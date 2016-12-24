/*******************************************************************************
 * Copyright (c) 2016 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.convert;

import java.util.Iterator;

public class Convert extends ConvertData {

	private Convert() {}

	public static String getUnicode(String ref) {
		if (ref.startsWith("&") && ref.endsWith(";")) {
			if (ref.charAt(1) == '#') {
				String numStr = ref.substring(2, ref.indexOf(";"));
				int radix = 10;
				if (ref.charAt(2) == 'x' || ref.charAt(2) == 'X') {
					numStr = ref.substring(3, ref.indexOf(";"));
					radix = 16;
				}
				try {
					return String.valueOf(Character.toChars(Integer.parseInt(numStr, radix)));
				} catch (NumberFormatException exp) {
					return "?";
				}
			} else {
				String chStr = ref.substring(1, ref.indexOf(";"));
				String[] va = getRefMap().get(chStr);
				if (va != null) return va[2];
			}
		}
		return "?";
	}

	/**
	 * Encodes the given string.
	 */
	public static String encode(String input) {
		StringBuilder sb = new StringBuilder();
		for (int idx = 0; idx < input.length(); idx++) {
			sb.append(encode(input.charAt(idx)));
		}
		return sb.toString();
	}

	/**
	 * Encodes the given string.
	 */
	public static String encode(char unicode) {
		if (!requiresEncoding(unicode)) return String.valueOf(unicode);
		String[] va = getRefMap().get(String.valueOf(unicode));
		if (va != null) return va[1];
		return String.valueOf(Character.toChars(unicode));
	}

	public static String encodeAlias(char unicode) {
		if (!requiresEncoding(unicode)) return String.valueOf(unicode);
		String[] va = getRefMap().get(String.valueOf(unicode));
		if (va != null) return va[0];
		return encode(unicode);
	}

	public static boolean requiresEncoding(char c) {
		return c > 127 || getRefMap().containsKey(String.valueOf(c));
	}

	public static Iterator<String[]> getIterator() {
		return getTipMap().values().iterator();
	}

	public static String getToolTip(String unicode) {
		String[] va = getTipMap().get(unicode);
		if (va == null) return null;
		return va[1];
	}
}
