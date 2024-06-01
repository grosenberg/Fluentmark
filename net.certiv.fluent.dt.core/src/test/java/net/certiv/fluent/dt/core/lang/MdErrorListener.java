package net.certiv.fluent.dt.core.lang;

import java.util.BitSet;
import java.util.LinkedList;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.LexerNoViableAltException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.Interval;

import net.certiv.common.log.Log;
import net.certiv.common.util.Strings;
import net.certiv.common.util.TxtUtil;
import net.certiv.dsl.core.util.antlr.GrammarUtil;
import net.certiv.fluent.dt.core.FluentCore;
import net.certiv.fluent.dt.core.lang.md.MdToken;

public class MdErrorListener extends BaseErrorListener {

	private final LinkedList<String> problems;
	private final boolean reportAmbiguities;

	public MdErrorListener(LinkedList<String> problems, boolean reportAmbiguities) {
		this.problems = problems;
		this.reportAmbiguities = reportAmbiguities;
	}

	@Override
	public void syntaxError(Recognizer<?, ?> recognizer, Object symbol, int line, int charPos, String msg,
			RecognitionException e) {

		Token token = symbol instanceof Token ? (Token) symbol : null;
		String problem = GrammarUtil.evalError(recognizer, token, line, charPos, msg, e);
		problem = refine(problem, recognizer, symbol, line, charPos, e);
		problems.add(problem);
	}

	@Override
	public void reportAmbiguity(Parser recognizer, DFA dfa, int start, int stop, boolean exact, BitSet ambigs,
			ATNConfigSet configs) {

		if (!reportAmbiguities) return;

		Token token = GrammarUtil.find(recognizer.getTokenStream(), start);
		if (token != null) {
			String problem = GrammarUtil.evalAmbiguity(recognizer, dfa, start, stop, exact, ambigs, configs);
			problems.add(problem);
		}
	}

	// symbol is string for lexers; token for parsers
	private String refine(String problem, Recognizer<?, ?> recognizer, Object symbol, int line, int charPos,
			RecognitionException e) {

		int at;
		CharStream cs;
		int tabWidth;

		if (e instanceof LexerNoViableAltException) {
			LexerNoViableAltException ex = (LexerNoViableAltException) e;
			at = ex.getStartIndex();
			cs = (CodePointCharStream) recognizer.getInputStream();
			tabWidth = FluentCore.getDefault().getPrefsManager().getTabWidth();

		} else {
			MdToken token = (MdToken) symbol;
			at = token.getStartIndex();
			cs = (CharStream) token.getInputStream();
			tabWidth = token.tabWidth();
		}

		return calcVisual(problem, cs, at, line + 1, charPos, tabWidth);
	}

	private String calcVisual(String problem, CharStream cs, int at, int line, int charPos, int tabWidth) {
		if (cs != null) {
			int beg = Math.max(at - charPos, 0); // line beg
			String txt = Strings.EMPTY;
			Interval range = Interval.of(beg, at);
			try {
				txt = cs.getText(range);
				int visPos = TxtUtil.measureVisualWidth(txt, tabWidth);
				return String.format(problem, line, visPos);

			} catch (Exception e) {
				Log.error("Bad visual position: [%s: %s] %s", range, txt, e.getMessage());
			}
		}
		return String.format(problem, line, charPos);
	}
}
