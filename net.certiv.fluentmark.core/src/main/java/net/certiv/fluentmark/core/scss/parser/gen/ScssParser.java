// Generated from D:/DevFiles/Eclipse/DslEditors/net.certiv.fluentmark/net.certiv.fluentmark.core/src/main/java/net/certiv/fluentmark/core/scss/parser/ScssParser.g4 by ANTLR 4.7.1

	package net.certiv.fluentmark.core.scss.parser.gen;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ScssParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NUMBER=1, UNIT=2, NULL=3, FROM=4, THROUGH=5, IN=6, MIXIN=7, FUNCTION=8, 
		AT_ELSE=9, IF=10, AT_IF=11, AT_FOR=12, AT_WHILE=13, AT_EACH=14, INCLUDE=15, 
		IMPORT=16, RETURN=17, DEFAULT=18, INTERPOLATION_START=19, URL_BEG=20, 
		STRING=21, COLOR=22, IDENTIFIER=23, LPAREN=24, RPAREN=25, LBRACE=26, RBRACE=27, 
		LBRACK=28, RBRACK=29, GT=30, TIL=31, ELLIPSIS=32, LT=33, COLON=34, SEMI=35, 
		COMMA=36, DOT=37, DOLLAR=38, AT=39, AND=40, HASH=41, PLUS=42, TIMES=43, 
		DIV=44, MINUS=45, PERC=46, EQ=47, PIPE_EQ=48, TILD_EQ=49, EQIV=50, NOTEQ=51, 
		COMBINE_COMPARE=52, COLONCOLON=53, WS=54, LINE_COMMENT=55, BLOCK_COMMENT=56, 
		URL_END=57, URL=58, WS_ID=59, InterpolationStartAfter=60, IdentifierAfter=61;
	public static final int
		RULE_stylesheet = 0, RULE_statement = 1, RULE_params = 2, RULE_param = 3, 
		RULE_variableName = 4, RULE_paramOptionalValue = 5, RULE_mixinDeclaration = 6, 
		RULE_includeDeclaration = 7, RULE_functionDeclaration = 8, RULE_functionBody = 9, 
		RULE_functionReturn = 10, RULE_functionStatement = 11, RULE_commandStatement = 12, 
		RULE_mathCharacter = 13, RULE_mathStatement = 14, RULE_expression = 15, 
		RULE_ifDeclaration = 16, RULE_elseIfStatement = 17, RULE_elseStatement = 18, 
		RULE_conditions = 19, RULE_condition = 20, RULE_variableDeclaration = 21, 
		RULE_forDeclaration = 22, RULE_whileDeclaration = 23, RULE_eachDeclaration = 24, 
		RULE_eachValueList = 25, RULE_identifierListOrMap = 26, RULE_identifierValue = 27, 
		RULE_importDeclaration = 28, RULE_referenceUrl = 29, RULE_mediaTypes = 30, 
		RULE_nested = 31, RULE_nest = 32, RULE_ruleset = 33, RULE_block = 34, 
		RULE_selectors = 35, RULE_selector = 36, RULE_selectorPrefix = 37, RULE_element = 38, 
		RULE_pseudo = 39, RULE_attrib = 40, RULE_attribRelate = 41, RULE_identifier = 42, 
		RULE_identifierPart = 43, RULE_identifierVariableName = 44, RULE_property = 45, 
		RULE_values = 46, RULE_url = 47, RULE_measurement = 48, RULE_functionCall = 49;
	public static final String[] ruleNames = {
		"stylesheet", "statement", "params", "param", "variableName", "paramOptionalValue", 
		"mixinDeclaration", "includeDeclaration", "functionDeclaration", "functionBody", 
		"functionReturn", "functionStatement", "commandStatement", "mathCharacter", 
		"mathStatement", "expression", "ifDeclaration", "elseIfStatement", "elseStatement", 
		"conditions", "condition", "variableDeclaration", "forDeclaration", "whileDeclaration", 
		"eachDeclaration", "eachValueList", "identifierListOrMap", "identifierValue", 
		"importDeclaration", "referenceUrl", "mediaTypes", "nested", "nest", "ruleset", 
		"block", "selectors", "selector", "selectorPrefix", "element", "pseudo", 
		"attrib", "attribRelate", "identifier", "identifierPart", "identifierVariableName", 
		"property", "values", "url", "measurement", "functionCall"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "NUMBER", "UNIT", "NULL", "FROM", "THROUGH", "IN", "MIXIN", "FUNCTION", 
		"AT_ELSE", "IF", "AT_IF", "AT_FOR", "AT_WHILE", "AT_EACH", "INCLUDE", 
		"IMPORT", "RETURN", "DEFAULT", "INTERPOLATION_START", "URL_BEG", "STRING", 
		"COLOR", "IDENTIFIER", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRACK", 
		"RBRACK", "GT", "TIL", "ELLIPSIS", "LT", "COLON", "SEMI", "COMMA", "DOT", 
		"DOLLAR", "AT", "AND", "HASH", "PLUS", "TIMES", "DIV", "MINUS", "PERC", 
		"EQ", "PIPE_EQ", "TILD_EQ", "EQIV", "NOTEQ", "COMBINE_COMPARE", "COLONCOLON", 
		"WS", "LINE_COMMENT", "BLOCK_COMMENT", "URL_END", "URL", "WS_ID", "InterpolationStartAfter", 
		"IdentifierAfter"
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
	public String getGrammarFileName() { return "ScssParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ScssParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StylesheetContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ScssParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StylesheetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stylesheet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterStylesheet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitStylesheet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitStylesheet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StylesheetContext stylesheet() throws RecognitionException {
		StylesheetContext _localctx = new StylesheetContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_stylesheet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MIXIN) | (1L << FUNCTION) | (1L << AT_IF) | (1L << AT_FOR) | (1L << AT_WHILE) | (1L << AT_EACH) | (1L << INCLUDE) | (1L << IMPORT) | (1L << INTERPOLATION_START) | (1L << IDENTIFIER) | (1L << DOT) | (1L << DOLLAR) | (1L << AT) | (1L << AND) | (1L << HASH) | (1L << TIMES))) != 0)) {
				{
				{
				setState(100);
				statement();
				}
				}
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(106);
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

	public static class StatementContext extends ParserRuleContext {
		public ImportDeclarationContext importDeclaration() {
			return getRuleContext(ImportDeclarationContext.class,0);
		}
		public NestedContext nested() {
			return getRuleContext(NestedContext.class,0);
		}
		public RulesetContext ruleset() {
			return getRuleContext(RulesetContext.class,0);
		}
		public MixinDeclarationContext mixinDeclaration() {
			return getRuleContext(MixinDeclarationContext.class,0);
		}
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public IncludeDeclarationContext includeDeclaration() {
			return getRuleContext(IncludeDeclarationContext.class,0);
		}
		public IfDeclarationContext ifDeclaration() {
			return getRuleContext(IfDeclarationContext.class,0);
		}
		public ForDeclarationContext forDeclaration() {
			return getRuleContext(ForDeclarationContext.class,0);
		}
		public WhileDeclarationContext whileDeclaration() {
			return getRuleContext(WhileDeclarationContext.class,0);
		}
		public EachDeclarationContext eachDeclaration() {
			return getRuleContext(EachDeclarationContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(119);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IMPORT:
				enterOuterAlt(_localctx, 1);
				{
				setState(108);
				importDeclaration();
				}
				break;
			case AT:
				enterOuterAlt(_localctx, 2);
				{
				setState(109);
				nested();
				}
				break;
			case INTERPOLATION_START:
			case IDENTIFIER:
			case DOT:
			case AND:
			case HASH:
			case TIMES:
				enterOuterAlt(_localctx, 3);
				{
				setState(110);
				ruleset();
				}
				break;
			case MIXIN:
				enterOuterAlt(_localctx, 4);
				{
				setState(111);
				mixinDeclaration();
				}
				break;
			case FUNCTION:
				enterOuterAlt(_localctx, 5);
				{
				setState(112);
				functionDeclaration();
				}
				break;
			case DOLLAR:
				enterOuterAlt(_localctx, 6);
				{
				setState(113);
				variableDeclaration();
				}
				break;
			case INCLUDE:
				enterOuterAlt(_localctx, 7);
				{
				setState(114);
				includeDeclaration();
				}
				break;
			case AT_IF:
				enterOuterAlt(_localctx, 8);
				{
				setState(115);
				ifDeclaration();
				}
				break;
			case AT_FOR:
				enterOuterAlt(_localctx, 9);
				{
				setState(116);
				forDeclaration();
				}
				break;
			case AT_WHILE:
				enterOuterAlt(_localctx, 10);
				{
				setState(117);
				whileDeclaration();
				}
				break;
			case AT_EACH:
				enterOuterAlt(_localctx, 11);
				{
				setState(118);
				eachDeclaration();
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

	public static class ParamsContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ScssParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ScssParser.COMMA, i);
		}
		public TerminalNode ELLIPSIS() { return getToken(ScssParser.ELLIPSIS, 0); }
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			param();
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(122);
				match(COMMA);
				setState(123);
				param();
				}
				}
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELLIPSIS) {
				{
				setState(129);
				match(ELLIPSIS);
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

	public static class ParamContext extends ParserRuleContext {
		public VariableNameContext variableName() {
			return getRuleContext(VariableNameContext.class,0);
		}
		public ParamOptionalValueContext paramOptionalValue() {
			return getRuleContext(ParamOptionalValueContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_param);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			variableName();
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(133);
				paramOptionalValue();
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

	public static class VariableNameContext extends ParserRuleContext {
		public TerminalNode DOLLAR() { return getToken(ScssParser.DOLLAR, 0); }
		public TerminalNode IDENTIFIER() { return getToken(ScssParser.IDENTIFIER, 0); }
		public VariableNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterVariableName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitVariableName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitVariableName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableNameContext variableName() throws RecognitionException {
		VariableNameContext _localctx = new VariableNameContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_variableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(DOLLAR);
			setState(137);
			match(IDENTIFIER);
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

	public static class ParamOptionalValueContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(ScssParser.COLON, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ParamOptionalValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramOptionalValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterParamOptionalValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitParamOptionalValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitParamOptionalValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamOptionalValueContext paramOptionalValue() throws RecognitionException {
		ParamOptionalValueContext _localctx = new ParamOptionalValueContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_paramOptionalValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(COLON);
			setState(141); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(140);
				expression();
				}
				}
				setState(143); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMBER) | (1L << NULL) | (1L << INTERPOLATION_START) | (1L << URL_BEG) | (1L << STRING) | (1L << COLOR) | (1L << IDENTIFIER) | (1L << DOLLAR))) != 0) );
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

	public static class MixinDeclarationContext extends ParserRuleContext {
		public TerminalNode MIXIN() { return getToken(ScssParser.MIXIN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(ScssParser.IDENTIFIER, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(ScssParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ScssParser.RPAREN, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public MixinDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mixinDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterMixinDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitMixinDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitMixinDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MixinDeclarationContext mixinDeclaration() throws RecognitionException {
		MixinDeclarationContext _localctx = new MixinDeclarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_mixinDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(MIXIN);
			setState(146);
			match(IDENTIFIER);
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(147);
				match(LPAREN);
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOLLAR) {
					{
					setState(148);
					params();
					}
				}

				setState(151);
				match(RPAREN);
				}
			}

			setState(154);
			block();
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

	public static class IncludeDeclarationContext extends ParserRuleContext {
		public TerminalNode INCLUDE() { return getToken(ScssParser.INCLUDE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(ScssParser.IDENTIFIER, 0); }
		public TerminalNode SEMI() { return getToken(ScssParser.SEMI, 0); }
		public TerminalNode LPAREN() { return getToken(ScssParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ScssParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ValuesContext values() {
			return getRuleContext(ValuesContext.class,0);
		}
		public IncludeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_includeDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterIncludeDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitIncludeDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitIncludeDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IncludeDeclarationContext includeDeclaration() throws RecognitionException {
		IncludeDeclarationContext _localctx = new IncludeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_includeDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(INCLUDE);
			setState(157);
			match(IDENTIFIER);
			setState(172);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SEMI:
				{
				setState(158);
				match(SEMI);
				}
				break;
			case EOF:
			case NUMBER:
			case NULL:
			case MIXIN:
			case FUNCTION:
			case AT_IF:
			case AT_FOR:
			case AT_WHILE:
			case AT_EACH:
			case INCLUDE:
			case IMPORT:
			case RETURN:
			case INTERPOLATION_START:
			case URL_BEG:
			case STRING:
			case COLOR:
			case IDENTIFIER:
			case LPAREN:
			case LBRACE:
			case RBRACE:
			case DOT:
			case DOLLAR:
			case AT:
			case AND:
			case HASH:
			case TIMES:
				{
				setState(167);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(159);
					match(LPAREN);
					setState(161);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMBER) | (1L << NULL) | (1L << INTERPOLATION_START) | (1L << URL_BEG) | (1L << STRING) | (1L << COLOR) | (1L << IDENTIFIER) | (1L << LPAREN) | (1L << DOLLAR))) != 0)) {
						{
						setState(160);
						values();
						}
					}

					setState(163);
					match(RPAREN);
					setState(165);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SEMI) {
						{
						setState(164);
						match(SEMI);
						}
					}

					}
					break;
				}
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACE) {
					{
					setState(169);
					block();
					}
				}

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

	public static class FunctionDeclarationContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(ScssParser.FUNCTION, 0); }
		public TerminalNode IDENTIFIER() { return getToken(ScssParser.IDENTIFIER, 0); }
		public TerminalNode LPAREN() { return getToken(ScssParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ScssParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(ScssParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ScssParser.RBRACE, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public FunctionBodyContext functionBody() {
			return getRuleContext(FunctionBodyContext.class,0);
		}
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitFunctionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_functionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(FUNCTION);
			setState(175);
			match(IDENTIFIER);
			setState(176);
			match(LPAREN);
			setState(178);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOLLAR) {
				{
				setState(177);
				params();
				}
			}

			setState(180);
			match(RPAREN);
			setState(181);
			match(LBRACE);
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMBER) | (1L << NULL) | (1L << MIXIN) | (1L << FUNCTION) | (1L << AT_IF) | (1L << AT_FOR) | (1L << AT_WHILE) | (1L << AT_EACH) | (1L << INCLUDE) | (1L << IMPORT) | (1L << RETURN) | (1L << INTERPOLATION_START) | (1L << URL_BEG) | (1L << STRING) | (1L << COLOR) | (1L << IDENTIFIER) | (1L << LPAREN) | (1L << DOT) | (1L << DOLLAR) | (1L << AT) | (1L << AND) | (1L << HASH) | (1L << TIMES))) != 0)) {
				{
				setState(182);
				functionBody();
				}
			}

			setState(185);
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

	public static class FunctionBodyContext extends ParserRuleContext {
		public FunctionReturnContext functionReturn() {
			return getRuleContext(FunctionReturnContext.class,0);
		}
		public List<FunctionStatementContext> functionStatement() {
			return getRuleContexts(FunctionStatementContext.class);
		}
		public FunctionStatementContext functionStatement(int i) {
			return getRuleContext(FunctionStatementContext.class,i);
		}
		public FunctionBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterFunctionBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitFunctionBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitFunctionBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionBodyContext functionBody() throws RecognitionException {
		FunctionBodyContext _localctx = new FunctionBodyContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_functionBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMBER) | (1L << NULL) | (1L << MIXIN) | (1L << FUNCTION) | (1L << AT_IF) | (1L << AT_FOR) | (1L << AT_WHILE) | (1L << AT_EACH) | (1L << INCLUDE) | (1L << IMPORT) | (1L << INTERPOLATION_START) | (1L << URL_BEG) | (1L << STRING) | (1L << COLOR) | (1L << IDENTIFIER) | (1L << LPAREN) | (1L << DOT) | (1L << DOLLAR) | (1L << AT) | (1L << AND) | (1L << HASH) | (1L << TIMES))) != 0)) {
				{
				{
				setState(187);
				functionStatement();
				}
				}
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(193);
			functionReturn();
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

	public static class FunctionReturnContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(ScssParser.RETURN, 0); }
		public CommandStatementContext commandStatement() {
			return getRuleContext(CommandStatementContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ScssParser.SEMI, 0); }
		public FunctionReturnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionReturn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterFunctionReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitFunctionReturn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitFunctionReturn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionReturnContext functionReturn() throws RecognitionException {
		FunctionReturnContext _localctx = new FunctionReturnContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_functionReturn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			match(RETURN);
			setState(196);
			commandStatement();
			setState(197);
			match(SEMI);
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

	public static class FunctionStatementContext extends ParserRuleContext {
		public CommandStatementContext commandStatement() {
			return getRuleContext(CommandStatementContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ScssParser.SEMI, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public FunctionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterFunctionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitFunctionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitFunctionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionStatementContext functionStatement() throws RecognitionException {
		FunctionStatementContext _localctx = new FunctionStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_functionStatement);
		try {
			setState(203);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(199);
				commandStatement();
				setState(200);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(202);
				statement();
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

	public static class CommandStatementContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(ScssParser.LPAREN, 0); }
		public CommandStatementContext commandStatement() {
			return getRuleContext(CommandStatementContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ScssParser.RPAREN, 0); }
		public MathStatementContext mathStatement() {
			return getRuleContext(MathStatementContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public CommandStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commandStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterCommandStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitCommandStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitCommandStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandStatementContext commandStatement() throws RecognitionException {
		CommandStatementContext _localctx = new CommandStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_commandStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
			case NULL:
			case INTERPOLATION_START:
			case URL_BEG:
			case STRING:
			case COLOR:
			case IDENTIFIER:
			case DOLLAR:
				{
				setState(206); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(205);
					expression();
					}
					}
					setState(208); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMBER) | (1L << NULL) | (1L << INTERPOLATION_START) | (1L << URL_BEG) | (1L << STRING) | (1L << COLOR) | (1L << IDENTIFIER) | (1L << DOLLAR))) != 0) );
				}
				break;
			case LPAREN:
				{
				setState(210);
				match(LPAREN);
				setState(211);
				commandStatement();
				setState(212);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << TIMES) | (1L << DIV) | (1L << MINUS) | (1L << PERC))) != 0)) {
				{
				setState(216);
				mathStatement();
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

	public static class MathCharacterContext extends ParserRuleContext {
		public TerminalNode TIMES() { return getToken(ScssParser.TIMES, 0); }
		public TerminalNode PLUS() { return getToken(ScssParser.PLUS, 0); }
		public TerminalNode DIV() { return getToken(ScssParser.DIV, 0); }
		public TerminalNode MINUS() { return getToken(ScssParser.MINUS, 0); }
		public TerminalNode PERC() { return getToken(ScssParser.PERC, 0); }
		public MathCharacterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mathCharacter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterMathCharacter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitMathCharacter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitMathCharacter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MathCharacterContext mathCharacter() throws RecognitionException {
		MathCharacterContext _localctx = new MathCharacterContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_mathCharacter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << TIMES) | (1L << DIV) | (1L << MINUS) | (1L << PERC))) != 0)) ) {
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

	public static class MathStatementContext extends ParserRuleContext {
		public MathCharacterContext mathCharacter() {
			return getRuleContext(MathCharacterContext.class,0);
		}
		public CommandStatementContext commandStatement() {
			return getRuleContext(CommandStatementContext.class,0);
		}
		public MathStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mathStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterMathStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitMathStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitMathStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MathStatementContext mathStatement() throws RecognitionException {
		MathStatementContext _localctx = new MathStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_mathStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			mathCharacter();
			setState(222);
			commandStatement();
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

	public static class ExpressionContext extends ParserRuleContext {
		public MeasurementContext measurement() {
			return getRuleContext(MeasurementContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode COLOR() { return getToken(ScssParser.COLOR, 0); }
		public TerminalNode STRING() { return getToken(ScssParser.STRING, 0); }
		public TerminalNode NULL() { return getToken(ScssParser.NULL, 0); }
		public UrlContext url() {
			return getRuleContext(UrlContext.class,0);
		}
		public VariableNameContext variableName() {
			return getRuleContext(VariableNameContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_expression);
		try {
			setState(232);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(224);
				measurement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(225);
				identifier();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(226);
				match(COLOR);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(227);
				match(STRING);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(228);
				match(NULL);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(229);
				url();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(230);
				variableName();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(231);
				functionCall();
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

	public static class IfDeclarationContext extends ParserRuleContext {
		public TerminalNode AT_IF() { return getToken(ScssParser.AT_IF, 0); }
		public ConditionsContext conditions() {
			return getRuleContext(ConditionsContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<ElseIfStatementContext> elseIfStatement() {
			return getRuleContexts(ElseIfStatementContext.class);
		}
		public ElseIfStatementContext elseIfStatement(int i) {
			return getRuleContext(ElseIfStatementContext.class,i);
		}
		public ElseStatementContext elseStatement() {
			return getRuleContext(ElseStatementContext.class,0);
		}
		public IfDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterIfDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitIfDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitIfDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfDeclarationContext ifDeclaration() throws RecognitionException {
		IfDeclarationContext _localctx = new IfDeclarationContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_ifDeclaration);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(AT_IF);
			setState(235);
			conditions();
			setState(236);
			block();
			setState(240);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(237);
					elseIfStatement();
					}
					} 
				}
				setState(242);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			setState(244);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AT_ELSE) {
				{
				setState(243);
				elseStatement();
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

	public static class ElseIfStatementContext extends ParserRuleContext {
		public TerminalNode AT_ELSE() { return getToken(ScssParser.AT_ELSE, 0); }
		public TerminalNode IF() { return getToken(ScssParser.IF, 0); }
		public ConditionsContext conditions() {
			return getRuleContext(ConditionsContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ElseIfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseIfStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterElseIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitElseIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitElseIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseIfStatementContext elseIfStatement() throws RecognitionException {
		ElseIfStatementContext _localctx = new ElseIfStatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_elseIfStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			match(AT_ELSE);
			setState(247);
			match(IF);
			setState(248);
			conditions();
			setState(249);
			block();
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

	public static class ElseStatementContext extends ParserRuleContext {
		public TerminalNode AT_ELSE() { return getToken(ScssParser.AT_ELSE, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterElseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitElseStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitElseStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseStatementContext elseStatement() throws RecognitionException {
		ElseStatementContext _localctx = new ElseStatementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_elseStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			match(AT_ELSE);
			setState(252);
			block();
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

	public static class ConditionsContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode COMBINE_COMPARE() { return getToken(ScssParser.COMBINE_COMPARE, 0); }
		public ConditionsContext conditions() {
			return getRuleContext(ConditionsContext.class,0);
		}
		public TerminalNode NULL() { return getToken(ScssParser.NULL, 0); }
		public ConditionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterConditions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitConditions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitConditions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionsContext conditions() throws RecognitionException {
		ConditionsContext _localctx = new ConditionsContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_conditions);
		try {
			setState(260);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(254);
				condition();
				setState(257);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(255);
					match(COMBINE_COMPARE);
					setState(256);
					conditions();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(259);
				match(NULL);
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

	public static class ConditionContext extends ParserRuleContext {
		public CommandStatementContext commandStatement() {
			return getRuleContext(CommandStatementContext.class,0);
		}
		public ConditionsContext conditions() {
			return getRuleContext(ConditionsContext.class,0);
		}
		public TerminalNode EQIV() { return getToken(ScssParser.EQIV, 0); }
		public TerminalNode LT() { return getToken(ScssParser.LT, 0); }
		public TerminalNode GT() { return getToken(ScssParser.GT, 0); }
		public TerminalNode NOTEQ() { return getToken(ScssParser.NOTEQ, 0); }
		public TerminalNode LPAREN() { return getToken(ScssParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ScssParser.RPAREN, 0); }
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_condition);
		int _la;
		try {
			setState(271);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(262);
				commandStatement();
				setState(265);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << LT) | (1L << EQIV) | (1L << NOTEQ))) != 0)) {
					{
					setState(263);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << LT) | (1L << EQIV) | (1L << NOTEQ))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(264);
					conditions();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(267);
				match(LPAREN);
				setState(268);
				conditions();
				setState(269);
				match(RPAREN);
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

	public static class VariableDeclarationContext extends ParserRuleContext {
		public VariableNameContext variableName() {
			return getRuleContext(VariableNameContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ScssParser.COLON, 0); }
		public ValuesContext values() {
			return getRuleContext(ValuesContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ScssParser.SEMI, 0); }
		public TerminalNode DEFAULT() { return getToken(ScssParser.DEFAULT, 0); }
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_variableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			variableName();
			setState(274);
			match(COLON);
			setState(275);
			values();
			setState(277);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(276);
				match(DEFAULT);
				}
			}

			setState(279);
			match(SEMI);
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

	public static class ForDeclarationContext extends ParserRuleContext {
		public Token from;
		public Token thru;
		public TerminalNode AT_FOR() { return getToken(ScssParser.AT_FOR, 0); }
		public VariableNameContext variableName() {
			return getRuleContext(VariableNameContext.class,0);
		}
		public TerminalNode FROM() { return getToken(ScssParser.FROM, 0); }
		public TerminalNode THROUGH() { return getToken(ScssParser.THROUGH, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<TerminalNode> NUMBER() { return getTokens(ScssParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(ScssParser.NUMBER, i);
		}
		public ForDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterForDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitForDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitForDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForDeclarationContext forDeclaration() throws RecognitionException {
		ForDeclarationContext _localctx = new ForDeclarationContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_forDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			match(AT_FOR);
			setState(282);
			variableName();
			setState(283);
			match(FROM);
			setState(284);
			((ForDeclarationContext)_localctx).from = match(NUMBER);
			setState(285);
			match(THROUGH);
			setState(286);
			((ForDeclarationContext)_localctx).thru = match(NUMBER);
			setState(287);
			block();
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

	public static class WhileDeclarationContext extends ParserRuleContext {
		public TerminalNode AT_WHILE() { return getToken(ScssParser.AT_WHILE, 0); }
		public ConditionsContext conditions() {
			return getRuleContext(ConditionsContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterWhileDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitWhileDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitWhileDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileDeclarationContext whileDeclaration() throws RecognitionException {
		WhileDeclarationContext _localctx = new WhileDeclarationContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_whileDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			match(AT_WHILE);
			setState(290);
			conditions();
			setState(291);
			block();
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

	public static class EachDeclarationContext extends ParserRuleContext {
		public TerminalNode AT_EACH() { return getToken(ScssParser.AT_EACH, 0); }
		public List<VariableNameContext> variableName() {
			return getRuleContexts(VariableNameContext.class);
		}
		public VariableNameContext variableName(int i) {
			return getRuleContext(VariableNameContext.class,i);
		}
		public TerminalNode IN() { return getToken(ScssParser.IN, 0); }
		public EachValueListContext eachValueList() {
			return getRuleContext(EachValueListContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(ScssParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ScssParser.COMMA, i);
		}
		public EachDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eachDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterEachDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitEachDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitEachDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EachDeclarationContext eachDeclaration() throws RecognitionException {
		EachDeclarationContext _localctx = new EachDeclarationContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_eachDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			match(AT_EACH);
			setState(294);
			variableName();
			setState(299);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(295);
				match(COMMA);
				setState(296);
				variableName();
				}
				}
				setState(301);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(302);
			match(IN);
			setState(303);
			eachValueList();
			setState(304);
			block();
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

	public static class EachValueListContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(ScssParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(ScssParser.IDENTIFIER, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ScssParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ScssParser.COMMA, i);
		}
		public List<IdentifierListOrMapContext> identifierListOrMap() {
			return getRuleContexts(IdentifierListOrMapContext.class);
		}
		public IdentifierListOrMapContext identifierListOrMap(int i) {
			return getRuleContext(IdentifierListOrMapContext.class,i);
		}
		public EachValueListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eachValueList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterEachValueList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitEachValueList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitEachValueList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EachValueListContext eachValueList() throws RecognitionException {
		EachValueListContext _localctx = new EachValueListContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_eachValueList);
		int _la;
		try {
			setState(322);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(306);
				match(IDENTIFIER);
				setState(311);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(307);
					match(COMMA);
					setState(308);
					match(IDENTIFIER);
					}
					}
					setState(313);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(314);
				identifierListOrMap();
				setState(319);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(315);
					match(COMMA);
					setState(316);
					identifierListOrMap();
					}
					}
					setState(321);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class IdentifierListOrMapContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(ScssParser.LPAREN, 0); }
		public List<IdentifierValueContext> identifierValue() {
			return getRuleContexts(IdentifierValueContext.class);
		}
		public IdentifierValueContext identifierValue(int i) {
			return getRuleContext(IdentifierValueContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(ScssParser.RPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(ScssParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ScssParser.COMMA, i);
		}
		public IdentifierListOrMapContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierListOrMap; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterIdentifierListOrMap(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitIdentifierListOrMap(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitIdentifierListOrMap(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierListOrMapContext identifierListOrMap() throws RecognitionException {
		IdentifierListOrMapContext _localctx = new IdentifierListOrMapContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_identifierListOrMap);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324);
			match(LPAREN);
			setState(325);
			identifierValue();
			setState(330);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(326);
				match(COMMA);
				setState(327);
				identifierValue();
				}
				}
				setState(332);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(333);
			match(RPAREN);
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

	public static class IdentifierValueContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ScssParser.COLON, 0); }
		public ValuesContext values() {
			return getRuleContext(ValuesContext.class,0);
		}
		public IdentifierValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterIdentifierValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitIdentifierValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitIdentifierValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierValueContext identifierValue() throws RecognitionException {
		IdentifierValueContext _localctx = new IdentifierValueContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_identifierValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
			identifier();
			setState(338);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(336);
				match(COLON);
				setState(337);
				values();
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

	public static class ImportDeclarationContext extends ParserRuleContext {
		public TerminalNode IMPORT() { return getToken(ScssParser.IMPORT, 0); }
		public ReferenceUrlContext referenceUrl() {
			return getRuleContext(ReferenceUrlContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ScssParser.SEMI, 0); }
		public MediaTypesContext mediaTypes() {
			return getRuleContext(MediaTypesContext.class,0);
		}
		public ImportDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterImportDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitImportDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitImportDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportDeclarationContext importDeclaration() throws RecognitionException {
		ImportDeclarationContext _localctx = new ImportDeclarationContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_importDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			match(IMPORT);
			setState(341);
			referenceUrl();
			setState(343);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(342);
				mediaTypes();
				}
			}

			setState(345);
			match(SEMI);
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

	public static class ReferenceUrlContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(ScssParser.STRING, 0); }
		public UrlContext url() {
			return getRuleContext(UrlContext.class,0);
		}
		public ReferenceUrlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_referenceUrl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterReferenceUrl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitReferenceUrl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitReferenceUrl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferenceUrlContext referenceUrl() throws RecognitionException {
		ReferenceUrlContext _localctx = new ReferenceUrlContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_referenceUrl);
		try {
			setState(349);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(347);
				match(STRING);
				}
				break;
			case URL_BEG:
				enterOuterAlt(_localctx, 2);
				{
				setState(348);
				url();
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

	public static class MediaTypesContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(ScssParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(ScssParser.IDENTIFIER, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ScssParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ScssParser.COMMA, i);
		}
		public MediaTypesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mediaTypes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterMediaTypes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitMediaTypes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitMediaTypes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MediaTypesContext mediaTypes() throws RecognitionException {
		MediaTypesContext _localctx = new MediaTypesContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_mediaTypes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(351);
			match(IDENTIFIER);
			setState(356);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(352);
				match(COMMA);
				setState(353);
				match(IDENTIFIER);
				}
				}
				setState(358);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class NestedContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(ScssParser.AT, 0); }
		public NestContext nest() {
			return getRuleContext(NestContext.class,0);
		}
		public SelectorsContext selectors() {
			return getRuleContext(SelectorsContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(ScssParser.LBRACE, 0); }
		public StylesheetContext stylesheet() {
			return getRuleContext(StylesheetContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(ScssParser.RBRACE, 0); }
		public NestedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nested; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterNested(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitNested(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitNested(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NestedContext nested() throws RecognitionException {
		NestedContext _localctx = new NestedContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_nested);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(359);
			match(AT);
			setState(360);
			nest();
			setState(361);
			selectors();
			setState(362);
			match(LBRACE);
			setState(363);
			stylesheet();
			setState(364);
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

	public static class NestContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(ScssParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(ScssParser.IDENTIFIER, i);
		}
		public TerminalNode AND() { return getToken(ScssParser.AND, 0); }
		public List<PseudoContext> pseudo() {
			return getRuleContexts(PseudoContext.class);
		}
		public PseudoContext pseudo(int i) {
			return getRuleContext(PseudoContext.class,i);
		}
		public NestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterNest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitNest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitNest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NestContext nest() throws RecognitionException {
		NestContext _localctx = new NestContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_nest);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(366);
			_la = _input.LA(1);
			if ( !(_la==IDENTIFIER || _la==AND) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(370);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(367);
					match(IDENTIFIER);
					}
					} 
				}
				setState(372);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			}
			setState(376);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COLON || _la==COLONCOLON) {
				{
				{
				setState(373);
				pseudo();
				}
				}
				setState(378);
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

	public static class RulesetContext extends ParserRuleContext {
		public SelectorsContext selectors() {
			return getRuleContext(SelectorsContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public RulesetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ruleset; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterRuleset(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitRuleset(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitRuleset(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RulesetContext ruleset() throws RecognitionException {
		RulesetContext _localctx = new RulesetContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_ruleset);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(379);
			selectors();
			setState(380);
			block();
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

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(ScssParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ScssParser.RBRACE, 0); }
		public List<PropertyContext> property() {
			return getRuleContexts(PropertyContext.class);
		}
		public PropertyContext property(int i) {
			return getRuleContext(PropertyContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(ScssParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(ScssParser.SEMI, i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_block);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(382);
			match(LBRACE);
			setState(389);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(387);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
					case 1:
						{
						setState(383);
						property();
						setState(384);
						match(SEMI);
						}
						break;
					case 2:
						{
						setState(386);
						statement();
						}
						break;
					}
					} 
				}
				setState(391);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			}
			setState(393);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INTERPOLATION_START || _la==IDENTIFIER) {
				{
				setState(392);
				property();
				}
			}

			setState(395);
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

	public static class SelectorsContext extends ParserRuleContext {
		public List<SelectorContext> selector() {
			return getRuleContexts(SelectorContext.class);
		}
		public SelectorContext selector(int i) {
			return getRuleContext(SelectorContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ScssParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ScssParser.COMMA, i);
		}
		public SelectorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectors; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterSelectors(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitSelectors(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitSelectors(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectorsContext selectors() throws RecognitionException {
		SelectorsContext _localctx = new SelectorsContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_selectors);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(397);
			selector();
			setState(402);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(398);
				match(COMMA);
				setState(399);
				selector();
				}
				}
				setState(404);
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

	public static class SelectorContext extends ParserRuleContext {
		public List<ElementContext> element() {
			return getRuleContexts(ElementContext.class);
		}
		public ElementContext element(int i) {
			return getRuleContext(ElementContext.class,i);
		}
		public List<SelectorPrefixContext> selectorPrefix() {
			return getRuleContexts(SelectorPrefixContext.class);
		}
		public SelectorPrefixContext selectorPrefix(int i) {
			return getRuleContext(SelectorPrefixContext.class,i);
		}
		public List<AttribContext> attrib() {
			return getRuleContexts(AttribContext.class);
		}
		public AttribContext attrib(int i) {
			return getRuleContext(AttribContext.class,i);
		}
		public PseudoContext pseudo() {
			return getRuleContext(PseudoContext.class,0);
		}
		public SelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterSelector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitSelector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitSelector(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectorContext selector() throws RecognitionException {
		SelectorContext _localctx = new SelectorContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_selector);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(406); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(405);
				element();
				}
				}
				setState(408); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTERPOLATION_START) | (1L << IDENTIFIER) | (1L << DOT) | (1L << AND) | (1L << HASH) | (1L << TIMES))) != 0) );
			setState(415);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << TIL) | (1L << PLUS))) != 0)) {
				{
				{
				setState(410);
				selectorPrefix();
				setState(411);
				element();
				}
				}
				setState(417);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(421);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACK) {
				{
				{
				setState(418);
				attrib();
				}
				}
				setState(423);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(425);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON || _la==COLONCOLON) {
				{
				setState(424);
				pseudo();
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

	public static class SelectorPrefixContext extends ParserRuleContext {
		public TerminalNode GT() { return getToken(ScssParser.GT, 0); }
		public TerminalNode PLUS() { return getToken(ScssParser.PLUS, 0); }
		public TerminalNode TIL() { return getToken(ScssParser.TIL, 0); }
		public SelectorPrefixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectorPrefix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterSelectorPrefix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitSelectorPrefix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitSelectorPrefix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectorPrefixContext selectorPrefix() throws RecognitionException {
		SelectorPrefixContext _localctx = new SelectorPrefixContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_selectorPrefix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(427);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << TIL) | (1L << PLUS))) != 0)) ) {
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

	public static class ElementContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode HASH() { return getToken(ScssParser.HASH, 0); }
		public TerminalNode DOT() { return getToken(ScssParser.DOT, 0); }
		public TerminalNode AND() { return getToken(ScssParser.AND, 0); }
		public TerminalNode TIMES() { return getToken(ScssParser.TIMES, 0); }
		public ElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementContext element() throws RecognitionException {
		ElementContext _localctx = new ElementContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_element);
		try {
			setState(436);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTERPOLATION_START:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(429);
				identifier();
				}
				break;
			case HASH:
				enterOuterAlt(_localctx, 2);
				{
				setState(430);
				match(HASH);
				setState(431);
				identifier();
				}
				break;
			case DOT:
				enterOuterAlt(_localctx, 3);
				{
				setState(432);
				match(DOT);
				setState(433);
				identifier();
				}
				break;
			case AND:
				enterOuterAlt(_localctx, 4);
				{
				setState(434);
				match(AND);
				}
				break;
			case TIMES:
				enterOuterAlt(_localctx, 5);
				{
				setState(435);
				match(TIMES);
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

	public static class PseudoContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ScssParser.IDENTIFIER, 0); }
		public TerminalNode COLON() { return getToken(ScssParser.COLON, 0); }
		public TerminalNode COLONCOLON() { return getToken(ScssParser.COLONCOLON, 0); }
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public PseudoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pseudo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterPseudo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitPseudo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitPseudo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PseudoContext pseudo() throws RecognitionException {
		PseudoContext _localctx = new PseudoContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_pseudo);
		int _la;
		try {
			setState(442);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(438);
				_la = _input.LA(1);
				if ( !(_la==COLON || _la==COLONCOLON) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(439);
				match(IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(440);
				_la = _input.LA(1);
				if ( !(_la==COLON || _la==COLONCOLON) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(441);
				functionCall();
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

	public static class AttribContext extends ParserRuleContext {
		public TerminalNode LBRACK() { return getToken(ScssParser.LBRACK, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(ScssParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(ScssParser.IDENTIFIER, i);
		}
		public TerminalNode RBRACK() { return getToken(ScssParser.RBRACK, 0); }
		public AttribRelateContext attribRelate() {
			return getRuleContext(AttribRelateContext.class,0);
		}
		public TerminalNode STRING() { return getToken(ScssParser.STRING, 0); }
		public AttribContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attrib; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterAttrib(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitAttrib(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitAttrib(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttribContext attrib() throws RecognitionException {
		AttribContext _localctx = new AttribContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_attrib);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(444);
			match(LBRACK);
			setState(445);
			match(IDENTIFIER);
			setState(449);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << PIPE_EQ) | (1L << TILD_EQ))) != 0)) {
				{
				setState(446);
				attribRelate();
				setState(447);
				_la = _input.LA(1);
				if ( !(_la==STRING || _la==IDENTIFIER) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(451);
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

	public static class AttribRelateContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(ScssParser.EQ, 0); }
		public TerminalNode TILD_EQ() { return getToken(ScssParser.TILD_EQ, 0); }
		public TerminalNode PIPE_EQ() { return getToken(ScssParser.PIPE_EQ, 0); }
		public AttribRelateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribRelate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterAttribRelate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitAttribRelate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitAttribRelate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttribRelateContext attribRelate() throws RecognitionException {
		AttribRelateContext _localctx = new AttribRelateContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_attribRelate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(453);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << PIPE_EQ) | (1L << TILD_EQ))) != 0)) ) {
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

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ScssParser.IDENTIFIER, 0); }
		public List<IdentifierPartContext> identifierPart() {
			return getRuleContexts(IdentifierPartContext.class);
		}
		public IdentifierPartContext identifierPart(int i) {
			return getRuleContext(IdentifierPartContext.class,i);
		}
		public TerminalNode INTERPOLATION_START() { return getToken(ScssParser.INTERPOLATION_START, 0); }
		public IdentifierVariableNameContext identifierVariableName() {
			return getRuleContext(IdentifierVariableNameContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(ScssParser.RBRACE, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_identifier);
		int _la;
		try {
			setState(471);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(455);
				match(IDENTIFIER);
				setState(459);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==InterpolationStartAfter || _la==IdentifierAfter) {
					{
					{
					setState(456);
					identifierPart();
					}
					}
					setState(461);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case INTERPOLATION_START:
				enterOuterAlt(_localctx, 2);
				{
				setState(462);
				match(INTERPOLATION_START);
				setState(463);
				identifierVariableName();
				setState(464);
				match(RBRACE);
				setState(468);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==InterpolationStartAfter || _la==IdentifierAfter) {
					{
					{
					setState(465);
					identifierPart();
					}
					}
					setState(470);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class IdentifierPartContext extends ParserRuleContext {
		public TerminalNode InterpolationStartAfter() { return getToken(ScssParser.InterpolationStartAfter, 0); }
		public IdentifierVariableNameContext identifierVariableName() {
			return getRuleContext(IdentifierVariableNameContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(ScssParser.RBRACE, 0); }
		public TerminalNode IdentifierAfter() { return getToken(ScssParser.IdentifierAfter, 0); }
		public IdentifierPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierPart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterIdentifierPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitIdentifierPart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitIdentifierPart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierPartContext identifierPart() throws RecognitionException {
		IdentifierPartContext _localctx = new IdentifierPartContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_identifierPart);
		try {
			setState(478);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case InterpolationStartAfter:
				enterOuterAlt(_localctx, 1);
				{
				setState(473);
				match(InterpolationStartAfter);
				setState(474);
				identifierVariableName();
				setState(475);
				match(RBRACE);
				}
				break;
			case IdentifierAfter:
				enterOuterAlt(_localctx, 2);
				{
				setState(477);
				match(IdentifierAfter);
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

	public static class IdentifierVariableNameContext extends ParserRuleContext {
		public TerminalNode DOLLAR() { return getToken(ScssParser.DOLLAR, 0); }
		public TerminalNode IDENTIFIER() { return getToken(ScssParser.IDENTIFIER, 0); }
		public TerminalNode IdentifierAfter() { return getToken(ScssParser.IdentifierAfter, 0); }
		public IdentifierVariableNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierVariableName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterIdentifierVariableName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitIdentifierVariableName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitIdentifierVariableName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierVariableNameContext identifierVariableName() throws RecognitionException {
		IdentifierVariableNameContext _localctx = new IdentifierVariableNameContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_identifierVariableName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(480);
			match(DOLLAR);
			setState(481);
			_la = _input.LA(1);
			if ( !(_la==IDENTIFIER || _la==IdentifierAfter) ) {
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

	public static class PropertyContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ScssParser.COLON, 0); }
		public ValuesContext values() {
			return getRuleContext(ValuesContext.class,0);
		}
		public PropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_property; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropertyContext property() throws RecognitionException {
		PropertyContext _localctx = new PropertyContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(483);
			identifier();
			setState(484);
			match(COLON);
			setState(485);
			values();
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

	public static class ValuesContext extends ParserRuleContext {
		public List<CommandStatementContext> commandStatement() {
			return getRuleContexts(CommandStatementContext.class);
		}
		public CommandStatementContext commandStatement(int i) {
			return getRuleContext(CommandStatementContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ScssParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ScssParser.COMMA, i);
		}
		public ValuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_values; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterValues(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitValues(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitValues(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValuesContext values() throws RecognitionException {
		ValuesContext _localctx = new ValuesContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_values);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(487);
			commandStatement();
			setState(492);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(488);
					match(COMMA);
					setState(489);
					commandStatement();
					}
					} 
				}
				setState(494);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
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

	public static class UrlContext extends ParserRuleContext {
		public TerminalNode URL_BEG() { return getToken(ScssParser.URL_BEG, 0); }
		public TerminalNode URL() { return getToken(ScssParser.URL, 0); }
		public TerminalNode URL_END() { return getToken(ScssParser.URL_END, 0); }
		public UrlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_url; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterUrl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitUrl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitUrl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UrlContext url() throws RecognitionException {
		UrlContext _localctx = new UrlContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_url);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(495);
			match(URL_BEG);
			setState(496);
			match(URL);
			setState(497);
			match(URL_END);
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

	public static class MeasurementContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(ScssParser.NUMBER, 0); }
		public TerminalNode UNIT() { return getToken(ScssParser.UNIT, 0); }
		public MeasurementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_measurement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterMeasurement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitMeasurement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitMeasurement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MeasurementContext measurement() throws RecognitionException {
		MeasurementContext _localctx = new MeasurementContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_measurement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(499);
			match(NUMBER);
			setState(501);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==UNIT) {
				{
				setState(500);
				match(UNIT);
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

	public static class FunctionCallContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ScssParser.IDENTIFIER, 0); }
		public TerminalNode LPAREN() { return getToken(ScssParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ScssParser.RPAREN, 0); }
		public ValuesContext values() {
			return getRuleContext(ValuesContext.class,0);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScssParserListener ) ((ScssParserListener)listener).exitFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ScssParserVisitor ) return ((ScssParserVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(503);
			match(IDENTIFIER);
			setState(504);
			match(LPAREN);
			setState(506);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMBER) | (1L << NULL) | (1L << INTERPOLATION_START) | (1L << URL_BEG) | (1L << STRING) | (1L << COLOR) | (1L << IDENTIFIER) | (1L << LPAREN) | (1L << DOLLAR))) != 0)) {
				{
				setState(505);
				values();
				}
			}

			setState(508);
			match(RPAREN);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3?\u0201\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\3\2\7\2"+
		"h\n\2\f\2\16\2k\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\5\3z\n\3\3\4\3\4\3\4\7\4\177\n\4\f\4\16\4\u0082\13\4\3\4\5\4\u0085"+
		"\n\4\3\5\3\5\5\5\u0089\n\5\3\6\3\6\3\6\3\7\3\7\6\7\u0090\n\7\r\7\16\7"+
		"\u0091\3\b\3\b\3\b\3\b\5\b\u0098\n\b\3\b\5\b\u009b\n\b\3\b\3\b\3\t\3\t"+
		"\3\t\3\t\3\t\5\t\u00a4\n\t\3\t\3\t\5\t\u00a8\n\t\5\t\u00aa\n\t\3\t\5\t"+
		"\u00ad\n\t\5\t\u00af\n\t\3\n\3\n\3\n\3\n\5\n\u00b5\n\n\3\n\3\n\3\n\5\n"+
		"\u00ba\n\n\3\n\3\n\3\13\7\13\u00bf\n\13\f\13\16\13\u00c2\13\13\3\13\3"+
		"\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\5\r\u00ce\n\r\3\16\6\16\u00d1\n\16"+
		"\r\16\16\16\u00d2\3\16\3\16\3\16\3\16\5\16\u00d9\n\16\3\16\5\16\u00dc"+
		"\n\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\5\21\u00eb\n\21\3\22\3\22\3\22\3\22\7\22\u00f1\n\22\f\22\16\22\u00f4"+
		"\13\22\3\22\5\22\u00f7\n\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3"+
		"\25\3\25\3\25\5\25\u0104\n\25\3\25\5\25\u0107\n\25\3\26\3\26\3\26\5\26"+
		"\u010c\n\26\3\26\3\26\3\26\3\26\5\26\u0112\n\26\3\27\3\27\3\27\3\27\5"+
		"\27\u0118\n\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31"+
		"\3\31\3\31\3\31\3\32\3\32\3\32\3\32\7\32\u012c\n\32\f\32\16\32\u012f\13"+
		"\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\7\33\u0138\n\33\f\33\16\33\u013b"+
		"\13\33\3\33\3\33\3\33\7\33\u0140\n\33\f\33\16\33\u0143\13\33\5\33\u0145"+
		"\n\33\3\34\3\34\3\34\3\34\7\34\u014b\n\34\f\34\16\34\u014e\13\34\3\34"+
		"\3\34\3\35\3\35\3\35\5\35\u0155\n\35\3\36\3\36\3\36\5\36\u015a\n\36\3"+
		"\36\3\36\3\37\3\37\5\37\u0160\n\37\3 \3 \3 \7 \u0165\n \f \16 \u0168\13"+
		" \3!\3!\3!\3!\3!\3!\3!\3\"\3\"\7\"\u0173\n\"\f\"\16\"\u0176\13\"\3\"\7"+
		"\"\u0179\n\"\f\"\16\"\u017c\13\"\3#\3#\3#\3$\3$\3$\3$\3$\7$\u0186\n$\f"+
		"$\16$\u0189\13$\3$\5$\u018c\n$\3$\3$\3%\3%\3%\7%\u0193\n%\f%\16%\u0196"+
		"\13%\3&\6&\u0199\n&\r&\16&\u019a\3&\3&\3&\7&\u01a0\n&\f&\16&\u01a3\13"+
		"&\3&\7&\u01a6\n&\f&\16&\u01a9\13&\3&\5&\u01ac\n&\3\'\3\'\3(\3(\3(\3(\3"+
		"(\3(\3(\5(\u01b7\n(\3)\3)\3)\3)\5)\u01bd\n)\3*\3*\3*\3*\3*\5*\u01c4\n"+
		"*\3*\3*\3+\3+\3,\3,\7,\u01cc\n,\f,\16,\u01cf\13,\3,\3,\3,\3,\7,\u01d5"+
		"\n,\f,\16,\u01d8\13,\5,\u01da\n,\3-\3-\3-\3-\3-\5-\u01e1\n-\3.\3.\3.\3"+
		"/\3/\3/\3/\3\60\3\60\3\60\7\60\u01ed\n\60\f\60\16\60\u01f0\13\60\3\61"+
		"\3\61\3\61\3\61\3\62\3\62\5\62\u01f8\n\62\3\63\3\63\3\63\5\63\u01fd\n"+
		"\63\3\63\3\63\3\63\2\2\64\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&"+
		"(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bd\2\n\3\2,\60\5\2  ##\64\65\4\2"+
		"\31\31**\4\2 !,,\4\2$$\67\67\4\2\27\27\31\31\3\2\61\63\4\2\31\31??\2\u0219"+
		"\2i\3\2\2\2\4y\3\2\2\2\6{\3\2\2\2\b\u0086\3\2\2\2\n\u008a\3\2\2\2\f\u008d"+
		"\3\2\2\2\16\u0093\3\2\2\2\20\u009e\3\2\2\2\22\u00b0\3\2\2\2\24\u00c0\3"+
		"\2\2\2\26\u00c5\3\2\2\2\30\u00cd\3\2\2\2\32\u00d8\3\2\2\2\34\u00dd\3\2"+
		"\2\2\36\u00df\3\2\2\2 \u00ea\3\2\2\2\"\u00ec\3\2\2\2$\u00f8\3\2\2\2&\u00fd"+
		"\3\2\2\2(\u0106\3\2\2\2*\u0111\3\2\2\2,\u0113\3\2\2\2.\u011b\3\2\2\2\60"+
		"\u0123\3\2\2\2\62\u0127\3\2\2\2\64\u0144\3\2\2\2\66\u0146\3\2\2\28\u0151"+
		"\3\2\2\2:\u0156\3\2\2\2<\u015f\3\2\2\2>\u0161\3\2\2\2@\u0169\3\2\2\2B"+
		"\u0170\3\2\2\2D\u017d\3\2\2\2F\u0180\3\2\2\2H\u018f\3\2\2\2J\u0198\3\2"+
		"\2\2L\u01ad\3\2\2\2N\u01b6\3\2\2\2P\u01bc\3\2\2\2R\u01be\3\2\2\2T\u01c7"+
		"\3\2\2\2V\u01d9\3\2\2\2X\u01e0\3\2\2\2Z\u01e2\3\2\2\2\\\u01e5\3\2\2\2"+
		"^\u01e9\3\2\2\2`\u01f1\3\2\2\2b\u01f5\3\2\2\2d\u01f9\3\2\2\2fh\5\4\3\2"+
		"gf\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3\2\2\2jl\3\2\2\2ki\3\2\2\2lm\7\2\2\3"+
		"m\3\3\2\2\2nz\5:\36\2oz\5@!\2pz\5D#\2qz\5\16\b\2rz\5\22\n\2sz\5,\27\2"+
		"tz\5\20\t\2uz\5\"\22\2vz\5.\30\2wz\5\60\31\2xz\5\62\32\2yn\3\2\2\2yo\3"+
		"\2\2\2yp\3\2\2\2yq\3\2\2\2yr\3\2\2\2ys\3\2\2\2yt\3\2\2\2yu\3\2\2\2yv\3"+
		"\2\2\2yw\3\2\2\2yx\3\2\2\2z\5\3\2\2\2{\u0080\5\b\5\2|}\7&\2\2}\177\5\b"+
		"\5\2~|\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081"+
		"\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0083\u0085\7\"\2\2\u0084\u0083\3\2"+
		"\2\2\u0084\u0085\3\2\2\2\u0085\7\3\2\2\2\u0086\u0088\5\n\6\2\u0087\u0089"+
		"\5\f\7\2\u0088\u0087\3\2\2\2\u0088\u0089\3\2\2\2\u0089\t\3\2\2\2\u008a"+
		"\u008b\7(\2\2\u008b\u008c\7\31\2\2\u008c\13\3\2\2\2\u008d\u008f\7$\2\2"+
		"\u008e\u0090\5 \21\2\u008f\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u008f"+
		"\3\2\2\2\u0091\u0092\3\2\2\2\u0092\r\3\2\2\2\u0093\u0094\7\t\2\2\u0094"+
		"\u009a\7\31\2\2\u0095\u0097\7\32\2\2\u0096\u0098\5\6\4\2\u0097\u0096\3"+
		"\2\2\2\u0097\u0098\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009b\7\33\2\2\u009a"+
		"\u0095\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009d\5F"+
		"$\2\u009d\17\3\2\2\2\u009e\u009f\7\21\2\2\u009f\u00ae\7\31\2\2\u00a0\u00af"+
		"\7%\2\2\u00a1\u00a3\7\32\2\2\u00a2\u00a4\5^\60\2\u00a3\u00a2\3\2\2\2\u00a3"+
		"\u00a4\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a7\7\33\2\2\u00a6\u00a8\7"+
		"%\2\2\u00a7\u00a6\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00aa\3\2\2\2\u00a9"+
		"\u00a1\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ac\3\2\2\2\u00ab\u00ad\5F"+
		"$\2\u00ac\u00ab\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00af\3\2\2\2\u00ae"+
		"\u00a0\3\2\2\2\u00ae\u00a9\3\2\2\2\u00af\21\3\2\2\2\u00b0\u00b1\7\n\2"+
		"\2\u00b1\u00b2\7\31\2\2\u00b2\u00b4\7\32\2\2\u00b3\u00b5\5\6\4\2\u00b4"+
		"\u00b3\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\7\33"+
		"\2\2\u00b7\u00b9\7\34\2\2\u00b8\u00ba\5\24\13\2\u00b9\u00b8\3\2\2\2\u00b9"+
		"\u00ba\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bc\7\35\2\2\u00bc\23\3\2\2"+
		"\2\u00bd\u00bf\5\30\r\2\u00be\u00bd\3\2\2\2\u00bf\u00c2\3\2\2\2\u00c0"+
		"\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c3\3\2\2\2\u00c2\u00c0\3\2"+
		"\2\2\u00c3\u00c4\5\26\f\2\u00c4\25\3\2\2\2\u00c5\u00c6\7\23\2\2\u00c6"+
		"\u00c7\5\32\16\2\u00c7\u00c8\7%\2\2\u00c8\27\3\2\2\2\u00c9\u00ca\5\32"+
		"\16\2\u00ca\u00cb\7%\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00ce\5\4\3\2\u00cd"+
		"\u00c9\3\2\2\2\u00cd\u00cc\3\2\2\2\u00ce\31\3\2\2\2\u00cf\u00d1\5 \21"+
		"\2\u00d0\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3"+
		"\3\2\2\2\u00d3\u00d9\3\2\2\2\u00d4\u00d5\7\32\2\2\u00d5\u00d6\5\32\16"+
		"\2\u00d6\u00d7\7\33\2\2\u00d7\u00d9\3\2\2\2\u00d8\u00d0\3\2\2\2\u00d8"+
		"\u00d4\3\2\2\2\u00d9\u00db\3\2\2\2\u00da\u00dc\5\36\20\2\u00db\u00da\3"+
		"\2\2\2\u00db\u00dc\3\2\2\2\u00dc\33\3\2\2\2\u00dd\u00de\t\2\2\2\u00de"+
		"\35\3\2\2\2\u00df\u00e0\5\34\17\2\u00e0\u00e1\5\32\16\2\u00e1\37\3\2\2"+
		"\2\u00e2\u00eb\5b\62\2\u00e3\u00eb\5V,\2\u00e4\u00eb\7\30\2\2\u00e5\u00eb"+
		"\7\27\2\2\u00e6\u00eb\7\5\2\2\u00e7\u00eb\5`\61\2\u00e8\u00eb\5\n\6\2"+
		"\u00e9\u00eb\5d\63\2\u00ea\u00e2\3\2\2\2\u00ea\u00e3\3\2\2\2\u00ea\u00e4"+
		"\3\2\2\2\u00ea\u00e5\3\2\2\2\u00ea\u00e6\3\2\2\2\u00ea\u00e7\3\2\2\2\u00ea"+
		"\u00e8\3\2\2\2\u00ea\u00e9\3\2\2\2\u00eb!\3\2\2\2\u00ec\u00ed\7\r\2\2"+
		"\u00ed\u00ee\5(\25\2\u00ee\u00f2\5F$\2\u00ef\u00f1\5$\23\2\u00f0\u00ef"+
		"\3\2\2\2\u00f1\u00f4\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3"+
		"\u00f6\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f5\u00f7\5&\24\2\u00f6\u00f5\3\2"+
		"\2\2\u00f6\u00f7\3\2\2\2\u00f7#\3\2\2\2\u00f8\u00f9\7\13\2\2\u00f9\u00fa"+
		"\7\f\2\2\u00fa\u00fb\5(\25\2\u00fb\u00fc\5F$\2\u00fc%\3\2\2\2\u00fd\u00fe"+
		"\7\13\2\2\u00fe\u00ff\5F$\2\u00ff\'\3\2\2\2\u0100\u0103\5*\26\2\u0101"+
		"\u0102\7\66\2\2\u0102\u0104\5(\25\2\u0103\u0101\3\2\2\2\u0103\u0104\3"+
		"\2\2\2\u0104\u0107\3\2\2\2\u0105\u0107\7\5\2\2\u0106\u0100\3\2\2\2\u0106"+
		"\u0105\3\2\2\2\u0107)\3\2\2\2\u0108\u010b\5\32\16\2\u0109\u010a\t\3\2"+
		"\2\u010a\u010c\5(\25\2\u010b\u0109\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u0112"+
		"\3\2\2\2\u010d\u010e\7\32\2\2\u010e\u010f\5(\25\2\u010f\u0110\7\33\2\2"+
		"\u0110\u0112\3\2\2\2\u0111\u0108\3\2\2\2\u0111\u010d\3\2\2\2\u0112+\3"+
		"\2\2\2\u0113\u0114\5\n\6\2\u0114\u0115\7$\2\2\u0115\u0117\5^\60\2\u0116"+
		"\u0118\7\24\2\2\u0117\u0116\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u0119\3"+
		"\2\2\2\u0119\u011a\7%\2\2\u011a-\3\2\2\2\u011b\u011c\7\16\2\2\u011c\u011d"+
		"\5\n\6\2\u011d\u011e\7\6\2\2\u011e\u011f\7\3\2\2\u011f\u0120\7\7\2\2\u0120"+
		"\u0121\7\3\2\2\u0121\u0122\5F$\2\u0122/\3\2\2\2\u0123\u0124\7\17\2\2\u0124"+
		"\u0125\5(\25\2\u0125\u0126\5F$\2\u0126\61\3\2\2\2\u0127\u0128\7\20\2\2"+
		"\u0128\u012d\5\n\6\2\u0129\u012a\7&\2\2\u012a\u012c\5\n\6\2\u012b\u0129"+
		"\3\2\2\2\u012c\u012f\3\2\2\2\u012d\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e"+
		"\u0130\3\2\2\2\u012f\u012d\3\2\2\2\u0130\u0131\7\b\2\2\u0131\u0132\5\64"+
		"\33\2\u0132\u0133\5F$\2\u0133\63\3\2\2\2\u0134\u0139\7\31\2\2\u0135\u0136"+
		"\7&\2\2\u0136\u0138\7\31\2\2\u0137\u0135\3\2\2\2\u0138\u013b\3\2\2\2\u0139"+
		"\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u0145\3\2\2\2\u013b\u0139\3\2"+
		"\2\2\u013c\u0141\5\66\34\2\u013d\u013e\7&\2\2\u013e\u0140\5\66\34\2\u013f"+
		"\u013d\3\2\2\2\u0140\u0143\3\2\2\2\u0141\u013f\3\2\2\2\u0141\u0142\3\2"+
		"\2\2\u0142\u0145\3\2\2\2\u0143\u0141\3\2\2\2\u0144\u0134\3\2\2\2\u0144"+
		"\u013c\3\2\2\2\u0145\65\3\2\2\2\u0146\u0147\7\32\2\2\u0147\u014c\58\35"+
		"\2\u0148\u0149\7&\2\2\u0149\u014b\58\35\2\u014a\u0148\3\2\2\2\u014b\u014e"+
		"\3\2\2\2\u014c\u014a\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u014f\3\2\2\2\u014e"+
		"\u014c\3\2\2\2\u014f\u0150\7\33\2\2\u0150\67\3\2\2\2\u0151\u0154\5V,\2"+
		"\u0152\u0153\7$\2\2\u0153\u0155\5^\60\2\u0154\u0152\3\2\2\2\u0154\u0155"+
		"\3\2\2\2\u01559\3\2\2\2\u0156\u0157\7\22\2\2\u0157\u0159\5<\37\2\u0158"+
		"\u015a\5> \2\u0159\u0158\3\2\2\2\u0159\u015a\3\2\2\2\u015a\u015b\3\2\2"+
		"\2\u015b\u015c\7%\2\2\u015c;\3\2\2\2\u015d\u0160\7\27\2\2\u015e\u0160"+
		"\5`\61\2\u015f\u015d\3\2\2\2\u015f\u015e\3\2\2\2\u0160=\3\2\2\2\u0161"+
		"\u0166\7\31\2\2\u0162\u0163\7&\2\2\u0163\u0165\7\31\2\2\u0164\u0162\3"+
		"\2\2\2\u0165\u0168\3\2\2\2\u0166\u0164\3\2\2\2\u0166\u0167\3\2\2\2\u0167"+
		"?\3\2\2\2\u0168\u0166\3\2\2\2\u0169\u016a\7)\2\2\u016a\u016b\5B\"\2\u016b"+
		"\u016c\5H%\2\u016c\u016d\7\34\2\2\u016d\u016e\5\2\2\2\u016e\u016f\7\35"+
		"\2\2\u016fA\3\2\2\2\u0170\u0174\t\4\2\2\u0171\u0173\7\31\2\2\u0172\u0171"+
		"\3\2\2\2\u0173\u0176\3\2\2\2\u0174\u0172\3\2\2\2\u0174\u0175\3\2\2\2\u0175"+
		"\u017a\3\2\2\2\u0176\u0174\3\2\2\2\u0177\u0179\5P)\2\u0178\u0177\3\2\2"+
		"\2\u0179\u017c\3\2\2\2\u017a\u0178\3\2\2\2\u017a\u017b\3\2\2\2\u017bC"+
		"\3\2\2\2\u017c\u017a\3\2\2\2\u017d\u017e\5H%\2\u017e\u017f\5F$\2\u017f"+
		"E\3\2\2\2\u0180\u0187\7\34\2\2\u0181\u0182\5\\/\2\u0182\u0183\7%\2\2\u0183"+
		"\u0186\3\2\2\2\u0184\u0186\5\4\3\2\u0185\u0181\3\2\2\2\u0185\u0184\3\2"+
		"\2\2\u0186\u0189\3\2\2\2\u0187\u0185\3\2\2\2\u0187\u0188\3\2\2\2\u0188"+
		"\u018b\3\2\2\2\u0189\u0187\3\2\2\2\u018a\u018c\5\\/\2\u018b\u018a\3\2"+
		"\2\2\u018b\u018c\3\2\2\2\u018c\u018d\3\2\2\2\u018d\u018e\7\35\2\2\u018e"+
		"G\3\2\2\2\u018f\u0194\5J&\2\u0190\u0191\7&\2\2\u0191\u0193\5J&\2\u0192"+
		"\u0190\3\2\2\2\u0193\u0196\3\2\2\2\u0194\u0192\3\2\2\2\u0194\u0195\3\2"+
		"\2\2\u0195I\3\2\2\2\u0196\u0194\3\2\2\2\u0197\u0199\5N(\2\u0198\u0197"+
		"\3\2\2\2\u0199\u019a\3\2\2\2\u019a\u0198\3\2\2\2\u019a\u019b\3\2\2\2\u019b"+
		"\u01a1\3\2\2\2\u019c\u019d\5L\'\2\u019d\u019e\5N(\2\u019e\u01a0\3\2\2"+
		"\2\u019f\u019c\3\2\2\2\u01a0\u01a3\3\2\2\2\u01a1\u019f\3\2\2\2\u01a1\u01a2"+
		"\3\2\2\2\u01a2\u01a7\3\2\2\2\u01a3\u01a1\3\2\2\2\u01a4\u01a6\5R*\2\u01a5"+
		"\u01a4\3\2\2\2\u01a6\u01a9\3\2\2\2\u01a7\u01a5\3\2\2\2\u01a7\u01a8\3\2"+
		"\2\2\u01a8\u01ab\3\2\2\2\u01a9\u01a7\3\2\2\2\u01aa\u01ac\5P)\2\u01ab\u01aa"+
		"\3\2\2\2\u01ab\u01ac\3\2\2\2\u01acK\3\2\2\2\u01ad\u01ae\t\5\2\2\u01ae"+
		"M\3\2\2\2\u01af\u01b7\5V,\2\u01b0\u01b1\7+\2\2\u01b1\u01b7\5V,\2\u01b2"+
		"\u01b3\7\'\2\2\u01b3\u01b7\5V,\2\u01b4\u01b7\7*\2\2\u01b5\u01b7\7-\2\2"+
		"\u01b6\u01af\3\2\2\2\u01b6\u01b0\3\2\2\2\u01b6\u01b2\3\2\2\2\u01b6\u01b4"+
		"\3\2\2\2\u01b6\u01b5\3\2\2\2\u01b7O\3\2\2\2\u01b8\u01b9\t\6\2\2\u01b9"+
		"\u01bd\7\31\2\2\u01ba\u01bb\t\6\2\2\u01bb\u01bd\5d\63\2\u01bc\u01b8\3"+
		"\2\2\2\u01bc\u01ba\3\2\2\2\u01bdQ\3\2\2\2\u01be\u01bf\7\36\2\2\u01bf\u01c3"+
		"\7\31\2\2\u01c0\u01c1\5T+\2\u01c1\u01c2\t\7\2\2\u01c2\u01c4\3\2\2\2\u01c3"+
		"\u01c0\3\2\2\2\u01c3\u01c4\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5\u01c6\7\37"+
		"\2\2\u01c6S\3\2\2\2\u01c7\u01c8\t\b\2\2\u01c8U\3\2\2\2\u01c9\u01cd\7\31"+
		"\2\2\u01ca\u01cc\5X-\2\u01cb\u01ca\3\2\2\2\u01cc\u01cf\3\2\2\2\u01cd\u01cb"+
		"\3\2\2\2\u01cd\u01ce\3\2\2\2\u01ce\u01da\3\2\2\2\u01cf\u01cd\3\2\2\2\u01d0"+
		"\u01d1\7\25\2\2\u01d1\u01d2\5Z.\2\u01d2\u01d6\7\35\2\2\u01d3\u01d5\5X"+
		"-\2\u01d4\u01d3\3\2\2\2\u01d5\u01d8\3\2\2\2\u01d6\u01d4\3\2\2\2\u01d6"+
		"\u01d7\3\2\2\2\u01d7\u01da\3\2\2\2\u01d8\u01d6\3\2\2\2\u01d9\u01c9\3\2"+
		"\2\2\u01d9\u01d0\3\2\2\2\u01daW\3\2\2\2\u01db\u01dc\7>\2\2\u01dc\u01dd"+
		"\5Z.\2\u01dd\u01de\7\35\2\2\u01de\u01e1\3\2\2\2\u01df\u01e1\7?\2\2\u01e0"+
		"\u01db\3\2\2\2\u01e0\u01df\3\2\2\2\u01e1Y\3\2\2\2\u01e2\u01e3\7(\2\2\u01e3"+
		"\u01e4\t\t\2\2\u01e4[\3\2\2\2\u01e5\u01e6\5V,\2\u01e6\u01e7\7$\2\2\u01e7"+
		"\u01e8\5^\60\2\u01e8]\3\2\2\2\u01e9\u01ee\5\32\16\2\u01ea\u01eb\7&\2\2"+
		"\u01eb\u01ed\5\32\16\2\u01ec\u01ea\3\2\2\2\u01ed\u01f0\3\2\2\2\u01ee\u01ec"+
		"\3\2\2\2\u01ee\u01ef\3\2\2\2\u01ef_\3\2\2\2\u01f0\u01ee\3\2\2\2\u01f1"+
		"\u01f2\7\26\2\2\u01f2\u01f3\7<\2\2\u01f3\u01f4\7;\2\2\u01f4a\3\2\2\2\u01f5"+
		"\u01f7\7\3\2\2\u01f6\u01f8\7\4\2\2\u01f7\u01f6\3\2\2\2\u01f7\u01f8\3\2"+
		"\2\2\u01f8c\3\2\2\2\u01f9\u01fa\7\31\2\2\u01fa\u01fc\7\32\2\2\u01fb\u01fd"+
		"\5^\60\2\u01fc\u01fb\3\2\2\2\u01fc\u01fd\3\2\2\2\u01fd\u01fe\3\2\2\2\u01fe"+
		"\u01ff\7\33\2\2\u01ffe\3\2\2\2;iy\u0080\u0084\u0088\u0091\u0097\u009a"+
		"\u00a3\u00a7\u00a9\u00ac\u00ae\u00b4\u00b9\u00c0\u00cd\u00d2\u00d8\u00db"+
		"\u00ea\u00f2\u00f6\u0103\u0106\u010b\u0111\u0117\u012d\u0139\u0141\u0144"+
		"\u014c\u0154\u0159\u015f\u0166\u0174\u017a\u0185\u0187\u018b\u0194\u019a"+
		"\u01a1\u01a7\u01ab\u01b6\u01bc\u01c3\u01cd\u01d6\u01d9\u01e0\u01ee\u01f7"+
		"\u01fc";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}