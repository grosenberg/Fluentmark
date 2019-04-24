package net.certiv.fluent.dt.core.lang.md;

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;

import net.certiv.fluent.dt.core.lang.md.gen.MdLexer;

public abstract class MdParserBase extends Parser {

	public MdParserBase(TokenStream input) {
		super(input);
	}

	protected boolean befBL() {
		for (int idx = _input.index() + 1, len = _input.size() - 1; idx < len; idx++) {
			switch (_input.get(idx).getType()) {
				case MdLexer.HWS:
					continue;
				case MdLexer.LN_BLANK:
				case Token.EOF:
					return true;
				default:
					return false;
			}
		}
		return false;
	}

	protected boolean aftNL() {
		for (int idx = _input.index() - 1; idx >= 0; idx--) {
			switch (_input.get(idx).getType()) {
				case MdLexer.HWS:
					continue;
				case MdLexer.LN_BLANK:
				case MdLexer.LN_BREAK:
				case MdLexer.VWS:
					return true;
				default:
					return false;
			}
		}
		return false;
	}

	protected boolean befNL() {
		for (int idx = _input.index(), len = _input.size() - 1; idx < len; idx++) {
			switch (_input.get(idx).getType()) {
				case MdLexer.HWS:
					continue;
				case MdLexer.LN_BLANK:
				case MdLexer.LN_BREAK:
				case MdLexer.VWS:
				case Token.EOF:
					return true;
				default:
					return false;
			}
		}
		return false;
	}
}
