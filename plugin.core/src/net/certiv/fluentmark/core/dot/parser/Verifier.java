package net.certiv.fluentmark.core.dot.parser;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.eclipse.core.resources.IMarker;

import net.certiv.dsl.core.parser.DslProblem;
import net.certiv.dsl.core.parser.DslProblemCollector;
import net.certiv.dsl.core.util.Log;
import net.certiv.fluentmark.core.dot.parser.AttrMap.Props;
import net.certiv.fluentmark.core.dot.parser.gen.DotLexer;
import net.certiv.fluentmark.core.dot.parser.gen.DotParser.AttrListContext;
import net.certiv.fluentmark.core.dot.parser.gen.DotParser.AttributeContext;
import net.certiv.fluentmark.core.dot.parser.gen.DotParserBaseListener;

public class Verifier {

	public static final Verifier INST = new Verifier();
	private static final ContextVisitor visitor = INST.new ContextVisitor();

	private DotSourceParser srcParser;
	private DslProblemCollector collector;

	private enum Kind {
		SEMANTIC,
		ATTRIBUTE;
	}

	/**
	 * Verifies the semantic and attribute value correctness of the DOT spec described by the given
	 * srcParser. Issues are reported to the given collector.
	 */
	public void check(DotSourceParser srcParser, DslProblemCollector collector) {
		this.srcParser = srcParser;
		this.collector = collector;
		ParseTreeWalker.DEFAULT.walk(visitor, srcParser.getTree());
	}

	private void reportProblem(int severity, Kind kind, Token token, String cause) {
		DslProblem problem = srcParser.createProblem(severity, cause, token);
		Log.error(this, problem.toString());
		collector.accept(problem);
	}

	private class ContextVisitor extends DotParserBaseListener {

		@Override
		public void enterAttrList(AttrListContext ctx) {
			for (AttributeContext attribute : ctx.attribute()) {
				String id = attribute.id().getText();
				Props props = AttrMap.get(id);
				if (props.name.equals(Attr.INVALID)) {
					String cause = "Invalid name '" + id + "' at %s:%s";
					reportProblem(IMarker.SEVERITY_ERROR, Kind.ATTRIBUTE, attribute.id().name, cause);
					continue;
				}

				Token token = attribute.value().getStart();
				String value = attribute.value().getText();
				String cause = null;
				switch (props.type) {
					case LIST:
						if (!AttrMap.in(props.values, value)) {
							cause = "Invalid value '" + value + "' at %s:%s";
						}
						break;

					case COLOR:
						boolean rgb = token.getType() == DotLexer.RGB;
						boolean hsv = token.getType() == DotLexer.HSV;
						String color = DotColors.get("x11", value); // TODO: handle colorScheme
						if (!rgb && !hsv && color == null) {
							cause = "Color [name|RGB|RGBA|HSV] value required as '" + value + "' at %s:%s";
						}
						break;

					case COLORS:
						rgb = token.getType() == DotLexer.RGB;
						hsv = token.getType() == DotLexer.HSV;
						color = DotColors.get("x11", value);
						if (!rgb && !hsv && color == null && attribute.value().COLORS() == null) {
							cause = "Color or Color list required as '" + value + "' at %s:%s";
						}
						break;

					case NUMBER:
						if (attribute.value().NUMBER() == null) {
							cause = "Numeric value required as '" + value + "' at %s:%s";
						}
						break;

					case POINT:
						if (attribute.value().POINT() == null) {
							cause = "Point required as '" + value + "' at %s:%s";
						}
						break;

					case RECT:
						if (attribute.value().RECT() == null) {
							cause = "Rectangle required as '" + value + "' at %s:%s";
						}
						break;

					case SPLINE:
						if (attribute.value().SPLINE() == null || attribute.value().POINT() == null) {
							cause = "Spline or Point required as '" + value + "' at %s:%s";
						}
						break;

					case STRING:
						if (token.getType() != DotLexer.STRING && token.getType() != DotLexer.HTML) {
							cause = "String or Html value required as '" + value + "' at %s:%s";
						}
						break;

					default:
						break;
				}
				if (cause != null) reportProblem(IMarker.SEVERITY_ERROR, Kind.ATTRIBUTE, token, cause);
			}
		}
	}
}
