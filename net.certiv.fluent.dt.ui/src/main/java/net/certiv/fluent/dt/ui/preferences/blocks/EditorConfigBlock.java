package net.certiv.fluent.dt.ui.preferences.blocks;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;

import net.certiv.dsl.core.color.DslColorRegistry;
import net.certiv.dsl.core.preferences.PrefsDeltaManager;
import net.certiv.dsl.core.preferences.consts.Operation;
import net.certiv.dsl.ui.preferences.blocks.DefaultEditorConfigBlock;
import net.certiv.dsl.ui.preferences.pages.IDslPreferencePage;
import net.certiv.dsl.ui.util.SWTFactory;
import net.certiv.fluent.dt.core.preferences.Prefs;

public class EditorConfigBlock extends DefaultEditorConfigBlock {

	public EditorConfigBlock(IDslPreferencePage page, PrefsDeltaManager delta, FormToolkit formkit,
			DslColorRegistry reg) {
		super(page, delta, formkit, reg);
	}

	@Override
	protected List<String> createDeltaMatchKeys(List<String> keys) {

		keys.add(Prefs.EDITOR_WORD_WRAP);
		keys.add(Operation.OUTLINE_OPEN_LEVELS);

		keys.add(Prefs.VIEW_UPDATE_DELAY);
		keys.add(Prefs.EDITOR_HTML_OPEN);
		keys.add(Prefs.EDITOR_PDF_OPEN);

		keys.add(Prefs.FORMATTER_ENABLED);
		keys.add(Prefs.FORMATTER_WRAP_COLUMN);

		keys.add(Prefs.EDITOR_TASK_TAGS);
		keys.add(Prefs.EDITOR_TASK_TAGS_DEFINED);

		return super.createDeltaMatchKeys(keys);
	}

	@Override
	public void addEditingControls(Composite parent) {
		Composite settings = createSettingsGroup(parent);
		appendSettings(settings);

		createTabsGroup(parent);
		createOutlineGroup(parent);
		createFormattingGroup(parent);
		createPreviewGroup(parent);
	}

	private void appendSettings(Composite composite) {
		addCheckBox(composite, "Enable editor word wrap", Prefs.EDITOR_WORD_WRAP, 2, 2);
	}

	private void createFormattingGroup(Composite parent) {
		Composite composite = SWTFactory.createGroupComposite(parent, 3, 3, "Formatting");
		addCheckBox(composite, "Formatting enabled", Prefs.FORMATTER_ENABLED, 3, 0);
		addTextField(composite, "Line width", Prefs.FORMATTER_WRAP_COLUMN, 6, 0, FType.INTEGER);
		SWTFactory.createLabel(composite, "(set to '0' to disable formatter wrapping)", SWT.BEGINNING);
	}

	private void createPreviewGroup(Composite parent) {
		Composite comp = SWTFactory.createGroupComposite(parent, 3, 2, "Preview");
		addTextField(comp, "Preview update rate (ms) ", Prefs.VIEW_UPDATE_DELAY, 6, 0, FType.INTEGER);
		addCheckBox(comp, "Open HTML file after creation", Prefs.EDITOR_HTML_OPEN, 2, 0);
		addCheckBox(comp, "Open PDF file after creation", Prefs.EDITOR_PDF_OPEN, 2, 0);
	}
}
