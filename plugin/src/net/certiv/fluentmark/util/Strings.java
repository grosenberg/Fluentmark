/*******************************************************************************
 * Copyright (c) 2016 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.util;

import java.util.regex.Pattern;

public final class Strings {

	public static final String ISO_LATIN = "ISO-8859-1";
	public static final String UTF_8 = "UTF-8";
	public static final String EOL = System.getProperty("line.separator");
	public static final String EOL2 = EOL + EOL;

	public static final Pattern BLANK_LINE = Pattern.compile("^\\s+$", 8);

	public static String ellipsize(String input, int maxLength) {
		if (input == null || input.length() < maxLength) return input;
		return input.substring(0, maxLength) + "...";
	}

	public static String capitalize(String meta) {
		if (meta == null) return "";
		meta = meta.trim();
		if (meta.isEmpty()) return meta;
		return meta.substring(0, 1).toUpperCase() + meta.substring(1);
	}

	public static String normalize(String content) throws IllegalArgumentException {
		return content.replaceAll("\\r?\\n", EOL);
	}

	public static boolean isBlank(String line) {
		return line == null || line.trim().isEmpty();
	}

	public static String trimLeadingPunctuation(String text) {
		int offset = 0;
		for (char c : text.toCharArray()) {
			if (Character.isLetterOrDigit(c)) break;
			offset++;
		}
		return text.substring(offset);
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
}
