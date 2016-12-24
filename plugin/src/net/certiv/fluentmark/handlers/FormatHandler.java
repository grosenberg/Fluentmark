/*******************************************************************************
 * Copyright (c) 2016 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.ui.handlers.HandlerUtil;

import net.certiv.fluentmark.Log;
import net.certiv.fluentmark.editor.FluentMkEditor;
import net.certiv.fluentmark.formatter.TextFormatter;
import net.certiv.fluentmark.model.ISourceRange;
import net.certiv.fluentmark.model.Kind;
import net.certiv.fluentmark.model.PagePart;
import net.certiv.fluentmark.model.PageRoot;
import net.certiv.fluentmark.preferences.Prefs;

/**
 * Format text via hard wrapping, i.e. inserting returns.
 */
public class FormatHandler extends AbstractHandler {

	// TODO: normalize line endings:
	// doc.set(Strings.normalise(doc.get()));
	public FormatHandler() {
		super();
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		FluentMkEditor editor = (FluentMkEditor) HandlerUtil.getActiveEditor(event);
		if (editor == null) return null;

		IPreferenceStore store = editor.getPrefsStore();
		if (!store.getBoolean(Prefs.EDITOR_FORMATTING_ENABLED)) return null;

		int cols = store.getInt(Prefs.EDITOR_FORMATTING_COLUMN);

		try {
			ITextSelection sel = (ITextSelection) editor.getSelectionProvider().getSelection();
			if (sel != null && sel.getLength() > 0) {
				formatSelectedRegion(editor, sel, cols);
				return null;
			}

			ISourceViewer viewer = editor.getViewer();
			int caretOffset = viewer.getTextWidget().getCaretOffset();
			PageRoot model = editor.getPageModel();
			PagePart part = model.partAtOffset(caretOffset);
			if (part.getKind().equals(Kind.TEXT)) {
				ISourceRange range = part.getSourceRange();
				String paragraph = editor.getDocument().get(range.getOffset(), range.getLength());
				String formatted = TextFormatter.format(paragraph, cols);
				if (!formatted.equals(paragraph)) { // Replace with the new formatted text
					editor.getDocument().replace(range.getOffset(), range.getLength(), formatted);
				}
			}
		} catch (Exception ex) {
			Log.error("Bad location error occurred during formatting", ex );
		}

		return null;
	}

	private void formatSelectedRegion(FluentMkEditor editor, ITextSelection sel, int cols) throws BadLocationException {
		PageRoot page = editor.getPageModel();
		int beg = sel.getStartLine();
		int end = sel.getEndLine();

		MultiTextEdit edit = new MultiTextEdit();

		for (int idx = beg; idx <= end; idx++) {
			int offset = page.getOffset(idx);
			PagePart part = page.partAtOffset(offset);
			if (part.getKind().equals(Kind.TEXT)) {
				ISourceRange range = part.getSourceRange();
				String paragraph = editor.getDocument().get(range.getOffset(), range.getLength());
				String formatted = TextFormatter.format(paragraph, cols);
				if (!formatted.equals(paragraph)) { // Replace with the new formatted text
					edit.addChild(new ReplaceEdit(range.getOffset(), range.getLength(), formatted));
					idx = range.getEndLine();
				}
			}
		}

		edit.apply(editor.getDocument());
	}
}
