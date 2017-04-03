/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.editor.text;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.jface.text.rules.WordRule;

import net.certiv.fluentmark.preferences.Prefs;

public class ScannerMath extends AbstractBufferedRuleBasedScanner {

	private String[] tokenProperties;

	public ScannerMath() {
		super();
		initialize();
	}

	@Override
	protected String[] getTokenProperties() {
		if (tokenProperties == null) {
			tokenProperties = new String[] { Prefs.EDITOR_MATH_KEYWORD_COLOR, Prefs.EDITOR_MATH_SYMBOL_COLOR,
					Prefs.EDITOR_MATH_COMMENT_COLOR, Prefs.EDITOR_DEFAULT_COLOR };
		}
		return tokenProperties;
	}

	@Override
	protected List<IRule> createRules() {
		IToken keywordToken = getToken(Prefs.EDITOR_MATH_KEYWORD_COLOR);
		IToken symbolToken = getToken(Prefs.EDITOR_MATH_SYMBOL_COLOR);
		IToken commentToken = getToken(Prefs.EDITOR_MATH_COMMENT_COLOR);
		// IToken defaultToken = getToken(Prefs.EDITOR_DEFAULT_COLOR);

		WordRule wordRule = new WordRule(new MathWordDetector(), keywordToken, true);
		WordRule symbolRule = new WordRule(new MathSymbolDetector(), symbolToken, true);

		List<IRule> rules = new ArrayList<IRule>();
		rules.add(wordRule);
		rules.add(symbolRule);
		rules.add(new EndOfLineRule("%", commentToken));
		rules.add(new WhitespaceRule(new WhitespaceDetector()));
		return rules;
	}
}
