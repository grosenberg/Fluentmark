package net.certiv.fluent.dt.ui.preferences.blocks;

import java.util.List;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;

import net.certiv.dsl.core.color.DslColorRegistry;
import net.certiv.dsl.core.preferences.PrefsDeltaManager;
import net.certiv.dsl.ui.preferences.blocks.AbstractFoldingConfigBlock;
import net.certiv.dsl.ui.preferences.pages.IDslPreferencePage;
import net.certiv.fluent.dt.core.preferences.Prefs;

public class FoldingConfigBlock extends AbstractFoldingConfigBlock {

	public FoldingConfigBlock(IDslPreferencePage page, PrefsDeltaManager delta, FormToolkit formkit,
			DslColorRegistry reg) {
		super(page, delta, formkit, reg);
	}

	@Override
	public List<String> getDeltaFoldingKeys(List<String> keys) {
		keys.add(Prefs.FOLDING_FRONTMATTER);
		keys.add(Prefs.FOLDING_COMMENTS);
		keys.add(Prefs.FOLDING_CODEBLOCKS);
		keys.add(Prefs.FOLDING_HTMLBLOCKS);
		keys.add(Prefs.FOLDING_DOTBLOCKS);
		keys.add(Prefs.FOLDING_UMLBLOCKS);
		keys.add(Prefs.FOLDING_MATHBLOCKS);

		return keys;
	}

	@Override
	public void addCustomControls(Composite initialFolding) {
		addCheckBox(initialFolding, "Front matter", Prefs.FOLDING_FRONTMATTER, 0);
		addCheckBox(initialFolding, "Comments", Prefs.FOLDING_COMMENTS, 0);
		addCheckBox(initialFolding, "Code blocks", Prefs.FOLDING_CODEBLOCKS, 0);
		addCheckBox(initialFolding, "HTML blocks", Prefs.FOLDING_HTMLBLOCKS, 0);
		addCheckBox(initialFolding, "Dot blocks", Prefs.FOLDING_DOTBLOCKS, 0);
		addCheckBox(initialFolding, "UML blocks", Prefs.FOLDING_UMLBLOCKS, 0);
		addCheckBox(initialFolding, "Math blocks", Prefs.FOLDING_MATHBLOCKS, 0);
	}
}
