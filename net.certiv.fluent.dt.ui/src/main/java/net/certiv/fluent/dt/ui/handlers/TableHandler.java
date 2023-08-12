package net.certiv.fluent.dt.ui.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.text.edits.InsertEdit;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.text.undo.DocumentUndoManagerRegistry;
import org.eclipse.text.undo.IDocumentUndoManager;
import org.eclipse.ui.handlers.HandlerUtil;

import net.certiv.common.log.Log;
import net.certiv.common.util.Strings;
import net.certiv.dsl.core.model.ICodeUnit;
import net.certiv.dsl.core.model.Statement;
import net.certiv.dsl.core.model.builder.SourceRange;
import net.certiv.fluent.dt.core.lang.md.model.SpecializedType;
import net.certiv.fluent.dt.ui.editor.FluentEditor;
import net.certiv.fluent.dt.ui.editor.strategies.tables.TableDialog;

public class TableHandler extends AbstractDslHandler {

	private static final String TABLE = "" //
			+ "| A  | B  |" + Strings.EOL //
			+ "|----|----|" + Strings.EOL //
			+ "|    |    |" + Strings.EOL //
			+ "|    |    |" + Strings.EOL //
	;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {
			FluentEditor editor = (FluentEditor) HandlerUtil.getActiveEditor(event);
			ICodeUnit unit = editor.getInputDslElement();
			Statement stmt = (Statement) unit.getElementAtOffset(getCursorOffset(editor));
			IDocument doc = editor.getDocument();

			if (stmt.getSpecializedType() == SpecializedType.Table) {
				TableDialog dialog = new TableDialog(stmt);
				int ret = dialog.open();
				if (ret == 0) {
					String table = dialog.build();
					SourceRange range = stmt.getRange();
					editor.getViewer().setSelectedRange(range.getOffset(), 0);
					try {
						IDocumentUndoManager mgr = DocumentUndoManagerRegistry.getDocumentUndoManager(doc);
						mgr.beginCompoundChange();
						MultiTextEdit edit = new MultiTextEdit();
						edit.addChild(new ReplaceEdit(range.getOffset(), range.getLength(), table));
						edit.apply(doc);
						mgr.endCompoundChange();

					} catch (MalformedTreeException | BadLocationException e) {
						Log.error("Failed to revise table in %s [%s]", stmt, e.getMessage());
						return Status.CANCEL_STATUS;
					}
				}

			} else {
				try {
					int off = getCursorOffset(editor);
					int ln = doc.getLineOfOffset(off);
					if (isBlank(doc, ln)) {
						IDocumentUndoManager mgr = DocumentUndoManagerRegistry.getDocumentUndoManager(doc);
						mgr.beginCompoundChange();
						MultiTextEdit edit = new MultiTextEdit();
						if (!isBlank(doc, ln - 1)) {
							edit.addChild(new InsertEdit(off, Strings.EOL));
						}
						edit.addChild(new InsertEdit(off, TABLE));
						edit.apply(doc);
						mgr.endCompoundChange();
					}

				} catch (MalformedTreeException | BadLocationException e) {
					Log.error("Failed to insert new table [%s]", e.getMessage());
					return Status.CANCEL_STATUS;
				}
			}

		} catch (Exception e) {}
		return null;
	}
}
