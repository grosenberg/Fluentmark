package net.certiv.fluent.dt.ui.preferences.blocks;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.widgets.FormToolkit;

import net.certiv.dsl.core.color.DslColorManager;
import net.certiv.dsl.core.log.Log;
import net.certiv.dsl.core.preferences.DslPrefsManagerDelta;
import net.certiv.dsl.core.util.Chars;
import net.certiv.dsl.ui.preferences.bind.DirectorypathValidator;
import net.certiv.dsl.ui.preferences.blocks.AbstractConfigBlock;
import net.certiv.dsl.ui.preferences.pages.IDslPreferencePage;
import net.certiv.dsl.ui.util.SWTFactory;
import net.certiv.fluent.dt.core.preferences.Prefs;
import net.certiv.fluent.dt.ui.editor.convert.HtmlGen;

public class StylesConfigBlock extends AbstractConfigBlock {

	private Composite extComp;
	private Combo combo;

	public StylesConfigBlock(IDslPreferencePage page, DslPrefsManagerDelta delta, FormToolkit formkit,
			DslColorManager colorMgr) {
		super(page, delta, formkit, colorMgr);
	}

	@Override
	protected List<String> createDeltaMatchKeys(List<String> keys) {
		keys.add(Prefs.EDITOR_SEMANTIC_ENABLED);
		keys.add(Prefs.EDITOR_SEMANTIC_STYLESHEET);

		keys.add(Prefs.EDITOR_SEMANTIC_INTERNAL_DIR);
		keys.add(Prefs.EDITOR_SEMANTIC_EXTERNAL_ENABLE);
		keys.add(Prefs.EDITOR_SEMANTIC_EXTERNAL_DIR);

		return keys;
	}

	@Override
	public Composite createContents(Composite parent) {
		Composite contents = super.createContents(parent);
		Composite comp = SWTFactory.createGroupComposite(contents, 1, 3, "Stylesheet Selection");
		addEditingControls(comp);

		return comp;
	}

	private void addEditingControls(Composite parent) {
		createStyleSheetsGroup(parent);
	}

	protected Composite createStyleSheetsGroup(Composite parent) {
		Composite comp = SWTFactory.createGroupComposite(parent, 3, 2, "Editor Semantic Styles");

		addCheckBox(comp, "Enable", Prefs.EDITOR_SEMANTIC_ENABLED, 2, 4);

		Map<String, Object> values = getValues();
		combo = addLabeledCombo(comp, "Select", Prefs.EDITOR_SEMANTIC_STYLESHEET, values);
		SWTFactory.createVerticalSpacer(comp, 1, 3);

		Button ex = addCheckBox(comp, "External stylesheets", Prefs.EDITOR_SEMANTIC_EXTERNAL_ENABLE, 2, 4);
		ex.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				adjustControls(ex.getSelection());
			}
		});

		extComp = SWTFactory.createComposite(comp, 2, 2, 4);
		addDirectoryField(extComp, Prefs.EDITOR_SEMANTIC_EXTERNAL_DIR, 2, 2, "Directory", 50,
				new DirectorypathValidator(null, true));

		adjustControls(ex.getSelection());
		return comp;
	}

	private void adjustControls(boolean external) {
		String choice = delta.getString(Prefs.EDITOR_SEMANTIC_STYLESHEET);
		enableControls(extComp, external);
		if (external) {
			updateCombo(combo, choices(Prefs.EDITOR_SEMANTIC_EXTERNAL_DIR));
		} else {
			updateCombo(combo, choices(Prefs.EDITOR_SEMANTIC_INTERNAL_DIR));
		}
		int idx = combo.indexOf(choice);
		if (idx > -1) combo.select(idx);
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

	private Map<String, Object> getValues() {
		boolean ext = delta.getBoolean(Prefs.EDITOR_SEMANTIC_EXTERNAL_ENABLE);
		Map<String, Object> values = ext ? choices(Prefs.EDITOR_SEMANTIC_EXTERNAL_DIR)
				: choices(Prefs.EDITOR_SEMANTIC_INTERNAL_DIR);
		return values;
	}

	private Map<String, Object> choices(String key) {
		Map<String, Object> map = new HashMap<>();
		final File root = dir(delta.bind(key));
		if (root == null || !root.isDirectory()) return map;

		for (String filename : root.list()) {
			if (filename.endsWith(Chars.DOT + HtmlGen.CSS) && !filename.endsWith(Chars.DOT + HtmlGen.MIN_CSS)) {
				map.put(filename, root.toURI().resolve(filename).toString());
			}
		}
		return map;
	}

	private File dir(String key) {
		String dir = delta.getString(key);
		if (dir.isEmpty()) return null;

		try {
			URI uri = new URI(dir);
			return new File(uri);
		} catch (URISyntaxException e) {
			Log.error(this, "Invalid URI: " + dir);
			return null;
		}
	}
}
