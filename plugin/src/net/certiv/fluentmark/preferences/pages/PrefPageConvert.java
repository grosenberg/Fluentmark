/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.preferences.pages;

import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.IPreferencePageContainer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;

import net.certiv.fluentmark.FluentMkUI;
import net.certiv.fluentmark.preferences.BaseFieldEditorPreferencePage;
import net.certiv.fluentmark.preferences.Prefs;
import net.certiv.fluentmark.preferences.SwtUtil;
import net.certiv.fluentmark.preferences.editors.ConverterSelectFieldEditor;

public class PrefPageConvert extends BaseFieldEditorPreferencePage implements Prefs {

	private static final String[][] converters = new String[][] {  //
			{ "BlackFriday", KEY_BLACKFRIDAY }, //
			{ "Commonmark", KEY_COMMONMARK },  //
			{ "MarkdownJ", KEY_MARDOWNJ },  //
			{ "Pandoc", KEY_PANDOC }, //
			{ "PegDown", KEY_PEGDOWN },  //
			{ "TxtMark", KEY_TXTMARK },  //
			{ "External converter", KEY_EXTERNAL }, //
	};

	private Composite base;
	private Composite stack;
	private StackLayout stackSel;
	private String selectedKey;

	private ConverterSelectFieldEditor combo;
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

	public void init(IWorkbench workbench) {
		setPreferenceStore(FluentMkUI.getDefault().getPreferenceStore());
	}

	/** Create fields controlling converter selection */
	@Override
	public void createFieldEditors() {
		Composite parent = getFieldEditorParent();
		base = SwtUtil.makeGroupComposite(parent, 3, 1, "Conversion filter selection");

		// Converter selection
		combo = new ConverterSelectFieldEditor(EDITOR_MD_CONVERTER, "Converter:", converters, base);
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

		// Converter option selection
		updateOptionsBlock(stack, getPreferenceStore().getString(EDITOR_MD_CONVERTER));
	}

	public boolean isSelected(String target) {
		return selectedKey.equals(target);
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		updateOptionsBlock(stack, combo.getValue());
		validateSettings();
		super.propertyChange(event);
	}

	private void updateOptionsBlock(Composite stack, String key) {
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

	private void validateSettings() {
		setErrorMessage(null);
		setMessage(null);

		pandoc.validateSettings();
		bfriday.validateSettings();
		txtmark.validateSettings();
		external.validateSettings();
		other.validateSettings();
		dotgen.validateSettings();
	}

	@Override
	protected void adjustSubLayout() {}

	// ----------------------------------------------------------------
	// Delegation methods

	public void addField(FieldEditor editor) {
		super.addField(editor);
	}

	@Override
	public Point computeSize() {
		return super.computeSize();
	}

	@Override
	protected void contributeButtons(Composite parent) {
		super.contributeButtons(parent);
	}

	@Override
	protected void applyDialogFont(Composite composite) {
		super.applyDialogFont(composite);
	}

	@Override
	protected Label createDescriptionLabel(Composite parent) {
		return super.createDescriptionLabel(parent);
	}

	@Override
	protected Point doComputeSize() {
		return super.doComputeSize();
	}

	@Override
	protected IPreferenceStore doGetPreferenceStore() {
		return super.doGetPreferenceStore();
	}

	@Override
	public IPreferencePageContainer getContainer() {
		return super.getContainer();
	}

	@Override
	public IPreferenceStore getPreferenceStore() {
		return super.getPreferenceStore();
	}

	@Override
	public boolean isValid() {
		return super.isValid();
	}

	@Override
	protected void noDefaultAndApplyButton() {
		super.noDefaultAndApplyButton();
	}

	@Override
	protected void noDefaultButton() {
		super.noDefaultButton();
	}

	@Override
	public boolean okToLeave() {
		return super.okToLeave();
	}

	@Override
	protected void performApply() {
		super.performApply();
	}

	@Override
	public boolean performCancel() {
		return super.performCancel();
	}

	@Override
	public void setContainer(IPreferencePageContainer container) {
		super.setContainer(container);
	}

	@Override
	public void setPreferenceStore(IPreferenceStore store) {
		super.setPreferenceStore(store);
	}

	@Override
	public void setSize(Point uiSize) {
		super.setSize(uiSize);
	}

	@Override
	public void setTitle(String title) {
		super.setTitle(title);
	}

	@Override
	public void setValid(boolean b) {
		super.setValid(b);
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	protected void updateApplyButton() {
		super.updateApplyButton();
	}

	@Override
	protected Composite createNoteComposite(Font font, Composite composite, String title, String message) {
		return super.createNoteComposite(font, composite, title, message);
	}

	@Override
	protected Button getApplyButton() {
		return super.getApplyButton();
	}

	@Override
	protected Button getDefaultsButton() {
		return super.getDefaultsButton();
	}

	@Override
	public void performHelp() {
		super.performHelp();
	}

	@Override
	public void applyData(Object data) {
		super.applyData(data);
	}

	@Override
	public void setErrorMessage(String newMessage) {
		super.setErrorMessage(newMessage);
	}

	@Override
	public void setMessage(String newMessage, int newType) {
		super.setMessage(newMessage, newType);
	}
}
