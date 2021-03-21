package net.certiv.fluent.dt.vis.server;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.servlet.ServletUpgradeRequest;
import org.eclipse.jetty.websocket.servlet.ServletUpgradeResponse;
import org.eclipse.jetty.websocket.servlet.WebSocketCreator;
import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextListener;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.TextEvent;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.texteditor.IDocumentProvider;

import com.google.gson.Gson;

import net.certiv.common.log.Log;
import net.certiv.common.stores.Holder;
import net.certiv.common.util.Strings;
import net.certiv.common.util.Time;
import net.certiv.dsl.core.model.ICodeUnit;
import net.certiv.dsl.core.preferences.PrefsManager;
import net.certiv.dsl.core.util.CoreUtil;
import net.certiv.dsl.core.util.eclipse.PartAdaptor;
import net.certiv.fluent.dt.core.FluentCore;
import net.certiv.fluent.dt.core.preferences.Prefs;
import net.certiv.fluent.dt.ui.editor.FluentEditor;
import net.certiv.fluent.dt.vis.FluentVis;
import net.certiv.fluent.dt.vis.convert.HtmlGen;
import net.certiv.fluent.dt.vis.convert.Kind;
import net.certiv.fluent.dt.vis.util.LiveUtil;

public class LiveServer {

	private static final String[] Properties = { //
			Prefs.EDITOR_PREVIEW_FILE, //
			Prefs.EDITOR_PREVIEW_EXTERNAL_ENABLE, //
			Prefs.EDITOR_PREVIEW_EXTERNAL_DIR //
	};

	private static final String ErrBase = "Client server: invalid static resource path '%s'.";

	private static final String ErrServer = "Liveserver failure: %s";
	private static final String WarnServer = "Liveserver already running.";
	private static final String InfoServer = "Liveserver '%s:%s/%s'";

	private static final String ErrMsgSend = "WS send message failed: %s";

	private final SessionMap sessions = new SessionMap();
	private final Gson gson = new Gson();
	private final Monitor monitor = new Monitor();

	private PrefsManager mgr;
	private Server srvr;
	private File resBase;

	public LiveServer() {
		super();
	}

	public void start() {
		if (srvr != null) {
			if (srvr.isRunning()) {
				Log.warn(this, WarnServer);
				return;
			}
			stop();
		}

		mgr = FluentVis.getDefault().getPrefsManager();
		String host = mgr.getString(Prefs.VIEW_HOST_NAME);
		int port = mgr.getInt(Prefs.VIEW_HOST_PORT);
		String context = mgr.getString(Prefs.VIEW_WS_CONTEXT);

		try {
			srvr = new Server();
			srvr.setStopAtShutdown(true);

			ServerConnector conn = new ServerConnector(srvr);
			conn.setHost(host);
			conn.setPort(port);
			srvr.addConnector(conn);

			resBase = LiveUtil.extractClient();
			if (resBase == null || !resBase.isDirectory()) {
				Log.error(this, ErrBase, resBase);
				return;
			}

			// ---- serve websocket sessions on "/liveview"

			ServletContextHandler ctx = new ServletContextHandler(
					ServletContextHandler.SESSIONS | ServletContextHandler.NO_SECURITY);
			ctx.addServlet(new ServletHolder(new LiveServlet(this)), Strings.SLASH + context);

			// ---- serve static files from "<tmp>/liveview/app..." to "/"

			ctx.setResourceBase(resBase.getPath());
			ctx.setContextPath(Strings.SLASH);
			ctx.addServlet(DefaultServlet.class, Strings.SLASH);

			// ----

			srvr.setHandler(ctx);
			srvr.start();
			Log.info(this, InfoServer, host, port, context);

			// begin listening for update triggers
			mgr.addPropertyChangeListener(monitor);
			CoreUtil.getActivePage().addPartListener(monitor);

		} catch (Exception e) {
			stop();
			Log.error(this, e, ErrServer, e.getMessage());
			throw new RuntimeException(e);
		}
	}

	public final void stop() {
		if (srvr != null) {
			// stop listening for update triggers
			mgr.removePropertyChangeListener(monitor);
			IWorkbenchPage page = CoreUtil.getActivePage();
			if (page != null) page.removePartListener(monitor);
			try {
				srvr.stop();
			} catch (Exception e) {
				Log.error(this, ErrServer, e.getMessage());
			}
			srvr = null;
			resBase = null;
		}
	}

	public boolean isRunning() {
		if (srvr == null) return false;
		return srvr.isRunning();
	}

	public boolean isStopped() {
		if (srvr == null) return true;
		return srvr.isStopped();
	}

	public File getResourceBase() {
		return resBase;
	}

	public void createSessionEntry(String target, FluentEditor editor, File base) {
		sessions.createEntry(target, editor, base);
	}

	public boolean isConnected(Session session) {
		return sessions.isConnected(session);
	}

	public boolean isConnected(String target) {
		return sessions.isConnected(target);
	}

	public String getTarget(Session session) {
		return sessions.get(session);
	}

	/** Called on initial session connection. */
	public void connect(Session session) {
		IEditorPart ed = CoreUtil.getActiveEditor();
		if (ed instanceof FluentEditor) {
			FluentEditor editor = (FluentEditor) ed;
			String target = editor.getInputDslElement().getPackageName();
			if (sessions.put(session, target)) {
				monitor.beginTracking(editor);
				Time.sleep(mgr.getInt(Prefs.VIEW_UPDATE_DELAY) / 1000);
				update(editor);
				Log.debug(this, "Connect '%s' -> %s", target, session.getRemoteAddress());

			} else {
				Log.error(this, "Bad connect '%s' -> %s", target, session.getRemoteAddress());
			}
		}
	}

	public void disconnect(Session session) {
		Log.debug(this, "Disconnected %s", session.getRemoteAddress());
		sessions.remove(session);
	}

	/**
	 * Respond to a client-originated refresh request, identified by the envelope
	 * target, by sending an update message to refresh the content.
	 */
	public void update(MsgEnvl envl) {
		for (IEditorReference ref : CoreUtil.getActivePage().getEditorReferences()) {
			if (FluentEditor.EDITOR_ID.equals(ref.getId())) {
				FluentEditor editor = (FluentEditor) ref.getEditor(false);
				if (editor != null) {
					String pkgname = editor.getInputDslElement().getPackageName();
					if (envl.target.equals(pkgname)) {
						update(editor);
						break;
					}
				}
			}
		}
	}

	/**
	 * Send an update message to the client to refresh the content. Called on
	 * <ul>
	 * <li>initial connection with a new client corresponding to the given editor
	 * <li>any text change in the given editor
	 * <li>a refresh request received from the client for the given editor
	 * </ul>
	 *
	 * @param editor
	 */
	public void update(FluentEditor editor) {
		if (srvr == null) return;
		try {
			IDocumentProvider provider = editor.getDocumentProvider();
			IDocument doc = provider.getDocument(editor.getEditorInput());

			Holder<Integer> line = new Holder<>(-1);
			Holder<Integer> total = new Holder<>(-1);
			Display.getDefault().syncExec(() -> {
				try {
					IWorkbenchPartSite site = editor.getSite();
					ISelectionProvider selprovider = site.getSelectionProvider();
					ITextSelection sel = (ITextSelection) selprovider.getSelection();
					line.value = doc.getLineOfOffset(sel.getOffset());
					total.value = doc.getNumberOfLines();
				} catch (BadLocationException e) {
					Log.warn(this, "Failed to determine line number of change: %s", e.getMessage());
				}
			});

			ICodeUnit unit = editor.getInputDslElement().getCodeUnit();
			String target = unit.getPackageName();
			if (sessions.isConnected(target)) {
				HtmlGen gen = new HtmlGen(editor, FluentVis.getDefault().getConverter());
				String content = gen.getHtml(Kind.UPDATE);

				File loc = unit.getResource().getParent().getLocation().toFile();
				LiveUtil.rebaseImages(content, loc, resBase);

				Message msg = Message.request(target, content, line.value, total.value);
				send(MsgEnvl.UPDATE, msg);

			} else {
				monitor.endTracking(editor); // web page was closed
			}

		} catch (Exception e) {
			Log.error(this, "Content update failed: %s", e.getMessage());
		}
	}

	public void send(int request, Message msg) {
		send(MsgEnvl.request(request, msg));
	}

	public void send(MsgEnvl envl) {
		if (srvr.isRunning()) {
			try {
				sessions.get(envl.target).getRemote().sendString(gson.toJson(envl));
			} catch (Exception ex) {
				Log.error(this, ErrMsgSend, ex.getMessage());
			}
		}
	}

	/** used to interpose the {@link MsgHandler} */
	private class LiveServlet extends WebSocketServlet {

		private LiveServer srvr;

		public LiveServlet(LiveServer srvr) {
			this.srvr = srvr;
		}

		@Override
		public void configure(WebSocketServletFactory factory) {
			factory.register(MsgHandler.class);

			// default creator
			final WebSocketCreator creator = factory.getCreator();
			// specialized creator
			factory.setCreator(new WebSocketCreator() {

				@Override
				public Object createWebSocket(ServletUpgradeRequest req, ServletUpgradeResponse resp) {
					Object ws = creator.createWebSocket(req, resp);
					if (ws instanceof MsgHandler) {
						((MsgHandler) ws).initialize(srvr);
					}
					return ws;
				}
			});
		}
	}

	class Monitor implements PartAdaptor, IPropertyChangeListener {

		private final Map<FluentEditor, Trigger> triggers = new HashMap<>();

		public void beginTracking(FluentEditor editor) {
			Trigger trigger = triggers.get(editor);
			if (trigger == null) {
				trigger = new Trigger(editor);
				triggers.put(editor, trigger);
			}
			editor.getViewer().addTextListener(trigger);
			Log.debug(this, "Tracking %s", editor.getEditorInput().getName());
		}

		public void endTracking(FluentEditor editor) {
			Trigger trigger = triggers.get(editor);
			if (trigger != null) {
				editor.getViewer().removeTextListener(trigger);
				triggers.remove(editor);
				Log.debug(this, "Untracking %s", editor.getEditorInput().getName());
			}
		}

		@Override
		public void partClosed(IWorkbenchPart part) { // closed
			if (srvr != null && part instanceof FluentEditor) {
				FluentEditor editor = (FluentEditor) part;
				endTracking(editor);
			}
		}

		@Override
		public void propertyChange(PropertyChangeEvent evt) { // on property store change
			if (srvr != null) {
				PrefsManager mgr = FluentCore.getDefault().getPrefsManager();
				if (mgr.keyMatch(evt.getProperty(), Properties)) {
					// updateAll();
					Log.debug(this, "Property change %s", evt.getProperty());
				}
			}
		}
	}

	// See net.certiv.antlr.dt.vis.parse.TargetBuilder for keystroke run length
	// limiter
	class Trigger implements ITextListener {

		private FluentEditor editor;

		public Trigger(FluentEditor editor) {
			this.editor = editor;
		}

		@Override
		public void textChanged(TextEvent evt) { // on editor content change
			Log.debug(this, "Text change on %s", editor.getEditorInput().getName());
			update(editor);
		}
	}
}
