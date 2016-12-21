package net.certiv.fluentmark.editor.strategies;

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

import net.certiv.fluentmark.Log;
import net.certiv.fluentmark.editor.FluentMkEditor;
import net.certiv.fluentmark.model.ISourceRange;
import net.certiv.fluentmark.model.Kind;
import net.certiv.fluentmark.model.PagePart;
import net.certiv.fluentmark.model.PageRoot;
import net.certiv.fluentmk.tables.TableViewDialog;

public class DoubleClickStrategy extends DefaultTextDoubleClickStrategy {

	private FluentMkEditor editor;

	public DoubleClickStrategy(ITextEditor editor) {
		super();
		this.editor = (FluentMkEditor) editor;
	}

	@Override
	public void doubleClicked(ITextViewer viewer) {
		final int offset = viewer.getSelectedRange().x;
		if (offset < 0) return;

		PageRoot model = editor.getPageModel();
		PagePart part = model.partAtOffset(offset);

		if (part.getKind() != Kind.TABLE) {
			super.doubleClicked(viewer);
			return;
		}

		UIJob job = new UIJob("Table editor") {

			@Override
			public IStatus runInUIThread(IProgressMonitor monitor) {
				TableViewDialog dialog = new TableViewDialog(part);
				int ret = dialog.open();
				if (ret == 0) {
					String newTable = dialog.build();
					ISourceRange range = part.getSourceRange();
					editor.getViewer().setSelectedRange(range.getOffset(), 0);
					TextEdit edit = new ReplaceEdit(range.getOffset(), range.getLength(), newTable);
					try {
						edit.apply(editor.getDocument());
					} catch (MalformedTreeException | BadLocationException e) {
						Log.error("Failed to insert new table in part " + part + " (" + e.getMessage() + ")");
						return Status.CANCEL_STATUS;
					}
				}
				return Status.OK_STATUS;
			}
		};
		job.setPriority(Job.INTERACTIVE);
		job.schedule();
	}
}
