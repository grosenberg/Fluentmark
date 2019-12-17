// Generated from D:/DevFiles/Eclipse/Tools/Editors/net.certiv.fluent.dt/net.certiv.fluent.dt.core/src/main/java/net/certiv/fluent/dt/core/lang/md/MdParser.g4 by ANTLR 4.7.2
 
	package net.certiv.fluent.dt.core.lang.md.gen;

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
	 * Visit a parse tree produced by {@link MdParser#yaml}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYaml(MdParser.YamlContext ctx);
	/**
	 * Visit a parse tree produced by {@link MdParser#html}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtml(MdParser.HtmlContext ctx);
	/**
	 * Visit a parse tree produced by {@link MdParser#math}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMath(MdParser.MathContext ctx);
	/**
	 * Visit a parse tree produced by {@link MdParser#tex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTex(MdParser.TexContext ctx);
	/**
	 * Visit a parse tree produced by {@link MdParser#uml}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUml(MdParser.UmlContext ctx);
	/**
	 * Visit a parse tree produced by {@link MdParser#code}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCode(MdParser.CodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MdParser#header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeader(MdParser.HeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link MdParser#hrule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHrule(MdParser.HruleContext ctx);
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
	 * Visit a parse tree produced by {@link MdParser#listMark}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListMark(MdParser.ListMarkContext ctx);
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
	 * Visit a parse tree produced by {@link MdParser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine(MdParser.LineContext ctx);
	/**
	 * Visit a parse tree produced by {@link MdParser#link}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLink(MdParser.LinkContext ctx);
	/**
	 * Visit a parse tree produced by {@link MdParser#text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(MdParser.TextContext ctx);
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
	 * Visit a parse tree produced by {@link MdParser#comment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComment(MdParser.CommentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MdParser#lnBlank}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLnBlank(MdParser.LnBlankContext ctx);
	/**
	 * Visit a parse tree produced by {@link MdParser#lnBreak}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLnBreak(MdParser.LnBreakContext ctx);
	/**
	 * Visit a parse tree produced by {@link MdParser#err}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitErr(MdParser.ErrContext ctx);
}