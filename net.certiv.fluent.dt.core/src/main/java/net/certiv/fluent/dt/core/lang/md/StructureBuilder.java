package net.certiv.fluent.dt.core.lang.md;

import java.util.ArrayDeque;
import java.util.Deque;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import net.certiv.antlr.runtime.xvisitor.Processor;
import net.certiv.dsl.core.model.Block;
import net.certiv.dsl.core.model.IStatement.BaseType;
import net.certiv.dsl.core.model.ModuleStmt;
import net.certiv.dsl.core.model.Statement;
import net.certiv.dsl.core.model.builder.ModelBuilder;
import net.certiv.fluent.dt.core.lang.md.gen.MdLexer;
import net.certiv.fluent.dt.core.lang.md.gen.MdParser;
import net.certiv.fluent.dt.core.lang.md.gen.MdParser.HeaderContext;
import net.certiv.fluent.dt.core.lang.md.gen.MdParser.ListContext;
import net.certiv.fluent.dt.core.lang.md.gen.MdParser.ListItemContext;
import net.certiv.fluent.dt.core.lang.md.gen.MdParser.PageContext;
import net.certiv.fluent.dt.core.model.SpecData;
import net.certiv.fluent.dt.core.model.SpecType;

public abstract class StructureBuilder extends Processor {

	private ModelBuilder builder;
	private String name = "<Undefined>"; // typically, the source file name
	private Deque<Header> headers = new ArrayDeque<>();

	class Header {

		Statement stmt;
		int level;

		public Header(Statement stmt, int level) {
			this.stmt = stmt;
			this.level = level;
		}

		@Override
		public String toString() {
			return "Header: " + level;
		}
	}

	public StructureBuilder(ParseTree tree) {
		super(tree);
	}

	public void setMaker(ModelBuilder builder) {
		this.builder = builder;
	}

	public void setSourceName(String name) {
		this.name = name;
	}

	/** Called on a PageContext node. */
	public void doModule() {
		PageContext ctx = (PageContext) lastPathNode();
		SpecData data = new SpecData(BaseType.UNIT, SpecType.Page, rulename(ctx), ctx, name);
		ModuleStmt module = builder.module(ctx, name, data);
		builder.pushParent(module);

		headers.push(new Header(module, 0)); // header 0 is the root
	}

	public void doHeader() {
		HeaderContext ctx = (HeaderContext) lastPathNode();
		SpecData data = new SpecData(BaseType.TYPE, SpecType.Header, rulename(ctx), ctx, name);

		int level = calc(ctx);
		data.setHeaderLevel(level);

		Statement parent = getEnclosingParent(level);
		builder.toParent(parent);
		Statement stmt = builder.statement(ctx, ctx, data);
		builder.pushParent(stmt);
		headers.push(new Header(stmt, level));
	}

	private int calc(HeaderContext ctx) {
		if (ctx.HASHES() != null) return ctx.HASHES().getText().length();
		if (ctx.EQUALS() != null) return 1;
		return 2;
	}

	/**
	 * <pre>
	 * 	# first
	 * 		## second
	 *   		### third
	 *   			#### forth
	 *   	## second
	 * </pre>
	 */
	private Statement getEnclosingParent(int level) {
		if (level < 1) level = 1;
		if (level > 6) level = 6;
		while (headers.peek().level >= level) {
			headers.pop();
		}
		return headers.peek().stmt;
	}

	public void doStatement(SpecType type) {
		ParserRuleContext ctx = (ParserRuleContext) lastPathNode();
		SpecData data = new SpecData(BaseType.TYPE, type, rulename(ctx), ctx, name);
		builder.statement(ctx, ctx, data);
	}

	private boolean startList = false;
	private int listDents = -1;

	public void doList() {
		ListContext ctx = (ListContext) lastPathNode();
		MdToken mark = (MdToken) ((ListItemContext) ctx.getChild(0)).listMark().mark;
		SpecType type = mark.getType() == MdLexer.UNORDERED_MARK ? SpecType.ListUnordered : SpecType.ListOrdered;

		SpecData data = new SpecData(BaseType.TYPE, type, rulename(ctx), ctx, type.name);
		data.setListType(type);
		data.setDents(mark.getDents());
		data.begList();

		startList = true;

		Statement stmt = builder.statement(ctx, ctx, data);
		builder.pushParent(stmt);
	}

	public void doListItem() {
		ListItemContext ctx = (ListItemContext) lastPathNode();
		MdToken mark = (MdToken) ctx.listMark().mark;
		SpecData data = new SpecData(BaseType.TYPE, SpecType.ListItem, rulename(ctx), ctx, mark.getText());
		int dents = mark.getDents();
		data.setDents(dents);

		SpecType type = mark.getType() == MdLexer.UNORDERED_MARK ? SpecType.ListUnordered : SpecType.ListOrdered;
		data.setListType(type);

		if (startList) {
			listDents = dents;
			startList = false;
		} else {
			if (listDents < dents) data.begList();
			if (listDents > dents) data.endList();
			listDents = dents;
		}

		builder.statement(ctx, mark, data);
	}

	// public void doTable() {
	// TableContext ctx = (TableContext) lastPathNode();
	// ModelData data = new ModelData(ModelType.Table, ctx);
	// Statement stmt = builder.statement(ctx, ctx, data);
	// builder.pushParent(stmt);
	// }
	//
	// public void doTableRow() {
	// TableRowContext ctx = (TableRowContext) lastPathNode();
	// ModelData data = new ModelData(ModelType.TableRow, ctx);
	// builder.statement(ctx, ctx, data);
	// }

	public void endBlock() {
		builder.popParent();
	}

	@SuppressWarnings("unused")
	private void addField(BaseType baseType, SpecType specType, String rulename, ParseTree ctx) {
		if (ctx != null) {
			builder.field(ctx, ctx, baseType, new SpecData(baseType, specType, rulename, ctx, ctx.getText()));
		}
	}

	@SuppressWarnings("unused")
	private void addBlock(int blockType, TerminalNode beg, TerminalNode end) {
		Block block = builder.block(blockType, beg, end, null);
		if (block != null) builder.pushParent(block);
	}

	private String rulename(ParserRuleContext ctx) {
		return MdParser.ruleNames[ctx.getRuleIndex()];
	}
}
