// Generated from D:/DevFiles/Eclipse/Tools/Editors/net.certiv.fluent.dt/net.certiv.fluent.dt.core/src/main/java/net/certiv/fluent/dt/core/lang/md/MdParser.g4 by ANTLR 4.7.2
 
	package net.certiv.fluent.dt.core.lang.md.gen;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MdParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WORD=1, RBOLD=2, RITALIC=3, RSTRIKE=4, RSPAN=5, RDSPAN=6, RDQUOTE=7, RSQUOTE=8, 
		COMMENT=9, URL=10, LSTYLE=11, LBRACK=12, IMAGE=13, LINK_SEP=14, REF_SEP=15, 
		DEF_SEP=16, RBRACK=17, RPAREN=18, CODE_BEG=19, CODE_SPAN=20, YAML_BLOCK=21, 
		HTML_BLOCK=22, MATH_BLOCK=23, TEX_BLOCK=24, UML_BLOCK=25, UNICODE=26, 
		ENTITY=27, TEX=28, HTML=29, MATH_SPAN=30, TABLE_DEF=31, PIPE=32, HRULE=33, 
		HASHES=34, DASHES=35, EQUALS=36, COLON=37, UNORDERED_MARK=38, NUMBER_MARK=39, 
		PAREN_MARK=40, UALPHA_MARK=41, LALPHA_MARK=42, LBOLD=43, LITALIC=44, LSTRIKE=45, 
		LSPAN=46, LDSPAN=47, LDQUOTE=48, LSQUOTE=49, LINE_BLANK=50, LINE_BREAK=51, 
		LINE_QUOTE=52, LINE_DENT=53, VWS=54, HWS=55, CHAR=56, ERR=57, HASH=58, 
		CHAR_h=59, RSTYLE=60, CLASS=61, ID=62, EQ=63, QUOTE=64, MARK=65, CHAR_s=66, 
		CODE_END=67, CHAR_b=68, CHAR_t=69;
	public static final int
		RULE_page = 0, RULE_yamlBlock = 1, RULE_htmlBlock = 2, RULE_mathBlock = 3, 
		RULE_texBlock = 4, RULE_umlBlock = 5, RULE_codeBlock = 6, RULE_header = 7, 
		RULE_hrule = 8, RULE_table = 9, RULE_tableRow = 10, RULE_list = 11, RULE_listItem = 12, 
		RULE_listMark = 13, RULE_definition = 14, RULE_paragraph = 15, RULE_line = 16, 
		RULE_link = 17, RULE_styledtext = 18, RULE_beg = 19, RULE_text = 20, RULE_word = 21, 
		RULE_style = 22, RULE_attrLeft = 23, RULE_attrRight = 24, RULE_comment = 25, 
		RULE_lnBlank = 26, RULE_lnBreak = 27, RULE_err = 28;
	private static String[] makeRuleNames() {
		return new String[] {
			"page", "yamlBlock", "htmlBlock", "mathBlock", "texBlock", "umlBlock", 
			"codeBlock", "header", "hrule", "table", "tableRow", "list", "listItem", 
			"listMark", "definition", "paragraph", "line", "link", "styledtext", 
			"beg", "text", "word", "style", "attrLeft", "attrRight", "comment", "lnBlank", 
			"lnBreak", "err"
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
			null, "WORD", "RBOLD", "RITALIC", "RSTRIKE", "RSPAN", "RDSPAN", "RDQUOTE", 
			"RSQUOTE", "COMMENT", "URL", "LSTYLE", "LBRACK", "IMAGE", "LINK_SEP", 
			"REF_SEP", "DEF_SEP", "RBRACK", "RPAREN", "CODE_BEG", "CODE_SPAN", "YAML_BLOCK", 
			"HTML_BLOCK", "MATH_BLOCK", "TEX_BLOCK", "UML_BLOCK", "UNICODE", "ENTITY", 
			"TEX", "HTML", "MATH_SPAN", "TABLE_DEF", "PIPE", "HRULE", "HASHES", "DASHES", 
			"EQUALS", "COLON", "UNORDERED_MARK", "NUMBER_MARK", "PAREN_MARK", "UALPHA_MARK", 
			"LALPHA_MARK", "LBOLD", "LITALIC", "LSTRIKE", "LSPAN", "LDSPAN", "LDQUOTE", 
			"LSQUOTE", "LINE_BLANK", "LINE_BREAK", "LINE_QUOTE", "LINE_DENT", "VWS", 
			"HWS", "CHAR", "ERR", "HASH", "CHAR_h", "RSTYLE", "CLASS", "ID", "EQ", 
			"QUOTE", "MARK", "CHAR_s", "CODE_END", "CHAR_b", "CHAR_t"
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
	public String getGrammarFileName() { return "MdParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MdParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class PageContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(MdParser.EOF, 0); }
		public List<YamlBlockContext> yamlBlock() {
			return getRuleContexts(YamlBlockContext.class);
		}
		public YamlBlockContext yamlBlock(int i) {
			return getRuleContext(YamlBlockContext.class,i);
		}
		public List<HtmlBlockContext> htmlBlock() {
			return getRuleContexts(HtmlBlockContext.class);
		}
		public HtmlBlockContext htmlBlock(int i) {
			return getRuleContext(HtmlBlockContext.class,i);
		}
		public List<MathBlockContext> mathBlock() {
			return getRuleContexts(MathBlockContext.class);
		}
		public MathBlockContext mathBlock(int i) {
			return getRuleContext(MathBlockContext.class,i);
		}
		public List<TexBlockContext> texBlock() {
			return getRuleContexts(TexBlockContext.class);
		}
		public TexBlockContext texBlock(int i) {
			return getRuleContext(TexBlockContext.class,i);
		}
		public List<UmlBlockContext> umlBlock() {
			return getRuleContexts(UmlBlockContext.class);
		}
		public UmlBlockContext umlBlock(int i) {
			return getRuleContext(UmlBlockContext.class,i);
		}
		public List<CodeBlockContext> codeBlock() {
			return getRuleContexts(CodeBlockContext.class);
		}
		public CodeBlockContext codeBlock(int i) {
			return getRuleContext(CodeBlockContext.class,i);
		}
		public List<HeaderContext> header() {
			return getRuleContexts(HeaderContext.class);
		}
		public HeaderContext header(int i) {
			return getRuleContext(HeaderContext.class,i);
		}
		public List<HruleContext> hrule() {
			return getRuleContexts(HruleContext.class);
		}
		public HruleContext hrule(int i) {
			return getRuleContext(HruleContext.class,i);
		}
		public List<TableContext> table() {
			return getRuleContexts(TableContext.class);
		}
		public TableContext table(int i) {
			return getRuleContext(TableContext.class,i);
		}
		public List<ListContext> list() {
			return getRuleContexts(ListContext.class);
		}
		public ListContext list(int i) {
			return getRuleContext(ListContext.class,i);
		}
		public List<ParagraphContext> paragraph() {
			return getRuleContexts(ParagraphContext.class);
		}
		public ParagraphContext paragraph(int i) {
			return getRuleContext(ParagraphContext.class,i);
		}
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
		}
		public List<LnBlankContext> lnBlank() {
			return getRuleContexts(LnBlankContext.class);
		}
		public LnBlankContext lnBlank(int i) {
			return getRuleContext(LnBlankContext.class,i);
		}
		public List<LnBreakContext> lnBreak() {
			return getRuleContexts(LnBreakContext.class);
		}
		public LnBreakContext lnBreak(int i) {
			return getRuleContext(LnBreakContext.class,i);
		}
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public List<ErrContext> err() {
			return getRuleContexts(ErrContext.class);
		}
		public ErrContext err(int i) {
			return getRuleContext(ErrContext.class,i);
		}
		public PageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_page; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterPage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitPage(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitPage(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PageContext page() throws RecognitionException {
		PageContext _localctx = new PageContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_page);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << COMMENT) | (1L << URL) | (1L << LBRACK) | (1L << IMAGE) | (1L << RPAREN) | (1L << CODE_BEG) | (1L << CODE_SPAN) | (1L << YAML_BLOCK) | (1L << HTML_BLOCK) | (1L << MATH_BLOCK) | (1L << TEX_BLOCK) | (1L << UML_BLOCK) | (1L << UNICODE) | (1L << ENTITY) | (1L << TEX) | (1L << HTML) | (1L << MATH_SPAN) | (1L << TABLE_DEF) | (1L << PIPE) | (1L << HRULE) | (1L << HASHES) | (1L << UNORDERED_MARK) | (1L << NUMBER_MARK) | (1L << PAREN_MARK) | (1L << UALPHA_MARK) | (1L << LALPHA_MARK) | (1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LSPAN) | (1L << LDSPAN) | (1L << LDQUOTE) | (1L << LSQUOTE) | (1L << LINE_BLANK) | (1L << LINE_BREAK) | (1L << ERR))) != 0)) {
				{
				setState(74);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(58);
					yamlBlock();
					}
					break;
				case 2:
					{
					setState(59);
					htmlBlock();
					}
					break;
				case 3:
					{
					setState(60);
					mathBlock();
					}
					break;
				case 4:
					{
					setState(61);
					texBlock();
					}
					break;
				case 5:
					{
					setState(62);
					umlBlock();
					}
					break;
				case 6:
					{
					setState(63);
					codeBlock();
					}
					break;
				case 7:
					{
					setState(64);
					header();
					}
					break;
				case 8:
					{
					setState(65);
					hrule();
					}
					break;
				case 9:
					{
					setState(66);
					table();
					}
					break;
				case 10:
					{
					setState(67);
					list();
					}
					break;
				case 11:
					{
					setState(68);
					paragraph();
					}
					break;
				case 12:
					{
					setState(69);
					definition();
					}
					break;
				case 13:
					{
					setState(70);
					lnBlank();
					}
					break;
				case 14:
					{
					setState(71);
					lnBreak();
					}
					break;
				case 15:
					{
					setState(72);
					comment();
					}
					break;
				case 16:
					{
					setState(73);
					err();
					}
					break;
				}
				}
				setState(78);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(79);
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

	public static class YamlBlockContext extends ParserRuleContext {
		public TerminalNode YAML_BLOCK() { return getToken(MdParser.YAML_BLOCK, 0); }
		public YamlBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yamlBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterYamlBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitYamlBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitYamlBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final YamlBlockContext yamlBlock() throws RecognitionException {
		YamlBlockContext _localctx = new YamlBlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_yamlBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(YAML_BLOCK);
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

	public static class HtmlBlockContext extends ParserRuleContext {
		public TerminalNode HTML_BLOCK() { return getToken(MdParser.HTML_BLOCK, 0); }
		public HtmlBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterHtmlBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitHtmlBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitHtmlBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlBlockContext htmlBlock() throws RecognitionException {
		HtmlBlockContext _localctx = new HtmlBlockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_htmlBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(HTML_BLOCK);
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

	public static class MathBlockContext extends ParserRuleContext {
		public TerminalNode MATH_BLOCK() { return getToken(MdParser.MATH_BLOCK, 0); }
		public MathBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mathBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterMathBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitMathBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitMathBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MathBlockContext mathBlock() throws RecognitionException {
		MathBlockContext _localctx = new MathBlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_mathBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(MATH_BLOCK);
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

	public static class TexBlockContext extends ParserRuleContext {
		public TerminalNode TEX_BLOCK() { return getToken(MdParser.TEX_BLOCK, 0); }
		public TexBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_texBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterTexBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitTexBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitTexBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TexBlockContext texBlock() throws RecognitionException {
		TexBlockContext _localctx = new TexBlockContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_texBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(TEX_BLOCK);
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

	public static class UmlBlockContext extends ParserRuleContext {
		public TerminalNode UML_BLOCK() { return getToken(MdParser.UML_BLOCK, 0); }
		public UmlBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_umlBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterUmlBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitUmlBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitUmlBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UmlBlockContext umlBlock() throws RecognitionException {
		UmlBlockContext _localctx = new UmlBlockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_umlBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(UML_BLOCK);
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

	public static class CodeBlockContext extends ParserRuleContext {
		public Token lang;
		public TerminalNode CODE_BEG() { return getToken(MdParser.CODE_BEG, 0); }
		public TerminalNode CODE_END() { return getToken(MdParser.CODE_END, 0); }
		public StyleContext style() {
			return getRuleContext(StyleContext.class,0);
		}
		public List<TerminalNode> VWS() { return getTokens(MdParser.VWS); }
		public TerminalNode VWS(int i) {
			return getToken(MdParser.VWS, i);
		}
		public List<TerminalNode> WORD() { return getTokens(MdParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(MdParser.WORD, i);
		}
		public CodeBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_codeBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterCodeBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitCodeBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitCodeBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CodeBlockContext codeBlock() throws RecognitionException {
		CodeBlockContext _localctx = new CodeBlockContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_codeBlock);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(CODE_BEG);
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WORD) {
				{
				setState(92);
				((CodeBlockContext)_localctx).lang = match(WORD);
				}
			}

			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LSTYLE) {
				{
				setState(95);
				style();
				}
			}

			setState(99); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(98);
					match(VWS);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(101); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WORD || _la==VWS) {
				{
				{
				setState(103);
				_la = _input.LA(1);
				if ( !(_la==WORD || _la==VWS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(109);
			match(CODE_END);
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

	public static class HeaderContext extends ParserRuleContext {
		public TerminalNode HASHES() { return getToken(MdParser.HASHES, 0); }
		public LineContext line() {
			return getRuleContext(LineContext.class,0);
		}
		public List<TerminalNode> HASH() { return getTokens(MdParser.HASH); }
		public TerminalNode HASH(int i) {
			return getToken(MdParser.HASH, i);
		}
		public StyleContext style() {
			return getRuleContext(StyleContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(MdParser.EQUALS, 0); }
		public TerminalNode DASHES() { return getToken(MdParser.DASHES, 0); }
		public HeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitHeader(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_header);
		int _la;
		try {
			setState(125);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HASHES:
				enterOuterAlt(_localctx, 1);
				{
				setState(111);
				match(HASHES);
				setState(112);
				line();
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==HASH) {
					{
					{
					setState(113);
					match(HASH);
					}
					}
					setState(118);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LSTYLE) {
					{
					setState(119);
					style();
					}
				}

				}
				break;
			case WORD:
			case URL:
			case LBRACK:
			case IMAGE:
			case RPAREN:
			case CODE_SPAN:
			case UNICODE:
			case ENTITY:
			case TEX:
			case HTML:
			case MATH_SPAN:
			case LBOLD:
			case LITALIC:
			case LSTRIKE:
			case LSPAN:
			case LDSPAN:
			case LDQUOTE:
			case LSQUOTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(122);
				line();
				setState(123);
				_la = _input.LA(1);
				if ( !(_la==DASHES || _la==EQUALS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
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

	public static class HruleContext extends ParserRuleContext {
		public TerminalNode HRULE() { return getToken(MdParser.HRULE, 0); }
		public StyleContext style() {
			return getRuleContext(StyleContext.class,0);
		}
		public HruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hrule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterHrule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitHrule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitHrule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HruleContext hrule() throws RecognitionException {
		HruleContext _localctx = new HruleContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_hrule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(HRULE);
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LSTYLE) {
				{
				setState(128);
				style();
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

	public static class TableContext extends ParserRuleContext {
		public TerminalNode TABLE_DEF() { return getToken(MdParser.TABLE_DEF, 0); }
		public List<TableRowContext> tableRow() {
			return getRuleContexts(TableRowContext.class);
		}
		public TableRowContext tableRow(int i) {
			return getRuleContext(TableRowContext.class,i);
		}
		public StyleContext style() {
			return getRuleContext(StyleContext.class,0);
		}
		public TableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitTable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableContext table() throws RecognitionException {
		TableContext _localctx = new TableContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_table);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << URL) | (1L << LBRACK) | (1L << IMAGE) | (1L << RPAREN) | (1L << CODE_SPAN) | (1L << UNICODE) | (1L << ENTITY) | (1L << TEX) | (1L << HTML) | (1L << MATH_SPAN) | (1L << PIPE) | (1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LSPAN) | (1L << LDSPAN) | (1L << LDQUOTE) | (1L << LSQUOTE))) != 0)) {
				{
				{
				setState(131);
				tableRow();
				}
				}
				setState(136);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(137);
			match(TABLE_DEF);
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LSTYLE) {
				{
				setState(138);
				style();
				}
			}

			setState(144);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(141);
					tableRow();
					}
					} 
				}
				setState(146);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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

	public static class TableRowContext extends ParserRuleContext {
		public List<TerminalNode> PIPE() { return getTokens(MdParser.PIPE); }
		public TerminalNode PIPE(int i) {
			return getToken(MdParser.PIPE, i);
		}
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public TableRowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableRow; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterTableRow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitTableRow(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitTableRow(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableRowContext tableRow() throws RecognitionException {
		TableRowContext _localctx = new TableRowContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_tableRow);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(147);
				match(PIPE);
				}
				break;
			}
			setState(154); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(151);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << URL) | (1L << LBRACK) | (1L << IMAGE) | (1L << RPAREN) | (1L << CODE_SPAN) | (1L << UNICODE) | (1L << ENTITY) | (1L << TEX) | (1L << HTML) | (1L << MATH_SPAN) | (1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LSPAN) | (1L << LDSPAN) | (1L << LDQUOTE) | (1L << LSQUOTE))) != 0)) {
						{
						setState(150);
						line();
						}
					}

					setState(153);
					match(PIPE);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(156); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(159);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(158);
				line();
				}
				break;
			}
			setState(162);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(161);
				match(PIPE);
				}
				break;
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

	public static class ListContext extends ParserRuleContext {
		public List<ListItemContext> listItem() {
			return getRuleContexts(ListItemContext.class);
		}
		public ListItemContext listItem(int i) {
			return getRuleContext(ListItemContext.class,i);
		}
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(165); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(164);
					listItem();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(167); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class ListItemContext extends ParserRuleContext {
		public ListMarkContext listMark() {
			return getRuleContext(ListMarkContext.class,0);
		}
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public List<LnBreakContext> lnBreak() {
			return getRuleContexts(LnBreakContext.class);
		}
		public LnBreakContext lnBreak(int i) {
			return getRuleContext(LnBreakContext.class,i);
		}
		public ListItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterListItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitListItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitListItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListItemContext listItem() throws RecognitionException {
		ListItemContext _localctx = new ListItemContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_listItem);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			listMark();
			setState(176);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(170);
					line();
					setState(172);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						setState(171);
						lnBreak();
						}
						break;
					}
					}
					} 
				}
				setState(178);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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

	public static class ListMarkContext extends ParserRuleContext {
		public Token mark;
		public TerminalNode UNORDERED_MARK() { return getToken(MdParser.UNORDERED_MARK, 0); }
		public TerminalNode NUMBER_MARK() { return getToken(MdParser.NUMBER_MARK, 0); }
		public TerminalNode PAREN_MARK() { return getToken(MdParser.PAREN_MARK, 0); }
		public TerminalNode UALPHA_MARK() { return getToken(MdParser.UALPHA_MARK, 0); }
		public TerminalNode LALPHA_MARK() { return getToken(MdParser.LALPHA_MARK, 0); }
		public ListMarkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listMark; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterListMark(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitListMark(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitListMark(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListMarkContext listMark() throws RecognitionException {
		ListMarkContext _localctx = new ListMarkContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_listMark);
		try {
			setState(184);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case UNORDERED_MARK:
				enterOuterAlt(_localctx, 1);
				{
				setState(179);
				((ListMarkContext)_localctx).mark = match(UNORDERED_MARK);
				}
				break;
			case NUMBER_MARK:
				enterOuterAlt(_localctx, 2);
				{
				setState(180);
				((ListMarkContext)_localctx).mark = match(NUMBER_MARK);
				}
				break;
			case PAREN_MARK:
				enterOuterAlt(_localctx, 3);
				{
				setState(181);
				((ListMarkContext)_localctx).mark = match(PAREN_MARK);
				}
				break;
			case UALPHA_MARK:
				enterOuterAlt(_localctx, 4);
				{
				setState(182);
				((ListMarkContext)_localctx).mark = match(UALPHA_MARK);
				}
				break;
			case LALPHA_MARK:
				enterOuterAlt(_localctx, 5);
				{
				setState(183);
				((ListMarkContext)_localctx).mark = match(LALPHA_MARK);
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

	public static class DefinitionContext extends ParserRuleContext {
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public List<TerminalNode> COLON() { return getTokens(MdParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(MdParser.COLON, i);
		}
		public List<LnBreakContext> lnBreak() {
			return getRuleContexts(LnBreakContext.class);
		}
		public LnBreakContext lnBreak(int i) {
			return getRuleContext(LnBreakContext.class,i);
		}
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_definition);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			line();
			setState(197); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(187);
				match(COLON);
				setState(188);
				line();
				setState(194);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(189);
						lnBreak();
						setState(190);
						line();
						}
						} 
					}
					setState(196);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
				}
				}
				}
				setState(199); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==COLON );
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

	public static class ParagraphContext extends ParserRuleContext {
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public List<LnBreakContext> lnBreak() {
			return getRuleContexts(LnBreakContext.class);
		}
		public LnBreakContext lnBreak(int i) {
			return getRuleContext(LnBreakContext.class,i);
		}
		public ParagraphContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paragraph; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterParagraph(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitParagraph(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitParagraph(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParagraphContext paragraph() throws RecognitionException {
		ParagraphContext _localctx = new ParagraphContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_paragraph);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			line();
			setState(207);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(202);
					lnBreak();
					setState(203);
					line();
					}
					} 
				}
				setState(209);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
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

	public static class LineContext extends ParserRuleContext {
		public List<WordContext> word() {
			return getRuleContexts(WordContext.class);
		}
		public WordContext word(int i) {
			return getRuleContext(WordContext.class,i);
		}
		public List<LinkContext> link() {
			return getRuleContexts(LinkContext.class);
		}
		public LinkContext link(int i) {
			return getRuleContext(LinkContext.class,i);
		}
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_line);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(212); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(212);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case WORD:
					case URL:
					case RPAREN:
					case CODE_SPAN:
					case UNICODE:
					case ENTITY:
					case TEX:
					case HTML:
					case MATH_SPAN:
					case LBOLD:
					case LITALIC:
					case LSTRIKE:
					case LSPAN:
					case LDSPAN:
					case LDQUOTE:
					case LSQUOTE:
						{
						setState(210);
						word();
						}
						break;
					case LBRACK:
					case IMAGE:
						{
						setState(211);
						link();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(214); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class LinkContext extends ParserRuleContext {
		public TerminalNode LINK_SEP() { return getToken(MdParser.LINK_SEP, 0); }
		public TerminalNode URL() { return getToken(MdParser.URL, 0); }
		public TerminalNode RPAREN() { return getToken(MdParser.RPAREN, 0); }
		public TerminalNode IMAGE() { return getToken(MdParser.IMAGE, 0); }
		public TerminalNode LBRACK() { return getToken(MdParser.LBRACK, 0); }
		public LinkContext link() {
			return getRuleContext(LinkContext.class,0);
		}
		public List<TextContext> text() {
			return getRuleContexts(TextContext.class);
		}
		public TextContext text(int i) {
			return getRuleContext(TextContext.class,i);
		}
		public TerminalNode LDQUOTE() { return getToken(MdParser.LDQUOTE, 0); }
		public TerminalNode RDQUOTE() { return getToken(MdParser.RDQUOTE, 0); }
		public StyleContext style() {
			return getRuleContext(StyleContext.class,0);
		}
		public TerminalNode REF_SEP() { return getToken(MdParser.REF_SEP, 0); }
		public TerminalNode RBRACK() { return getToken(MdParser.RBRACK, 0); }
		public TerminalNode DEF_SEP() { return getToken(MdParser.DEF_SEP, 0); }
		public LinkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_link; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterLink(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitLink(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitLink(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LinkContext link() throws RecognitionException {
		LinkContext _localctx = new LinkContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_link);
		int _la;
		try {
			setState(268);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(216);
				_la = _input.LA(1);
				if ( !(_la==LBRACK || _la==IMAGE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(219);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LBRACK:
				case IMAGE:
					{
					setState(217);
					link();
					}
					break;
				case WORD:
				case URL:
				case RPAREN:
				case CODE_SPAN:
				case UNICODE:
				case ENTITY:
				case TEX:
				case HTML:
				case MATH_SPAN:
				case LBOLD:
				case LITALIC:
				case LSTRIKE:
				case LSPAN:
				case LDSPAN:
				case LDQUOTE:
				case LSQUOTE:
					{
					setState(218);
					text();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(221);
				match(LINK_SEP);
				setState(222);
				match(URL);
				setState(227);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LDQUOTE) {
					{
					setState(223);
					match(LDQUOTE);
					setState(224);
					text();
					setState(225);
					match(RDQUOTE);
					}
				}

				setState(229);
				match(RPAREN);
				setState(231);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
				case 1:
					{
					setState(230);
					style();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(233);
				_la = _input.LA(1);
				if ( !(_la==LBRACK || _la==IMAGE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(236);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LBRACK:
				case IMAGE:
					{
					setState(234);
					link();
					}
					break;
				case WORD:
				case URL:
				case RPAREN:
				case CODE_SPAN:
				case UNICODE:
				case ENTITY:
				case TEX:
				case HTML:
				case MATH_SPAN:
				case LBOLD:
				case LITALIC:
				case LSTRIKE:
				case LSPAN:
				case LDSPAN:
				case LDQUOTE:
				case LSQUOTE:
					{
					setState(235);
					text();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(238);
				match(REF_SEP);
				setState(239);
				text();
				setState(240);
				match(RBRACK);
				setState(242);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
				case 1:
					{
					setState(241);
					style();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(244);
				_la = _input.LA(1);
				if ( !(_la==LBRACK || _la==IMAGE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(246);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << URL) | (1L << RPAREN) | (1L << CODE_SPAN) | (1L << UNICODE) | (1L << ENTITY) | (1L << TEX) | (1L << HTML) | (1L << MATH_SPAN) | (1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LSPAN) | (1L << LDSPAN) | (1L << LDQUOTE) | (1L << LSQUOTE))) != 0)) {
					{
					setState(245);
					text();
					}
				}

				setState(248);
				match(RBRACK);
				setState(250);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
				case 1:
					{
					setState(249);
					style();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(252);
				_la = _input.LA(1);
				if ( !(_la==LBRACK || _la==IMAGE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(253);
				match(URL);
				setState(254);
				match(RBRACK);
				setState(256);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
				case 1:
					{
					setState(255);
					style();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(258);
				match(LBRACK);
				setState(259);
				text();
				setState(260);
				match(DEF_SEP);
				setState(261);
				match(URL);
				setState(266);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
				case 1:
					{
					setState(262);
					match(LDQUOTE);
					setState(263);
					text();
					setState(264);
					match(RDQUOTE);
					}
					break;
				}
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

	public static class StyledtextContext extends ParserRuleContext {
		public BegContext beg() {
			return getRuleContext(BegContext.class,0);
		}
		public List<AttrRightContext> attrRight() {
			return getRuleContexts(AttrRightContext.class);
		}
		public AttrRightContext attrRight(int i) {
			return getRuleContext(AttrRightContext.class,i);
		}
		public StyledtextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_styledtext; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterStyledtext(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitStyledtext(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitStyledtext(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StyledtextContext styledtext() throws RecognitionException {
		StyledtextContext _localctx = new StyledtextContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_styledtext);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			beg();
			setState(272); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(271);
				attrRight();
				}
				}
				setState(274); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RBOLD) | (1L << RITALIC) | (1L << RSTRIKE) | (1L << RSPAN) | (1L << RDSPAN) | (1L << RDQUOTE) | (1L << RSQUOTE))) != 0) );
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

	public static class BegContext extends ParserRuleContext {
		public List<AttrLeftContext> attrLeft() {
			return getRuleContexts(AttrLeftContext.class);
		}
		public AttrLeftContext attrLeft(int i) {
			return getRuleContext(AttrLeftContext.class,i);
		}
		public List<WordContext> word() {
			return getRuleContexts(WordContext.class);
		}
		public WordContext word(int i) {
			return getRuleContext(WordContext.class,i);
		}
		public BegContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_beg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterBeg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitBeg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitBeg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BegContext beg() throws RecognitionException {
		BegContext _localctx = new BegContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_beg);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(277); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(276);
					attrLeft();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(279); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(282); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(281);
				word();
				}
				}
				setState(284); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << URL) | (1L << RPAREN) | (1L << CODE_SPAN) | (1L << UNICODE) | (1L << ENTITY) | (1L << TEX) | (1L << HTML) | (1L << MATH_SPAN) | (1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LSPAN) | (1L << LDSPAN) | (1L << LDQUOTE) | (1L << LSQUOTE))) != 0) );
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

	public static class TextContext extends ParserRuleContext {
		public List<WordContext> word() {
			return getRuleContexts(WordContext.class);
		}
		public WordContext word(int i) {
			return getRuleContext(WordContext.class,i);
		}
		public TextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_text; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitText(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextContext text() throws RecognitionException {
		TextContext _localctx = new TextContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_text);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(286);
				word();
				}
				}
				setState(289); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << URL) | (1L << RPAREN) | (1L << CODE_SPAN) | (1L << UNICODE) | (1L << ENTITY) | (1L << TEX) | (1L << HTML) | (1L << MATH_SPAN) | (1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LSPAN) | (1L << LDSPAN) | (1L << LDQUOTE) | (1L << LSQUOTE))) != 0) );
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

	public static class WordContext extends ParserRuleContext {
		public Token w;
		public TerminalNode WORD() { return getToken(MdParser.WORD, 0); }
		public TerminalNode RPAREN() { return getToken(MdParser.RPAREN, 0); }
		public TerminalNode CODE_SPAN() { return getToken(MdParser.CODE_SPAN, 0); }
		public TerminalNode MATH_SPAN() { return getToken(MdParser.MATH_SPAN, 0); }
		public TerminalNode UNICODE() { return getToken(MdParser.UNICODE, 0); }
		public TerminalNode ENTITY() { return getToken(MdParser.ENTITY, 0); }
		public TerminalNode HTML() { return getToken(MdParser.HTML, 0); }
		public TerminalNode TEX() { return getToken(MdParser.TEX, 0); }
		public TerminalNode URL() { return getToken(MdParser.URL, 0); }
		public List<AttrLeftContext> attrLeft() {
			return getRuleContexts(AttrLeftContext.class);
		}
		public AttrLeftContext attrLeft(int i) {
			return getRuleContext(AttrLeftContext.class,i);
		}
		public List<AttrRightContext> attrRight() {
			return getRuleContexts(AttrRightContext.class);
		}
		public AttrRightContext attrRight(int i) {
			return getRuleContext(AttrRightContext.class,i);
		}
		public WordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_word; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterWord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitWord(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitWord(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WordContext word() throws RecognitionException {
		WordContext _localctx = new WordContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_word);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LSPAN) | (1L << LDSPAN) | (1L << LDQUOTE) | (1L << LSQUOTE))) != 0)) {
				{
				{
				setState(291);
				attrLeft();
				}
				}
				setState(296);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(297);
			((WordContext)_localctx).w = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << URL) | (1L << RPAREN) | (1L << CODE_SPAN) | (1L << UNICODE) | (1L << ENTITY) | (1L << TEX) | (1L << HTML) | (1L << MATH_SPAN))) != 0)) ) {
				((WordContext)_localctx).w = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(301);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(298);
					attrRight();
					}
					} 
				}
				setState(303);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
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

	public static class StyleContext extends ParserRuleContext {
		public TerminalNode LSTYLE() { return getToken(MdParser.LSTYLE, 0); }
		public TerminalNode RSTYLE() { return getToken(MdParser.RSTYLE, 0); }
		public List<TerminalNode> CLASS() { return getTokens(MdParser.CLASS); }
		public TerminalNode CLASS(int i) {
			return getToken(MdParser.CLASS, i);
		}
		public List<TerminalNode> WORD() { return getTokens(MdParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(MdParser.WORD, i);
		}
		public List<TerminalNode> ID() { return getTokens(MdParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MdParser.ID, i);
		}
		public List<TerminalNode> EQ() { return getTokens(MdParser.EQ); }
		public TerminalNode EQ(int i) {
			return getToken(MdParser.EQ, i);
		}
		public List<TerminalNode> QUOTE() { return getTokens(MdParser.QUOTE); }
		public TerminalNode QUOTE(int i) {
			return getToken(MdParser.QUOTE, i);
		}
		public List<TerminalNode> MARK() { return getTokens(MdParser.MARK); }
		public TerminalNode MARK(int i) {
			return getToken(MdParser.MARK, i);
		}
		public StyleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_style; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterStyle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitStyle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitStyle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StyleContext style() throws RecognitionException {
		StyleContext _localctx = new StyleContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_style);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			match(LSTYLE);
			setState(327); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(327);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CLASS:
					{
					setState(305);
					match(CLASS);
					setState(306);
					match(WORD);
					}
					break;
				case ID:
					{
					setState(307);
					match(ID);
					setState(308);
					match(WORD);
					}
					break;
				case WORD:
					{
					setState(309);
					match(WORD);
					setState(310);
					match(EQ);
					setState(325);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
					case 1:
						{
						setState(312);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==QUOTE) {
							{
							setState(311);
							match(QUOTE);
							}
						}

						setState(314);
						match(WORD);
						setState(316);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==QUOTE) {
							{
							setState(315);
							match(QUOTE);
							}
						}

						}
						break;
					case 2:
						{
						setState(319);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==MARK) {
							{
							setState(318);
							match(MARK);
							}
						}

						setState(321);
						match(WORD);
						setState(323);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==MARK) {
							{
							setState(322);
							match(MARK);
							}
						}

						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(329); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << CLASS) | (1L << ID))) != 0) );
			setState(331);
			match(RSTYLE);
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

	public static class AttrLeftContext extends ParserRuleContext {
		public TerminalNode LBOLD() { return getToken(MdParser.LBOLD, 0); }
		public TerminalNode LITALIC() { return getToken(MdParser.LITALIC, 0); }
		public TerminalNode LSTRIKE() { return getToken(MdParser.LSTRIKE, 0); }
		public TerminalNode LSPAN() { return getToken(MdParser.LSPAN, 0); }
		public TerminalNode LDSPAN() { return getToken(MdParser.LDSPAN, 0); }
		public TerminalNode LDQUOTE() { return getToken(MdParser.LDQUOTE, 0); }
		public TerminalNode LSQUOTE() { return getToken(MdParser.LSQUOTE, 0); }
		public AttrLeftContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attrLeft; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterAttrLeft(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitAttrLeft(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitAttrLeft(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttrLeftContext attrLeft() throws RecognitionException {
		AttrLeftContext _localctx = new AttrLeftContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_attrLeft);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(333);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LSPAN) | (1L << LDSPAN) | (1L << LDQUOTE) | (1L << LSQUOTE))) != 0)) ) {
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

	public static class AttrRightContext extends ParserRuleContext {
		public TerminalNode RBOLD() { return getToken(MdParser.RBOLD, 0); }
		public TerminalNode RITALIC() { return getToken(MdParser.RITALIC, 0); }
		public TerminalNode RSTRIKE() { return getToken(MdParser.RSTRIKE, 0); }
		public TerminalNode RSPAN() { return getToken(MdParser.RSPAN, 0); }
		public TerminalNode RDSPAN() { return getToken(MdParser.RDSPAN, 0); }
		public TerminalNode RDQUOTE() { return getToken(MdParser.RDQUOTE, 0); }
		public TerminalNode RSQUOTE() { return getToken(MdParser.RSQUOTE, 0); }
		public AttrRightContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attrRight; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterAttrRight(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitAttrRight(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitAttrRight(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttrRightContext attrRight() throws RecognitionException {
		AttrRightContext _localctx = new AttrRightContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_attrRight);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RBOLD) | (1L << RITALIC) | (1L << RSTRIKE) | (1L << RSPAN) | (1L << RDSPAN) | (1L << RDQUOTE) | (1L << RSQUOTE))) != 0)) ) {
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

	public static class CommentContext extends ParserRuleContext {
		public TerminalNode COMMENT() { return getToken(MdParser.COMMENT, 0); }
		public CommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterComment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitComment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitComment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommentContext comment() throws RecognitionException {
		CommentContext _localctx = new CommentContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_comment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337);
			match(COMMENT);
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

	public static class LnBlankContext extends ParserRuleContext {
		public TerminalNode LINE_BLANK() { return getToken(MdParser.LINE_BLANK, 0); }
		public LnBlankContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lnBlank; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterLnBlank(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitLnBlank(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitLnBlank(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LnBlankContext lnBlank() throws RecognitionException {
		LnBlankContext _localctx = new LnBlankContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_lnBlank);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			match(LINE_BLANK);
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

	public static class LnBreakContext extends ParserRuleContext {
		public TerminalNode LINE_BREAK() { return getToken(MdParser.LINE_BREAK, 0); }
		public LnBreakContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lnBreak; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterLnBreak(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitLnBreak(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitLnBreak(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LnBreakContext lnBreak() throws RecognitionException {
		LnBreakContext _localctx = new LnBreakContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_lnBreak);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(341);
			match(LINE_BREAK);
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

	public static class ErrContext extends ParserRuleContext {
		public List<TerminalNode> ERR() { return getTokens(MdParser.ERR); }
		public TerminalNode ERR(int i) {
			return getToken(MdParser.ERR, i);
		}
		public ErrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_err; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterErr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitErr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitErr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ErrContext err() throws RecognitionException {
		ErrContext _localctx = new ErrContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_err);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(344); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(343);
					match(ERR);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(346); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3G\u015f\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2M\n\2\f\2\16\2P\13\2\3"+
		"\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\5\b`\n\b\3\b\5"+
		"\bc\n\b\3\b\6\bf\n\b\r\b\16\bg\3\b\7\bk\n\b\f\b\16\bn\13\b\3\b\3\b\3\t"+
		"\3\t\3\t\7\tu\n\t\f\t\16\tx\13\t\3\t\5\t{\n\t\3\t\3\t\3\t\5\t\u0080\n"+
		"\t\3\n\3\n\5\n\u0084\n\n\3\13\7\13\u0087\n\13\f\13\16\13\u008a\13\13\3"+
		"\13\3\13\5\13\u008e\n\13\3\13\7\13\u0091\n\13\f\13\16\13\u0094\13\13\3"+
		"\f\5\f\u0097\n\f\3\f\5\f\u009a\n\f\3\f\6\f\u009d\n\f\r\f\16\f\u009e\3"+
		"\f\5\f\u00a2\n\f\3\f\5\f\u00a5\n\f\3\r\6\r\u00a8\n\r\r\r\16\r\u00a9\3"+
		"\16\3\16\3\16\5\16\u00af\n\16\7\16\u00b1\n\16\f\16\16\16\u00b4\13\16\3"+
		"\17\3\17\3\17\3\17\3\17\5\17\u00bb\n\17\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\7\20\u00c3\n\20\f\20\16\20\u00c6\13\20\6\20\u00c8\n\20\r\20\16\20\u00c9"+
		"\3\21\3\21\3\21\3\21\7\21\u00d0\n\21\f\21\16\21\u00d3\13\21\3\22\3\22"+
		"\6\22\u00d7\n\22\r\22\16\22\u00d8\3\23\3\23\3\23\5\23\u00de\n\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\5\23\u00e6\n\23\3\23\3\23\5\23\u00ea\n\23\3"+
		"\23\3\23\3\23\5\23\u00ef\n\23\3\23\3\23\3\23\3\23\5\23\u00f5\n\23\3\23"+
		"\3\23\5\23\u00f9\n\23\3\23\3\23\5\23\u00fd\n\23\3\23\3\23\3\23\3\23\5"+
		"\23\u0103\n\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u010d\n\23"+
		"\5\23\u010f\n\23\3\24\3\24\6\24\u0113\n\24\r\24\16\24\u0114\3\25\6\25"+
		"\u0118\n\25\r\25\16\25\u0119\3\25\6\25\u011d\n\25\r\25\16\25\u011e\3\26"+
		"\6\26\u0122\n\26\r\26\16\26\u0123\3\27\7\27\u0127\n\27\f\27\16\27\u012a"+
		"\13\27\3\27\3\27\7\27\u012e\n\27\f\27\16\27\u0131\13\27\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\5\30\u013b\n\30\3\30\3\30\5\30\u013f\n\30\3"+
		"\30\5\30\u0142\n\30\3\30\3\30\5\30\u0146\n\30\5\30\u0148\n\30\6\30\u014a"+
		"\n\30\r\30\16\30\u014b\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3"+
		"\34\3\35\3\35\3\36\6\36\u015b\n\36\r\36\16\36\u015c\3\36\2\2\37\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:\2\b\4\2\3\38"+
		"8\3\2%&\3\2\16\17\7\2\3\3\f\f\24\24\26\26\34 \3\2-\63\3\2\4\n\2\u0189"+
		"\2N\3\2\2\2\4S\3\2\2\2\6U\3\2\2\2\bW\3\2\2\2\nY\3\2\2\2\f[\3\2\2\2\16"+
		"]\3\2\2\2\20\177\3\2\2\2\22\u0081\3\2\2\2\24\u0088\3\2\2\2\26\u0096\3"+
		"\2\2\2\30\u00a7\3\2\2\2\32\u00ab\3\2\2\2\34\u00ba\3\2\2\2\36\u00bc\3\2"+
		"\2\2 \u00cb\3\2\2\2\"\u00d6\3\2\2\2$\u010e\3\2\2\2&\u0110\3\2\2\2(\u0117"+
		"\3\2\2\2*\u0121\3\2\2\2,\u0128\3\2\2\2.\u0132\3\2\2\2\60\u014f\3\2\2\2"+
		"\62\u0151\3\2\2\2\64\u0153\3\2\2\2\66\u0155\3\2\2\28\u0157\3\2\2\2:\u015a"+
		"\3\2\2\2<M\5\4\3\2=M\5\6\4\2>M\5\b\5\2?M\5\n\6\2@M\5\f\7\2AM\5\16\b\2"+
		"BM\5\20\t\2CM\5\22\n\2DM\5\24\13\2EM\5\30\r\2FM\5 \21\2GM\5\36\20\2HM"+
		"\5\66\34\2IM\58\35\2JM\5\64\33\2KM\5:\36\2L<\3\2\2\2L=\3\2\2\2L>\3\2\2"+
		"\2L?\3\2\2\2L@\3\2\2\2LA\3\2\2\2LB\3\2\2\2LC\3\2\2\2LD\3\2\2\2LE\3\2\2"+
		"\2LF\3\2\2\2LG\3\2\2\2LH\3\2\2\2LI\3\2\2\2LJ\3\2\2\2LK\3\2\2\2MP\3\2\2"+
		"\2NL\3\2\2\2NO\3\2\2\2OQ\3\2\2\2PN\3\2\2\2QR\7\2\2\3R\3\3\2\2\2ST\7\27"+
		"\2\2T\5\3\2\2\2UV\7\30\2\2V\7\3\2\2\2WX\7\31\2\2X\t\3\2\2\2YZ\7\32\2\2"+
		"Z\13\3\2\2\2[\\\7\33\2\2\\\r\3\2\2\2]_\7\25\2\2^`\7\3\2\2_^\3\2\2\2_`"+
		"\3\2\2\2`b\3\2\2\2ac\5.\30\2ba\3\2\2\2bc\3\2\2\2ce\3\2\2\2df\78\2\2ed"+
		"\3\2\2\2fg\3\2\2\2ge\3\2\2\2gh\3\2\2\2hl\3\2\2\2ik\t\2\2\2ji\3\2\2\2k"+
		"n\3\2\2\2lj\3\2\2\2lm\3\2\2\2mo\3\2\2\2nl\3\2\2\2op\7E\2\2p\17\3\2\2\2"+
		"qr\7$\2\2rv\5\"\22\2su\7<\2\2ts\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2"+
		"wz\3\2\2\2xv\3\2\2\2y{\5.\30\2zy\3\2\2\2z{\3\2\2\2{\u0080\3\2\2\2|}\5"+
		"\"\22\2}~\t\3\2\2~\u0080\3\2\2\2\177q\3\2\2\2\177|\3\2\2\2\u0080\21\3"+
		"\2\2\2\u0081\u0083\7#\2\2\u0082\u0084\5.\30\2\u0083\u0082\3\2\2\2\u0083"+
		"\u0084\3\2\2\2\u0084\23\3\2\2\2\u0085\u0087\5\26\f\2\u0086\u0085\3\2\2"+
		"\2\u0087\u008a\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008b"+
		"\3\2\2\2\u008a\u0088\3\2\2\2\u008b\u008d\7!\2\2\u008c\u008e\5.\30\2\u008d"+
		"\u008c\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u0092\3\2\2\2\u008f\u0091\5\26"+
		"\f\2\u0090\u008f\3\2\2\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0092"+
		"\u0093\3\2\2\2\u0093\25\3\2\2\2\u0094\u0092\3\2\2\2\u0095\u0097\7\"\2"+
		"\2\u0096\u0095\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u009c\3\2\2\2\u0098\u009a"+
		"\5\"\22\2\u0099\u0098\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009b\3\2\2\2"+
		"\u009b\u009d\7\"\2\2\u009c\u0099\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009c"+
		"\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a1\3\2\2\2\u00a0\u00a2\5\"\22\2"+
		"\u00a1\u00a0\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a4\3\2\2\2\u00a3\u00a5"+
		"\7\"\2\2\u00a4\u00a3\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\27\3\2\2\2\u00a6"+
		"\u00a8\5\32\16\2\u00a7\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00a7\3"+
		"\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\31\3\2\2\2\u00ab\u00b2\5\34\17\2\u00ac"+
		"\u00ae\5\"\22\2\u00ad\u00af\58\35\2\u00ae\u00ad\3\2\2\2\u00ae\u00af\3"+
		"\2\2\2\u00af\u00b1\3\2\2\2\u00b0\u00ac\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2"+
		"\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\33\3\2\2\2\u00b4\u00b2\3\2\2"+
		"\2\u00b5\u00bb\7(\2\2\u00b6\u00bb\7)\2\2\u00b7\u00bb\7*\2\2\u00b8\u00bb"+
		"\7+\2\2\u00b9\u00bb\7,\2\2\u00ba\u00b5\3\2\2\2\u00ba\u00b6\3\2\2\2\u00ba"+
		"\u00b7\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00b9\3\2\2\2\u00bb\35\3\2\2"+
		"\2\u00bc\u00c7\5\"\22\2\u00bd\u00be\7\'\2\2\u00be\u00c4\5\"\22\2\u00bf"+
		"\u00c0\58\35\2\u00c0\u00c1\5\"\22\2\u00c1\u00c3\3\2\2\2\u00c2\u00bf\3"+
		"\2\2\2\u00c3\u00c6\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5"+
		"\u00c8\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c7\u00bd\3\2\2\2\u00c8\u00c9\3\2"+
		"\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\37\3\2\2\2\u00cb\u00d1"+
		"\5\"\22\2\u00cc\u00cd\58\35\2\u00cd\u00ce\5\"\22\2\u00ce\u00d0\3\2\2\2"+
		"\u00cf\u00cc\3\2\2\2\u00d0\u00d3\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2"+
		"\3\2\2\2\u00d2!\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d4\u00d7\5,\27\2\u00d5"+
		"\u00d7\5$\23\2\u00d6\u00d4\3\2\2\2\u00d6\u00d5\3\2\2\2\u00d7\u00d8\3\2"+
		"\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9#\3\2\2\2\u00da\u00dd"+
		"\t\4\2\2\u00db\u00de\5$\23\2\u00dc\u00de\5*\26\2\u00dd\u00db\3\2\2\2\u00dd"+
		"\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e0\7\20\2\2\u00e0\u00e5\7"+
		"\f\2\2\u00e1\u00e2\7\62\2\2\u00e2\u00e3\5*\26\2\u00e3\u00e4\7\t\2\2\u00e4"+
		"\u00e6\3\2\2\2\u00e5\u00e1\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7\3\2"+
		"\2\2\u00e7\u00e9\7\24\2\2\u00e8\u00ea\5.\30\2\u00e9\u00e8\3\2\2\2\u00e9"+
		"\u00ea\3\2\2\2\u00ea\u010f\3\2\2\2\u00eb\u00ee\t\4\2\2\u00ec\u00ef\5$"+
		"\23\2\u00ed\u00ef\5*\26\2\u00ee\u00ec\3\2\2\2\u00ee\u00ed\3\2\2\2\u00ef"+
		"\u00f0\3\2\2\2\u00f0\u00f1\7\21\2\2\u00f1\u00f2\5*\26\2\u00f2\u00f4\7"+
		"\23\2\2\u00f3\u00f5\5.\30\2\u00f4\u00f3\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5"+
		"\u010f\3\2\2\2\u00f6\u00f8\t\4\2\2\u00f7\u00f9\5*\26\2\u00f8\u00f7\3\2"+
		"\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fc\7\23\2\2\u00fb"+
		"\u00fd\5.\30\2\u00fc\u00fb\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u010f\3\2"+
		"\2\2\u00fe\u00ff\t\4\2\2\u00ff\u0100\7\f\2\2\u0100\u0102\7\23\2\2\u0101"+
		"\u0103\5.\30\2\u0102\u0101\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u010f\3\2"+
		"\2\2\u0104\u0105\7\16\2\2\u0105\u0106\5*\26\2\u0106\u0107\7\22\2\2\u0107"+
		"\u010c\7\f\2\2\u0108\u0109\7\62\2\2\u0109\u010a\5*\26\2\u010a\u010b\7"+
		"\t\2\2\u010b\u010d\3\2\2\2\u010c\u0108\3\2\2\2\u010c\u010d\3\2\2\2\u010d"+
		"\u010f\3\2\2\2\u010e\u00da\3\2\2\2\u010e\u00eb\3\2\2\2\u010e\u00f6\3\2"+
		"\2\2\u010e\u00fe\3\2\2\2\u010e\u0104\3\2\2\2\u010f%\3\2\2\2\u0110\u0112"+
		"\5(\25\2\u0111\u0113\5\62\32\2\u0112\u0111\3\2\2\2\u0113\u0114\3\2\2\2"+
		"\u0114\u0112\3\2\2\2\u0114\u0115\3\2\2\2\u0115\'\3\2\2\2\u0116\u0118\5"+
		"\60\31\2\u0117\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u0117\3\2\2\2\u0119"+
		"\u011a\3\2\2\2\u011a\u011c\3\2\2\2\u011b\u011d\5,\27\2\u011c\u011b\3\2"+
		"\2\2\u011d\u011e\3\2\2\2\u011e\u011c\3\2\2\2\u011e\u011f\3\2\2\2\u011f"+
		")\3\2\2\2\u0120\u0122\5,\27\2\u0121\u0120\3\2\2\2\u0122\u0123\3\2\2\2"+
		"\u0123\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124+\3\2\2\2\u0125\u0127\5"+
		"\60\31\2\u0126\u0125\3\2\2\2\u0127\u012a\3\2\2\2\u0128\u0126\3\2\2\2\u0128"+
		"\u0129\3\2\2\2\u0129\u012b\3\2\2\2\u012a\u0128\3\2\2\2\u012b\u012f\t\5"+
		"\2\2\u012c\u012e\5\62\32\2\u012d\u012c\3\2\2\2\u012e\u0131\3\2\2\2\u012f"+
		"\u012d\3\2\2\2\u012f\u0130\3\2\2\2\u0130-\3\2\2\2\u0131\u012f\3\2\2\2"+
		"\u0132\u0149\7\r\2\2\u0133\u0134\7?\2\2\u0134\u014a\7\3\2\2\u0135\u0136"+
		"\7@\2\2\u0136\u014a\7\3\2\2\u0137\u0138\7\3\2\2\u0138\u0147\7A\2\2\u0139"+
		"\u013b\7B\2\2\u013a\u0139\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u013c\3\2"+
		"\2\2\u013c\u013e\7\3\2\2\u013d\u013f\7B\2\2\u013e\u013d\3\2\2\2\u013e"+
		"\u013f\3\2\2\2\u013f\u0148\3\2\2\2\u0140\u0142\7C\2\2\u0141\u0140\3\2"+
		"\2\2\u0141\u0142\3\2\2\2\u0142\u0143\3\2\2\2\u0143\u0145\7\3\2\2\u0144"+
		"\u0146\7C\2\2\u0145\u0144\3\2\2\2\u0145\u0146\3\2\2\2\u0146\u0148\3\2"+
		"\2\2\u0147\u013a\3\2\2\2\u0147\u0141\3\2\2\2\u0148\u014a\3\2\2\2\u0149"+
		"\u0133\3\2\2\2\u0149\u0135\3\2\2\2\u0149\u0137\3\2\2\2\u014a\u014b\3\2"+
		"\2\2\u014b\u0149\3\2\2\2\u014b\u014c\3\2\2\2\u014c\u014d\3\2\2\2\u014d"+
		"\u014e\7>\2\2\u014e/\3\2\2\2\u014f\u0150\t\6\2\2\u0150\61\3\2\2\2\u0151"+
		"\u0152\t\7\2\2\u0152\63\3\2\2\2\u0153\u0154\7\13\2\2\u0154\65\3\2\2\2"+
		"\u0155\u0156\7\64\2\2\u0156\67\3\2\2\2\u0157\u0158\7\65\2\2\u01589\3\2"+
		"\2\2\u0159\u015b\7;\2\2\u015a\u0159\3\2\2\2\u015b\u015c\3\2\2\2\u015c"+
		"\u015a\3\2\2\2\u015c\u015d\3\2\2\2\u015d;\3\2\2\2\65LN_bglvz\177\u0083"+
		"\u0088\u008d\u0092\u0096\u0099\u009e\u00a1\u00a4\u00a9\u00ae\u00b2\u00ba"+
		"\u00c4\u00c9\u00d1\u00d6\u00d8\u00dd\u00e5\u00e9\u00ee\u00f4\u00f8\u00fc"+
		"\u0102\u010c\u010e\u0114\u0119\u011e\u0123\u0128\u012f\u013a\u013e\u0141"+
		"\u0145\u0147\u0149\u014b\u015c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}