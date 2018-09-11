// Generated from D:/DevFiles/Eclipse/Fluentmark/net.certiv.fluentmark/plugin/src/net/certiv/fluentmark/dot/DotParser.g4 by ANTLR 4.7.1

	package net.certiv.fluentmark.dot.gen;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DotParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMA=1, SEMI=2, LBRACE=3, RBRACE=4, LBRACK=5, RBRACK=6, COLON=7, EQ=8, 
		DIRECTED=9, UNDIRECTED=10, STRICT=11, DIGRAPH=12, GRAPH=13, NODE=14, EDGE=15, 
		SUBGRAPH=16, N=17, NE=18, E=19, SE=20, S=21, SW=22, W=23, NW=24, C=25, 
		ID=26, NUMERAL=27, STRING=28, ALPHA=29, DIGIT=30, QUOTED_STRING=31, HTML_STRING=32, 
		ML_COMMENT=33, SL_COMMENT=34, WS=35, ERR=36;
	public static final int
		RULE_graph = 0, RULE_stmt = 1, RULE_nodeStmt = 2, RULE_edgeStmt = 3, RULE_attrStmt = 4, 
		RULE_attrList = 5, RULE_attribute = 6, RULE_subgraph = 7, RULE_edgeRhs = 8, 
		RULE_nodeId = 9, RULE_port = 10, RULE_id = 11, RULE_compass = 12;
	public static final String[] ruleNames = {
		"graph", "stmt", "nodeStmt", "edgeStmt", "attrStmt", "attrList", "attribute", 
		"subgraph", "edgeRhs", "nodeId", "port", "id", "compass"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "COMMA", "SEMI", "LBRACE", "RBRACE", "LBRACK", "RBRACK", "COLON", 
		"EQ", "DIRECTED", "UNDIRECTED", "STRICT", "DIGRAPH", "GRAPH", "NODE", 
		"EDGE", "SUBGRAPH", "N", "NE", "E", "SE", "S", "SW", "W", "NW", "C", "ID", 
		"NUMERAL", "STRING", "ALPHA", "DIGIT", "QUOTED_STRING", "HTML_STRING", 
		"ML_COMMENT", "SL_COMMENT", "WS", "ERR"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "DotParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DotParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class GraphContext extends ParserRuleContext {
		public Token gtype;
		public TerminalNode LBRACE() { return getToken(DotParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(DotParser.RBRACE, 0); }
		public TerminalNode GRAPH() { return getToken(DotParser.GRAPH, 0); }
		public TerminalNode DIGRAPH() { return getToken(DotParser.DIGRAPH, 0); }
		public TerminalNode STRICT() { return getToken(DotParser.STRICT, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public GraphContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_graph; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DotParserListener ) ((DotParserListener)listener).enterGraph(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DotParserListener ) ((DotParserListener)listener).exitGraph(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DotParserVisitor ) return ((DotParserVisitor<? extends T>)visitor).visitGraph(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GraphContext graph() throws RecognitionException {
		GraphContext _localctx = new GraphContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_graph);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRICT) {
				{
				setState(26);
				match(STRICT);
				}
			}

			setState(29);
			((GraphContext)_localctx).gtype = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==DIGRAPH || _la==GRAPH) ) {
				((GraphContext)_localctx).gtype = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << N) | (1L << NE) | (1L << E) | (1L << SE) | (1L << S) | (1L << SW) | (1L << W) | (1L << NW) | (1L << C) | (1L << ID))) != 0)) {
				{
				setState(30);
				id();
				}
			}

			setState(33);
			match(LBRACE);
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GRAPH) | (1L << NODE) | (1L << EDGE) | (1L << SUBGRAPH) | (1L << N) | (1L << NE) | (1L << E) | (1L << SE) | (1L << S) | (1L << SW) | (1L << W) | (1L << NW) | (1L << C) | (1L << ID))) != 0)) {
				{
				{
				setState(34);
				stmt();
				}
				}
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(40);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public NodeStmtContext nodeStmt() {
			return getRuleContext(NodeStmtContext.class,0);
		}
		public EdgeStmtContext edgeStmt() {
			return getRuleContext(EdgeStmtContext.class,0);
		}
		public AttrStmtContext attrStmt() {
			return getRuleContext(AttrStmtContext.class,0);
		}
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public SubgraphContext subgraph() {
			return getRuleContext(SubgraphContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(DotParser.SEMI, 0); }
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DotParserListener ) ((DotParserListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DotParserListener ) ((DotParserListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DotParserVisitor ) return ((DotParserVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(42);
				nodeStmt();
				}
				break;
			case 2:
				{
				setState(43);
				edgeStmt();
				}
				break;
			case 3:
				{
				setState(44);
				attrStmt();
				}
				break;
			case 4:
				{
				setState(45);
				attribute();
				}
				break;
			case 5:
				{
				setState(46);
				subgraph();
				}
				break;
			}
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(49);
				match(SEMI);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NodeStmtContext extends ParserRuleContext {
		public NodeIdContext nodeId() {
			return getRuleContext(NodeIdContext.class,0);
		}
		public List<AttrListContext> attrList() {
			return getRuleContexts(AttrListContext.class);
		}
		public AttrListContext attrList(int i) {
			return getRuleContext(AttrListContext.class,i);
		}
		public NodeStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nodeStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DotParserListener ) ((DotParserListener)listener).enterNodeStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DotParserListener ) ((DotParserListener)listener).exitNodeStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DotParserVisitor ) return ((DotParserVisitor<? extends T>)visitor).visitNodeStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NodeStmtContext nodeStmt() throws RecognitionException {
		NodeStmtContext _localctx = new NodeStmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_nodeStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			nodeId();
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACK) {
				{
				{
				setState(53);
				attrList();
				}
				}
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EdgeStmtContext extends ParserRuleContext {
		public NodeIdContext nodeId() {
			return getRuleContext(NodeIdContext.class,0);
		}
		public SubgraphContext subgraph() {
			return getRuleContext(SubgraphContext.class,0);
		}
		public List<EdgeRhsContext> edgeRhs() {
			return getRuleContexts(EdgeRhsContext.class);
		}
		public EdgeRhsContext edgeRhs(int i) {
			return getRuleContext(EdgeRhsContext.class,i);
		}
		public List<AttrListContext> attrList() {
			return getRuleContexts(AttrListContext.class);
		}
		public AttrListContext attrList(int i) {
			return getRuleContext(AttrListContext.class,i);
		}
		public EdgeStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_edgeStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DotParserListener ) ((DotParserListener)listener).enterEdgeStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DotParserListener ) ((DotParserListener)listener).exitEdgeStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DotParserVisitor ) return ((DotParserVisitor<? extends T>)visitor).visitEdgeStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EdgeStmtContext edgeStmt() throws RecognitionException {
		EdgeStmtContext _localctx = new EdgeStmtContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_edgeStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case N:
			case NE:
			case E:
			case SE:
			case S:
			case SW:
			case W:
			case NW:
			case C:
			case ID:
				{
				setState(59);
				nodeId();
				}
				break;
			case SUBGRAPH:
				{
				setState(60);
				subgraph();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(64); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(63);
				edgeRhs();
				}
				}
				setState(66); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DIRECTED || _la==UNDIRECTED );
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACK) {
				{
				{
				setState(68);
				attrList();
				}
				}
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttrStmtContext extends ParserRuleContext {
		public Token atype;
		public TerminalNode GRAPH() { return getToken(DotParser.GRAPH, 0); }
		public TerminalNode NODE() { return getToken(DotParser.NODE, 0); }
		public TerminalNode EDGE() { return getToken(DotParser.EDGE, 0); }
		public List<AttrListContext> attrList() {
			return getRuleContexts(AttrListContext.class);
		}
		public AttrListContext attrList(int i) {
			return getRuleContext(AttrListContext.class,i);
		}
		public AttrStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attrStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DotParserListener ) ((DotParserListener)listener).enterAttrStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DotParserListener ) ((DotParserListener)listener).exitAttrStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DotParserVisitor ) return ((DotParserVisitor<? extends T>)visitor).visitAttrStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttrStmtContext attrStmt() throws RecognitionException {
		AttrStmtContext _localctx = new AttrStmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_attrStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			((AttrStmtContext)_localctx).atype = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GRAPH) | (1L << NODE) | (1L << EDGE))) != 0)) ) {
				((AttrStmtContext)_localctx).atype = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(76); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(75);
				attrList();
				}
				}
				setState(78); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==LBRACK );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttrListContext extends ParserRuleContext {
		public TerminalNode LBRACK() { return getToken(DotParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(DotParser.RBRACK, 0); }
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(DotParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DotParser.COMMA, i);
		}
		public List<TerminalNode> SEMI() { return getTokens(DotParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(DotParser.SEMI, i);
		}
		public AttrListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attrList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DotParserListener ) ((DotParserListener)listener).enterAttrList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DotParserListener ) ((DotParserListener)listener).exitAttrList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DotParserVisitor ) return ((DotParserVisitor<? extends T>)visitor).visitAttrList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttrListContext attrList() throws RecognitionException {
		AttrListContext _localctx = new AttrListContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_attrList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(LBRACK);
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << N) | (1L << NE) | (1L << E) | (1L << SE) | (1L << S) | (1L << SW) | (1L << W) | (1L << NW) | (1L << C) | (1L << ID))) != 0)) {
				{
				{
				setState(81);
				attribute();
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA || _la==SEMI) {
					{
					setState(82);
					_la = _input.LA(1);
					if ( !(_la==COMMA || _la==SEMI) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				}
				}
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(90);
			match(RBRACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributeContext extends ParserRuleContext {
		public IdContext key;
		public IdContext value;
		public TerminalNode EQ() { return getToken(DotParser.EQ, 0); }
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
		}
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
		}
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DotParserListener ) ((DotParserListener)listener).enterAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DotParserListener ) ((DotParserListener)listener).exitAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DotParserVisitor ) return ((DotParserVisitor<? extends T>)visitor).visitAttribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_attribute);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			((AttributeContext)_localctx).key = id();
			setState(93);
			match(EQ);
			setState(94);
			((AttributeContext)_localctx).value = id();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubgraphContext extends ParserRuleContext {
		public TerminalNode SUBGRAPH() { return getToken(DotParser.SUBGRAPH, 0); }
		public TerminalNode LBRACE() { return getToken(DotParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(DotParser.RBRACE, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public SubgraphContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subgraph; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DotParserListener ) ((DotParserListener)listener).enterSubgraph(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DotParserListener ) ((DotParserListener)listener).exitSubgraph(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DotParserVisitor ) return ((DotParserVisitor<? extends T>)visitor).visitSubgraph(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubgraphContext subgraph() throws RecognitionException {
		SubgraphContext _localctx = new SubgraphContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_subgraph);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(SUBGRAPH);
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << N) | (1L << NE) | (1L << E) | (1L << SE) | (1L << S) | (1L << SW) | (1L << W) | (1L << NW) | (1L << C) | (1L << ID))) != 0)) {
				{
				setState(97);
				id();
				}
			}

			setState(100);
			match(LBRACE);
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GRAPH) | (1L << NODE) | (1L << EDGE) | (1L << SUBGRAPH) | (1L << N) | (1L << NE) | (1L << E) | (1L << SE) | (1L << S) | (1L << SW) | (1L << W) | (1L << NW) | (1L << C) | (1L << ID))) != 0)) {
				{
				{
				setState(101);
				stmt();
				}
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(107);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EdgeRhsContext extends ParserRuleContext {
		public Token op;
		public TerminalNode DIRECTED() { return getToken(DotParser.DIRECTED, 0); }
		public TerminalNode UNDIRECTED() { return getToken(DotParser.UNDIRECTED, 0); }
		public NodeIdContext nodeId() {
			return getRuleContext(NodeIdContext.class,0);
		}
		public SubgraphContext subgraph() {
			return getRuleContext(SubgraphContext.class,0);
		}
		public EdgeRhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_edgeRhs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DotParserListener ) ((DotParserListener)listener).enterEdgeRhs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DotParserListener ) ((DotParserListener)listener).exitEdgeRhs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DotParserVisitor ) return ((DotParserVisitor<? extends T>)visitor).visitEdgeRhs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EdgeRhsContext edgeRhs() throws RecognitionException {
		EdgeRhsContext _localctx = new EdgeRhsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_edgeRhs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			((EdgeRhsContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==DIRECTED || _la==UNDIRECTED) ) {
				((EdgeRhsContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(112);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case N:
			case NE:
			case E:
			case SE:
			case S:
			case SW:
			case W:
			case NW:
			case C:
			case ID:
				{
				setState(110);
				nodeId();
				}
				break;
			case SUBGRAPH:
				{
				setState(111);
				subgraph();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NodeIdContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public PortContext port() {
			return getRuleContext(PortContext.class,0);
		}
		public NodeIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nodeId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DotParserListener ) ((DotParserListener)listener).enterNodeId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DotParserListener ) ((DotParserListener)listener).exitNodeId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DotParserVisitor ) return ((DotParserVisitor<? extends T>)visitor).visitNodeId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NodeIdContext nodeId() throws RecognitionException {
		NodeIdContext _localctx = new NodeIdContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_nodeId);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			id();
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(115);
				port();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PortContext extends ParserRuleContext {
		public List<TerminalNode> COLON() { return getTokens(DotParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(DotParser.COLON, i);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public CompassContext compass() {
			return getRuleContext(CompassContext.class,0);
		}
		public PortContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_port; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DotParserListener ) ((DotParserListener)listener).enterPort(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DotParserListener ) ((DotParserListener)listener).exitPort(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DotParserVisitor ) return ((DotParserVisitor<? extends T>)visitor).visitPort(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PortContext port() throws RecognitionException {
		PortContext _localctx = new PortContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_port);
		int _la;
		try {
			setState(126);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(118);
				match(COLON);
				setState(119);
				id();
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(120);
					match(COLON);
					setState(121);
					compass();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
				match(COLON);
				setState(125);
				compass();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(DotParser.ID, 0); }
		public CompassContext compass() {
			return getRuleContext(CompassContext.class,0);
		}
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DotParserListener ) ((DotParserListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DotParserListener ) ((DotParserListener)listener).exitId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DotParserVisitor ) return ((DotParserVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_id);
		try {
			setState(130);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(128);
				match(ID);
				}
				break;
			case N:
			case NE:
			case E:
			case SE:
			case S:
			case SW:
			case W:
			case NW:
			case C:
				enterOuterAlt(_localctx, 2);
				{
				setState(129);
				compass();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompassContext extends ParserRuleContext {
		public TerminalNode N() { return getToken(DotParser.N, 0); }
		public TerminalNode NE() { return getToken(DotParser.NE, 0); }
		public TerminalNode E() { return getToken(DotParser.E, 0); }
		public TerminalNode SE() { return getToken(DotParser.SE, 0); }
		public TerminalNode S() { return getToken(DotParser.S, 0); }
		public TerminalNode SW() { return getToken(DotParser.SW, 0); }
		public TerminalNode W() { return getToken(DotParser.W, 0); }
		public TerminalNode NW() { return getToken(DotParser.NW, 0); }
		public TerminalNode C() { return getToken(DotParser.C, 0); }
		public CompassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DotParserListener ) ((DotParserListener)listener).enterCompass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DotParserListener ) ((DotParserListener)listener).exitCompass(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DotParserVisitor ) return ((DotParserVisitor<? extends T>)visitor).visitCompass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompassContext compass() throws RecognitionException {
		CompassContext _localctx = new CompassContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_compass);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << N) | (1L << NE) | (1L << E) | (1L << SE) | (1L << S) | (1L << SW) | (1L << W) | (1L << NW) | (1L << C))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3&\u0089\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\5\2\36\n\2\3\2\3\2\5\2\"\n\2\3\2\3\2"+
		"\7\2&\n\2\f\2\16\2)\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\5\3\62\n\3\3\3\5"+
		"\3\65\n\3\3\4\3\4\7\49\n\4\f\4\16\4<\13\4\3\5\3\5\5\5@\n\5\3\5\6\5C\n"+
		"\5\r\5\16\5D\3\5\7\5H\n\5\f\5\16\5K\13\5\3\6\3\6\6\6O\n\6\r\6\16\6P\3"+
		"\7\3\7\3\7\5\7V\n\7\7\7X\n\7\f\7\16\7[\13\7\3\7\3\7\3\b\3\b\3\b\3\b\3"+
		"\t\3\t\5\te\n\t\3\t\3\t\7\ti\n\t\f\t\16\tl\13\t\3\t\3\t\3\n\3\n\3\n\5"+
		"\ns\n\n\3\13\3\13\5\13w\n\13\3\f\3\f\3\f\3\f\5\f}\n\f\3\f\3\f\5\f\u0081"+
		"\n\f\3\r\3\r\5\r\u0085\n\r\3\16\3\16\3\16\2\2\17\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\2\7\3\2\16\17\3\2\17\21\3\2\3\4\3\2\13\f\3\2\23\33\2\u0091"+
		"\2\35\3\2\2\2\4\61\3\2\2\2\6\66\3\2\2\2\b?\3\2\2\2\nL\3\2\2\2\fR\3\2\2"+
		"\2\16^\3\2\2\2\20b\3\2\2\2\22o\3\2\2\2\24t\3\2\2\2\26\u0080\3\2\2\2\30"+
		"\u0084\3\2\2\2\32\u0086\3\2\2\2\34\36\7\r\2\2\35\34\3\2\2\2\35\36\3\2"+
		"\2\2\36\37\3\2\2\2\37!\t\2\2\2 \"\5\30\r\2! \3\2\2\2!\"\3\2\2\2\"#\3\2"+
		"\2\2#\'\7\5\2\2$&\5\4\3\2%$\3\2\2\2&)\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(*"+
		"\3\2\2\2)\'\3\2\2\2*+\7\6\2\2+\3\3\2\2\2,\62\5\6\4\2-\62\5\b\5\2.\62\5"+
		"\n\6\2/\62\5\16\b\2\60\62\5\20\t\2\61,\3\2\2\2\61-\3\2\2\2\61.\3\2\2\2"+
		"\61/\3\2\2\2\61\60\3\2\2\2\62\64\3\2\2\2\63\65\7\4\2\2\64\63\3\2\2\2\64"+
		"\65\3\2\2\2\65\5\3\2\2\2\66:\5\24\13\2\679\5\f\7\28\67\3\2\2\29<\3\2\2"+
		"\2:8\3\2\2\2:;\3\2\2\2;\7\3\2\2\2<:\3\2\2\2=@\5\24\13\2>@\5\20\t\2?=\3"+
		"\2\2\2?>\3\2\2\2@B\3\2\2\2AC\5\22\n\2BA\3\2\2\2CD\3\2\2\2DB\3\2\2\2DE"+
		"\3\2\2\2EI\3\2\2\2FH\5\f\7\2GF\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2\2J"+
		"\t\3\2\2\2KI\3\2\2\2LN\t\3\2\2MO\5\f\7\2NM\3\2\2\2OP\3\2\2\2PN\3\2\2\2"+
		"PQ\3\2\2\2Q\13\3\2\2\2RY\7\7\2\2SU\5\16\b\2TV\t\4\2\2UT\3\2\2\2UV\3\2"+
		"\2\2VX\3\2\2\2WS\3\2\2\2X[\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z\\\3\2\2\2[Y\3"+
		"\2\2\2\\]\7\b\2\2]\r\3\2\2\2^_\5\30\r\2_`\7\n\2\2`a\5\30\r\2a\17\3\2\2"+
		"\2bd\7\22\2\2ce\5\30\r\2dc\3\2\2\2de\3\2\2\2ef\3\2\2\2fj\7\5\2\2gi\5\4"+
		"\3\2hg\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2km\3\2\2\2lj\3\2\2\2mn\7\6"+
		"\2\2n\21\3\2\2\2or\t\5\2\2ps\5\24\13\2qs\5\20\t\2rp\3\2\2\2rq\3\2\2\2"+
		"s\23\3\2\2\2tv\5\30\r\2uw\5\26\f\2vu\3\2\2\2vw\3\2\2\2w\25\3\2\2\2xy\7"+
		"\t\2\2y|\5\30\r\2z{\7\t\2\2{}\5\32\16\2|z\3\2\2\2|}\3\2\2\2}\u0081\3\2"+
		"\2\2~\177\7\t\2\2\177\u0081\5\32\16\2\u0080x\3\2\2\2\u0080~\3\2\2\2\u0081"+
		"\27\3\2\2\2\u0082\u0085\7\34\2\2\u0083\u0085\5\32\16\2\u0084\u0082\3\2"+
		"\2\2\u0084\u0083\3\2\2\2\u0085\31\3\2\2\2\u0086\u0087\t\6\2\2\u0087\33"+
		"\3\2\2\2\25\35!\'\61\64:?DIPUYdjrv|\u0080\u0084";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}