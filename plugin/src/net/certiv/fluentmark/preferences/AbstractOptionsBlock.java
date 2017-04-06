package net.certiv.fluentmark.preferences;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;

import net.certiv.fluentmark.preferences.pages.PrefPageConvert;

public abstract class AbstractOptionsBlock {

	private static final List<FieldEditor> actives = new ArrayList<>();

	private PrefPageConvert page;
	private Composite comp;
	private boolean visible;

	public AbstractOptionsBlock(PrefPageConvert page, Composite parent, String title) {
		this.page = page;
		this.comp = SwtUtil.makeGroupComposite(parent, 3, 3, title);

		createControls(comp);
	}

	public PrefPageConvert getPage() {
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

	protected boolean checkPathname(String pathname, String target) {
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

	protected void addField(FieldEditor ed) {
		actives.add(ed);
		getPage().addField(ed);
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
