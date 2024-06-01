package net.certiv.fluent.dt.vis.server;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.WebSocketAdapter;

import net.certiv.common.ex.JsonException;
import net.certiv.common.log.Level;
import net.certiv.common.log.Log;
import net.certiv.common.util.Strings;
import net.certiv.fluent.dt.vis.FluentVis;

/** Responsible for parsing received data. */
public class MsgHandler extends WebSocketAdapter {

	private static final String ErrSyntax = "WS envelope syntax error: %s";
	private static final String WarnRcv = "WS received message %s (%s).";

	private static final String AuthRcv = "WS auth: '%s' at %s";
	private static final String ReAuthRcv = "WS re-auth: '%s' -> '%s' at %s";
	private static final String HeloRcv = "WS hello: '%s' says '%s'";

	private static final String RefreshRcv = "WS %s: '%s' at %s";
	private static final String UpdateRcv = "WS %s: '%s' at %s";
	private static final String HBRcv = "WS heartbeat %s";

	private LiveServer srvr;

	/** Created by {@link LiveServer$LiveServlet}. */
	public MsgHandler() {
		super();
		Log.setLevel(Level.DEBUG);
	}

	public void initialize(LiveServer srvr) {
		this.srvr = srvr;
	}

	/**
	 * Inbound websocket connection established.
	 *
	 * @param session the connection defining session
	 */
	@Override
	public void onWebSocketConnect(Session session) {
		super.onWebSocketConnect(session);
		if (srvr == null) {
			FluentVis vis = FluentVis.getDefault();
			srvr = vis.getLiveServer();
			Log.debug("Websocket connected: initialized message handler.");
		}
		srvr.connect(session);
	}

	/**
	 * Inbound message processor.
	 *
	 * <pre>
	 * on client sent [AUTH] -> server sends [ACK]
	 * on client sent [HELO] -> server sends [ACK]
	 * on client sent [REFRESH] -> server sends [ACK] then sends [UPDATE]
	 * on client sent [UPDATE] -> server sends [UPDATE]
	 * on client sent [HEARTBEAT] -> server logs event
	 * </pre>
	 *
	 * @param txt text representing a received message
	 */
	@Override
	public void onWebSocketText(String txt) {
		MsgEnvl envl;
		try {
			envl = LiveServer.JSU.fromJson(txt, MsgEnvl.class);
			if (envl == null) {
				Log.warn(WarnRcv, "envelope is empty.", "null");
				return;
			}
		} catch (JsonException e) {
			Log.error(ErrSyntax, e.getMessage());
			return;
		}

		Session session = getSession();
		if (chkSession(session, envl)) {
			String name = MsgEnvl.name(envl.request);
			switch (envl.request) {
				case MsgEnvl.AUTH:
					String target = srvr.getTarget(session);
					if (target == null) {
						Log.error(AuthRcv, envl.target, session.getRemoteAddress());

					} else if (!target.equals(envl.target)) {
						Log.info(ReAuthRcv, target, envl.target, session.getRemoteAddress());
					}
					srvr.send(MsgEnvl.ack(envl));
					break;

				case MsgEnvl.HELO:
					Log.info(HeloRcv, envl.target, envl.msg.content);
					srvr.send(MsgEnvl.ack(envl));
					break;

				case MsgEnvl.REFRESH:
					Log.info(RefreshRcv, name, envl.target, session.getRemoteAddress());
					srvr.send(MsgEnvl.ack(envl));
					srvr.update(envl);
					break;

				case MsgEnvl.UPDATE:
					Log.info(UpdateRcv, name, envl.target, session.getRemoteAddress());
					srvr.update(envl);
					break;

				case MsgEnvl.HEARTBEAT:
					Log.info(HBRcv, session.getRemoteAddress());
					break;

				default:
					Log.warn(WarnRcv, "has unknown request code", envl.request);
					srvr.send(MsgEnvl.nack(envl, "Unknown request"));
			}
		}
	}

	private boolean chkSession(Session session, MsgEnvl envl) {
		if (envl.request != MsgEnvl.AUTH) {
			boolean ok = srvr.isConnected(session);
			if (!ok) {
				onWebSocketConnect(session);
			}
			return srvr.isConnected(session);
		}

		if (Strings.empty(envl.target)) {
			session.close(401, "Invalid target.");

		} else if (!srvr.isConnected(envl.target)) {
			session.close(401, "Unknown target.");

		} else {
			return true;
		}
		return false;
	}

	@Override
	public void onWebSocketClose(int statusCode, String reason) {
		Log.debug("WS disconnect: code=%s reason=%s", statusCode, reason);
		srvr.disconnect(getSession());
		super.onWebSocketClose(statusCode, reason);
	}

	@Override
	public void onWebSocketBinary(byte[] payload, int offset, int len) {
		Log.warn("WS binary received");
	}

	@Override
	public void onWebSocketError(Throwable cause) {
		String msg = cause.getMessage();
		if (!msg.equals("Connection Idle Timeout")) {
			Log.error(cause, "WS error: %s", msg);
		}
	}
}
