package net.certiv.fluent.dt.core.lang.scss;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenFactory;
import org.antlr.v4.runtime.TokenSource;
import org.antlr.v4.runtime.misc.Pair;

public class ScssTokenFactory implements TokenFactory<ScssToken> {

	private int tabWidth = 4;

	public ScssTokenFactory() {}

	public void setTabWidth(int tabWidth) {
		this.tabWidth = tabWidth;
	}

	@Override
	public ScssToken create(int type, String text) {
		ScssToken token = new ScssToken(type, text, tabWidth);
		return token;
	}

	@Override
	public ScssToken create(Pair<TokenSource, CharStream> source, int type, String text, int channel, int start, int stop,
			int line, int charPos) {

		ScssToken token = new ScssToken(source, type, channel, start, stop, tabWidth);
		token.setText(text);
		token.setLine(line);
		token.setCharPositionInLine(charPos);
		token.setMode(((Lexer) source.a)._mode);
		return token;
	}
}
