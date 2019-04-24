package net.certiv.fluent.dt.ui.preferences.formatter;

import net.certiv.dsl.ui.formatter.FormatterModifyDialog;
import net.certiv.dsl.ui.formatter.IDslFormatterFactory;
import net.certiv.dsl.ui.formatter.IFormatterModifyDialogOwner;

public class ModifyDialog extends FormatterModifyDialog {

	public ModifyDialog(IFormatterModifyDialogOwner owner, IDslFormatterFactory factory) {
		super(owner, factory);
	}

	@Override
	protected void addPages() {
		addTabPage("General", new TabGeneral(this, getFormatterFactory()));
		addTabPage("Blank Lines", new TabBlankLines(this));
	}
}
