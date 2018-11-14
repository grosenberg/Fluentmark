package net.certiv.fluentmark.core.dot.parser;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenFactory;
import org.antlr.v4.runtime.TokenSource;
import org.antlr.v4.runtime.misc.Pair;

public class DotTokenFactory implements TokenFactory<DotToken> {

	private int tabWidth;

	public DotTokenFactory() {}

	public void setTabWidth(int tabWidth) {
		this.tabWidth = tabWidth;
	}

	@Override
	public DotToken create(int type, String text) {
		DotToken token = new DotToken(type, text, tabWidth);
		return token;
	}

	@Override
	public DotToken create(Pair<TokenSource, CharStream> source, int type, String text, int channel, int start,
			int stop, int line, int charPos) {

		DotToken token = new DotToken(source, type, channel, start, stop, tabWidth);
		token.setText(text);
		token.setLine(line);
		token.setCharPositionInLine(charPos);
		token.setMode(((Lexer) source.a)._mode);
		return token;
	}
}
