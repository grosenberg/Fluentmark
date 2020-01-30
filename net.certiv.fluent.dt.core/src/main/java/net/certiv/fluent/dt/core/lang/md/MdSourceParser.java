package net.certiv.fluent.dt.core.lang.md;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.core.model.builder.ModelBuilder;
import net.certiv.dsl.core.parser.DslParseRecord;
import net.certiv.dsl.core.parser.DslSourceParser;
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
			record.cs = CharStreams.fromString(getContent(), record.unit.getFile().getName());
			Lexer lexer = new MdLexer(record.cs);
			lexer.setTokenFactory(TokenFactory);
			lexer.removeErrorListeners();
			lexer.addErrorListener(getDslErrorListener());
			record.ts = new CommonTokenStream(lexer);

			record.parser = new MdParser(record.ts);
			record.parser.setTokenFactory(TokenFactory);
			record.parser.removeErrorListeners();
			record.parser.addErrorListener(getDslErrorListener());
			record.tree = ((MdParser) record.parser).page();
			return null;

		} catch (Exception | Error e) {
			getDslErrorListener().generalError(ERR_ANALYSIS, e);
			return e;
		}
	}

	@Override
	public Throwable analyze(ModelBuilder builder) {
		try {
			StructureVisitor visitor = new StructureVisitor(record.tree);
			visitor.setBuilder(builder);
			visitor.setSourceName(record.unit.getElementName());
			builder.beginAnalysis();
			visitor.findAll();
			builder.endAnalysis();
			return null;

		} catch (Exception | Error e) {
			getDslErrorListener().generalError(ERR_ANALYSIS, e);
			return e;
		}
	}
}
