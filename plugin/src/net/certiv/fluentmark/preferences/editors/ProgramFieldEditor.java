package net.certiv.fluentmark.preferences.editors;

import java.io.File;

import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.swt.widgets.Composite;

public class ProgramFieldEditor extends FileFieldEditor {

	private String[] msg;

	public ProgramFieldEditor(String key, String label, Composite parent, String[] msg) {
		super(key, label, true, FileFieldEditor.VALIDATE_ON_KEY_STROKE, parent);
		this.msg = msg;

		setErrorMessage(msg[0]);
		setEmptyStringAllowed(true);
		getTextControl().setToolTipText(msg[1]);
	}

	@Override
	public boolean isValid() {
		boolean ok = super.isValid();
		String value = getStringValue();
		if (!value.isEmpty()) {
			ok = ok && isValidExecutable(value, msg[2]);
		}
		return ok;
	}

	@Override
	protected void refreshValidState() {
		super.refreshValidState();
		if (!isValid()) {
			showErrorMessage(getErrorMessage());
		}
		checkState();
	}

	@Override
	public boolean doCheckState() {
		String currentValue = getStringValue();
		if (!currentValue.isEmpty()) {
			return isValidExecutable(currentValue, msg[2]);
		}
		return super.doCheckState();
	}

	@Override
	public String changePressed() { // Browse
		String dotExecutablePath = super.changePressed();
		if (dotExecutablePath == null) return null; // no change
		return dotExecutablePath;
	}

	@Override
	protected void fireValueChanged(String property, Object oldValue, Object newValue) {
		super.fireValueChanged(property, oldValue, newValue);
		// update(page.getCombo());
	}

	private boolean isValidExecutable(String path, String name) {
		if (path == null || path.isEmpty()) return false;
		File file = new File(path);
		if (!(file.getName().equals(name) || file.getName().equals(name + ".exe"))) { //$NON-NLS-1$
			return false;
		}
		return file.isFile();
	}
}
