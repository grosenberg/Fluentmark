/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluent.dt.ui.editor.strategies;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.TextUtilities;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.text.edits.DeleteEdit;
import org.eclipse.ui.texteditor.ITextEditor;

import net.certiv.dsl.core.model.IStatement;
import net.certiv.dsl.core.model.ModelException;
import net.certiv.dsl.core.model.builder.SourceRange;
import net.certiv.dsl.ui.editor.text.SmartEdit;
import net.certiv.fluent.dt.core.FluentCore;
import net.certiv.fluent.dt.core.lang.md.model.SpecializationType;
import net.certiv.fluent.dt.core.model.SpecUtil;
import net.certiv.fluent.dt.core.preferences.Prefs;
import net.certiv.fluent.dt.ui.editor.FluentEditor;

/**
 * Modifies the document content to avoid lines above a preferred length
 */
public class LineWrapEditStrategy implements IAutoEditStrategy {

	private int limit; 	// Maximum line length
	private FluentEditor editor;

	public LineWrapEditStrategy(ITextEditor editor) {
		this.editor = (FluentEditor) editor;
		IPreferenceStore store = FluentCore.getDefault().getPrefsManager();
		store.addPropertyChangeListener(new IPropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent event) {
				if (event.getProperty().equals(Prefs.FORMATTER_WRAP_COLUMN)) {
					limit = Integer.valueOf((String) event.getNewValue());
				}
			}
		});

		limit = store.getInt(Prefs.FORMATTER_WRAP_COLUMN);
	}

	@Override
	public void customizeDocumentCommand(final IDocument doc, final DocumentCommand cmd) {
		if (cmd.length != 0 || cmd.text == null) return;

		try {
			if (TextUtilities.endsWith(doc.getLegalLineDelimiters(), cmd.text) != -1) {
				if (SmartEdit.isBlankLine(doc, cmd.offset)) {
					int beg = SmartEdit.getLineOffset(doc, cmd.offset);
					int len = cmd.offset - beg;

					DeleteEdit blanks = new DeleteEdit(beg, len);
					blanks.apply(doc);
					cmd.offset = beg;

				} else {
					autoIndent(doc, cmd, false);	// return entered
				}

			} else if (evaluateInsertPoint(doc, cmd)) {
				autoIndent(doc, cmd, true);		// insert point exceeds limit
			} else if (evaluateLineWidth(doc, cmd)) {
				wrapLines(doc, cmd);			// line end exceeds limit
			}
		} catch (BadLocationException e) {}
	}

	/**
	 * Copies the indentation of the previous line, modified to account for marker
	 * width in lists.
	 */
	private void autoIndent(IDocument doc, DocumentCommand cmd, boolean forceNL) {
		if (cmd.offset == -1 || doc.getLength() == 0) return;

		try {
			int offset = SmartEdit.getCmdOffset(doc, cmd);
			IRegion info = doc.getLineInformationOfOffset(offset);
			int beg = info.getOffset();
			int end = SmartEdit.getEndOfWs(doc, beg, cmd.offset); // end of WS
			int markWidth = 0;

			try {
				IStatement stmt = editor.getInputDslElement().getElementAtOffset(offset);
				if (SpecUtil.getSpecializedType(stmt) == SpecializationType.ListItem) {
					SourceRange range = stmt.getRange();
					markWidth = range.getIdLength();
				}
			} catch (ModelException e) {}

			StringBuffer buf = new StringBuffer(cmd.text);
			if (forceNL) buf.append(TextUtilities.getDefaultLineDelimiter(doc)); // force new line
			if (end > beg) {
				buf.append(doc.get(beg, end - beg)); 	// add the indent
			}
			for (int cnt = 0; cnt < markWidth; cnt++) {		// add marker width
				buf.append(" ");
			}
			cmd.text = buf.toString();
		} catch (BadLocationException e) {}
	}

	private boolean evaluateInsertPoint(IDocument doc, DocumentCommand cmd) {
		if (!(cmd.text.equals(" ") || cmd.text.equals("\t"))) return false;	// only check HWS

		try {
			int beg = SmartEdit.getLineOffset(doc, cmd.offset);
			boolean force = cmd.offset > beg + limit + TextUtilities.getDefaultLineDelimiter(doc).length();
			return force;
		} catch (BadLocationException e) {
			return false;
		}
	}

	private boolean evaluateLineWidth(IDocument doc, DocumentCommand cmd) {
		return false;
	}

	private void wrapLines(IDocument doc, DocumentCommand cmd) {}
}
