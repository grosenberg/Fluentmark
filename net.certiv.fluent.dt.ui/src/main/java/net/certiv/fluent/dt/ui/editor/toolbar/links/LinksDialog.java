package net.certiv.fluent.dt.ui.editor.toolbar.links;

import java.util.LinkedList;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

import net.certiv.common.ex.IllegalArgsEx;
import net.certiv.common.log.Log;
import net.certiv.dsl.ui.util.SWTFactory;
import net.certiv.fluent.dt.core.lang.md.model.SpecSubType;
import net.certiv.fluent.dt.core.lang.md.model.SpecializedType;
import net.certiv.fluent.dt.ui.FluentUI;
import net.certiv.fluent.dt.ui.editor.FluentEditor;
import net.certiv.fluent.dt.ui.editor.toolbar.links.tabs.FootnoteRefTab;
import net.certiv.fluent.dt.ui.editor.toolbar.links.tabs.FootnoteTab;
import net.certiv.fluent.dt.ui.editor.toolbar.links.tabs.ImageRefTab;
import net.certiv.fluent.dt.ui.editor.toolbar.links.tabs.ImageTab;
import net.certiv.fluent.dt.ui.editor.toolbar.links.tabs.LinkRefTab;
import net.certiv.fluent.dt.ui.editor.toolbar.links.tabs.LinkTab;

public class LinksDialog extends Dialog {

	private static final String ERR_TITLE = " Install -- Failure";
	private static final String ERR_UNDEFINED = "" //
			+ "The Link Reference is undefined/not found\n" //
			+ "for the selected Link Definition";

	private final LinkedList<AbstractLinkTab> tabs = new LinkedList<>();

	private TabFolder folder;
	private LinksInfo info;

	public LinksDialog(Shell shell, FluentEditor editor, TextSelection sel) {
		super(shell);
		info = new LinksInfo(shell, editor, sel);
	}

	@Override
	public void create() {
		super.create();
		getShell().setText("Links Dialog"); //$NON-NLS-1$
	}

	@Override
	protected Control createContents(Composite parent) {
		return super.createContents(parent);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite comp = (Composite) super.createDialogArea(parent);

		info.initialize();

		folder = SWTFactory.createTabFolder(comp, SWT.NONE, GridData.FILL, SWT.DEFAULT);
		Dialog.applyDialogFont(folder);

		int idx = 0;
		createTab(folder, new LinkTab(info, idx++));
		createTab(folder, new LinkRefTab(info, idx++));
		createTab(folder, new ImageTab(info, idx++));
		createTab(folder, new ImageRefTab(info, idx++));
		createTab(folder, new FootnoteTab(info, idx++));
		createTab(folder, new FootnoteRefTab(info, idx++));

		selectTab(info.type, info.subtype);

		return comp;
	}

	private void createTab(TabFolder folder, AbstractLinkTab tab) {
		Composite comp = SWTFactory.createComposite(folder, 1, 1);
		TabItem item = new TabItem(folder, SWT.NONE);
		item.setText(tab.title());
		item.setControl(comp);

		tab.createControls(comp);
		tabs.add(tab);
	}

	private void selectTab(SpecializedType type, SpecSubType subtype) {
		for (AbstractLinkTab tab : tabs) {
			if (tab.type == type && tab.subtype == subtype) {
				folder.setSelection(tab.idx);
				break;
			}
		}
	}

	@Override
	protected void okPressed() {
		AbstractLinkTab tab = tabs.get(folder.getSelectionIndex());
		if (info.selOff < 0) {
			IStatus status = FluentUI.getDefault().createStatus(IStatus.ERROR,
					IllegalArgsEx.of(ERR_UNDEFINED));
			FluentUI.getDefault().errorDialog(info.shell, tab.title() + ERR_TITLE, ERR_UNDEFINED, status,
					true);

		} else {
			Log.debug("Installing %s -> %s", tab.type, tab.getLinkText());
			tab.install();
		}
		super.okPressed();
	}
}
