package net.certiv.fluentmark.preferences.pages;

import static net.certiv.fluentmark.preferences.Prefs.EDITOR_EXTERNAL_COMMAND;
import static net.certiv.fluentmark.preferences.Prefs.KEY_EXTERNAL;

import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swt.widgets.Composite;

import net.certiv.fluentmark.preferences.AbstractOptionsBlock;

public class ConverterExternalOps extends AbstractOptionsBlock {

	private StringFieldEditor exCmd;

	public ConverterExternalOps(PrefPageConvert page, Composite parent, String title) {
		super(page, parent, title);
	}

	@Override
	protected void createControls(Composite comp) {
		exCmd = new StringFieldEditor(EDITOR_EXTERNAL_COMMAND, "", comp);
		addField(exCmd);
	}

	@Override
	public boolean validateSettings() {
		return getPage().isSelected(KEY_EXTERNAL) ? checkPathExe(exCmd.getStringValue(), null) : true;
	}
}
