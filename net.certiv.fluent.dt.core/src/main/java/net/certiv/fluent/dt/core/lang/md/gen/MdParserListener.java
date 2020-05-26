// Generated from D:/DevFiles/Eclipse/Tools/Editors/net.certiv.fluent.dt/net.certiv.fluent.dt.core/src/main/java/net/certiv/fluent/dt/core/lang/md/MdParser.g4 by ANTLR 4.8
 
	package net.certiv.fluent.dt.core.lang.md.gen;

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
	 * Enter a parse tree produced by {@link MdParser#yamlBlock}.
	 * @param ctx the parse tree
	 */
	void enterYamlBlock(MdParser.YamlBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MdParser#yamlBlock}.
	 * @param ctx the parse tree
	 */
	void exitYamlBlock(MdParser.YamlBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link MdParser#htmlBlock}.
	 * @param ctx the parse tree
	 */
	void enterHtmlBlock(MdParser.HtmlBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MdParser#htmlBlock}.
	 * @param ctx the parse tree
	 */
	void exitHtmlBlock(MdParser.HtmlBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link MdParser#dotBlock}.
	 * @param ctx the parse tree
	 */
	void enterDotBlock(MdParser.DotBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MdParser#dotBlock}.
	 * @param ctx the parse tree
	 */
	void exitDotBlock(MdParser.DotBlockContext ctx);
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
	 * Enter a parse tree produced by {@link MdParser#texBlock}.
	 * @param ctx the parse tree
	 */
	void enterTexBlock(MdParser.TexBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MdParser#texBlock}.
	 * @param ctx the parse tree
	 */
	void exitTexBlock(MdParser.TexBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link MdParser#umlBlock}.
	 * @param ctx the parse tree
	 */
	void enterUmlBlock(MdParser.UmlBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MdParser#umlBlock}.
	 * @param ctx the parse tree
	 */
	void exitUmlBlock(MdParser.UmlBlockContext ctx);
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
	 * Enter a parse tree produced by {@link MdParser#listMark}.
	 * @param ctx the parse tree
	 */
	void enterListMark(MdParser.ListMarkContext ctx);
	/**
	 * Exit a parse tree produced by {@link MdParser#listMark}.
	 * @param ctx the parse tree
	 */
	void exitListMark(MdParser.ListMarkContext ctx);
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
	 * Enter a parse tree produced by {@link MdParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(MdParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link MdParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(MdParser.LineContext ctx);
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
	 * Enter a parse tree produced by {@link MdParser#text}.
	 * @param ctx the parse tree
	 */
	void enterText(MdParser.TextContext ctx);
	/**
	 * Exit a parse tree produced by {@link MdParser#text}.
	 * @param ctx the parse tree
	 */
	void exitText(MdParser.TextContext ctx);
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
	 * Enter a parse tree produced by {@link MdParser#lnBlank}.
	 * @param ctx the parse tree
	 */
	void enterLnBlank(MdParser.LnBlankContext ctx);
	/**
	 * Exit a parse tree produced by {@link MdParser#lnBlank}.
	 * @param ctx the parse tree
	 */
	void exitLnBlank(MdParser.LnBlankContext ctx);
	/**
	 * Enter a parse tree produced by {@link MdParser#lnBreak}.
	 * @param ctx the parse tree
	 */
	void enterLnBreak(MdParser.LnBreakContext ctx);
	/**
	 * Exit a parse tree produced by {@link MdParser#lnBreak}.
	 * @param ctx the parse tree
	 */
	void exitLnBreak(MdParser.LnBreakContext ctx);
	/**
	 * Enter a parse tree produced by {@link MdParser#err}.
	 * @param ctx the parse tree
	 */
	void enterErr(MdParser.ErrContext ctx);
	/**
	 * Exit a parse tree produced by {@link MdParser#err}.
	 * @param ctx the parse tree
	 */
	void exitErr(MdParser.ErrContext ctx);
}