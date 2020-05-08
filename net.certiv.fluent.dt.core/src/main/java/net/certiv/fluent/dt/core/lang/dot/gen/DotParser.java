// Generated from D:/DevFiles/Eclipse/Tools/Editors/net.certiv.fluent.dt/net.certiv.fluent.dt.core/src/main/java/net/certiv/fluent/dt/core/lang/dot/DotParser.g4 by ANTLR 4.8

	package net.certiv.fluent.dt.core.lang.dot.gen;

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
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		VWS=1, HWS=2, OTHER=3, GRAPH=4, LBRACE=5, RBRACE=6, RGB=7, HSV=8, POINT=9, 
		RECT=10, COLORS=11, STRING=12, SPLINE=13, SPOINT=14, HTML=15, NUMBER=16, 
		ML_COMMENT=17, SL_COMMENT=18, COMMA=19, SEMI=20, LBRACK=21, RBRACK=22, 
		COLON=23, EQ=24, DIRECTED=25, UNDIRECTED=26, SUBGRAPH=27, NODE=28, EDGE=29, 
		N=30, NE=31, E=32, SE=33, S=34, SW=35, W=36, NW=37, C=38, ID=39;
	public static final int
		RULE_document = 0, RULE_graph = 1, RULE_stmt = 2, RULE_nodeStmt = 3, RULE_edgeStmt = 4, 
		RULE_attrStmt = 5, RULE_attrList = 6, RULE_attribute = 7, RULE_value = 8, 
		RULE_subgraph = 9, RULE_edgeRhs = 10, RULE_nodeId = 11, RULE_port = 12, 
		RULE_id = 13, RULE_compass = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"document", "graph", "stmt", "nodeStmt", "edgeStmt", "attrStmt", "attrList", 
			"attribute", "value", "subgraph", "edgeRhs", "nodeId", "port", "id", 
			"compass"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "VWS", "HWS", "OTHER", "GRAPH", "LBRACE", "RBRACE", "RGB", "HSV", 
			"POINT", "RECT", "COLORS", "STRING", "SPLINE", "SPOINT", "HTML", "NUMBER", 
			"ML_COMMENT", "SL_COMMENT", "COMMA", "SEMI", "LBRACK", "RBRACK", "COLON", 
			"EQ", "DIRECTED", "UNDIRECTED", "SUBGRAPH", "NODE", "EDGE", "N", "NE", 
			"E", "SE", "S", "SW", "W", "NW", "C", "ID"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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

	public static class DocumentContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(DotParser.EOF, 0); }
		public List<GraphContext> graph() {
			return getRuleContexts(GraphContext.class);
		}
		public GraphContext graph(int i) {
			return getRuleContext(GraphContext.class,i);
		}
		public List<TerminalNode> OTHER() { return getTokens(DotParser.OTHER); }
		public TerminalNode OTHER(int i) {
			return getToken(DotParser.OTHER, i);
		}
		public DocumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_document; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DotParserListener ) ((DotParserListener)listener).enterDocument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DotParserListener ) ((DotParserListener)listener).exitDocument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DotParserVisitor ) return ((DotParserVisitor<? extends T>)visitor).visitDocument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DocumentContext document() throws RecognitionException {
		DocumentContext _localctx = new DocumentContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_document);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OTHER || _la==GRAPH) {
				{
				setState(32);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case GRAPH:
					{
					setState(30);
					graph();
					}
					break;
				case OTHER:
					{
					setState(31);
					match(OTHER);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(37);
			match(EOF);
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

	public static class GraphContext extends ParserRuleContext {
		public TerminalNode GRAPH() { return getToken(DotParser.GRAPH, 0); }
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
		enterRule(_localctx, 2, RULE_graph);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			match(GRAPH);
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << N) | (1L << NE) | (1L << E) | (1L << SE) | (1L << S) | (1L << SW) | (1L << W) | (1L << NW) | (1L << C) | (1L << ID))) != 0)) {
				{
				setState(40);
				id();
				}
			}

			setState(43);
			match(LBRACE);
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GRAPH) | (1L << SUBGRAPH) | (1L << NODE) | (1L << EDGE) | (1L << N) | (1L << NE) | (1L << E) | (1L << SE) | (1L << S) | (1L << SW) | (1L << W) | (1L << NW) | (1L << C) | (1L << ID))) != 0)) {
				{
				{
				setState(44);
				stmt();
				}
				}
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(50);
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
		enterRule(_localctx, 4, RULE_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(52);
				nodeStmt();
				}
				break;
			case 2:
				{
				setState(53);
				edgeStmt();
				}
				break;
			case 3:
				{
				setState(54);
				attrStmt();
				}
				break;
			case 4:
				{
				setState(55);
				attribute();
				}
				break;
			case 5:
				{
				setState(56);
				subgraph();
				}
				break;
			}
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(59);
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
		enterRule(_localctx, 6, RULE_nodeStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			nodeId();
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACK) {
				{
				{
				setState(63);
				attrList();
				}
				}
				setState(68);
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
		enterRule(_localctx, 8, RULE_edgeStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
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
				setState(69);
				nodeId();
				}
				break;
			case SUBGRAPH:
				{
				setState(70);
				subgraph();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(74); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(73);
				edgeRhs();
				}
				}
				setState(76); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DIRECTED || _la==UNDIRECTED );
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACK) {
				{
				{
				setState(78);
				attrList();
				}
				}
				setState(83);
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
		enterRule(_localctx, 10, RULE_attrStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
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
			setState(86); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(85);
				attrList();
				}
				}
				setState(88); 
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
		enterRule(_localctx, 12, RULE_attrList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(LBRACK);
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << N) | (1L << NE) | (1L << E) | (1L << SE) | (1L << S) | (1L << SW) | (1L << W) | (1L << NW) | (1L << C) | (1L << ID))) != 0)) {
				{
				{
				setState(91);
				attribute();
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA || _la==SEMI) {
					{
					setState(92);
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
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(100);
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
		enterRule(_localctx, 14, RULE_attribute);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			id();
			setState(103);
			match(EQ);
			setState(104);
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
		public TerminalNode STRING() { return getToken(DotParser.STRING, 0); }
		public TerminalNode HTML() { return getToken(DotParser.HTML, 0); }
		public TerminalNode NUMBER() { return getToken(DotParser.NUMBER, 0); }
		public TerminalNode POINT() { return getToken(DotParser.POINT, 0); }
		public TerminalNode RECT() { return getToken(DotParser.RECT, 0); }
		public TerminalNode SPLINE() { return getToken(DotParser.SPLINE, 0); }
		public TerminalNode COLORS() { return getToken(DotParser.COLORS, 0); }
		public TerminalNode RGB() { return getToken(DotParser.RGB, 0); }
		public TerminalNode HSV() { return getToken(DotParser.HSV, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
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
		enterRule(_localctx, 16, RULE_value);
		try {
			setState(116);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(106);
				match(STRING);
				}
				break;
			case HTML:
				enterOuterAlt(_localctx, 2);
				{
				setState(107);
				match(HTML);
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 3);
				{
				setState(108);
				match(NUMBER);
				}
				break;
			case POINT:
				enterOuterAlt(_localctx, 4);
				{
				setState(109);
				match(POINT);
				}
				break;
			case RECT:
				enterOuterAlt(_localctx, 5);
				{
				setState(110);
				match(RECT);
				}
				break;
			case SPLINE:
				enterOuterAlt(_localctx, 6);
				{
				setState(111);
				match(SPLINE);
				}
				break;
			case COLORS:
				enterOuterAlt(_localctx, 7);
				{
				setState(112);
				match(COLORS);
				}
				break;
			case RGB:
				enterOuterAlt(_localctx, 8);
				{
				setState(113);
				match(RGB);
				}
				break;
			case HSV:
				enterOuterAlt(_localctx, 9);
				{
				setState(114);
				match(HSV);
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
			case ID:
				enterOuterAlt(_localctx, 10);
				{
				setState(115);
				id();
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
		enterRule(_localctx, 18, RULE_subgraph);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(SUBGRAPH);
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << N) | (1L << NE) | (1L << E) | (1L << SE) | (1L << S) | (1L << SW) | (1L << W) | (1L << NW) | (1L << C) | (1L << ID))) != 0)) {
				{
				setState(119);
				id();
				}
			}

			setState(122);
			match(LBRACE);
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GRAPH) | (1L << SUBGRAPH) | (1L << NODE) | (1L << EDGE) | (1L << N) | (1L << NE) | (1L << E) | (1L << SE) | (1L << S) | (1L << SW) | (1L << W) | (1L << NW) | (1L << C) | (1L << ID))) != 0)) {
				{
				{
				setState(123);
				stmt();
				}
				}
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(129);
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
		enterRule(_localctx, 20, RULE_edgeRhs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
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
			setState(134);
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
				setState(132);
				nodeId();
				}
				break;
			case SUBGRAPH:
				{
				setState(133);
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
		enterRule(_localctx, 22, RULE_nodeId);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			id();
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(137);
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
		enterRule(_localctx, 24, RULE_port);
		int _la;
		try {
			setState(148);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(140);
				match(COLON);
				setState(141);
				id();
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(142);
					match(COLON);
					setState(143);
					compass();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(146);
				match(COLON);
				setState(147);
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
		enterRule(_localctx, 26, RULE_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
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
		enterRule(_localctx, 28, RULE_compass);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3)\u009d\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\7\2#\n\2\f\2"+
		"\16\2&\13\2\3\2\3\2\3\3\3\3\5\3,\n\3\3\3\3\3\7\3\60\n\3\f\3\16\3\63\13"+
		"\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\5\4<\n\4\3\4\5\4?\n\4\3\5\3\5\7\5C\n\5"+
		"\f\5\16\5F\13\5\3\6\3\6\5\6J\n\6\3\6\6\6M\n\6\r\6\16\6N\3\6\7\6R\n\6\f"+
		"\6\16\6U\13\6\3\7\3\7\6\7Y\n\7\r\7\16\7Z\3\b\3\b\3\b\5\b`\n\b\7\bb\n\b"+
		"\f\b\16\be\13\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\5\nw\n\n\3\13\3\13\5\13{\n\13\3\13\3\13\7\13\177\n\13\f\13"+
		"\16\13\u0082\13\13\3\13\3\13\3\f\3\f\3\f\5\f\u0089\n\f\3\r\3\r\5\r\u008d"+
		"\n\r\3\16\3\16\3\16\3\16\5\16\u0093\n\16\3\16\3\16\5\16\u0097\n\16\3\17"+
		"\3\17\3\20\3\20\3\20\2\2\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\7"+
		"\4\2\6\6\36\37\3\2\25\26\3\2\33\34\3\2 )\3\2 (\2\u00ac\2$\3\2\2\2\4)\3"+
		"\2\2\2\6;\3\2\2\2\b@\3\2\2\2\nI\3\2\2\2\fV\3\2\2\2\16\\\3\2\2\2\20h\3"+
		"\2\2\2\22v\3\2\2\2\24x\3\2\2\2\26\u0085\3\2\2\2\30\u008a\3\2\2\2\32\u0096"+
		"\3\2\2\2\34\u0098\3\2\2\2\36\u009a\3\2\2\2 #\5\4\3\2!#\7\5\2\2\" \3\2"+
		"\2\2\"!\3\2\2\2#&\3\2\2\2$\"\3\2\2\2$%\3\2\2\2%\'\3\2\2\2&$\3\2\2\2\'"+
		"(\7\2\2\3(\3\3\2\2\2)+\7\6\2\2*,\5\34\17\2+*\3\2\2\2+,\3\2\2\2,-\3\2\2"+
		"\2-\61\7\7\2\2.\60\5\6\4\2/.\3\2\2\2\60\63\3\2\2\2\61/\3\2\2\2\61\62\3"+
		"\2\2\2\62\64\3\2\2\2\63\61\3\2\2\2\64\65\7\b\2\2\65\5\3\2\2\2\66<\5\b"+
		"\5\2\67<\5\n\6\28<\5\f\7\29<\5\20\t\2:<\5\24\13\2;\66\3\2\2\2;\67\3\2"+
		"\2\2;8\3\2\2\2;9\3\2\2\2;:\3\2\2\2<>\3\2\2\2=?\7\26\2\2>=\3\2\2\2>?\3"+
		"\2\2\2?\7\3\2\2\2@D\5\30\r\2AC\5\16\b\2BA\3\2\2\2CF\3\2\2\2DB\3\2\2\2"+
		"DE\3\2\2\2E\t\3\2\2\2FD\3\2\2\2GJ\5\30\r\2HJ\5\24\13\2IG\3\2\2\2IH\3\2"+
		"\2\2JL\3\2\2\2KM\5\26\f\2LK\3\2\2\2MN\3\2\2\2NL\3\2\2\2NO\3\2\2\2OS\3"+
		"\2\2\2PR\5\16\b\2QP\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2T\13\3\2\2\2"+
		"US\3\2\2\2VX\t\2\2\2WY\5\16\b\2XW\3\2\2\2YZ\3\2\2\2ZX\3\2\2\2Z[\3\2\2"+
		"\2[\r\3\2\2\2\\c\7\27\2\2]_\5\20\t\2^`\t\3\2\2_^\3\2\2\2_`\3\2\2\2`b\3"+
		"\2\2\2a]\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2df\3\2\2\2ec\3\2\2\2fg\7"+
		"\30\2\2g\17\3\2\2\2hi\5\34\17\2ij\7\32\2\2jk\5\22\n\2k\21\3\2\2\2lw\7"+
		"\16\2\2mw\7\21\2\2nw\7\22\2\2ow\7\13\2\2pw\7\f\2\2qw\7\17\2\2rw\7\r\2"+
		"\2sw\7\t\2\2tw\7\n\2\2uw\5\34\17\2vl\3\2\2\2vm\3\2\2\2vn\3\2\2\2vo\3\2"+
		"\2\2vp\3\2\2\2vq\3\2\2\2vr\3\2\2\2vs\3\2\2\2vt\3\2\2\2vu\3\2\2\2w\23\3"+
		"\2\2\2xz\7\35\2\2y{\5\34\17\2zy\3\2\2\2z{\3\2\2\2{|\3\2\2\2|\u0080\7\7"+
		"\2\2}\177\5\6\4\2~}\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081"+
		"\3\2\2\2\u0081\u0083\3\2\2\2\u0082\u0080\3\2\2\2\u0083\u0084\7\b\2\2\u0084"+
		"\25\3\2\2\2\u0085\u0088\t\4\2\2\u0086\u0089\5\30\r\2\u0087\u0089\5\24"+
		"\13\2\u0088\u0086\3\2\2\2\u0088\u0087\3\2\2\2\u0089\27\3\2\2\2\u008a\u008c"+
		"\5\34\17\2\u008b\u008d\5\32\16\2\u008c\u008b\3\2\2\2\u008c\u008d\3\2\2"+
		"\2\u008d\31\3\2\2\2\u008e\u008f\7\31\2\2\u008f\u0092\5\34\17\2\u0090\u0091"+
		"\7\31\2\2\u0091\u0093\5\36\20\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2"+
		"\2\u0093\u0097\3\2\2\2\u0094\u0095\7\31\2\2\u0095\u0097\5\36\20\2\u0096"+
		"\u008e\3\2\2\2\u0096\u0094\3\2\2\2\u0097\33\3\2\2\2\u0098\u0099\t\5\2"+
		"\2\u0099\35\3\2\2\2\u009a\u009b\t\6\2\2\u009b\37\3\2\2\2\26\"$+\61;>D"+
		"INSZ_cvz\u0080\u0088\u008c\u0092\u0096";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}