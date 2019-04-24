package net.certiv.fluent.dt.core.lang.md;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenFactory;
import org.antlr.v4.runtime.TokenSource;
import org.antlr.v4.runtime.misc.Pair;

public class MdTokenFactory implements TokenFactory<MdToken> {

	private int tabWidth = 4;

	public MdTokenFactory() {}

	public void setTabWidth(int tabWidth) {
		this.tabWidth = tabWidth;
	}

	@Override
	public MdToken create(int type, String text) {
		MdToken token = new MdToken(type, text, tabWidth);
		return token;
	}

	@Override
	public MdToken create(Pair<TokenSource, CharStream> source, int type, String text, int channel, int start, int stop,
			int line, int charPos) {

		MdToken token = new MdToken(source, type, channel, start, stop, tabWidth);
		token.setText(text);
		token.setLine(line);
		token.setCharPositionInLine(charPos);
		token.setMode(((Lexer) source.a)._mode);
		return token;
	}
}
