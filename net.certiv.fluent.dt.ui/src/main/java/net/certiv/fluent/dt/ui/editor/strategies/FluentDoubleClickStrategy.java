/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluent.dt.ui.editor.strategies;

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

import net.certiv.common.log.Log;
import net.certiv.dsl.core.model.ICodeUnit;
import net.certiv.dsl.core.model.IStatement;
import net.certiv.dsl.core.model.ModelException;
import net.certiv.dsl.core.model.Statement;
import net.certiv.dsl.core.model.builder.SourceRange;
import net.certiv.fluent.dt.core.model.SpecUtil;
import net.certiv.fluent.dt.ui.editor.FluentEditor;
import net.certiv.fluent.dt.ui.editor.strategies.tables.TableDialog;

public class FluentDoubleClickStrategy extends DefaultTextDoubleClickStrategy {

	private FluentEditor editor;
	private ICodeUnit unit;
	private IStatement stmt;

	public FluentDoubleClickStrategy(ITextEditor editor) {
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
			if (stmt != null) {
				switch (SpecUtil.getSpecializedType(stmt)) {
					case Table:
						runTableEditor((Statement) stmt);
						return;

					default:
				}
			} else {
				Log.debug("[DoubleClick] Table statement not found at offset %s", offset);
			}
		} catch (ModelException e) {
			Log.error(e, "Table double click @%s", offset);
		}
		super.doubleClicked(viewer);
	}

	private void runTableEditor(Statement stmt) {
		UIJob job = new UIJob("Table editor") {

			@Override
			public IStatus runInUIThread(IProgressMonitor monitor) {
				TableDialog dialog = new TableDialog(stmt);
				int ret = dialog.open();
				if (ret == 0) {
					String newTable = dialog.build();
					SourceRange range = stmt.getRange();
					editor.getViewer().setSelectedRange(range.getOffset(), 0);
					TextEdit edit = new ReplaceEdit(range.getOffset(), range.getLength(), newTable);
					try {
						edit.apply(editor.getDocument());
					} catch (MalformedTreeException | BadLocationException e) {
						Log.error("Failed to insert new table in stmt " + stmt + " (" + e.getMessage() + ")");
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
