/*******************************************************************************
 * Copyright (c) 2016 - 2018 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.editor.text;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.jface.text.rules.WordRule;

import net.certiv.fluentmark.preferences.Prefs;

public class ScannerUml extends AbstractBufferedRuleBasedScanner implements IScannerExt {

	private String[] tokenProperties;

	private static final String[] types = { "actor", "participant", "usecase", "class", "interface", "abstract", "enum",
			"component", "state", "object", "artifact", "folder", "rectangle", "node", "frame", "cloud", "database",
			"storage", "agent", "stack", "boundary", "control", "entity", "card", "file", "package", "queue",
			"archimate", };

	private static final String[] keywords = { "@startuml", "@enduml", "@startdot", "@enddot", "@startsalt", "@endsalt",
			"as", "also", "autonumber", "caption", "title", "newpage", "box", "alt", "else", "opt", "loop", "par",
			"break", "critical", "note", "rnote", "hnote", "legend", "group", "left", "right", "of", "on", "link",
			"over", "end", "activate", "deactivate", "destroy", "create", "footbox", "hide", "show", "skinparam",
			"skin", "top", "bottom", "top to bottom direction", "package", "namespace", "page", "up", "down", "if",
			"else", "elseif", "endif", "partition", "footer", "header", "center", "rotate", "ref", "return", "is",
			"repeat", "start", "stop", "while", "endwhile", "fork", "again", "kill", "order", };

	private static final String[] preprocs = { "!exit", "!include", "!pragma", "!define", "!undef", "!if", "!ifdef",
			"!endif", "!ifndef", "!else", "!definelong", "!enddefinelong", };

	private static final String[] symbols = { "{", "}", "[", "]", "<-", "<--", "<---", "-", "--", "---", "->", "-->",
			"--->", "(", ")" };

	public ScannerUml() {
		super();
		initialize();
	}

	@Override
	protected String[] getTokenProperties() {
		if (tokenProperties == null) {
			tokenProperties = new String[] { Prefs.EDITOR_UML_KEYWORD_COLOR, Prefs.EDITOR_UML_ATTRIBS_COLOR,
					Prefs.EDITOR_UML_COMMENT_COLOR, Prefs.EDITOR_UML_SYMBOL_COLOR, Prefs.EDITOR_UML_STRING_COLOR,
					Prefs.EDITOR_DEFAULT_COLOR };
		}
		return tokenProperties;
	}

	@Override
	protected List<IRule> createRules() {
		IToken keywordToken = getToken(Prefs.EDITOR_UML_KEYWORD_COLOR);
		IToken attribsToken = getToken(Prefs.EDITOR_UML_ATTRIBS_COLOR);
		IToken symbolToken = getToken(Prefs.EDITOR_UML_SYMBOL_COLOR);
		IToken stringToken = getToken(Prefs.EDITOR_UML_STRING_COLOR);
		IToken commentToken = getToken(Prefs.EDITOR_UML_COMMENT_COLOR);
		IToken defaultToken = getToken(Prefs.EDITOR_DEFAULT_COLOR);

		WordRule wordRule = new WordRule(new UmlWordDetector(), defaultToken, true);
		for (String keyword : keywords) {
			wordRule.addWord(keyword, keywordToken);
		}

		WordRule typeRule = new WordRule(new UmlWordDetector(), defaultToken, true);
		for (String type : types) {
			wordRule.addWord(type, attribsToken);
		}

		WordRule symbolRule = new WordRule(new UmlSymbolDetector(), defaultToken, true);
		for (String symbol : symbols) {
			symbolRule.addWord(symbol, symbolToken);
		}
		for (String preproc : preprocs) {
			symbolRule.addWord(preproc, symbolToken);
		}

		List<IRule> rules = new ArrayList<>();
		rules.add(new MultiLineRule("/'", "'/", commentToken, '\\', true));
		rules.add(new SingleLineRule("'", null, commentToken, '\\', true));
		rules.add(new SingleLineRule("\"", "\"", stringToken, '\\', true));
		rules.add(wordRule);
		rules.add(typeRule);
		rules.add(symbolRule);
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
