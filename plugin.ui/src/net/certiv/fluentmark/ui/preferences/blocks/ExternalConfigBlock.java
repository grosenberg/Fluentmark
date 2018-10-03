package net.certiv.fluentmark.ui.preferences.blocks;

import static net.certiv.fluentmark.core.preferences.Prefs.EDITOR_EXTERNAL_COMMAND;
import static net.certiv.fluentmark.core.preferences.Prefs.KEY_EXTERNAL;

import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.swt.widgets.Composite;

import net.certiv.fluentmark.ui.preferences.pages.ConvertersPage;

public class ExternalConfigBlock extends AbstractConverterBlock {

	private StringFieldEditor exCmd;

	public ExternalConfigBlock(ConvertersPage page, Composite parent, String title) {
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
