package net.certiv.fluentmark.ui.editor.text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;

public class MdUtil {

	private static final Pattern UL = Pattern.compile("([\\*\\+\\-]\\s+)\\S.*");
	private static final Pattern OL = Pattern.compile("(\\d+\\.\\s+)\\S.*");
	private static final Pattern[] MARKERS = { UL, OL };

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
}
