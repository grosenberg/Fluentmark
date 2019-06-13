//
// Generated from D:\DevFiles\Eclipse\Tools\Editors\net.certiv.fluent.dt\net.certiv.fluent.dt.core\src\main\java\net\certiv\fluent\dt\core\lang\md\Structure.xv
// by XVisitor 4.7
//
package net.certiv.fluent.dt.core.lang.md.gen;
	import org.antlr.v4.runtime.tree.ParseTree;

import net.certiv.antlr.runtime.xvisitor.xpath.EType;
import  net.certiv.fluent.dt.core.lang.md.StructureBuilder;
import net.certiv.fluent.dt.core.model.ModelType;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class StructureVisitor extends StructureBuilder {

	public static final String[] tokenNames = {
		"<INVALID>", "WORD", "HDR_END", "RBOLD", "RITALIC", "RSTRIKE", "RSPAN", 
		"RDQUOTE", "RSQUOTE", "HIDN_COMMENT", "HTML_COMMENT", "URL", "LSTYLE", 
		"LINK", "LREF", "LURL", "LDEF", "CODE_BEG", "YAML_BLOCK", "HTML_BLOCK", 
		"MATH_BLOCK", "TEX_BLOCK", "UML_BLOCK", "UNICODE", "ENTITY", "TEX", "MATH", 
		"HTML", "TABLE", "PIPE", "COLON", "BQUOTE", "HASHES", "DASHES", "EQUALS", 
		"LIST_ITEM", "HRULE", "LBOLD", "LITALIC", "LSTRIKE", "LSPAN", "LDQUOTE", 
		"LSQUOTE", "BLANK", "BREAK", "VWS", "HWS", "CHAR", "ERR", "HASH", "CHAR_h", 
		"RSTYLE", "CLASS", "ID", "EQ", "QUOTE", "MARK", "CHAR_sd", "LINK_MARK", 
		"REF_MARK", "DEF_MARK", "RBRACK", "RPAREN", "CHAR_l", "CODE_END", "WORD_b", 
		"WORD_t"
	};

	public static final int
		WORD = 1, HDR_END = 2, RBOLD = 3, RITALIC = 4, RSTRIKE = 5, RSPAN = 6, 
		RDQUOTE = 7, RSQUOTE = 8, HIDN_COMMENT = 9, HTML_COMMENT = 10, URL = 11, 
		LSTYLE = 12, LINK = 13, LREF = 14, LURL = 15, LDEF = 16, CODE_BEG = 17, 
		YAML_BLOCK = 18, HTML_BLOCK = 19, MATH_BLOCK = 20, TEX_BLOCK = 21, UML_BLOCK = 22, 
		UNICODE = 23, ENTITY = 24, TEX = 25, MATH = 26, HTML = 27, TABLE = 28, 
		PIPE = 29, COLON = 30, BQUOTE = 31, HASHES = 32, DASHES = 33, EQUALS = 34, 
		LIST_ITEM = 35, HRULE = 36, LBOLD = 37, LITALIC = 38, LSTRIKE = 39, LSPAN = 40, 
		LDQUOTE = 41, LSQUOTE = 42, BLANK = 43, BREAK = 44, VWS = 45, HWS = 46, 
		CHAR = 47, ERR = 48, HASH = 49, CHAR_h = 50, RSTYLE = 51, CLASS = 52, 
		ID = 53, EQ = 54, QUOTE = 55, MARK = 56, CHAR_sd = 57, LINK_MARK = 58, 
		REF_MARK = 59, DEF_MARK = 60, RBRACK = 61, RPAREN = 62, CHAR_l = 63, CODE_END = 64, 
		WORD_b = 65, WORD_t = 66;

	public static final String[] ruleNames = {
		"page", "yamlBlock", "htmlBlock", "mathBlock", "texBlock", "umlBlock", 
		"codeBlock", "header", "hrule", "list", "listItem", "table", "tableDef", 
		"tableRow", "tableCell", "quote", "definition", "paragraph", "content", 
		"text", "line", "word", "link", "style", "attrLeft", "attrRight", "comment", 
		"lnBlank", "lnBreak", "ignore"
	};

	public static final int
		page = 1000, yamlBlock = 1001, htmlBlock = 1002, mathBlock = 1003, texBlock = 1004, 
		umlBlock = 1005, codeBlock = 1006, header = 1007, hrule = 1008, list = 1009, 
		listItem = 1010, table = 1011, tableDef = 1012, tableRow = 1013, tableCell = 1014, 
		quote = 1015, definition = 1016, paragraph = 1017, content = 1018, text = 1019, 
		line = 1020, word = 1021, link = 1022, style = 1023, attrLeft = 1024, 
		attrRight = 1025, comment = 1026, lnBlank = 1027, lnBreak = 1028, ignore = 1029;

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

					createPathSpec("paragraph");
						addElement(EType.Rule, true, false, "paragraph", 17); 
					completePathSpec(); 

					createPathSpec("hrule");
						addElement(EType.Rule, true, false, "hrule", 8); 
					completePathSpec(); 

					createPathSpec("comment");
						addElement(EType.Rule, true, false, "comment", 26); 
					completePathSpec(); 

					createPathSpec("yamlBlock");
						addElement(EType.Rule, true, false, "yamlBlock", 1); 
					completePathSpec(); 

					createPathSpec("htmlBlock");
						addElement(EType.Rule, true, false, "htmlBlock", 2); 
					completePathSpec(); 

					createPathSpec("codeBlock");
						addElement(EType.Rule, true, false, "codeBlock", 6); 
					completePathSpec(); 

					createPathSpec("mathBlock");
						addElement(EType.Rule, true, false, "mathBlock", 3); 
					completePathSpec(); 

					createPathSpec("texBlock");
						addElement(EType.Rule, true, false, "texBlock", 4); 
					completePathSpec(); 

					createPathSpec("umlBlock");
						addElement(EType.Rule, true, false, "umlBlock", 5); 
					completePathSpec(); 

					createPathSpec("list");
						addElement(EType.Rule, true, false, "list", 9); 
					completePathSpec(); 

					createPathSpec("table");
						addElement(EType.Rule, true, false, "table", 11); 
					completePathSpec(); 

					createPathSpec("quote");
						addElement(EType.Rule, true, false, "quote", 15); 
					completePathSpec(); 

					createPathSpec("definition");
						addElement(EType.Rule, true, false, "definition", 16); 
					completePathSpec(); 

					createPathSpec("listItem");
						addElement(EType.Rule, true, false, "listItem", 10); 
					completePathSpec(); 

					createPathSpec("tableRow");
						addElement(EType.Rule, true, false, "tableRow", 13); 
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
					case "paragraph":
						paragraph();
						break;
					case "hrule":
						hrule();
						break;
					case "comment":
						comment();
						break;
					case "quote":
						quote();
						break;
					case "definition":
						definition();
						break;
					case "yamlBlock":
						yamlBlock();
						break;
					case "htmlBlock":
						htmlBlock();
						break;
					case "codeBlock":
						codeBlock();
						break;
					case "mathBlock":
						mathBlock();
						break;
					case "texBlock":
						texBlock();
						break;
					case "umlBlock":
						umlBlock();
						break;
					case "list":
						list();
						break;
					case "listItem":
						listItem();
						break;
					case "table":
						table();
						break;
					case "tableRow":
						tableRow();
						break;
		}
	}

	private void page() {
		if (entering()) { doModule(); }
	}

	private void header() {
		if (entering()) { doHeader(); }
	}

	private void paragraph() {
		if (entering()) { doStatement(ModelType.Paragraph); }
	}

	private void hrule() {
		if (entering()) { doStatement(ModelType.HRule); }
	}

	private void comment() {
		if (entering()) { doStatement(ModelType.Comment); }
	}

	private void quote() {
		if (entering()) { doStatement(ModelType.Quote); }
	}

	private void definition() {
		if (entering()) { doStatement(ModelType.Definition); }
	}

	private void yamlBlock() {
		if (entering()) { doStatement(ModelType.MetaMatter); }
	}

	private void htmlBlock() {
		if (entering()) { doStatement(ModelType.HtmlBlock); }
	}

	private void codeBlock() {
		if (entering()) { doStatement(ModelType.CodeBlock); }
	}

	private void mathBlock() {
		if (entering()) { doStatement(ModelType.MathBlock); }
	}

	private void texBlock() {
		if (entering()) { doStatement(ModelType.TexBlock); }
	}

	private void umlBlock() {
		if (entering()) { doStatement(ModelType.UmlGraph); }
	}

	private void list() {
		if (entering()) { doList(); }
		if (exiting()) { endBlock(); }
	}

	private void listItem() {
		if (entering()) { doListItem(); }
	}

	private void table() {
		if (entering()) { doTable(); }
		if (exiting()) { endBlock(); }
	}

	private void tableRow() {
		if (entering()) { doTableRow(); }
	}



}