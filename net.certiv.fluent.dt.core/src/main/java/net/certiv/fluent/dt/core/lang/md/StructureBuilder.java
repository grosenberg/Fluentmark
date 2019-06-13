package net.certiv.fluent.dt.core.lang.md;

import java.util.ArrayDeque;
import java.util.Deque;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import net.certiv.antlr.runtime.xvisitor.Processor;
import net.certiv.dsl.core.model.ModuleStmt;
import net.certiv.dsl.core.model.Statement;
import net.certiv.dsl.core.model.builder.DslModelMaker;
import net.certiv.fluent.dt.core.lang.md.gen.MdParser.HeaderContext;
import net.certiv.fluent.dt.core.lang.md.gen.MdParser.ListContext;
import net.certiv.fluent.dt.core.lang.md.gen.MdParser.ListItemContext;
import net.certiv.fluent.dt.core.lang.md.gen.MdParser.PageContext;
import net.certiv.fluent.dt.core.lang.md.gen.MdParser.TableContext;
import net.certiv.fluent.dt.core.lang.md.gen.MdParser.TableRowContext;
import net.certiv.fluent.dt.core.model.ModelData;
import net.certiv.fluent.dt.core.model.ModelType;

public abstract class StructureBuilder extends Processor {

	private DslModelMaker maker;
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

		headers.push(new Header(module, 0)); // header 0 is the root
	}

	public void doHeader() {
		HeaderContext ctx = (HeaderContext) lastPathNode();
		ModelData data = new ModelData(ModelType.Header, ctx);

		int level = calc(ctx);
		Statement parent = getEnclosingParent(level);
		maker.toParent(parent);
		Statement stmt = maker.statement(ctx, ctx, data);
		maker.pushParent(stmt);
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

	public void doStatement(ModelType type) {
		ParseTree ctx = lastPathNode();
		ModelData data = new ModelData(type, ctx);
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
		Token mark = ctx.listMark().mark;
		ModelData data = new ModelData(ModelType.ListItem, ctx, mark.getText());
		maker.statement(ctx, mark, data);
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

	public void endBlock() {
		maker.popParent();
	}
}
