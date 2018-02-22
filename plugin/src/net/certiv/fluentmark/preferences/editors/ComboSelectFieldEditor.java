package net.certiv.fluentmark.preferences.editors;

import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.swt.widgets.Composite;

public class ComboSelectFieldEditor extends ComboFieldEditor {

	private String key = ""; // current key key
	private String[][] entryNamesAndValues;

	public ComboSelectFieldEditor(String name, String labelText, String[][] entryNamesAndValues, Composite parent) {
		super(name, labelText, entryNamesAndValues, parent);
		this.entryNamesAndValues = entryNamesAndValues;
	}

	public String getKey() {
		return key;
	}

	public String getValue(String key) {
		for (String[] entry : entryNamesAndValues) {
			if (key.equals(entry[0])) return entry[1];
		}
		return "";
	}

	@Override
	protected void fireValueChanged(String property, Object oldValue, Object newValue) {
		key = (String) newValue;
		super.fireValueChanged(property, oldValue, newValue);
	}
}
