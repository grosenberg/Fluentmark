package net.certiv.fluentmark.ui.preferences.pages;

import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
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
import net.certiv.fluentmark.ui.preferences.blocks.BlackFridayConfigBlock;
import net.certiv.fluentmark.ui.preferences.blocks.DotConfigBlock;
import net.certiv.fluentmark.ui.preferences.blocks.ExternalConfigBlock;
import net.certiv.fluentmark.ui.preferences.blocks.NullConfigBlock;
import net.certiv.fluentmark.ui.preferences.blocks.PandocConfigBlock;
import net.certiv.fluentmark.ui.preferences.blocks.TxtmarkConfigBlock;

public class ConvertersPage extends AbstractFieldEditorPreferencePage {

	private Composite base;
	private Composite stack;
	private StackLayout stackSel;
	private String selectedKey;

	private ComboSelectFieldEditor combo;
	private PandocConfigBlock pandoc;
	private BlackFridayConfigBlock bfriday;
	private TxtmarkConfigBlock txtmark;
	private ExternalConfigBlock external;
	private NullConfigBlock other;

	private DotConfigBlock dotgen;

	private static final String[][] converters = new String[][] { //
			{ "BlackFridayConfigBlock", Prefs.KEY_BLACKFRIDAY }, //
			{ "Commonmark", Prefs.KEY_COMMONMARK }, //
			{ "MarkdownJ", Prefs.KEY_MARDOWNJ }, //
			{ "Pandoc", Prefs.KEY_PANDOC }, //
			{ "PegDown", Prefs.KEY_PEGDOWN }, //
			{ "TxtMark", Prefs.KEY_TXTMARK }, //
			{ "External converter", Prefs.KEY_EXTERNAL }, //
	};

	public ConvertersPage() {
		super(GRID);
		setDescription("");
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

	/** Create fields controlling converter selection */
	@Override
	public void createFieldEditors() {
		Composite parent = getFieldEditorParent();
		base = SWTFactory.makeGroupComposite(parent, 3, 1, "Conversion filter selection");

		// Converter selection
		combo = new ComboSelectFieldEditor(Prefs.EDITOR_MD_CONVERTER, "Converter:", converters, base);
		addField(combo);

		stack = SWTFactory.makeCompositeStack(parent, 3, 1);
		stackSel = (StackLayout) stack.getLayout();

		// stacked options
		pandoc = new PandocConfigBlock(this, stack, "Pandoc Options");
		bfriday = new BlackFridayConfigBlock(this, stack, "BlackFridayConfigBlock Options");
		txtmark = new TxtmarkConfigBlock(this, stack, "TxtMark Options");
		external = new ExternalConfigBlock(this, stack, "External Options");
		other = new NullConfigBlock(this, stack, "Default Options");

		// rest
		dotgen = new DotConfigBlock(this, parent, "Graphviz Options");

		// init converter option selection
		updateConverter(stack, getPreferenceStore().getString(Prefs.EDITOR_MD_CONVERTER));
	}

	@Override
	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);
		validateSettings(getPreferenceStore().getString(Prefs.EDITOR_MD_CONVERTER));
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
			case Prefs.KEY_PANDOC:
				stackSel.topControl = pandoc.getFrame();
				dotgen.setVisible(true);
				break;

			case Prefs.KEY_BLACKFRIDAY:
				stackSel.topControl = bfriday.getFrame();
				dotgen.setVisible(true);
				break;

			case Prefs.KEY_TXTMARK:
				stackSel.topControl = txtmark.getFrame();
				dotgen.setVisible(true);
				break;

			case Prefs.KEY_EXTERNAL:
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
			case Prefs.KEY_PANDOC:
				pandoc.validateSettings();
				dotgen.validateSettings();
				break;

			case Prefs.KEY_BLACKFRIDAY:
				bfriday.validateSettings();
				dotgen.validateSettings();
				break;

			case Prefs.KEY_TXTMARK:
				txtmark.validateSettings();
				break;

			case Prefs.KEY_EXTERNAL:
				external.validateSettings();
				break;

			default:
				other.validateSettings();
				break;
		}
	}

	@Override
	protected IPreferenceConfigBlock createConfigurationBlock(AbstractFieldEditorPreferencePage page, Composite parent,
			DslPrefsManagerDelta delta, FormToolkit formkit, DslColorManager colorMgr) {
		return null;
	}

	@Override
	protected void adjustSubLayout() {}
}
