/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluent.dt.ui.editor.text.rules;

import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.PatternRule;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;

public class FrontMatterRule extends PatternRule {

	public FrontMatterRule(String startSequence, String endSequence, IToken token, char escapeCharacter) {
		super(startSequence, endSequence, token, escapeCharacter, false, true);
		setColumnConstraint(0);
	}

	@Override
	public IToken evaluate(ICharacterScanner scanner, boolean resume) {
		if (fColumn == UNDEFINED) return doEvaluate(scanner, resume);

		int c = scanner.read();
		scanner.unread();
		if (c == fStartSequence[0] && fColumn == scanner.getColumn()) {
			if (((RuleBasedScanner) scanner).getTokenOffset() == 0) {
				return doEvaluate(scanner, resume);
			}
		}
		return Token.UNDEFINED;
	}
}
