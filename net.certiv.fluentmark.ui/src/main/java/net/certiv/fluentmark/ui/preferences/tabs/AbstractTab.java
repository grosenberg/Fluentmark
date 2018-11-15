package net.certiv.fluentmark.ui.preferences.tabs;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;

import net.certiv.dsl.ui.preferences.pages.AbstractFieldEditorPreferencePage;
import net.certiv.dsl.ui.preferences.pages.IDslPreferencePage;
import net.certiv.dsl.ui.util.SWTFactory;

public abstract class AbstractTab {

	private static final List<FieldEditor> actives = new ArrayList<>();

	private IDslPreferencePage page;
	private Composite comp;
	private boolean visible;

	public AbstractTab(IDslPreferencePage page, Composite parent, String title) {
		this.page = page;
		this.comp = SWTFactory.createGroupComposite(parent, 3, 3, title);

		createControls(comp);
	}

	public IDslPreferencePage getPage() {
		return page;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
		Group frame = (Group) comp.getParent();
		frame.setVisible(visible);
	}

	protected abstract void createControls(Composite comp);

	public abstract boolean validateSettings();

	protected boolean checkPathExe(String pathname, String target) {
		if (pathname.trim().isEmpty()) {
			page.setMessage("Missing pathname of " + target + " executable", IMessageProvider.ERROR);
			return false;
		}
		File file = new File(pathname);
		if (target != null) {
			if (!isValidExecutable(file.getPath(), target)) {
				page.setMessage("Invalid name of " + target + " executable", IMessageProvider.ERROR);
				return false;
			}
		}
		if (!file.isFile()) {
			page.setMessage("Invalid pathname of " + target + " executable", IMessageProvider.ERROR);
			return false;
		}
		return true;
	}

	private boolean isValidExecutable(String path, String name) {
		if (path == null || path.isEmpty()) return false;
		File file = new File(path);
		if (!(file.getName().equals(name) || file.getName().equals(name + ".exe"))) { //$NON-NLS-1$
			return false;
		}
		return file.isFile();
	}

	protected boolean checkPathDir(String pathname, boolean emptyAllowed) {
		Path path = new Path(pathname);
		if (path.isEmpty()) {
			if (emptyAllowed) return true;
			page.setMessage("Missing directory path", IMessageProvider.ERROR);
			return false;
		}
		if (!path.toFile().isDirectory()) {
			page.setMessage("Invalid directory path", IMessageProvider.ERROR);
			return false;
		}
		return true;
	}

	protected void addField(FieldEditor ed) {
		actives.add(ed);
		((AbstractFieldEditorPreferencePage) page).addField(ed);
	}

	public Control getFrame() {
		return comp.getParent();
	}

	public Composite getBase() {
		return comp;
	}

	public void dispose() {
		for (FieldEditor ed : actives) {
			ed.setPage(null);
			ed.setPropertyChangeListener(null);
			ed.setPreferenceStore(null);
		}

		actives.clear();
		comp.getParent().dispose();
		comp = null;
		page = null;
	}
}
