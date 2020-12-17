package net.certiv.fluent.dt.ui.wizards;

import org.eclipse.jface.resource.ImageDescriptor;

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.ui.DslImageManager;
import net.certiv.dsl.ui.DslUI;
import net.certiv.dsl.ui.wizard.DslFileWizard;
import net.certiv.fluent.dt.core.FluentCore;
import net.certiv.fluent.dt.ui.FluentUI;

/** Create a new resource in the indicated container. */
public class FluentNewWizard extends DslFileWizard {

	private FluentNewWizardPage page;

	public FluentNewWizard() {
		super("FluentNewWizard");
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
	public ImageDescriptor getPageImageDescriptor() {
		DslImageManager imgMgr = getDslUI().getImageManager();
		return imgMgr.getDescriptor(imgMgr.IMG_WIZBAN_NEW_FILE);
	}

	@Override
	public String getWindowShellTitle() {
		return "New Fluentmark file";
	}

	@Override
	protected FluentNewWizardPage getMainPage() {
		if (page == null) {
			page = new FluentNewWizardPage(this, getSelection());
		}
		return page;
	}
}
