package net.certiv.fluentmark.ui.preferences.blocks;

import static net.certiv.fluentmark.core.preferences.Prefs.EDITOR_DOTMODE_ENABLED;
import static net.certiv.fluentmark.core.preferences.Prefs.EDITOR_DOT_PROGRAM;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.swt.widgets.Composite;

import net.certiv.dsl.ui.preferences.editors.ProgramFieldEditor;
import net.certiv.dsl.ui.util.SWTFactory;
import net.certiv.fluentmark.ui.preferences.pages.ConvertersPage;

public class DotConfigBlock extends AbstractConverterBlock {

	private static final String DOT = "dot";
	private static final String[] DOT_MSG = { "Invalid Dot executable",
			"Full pathname of the Dot executable [dot|dot.exe]", "dot" };

	private BooleanFieldEditor dotMode;
	private ProgramFieldEditor dotExe;

	public DotConfigBlock(ConvertersPage page, Composite parent, String title) {
		super(page, parent, title);
	}

	@Override
	protected void createControls(Composite comp) {
		Composite bools = SWTFactory.makeComposite(comp, 3, 1);
		dotMode = new BooleanFieldEditor(EDITOR_DOTMODE_ENABLED, "Enable Dot diagram generator", bools);
		dotExe = new ProgramFieldEditor(EDITOR_DOT_PROGRAM, "Program:", bools, DOT_MSG);

		addField(dotMode);

		SWTFactory.addSpacer(comp, 3);
		addField(dotExe);
	}

	@Override
	public boolean validateSettings() {
		return isVisible() && dotMode.getBooleanValue() ? checkPathExe(dotExe.getStringValue(), DOT) : true;
	}
}
