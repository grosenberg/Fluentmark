//
// Generated from D:\DevFiles\Eclipse\Tools\Editors\net.certiv.fluent.dt\net.certiv.fluent.dt.core\src\main\java\net\certiv\fluent\dt\core\lang\md\Structure.xv
// by XVisitor 4.7
//
package net.certiv.fluent.dt.core.lang.md.gen;
	import  net.certiv.fluent.dt.core.lang.md.StructureBuilder;
	import  net.certiv.fluent.dt.core.model.SpecType;

import java.util.List;
import org.antlr.v4.runtime.tree.ParseTree;
import net.certiv.antlr.runtime.xvisitor.Processor;
import net.certiv.antlr.runtime.xvisitor.xpath.EType;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class StructureVisitor extends StructureBuilder {

	public static final String[] tokenNames = {
		"<INVALID>", "WORD", "RBOLD", "RITALIC", "RSTRIKE", "RSPAN", "RDQUOTE", 
		"RSQUOTE", "HIDN_COMMENT", "HTML_COMMENT", "URL", "LSTYLE", "LINK", "LDEF", 
		"LREF", "LURL", "LTXT", "CODE_BEG", "YAML_BLOCK", "HTML_BLOCK", "MATH_BLOCK", 
		"TEX_BLOCK", "UML_BLOCK", "UNICODE", "ENTITY", "TEX", "MATH", "HTML", 
		"TABLE_DEF", "PIPE", "HRULE", "HASHES", "DASHES", "EQUALS", "COLON", "SIMPLE_MARK", 
		"PAREN_MARK", "UALPHA_MARK", "LALPHA_MARK", "LBOLD", "LITALIC", "LSTRIKE", 
		"LSPAN", "LDQUOTE", "LSQUOTE", "SECTION", "BREAK", "BQUOTE", "DENT", "VWS", 
		"HWS", "CHAR", "ERR", "HASH", "CHAR_h", "RSTYLE", "CLASS", "ID", "EQ", 
		"QUOTE", "MARK", "CHAR_sd", "LINK_MARK", "REF_MARK", "DEF_MARK", "RBRACK", 
		"RPAREN", "CHAR_l", "CODE_END", "WORD_b", "WORD_t"
	};

	public static final int
		WORD = 1, RBOLD = 2, RITALIC = 3, RSTRIKE = 4, RSPAN = 5, RDQUOTE = 6, 
		RSQUOTE = 7, HIDN_COMMENT = 8, HTML_COMMENT = 9, URL = 10, LSTYLE = 11, 
		LINK = 12, LDEF = 13, LREF = 14, LURL = 15, LTXT = 16, CODE_BEG = 17, 
		YAML_BLOCK = 18, HTML_BLOCK = 19, MATH_BLOCK = 20, TEX_BLOCK = 21, UML_BLOCK = 22, 
		UNICODE = 23, ENTITY = 24, TEX = 25, MATH = 26, HTML = 27, TABLE_DEF = 28, 
		PIPE = 29, HRULE = 30, HASHES = 31, DASHES = 32, EQUALS = 33, COLON = 34, 
		SIMPLE_MARK = 35, PAREN_MARK = 36, UALPHA_MARK = 37, LALPHA_MARK = 38, 
		LBOLD = 39, LITALIC = 40, LSTRIKE = 41, LSPAN = 42, LDQUOTE = 43, LSQUOTE = 44, 
		SECTION = 45, BREAK = 46, BQUOTE = 47, DENT = 48, VWS = 49, HWS = 50, 
		CHAR = 51, ERR = 52, HASH = 53, CHAR_h = 54, RSTYLE = 55, CLASS = 56, 
		ID = 57, EQ = 58, QUOTE = 59, MARK = 60, CHAR_sd = 61, LINK_MARK = 62, 
		REF_MARK = 63, DEF_MARK = 64, RBRACK = 65, RPAREN = 66, CHAR_l = 67, CODE_END = 68, 
		WORD_b = 69, WORD_t = 70;

	public static final String[] ruleNames = {
		"page", "yaml", "html", "math", "tex", "uml", "code", "header", "hrule", 
		"table", "tableRow", "list", "listItem", "listMark", "definition", "paragraph", 
		"line", "text", "link", "word", "style", "attrLeft", "attrRight", "comment", 
		"lnBlank", "lnBreak", "err"
	};

	public static final int
		page = 1000, yaml = 1001, html = 1002, math = 1003, tex = 1004, uml = 1005, 
		code = 1006, header = 1007, hrule = 1008, table = 1009, tableRow = 1010, 
		list = 1011, listItem = 1012, listMark = 1013, definition = 1014, paragraph = 1015, 
		line = 1016, text = 1017, link = 1018, word = 1019, style = 1020, attrLeft = 1021, 
		attrRight = 1022, comment = 1023, lnBlank = 1024, lnBreak = 1025, err = 1026;

	public StructureVisitor(ParseTree tree) {
		super(tree);
		init();
	}

	/** Entry point for finding all matches of the defined XPaths in the parse tree */
	@Override
	public void findAll() {
		super.findAll();
	}

	/**
	 * Entry point for finding all matches of a set of one or more named XPaths in the parse tree. The name of an XPath
	 * is the rulename used in the tree grammar to define the XPath.
	 */
	@Override
	public void find(String... names) {
		super.find(names);
	}

	/** Change the parse tree to match against. Implicitly performs a reset. */
	@Override
	public void setNewParseTree(ParseTree tree) {
		super.setNewParseTree(tree);
	}

	/** Clears state information developed in a prior find operation. */
	@Override
	public void reset() {
		super.reset();
	}

	protected String[] getTokenNames() {
		return tokenNames;
	}

	protected String[] getRuleNames() {
		return ruleNames;
	}

	private void init() {
		mainRule("structure");

					createPathSpec("page");
						addElement(EType.Rule, false, false, "page", 0); 
					completePathSpec(); 

					createPathSpec("header");
						addElement(EType.Rule, true, false, "header", 7); 
					completePathSpec(); 

					createPathSpec("hrule");
						addElement(EType.Rule, true, false, "hrule", 8); 
					completePathSpec(); 

					createPathSpec("paragraph");
						addElement(EType.Rule, true, false, "paragraph", 15); 
					completePathSpec(); 

					createPathSpec("table");
						addElement(EType.Rule, true, false, "table", 9); 
					completePathSpec(); 

					createPathSpec("definition");
						addElement(EType.Rule, true, false, "definition", 14); 
					completePathSpec(); 

					createPathSpec("list");
						addElement(EType.Rule, true, false, "list", 11); 
					completePathSpec(); 

					createPathSpec("comment");
						addElement(EType.Rule, true, false, "comment", 23); 
					completePathSpec(); 

					createPathSpec("yaml");
						addElement(EType.Rule, true, false, "yaml", 1); 
					completePathSpec(); 

					createPathSpec("html");
						addElement(EType.Rule, true, false, "html", 2); 
					completePathSpec(); 

					createPathSpec("code");
						addElement(EType.Rule, true, false, "code", 6); 
					completePathSpec(); 

					createPathSpec("math");
						addElement(EType.Rule, true, false, "math", 3); 
					completePathSpec(); 

					createPathSpec("tex");
						addElement(EType.Rule, true, false, "tex", 4); 
					completePathSpec(); 

					createPathSpec("uml");
						addElement(EType.Rule, true, false, "uml", 5); 
					completePathSpec(); 

					createPathSpec("listItem");
						addElement(EType.Rule, true, false, "listItem", 12); 
					completePathSpec(); 
	}


	@Override
	public void executeActionBlock(String name) {
		switch (name) {
					case "page":
						page();
						break;
					case "header":
						header();
						break;
					case "hrule":
						hrule();
						break;
					case "paragraph":
						paragraph();
						break;
					case "definition":
						definition();
						break;
					case "table":
						table();
						break;
					case "comment":
						comment();
						break;
					case "yaml":
						yaml();
						break;
					case "html":
						html();
						break;
					case "code":
						code();
						break;
					case "math":
						math();
						break;
					case "tex":
						tex();
						break;
					case "uml":
						uml();
						break;
					case "list":
						list();
						break;
					case "listItem":
						listItem();
						break;
		}
	}

	private void page() {
		if (entering()) { doModule(); }
	}

	private void header() {
		if (entering()) { doHeader(); }
	}

	private void hrule() {
		if (entering()) { doStatement(SpecType.HRule); }
	}

	private void paragraph() {
		if (entering()) { doStatement(SpecType.Paragraph); }
	}

	private void definition() {
		if (entering()) { doStatement(SpecType.Definition); }
	}

	private void table() {
		if (entering()) { doStatement(SpecType.Table); }
	}

	private void comment() {
		if (entering()) { doStatement(SpecType.Comment); }
	}

	private void yaml() {
		if (entering()) { doStatement(SpecType.YamlBlock); }
	}

	private void html() {
		if (entering()) { doStatement(SpecType.HtmlBlock); }
	}

	private void code() {
		if (entering()) { doStatement(SpecType.CodeBlock); }
	}

	private void math() {
		if (entering()) { doStatement(SpecType.MathBlock); }
	}

	private void tex() {
		if (entering()) { doStatement(SpecType.TexBlock) ; }
	}

	private void uml() {
		if (entering()) { doStatement(SpecType.UmlBlock) ; }
	}

	private void list() {
		if (entering()) { doList(); }
		if (exiting()) { endBlock(); }
	}

	private void listItem() {
		if (entering()) { doListItem(); }
	}



}