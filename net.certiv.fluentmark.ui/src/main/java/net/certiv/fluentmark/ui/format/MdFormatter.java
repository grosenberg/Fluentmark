package net.certiv.fluentmark.ui.format;

import java.util.List;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextUtilities;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.ui.IEditorPart;

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.core.formatter.BaseCodeFormatter;
import net.certiv.dsl.core.log.Log;
import net.certiv.dsl.core.model.CodeUnit;
import net.certiv.dsl.core.model.DslModelException;
import net.certiv.dsl.core.model.IStatement;
import net.certiv.dsl.core.model.Statement;
import net.certiv.dsl.core.model.builder.ISourceRange;
import net.certiv.dsl.core.model.builder.SourceRange;
import net.certiv.dsl.core.preferences.IDslPrefsManager;
import net.certiv.dsl.core.util.CoreUtil;
import net.certiv.dsl.core.util.Indent;
import net.certiv.dsl.core.util.Strings;
import net.certiv.fluentmark.core.FluentCore;
import net.certiv.fluentmark.core.model.ModelType;
import net.certiv.fluentmark.core.model.ModelUtil;
import net.certiv.fluentmark.core.preferences.Prefs;
import net.certiv.fluentmark.ui.dialog.tables.TableModel;
import net.certiv.fluentmark.ui.editor.FluentEditor;

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
	public TextEdit format(int kind, String content, int offset, int length, int indentLevel, String lineSeparator,
			IDslPrefsManager store) {

		setPrefsManager(store);
		checkCanceled();
		if (!getDslCore().FormatterLock.tryLock()) return null;

		try {
			long startTime = System.currentTimeMillis();
			if (store.getBoolean(Prefs.EDITOR_FORMATTING_UNWRAP)) {
				cols = 0;
			} else {
				cols = store.getInt(Prefs.EDITOR_FORMATTING_COLUMN);
			}
			tabWidth = store.getInt(Prefs.EDITOR_TAB_WIDTH);

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

		} catch (DslModelException e) {
			Log.error(this, e.getLocalizedMessage());
		} finally {
			getDslCore().FormatterLock.unlock();
		}

		return null;
	}

	private void format(IStatement stmt, TextEdit edit, String delim) {
		switch (ModelUtil.getModelType(stmt)) {
			case Terminal:
				formatBlank(stmt, edit, delim);
				break;
			case Paragraph:
				formatText(stmt, edit, delim, cols);
				break;
			case List:
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
		ISourceRange range = stmt.getSourceRangeChecked();
		int eols = range.getEndLine() - range.getBegLine() + 1;
		String rep = Strings.dup(eols, delim);
		if (range.getOffset() + range.getLength() <= docLength) {
			edit.addChild(new ReplaceEdit(range.getOffset(), range.getLength(), rep));
		}
	}

	private void formatTable(IStatement stmt, TextEdit edit, String delim) {
		TableModel table = new TableModel(delim);
		table.load((Statement) stmt);
		ISourceRange range = stmt.getSourceRangeChecked();
		String content = table.build();
		if (content != null) edit.addChild(new ReplaceEdit(range.getOffset(), range.getLength(), content));
	}

	private void formatText(IStatement stmt, TextEdit edit, String delim, int cols) {
		try {
			ISourceRange range = stmt.getSourceRange();
			int offset = range.getOffset();
			int len = range.getLength() - delim.length();
			if (len <= 0) return;

			String content = stmt.getSource();
			content = TextFormatter.wrap(content, cols, delim);

			edit.addChild(new ReplaceEdit(offset, len, content));
		} catch (DslModelException | MalformedTreeException e) {}
	}

	private void formatList(IStatement stmt, TextEdit edit, String delim, int cols, int tabWidth) {
		for (IStatement listItem : ModelUtil.getChildren(stmt, ModelType.ListItem)) {
			formatListItem(stmt, listItem, edit, delim, cols, tabWidth);
		}
	}

	private void formatListItem(IStatement stmt, IStatement listItem, TextEdit edit, String delim, int cols,
			int tabWidth) {
		try {
			ISourceRange range = listItem.getSourceRange();
			int offset = range.getOffset();
			int len = range.getLength() - delim.length();
			if (len <= 0) return;

			String content = listItem.getSource();
			int indent = Indent.measureIndentInTabs(content, tabWidth);
			int markWidth = listMarkWidth(content);
			content = TextFormatter.wrap(content, cols, delim, tabWidth * indent, (tabWidth * indent) + markWidth);

			edit.addChild(new ReplaceEdit(offset, len, content));
		} catch (DslModelException | MalformedTreeException e) {}
	}

	private int listMarkWidth(String item) {
		String line = item.trim();
		char c = line.charAt(0);
		switch (c) {
			case '-':
			case '+':
			case '*':
				return 2;

			default:
				int dot = line.indexOf('.');
				if (dot > 0) return dot + 2;
		}
		return 0;
	}
}
