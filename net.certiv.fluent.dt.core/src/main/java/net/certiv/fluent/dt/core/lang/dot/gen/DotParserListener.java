// Generated from D:/DevFiles/Eclipse/Tools/Editors/net.certiv.fluent.dt/net.certiv.fluent.dt.core/src/main/java/net/certiv/fluent/dt/core/lang/dot/DotParser.g4 by ANTLR 4.7.2

	package net.certiv.fluent.dt.core.lang.dot.gen;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DotParser}.
 */
public interface DotParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DotParser#graph}.
	 * @param ctx the parse tree
	 */
	void enterGraph(DotParser.GraphContext ctx);
	/**
	 * Exit a parse tree produced by {@link DotParser#graph}.
	 * @param ctx the parse tree
	 */
	void exitGraph(DotParser.GraphContext ctx);
	/**
	 * Enter a parse tree produced by {@link DotParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(DotParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link DotParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(DotParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link DotParser#nodeStmt}.
	 * @param ctx the parse tree
	 */
	void enterNodeStmt(DotParser.NodeStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link DotParser#nodeStmt}.
	 * @param ctx the parse tree
	 */
	void exitNodeStmt(DotParser.NodeStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link DotParser#edgeStmt}.
	 * @param ctx the parse tree
	 */
	void enterEdgeStmt(DotParser.EdgeStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link DotParser#edgeStmt}.
	 * @param ctx the parse tree
	 */
	void exitEdgeStmt(DotParser.EdgeStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link DotParser#attrStmt}.
	 * @param ctx the parse tree
	 */
	void enterAttrStmt(DotParser.AttrStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link DotParser#attrStmt}.
	 * @param ctx the parse tree
	 */
	void exitAttrStmt(DotParser.AttrStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link DotParser#attrList}.
	 * @param ctx the parse tree
	 */
	void enterAttrList(DotParser.AttrListContext ctx);
	/**
	 * Exit a parse tree produced by {@link DotParser#attrList}.
	 * @param ctx the parse tree
	 */
	void exitAttrList(DotParser.AttrListContext ctx);
	/**
	 * Enter a parse tree produced by {@link DotParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(DotParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DotParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(DotParser.AttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DotParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(DotParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link DotParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(DotParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link DotParser#subgraph}.
	 * @param ctx the parse tree
	 */
	void enterSubgraph(DotParser.SubgraphContext ctx);
	/**
	 * Exit a parse tree produced by {@link DotParser#subgraph}.
	 * @param ctx the parse tree
	 */
	void exitSubgraph(DotParser.SubgraphContext ctx);
	/**
	 * Enter a parse tree produced by {@link DotParser#edgeRhs}.
	 * @param ctx the parse tree
	 */
	void enterEdgeRhs(DotParser.EdgeRhsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DotParser#edgeRhs}.
	 * @param ctx the parse tree
	 */
	void exitEdgeRhs(DotParser.EdgeRhsContext ctx);
	/**
	 * Enter a parse tree produced by {@link DotParser#nodeId}.
	 * @param ctx the parse tree
	 */
	void enterNodeId(DotParser.NodeIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link DotParser#nodeId}.
	 * @param ctx the parse tree
	 */
	void exitNodeId(DotParser.NodeIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link DotParser#port}.
	 * @param ctx the parse tree
	 */
	void enterPort(DotParser.PortContext ctx);
	/**
	 * Exit a parse tree produced by {@link DotParser#port}.
	 * @param ctx the parse tree
	 */
	void exitPort(DotParser.PortContext ctx);
	/**
	 * Enter a parse tree produced by {@link DotParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(DotParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link DotParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(DotParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by {@link DotParser#compass}.
	 * @param ctx the parse tree
	 */
	void enterCompass(DotParser.CompassContext ctx);
	/**
	 * Exit a parse tree produced by {@link DotParser#compass}.
	 * @param ctx the parse tree
	 */
	void exitCompass(DotParser.CompassContext ctx);
}