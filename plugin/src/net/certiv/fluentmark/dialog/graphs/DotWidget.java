package net.certiv.fluentmark.dialog.graphs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

public class DotWidget extends Composite {

	/**
	 * Create the composite.
	 *
	 * @param parent
	 * @param style
	 */
	public DotWidget(Composite parent, int style) {
		super(parent, SWT.NONE);
		setLayout(new FormLayout());

		CTabFolder tabFolder = new CTabFolder(this, SWT.BORDER);
		FormData fd_tabFolder = new FormData();
		fd_tabFolder.bottom = new FormAttachment(0, 296);
		fd_tabFolder.right = new FormAttachment(0, 446);
		fd_tabFolder.top = new FormAttachment(0, 4);
		fd_tabFolder.left = new FormAttachment(0, 4);
		tabFolder.setLayoutData(fd_tabFolder);
		tabFolder.setSelectionBackground(
				Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));

		CTabItem globalItem = new CTabItem(tabFolder, SWT.NONE);
		globalItem.setText("Globals");

		CTabItem nodeItem = new CTabItem(tabFolder, SWT.NONE);
		nodeItem.setText("Nodes");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
