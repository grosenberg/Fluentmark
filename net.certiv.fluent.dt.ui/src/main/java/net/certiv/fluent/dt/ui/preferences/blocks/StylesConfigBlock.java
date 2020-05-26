package net.certiv.fluent.dt.ui.preferences.blocks;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.widgets.FormToolkit;

import net.certiv.dsl.core.color.DslColorManager;
import net.certiv.dsl.core.log.Log;
import net.certiv.dsl.core.preferences.PrefsDeltaManager;
import net.certiv.dsl.core.preferences.consts.Editor;
import net.certiv.dsl.ui.preferences.bind.DirectorypathValidator;
import net.certiv.dsl.ui.preferences.blocks.AbstractConfigBlock;
import net.certiv.dsl.ui.preferences.pages.IDslPreferencePage;
import net.certiv.dsl.ui.util.SWTFactory;
import net.certiv.fluent.dt.core.preferences.Prefs;

public class StylesConfigBlock extends AbstractConfigBlock {

	private Combo prvCombo;
	private Composite prvComp;
	private Combo smtCombo;
	private Composite smtComp;

	public StylesConfigBlock(IDslPreferencePage page, PrefsDeltaManager delta, FormToolkit formkit,
			DslColorManager colorMgr) {
		super(page, delta, formkit, colorMgr);
	}

	@Override
	protected List<String> createDeltaMatchKeys(List<String> keys) {
		keys.add(Editor.EDITOR_SEMANTIC_ENABLED);

		keys.add(Editor.EDITOR_SEMANTIC_FILE);
		keys.add(Editor.EDITOR_SEMANTIC_INTERNAL_DIR);
		keys.add(Editor.EDITOR_SEMANTIC_EXTERNAL_DIR);
		keys.add(Editor.EDITOR_SEMANTIC_EXTERNAL_ENABLE);

		keys.add(Prefs.EDITOR_PREVIEW_FILE);
		keys.add(Prefs.EDITOR_PREVIEW_INTERNAL_DIR);
		keys.add(Prefs.EDITOR_PREVIEW_EXTERNAL_DIR);
		keys.add(Prefs.EDITOR_PREVIEW_EXTERNAL_ENABLE);

		return keys;
	}

	@Override
	public Composite createContents(Composite parent) {
		Composite contents = super.createContents(parent);
		Composite comp = SWTFactory.createGroupComposite(contents, 1, 3, "Stylesheet Selection");

		createSemanticStylesGroup(parent);
		createPreviewStylesGroup(parent);
		return comp;
	}

	protected Composite createSemanticStylesGroup(Composite parent) {
		Composite comp = SWTFactory.createGroupComposite(parent, 3, 2, "Semantic Editor Styles");
		addCheckBox(comp, "Enable", Editor.EDITOR_SEMANTIC_ENABLED, 2, 4);
		smtCombo = addLabeledCombo(comp, "Select", Editor.EDITOR_SEMANTIC_FILE);

		addVerticalSpace(comp, 1, 3);
		addCheckBox(comp, "External stylesheets", Editor.EDITOR_SEMANTIC_EXTERNAL_ENABLE, 2, 4)
				.addSelectionListener(new SelectionAdapter() {

					@Override
					public void widgetSelected(SelectionEvent e) {
						adjustSemanticSelection(((Button) e.widget).getSelection());
					}
				});

		smtComp = SWTFactory.createComposite(comp, 2, 2, 4);
		addDirectoryField(smtComp, Editor.EDITOR_SEMANTIC_EXTERNAL_DIR, 2, 2, "Directory", 50,
				new DirectorypathValidator(null, true)).addModifyListener(new ModifyListener() {

					@Override
					public void modifyText(ModifyEvent e) {
						adjustSemanticSelection(delta.getBoolean(Editor.EDITOR_SEMANTIC_EXTERNAL_ENABLE));
					}
				});

		adjustSemanticSelection(delta.getBoolean(Editor.EDITOR_SEMANTIC_EXTERNAL_ENABLE));
		return comp;
	}

	private void adjustSemanticSelection(boolean external) {
		String choice = delta.getString(Editor.EDITOR_SEMANTIC_FILE);
		File f = new File(choice);
		choice = f.getName();
		enableControls(smtComp, external);

		updateCombo(smtCombo, choices(external, true));

		int idx = smtCombo.indexOf(choice);
		if (idx < 0) idx = 0;
		smtCombo.select(idx);
	}

	protected Composite createPreviewStylesGroup(Composite parent) {
		Composite comp = SWTFactory.createGroupComposite(parent, 3, 2, "Html Preview/Export Styles");
		prvCombo = addLabeledCombo(comp, "Select", Prefs.EDITOR_PREVIEW_FILE);

		addVerticalSpace(comp, 1, 3);
		addCheckBox(comp, "External stylesheets", Prefs.EDITOR_PREVIEW_EXTERNAL_ENABLE, 2, 0)
				.addSelectionListener(new SelectionAdapter() {

					@Override
					public void widgetSelected(SelectionEvent e) {
						adjustPreviewSelection(((Button) e.widget).getSelection());
					}
				});

		prvComp = SWTFactory.createComposite(comp, 2, 2, 4);
		addDirectoryField(prvComp, Prefs.EDITOR_PREVIEW_EXTERNAL_DIR, 2, 2, "Directory", 50,
				new DirectorypathValidator(null, true)).addModifyListener(new ModifyListener() {

					@Override
					public void modifyText(ModifyEvent e) {
						adjustPreviewSelection(delta.getBoolean(Prefs.EDITOR_PREVIEW_EXTERNAL_ENABLE));
					}
				});

		adjustPreviewSelection(delta.getBoolean(Prefs.EDITOR_PREVIEW_EXTERNAL_ENABLE));
		return comp;
	}

	private void adjustPreviewSelection(boolean external) {
		String choice = delta.getString(Prefs.EDITOR_PREVIEW_FILE);
		File f = new File(choice);
		choice = f.getName();
		enableControls(prvComp, external);

		updateCombo(prvCombo, choices(external, false));
		int idx = prvCombo.indexOf(choice);
		if (idx < 0) idx = 0;
		prvCombo.select(idx);
	}

	private void enableControls(Composite comp, boolean enable) {
		for (Control control : comp.getChildren()) {
			if (control instanceof Composite) {
				enableControls((Composite) control, enable);
			} else {
				control.setEnabled(enable);
			}
		}
	}

	private Map<String, Object> choices(boolean external, boolean semantic) {
		Map<String, Object> choices = new LinkedHashMap<>();

		File file = null;
		if (external) {
			String key = Prefs.EDITOR_PREVIEW_EXTERNAL_DIR;
			if (semantic) key = Editor.EDITOR_SEMANTIC_EXTERNAL_DIR;
			String pathname = delta.getString(key);
			if (pathname.isEmpty()) return choices;

			file = new File(pathname);

		} else {
			String key = Prefs.EDITOR_PREVIEW_INTERNAL_DIR;
			if (semantic) key = Editor.EDITOR_SEMANTIC_INTERNAL_DIR;
			String pathname = delta.getString(key);
			if (pathname.isEmpty()) return choices;

			try {
				file = new File(new URI(pathname));
			} catch (URISyntaxException e) {
				Log.error(this, "Invalid URI: " + pathname);
				return choices;
			}
		}

		if (!file.isDirectory()) return choices;

		for (String filename : file.list()) {
			if (filename.endsWith(Editor.DOT_CSS) || filename.endsWith(Editor.DOT_MIN_CSS)) {
				choices.put(filename, file.toURI().resolve(filename).toString());
			}
		}
		return choices;
	}
}
