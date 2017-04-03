/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;

import net.certiv.fluentmark.Log;
import net.certiv.fluentmark.views.FluentMkPreview;

public class OpenMdViewHandler extends AbstractHandler {

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		try {
			IWorkbenchPage activePage = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage();
			IViewPart mdView = activePage.showView(FluentMkPreview.ID);
			FluentMkPreview preview = (FluentMkPreview) mdView;
			activePage.activate(preview);
		} catch (PartInitException e) {
			showError(e);
		}
		return null;
	}

	private void showError(Exception e) {
		String title = "Exception while opening Markdown Preview";
		String message = title + " (" + FluentMkPreview.ID + ")";
		Log.error(message, e);

		Shell shell = Display.getDefault().getActiveShell();
		MessageDialog.openError(shell, title , message);
	}
}
