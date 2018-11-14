package net.certiv.fluentmark.ui.preferences.tabs;

import static net.certiv.fluentmark.core.preferences.Prefs.*;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.swt.widgets.Composite;

import net.certiv.dsl.core.preferences.DslPrefsManagerDelta;
import net.certiv.dsl.ui.preferences.editors.ProgramFieldEditor;
import net.certiv.dsl.ui.preferences.pages.IDslPreferencePage;
import net.certiv.dsl.ui.util.SWTFactory;
import net.certiv.fluentmark.ui.preferences.blocks.Cnv;

public class PandocTab extends AbstractTab {

	private ProgramFieldEditor exe;
	private DirectoryFieldEditor tmplDir;
	private DslPrefsManagerDelta delta;

	public PandocTab(IDslPreferencePage page, Composite parent, DslPrefsManagerDelta delta, String title) {
		super(page, parent, title);
		this.delta = delta;
	}

	@Override
	protected void createControls(Composite comp) {
		Composite bools = SWTFactory.createGroupComposite(comp, 3, 1, "Options");

		addField(new BooleanFieldEditor(EDITOR_PANDOC_SMART, "Use smart typography", bools));
		addField(new BooleanFieldEditor(EDITOR_PANDOC_ADDTOC, "Add table of contents", bools));
		addField(new BooleanFieldEditor(EDITOR_PANDOC_MATHJAX, "Enable Mathjax rendering", bools));
		addField(new BooleanFieldEditor(EDITOR_UMLMODE_ENABLED, "Enable PlantUML rendering", bools));

		SWTFactory.addSpacer(comp, 3);
		Composite loc = SWTFactory.createGroupComposite(comp, 3, 1, "Locations");

		exe = new ProgramFieldEditor(EDITOR_PANDOC_PROGRAM, "Program:", loc, Cnv.PANDOC.msg());
		addField(exe);
		tmplDir = new DirectoryFieldEditor(EDITOR_PANDOC_TEMPLATES, "LaTex Templates:", loc);
		addField(tmplDir);
	}

	@Override
	public boolean validateSettings() {
		boolean ok = true;
		if (isSelected()) {
			ok = ok && checkPathExe(exe.getStringValue(), Cnv.PANDOC.base());
			ok = ok && checkPathDir(tmplDir.getStringValue(), true);
		}
		return ok;
	}

	private boolean isSelected() {
		return KEY_PANDOC.equals(delta.getString(EDITOR_MD_CONVERTER));
	}
}
