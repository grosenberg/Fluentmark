package net.certiv.fluent.dt.vis.server;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jetty.websocket.api.Session;

public class SessionMap {

	private class M {
		private Session session;
		private String target;

		public M(Session session, String target) {
			this.session = session;
			this.target = target;
		}
	}

	// key=session; value=editor input filename
	private final Map<Object, M> sessions = new HashMap<>();

	public boolean isConnected(Session session) {
		if (sessions.containsKey(session)) {
			return session.isOpen();
		}
		return false;
	}

	public boolean isConnected(String target) {
		if (sessions.containsKey(target)) {
			M m = sessions.get(target);
			return m.session.isOpen();
		}
		return false;
	}

	public String get(Session session) {
		M m = sessions.get(session);
		if (m == null) return null;
		return m.target;
	}

	public Session get(String target) {
		M m = sessions.get(target);
		if (m == null) return null;
		return m.session;
	}

	public boolean put(Session session, String target) {
		M m = new M(session, target);
		boolean err = sessions.put(session, m) != null;
		err |= sessions.put(target, m) != null;
		return err;
	}

	public void remove(Session session) {
		if (sessions.containsKey(session)) {
			M m = sessions.get(session);
			sessions.remove(m.session);
			sessions.remove(m.target);
		}
	}

	public void remove(String target) {
		if (sessions.containsKey(target)) {
			M m = sessions.get(target);
			sessions.remove(m.session);
			sessions.remove(m.target);
		}
	}

}
