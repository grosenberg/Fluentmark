/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.ui.editor.text.rules;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;

import net.certiv.dsl.core.log.Log;
import net.certiv.fluentmark.ui.editor.PartitionScanner;
import net.certiv.fluentmark.ui.editor.text.IScannerExt;

public class HtmlCodeRule implements IPredicateRule {

	private IToken token;

	public HtmlCodeRule(IToken token) {
		this.token = token;
	}

	// called from the partition scanner
	@Override
	public IToken evaluate(ICharacterScanner scanner, boolean resume) {
		return evaluate(scanner);
	}

	// called from the reconcile scanners
	@Override
	public IToken evaluate(ICharacterScanner scanner) {
		int col = scanner.getColumn();
		if (col == 1) {
			scanner.unread();
			int p = scanner.read();
			if (p == '\n') col = 0;
		}

		try {
			if (col == 0) {
				String text = getScanText(scanner);
				if (tagStarts(text)) {
					gotoEOB(scanner);
					return getSuccessToken();
				}
			}
		} catch (BadLocationException e) {
			Log.error(this, "HtmlCodeRule", e);
		}
		return Token.UNDEFINED;
	}

	@Override
	public IToken getSuccessToken() {
		return token;
	}

	private String getScanText(ICharacterScanner scanner) throws BadLocationException {
		IScannerExt scan = ((IScannerExt) scanner);
		IDocument doc = scan.getDocument();
		int beg = scan.getOffset();
		int end = scan.getRangeEnd();
		int len = end - beg;
		return doc.get(beg, Math.min(256, len));
	}

	private boolean tagStarts(String text) {
		if (text.isEmpty()) return false;
		if (text.charAt(0) != '<') return false;

		int beg = 1;
		int end = text.length();
		for (int idx = beg; idx < end; idx++) {
			char c = text.charAt(idx);
			switch (c) {
				case '\\':
					idx++;
					continue;
				case '"':
				case '\'':
					idx = stringEnd(text, idx);
					if (idx == -1) return false;
					continue;
				case '/':
					if (text.charAt(idx + 1) != '>') continue;
				case '>':
					return true;
			}
		}
		return false;
	}

	private int stringEnd(String text, int beg) {
		char sType = text.charAt(beg);
		for (int idx = beg + 1; idx < text.length(); idx++) {
			char c = text.charAt(idx);
			switch (c) {
				case '\r':
				case '\n':
					break;
				case '\\':
					idx++;
					continue;
				case '"':
				case '\'':
					if (c == sType) return idx;
			}
		}
		return -1;
	}

	private int getOffset(ICharacterScanner scanner) {
		return ((PartitionScanner) scanner).getOffset();
	}

	private char getCharAt(ICharacterScanner scanner, int idx) {
		try {
			return ((PartitionScanner) scanner).getDocument().getChar(idx);
		} catch (BadLocationException e) {
			return 0; // NULL
		}
	}

	private void gotoEOB(ICharacterScanner scanner) {
		// Log.error("Beg block at " + getOffset(scanner));
		int mark = scanner.getColumn();
		while (!gotoEOL(scanner, true)) {	// read line, testing for blank
			mark = scanner.getColumn();		// mark beginning of each line
		}
		rewindToMark(scanner, mark); 		// to start of blank line
		rewindEOL(scanner);					// rewind through EOL
		// Log.error("End block at " + getOffset(scanner));
	}

	private boolean gotoEOL(ICharacterScanner scanner, boolean consumeEOL) {
		boolean blank = true;
		int b = scanner.read();
		while (!isEol(b)) {
			blank = blank && Character.isWhitespace(b);
			b = scanner.read();
		}
		if (b == ICharacterScanner.EOF) scanner.unread();
		if (consumeEOL) {
			b = scanner.read();
			if (b == '\r') {
				b = scanner.read();
			}
			if (b == ICharacterScanner.EOF) scanner.unread();
		}
		return blank;
	}

	private void rewindToMark(ICharacterScanner scanner, int mark) {
		for (int idx = scanner.getColumn(); idx > mark; idx--) {
			scanner.unread();
		}
	}

	private void rewindEOL(ICharacterScanner scanner) {
		for (int idx = getOffset(scanner) - 1; idx >= 0; idx--) {
			char c = getCharAt(scanner, idx);
			if (!isEol(c)) break;
			scanner.unread();
		}
	}

	private boolean isEol(int c) {
		return c == '\r' || c == '\n' || c == ICharacterScanner.EOF;
	}
}
