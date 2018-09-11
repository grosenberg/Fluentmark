package net.certiv.fluentmark.dot;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.eclipse.core.runtime.IStatus;

import net.certiv.fluentmark.FluentUI;
import net.certiv.fluentmark.dot.gen.DotParserBaseListener;
import net.certiv.fluentmark.editor.assist.DotProblem;
import net.certiv.fluentmark.editor.text.DotReconcilingStrategy.DotProblemCollector;

public class VerifyVisitor {

	public static final VerifyVisitor INST = new VerifyVisitor();
	private static final ContextVisitor visitor = INST.new ContextVisitor();

	private Record record;
	private DotProblemCollector collector;

	/**
	 * Verifies the semantic and attribute value correctness of the DOT spec described by the given
	 * record. Issues are reported to the given collector.
	 */
	public void check(Record record, DotProblemCollector collector) {
		this.record = record;
		this.collector = collector;
		ParseTreeWalker.DEFAULT.walk(visitor, record.tree);
	}

	private void report(int severity, Kind kind, Token token, int line, int charPos, String msg) {
		String cause = eval(severity, kind, token, line, charPos, msg);
		DotProblem problem = new DotProblem(severity, cause, token, record.res, record.docOffset, record.docLine);
		FluentUI.log(IStatus.INFO, problem.toString());
		collector.accept(problem);
	}

	private String eval(int severity, Kind kind, Token token, int line, int charPos, String msg) {
		return null;
	}

	private class ContextVisitor extends DotParserBaseListener {

	}

	private enum Kind {
		SEMANTIC,
		ATTRIBUTE;
	}
}
