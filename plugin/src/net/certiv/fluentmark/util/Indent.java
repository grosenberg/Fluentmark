package net.certiv.fluentmark.util;

import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DefaultLineTracker;
import org.eclipse.jface.text.ILineTracker;
import org.eclipse.jface.text.IRegion;
import org.eclipse.text.edits.ReplaceEdit;

public class Indent {

	public static final String EMPTY = ""; //$NON-NLS-1$

	/**
	 * Returns the indentation of the given line in tab equivalents. Partial tabs are not counted.
	 */
	public static int measureIndentInTabs(String line, int tabWidth) {
		int spaces = measureIndentInSpaces(line, tabWidth);
		return spaces / tabWidth;
	}

	/**
	 * Returns the indentation of the given line in space equivalents.
	 * <p>
	 * Tab characters are counted using the given <code>tabWidth</code> and every other indent
	 * character as one. This method analyzes the content of <code>line</code> up to the first
	 * non-whitespace character.
	 *
	 * @param line the string to measure the indent of
	 * @param tabWidth the width of one tab in space equivalents
	 * @return the measured indent width in space equivalents
	 * @exception IllegalArgumentException if:
	 *                <ul>
	 *                <li>the given <code>line</code> is null</li>
	 *                <li>the given <code>tabWidth</code> is lower than zero</li>
	 *                </ul>
	 */
	public static int measureIndentInSpaces(String line, int tabWidth) {
		if (tabWidth < 0 || line == null) throw new IllegalArgumentException();

		int length = 0;
		int max = line.length();
		for (int i = 0; i < max; i++) {
			char ch = line.charAt(i);
			if (ch == '\t') {
				int reminder = length % tabWidth;
				length += tabWidth - reminder;
			} else if (isIndentChar(ch)) {
				length++;
			} else {
				return length;
			}
		}
		return length;
	}

	/**
	 * Returns <code>true</code> if the given character is an indentation character. Indentation
	 * character are all whitespace characters except the line delimiter characters.
	 *
	 * @param ch the given character
	 * @return Returns <code>true</code> if this the character is a indent character,
	 *         <code>false</code> otherwise
	 */
	private static boolean isIndentChar(char ch) {
		return Character.isWhitespace(ch) && !isLineDelimiterChar(ch);
	}

	/**
	 * Returns <code>true</code> if the given character is a line delimiter character.
	 *
	 * @param ch the given character
	 * @return Returns <code>true</code> if this the character is a line delimiter character,
	 *         <code>false</code> otherwise
	 */
	private static boolean isLineDelimiterChar(char ch) {
		return ch == '\n' || ch == '\r';
	}

	/**
	 * Change the indent of a, possible multiple line, code string. The given number of indent units
	 * is removed, and a new indent string is added.
	 * <p>
	 * The first line of the code will not be changed (It is considered to have no indent as it
	 * might start in the middle of a line).
	 * </p>
	 *
	 * @param code the code to change the indent of
	 * @param indentUnitsToRemove the number of indent units to remove from each line (except the
	 *            first) of the given code
	 * @param tabWidth the size of one tab in space equivalents
	 * @param indentWidth the width of one indentation unit in space equivalents
	 * @param newIndentString the new indent string to be added to all lines (except the first)
	 * @param lineDelim the new line delimiter to be used. The returned code will contain only this
	 *            line delimiter.
	 * @return the newly indent code, containing only the given line delimiters.
	 * @exception IllegalArgumentException if:
	 *                <ul>
	 *                <li>the given <code>indentWidth</code> is lower or equals to zero</li>
	 *                <li>the given <code>tabWidth</code> is lower than zero</li>
	 *                <li>the given <code>code</code> is null</li>
	 *                <li>the given <code>indentUnitsToRemove</code> is lower than zero</li>
	 *                <li>the given <code>newIndentString</code> is null</li>
	 *                <li>the given <code>lineDelim</code> is null</li>
	 *                </ul>
	 */
	public static String changeIndent(String code, int indentUnitsToRemove, int tabWidth, int indentWidth,
			String newIndentString, String lineDelim) {
		if (tabWidth < 0 || indentWidth <= 0 || code == null || indentUnitsToRemove < 0 || newIndentString == null
				|| lineDelim == null) {
			throw new IllegalArgumentException();
		}

		try {
			ILineTracker tracker = new DefaultLineTracker();
			tracker.set(code);
			int nLines = tracker.getNumberOfLines();
			if (nLines == 1) {
				return code;
			}

			StringBuffer buf = new StringBuffer();

			for (int i = 0; i < nLines; i++) {
				IRegion region = tracker.getLineInformation(i);
				int start = region.getOffset();
				int end = start + region.getLength();
				String line = code.substring(start, end);

				if (i == 0) {
					// no indent for first line (contained in the formatted string)
					buf.append(line);
				} else {
					// no new line after last line
					buf.append(lineDelim);
					buf.append(newIndentString);
					buf.append(trimIndent(line, indentUnitsToRemove, tabWidth, indentWidth));
				}
			}
			return buf.toString();
		} catch (BadLocationException e) {
			// can not happen
			return code;
		}
	}

	/**
	 * Removes the given number of indentation units from a given line. If the line has less than
	 * the given indent, all the available indentation is removed. If
	 * <code>indentsToRemove <= 0</code> the line is returned.
	 *
	 * @param line the line to trim
	 * @param tabWidth the width of one tab in space equivalents
	 * @param indentWidth the width of one indentation unit in space equivalents
	 * @return the trimmed string
	 * @exception IllegalArgumentException if:
	 *                <ul>
	 *                <li>the given <code>indentWidth</code> is lower or equals to zero</li>
	 *                <li>the given <code>tabWidth</code> is lower than zero</li>
	 *                <li>the given <code>line</code> is null</li>
	 *                </ul>
	 */
	private static String trimIndent(String line, int indentUnitsToRemove, int tabWidth, int indentWidth) {
		if (tabWidth < 0 || indentWidth <= 0 || line == null) throw new IllegalArgumentException();
		if (indentUnitsToRemove <= 0) return line;

		final int spaceEquivalentsToRemove = indentUnitsToRemove * indentWidth;

		int start = 0;
		int spaceEquivalents = 0;
		int size = line.length();
		String prefix = null;
		for (int i = 0; i < size; i++) {
			char c = line.charAt(i);
			if (c == '\t') {
				int remainder = spaceEquivalents % tabWidth;
				spaceEquivalents += tabWidth - remainder;
			} else if (isIndentChar(c)) {
				spaceEquivalents++;
			} else {
				// Assert.isTrue(false, "Line does not have requested number of indents");
				start = i;
				break;
			}
			if (spaceEquivalents == spaceEquivalentsToRemove) {
				start = i + 1;
				break;
			}
			if (spaceEquivalents > spaceEquivalentsToRemove) {
				// can happen if tabSize > indentSize, e.g tabsize==8, indent==4,
				// indentsToRemove==1, line prefixed with one tab
				// this implements the third option
				start = i + 1; // remove the tab
				// and add the missing spaces
				char[] missing = new char[spaceEquivalents - spaceEquivalentsToRemove];
				Arrays.fill(missing, ' ');
				prefix = new String(missing);
				break;
			}
		}
		String trimmed;
		if (start == size) {
			trimmed = EMPTY;
		} else {
			trimmed = line.substring(start);
		}

		if (prefix == null) {
			return trimmed;
		}
		return prefix + trimmed;
	}

	/**
	 * Returns the text edits retrieved after changing the indentation of a, possible multi-line,
	 * code string.
	 * <p>
	 * The given number of indent units is removed, and a new indent string is added.
	 * </p>
	 * <p>
	 * The first line of the code will not be changed (It is considered to have no indent as it
	 * might start in the middle of a line).
	 * </p>
	 *
	 * @param source The code to change the indent of
	 * @param indentUnitsToRemove the number of indent units to remove from each line (except the
	 *            first) of the given code
	 * @param tabWidth the size of one tab in space equivalents
	 * @param indentWidth the width of one indentation unit in space equivalents
	 * @param newIndentString the new indent string to be added to all lines (except the first)
	 * @return returns the resulting text edits
	 * @exception IllegalArgumentException if:
	 *                <ul>
	 *                <li>the given <code>indentWidth</code> is lower or equals to zero</li>
	 *                <li>the given <code>tabWidth</code> is lower than zero</li>
	 *                <li>the given <code>source</code> is null</li>
	 *                <li>the given <code>indentUnitsToRemove</code> is lower than zero</li>
	 *                <li>the given <code>newIndentString</code> is null</li>
	 *                </ul>
	 */
	public static ReplaceEdit[] getChangeIndentEdits(String source, int indentUnitsToRemove, int tabWidth,
			int indentWidth, String newIndentString) {
		if (tabWidth < 0 || indentWidth <= 0 || source == null || indentUnitsToRemove < 0 || newIndentString == null) {
			throw new IllegalArgumentException();
		}

		ArrayList<ReplaceEdit> result = new ArrayList<ReplaceEdit>();
		try {
			ILineTracker tracker = new DefaultLineTracker();
			tracker.set(source);
			int nLines = tracker.getNumberOfLines();
			if (nLines == 1) {
				return result.toArray(new ReplaceEdit[result.size()]);
			}
			for (int i = 1; i < nLines; i++) {
				IRegion region = tracker.getLineInformation(i);
				int offset = region.getOffset();
				String line = source.substring(offset, offset + region.getLength());
				int length = indexOfIndent(line, indentUnitsToRemove, tabWidth, indentWidth);
				if (length >= 0) {
					result.add(new ReplaceEdit(offset, length, newIndentString));
				} else {
					length = measureIndentUnits(line, tabWidth, indentWidth);
					result.add(new ReplaceEdit(offset, length, "")); //$NON-NLS-1$
				}
			}
		} catch (BadLocationException cannotHappen) {}
		return result.toArray(new ReplaceEdit[result.size()]);
	}

	/*
	 * Returns the index where the indent of the given size ends. Returns <code>-1<code> if the line
	 * isn't prefixed with an indent of the given number of indents.
	 */
	private static int indexOfIndent(CharSequence line, int numberOfIndentUnits, int tabWidth, int indentWidth) {

		int spaceEquivalents = numberOfIndentUnits * indentWidth;

		int size = line.length();
		int result = -1;
		int blanks = 0;
		for (int i = 0; i < size && blanks < spaceEquivalents; i++) {
			char c = line.charAt(i);
			if (c == '\t') {
				int remainder = blanks % tabWidth;
				blanks += tabWidth - remainder;
			} else if (isIndentChar(c)) {
				blanks++;
			} else {
				break;
			}
			result = i;
		}
		if (blanks < spaceEquivalents) {
			return -1;
		}
		return result + 1;
	}

	/**
	 * Returns the indentation of the given line in indentation units. Odd spaces are not counted.
	 * This method only analyzes the content of <code>line</code> up to the first non-whitespace
	 * character.
	 *
	 * @param line the string to measure the indent of
	 * @param tabWidth the width of one tab character in space equivalents
	 * @param indentWidth the width of one indentation unit in space equivalents
	 * @return the number of indentation units that line is indented by
	 * @exception IllegalArgumentException if:
	 *                <ul>
	 *                <li>the given <code>indentWidth</code> is lower or equals to zero</li>
	 *                <li>the given <code>tabWidth</code> is lower than zero</li>
	 *                <li>the given <code>line</code> is null</li>
	 *                </ul>
	 */
	private static int measureIndentUnits(String line, int tabWidth, int indentWidth) {
		if (indentWidth <= 0 || tabWidth < 0 || line == null) {
			throw new IllegalArgumentException();
		}

		int visualLength = measureIndentInSpaces(line, tabWidth);
		return visualLength / indentWidth;
	}

}
