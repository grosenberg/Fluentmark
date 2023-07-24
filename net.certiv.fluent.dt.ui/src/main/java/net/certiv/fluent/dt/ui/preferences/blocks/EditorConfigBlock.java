package net.certiv.fluent.dt.ui.preferences.blocks;

import java.util.List;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;

import net.certiv.dsl.core.color.DslColorRegistry;
import net.certiv.dsl.core.preferences.PrefsDeltaManager;
import net.certiv.dsl.core.preferences.consts.Operation;
import net.certiv.dsl.ui.preferences.blocks.DefaultEditorConfigBlock;
import net.certiv.dsl.ui.preferences.pages.IDslPreferencePage;
import net.certiv.fluent.dt.core.preferences.Prefs;

public class EditorConfigBlock extends DefaultEditorConfigBlock {

	public EditorConfigBlock(IDslPreferencePage page, PrefsDeltaManager delta, FormToolkit formkit,
			DslColorRegistry reg) {
		super(page, delta, formkit, reg);
	}

	@Override
	protected List<String> createDeltaMatchKeys(List<String> keys) {

		keys.add(Prefs.EDITOR_SOFT_WRAP);
		keys.add(Prefs.EDITOR_TASK_TAGS);
		keys.add(Prefs.EDITOR_TASK_TAGS_DEFINED);
		keys.add(Operation.OUTLINE_OPEN_LEVELS);

		return super.createDeltaMatchKeys(keys);
	}

	@Override
	public void addEditingControls(Composite parent) {
		createSettingsGroup(parent);
		createTabsGroup(parent);
		createOutlineGroup(parent);
	}
}
