package net.certiv.fluentmark.ui.preferences.blocks;

import static net.certiv.fluentmark.core.preferences.Prefs.*;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.swt.widgets.Composite;

import net.certiv.dsl.ui.preferences.editors.ProgramFieldEditor;
import net.certiv.dsl.ui.util.SWTFactory;
import net.certiv.fluentmark.ui.preferences.pages.ConvertersPage;

public class BlackFridayConfigBlock extends AbstractConverterBlock {

	private static final String BLACKFRIDAY = "blackfriday-tool";
	private static final String[] BF_MSG = { "Invalid BlackFriday executable",
			"Full pathname of the BlackFridayConfigBlock tool [blackfriday-tool|blackfriday-tool.exe]", "blackfriday-tool" };

	private ProgramFieldEditor bfExe;

	public BlackFridayConfigBlock(ConvertersPage page, Composite parent, String title) {
		super(page, parent, title);
	}

	@Override
	protected void createControls(Composite comp) {
		Composite bools = SWTFactory.makeComposite(comp, 3, 1);
		addField(new BooleanFieldEditor(EDITOR_BLACKFRIDAY_SMART, "Use smart typography", bools));
		addField(new BooleanFieldEditor(EDITOR_BLACKFRIDAY_ADDTOC, "Add table of contents", bools));

		SWTFactory.addSpacer(comp, 3);
		bfExe = new ProgramFieldEditor(EDITOR_BLACKFRIDAY_PROGRAM, "Program:", comp, BF_MSG);
		addField(bfExe);
	}

	@Override
	public boolean validateSettings() {
		return getPage().isSelected(KEY_BLACKFRIDAY) ? checkPathExe(bfExe.getStringValue(), BLACKFRIDAY) : true;
	}
}
