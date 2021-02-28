//
// Generated from net.certiv.fluent.dt.core.lang.md.gen
// by XVisitor 4.7.1
//
package net.certiv.fluent.dt.core.lang.md.gen;
	import static net.certiv.fluent.dt.core.lang.md.model.SpecializationType.*;

import org.antlr.v4.runtime.tree.ParseTree;

import net.certiv.antlr.runtime.xvisitor.xpath.EType;
import net.certiv.fluent.dt.core.lang.md.model.StructureBuilder;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class StructureVisitor extends StructureBuilder {

	public static final String[] tokenNames = {
		"<INVALID>", "WORD", "RBOLD", "RITALIC", "RSTRIKE", "RDQUOTE", "RSQUOTE", 
		"COMMENT", "CODE_BEG", "YAML_BLOCK", "HTML_BLOCK", "DOT_BLOCK", "MATH_BLOCK", 
		"TEX_BLOCK", "UML_BLOCK", "MATHS", "SPAN", "LSTYLE", "URL", "URLTAG", 
		"HTML", "TEX", "UNICODE", "ENTITY", "IMAGE", "FNOTE", "LINK", "TABLE", 
		"PIPE", "HASHES", "DASHES", "EQUALS", "HRULE", "COLON", "BULLET_MARK", 
		"NUMBER_MARK", "PAREN_MARK", "UALPHA_MARK", "LALPHA_MARK", "LBOLD", "LITALIC", 
		"LSTRIKE", "LDQUOTE", "LSQUOTE", "BLOCKQUOTE", "LINE_DENT", "LINE_BLANK", 
		"LINE_BREAK", "VWS", "HWS", "CHAR", "HASH", "CHAR_h", "RSTYLE", "CLASS", 
		"ID", "EQ", "DASH", "DQUOTE", "SQUOTE", "CHAR_s", "CODE_END", "CHR_c", 
		"CHR_t", "LNK_SEP", "LNK_REF", "LNK_DEF", "RBRACK", "CHR_l", "RPAREN", 
		"CHR_d", "CHR_r"
	};

	public static final int
		WORD = 1, RBOLD = 2, RITALIC = 3, RSTRIKE = 4, RDQUOTE = 5, RSQUOTE = 6, 
		COMMENT = 7, CODE_BEG = 8, YAML_BLOCK = 9, HTML_BLOCK = 10, DOT_BLOCK = 11, 
		MATH_BLOCK = 12, TEX_BLOCK = 13, UML_BLOCK = 14, MATHS = 15, SPAN = 16, 
		LSTYLE = 17, URL = 18, URLTAG = 19, HTML = 20, TEX = 21, UNICODE = 22, 
		ENTITY = 23, IMAGE = 24, FNOTE = 25, LINK = 26, TABLE = 27, PIPE = 28, 
		HASHES = 29, DASHES = 30, EQUALS = 31, HRULE = 32, COLON = 33, BULLET_MARK = 34, 
		NUMBER_MARK = 35, PAREN_MARK = 36, UALPHA_MARK = 37, LALPHA_MARK = 38, 
		LBOLD = 39, LITALIC = 40, LSTRIKE = 41, LDQUOTE = 42, LSQUOTE = 43, BLOCKQUOTE = 44, 
		LINE_DENT = 45, LINE_BLANK = 46, LINE_BREAK = 47, VWS = 48, HWS = 49, 
		CHAR = 50, HASH = 51, CHAR_h = 52, RSTYLE = 53, CLASS = 54, ID = 55, EQ = 56, 
		DASH = 57, DQUOTE = 58, SQUOTE = 59, CHAR_s = 60, CODE_END = 61, CHR_c = 62, 
		CHR_t = 63, LNK_SEP = 64, LNK_REF = 65, LNK_DEF = 66, RBRACK = 67, CHR_l = 68, 
		RPAREN = 69, CHR_d = 70, CHR_r = 71;

	public static final String[] ruleNames = {
		"page", "yamlBlock", "htmlBlock", "dotBlock", "mathBlock", "texBlock", 
		"umlBlock", "codeBlock", "style", "header", "hrule", "table", "tableRow", 
		"list", "listItem", "definition", "defineItem", "link", "lnkDef", "lnkRef", 
		"url", "alt", "paragraph", "lines", "line", "word", "nl", "nl2", "attrLeft", 
		"attrRight", "comment", "lnBlank", "lnBreak"
	};

	public static final int
		page = 1000, yamlBlock = 1001, htmlBlock = 1002, dotBlock = 1003, mathBlock = 1004, 
		texBlock = 1005, umlBlock = 1006, codeBlock = 1007, style = 1008, header = 1009, 
		hrule = 1010, table = 1011, tableRow = 1012, list = 1013, listItem = 1014, 
		definition = 1015, defineItem = 1016, link = 1017, lnkDef = 1018, lnkRef = 1019, 
		url = 1020, alt = 1021, paragraph = 1022, lines = 1023, line = 1024, word = 1025, 
		nl = 1026, nl2 = 1027, attrLeft = 1028, attrRight = 1029, comment = 1030, 
		lnBlank = 1031, lnBreak = 1032;

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
						addElement(EType.Rule, true, false, "header", 9); 
					completePathSpec(); 

					createPathSpec("hrule");
						addElement(EType.Rule, true, false, "hrule", 10); 
					completePathSpec(); 

					createPathSpec("paragraph");
						addElement(EType.Rule, true, false, "paragraph", 22); 
					completePathSpec(); 

					createPathSpec("table");
						addElement(EType.Rule, true, false, "table", 11); 
					completePathSpec(); 

					createPathSpec("definition");
						addElement(EType.Rule, true, false, "definition", 15); 
					completePathSpec(); 

					createPathSpec("list");
						addElement(EType.Rule, true, false, "list", 13); 
					completePathSpec(); 

					createPathSpec("word");
						addElement(EType.Rule, true, false, "word", 25); 
					completePathSpec(); 

					createPathSpec("attrL");
						addElement(EType.Rule, true, false, "attrLeft", 28); 
					completePathSpec(); 

					createPathSpec("attrR");
						addElement(EType.Rule, true, false, "attrRight", 29); 
					completePathSpec(); 

					createPathSpec("comment");
						addElement(EType.Rule, true, false, "comment", 30); 
					completePathSpec(); 

					createPathSpec("yamlBlock");
						addElement(EType.Rule, true, false, "yamlBlock", 1); 
					completePathSpec(); 

					createPathSpec("htmlBlock");
						addElement(EType.Rule, true, false, "htmlBlock", 2); 
					completePathSpec(); 

					createPathSpec("codeBlock");
						addElement(EType.Rule, true, false, "codeBlock", 7); 
					completePathSpec(); 

					createPathSpec("dotBlock");
						addElement(EType.Rule, true, false, "dotBlock", 3); 
					completePathSpec(); 

					createPathSpec("mathBlock");
						addElement(EType.Rule, true, false, "mathBlock", 4); 
					completePathSpec(); 

					createPathSpec("texBlock");
						addElement(EType.Rule, true, false, "texBlock", 5); 
					completePathSpec(); 

					createPathSpec("umlBlock");
						addElement(EType.Rule, true, false, "umlBlock", 6); 
					completePathSpec(); 

					createPathSpec("listItem");
						addElement(EType.Rule, true, false, "listItem", 14); 
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
					case "comment":
						comment();
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
					case "dotBlock":
						dotBlock();
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
					case "definition":
						definition();
						break;
					case "table":
						table();
						break;
					case "paragraph":
						paragraph();
						break;
					case "list":
						list();
						break;
					case "listItem":
						listItem();
						break;
					case "attrL":
						attrL();
						break;
					case "word":
						word();
						break;
					case "attrR":
						attrR();
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
		if (entering()) { doType(HRule); }
	}

	private void comment() {
		if (entering()) { doType(Comment); }
	}

	private void yamlBlock() {
		if (entering()) { doType(YamlBlock); }
	}

	private void htmlBlock() {
		if (entering()) { doType(HtmlBlock); }
	}

	private void codeBlock() {
		if (entering()) { doType(CodeBlock); }
	}

	private void dotBlock() {
		if (entering()) { doType(DotBlock); }
	}

	private void mathBlock() {
		if (entering()) { doType(MathBlock); }
	}

	private void texBlock() {
		if (entering()) { doType(TexBlock) ; }
	}

	private void umlBlock() {
		if (entering()) { doType(UmlBlock) ; }
	}

	private void definition() {
		if (entering()) { doType(Definition); }
	}

	private void table() {
		if (entering()) { doType(Table); }
	}

	private void paragraph() {
		if (entering()) { doStatement(Paragraph); }
		if (exiting()) {  endBlock(); }
	}

	private void list() {
		if (entering()) { doList(); }
		if (exiting()) {  endBlock(); }
	}

	private void listItem() {
		if (entering()) { doListItem(); }
	}

	private void attrL() {
		if (entering()) { doAttrL() ; }
	}

	private void word() {
		if (entering()) { doWord()  ; }
	}

	private void attrR() {
		if (entering()) { doAttrR() ; }
	}



}