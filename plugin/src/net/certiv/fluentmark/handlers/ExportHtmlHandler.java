/*******************************************************************************
 * Copyright (c) 2016 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.handlers;

import java.awt.Desktop;
import java.io.File;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.handlers.HandlerUtil;

import net.certiv.fluentmark.FluentMkUI;
import net.certiv.fluentmark.editor.FluentMkEditor;
import net.certiv.fluentmark.preferences.Prefs;
import net.certiv.fluentmark.util.FileUtils;

public class ExportHtmlHandler extends AbstractHandler {

	public ExportHtmlHandler() {
		super();
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		FluentMkEditor editor = (FluentMkEditor) HandlerUtil.getActiveEditor(event);
		Shell shell = HandlerUtil.getActiveShell(event);

		IEditorInput input = editor.getEditorInput();
		if (input instanceof IFileEditorInput) {
			IFile file = ((IFileEditorInput) input).getFile();
			IPath path = file.getLocation().removeFileExtension().addFileExtension("html");
			String base = path.removeLastSegments(1).toOSString();
			String name = path.lastSegment();

			FileDialog dialog = new FileDialog(shell, SWT.SAVE);
			dialog.setFilterNames(new String[] { "Html Files", "All Files (*.*)" });
			dialog.setFilterExtensions(new String[] { "*.html", "*.*" });
			dialog.setFilterPath(base);
			dialog.setFileName(name);

			String pathname = dialog.open();
			if (pathname != null) {
				String html = editor.getHtml(true);
				FileUtils.write(new File(pathname), html);
			}
		
			if (FluentMkUI.getDefault().getPreferenceStore().getBoolean(Prefs.EDITOR_HTML_OPEN)) {
				if (Desktop.isDesktopSupported()) {
					try {
						Desktop.getDesktop().open(new File(pathname));
					} catch (Exception e) {
						String msg = "Cannot open " + pathname + " (" + e.getMessage() + ")";
						return new Status(IStatus.ERROR, FluentMkUI.PLUGIN_ID, msg);
					}
				}
			}
		}

		return null;
	}
}
