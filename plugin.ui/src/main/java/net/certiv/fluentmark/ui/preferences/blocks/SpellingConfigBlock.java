/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.ui.preferences.blocks;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.variables.IStringVariableManager;
import org.eclipse.core.variables.VariablesPlugin;
import org.eclipse.debug.ui.StringVariableSelectionDialog;
import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.preference.PreferenceStore;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.ide.dialogs.EncodingFieldEditor;

import net.certiv.dsl.core.color.DslColorManager;
import net.certiv.dsl.core.preferences.DslPrefsManagerDelta;
import net.certiv.dsl.ui.dialogs.StatusUtil;
import net.certiv.dsl.ui.preferences.ScrolledPageContent;
import net.certiv.dsl.ui.preferences.blocks.AbstractConfigBlock;
import net.certiv.dsl.ui.preferences.pages.IDslPreferencePage;
import net.certiv.dsl.ui.util.SWTFactory;
import net.certiv.dsl.ui.util.SWTUtil;
import net.certiv.fluentmark.core.preferences.Prefs;
import net.certiv.fluentmark.core.preferences.PrefsSpelling;
import net.certiv.spellchecker.SpellCheckEngine;
import net.certiv.spellchecker.etc.IStatusChangeListener;
import net.certiv.spellchecker.etc.StatusInfo;
import net.certiv.spellchecker.preferences.PreferencesMessages;

public class SpellingConfigBlock extends AbstractConfigBlock {

	/** The value for no platform dictionary. */
	private static final String VALUE_NO_LOCALE = ""; //$NON-NLS-1$

	private Composite options;

	private Text fDictionaryPath;
	private Combo localeCombo;
	private IStatus fFileStatus = new StatusInfo();

	private EncodingFieldEditor encEditor;
	private Composite fEncodingEditorParent;
	private IStatus fThresholdStatus = new StatusInfo();
	private IStatus fEncodingFieldEditorStatus = new StatusInfo();
	public IStatusChangeListener context;

	protected static class ControlData {

		private final String fKey;
		private final String[] fValues;

		public ControlData(String key, String[] values) {
			fKey = key;
			fValues = values;
		}

		public String getKey() {
			return fKey;
		}

		public String getValue(boolean selection) {
			int index = selection ? 0 : 1;
			return fValues[index];
		}

		public String getValue(int index) {
			return fValues[index];
		}

		public int getSelection(String value) {
			if (value != null) {
				for (int i = 0; i < fValues.length; i++) {
					if (value.equals(fValues[i])) return i;
				}
			}
			return fValues.length - 1; // assume the last option is the least severe
		}
	}

	public SpellingConfigBlock(IDslPreferencePage page, DslPrefsManagerDelta delta, FormToolkit formkit,
			DslColorManager colorMgr, IStatusChangeListener context) {

		super(page, delta, formkit, colorMgr);
		this.context = context;
	}

	@Override
	protected List<String> createDeltaMatchKeys(List<String> keys) {
		keys.add(Prefs.SPELLING_ENABLED);

		keys.add(PrefsSpelling.SPELLING_IGNORE_DIGITS);
		keys.add(PrefsSpelling.SPELLING_IGNORE_MIXED);
		keys.add(PrefsSpelling.SPELLING_IGNORE_SENTENCE);
		keys.add(PrefsSpelling.SPELLING_IGNORE_UPPER);
		keys.add(PrefsSpelling.SPELLING_IGNORE_SINGLE_LETTERS);
		keys.add(PrefsSpelling.SPELLING_IGNORE_NON_LETTERS);
		keys.add(PrefsSpelling.SPELLING_IGNORE_URLS);

		keys.add(Prefs.SPELLING_ENGINE);

		keys.add(PrefsSpelling.SPELLING_LOCALE);
		keys.add(PrefsSpelling.SPELLING_PROPOSAL_THRESHOLD);
		keys.add(PrefsSpelling.SPELLING_PROBLEMS_THRESHOLD);
		keys.add(PrefsSpelling.SPELLING_USER_DICTIONARY);
		keys.add(PrefsSpelling.SPELLING_USER_DICTIONARY_ENCODING);

		keys.add(PrefsSpelling.SPELLING_ENABLE_CONTENTASSIST);

		return keys;
	}

	/**
	 * Creates page for preferences.
	 *
	 * @param parent the parent composite
	 * @return the control for the preference page
	 */
	@Override
	public Composite createContents(Composite parent) {
		super.createContents(parent);

		ScrolledPageContent scrolled = new ScrolledPageContent(formkit, parent, SWT.H_SCROLL | SWT.V_SCROLL);
		scrolled.setExpandHorizontal(true);
		scrolled.setExpandVertical(true);

		Control control = createContent(scrolled);

		scrolled.setContent(control);
		final Point size = control.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		scrolled.setMinSize(size.x, size.y);
		return scrolled;
	}

	@Override
	public void performDefaults() {
		super.performDefaults();
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	private Control createContent(final Composite parent) {
		Composite base = SWTFactory.createComposite(parent, 1, 1);
		addCheckBox(base, "Enable FluentMark spell checker", Prefs.SPELLING_ENABLED, 2);

		options = SWTFactory.makeGroup(base, "Options", 1);
		addCheckBox(options, "Ignore digits", PrefsSpelling.SPELLING_IGNORE_DIGITS, 2);
		addCheckBox(options, "Ignore mixed case words", PrefsSpelling.SPELLING_IGNORE_MIXED, 2);
		addCheckBox(options, "Ignore sentence capitalization", PrefsSpelling.SPELLING_IGNORE_SENTENCE, 2);
		addCheckBox(options, "Ignore upper case words", PrefsSpelling.SPELLING_IGNORE_UPPER, 2);
		addCheckBox(options, "Ignore single letters", PrefsSpelling.SPELLING_IGNORE_SINGLE_LETTERS, 2);
		addCheckBox(options, "Ignore non-letters at word boundaries", PrefsSpelling.SPELLING_IGNORE_NON_LETTERS, 2);
		addCheckBox(options, "Ignore internet addresses/URLs", PrefsSpelling.SPELLING_IGNORE_URLS, 2);

		addFiller(options, 4);

		dictBrowseControl(options, "User dictionary", 4, PrefsSpelling.SPELLING_USER_DICTIONARY);

		Composite encoding = SWTFactory.makeGroup(options, "Encoding", 3);
		encodingControl(encoding, "");

		Composite advanced = SWTFactory.makeGroup(options, "Advanced", 3);
		addLabeledTextField(advanced, "Spelling proposal threshhold", PrefsSpelling.SPELLING_PROPOSAL_THRESHOLD, 20, 3,
				true);
		addLabeledTextField(advanced, "Spelling problems threshhold", PrefsSpelling.SPELLING_PROBLEMS_THRESHOLD, 20, 3,
				true);

		advanced.layout();
		options.layout();
		return base;
	}

	private void addFiller(Composite parent, int horizontalSpan) {
		Label filler = new Label(parent, SWT.LEFT);
		GridData gd = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		gd.horizontalSpan = horizontalSpan;
		gd.heightHint = convertHeightInCharsToPixels(1) / 2;
		filler.setLayoutData(gd);
	}

	private void dictBrowseControl(Composite parent, String string, int span, String pref) {
		final Set<Locale> locales = SpellCheckEngine.getLocalesWithInstalledDictionaries();
		boolean hasPlaformDictionaries = locales.size() > 0;

		final Group group = new Group(parent, SWT.NONE);
		if (hasPlaformDictionaries) {
			group.setText(PreferencesMessages.SpellingPreferencePage_group_dictionaries);
		} else {
			group.setText(PreferencesMessages.SpellingPreferencePage_group_dictionary);
		}
		group.setLayout(new GridLayout(4, false));
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		String label;
		if (hasPlaformDictionaries) {
			label = PreferencesMessages.SpellingPreferencePage_dictionary_label;
			localeCombo = addLocaleBox(group, label, PrefsSpelling.SPELLING_LOCALE, getDictionaryCodes(locales),
					getDictionaryLabels(locales), 0);
			localeCombo.setEnabled(locales.size() > 0);
			new Label(group, SWT.NONE); // placeholder
		}

		label = PreferencesMessages.SpellingPreferencePage_workspace_dictionary_label;
		fDictionaryPath = addLabeledTextField(group, label, PrefsSpelling.SPELLING_USER_DICTIONARY, 0, 0, false);

		GridData gd = (GridData) fDictionaryPath.getLayoutData();
		gd.grabExcessHorizontalSpace = true;
		gd.widthHint = convertWidthInCharsToPixels(40);

		Composite buttons = new Composite(group, SWT.NONE);
		buttons.setLayout(new GridLayout(2, true));
		buttons.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_END));

		Button button = new Button(buttons, SWT.PUSH);
		button.setText(PreferencesMessages.SpellingPreferencePage_browse_label);
		button.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(final SelectionEvent event) {
				handleBrowseButtonSelected();
			}
		});
		SWTUtil.setButtonDimensionHint(button);
		button.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));

		button = new Button(buttons, SWT.PUSH);
		button.setText(PreferencesMessages.SpellingPreferencePage_variables);
		button.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				handleVariablesButtonSelected();
			}

		});
		SWTUtil.setButtonDimensionHint(button);
		button.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));
	}

	/**
	 * Handles selections of the browse button.
	 */
	protected void handleBrowseButtonSelected() {
		final FileDialog dialog = new FileDialog(fDictionaryPath.getShell(), SWT.OPEN);
		dialog.setText(PreferencesMessages.SpellingPreferencePage_filedialog_title);
		dialog.setFilterPath(fDictionaryPath.getText());

		final String path = dialog.open();
		if (path != null) fDictionaryPath.setText(path);
	}

	protected void handleVariablesButtonSelected() {
		StringVariableSelectionDialog dialog = new StringVariableSelectionDialog(fDictionaryPath.getShell());
		if (dialog.open() == Window.OK)
			fDictionaryPath.setText(fDictionaryPath.getText() + dialog.getVariableExpression());
	}

	/**
	 * Returns the locale codes for the locale list.
	 *
	 * @param locales The list of locales
	 * @return Array of locale codes for the list
	 */
	protected static String[] getDictionaryCodes(final Set<Locale> locales) {
		int index = 0;
		Locale locale = null;
		final String[] codes = new String[locales.size() + 1];
		for (final Iterator<Locale> iterator = locales.iterator(); iterator.hasNext();) {
			locale = iterator.next();
			codes[index++] = locale.toString();
		}
		codes[index++] = VALUE_NO_LOCALE;
		return codes;
	}

	/**
	 * Returns the display labels for the locale list.
	 *
	 * @param locales The list of locales
	 * @return Array of display labels for the list
	 */
	protected static String[] getDictionaryLabels(final Set<Locale> locales) {
		int index = 0;
		Locale locale = null;
		final String[] labels = new String[locales.size() + 1];
		for (final Iterator<Locale> iterator = locales.iterator(); iterator.hasNext();) {
			locale = iterator.next();
			labels[index++] = locale.getDisplayName();
		}
		labels[index++] = PreferencesMessages.SpellingPreferencePage_dictionary_none;
		return labels;
	}

	protected Combo addLocaleBox(Composite parent, String label, String key, String[] values, String[] valueLabels,
			int indent) {

		ControlData data = new ControlData(key, values);
		Combo combo = addComboBox(parent, label, key, values, valueLabels, indent, false);
		combo.setData(data);

		String currValue = getDelta().getString(key);
		Locale locale = SpellCheckEngine.convertToLocale(currValue);
		locale = SpellCheckEngine.findClosestLocale(locale);
		if (locale != null) currValue = locale.toString();
		combo.select(data.getSelection(currValue));
		return combo;
	}

	@Override
	protected void comboFieldChanged(Combo combo, Object oData) {
		if (combo == localeCombo) {
			ControlData data = (ControlData) oData;
			String value = data.getValue(combo.getSelectionIndex());
			Locale locale = SpellCheckEngine.convertToLocale(value);
			locale = SpellCheckEngine.findClosestLocale(locale);
			if (locale != null) value = locale.toString();
			getDelta().setValue(data.getKey(), value);
		}
	}

	/**
	 * Creates the encoding field editor.
	 *
	 * @param composite the parent composite
	 * @param string list with all controls
	 */
	private void encodingControl(Composite composite, String text) {

		Label label = new Label(composite, SWT.NONE);
		label.setText(text);
		label.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));

		fEncodingEditorParent = new Composite(composite, SWT.NONE);
		GridLayout layout = new GridLayout(2, false);
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		fEncodingEditorParent.setLayout(layout);
		GridData gd = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		gd.horizontalSpan = 3;
		gd.horizontalIndent += SWTUtil.getIndent();
		fEncodingEditorParent.setLayoutData(gd);

		encEditor = new EncodingFieldEditor(PrefsSpelling.SPELLING_USER_DICTIONARY_ENCODING, "", null,
				fEncodingEditorParent); // $NON-NLS-1$

		PreferenceStore store = new PreferenceStore();
		String defaultEncoding = ResourcesPlugin.getEncoding();
		store.setDefault(PrefsSpelling.SPELLING_USER_DICTIONARY_ENCODING, defaultEncoding);
		String encoding = store.getString(PrefsSpelling.SPELLING_USER_DICTIONARY_ENCODING);
		if (encoding != null && encoding.length() > 0)
			store.setValue(PrefsSpelling.SPELLING_USER_DICTIONARY_ENCODING, encoding);

		encEditor.setPreferenceStore(store);

		// Redirect status messages from the field editor to the status change listener
		DialogPage fakePage = new DialogPage() {

			@Override
			public void createControl(Composite c) {}

			@Override
			public void setErrorMessage(String newMessage) {
				StatusInfo status = new StatusInfo();
				if (newMessage != null) status.setError(newMessage);
				fEncodingFieldEditorStatus = status;
				context.statusChanged(StatusUtil
						.getMostSevere(new IStatus[] { fThresholdStatus, fFileStatus, fEncodingFieldEditorStatus }));
			}
		};
		encEditor.setPage(fakePage);
		encEditor.load();
		if (encoding == null || encoding.equals(defaultEncoding) || encoding.length() == 0) {
			encEditor.loadDefault();
		}
	}

	@Override
	protected IStatus validateSettings(final String key, final String oldValue, final String newValue) {
		if (key == null || PrefsSpelling.SPELLING_PROPOSAL_THRESHOLD.equals(key)) {
			fThresholdStatus = SWTUtil.validatePositiveNumber(newValue);
		} else {
			fThresholdStatus = new StatusInfo();
		}
		if (key == null || PrefsSpelling.SPELLING_PROBLEMS_THRESHOLD.equals(key)) {
			IStatus status = SWTUtil.validatePositiveNumber(newValue);
			fThresholdStatus = StatusUtil.getMostSevere(new IStatus[] { fThresholdStatus, status });
		}
		if (key == null || PrefsSpelling.SPELLING_USER_DICTIONARY.equals(key)) {
			fFileStatus = validateAbsoluteFilePath(newValue);
		}

		IStatus status = StatusUtil
				.getMostSevere(new IStatus[] { fThresholdStatus, fFileStatus, fEncodingFieldEditorStatus });
		context.statusChanged(status);

		if (Prefs.SPELLING_ENABLED.equals(key)) {
			setEnabled(options, Boolean.valueOf(newValue));
		}
		return status;
	}

	private void setEnabled(Control control, boolean enabled) {
		if (control instanceof Composite) {
			Control[] children = ((Composite) control).getChildren();
			for (Control child : children)
				setEnabled(child, enabled);
		}
		control.setEnabled(enabled);
	}

	/**
	 * Validates that the file with the specified absolute path exists and can be opened.
	 *
	 * @param path The path of the file to validate
	 * @return a status without error if the path is valid
	 */
	protected static IStatus validateAbsoluteFilePath(String path) {
		final StatusInfo status = new StatusInfo();
		IStringVariableManager variableManager = VariablesPlugin.getDefault().getStringVariableManager();
		try {
			path = variableManager.performStringSubstitution(path);
			if (path.length() > 0) {

				final File file = new File(path);
				if (!file.exists() && (!file.isAbsolute() || !file.getParentFile().canWrite()))
					status.setError(PreferencesMessages.SpellingPreferencePage_dictionary_error);
				else if (file.exists() && (!file.isFile() || !file.isAbsolute() || !file.canRead() || !file.canWrite()))
					status.setError(PreferencesMessages.SpellingPreferencePage_dictionary_error);
			}
		} catch (CoreException e) {
			status.setError(e.getLocalizedMessage());
		}
		return status;
	}
}
