package net.certiv.fluentmark.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.text.TextUtilities;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.text.edits.DeleteEdit;
import org.eclipse.text.edits.InsertEdit;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.undo.DocumentUndoManagerRegistry;
import org.eclipse.text.undo.IDocumentUndoManager;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

import net.certiv.fluentmark.Log;
import net.certiv.fluentmark.editor.FluentEditor;
import net.certiv.fluentmark.editor.Partitions;

public abstract class AbstractMarksHandler extends AbstractHandler {

	private FluentEditor editor;
	private IDocument doc;
	private int cpos;
	private String[] markSpec;

	public abstract String[] getMark();

	public abstract boolean qualified(String mark);

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		markSpec = getMark();
		IEditorPart edPart = HandlerUtil.getActiveEditor(event);
		if (edPart instanceof FluentEditor) {
			editor = (FluentEditor) edPart;
			doc = editor.getDocument();
			if (doc != null) {
				ISelection sel = HandlerUtil.getCurrentSelection(event);
				if (sel instanceof TextSelection) {
					TextSelection tsel = (TextSelection) sel;
					int beg = tsel.getOffset();
					int len = tsel.getLength();
					cpos = editor.getCursorOffset();
					if (len == 0) beg = cpos;
					try {
						if (samePartition(beg, len)) {
							toggle(beg, len);
						}
					} catch (BadLocationException e) {}
				}
			}
		}
		return null;
	}

	private boolean samePartition(int beg, int len) throws BadLocationException {
		if (len == 0) return TextUtilities.getContentType(doc, Partitions.MK_PARTITIONING, cpos, false)
				.equals(IDocument.DEFAULT_CONTENT_TYPE);

		boolean begDef = TextUtilities.getContentType(doc, Partitions.MK_PARTITIONING, beg, false)
				.equals(IDocument.DEFAULT_CONTENT_TYPE);
		boolean endDef = TextUtilities.getContentType(doc, Partitions.MK_PARTITIONING, beg + len - 1, false)
				.equals(IDocument.DEFAULT_CONTENT_TYPE);

		if (begDef && endDef) {
			ITypedRegion begRegion = TextUtilities.getPartition(doc, Partitions.MK_PARTITIONING, beg, false);
			ITypedRegion endRegion = TextUtilities.getPartition(doc, Partitions.MK_PARTITIONING, beg + len - 1, false);
			if (begRegion.getOffset() == endRegion.getOffset()) return true;
		}
		return false;
	}

	private void toggle(int beg, int len) {
		// if surrounded by marks, remove them
		String mark = isMarked(beg, len);
		if (qualified(mark)) {
			remove(beg, len, mark.length());
			return;
		}

		if (mark == null || mark.charAt(0) == markSpec[1].charAt(0)) {
			mark = markSpec[0];
		} else {
			mark = markSpec[1];
		}

		// add surrounding marks
		IDocumentUndoManager undoMgr = DocumentUndoManagerRegistry.getDocumentUndoManager(doc);
		undoMgr.beginCompoundChange();
		MultiTextEdit edit = new MultiTextEdit();
		edit.addChild(new InsertEdit(beg, mark));
		edit.addChild(new InsertEdit(beg + len, mark));

		// // remove any included marks
		// if (len > 0) {
		// try {
		// String text = doc.get(beg, len);
		// Pattern srch = Pattern.compile(Pattern.quote(markSpec[0]));
		// Matcher matcher = srch.matcher(text);
		// while (matcher.find()) {
		// int start = matcher.start();
		// int stop = matcher.end();
		// edit.addChild(new DeleteEdit(beg + start, stop - start + 1));
		// }
		// } catch (MalformedTreeException | BadLocationException e) {}
		// }

		try {
			edit.apply(doc);
			undoMgr.endCompoundChange();
			editor.setCursorOffset(cpos + markSpec[0].length());
		} catch (MalformedTreeException | BadLocationException e) {
			Log.error("Failure applying mark" + e.getMessage());
		}
	}

	private String isMarked(int beg, int len) {
		if (beg >= 2 && beg + len + 2 < doc.getLength()) {
			try {
				String bef = doc.get(beg - 2, 2);
				String aft = doc.get(beg + len, 2);
				if (bef.equals(aft) && bef.charAt(0) == bef.charAt(1)) return bef;
			} catch (BadLocationException e) {}
		}
		if (beg >= 1 && beg + len + 1 < doc.getLength()) {
			try {
				String bef = doc.get(beg - 1, 1);
				String aft = doc.get(beg + len, 1);
				if (bef.equals(aft)) return bef;
			} catch (BadLocationException e) {}
		}
		return null;
	}

	private void remove(int beg, int len, int markLen) {
		try {
			IDocumentUndoManager undoMgr = DocumentUndoManagerRegistry.getDocumentUndoManager(doc);
			undoMgr.beginCompoundChange();

			MultiTextEdit edit = new MultiTextEdit();
			edit.addChild(new DeleteEdit(beg - markLen, markLen));
			edit.addChild(new DeleteEdit(beg + len, markLen));
			edit.apply(doc);
			undoMgr.endCompoundChange();
		} catch (MalformedTreeException | BadLocationException e) {
			Log.error("Failure removing mark" + e.getMessage());
		}
	}
}
