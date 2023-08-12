package net.certiv.fluent.dt.ui.handlers;

import static net.certiv.common.util.Strings.EOL;

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
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.undo.DocumentUndoManagerRegistry;
import org.eclipse.text.undo.IDocumentUndoManager;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

import net.certiv.common.log.Log;
import net.certiv.dsl.core.model.ICodeUnit;
import net.certiv.dsl.core.model.Statement;
import net.certiv.dsl.core.model.builder.ISpecializedType;
import net.certiv.fluent.dt.ui.editor.FluentEditor;

public abstract class AbstractBlockHandler extends AbstractDslHandler {

	private static final String ERR_MARK_APPLY = "Failure applying mark [%s]";
	private static final String ERR_MARK_REMOVE = "Failure removing mark [%s]";

	protected final LinkedHashMap<String, String> marks = new LinkedHashMap<>();

	private FluentEditor editor;
	private IDocument doc;

	public abstract ISpecializedType blockType();

	/**
	 * If in block: remove block marks<br>
	 * Not in block, nothing selected: insert empty block<br>
	 * Not in block, something selected: insert block around selection<br>
	 */
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
					int off = tsel.getOffset();
					int len = tsel.getLength();
					if (len == 0) off = getCursorOffset(editor);

					try {
						ICodeUnit unit = editor.getInputDslElement();
						Statement stmt = (Statement) unit.getElementAtOffset(off);
						if (stmt != null & stmt.getSpecializedType() == blockType()) {
							removeBlockMarks(stmt);

						} else {
							insertBlockMarks(off, len);
						}
					} catch (Exception e) {}
				}
			}
		}
		return null;
	}

	private void insertBlockMarks(int off, int len) {
		Entry<String, String> pair = marks.entrySet().stream().findFirst().orElseThrow();

		try {
			String lead = mkMark(SWT.LEAD, pair, off, len);
			String trail = mkMark(SWT.TRAIL, pair, off, len);

			IDocumentUndoManager mgr = DocumentUndoManagerRegistry.getDocumentUndoManager(doc);
			mgr.beginCompoundChange();
			MultiTextEdit edit = new MultiTextEdit();
			edit.addChild(new InsertEdit(off, lead));
			edit.addChild(new InsertEdit(off + len, trail));
			edit.apply(doc);
			mgr.endCompoundChange();

			setCursorOffset(editor, off + lead.length());
		} catch (Exception e) {
			Log.error(ERR_MARK_APPLY, e.getMessage());
		}
	}

	private String mkMark(int dir, Entry<String, String> pair, int off, int len) throws BadLocationException {
		if (SWT.LEAD == dir) {
			String lead = EOL;
			if (hasText(doc, off, SWT.LEAD) || !isBlank(doc, doc.getLineOfOffset(off) - 1)) {
				lead += EOL;
			}
			return lead + pair.getKey() + EOL;
		}

		String trail = EOL + pair.getValue() + EOL;
		if (hasText(doc, off + len, SWT.TRAIL) || !isBlank(doc, doc.getLineOfOffset(off) + 1)) {
			trail += EOL;
		}
		return trail;
	}

	private void removeBlockMarks(Statement stmt) {
		try {
			int off = stmt.getOffset();
			int ln = doc.getLineOfOffset(off);
			int begOff = doc.getLineOffset(ln);
			int begLen = doc.getLineLength(ln);

			off = stmt.getOffset() + stmt.getLength();
			ln = doc.getLineOfOffset(off);
			int endOff = doc.getLineOffset(ln);
			int endLen = doc.getLineLength(ln);

			IDocumentUndoManager mgr = DocumentUndoManagerRegistry.getDocumentUndoManager(doc);
			mgr.beginCompoundChange();

			MultiTextEdit edit = new MultiTextEdit();
			edit.addChild(new DeleteEdit(begOff, begLen));
			edit.addChild(new DeleteEdit(endOff, endLen));
			edit.apply(doc);
			mgr.endCompoundChange();
		} catch (Exception e) {
			Log.error(ERR_MARK_REMOVE, e.getMessage());
		}
	}
}
