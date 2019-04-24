package net.certiv.fluent.dt.ui.preferences.tabs;

import static net.certiv.fluent.dt.core.preferences.Prefs.*;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import net.certiv.dsl.core.preferences.DslPrefsManagerDelta;
import net.certiv.dsl.ui.preferences.tabs.AbstractTab;
import net.certiv.dsl.ui.util.SWTFactory;
import net.certiv.fluent.dt.ui.preferences.blocks.Cnv;
import net.certiv.fluent.dt.ui.preferences.blocks.ConvertersConfigBlock;

public class BlackFridayTab extends AbstractTab {

	private Text text;
	private DslPrefsManagerDelta delta;

	public BlackFridayTab(ConvertersConfigBlock block, Composite parent, DslPrefsManagerDelta delta, String title) {
		super(block, parent, title);
		this.delta = delta;
	}

	@Override
	protected void createControls(Composite comp) {
		Composite bools = SWTFactory.createGroupComposite(comp, 3, 1, "Options");
		block.addCheckBox(bools, "Use smart typography", EDITOR_BLACKFRIDAY_SMART, 0);
		block.addCheckBox(bools, "Add table of contents", EDITOR_BLACKFRIDAY_ADDTOC, 0);

		Composite loc = SWTFactory.createGroupComposite(comp, 3, 2, "Location");
		text = block.addProgramField(loc, EDITOR_BLACKFRIDAY_PROGRAM, 0, 3, "Program", 0, validFilePath);
	}

	@Override
	public boolean validateSettings() {
		boolean ok = true;
		if (isSelected()) {
			ok = ok && checkPathExe(text.getText(), Cnv.PANDOC.basename());
		}
		return ok;
	}

	private boolean isSelected() {
		return KEY_BLACKFRIDAY.equals(delta.getString(EDITOR_MD_CONVERTER));
	}
}
