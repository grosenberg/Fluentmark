package net.certiv.fluentmark.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Pattern;

import net.certiv.fluentmark.util.legacy.Printer;

public final class Strings {

	public static final String ISO_LATIN = "ISO-8859-1";
	public static final String UTF_8 = "UTF-8";
	public static final String EOL = System.getProperty("line.separator");
	public static final String EOL2 = EOL + EOL;
	public static final Pattern BLANK_LINE = Pattern.compile("^\\s+$", 8);

	public static String ellipsize(String input, int maxLength) {
		if (input == null) return null;
		if (input.length() <= maxLength) return input;
		if (maxLength < 3) return "";
		if (maxLength == 3) return "...";
		int i = input.lastIndexOf(' ', maxLength - 3);
		if (i < 1 || i < maxLength - 10) {
			i = maxLength - 3;
		}
		return String.valueOf(substring(input, 0, i)) + "...";
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

	// ===========================================================================

	public static int countLeading(String text, char lead) {
		int count = 0;
		for (char s : text.toCharArray()) {
			if (s != lead) return count;
			count++;
		}
		return count;
	}

	public static String join(Collection<?> list, String separator) {
		return Printer.toString(list, separator);
	}

	public static StringBuilder join(String start, Collection<?> list, String separator, String end) {
		StringBuilder sb = new StringBuilder(start);
		if (!list.isEmpty()) {
			for (Iterator<?> iterator = list.iterator(); iterator.hasNext();) {
				Object t = (Object) iterator.next();
				if (t != null) {
					sb.append(Printer.toString(t));
					sb.append(separator);
				}
			}

			if (sb.length() != 0) {
				pop(sb, separator.length());
			}
		}
		sb.append(end);
		return sb;
	}

	public static String join(String array[], String separator) {
		if (array.length == 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		String as[];
		int j = (as = array).length;
		for (int i = 0; i < j; i++) {
			String string = as[i];
			if (string != null) {
				sb.append(string);
				sb.append(separator);
			}
		}

		if (sb.length() != 0) {
			pop(sb, separator.length());
		}
		return sb.toString();
	}

	public static void join(StringBuilder sb, Collection<?> list, String separator) {
		Printer.append(sb, list, separator);
	}

	public static void pop(StringBuilder sb, int chars) {
		sb.delete(sb.length() - chars, sb.length());
	}

	public static String substring(String string, int start, int end) {
		if (string == null) {
			return null;
		}
		int len = string.length();
		if (start < 0) {
			start = len + start;
			if (start < 0) {
				start = 0;
			}
		}
		if (end <= 0) {
			end = len + end;
			if (end < start) {
				return "";
			}
		}
		if (end > len) {
			end = len;
		}
		if (start == 0 && end == len) {
			return string;
		} else {
			return string.substring(start, end);
		}
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

	public static String toNSigFigs(double x, int n) {
		if (n <= 0) {
			throw new AssertionError();
		}
		String sign = x >= 0.0D ? "" : "-";
		double v = Math.abs(x);
		double lv = Math.floor(Math.log10(v));
		double keeper = Math.pow(10D, n - 1);
		double tens = Math.pow(10D, lv);
		int keepMe = (int) Math.round((v * keeper) / tens);
		if (lv < 0.0D) {
			String s = toNSigFigs2_small(n, sign, lv, keepMe);
			if (s != null) {
				return s;
			}
		}
		double vt = ((double) keepMe * tens) / keeper;
		String num = Printer.toStringNumber(Double.valueOf(vt));
		return (new StringBuilder(String.valueOf(sign))).append(num).toString();
	}

	private static String toNSigFigs2_small(int n, String sign, double lv, int keepMe) {
		if (lv < -8D) {
			return null;
		}
		StringBuilder sb = new StringBuilder(sign);
		int zs = (int) (-lv);
		String sKeepMe = Integer.toString(keepMe);
		if (sKeepMe.length() > n) {
			if (sKeepMe.charAt(sKeepMe.length() - 1) != '0') {
				throw new AssertionError();
			}
			zs--;
			sKeepMe = sKeepMe.substring(0, sKeepMe.length() - 1);
			if (zs == 0) {
				return null;
			}
		}
		sb.append("0.");
		for (int i = 1; i < zs; i++) {
			sb.append('0');
		}

		sb.append(sKeepMe);
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
