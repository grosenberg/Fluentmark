/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluent.dt.ui.editor.text.rules;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;

import net.certiv.common.log.Log;
import net.certiv.fluent.dt.ui.editor.PartitionScanner;

public class DotCodeRule implements IPredicateRule {

	private IToken token;

	public DotCodeRule(IToken token) {
		this.token = token;
	}

	@Override
	public IToken evaluate(ICharacterScanner scanner, boolean resume) {
		return evaluate(scanner);
	}

	@Override
	public IToken evaluate(ICharacterScanner scanner) {
		int c = scanner.read();
		if (c != ICharacterScanner.EOF && 0 == scanner.getColumn() - 1) {
			try {
				if (dotStarts(scanner, c)) {
					gotoEOB(scanner, c);
					return getSuccessToken();
				}
			} catch (BadLocationException e) {
				Log.error(this, "DotCodeRule", e);
			}
		}

		scanner.unread();
		return Token.UNDEFINED;
	}

	@Override
	public IToken getSuccessToken() {
		return token;
	}

	private boolean dotStarts(ICharacterScanner scanner, int c) throws BadLocationException {
		if (c != '`' && c != '~') return false;

		PartitionScanner scan = (PartitionScanner) scanner;
		IDocument doc = scan.getDocument();
		IRegion info = doc.getLineInformationOfOffset(scan.getOffset());
		String text = doc.get(info.getOffset(), info.getLength());
		if (text.matches("(```+|~~~+)\\s+dot(\\s.*)?")) return true;
		return false;
	}

	private void gotoEOB(ICharacterScanner scanner, int c) {
		while (gotoEOL(scanner, true)) {
			if (lineStartsWith3(scanner, c)) {
				gotoEOL(scanner, true);
				return;
			}
		}
	}

	private boolean lineStartsWith3(ICharacterScanner scanner, int mark) {
		for (int idx = 0; idx < 3; idx++) {
			int c = scanner.read();
			if (c != mark) return false;
		}
		return true;
	}

	// returns true unless EOF encountered
	private boolean gotoEOL(ICharacterScanner scanner, boolean consumeEOL) {
		int b = scanner.read();
		scanner.unread();
		while (!isEol(b)) {
			b = scanner.read();
		}
		if (b == ICharacterScanner.EOF) {
			scanner.unread();
			return false;
		}
		if (consumeEOL) {
			b = scanner.read();
			if (b == '\r') {
				b = scanner.read();
			}
			if (b == ICharacterScanner.EOF) {
				scanner.unread();
				return false;
			}
		}
		return true;
	}

	private boolean isEol(int c) {
		return c == '\r' || c == '\n' || c == ICharacterScanner.EOF;
	}
}
