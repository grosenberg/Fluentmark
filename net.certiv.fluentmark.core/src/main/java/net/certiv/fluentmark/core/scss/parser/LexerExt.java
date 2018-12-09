package net.certiv.fluentmark.core.scss.parser;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;

public abstract class LexerExt extends Lexer {

	protected boolean _number;

	public LexerExt(CharStream input) {
		super(input);
	}

	protected void atNumber() {
		_number = true;
	}

	protected boolean aftNumber() {
		if (!_number && Character.isWhitespace(_input.LA(1))) return false;
		_number = false;
		return true;
	}
}
