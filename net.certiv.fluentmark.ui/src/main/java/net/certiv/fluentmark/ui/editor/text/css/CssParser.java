/*******************************************************************************
 * Copyright (c) 2009, 2011 David Green and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     David Green - initial API and implementation
 *******************************************************************************/

package net.certiv.fluentmark.ui.editor.text.css;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A rudimentary CSS stylesheet parser. Recognizes commonly-used CSS syntax. The result of parsing
 * is a CSS-specific object model.
 *
 * @author David Green
 * @see Stylesheet
 * @see CssRule
 * @since 3.0
 */
public class CssParser {

	private static final Pattern CSS_COMMENT_PATTERN = Pattern.compile("/\\*.*?(\\*/|\\z)", //$NON-NLS-1$
			Pattern.MULTILINE | Pattern.DOTALL);

	private static Pattern CSS_BLOCK_PATTERN = Pattern.compile("(?:$|^)([^{]+)\\{([^\\}]*)\\}", //$NON-NLS-1$
			Pattern.MULTILINE | Pattern.DOTALL);

	static final Pattern CSS_RULE_PATTERN = Pattern.compile("(?:^|\\s?)([\\w-]+)\\s*:\\s*([^;]+)(;|$)", //$NON-NLS-1$
			Pattern.MULTILINE | Pattern.DOTALL);

	private static final String elemNamePatternPart = "(\\*|[a-zA-Z][a-zA-Z0-9]*)"; // capture 1 '*' or //$NON-NLS-1$
																					 // name

	private static final String elemQualifierPatternPart = "(?:(\\.|\\#)([a-zA-Z0-9]+))"; // capture 1 '.' //$NON-NLS-1$
																							 // or '#' capture 2
																							 // class/id

	private static final String elemPseudoClassPatternPart = "(?:\\:([a-zA-Z]+))"; // capture 1 //$NON-NLS-1$
																					 // pseudoClass without ':' prefix

	private static final String fullElementPatternPart = "(?:(?:" + elemNamePatternPart + "|" + elemQualifierPatternPart //$NON-NLS-1$//$NON-NLS-2$
			+ "|" + elemPseudoClassPatternPart + "){1,3})"; // 4 capturing groups //$NON-NLS-1$ //$NON-NLS-2$

	private static Pattern CSS_SELECTOR_PATTERN = Pattern.compile(fullElementPatternPart + // first element name
																							 // selector
			"(?:\\s*?" + // optional join part //$NON-NLS-1$
			"(\\s|\\>|\\+)" + // join clause //$NON-NLS-1$
			"\\s*" + //$NON-NLS-1$
			fullElementPatternPart + // second element name selector
			")?" //$NON-NLS-1$
	);

	private class CssRuleIterator implements Iterator<CssRule> {
		private final Matcher matcher;

		private boolean hasNext;

		private final int blockOffset;

		public CssRuleIterator(String cssStyles, int blockOffset) {
			this.blockOffset = blockOffset;
			matcher = CSS_RULE_PATTERN.matcher(cssStyles);
			hasNext = matcher.find();
		}

		@Override
		public boolean hasNext() {
			return hasNext;
		}

		@Override
		public CssRule next() {
			if (!hasNext) {
				throw new NoSuchElementException();
			}
			int offset = matcher.start();
			int length = matcher.end() - offset;
			String ruleName = matcher.group(1);
			int nameOffset = matcher.start(1);
			String ruleValue = matcher.group(2).trim();
			int valueOffset = matcher.start(2);
			hasNext = matcher.find();
			return new CssRule(ruleName, ruleValue, offset + blockOffset, length, nameOffset + blockOffset,
					valueOffset + blockOffset);
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	/**
	 * parse the contents of a CSS block
	 *
	 * @param content the content of the block
	 * @return a list of rules, or an empty list if there are none
	 */
	public List<CssRule> parseBlockContent(String content) {
		return parseBlock(content, 0);
	}

	/**
	 * parse the contents of a CSS block and return the result as an iterator of rules
	 *
	 * @param content
	 * @return
	 */
	public Iterator<CssRule> createRuleIterator(String content) {
		return createRuleIterator(content, 0);
	}

	public Stylesheet parse(Reader reader) {
		try {
			int i;
			reader = new BufferedReader(reader);
			StringWriter writer = new StringWriter();
			while ((i = reader.read()) != -1) {
				writer.write(i);
			}
			return parse(writer.toString());
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}

	public Stylesheet parse(String cssContent) {
		Stylesheet stylesheet = new Stylesheet();

		SparseCharSequence charSequence = new SparseCharSequence(cssContent, CSS_COMMENT_PATTERN);
		Matcher matcher = CSS_BLOCK_PATTERN.matcher(charSequence);
		while (matcher.find()) {
			String selectorText = matcher.group(1);
			String blockContent = matcher.group(2);
			if (selectorText != null && blockContent != null) {
				Selector selector = parseSelector(selectorText);
				if (selector != null) {
					int offset = matcher.start(2);
					offset = charSequence.originalOffsetOf(offset);
					List<CssRule> rules = parseBlock(blockContent, offset);
					Block block = new Block(selector, rules);
					stylesheet.add(block);
				}
			}
		}
		return stylesheet;
	}

	private List<CssRule> parseBlock(String content, int blockOffset) {
		List<CssRule> rules = new ArrayList<>();
		Iterator<CssRule> it = createRuleIterator(content, blockOffset);
		while (it.hasNext()) {
			rules.add(it.next());
		}
		return rules;
	}

	private Iterator<CssRule> createRuleIterator(String content, int blockOffset) {
		return new CssRuleIterator(content, blockOffset);
	}

	/**
	 * <em>NOT API</em> public for testing purposes only
	 */
	public Selector parseSelector(String selectorText) {
		String[] cssSelectorParts = selectorText.split(","); //$NON-NLS-1$

		List<Selector> parts = new ArrayList<>();

		for (String part : cssSelectorParts) {
			Selector selector = parseSelectorPart(part);
			if (selector != null) {
				parts.add(selector);
			}
		}
		if (parts.isEmpty()) {
			return null;
		}
		if (parts.size() == 1) {
			return parts.get(0);
		}
		return new CompositeSelector(false, parts);
	}

	private Selector parseSelectorPart(String part) {
		List<Selector> parts = new ArrayList<>();

		Matcher matcher = CSS_SELECTOR_PATTERN.matcher(part);
		while (matcher.find()) {
			String elemSelector = matcher.group(1);
			String elemSelectorQualifierType = matcher.group(2);
			String elemSelectorQualifier = matcher.group(3);
			String elemSelectorPseudoClass = matcher.group(4);
			String join = matcher.group(5);
			String elemSelector2 = matcher.group(6);
			String elemSelector2QualifierType = matcher.group(7);
			String elemSelector2Qualifier = matcher.group(8);
			String elemSelector2PseudoClass = matcher.group(9);

			if (elemSelectorPseudoClass != null || elemSelector2PseudoClass != null) {
				continue; // not supported
			}

			Selector firstElementSelector = buildElementSelector(elemSelector, elemSelectorQualifierType,
					elemSelectorQualifier, elemSelectorPseudoClass);
			if (join != null && elemSelector2 != null) {
				if (join.trim().length() == 0) {
					// first must be ancestor of second
					parts.add(new DescendantSelector(firstElementSelector));
					parts.add(buildElementSelector(elemSelector2, elemSelector2QualifierType, elemSelector2Qualifier,
							elemSelector2PseudoClass));
				} else {
					// not yet supported!!
				}
			} else {
				parts.add(firstElementSelector);
			}

		}
		if (parts.isEmpty()) {
			return null;
		}
		if (parts.size() == 1) {
			return parts.get(0);
		}
		return new CompositeSelector(true, parts);
	}

	private Selector buildElementSelector(String elemSelector, String elemSelectorQualifierType,
			String elemSelectorQualifier, String elemSelectorPseudoClass) {
		List<Selector> parts = new ArrayList<>();
		if (elemSelector != null) {
			if ("*".equals(elemSelector)) { //$NON-NLS-1$
				parts.add(new AnySelector());
			} else {
				parts.add(new NameSelector(elemSelector));
			}
		}
		if (elemSelectorQualifierType != null && elemSelectorQualifier != null) {
			if (".".equals(elemSelectorQualifierType)) { //$NON-NLS-1$
				parts.add(new CssClassSelector(elemSelectorQualifier));
			} else if ("#".equals(elemSelectorQualifierType)) { //$NON-NLS-1$
				parts.add(new IdSelector(elemSelectorQualifier));
			}
		}
		return parts.size() == 1 ? parts.get(0) : new CompositeSelector(true, parts);
	}

}
