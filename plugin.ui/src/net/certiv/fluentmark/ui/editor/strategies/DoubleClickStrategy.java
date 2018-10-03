/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.ui.editor.strategies;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DefaultTextDoubleClickStrategy;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.ui.progress.UIJob;
import org.eclipse.ui.texteditor.ITextEditor;

import net.certiv.dsl.core.model.util.ISourceRange;
import net.certiv.dsl.core.util.Log;
import net.certiv.fluentmark.core.model.IPageElement;
import net.certiv.fluentmark.core.model.Page;
import net.certiv.fluentmark.core.model.PagePart;
import net.certiv.fluentmark.ui.dialog.graphs.DotDialog;
import net.certiv.fluentmark.ui.dialog.tables.TableDialog;
import net.certiv.fluentmark.ui.editor.FluentEditor;

public class DoubleClickStrategy extends DefaultTextDoubleClickStrategy {

	private FluentEditor editor;
	private Page model;
	private PagePart part;

	public DoubleClickStrategy(ITextEditor editor) {
		super();
		this.editor = (FluentEditor) editor;
	}

	@Override
	public void doubleClicked(ITextViewer viewer) {
		final int offset = viewer.getSelectedRange().x;
		if (offset < 0) return;

		model = editor.getPageModel();
		part = model.partAtOffset(offset);

		switch (part.getItem()) {
			case CODE_BLOCK:
				if (part.getMeta().toLowerCase().equals(IPageElement.DOT)) {
					runDotEditor();
					return;
				}

			case TABLE:
				runTableEditor();
				return;

			default:
		}

		super.doubleClicked(viewer);
	}

	private void runDotEditor() {
		UIJob job = new UIJob("Dot editor") {

			@Override
			public IStatus runInUIThread(IProgressMonitor monitor) {
				DotDialog dialog = new DotDialog(part);
				int ret = dialog.open();
				if (ret == 0) {
					// String newTable = dialog.build();
					// ISourceRange range = part.getSourceRange();
					// editor.getViewer().setSelectedRange(range.getOffset(), 0);
					// TextEdit edit = new ReplaceEdit(range.getOffset(), range.getLength(), newTable);
					// try {
					// edit.apply(editor.getDocument());
					// } catch (MalformedTreeException | BadLocationException e) {
					// Log.error("Failed to insert new table in part " + part + " (" + e.getMessage() + ")");
					// return Status.CANCEL_STATUS;
					// }
				}
				return Status.OK_STATUS;
			}
		};
		job.setPriority(Job.INTERACTIVE);
		job.schedule(200);
	}

	private void runTableEditor() {
		UIJob job = new UIJob("Table editor") {

			@Override
			public IStatus runInUIThread(IProgressMonitor monitor) {
				TableDialog dialog = new TableDialog(part);
				int ret = dialog.open();
				if (ret == 0) {
					String newTable = dialog.build();
					ISourceRange range = part.getSourceRange();
					editor.getViewer().setSelectedRange(range.getOffset(), 0);
					TextEdit edit = new ReplaceEdit(range.getOffset(), range.getLength(), newTable);
					try {
						edit.apply(editor.getDocument());
					} catch (MalformedTreeException | BadLocationException e) {
						Log.error(this, "Failed to insert new table in part " + part + " (" + e.getMessage() + ")");
						return Status.CANCEL_STATUS;
					}
				}
				return Status.OK_STATUS;
			}
		};
		job.setPriority(Job.INTERACTIVE);
		job.schedule(200);
	}
}
