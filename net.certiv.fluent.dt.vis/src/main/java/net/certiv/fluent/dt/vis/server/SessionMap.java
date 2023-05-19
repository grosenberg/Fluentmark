package net.certiv.fluent.dt.vis.server;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jetty.websocket.api.Session;

import net.certiv.common.log.Log;
import net.certiv.fluent.dt.ui.editor.FluentEditor;

public class SessionMap {

	private class Entry {

		private Session session;		// ws session ident
		private String target;			// ws callback ident

		@SuppressWarnings("unused")
		private FluentEditor editor;	// original content source
		@SuppressWarnings("unused")
		private File base;				// page content source

		public Entry(FluentEditor editor, String target, File base) {
			this.editor = editor;
			this.target = target;
			this.base = base;
		}
	}

	// key=[session|target]; value=session entry
	private final Map<Object, Entry> sessions = new HashMap<>();

	/**
	 * Called on initial construction of the client.
	 * <p>
	 * If a mapping to {@code target} exists, a valid client has been defined. If the
	 * corresponding {@code Entry} contains a non-null session, a corresponding session
	 * mapping should exist, marking the session/entry as connected.
	 */
	public void createEntry(String target, FluentEditor editor, File base) {
		Entry entry = new Entry(editor, target, base);
		Entry prior = sessions.get(target);
		if (prior != null) {
			sessions.remove(prior.session);
			sessions.remove(prior.target);
		}
		sessions.put(target, entry);
		Log.debug("Created entry: %s", target);
	}

	public boolean isConnected(Session session) {
		return sessions.containsKey(session) && session.isOpen();
	}

	public boolean isConnected(String target) {
		Entry entry = sessions.get(target);
		return entry != null && isConnected(entry.session);
	}

	public boolean has(Session session) {
		return sessions.get(session) != null;
	}

	public Entry getConnected(Session session) {
		return sessions.get(session);
	}

	public String getConnectedTarget(Session session) {
		Entry entry = sessions.get(session);
		return entry != null ? entry.target : null;
	}

	public Session getActiveSession(String target) {
		Entry entry = sessions.get(target);
		return entry != null ? entry.session : null;
	}

	/** Called on websocket connect/open message. */
	public boolean reconnect(Session session, String target) {
		Entry entry = sessions.get(target);
		if (entry == null) return false;

		if (entry.session != null) sessions.remove(entry.session);
		entry.session = session;
		sessions.put(session, entry);
		return true;
	}

	/** Called on websocket disconnect/close message. */
	public void disconnect(Session session) {
		if (sessions.containsKey(session)) {
			Entry entry = sessions.get(session);
			sessions.remove(entry.session);
			sessions.remove(entry.target);
		}
	}

	public void terminate(String target) {
		if (sessions.containsKey(target)) {
			Entry entry = sessions.get(target);
			sessions.remove(entry.session);
			sessions.remove(entry.target);
		}
	}
}
