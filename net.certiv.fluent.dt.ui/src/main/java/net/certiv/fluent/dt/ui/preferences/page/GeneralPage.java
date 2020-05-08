package net.certiv.fluent.dt.ui.preferences.page;

import static net.certiv.fluent.dt.core.preferences.Prefs.*;

import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.forms.widgets.FormToolkit;

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.core.color.DslColorManager;
import net.certiv.dsl.core.preferences.PrefsDeltaManager;
import net.certiv.dsl.ui.DslUI;
import net.certiv.dsl.ui.preferences.blocks.IPreferenceConfigBlock;
import net.certiv.dsl.ui.preferences.editors.ComboSelectFieldEditor;
import net.certiv.dsl.ui.preferences.pages.AbstractFieldEditorPreferencePage;
import net.certiv.dsl.ui.util.SWTFactory;
import net.certiv.fluent.dt.core.FluentCore;
import net.certiv.fluent.dt.core.preferences.Prefs;
import net.certiv.fluent.dt.ui.FluentUI;
import net.certiv.fluent.dt.ui.preferences.blocks.Cnv;
import net.certiv.fluent.dt.ui.preferences.blocks.ConvertersConfigBlock;

public class GeneralPage extends AbstractFieldEditorPreferencePage {

	private static final String[][] converters = new String[][] { //
			{ "Pandoc", Prefs.KEY_PANDOC }, //
			{ "Flexmark", Prefs.KEY_FLEXMARK }, //
			{ "BlackFriday", Prefs.KEY_BLACKFRIDAY }, //
			{ "External", Prefs.KEY_EXTERNAL }, //
	};

	private ComboSelectFieldEditor combo;
	private ConvertersConfigBlock block;

	public GeneralPage() {
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
		super.init(workbench);
		String converter = getPreferenceStore().getString(Prefs.EDITOR_MD_CONVERTER);
		switch (converter) {
			case KEY_PANDOC:
			case KEY_FLEXMARK:
			case KEY_BLACKFRIDAY:
			case KEY_EXTERNAL:
				break;
			default:
				getPreferenceStore().setToDefault(Prefs.EDITOR_MD_CONVERTER);
		}
	}

	@Override
	protected Control createContents(Composite parent) {
		Control control = super.createContents(parent);
		String key = getPreferenceStore().getString(Prefs.EDITOR_MD_CONVERTER);
		Cnv cnv = Cnv.find(key);
		block.selectTab(cnv.index());
		return control;
	}

	@Override
	protected void createFieldEditors() {
		Composite parent = getFieldEditorParent();
		Composite base = SWTFactory.createGroupComposite(parent, 2, 3, "Conversion filter selection");
		combo = new ComboSelectFieldEditor(Prefs.EDITOR_MD_CONVERTER, "Converter:", converters, base);
		addField(combo);
	}

	@Override
	protected IPreferenceConfigBlock createConfigurationBlock(AbstractFieldEditorPreferencePage page, Composite parent,
			PrefsDeltaManager delta, FormToolkit formkit, DslColorManager colorMgr) {
		block = new ConvertersConfigBlock(this, delta, formkit, colorMgr);
		return block;
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		if (event.getSource() == combo && !event.getNewValue().equals(event.getOldValue())) {
			setErrorMessage(null);
			setMessage(null);
			Cnv cnv = Cnv.find(combo.getKey());
			block.selectTab(cnv.index());
			block.validateSettings(combo.getKey());
		}
		super.propertyChange(event);
	}

	@Override
	protected void adjustSubLayout() {}

}
