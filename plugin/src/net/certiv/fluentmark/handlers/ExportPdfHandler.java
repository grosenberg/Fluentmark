/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.handlers;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.text.Document;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.handlers.HandlerUtil;

import net.certiv.fluentmark.convert.PdfGen;
import net.certiv.fluentmark.editor.FluentMkEditor;
import net.certiv.fluentmark.model.PagePart;
import net.certiv.fluentmark.model.PageRoot;
import net.certiv.fluentmark.model.Type;

public class ExportPdfHandler extends AbstractHandler {

	public ExportPdfHandler() {
		super();
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		FluentMkEditor editor = (FluentMkEditor) HandlerUtil.getActiveEditor(event);
		Shell shell = HandlerUtil.getActiveShell(event);

		IEditorInput input = editor.getEditorInput();
		if (input instanceof IFileEditorInput) {
			IFile file = ((IFileEditorInput) input).getFile();
			IPath path = file.getLocation().removeFileExtension().addFileExtension("pdf");
			String base = path.removeLastSegments(1).addTrailingSeparator().toString();
			String name = path.lastSegment();

			FileDialog dialog = new FileDialog(shell, SWT.SAVE);
			dialog.setFilterNames(new String[] { "PDF Files", "All Files (*.*)" });
			dialog.setFilterExtensions(new String[] { "*.pdf", "*.*" });
			dialog.setFilterPath(base);
			dialog.setFileName(name);

			String pathname = dialog.open();
			if (pathname != null) {
				PageRoot model = editor.getPageModel(true);
				List<PagePart> parts = model.getPageParts(Type.CODE_BLOCK);
				String md = editor.getDocument().get();
				PdfGen.save(base, new Document(md), parts, pathname);
			}
		}
		return null;
	}
}
