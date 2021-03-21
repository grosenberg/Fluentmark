package net.certiv.fluent.dt.vis.server;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jetty.websocket.api.Session;

import net.certiv.fluent.dt.ui.editor.FluentEditor;

public class SessionMap {

	private class Entry {

		private Session session;		// ws session ident
		private String target;			// ws callback ident

		@SuppressWarnings("unused") private FluentEditor editor;	// original content source
		@SuppressWarnings("unused") private File base;				// page content source

		public Entry(FluentEditor editor, String target, File base) {
			this.editor = editor;
			this.target = target;
			this.base = base;
		}
	}

	// key=session; value=editor input filename
	private final Map<Object, Entry> sessions = new HashMap<>();

	public void createEntry(String target, FluentEditor editor, File base) {
		Entry entry = new Entry(editor, target, base);
		Entry prior = sessions.get(target);
		if (prior != null) {
			sessions.remove(prior.session);
			sessions.remove(prior.target);
		}
		sessions.put(target, entry);
	}

	public boolean isConnected(Session session) {
		if (!sessions.containsKey(session)) return false;
		return session.isOpen();
	}

	public boolean isConnected(String target) {
		if (sessions.containsKey(target)) {
			Entry entry = sessions.get(target);
			return entry.session != null && entry.session.isOpen();
		}
		return false;
	}

	public String get(Session session) {
		Entry entry = sessions.get(session);
		if (entry == null) return null;
		return entry.target;
	}

	public Session get(String target) {
		Entry entry = sessions.get(target);
		if (entry == null) return null;
		return entry.session;
	}

	public boolean put(Session session, String target) {
		Entry entry = sessions.get(target);
		if (entry == null) return false;
		entry.session = session;
		sessions.put(session, entry);
		return true;
	}

	public void remove(Session session) {
		if (sessions.containsKey(session)) {
			Entry entry = sessions.get(session);
			sessions.remove(entry.session);
			sessions.remove(entry.target);
		}
	}

	public void remove(String target) {
		if (sessions.containsKey(target)) {
			Entry entry = sessions.get(target);
			sessions.remove(entry.session);
			sessions.remove(entry.target);
		}
	}
}
