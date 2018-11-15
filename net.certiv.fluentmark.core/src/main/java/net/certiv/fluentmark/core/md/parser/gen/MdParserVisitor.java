// Generated from D:/DevFiles/Eclipse/DslEditors/net.certiv.fluentmark/net.certiv.fluentmark.core/src/main/java/net/certiv/fluentmark/core/md/parser/MdParser.g4 by ANTLR 4.7.1

	package net.certiv.fluentmark.core.md.parser.gen;
	import net.certiv.fluentmark.core.md.parser.MdToken;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MdParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MdParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MdParser#page}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPage(MdParser.PageContext ctx);
	/**
	 * Visit a parse tree produced by {@link MdParser#part}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPart(MdParser.PartContext ctx);
	/**
	 * Visit a parse tree produced by {@link MdParser#frontMatter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFrontMatter(MdParser.FrontMatterContext ctx);
	/**
	 * Visit a parse tree produced by {@link MdParser#header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeader(MdParser.HeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link MdParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(MdParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MdParser#listItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListItem(MdParser.ListItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link MdParser#content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContent(MdParser.ContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MdParser#word}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWord(MdParser.WordContext ctx);
	/**
	 * Visit a parse tree produced by {@link MdParser#style}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStyle(MdParser.StyleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MdParser#link}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLink(MdParser.LinkContext ctx);
	/**
	 * Visit a parse tree produced by {@link MdParser#attrLeft}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrLeft(MdParser.AttrLeftContext ctx);
	/**
	 * Visit a parse tree produced by {@link MdParser#attrRight}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrRight(MdParser.AttrRightContext ctx);
	/**
	 * Visit a parse tree produced by {@link MdParser#table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable(MdParser.TableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MdParser#tableRow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableRow(MdParser.TableRowContext ctx);
	/**
	 * Visit a parse tree produced by {@link MdParser#tableCell}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableCell(MdParser.TableCellContext ctx);
	/**
	 * Visit a parse tree produced by {@link MdParser#html}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtml(MdParser.HtmlContext ctx);
	/**
	 * Visit a parse tree produced by {@link MdParser#hrule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHrule(MdParser.HruleContext ctx);
	/**
	 * Visit a parse tree produced by {@link MdParser#codeBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCodeBlock(MdParser.CodeBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link MdParser#mathBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMathBlock(MdParser.MathBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link MdParser#quote}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuote(MdParser.QuoteContext ctx);
	/**
	 * Visit a parse tree produced by {@link MdParser#definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinition(MdParser.DefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MdParser#paragraph}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParagraph(MdParser.ParagraphContext ctx);
	/**
	 * Visit a parse tree produced by {@link MdParser#terminal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerminal(MdParser.TerminalContext ctx);
	/**
	 * Visit a parse tree produced by {@link MdParser#comment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComment(MdParser.CommentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MdParser#unknown}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnknown(MdParser.UnknownContext ctx);
}