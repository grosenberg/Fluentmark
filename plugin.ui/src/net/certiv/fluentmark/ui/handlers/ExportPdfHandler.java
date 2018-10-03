/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.ui.handlers;

import java.util.LinkedHashMap;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.text.Document;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.handlers.HandlerUtil;

import net.certiv.dsl.core.util.FileUtils;
import net.certiv.fluentmark.core.model.Page;
import net.certiv.fluentmark.ui.FluentUI;
import net.certiv.fluentmark.ui.editor.FluentEditor;
import net.certiv.fluentmark.ui.gen.PdfGen;
import net.certiv.fluentmark.ui.handlers.dialog.PdfDialog;

public class ExportPdfHandler extends AbstractHandler {

	private IFile source;
	private String template;
	private String destination;

	public ExportPdfHandler() {
		super();
	}

	public void setTemplate(String pathname) {
		this.template = pathname;
	}

	public void setDestination(String pathname) {
		this.destination = pathname;
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IEditorPart active = HandlerUtil.getActiveEditor(event);
		if (active instanceof FluentEditor) {
			FluentEditor editor = (FluentEditor) active;
			Shell shell = HandlerUtil.getActiveShell(event);

			IEditorInput input = editor.getEditorInput();
			if (input instanceof IFileEditorInput) {
				source = ((IFileEditorInput) input).getFile();
				PdfDialog pdf = new PdfDialog(shell, this, source);
				if (pdf.open() == 0) { // 0: generate; 1: cancel; -1: close
					String basepath = source.getLocation().removeLastSegments(1).addTrailingSeparator().toString();
					Document doc = new Document(editor.getDocument().get());
					Page model = editor.getPageModel(true);
					PdfGen.save(basepath, doc, model, template, destination);

					IPath location = FluentUI.getDefault().getStateLocation();

					LinkedHashMap<String, String> map = FileUtils.getTemplateMap(location);
					map.put(source.getFullPath().toString(), template); // by WS relative source pathname
					map.put(source.getName(), template); // by source filename
					FileUtils.putTemplateMap(location, map);
				}
			}
		}
		return null;
	}
}
