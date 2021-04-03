package net.certiv.fluent.dt.ui.preferences.tabs;

import static net.certiv.fluent.dt.core.preferences.Prefs.*;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import net.certiv.dsl.core.preferences.PrefsDeltaManager;
import net.certiv.dsl.ui.preferences.tabs.AbstractTab;
import net.certiv.dsl.ui.util.SWTFactory;
import net.certiv.fluent.dt.ui.preferences.blocks.Cnv;
import net.certiv.fluent.dt.ui.preferences.blocks.ConvertersConfigBlock;

public class PandocTab extends AbstractTab {

	private PrefsDeltaManager delta;
	private Text pgmText;
	private Text dirText;

	public PandocTab(ConvertersConfigBlock block, Composite parent, PrefsDeltaManager delta, String title) {
		super(block, parent, title);
		this.delta = delta;
	}

	@Override
	protected void createControls(Composite comp) {
		Composite bools = SWTFactory.createGroupComposite(comp, 3, 1, "Options");
		block.addCheckBox(bools, "Enable Mathjax rendering", EDITOR_PANDOC_MATHJAX, 0);
		block.addCheckBox(bools, "Use smart typography", EDITOR_PANDOC_SMART, 0);
		block.addCheckBox(bools, "Add table of contents", EDITOR_PANDOC_ADDTOC, 0);

		Composite loc = SWTFactory.createGroupComposite(comp, 3, 3, "Locations");
		pgmText = block.addProgramField(loc, EDITOR_PANDOC_PROGRAM, 0, 3, "Program", 0, validFilePath);
		dirText = block.addDirectoryField(loc, EDITOR_PANDOC_TEMPLATES, 0, 3, "Templates", 0, validDirPath);
	}

	@Override
	public boolean validateSettings() {
		boolean ok = true;
		if (isSelected()) {
			ok = ok && checkPathExe(pgmText.getText(), Cnv.PANDOC.basename());
			ok = ok && checkPathDir(dirText.getText(), true);
		}
		return ok;
	}

	private boolean isSelected() {
		return KEY_PANDOC.equals(delta.getString(EDITOR_MD_CONVERTER));
	}
}
