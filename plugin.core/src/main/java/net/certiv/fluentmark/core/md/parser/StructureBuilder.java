package net.certiv.fluentmark.core.md.parser;

import org.antlr.v4.runtime.tree.ParseTree;

import net.certiv.antlr.runtime.xvisitor.Processor;
import net.certiv.dsl.core.model.ModuleStmt;
import net.certiv.dsl.core.model.Statement;
import net.certiv.dsl.core.model.builder.DslModelMaker;
import net.certiv.fluentmark.core.md.parser.gen.MdParser.CodeBlockContext;
import net.certiv.fluentmark.core.md.parser.gen.MdParser.CommentContext;
import net.certiv.fluentmark.core.md.parser.gen.MdParser.DefinitionContext;
import net.certiv.fluentmark.core.md.parser.gen.MdParser.FrontMatterContext;
import net.certiv.fluentmark.core.md.parser.gen.MdParser.HeaderContext;
import net.certiv.fluentmark.core.md.parser.gen.MdParser.HruleContext;
import net.certiv.fluentmark.core.md.parser.gen.MdParser.HtmlContext;
import net.certiv.fluentmark.core.md.parser.gen.MdParser.ListContext;
import net.certiv.fluentmark.core.md.parser.gen.MdParser.ListItemContext;
import net.certiv.fluentmark.core.md.parser.gen.MdParser.MathBlockContext;
import net.certiv.fluentmark.core.md.parser.gen.MdParser.PageContext;
import net.certiv.fluentmark.core.md.parser.gen.MdParser.ParagraphContext;
import net.certiv.fluentmark.core.md.parser.gen.MdParser.QuoteContext;
import net.certiv.fluentmark.core.md.parser.gen.MdParser.TableContext;
import net.certiv.fluentmark.core.md.parser.gen.MdParser.TableRowContext;
import net.certiv.fluentmark.core.md.parser.gen.MdParser.TerminalContext;

public abstract class StructureBuilder extends Processor {

	private DslModelMaker maker;
	private String name = "<Undefined>"; // typically, the source file name

	public StructureBuilder(ParseTree tree) {
		super(tree);
	}

	public void setMaker(DslModelMaker maker) {
		this.maker = maker;
	}

	public void setSourceName(String name) {
		this.name = name;
	}

	/** Called on a GrammarSpecContext node. */
	public void doModule() {
		PageContext ctx = (PageContext) lastPathNode();
		ModelData data = new ModelData(ModelType.Page, ctx, name);
		ModuleStmt module = maker.module(ctx, name, data);
		maker.pushParent(module);
	}

	public void doFrontMatter() {
		FrontMatterContext ctx = (FrontMatterContext) lastPathNode();
		ModelData data = new ModelData(ModelType.FrontMatter, ctx);
		maker.statement(ctx, ctx, data);
	}

	public void doHeader() {
		HeaderContext ctx = (HeaderContext) lastPathNode();
		ModelData data = new ModelData(ModelType.Header, ctx);
		maker.statement(ctx, ctx, data);
	}

	public void doParagraph() {
		ParagraphContext ctx = (ParagraphContext) lastPathNode();
		ModelData data = new ModelData(ModelType.Paragraph, ctx);
		maker.statement(ctx, ctx, data);
	}

	public void doTerminal() {
		TerminalContext ctx = (TerminalContext) lastPathNode();
		ModelData data = new ModelData(ModelType.Terminal, ctx);
		maker.statement(ctx, ctx, data);
	}

	public void doHRule() {
		HruleContext ctx = (HruleContext) lastPathNode();
		ModelData data = new ModelData(ModelType.HRule, ctx);
		maker.statement(ctx, ctx, data);
	}

	public void doComment() {
		CommentContext ctx = (CommentContext) lastPathNode();
		ModelData data = new ModelData(ModelType.Comment, ctx);
		maker.statement(ctx, ctx, data);
	}

	public void doList() {
		ListContext ctx = (ListContext) lastPathNode();
		ModelData data = new ModelData(ModelType.List, ctx);
		Statement stmt = maker.statement(ctx, ctx, data);
		maker.pushParent(stmt);
	}

	public void doListItem() {
		ListItemContext ctx = (ListItemContext) lastPathNode();
		ModelData data = new ModelData(ModelType.ListItem, ctx, ctx.LIST_ITEM().getText());
		maker.statement(ctx, ctx.LIST_ITEM(), data);
	}

	public void doTable() {
		TableContext ctx = (TableContext) lastPathNode();
		ModelData data = new ModelData(ModelType.Table, ctx);
		Statement stmt = maker.statement(ctx, ctx, data);
		maker.pushParent(stmt);
	}

	public void doTableRow() {
		TableRowContext ctx = (TableRowContext) lastPathNode();
		ModelData data = new ModelData(ModelType.TableRow, ctx);
		maker.statement(ctx, ctx, data);
	}

	public void doQuote() {
		QuoteContext ctx = (QuoteContext) lastPathNode();
		ModelData data = new ModelData(ModelType.Quote, ctx);
		maker.statement(ctx, ctx, data);
	}

	public void doDefinition() {
		DefinitionContext ctx = (DefinitionContext) lastPathNode();
		ModelData data = new ModelData(ModelType.Definition, ctx);
		maker.statement(ctx, ctx, data);
	}

	public void doHtmlBlock() {
		HtmlContext ctx = (HtmlContext) lastPathNode();
		ModelData data = new ModelData(ModelType.HtmlBlock, ctx);
		maker.statement(ctx, ctx, data);
	}

	public void doMathBlock() {
		MathBlockContext ctx = (MathBlockContext) lastPathNode();
		ModelData data = new ModelData(ModelType.MathBlock, ctx);
		maker.statement(ctx, ctx, data);
	}

	public void doCodeBlock() {
		CodeBlockContext ctx = (CodeBlockContext) lastPathNode();
		ModelData data = new ModelData(ModelType.FrontMatter, ctx);
		maker.statement(ctx, ctx, data);
	}

	public void endBlock() {
		maker.popParent();
	}
}
