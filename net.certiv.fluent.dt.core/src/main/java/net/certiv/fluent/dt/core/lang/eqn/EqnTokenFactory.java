package net.certiv.fluent.dt.core.lang.eqn;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenFactory;
import org.antlr.v4.runtime.TokenSource;
import org.antlr.v4.runtime.misc.Pair;

public class EqnTokenFactory implements TokenFactory<EqnToken> {

	private int tabWidth;

	public EqnTokenFactory() {}

	public void setTabWidth(int tabWidth) {
		this.tabWidth = tabWidth;
	}

	@Override
	public EqnToken create(int type, String text) {
		EqnToken token = new EqnToken(type, text, tabWidth);
		return token;
	}

	@Override
	public EqnToken create(Pair<TokenSource, CharStream> source, int type, String text, int channel, int start,
			int stop, int line, int charPos) {

		EqnToken token = new EqnToken(source, type, channel, start, stop, tabWidth);
		token.setText(text);
		token.setLine(line);
		token.setCharPositionInLine(charPos);
		token.setMode(((Lexer) source.a)._mode);
		return token;
	}
}
