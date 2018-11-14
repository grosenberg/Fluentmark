package net.certiv.fluentmark.core.md.parser;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Interval;

import net.certiv.fluentmark.core.md.parser.gen.MdLexer;

public abstract class LexerAdaptor extends LexerNeo {

	private static final Set<Character> ATTRS = new HashSet<>(
			Arrays.asList(new Character[] { '`', '\'', '"', '*', '_', '~' }));

	public LexerAdaptor(CharStream input) {
		super(input);
	}

	/** Returns {@code true} if the immediately prior matched token is {@code MdLexer.TERM}. */
	protected boolean term() {
		if (!bol()) return false;
		if (prior().getType() == MdLexer.TERM) return true;
		return false;
	}

	private Token prior() {
		if (!_queue.isEmpty()) return _queue.peekLast();
		return _priors.peek();
	}

	/** On left edge of thing */
	protected boolean left() {
		for (int ch = 0, idx = 1;; ch = _input.LA(idx++)) {
			if (ch == Token.EOF) return false;
			if (Character.isWhitespace(ch)) return false;
			if (ATTRS.contains(Character.valueOf((char) ch))) continue;
			break;
		}

		for (int ch = 0, idx = -1, beg = -_input.index(); idx >= beg; ch = _input.LA(idx--)) {
			if (Character.isWhitespace(ch)) break;
			if (ATTRS.contains(Character.valueOf((char) ch))) continue;
			return false;
		}

		return true;
	}

	/** On right edge of thing */
	protected boolean right() {
		for (int ch = 0, idx = -1, beg = -_input.index(); idx >= beg; ch = _input.LA(idx--)) {
			if (ch == Token.EOF) return false;
			if (Character.isWhitespace(ch)) return false;
			if (ATTRS.contains(Character.valueOf((char) ch))) continue;
			break;
		}

		for (int ch = 0, idx = 1;; ch = _input.LA(idx++)) {
			if (Character.isWhitespace(ch)) break;
			if (ATTRS.contains(Character.valueOf((char) ch))) continue;
			return false;
		}

		return true;
	}

	/** Returns true iif the input stream contains a simple close of the just matched character. */
	protected boolean closed(int end) {
		int beg = _input.LA(-1);
		for (int ch = 0, idx = 1; ch != Token.EOF; ch = _input.LA(idx++)) {
			if (ch == end) return true;
			if (ch == beg || ch == '\r' || ch == '\n') return false;
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

	/**
	 * Returns true iif the lexer is currently positioned immediately after whitespace and before text.
	 */
	protected boolean attrLeft() {
		if (isWS(_input.LA(-1)) && isText(_input.LA(1))) return true;
		return false;
	}

	/**
	 * Returns true iif the lexer is currently positioned immediately after text and before whitespace.
	 */
	protected boolean attrRight() {
		if (isText(_input.LA(-1)) && isWS(_input.LA(1))) return true;
		return false;
	}

	private boolean isText(int ch) {
		return ch == Token.EOF || !Character.isWhitespace(ch);
	}

	private boolean isWS(int ch) {
		return ch == Token.EOF || Character.isWhitespace(ch);
	}

	/** Returns true if the lexer is currently positioned at the given input string. */
	protected boolean at(String s) {
		int len = s.length();
		String txt = _input.getText(Interval.of(_input.index(), _input.index() + len - 1));
		// System.err.println(String.format("%s == %s", s, txt));
		return s.equals(txt);
	}
}
