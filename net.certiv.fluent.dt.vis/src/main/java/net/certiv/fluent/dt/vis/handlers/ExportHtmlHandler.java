/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluent.dt.vis.handlers;

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

import net.certiv.common.util.FsUtil;
import net.certiv.dsl.ui.DslUI;
import net.certiv.fluent.dt.core.FluentCore;
import net.certiv.fluent.dt.core.preferences.Prefs;
import net.certiv.fluent.dt.ui.editor.FluentEditor;
import net.certiv.fluent.dt.vis.FluentVis;
import net.certiv.fluent.dt.vis.convert.HtmlGen;
import net.certiv.fluent.dt.vis.convert.Kind;

public class ExportHtmlHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		FluentEditor editor = (FluentEditor) HandlerUtil.getActiveEditorChecked(event);
		Shell shell = HandlerUtil.getActiveShellChecked(event);

		IEditorInput input = editor.getEditorInput();
		if (input instanceof IFileEditorInput) {
			IFile file = ((IFileEditorInput) input).getFile();
			IPath path = file.getLocation().removeFileExtension().addFileExtension("html");
			String base = path.removeLastSegments(1).addTrailingSeparator().toString();
			String name = path.lastSegment();

			FileDialog dialog = new FileDialog(shell, SWT.SAVE);
			dialog.setFilterNames(new String[] { "Html Files", "All Files (*.*)" });
			dialog.setFilterExtensions(new String[] { "*.html", "*.*" });
			dialog.setFilterPath(base);
			dialog.setFileName(name);

			String pathname = dialog.open();
			if (pathname != null) {
				HtmlGen gen = new HtmlGen(editor, FluentVis.getDefault().getConverter());
				String content = gen.getHtml(Kind.EXPORT);
				FsUtil.write(new File(pathname), content);
			}

			if (FluentCore.getDefault().getPrefsManager().getBoolean(Prefs.VIEW_HTML_OPEN)) {
				if (Desktop.isDesktopSupported()) {
					try {
						Desktop.getDesktop().open(new File(pathname));
					} catch (Exception e) {
						String msg = "Cannot open " + pathname + " (" + e.getMessage() + ")";
						return new Status(IStatus.ERROR, DslUI.PLUGIN_ID, msg);
					}
				}
			}
		}

		return null;
	}
}
