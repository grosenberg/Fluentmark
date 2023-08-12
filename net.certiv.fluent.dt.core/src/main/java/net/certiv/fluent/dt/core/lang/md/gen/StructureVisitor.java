//
// Generated from net.certiv.fluent.dt.core.lang.md.gen
// by XVisitor 4.8.0
//
package net.certiv.fluent.dt.core.lang.md.gen;
	import  net.certiv.fluent.dt.core.lang.md.model.StructureBuilder;
	import  static net.certiv.fluent.dt.core.lang.md.model.SpecializedType.*;
	import  static net.certiv.fluent.dt.core.lang.md.model.SpecSubType.*;

import java.util.List;
import org.antlr.v4.runtime.tree.ParseTree;
import net.certiv.antlr.runtime.xvisitor.Processor;
import net.certiv.antlr.runtime.xvisitor.xpath.EType;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class StructureVisitor extends StructureBuilder {

	public static final String[] tokenNames = {
		"<INVALID>", "WORD", "CODE_BEG", "CODE_END", "CODE_TYPE", "CODE_LINE", 
		"CODE_DENT", "CODE_BLANK", "QUOTE_BLANK", "QUOTE_DENT", "ESC_SQUOTE", 
		"ESC_DQUOTE", "LBOLD", "LITALIC", "LSTRIKE", "LDQUOTE", "LSQUOTE", "RBOLD", 
		"RITALIC", "RSTRIKE", "RDQUOTE", "RSQUOTE", "COMMENT", "HTML_BLOCK_BEG", 
		"HTML_BLOCK_END", "YAML_BLOCK", "DOT_BLOCK", "MATH_BLOCK", "TEX_BLOCK", 
		"UML_BLOCK", "MATHS", "SPAN", "LSTYLE", "URL", "URLTAG", "HTML", "TEX", 
		"UNICODE", "ENTITY", "HASHES", "SETEXT", "HRULE", "DEFINE", "TABLE_DEF", 
		"PIPE", "BULLET_MARK", "NUMBER_MARK", "TASK_MARK", "LNK_IMG", "LNK_FN", 
		"LNK_SEP", "LNK_REF", "LNK_DEF", "LBRACK", "RBRACK", "LPAREN", "RPAREN", 
		"BOLD", "ITALIC", "STRIKE", "DQUOTE", "SQUOTE", "LINE_BLANK", "LINE_BREAK", 
		"LINE_DENT", "VWS", "HWS", "CHAR", "RSTYLE", "CLASS", "ID", "EQ", "DASH", 
		"CHAR_s", "TYP_c", "END_cb", "CHR_cb", "TYP_d", "END_db", "CHR_db"
	};

	public static final int
		WORD = 1, CODE_BEG = 2, CODE_END = 3, CODE_TYPE = 4, CODE_LINE = 5, CODE_DENT = 6, 
		CODE_BLANK = 7, QUOTE_BLANK = 8, QUOTE_DENT = 9, ESC_SQUOTE = 10, ESC_DQUOTE = 11, 
		LBOLD = 12, LITALIC = 13, LSTRIKE = 14, LDQUOTE = 15, LSQUOTE = 16, RBOLD = 17, 
		RITALIC = 18, RSTRIKE = 19, RDQUOTE = 20, RSQUOTE = 21, COMMENT = 22, 
		HTML_BLOCK_BEG = 23, HTML_BLOCK_END = 24, YAML_BLOCK = 25, DOT_BLOCK = 26, 
		MATH_BLOCK = 27, TEX_BLOCK = 28, UML_BLOCK = 29, MATHS = 30, SPAN = 31, 
		LSTYLE = 32, URL = 33, URLTAG = 34, HTML = 35, TEX = 36, UNICODE = 37, 
		ENTITY = 38, HASHES = 39, SETEXT = 40, HRULE = 41, DEFINE = 42, TABLE_DEF = 43, 
		PIPE = 44, BULLET_MARK = 45, NUMBER_MARK = 46, TASK_MARK = 47, LNK_IMG = 48, 
		LNK_FN = 49, LNK_SEP = 50, LNK_REF = 51, LNK_DEF = 52, LBRACK = 53, RBRACK = 54, 
		LPAREN = 55, RPAREN = 56, BOLD = 57, ITALIC = 58, STRIKE = 59, DQUOTE = 60, 
		SQUOTE = 61, LINE_BLANK = 62, LINE_BREAK = 63, LINE_DENT = 64, VWS = 65, 
		HWS = 66, CHAR = 67, RSTYLE = 68, CLASS = 69, ID = 70, EQ = 71, DASH = 72, 
		CHAR_s = 73, TYP_c = 74, END_cb = 75, CHR_cb = 76, TYP_d = 77, END_db = 78, 
		CHR_db = 79;

	public static final String[] ruleNames = {
		"page", "yamlBlock", "dotBlock", "mathBlock", "texBlock", "umlBlock", 
		"htmlBlock", "codeBlock", "style", "header", "hrule", "table", "tableRow", 
		"list", "listItem", "definition", "definitionItem", "link", "linkRef", 
		"imgLink", "imgLinkRef", "fnLink", "fnLinkRef", "autoLink", "refLinkDef", 
		"fnLinkDef", "paragraph", "line", "phrase", "quote", "url", "lineBlank", 
		"codeBlank", "quoteBlank", "lineBreak", "nl", "attrLeft", "attrRight", 
		"comment"
	};

	public static final int
		page = 1000, yamlBlock = 1001, dotBlock = 1002, mathBlock = 1003, texBlock = 1004, 
		umlBlock = 1005, htmlBlock = 1006, codeBlock = 1007, style = 1008, header = 1009, 
		hrule = 1010, table = 1011, tableRow = 1012, list = 1013, listItem = 1014, 
		definition = 1015, definitionItem = 1016, link = 1017, linkRef = 1018, 
		imgLink = 1019, imgLinkRef = 1020, fnLink = 1021, fnLinkRef = 1022, autoLink = 1023, 
		refLinkDef = 1024, fnLinkDef = 1025, paragraph = 1026, line = 1027, phrase = 1028, 
		quote = 1029, url = 1030, lineBlank = 1031, codeBlank = 1032, quoteBlank = 1033, 
		lineBreak = 1034, nl = 1035, attrLeft = 1036, attrRight = 1037, comment = 1038;

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

					createPathSpec("table");
						addElement(EType.Rule, true, false, "table", 11); 
					completePathSpec(); 

					createPathSpec("definition");
						addElement(EType.Rule, true, false, "definition", 15); 
					completePathSpec(); 

					createPathSpec("list");
						addElement(EType.Rule, true, false, "list", 13); 
					completePathSpec(); 

					createPathSpec("paragraph");
						addElement(EType.Rule, true, false, "paragraph", 26); 
					completePathSpec(); 

					createPathSpec("phrase");
						addElement(EType.Rule, true, false, "phrase", 28); 
					completePathSpec(); 

					createPathSpec("link");
						addElement(EType.Rule, true, false, "link", 17); 
					completePathSpec(); 

					createPathSpec("linkRef");
						addElement(EType.Rule, true, false, "linkRef", 18); 
					completePathSpec(); 

					createPathSpec("imglink");
						addElement(EType.Rule, true, false, "imgLink", 19); 
					completePathSpec(); 

					createPathSpec("imglinkRef");
						addElement(EType.Rule, true, false, "imgLinkRef", 20); 
					completePathSpec(); 

					createPathSpec("fnlink");
						addElement(EType.Rule, true, false, "fnLink", 21); 
					completePathSpec(); 

					createPathSpec("fnlinkRef");
						addElement(EType.Rule, true, false, "fnLinkRef", 22); 
					completePathSpec(); 

					createPathSpec("refLinkDef");
						addElement(EType.Rule, true, false, "refLinkDef", 24); 
					completePathSpec(); 

					createPathSpec("fnLinkDef");
						addElement(EType.Rule, true, false, "fnLinkDef", 25); 
					completePathSpec(); 

					createPathSpec("comment");
						addElement(EType.Rule, true, false, "comment", 38); 
					completePathSpec(); 

					createPathSpec("yamlBlock");
						addElement(EType.Rule, true, false, "yamlBlock", 1); 
					completePathSpec(); 

					createPathSpec("htmlBlock");
						addElement(EType.Rule, true, false, "htmlBlock", 6); 
					completePathSpec(); 

					createPathSpec("codeBlock");
						addElement(EType.Rule, true, false, "codeBlock", 7); 
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
					case "phrase":
						phrase();
						break;
					case "list":
						list();
						break;
					case "listItem":
						listItem();
						break;
					case "link":
						link();
						break;
					case "linkRef":
						linkRef();
						break;
					case "imglink":
						imglink();
						break;
					case "imglinkRef":
						imglinkRef();
						break;
					case "fnlink":
						fnlink();
						break;
					case "fnlinkRef":
						fnlinkRef();
						break;
					case "refLinkDef":
						refLinkDef();
						break;
					case "fnLinkDef":
						fnLinkDef();
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

	private void phrase() {
		if (entering()) { doType(Phrase); }
	}

	private void list() {
		if (entering()) { doList(); }
		if (exiting()) {  endBlock(); }
	}

	private void listItem() {
		if (entering()) { doListItem(); }
		if (exiting()) {  endBlock(); }
	}

	private void link() {
		if (entering()) { doLink(Link, INLINE); }
		if (exiting()) {  endBlock(); }
	}

	private void linkRef() {
		if (entering()) { doLink(Link, REF); }
		if (exiting()) {  endBlock(); }
	}

	private void imglink() {
		if (entering()) { doLink(Image, INLINE); }
		if (exiting()) {  endBlock(); }
	}

	private void imglinkRef() {
		if (entering()) { doLink(Image, REF); }
		if (exiting()) {  endBlock(); }
	}

	private void fnlink() {
		if (entering()) { doLink(Footnote, INLINE); }
		if (exiting()) {  endBlock(); }
	}

	private void fnlinkRef() {
		if (entering()) { doLink(Footnote, REF); }
		if (exiting()) {  endBlock(); }
	}

	private void refLinkDef() {
		if (entering()) { doLink(Link, REF_DEF); }
		if (exiting()) {  endBlock(); }
	}

	private void fnLinkDef() {
		if (entering()) { doLink(Footnote, REF_DEF); }
		if (exiting()) {  endBlock(); }
	}



}