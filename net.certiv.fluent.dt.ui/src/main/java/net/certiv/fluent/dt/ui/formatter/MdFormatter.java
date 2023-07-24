package net.certiv.fluent.dt.ui.formatter;

import java.util.List;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextUtilities;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.ui.IEditorPart;

import net.certiv.common.log.Log;
import net.certiv.common.util.Strings;
import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.core.formatter.BaseCodeFormatter;
import net.certiv.dsl.core.model.CodeUnit;
import net.certiv.dsl.core.model.IStatement;
import net.certiv.dsl.core.model.ModelException;
import net.certiv.dsl.core.model.Statement;
import net.certiv.dsl.core.model.builder.SourceRange;
import net.certiv.dsl.core.preferences.IPrefsManager;
import net.certiv.dsl.core.preferences.consts.Editor;
import net.certiv.dsl.core.util.CoreUtil;
import net.certiv.dsl.core.util.Indent;
import net.certiv.fluent.dt.core.FluentCore;
import net.certiv.fluent.dt.core.lang.md.model.SpecializationType;
import net.certiv.fluent.dt.core.model.SpecUtil;
import net.certiv.fluent.dt.ui.editor.FluentEditor;
import net.certiv.fluent.dt.ui.editor.strategies.tables.TableModel;

public class MdFormatter extends BaseCodeFormatter {

	private int tabWidth;
	private int docLength;

	public MdFormatter() {
		super();
	}

	@Override
	public DslCore getDslCore() {
		return FluentCore.getDefault();
	}

	@Override
	public TextEdit format(int kind, String content, int offset, int length, int indentLevel,
			String lineSeparator, IPrefsManager mgr) {

		setPrefsManager(mgr);
		checkCanceled();
		if (!getDslCore().FormatterLock.tryLock()) return null;

		try {
			long startTime = System.currentTimeMillis();
			tabWidth = mgr.getInt(Editor.EDITOR_TAB_WIDTH);

			IEditorPart active = CoreUtil.getActiveEditor();
			if (active instanceof FluentEditor) {
				FluentEditor editor = (FluentEditor) active;
				IDocument doc = editor.getDocument();
				if (doc.get().equals(content)) {
					CodeUnit unit = (CodeUnit) editor.getInputDslElement();

					SourceRange target = new SourceRange(offset, length);
					List<IStatement> stmts = unit.getElements(target);

					TextEdit edits = new MultiTextEdit();
					String delim = TextUtilities.getDefaultLineDelimiter(doc);

					for (IStatement stmt : stmts) {
						format((Statement) stmt, edits, delim);
					}

					// complete and return the edits
					long currentTime = System.currentTimeMillis() - startTime;
					Log.info("Formatting pass (" + currentTime + "ms)");
					return edits;
				}
			}

		} catch (ModelException e) {
			Log.error(e.getLocalizedMessage());
		} finally {
			getDslCore().FormatterLock.unlock();
		}

		return null;
	}

	private void format(Statement stmt, TextEdit edit, String delim) {
		switch (SpecUtil.getSpecializedType(stmt)) {
			case Terminal:
				formatBlank(stmt, edit, delim);
				break;
			case Paragraph:
				formatPara(stmt, edit, delim);
				break;
			case ListUnordered:
				formatList(stmt, edit, delim, tabWidth);
				break;
			case Table:
				formatTable(stmt, edit, delim);
				break;
			case HtmlBlock:
				break;
			default:
				break;
		}
	}

	private void formatBlank(IStatement stmt, TextEdit edit, String delim) {
		SourceRange range = stmt.getRange();
		int eols = range.getEndLine() - range.getBegLine() + 1;
		String rep = Strings.dup(eols, delim);
		if (range.getOffset() + range.getLength() <= docLength) {
			edit.addChild(new ReplaceEdit(range.getOffset(), range.getLength(), rep));
		}
	}

	private void formatTable(Statement stmt, TextEdit edit, String delim) {
		SourceRange range = stmt.getRange();
		int offset = range.getOffset();
		int len = range.getLength();

		try {
			TableModel table = new TableModel(delim);
			table.load(stmt);
			String content = table.build();
			if (content != null) {
				edit.addChild(new ReplaceEdit(offset, len, content));
			}

		} catch (MalformedTreeException e) {
			Log.error("Table @%s:%s [%s]", offset, offset + len, e.getMessage());
		}
	}

	private void formatPara(Statement stmt, TextEdit edit, String delim) {
		if (stmt.getParent() != null) {
			if (stmt.getParent().getSpecializedType() == SpecializationType.ListItem) {
				return; // skip paragraph statements in lists
			}
		}

		SourceRange range = stmt.getRange();
		int offset = range.getOffset();
		int len = range.getLength();

		try {
			String content = stmt.getSource();
			content = TextFormatter.para(content, delim);

			edit.addChild(new ReplaceEdit(offset, len, content));

		} catch (MalformedTreeException | BadLocationException e) {
			Log.error("Text @%s:%s [%s]", offset, offset + len, e.getMessage());
		}
	}

	private void formatList(Statement stmt, TextEdit edit, String delim, int tabWidth) {
		for (IStatement item : SpecUtil.getChildren(stmt, SpecializationType.ListItem)) {

			SourceRange range = item.getRange();
			int offset = range.getOffset();
			int len = range.getLength();

			try {
				String content = item.getSource();
				int level = Indent.measureIndentInTabs(content, tabWidth);
				int indent = level * tabWidth;
				content = TextFormatter.list(content, indent, delim);

				edit.addChild(new ReplaceEdit(offset, len, content));

			} catch (MalformedTreeException | BadLocationException e) {
				Log.error("List @%s:%s [%s]", offset, offset + len, e.getMessage());
			}
		}
	}
}
