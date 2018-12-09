package net.certiv.fluentmark.core.md.parser;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;

import net.certiv.fluentmark.core.md.parser.gen.MdLexer;

public abstract class LexerAdaptor extends LexerNeo {

	private static final Set<Character> ATTRS = new HashSet<>(
			Arrays.asList(new Character[] { '`', '\'', '"', '*', '_', '~' }));

	private static final Pattern Link = Pattern.compile("\\!?\\[.*?\\]([ ]?(\\(\\S*?([ ]?\".*?\")?\\)|\\[.*?\\]))?");
	private static final Pattern LRef = Pattern.compile("\\[.*?\\]:[ ]?(\\S+?://)?\\S+([ ]?\".*?\")?");

	private final char[] in;
	private Token last;

	public LexerAdaptor(CharStream input) {
		super(input);
		in = input.toString().toCharArray();
	}

	@Override
	public void emit(Token token) {
		super.emit(token);
		last = token;
	}

	/** Returns {@code true} if the immediately after {@code MdLexer.TERM}. */
	protected boolean aftTerm() {
		if (bof()) return true;
		if (!bol()) return false;
		if (!_queue.isEmpty()) return _queue.peekLast().getType() == MdLexer.TERM;
		return last.getType() == MdLexer.TERM;
	}

	/** Returns {@code true} if immediately before {@code MdLexer.TERM}. */
	protected boolean befTerm() {
		int cnt = 0;
		for (int idx = _input.index(); idx < in.length; idx++) {
			char ch = in[idx];
			if (ch == Token.EOF) return true;
			if (!Character.isWhitespace(ch)) return false;
			if (ch == ' ' || ch == '\t' || ch == '\r') continue;
			if (ch == '\n') {
				if (cnt == 1) return true;
				cnt++;
			}
		}
		return true;
	}

	protected boolean link() {
		try {
			int idx = _input.index() - 1;
			String txt = String.valueOf(in, idx, in.length - idx);
			boolean found = Link.matcher(txt).lookingAt();
			// Log.info(this, "Link (" + found + "): " + Strings.ellipsize(txt, 48));
			return found;
		} catch (Exception e) {}
		return false;
	}

	protected boolean linkRef() {
		try {
			int idx = _input.index() - 1;
			String txt = String.valueOf(in, idx, in.length - idx);
			boolean found = LRef.matcher(txt).lookingAt();
			// Log.info(this, "LinkRef(" + found + "): " + Strings.ellipsize(txt, 48));
			return found;
		} catch (Exception e) {}
		return false;
	}

	// attribute at left edge: left is ws, right is text
	protected boolean left() {
		char ch = boundaryLeft();
		if (ch == Token.INVALID_TYPE || !isText(ch)) {
			ch = boundaryRight();
			return ch == Token.EOF || isText(ch);
		}
		return false;
	}

	// attribute at right edge: left is text, right is ws
	protected boolean right() {
		char ch = boundaryLeft();
		if (ch == Token.INVALID_TYPE || isText(ch)) {
			ch = boundaryRight();
			return ch == Token.EOF || !isText(ch);
		}
		return false;
	}

	private boolean isText(char ch) {
		return !(Character.isWhitespace(ch) || isPunctuation(ch));
	}

	private boolean isPunctuation(char ch) {
		switch (Character.getType(ch)) {
			case Character.DASH_PUNCTUATION:
			case Character.START_PUNCTUATION:
			case Character.END_PUNCTUATION:
			case Character.CONNECTOR_PUNCTUATION:
			case Character.OTHER_PUNCTUATION:
			case Character.MATH_SYMBOL:
			case Character.CURRENCY_SYMBOL:
			case Character.MODIFIER_SYMBOL:
			case Character.OTHER_SYMBOL:
			case Character.INITIAL_QUOTE_PUNCTUATION:
			case Character.FINAL_QUOTE_PUNCTUATION:
				return true;
			default:
				return false;
		}
	}

	// _input.index points at the first lookahead char
	private char boundaryLeft() {
		for (int idx = _input.index() - 1; idx >= 0; idx--) {
			char ch = in[idx];
			if (ATTRS.contains(Character.valueOf(ch))) continue;
			return ch;
		}
		return Token.INVALID_TYPE;
	}

	private char boundaryRight() {
		for (int idx = _input.index(); idx < in.length; idx++) {
			char ch = in[idx];
			if (ATTRS.contains(Character.valueOf(ch))) continue;
			return ch;
		}
		return (char) Token.EOF;
	}

	/** Returns true iif the input stream contains a balanced close of the just matched character. */
	protected boolean closed(int end) {
		int beg = _input.LA(-1);
		int cnt = 1;
		for (int idx = _input.index(); idx < in.length; idx++) {
			char ch = in[idx];
			if (ch == Token.EOF || ch == '\r' || ch == '\n') return false;
			if (ch == beg) cnt++;
			if (ch == end) cnt--;
			if (cnt == 0) return true;
		}
		return false;
	}

	protected boolean contLink() {
		for (int la = 0, idx = 1; la != Token.EOF; la = _input.LA(idx++)) {
			switch (la) {
				case ' ':
				case '\t':
					continue;
				case '(':
				case '[':
					return true;
				default:
					return false;
			}
		}
		return false;
	}

	/** Returns true iif the current lexer position follows any of the given characters. */
	protected boolean follows(char... cs) {
		for (int la = 0, idx = -1; la != Token.EOF; la = _input.LA(idx--)) {
			if (la == ' ' || la == '\t') {
				continue;
			} else {
				for (char ch : cs) {
					if (la == ch) return true;
				}
			}
		}
		return false;
	}

	/**
	 * Returns true if the lexer is currently positioned before a blank line given that the current
	 * position is immediately after {@code VWS}. {@code EOF} is defined to be a blank line.
	 */
	protected boolean atBlankLine() {
		for (int la = 0, idx = 1; la != Token.EOF; la = _input.LA(idx++)) {
			switch (la) {
				case ' ':
				case '\t':
					continue;
				case '\r':
				case '\n':
					return true;
				default:
					return false;
			}
		}
		return true; // hit EOF
	}

	// /** On left edge of text without intervening ws, ignoring ATTRS. */
	// protected boolean left() {
	// if (!isText(boundaryLeft()) && isText(boundaryRight())) return true;
	// return false;
	// }
	//
	// /** On right edge of text without intervening ws, ignoring ATTRS. */
	// protected boolean right() {
	// if (isText(boundaryLeft()) && !isText(boundaryRight())) return true;
	// return false;
	// }
}
