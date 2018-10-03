package net.certiv.fluentmark.ui.format;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.text.edits.TextEdit;

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.core.formatter.BaseCodeFormatter;
import net.certiv.dsl.core.model.util.ISourceRange;
import net.certiv.dsl.core.preferences.IDslPrefsManager;
import net.certiv.dsl.core.util.Indent;
import net.certiv.dsl.core.util.Log;
import net.certiv.dsl.core.util.Strings;
import net.certiv.fluentmark.core.FluentCore;
import net.certiv.fluentmark.core.model.Page;
import net.certiv.fluentmark.core.model.PagePart;
import net.certiv.fluentmark.core.preferences.Prefs;
import net.certiv.fluentmark.ui.dialog.tables.TableModel;

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
			cols = store.getInt(Prefs.EDITOR_FORMATTING_COLUMN);
			tabWidth = store.getInt(Prefs.EDITOR_TAB_WIDTH);

			Page model = (Page) getDslCore().getModelManager().getModel();
			List<PagePart> parts = model.getPageParts();

			// adjust for selection
			if (length != content.length()) {
				parts = subselect(model, offset, length);
			}

			TextEdit edits = new MultiTextEdit();
			for (PagePart part : parts) {
				formatPagePart(part, edits);
			}

			// complete and return the edits
			long currentTime = System.currentTimeMillis() - startTime;
			Log.info(this, "Formatting pass (" + currentTime + "ms)");
			return edits;

		} finally {
			getDslCore().FormatterLock.unlock();
		}

		return null;
	}

	// private void doFormat(FluentEditor editor, ITextSelection sel) {
	// IDocument doc = editor.ensureLastLineBlank().getDocument();
	// if (doc == null || doc.getLength() == 0) return;
	//
	// docLength = doc.getLength();
	//
	// try {
	// Page model = editor.getPageModel();
	// List<PagePart> parts = model.getPageParts();
	// if (sel != null && sel.getLength() > 0) {
	// parts = selectedParts(model, sel);
	// }
	//
	// IDocumentUndoManager undoMgr = DocumentUndoManagerRegistry.getDocumentUndoManager(doc);
	// undoMgr.beginCompoundChange();
	// TextEdit edit = new MultiTextEdit();
	// for (PagePart part : parts) {
	// formatPagePart(part, edit);
	// }
	// edit.apply(editor.getDocument());
	// undoMgr.endCompoundChange();
	// } catch (Exception ex) {
	// Log.error(MdFormatter.class, "Bad location error occurred during formatting", ex);
	// }
	// }

	// public void format(FluentEditor editor, ITextSelection sel) {
	// cols = store.getInt(Prefs.EDITOR_FORMATTING_COLUMN);
	// tabWidth = store.getInt(Prefs.EDITOR_TAB_WIDTH);
	//
	// doFormat(editor, sel);
	// }
	//
	// public void unwrap(FluentEditor editor, ITextSelection sel) {
	// cols = 0;
	// tabWidth = store.getInt(Prefs.EDITOR_TAB_WIDTH);
	//
	// doFormat(editor, sel);
	// }

	// private void doFormat(FluentEditor editor, ITextSelection sel) {
	// IDocument doc = editor.ensureLastLineBlank().getDocument();
	// if (doc == null || doc.getLength() == 0) return;
	//
	// docLength = doc.getLength();
	//
	// try {
	// Page model = editor.getPageModel();
	// List<PagePart> parts = model.getPageParts();
	// if (sel != null && sel.getLength() > 0) {
	// parts = selectedParts(model, sel);
	// }
	//
	// IDocumentUndoManager undoMgr = DocumentUndoManagerRegistry.getDocumentUndoManager(doc);
	// undoMgr.beginCompoundChange();
	// TextEdit edit = new MultiTextEdit();
	// for (PagePart part : parts) {
	// formatPagePart(part, edit);
	// }
	// edit.apply(editor.getDocument());
	// undoMgr.endCompoundChange();
	// } catch (Exception ex) {
	// Log.error(MdFormatter.class, "Bad location error occurred during formatting", ex);
	// }
	// }

	private List<PagePart> subselect(Page model, int offset, int len) {
		List<PagePart> selected = new ArrayList<>();
		int begOffset = offset;
		int endOffset = offset + len;
		PagePart beg = model.partAtOffset(begOffset);
		PagePart end = model.partAtOffset(endOffset);

		for (int idx = beg.getPartIdx(); idx <= end.getPartIdx(); idx++) {
			selected.add(model.getPagePart(idx));
		}
		return selected;
	}

	// private List<PagePart> selectedParts(Page model, ITextSelection sel) {
	// List<PagePart> selected = new ArrayList<>();
	// int begOffset = sel.getOffset();
	// int endOffset = sel.getOffset() + sel.getLength();
	// PagePart beg = model.partAtOffset(begOffset);
	// PagePart end = model.partAtOffset(endOffset);
	//
	// for (int idx = beg.getPartIdx(); idx <= end.getPartIdx(); idx++) {
	// selected.add(model.getPagePart(idx));
	// }
	// return selected;
	// }

	private void formatPagePart(PagePart part, TextEdit edit) {
		switch (part.getItem()) {
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

	private void formatBlank(PagePart part, TextEdit edit) {
		ISourceRange range = part.getSourceRange();
		int eols = range.getEndLine() - range.getBegLine() + 1;
		String rep = Strings.dup(eols, part.delim());
		if (range.getOffset() + range.getLength() <= docLength) {
			edit.addChild(new ReplaceEdit(range.getOffset(), range.getLength(), rep));
		}
	}

	private void formatTable(PagePart part, TextEdit edit) {
		TableModel table = new TableModel();
		table.load(part);
		ISourceRange range = part.getSourceRange();
		edit.addChild(new ReplaceEdit(range.getOffset(), range.getLength(), table.build()));
	}

	private void formatText(PagePart part, TextEdit edit, int cols) {
		ISourceRange range = part.getSourceRange();
		int offset = range.getOffset();
		int len = range.getLength() - part.delim().length();
		if (len <= 0) return;

		String content = part.getContent(true);
		content = TextFormatter.wrap(content, cols, part.delim());

		edit.addChild(new ReplaceEdit(offset, len, content));
	}

	private void formatList(PagePart part, TextEdit edit, int cols, int tabWidth) {
		for (int mark : part.getListMarkedLines()) {
			formatListItem(part, mark, edit, cols, tabWidth);
		}
	}

	private void formatListItem(PagePart part, int mark, TextEdit edit, int cols, int tabWidth) {
		ISourceRange range = part.getSublistRange(mark);
		int offset = range.getOffset();
		int len = range.getLength() - part.delim().length();
		if (len <= 0) return;

		String listItem = part.getSublistContent(mark);
		int indent = Indent.measureIndentInTabs(listItem, tabWidth);
		int markWidth = listMarkWidth(listItem);
		listItem = TextFormatter.wrap(listItem, cols, part.delim(), tabWidth * indent, (tabWidth * indent) + markWidth);

		edit.addChild(new ReplaceEdit(offset, len, listItem));
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
