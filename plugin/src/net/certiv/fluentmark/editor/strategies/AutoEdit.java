package net.certiv.fluentmark.editor.strategies;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IDocument;

public class AutoEdit {

	private static final Pattern UL = Pattern.compile("([\\*\\+\\-]\\s+)\\S.*");
	private static final Pattern OL = Pattern.compile("(\\d+\\.\\s+)\\S.*");
	private static final Pattern[] MARKERS = { UL, OL };

	public AutoEdit() {}

	public static void insert(DocumentCommand cmd) {
		insert(cmd, "");
	}

	public static void insert(DocumentCommand cmd, String end) {
		cmd.text += end;
		configureCaret(cmd);
	}

	public static void skipRight(DocumentCommand cmd) {
		cmd.text = "";
		configureCaret(cmd);
	}

	public static boolean atSameChar(IDocument doc, DocumentCommand cmd) throws BadLocationException {
		if (cmd.text.length() != 1) return false;
		return cmd.text.charAt(0) == doc.getChar(cmd.offset);
	}

	public static void configureCaret(DocumentCommand cmd) {
		cmd.caretOffset = cmd.offset + 1;
		cmd.shiftsCaret = false;
	}

	/**
	 * Get the current offset of the command in the document, protecting against a command offset at
	 * the end of the document.
	 */
	public static int getOffset(IDocument doc, DocumentCommand cmd) {
		return cmd.offset == doc.getLength() ? cmd.offset - 1 : cmd.offset;
	}

	/**
	 * Get the index of the line containing the offset. An offset after the end of the document is
	 * considered valid.
	 */
	public static int getLineOfOffset(IDocument doc, int offset) throws BadLocationException {
		return doc.getLineOfOffset(offset);
	}

	/**
	 * Returns the offset of of the line that contains the offset in the document.
	 */
	public static int getLineOffset(IDocument doc, int offset) throws BadLocationException {
		int line = doc.getLineOfOffset(offset);
		if (line > -1) {
			return doc.getLineOffset(line);
		}
		return 0;
	}

	/**
	 * Returns the length of the line that contains the offset in the document. Length includes the
	 * line delimiter(s).
	 */
	public static int getLineLength(IDocument doc, int offset) throws BadLocationException {
		int line = doc.getLineOfOffset(offset);
		if (line > -1) {
			return doc.getLineLength(line);
		}
		return 0;
	}

	public static String getIndent(IDocument doc, int offset) throws BadLocationException {
		int line = doc.getLineOfOffset(offset);
		if (line > -1) {
			int beg = doc.getLineOffset(line);
			int end = doc.getLineLength(line) - 1 + beg;
			int eoWs = getEndOfWs(doc, beg, end);
			return doc.get(beg, eoWs - beg);
		}
		return "";
	}

	/**
	 * Get the width of the list marker, if present.
	 * 
	 * @param doc
	 * @param offset offset of the list marker, if present.
	 * @return
	 * @throws BadLocationException
	 */
	public static int listMarkerWidth(IDocument doc, int offset) throws BadLocationException {
		int line = doc.getLineOfOffset(offset);
		if (line > -1) {
			int beg = doc.getLineOffset(line);
			int end = doc.getLineLength(line) - 1 + beg;
			if (end > beg) {
				String text = doc.get(offset, end - beg);
				for (Pattern p : MARKERS) {
					Matcher m = p.matcher(text);
					if (m.find()) {
						return m.group(1).length();
					}
				}
			}
		}
		return 0;
	}

	/** Get the offset in the current line that is after the end of the indent */
	public static int getEndOfWs(IDocument doc, int offset) throws BadLocationException {
		int line = doc.getLineOfOffset(offset);
		if (line > -1) {
			int beg = doc.getLineOffset(line);
			int end = doc.getLineLength(line) - 1 + beg;
			return getEndOfWs(doc, beg, end);
		}
		return -1;
	}

	/**
	 * Returns the first offset greater than <code>beg</code> and smaller than <code>end</code>
	 * whose character is not a space or tab character. If no such offset is found, <code>end</code>
	 * is returned.
	 *
	 * @param doc the document to search in
	 * @param beg the offset at which searching start
	 * @param end the offset at which searching stops
	 * @return the offset in the specified range whose character is not a space or tab
	 * @exception BadLocationException if position is an invalid range in the given document
	 */
	public static int getEndOfWs(IDocument doc, int beg, int end) throws BadLocationException {
		for (int idx = beg; idx < end; idx++) {
			char c = doc.getChar(idx);
			if (c != ' ' && c != '\t') return idx;
		}
		return end;
	}

	/** Return the text of the line containing the offset from BOL to the offset location */
	public static String getLinePrefix(IDocument doc, int offset) throws BadLocationException {
		int line = doc.getLineOfOffset(offset);
		if (line > -1) {
			int beg = doc.getLineOffset(line);
			int len = offset - beg;
			return doc.get(beg, len);
		}
		return "";
	}

	/** Return true if the line containing the offset is blank upto the offset location */
	public static boolean isBlankLine(IDocument doc, int offset) throws BadLocationException {
		String prefix = getLinePrefix(doc, offset);
		for (char c : prefix.toCharArray()) {
			if (!Character.isWhitespace(c)) return false;
		}
		return true;
	}
}
