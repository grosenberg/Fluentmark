//
// Generated from D:\DevFiles\Eclipse\Tools\Editors\net.certiv.fluent.dt\net.certiv.fluent.dt.core\src\main\java\net\certiv\fluent\dt\core\lang\md\Structure.xv
// by XVisitor 4.7
//
package net.certiv.fluent.dt.core.lang.md.gen;
	import  net.certiv.fluent.dt.core.lang.md.StructureBuilder;
	import net.certiv.fluent.dt.core.model.ModelType;

import java.util.List;
import org.antlr.v4.runtime.tree.ParseTree;
import net.certiv.antlr.runtime.xvisitor.Processor;
import net.certiv.antlr.runtime.xvisitor.xpath.EType;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class StructureVisitor extends StructureBuilder {

	public static final String[] tokenNames = {
		"<INVALID>", "WORD", "HIDN_COMMENT", "HTML_COMMENT", "META", "TICS", "TILDES", 
		"MATH_MARK", "TEX_BEG", "UML_BEG", "LIST_ITEM", "TABLE_DEF", "DEFINITION", 
		"HRULE", "DASHES", "DOTS", "HASHES", "EQUALS", "QUOTES", "UNICODE", "ENTITY", 
		"TEX", "HTML", "INMATH", "URL", "LBOLD", "LITALIC", "LSTRIKE", "LSPAN", 
		"LDQUOTE", "LSQUOTE", "RBOLD", "RITALIC", "RSTRIKE", "RSPAN", "RDQUOTE", 
		"RSQUOTE", "LSTYLE", "LINK", "LREF", "LURL", "LDEF", "HASH", "PIPE", "LN_BLANK", 
		"LN_BREAK", "VWS", "HWS", "CHAR", "ERR", "RSTYLE", "CLASS", "ID", "EQ", 
		"QUOTE", "MARK", "CHAR_sd", "LINK_MARK", "REF_MARK", "DEF_MARK", "RBRACK", 
		"RPAREN", "CHAR_l", "WORD_b", "WORD_t", "WORD_y", "WORD_m", "TEX_END", 
		"WORD_x", "UML_END", "WORD_u"
	};

	public static final int
		WORD = 1, HIDN_COMMENT = 2, HTML_COMMENT = 3, META = 4, TICS = 5, TILDES = 6, 
		MATH_MARK = 7, TEX_BEG = 8, UML_BEG = 9, LIST_ITEM = 10, TABLE_DEF = 11, 
		DEFINITION = 12, HRULE = 13, DASHES = 14, DOTS = 15, HASHES = 16, EQUALS = 17, 
		QUOTES = 18, UNICODE = 19, ENTITY = 20, TEX = 21, HTML = 22, INMATH = 23, 
		URL = 24, LBOLD = 25, LITALIC = 26, LSTRIKE = 27, LSPAN = 28, LDQUOTE = 29, 
		LSQUOTE = 30, RBOLD = 31, RITALIC = 32, RSTRIKE = 33, RSPAN = 34, RDQUOTE = 35, 
		RSQUOTE = 36, LSTYLE = 37, LINK = 38, LREF = 39, LURL = 40, LDEF = 41, 
		HASH = 42, PIPE = 43, LN_BLANK = 44, LN_BREAK = 45, VWS = 46, HWS = 47, 
		CHAR = 48, ERR = 49, RSTYLE = 50, CLASS = 51, ID = 52, EQ = 53, QUOTE = 54, 
		MARK = 55, CHAR_sd = 56, LINK_MARK = 57, REF_MARK = 58, DEF_MARK = 59, 
		RBRACK = 60, RPAREN = 61, CHAR_l = 62, WORD_b = 63, WORD_t = 64, WORD_y = 65, 
		WORD_m = 66, TEX_END = 67, WORD_x = 68, UML_END = 69, WORD_u = 70;

	public static final String[] ruleNames = {
		"page", "metaBlock", "header", "hrule", "list", "listItem", "table", "tableDef", 
		"tableRow", "tableCell", "htmlBlock", "codeBlock", "mathBlock", "texBlock", 
		"umlBlock", "quote", "definition", "paragraph", "content", "text", "line", 
		"lnBlank", "lnBreak", "word", "link", "style", "attrLeft", "attrRight", 
		"comment", "unknown"
	};

	public static final int
		page = 1000, metaBlock = 1001, header = 1002, hrule = 1003, list = 1004, 
		listItem = 1005, table = 1006, tableDef = 1007, tableRow = 1008, tableCell = 1009, 
		htmlBlock = 1010, codeBlock = 1011, mathBlock = 1012, texBlock = 1013, 
		umlBlock = 1014, quote = 1015, definition = 1016, paragraph = 1017, content = 1018, 
		text = 1019, line = 1020, lnBlank = 1021, lnBreak = 1022, word = 1023, 
		link = 1024, style = 1025, attrLeft = 1026, attrRight = 1027, comment = 1028, 
		unknown = 1029;

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

					createPathSpec("metaMatter");
						addElement(EType.Rule, true, false, "metaBlock", 1); 
					completePathSpec(); 

					createPathSpec("header");
						addElement(EType.Rule, true, false, "header", 2); 
					completePathSpec(); 

					createPathSpec("paragraph");
						addElement(EType.Rule, true, false, "paragraph", 17); 
					completePathSpec(); 

					createPathSpec("hrule");
						addElement(EType.Rule, true, false, "hrule", 3); 
					completePathSpec(); 

					createPathSpec("comment");
						addElement(EType.Rule, true, false, "comment", 28); 
					completePathSpec(); 

					createPathSpec("list");
						addElement(EType.Rule, true, false, "list", 4); 
					completePathSpec(); 

					createPathSpec("table");
						addElement(EType.Rule, true, false, "table", 6); 
					completePathSpec(); 

					createPathSpec("quote");
						addElement(EType.Rule, true, false, "quote", 15); 
					completePathSpec(); 

					createPathSpec("definition");
						addElement(EType.Rule, true, false, "definition", 16); 
					completePathSpec(); 

					createPathSpec("htmlBlock");
						addElement(EType.Rule, true, false, "htmlBlock", 10); 
					completePathSpec(); 

					createPathSpec("codeBlock");
						addElement(EType.Rule, true, false, "codeBlock", 11); 
					completePathSpec(); 

					createPathSpec("mathBlock");
						addElement(EType.Rule, true, false, "mathBlock", 12); 
					completePathSpec(); 

					createPathSpec("texBlock");
						addElement(EType.Rule, true, false, "texBlock", 13); 
					completePathSpec(); 

					createPathSpec("umlBlock");
						addElement(EType.Rule, true, false, "umlBlock", 14); 
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
					case "metaMatter":
						metaMatter();
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

	private void metaMatter() {
		if (entering()) { doStatement(ModelType.MetaMatter); }
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