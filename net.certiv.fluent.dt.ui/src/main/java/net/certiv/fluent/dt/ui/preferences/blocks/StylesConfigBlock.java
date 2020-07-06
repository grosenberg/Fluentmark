package net.certiv.fluent.dt.ui.preferences.blocks;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.ui.forms.widgets.FormToolkit;

import net.certiv.dsl.core.color.DslColorRegistry;
import net.certiv.dsl.core.log.Log;
import net.certiv.dsl.core.preferences.PrefsDeltaManager;
import net.certiv.dsl.core.preferences.consts.Editor;
import net.certiv.dsl.ui.preferences.bind.DirectorypathValidator;
import net.certiv.dsl.ui.preferences.blocks.AbstractConfigBlock;
import net.certiv.dsl.ui.preferences.pages.IDslPreferencePage;
import net.certiv.dsl.ui.util.SWTFactory;
import net.certiv.fluent.dt.core.preferences.Prefs;

public class StylesConfigBlock extends AbstractConfigBlock {

	private Composite stdComp;
	private Composite extComp;
	private Button stdEn;
	private Button extEn;
	private Combo smtCombo;

	private Composite prvComp;
	private Combo prvCombo;
	private Button prvEx;

	public StylesConfigBlock(IDslPreferencePage page, PrefsDeltaManager delta, FormToolkit formkit,
			DslColorRegistry reg) {
		super(page, delta, formkit, reg);
	}

	@Override
	protected List<String> createDeltaMatchKeys(List<String> keys) {
		keys.add(Editor.EDITOR_SEMANTIC_ENABLED);

		keys.add(Editor.EDITOR_SEMANTIC_FILE);
		keys.add(Editor.EDITOR_SEMANTIC_INTERNAL_DIR);
		keys.add(Editor.EDITOR_SEMANTIC_EXTERNAL_DIR);
		keys.add(Editor.EDITOR_SEMANTIC_EXTERNAL_ENABLE);
		keys.add(Editor.EDITOR_SEMANTIC_EXTERNAL_MAXDEPTH);
		keys.add(Editor.EDITOR_SEMANTIC_EXTERNAL_SENTINELS);

		keys.add(Prefs.EDITOR_PREVIEW_FILE);
		keys.add(Prefs.EDITOR_PREVIEW_INTERNAL_DIR);
		keys.add(Prefs.EDITOR_PREVIEW_EXTERNAL_DIR);
		keys.add(Prefs.EDITOR_PREVIEW_EXTERNAL_ENABLE);

		return keys;
	}

	@Override
	public Composite createContents(Composite parent) {
		Composite contents = super.createContents(parent);
		createSemanticStylesGroup(contents);
		createPreviewStylesGroup(contents);
		return contents;
	}

	protected Composite createSemanticStylesGroup(Composite parent) {
		Composite comp = SWTFactory.createGroupComposite(parent, 3, 2, "Semantic Editor Styles");
		stdEn = addCheckBox(comp, "Enable", Editor.EDITOR_SEMANTIC_ENABLED, 2, 4);

		stdComp = SWTFactory.createComposite(comp, 2, 2, 4);
		smtCombo = addLabeledCombo(stdComp, "Select", Editor.EDITOR_SEMANTIC_FILE);
		addSpace(stdComp, 1, 3);

		extEn = addCheckBox(stdComp, "External stylesheets", Editor.EDITOR_SEMANTIC_EXTERNAL_ENABLE, 2, 4);
		extComp = SWTFactory.createComposite(stdComp, 2, 2, 4);

		addDirectoryField(extComp, Editor.EDITOR_SEMANTIC_EXTERNAL_DIR, 2, 2, "Directory", 50,
				new DirectorypathValidator(null, true)).addModifyListener(e -> updateSemantics(true));
		addLabeledSpinner(extComp, "Max depth", Editor.EDITOR_SEMANTIC_EXTERNAL_MAXDEPTH, 2, 2, SWT.BORDER, 0, 9, 1)
				.addModifyListener(e -> updateSemantics(true));

		addCheckBox(stdComp, "Enable live watch & reload for external stylesheets",
				Editor.EDITOR_SEMANTIC_EXTERNAL_SENTINELS, 2, 4);

		stdEn.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				boolean en = stdEn.getSelection();
				enableControls(stdComp, en);
				boolean ex = extEn.getSelection();
				enableControls(extComp, en && ex);
				updateSemantics(ex);
			}
		});
		extEn.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				boolean ex = extEn.getSelection();
				enableControls(extComp, ex);
				updateSemantics(ex);
			}
		});

		initSemantics();
		return comp;
	}

	private void initSemantics() {
		boolean en = delta.getBoolean(Editor.EDITOR_SEMANTIC_ENABLED);
		boolean ex = delta.getBoolean(Editor.EDITOR_SEMANTIC_EXTERNAL_ENABLE);
		String exname = delta.getString(Editor.EDITOR_SEMANTIC_EXTERNAL_DIR);
		ex = ex && !exname.isEmpty();
		delta.setValue(Editor.EDITOR_SEMANTIC_EXTERNAL_ENABLE, ex);
		enableControls(stdComp, en);
		enableControls(extComp, en && ex);
		updateSemantics(ex);
	}

	private void updateSemantics(boolean ex) {
		String pathname = delta.getString(Editor.EDITOR_SEMANTIC_FILE);
		File f = new File(pathname);
		String filename = f.getName();
		updateCombo(smtCombo, choices(ex, true));

		int idx = smtCombo.indexOf(filename);
		if (idx < 0) idx = 0;
		smtCombo.select(idx);
	}

	protected Composite createPreviewStylesGroup(Composite parent) {
		Composite comp = SWTFactory.createGroupComposite(parent, 3, 2, "Preview & Export Styles");
		prvCombo = addLabeledCombo(comp, "Select", Prefs.EDITOR_PREVIEW_FILE);

		addSpace(comp, 1, 3);
		prvEx = addCheckBox(comp, "External stylesheets", Prefs.EDITOR_PREVIEW_EXTERNAL_ENABLE, 2, 4);
		prvEx.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				boolean ex = prvEx.getSelection();
				enableControls(prvComp, ex);
				updatePreview(ex);
			}
		});

		prvComp = SWTFactory.createComposite(comp, 2, 2, 4);
		addDirectoryField(prvComp, Prefs.EDITOR_PREVIEW_EXTERNAL_DIR, 2, 2, "Directory", 50,
				new DirectorypathValidator(null, true)).addModifyListener(e -> updatePreview(true));
		addLabeledSpinner(prvComp, "Max depth", Prefs.EDITOR_PREVIEW_MAXDEPTH, 2, 2, SWT.BORDER, 0, 9, 1)
				.addModifyListener(e -> updatePreview(true));

		initPreview();
		return comp;
	}

	private void initPreview() {
		boolean ex = delta.getBoolean(Prefs.EDITOR_PREVIEW_EXTERNAL_ENABLE);
		String exname = delta.getString(Prefs.EDITOR_PREVIEW_EXTERNAL_DIR);
		ex = ex && !exname.isEmpty();
		delta.setValue(Prefs.EDITOR_PREVIEW_EXTERNAL_ENABLE, ex);
		enableControls(prvComp, ex);
		updatePreview(ex);
	}

	private void updatePreview(boolean ex) {
		String choice = delta.getString(Prefs.EDITOR_PREVIEW_FILE);
		File f = new File(choice);
		choice = f.getName();

		updateCombo(prvCombo, choices(ex, false));

		int idx = prvCombo.indexOf(choice);
		if (idx < 0) idx = 0;
		prvCombo.select(idx);
	}

	private void enableControls(Composite comp, boolean enable) {
		for (Control control : comp.getChildren()) {
			if (control instanceof Combo) {
				((Combo) control).setEnabled(enable);
			} else if (control instanceof Spinner) {
				((Spinner) control).setEnabled(enable);
			} else if (control instanceof Composite) {
				enableControls((Composite) control, enable);
			} else {
				control.setEnabled(enable);
			}
		}
	}

	private Map<String, Object> choices(boolean external, boolean semantic) {
		// key=display name; value=pathname URI string
		Map<String, Object> nameMap = new LinkedHashMap<>();

		File file = null;
		if (external) {
			String key = Prefs.EDITOR_PREVIEW_EXTERNAL_DIR;
			if (semantic) key = Editor.EDITOR_SEMANTIC_EXTERNAL_DIR;
			String pathname = delta.getString(key);
			if (pathname.isEmpty()) return nameMap;

			file = new File(pathname);

		} else {
			String key = Prefs.EDITOR_PREVIEW_INTERNAL_DIR;
			if (semantic) key = Editor.EDITOR_SEMANTIC_INTERNAL_DIR;
			String pathname = delta.getString(key);
			if (pathname.isEmpty()) return nameMap;

			try {
				file = new File(new URI(pathname));
			} catch (URISyntaxException e) {
				Log.error(this, "Invalid URI: " + pathname);
				return nameMap;
			}
		}

		if (!file.isDirectory()) return nameMap;

		for (String filename : file.list()) {
			if (filename.endsWith(Editor.DOT_CSS) || filename.endsWith(Editor.DOT_MIN_CSS)) {
				nameMap.put(filename, file.toURI().resolve(filename).toString());
			}
		}
		return nameMap;
	}
}
