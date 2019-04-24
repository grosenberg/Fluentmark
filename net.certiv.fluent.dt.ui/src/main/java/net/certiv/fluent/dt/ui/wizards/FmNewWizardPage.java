package net.certiv.fluent.dt.ui.wizards;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import net.certiv.fluent.dt.core.FluentCore;
import net.certiv.fluent.dt.ui.FluentUI;

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.ui.DslUI;
import net.certiv.dsl.ui.wizards.DslContainerWizardPage;

/**
 * Wizard UI to obtain the file name and location.
 */
public class FmNewWizardPage extends DslContainerWizardPage {

	public FmNewWizardPage(IStructuredSelection selection) {
		super("wizardPage", selection);
		setTitle("FluentMark Editor File");
		setDescription("Creates a new file with 'md' extension.");
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
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(container);
		GridLayoutFactory.fillDefaults().spacing(6, 9).margins(6, 6).applyTo(container);

		setFileName("file_name");
		setFileExtension("md");
		createContainerControl(container);

		setControl(container);
		setErrorMessage(null);
		setMessage(null);
		validatePage();
	}
}
