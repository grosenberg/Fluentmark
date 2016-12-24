/*******************************************************************************
 * Copyright (c) 2016 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.editor.text;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.jface.text.rules.WordRule;

import net.certiv.fluentmark.preferences.Prefs;

public class ScannerHtml extends AbstractBufferedRuleBasedScanner {

	private String[] tokenProperties;
	private static final String[] keywords = { "a", "abbr", "acronym", "address", "applet", "area", "article", "aside",
			"audio", "b", "base", "basefont", "bdi", "bdo", "bgsound", "big", "blink", "blockquote", "body", "br",
			"button", "canvas", "caption", "center", "cite", "code", "col", "colgroup", "command", "content", "data",
			"datalist", "dd", "del", "details", "dfn", "dialog", "dir", "div", "dl", "dt", "element", "em", "embed",
			"fieldset", "figcaption", "figure", "font", "footer", "form", "frame", "frameset", "head", "header",
			"hgroup", "hr", "html", "i", "iframe", "image", "img", "input", "ins", "isindex", "kbd", "keygen", "label",
			"legend", "li", "link", "listing", "main", "map", "mark", "marquee", "menu", "menuitem", "meta", "meter",
			"multicol", "nav", "nobr", "noembed", "noframes", "noscript", "object", "ol", "optgroup", "option",
			"output", "p", "param", "picture", "plaintext", "pre", "progress", "q", "rp", "rt", "rtc", "ruby", "s",
			"samp", "script", "section", "select", "shadow", "small", "source", "spacer", "span", "strike", "strong",
			"style", "sub", "summary", "sup", "table", "tbody", "td", "template", "textarea", "tfoot", "th", "thead",
			"time", "title", "tr", "track", "tt", "u", "ul", "var", "video", "wbr", "xmp" };
	private static final String[] symbols = { "<", "/", "=", ">" };

	public ScannerHtml() {
		super();
		initialize();
	}

	@Override
	protected String[] getTokenProperties() {
		if (tokenProperties == null) {
			tokenProperties = new String[] { Prefs.EDITOR_HTML_KEYWORD_COLOR, Prefs.EDITOR_HTML_SYMBOL_COLOR,
					Prefs.EDITOR_HTML_STRING_COLOR, Prefs.EDITOR_DEFAULT_COLOR };
		}
		return tokenProperties;
	}

	@Override
	protected List<IRule> createRules() {
		IToken keywordToken = getToken(Prefs.EDITOR_HTML_KEYWORD_COLOR);
		IToken symbolToken = getToken(Prefs.EDITOR_HTML_SYMBOL_COLOR);
		IToken stringToken = getToken(Prefs.EDITOR_HTML_STRING_COLOR);
		IToken defaultToken = getToken(Prefs.EDITOR_DEFAULT_COLOR);

		WordRule wordRule = new WordRule(new HtmlWordDetector(), defaultToken, true);
		for (String keyword : keywords) {
			wordRule.addWord(keyword, keywordToken);
		}

		WordRule symbolRule = new WordRule(new HtmlSymbolDetector(), defaultToken, true);
		for (String symbol : symbols) {
			symbolRule.addWord(symbol, symbolToken);
		}

		List<IRule> rules = new ArrayList<IRule>();
		rules.add(new SingleLineRule("\"", "\"", stringToken, '\\', true));
		rules.add(new SingleLineRule("'", "'", stringToken, '\\', true));
		rules.add(wordRule);
		rules.add(symbolRule);
		rules.add(new WhitespaceRule(new WhitespaceDetector()));
		return rules;
	}
}
