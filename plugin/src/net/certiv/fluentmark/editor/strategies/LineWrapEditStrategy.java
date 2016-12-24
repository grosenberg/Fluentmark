/*******************************************************************************
 * Copyright (c) 2016 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.editor.strategies;

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

import net.certiv.fluentmark.FluentMkUI;
import net.certiv.fluentmark.model.Kind;
import net.certiv.fluentmark.model.PagePart;
import net.certiv.fluentmark.model.PageRoot;
import net.certiv.fluentmark.preferences.Prefs;
import net.certiv.fluentmark.util.Strings;

/**
 * Modifies the document content to avoid lines above a preferred length
 */
public class LineWrapEditStrategy implements IAutoEditStrategy {

	private int limit; 	// Maximum line length

	public LineWrapEditStrategy() {
		IPreferenceStore store = FluentMkUI.getDefault().getPreferenceStore();
		store.addPropertyChangeListener(new IPropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent event) {
				if (event.getProperty().equals(Prefs.EDITOR_FORMATTING_COLUMN)) {
					limit = (int) event.getNewValue();
				}
			}
		});

		this.limit = store.getInt(Prefs.EDITOR_FORMATTING_COLUMN);
	}

	@Override
	public void customizeDocumentCommand(final IDocument doc, final DocumentCommand cmd) {
		if (cmd.length != 0 || cmd.text == null) return;

		try {
			if (TextUtilities.endsWith(doc.getLegalLineDelimiters(), cmd.text) != -1) {
				if (AutoEdit.isBlankLine(doc, cmd.offset)) {
					int beg = AutoEdit.getLineOffset(doc, cmd.offset);
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
	 * Copies the indentation of the previous line, modified to account for marker width in lists.
	 */
	private void autoIndent(IDocument doc, DocumentCommand cmd, boolean forceNL) {
		if (cmd.offset == -1 || doc.getLength() == 0) return;

		try {
			int offset = AutoEdit.getOffset(doc, cmd);
			IRegion info = doc.getLineInformationOfOffset(offset);
			int beg = info.getOffset();
			int end = AutoEdit.getEndOfWs(doc, beg, cmd.offset); // end of WS
			int lmw = 0;

			PagePart part = PageRoot.MODEL.partAtOffset(offset);
			if (part != null && part.getKind() == Kind.LIST) {
				lmw = AutoEdit.listMarkerWidth(doc, end);
			}

			StringBuffer buf = new StringBuffer(cmd.text);
			if (forceNL) buf.append(Strings.EOL); 		// force new line
			if (end > beg) {
				buf.append(doc.get(beg, end - beg)); 	// add the indent
			}
			for (int cnt = 0; cnt < lmw; cnt++) {		// add marker width
				buf.append(" ");
			}
			cmd.text = buf.toString();
		} catch (BadLocationException e) {}
	}

	private boolean evaluateInsertPoint(IDocument doc, DocumentCommand cmd) {
		if (!(cmd.text.equals(" ") || cmd.text.equals("\t"))) return false;	// only check on
																				// whitespace

		try {
			int beg = AutoEdit.getLineOffset(doc, cmd.offset);
			boolean force = cmd.offset > beg + limit + Strings.EOL.length();
			// if (force) cmd.text = ""; // consume the WS
			return force;
		} catch (BadLocationException e) {
			return false;
		}
	}

	private boolean evaluateLineWidth(IDocument doc, DocumentCommand cmd) {
		// TODO
		return false;
	}

	private void wrapLines(IDocument doc, DocumentCommand cmd) {
		// TODO
	}
}
