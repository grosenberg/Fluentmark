package net.certiv.fluent.dt.ui.preferences.tabs;

import static net.certiv.fluent.dt.core.preferences.Prefs.EDITOR_FLEXMARK_MATHJAX;
import static net.certiv.fluent.dt.core.preferences.Prefs.EDITOR_FLEXMARK_PROFILE;

import org.eclipse.swt.widgets.Composite;

import com.vladsch.flexmark.parser.ParserEmulationProfile;

import net.certiv.dsl.core.preferences.DslPrefsManagerDelta;
import net.certiv.dsl.ui.preferences.tabs.AbstractTab;
import net.certiv.dsl.ui.util.SWTFactory;
import net.certiv.fluent.dt.ui.preferences.blocks.ConvertersConfigBlock;

public class FlexmarkTab extends AbstractTab {

	private static final String[][] profiles = new String[][] { //
			{ "Commonmark", ParserEmulationProfile.COMMONMARK_0_28.toString() }, //
			{ "Github Flavored Markdown", ParserEmulationProfile.GITHUB_DOC.toString() }, //
			{ "Multi-markdown", ParserEmulationProfile.MULTI_MARKDOWN.toString() }, //
			{ "Pegdown", ParserEmulationProfile.PEGDOWN.toString() } //
	};

	public FlexmarkTab(ConvertersConfigBlock block, Composite parent, DslPrefsManagerDelta delta, String title) {
		super(block, parent, title);
	}

	@Override
	protected void createControls(Composite comp) {
		Composite config = SWTFactory.createGroupComposite(comp, 1, 3, "Markdown configuration");
		block.addLabeledCombo(config, "Profile", EDITOR_FLEXMARK_PROFILE, profiles, false);

		Composite bools = SWTFactory.createGroupComposite(comp, 3, 1, "Options");
		block.addCheckBox(bools, "Enable Mathjax rendering", EDITOR_FLEXMARK_MATHJAX, 0);
	}

	@Override
	public boolean validateSettings() {
		return true;
	}
}
