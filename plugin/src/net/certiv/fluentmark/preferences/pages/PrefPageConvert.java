package net.certiv.fluentmark.preferences.pages;

import java.io.File;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.preference.IPreferencePageContainer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;

import net.certiv.fluentmark.FluentMkUI;
import net.certiv.fluentmark.preferences.BaseFieldEditorPreferencePage;
import net.certiv.fluentmark.preferences.Prefs;
import net.certiv.fluentmark.preferences.SwtUtil;

public class PrefPageConvert extends BaseFieldEditorPreferencePage implements Prefs {

	private static final String DOT = "dot";
	private static final String BLACKFRIDAY = "blackfriday-tool";
	private static final String PANDOC = "pandoc";

	protected static final String[] DOT_MSG = { "Invalid Dot executable",
			"Full pathname of the Dot executable [dot|dot.exe]", "dot" };

	protected static final String[] BF_MSG = { "Invalid BlackFriday executable",
			"Full pathname of the BlackFriday tool [blackfriday-tool|blackfriday-tool.exe]", "blackfriday-tool" };

	protected static final String[] PD_MSG = { "Invalid Pandoc executable",
			"Full pathname of the Pandoc executable [pandoc|pandoc.exe]", "pandoc" };

	private ComboFieldEditor2 combo;
	private String[][] converters;

	private Composite dotComp;
	private BooleanFieldEditor dotMode;
	private FileFieldEditor dotExe;

	private Composite bfComp;
	private BooleanFieldEditor bfSmart;
	private BooleanFieldEditor bfAddToc;
	private FileFieldEditor bfExe;

	private Composite pdComp;
	private BooleanFieldEditor pdSmart;
	private BooleanFieldEditor pdAddToc;
	private BooleanFieldEditor pdMathjax;
	private FileFieldEditor pdExe;

	private Composite txtComp;
	private BooleanFieldEditor safeMode;
	private BooleanFieldEditor extended;

	private Composite extComp;
	private StringFieldEditor extField;
	private boolean dotEnabled;

	private class ComboFieldEditor2 extends ComboFieldEditor {

		private String value = ""; // current key value

		public ComboFieldEditor2(String name, String labelText, String[][] entryNamesAndValues, Composite parent) {
			super(name, labelText, entryNamesAndValues, parent);
		}

		public String getValue() {
			return value;
		}

		@Override
		protected void fireValueChanged(String property, Object oldValue, Object newValue) {
			super.fireValueChanged(property, oldValue, newValue);
			value = (String) newValue;
			update(value);
		}
	}

	public PrefPageConvert() {
		super(GRID);
		setDescription("");
	}

	public void init(IWorkbench workbench) {
		setPreferenceStore(FluentMkUI.getDefault().getPreferenceStore());
	}

	/** Create fields controlling general editor behavior */
	@Override
	public void createFieldEditors() {

		// Converter selection
		Composite baseComp = SwtUtil.makeGroupComposite(getFieldEditorParent(), "Conversion filter selection");
		combo = new ComboFieldEditor2(EDITOR_MD_CONVERTER, "Converter:", converters(), baseComp);
		addField(combo);

		// ----------------------------------------------------------------------------------

		// Dot options
		dotComp = SwtUtil.makeGroupComposite(baseComp, "Graphviz Dot");

		dotMode = new BooleanFieldEditor(EDITOR_DOTMODE_ENABLED, "Use Dot diagram generator", dotComp);
		addField(dotMode);
		dotExe = createProgramField(EDITOR_DOT_PROGRAM, "Location:", dotComp, DOT_MSG);
		addField(dotExe);

		// ----------------------------------------------------------------------------------

		// BlackFriday related options
		bfComp = SwtUtil.makeGroupComposite(baseComp, "BlackFriday Options");

		bfSmart = new BooleanFieldEditor(EDITOR_BLACKFRIDAY_SMART, "Use smart typography", bfComp);
		addField(bfSmart);
		bfAddToc = new BooleanFieldEditor(EDITOR_BLACKFRIDAY_ADDTOC, "Add table of contents", bfComp);
		addField(bfAddToc);

		bfExe = createProgramField(EDITOR_BLACKFRIDAY_PROGRAM, "Location:", bfComp, BF_MSG);
		addField(bfExe);

		// ----------------------------------------------------------------------------------

		// Pandoc related options
		pdComp = SwtUtil.makeGroupComposite(baseComp, "Pandoc Options");

		pdSmart = new BooleanFieldEditor(EDITOR_PANDOC_SMART, "Use smart typography", pdComp);
		addField(pdSmart);
		pdAddToc = new BooleanFieldEditor(EDITOR_PANDOC_ADDTOC, "Add table of contents", pdComp);
		addField(pdAddToc);
		pdMathjax = new BooleanFieldEditor(EDITOR_PANDOC_MATHJAX, "Enable Mathjax rendering", pdComp);
		addField(pdMathjax);

		pdExe = createProgramField(EDITOR_PANDOC_PROGRAM, "Location:", pdComp, PD_MSG);
		addField(pdExe);

		// ----------------------------------------------------------------------------------

		// TxtMark related options
		txtComp = SwtUtil.makeGroupComposite(baseComp, "TxtMark Options");

		safeMode = new BooleanFieldEditor(EDITOR_TXTMARK_SAFEMODE, "Use safe mode", txtComp);
		addField(safeMode);
		extended = new BooleanFieldEditor(EDITOR_TXTMARK_EXTENDED, "Use extended profile", txtComp);
		addField(extended);

		// ----------------------------------------------------------------------------------

		// External cli
		extComp = SwtUtil.makeGroupComposite(baseComp, "External Converter Command line (stdin to stdout)");

		extField = new StringFieldEditor(EDITOR_EXTERNAL_COMMAND, "", extComp);

		// ----------------------------------------------------------------------------------

		update(getPreferenceStore().getString(EDITOR_MD_CONVERTER)); // init visibility
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		update(getKey(combo.getValue()));
		validateSettings();
		super.propertyChange(event);
	}

	@Override
	protected void adjustSubLayout() {
		adjust(dotComp, 1);
		adjust(bfComp, 1);
		adjust(pdComp, 1);
		adjust(txtComp, 1);
		adjust(extComp, 1);
	}

	private FileFieldEditor createProgramField(String key, String label, Composite parent, String[] msg) {

		return new FileFieldEditor(key, label, true, FileFieldEditor.VALIDATE_ON_KEY_STROKE, parent) {

			{
				setErrorMessage(msg[0]);
				setEmptyStringAllowed(true);
				getTextControl().setToolTipText(msg[1]);
			}

			@Override
			public boolean isValid() {
				boolean ok = super.isValid();
				String value = getStringValue();
				if (!value.isEmpty()) {
					ok = ok && isValidExecutable(value, msg[2]);
				}
				return ok;
			}

			@Override
			protected void refreshValidState() {
				super.refreshValidState();
				if (!isValid()) {
					showErrorMessage(getErrorMessage());
				}
				checkState();
			}

			@Override
			public boolean doCheckState() {
				String currentValue = getStringValue();
				if (!currentValue.isEmpty()) {
					return isValidExecutable(currentValue, msg[2]);
				}
				return super.doCheckState();
			}

			@Override
			public String changePressed() { // Browse
				String dotExecutablePath = super.changePressed();
				if (dotExecutablePath == null) return null; // no change
				return dotExecutablePath;
			}

			@Override
			protected void fireValueChanged(String property, Object oldValue, Object newValue) {
				super.fireValueChanged(property, oldValue, newValue);
				update(combo.getValue());
			}
		};
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
	public void createControl(Composite parent) {
		super.createControl(parent);
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

	private void update(String value) {

		Display.getDefault().asyncExec(new Runnable() {

			@Override
			public void run() {
				switch (value) {
					case KEY_BLACKFRIDAY:
						dotEnabled = true;
						enable(dotComp, dotMode, dotExe);
						enable(bfComp, bfSmart, bfAddToc, bfExe);
						disable(pdComp, pdSmart, pdAddToc, pdMathjax, pdExe);
						disable(txtComp, safeMode, extended);
						disable(extComp, extField);
						break;
					case KEY_PANDOC:
						dotEnabled = true;
						enable(dotComp, dotMode, dotExe);
						enable(pdComp, pdSmart, pdAddToc, pdMathjax, pdExe);
						disable(bfComp, bfSmart, bfAddToc, bfExe);
						disable(txtComp, safeMode, extended);
						disable(extComp, extField);
						break;
					case KEY_TXTMARK:
						dotEnabled = true;
						enable(dotComp, dotMode, dotExe);
						disable(bfComp, bfSmart, bfAddToc, bfExe);
						disable(pdComp, pdSmart, pdAddToc, pdMathjax, pdExe);
						enable(txtComp, safeMode, extended);
						disable(extComp, extField);
						break;
					case KEY_EXTERNAL:
						dotEnabled = true;
						enable(dotComp, dotMode, dotExe);
						disable(bfComp, bfSmart, bfAddToc, bfExe);
						disable(pdComp, pdSmart, pdAddToc, pdMathjax, pdExe);
						disable(txtComp, safeMode, extended);
						enable(extComp, extField);
						break;
					default:
						dotEnabled = false;
						disable(dotComp, dotMode, dotExe);
						disable(bfComp, bfSmart, bfAddToc, bfExe);
						disable(pdComp, pdSmart, pdAddToc, pdMathjax, pdExe);
						disable(txtComp, safeMode, extended);
						disable(extComp, extField);
				}
			}
		});
	}

	private void validateSettings() {
		setErrorMessage(null);
		setMessage(null);
		if (dotEnabled && dotMode.getBooleanValue()) {
			String pathname = dotExe.getStringValue();
			if (!checkPathname(pathname, DOT)) return;
		}
		String target = combo.getValue();
		String key = getKey(target);
		String pathname = getPreferenceStore().getString(key);
		switch (key) {
			case KEY_BLACKFRIDAY:
				if (!checkPathname(pathname, BLACKFRIDAY)) return;
				break;
			case KEY_PANDOC:
				if (!checkPathname(pathname, PANDOC)) return;
				break;
			case KEY_EXTERNAL:
				if (!checkPathname(pathname, null)) return;
				break;
		}
	}

	private boolean checkPathname(String pathname, String target) {
		if (pathname.trim().isEmpty()) {
			setMessage("Missing pathname of " + target + " executable", IMessageProvider.ERROR);
			return false;
		}
		File file = new File(pathname);
		if (target != null) {
			if (!isValidExecutable(file.getPath(), target)) {
				setMessage("Invalid name of " + target + " executable", IMessageProvider.ERROR);
				return false;
			}
		}
		if (!file.isFile()) {
			setMessage("Invalid pathname of " + target + " executable", IMessageProvider.ERROR);
			return false;
		}
		return true;
	}

	private boolean isValidExecutable(String path, String name) {
		if (path == null || path.isEmpty()) return false;
		File file = new File(path);
		if (!(file.getName().equals(name) || file.getName().equals(name + ".exe"))) { //$NON-NLS-1$
			return false;
		}
		return file.isFile();
	}

	private void enable(Composite parent, FieldEditor... editors) {
		for (FieldEditor editor : editors) {
			editor.setEnabled(true, parent);
		}
	}

	private void disable(Composite parent, FieldEditor... editors) {
		for (FieldEditor editor : editors) {
			editor.setEnabled(false, parent);
		}
	}

	private String[][] converters() {
		if (converters == null) {
			converters = new String[7][2];
			converters[0][0] = "BlackFriday";
			converters[0][1] = KEY_BLACKFRIDAY;
			converters[1][0] = "Commonmark";
			converters[1][1] = KEY_COMMONMARK;
			converters[2][0] = "MarkdownJ";
			converters[2][1] = KEY_MARDOWNJ;
			converters[3][0] = "Pandoc";
			converters[3][1] = KEY_PANDOC;
			converters[4][0] = "PegDown";
			converters[4][1] = KEY_PEGDOWN;
			converters[5][0] = "TxtMark";
			converters[5][1] = KEY_TXTMARK;
			converters[6][0] = "External converter";
			converters[6][1] = KEY_EXTERNAL;
		}
		return converters;
	}

	private String getKey(String value) {
		for (int idx = 0; idx < converters.length; idx++) {
			if (converters[idx][0].equals(value)) return converters[idx][1];
		}
		return "";
	}
}
