package net.certiv.fluent.dt.ui.preferences.page;

import static net.certiv.fluent.dt.core.preferences.Prefs.KEY_BLACKFRIDAY;
import static net.certiv.fluent.dt.core.preferences.Prefs.KEY_EXTERNAL;
import static net.certiv.fluent.dt.core.preferences.Prefs.KEY_FLEXMARK;
import static net.certiv.fluent.dt.core.preferences.Prefs.KEY_PANDOC;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.forms.widgets.FormToolkit;

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.core.color.DslColorRegistry;
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
			{ "Pandoc", KEY_PANDOC }, //
			{ "Flexmark", KEY_FLEXMARK }, //
			{ "BlackFriday", KEY_BLACKFRIDAY }, //
			{ "External", KEY_EXTERNAL }, //
	};

	private static final String[][] engines = new String[][] { //
			{ "IE", String.valueOf(SWT.NONE) }, //
			{ "Chromium", String.valueOf(SWT.CHROMIUM) }, //
			{ "Webkit", String.valueOf(SWT.WEBKIT) }, //
	};

	private ComboSelectFieldEditor converter;
	private ConvertersConfigBlock block;
	private ComboSelectFieldEditor engine;

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
		IPreferenceStore store = getPreferenceStore();
		String converter = store.getString(Prefs.EDITOR_MD_CONVERTER);
		switch (converter) {
			case KEY_PANDOC:
			case KEY_FLEXMARK:
			case KEY_BLACKFRIDAY:
			case KEY_EXTERNAL:
				break;
			default:
				store.setToDefault(Prefs.EDITOR_MD_CONVERTER);
		}

		int engine = -1;
		try {
			engine = Integer.valueOf(store.getString(Prefs.EDITOR_MD_ENGINE));
		} catch (NumberFormatException e) {}
		switch (engine) {
			case SWT.NONE:
			case SWT.CHROMIUM:
			case SWT.WEBKIT:
				break;
			default:
				store.setToDefault(Prefs.EDITOR_MD_ENGINE);
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
		Composite base = SWTFactory.createGroupComposite(parent, 2, 3, "Markdown");
		converter = new ComboSelectFieldEditor(Prefs.EDITOR_MD_CONVERTER, "Converter:", converters, base);
		addField(converter);
		engine = new ComboSelectFieldEditor(Prefs.EDITOR_MD_ENGINE, "Preview engine:", engines, base);
		addField(engine);
	}

	@Override
	protected IPreferenceConfigBlock createConfigurationBlock(AbstractFieldEditorPreferencePage page, Composite parent,
			PrefsDeltaManager delta, FormToolkit formkit, DslColorRegistry reg) {
		block = new ConvertersConfigBlock(this, delta, formkit, reg);
		return block;
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		if (event.getSource() == converter && !event.getNewValue().equals(event.getOldValue())) {
			setErrorMessage(null);
			setMessage(null);
			Cnv cnv = Cnv.find(converter.getKey());
			block.selectTab(cnv.index());
			block.validateSettings(converter.getKey());
		}
		super.propertyChange(event);
	}

	@Override
	protected void adjustSubLayout() {}
}
