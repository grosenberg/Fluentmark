package net.certiv.fluentmark.ui.preferences.pages;

import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.forms.widgets.FormToolkit;

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.core.color.DslColorManager;
import net.certiv.dsl.core.preferences.DslPrefsManagerDelta;
import net.certiv.dsl.ui.DslUI;
import net.certiv.dsl.ui.preferences.blocks.IPreferenceConfigBlock;
import net.certiv.dsl.ui.preferences.editors.ComboSelectFieldEditor;
import net.certiv.dsl.ui.preferences.pages.AbstractFieldEditorPreferencePage;
import net.certiv.dsl.ui.util.SWTFactory;
import net.certiv.fluentmark.core.FluentCore;
import net.certiv.fluentmark.core.preferences.Prefs;
import net.certiv.fluentmark.ui.FluentUI;
import net.certiv.fluentmark.ui.preferences.blocks.ConvertersConfigBlock;

public class ConvertersPage extends AbstractFieldEditorPreferencePage {

	private static final String[][] converters = new String[][] { //
			{ "BlackFriday", Prefs.KEY_BLACKFRIDAY }, //
			{ "CMark", Prefs.KEY_CMARK }, //
			{ "Pandoc", Prefs.KEY_PANDOC }, //
			{ "TxtMark", Prefs.KEY_TXTMARK }, //
			{ "External", Prefs.KEY_EXTERNAL }, //
	};

	private ComboSelectFieldEditor combo;
	private ConvertersConfigBlock block;

	protected ConvertersPage() {
		super(GRID);
	}

	@Override
	public DslUI getDslUI() {
		return FluentUI.getDefault();
	}

	@Override
	public DslCore getDslCore() {
		return FluentCore.getDefault();
	}

	@Override
	public void init(IWorkbench workbench) {
		setPreferenceStore(FluentCore.getDefault().getPrefsManager());
	}

	@Override
	protected void createFieldEditors() {
		Composite parent = getFieldEditorParent();
		Composite base = SWTFactory.createGroupComposite(parent, 3, 1, "Conversion filter selection");
		combo = new ComboSelectFieldEditor(Prefs.EDITOR_MD_CONVERTER, "Cnv:", converters, base);
		addField(combo);
	}

	@Override
	protected IPreferenceConfigBlock createConfigurationBlock(AbstractFieldEditorPreferencePage page, Composite parent,
			DslPrefsManagerDelta delta, FormToolkit formkit, DslColorManager colorMgr) {
		block = new ConvertersConfigBlock(this, delta, formkit, colorMgr);
		return block;
	}

	@Override
	protected void initialize() {
		super.initialize();
		block.validateSettings(getPreferenceStore().getString(Prefs.EDITOR_MD_CONVERTER));
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		if (event.getSource() == combo && !event.getNewValue().equals(event.getOldValue())) {
			setErrorMessage(null);
			setMessage(null);
			block.validateSettings(combo.getKey());
		}
		super.propertyChange(event);
	}

	@Override
	protected void adjustSubLayout() {}
}
