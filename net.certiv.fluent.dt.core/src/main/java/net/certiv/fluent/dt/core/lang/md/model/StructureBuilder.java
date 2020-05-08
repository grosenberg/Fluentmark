package net.certiv.fluent.dt.core.lang.md.model;

import java.util.HashMap;
import java.util.LinkedList;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import net.certiv.antlr.runtime.xvisitor.Processor;
import net.certiv.dsl.core.model.ModelType;
import net.certiv.dsl.core.model.ModuleStmt;
import net.certiv.dsl.core.model.Statement;
import net.certiv.dsl.core.model.builder.ModelBuilder;
import net.certiv.fluent.dt.core.lang.md.MdToken;
import net.certiv.fluent.dt.core.lang.md.gen.MdLexer;
import net.certiv.fluent.dt.core.lang.md.gen.MdParser;
import net.certiv.fluent.dt.core.lang.md.gen.MdParser.AttrLeftContext;
import net.certiv.fluent.dt.core.lang.md.gen.MdParser.AttrRightContext;
import net.certiv.fluent.dt.core.lang.md.gen.MdParser.CodeBlockContext;
import net.certiv.fluent.dt.core.lang.md.gen.MdParser.HeaderContext;
import net.certiv.fluent.dt.core.lang.md.gen.MdParser.ListContext;
import net.certiv.fluent.dt.core.lang.md.gen.MdParser.ListItemContext;
import net.certiv.fluent.dt.core.lang.md.gen.MdParser.PageContext;
import net.certiv.fluent.dt.core.lang.md.gen.MdParser.WordContext;
import net.certiv.fluent.dt.core.model.SpecUtil;

public abstract class StructureBuilder extends Processor {

	class Mark {

		ParserRuleContext ctx;
		MdToken begToken;

		int beg;
		int type;
		SpecializationType specType;
		Specialization data;

		Mark(ParserRuleContext ctx, MdToken begToken) {
			this.ctx = ctx;
			this.begToken = begToken;

			beg = begToken.getStartIndex();
			type = begToken.getType();
			specType = toSpecType(begToken);
			data = new Specialization(specType, rulename(ctx), ctx, specType.name);
		}
	}

	private final LinkedList<Header> headers = new LinkedList<>();
	/** key=token type; value=attributes of left context */
	private final HashMap<Integer, Mark> attributes = new HashMap<>();

	private ModelBuilder builder;
	private String name = ModelBuilder.UNKNOWN;
	private boolean startList = false;
	private int listDents = -1;

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

	public void setBuilder(ModelBuilder builder) {
		this.builder = builder;
	}

	public void setSourceName(String name) {
		this.name = name;
	}

	/** Called on a PageContext node. */
	public void doModule() {
		PageContext ctx = (PageContext) lastPathNode();
		Specialization data = new Specialization(SpecializationType.Page, rulename(ctx), ctx, name);
		ModuleStmt module = builder.module(ctx, name, data);
		headers.push(new Header(module, 0)); // header 0 is the root
	}

	public void doHeader() {
		HeaderContext ctx = (HeaderContext) lastPathNode();
		Specialization data = new Specialization(SpecializationType.Header, rulename(ctx), ctx, name);

		int level = calc(ctx);
		data.setHeaderLevel(level);

		Statement parent = getEnclosingParent(level);
		builder.toParent(parent);
		Statement stmt = builder.statement(ModelType.SPAN, ctx, ctx, data);
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
	 * # first
	 * 	 ## second
	 *     ### third
	 *       #### fourth
	 *   ## second
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

	public void doStatement(SpecializationType type) {
		ParserRuleContext ctx = (ParserRuleContext) lastPathNode();
		Specialization data = new Specialization(type, rulename(ctx), ctx, name);
		Statement stmt = builder.statement(ModelType.TYPE, ctx, ctx, data);
		builder.pushParent(stmt);
	}

	public void doType(SpecializationType type) {
		ParserRuleContext ctx = (ParserRuleContext) lastPathNode();
		if (type == SpecializationType.CodeBlock) {
			Token lang = ((CodeBlockContext) ctx).lang;
			if (lang != null) {
				if (SpecUtil.DOT.equalsIgnoreCase(lang.getText())) {
					type = SpecializationType.DotBlock;
				} else if (SpecUtil.UML.equalsIgnoreCase(lang.getText())) {
					type = SpecializationType.UmlBlock;
				}
			}
		}
		Specialization data = new Specialization(type, rulename(ctx), ctx, name);
		builder.statement(ModelType.TYPE, ctx, ctx, data);
	}

	public void doWord() {
		WordContext ctx = (WordContext) lastPathNode();
		SpecializationType specializationType;
		switch (ctx.w.getType()) {
			case MdLexer.CODE_SPAN:
				specializationType = SpecializationType.CodeSpan;
				break;
			case MdLexer.MATH_SPAN:
				specializationType = SpecializationType.MathSpan;
				break;

			case MdLexer.WORD:
			case MdLexer.RPAREN:
			case MdLexer.UNICODE:
			case MdLexer.ENTITY:
			case MdLexer.HTML:
			case MdLexer.TEX:
			case MdLexer.URL:
			default:
				return;
		}

		Specialization data = new Specialization(specializationType, rulename(ctx), ctx, name);
		builder.field(ctx, ctx, ModelType.LITERAL, data);
	}

	public void doAttrL() {
		AttrLeftContext ctx = (AttrLeftContext) lastPathNode();
		for (ParseTree child : ctx.children) {
			TerminalNode node = (TerminalNode) child;
			MdToken begAttr = (MdToken) node.getSymbol();
			attributes.put(begAttr.getType(), new Mark(ctx, begAttr));
		}
	}

	public void doAttrR() {
		AttrRightContext ctx = (AttrRightContext) lastPathNode();
		for (ParseTree child : ctx.children) {
			TerminalNode node = (TerminalNode) child;
			MdToken endAttr = (MdToken) node.getSymbol();
			Mark mark = attributes.get(leftEquiv(endAttr.getType()));
			if (mark != null) {
				builder.field(mark.ctx, mark.begToken, endAttr, mark.data.name, ModelType.SPAN, mark.data);
				attributes.remove(mark.type);
			}
		}
	}

	// --------------------------------------------------

	private int leftEquiv(int type) {
		switch (type) {
			case MdLexer.RBOLD:
				return MdLexer.LBOLD;
			case MdLexer.RITALIC:
				return MdLexer.LITALIC;
			case MdLexer.RSTRIKE:
				return MdLexer.LSTRIKE;
			case MdLexer.RDQUOTE:
				return MdLexer.LDQUOTE;
			case MdLexer.RSQUOTE:
				return MdLexer.LSQUOTE;
			case MdLexer.RDSPAN:
				return MdLexer.LDSPAN;
			case MdLexer.RSPAN:
				return MdLexer.LSPAN;

			default:
				return Token.INVALID_TYPE;
		}
	}

	private SpecializationType toSpecType(MdToken token) {
		switch (token.getType()) {
			case MdLexer.LBOLD:
			case MdLexer.RBOLD:
				return SpecializationType.Bold;

			case MdLexer.LITALIC:
			case MdLexer.RITALIC:
				return SpecializationType.Italic;

			case MdLexer.LSTRIKE:
			case MdLexer.RSTRIKE:
				return SpecializationType.Strike;

			case MdLexer.LSPAN:
			case MdLexer.RSPAN:
				return SpecializationType.Span;

			case MdLexer.LDSPAN:
			case MdLexer.RDSPAN:
				return SpecializationType.Span;

			case MdLexer.LDQUOTE:
			case MdLexer.RDQUOTE:
				return SpecializationType.Quote;

			case MdLexer.LSQUOTE:
			case MdLexer.RSQUOTE:
				return SpecializationType.Quote;

			default:
				return SpecializationType.Unknown;
		}
	}

	public void doList() {
		ListContext ctx = (ListContext) lastPathNode();
		MdToken mark = (MdToken) ((ListItemContext) ctx.getChild(0)).listMark().mark;
		SpecializationType type = mark.getType() == MdLexer.UNORDERED_MARK ? SpecializationType.ListUnordered
				: SpecializationType.ListOrdered;

		Specialization data = new Specialization(type, rulename(ctx), ctx, type.name);
		data.setListType(type);
		data.setDents(mark.getDents());
		data.begList();

		startList = true;

		Statement stmt = builder.statement(ModelType.TYPE, ctx, ctx, data);
		builder.pushParent(stmt);
	}

	public void doListItem() {
		ListItemContext ctx = (ListItemContext) lastPathNode();
		MdToken mark = (MdToken) ctx.listMark().mark;
		Specialization data = new Specialization(SpecializationType.ListItem, rulename(ctx), ctx, mark.getText());
		int dents = mark.getDents();
		data.setDents(dents);

		SpecializationType lt = SpecializationType.ListUnordered;
		Statement parent = builder.peekParent();
		if (parent.hasData()) {
			lt = ((Specialization) parent.getData()).listType;
		}
		data.setListType(lt);

		if (startList) {
			listDents = dents;
			startList = false;
		} else {
			if (listDents < dents) data.begList();
			if (listDents > dents) data.endList();
			listDents = dents;
		}

		builder.statement(ModelType.TYPE, ctx, mark, data);
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
		// if (lastPathNode() instanceof ParagraphContext) {
		// for (Span span : spans.values()) {
		// span.createField(builder);
		// }
		// spans.clear();
		// stacks.clear();
		// }
		builder.popParent();
	}

	private String rulename(ParserRuleContext ctx) {
		return MdParser.ruleNames[ctx.getRuleIndex()];
	}
}
