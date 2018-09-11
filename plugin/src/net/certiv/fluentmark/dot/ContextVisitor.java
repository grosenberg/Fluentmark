package net.certiv.fluentmark.dot;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import net.certiv.fluentmark.dot.gen.DotParserBaseListener;

public class ContextVisitor {

	public static final ContextVisitor INST = new ContextVisitor();
	private static final NodeVisitor visitor = INST.new NodeVisitor();

	/**
	 * Returns the context node that most narrowly contains the given offset.
	 *
	 * @param record the parser record to search
	 * @param offset the target offset
	 * @return the narrowest containing node
	 */
	public ParserRuleContext getNode(Record record, int offset) {
		visitor.offset = offset;
		ParseTreeWalker.DEFAULT.walk(visitor, record.tree);
		return visitor.last;
	}

	private class NodeVisitor extends DotParserBaseListener {

		int offset;
		ParserRuleContext last;
		int start;
		int stop;

		@Override
		public void enterEveryRule(ParserRuleContext ctx) {
			if (last == null) {
				last = ctx;
				start = last.start.getStartIndex();
				stop = last.stop.getStopIndex();

			} else {
				int beg = ctx.start.getStartIndex();
				int end = ctx.stop.getStopIndex();
				if (beg <= offset && end >= offset) {
					if (beg >= start && end <= stop) {
						start = beg;
						stop = end;
						last = ctx;
					}
				}
			}
		}
	}
}
