// Generated from D:/DevFiles/Eclipse/DslEditors/net.certiv.fluentmark/net.certiv.fluentmark.core/src/main/java/net/certiv/fluentmark/core/md/parser/MdParser.g4 by ANTLR 4.7.1

	package net.certiv.fluentmark.core.md.parser.gen;
	import net.certiv.fluentmark.core.md.parser.MdToken;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MdParser}.
 */
public interface MdParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MdParser#page}.
	 * @param ctx the parse tree
	 */
	void enterPage(MdParser.PageContext ctx);
	/**
	 * Exit a parse tree produced by {@link MdParser#page}.
	 * @param ctx the parse tree
	 */
	void exitPage(MdParser.PageContext ctx);
	/**
	 * Enter a parse tree produced by {@link MdParser#part}.
	 * @param ctx the parse tree
	 */
	void enterPart(MdParser.PartContext ctx);
	/**
	 * Exit a parse tree produced by {@link MdParser#part}.
	 * @param ctx the parse tree
	 */
	void exitPart(MdParser.PartContext ctx);
	/**
	 * Enter a parse tree produced by {@link MdParser#frontMatter}.
	 * @param ctx the parse tree
	 */
	void enterFrontMatter(MdParser.FrontMatterContext ctx);
	/**
	 * Exit a parse tree produced by {@link MdParser#frontMatter}.
	 * @param ctx the parse tree
	 */
	void exitFrontMatter(MdParser.FrontMatterContext ctx);
	/**
	 * Enter a parse tree produced by {@link MdParser#header}.
	 * @param ctx the parse tree
	 */
	void enterHeader(MdParser.HeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link MdParser#header}.
	 * @param ctx the parse tree
	 */
	void exitHeader(MdParser.HeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link MdParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(MdParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MdParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(MdParser.ListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MdParser#listItem}.
	 * @param ctx the parse tree
	 */
	void enterListItem(MdParser.ListItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link MdParser#listItem}.
	 * @param ctx the parse tree
	 */
	void exitListItem(MdParser.ListItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link MdParser#content}.
	 * @param ctx the parse tree
	 */
	void enterContent(MdParser.ContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MdParser#content}.
	 * @param ctx the parse tree
	 */
	void exitContent(MdParser.ContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MdParser#word}.
	 * @param ctx the parse tree
	 */
	void enterWord(MdParser.WordContext ctx);
	/**
	 * Exit a parse tree produced by {@link MdParser#word}.
	 * @param ctx the parse tree
	 */
	void exitWord(MdParser.WordContext ctx);
	/**
	 * Enter a parse tree produced by {@link MdParser#style}.
	 * @param ctx the parse tree
	 */
	void enterStyle(MdParser.StyleContext ctx);
	/**
	 * Exit a parse tree produced by {@link MdParser#style}.
	 * @param ctx the parse tree
	 */
	void exitStyle(MdParser.StyleContext ctx);
	/**
	 * Enter a parse tree produced by {@link MdParser#link}.
	 * @param ctx the parse tree
	 */
	void enterLink(MdParser.LinkContext ctx);
	/**
	 * Exit a parse tree produced by {@link MdParser#link}.
	 * @param ctx the parse tree
	 */
	void exitLink(MdParser.LinkContext ctx);
	/**
	 * Enter a parse tree produced by {@link MdParser#attrLeft}.
	 * @param ctx the parse tree
	 */
	void enterAttrLeft(MdParser.AttrLeftContext ctx);
	/**
	 * Exit a parse tree produced by {@link MdParser#attrLeft}.
	 * @param ctx the parse tree
	 */
	void exitAttrLeft(MdParser.AttrLeftContext ctx);
	/**
	 * Enter a parse tree produced by {@link MdParser#attrRight}.
	 * @param ctx the parse tree
	 */
	void enterAttrRight(MdParser.AttrRightContext ctx);
	/**
	 * Exit a parse tree produced by {@link MdParser#attrRight}.
	 * @param ctx the parse tree
	 */
	void exitAttrRight(MdParser.AttrRightContext ctx);
	/**
	 * Enter a parse tree produced by {@link MdParser#table}.
	 * @param ctx the parse tree
	 */
	void enterTable(MdParser.TableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MdParser#table}.
	 * @param ctx the parse tree
	 */
	void exitTable(MdParser.TableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MdParser#tableRow}.
	 * @param ctx the parse tree
	 */
	void enterTableRow(MdParser.TableRowContext ctx);
	/**
	 * Exit a parse tree produced by {@link MdParser#tableRow}.
	 * @param ctx the parse tree
	 */
	void exitTableRow(MdParser.TableRowContext ctx);
	/**
	 * Enter a parse tree produced by {@link MdParser#tableCell}.
	 * @param ctx the parse tree
	 */
	void enterTableCell(MdParser.TableCellContext ctx);
	/**
	 * Exit a parse tree produced by {@link MdParser#tableCell}.
	 * @param ctx the parse tree
	 */
	void exitTableCell(MdParser.TableCellContext ctx);
	/**
	 * Enter a parse tree produced by {@link MdParser#html}.
	 * @param ctx the parse tree
	 */
	void enterHtml(MdParser.HtmlContext ctx);
	/**
	 * Exit a parse tree produced by {@link MdParser#html}.
	 * @param ctx the parse tree
	 */
	void exitHtml(MdParser.HtmlContext ctx);
	/**
	 * Enter a parse tree produced by {@link MdParser#hrule}.
	 * @param ctx the parse tree
	 */
	void enterHrule(MdParser.HruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link MdParser#hrule}.
	 * @param ctx the parse tree
	 */
	void exitHrule(MdParser.HruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link MdParser#codeBlock}.
	 * @param ctx the parse tree
	 */
	void enterCodeBlock(MdParser.CodeBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MdParser#codeBlock}.
	 * @param ctx the parse tree
	 */
	void exitCodeBlock(MdParser.CodeBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link MdParser#mathBlock}.
	 * @param ctx the parse tree
	 */
	void enterMathBlock(MdParser.MathBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MdParser#mathBlock}.
	 * @param ctx the parse tree
	 */
	void exitMathBlock(MdParser.MathBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link MdParser#quote}.
	 * @param ctx the parse tree
	 */
	void enterQuote(MdParser.QuoteContext ctx);
	/**
	 * Exit a parse tree produced by {@link MdParser#quote}.
	 * @param ctx the parse tree
	 */
	void exitQuote(MdParser.QuoteContext ctx);
	/**
	 * Enter a parse tree produced by {@link MdParser#definition}.
	 * @param ctx the parse tree
	 */
	void enterDefinition(MdParser.DefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MdParser#definition}.
	 * @param ctx the parse tree
	 */
	void exitDefinition(MdParser.DefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MdParser#paragraph}.
	 * @param ctx the parse tree
	 */
	void enterParagraph(MdParser.ParagraphContext ctx);
	/**
	 * Exit a parse tree produced by {@link MdParser#paragraph}.
	 * @param ctx the parse tree
	 */
	void exitParagraph(MdParser.ParagraphContext ctx);
	/**
	 * Enter a parse tree produced by {@link MdParser#terminal}.
	 * @param ctx the parse tree
	 */
	void enterTerminal(MdParser.TerminalContext ctx);
	/**
	 * Exit a parse tree produced by {@link MdParser#terminal}.
	 * @param ctx the parse tree
	 */
	void exitTerminal(MdParser.TerminalContext ctx);
	/**
	 * Enter a parse tree produced by {@link MdParser#comment}.
	 * @param ctx the parse tree
	 */
	void enterComment(MdParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MdParser#comment}.
	 * @param ctx the parse tree
	 */
	void exitComment(MdParser.CommentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MdParser#unknown}.
	 * @param ctx the parse tree
	 */
	void enterUnknown(MdParser.UnknownContext ctx);
	/**
	 * Exit a parse tree produced by {@link MdParser#unknown}.
	 * @param ctx the parse tree
	 */
	void exitUnknown(MdParser.UnknownContext ctx);
}