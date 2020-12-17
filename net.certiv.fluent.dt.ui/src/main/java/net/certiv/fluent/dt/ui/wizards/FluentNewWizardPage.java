package net.certiv.fluent.dt.ui.wizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Composite;

import net.certiv.dsl.ui.wizard.DslFileWizard;
import net.certiv.dsl.ui.wizard.DslFileWizardPage;

/**
 * Wizard UI to obtain the file name and location.
 */
public class FluentNewWizardPage extends DslFileWizardPage {

	public FluentNewWizardPage(DslFileWizard wizard, IStructuredSelection selection) {
		super("FluentNewWizardPage", wizard, selection);

		setTitle("Create FluentMark Document");
		setDescription("Creates a new document with 'md' extension.");
		setFilename("new_document");
		setFileExtension("md");
	}

	@Override
	protected void createCustomGroup(Composite topLevel) {}

	@Override
	protected String getInitialContents() {
		String contents = "# FluentMark";
		return contents;
	}
}
