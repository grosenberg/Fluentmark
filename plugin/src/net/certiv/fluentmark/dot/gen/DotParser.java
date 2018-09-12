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
		DIRECTED=9, UNDIRECTED=10, STRICT=11, DIGRAPH=12, GRAPH=13, SUBGRAPH=14, 
		NODE=15, EDGE=16, N=17, NE=18, E=19, SE=20, S=21, SW=22, W=23, NW=24, 
		C=25, ID=26, RGB=27, HSV=28, POINT=29, RECT=30, COLORS=31, STRING=32, 
		SPLINE=33, SPOINT=34, HTML=35, NUMBER=36, ML_COMMENT=37, SL_COMMENT=38, 
		VWS=39, HWS=40, ERR=41;
	public static final int
		RULE_graph = 0, RULE_stmt = 1, RULE_nodeStmt = 2, RULE_edgeStmt = 3, RULE_attrStmt = 4, 
		RULE_attrList = 5, RULE_attribute = 6, RULE_value = 7, RULE_subgraph = 8, 
		RULE_edgeRhs = 9, RULE_nodeId = 10, RULE_port = 11, RULE_id = 12, RULE_compass = 13;
	public static final String[] ruleNames = {
		"graph", "stmt", "nodeStmt", "edgeStmt", "attrStmt", "attrList", "attribute", 
		"value", "subgraph", "edgeRhs", "nodeId", "port", "id", "compass"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "COMMA", "SEMI", "LBRACE", "RBRACE", "LBRACK", "RBRACK", "COLON", 
		"EQ", "DIRECTED", "UNDIRECTED", "STRICT", "DIGRAPH", "GRAPH", "SUBGRAPH", 
		"NODE", "EDGE", "N", "NE", "E", "SE", "S", "SW", "W", "NW", "C", "ID", 
		"RGB", "HSV", "POINT", "RECT", "COLORS", "STRING", "SPLINE", "SPOINT", 
		"HTML", "NUMBER", "ML_COMMENT", "SL_COMMENT", "VWS", "HWS", "ERR"
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
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRICT) {
				{
				setState(28);
				match(STRICT);
				}
			}

			setState(31);
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
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << N) | (1L << NE) | (1L << E) | (1L << SE) | (1L << S) | (1L << SW) | (1L << W) | (1L << NW) | (1L << C) | (1L << ID))) != 0)) {
				{
				setState(32);
				id();
				}
			}

			setState(35);
			match(LBRACE);
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GRAPH) | (1L << SUBGRAPH) | (1L << NODE) | (1L << EDGE) | (1L << N) | (1L << NE) | (1L << E) | (1L << SE) | (1L << S) | (1L << SW) | (1L << W) | (1L << NW) | (1L << C) | (1L << ID))) != 0)) {
				{
				{
				setState(36);
				stmt();
				}
				}
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(42);
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
			setState(49);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(44);
				nodeStmt();
				}
				break;
			case 2:
				{
				setState(45);
				edgeStmt();
				}
				break;
			case 3:
				{
				setState(46);
				attrStmt();
				}
				break;
			case 4:
				{
				setState(47);
				attribute();
				}
				break;
			case 5:
				{
				setState(48);
				subgraph();
				}
				break;
			}
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(51);
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
			setState(54);
			nodeId();
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACK) {
				{
				{
				setState(55);
				attrList();
				}
				}
				setState(60);
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
			setState(63);
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
				setState(61);
				nodeId();
				}
				break;
			case SUBGRAPH:
				{
				setState(62);
				subgraph();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(66); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(65);
				edgeRhs();
				}
				}
				setState(68); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DIRECTED || _la==UNDIRECTED );
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACK) {
				{
				{
				setState(70);
				attrList();
				}
				}
				setState(75);
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
			setState(76);
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
			setState(78); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(77);
				attrList();
				}
				}
				setState(80); 
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
			setState(82);
			match(LBRACK);
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << N) | (1L << NE) | (1L << E) | (1L << SE) | (1L << S) | (1L << SW) | (1L << W) | (1L << NW) | (1L << C) | (1L << ID))) != 0)) {
				{
				{
				setState(83);
				attribute();
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA || _la==SEMI) {
					{
					setState(84);
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
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(92);
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
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode EQ() { return getToken(DotParser.EQ, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
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
			setState(94);
			id();
			setState(95);
			match(EQ);
			setState(96);
			value();
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

	public static class ValueContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode STRING() { return getToken(DotParser.STRING, 0); }
		public TerminalNode HTML() { return getToken(DotParser.HTML, 0); }
		public TerminalNode NUMBER() { return getToken(DotParser.NUMBER, 0); }
		public TerminalNode POINT() { return getToken(DotParser.POINT, 0); }
		public TerminalNode RECT() { return getToken(DotParser.RECT, 0); }
		public TerminalNode SPLINE() { return getToken(DotParser.SPLINE, 0); }
		public TerminalNode COLORS() { return getToken(DotParser.COLORS, 0); }
		public TerminalNode RGB() { return getToken(DotParser.RGB, 0); }
		public TerminalNode HSV() { return getToken(DotParser.HSV, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DotParserListener ) ((DotParserListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DotParserListener ) ((DotParserListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DotParserVisitor ) return ((DotParserVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_value);
		try {
			setState(108);
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
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				id();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(99);
				match(STRING);
				}
				break;
			case HTML:
				enterOuterAlt(_localctx, 3);
				{
				setState(100);
				match(HTML);
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 4);
				{
				setState(101);
				match(NUMBER);
				}
				break;
			case POINT:
				enterOuterAlt(_localctx, 5);
				{
				setState(102);
				match(POINT);
				}
				break;
			case RECT:
				enterOuterAlt(_localctx, 6);
				{
				setState(103);
				match(RECT);
				}
				break;
			case SPLINE:
				enterOuterAlt(_localctx, 7);
				{
				setState(104);
				match(SPLINE);
				}
				break;
			case COLORS:
				enterOuterAlt(_localctx, 8);
				{
				setState(105);
				match(COLORS);
				}
				break;
			case RGB:
				enterOuterAlt(_localctx, 9);
				{
				setState(106);
				match(RGB);
				}
				break;
			case HSV:
				enterOuterAlt(_localctx, 10);
				{
				setState(107);
				match(HSV);
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
		enterRule(_localctx, 16, RULE_subgraph);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(SUBGRAPH);
			setState(112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << N) | (1L << NE) | (1L << E) | (1L << SE) | (1L << S) | (1L << SW) | (1L << W) | (1L << NW) | (1L << C) | (1L << ID))) != 0)) {
				{
				setState(111);
				id();
				}
			}

			setState(114);
			match(LBRACE);
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GRAPH) | (1L << SUBGRAPH) | (1L << NODE) | (1L << EDGE) | (1L << N) | (1L << NE) | (1L << E) | (1L << SE) | (1L << S) | (1L << SW) | (1L << W) | (1L << NW) | (1L << C) | (1L << ID))) != 0)) {
				{
				{
				setState(115);
				stmt();
				}
				}
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(121);
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
		enterRule(_localctx, 18, RULE_edgeRhs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
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
			setState(126);
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
				setState(124);
				nodeId();
				}
				break;
			case SUBGRAPH:
				{
				setState(125);
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
		enterRule(_localctx, 20, RULE_nodeId);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			id();
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(129);
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
		enterRule(_localctx, 22, RULE_port);
		int _la;
		try {
			setState(140);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(132);
				match(COLON);
				setState(133);
				id();
				setState(136);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(134);
					match(COLON);
					setState(135);
					compass();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(138);
				match(COLON);
				setState(139);
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
		public Token name;
		public TerminalNode ID() { return getToken(DotParser.ID, 0); }
		public TerminalNode N() { return getToken(DotParser.N, 0); }
		public TerminalNode NE() { return getToken(DotParser.NE, 0); }
		public TerminalNode E() { return getToken(DotParser.E, 0); }
		public TerminalNode SE() { return getToken(DotParser.SE, 0); }
		public TerminalNode S() { return getToken(DotParser.S, 0); }
		public TerminalNode SW() { return getToken(DotParser.SW, 0); }
		public TerminalNode W() { return getToken(DotParser.W, 0); }
		public TerminalNode NW() { return getToken(DotParser.NW, 0); }
		public TerminalNode C() { return getToken(DotParser.C, 0); }
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
		enterRule(_localctx, 24, RULE_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			((IdContext)_localctx).name = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << N) | (1L << NE) | (1L << E) | (1L << SE) | (1L << S) | (1L << SW) | (1L << W) | (1L << NW) | (1L << C) | (1L << ID))) != 0)) ) {
				((IdContext)_localctx).name = (Token)_errHandler.recoverInline(this);
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

	public static class CompassContext extends ParserRuleContext {
		public Token dir;
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
		enterRule(_localctx, 26, RULE_compass);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			((CompassContext)_localctx).dir = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << N) | (1L << NE) | (1L << E) | (1L << SE) | (1L << S) | (1L << SW) | (1L << W) | (1L << NW) | (1L << C))) != 0)) ) {
				((CompassContext)_localctx).dir = (Token)_errHandler.recoverInline(this);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3+\u0095\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\5\2 \n\2\3\2\3\2\5\2$\n\2"+
		"\3\2\3\2\7\2(\n\2\f\2\16\2+\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\5\3\64\n"+
		"\3\3\3\5\3\67\n\3\3\4\3\4\7\4;\n\4\f\4\16\4>\13\4\3\5\3\5\5\5B\n\5\3\5"+
		"\6\5E\n\5\r\5\16\5F\3\5\7\5J\n\5\f\5\16\5M\13\5\3\6\3\6\6\6Q\n\6\r\6\16"+
		"\6R\3\7\3\7\3\7\5\7X\n\7\7\7Z\n\7\f\7\16\7]\13\7\3\7\3\7\3\b\3\b\3\b\3"+
		"\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\to\n\t\3\n\3\n\5\ns\n\n\3"+
		"\n\3\n\7\nw\n\n\f\n\16\nz\13\n\3\n\3\n\3\13\3\13\3\13\5\13\u0081\n\13"+
		"\3\f\3\f\5\f\u0085\n\f\3\r\3\r\3\r\3\r\5\r\u008b\n\r\3\r\3\r\5\r\u008f"+
		"\n\r\3\16\3\16\3\17\3\17\3\17\2\2\20\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\2\b\3\2\16\17\4\2\17\17\21\22\3\2\3\4\3\2\13\f\3\2\23\34\3\2\23\33"+
		"\2\u00a4\2\37\3\2\2\2\4\63\3\2\2\2\68\3\2\2\2\bA\3\2\2\2\nN\3\2\2\2\f"+
		"T\3\2\2\2\16`\3\2\2\2\20n\3\2\2\2\22p\3\2\2\2\24}\3\2\2\2\26\u0082\3\2"+
		"\2\2\30\u008e\3\2\2\2\32\u0090\3\2\2\2\34\u0092\3\2\2\2\36 \7\r\2\2\37"+
		"\36\3\2\2\2\37 \3\2\2\2 !\3\2\2\2!#\t\2\2\2\"$\5\32\16\2#\"\3\2\2\2#$"+
		"\3\2\2\2$%\3\2\2\2%)\7\5\2\2&(\5\4\3\2\'&\3\2\2\2(+\3\2\2\2)\'\3\2\2\2"+
		")*\3\2\2\2*,\3\2\2\2+)\3\2\2\2,-\7\6\2\2-\3\3\2\2\2.\64\5\6\4\2/\64\5"+
		"\b\5\2\60\64\5\n\6\2\61\64\5\16\b\2\62\64\5\22\n\2\63.\3\2\2\2\63/\3\2"+
		"\2\2\63\60\3\2\2\2\63\61\3\2\2\2\63\62\3\2\2\2\64\66\3\2\2\2\65\67\7\4"+
		"\2\2\66\65\3\2\2\2\66\67\3\2\2\2\67\5\3\2\2\28<\5\26\f\29;\5\f\7\2:9\3"+
		"\2\2\2;>\3\2\2\2<:\3\2\2\2<=\3\2\2\2=\7\3\2\2\2><\3\2\2\2?B\5\26\f\2@"+
		"B\5\22\n\2A?\3\2\2\2A@\3\2\2\2BD\3\2\2\2CE\5\24\13\2DC\3\2\2\2EF\3\2\2"+
		"\2FD\3\2\2\2FG\3\2\2\2GK\3\2\2\2HJ\5\f\7\2IH\3\2\2\2JM\3\2\2\2KI\3\2\2"+
		"\2KL\3\2\2\2L\t\3\2\2\2MK\3\2\2\2NP\t\3\2\2OQ\5\f\7\2PO\3\2\2\2QR\3\2"+
		"\2\2RP\3\2\2\2RS\3\2\2\2S\13\3\2\2\2T[\7\7\2\2UW\5\16\b\2VX\t\4\2\2WV"+
		"\3\2\2\2WX\3\2\2\2XZ\3\2\2\2YU\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2"+
		"\\^\3\2\2\2][\3\2\2\2^_\7\b\2\2_\r\3\2\2\2`a\5\32\16\2ab\7\n\2\2bc\5\20"+
		"\t\2c\17\3\2\2\2do\5\32\16\2eo\7\"\2\2fo\7%\2\2go\7&\2\2ho\7\37\2\2io"+
		"\7 \2\2jo\7#\2\2ko\7!\2\2lo\7\35\2\2mo\7\36\2\2nd\3\2\2\2ne\3\2\2\2nf"+
		"\3\2\2\2ng\3\2\2\2nh\3\2\2\2ni\3\2\2\2nj\3\2\2\2nk\3\2\2\2nl\3\2\2\2n"+
		"m\3\2\2\2o\21\3\2\2\2pr\7\20\2\2qs\5\32\16\2rq\3\2\2\2rs\3\2\2\2st\3\2"+
		"\2\2tx\7\5\2\2uw\5\4\3\2vu\3\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y{\3\2"+
		"\2\2zx\3\2\2\2{|\7\6\2\2|\23\3\2\2\2}\u0080\t\5\2\2~\u0081\5\26\f\2\177"+
		"\u0081\5\22\n\2\u0080~\3\2\2\2\u0080\177\3\2\2\2\u0081\25\3\2\2\2\u0082"+
		"\u0084\5\32\16\2\u0083\u0085\5\30\r\2\u0084\u0083\3\2\2\2\u0084\u0085"+
		"\3\2\2\2\u0085\27\3\2\2\2\u0086\u0087\7\t\2\2\u0087\u008a\5\32\16\2\u0088"+
		"\u0089\7\t\2\2\u0089\u008b\5\34\17\2\u008a\u0088\3\2\2\2\u008a\u008b\3"+
		"\2\2\2\u008b\u008f\3\2\2\2\u008c\u008d\7\t\2\2\u008d\u008f\5\34\17\2\u008e"+
		"\u0086\3\2\2\2\u008e\u008c\3\2\2\2\u008f\31\3\2\2\2\u0090\u0091\t\6\2"+
		"\2\u0091\33\3\2\2\2\u0092\u0093\t\7\2\2\u0093\35\3\2\2\2\25\37#)\63\66"+
		"<AFKRW[nrx\u0080\u0084\u008a\u008e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}