package net.certiv.fluent.dt.core.lang.md;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.core.model.builder.ModelBuilder;
import net.certiv.dsl.core.parser.DslParseRecord;
import net.certiv.dsl.core.parser.DslSourceParser;
import net.certiv.dsl.core.parser.Origin;
import net.certiv.fluent.dt.core.FluentCore;
import net.certiv.fluent.dt.core.lang.md.gen.MdLexer;
import net.certiv.fluent.dt.core.lang.md.gen.MdParser;
import net.certiv.fluent.dt.core.lang.md.gen.StructureVisitor;

public class MdSourceParser extends DslSourceParser {

	private static final MdTokenFactory TokenFactory = new MdTokenFactory();

	public MdSourceParser(DslParseRecord record) {
		super(record);
		TokenFactory.setTabWidth(record.tabWidth);
	}

	@Override
	public DslCore getDslCore() {
		return FluentCore.getDefault();
	}

	@Override
	public boolean doAnalysis() {
		return true;
	}

	@Override
	public Throwable parse() {
		try {
			record.setCharStream(CharStreams.fromString(getContent(), record.unit.getFile().getName()));
			MdLexer lexer = new MdLexer(record.getCharStream());
			lexer.setTokenFactory(TokenFactory);
			lexer.removeErrorListeners();
			lexer.addErrorListener(getErrorListener());
			record.setTokenStream(new CommonTokenStream(lexer));
			record.getTokenStream().fill(); // force stream update

			MdParser parser = new MdParser(record.getTokenStream());
			parser.setTokenFactory(TokenFactory);
			parser.removeErrorListeners();
			parser.addErrorListener(getErrorListener());
			record.setParser(parser);
			record.setTree(parser.page());

			return null;

		} catch (Exception | Error e) {
			getErrorListener().generalError(Origin.GENERAL, ERR_ANALYSIS, e);
			return e;
		}
	}

	@Override
	public Throwable analyze(ModelBuilder builder) {
		try {
			StructureVisitor visitor = new StructureVisitor(record.getTree());
			visitor.setBuilder(builder);
			visitor.setSourceName(record.unit.getPackageName());
			builder.beginAnalysis();
			visitor.findAll();
			builder.endAnalysis();
			return null;

		} catch (Exception | Error e) {
			getErrorListener().generalError(Origin.ANALYSIS, ERR_ANALYSIS, e);
			return e;
		}
	}
}
