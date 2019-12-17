package net.certiv.fluent.dt.ui.editor.text.rules;

import java.util.Arrays;
import java.util.Comparator;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;

import net.certiv.fluent.dt.ui.editor.text.IScannerExt;

public class MatchRule implements IPredicateRule {

	private char[][] fLineDelimiters;
	private char[][] fSortedLineDelimiters;
	private static final Comparator<char[]> fLineDelimiterComparator = new Comparator<char[]>() {

		@Override
		public int compare(char[] o1, char[] o2) {
			return o2.length - o1.length;
		}
	};

	/** Internal setting for the un-initialized column constraint */
	protected static final int UNDEFINED = -1;

	/** The token to be returned on success */
	protected IToken fToken;
	/** The pattern's start sequence */
	protected char[] fStartSequence;
	/** The pattern's end sequence */
	protected char[] fEndSequence;
	/** The pattern's column constrain */
	protected int fColumn = UNDEFINED;
	/** The pattern's escape character */
	protected char fEscapeCharacter;
	/** Indicates whether the escape character continues a line */
	protected boolean fEscapeContinuesLine;
	/** Indicates whether end of line terminates the pattern */
	protected boolean fBreaksOnEOL;
	/** Indicates whether end of file terminates the pattern */
	protected boolean fBreaksOnEOF;

	/**
	 * Creates a rule for the given starting and ending sequence. When these sequences are detected the
	 * rule will return the specified token. Alternatively, the sequence can also be ended by the end of
	 * the line. Any character which follows the given escapeCharacter will be ignored.
	 *
	 * @param startSequence the pattern's start sequence
	 * @param endSequence the pattern's end sequence, {@code null} is a legal value
	 * @param token the token which will be returned on success
	 * @param escapeCharacter any character following this one will be ignored
	 * @param breaksOnEOL indicates whether the end of the line also terminates the pattern
	 */
	public MatchRule(String startSequence, String endSequence, IToken token, char escapeCharacter,
			boolean breaksOnEOL) {
		Assert.isTrue(startSequence != null && startSequence.length() > 0);
		Assert.isTrue(endSequence != null || breaksOnEOL);
		Assert.isNotNull(token);

		fStartSequence = startSequence.toCharArray();
		fEndSequence = (endSequence == null ? new char[0] : endSequence.toCharArray());
		fToken = token;
		fEscapeCharacter = escapeCharacter;
		fBreaksOnEOL = breaksOnEOL;
	}

	/**
	 * Creates a rule for the given starting and ending sequence. When these sequences are detected the
	 * rule will return the specified token. Alternatively, the sequence can also be ended by the end of
	 * the line or the end of the file. Any character which follows the given escapeCharacter will be
	 * ignored.
	 *
	 * @param startSequence the pattern's start sequence
	 * @param endSequence the pattern's end sequence, {@code null} is a legal value
	 * @param token the token which will be returned on success
	 * @param escapeCharacter any character following this one will be ignored
	 * @param breaksOnEOL indicates whether the end of the line also terminates the pattern
	 * @param breaksOnEOF indicates whether the end of the file also terminates the pattern
	 */
	public MatchRule(String startSequence, String endSequence, IToken token, char escapeCharacter, boolean breaksOnEOL,
			boolean breaksOnEOF) {
		this(startSequence, endSequence, token, escapeCharacter, breaksOnEOL);
		fBreaksOnEOF = breaksOnEOF;
	}

	/**
	 * Sets a column constraint for this rule. If set, the rule's token will only be returned if the
	 * pattern is detected starting at the specified column. If the column is smaller then 0, the column
	 * constraint is considered removed.
	 *
	 * @param column the column in which the pattern starts
	 */
	public void setColumnConstraint(int column) {
		if (column < 0) column = UNDEFINED;
		fColumn = column;
	}

	/**
	 * Evaluates this rules without considering any column constraints.
	 *
	 * @param scanner the character scanner to be used
	 * @return the token resulting from this evaluation
	 */
	protected IToken doEvaluate(ICharacterScanner scanner) {
		return doEvaluate(scanner, false);
	}

	/**
	 * Evaluates this rules without considering any column constraints. Resumes detection, i.e. look
	 * sonly for the end sequence required by this rule if the {@code resume} flag is set.
	 *
	 * @param scanner the character scanner to be used
	 * @param resume {@code true} if detection should be resumed, {@code false} otherwise
	 * @return the token resulting from this evaluation
	 * @since 2.0
	 */
	protected IToken doEvaluate(ICharacterScanner scanner, boolean resume) {
		if (resume) {
			if (endSequenceDetected(scanner)) return fToken;
		} else {
			if (sequenceDetected(scanner, fStartSequence, false)) {
				if (endSequenceDetected(scanner)) return fToken;
			}
		}
		return Token.UNDEFINED;
	}

	@Override
	public IToken evaluate(ICharacterScanner scanner) {
		return evaluate(scanner, false);
	}

	/**
	 * Returns whether the next characters to be read by the character scanner are an exact match with
	 * the given sequence. No escape characters are allowed within the sequence. If specified the
	 * sequence is considered to be found when reading the EOF character.
	 *
	 * @param scanner the character scanner to be used
	 * @param sequence the sequence to be detected
	 * @param eofAllowed indicated whether EOF terminates the pattern
	 * @return {@code true} if the given sequence has been detected
	 */
	protected boolean sequenceDetected(ICharacterScanner scanner, char[] sequence, boolean eofAllowed) {
		return sequenceDetected(scanner, sequence, true, eofAllowed);
	}

	/**
	 * Returns whether the end sequence was detected. As the pattern can be considered ended by a line
	 * delimiter, the result of this method is {@code true} if the rule breaks on the end of the
	 * line, or if the EOF character is read.
	 *
	 * @param scanner the character scanner to be used
	 * @return {@code true} if the end sequence has been detected
	 */
	protected boolean endSequenceDetected(ICharacterScanner scanner) {
		char[][] originalDelimiters = scanner.getLegalLineDelimiters();
		int count = originalDelimiters.length;
		if (fLineDelimiters == null || fLineDelimiters.length != count) {
			fSortedLineDelimiters = new char[count][];
		} else {
			while (count > 0 && Arrays.equals(fLineDelimiters[count - 1], originalDelimiters[count - 1])) {
				count--;
			}
		}
		if (count != 0) {
			fLineDelimiters = originalDelimiters;
			System.arraycopy(fLineDelimiters, 0, fSortedLineDelimiters, 0, fLineDelimiters.length);
			Arrays.sort(fSortedLineDelimiters, fLineDelimiterComparator);
		}

		int readCount = 1;
		int c;
		while ((c = scanner.read()) != ICharacterScanner.EOF) {
			if (c == fEscapeCharacter) {
				// Skip escaped character(s)
				if (fEscapeContinuesLine) {
					c = scanner.read();
					for (char[] fSortedLineDelimiter : fSortedLineDelimiters) {
						if (c == fSortedLineDelimiter[0]
								&& sequenceDetected(scanner, fSortedLineDelimiter, fBreaksOnEOF)) {
							break;
						}
					}
				} else {
					scanner.read();
				}

				// Check if the specified end sequence has been found.
			} else if (sequenceDetected(scanner, fEndSequence, false, fBreaksOnEOF)) {
				return true;
			} else if (fBreaksOnEOL) {
				// Check for end of line since it can be used to terminate the pattern.
				for (char[] fSortedLineDelimiter : fSortedLineDelimiters) {
					if (c == fSortedLineDelimiter[0]
							&& sequenceDetected(scanner, fSortedLineDelimiter, true, fBreaksOnEOF))
						return true;
				}
			}
			readCount++;
		}

		if (fBreaksOnEOF) return true;

		for (; readCount > 0; readCount--)
			scanner.unread();

		return false;
	}

	private boolean sequenceDetected(ICharacterScanner scanner, char[] sequence, boolean forward, boolean eofAllowed) {
		int c = scanner.read();
		if (c == ICharacterScanner.EOF) {
			if (forward) return false;
			return eofAllowed ? true : false;
		}
		scanner.unread();

		try {
			String txt = getScanText(scanner, 6, forward);
			String regex = String.valueOf(sequence);
			if (forward && txt.matches(regex + ".*")) {
				return true;
			}
			if (!forward && txt.matches(".*" + regex)) {
				return true;
			}
		} catch (BadLocationException e) {}
		return false;
	}

	private String getScanText(ICharacterScanner scanner, int max, boolean forward) throws BadLocationException {
		IScannerExt scan = ((IScannerExt) scanner);
		IDocument doc = scan.getDocument();
		int beg;
		int end;
		int len;
		if (forward) {
			beg = scan.getOffset();
			end = scan.getRangeEnd();
			len = Math.min(max, end - beg);
		} else {
			end = scan.getOffset() + 1;
			beg = Math.max(0, end - max);
			len = end - beg;
		}
		return doc.get(beg, len);
	}

	@Override
	public IToken evaluate(ICharacterScanner scanner, boolean resume) {
		if (fColumn == UNDEFINED) return doEvaluate(scanner, resume);

		int c = scanner.read();
		scanner.unread();
		if (c == fStartSequence[0])
			return (fColumn == scanner.getColumn() ? doEvaluate(scanner, resume) : Token.UNDEFINED);
		return Token.UNDEFINED;
	}

	@Override
	public IToken getSuccessToken() {
		return fToken;
	}
}
