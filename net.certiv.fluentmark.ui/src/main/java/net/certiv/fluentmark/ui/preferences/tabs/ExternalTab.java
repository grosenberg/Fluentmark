package net.certiv.fluentmark.ui.preferences.tabs;

import static net.certiv.fluentmark.core.preferences.Prefs.EDITOR_MD_CONVERTER;
import static net.certiv.fluentmark.core.preferences.Prefs.EDITOR_PANDOC_PROGRAM;
import static net.certiv.fluentmark.core.preferences.Prefs.KEY_EXTERNAL;

import org.eclipse.swt.widgets.Composite;

import net.certiv.dsl.core.preferences.DslPrefsManagerDelta;
import net.certiv.dsl.ui.preferences.editors.ProgramFieldEditor;
import net.certiv.dsl.ui.preferences.pages.IDslPreferencePage;
import net.certiv.dsl.ui.util.SWTFactory;
import net.certiv.fluentmark.ui.preferences.blocks.Cnv;

public class ExternalTab extends AbstractTab {

	private DslPrefsManagerDelta delta;
	private ProgramFieldEditor exe;

	public ExternalTab(IDslPreferencePage page, Composite parent, DslPrefsManagerDelta delta, String title) {
		super(page, parent, title);
		this.delta = delta;
	}

	@Override
	protected void createControls(Composite comp) {
		Composite loc = SWTFactory.createComposite(comp, 3, 1);
		exe = new ProgramFieldEditor(EDITOR_PANDOC_PROGRAM, "Program:", loc, Cnv.EXTERNAL.msg());
		addField(exe);
	}

	@Override
	public boolean validateSettings() {
		return KEY_EXTERNAL.equals(delta.getString(EDITOR_MD_CONVERTER));
	}
}
