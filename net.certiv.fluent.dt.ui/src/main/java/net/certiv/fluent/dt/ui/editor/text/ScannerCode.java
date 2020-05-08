/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluent.dt.ui.editor.text;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.WhitespaceRule;

import net.certiv.dsl.core.preferences.IPrefsManager;
import net.certiv.dsl.ui.editor.scanners.AbstractBufferedRuleBasedScanner;
import net.certiv.fluent.dt.core.preferences.Prefs;
import net.certiv.fluent.dt.ui.editor.text.rules.WhitespaceDetector;

public class ScannerCode extends AbstractBufferedRuleBasedScanner implements IScannerExt {

	private String[] tokenProperties;

	public ScannerCode(IPrefsManager store) {
		super(store);
		initialize();
	}

	@Override
	protected String[] getTokenProperties() {
		if (tokenProperties == null) {
			tokenProperties = new String[] { Prefs.EDITOR_CODE_COLOR, Prefs.EDITOR_CODEBLOCK_COLOR };
		}
		return tokenProperties;
	}

	@Override
	protected List<IRule> createRules() {
		// IToken code = getToken(Prefs.EDITOR_CODE_COLOR);
		IToken block = getToken(Prefs.EDITOR_CODEBLOCK_COLOR);

		List<IRule> rules = new ArrayList<>();
		rules.add(new MultiLineRule("```", "```", block, '\\', true));
		rules.add(new MultiLineRule("~~~", "~~~", block, '\\', true));
		// rules.add(new SingleLineRule("`", "`", code, '\\', true));
		rules.add(new WhitespaceRule(new WhitespaceDetector()));
		return rules;
	}

	@Override
	public IDocument getDocument() {
		return fDocument;
	}

	@Override
	public int getOffset() {
		return fOffset;
	}

	@Override
	public int getRangeEnd() {
		return fRangeEnd;
	}
}
