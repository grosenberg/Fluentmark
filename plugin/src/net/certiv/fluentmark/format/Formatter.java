package net.certiv.fluentmark.format;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.text.undo.DocumentUndoManagerRegistry;
import org.eclipse.text.undo.IDocumentUndoManager;

import net.certiv.fluentmark.Log;
import net.certiv.fluentmark.dialog.tables.TableModel;
import net.certiv.fluentmark.editor.FluentEditor;
import net.certiv.fluentmark.model.ISourceRange;
import net.certiv.fluentmark.model.PagePart;
import net.certiv.fluentmark.model.PageRoot;
import net.certiv.fluentmark.preferences.Prefs;
import net.certiv.fluentmark.util.Indent;
import net.certiv.fluentmark.util.Strings;

public class Formatter {

	private static int cols;
	private static int tabWidth;
	private static int docLength;

	public static void format(FluentEditor editor, ITextSelection sel) {
		IPreferenceStore store = editor.getPrefsStore();
		cols = store.getInt(Prefs.EDITOR_FORMATTING_COLUMN);
		tabWidth = store.getInt(Prefs.EDITOR_TAB_WIDTH);

		doFormat(editor, sel);
	}

	public static void unwrap(FluentEditor editor, ITextSelection sel) {
		IPreferenceStore store = editor.getPrefsStore();
		cols = 0;
		tabWidth = store.getInt(Prefs.EDITOR_TAB_WIDTH);

		doFormat(editor, sel);
	}

	private static void doFormat(FluentEditor editor, ITextSelection sel) {
		IDocument doc = editor.ensureLastLineBlank().getDocument();
		if (doc == null || doc.getLength() == 0) return;

		docLength = doc.getLength();

		try {
			PageRoot model = editor.getPageModel();
			List<PagePart> parts = model.getPageParts();
			if (sel != null && sel.getLength() > 0) {
				parts = selectedParts(model, sel);
			}

			IDocumentUndoManager undoMgr = DocumentUndoManagerRegistry.getDocumentUndoManager(doc);
			undoMgr.beginCompoundChange();
			TextEdit edit = new MultiTextEdit();
			for (PagePart part : parts) {
				formatPagePart(part, edit);
			}
			edit.apply(editor.getDocument());
			undoMgr.endCompoundChange();
		} catch (Exception ex) {
			Log.error("Bad location error occurred during formatting", ex);
		}
	}

	private static List<PagePart> selectedParts(PageRoot model, ITextSelection sel) {
		List<PagePart> selected = new ArrayList<>();
		int begOffset = sel.getOffset();
		int endOffset = sel.getOffset() + sel.getLength();
		PagePart beg = model.partAtOffset(begOffset);
		PagePart end = model.partAtOffset(endOffset);

		for (int idx = beg.getPartIdx(); idx <= end.getPartIdx(); idx++) {
			selected.add(model.getPagePart(idx));
		}
		return selected;
	}

	private static void formatPagePart(PagePart part, TextEdit edit) {
		switch (part.getKind()) {
			case BLANK:
				formatBlank(part, edit);
				break;
			case TEXT:
				formatText(part, edit, cols);
				break;
			case LIST:
				formatList(part, edit, cols, tabWidth);
				break;
			case TABLE:
				formatTable(part, edit);
				break;
			default:
				break;
		}
	}

	private static void formatBlank(PagePart part, TextEdit edit) {
		ISourceRange range = part.getSourceRange();
		int eols = range.getEndLine() - range.getBeginLine() + 1;
		String rep = Strings.dup(part.getLineDelim(), eols);
		if (range.getOffset() + range.getLength() <= docLength) {
			edit.addChild(new ReplaceEdit(range.getOffset(), range.getLength(), rep));
		}
	}

	private static void formatTable(PagePart part, TextEdit edit) {
		TableModel table = new TableModel();
		table.load(part);
		ISourceRange range = part.getSourceRange();
		edit.addChild(new ReplaceEdit(range.getOffset(), range.getLength(), table.build()));
	}

	private static void formatText(PagePart part, TextEdit edit, int cols) {
		ISourceRange range = part.getSourceRange();
		int offset = range.getOffset();
		int len = range.getLength() - part.getLineDelim().length();
		if (len <= 0) return;

		String content = part.getContent(true);
		content = TextFormatter.wrap(content, cols, part.getLineDelim());

		edit.addChild(new ReplaceEdit(offset, len, content));
	}

	private static void formatList(PagePart part, TextEdit edit, int cols, int tabWidth) {
		for (int mark : part.getListMarkedLines()) {
			formatListItem(part, mark, edit, cols, tabWidth);
		}
	}

	private static void formatListItem(PagePart part, int mark, TextEdit edit, int cols, int tabWidth) {
		ISourceRange range = part.getSublistRange(mark);
		int offset = range.getOffset();
		int len = range.getLength() - part.getLineDelim().length();
		if (len <= 0) return;

		String listItem = part.getSublistContent(mark);
		int indent = Indent.measureIndentInTabs(listItem, tabWidth);
		int markWidth = listMarkWidth(listItem);
		listItem = TextFormatter.wrap(listItem, cols, part.getLineDelim(), tabWidth * indent,
				(tabWidth * indent) + markWidth);

		edit.addChild(new ReplaceEdit(offset, len, listItem));
	}

	private static int listMarkWidth(String item) {
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
