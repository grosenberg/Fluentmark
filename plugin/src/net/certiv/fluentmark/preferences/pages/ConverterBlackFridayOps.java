package net.certiv.fluentmark.preferences.pages;

import static net.certiv.fluentmark.preferences.Prefs.*;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.swt.widgets.Composite;

import net.certiv.fluentmark.preferences.AbstractOptionsBlock;
import net.certiv.fluentmark.preferences.editors.ProgramFieldEditor;
import net.certiv.fluentmark.util.SwtUtil;

public class ConverterBlackFridayOps extends AbstractOptionsBlock {

	private static final String BLACKFRIDAY = "blackfriday-tool";
	private static final String[] BF_MSG = { "Invalid BlackFriday executable",
			"Full pathname of the BlackFriday tool [blackfriday-tool|blackfriday-tool.exe]", "blackfriday-tool" };
	private ProgramFieldEditor bfExe;

	public ConverterBlackFridayOps(PrefPageConvert page, Composite parent, String title) {
		super(page, parent, title);
	}

	@Override
	protected void createControls(Composite comp) {
		Composite bools = SwtUtil.makeComposite(comp, 3, 1);
		addField(new BooleanFieldEditor(EDITOR_BLACKFRIDAY_SMART, "Use smart typography", bools));
		addField(new BooleanFieldEditor(EDITOR_BLACKFRIDAY_ADDTOC, "Add table of contents", bools));

		SwtUtil.addSpacer(comp, 3);
		bfExe = new ProgramFieldEditor(EDITOR_BLACKFRIDAY_PROGRAM, "Program:", comp, BF_MSG);
		addField(bfExe);
	}

	@Override
	public boolean validateSettings() {
		return getPage().isSelected(KEY_BLACKFRIDAY) ? checkPathExe(bfExe.getStringValue(), BLACKFRIDAY) : true;
	}
}
