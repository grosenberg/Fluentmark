//
// Generated from D:\DevFiles\Eclipse\DslEditors\net.certiv.fluentmark\net.certiv.fluentmark.core\src\main\java\net\certiv\fluentmark\core\md\parser\Structure.xv
// by XVisitor 4.7
//
package net.certiv.fluentmark.core.md.parser.gen;
	import net.certiv.fluentmark.core.md.parser.StructureBuilder;

import java.util.List;
import org.antlr.v4.runtime.tree.ParseTree;
import net.certiv.antlr.runtime.xvisitor.Processor;
import net.certiv.antlr.runtime.xvisitor.xpath.EType;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class StructureVisitor extends StructureBuilder {

	public static final String[] tokenNames = {
		"<INVALID>", "WORD", "LINE", "IMAGE", "LINK", "LINK_REF", "INVS_COMMENT", 
		"HTML_COMMENT", "FRONT_MATTER", "CODE_BLOCK_BT", "CODE_BLOCK_TD", "MATH_BLOCK", 
		"TEX_BEG", "HEADER", "SEMARK", "LIST_ITEM", "QUOTE_BLOCK", "DEFINE_BLOCK", 
		"HRULE", "TABLE_DEF", "PIPE", "UNICODE", "ENTITY", "TEX", "HTML", "INMATH", 
		"URL", "LBOLD", "LITALIC", "LSTRIKE", "LSPAN", "LQUOTE", "LAPSTP", "RBOLD", 
		"RITALIC", "RSTRIKE", "RSPAN", "RQUOTE", "RAPSTP", "REF", "TERM", "LBRK", 
		"VWS", "HWS", "CHAR", "ERR", "LBRACE", "HASH", "CHAR_ht", "RBRACE", "CLASS", 
		"ID", "EQ", "QUOTE", "APSTP", "CHAR_sd", "LINK_DEF", "REF_DEF", "RBRACK", 
		"RPAREN", "CHAR_lk", "CHAR_fm", "CHAR_bt", "CHAR_btl", "CHAR_td", "CHAR_tdl", 
		"CHAR_mb", "TEX_END", "CHAR_tb"
	};

	public static final int
		WORD = 1, LINE = 2, IMAGE = 3, LINK = 4, LINK_REF = 5, INVS_COMMENT = 6, 
		HTML_COMMENT = 7, FRONT_MATTER = 8, CODE_BLOCK_BT = 9, CODE_BLOCK_TD = 10, 
		MATH_BLOCK = 11, TEX_BEG = 12, HEADER = 13, SEMARK = 14, LIST_ITEM = 15, 
		QUOTE_BLOCK = 16, DEFINE_BLOCK = 17, HRULE = 18, TABLE_DEF = 19, PIPE = 20, 
		UNICODE = 21, ENTITY = 22, TEX = 23, HTML = 24, INMATH = 25, URL = 26, 
		LBOLD = 27, LITALIC = 28, LSTRIKE = 29, LSPAN = 30, LQUOTE = 31, LAPSTP = 32, 
		RBOLD = 33, RITALIC = 34, RSTRIKE = 35, RSPAN = 36, RQUOTE = 37, RAPSTP = 38, 
		REF = 39, TERM = 40, LBRK = 41, VWS = 42, HWS = 43, CHAR = 44, ERR = 45, 
		LBRACE = 46, HASH = 47, CHAR_ht = 48, RBRACE = 49, CLASS = 50, ID = 51, 
		EQ = 52, QUOTE = 53, APSTP = 54, CHAR_sd = 55, LINK_DEF = 56, REF_DEF = 57, 
		RBRACK = 58, RPAREN = 59, CHAR_lk = 60, CHAR_fm = 61, CHAR_bt = 62, CHAR_btl = 63, 
		CHAR_td = 64, CHAR_tdl = 65, CHAR_mb = 66, TEX_END = 67, CHAR_tb = 68;

	public static final String[] ruleNames = {
		"page", "frontMatter", "header", "hrule", "list", "listItem", "table", 
		"tableDef", "tableRow", "tableCell", "html", "codeBlock", "mathBlock", 
		"texBlock", "quote", "definition", "paragraph", "link", "text", "word", 
		"style", "attrLeft", "attrRight", "content", "terminal", "comment", "unknown"
	};

	public static final int
		page = 1000, frontMatter = 1001, header = 1002, hrule = 1003, list = 1004, 
		listItem = 1005, table = 1006, tableDef = 1007, tableRow = 1008, tableCell = 1009, 
		html = 1010, codeBlock = 1011, mathBlock = 1012, texBlock = 1013, quote = 1014, 
		definition = 1015, paragraph = 1016, link = 1017, text = 1018, word = 1019, 
		style = 1020, attrLeft = 1021, attrRight = 1022, content = 1023, terminal = 1024, 
		comment = 1025, unknown = 1026;

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

					createPathSpec("frontMatter");
						addElement(EType.Rule, true, false, "frontMatter", 1); 
					completePathSpec(); 

					createPathSpec("header");
						addElement(EType.Rule, true, false, "header", 2); 
					completePathSpec(); 

					createPathSpec("paragraph");
						addElement(EType.Rule, true, false, "paragraph", 16); 
					completePathSpec(); 

					createPathSpec("hrule");
						addElement(EType.Rule, true, false, "hrule", 3); 
					completePathSpec(); 

					createPathSpec("comment");
						addElement(EType.Rule, true, false, "comment", 25); 
					completePathSpec(); 

					createPathSpec("list");
						addElement(EType.Rule, true, false, "list", 4); 
					completePathSpec(); 

					createPathSpec("table");
						addElement(EType.Rule, true, false, "table", 6); 
					completePathSpec(); 

					createPathSpec("quote");
						addElement(EType.Rule, true, false, "quote", 14); 
					completePathSpec(); 

					createPathSpec("definition");
						addElement(EType.Rule, true, false, "definition", 15); 
					completePathSpec(); 

					createPathSpec("htmlBlock");
						addElement(EType.Rule, true, false, "html", 10); 
					completePathSpec(); 

					createPathSpec("codeBlock");
						addElement(EType.Rule, true, false, "codeBlock", 11); 
					completePathSpec(); 

					createPathSpec("mathBlock");
						addElement(EType.Rule, true, false, "mathBlock", 12); 
					completePathSpec(); 

					createPathSpec("listItem");
						addElement(EType.Rule, true, false, "listItem", 5); 
					completePathSpec(); 

					createPathSpec("tableRow");
						addElement(EType.Rule, true, false, "tableRow", 8); 
					completePathSpec(); 
	}


	@Override
	public void executeActionBlock(String name) {
		switch (name) {
					case "page":
						page();
						break;
					case "frontMatter":
						frontMatter();
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
					case "quote":
						quote();
						break;
					case "definition":
						definition();
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
		}
	}

	private void page() {
		if (entering()) { doModule(); }
	}

	private void frontMatter() {
		if (entering()) { doFrontMatter(); }
	}

	private void header() {
		if (entering()) { doHeader(); }
	}

	private void paragraph() {
		if (entering()) { doParagraph(); }
	}

	private void hrule() {
		if (entering()) { doHRule(); }
	}

	private void comment() {
		if (entering()) { doComment(); }
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

	private void quote() {
		if (entering()) { doQuote(); }
	}

	private void definition() {
		if (entering()) { doDefinition(); }
	}

	private void htmlBlock() {
		if (entering()) { doHtmlBlock(); }
	}

	private void codeBlock() {
		if (entering()) { doCodeBlock(); }
	}

	private void mathBlock() {
		if (entering()) { doMathBlock(); }
	}



}