/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Strings {

	private static final Pattern NL = Pattern.compile(".*?(\\R)");

	public static final Pattern BLANK_LINE = Pattern.compile("^\\s+$", 8);

	public static final String ISO_LATIN = "ISO-8859-1";
	public static final String UTF_8 = "UTF-8";
	public static final String EOL = System.getProperty("line.separator");
	// public static final String EOL2 = EOL + EOL;

	public static final String TTAB_MARK = "\u1E6F"; 		// t underbar ṯ
	public static final String TAB_MARK = "\u2666";			// diamond ♦
	public static final String PARA_MARK = "\u00B6";		// pillcrow ¶
	public static final String SPACE_MARK = "\u00B7";		// middle dot ·
	public static final String ELLIPSIS_MARK = "\u2026"; 	// ellipsis …
	public static final String LARR_MARK = "\u2190";		// leftwards arrow
	public static final String RARR_MARK = "\u2192";		// rightwards arrow →
	public static final String SPACE = " ";

	public static final char SPC = ' ';
	public static final char TAB = '\t';
	public static final char RET = '\r';
	public static final char NLC = '\n';
	public static final char DOT = '.';

	/** Encodes WS as visible characters. */
	public static String encode(String in) {
		StringBuilder sb = new StringBuilder();
		for (int idx = 0; idx < in.length(); idx++) {
			char c = in.charAt(idx);
			switch (c) {
				case SPC:
					sb.append(SPACE_MARK);
					break;
				case TAB:
					sb.append(TAB_MARK);
					break;
				case RET:
					if (idx + 1 == in.length() || in.charAt(idx + 1) != NLC) {
						sb.append(PARA_MARK);
					}
					break;
				case NLC:
					sb.append(PARA_MARK);
					break;
				default:
					sb.append(c);
			}
		}
		return sb.toString();
	}

	public static String ellipsize(String input, int maxLength) {
		if (input == null || input.length() < maxLength) return input;
		return input.substring(0, maxLength) + ELLIPSIS_MARK;
	}

	public static String capitalize(String meta) {
		if (meta == null) return "";
		meta = meta.trim();
		if (meta.isEmpty()) return meta;
		return meta.substring(0, 1).toUpperCase() + meta.substring(1);
	}

	public static String toTitleCase(String title) {
		if (title.length() < 2) {
			return title.toUpperCase();
		}
		StringBuilder sb = new StringBuilder(title.length());
		boolean goUp = true;
		int i = 0;
		for (int n = title.length(); i < n; i++) {
			char c = title.charAt(i);
			if (Character.isLetterOrDigit(c) || c == '\'') {
				if (goUp) {
					sb.append(Character.toUpperCase(c));
					goUp = false;
				} else {
					sb.append(Character.toLowerCase(c));
				}
			} else {
				sb.append(c);
				goUp = true;
			}
		}

		return sb.toString();
	}

	public static String normalize(String content) throws IllegalArgumentException {
		return content.replaceAll("\\r?\\n", EOL);
	}

	public static boolean isBlank(String line) {
		return line == null || line.trim().isEmpty();
	}

	public static String trimQuotes(String string) {
		if (string.charAt(0) != '\'' && string.charAt(0) != '"') {
			return string;
		}
		char c = string.charAt(string.length() - 1);
		if (c != '\'' && c != '"') {
			return string;
		} else {
			return string.substring(1, string.length() - 1);
		}
	}

	public static String trimLeadingPunctuation(String text) {
		int offset = 0;
		for (char c : text.toCharArray()) {
			if (Character.isLetterOrDigit(c)) break;
			offset++;
		}
		return text.substring(offset);
	}

	public static String trimLeft(String text) {
		for (int idx = 0; idx < text.length(); idx++) {
			if (!Character.isSpaceChar(text.charAt(idx))) {
				return text.substring(idx);
			}
		}
		return "";
	}

	public static String trimRight(String text) {
		for (int idx = text.length(); idx > 0; idx--) {
			if (!Character.isWhitespace(text.charAt(idx - 1))) {
				return text.substring(0, idx);
			}
		}
		return "";
	}

	public static String wrap(String s, int limit) {
		StringBuilder block = new StringBuilder();
		StringBuilder line = new StringBuilder();
		String[] words = s.split(" ");
		for (int i = 0; i < words.length; i++) {
			line.append(words[i]).append(" ");
			if (i + 1 == words.length || line.length() + words[i + 1].length() > limit) {
				line.deleteCharAt(line.length() - 1);
				block.append(line.toString() + EOL);
				line = new StringBuilder();
			}
		}
		return block.toString();
	}

	public static int wordCount(String text) {
		return text.split("\\s+").length;
	}

	public static int countLeading(String text, char lead) {
		int count = 0;
		for (char s : text.toCharArray()) {
			if (s != lead) return count;
			count++;
		}
		return count;
	}

	public static int countLines(String txt) {
		if (txt == null || txt.isEmpty()) return 0;

		int cnt = 0;
		Matcher m = NL.matcher(txt);
		while (m.find()) {
			cnt++;
		}
		return cnt;
	}

	public static int lastLineLen(String txt) {
		if (txt == null || txt.isEmpty()) return 0;

		int idx = txt.lastIndexOf(NLC);
		if (idx == -1) return txt.length();
		return txt.substring(idx + 1).length();
	}

	public static String toInitials(String name) {
		StringBuilder sb = new StringBuilder();
		boolean yes = true;
		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
			if (Character.isWhitespace(c)) {
				yes = true;
			} else {
				if (yes) {
					c = Character.toUpperCase(c);
					sb.append(c);
				}
				yes = false;
			}
		}

		return sb.toString();
	}

	/**
	 * Returns the visual width of the given line of text.
	 *
	 * @param text the string to measure
	 * @param tabWidth the visual width of a tab
	 * @return the visual width of <code>text</code>
	 * @see org.eclipse.jdt.ui/ui/org/eclipse/jdt/internal/ui/javaeditor/IndentUtil.java
	 */
	public static int measureVisualWidth(CharSequence text, int tabWidth) {
		return measureVisualWidth(text, tabWidth, 0);
	}

	/**
	 * Returns the visual width of the given text starting from the given offset within a line. Width is
	 * reset each time a line separator character is encountered.
	 *
	 * @param text the string to measure
	 * @param tabWidth the visual width of a tab
	 * @param from the visual starting offset of the text
	 * @return the visual width of <code>text</code>
	 * @see org.eclipse.jdt.ui/ui/org/eclipse/jdt/internal/ui/javaeditor/IndentUtil.java
	 */
	public static int measureVisualWidth(CharSequence text, int tabWidth, int from) {
		if (text == null || tabWidth < 0 || from < 0) throw new IllegalArgumentException();

		int width = from;
		for (int idx = 0, len = text.length(); idx < len; idx++) {
			switch (text.charAt(idx)) {
				case TAB:
					if (tabWidth > 0) width += tabWidth - width % tabWidth;
					break;
				case RET:
				case NLC:
					width = 0;
					from = 0;
					break;
				default:
					width++;
			}
		}
		return width - from;
	}

	public static String dup(String value, int cnt) {
		StringBuilder sb = new StringBuilder();
		for (int idx = 0; idx < cnt; idx++) {
			sb.append(value);
		}
		return sb.toString();
	}
}
