package net.certiv.fluentmark.dot;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.FailedPredicateException;
import org.antlr.v4.runtime.InputMismatchException;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.LexerNoViableAltException;
import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.misc.IntervalSet;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.IStatus;

import net.certiv.fluentmark.FluentUI;
import net.certiv.fluentmark.editor.assist.DotProblem;
import net.certiv.fluentmark.editor.text.DotReconcilingStrategy.DotProblemCollector;
import net.certiv.fluentmark.util.Reflect;
import net.certiv.fluentmark.util.Strings;

public class DotErrorListener extends BaseErrorListener {

	private Record record;
	private DotProblemCollector collector;

	public void setup(Record record, DotProblemCollector collector) {
		this.record = record;
		this.collector = collector;
	}

	@Override
	public void syntaxError(Recognizer<?, ?> recognizer, Object symbol, int line, int charPos, String msg,
			RecognitionException e) {

		String cause = evalError(recognizer, symbol, line, charPos, e);
		DotProblem problem = new DotProblem(IMarker.SEVERITY_ERROR, cause, e.getOffendingToken(), record);
		FluentUI.log(IStatus.ERROR, problem.toString());
		collector.accept(problem);
	}

	private static String evalError(Recognizer<?, ?> recognizer, Object symbol, int line, int charPos,
			RecognitionException e) {

		Token token = symbol instanceof Token ? (Token) symbol : null;
		String expected = getExpected(e);

		String cause;
		if (e instanceof InputMismatchException) {
			cause = "Mismatched input " + getTokentext(token) + " at %s:%s" + expected;

		} else if (e instanceof NoViableAltException) {
			String input = "<unknown>";
			TokenStream ts = ((Parser) recognizer).getInputStream();
			if (ts != null) {
				NoViableAltException ne = (NoViableAltException) e;
				if (ne.getStartToken().getType() == Token.EOF) {
					input = "<EOF>";
				} else {
					input = ts.getText(ne.getStartToken(), ne.getOffendingToken());
					input = Strings.encode(input);
				}
			}
			cause = "No viable alternative for input '" + input + "' at %s:%s" + getTokentext(token);

		} else if (e instanceof LexerNoViableAltException) {
			LexerNoViableAltException le = (LexerNoViableAltException) e;
			int start = le.getStartIndex();
			String txt = "<?>";
			if (start >= 0 && start < le.getInputStream().size()) {
				txt = le.getInputStream().getText(Interval.of(start, start));
				txt = Strings.encode(txt);
			}
			cause = "Lexer: no viable alternative for input '" + txt + "' at %s:%s";
			fudgit(le, start);

		} else if (e instanceof FailedPredicateException) {
			FailedPredicateException fe = (FailedPredicateException) e;
			cause = String.format("Failed predicate '{%s}?'", fe.getPredicate());
			cause += " at %s:%s " + getTokentext(token);

		} else if (e instanceof UnwantedTokenException) {
			cause = "Extraneous input " + getTokentext(token) + " at %s:%s" + expected;

		} else if (e instanceof MissingTokenException) {
			cause = "Missing input " + expected + " at %s:%s " + getTokentext(token);

		} else {
			cause = String.format("Unknown recognition error of type '%s'", e.getClass().getSimpleName()) + " at %s:%s"
					+ expected;
		}
		return cause;
	}

	private static void fudgit(LexerNoViableAltException le, int start) {
		String text = le.getInputStream().getText(Interval.of(0, start));
		CommonToken ctoken = new CommonToken(Token.INVALID_TYPE, text);
		ctoken.setStartIndex(start);
		ctoken.setStopIndex(start);
		ctoken.setLine(Strings.countLines(text));
		ctoken.setCharPositionInLine(Strings.lastLineLen(text));
		Reflect.set(le, "offendingToken", ctoken);
	}

	private static String getTokentext(Token token) {
		return String.format("'%s' <%s>", token.getText(), getTypename(token));
	}

	private static String getTypename(Token token) {
		if (token == null) return "INVALID_TYPE";

		Lexer lexer = (Lexer) token.getTokenSource();
		return lexer.getVocabulary().getDisplayName(token.getType());
	}

	// Returns a description of the expected tokens at the error site.
	private static String getExpected(RecognitionException e) {
		if (e == null) return "";
		IntervalSet expected = e.getExpectedTokens();
		if (expected == null || expected.isNil()) return "";

		StringBuilder sb = new StringBuilder("; expected {");
		Vocabulary vocab = e.getRecognizer().getVocabulary();
		for (int ttype : expected.toList()) {
			String typename = vocab.getDisplayName(ttype);
			sb.append(String.format("'%s', ", typename));
		}
		if (sb.length() > 2) sb.setLength(sb.length() - 2);
		sb.append("}");
		return sb.toString();
	}
}
