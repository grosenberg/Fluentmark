/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.preferences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.layout.PixelConverter;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.widgets.ExpandableComposite;

import net.certiv.fluentmark.editor.StatusInfo;
import net.certiv.fluentmark.editor.StatusUtil;
import net.certiv.fluentmark.util.SwtUtil;

public abstract class AbstractConfigurationBlock implements IPreferenceConfigurationBlock {

	/**
	 * Use as follows:
	 *
	 * <pre>
	 * SectionManager manager= new SectionManager();
	 * Composite composite= manager.createSectionComposite(parent);
	 *
	 * Composite xSection= manager.createSection("section X"));
	 * xSection.setLayout(new FillLayout());
	 * new Button(xSection, SWT.PUSH); // add controls to section..
	 *
	 * [...]
	 *
	 * return composite; // return main composite
	 * </pre>
	 */
	protected final class SectionManager {

		/** The preference setting for keeping no section open. */
		private static final String __NONE = "__none"; //$NON-NLS-1$
		private Set<ExpandableComposite> fSections = new HashSet<>();
		private boolean fIsBeingManaged = false;
		private ExpansionAdapter fListener = new ExpansionAdapter() {

			@Override
			public void expansionStateChanged(ExpansionEvent e) {
				ExpandableComposite source = (ExpandableComposite) e.getSource();
				updateSectionStyle(source);
				if (fIsBeingManaged) return;
				if (e.getState()) {
					try {
						fIsBeingManaged = true;
						for (Iterator<ExpandableComposite> iter = fSections.iterator(); iter.hasNext();) {
							ExpandableComposite composite = iter.next();
							if (composite != source) composite.setExpanded(false);
						}
					} finally {
						fIsBeingManaged = false;
					}
					if (fLastOpenKey != null && fDialogSettingsStore != null)
						fDialogSettingsStore.setValue(fLastOpenKey, source.getText());
				} else {
					if (!fIsBeingManaged && fLastOpenKey != null && fDialogSettingsStore != null)
						fDialogSettingsStore.setValue(fLastOpenKey, __NONE);
				}
				ExpandableComposite exComp = getParentExpandableComposite(source);
				if (exComp != null) exComp.layout(true, true);
				ScrolledPageContent parentScrolledComposite = getParentScrolledComposite(source);
				if (parentScrolledComposite != null) {
					parentScrolledComposite.reflow(true);
				}
			}
		};
		private Composite fBody;
		private final String fLastOpenKey;
		private final IPreferenceStore fDialogSettingsStore;
		private ExpandableComposite fFirstChild = null;

		/**
		 * Creates a new section manager.
		 */
		public SectionManager() {
			this(null, null);
		}

		/**
		 * Creates a new section manager.
		 * 
		 * @param dialogSettingsStore the dialog store
		 * @param lastOpenKey the preference key
		 */
		public SectionManager(IPreferenceStore dialogSettingsStore, String lastOpenKey) {
			fDialogSettingsStore = dialogSettingsStore;
			fLastOpenKey = lastOpenKey;
		}

		private void manage(ExpandableComposite section) {
			if (section == null) throw new NullPointerException();
			if (fSections.add(section)) section.addExpansionListener(fListener);
			makeScrollableCompositeAware(section);
		}

		/**
		 * Creates a new composite that can contain a set of expandable sections. A
		 * <code>ScrolledPageComposite</code> is created and a new composite within that, to ensure
		 * that expanding the sections will always have enough space, unless there already is a
		 * <code>ScrolledComposite</code> along the parent chain of <code>parent</code>, in which
		 * case a normal <code>Composite</code> is created.
		 * <p>
		 * The receiver keeps a reference to the inner body composite, so that new sections can be
		 * added via <code>createSection</code>.
		 * </p>
		 *
		 * @param parent the parent composite
		 * @return the newly created composite
		 */
		public Composite createSectionComposite(Composite parent) {
			Assert.isTrue(fBody == null);
			boolean isNested = isNestedInScrolledComposite(parent);
			Composite composite;
			if (isNested) {
				composite = new Composite(parent, SWT.NONE);
				fBody = composite;
			} else {
				composite = new ScrolledPageContent(parent);
				fBody = ((ScrolledPageContent) composite).getBody();
			}

			fBody.setLayout(new GridLayout());

			return composite;
		}

		/**
		 * Creates an expandable section within the parent created previously by calling
		 * <code>createSectionComposite</code>. Controls can be added directly to the returned
		 * composite, which has no layout initially.
		 *
		 * @param label the display name of the section
		 * @return a composite within the expandable section
		 */
		public Composite createSection(String label) {
			Assert.isNotNull(fBody);
			final ExpandableComposite excomposite = new ExpandableComposite(fBody, SWT.NONE,
					ExpandableComposite.TWISTIE | ExpandableComposite.CLIENT_INDENT | ExpandableComposite.COMPACT);
			if (fFirstChild == null) fFirstChild = excomposite;
			excomposite.setText(label);
			String last = null;
			if (fLastOpenKey != null && fDialogSettingsStore != null)
				last = fDialogSettingsStore.getString(fLastOpenKey);

			if (fFirstChild == excomposite && !__NONE.equals(last) || label.equals(last)) {
				excomposite.setExpanded(true);
				if (fFirstChild != excomposite) fFirstChild.setExpanded(false);
			} else {
				excomposite.setExpanded(false);
			}
			excomposite.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true, false));

			updateSectionStyle(excomposite);
			manage(excomposite);

			Composite contents = new Composite(excomposite, SWT.NONE);
			excomposite.setClient(contents);

			return contents;
		}
	}

	protected static final int INDENT = 20;
	private OverlayPreferenceStore fStore;
	private FontMetrics fFontMetrics;

	private Map<Button, String> fCheckBoxes = new HashMap<>();
	private SelectionListener fCheckBoxListener = new SelectionListener() {

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {}

		@Override
		public void widgetSelected(SelectionEvent e) {
			buttonChanged((Button) e.widget);
		}
	};

	private Map<Text, String> fTextFields = new HashMap<>();
	private ModifyListener fTextFieldListener = new ModifyListener() {

		@Override
		public void modifyText(ModifyEvent e) {
			textChanged((Text) e.widget);
		}
	};

	private ArrayList<Text> fNumberFields = new ArrayList<>();
	private ModifyListener fNumberFieldListener = new ModifyListener() {

		@Override
		public void modifyText(ModifyEvent e) {
			numberFieldChanged((Text) e.widget);
		}
	};

	private Map<Combo, String> fComboFields = new HashMap<>();
	private SelectionListener fComboFieldListener = new SelectionListener() {

		@Override
		public void widgetSelected(SelectionEvent e) {
			comboFieldChanged((Combo) e.widget, e.data);
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {}
	};

	/**
	 * List of master/slave listeners when there's a dependency.
	 *
	 * @see #createDependency(Button, Control)
	 * @since 3.0
	 */
	private ArrayList<SelectionListener> fMasterSlaveListeners = new ArrayList<>();

	private StatusInfo fStatus;
	private final PreferencePage fMainPage;

	public AbstractConfigurationBlock(OverlayPreferenceStore store) {
		Assert.isNotNull(store);
		fStore = store;
		fMainPage = null;
	}

	public AbstractConfigurationBlock(OverlayPreferenceStore store, PreferencePage mainPreferencePage) {
		Assert.isNotNull(store);
		Assert.isNotNull(mainPreferencePage);
		fStore = store;
		fMainPage = mainPreferencePage;
	}

	protected final ScrolledPageContent getParentScrolledComposite(Control control) {
		Control parent = control.getParent();
		while (!(parent instanceof ScrolledPageContent) && parent != null) {
			parent = parent.getParent();
		}
		if (parent instanceof ScrolledPageContent) {
			return (ScrolledPageContent) parent;
		}
		return null;
	}

	private final ExpandableComposite getParentExpandableComposite(Control control) {
		Control parent = control.getParent();
		while (!(parent instanceof ExpandableComposite) && parent != null) {
			parent = parent.getParent();
		}
		if (parent instanceof ExpandableComposite) {
			return (ExpandableComposite) parent;
		}
		return null;
	}

	protected void updateSectionStyle(ExpandableComposite excomposite) {
		excomposite.setFont(JFaceResources.getFontRegistry().getBold(JFaceResources.DIALOG_FONT));
	}

	protected void makeScrollableCompositeAware(Control control) {
		ScrolledPageContent parentScrolledComposite = getParentScrolledComposite(control);
		if (parentScrolledComposite != null) {
			parentScrolledComposite.adaptChild(control);
		}
	}

	private boolean isNestedInScrolledComposite(Composite parent) {
		return getParentScrolledComposite(parent) != null;
	}

	protected Button addCheckBox(Composite parent, String label, String key, int indentation) {
		Button checkBox = new Button(parent, SWT.CHECK);
		checkBox.setText(label);

		GridData gd = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		gd.horizontalIndent = indentation;
		gd.horizontalSpan = 2;
		checkBox.setLayoutData(gd);
		checkBox.addSelectionListener(fCheckBoxListener);
		makeScrollableCompositeAware(checkBox);

		fCheckBoxes.put(checkBox, key);

		return checkBox;
	}

	/**
	 * Returns an array of size 2: - first element is of type <code>Label</code> - second element is
	 * of type <code>Text</code> Use <code>getLabelControl</code> and <code>getTextControl</code> to
	 * get the 2 controls.
	 *
	 * @param parent the parent composite
	 * @param label the text field's label
	 * @param key the preference key
	 * @param widthHint the text limit
	 * @param indent the field's indentation
	 * @param isNumber <code>true</code> iff this text field is used to edit a number
	 * @return the controls added
	 */
	protected Control[] addTextField(Composite parent, String label, String key, int widthHint, int indent,
			boolean isNumber) {

		PixelConverter pixelConverter = new PixelConverter(parent);
		Label labelControl = new Label(parent, SWT.NONE);
		labelControl.setText(label);
		GridData gd = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		gd.horizontalIndent = indent;
		labelControl.setLayoutData(gd);

		Text textBox = new Text(parent, SWT.BORDER | SWT.SINGLE);
		textBox.setText(fStore.getString(key));

		makeScrollableCompositeAware(textBox);

		gd = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		gd.widthHint = pixelConverter.convertWidthInCharsToPixels(widthHint + 1);
		gd.horizontalSpan = 2;
		textBox.setLayoutData(gd);
		if (widthHint > 0) textBox.setTextLimit(widthHint);
		fTextFields.put(textBox, key);
		if (isNumber) {
			fNumberFields.add(textBox);
			textBox.addModifyListener(fNumberFieldListener);
		} else {
			textBox.addModifyListener(fTextFieldListener);
		}
		return new Control[] { labelControl, textBox };
	}

	protected Combo addComboBox(Composite parent, String label, String key, String[] values, String[] valueLabels,
			int indent) {

		GridData gd = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		gd.horizontalIndent = indent;

		Label labelControl = new Label(parent, SWT.LEFT | SWT.WRAP);
		labelControl.setText(label);
		labelControl.setLayoutData(gd);

		Combo comboBox = new Combo(parent, SWT.READ_ONLY);
		SwtUtil.setDefaultVisibleItemCount(comboBox);
		comboBox.setItems(valueLabels);
		gd = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		gd.horizontalSpan = 2;
		comboBox.setLayoutData(gd);
		comboBox.addSelectionListener(fComboFieldListener);
		fComboFields.put(comboBox, key);
		return comboBox;
	}

	protected void createDependency(final Button master, final Control slave) {
		Assert.isNotNull(slave);
		indent(slave);
		SelectionListener listener = new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				boolean state = master.getSelection();
				slave.setEnabled(state);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}
		};
		master.addSelectionListener(listener);
		fMasterSlaveListeners.add(listener);
	}

	protected static void indent(Control control) {
		((GridData) control.getLayoutData()).horizontalIndent += SwtUtil.getIndent();
	}

	@Override
	public Control createControl(Composite parent) {
		initializeDialogUnits(parent);
		return null;
	}

	@Override
	public void initialize() {
		initializeFields();
	}

	private void initializeFields() {

		Iterator<Button> iter = fCheckBoxes.keySet().iterator();
		while (iter.hasNext()) {
			Button b = iter.next();
			String key = fCheckBoxes.get(b);
			b.setSelection(fStore.getBoolean(key));
		}

		Iterator<Text> iter2 = fTextFields.keySet().iterator();
		while (iter2.hasNext()) {
			Text t = iter2.next();
			String key = fTextFields.get(t);
			t.setText(fStore.getString(key));
		}

		// Update slaves
		Iterator<SelectionListener> iter3 = fMasterSlaveListeners.iterator();
		while (iter3.hasNext()) {
			SelectionListener listener = iter3.next();
			listener.widgetSelected(null);
		}

		updateStatus(new StatusInfo());
	}

	@Override
	public void applyData(Object data) {}

	@Override
	public boolean canPerformOk() {
		return true;
	}

	@Override
	public void performOk() {}

	@Override
	public void performDefaults() {
		initializeFields();
	}

	IStatus getStatus() {
		if (fStatus == null) fStatus = new StatusInfo();
		return fStatus;
	}

	@Override
	public void dispose() {}

	protected void buttonChanged(Button button) {
		String key = fCheckBoxes.get(button);
		String newValue = String.valueOf(button.getSelection());
		String oldValue = String.valueOf(!button.getSelection());
		IStatus status = validateSettings(key, oldValue, newValue);
		if (!status.matches(IStatus.ERROR)) fStore.setValue(key, newValue);
		updateStatus(status);
	}

	protected void textChanged(Text textControl) {
		String key = fTextFields.get(textControl);
		String text = textControl.getText();
		String oldValue = fStore.getString(key);
		IStatus status = validateSettings(key, oldValue, text);
		if (!status.matches(IStatus.ERROR)) fStore.setValue(key, text);
		updateStatus(status);
	}

	protected void numberFieldChanged(Text textControl) {
		String key = fTextFields.get(textControl);
		String number = textControl.getText();
		IStatus status = validateSettings(key, null, number);
		if (!status.matches(IStatus.ERROR)) fStore.setValue(key, number);
		updateStatus(status);
	}

	protected void comboFieldChanged(Combo widget, Object data) {}

	protected IStatus validatePositiveNumber(String number) {
		StatusInfo status = new StatusInfo();
		if (number.length() == 0) {
			status.setError("Empty_input");
		} else {
			try {
				int value = Integer.parseInt(number);
				if (value < 0) status.setError(number + " is not a valid input.");
			} catch (NumberFormatException e) {
				status.setError(number + " is not a valid input.");
			}
		}
		return status;
	}

	protected IStatus validateSettings(String key, String oldValue, String newValue) {
		return new StatusInfo();
	}

	protected void updateStatus(IStatus status) {
		if (fMainPage == null) return;
		fMainPage.setValid(status.isOK());
		StatusUtil.applyToStatusLine(fMainPage, status);
	}

	protected final OverlayPreferenceStore getPreferenceStore() {
		return fStore;
	}

	protected Composite createSubsection(Composite parent, SectionManager manager, String label) {
		if (manager != null) {
			return manager.createSection(label);
		} else {
			Group group = new Group(parent, SWT.SHADOW_NONE);
			group.setText(label);
			GridData data = new GridData(SWT.FILL, SWT.CENTER, true, false);
			group.setLayoutData(data);
			return group;
		}
	}

	/**
	 * Returns the number of pixels corresponding to the width of the given number of characters.
	 * <p>
	 * This method may only be called after <code>initializeDialogUnits</code> has been called.
	 * </p>
	 * <p>
	 * Clients may call this framework method, but should not override it.
	 * </p>
	 *
	 * @param chars the number of characters
	 * @return the number of pixels
	 */
	protected int convertWidthInCharsToPixels(int chars) {
		if (fFontMetrics == null) return 0;
		return Dialog.convertWidthInCharsToPixels(fFontMetrics, chars);
	}

	/**
	 * Returns the number of pixels corresponding to the height of the given number of characters.
	 * <p>
	 * This method may only be called after <code>initializeDialogUnits</code> has been called.
	 * </p>
	 * <p>
	 * Clients may call this framework method, but should not override it.
	 * </p>
	 *
	 * @param chars the number of characters
	 * @return the number of pixels
	 */
	protected int convertHeightInCharsToPixels(int chars) {
		if (fFontMetrics == null) return 0;
		return Dialog.convertHeightInCharsToPixels(fFontMetrics, chars);
	}

	/**
	 * Initializes the computation of horizontal and vertical dialog units based on the size of
	 * current font.
	 * <p>
	 * This method must be called before any of the dialog unit based conversion methods are called.
	 * </p>
	 *
	 * @param testControl a control from which to obtain the current font
	 */
	private void initializeDialogUnits(Control testControl) {
		GC gc = new GC(testControl);
		gc.setFont(JFaceResources.getDialogFont());
		fFontMetrics = gc.getFontMetrics();
		gc.dispose();
	}
}
