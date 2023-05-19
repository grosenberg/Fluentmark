package net.certiv.fluent.dt.core.lang.md;

import java.util.List;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;

import net.certiv.fluent.dt.core.lang.md.gen.MdParser;

public abstract class MdParserBase extends Parser {

	public MdParserBase(TokenStream input) {
		super(input);
	}

	protected boolean twoSpaces() {
		CommonTokenStream ts = (CommonTokenStream) getTokenStream();
		List<Token> tokens = ts.getHiddenTokensToLeft(ts.index());
		return (tokens.size() == 2 //
				&& tokens.get(0).getType() == MdParser.HWS //
				&& tokens.get(1).getType() == MdParser.HWS //
		);
	}
}
