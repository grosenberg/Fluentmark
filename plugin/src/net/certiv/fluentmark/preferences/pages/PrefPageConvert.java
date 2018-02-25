/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.preferences.pages;

import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;

import net.certiv.fluentmark.FluentUI;
import net.certiv.fluentmark.preferences.BaseFieldEditorPreferencePage;
import net.certiv.fluentmark.preferences.Prefs;
import net.certiv.fluentmark.preferences.editors.ComboSelectFieldEditor;
import net.certiv.fluentmark.util.SwtUtil;

public class PrefPageConvert extends BaseFieldEditorPreferencePage implements Prefs {

	private static final String[][] converters = new String[][] { //
			{ "BlackFriday", KEY_BLACKFRIDAY }, //
			{ "Commonmark", KEY_COMMONMARK }, //
			{ "MarkdownJ", KEY_MARDOWNJ }, //
			{ "Pandoc", KEY_PANDOC }, //
			{ "PegDown", KEY_PEGDOWN }, //
			{ "TxtMark", KEY_TXTMARK }, //
			{ "External converter", KEY_EXTERNAL }, //
	};

	private Composite base;
	private Composite stack;
	private StackLayout stackSel;
	private String selectedKey;

	private ComboSelectFieldEditor combo;
	private ConverterPandocOps pandoc;
	private ConverterBlackFridayOps bfriday;
	private ConverterTxtmarkOps txtmark;
	private ConverterExternalOps external;
	private ConverterNullOps other;

	private ConverterDotOps dotgen;

	public PrefPageConvert() {
		super(GRID);
		setDescription("");
	}

	@Override
	public void init(IWorkbench workbench) {
		setPreferenceStore(FluentUI.getDefault().getPreferenceStore());
	}

	/** Create fields controlling converter selection */
	@Override
	public void createFieldEditors() {
		Composite parent = getFieldEditorParent();
		base = SwtUtil.makeGroupComposite(parent, 3, 1, "Conversion filter selection");

		// Converter selection
		combo = new ComboSelectFieldEditor(EDITOR_MD_CONVERTER, "Converter:", converters, base);
		addField(combo);

		stack = SwtUtil.makeCompositeStack(parent, 3, 1);
		stackSel = (StackLayout) stack.getLayout();

		// stacked options
		pandoc = new ConverterPandocOps(this, stack, "Pandoc Options");
		bfriday = new ConverterBlackFridayOps(this, stack, "BlackFriday Options");
		txtmark = new ConverterTxtmarkOps(this, stack, "TxtMark Options");
		external = new ConverterExternalOps(this, stack, "External Options");
		other = new ConverterNullOps(this, stack, "Default Options");

		// rest
		dotgen = new ConverterDotOps(this, parent, "Graphviz Options");

		// init converter option selection
		updateConverter(stack, getPreferenceStore().getString(EDITOR_MD_CONVERTER));
	}

	@Override
	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);
		validateSettings(getPreferenceStore().getString(EDITOR_MD_CONVERTER));
		return contents;
	}

	public boolean isSelected(String target) {
		return selectedKey.equals(target);
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		if (event.getSource() == combo && !event.getNewValue().equals(event.getOldValue())) {
			String key = combo.getKey();
			updateConverter(stack, key);
			validateSettings(key);
		}
		super.propertyChange(event);
	}

	private void updateConverter(Composite stack, String key) {
		this.selectedKey = key;

		switch (key) {
			case KEY_PANDOC:
				stackSel.topControl = pandoc.getFrame();
				dotgen.setVisible(true);
				break;

			case KEY_BLACKFRIDAY:
				stackSel.topControl = bfriday.getFrame();
				dotgen.setVisible(true);
				break;

			case KEY_TXTMARK:
				stackSel.topControl = txtmark.getFrame();
				dotgen.setVisible(true);
				break;

			case KEY_EXTERNAL:
				stackSel.topControl = external.getFrame();
				dotgen.setVisible(false);
				break;

			default:
				stackSel.topControl = other.getFrame();
				dotgen.setVisible(false);
				break;
		}
		stack.layout();
	}

	private void validateSettings(String key) {
		setErrorMessage(null);
		setMessage(null);

		switch (key) {
			case KEY_PANDOC:
				pandoc.validateSettings();
				dotgen.validateSettings();
				break;

			case KEY_BLACKFRIDAY:
				bfriday.validateSettings();
				dotgen.validateSettings();
				break;

			case KEY_TXTMARK:
				txtmark.validateSettings();
				break;

			case KEY_EXTERNAL:
				external.validateSettings();
				break;

			default:
				other.validateSettings();
				break;
		}
	}

	@Override
	protected void adjustSubLayout() {}

	@Override
	public void addField(FieldEditor editor) {
		super.addField(editor);
	}
}
