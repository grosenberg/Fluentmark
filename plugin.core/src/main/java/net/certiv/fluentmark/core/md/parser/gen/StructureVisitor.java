//
// Generated from D:\DevFiles\Eclipse\Fluentmark\net.certiv.fluentmark\plugin.core\src\main\java\net\certiv\fluentmark\core\md\parser\Structure.xv
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
		"<INVALID>", "WORD", "LINE", "ML_COMMENT", "HTML_COMMENT", "FRONT_MATTER", 
		"CODE_BLOCK_BT", "CODE_BLOCK_TD", "MATH_BLOCK", "HEADER", "SEMARK", "LIST_ITEM", 
		"QUOTE_BLOCK", "DEFINE_BLOCK", "HRULE", "HTML", "TABLE_DEF", "UNICODE", 
		"ENTITY", "IMAGE", "LBRACK", "RBRACK", "LBRACE", "RBRACE", "LPAREN", "RPAREN", 
		"PIPE", "QUOTE", "LBOLD", "LITALIC", "LSTRIKE", "RBOLD", "RITALIC", "RSTRIKE", 
		"INCODE", "INMATH", "TERM", "VWS", "HWS", "CHAR", "ERR", "HASH", "CHAR_ht", 
		"CLASS", "ID", "EQ", "TIC", "CHAR_sd", "CHAR_ld", "CHAR_fm", "CHAR_bt", 
		"CHAR_td", "CHAR_mb"
	};

	public static final int
		WORD = 1, LINE = 2, ML_COMMENT = 3, HTML_COMMENT = 4, FRONT_MATTER = 5, 
		CODE_BLOCK_BT = 6, CODE_BLOCK_TD = 7, MATH_BLOCK = 8, HEADER = 9, SEMARK = 10, 
		LIST_ITEM = 11, QUOTE_BLOCK = 12, DEFINE_BLOCK = 13, HRULE = 14, HTML = 15, 
		TABLE_DEF = 16, UNICODE = 17, ENTITY = 18, IMAGE = 19, LBRACK = 20, RBRACK = 21, 
		LBRACE = 22, RBRACE = 23, LPAREN = 24, RPAREN = 25, PIPE = 26, QUOTE = 27, 
		LBOLD = 28, LITALIC = 29, LSTRIKE = 30, RBOLD = 31, RITALIC = 32, RSTRIKE = 33, 
		INCODE = 34, INMATH = 35, TERM = 36, VWS = 37, HWS = 38, CHAR = 39, ERR = 40, 
		HASH = 41, CHAR_ht = 42, CLASS = 43, ID = 44, EQ = 45, TIC = 46, CHAR_sd = 47, 
		CHAR_ld = 48, CHAR_fm = 49, CHAR_bt = 50, CHAR_td = 51, CHAR_mb = 52;

	public static final String[] ruleNames = {
		"page", "part", "frontMatter", "header", "list", "listItem", "content", 
		"word", "style", "link", "attrLeft", "attrRight", "table", "tableRow", 
		"tableCell", "html", "hrule", "codeBlock", "mathBlock", "quote", "definition", 
		"paragraph", "terminal", "comment", "unknown"
	};

	public static final int
		page = 1000, part = 1001, frontMatter = 1002, header = 1003, list = 1004, 
		listItem = 1005, content = 1006, word = 1007, style = 1008, link = 1009, 
		attrLeft = 1010, attrRight = 1011, table = 1012, tableRow = 1013, tableCell = 1014, 
		html = 1015, hrule = 1016, codeBlock = 1017, mathBlock = 1018, quote = 1019, 
		definition = 1020, paragraph = 1021, terminal = 1022, comment = 1023, 
		unknown = 1024;

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
						addElement(EType.Rule, true, false, "frontMatter", 2); 
					completePathSpec(); 

					createPathSpec("header");
						addElement(EType.Rule, true, false, "header", 3); 
					completePathSpec(); 

					createPathSpec("paragraph");
						addElement(EType.Rule, true, false, "paragraph", 21); 
					completePathSpec(); 

					createPathSpec("hrule");
						addElement(EType.Rule, true, false, "hrule", 16); 
					completePathSpec(); 

					createPathSpec("comment");
						addElement(EType.Rule, true, false, "comment", 23); 
					completePathSpec(); 

					createPathSpec("list");
						addElement(EType.Rule, true, false, "list", 4); 
					completePathSpec(); 

					createPathSpec("table");
						addElement(EType.Rule, true, false, "table", 12); 
					completePathSpec(); 

					createPathSpec("quote");
						addElement(EType.Rule, true, false, "quote", 19); 
					completePathSpec(); 

					createPathSpec("definition");
						addElement(EType.Rule, true, false, "definition", 20); 
					completePathSpec(); 

					createPathSpec("htmlBlock");
						addElement(EType.Rule, true, false, "html", 15); 
					completePathSpec(); 

					createPathSpec("codeBlock");
						addElement(EType.Rule, true, false, "codeBlock", 17); 
					completePathSpec(); 

					createPathSpec("mathBlock");
						addElement(EType.Rule, true, false, "mathBlock", 18); 
					completePathSpec(); 

					createPathSpec("listItem");
						addElement(EType.Rule, true, false, "listItem", 5); 
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