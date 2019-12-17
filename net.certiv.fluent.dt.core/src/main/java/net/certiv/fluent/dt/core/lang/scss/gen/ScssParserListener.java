// Generated from D:/DevFiles/Eclipse/Tools/Editors/net.certiv.fluent.dt/net.certiv.fluent.dt.core/src/main/java/net/certiv/fluent/dt/core/lang/scss/ScssParser.g4 by ANTLR 4.7.2

	package net.certiv.fluent.dt.core.lang.scss.gen;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ScssParser}.
 */
public interface ScssParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ScssParser#stylesheet}.
	 * @param ctx the parse tree
	 */
	void enterStylesheet(ScssParser.StylesheetContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#stylesheet}.
	 * @param ctx the parse tree
	 */
	void exitStylesheet(ScssParser.StylesheetContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScssParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(ScssParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(ScssParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScssParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(ScssParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(ScssParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScssParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(ScssParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(ScssParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScssParser#variableName}.
	 * @param ctx the parse tree
	 */
	void enterVariableName(ScssParser.VariableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#variableName}.
	 * @param ctx the parse tree
	 */
	void exitVariableName(ScssParser.VariableNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScssParser#paramOptionalValue}.
	 * @param ctx the parse tree
	 */
	void enterParamOptionalValue(ScssParser.ParamOptionalValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#paramOptionalValue}.
	 * @param ctx the parse tree
	 */
	void exitParamOptionalValue(ScssParser.ParamOptionalValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScssParser#mixinDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMixinDeclaration(ScssParser.MixinDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#mixinDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMixinDeclaration(ScssParser.MixinDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScssParser#includeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterIncludeDeclaration(ScssParser.IncludeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#includeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitIncludeDeclaration(ScssParser.IncludeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScssParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(ScssParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(ScssParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScssParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void enterFunctionBody(ScssParser.FunctionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void exitFunctionBody(ScssParser.FunctionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScssParser#functionReturn}.
	 * @param ctx the parse tree
	 */
	void enterFunctionReturn(ScssParser.FunctionReturnContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#functionReturn}.
	 * @param ctx the parse tree
	 */
	void exitFunctionReturn(ScssParser.FunctionReturnContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScssParser#functionStatement}.
	 * @param ctx the parse tree
	 */
	void enterFunctionStatement(ScssParser.FunctionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#functionStatement}.
	 * @param ctx the parse tree
	 */
	void exitFunctionStatement(ScssParser.FunctionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScssParser#commandStatement}.
	 * @param ctx the parse tree
	 */
	void enterCommandStatement(ScssParser.CommandStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#commandStatement}.
	 * @param ctx the parse tree
	 */
	void exitCommandStatement(ScssParser.CommandStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScssParser#mathCharacter}.
	 * @param ctx the parse tree
	 */
	void enterMathCharacter(ScssParser.MathCharacterContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#mathCharacter}.
	 * @param ctx the parse tree
	 */
	void exitMathCharacter(ScssParser.MathCharacterContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScssParser#mathStatement}.
	 * @param ctx the parse tree
	 */
	void enterMathStatement(ScssParser.MathStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#mathStatement}.
	 * @param ctx the parse tree
	 */
	void exitMathStatement(ScssParser.MathStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScssParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(ScssParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(ScssParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScssParser#ifDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterIfDeclaration(ScssParser.IfDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#ifDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitIfDeclaration(ScssParser.IfDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScssParser#elseIfStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseIfStatement(ScssParser.ElseIfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#elseIfStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseIfStatement(ScssParser.ElseIfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScssParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseStatement(ScssParser.ElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseStatement(ScssParser.ElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScssParser#conditions}.
	 * @param ctx the parse tree
	 */
	void enterConditions(ScssParser.ConditionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#conditions}.
	 * @param ctx the parse tree
	 */
	void exitConditions(ScssParser.ConditionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScssParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(ScssParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(ScssParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScssParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(ScssParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(ScssParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScssParser#forDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterForDeclaration(ScssParser.ForDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#forDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitForDeclaration(ScssParser.ForDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScssParser#whileDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterWhileDeclaration(ScssParser.WhileDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#whileDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitWhileDeclaration(ScssParser.WhileDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScssParser#eachDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterEachDeclaration(ScssParser.EachDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#eachDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitEachDeclaration(ScssParser.EachDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScssParser#eachValueList}.
	 * @param ctx the parse tree
	 */
	void enterEachValueList(ScssParser.EachValueListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#eachValueList}.
	 * @param ctx the parse tree
	 */
	void exitEachValueList(ScssParser.EachValueListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScssParser#identifierListOrMap}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierListOrMap(ScssParser.IdentifierListOrMapContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#identifierListOrMap}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierListOrMap(ScssParser.IdentifierListOrMapContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScssParser#identifierValue}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierValue(ScssParser.IdentifierValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#identifierValue}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierValue(ScssParser.IdentifierValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScssParser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterImportDeclaration(ScssParser.ImportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitImportDeclaration(ScssParser.ImportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScssParser#referenceUrl}.
	 * @param ctx the parse tree
	 */
	void enterReferenceUrl(ScssParser.ReferenceUrlContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#referenceUrl}.
	 * @param ctx the parse tree
	 */
	void exitReferenceUrl(ScssParser.ReferenceUrlContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScssParser#mediaTypes}.
	 * @param ctx the parse tree
	 */
	void enterMediaTypes(ScssParser.MediaTypesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#mediaTypes}.
	 * @param ctx the parse tree
	 */
	void exitMediaTypes(ScssParser.MediaTypesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScssParser#nested}.
	 * @param ctx the parse tree
	 */
	void enterNested(ScssParser.NestedContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#nested}.
	 * @param ctx the parse tree
	 */
	void exitNested(ScssParser.NestedContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScssParser#nest}.
	 * @param ctx the parse tree
	 */
	void enterNest(ScssParser.NestContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#nest}.
	 * @param ctx the parse tree
	 */
	void exitNest(ScssParser.NestContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScssParser#ruleset}.
	 * @param ctx the parse tree
	 */
	void enterRuleset(ScssParser.RulesetContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#ruleset}.
	 * @param ctx the parse tree
	 */
	void exitRuleset(ScssParser.RulesetContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScssParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(ScssParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(ScssParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScssParser#selectors}.
	 * @param ctx the parse tree
	 */
	void enterSelectors(ScssParser.SelectorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#selectors}.
	 * @param ctx the parse tree
	 */
	void exitSelectors(ScssParser.SelectorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScssParser#selector}.
	 * @param ctx the parse tree
	 */
	void enterSelector(ScssParser.SelectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#selector}.
	 * @param ctx the parse tree
	 */
	void exitSelector(ScssParser.SelectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScssParser#selectorPrefix}.
	 * @param ctx the parse tree
	 */
	void enterSelectorPrefix(ScssParser.SelectorPrefixContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#selectorPrefix}.
	 * @param ctx the parse tree
	 */
	void exitSelectorPrefix(ScssParser.SelectorPrefixContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScssParser#element}.
	 * @param ctx the parse tree
	 */
	void enterElement(ScssParser.ElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#element}.
	 * @param ctx the parse tree
	 */
	void exitElement(ScssParser.ElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScssParser#pseudo}.
	 * @param ctx the parse tree
	 */
	void enterPseudo(ScssParser.PseudoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#pseudo}.
	 * @param ctx the parse tree
	 */
	void exitPseudo(ScssParser.PseudoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScssParser#attrib}.
	 * @param ctx the parse tree
	 */
	void enterAttrib(ScssParser.AttribContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#attrib}.
	 * @param ctx the parse tree
	 */
	void exitAttrib(ScssParser.AttribContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScssParser#attribRelate}.
	 * @param ctx the parse tree
	 */
	void enterAttribRelate(ScssParser.AttribRelateContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#attribRelate}.
	 * @param ctx the parse tree
	 */
	void exitAttribRelate(ScssParser.AttribRelateContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScssParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(ScssParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(ScssParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScssParser#identifierPart}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierPart(ScssParser.IdentifierPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#identifierPart}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierPart(ScssParser.IdentifierPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScssParser#identifierVariableName}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierVariableName(ScssParser.IdentifierVariableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#identifierVariableName}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierVariableName(ScssParser.IdentifierVariableNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScssParser#property}.
	 * @param ctx the parse tree
	 */
	void enterProperty(ScssParser.PropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#property}.
	 * @param ctx the parse tree
	 */
	void exitProperty(ScssParser.PropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScssParser#values}.
	 * @param ctx the parse tree
	 */
	void enterValues(ScssParser.ValuesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#values}.
	 * @param ctx the parse tree
	 */
	void exitValues(ScssParser.ValuesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScssParser#url}.
	 * @param ctx the parse tree
	 */
	void enterUrl(ScssParser.UrlContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#url}.
	 * @param ctx the parse tree
	 */
	void exitUrl(ScssParser.UrlContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScssParser#measurement}.
	 * @param ctx the parse tree
	 */
	void enterMeasurement(ScssParser.MeasurementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#measurement}.
	 * @param ctx the parse tree
	 */
	void exitMeasurement(ScssParser.MeasurementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScssParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(ScssParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScssParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(ScssParser.FunctionCallContext ctx);
}