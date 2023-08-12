package net.certiv.fluent.dt.core.lang.md.model;

import static net.certiv.fluent.dt.core.lang.md.model.SpecializedType.*;

import java.util.LinkedList;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import net.certiv.antlr.runtime.xvisitor.Processor;
import net.certiv.dsl.core.model.ModelType;
import net.certiv.dsl.core.model.ModuleStmt;
import net.certiv.dsl.core.model.Statement;
import net.certiv.dsl.core.model.builder.ModelBuilder;
import net.certiv.fluent.dt.core.lang.md.MdToken;
import net.certiv.fluent.dt.core.lang.md.gen.MdLexer;
import net.certiv.fluent.dt.core.lang.md.gen.MdParser;
import net.certiv.fluent.dt.core.lang.md.gen.MdParser.CodeBlockContext;
import net.certiv.fluent.dt.core.lang.md.gen.MdParser.HeaderContext;
import net.certiv.fluent.dt.core.lang.md.gen.MdParser.ListContext;
import net.certiv.fluent.dt.core.lang.md.gen.MdParser.ListItemContext;
import net.certiv.fluent.dt.core.lang.md.gen.MdParser.PageContext;
import net.certiv.fluent.dt.core.model.SpecUtil;

public abstract class StructureBuilder extends Processor {

	// class Mark {
	//
	// ParserRuleContext ctx;
	// MdToken begToken;
	//
	// int beg;
	// int type;
	// SpecializedType specType;
	// Specialization data;
	//
	// Mark(ParserRuleContext ctx, MdToken begToken) {
	// this.ctx = ctx;
	// this.begToken = begToken;
	//
	// beg = begToken.getStartIndex();
	// type = begToken.getType();
	// specType = toSpecType(begToken);
	// data = new Specialization(specType, rulename(ctx), ctx, specType.name);
	// }
	// }

	class Level {

		Statement stmt;
		int level;

		public Level(Statement stmt, int level) {
			this.stmt = stmt;
			this.level = level;
		}

		@Override
		public String toString() {
			return "Level: " + level;
		}
	}

	/** key=token type; value=attributes of left context */
	// private final HashMap<Integer, Mark> attributes = new HashMap<>();
	private final LinkedList<Level> hdrLevels = new LinkedList<>();
	private final LinkedList<Level> lstLevels = new LinkedList<>();

	private ModelBuilder builder;
	private String name = ModelBuilder.UNKNOWN;

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
		Specialization data = new Specialization(Page, rulename(ctx), ctx, name);
		ModuleStmt module = builder.module(ctx, name, data);
		hdrLevels.push(new Level(module, 0)); // header 0 is the root
	}

	public void doHeader() {
		HeaderContext ctx = (HeaderContext) lastPathNode();
		Specialization data = new Specialization(Header, rulename(ctx), ctx, name);

		int level = calc(ctx);
		data.setHeaderLevel(level);

		Statement parent = getEnclosingHdrParent(level);
		builder.toParent(parent);
		Statement stmt = builder.statement(ModelType.SPAN, ctx, ctx, data);
		builder.pushParent(stmt);
		hdrLevels.push(new Level(stmt, level));
	}

	private int calc(HeaderContext ctx) {
		if (ctx.hdr != null) return ctx.hdr.getText().length();
		if (ctx.SETEXT() != null) return 1;
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
	private Statement getEnclosingHdrParent(int level) {
		if (level < 1) level = 1;
		if (level > 6) level = 6;
		while (hdrLevels.peek().level >= level) {
			hdrLevels.pop();
		}
		return hdrLevels.peek().stmt;
	}

	public void doStatement(SpecializedType type) {
		ParserRuleContext ctx = (ParserRuleContext) lastPathNode();
		Specialization data = new Specialization(type, rulename(ctx), ctx, name);
		Statement stmt = builder.statement(ModelType.TYPE, ctx, ctx, data);
		builder.pushParent(stmt);
	}

	public void doType(SpecializedType type) {
		ParserRuleContext ctx = (ParserRuleContext) lastPathNode();
		switch (type) {
			case CodeBlock:
				Token lang = ((CodeBlockContext) ctx).lang;
				if (lang != null) {
					if (SpecUtil.DOT.equalsIgnoreCase(lang.getText())) {
						type = DotBlock;
					} else if (SpecUtil.UML.equalsIgnoreCase(lang.getText())) {
						type = UmlBlock;
					}
				}
				break;

			default:
				break;
		}
		Specialization data = new Specialization(type, rulename(ctx), ctx, name);
		builder.statement(ModelType.TYPE, ctx, ctx, data);
	}

	// public void doWord() {
	// WordContext ctx = (WordContext) lastPathNode();
	// SpecializedType type;
	// switch (ctx.w.getType()) {
	// case MdLexer.SPAN:
	// type = CodeSpan;
	// break;
	// case MdLexer.MATHS:
	// type = MathSpan;
	// break;
	// default:
	// return;
	// }
	//
	// Specialization data = new Specialization(type, rulename(ctx), ctx, name);
	// builder.field(ModelType.LITERAL, ctx, ctx, data);
	// }
	//
	// public void doAttrL() {
	// ParseTree last = lastPathNode();
	// AttrLeftContext ctx = (AttrLeftContext) last;
	// for (ParseTree child : ctx.children) {
	// TerminalNode node = (TerminalNode) child;
	// MdToken begAttr = (MdToken) node.getSymbol();
	// attributes.put(begAttr.getType(), new Mark(ctx, begAttr));
	// }
	// }
	//
	// public void doAttrR() {
	// AttrRightContext ctx = (AttrRightContext) lastPathNode();
	// for (ParseTree child : ctx.children) {
	// TerminalNode node = (TerminalNode) child;
	// MdToken endAttr = (MdToken) node.getSymbol();
	// Mark mark = attributes.get(leftEquiv(endAttr.getType()));
	// if (mark != null) {
	// builder.field(ModelType.SPAN, mark.ctx, mark.begToken, endAttr, mark.data.name,
	// mark.data);
	// attributes.remove(mark.type);
	// }
	// }
	// }

	// --------------------------------------------------

	// private int leftEquiv(int type) {
	// switch (type) {
	// case MdLexer.RBOLD:
	// return MdLexer.LBOLD;
	// case MdLexer.RITALIC:
	// return MdLexer.LITALIC;
	// case MdLexer.RSTRIKE:
	// return MdLexer.LSTRIKE;
	// case MdLexer.RDQUOTE:
	// return MdLexer.LDQUOTE;
	// case MdLexer.RSQUOTE:
	// return MdLexer.LSQUOTE;
	//
	// default:
	// return Token.INVALID_TYPE;
	// }
	// }
	//
	// private SpecializedType toSpecType(MdToken token) {
	// switch (token.getType()) {
	// case MdLexer.LBOLD:
	// case MdLexer.RBOLD:
	// return Bold;
	//
	// case MdLexer.LITALIC:
	// case MdLexer.RITALIC:
	// return Italic;
	//
	// case MdLexer.LSTRIKE:
	// case MdLexer.RSTRIKE:
	// return Strike;
	//
	// case MdLexer.SPAN:
	// return Span;
	//
	// case MdLexer.LDQUOTE:
	// case MdLexer.RDQUOTE:
	// return Quote;
	//
	// case MdLexer.LSQUOTE:
	// case MdLexer.RSQUOTE:
	// return Quote;
	//
	// default:
	// return Unknown;
	// }
	// }

	public void doLink(SpecializedType type, SpecSubType subtype) {
		ParserRuleContext ctx = (ParserRuleContext) lastPathNode();
		Specialization data = new Specialization(type, rulename(ctx), ctx, name);
		data.setSpecSubType(subtype);
		Statement stmt = builder.statement(ModelType.VARIABLE, ctx, ctx, data);
		builder.pushParent(stmt);
	}

	public void doList() {
		ListContext ctx = (ListContext) lastPathNode();
		MdToken mark = (MdToken) ((ListItemContext) ctx.getChild(0)).mark;
		SpecializedType type = mark.getType() == MdLexer.BULLET_MARK ? ListUnordered : ListOrdered;

		Specialization data = new Specialization(type, rulename(ctx), ctx, type.name);
		data.setDents(mark.getDents());
		data.begList();

		Statement list = builder.statement(ModelType.TYPE, ctx, ctx, data);
		builder.pushParent(list);

		lstLevels.clear();
		lstLevels.push(new Level(list, -1)); // level -1 is the list root
	}

	public void doListItem() {
		ListItemContext ctx = (ListItemContext) lastPathNode();
		MdToken mark = (MdToken) ctx.mark;
		Specialization data = new Specialization(ListItem, rulename(ctx), ctx, mark.getText());

		int dents = mark.getDents();
		data.setDents(dents);

		Statement list = getEnclosingList(dents);
		builder.toParent(list);

		// SpecializedType type = ListUnordered;
		// if (list.hasData()) {
		// type = (SpecializedType) list.getSpecializedType();
		// }
		// data.setSpecializedType(type);

		Statement stmt = builder.statement(ModelType.TYPE, ctx, mark, data);
		builder.pushParent(stmt);
		lstLevels.push(new Level(stmt, dents));
	}

	private Statement getEnclosingList(int level) {
		if (level < 0) level = 0;
		if (level > 6) level = 6;
		while (lstLevels.peek().level >= level) {
			lstLevels.pop();
		}
		return lstLevels.peek().stmt;
	}

	public void endBlock() {
		builder.popParent();
	}

	private String rulename(ParserRuleContext ctx) {
		return MdParser.ruleNames[ctx.getRuleIndex()];
	}
}
