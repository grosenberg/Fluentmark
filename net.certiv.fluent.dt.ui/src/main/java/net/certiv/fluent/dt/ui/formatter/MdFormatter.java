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
import net.certiv.common.util.Chars;
import net.certiv.common.util.Strings;
import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.core.formatter.BaseCodeFormatter;
import net.certiv.dsl.core.model.CodeUnit;
import net.certiv.dsl.core.model.IStatement;
import net.certiv.dsl.core.model.ModelException;
import net.certiv.dsl.core.model.builder.SourceRange;
import net.certiv.dsl.core.preferences.IPrefsManager;
import net.certiv.dsl.core.preferences.consts.Editor;
import net.certiv.dsl.core.util.CoreUtil;
import net.certiv.dsl.core.util.Indent;
import net.certiv.fluent.dt.core.FluentCore;
import net.certiv.fluent.dt.core.lang.md.model.SpecializationType;
import net.certiv.fluent.dt.core.model.SpecUtil;
import net.certiv.fluent.dt.core.preferences.Prefs;
import net.certiv.fluent.dt.ui.editor.FluentEditor;
import net.certiv.fluent.dt.ui.editor.strategies.tables.TableModel;

public class MdFormatter extends BaseCodeFormatter {

	private int cols;
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
			String lineSeparator, IPrefsManager store) {

		setPrefsManager(store);
		checkCanceled();
		if (!getDslCore().FormatterLock.tryLock()) return null;

		try {
			long startTime = System.currentTimeMillis();
			if (store.getBoolean(Prefs.FORMATTER_UNWRAP)) {
				cols = 0;
			} else {
				cols = store.getInt(Prefs.FORMATTER_WRAP_COLUMN);
			}
			tabWidth = store.getInt(Editor.EDITOR_TAB_WIDTH);

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
						format(stmt, edits, delim);
					}

					// complete and return the edits
					long currentTime = System.currentTimeMillis() - startTime;
					Log.info(this, "Formatting pass (" + currentTime + "ms)");
					return edits;
				}
			}

		} catch (ModelException e) {
			Log.error(this, e.getLocalizedMessage());
		} finally {
			getDslCore().FormatterLock.unlock();
		}

		return null;
	}

	private void format(IStatement stmt, TextEdit edit, String delim) {
		switch (SpecUtil.getSpecializedType(stmt)) {
			case Terminal:
				formatBlank(stmt, edit, delim);
				break;
			case Paragraph:
				formatText(stmt, edit, delim, cols);
				break;
			case ListUnordered:
				formatList(stmt, edit, delim, cols, tabWidth);
				break;
			case Table:
				formatTable(stmt, edit, delim);
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

	private void formatTable(IStatement stmt, TextEdit edit, String delim) {
		TableModel table = new TableModel(delim);
		table.load(stmt);
		SourceRange range = stmt.getRange();
		String content = table.build();
		if (content != null) edit.addChild(new ReplaceEdit(range.getOffset(), range.getLength(), content));
	}

	private void formatText(IStatement stmt, TextEdit edit, String delim, int cols) {
		try {
			SourceRange range = stmt.getRange();
			int offset = range.getOffset();
			int len = range.getLength();

			String content = stmt.getSource();
			content = TextFormatter.wrap(content, cols, delim);

			edit.addChild(new ReplaceEdit(offset, len, content));
		} catch (MalformedTreeException | BadLocationException e) {
			Log.error(this, e.getMessage(), e);
		}
	}

	private void formatList(IStatement stmt, TextEdit edit, String delim, int cols, int tabWidth) {
		for (IStatement listItem : SpecUtil.getChildren(stmt, SpecializationType.ListItem)) {
			formatListItem(stmt, listItem, edit, delim, cols, tabWidth);
		}
	}

	private void formatListItem(IStatement stmt, IStatement listItem, TextEdit edit, String delim, int cols,
			int tabWidth) {
		try {
			SourceRange range = listItem.getRange();
			int offset = range.getOffset();
			int len = range.getLength();

			String content = listItem.getSource();
			int indent = Indent.measureIndentInTabs(content, tabWidth);
			int markWidth = listMarkWidth(content);
			content = TextFormatter.wrap(content, cols, delim, tabWidth * indent,
					(tabWidth * indent) + markWidth);

			edit.addChild(new ReplaceEdit(offset, len, content));
		} catch (MalformedTreeException | BadLocationException e) {
			Log.error(this, e.getMessage(), e);
		}
	}

	private int listMarkWidth(String item) {
		String line = item.trim();
		char c = line.charAt(0);
		switch (c) {
			case Chars.DASH:
			case Chars.PLUS:
			case Chars.STAR:
				return 2;

			default:
				int dot = line.indexOf(Chars.DOT);
				if (dot > 0) return dot + 2;
		}
		return 0;
	}
}
