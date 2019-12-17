// Generated from D:/DevFiles/Eclipse/Tools/Editors/net.certiv.fluent.dt/net.certiv.fluent.dt.core/src/main/java/net/certiv/fluent/dt/core/lang/scss/ScssParser.g4 by ANTLR 4.7.2

	package net.certiv.fluent.dt.core.lang.scss.gen;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ScssParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ScssParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ScssParser#stylesheet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStylesheet(ScssParser.StylesheetContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScssParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(ScssParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScssParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(ScssParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScssParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(ScssParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScssParser#variableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableName(ScssParser.VariableNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScssParser#paramOptionalValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamOptionalValue(ScssParser.ParamOptionalValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScssParser#mixinDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMixinDeclaration(ScssParser.MixinDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScssParser#includeDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncludeDeclaration(ScssParser.IncludeDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScssParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(ScssParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScssParser#functionBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionBody(ScssParser.FunctionBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScssParser#functionReturn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionReturn(ScssParser.FunctionReturnContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScssParser#functionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionStatement(ScssParser.FunctionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScssParser#commandStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommandStatement(ScssParser.CommandStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScssParser#mathCharacter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMathCharacter(ScssParser.MathCharacterContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScssParser#mathStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMathStatement(ScssParser.MathStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScssParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(ScssParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScssParser#ifDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfDeclaration(ScssParser.IfDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScssParser#elseIfStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseIfStatement(ScssParser.ElseIfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScssParser#elseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseStatement(ScssParser.ElseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScssParser#conditions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditions(ScssParser.ConditionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScssParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(ScssParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScssParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(ScssParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScssParser#forDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForDeclaration(ScssParser.ForDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScssParser#whileDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileDeclaration(ScssParser.WhileDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScssParser#eachDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEachDeclaration(ScssParser.EachDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScssParser#eachValueList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEachValueList(ScssParser.EachValueListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScssParser#identifierListOrMap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierListOrMap(ScssParser.IdentifierListOrMapContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScssParser#identifierValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierValue(ScssParser.IdentifierValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScssParser#importDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportDeclaration(ScssParser.ImportDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScssParser#referenceUrl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenceUrl(ScssParser.ReferenceUrlContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScssParser#mediaTypes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMediaTypes(ScssParser.MediaTypesContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScssParser#nested}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNested(ScssParser.NestedContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScssParser#nest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNest(ScssParser.NestContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScssParser#ruleset}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleset(ScssParser.RulesetContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScssParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(ScssParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScssParser#selectors}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectors(ScssParser.SelectorsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScssParser#selector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelector(ScssParser.SelectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScssParser#selectorPrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectorPrefix(ScssParser.SelectorPrefixContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScssParser#element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElement(ScssParser.ElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScssParser#pseudo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPseudo(ScssParser.PseudoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScssParser#attrib}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrib(ScssParser.AttribContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScssParser#attribRelate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribRelate(ScssParser.AttribRelateContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScssParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(ScssParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScssParser#identifierPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierPart(ScssParser.IdentifierPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScssParser#identifierVariableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierVariableName(ScssParser.IdentifierVariableNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScssParser#property}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperty(ScssParser.PropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScssParser#values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValues(ScssParser.ValuesContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScssParser#url}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUrl(ScssParser.UrlContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScssParser#measurement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMeasurement(ScssParser.MeasurementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScssParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(ScssParser.FunctionCallContext ctx);
}