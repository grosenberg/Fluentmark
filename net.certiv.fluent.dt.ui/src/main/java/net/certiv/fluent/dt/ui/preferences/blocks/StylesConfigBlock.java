package net.certiv.fluent.dt.ui.preferences.blocks;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

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
import net.certiv.dsl.core.util.Strings;
import net.certiv.dsl.ui.preferences.bind.DirectorypathValidator;
import net.certiv.dsl.ui.preferences.blocks.AbstractConfigBlock;
import net.certiv.dsl.ui.preferences.pages.IDslPreferencePage;
import net.certiv.dsl.ui.util.SWTFactory;
import net.certiv.fluent.dt.core.preferences.Prefs;
import net.certiv.fluent.dt.ui.editor.convert.HtmlGen;

public class StylesConfigBlock extends AbstractConfigBlock {

	private static final String[][] EMPTY = { { "<empty/>", "" } };

	private Composite extComp;
	private Combo combo;

	public StylesConfigBlock(IDslPreferencePage page, DslPrefsManagerDelta delta, FormToolkit formkit,
			DslColorManager colorMgr) {
		super(page, delta, formkit, colorMgr);
	}

	@Override
	protected List<String> createDeltaMatchKeys(List<String> keys) {

		keys.add(Prefs.EDITOR_CSS_EXTERNAL_ENABLE);
		keys.add(Prefs.EDITOR_CSS_INTERNAL_DIR);
		keys.add(Prefs.EDITOR_CSS_EXTERNAL_DIR);

		return keys;
	}

	@Override
	public Composite createContents(Composite parent) {
		Composite contents = super.createContents(parent);

		Composite comp = SWTFactory.createGroupComposite(contents, 1, 3, "Stylesheet Selection");

		boolean ext = delta.getBoolean(Prefs.EDITOR_CSS_EXTERNAL_ENABLE);
		String[][] values = ext ? values(Prefs.EDITOR_CSS_EXTERNAL_DIR) : values(Prefs.EDITOR_CSS_INTERNAL_DIR);

		combo = addLabeledCombo(comp, "Select", Prefs.EDITOR_CSS_FILE, values, false);
		SWTFactory.createVerticalSpacer(comp, 1, 3);

		Button en = addCheckBox(comp, "Use external stylesheets", Prefs.EDITOR_CSS_EXTERNAL_ENABLE, 2, 4);
		en.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				adjustControls(en.getSelection());
			}
		});

		extComp = SWTFactory.createComposite(comp, 2, 2, 4);
		addDirectoryField(extComp, Prefs.EDITOR_CSS_EXTERNAL_DIR, 2, 2, "Directory", 50,
				new DirectorypathValidator(null, true));

		adjustControls(en.getSelection());
		return contents;
	}

	private void adjustControls(boolean external) {
		String choice = delta.getString(Prefs.EDITOR_CSS_FILE);
		enableControls(extComp, external);
		if (external) {
			updateComboModel(combo, values(Prefs.EDITOR_CSS_EXTERNAL_DIR));
		} else {
			updateComboModel(combo, values(Prefs.EDITOR_CSS_INTERNAL_DIR));
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

	private String[][] values(String key) {
		final File dir = dir(key);
		if (dir == null || !dir.isDirectory()) {
			return EMPTY;
		}

		String[] files = dir.list();
		String[][] values = Arrays.stream(files)
				.filter(e -> e.endsWith(Strings.DOT + HtmlGen.CSS) && !e.endsWith(Strings.DOT + HtmlGen.MIN_CSS))
				.map(e -> new String[] { e, dir.toURI().resolve(e).toString() }) //
				.toArray(String[][]::new);

		return values;
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
