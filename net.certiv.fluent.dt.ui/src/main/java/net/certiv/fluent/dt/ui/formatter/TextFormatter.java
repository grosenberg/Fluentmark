/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluent.dt.ui.formatter;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

import net.certiv.dsl.core.util.Strings;

public class TextFormatter {

	public static final String LINK = "^\\[.*?\\]\\s?\\(.*?\\).*";
	public static final String IMG = "^!\\[.*?\\]\\s?\\(.*?\\).*";

	private TextFormatter() {}

	/** Format the given content by wrapping at the given col with no indent */
	public static String wrap(String content, int col, String delim) {
		return wrap(content, col, delim, 0, 0);
	}

	/**
	 * Format the given content by wrapping at the given {@code col}, provided {@code col} is greater
	 * than {@code 0}. First line will be indented by indentFirst spaces and the remaining lines will be
	 * indented with indentRest spaces
	 */
	public static String wrap(String content, int col, String delim, int indentFirst, int indentRest) {
		StringBuilder sb = new StringBuilder();
		sb.append(Strings.dup(indentFirst, " "));

		content = Strings.trimLeft(content);
		content = content.replaceAll("\\s*?\\R+\\s*", " ");
		if (col <= 0) return sb.append(content).toString();

		WordBreakIterator breaker = new WordBreakIterator();
		breaker.setText(content);
		List<String> lines = new ArrayList<>();

		int mark = breaker.first();
		int dot = breaker.next();
		while (dot != BreakIterator.DONE) {
			String segment = content.substring(mark, dot);
			segment = completeSpecial(content, breaker, mark, dot, segment);
			dot = mark + segment.length();
			sb.append(segment);
			if (Character.isWhitespace(segment.charAt(0))) {
				if (sb.length() > col) {
					lines.add(sb.toString());
					sb.setLength(0);
					sb.append(Strings.dup(indentRest, " "));
				}
			}
			mark = dot;
			dot = breaker.next();
		}

		String remainder = sb.toString();
		if (!remainder.trim().isEmpty()) {
			lines.add(remainder);
		}
		return String.join(delim, lines);
	}

	private static String completeSpecial(String content, WordBreakIterator breaker, int mark, int dot,
			String segment) {

		switch (segment) {
			case "[": // links
				if (content.substring(mark).matches(LINK)) {
					segment = collectThrough(content, breaker, mark, dot, segment, ")");
				}
				break;

			case "!": // images
				if (content.substring(mark).matches(LINK)) {
					segment = collectThrough(content, breaker, mark, dot, segment, ")");
				}
				break;

			case "`": // code
				segment = collectThrough(content, breaker, mark, dot, segment, "`");
				break;
		}
		return segment;
	}

	private static String collectThrough(String content, WordBreakIterator breaker, int mark, int dot, String segment,
			String term) {

		StringBuilder sb = new StringBuilder();
		while (dot != BreakIterator.DONE) {
			sb.append(segment);
			if (segment.equals(term)) break;
			mark = dot;
			dot = breaker.next();
			segment = content.substring(mark, dot);
		}
		return sb.toString();

	}
}
