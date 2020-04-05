package net.certiv.fluent.dt.core.lang.eqn;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.IntStream;
import org.antlr.v4.runtime.Lexer;

import net.certiv.dsl.core.util.Chars;

public abstract class LexerBase extends Lexer {

	private final String data;

	public LexerBase(CharStream input) {
		super(input);
		data = input.toString();
	}

	/**
	 * Return {@code true} if horizontal whitespace immediately preceeds the current
	 * in-progress, match.
	 */
	protected boolean at() {
		return at(1);
	}

	/**
	 * Return {@code true} if whitespace containing the given count of new lines
	 * immediately preceeds the current, in-progress match.
	 */
	protected boolean at(int cnt) {
		int idx = _tokenStartCharIndex;
		if (idx > 0) {
			for (char ch = 0; ch != IntStream.EOF && idx >= 0; idx--) {
				ch = data.charAt(idx - 1);
				if (!Character.isWhitespace(ch)) return false;
				if (ch == Chars.EOL) {
					cnt--;
					if (cnt == 0) return true;
				}
			}
		}
		return true;
	}
}
