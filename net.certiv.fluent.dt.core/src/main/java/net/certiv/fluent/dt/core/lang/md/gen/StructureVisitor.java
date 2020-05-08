//
// Generated from D:\DevFiles\EclipseTest\Test\src\net\certiv\fluent\dt\core\lang\md\Structure.xv
// by XVisitor 4.7
//
package net.certiv.fluent.dt.core.lang.md.gen;

import static net.certiv.fluent.dt.core.lang.md.model.SpecializationType.*;

import org.antlr.v4.runtime.tree.ParseTree;

import net.certiv.antlr.runtime.xvisitor.xpath.EType;
import net.certiv.fluent.dt.core.lang.md.model.StructureBuilder;

@SuppressWarnings({ "all", "warnings", "unchecked", "unused", "cast" })
public class StructureVisitor extends StructureBuilder {

	public static final String[] tokenNames = { "<INVALID>", "WORD", "RBOLD", "RITALIC", "RSTRIKE", "RSPAN", "RDSPAN",
			"RDQUOTE", "RSQUOTE", "COMMENT", "URL", "LSTYLE", "LBRACK", "IMAGE", "LINK_SEP", "REF_SEP", "DEF_SEP",
			"RBRACK", "RPAREN", "CODE_BEG", "CODE_SPAN", "YAML_BLOCK", "HTML_BLOCK", "MATH_BLOCK", "TEX_BLOCK",
			"UML_BLOCK", "UNICODE", "ENTITY", "TEX", "HTML", "MATH_SPAN", "TABLE_DEF", "PIPE", "HRULE", "HASHES",
			"DASHES", "EQUALS", "COLON", "UNORDERED_MARK", "NUMBER_MARK", "PAREN_MARK", "UALPHA_MARK", "LALPHA_MARK",
			"LBOLD", "LITALIC", "LSTRIKE", "LSPAN", "LDSPAN", "LDQUOTE", "LSQUOTE", "LINE_BLANK", "LINE_BREAK",
			"LINE_QUOTE", "LINE_DENT", "VWS", "HWS", "CHAR", "ERR", "HASH", "CHAR_h", "RSTYLE", "CLASS", "ID", "EQ",
			"QUOTE", "MARK", "CHAR_s", "CODE_END", "CHAR_b", "CHR_t" };

	public static final int WORD = 1, RBOLD = 2, RITALIC = 3, RSTRIKE = 4, RSPAN = 5, RDSPAN = 6, RDQUOTE = 7,
			RSQUOTE = 8, COMMENT = 9, URL = 10, LSTYLE = 11, LBRACK = 12, IMAGE = 13, LINK_SEP = 14, REF_SEP = 15,
			DEF_SEP = 16, RBRACK = 17, RPAREN = 18, CODE_BEG = 19, CODE_SPAN = 20, YAML_BLOCK = 21, HTML_BLOCK = 22,
			MATH_BLOCK = 23, TEX_BLOCK = 24, UML_BLOCK = 25, UNICODE = 26, ENTITY = 27, TEX = 28, HTML = 29,
			MATH_SPAN = 30, TABLE_DEF = 31, PIPE = 32, HRULE = 33, HASHES = 34, DASHES = 35, EQUALS = 36, COLON = 37,
			UNORDERED_MARK = 38, NUMBER_MARK = 39, PAREN_MARK = 40, UALPHA_MARK = 41, LALPHA_MARK = 42, LBOLD = 43,
			LITALIC = 44, LSTRIKE = 45, LSPAN = 46, LDSPAN = 47, LDQUOTE = 48, LSQUOTE = 49, LINE_BLANK = 50,
			LINE_BREAK = 51, LINE_QUOTE = 52, LINE_DENT = 53, VWS = 54, HWS = 55, CHAR = 56, ERR = 57, HASH = 58,
			CHAR_h = 59, RSTYLE = 60, CLASS = 61, ID = 62, EQ = 63, QUOTE = 64, MARK = 65, CHAR_s = 66, CODE_END = 67,
			CHAR_b = 68, CHR_t = 69;

	public static final String[] ruleNames = { "page", "yamlBlock", "htmlBlock", "mathBlock", "texBlock", "umlBlock",
			"codeBlock", "header", "hrule", "table", "tableRow", "list", "listItem", "listMark", "definition",
			"paragraph", "line", "link", "text", "word", "style", "attrLeft", "attrRight", "comment", "lnBlank",
			"lnBreak", "err" };

	public static final int page = 1000, yamlBlock = 1001, htmlBlock = 1002, mathBlock = 1003, texBlock = 1004,
			umlBlock = 1005, codeBlock = 1006, header = 1007, hrule = 1008, table = 1009, tableRow = 1010, list = 1011,
			listItem = 1012, listMark = 1013, definition = 1014, paragraph = 1015, line = 1016, link = 1017,
			text = 1018, word = 1019, style = 1020, attrLeft = 1021, attrRight = 1022, comment = 1023, lnBlank = 1024,
			lnBreak = 1025, err = 1026;

	public StructureVisitor(ParseTree tree) {
		super(tree);
		init();
	}

	/**
	 * Entry point for finding all matches of the defined XPaths in the parse tree
	 */
	@Override
	public void findAll() {
		super.findAll();
	}

	/**
	 * Entry point for finding all matches of a set of one or more named XPaths in
	 * the parse tree. The name of an XPath is the rulename used in the tree grammar
	 * to define the XPath.
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

	@Override
	protected String[] getTokenNames() {
		return tokenNames;
	}

	@Override
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

		createPathSpec("word");
		addElement(EType.Rule, true, false, "word", 19);
		completePathSpec();

		createPathSpec("attrL");
		addElement(EType.Rule, true, false, "attrLeft", 21);
		completePathSpec();

		createPathSpec("attrR");
		addElement(EType.Rule, true, false, "attrRight", 22);
		completePathSpec();

		createPathSpec("comment");
		addElement(EType.Rule, true, false, "comment", 23);
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
			case "word":
				word();
				break;
			case "attrL":
				attrL();
				break;
			case "attrR":
				attrR();
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
		if (entering()) {
			doModule();
		}
	}

	private void header() {
		if (entering()) {
			doHeader();
		}
	}

	private void hrule() {
		if (entering()) {
			doType(HRule);
		}
	}

	private void comment() {
		if (entering()) {
			doType(Comment);
		}
	}

	private void yamlBlock() {
		if (entering()) {
			doType(YamlBlock);
		}
	}

	private void htmlBlock() {
		if (entering()) {
			doType(HtmlBlock);
		}
	}

	private void codeBlock() {
		if (entering()) {
			doType(CodeBlock);
		}
	}

	private void mathBlock() {
		if (entering()) {
			doType(MathBlock);
		}
	}

	private void texBlock() {
		if (entering()) {
			doType(TexBlock);
		}
	}

	private void umlBlock() {
		if (entering()) {
			doType(UmlBlock);
		}
	}

	private void definition() {
		if (entering()) {
			doType(Definition);
		}
	}

	private void table() {
		if (entering()) {
			doType(Table);
		}
	}

	private void paragraph() {
		if (entering()) {
			doStatement(Paragraph);
		}
		if (exiting()) {
			endBlock();
		}
	}

	private void word() {
		if (entering()) {
			doWord();
		}
	}

	private void attrL() {
		if (entering()) {
			doAttrL();
		}
	}

	private void attrR() {
		if (entering()) {
			doAttrR();
		}
	}

	private void list() {
		if (entering()) {
			doList();
		}
		if (exiting()) {
			endBlock();
		}
	}

	private void listItem() {
		if (entering()) {
			doListItem();
		}
	}

}
