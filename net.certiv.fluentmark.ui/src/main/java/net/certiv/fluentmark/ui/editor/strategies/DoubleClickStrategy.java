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

import net.certiv.dsl.core.log.Log;
import net.certiv.dsl.core.model.DslModelException;
import net.certiv.dsl.core.model.ICodeUnit;
import net.certiv.dsl.core.model.IStatement;
import net.certiv.dsl.core.model.builder.ISourceRange;
import net.certiv.fluentmark.core.model.ModelUtil;
import net.certiv.fluentmark.ui.dialog.tables.TableDialog;
import net.certiv.fluentmark.ui.editor.FluentEditor;

public class DoubleClickStrategy extends DefaultTextDoubleClickStrategy {

	private FluentEditor editor;
	private ICodeUnit unit;
	private IStatement stmt;

	public DoubleClickStrategy(ITextEditor editor) {
		super();
		this.editor = (FluentEditor) editor;
	}

	@Override
	public void doubleClicked(ITextViewer viewer) {
		final int offset = viewer.getSelectedRange().x;
		if (offset < 0) return;

		unit = editor.getInputDslElement();
		try {
			stmt = unit.getElementAtOffset(offset);
			switch (ModelUtil.getModelType(stmt)) {
				case Table:
					runTableEditor();
					return;

				default:
			}
		} catch (DslModelException e) {}
		super.doubleClicked(viewer);
	}

	private void runTableEditor() {
		UIJob job = new UIJob("Table editor") {

			@Override
			public IStatus runInUIThread(IProgressMonitor monitor) {
				TableDialog dialog = new TableDialog(stmt);
				int ret = dialog.open();
				if (ret == 0) {
					String newTable = dialog.build();
					ISourceRange range;
					try {
						range = stmt.getSourceRange();
					} catch (DslModelException e) {
						return Status.CANCEL_STATUS;
					}

					editor.getViewer().setSelectedRange(range.getOffset(), 0);
					TextEdit edit = new ReplaceEdit(range.getOffset(), range.getLength(), newTable);
					try {
						edit.apply(editor.getDocument());
					} catch (MalformedTreeException | BadLocationException e) {
						Log.error(this, "Failed to insert new table in stmt " + stmt + " (" + e.getMessage() + ")");
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
