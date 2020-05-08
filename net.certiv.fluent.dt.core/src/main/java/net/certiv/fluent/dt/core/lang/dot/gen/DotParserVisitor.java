// Generated from D:/DevFiles/Eclipse/Tools/Editors/net.certiv.fluent.dt/net.certiv.fluent.dt.core/src/main/java/net/certiv/fluent/dt/core/lang/dot/DotParser.g4 by ANTLR 4.8

	package net.certiv.fluent.dt.core.lang.dot.gen;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DotParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DotParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DotParser#document}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocument(DotParser.DocumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link DotParser#graph}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGraph(DotParser.GraphContext ctx);
	/**
	 * Visit a parse tree produced by {@link DotParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(DotParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link DotParser#nodeStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNodeStmt(DotParser.NodeStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link DotParser#edgeStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEdgeStmt(DotParser.EdgeStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link DotParser#attrStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrStmt(DotParser.AttrStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link DotParser#attrList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrList(DotParser.AttrListContext ctx);
	/**
	 * Visit a parse tree produced by {@link DotParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute(DotParser.AttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DotParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(DotParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link DotParser#subgraph}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubgraph(DotParser.SubgraphContext ctx);
	/**
	 * Visit a parse tree produced by {@link DotParser#edgeRhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEdgeRhs(DotParser.EdgeRhsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DotParser#nodeId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNodeId(DotParser.NodeIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link DotParser#port}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPort(DotParser.PortContext ctx);
	/**
	 * Visit a parse tree produced by {@link DotParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(DotParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by {@link DotParser#compass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompass(DotParser.CompassContext ctx);
}