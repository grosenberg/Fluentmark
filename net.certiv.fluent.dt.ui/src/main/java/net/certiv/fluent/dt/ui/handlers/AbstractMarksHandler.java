package net.certiv.fluent.dt.ui.handlers;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.text.edits.DeleteEdit;
import org.eclipse.text.edits.InsertEdit;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.undo.DocumentUndoManagerRegistry;
import org.eclipse.text.undo.IDocumentUndoManager;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

import net.certiv.common.log.Log;
import net.certiv.fluent.dt.ui.editor.FluentEditor;

public abstract class AbstractMarksHandler extends AbstractDslHandler {

	private static final String ERR_MARK = "Failure removing mark [%s]";

	protected final LinkedHashMap<String, String> marks = new LinkedHashMap<>();

	private FluentEditor editor;
	private IDocument doc;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IEditorPart part = HandlerUtil.getActiveEditor(event);
		if (part instanceof FluentEditor) {
			editor = (FluentEditor) part;
			doc = editor.getDocument();
			if (doc != null) {
				ISelection sel = HandlerUtil.getCurrentSelection(event);
				if (sel instanceof TextSelection) {
					TextSelection tsel = (TextSelection) sel;
					int beg = tsel.getOffset();
					int len = tsel.getLength();

					if (len == 0) beg = getCursorOffset(editor);
					try {
						if (samePartition(doc, beg, len)) {
							toggle(beg, len);
						}
					} catch (BadLocationException e) {}
				}
			}
		}
		return null;
	}

	private void toggle(int beg, int len) {
		String[] pair = inlineMarks(beg, len);
		if (pair != null) {
			remove(beg, len, pair); // remove surrounding marks
			return;
		}

		Entry<String, String> first = marks.entrySet().stream().findFirst().orElseThrow();
		String left = mkMark(first, SWT.LEFT);
		String right = mkMark(first, SWT.RIGHT);

		// insert surrounding marks
		IDocumentUndoManager mgr = DocumentUndoManagerRegistry.getDocumentUndoManager(doc);
		mgr.beginCompoundChange();
		MultiTextEdit edit = new MultiTextEdit();

		edit.addChild(new InsertEdit(beg, left));
		edit.addChild(new InsertEdit(beg + len, right));

		try {
			edit.apply(doc);
			mgr.endCompoundChange();
			setCursorOffset(editor, beg + left.length());
		} catch (MalformedTreeException | BadLocationException e) {
			Log.error("Failure applying mark" + e.getMessage());
		}
	}

	private String mkMark(Entry<String, String> first, int end) {
		return SWT.LEFT == end ? first.getKey() : first.getValue();
	}

	private String[] inlineMarks(int beg, int len) {
		for (String left : marks.keySet()) {
			if (startsWith(left, beg)) {
				String right = marks.get(left);
				if (endsWith(right, beg + len)) {
					return new String[] { left, right };
				}
			}
		}
		return null;
	}

	private boolean startsWith(String left, int beg) {
		int len = left.length();
		if (beg >= len) {
			try {
				String bef = doc.get(beg - len, len);
				if (left.equals(bef)) return true;
			} catch (BadLocationException e) {}
		}
		return false;
	}

	private boolean endsWith(String right, int end) {
		int len = right.length();
		if (end + 1 < doc.getLength()) {
			try {
				String aft = doc.get(end, len);
				if (right.equals(aft)) return true;
			} catch (BadLocationException e) {}
		}
		return false;
	}

	private void remove(int beg, int len, String[] marks) {
		int bef = marks[0].length();
		int aft = marks[1].length();

		try {
			IDocumentUndoManager mgr = DocumentUndoManagerRegistry.getDocumentUndoManager(doc);
			mgr.beginCompoundChange();

			MultiTextEdit edit = new MultiTextEdit();
			edit.addChild(new DeleteEdit(beg - bef, bef));
			edit.addChild(new DeleteEdit(beg + len, aft));
			edit.apply(doc);
			mgr.endCompoundChange();
		} catch (MalformedTreeException | BadLocationException e) {
			Log.error(ERR_MARK, e.getMessage());
		}
	}
}
