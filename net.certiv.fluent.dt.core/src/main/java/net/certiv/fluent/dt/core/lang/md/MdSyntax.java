package net.certiv.fluent.dt.core.lang.md;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

import net.certiv.dsl.core.util.stores.HashList;
import net.certiv.fluent.dt.core.lang.md.gen.MdLexer;

public class MdSyntax {

	private final CommonTokenStream ts;

	// key = line num; value = tokens
	private final HashList<Integer, Token> lines = new HashList<>();

	// key = token type; value = token line
	private final HashList<Integer, Integer> index = new HashList<>();

	private final Set<Integer> listSet = new HashSet<>(Arrays.asList(MdLexer.UNORDERED_MARK, MdLexer.NUMBER_MARK,
			MdLexer.PAREN_MARK, MdLexer.UALPHA_MARK, MdLexer.LALPHA_MARK));

	public MdSyntax(CommonTokenStream ts) {
		this.ts = ts;
	}

	public void process() {
		ts.fill();
		for (Token token : ts.getTokens()) {
			int type = token.getType();
			if (token.getChannel() == Token.DEFAULT_CHANNEL && type != Token.EOF) {
				index.put(type, token.getLine());
				lines.put(token.getLine(), token);
			}
		}

		Set<Integer> listLines = new HashSet<>();
		for (Integer s : listSet) {
			listLines.addAll(index.get(s));
		}
		for (Integer line : lines.keySet()) {
			if (!contiguous(line, listSet)) {
				List<Token> tokens = lines.get(line);
				for (Token token : tokens) {
					if (listSet.contains(token.getType())) {
						((MdToken) token).setType(MdLexer.WORD);
						break;
					}
				}
			}
		}
	}

	protected boolean contiguous(int line, Set<Integer> types) {
		for (Integer type : types) {
			List<Integer> lines = index.get(type);
			if (lines.contains(line - 1) || lines.contains(line + 1)) return true;
		}
		return false;
	}
}
