package net.certiv.fluentmark.ui.preferences.tabs;

import static net.certiv.fluentmark.core.preferences.Prefs.*;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.swt.widgets.Composite;

import net.certiv.dsl.core.preferences.DslPrefsManagerDelta;
import net.certiv.dsl.ui.preferences.editors.ProgramFieldEditor;
import net.certiv.dsl.ui.preferences.pages.IDslPreferencePage;
import net.certiv.dsl.ui.util.SWTFactory;
import net.certiv.fluentmark.ui.preferences.blocks.Cnv;

public class BlackFridayTab extends AbstractTab {

	private ProgramFieldEditor bfExe;
	private DslPrefsManagerDelta delta;

	public BlackFridayTab(IDslPreferencePage page, Composite parent, DslPrefsManagerDelta delta, String title) {
		super(page, parent, title);
		this.delta = delta;
	}

	@Override
	protected void createControls(Composite comp) {
		Composite bools = SWTFactory.createComposite(comp, 3, 1);
		addField(new BooleanFieldEditor(EDITOR_BLACKFRIDAY_SMART, "Use smart typography", bools));
		addField(new BooleanFieldEditor(EDITOR_BLACKFRIDAY_ADDTOC, "Add table of contents", bools));

		SWTFactory.addSpacer(comp, 3);
		bfExe = new ProgramFieldEditor(EDITOR_BLACKFRIDAY_PROGRAM, "Program:", comp, Cnv.BLACKFRIDAY.msg());
		addField(bfExe);
	}

	@Override
	public boolean validateSettings() {
		return KEY_BLACKFRIDAY.equals(delta.getString(EDITOR_MD_CONVERTER));
	}
}
