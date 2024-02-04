package net.certiv.fluent.dt.vis.server;

import java.io.File;
import java.nio.file.Path;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.resource.PathResource;
import org.eclipse.jetty.websocket.api.RemoteEndpoint;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.server.JettyWebSocketServlet;
import org.eclipse.jetty.websocket.server.JettyWebSocketServletFactory;
import org.eclipse.jetty.websocket.server.config.JettyWebSocketServletContainerInitializer;
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

import jakarta.servlet.Servlet;
import net.certiv.common.log.Level;
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
	private Server server;
	private File resbase;

	public LiveServer() {
		Log.setLevel(Level.DEBUG);
	}

	public void start() {
		if (server != null) {
			if (server.isRunning()) {
				Log.warn(WarnServer);
				return;
			}
			stop();
		}

		mgr = FluentVis.getDefault().getPrefsManager();
		String host = mgr.getString(Prefs.VIEW_HOST_NAME);
		int port = mgr.getInt(Prefs.VIEW_HOST_PORT);
		String wspath = mgr.getString(Prefs.VIEW_WS_CONTEXT);
		wspath = wspath.startsWith(Strings.SLASH) ? wspath : Strings.SLASH + wspath;

		resbase = LiveUtil.extractClient(mgr);
		if (resbase != null && resbase.isDirectory()) {
			start(host, port, resbase.toPath(), wspath);

		} else {
			Log.error(ErrBase, resbase);
		}
	}

	/**
	 * Start a server with the given parameters.
	 * <p>
	 * The {@code basepath} is typically set to {@code "/app"}; default is {@code blank}.
	 * <p>
	 * The {@code resBase} plus {@code wspath} gives the full path to a websocket
	 * resource.
	 *
	 * @param host    connection host name
	 * @param port    connection host port
	 * @param respath abs resource base path for connection resources
	 * @param wspath  relative path for connection resources
	 */
	private void start(String host, int port, Path respath, String wspath) {
		try {
			server = new Server();
			// server.setDumpAfterStart(true);
			server.setStopAtShutdown(true);

			ServerConnector conn = new ServerConnector(server);
			conn.setHost(host);
			conn.setPort(port);
			server.addConnector(conn);

			ContextHandlerCollection handlers = new ContextHandlerCollection();

			// ---- serve static files from "<tmp>/<ws_context>/app/*" to "/"

			ResourceHandler rhx = new ResourceHandler();
			rhx.setDirectoriesListed(false);
			rhx.setBaseResource(new PathResource(respath));

			ContextHandler chx = new ContextHandler(Strings.SLASH);
			chx.setHandler(rhx);
			chx.clearAliasChecks();
			chx.setAllowNullPathInfo(true);

			handlers.addHandler(chx);

			// ---- serve websocket sessions on "/<ws_context>"

			ServletContextHandler ctx = new ServletContextHandler(
					ServletContextHandler.SESSIONS | ServletContextHandler.NO_SECURITY);
			ctx.setLogger(new Slf4jBridge(getClass()));
			ctx.setContextPath(Strings.SLASH);

			Servlet servlet = createWsServlet(this);
			ctx.addServlet(new ServletHolder(servlet), wspath);
			JettyWebSocketServletContainerInitializer.configure(ctx, null);
			handlers.addHandler(ctx);

			// ----

			server.setHandler(handlers);
			server.start();

			Log.info(InfoServer, host, port, wspath);
			Log.info("WS server dump: %s", server.dumpSelf());

			// begin listening for update triggers
			mgr.addPropertyChangeListener(monitor);
			CoreUtil.getActivePage().addPartListener(monitor);

		} catch (Exception e) {
			stop();
			Log.error(e, ErrServer, e.getMessage());
			throw new RuntimeException(e);
		}
	}

	/** Initialize the {@link MsgHandler} */
	private Servlet createWsServlet(LiveServer server) {
		return new JettyWebSocketServlet() {

			@Override
			protected void configure(JettyWebSocketServletFactory factory) {
				factory.register(MsgHandler.class);
				factory.setIdleTimeout(Duration.ofSeconds(100));
				factory.setMaxTextMessageSize(65535);
			}
		};
	}

	public void stop() {
		if (server != null && server.isRunning()) {

			// stop listening for update triggers
			mgr.removePropertyChangeListener(monitor);
			IWorkbenchPage page = CoreUtil.getActivePage();
			if (page != null) page.removePartListener(monitor);

			try {
				server.stop();
			} catch (Exception e) {
				Log.error(ErrServer, e.getMessage());
			}

			resbase = null;
			server = null;
		}
	}

	public void createSessionEntry(String source, FluentEditor editor, File base) {
		sessions.createEntry(source, editor, base);
	}

	public File getResourceBase() {
		return resbase;
	}

	public boolean isRunning() {
		if (server == null) return false;
		return server.isRunning();
	}

	public boolean isStopped() {
		if (server == null) return true;
		return server.isStopped();
	}

	public boolean isConnected(Session session) {
		return sessions.isConnected(session);
	}

	public boolean isConnected(String target) {
		return sessions.isConnected(target);
	}

	public String getTarget(Session session) {
		return sessions.getConnectedTarget(session);
	}

	/** Called on initial session connection. */
	public void connect(Session session) {
		IEditorPart ed = CoreUtil.getActiveEditor();
		if (ed instanceof FluentEditor) {
			FluentEditor editor = (FluentEditor) ed;
			String target = editor.getInputDslElement().getPackageName();

			if (mgr.getBoolean(Prefs.VIEW_WS_DEBUG) && !sessions.has(session)) {
				createSessionEntry(target, editor, null);
				Log.debug("[DEBUG] Defined '%s' -> %s", target, session.getRemoteAddress());
			}

			if (sessions.reconnect(session, target)) {
				monitor.beginTracking(editor);
				Time.sleep(mgr.getInt(Prefs.VIEW_UPDATE_DELAY) / 1000);
				update(editor);
				Log.debug("Connect source '%s' -> %s", target, session.getRemoteAddress());

			} else {
				Log.error("Bad connect '%s' -> %s", target, session.getRemoteAddress());
			}
		}
	}

	public void disconnect(Session session) {
		String source = getTarget(session);
		sessions.disconnect(session);
		Log.debug("Disconnected %s -> %s", source != null ? source : "", session.getRemoteAddress());
	}

	/**
	 * Respond to a client-originated UPDATE or REFRESH message. Requires the
	 * corresponding editor, identified by the envelope target, to be open. Uses that
	 * editor to originate a responsive UPDATE message to update the client display
	 * content.
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
	private void update(FluentEditor editor) {
		if (server == null) return;
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
					Log.warn("Failed to determine line number of change: %s", e.getMessage());
				}
			});

			ICodeUnit unit = editor.getInputDslElement().getCodeUnit();
			String target = unit.getPackageName();
			if (sessions.isConnected(target)) {
				HtmlGen gen = new HtmlGen(editor, FluentVis.getDefault().getConverter(), line.value);
				String content = gen.getHtml(Kind.UPDATE);

				File loc = unit.getResource().getParent().getLocation().toFile();
				LiveUtil.rebaseImages(content, loc, resbase);

				Message msg = Message.request(target, content, line.value, total.value);
				send(MsgEnvl.UPDATE, msg);

			} else {
				monitor.endTracking(editor); // web page was closed
			}

		} catch (Exception e) {
			Log.error("Content update failed: %s", e.getMessage());
		}
	}

	public void send(int request, Message msg) {
		send(MsgEnvl.request(request, msg));
	}

	public void send(MsgEnvl envl) {
		if (server.isRunning()) {
			try {
				Session session = sessions.getActiveSession(envl.target);
				RemoteEndpoint remote = session.getRemote();
				remote.sendString(gson.toJson(envl));
			} catch (Exception ex) {
				Log.error(ErrMsgSend, ex.getMessage());
			}
		}
	}

	private class Monitor implements PartAdaptor, IPropertyChangeListener {

		private final Map<FluentEditor, Trigger> triggers = new HashMap<>();

		public void beginTracking(FluentEditor editor) {
			Trigger trigger = triggers.get(editor);
			if (trigger == null) {
				trigger = new Trigger(editor);
				triggers.put(editor, trigger);
			}
			editor.getViewer().addTextListener(trigger);
			Log.debug("Tracking %s", editor.getEditorInput().getName());
		}

		public void endTracking(FluentEditor editor) {
			Trigger trigger = triggers.get(editor);
			if (trigger != null) {
				editor.getViewer().removeTextListener(trigger);
				triggers.remove(editor);
				Log.debug("Untracking %s", editor.getEditorInput().getName());
			}
		}

		@Override
		public void partClosed(IWorkbenchPart part) { // closed
			if (server != null && part instanceof FluentEditor) {
				FluentEditor editor = (FluentEditor) part;
				endTracking(editor);
			}
		}

		@Override
		public void propertyChange(PropertyChangeEvent evt) { // on property store change
			if (server != null) {
				PrefsManager mgr = FluentCore.getDefault().getPrefsManager();
				if (mgr.keyMatch(evt.getProperty(), Properties)) {
					// updateAll();
					Log.debug("Property change %s", evt.getProperty());
				}
			}
		}
	}

	private class Trigger implements ITextListener {

		private final FluentEditor editor;
		private final String name;
		private final TriggerJob job;

		public Trigger(FluentEditor editor) {
			this.editor = editor;
			name = editor.getEditorInput().getName();
			job = new TriggerJob(name);
			job.setPriority(Job.DECORATE);
		}

		@Override
		public void textChanged(TextEvent event) {
			job.schedule();	// on editor content change
		}

		private class TriggerJob extends Job {

			public TriggerJob(String name) {
				super("TriggerJob - " + name);
			}

			@Override
			public IStatus run(IProgressMonitor monitor) {
				update(editor); // send UPDATE notifying of source change
				return Status.OK_STATUS;
			}
		}
	}
}
