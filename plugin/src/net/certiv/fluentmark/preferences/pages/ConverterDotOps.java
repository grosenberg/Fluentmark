package net.certiv.fluentmark.preferences.pages;

import static net.certiv.fluentmark.preferences.Prefs.EDITOR_DOTMODE_ENABLED;
import static net.certiv.fluentmark.preferences.Prefs.EDITOR_DOT_PROGRAM;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.swt.widgets.Composite;

import net.certiv.fluentmark.preferences.AbstractOptionsBlock;
import net.certiv.fluentmark.preferences.editors.ProgramFieldEditor;
import net.certiv.fluentmark.util.SwtUtil;

public class ConverterDotOps extends AbstractOptionsBlock {

	private static final String DOT = "dot";
	private static final String[] DOT_MSG = { "Invalid Dot executable",
			"Full pathname of the Dot executable [dot|dot.exe]", "dot" };

	private BooleanFieldEditor dotMode;
	private ProgramFieldEditor dotExe;

	public ConverterDotOps(PrefPageConvert page, Composite parent, String title) {
		super(page, parent, title);
	}

	@Override
	protected void createControls(Composite comp) {
		Composite bools = SwtUtil.makeComposite(comp, 3, 1);
		dotMode = new BooleanFieldEditor(EDITOR_DOTMODE_ENABLED, "Enable Dot diagram generator", bools);
		dotExe = new ProgramFieldEditor(EDITOR_DOT_PROGRAM, "Program:", bools, DOT_MSG);

		addField(dotMode);

		SwtUtil.addSpacer(comp, 3);
		addField(dotExe);
	}

	@Override
	public boolean validateSettings() {
		return isVisible() && dotMode.getBooleanValue() ? checkPathExe(dotExe.getStringValue(), DOT) : true;
	}
}
