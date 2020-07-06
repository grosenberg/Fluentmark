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

import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.WhitespaceRule;

import net.certiv.dsl.core.preferences.IPrefsManager;
import net.certiv.dsl.ui.editor.scanners.DslRuleBasedScanner;
import net.certiv.dsl.ui.editor.semantic.StylesManager;
import net.certiv.fluent.dt.core.preferences.Prefs;
import net.certiv.fluent.dt.ui.editor.text.rules.WhitespaceDetector;

public class ScannerComment extends DslRuleBasedScanner {

	private String[] tokenProperties;

	public ScannerComment(IPrefsManager store, StylesManager stylesMgr) {
		super(store, stylesMgr);
		initialize();
	}

	@Override
	protected String[] getTokenProperties() {
		if (tokenProperties == null) {
			tokenProperties = new String[] { Prefs.EDITOR_COMMENT_HIDDEN_COLOR, Prefs.EDITOR_COMMENT_VISIBLE_COLOR, };
		}
		return tokenProperties;
	}

	@Override
	protected List<IRule> createRules() {
		IToken hidden = getToken(Prefs.EDITOR_COMMENT_HIDDEN_COLOR);
		IToken visible = getToken(Prefs.EDITOR_COMMENT_VISIBLE_COLOR);

		List<IRule> rules = new ArrayList<>();
		rules.add(new MultiLineRule("<!---", "--->", hidden, '\\'));
		rules.add(new MultiLineRule("<!--", "-->", visible, '\\'));
		rules.add(new WhitespaceRule(new WhitespaceDetector()));
		return rules;
	}
}
