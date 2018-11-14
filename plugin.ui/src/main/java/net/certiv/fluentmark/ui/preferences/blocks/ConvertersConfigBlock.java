package net.certiv.fluentmark.ui.preferences.blocks;

import static net.certiv.fluentmark.core.preferences.Prefs.*;

import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.forms.widgets.FormToolkit;

import net.certiv.dsl.core.color.DslColorManager;
import net.certiv.dsl.core.preferences.DslPrefsManagerDelta;
import net.certiv.dsl.ui.preferences.blocks.AbstractConfigBlock;
import net.certiv.dsl.ui.preferences.pages.IDslPreferencePage;
import net.certiv.dsl.ui.util.SWTFactory;
import net.certiv.fluentmark.ui.preferences.tabs.BlackFridayTab;
import net.certiv.fluentmark.ui.preferences.tabs.CMarkTab;
import net.certiv.fluentmark.ui.preferences.tabs.DotTab;
import net.certiv.fluentmark.ui.preferences.tabs.ExternalTab;
import net.certiv.fluentmark.ui.preferences.tabs.PandocTab;
import net.certiv.fluentmark.ui.preferences.tabs.TxtMarkTab;
import net.certiv.fluentmark.ui.preferences.tabs.UmlTab;

public class ConvertersConfigBlock extends AbstractConfigBlock {

	private TabFolder folder;
	private PandocTab pandocTab;
	private CMarkTab cmarkTab;
	private BlackFridayTab blackFridayTab;
	private TxtMarkTab txtMarkTab;
	private ExternalTab externalTab;
	private DotTab dotTab;
	private UmlTab umlTab;

	public ConvertersConfigBlock(IDslPreferencePage page, DslPrefsManagerDelta delta, FormToolkit formkit,
			DslColorManager colorMgr) {
		super(page, delta, formkit, colorMgr);
	}

	@Override
	protected List<String> createDeltaMatchKeys(List<String> keys) {
		return keys;
	}

	public void selectTab(int tabId) {
		folder.setSelection(tabId);
	}

	@Override
	public Composite createContents(Composite parent) {
		SWTFactory.createVerticalSpacer(parent, 1);
		Composite comp = SWTFactory.createComposite(parent, parent.getFont(), 1, 1, GridData.FILL_BOTH);
		folder = SWTFactory.createTabFolder(parent, SWT.NONE, GridData.FILL_BOTH, 400);

		createTab(Cnv.PANDOC);
		createTab(Cnv.CMARK);
		createTab(Cnv.BLACKFRIDAY);
		createTab(Cnv.TXTMARK);
		createTab(Cnv.EXTERNAL);

		createTab(Cnv.DOT);
		createTab(Cnv.UML);

		folder.setSelection(Cnv.PANDOC.idx());
		Dialog.applyDialogFont(folder);

		return comp;
	}

	private void createTab(Cnv type) {
		Composite comp = SWTFactory.createComposite(folder, 1, 1, GridData.FILL_BOTH);
		TabItem tab = new TabItem(folder, SWT.NONE, type.idx());
		tab.setText(type.name());
		tab.setControl(comp);

		SWTFactory.createVerticalSpacer(comp, 1);
		SWTFactory.createWrapLabel(comp, type.desc(), 1, 0);
		SWTFactory.createVerticalSpacer(comp, 1);

		switch (type.key()) {
			case KEY_PANDOC:
				pandocTab = new PandocTab(page, comp, delta, type.desc());
				break;

			case KEY_CMARK:
				cmarkTab = new CMarkTab(page, comp, delta, type.desc());
				break;

			case KEY_BLACKFRIDAY:
				blackFridayTab = new BlackFridayTab(page, comp, delta, type.desc());
				break;

			case KEY_TXTMARK:
				txtMarkTab = new TxtMarkTab(page, comp, delta, type.desc());
				break;

			case KEY_EXTERNAL:
				externalTab = new ExternalTab(page, comp, delta, type.desc());
				break;

			case KEY_DOT:
				dotTab = new DotTab(page, comp, delta, type.desc());
				break;

			case KEY_UML:
				umlTab = new UmlTab(page, comp, delta, type.desc());
				break;
		}

		SWTFactory.createVerticalSpacer(comp, 1);
	}

	public void validateSettings(String key) {
		switch (key) {
			case KEY_PANDOC:
				pandocTab.validateSettings();
				break;

			case KEY_CMARK:
				cmarkTab.validateSettings();
				break;

			case KEY_BLACKFRIDAY:
				blackFridayTab.validateSettings();
				break;

			case KEY_TXTMARK:
				txtMarkTab.validateSettings();
				break;

			case KEY_EXTERNAL:
				externalTab.validateSettings();
				break;

			case KEY_DOT:
				dotTab.validateSettings();
				break;

			case KEY_UML:
				umlTab.validateSettings();
				break;
		}
	}
}
