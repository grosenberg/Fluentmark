/*******************************************************************************
 * Copyright (c) 2016 - 2023 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluent.dt.ui.editor.text.rules;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;

import net.certiv.common.log.Log;
import net.certiv.fluent.dt.ui.editor.PartitionScanner;

public class MathRawRule implements IPredicateRule {

	private static final Pattern MathBeg = Pattern.compile("\\\\begin\\{.*?\\}");
	private static final Pattern MathEnd = Pattern.compile("\\\\end\\{.*?\\}");

	private IToken token;

	public MathRawRule(IToken token) {
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
				if (isMathBeg(scanner)) {
					toMathEnd(scanner);
					return getSuccessToken();
				}
			} catch (BadLocationException e) {
				Log.error("MathRawRule", e);
			}
		}

		return Token.UNDEFINED;
	}

	private boolean isMathBeg(ICharacterScanner scanner) throws BadLocationException {
		PartitionScanner scan = (PartitionScanner) scanner;
		IDocument doc = scan.getDocument();
		int offset = scan.getOffset();
		String text = doc.get().substring(offset);
		return MathBeg.matcher(text).lookingAt();
	}

	private void toMathEnd(ICharacterScanner scanner) {
		PartitionScanner scan = (PartitionScanner) scanner;
		IDocument doc = scan.getDocument();
		String text = doc.get().substring(scan.getOffset());
		Matcher m = MathEnd.matcher(text);
		if (m.find()) {
			for (int cnt = m.end(); cnt > 0; cnt--) {
				scanner.read();
			}
		}
	}
}
