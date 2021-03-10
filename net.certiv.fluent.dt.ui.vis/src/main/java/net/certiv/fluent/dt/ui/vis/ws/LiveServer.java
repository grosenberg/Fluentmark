package net.certiv.fluent.dt.ui.vis.ws;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.resource.PathResource;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.servlet.ServletUpgradeRequest;
import org.eclipse.jetty.websocket.servlet.ServletUpgradeResponse;
import org.eclipse.jetty.websocket.servlet.WebSocketCreator;
import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;

import com.google.gson.Gson;

import net.certiv.common.log.Log;
import net.certiv.common.util.Strings;
import net.certiv.dsl.core.preferences.PrefsManager;
import net.certiv.dsl.core.util.CoreUtil;
import net.certiv.fluent.dt.core.preferences.Prefs;
import net.certiv.fluent.dt.ui.editor.FluentEditor;
import net.certiv.fluent.dt.ui.vis.FluentVis;
import net.certiv.fluent.dt.ui.vis.convert.HtmlGen;
import net.certiv.fluent.dt.ui.vis.convert.Kind;

public class LiveServer {

	// public static final String HOST = "127.0.0.1";
	// public static final int PORT = 9024;
	// public static final String PATH = "/vis";
	// private static final String UIBasePath = "/app";

	private static final String ErrBasePath = "UI server: invalid base path '%s' (%s).";

	private static final String ErrServer = "UI server failure: %s";
	private static final String WarnServer = "UI server already running.";
	private static final String InfoServer = "UI server '%s:%s%s'";

	private static final String ErrMsgSend = "WS send message failed: %s";
	// private static final String WarnUpdType = "UI update: type '%s' is unknown.";

	// key = session; value=editor input filename
	private final Map<String, Session> sessions = new HashMap<>();
	private final Gson gson = new Gson();

	private Server server;

	public LiveServer() {
		super();
	}

	/** Returns the Jetty server. */
	public Server server() {
		return server;
	}

	public void start() {
		if (server != null) {
			if (server.isRunning()) {
				Log.warn(this, WarnServer);
				return;
			}
			stop();
		}

		PrefsManager mgr = FluentVis.getDefault().getPrefsManager();
		String host = mgr.getString(Prefs.VIEW_SRVR_NAME);
		int port = mgr.getInt(Prefs.VIEW_SRVR_PORT);
		String path = mgr.getString(Prefs.VIEW_WS_PATH);

		// base dir => static web resources container
		String base = mgr.getString(Prefs.VIEW_CLNT_APPL);

		Path basePath = null;
		try {
			basePath = new File(base).toPath().toRealPath();
		} catch (Exception e) {
			Log.error(this, ErrBasePath, base, e.getMessage());
			return;
		}

		try {
			server = new Server();
			server.setStopAtShutdown(true);

			ServerConnector conn = new ServerConnector(server);
			conn.setHost(host);
			conn.setPort(port);
			server.addConnector(conn);

			ServletContextHandler ctx = new ServletContextHandler(ServletContextHandler.SESSIONS);
			ctx.setContextPath(Strings.SLASH);
			if (basePath != null) ctx.setBaseResource(new PathResource(basePath));
			server.setHandler(ctx);

			ctx.addServlet(new ServletHolder(new LiveServlet(this)), path);

			server.start();
			Log.info(this, InfoServer, host, port, path);
			Log.info(this, "WS server dump: %s", server.dumpSelf());

		} catch (Exception e) {
			stop();
			Log.error(this, e, ErrServer, e.getMessage());
			throw new RuntimeException(e);
		}
	}

	public final void stop() {
		if (server != null && server.isRunning()) {
			try {
				server.stop();
			} catch (Exception e) {
				Log.error(this, ErrServer, e.getMessage());
			}
			server = null;
		}
	}

	public boolean isRunning() {
		return server.isRunning();
	}

	/** Call back on initial session connection. */
	public void connect(Session session) {
		IEditorPart ed = CoreUtil.getActiveEditor();
		if (ed instanceof FluentEditor) {
			FluentEditor editor = (FluentEditor) ed;
			String target = editor.getEditorInput().getName();
			Session old = sessions.get(target);
			if (old != null) {
				Log.warn(this, "Reconnected '%s' by %s", target, session.getRemoteAddress());
			}
			sessions.put(target, session);
			Log.debug(this, "Connected '%s' by %s", target, session.getRemoteAddress());
		}
	}

	public void disconnect(Session session) {}

	public String getTarget(Session session) {
		return null;
	}

	public boolean isKnownClient(String target) {
		return false;
	}

	public boolean isClientConnected(Session session) {
		return false;
	}

	public boolean isClientConnected(String target) {
		if (sessions.containsKey(target)) {
			Session session = sessions.get(target);
			return session.isOpen();
		}
		return false;
	}

	public void send(int request, Message msg) {
		send(MsgEnvl.request(request, msg));
	}

	public void send(MsgEnvl envl) {
		if (server.isRunning() && isClientConnected(envl.target)) {
			Session session = sessions.get(envl.target);
			try {
				session.getRemote().sendString(gson.toJson(envl));
			} catch (Exception ex) {
				Log.error(this, ErrMsgSend, ex.getMessage());
			}
		}
	}

	/**
	 * Handle a received refresh/update request, per the given message requirements.
	 * Collect and send the data requested to the message user.
	 */
	void handleUpdateRequest(MsgEnvl envl) {
		for (IEditorReference ref : CoreUtil.getActivePage().getEditorReferences()) {
			if (FluentEditor.EDITOR_ID.equals(ref.getId()) && envl.target.equals(ref.getName())) {
				FluentEditor editor = (FluentEditor) ref.getEditor(false);
				if (editor != null) {
					HtmlGen gen = new HtmlGen(editor, FluentVis.getDefault().getConverter());
					String content = gen.getHtml(Kind.UPDATE);
					MsgEnvl me = MsgEnvl.request(MsgEnvl.UPDATE, Message.reply(envl.msg, content));
					send(me);
				}
				break;
			}
		}
	}

	private class LiveServlet extends WebSocketServlet {

		private LiveServer srv;

		public LiveServlet(LiveServer srv) {
			this.srv = srv;
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
					Object webSocket = creator.createWebSocket(req, resp);
					if (webSocket instanceof MsgHandler) {
						((MsgHandler) webSocket).initialize(srv);
					}
					return webSocket;
				}
			});
		}
	}
}
