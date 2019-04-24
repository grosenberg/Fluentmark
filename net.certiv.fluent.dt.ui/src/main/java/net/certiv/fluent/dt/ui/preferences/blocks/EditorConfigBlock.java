package net.certiv.fluent.dt.ui.preferences.blocks;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;

import net.certiv.dsl.core.color.DslColorManager;
import net.certiv.dsl.core.preferences.DslPrefsManagerDelta;
import net.certiv.dsl.core.preferences.consts.Editor;
import net.certiv.dsl.ui.preferences.blocks.AbstractEditorConfigBlock;
import net.certiv.dsl.ui.preferences.pages.IDslPreferencePage;
import net.certiv.dsl.ui.util.SWTFactory;
import net.certiv.fluent.dt.core.preferences.Prefs;

public class EditorConfigBlock extends AbstractEditorConfigBlock {

	public EditorConfigBlock(IDslPreferencePage page, DslPrefsManagerDelta delta, FormToolkit formkit,
			DslColorManager colorMgr) {
		super(page, delta, formkit, colorMgr);
	}

	@Override
	protected List<String> createDeltaMatchKeys(List<String> keys) {

		keys.add(Editor.EDITOR_TAB_POLICY);
		keys.add(Editor.EDITOR_TAB_WIDTH);

		keys.add(Editor.EDITOR_SMART_INDENT);
		keys.add(Editor.EDITOR_SMART_BACKSPACE);

		keys.add(Editor.EDITOR_SMART_HOME_END);
		keys.add(Editor.EDITOR_SUB_WORD_NAVIGATION);

		keys.add(Prefs.EDITOR_WORD_WRAP);
		keys.add(Prefs.EDITOR_HTML_OPEN);
		keys.add(Prefs.EDITOR_PDF_OPEN);

		keys.add(Prefs.FORMATTER_ENABLED);
		keys.add(Prefs.FORMATTER_WRAP_COLUMN);

		keys.add(Prefs.EDITOR_TASK_TAGS);
		keys.add(Prefs.EDITOR_TASK_TAGS_DEFINED);

		keys.add(Prefs.VIEW_UPDATE_DELAY);
		return keys;
	}

	@Override
	public void addEditingControls(Composite parent) {
		createGeneralGroup(parent);
		createFormattingGroup(parent);
		createTaskGroup(parent);
		createPreviewGroup(parent);
	}

	private void createGeneralGroup(Composite parent) {
		Composite composite = SWTFactory.createGroupComposite(parent, 3, 2, "Settings");
		addCheckBox(composite, "Smart backspace", Editor.EDITOR_SMART_BACKSPACE, 2, 0);
		addCheckBox(composite, "Enable word wrap", Prefs.EDITOR_WORD_WRAP, 2, 0);
		addLabeledTextField(composite, "Indent width", Editor.EDITOR_TAB_WIDTH, 6, 0, true);

		SWTFactory.createHorizontalSpacer(composite, 2);

		addCheckBox(composite, "Open HTML file after creation", Prefs.EDITOR_HTML_OPEN, 2, 0);
		addCheckBox(composite, "Open PDF file after creation", Prefs.EDITOR_PDF_OPEN, 2, 0);
	}

	private void createFormattingGroup(Composite parent) {
		Composite composite = SWTFactory.createGroupComposite(parent, 3, 3, "Formatting");
		addCheckBox(composite, "Formatting enabled", Prefs.FORMATTER_ENABLED, 3, 0);
		addLabeledTextField(composite, "Line width", Prefs.FORMATTER_WRAP_COLUMN, 6, 0, true);
		SWTFactory.createLabel(composite, "(set to '0' to disable wrapping)", SWT.BEGINNING);
	}

	private void createTaskGroup(Composite parent) {
		Composite composite = SWTFactory.createGroupComposite(parent, 3, 2, "Task tags");
		addCheckBox(composite, "Use task tags", Prefs.EDITOR_TASK_TAGS, 2, 0);
		addLabeledTextField(composite, "Task tags defined", Prefs.EDITOR_TASK_TAGS_DEFINED, 0, 0, false);
	}

	private void createPreviewGroup(Composite parent) {
		Composite preComp = SWTFactory.createGroupComposite(parent, 3, 2, "Preview");
		addLabeledTextField(preComp, "Update rate limiter period (ms) ", Prefs.VIEW_UPDATE_DELAY, 6, 0, true);
	}

}
