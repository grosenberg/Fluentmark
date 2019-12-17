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

	/** Builds a ParseTree for the given content */
	@Override
	public void parse() {
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
	}

	/**
	 * Build the internal model used as the structural basis for the outline view,
	 * etc.
	 */
	@Override
	public void analyzeStructure(ModelBuilder maker) {
		try {
			StructureVisitor visitor = new StructureVisitor(record.tree);
			visitor.setMaker(maker);
			visitor.setSourceName(record.unit.getElementName());
			visitor.findAll();

		} catch (IllegalArgumentException e) {
			getDslErrorListener().generalError("Model analysis: %s @%s:%s", e);
		}
	}

	@Override
	public boolean modelContributor() {
		return true;
	}
}
