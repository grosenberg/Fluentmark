package net.certiv.fluentmark.ui.preferences.blocks;

import java.util.List;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;

import net.certiv.dsl.core.color.DslColorManager;
import net.certiv.dsl.core.preferences.DslPrefsManagerDelta;
import net.certiv.dsl.ui.preferences.blocks.AbstractEditorConfigBlock;
import net.certiv.dsl.ui.preferences.pages.IDslPreferencePage;
import net.certiv.dsl.ui.util.SWTFactory;
import net.certiv.fluentmark.core.preferences.Prefs;

public class EditorConfigBlock extends AbstractEditorConfigBlock {

	public EditorConfigBlock(IDslPreferencePage page, DslPrefsManagerDelta delta, FormToolkit formkit,
			DslColorManager colorMgr) {
		super(page, delta, formkit, colorMgr);
	}

	@Override
	protected List<String> createDeltaMatchKeys(List<String> keys) {
		keys.add(Prefs.EDITOR_SMART_BACKSPACE);
		keys.add(Prefs.EDITOR_WORD_WRAP);
		keys.add(Prefs.EDITOR_HTML_OPEN);
		keys.add(Prefs.EDITOR_PDF_OPEN);
		keys.add(Prefs.EDITOR_TAB_WIDTH);
		keys.add(Prefs.EDITOR_FORMATTING_ENABLED);
		keys.add(Prefs.EDITOR_FORMATTING_COLUMN);

		keys.add(Prefs.EDITOR_TASK_TAGS);
		keys.add(Prefs.EDITOR_TASK_TAGS_DEFINED);

		keys.add(Prefs.VIEW_UPDATE_DELAY);
		return keys;
	}

	@Override
	public void addEditingControls(Composite parent) {

		// General
		Composite genComposite = SWTFactory.createSubsection(parent, null, "General");
		GridLayout genLayout = new GridLayout(4, true);
		genComposite.setLayout(genLayout);

		addCheckBox(genComposite, "Smart backspace", Prefs.EDITOR_SMART_BACKSPACE, 0);
		addCheckBox(genComposite, "Enable word wrap", Prefs.EDITOR_WORD_WRAP, 0);
		addCheckBox(genComposite, "Open HTML file after creation", Prefs.EDITOR_HTML_OPEN, 0);
		addCheckBox(genComposite, "Open PDF file after creation", Prefs.EDITOR_PDF_OPEN, 0);
		addLabeledTextField(genComposite, "Tab size:", Prefs.EDITOR_TAB_WIDTH, 6, 0, true);

		// Formatting
		Composite forComp = SWTFactory.createSubsection(parent, null, "Formatting");
		GridLayout forLayout = new GridLayout(4, true);
		forComp.setLayout(forLayout);

		addCheckBox(forComp, "Formatting enabled", Prefs.EDITOR_FORMATTING_ENABLED, 0);
		addLabeledTextField(forComp, "Formatted line width:", Prefs.EDITOR_FORMATTING_COLUMN, 6, 0, true);

		// Task
		Composite taskComp = SWTFactory.createSubsection(parent, null, "Task tags");
		GridLayout taskLayout = new GridLayout(4, true);
		taskComp.setLayout(taskLayout);

		addCheckBox(taskComp, "Use task tags", Prefs.EDITOR_TASK_TAGS, 0);
		addLabeledTextField(taskComp, "Task tags defined:", Prefs.EDITOR_TASK_TAGS_DEFINED, 0, 0, false);

		// Preview
		Composite preComp = SWTFactory.createSubsection(parent, null, "Preview");
		GridLayout preLayout = new GridLayout(4, true);
		preComp.setLayout(preLayout);

		addLabeledTextField(preComp, "Update rate limiter period (ms): ", Prefs.VIEW_UPDATE_DELAY, 6, 0, true);
		// ((GridData) preComp.getLayoutData()).grabExcessHorizontalSpace = false;
	}
}
