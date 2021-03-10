package net.certiv.fluent.dt.ui.vis.ws;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.WebSocketAdapter;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import net.certiv.common.log.Log;
import net.certiv.common.util.Strings;

/** Responsible for parsing received data. */
public class MsgHandler extends WebSocketAdapter {

	private static final String ErrSyntax = "WS envelope syntax error: %s";
	private static final String WarnRcv = "WS received message %s (%s).";

	private static final String AuthRcv = "WS auth: '%s' at %s";
	private static final String ReAuthRcv = "WS re-auth: '%s' -> '%s' at %s";
	private static final String HeloRcv = "WS hello: '%s' says '%s'";

	private static final String UpdateRcv = "WS update: '%s' at %s";

	private final Gson gson = new Gson();

	private LiveServer srvr;

	/** Created by {@link LiveServer$LiveServlet}. */
	public MsgHandler() {
		super();
	}

	public void initialize(LiveServer srvr) {
		this.srvr = srvr;
	}

	@Override
	public void onWebSocketConnect(Session session) {
		super.onWebSocketConnect(session);
		Log.debug(this, "WS connect: %s <-> %s", session.getLocalAddress(), session.getRemoteAddress());
		srvr.connect(session);
	}

	@Override
	public void onWebSocketText(String msg) {
		Log.debug(this, "WS message: " + msg);
		MsgEnvl envl;
		try {
			envl = gson.fromJson(msg, MsgEnvl.class);
			if (envl == null) {
				Log.warn(this, WarnRcv, "envelope is empty.", "null");
				return;
			}
		} catch (JsonSyntaxException e) {
			Log.error(this, ErrSyntax, e.getMessage());
			return;
		}

		Session session = getSession();
		if (chkSession(session, envl)) {
			switch (envl.request) {
				case MsgEnvl.AUTH:
					String target = srvr.getTarget(session);
					if (target == null) {
						Log.error(this, AuthRcv, envl.target, session.getRemoteAddress());

					} else if (!target.equals(envl.target)) {
						Log.info(this, ReAuthRcv, target, envl.target, session.getRemoteAddress());
					}
					srvr.send(MsgEnvl.ack(envl));
					break;

				case MsgEnvl.HELO:
					Log.info(this, HeloRcv, envl.target, envl.msg.content);
					srvr.send(MsgEnvl.ack(envl));
					break;

				case MsgEnvl.REFRESH:
					Log.warn(this, WarnRcv, "request not yet implemented", envl.request);
					srvr.send(MsgEnvl.ack(envl));
					srvr.handleUpdateRequest(envl);
					break;

				case MsgEnvl.UPDATE:
					Log.info(this, UpdateRcv, envl.target, session.getRemoteAddress());
					srvr.handleUpdateRequest(envl);
					break;

				default:
					Log.warn(this, WarnRcv, "has unknown request code", envl.request);
					srvr.send(MsgEnvl.nack(envl, "Unknown request"));
					// getSession().close(404, "Unknown request");
			}
		}
	}

	private boolean chkSession(Session session, MsgEnvl envl) {
		if (envl.request != MsgEnvl.AUTH) {
			return srvr.isClientConnected(session);
		}

		if (Strings.empty(envl.target)) {
			session.close(401, "Invalid target.");

		} else if (!srvr.isKnownClient(envl.target)) {
			session.close(401, "Unknown target.");

		} else {
			return true;
		}
		return false;
	}

	@Override
	public void onWebSocketClose(int statusCode, String reason) {
		Log.debug(this, "WS disconnect: code=%s reason=%s", statusCode, reason);
		srvr.disconnect(getSession());
		super.onWebSocketClose(statusCode, reason);
	}

	@Override
	public void onWebSocketBinary(byte[] payload, int offset, int len) {
		Log.warn(this, "WS binary received");
	}

	@Override
	public void onWebSocketError(Throwable cause) {
		Log.error(this, "WS error: %s", cause.getMessage());
	}
}
