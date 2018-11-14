package net.certiv.fluentmark.ui.preferences.blocks;

import java.util.List;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;

import net.certiv.dsl.core.color.DslColorManager;
import net.certiv.dsl.core.preferences.DslPrefsManagerDelta;
import net.certiv.dsl.ui.preferences.blocks.AbstractFoldingConfigBlock;
import net.certiv.dsl.ui.preferences.pages.IDslPreferencePage;
import net.certiv.fluentmark.core.preferences.Prefs;

public class FoldingConfigBlock extends AbstractFoldingConfigBlock {

	public FoldingConfigBlock(IDslPreferencePage page, DslPrefsManagerDelta delta, FormToolkit formkit,
			DslColorManager colorMgr) {
		super(page, delta, formkit, colorMgr);
	}

	@Override
	public List<String> getDeltaFoldingKeys(List<String> keys) {
		keys.add(Prefs.FOLDING_FRONTMATTER_ENABLED);
		keys.add(Prefs.FOLDING_HIDDEN_COMMENTS_ENABLED);
		keys.add(Prefs.FOLDING_CODEBLOCKS_ENABLED);
		keys.add(Prefs.FOLDING_INITIAL_FRONT_MATTER);
		keys.add(Prefs.FOLDING_INITIAL_HIDDEN_COMMENTS);
		keys.add(Prefs.FOLDING_INITIAL_CODEBLOCKS);
		keys.add(Prefs.FOLDING_LINES_LIMIT);
		return keys;
	}

	@Override
	public void addCustomControls(Composite initialFolding) {
		addCheckBox(initialFolding, "Front matter block", Prefs.FOLDING_FRONTMATTER_ENABLED, 0);
		addCheckBox(initialFolding, "Hidden comments", Prefs.FOLDING_HIDDEN_COMMENTS_ENABLED, 0);
		addCheckBox(initialFolding, "Code blocks", Prefs.FOLDING_CODEBLOCKS_ENABLED, 0);
		addCheckBox(initialFolding, "Front matter block", Prefs.FOLDING_INITIAL_FRONT_MATTER, 0);
		addCheckBox(initialFolding, "Hidden comments", Prefs.FOLDING_INITIAL_HIDDEN_COMMENTS, 0);
		addCheckBox(initialFolding, "Code blocks", Prefs.FOLDING_INITIAL_CODEBLOCKS, 0);
	}
}
