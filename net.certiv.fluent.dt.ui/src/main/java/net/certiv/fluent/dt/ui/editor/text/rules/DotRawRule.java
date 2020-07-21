/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluent.dt.ui.editor.text.rules;

import java.util.regex.Pattern;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;

import net.certiv.dsl.core.log.Log;
import net.certiv.dsl.core.util.Chars;
import net.certiv.fluent.dt.ui.editor.PartitionScanner;

public class DotRawRule implements IPredicateRule {

	// strict digraph M3 {
	private static final String Pre = "[ \t>]*";
	private static final String Graph = "(strict\\h+)?(di)?graph\\h+";
	private static final String Name = "([a-zA-Z]\\w*|\"\\w+\")\\h*";
	private static final String Paren = "(\\v\\h*)?\\{";
	private static final Pattern DotBeg = Pattern.compile(Pre + Graph + Name + Paren);

	private IToken token;

	public DotRawRule(IToken token) {
		this.token = token;
	}

	@Override
	public IToken getSuccessToken() {
		return token;
	}

	@Override
	public IToken evaluate(ICharacterScanner scanner, boolean resume) {
		return evaluate(scanner);
	}

	@Override
	public IToken evaluate(ICharacterScanner scanner) {
		int c = scanner.read();
		scanner.unread();

		int col = scanner.getColumn();
		if (c != ICharacterScanner.EOF && 0 == col) {
			try {
				if (isDotBeg(scanner)) {
					toDotEnd(scanner);
					return getSuccessToken();
				}
			} catch (BadLocationException e) {
				Log.error(this, "DotRawRule", e);
			}
		}

		return Token.UNDEFINED;
	}

	private boolean isDotBeg(ICharacterScanner scanner) throws BadLocationException {
		PartitionScanner scan = (PartitionScanner) scanner;
		IDocument doc = scan.getDocument();
		int offset = scan.getOffset();
		String text = doc.get().substring(offset);
		return DotBeg.matcher(text).lookingAt();
	}

	private void toDotEnd(ICharacterScanner scanner) {
		int b = scanner.read();
		while (b != Chars.LBRACE) {
			b = scanner.read();
		}

		int cnt = 1;
		do {
			b = scanner.read();
			switch (b) {
				case ICharacterScanner.EOF:
					return;
				case Chars.ESC:
					scanner.read();
					break;
				case Chars.LBRACE:
					cnt++;
					break;
				case Chars.RBRACE:
					cnt--;
					break;
				default:
			}
		} while (cnt > 0);
	}
}
