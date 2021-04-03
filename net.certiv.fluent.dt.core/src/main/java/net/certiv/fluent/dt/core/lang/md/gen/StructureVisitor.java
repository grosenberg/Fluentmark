//
// Generated from net.certiv.fluent.dt.core.lang.md.gen
// by XVisitor 4.7.1
//
package net.certiv.fluent.dt.core.lang.md.gen;
	import  net.certiv.fluent.dt.core.lang.md.model.StructureBuilder;
	import  static net.certiv.fluent.dt.core.lang.md.model.SpecializationType.*;

import java.util.List;
import org.antlr.v4.runtime.tree.ParseTree;
import net.certiv.antlr.runtime.xvisitor.Processor;
import net.certiv.antlr.runtime.xvisitor.xpath.EType;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class StructureVisitor extends StructureBuilder {

	public static final String[] tokenNames = {
		"<INVALID>", "WORD", "RBOLD", "RITALIC", "RSTRIKE", "RDQUOTE", "RSQUOTE", 
		"COMMENT", "CODE_BEG", "HTML_BLOCK_BEG", "HTML_BLOCK_END", "YAML_BLOCK", 
		"DOT_BLOCK", "MATH_BLOCK", "TEX_BLOCK", "UML_BLOCK", "MATHS", "SPAN", 
		"LSTYLE", "URL", "URLTAG", "HTML", "TEX", "UNICODE", "ENTITY", "IMAGE", 
		"FNOTE", "LINK", "TABLE", "PIPE", "HASHES", "DASHES", "EQUALS", "HRULE", 
		"COLON", "BULLET_MARK", "NUMBER_MARK", "PAREN_MARK", "UALPHA_MARK", "LALPHA_MARK", 
		"LBOLD", "LITALIC", "LSTRIKE", "LDQUOTE", "LSQUOTE", "BLOCKQUOTE", "LINE_DENT", 
		"LINE_BLANK", "LINE_BREAK", "VWS", "HWS", "CHAR", "HASH", "CHAR_h", "RSTYLE", 
		"CLASS", "ID", "EQ", "DASH", "DQUOTE", "SQUOTE", "CHAR_s", "CODE_END", 
		"CHR_c", "CHR_t", "LNK_SEP", "LNK_REF", "LNK_DEF", "RBRACK", "CHR_l", 
		"RPAREN", "CHR_d", "CHR_r"
	};

	public static final int
		WORD = 1, RBOLD = 2, RITALIC = 3, RSTRIKE = 4, RDQUOTE = 5, RSQUOTE = 6, 
		COMMENT = 7, CODE_BEG = 8, HTML_BLOCK_BEG = 9, HTML_BLOCK_END = 10, YAML_BLOCK = 11, 
		DOT_BLOCK = 12, MATH_BLOCK = 13, TEX_BLOCK = 14, UML_BLOCK = 15, MATHS = 16, 
		SPAN = 17, LSTYLE = 18, URL = 19, URLTAG = 20, HTML = 21, TEX = 22, UNICODE = 23, 
		ENTITY = 24, IMAGE = 25, FNOTE = 26, LINK = 27, TABLE = 28, PIPE = 29, 
		HASHES = 30, DASHES = 31, EQUALS = 32, HRULE = 33, COLON = 34, BULLET_MARK = 35, 
		NUMBER_MARK = 36, PAREN_MARK = 37, UALPHA_MARK = 38, LALPHA_MARK = 39, 
		LBOLD = 40, LITALIC = 41, LSTRIKE = 42, LDQUOTE = 43, LSQUOTE = 44, BLOCKQUOTE = 45, 
		LINE_DENT = 46, LINE_BLANK = 47, LINE_BREAK = 48, VWS = 49, HWS = 50, 
		CHAR = 51, HASH = 52, CHAR_h = 53, RSTYLE = 54, CLASS = 55, ID = 56, EQ = 57, 
		DASH = 58, DQUOTE = 59, SQUOTE = 60, CHAR_s = 61, CODE_END = 62, CHR_c = 63, 
		CHR_t = 64, LNK_SEP = 65, LNK_REF = 66, LNK_DEF = 67, RBRACK = 68, CHR_l = 69, 
		RPAREN = 70, CHR_d = 71, CHR_r = 72;

	public static final String[] ruleNames = {
		"page", "yamlBlock", "dotBlock", "mathBlock", "texBlock", "umlBlock", 
		"htmlBlockBeg", "htmlBlockEnd", "codeBlock", "style", "header", "hrule", 
		"table", "tableRow", "list", "listItem", "definition", "defineItem", "link", 
		"lnkDef", "lnkRef", "url", "alt", "paragraph", "lines", "line", "word", 
		"nl", "nl2", "attrLeft", "attrRight", "comment", "lnBlank", "lnBreak"
	};

	public static final int
		page = 1000, yamlBlock = 1001, dotBlock = 1002, mathBlock = 1003, texBlock = 1004, 
		umlBlock = 1005, htmlBlockBeg = 1006, htmlBlockEnd = 1007, codeBlock = 1008, 
		style = 1009, header = 1010, hrule = 1011, table = 1012, tableRow = 1013, 
		list = 1014, listItem = 1015, definition = 1016, defineItem = 1017, link = 1018, 
		lnkDef = 1019, lnkRef = 1020, url = 1021, alt = 1022, paragraph = 1023, 
		lines = 1024, line = 1025, word = 1026, nl = 1027, nl2 = 1028, attrLeft = 1029, 
		attrRight = 1030, comment = 1031, lnBlank = 1032, lnBreak = 1033;

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
						addElement(EType.Rule, true, false, "header", 10); 
					completePathSpec(); 

					createPathSpec("hrule");
						addElement(EType.Rule, true, false, "hrule", 11); 
					completePathSpec(); 

					createPathSpec("paragraph");
						addElement(EType.Rule, true, false, "paragraph", 23); 
					completePathSpec(); 

					createPathSpec("table");
						addElement(EType.Rule, true, false, "table", 12); 
					completePathSpec(); 

					createPathSpec("definition");
						addElement(EType.Rule, true, false, "definition", 16); 
					completePathSpec(); 

					createPathSpec("list");
						addElement(EType.Rule, true, false, "list", 14); 
					completePathSpec(); 

					createPathSpec("word");
						addElement(EType.Rule, true, false, "word", 26); 
					completePathSpec(); 

					createPathSpec("attrL");
						addElement(EType.Rule, true, false, "attrLeft", 29); 
					completePathSpec(); 

					createPathSpec("attrR");
						addElement(EType.Rule, true, false, "attrRight", 30); 
					completePathSpec(); 

					createPathSpec("comment");
						addElement(EType.Rule, true, false, "comment", 31); 
					completePathSpec(); 

					createPathSpec("yamlBlock");
						addElement(EType.Rule, true, false, "yamlBlock", 1); 
					completePathSpec(); 

					createPathSpec("htmlBlock");
						addElement(EType.Rule, true, false, "htmlBlockBeg", 6); 
					completePathSpec(); 

					createPathSpec("codeBlock");
						addElement(EType.Rule, true, false, "codeBlock", 8); 
					completePathSpec(); 

					createPathSpec("dotBlock");
						addElement(EType.Rule, true, false, "dotBlock", 2); 
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

					createPathSpec("listItem");
						addElement(EType.Rule, true, false, "listItem", 15); 
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
					case "htmlBlock":
						htmlBlock();
						break;
					case "yamlBlock":
						yamlBlock();
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

	private void htmlBlock() {
		if (entering()) { doType(HtmlBlock); }
	}

	private void yamlBlock() {
		if (entering()) { doType(YamlBlock); }
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