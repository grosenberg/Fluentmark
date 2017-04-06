package net.certiv.fluentmark.preferences.editors;

import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.swt.widgets.Composite;

public class ConverterSelectFieldEditor extends ComboFieldEditor {

	private String value = ""; // current key value

	public ConverterSelectFieldEditor(String name, String labelText, String[][] entryNamesAndValues, Composite parent) {
		super(name, labelText, entryNamesAndValues, parent);
	}

	public String getValue() {
		return value;
	}

	@Override
	protected void fireValueChanged(String property, Object oldValue, Object newValue) {
		value = (String) newValue;
		super.fireValueChanged(property, oldValue, newValue);
	}
}
