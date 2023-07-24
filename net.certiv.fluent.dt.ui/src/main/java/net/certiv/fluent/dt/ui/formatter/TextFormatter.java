/*******************************************************************************
 * Copyright (c) 2016 - 2023 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluent.dt.ui.formatter;

import java.text.BreakIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.certiv.common.util.Strings;

/**
 * Formatter for markdown text.
 * <p>
 * Paragraph formatting rules:
 * <ol>
 * <li>condense horizontal whitespace sequences to a single space, except to two spaces
 * where followed by a single hard return
 * <li>remove single hard returns unless preceeded by two or more spaces
 * <li>ignore horizontal spacing in certain in-line quoted sequences: $ | ` | ' | "
 * </ol>
 */
public class TextFormatter {

	// negated look behind to exclude escaping '(?<!\\)'
	private static final String NO_ESC = "(?<!\\\\)\\";
	private static final String QUOTE = "[$`'\"]";
	private static final String PARA_BRK = "\\h\\h+\\R\\h*";
	private static final String SPACES = "\\s+";

	private TextFormatter() {}

	/**
	 * Format the given paragraph content to start at a zero indent level (column 0) with
	 * any line breaks implemented using the given delimiter.
	 *
	 * @param content the content to format
	 * @param delim   line break delimiter
	 * @return the formatted content
	 */
	public static String para(String content, String delim) {
		return para(content, 0, 0, delim);
	}

	/**
	 * Format the given paragraph content to start at the given indent level with any line
	 * breaks implemented using the given delimiter.
	 *
	 * @param content the content to format
	 * @param indent  indent in spaces
	 * @param delim   line break delimiter
	 * @return the formatted content
	 */
	public static String para(String content, int indent, String delim) {
		return para(content, indent, indent, delim);
	}

	/**
	 * Format the given paragraph content to start at the given indent level with any line
	 * breaks implemented using the given delimiter.
	 *
	 * @param content     the content to format
	 * @param indentFirst initial indent in spaces
	 * @param indentRem   remaining indent in spaces
	 * @param delim       line break delimiter
	 * @return the formatted content
	 */
	public static String para(String content, int indentFirst, int indentRem, String delim) {
		StringBuilder sb = new StringBuilder();
		sb.append(Strings.spaces(indentFirst));

		content = content.trim();

		WordBreakIterator breaker = new WordBreakIterator();
		breaker.setText(content);

		int mark = 0;
		int dot = breaker.next();
		while (dot != BreakIterator.DONE) {

			String word = content.substring(mark, dot);

			if (word.matches(SPACES)) {
				if (word.matches(PARA_BRK)) {
					sb.append(Strings.spaces(2));
					sb.append(delim);
					sb.append(Strings.spaces(indentRem));

					dot = breaker.next();
					if (dot != BreakIterator.DONE) {
						word = content.substring(mark, dot);
						if (!word.matches(PARA_BRK)) {
							dot = breaker.previous();
						}
					}

				} else {
					sb.append(Strings.SPACE);
				}

			} else if (word.matches(QUOTE)) {
				int inc = next(word, dot, content);
				if (inc > -1) {
					dot = breaker.advance(inc);
					word = content.substring(mark, dot);
				}
				sb.append(word);

			} else {
				sb.append(word);
			}

			mark = dot;
			dot = breaker.next();
		}

		return sb.toString();
	}

	/** Return the relative offset of the end of the next instance of the given word */
	private static int next(String word, int dot, String content) {
		String line = Strings.PAT_NL.split(content.substring(dot), -1)[0];
		Matcher m = Pattern.compile(NO_ESC + word).matcher(line);
		if (!m.find()) return -1;
		return m.end();
	}

	private static final Pattern PAT_MARK = Pattern.compile("" //
			+ "\\h*" //
			+ "([*+-]" //
			+ "|[0-9a-zA-Z][.)]" //
			+ ")\\h*" //
			+ "(\\[[0-9a-zA-Z ]\\])?\\h*" //
	);

	/**
	 * Format the given list item content to start at the given indent level with any line
	 * breaks implemented using the given delimiter and further indented by the width of
	 * the list item mark.
	 *
	 * @param content the content to format
	 * @param indent  indent in spaces
	 * @param delim   line break delimiter
	 * @return the formatted content
	 */
	public static String list(String content, int indent, String delim) {
		Matcher m = PAT_MARK.matcher(content);
		if (!m.find()) return content; // failure/no change

		StringBuilder sb = new StringBuilder();
		sb.append(Strings.spaces(indent));
		sb.append(mark(m));

		content = content.substring(m.end());
		content = para(content, 0, sb.length(), delim);
		sb.append(content);

		return sb.toString();
	}

	private static String mark(Matcher m) {
		StringBuilder sb = new StringBuilder();
		sb.append(m.group(1));
		String task = m.group(2);
		if (task != null) {
			sb.append(Strings.SPACE);
			sb.append(task);
		}
		sb.append(Strings.SPACE);
		return sb.toString();
	}
}
