package net.certiv.fluent.dt.ui.handlers;

import static net.certiv.fluent.dt.ui.editor.Partitions.PARTITIONING;
import static org.eclipse.jface.text.IDocument.DEFAULT_CONTENT_TYPE;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.TextUtilities;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.SWT;

import net.certiv.dsl.ui.editor.DslEditor;

public abstract class AbstractDslHandler extends AbstractHandler {

	protected boolean samePartition(IDocument doc, int beg, int len) throws BadLocationException {
		if (len == 0)
			return TextUtilities.getContentType(doc, PARTITIONING, beg, false).equals(DEFAULT_CONTENT_TYPE);

		boolean begDef = TextUtilities.getContentType(doc, PARTITIONING, beg, false)
				.equals(DEFAULT_CONTENT_TYPE);
		boolean endDef = TextUtilities.getContentType(doc, PARTITIONING, beg + len - 1, false)
				.equals(DEFAULT_CONTENT_TYPE);

		if (begDef && endDef) {
			ITypedRegion begRegion = TextUtilities.getPartition(doc, PARTITIONING, beg, false);
			ITypedRegion endRegion = TextUtilities.getPartition(doc, PARTITIONING, beg + len - 1, false);
			if (begRegion.getOffset() == endRegion.getOffset()) return true;
		}
		return false;
	}

	protected int getCursorOffset(DslEditor editor) {
		SourceViewer viewer = editor.getViewer();
		return viewer.widgetOffset2ModelOffset(viewer.getTextWidget().getCaretOffset());
	}

	protected void setCursorOffset(DslEditor editor, int offset) {
		SourceViewer viewer = editor.getViewer();
		viewer.getTextWidget().setCaretOffset(viewer.modelOffset2WidgetOffset(offset));
	}

	protected boolean isBlank(IDocument doc, int ln) throws BadLocationException {
		int beg = doc.getLineOffset(ln);
		int len = doc.getLineLength(ln);
		return doc.get(beg, len).isBlank();
	}

	/**
	 * Determine if text exists on the line of the given offset in the given relative
	 * direction.
	 *
	 * @param doc the document
	 * @param off offset within the document
	 * @param dir relative direction from the offset
	 * @return {@code true} if text exists
	 * @throws BadLocationException
	 */
	protected boolean hasText(IDocument doc, int off, int dir) throws BadLocationException {
		int ln = doc.getLineOfOffset(off);
		int beg = doc.getLineOffset(ln);
		int len = doc.getLineLength(ln);
		String txt = doc.get(beg, len);
		if (txt.isBlank()) return false;
		if (dir == SWT.LEAD) return !txt.substring(0, off - beg).isBlank();
		return !txt.substring(off - beg).isBlank();
	}
}
