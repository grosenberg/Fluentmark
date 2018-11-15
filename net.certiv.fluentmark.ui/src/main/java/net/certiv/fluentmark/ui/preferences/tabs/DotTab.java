package net.certiv.fluentmark.ui.preferences.tabs;

import static net.certiv.fluentmark.core.preferences.Prefs.EDITOR_DOTMODE_ENABLED;
import static net.certiv.fluentmark.core.preferences.Prefs.EDITOR_DOT_PROGRAM;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.swt.widgets.Composite;

import net.certiv.dsl.core.preferences.DslPrefsManagerDelta;
import net.certiv.dsl.ui.preferences.editors.ProgramFieldEditor;
import net.certiv.dsl.ui.preferences.pages.IDslPreferencePage;
import net.certiv.dsl.ui.util.SWTFactory;
import net.certiv.fluentmark.ui.preferences.blocks.Cnv;

public class DotTab extends AbstractTab {

	private BooleanFieldEditor dotEn;
	private ProgramFieldEditor dotExe;

	public DotTab(IDslPreferencePage page, Composite parent, DslPrefsManagerDelta delta, String title) {
		super(page, parent, title);
	}

	@Override
	protected void createControls(Composite comp) {
		Composite bools = SWTFactory.createComposite(comp, 3, 1);
		dotEn = new BooleanFieldEditor(EDITOR_DOTMODE_ENABLED, "Enable Dot diagram generator", bools);
		addField(dotEn);

		SWTFactory.addSpacer(comp, 3);
		dotExe = new ProgramFieldEditor(EDITOR_DOT_PROGRAM, "Program:", bools, Cnv.DOT.msg());
		addField(dotExe);
	}

	@Override
	public boolean validateSettings() {
		if (isVisible() && dotEn.getBooleanValue()) {
			return checkPathExe(dotExe.getStringValue(), Cnv.DOT.base());
		}
		return true;
	}
}
