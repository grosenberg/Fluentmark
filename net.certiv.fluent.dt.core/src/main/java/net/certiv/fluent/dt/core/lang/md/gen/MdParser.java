// Generated from D:/DevFiles/Eclipse/Tools/Editors/net.certiv.fluent.dt/net.certiv.fluent.dt.core/src/main/java/net/certiv/fluent/dt/core/lang/mdx/MdParser.g4 by ANTLR 4.8

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
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WORD=1, RBOLD=2, RITALIC=3, RSTRIKE=4, RDQUOTE=5, RSQUOTE=6, COMMENT=7, 
		CODE_BEG=8, YAML_BLOCK=9, HTML_BLOCK=10, DOT_BLOCK=11, MATH_BLOCK=12, 
		TEX_BLOCK=13, UML_BLOCK=14, MATHS=15, SPAN=16, LSTYLE=17, URL=18, URLTAG=19, 
		HTML=20, TEX=21, UNICODE=22, ENTITY=23, IMAGE=24, FNOTE=25, LINK=26, TABLE=27, 
		PIPE=28, HASHES=29, DASHES=30, EQUALS=31, HRULE=32, COLON=33, BULLET_MARK=34, 
		NUMBER_MARK=35, PAREN_MARK=36, UALPHA_MARK=37, LALPHA_MARK=38, LBOLD=39, 
		LITALIC=40, LSTRIKE=41, LDQUOTE=42, LSQUOTE=43, BLOCKQUOTE=44, LINE_DENT=45, 
		LINE_BLANK=46, LINE_BREAK=47, VWS=48, HWS=49, CHAR=50, HASH=51, CHAR_h=52, 
		RSTYLE=53, CLASS=54, ID=55, EQ=56, DASH=57, DQUOTE=58, SQUOTE=59, CHAR_s=60, 
		CODE_END=61, CHR_c=62, CHR_t=63, LNK_SEP=64, LNK_REF=65, LNK_DEF=66, RBRACK=67, 
		CHR_l=68, RPAREN=69, CHR_d=70, CHR_r=71;
	public static final int
		RULE_page = 0, RULE_yamlBlock = 1, RULE_htmlBlock = 2, RULE_dotBlock = 3, 
		RULE_mathBlock = 4, RULE_texBlock = 5, RULE_umlBlock = 6, RULE_codeBlock = 7, 
		RULE_style = 8, RULE_header = 9, RULE_hrule = 10, RULE_table = 11, RULE_tableRow = 12, 
		RULE_list = 13, RULE_listItem = 14, RULE_definition = 15, RULE_defineItem = 16, 
		RULE_link = 17, RULE_lnkDef = 18, RULE_lnkRef = 19, RULE_url = 20, RULE_alt = 21, 
		RULE_paragraph = 22, RULE_lines = 23, RULE_line = 24, RULE_word = 25, 
		RULE_nl = 26, RULE_nl2 = 27, RULE_attrLeft = 28, RULE_attrRight = 29, 
		RULE_comment = 30, RULE_lnBlank = 31, RULE_lnBreak = 32;
	private static String[] makeRuleNames() {
		return new String[] {
			"page", "yamlBlock", "htmlBlock", "dotBlock", "mathBlock", "texBlock", 
			"umlBlock", "codeBlock", "style", "header", "hrule", "table", "tableRow", 
			"list", "listItem", "definition", "defineItem", "link", "lnkDef", "lnkRef", 
			"url", "alt", "paragraph", "lines", "line", "word", "nl", "nl2", "attrLeft", 
			"attrRight", "comment", "lnBlank", "lnBreak"
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
			null, "WORD", "RBOLD", "RITALIC", "RSTRIKE", "RDQUOTE", "RSQUOTE", "COMMENT", 
			"CODE_BEG", "YAML_BLOCK", "HTML_BLOCK", "DOT_BLOCK", "MATH_BLOCK", "TEX_BLOCK", 
			"UML_BLOCK", "MATHS", "SPAN", "LSTYLE", "URL", "URLTAG", "HTML", "TEX", 
			"UNICODE", "ENTITY", "IMAGE", "FNOTE", "LINK", "TABLE", "PIPE", "HASHES", 
			"DASHES", "EQUALS", "HRULE", "COLON", "BULLET_MARK", "NUMBER_MARK", "PAREN_MARK", 
			"UALPHA_MARK", "LALPHA_MARK", "LBOLD", "LITALIC", "LSTRIKE", "LDQUOTE", 
			"LSQUOTE", "BLOCKQUOTE", "LINE_DENT", "LINE_BLANK", "LINE_BREAK", "VWS", 
			"HWS", "CHAR", "HASH", "CHAR_h", "RSTYLE", "CLASS", "ID", "EQ", "DASH", 
			"DQUOTE", "SQUOTE", "CHAR_s", "CODE_END", "CHR_c", "CHR_t", "LNK_SEP", 
			"LNK_REF", "LNK_DEF", "RBRACK", "CHR_l", "RPAREN", "CHR_d", "CHR_r"
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
		public List<DotBlockContext> dotBlock() {
			return getRuleContexts(DotBlockContext.class);
		}
		public DotBlockContext dotBlock(int i) {
			return getRuleContext(DotBlockContext.class,i);
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
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
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
		public List<ParagraphContext> paragraph() {
			return getRuleContexts(ParagraphContext.class);
		}
		public ParagraphContext paragraph(int i) {
			return getRuleContext(ParagraphContext.class,i);
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
		public List<TerminalNode> VWS() { return getTokens(MdParser.VWS); }
		public TerminalNode VWS(int i) {
			return getToken(MdParser.VWS, i);
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
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << COMMENT) | (1L << CODE_BEG) | (1L << YAML_BLOCK) | (1L << HTML_BLOCK) | (1L << DOT_BLOCK) | (1L << MATH_BLOCK) | (1L << TEX_BLOCK) | (1L << UML_BLOCK) | (1L << MATHS) | (1L << SPAN) | (1L << URL) | (1L << URLTAG) | (1L << HTML) | (1L << TEX) | (1L << UNICODE) | (1L << ENTITY) | (1L << IMAGE) | (1L << FNOTE) | (1L << LINK) | (1L << TABLE) | (1L << PIPE) | (1L << HASHES) | (1L << HRULE) | (1L << BULLET_MARK) | (1L << NUMBER_MARK) | (1L << PAREN_MARK) | (1L << UALPHA_MARK) | (1L << LALPHA_MARK) | (1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LDQUOTE) | (1L << LSQUOTE) | (1L << LINE_BLANK) | (1L << LINE_BREAK) | (1L << VWS))) != 0)) {
				{
				setState(83);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(66);
					yamlBlock();
					}
					break;
				case 2:
					{
					setState(67);
					htmlBlock();
					}
					break;
				case 3:
					{
					setState(68);
					dotBlock();
					}
					break;
				case 4:
					{
					setState(69);
					mathBlock();
					}
					break;
				case 5:
					{
					setState(70);
					texBlock();
					}
					break;
				case 6:
					{
					setState(71);
					umlBlock();
					}
					break;
				case 7:
					{
					setState(72);
					codeBlock();
					}
					break;
				case 8:
					{
					setState(73);
					comment();
					}
					break;
				case 9:
					{
					setState(74);
					header();
					}
					break;
				case 10:
					{
					setState(75);
					hrule();
					}
					break;
				case 11:
					{
					setState(76);
					paragraph();
					}
					break;
				case 12:
					{
					setState(77);
					table();
					}
					break;
				case 13:
					{
					setState(78);
					list();
					}
					break;
				case 14:
					{
					setState(79);
					definition();
					}
					break;
				case 15:
					{
					setState(80);
					lnBlank();
					}
					break;
				case 16:
					{
					setState(81);
					lnBreak();
					}
					break;
				case 17:
					{
					setState(82);
					match(VWS);
					}
					break;
				}
				}
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(88);
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
			setState(90);
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
			setState(92);
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

	public static class DotBlockContext extends ParserRuleContext {
		public TerminalNode DOT_BLOCK() { return getToken(MdParser.DOT_BLOCK, 0); }
		public DotBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dotBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterDotBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitDotBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitDotBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DotBlockContext dotBlock() throws RecognitionException {
		DotBlockContext _localctx = new DotBlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_dotBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(DOT_BLOCK);
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
		enterRule(_localctx, 8, RULE_mathBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
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
		enterRule(_localctx, 10, RULE_texBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
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
		enterRule(_localctx, 12, RULE_umlBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
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
		public List<TerminalNode> VWS() { return getTokens(MdParser.VWS); }
		public TerminalNode VWS(int i) {
			return getToken(MdParser.VWS, i);
		}
		public TerminalNode CODE_END() { return getToken(MdParser.CODE_END, 0); }
		public StyleContext style() {
			return getRuleContext(StyleContext.class,0);
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
		enterRule(_localctx, 14, RULE_codeBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(CODE_BEG);
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WORD) {
				{
				setState(103);
				((CodeBlockContext)_localctx).lang = match(WORD);
				}
			}

			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LSTYLE) {
				{
				setState(106);
				style();
				}
			}

			setState(109);
			match(VWS);
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WORD || _la==VWS) {
				{
				{
				setState(110);
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
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(116);
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

	public static class StyleContext extends ParserRuleContext {
		public TerminalNode LSTYLE() { return getToken(MdParser.LSTYLE, 0); }
		public TerminalNode RSTYLE() { return getToken(MdParser.RSTYLE, 0); }
		public List<TerminalNode> DASH() { return getTokens(MdParser.DASH); }
		public TerminalNode DASH(int i) {
			return getToken(MdParser.DASH, i);
		}
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
		public List<TerminalNode> SQUOTE() { return getTokens(MdParser.SQUOTE); }
		public TerminalNode SQUOTE(int i) {
			return getToken(MdParser.SQUOTE, i);
		}
		public List<TerminalNode> DQUOTE() { return getTokens(MdParser.DQUOTE); }
		public TerminalNode DQUOTE(int i) {
			return getToken(MdParser.DQUOTE, i);
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
		enterRule(_localctx, 16, RULE_style);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(LSTYLE);
			setState(135); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(135);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DASH:
					{
					setState(119);
					match(DASH);
					}
					break;
				case CLASS:
					{
					setState(120);
					match(CLASS);
					setState(121);
					match(WORD);
					}
					break;
				case ID:
					{
					setState(122);
					match(ID);
					setState(123);
					match(WORD);
					}
					break;
				case WORD:
					{
					setState(124);
					match(WORD);
					setState(125);
					match(EQ);
					setState(133);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case SQUOTE:
						{
						setState(126);
						match(SQUOTE);
						setState(127);
						match(WORD);
						setState(128);
						match(SQUOTE);
						}
						break;
					case DQUOTE:
						{
						setState(129);
						match(DQUOTE);
						setState(130);
						match(WORD);
						setState(131);
						match(DQUOTE);
						}
						break;
					case WORD:
						{
						setState(132);
						match(WORD);
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
				}
				setState(137); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << CLASS) | (1L << ID) | (1L << DASH))) != 0) );
			setState(139);
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
		public NlContext nl() {
			return getRuleContext(NlContext.class,0);
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
		enterRule(_localctx, 18, RULE_header);
		int _la;
		try {
			setState(159);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HASHES:
				enterOuterAlt(_localctx, 1);
				{
				setState(141);
				match(HASHES);
				setState(142);
				line();
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==HASH) {
					{
					{
					setState(143);
					match(HASH);
					}
					}
					setState(148);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LSTYLE) {
					{
					setState(149);
					style();
					}
				}

				}
				break;
			case WORD:
			case MATHS:
			case SPAN:
			case URL:
			case URLTAG:
			case HTML:
			case TEX:
			case UNICODE:
			case ENTITY:
			case IMAGE:
			case FNOTE:
			case LINK:
			case LBOLD:
			case LITALIC:
			case LSTRIKE:
			case LDQUOTE:
			case LSQUOTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(152);
				line();
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LSTYLE) {
					{
					setState(153);
					style();
					}
				}

				setState(156);
				nl();
				setState(157);
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
		enterRule(_localctx, 20, RULE_hrule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			match(HRULE);
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LSTYLE) {
				{
				setState(162);
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
		public TerminalNode TABLE() { return getToken(MdParser.TABLE, 0); }
		public List<NlContext> nl() {
			return getRuleContexts(NlContext.class);
		}
		public NlContext nl(int i) {
			return getRuleContext(NlContext.class,i);
		}
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
		enterRule(_localctx, 22, RULE_table);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << MATHS) | (1L << SPAN) | (1L << URL) | (1L << URLTAG) | (1L << HTML) | (1L << TEX) | (1L << UNICODE) | (1L << ENTITY) | (1L << IMAGE) | (1L << FNOTE) | (1L << LINK) | (1L << PIPE) | (1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LDQUOTE) | (1L << LSQUOTE))) != 0)) {
				{
				{
				setState(165);
				tableRow();
				setState(166);
				nl();
				}
				}
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(173);
			match(TABLE);
			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LSTYLE) {
				{
				setState(174);
				style();
				}
			}

			setState(177);
			nl();
			setState(183);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(178);
					tableRow();
					setState(179);
					nl();
					}
					} 
				}
				setState(185);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			setState(186);
			tableRow();
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
		enterRule(_localctx, 24, RULE_tableRow);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(188);
				match(PIPE);
				}
				break;
			}
			setState(195); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(192);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << MATHS) | (1L << SPAN) | (1L << URL) | (1L << URLTAG) | (1L << HTML) | (1L << TEX) | (1L << UNICODE) | (1L << ENTITY) | (1L << IMAGE) | (1L << FNOTE) | (1L << LINK) | (1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LDQUOTE) | (1L << LSQUOTE))) != 0)) {
						{
						setState(191);
						line();
						}
					}

					setState(194);
					match(PIPE);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(197); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(200);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(199);
				line();
				}
				break;
			}
			setState(203);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(202);
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
		public List<NlContext> nl() {
			return getRuleContexts(NlContext.class);
		}
		public NlContext nl(int i) {
			return getRuleContext(NlContext.class,i);
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
		enterRule(_localctx, 26, RULE_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			listItem();
			setState(211);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(206);
					nl();
					setState(207);
					listItem();
					}
					} 
				}
				setState(213);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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

	public static class ListItemContext extends ParserRuleContext {
		public Token mark;
		public LinesContext lines() {
			return getRuleContext(LinesContext.class,0);
		}
		public TerminalNode BULLET_MARK() { return getToken(MdParser.BULLET_MARK, 0); }
		public TerminalNode NUMBER_MARK() { return getToken(MdParser.NUMBER_MARK, 0); }
		public TerminalNode PAREN_MARK() { return getToken(MdParser.PAREN_MARK, 0); }
		public TerminalNode UALPHA_MARK() { return getToken(MdParser.UALPHA_MARK, 0); }
		public TerminalNode LALPHA_MARK() { return getToken(MdParser.LALPHA_MARK, 0); }
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
		enterRule(_localctx, 28, RULE_listItem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			((ListItemContext)_localctx).mark = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BULLET_MARK) | (1L << NUMBER_MARK) | (1L << PAREN_MARK) | (1L << UALPHA_MARK) | (1L << LALPHA_MARK))) != 0)) ) {
				((ListItemContext)_localctx).mark = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(215);
			lines();
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
		public LineContext line() {
			return getRuleContext(LineContext.class,0);
		}
		public List<NlContext> nl() {
			return getRuleContexts(NlContext.class);
		}
		public NlContext nl(int i) {
			return getRuleContext(NlContext.class,i);
		}
		public List<DefineItemContext> defineItem() {
			return getRuleContexts(DefineItemContext.class);
		}
		public DefineItemContext defineItem(int i) {
			return getRuleContext(DefineItemContext.class,i);
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
		enterRule(_localctx, 30, RULE_definition);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			line();
			setState(218);
			nl();
			setState(219);
			defineItem();
			setState(225);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(220);
					nl();
					setState(221);
					defineItem();
					}
					} 
				}
				setState(227);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
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

	public static class DefineItemContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(MdParser.COLON, 0); }
		public LinesContext lines() {
			return getRuleContext(LinesContext.class,0);
		}
		public DefineItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defineItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterDefineItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitDefineItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitDefineItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefineItemContext defineItem() throws RecognitionException {
		DefineItemContext _localctx = new DefineItemContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_defineItem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(COLON);
			setState(229);
			lines();
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
		public LnkDefContext lnkDef() {
			return getRuleContext(LnkDefContext.class,0);
		}
		public LineContext line() {
			return getRuleContext(LineContext.class,0);
		}
		public TerminalNode LNK_SEP() { return getToken(MdParser.LNK_SEP, 0); }
		public TerminalNode RPAREN() { return getToken(MdParser.RPAREN, 0); }
		public UrlContext url() {
			return getRuleContext(UrlContext.class,0);
		}
		public AltContext alt() {
			return getRuleContext(AltContext.class,0);
		}
		public StyleContext style() {
			return getRuleContext(StyleContext.class,0);
		}
		public TerminalNode LNK_REF() { return getToken(MdParser.LNK_REF, 0); }
		public TerminalNode RBRACK() { return getToken(MdParser.RBRACK, 0); }
		public List<WordContext> word() {
			return getRuleContexts(WordContext.class);
		}
		public WordContext word(int i) {
			return getRuleContext(WordContext.class,i);
		}
		public LnkRefContext lnkRef() {
			return getRuleContext(LnkRefContext.class,0);
		}
		public TerminalNode LNK_DEF() { return getToken(MdParser.LNK_DEF, 0); }
		public List<TerminalNode> VWS() { return getTokens(MdParser.VWS); }
		public TerminalNode VWS(int i) {
			return getToken(MdParser.VWS, i);
		}
		public List<TerminalNode> LINE_BREAK() { return getTokens(MdParser.LINE_BREAK); }
		public TerminalNode LINE_BREAK(int i) {
			return getToken(MdParser.LINE_BREAK, i);
		}
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
			setState(281);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(231);
				lnkDef();
				setState(232);
				line();
				setState(233);
				match(LNK_SEP);
				setState(235);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==URL || _la==URLTAG) {
					{
					setState(234);
					url();
					}
				}

				setState(238);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LDQUOTE) | (1L << LSQUOTE) | (1L << DQUOTE) | (1L << SQUOTE))) != 0)) {
					{
					setState(237);
					alt();
					}
				}

				setState(240);
				match(RPAREN);
				setState(242);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
				case 1:
					{
					setState(241);
					style();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(244);
				lnkDef();
				setState(245);
				line();
				setState(246);
				match(LNK_REF);
				setState(250);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << MATHS) | (1L << SPAN) | (1L << URL) | (1L << URLTAG) | (1L << HTML) | (1L << TEX) | (1L << UNICODE) | (1L << ENTITY) | (1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LDQUOTE) | (1L << LSQUOTE))) != 0)) {
					{
					{
					setState(247);
					word();
					}
					}
					setState(252);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(253);
				match(RBRACK);
				setState(255);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
				case 1:
					{
					setState(254);
					style();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(257);
				lnkRef();
				setState(261);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << MATHS) | (1L << SPAN) | (1L << URL) | (1L << URLTAG) | (1L << HTML) | (1L << TEX) | (1L << UNICODE) | (1L << ENTITY) | (1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LDQUOTE) | (1L << LSQUOTE))) != 0)) {
					{
					{
					setState(258);
					word();
					}
					}
					setState(263);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(264);
				match(LNK_DEF);
				setState(266);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LINE_BREAK || _la==VWS) {
					{
					setState(265);
					_la = _input.LA(1);
					if ( !(_la==LINE_BREAK || _la==VWS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(268);
				url();
				setState(273);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
				case 1:
					{
					setState(270);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==LINE_BREAK || _la==VWS) {
						{
						setState(269);
						_la = _input.LA(1);
						if ( !(_la==LINE_BREAK || _la==VWS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
					}

					setState(272);
					alt();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(275);
				lnkDef();
				setState(276);
				line();
				setState(277);
				match(RBRACK);
				setState(279);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
				case 1:
					{
					setState(278);
					style();
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

	public static class LnkDefContext extends ParserRuleContext {
		public TerminalNode IMAGE() { return getToken(MdParser.IMAGE, 0); }
		public TerminalNode FNOTE() { return getToken(MdParser.FNOTE, 0); }
		public TerminalNode LINK() { return getToken(MdParser.LINK, 0); }
		public LnkDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lnkDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterLnkDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitLnkDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitLnkDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LnkDefContext lnkDef() throws RecognitionException {
		LnkDefContext _localctx = new LnkDefContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_lnkDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IMAGE) | (1L << FNOTE) | (1L << LINK))) != 0)) ) {
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

	public static class LnkRefContext extends ParserRuleContext {
		public TerminalNode LINK() { return getToken(MdParser.LINK, 0); }
		public LnkRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lnkRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterLnkRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitLnkRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitLnkRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LnkRefContext lnkRef() throws RecognitionException {
		LnkRefContext _localctx = new LnkRefContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_lnkRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			match(LINK);
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
		public TerminalNode URLTAG() { return getToken(MdParser.URLTAG, 0); }
		public TerminalNode URL() { return getToken(MdParser.URL, 0); }
		public UrlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_url; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterUrl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitUrl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitUrl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UrlContext url() throws RecognitionException {
		UrlContext _localctx = new UrlContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_url);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			_la = _input.LA(1);
			if ( !(_la==URL || _la==URLTAG) ) {
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

	public static class AltContext extends ParserRuleContext {
		public List<TerminalNode> DQUOTE() { return getTokens(MdParser.DQUOTE); }
		public TerminalNode DQUOTE(int i) {
			return getToken(MdParser.DQUOTE, i);
		}
		public List<WordContext> word() {
			return getRuleContexts(WordContext.class);
		}
		public WordContext word(int i) {
			return getRuleContext(WordContext.class,i);
		}
		public List<TerminalNode> SQUOTE() { return getTokens(MdParser.SQUOTE); }
		public TerminalNode SQUOTE(int i) {
			return getToken(MdParser.SQUOTE, i);
		}
		public TerminalNode LDQUOTE() { return getToken(MdParser.LDQUOTE, 0); }
		public TerminalNode RDQUOTE() { return getToken(MdParser.RDQUOTE, 0); }
		public LineContext line() {
			return getRuleContext(LineContext.class,0);
		}
		public TerminalNode LSQUOTE() { return getToken(MdParser.LSQUOTE, 0); }
		public TerminalNode RSQUOTE() { return getToken(MdParser.RSQUOTE, 0); }
		public AltContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterAlt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitAlt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitAlt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AltContext alt() throws RecognitionException {
		AltContext _localctx = new AltContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_alt);
		int _la;
		try {
			setState(317);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DQUOTE:
				enterOuterAlt(_localctx, 1);
				{
				setState(289);
				match(DQUOTE);
				setState(294);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << MATHS) | (1L << SPAN) | (1L << URL) | (1L << URLTAG) | (1L << HTML) | (1L << TEX) | (1L << UNICODE) | (1L << ENTITY) | (1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LDQUOTE) | (1L << LSQUOTE) | (1L << SQUOTE))) != 0)) {
					{
					setState(292);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case WORD:
					case MATHS:
					case SPAN:
					case URL:
					case URLTAG:
					case HTML:
					case TEX:
					case UNICODE:
					case ENTITY:
					case LBOLD:
					case LITALIC:
					case LSTRIKE:
					case LDQUOTE:
					case LSQUOTE:
						{
						setState(290);
						word();
						}
						break;
					case SQUOTE:
						{
						setState(291);
						match(SQUOTE);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(296);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(297);
				match(DQUOTE);
				}
				break;
			case SQUOTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(298);
				match(SQUOTE);
				setState(303);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << MATHS) | (1L << SPAN) | (1L << URL) | (1L << URLTAG) | (1L << HTML) | (1L << TEX) | (1L << UNICODE) | (1L << ENTITY) | (1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LDQUOTE) | (1L << LSQUOTE) | (1L << DQUOTE))) != 0)) {
					{
					setState(301);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case WORD:
					case MATHS:
					case SPAN:
					case URL:
					case URLTAG:
					case HTML:
					case TEX:
					case UNICODE:
					case ENTITY:
					case LBOLD:
					case LITALIC:
					case LSTRIKE:
					case LDQUOTE:
					case LSQUOTE:
						{
						setState(299);
						word();
						}
						break;
					case DQUOTE:
						{
						setState(300);
						match(DQUOTE);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(305);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(306);
				match(SQUOTE);
				}
				break;
			case LDQUOTE:
				enterOuterAlt(_localctx, 3);
				{
				setState(307);
				match(LDQUOTE);
				setState(309);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << MATHS) | (1L << SPAN) | (1L << URL) | (1L << URLTAG) | (1L << HTML) | (1L << TEX) | (1L << UNICODE) | (1L << ENTITY) | (1L << IMAGE) | (1L << FNOTE) | (1L << LINK) | (1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LDQUOTE) | (1L << LSQUOTE))) != 0)) {
					{
					setState(308);
					line();
					}
				}

				setState(311);
				match(RDQUOTE);
				}
				break;
			case LSQUOTE:
				enterOuterAlt(_localctx, 4);
				{
				setState(312);
				match(LSQUOTE);
				setState(314);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << MATHS) | (1L << SPAN) | (1L << URL) | (1L << URLTAG) | (1L << HTML) | (1L << TEX) | (1L << UNICODE) | (1L << ENTITY) | (1L << IMAGE) | (1L << FNOTE) | (1L << LINK) | (1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LDQUOTE) | (1L << LSQUOTE))) != 0)) {
					{
					setState(313);
					line();
					}
				}

				setState(316);
				match(RSQUOTE);
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

	public static class ParagraphContext extends ParserRuleContext {
		public LinesContext lines() {
			return getRuleContext(LinesContext.class,0);
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
		enterRule(_localctx, 44, RULE_paragraph);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			lines();
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

	public static class LinesContext extends ParserRuleContext {
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public List<NlContext> nl() {
			return getRuleContexts(NlContext.class);
		}
		public NlContext nl(int i) {
			return getRuleContext(NlContext.class,i);
		}
		public LinesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lines; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterLines(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitLines(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitLines(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LinesContext lines() throws RecognitionException {
		LinesContext _localctx = new LinesContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_lines);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(321);
			line();
			setState(327);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(322);
					nl();
					setState(323);
					line();
					}
					} 
				}
				setState(329);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
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
		enterRule(_localctx, 48, RULE_line);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(332); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(332);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case WORD:
					case MATHS:
					case SPAN:
					case URL:
					case URLTAG:
					case HTML:
					case TEX:
					case UNICODE:
					case ENTITY:
					case LBOLD:
					case LITALIC:
					case LSTRIKE:
					case LDQUOTE:
					case LSQUOTE:
						{
						setState(330);
						word();
						}
						break;
					case IMAGE:
					case FNOTE:
					case LINK:
						{
						setState(331);
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
				setState(334); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
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

	public static class WordContext extends ParserRuleContext {
		public Token w;
		public TerminalNode WORD() { return getToken(MdParser.WORD, 0); }
		public TerminalNode ENTITY() { return getToken(MdParser.ENTITY, 0); }
		public TerminalNode UNICODE() { return getToken(MdParser.UNICODE, 0); }
		public TerminalNode URL() { return getToken(MdParser.URL, 0); }
		public TerminalNode URLTAG() { return getToken(MdParser.URLTAG, 0); }
		public TerminalNode SPAN() { return getToken(MdParser.SPAN, 0); }
		public TerminalNode MATHS() { return getToken(MdParser.MATHS, 0); }
		public TerminalNode HTML() { return getToken(MdParser.HTML, 0); }
		public TerminalNode TEX() { return getToken(MdParser.TEX, 0); }
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
		enterRule(_localctx, 50, RULE_word);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LDQUOTE) | (1L << LSQUOTE))) != 0)) {
				{
				{
				setState(336);
				attrLeft();
				}
				}
				setState(341);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(342);
			((WordContext)_localctx).w = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << MATHS) | (1L << SPAN) | (1L << URL) | (1L << URLTAG) | (1L << HTML) | (1L << TEX) | (1L << UNICODE) | (1L << ENTITY))) != 0)) ) {
				((WordContext)_localctx).w = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(346);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(343);
					attrRight();
					}
					} 
				}
				setState(348);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
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

	public static class NlContext extends ParserRuleContext {
		public TerminalNode LINE_BREAK() { return getToken(MdParser.LINE_BREAK, 0); }
		public TerminalNode VWS() { return getToken(MdParser.VWS, 0); }
		public NlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterNl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitNl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitNl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NlContext nl() throws RecognitionException {
		NlContext _localctx = new NlContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_nl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			_la = _input.LA(1);
			if ( !(_la==LINE_BREAK || _la==VWS) ) {
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

	public static class Nl2Context extends ParserRuleContext {
		public TerminalNode LINE_BREAK() { return getToken(MdParser.LINE_BREAK, 0); }
		public TerminalNode VWS() { return getToken(MdParser.VWS, 0); }
		public Nl2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nl2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterNl2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitNl2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitNl2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Nl2Context nl2() throws RecognitionException {
		Nl2Context _localctx = new Nl2Context(_ctx, getState());
		enterRule(_localctx, 54, RULE_nl2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(351);
			_la = _input.LA(1);
			if ( !(_la==LINE_BREAK || _la==VWS) ) {
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

	public static class AttrLeftContext extends ParserRuleContext {
		public TerminalNode LBOLD() { return getToken(MdParser.LBOLD, 0); }
		public TerminalNode LITALIC() { return getToken(MdParser.LITALIC, 0); }
		public TerminalNode LSTRIKE() { return getToken(MdParser.LSTRIKE, 0); }
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
		enterRule(_localctx, 56, RULE_attrLeft);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(353);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LDQUOTE) | (1L << LSQUOTE))) != 0)) ) {
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
		enterRule(_localctx, 58, RULE_attrRight);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(355);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RBOLD) | (1L << RITALIC) | (1L << RSTRIKE) | (1L << RDQUOTE) | (1L << RSQUOTE))) != 0)) ) {
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
		enterRule(_localctx, 60, RULE_comment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(357);
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
		enterRule(_localctx, 62, RULE_lnBlank);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(359);
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
		enterRule(_localctx, 64, RULE_lnBreak);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(361);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3I\u016e\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\7\2V\n\2\f\2\16\2Y\13\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6"+
		"\3\6\3\7\3\7\3\b\3\b\3\t\3\t\5\tk\n\t\3\t\5\tn\n\t\3\t\3\t\7\tr\n\t\f"+
		"\t\16\tu\13\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\5\n\u0088\n\n\6\n\u008a\n\n\r\n\16\n\u008b\3\n\3\n\3\13\3"+
		"\13\3\13\7\13\u0093\n\13\f\13\16\13\u0096\13\13\3\13\5\13\u0099\n\13\3"+
		"\13\3\13\5\13\u009d\n\13\3\13\3\13\3\13\5\13\u00a2\n\13\3\f\3\f\5\f\u00a6"+
		"\n\f\3\r\3\r\3\r\7\r\u00ab\n\r\f\r\16\r\u00ae\13\r\3\r\3\r\5\r\u00b2\n"+
		"\r\3\r\3\r\3\r\3\r\7\r\u00b8\n\r\f\r\16\r\u00bb\13\r\3\r\3\r\3\16\5\16"+
		"\u00c0\n\16\3\16\5\16\u00c3\n\16\3\16\6\16\u00c6\n\16\r\16\16\16\u00c7"+
		"\3\16\5\16\u00cb\n\16\3\16\5\16\u00ce\n\16\3\17\3\17\3\17\3\17\7\17\u00d4"+
		"\n\17\f\17\16\17\u00d7\13\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\7\21\u00e2\n\21\f\21\16\21\u00e5\13\21\3\22\3\22\3\22\3\23\3\23\3"+
		"\23\3\23\5\23\u00ee\n\23\3\23\5\23\u00f1\n\23\3\23\3\23\5\23\u00f5\n\23"+
		"\3\23\3\23\3\23\3\23\7\23\u00fb\n\23\f\23\16\23\u00fe\13\23\3\23\3\23"+
		"\5\23\u0102\n\23\3\23\3\23\7\23\u0106\n\23\f\23\16\23\u0109\13\23\3\23"+
		"\3\23\5\23\u010d\n\23\3\23\3\23\5\23\u0111\n\23\3\23\5\23\u0114\n\23\3"+
		"\23\3\23\3\23\3\23\5\23\u011a\n\23\5\23\u011c\n\23\3\24\3\24\3\25\3\25"+
		"\3\26\3\26\3\27\3\27\3\27\7\27\u0127\n\27\f\27\16\27\u012a\13\27\3\27"+
		"\3\27\3\27\3\27\7\27\u0130\n\27\f\27\16\27\u0133\13\27\3\27\3\27\3\27"+
		"\5\27\u0138\n\27\3\27\3\27\3\27\5\27\u013d\n\27\3\27\5\27\u0140\n\27\3"+
		"\30\3\30\3\31\3\31\3\31\3\31\7\31\u0148\n\31\f\31\16\31\u014b\13\31\3"+
		"\32\3\32\6\32\u014f\n\32\r\32\16\32\u0150\3\33\7\33\u0154\n\33\f\33\16"+
		"\33\u0157\13\33\3\33\3\33\7\33\u015b\n\33\f\33\16\33\u015e\13\33\3\34"+
		"\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3\"\2\2#\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@B\2\13\4\2"+
		"\3\3\62\62\3\2 !\3\2$(\3\2\61\62\3\2\32\34\3\2\24\25\5\2\3\3\21\22\24"+
		"\31\3\2)-\3\2\4\b\2\u0190\2W\3\2\2\2\4\\\3\2\2\2\6^\3\2\2\2\b`\3\2\2\2"+
		"\nb\3\2\2\2\fd\3\2\2\2\16f\3\2\2\2\20h\3\2\2\2\22x\3\2\2\2\24\u00a1\3"+
		"\2\2\2\26\u00a3\3\2\2\2\30\u00ac\3\2\2\2\32\u00bf\3\2\2\2\34\u00cf\3\2"+
		"\2\2\36\u00d8\3\2\2\2 \u00db\3\2\2\2\"\u00e6\3\2\2\2$\u011b\3\2\2\2&\u011d"+
		"\3\2\2\2(\u011f\3\2\2\2*\u0121\3\2\2\2,\u013f\3\2\2\2.\u0141\3\2\2\2\60"+
		"\u0143\3\2\2\2\62\u014e\3\2\2\2\64\u0155\3\2\2\2\66\u015f\3\2\2\28\u0161"+
		"\3\2\2\2:\u0163\3\2\2\2<\u0165\3\2\2\2>\u0167\3\2\2\2@\u0169\3\2\2\2B"+
		"\u016b\3\2\2\2DV\5\4\3\2EV\5\6\4\2FV\5\b\5\2GV\5\n\6\2HV\5\f\7\2IV\5\16"+
		"\b\2JV\5\20\t\2KV\5> \2LV\5\24\13\2MV\5\26\f\2NV\5.\30\2OV\5\30\r\2PV"+
		"\5\34\17\2QV\5 \21\2RV\5@!\2SV\5B\"\2TV\7\62\2\2UD\3\2\2\2UE\3\2\2\2U"+
		"F\3\2\2\2UG\3\2\2\2UH\3\2\2\2UI\3\2\2\2UJ\3\2\2\2UK\3\2\2\2UL\3\2\2\2"+
		"UM\3\2\2\2UN\3\2\2\2UO\3\2\2\2UP\3\2\2\2UQ\3\2\2\2UR\3\2\2\2US\3\2\2\2"+
		"UT\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2XZ\3\2\2\2YW\3\2\2\2Z[\7\2\2\3"+
		"[\3\3\2\2\2\\]\7\13\2\2]\5\3\2\2\2^_\7\f\2\2_\7\3\2\2\2`a\7\r\2\2a\t\3"+
		"\2\2\2bc\7\16\2\2c\13\3\2\2\2de\7\17\2\2e\r\3\2\2\2fg\7\20\2\2g\17\3\2"+
		"\2\2hj\7\n\2\2ik\7\3\2\2ji\3\2\2\2jk\3\2\2\2km\3\2\2\2ln\5\22\n\2ml\3"+
		"\2\2\2mn\3\2\2\2no\3\2\2\2os\7\62\2\2pr\t\2\2\2qp\3\2\2\2ru\3\2\2\2sq"+
		"\3\2\2\2st\3\2\2\2tv\3\2\2\2us\3\2\2\2vw\7?\2\2w\21\3\2\2\2x\u0089\7\23"+
		"\2\2y\u008a\7;\2\2z{\78\2\2{\u008a\7\3\2\2|}\79\2\2}\u008a\7\3\2\2~\177"+
		"\7\3\2\2\177\u0087\7:\2\2\u0080\u0081\7=\2\2\u0081\u0082\7\3\2\2\u0082"+
		"\u0088\7=\2\2\u0083\u0084\7<\2\2\u0084\u0085\7\3\2\2\u0085\u0088\7<\2"+
		"\2\u0086\u0088\7\3\2\2\u0087\u0080\3\2\2\2\u0087\u0083\3\2\2\2\u0087\u0086"+
		"\3\2\2\2\u0088\u008a\3\2\2\2\u0089y\3\2\2\2\u0089z\3\2\2\2\u0089|\3\2"+
		"\2\2\u0089~\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c"+
		"\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e\7\67\2\2\u008e\23\3\2\2\2\u008f"+
		"\u0090\7\37\2\2\u0090\u0094\5\62\32\2\u0091\u0093\7\65\2\2\u0092\u0091"+
		"\3\2\2\2\u0093\u0096\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095"+
		"\u0098\3\2\2\2\u0096\u0094\3\2\2\2\u0097\u0099\5\22\n\2\u0098\u0097\3"+
		"\2\2\2\u0098\u0099\3\2\2\2\u0099\u00a2\3\2\2\2\u009a\u009c\5\62\32\2\u009b"+
		"\u009d\5\22\n\2\u009c\u009b\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009e\3"+
		"\2\2\2\u009e\u009f\5\66\34\2\u009f\u00a0\t\3\2\2\u00a0\u00a2\3\2\2\2\u00a1"+
		"\u008f\3\2\2\2\u00a1\u009a\3\2\2\2\u00a2\25\3\2\2\2\u00a3\u00a5\7\"\2"+
		"\2\u00a4\u00a6\5\22\n\2\u00a5\u00a4\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6"+
		"\27\3\2\2\2\u00a7\u00a8\5\32\16\2\u00a8\u00a9\5\66\34\2\u00a9\u00ab\3"+
		"\2\2\2\u00aa\u00a7\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac"+
		"\u00ad\3\2\2\2\u00ad\u00af\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00b1\7\35"+
		"\2\2\u00b0\u00b2\5\22\n\2\u00b1\u00b0\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2"+
		"\u00b3\3\2\2\2\u00b3\u00b9\5\66\34\2\u00b4\u00b5\5\32\16\2\u00b5\u00b6"+
		"\5\66\34\2\u00b6\u00b8\3\2\2\2\u00b7\u00b4\3\2\2\2\u00b8\u00bb\3\2\2\2"+
		"\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bc\3\2\2\2\u00bb\u00b9"+
		"\3\2\2\2\u00bc\u00bd\5\32\16\2\u00bd\31\3\2\2\2\u00be\u00c0\7\36\2\2\u00bf"+
		"\u00be\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c5\3\2\2\2\u00c1\u00c3\5\62"+
		"\32\2\u00c2\u00c1\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4"+
		"\u00c6\7\36\2\2\u00c5\u00c2\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c5\3"+
		"\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00ca\3\2\2\2\u00c9\u00cb\5\62\32\2\u00ca"+
		"\u00c9\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cd\3\2\2\2\u00cc\u00ce\7\36"+
		"\2\2\u00cd\u00cc\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\33\3\2\2\2\u00cf\u00d5"+
		"\5\36\20\2\u00d0\u00d1\5\66\34\2\u00d1\u00d2\5\36\20\2\u00d2\u00d4\3\2"+
		"\2\2\u00d3\u00d0\3\2\2\2\u00d4\u00d7\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5"+
		"\u00d6\3\2\2\2\u00d6\35\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d8\u00d9\t\4\2"+
		"\2\u00d9\u00da\5\60\31\2\u00da\37\3\2\2\2\u00db\u00dc\5\62\32\2\u00dc"+
		"\u00dd\5\66\34\2\u00dd\u00e3\5\"\22\2\u00de\u00df\5\66\34\2\u00df\u00e0"+
		"\5\"\22\2\u00e0\u00e2\3\2\2\2\u00e1\u00de\3\2\2\2\u00e2\u00e5\3\2\2\2"+
		"\u00e3\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4!\3\2\2\2\u00e5\u00e3\3"+
		"\2\2\2\u00e6\u00e7\7#\2\2\u00e7\u00e8\5\60\31\2\u00e8#\3\2\2\2\u00e9\u00ea"+
		"\5&\24\2\u00ea\u00eb\5\62\32\2\u00eb\u00ed\7B\2\2\u00ec\u00ee\5*\26\2"+
		"\u00ed\u00ec\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00f0\3\2\2\2\u00ef\u00f1"+
		"\5,\27\2\u00f0\u00ef\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2"+
		"\u00f4\7G\2\2\u00f3\u00f5\5\22\n\2\u00f4\u00f3\3\2\2\2\u00f4\u00f5\3\2"+
		"\2\2\u00f5\u011c\3\2\2\2\u00f6\u00f7\5&\24\2\u00f7\u00f8\5\62\32\2\u00f8"+
		"\u00fc\7C\2\2\u00f9\u00fb\5\64\33\2\u00fa\u00f9\3\2\2\2\u00fb\u00fe\3"+
		"\2\2\2\u00fc\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00ff\3\2\2\2\u00fe"+
		"\u00fc\3\2\2\2\u00ff\u0101\7E\2\2\u0100\u0102\5\22\n\2\u0101\u0100\3\2"+
		"\2\2\u0101\u0102\3\2\2\2\u0102\u011c\3\2\2\2\u0103\u0107\5(\25\2\u0104"+
		"\u0106\5\64\33\2\u0105\u0104\3\2\2\2\u0106\u0109\3\2\2\2\u0107\u0105\3"+
		"\2\2\2\u0107\u0108\3\2\2\2\u0108\u010a\3\2\2\2\u0109\u0107\3\2\2\2\u010a"+
		"\u010c\7D\2\2\u010b\u010d\t\5\2\2\u010c\u010b\3\2\2\2\u010c\u010d\3\2"+
		"\2\2\u010d\u010e\3\2\2\2\u010e\u0113\5*\26\2\u010f\u0111\t\5\2\2\u0110"+
		"\u010f\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0114\5,"+
		"\27\2\u0113\u0110\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u011c\3\2\2\2\u0115"+
		"\u0116\5&\24\2\u0116\u0117\5\62\32\2\u0117\u0119\7E\2\2\u0118\u011a\5"+
		"\22\n\2\u0119\u0118\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u011c\3\2\2\2\u011b"+
		"\u00e9\3\2\2\2\u011b\u00f6\3\2\2\2\u011b\u0103\3\2\2\2\u011b\u0115\3\2"+
		"\2\2\u011c%\3\2\2\2\u011d\u011e\t\6\2\2\u011e\'\3\2\2\2\u011f\u0120\7"+
		"\34\2\2\u0120)\3\2\2\2\u0121\u0122\t\7\2\2\u0122+\3\2\2\2\u0123\u0128"+
		"\7<\2\2\u0124\u0127\5\64\33\2\u0125\u0127\7=\2\2\u0126\u0124\3\2\2\2\u0126"+
		"\u0125\3\2\2\2\u0127\u012a\3\2\2\2\u0128\u0126\3\2\2\2\u0128\u0129\3\2"+
		"\2\2\u0129\u012b\3\2\2\2\u012a\u0128\3\2\2\2\u012b\u0140\7<\2\2\u012c"+
		"\u0131\7=\2\2\u012d\u0130\5\64\33\2\u012e\u0130\7<\2\2\u012f\u012d\3\2"+
		"\2\2\u012f\u012e\3\2\2\2\u0130\u0133\3\2\2\2\u0131\u012f\3\2\2\2\u0131"+
		"\u0132\3\2\2\2\u0132\u0134\3\2\2\2\u0133\u0131\3\2\2\2\u0134\u0140\7="+
		"\2\2\u0135\u0137\7,\2\2\u0136\u0138\5\62\32\2\u0137\u0136\3\2\2\2\u0137"+
		"\u0138\3\2\2\2\u0138\u0139\3\2\2\2\u0139\u0140\7\7\2\2\u013a\u013c\7-"+
		"\2\2\u013b\u013d\5\62\32\2\u013c\u013b\3\2\2\2\u013c\u013d\3\2\2\2\u013d"+
		"\u013e\3\2\2\2\u013e\u0140\7\b\2\2\u013f\u0123\3\2\2\2\u013f\u012c\3\2"+
		"\2\2\u013f\u0135\3\2\2\2\u013f\u013a\3\2\2\2\u0140-\3\2\2\2\u0141\u0142"+
		"\5\60\31\2\u0142/\3\2\2\2\u0143\u0149\5\62\32\2\u0144\u0145\5\66\34\2"+
		"\u0145\u0146\5\62\32\2\u0146\u0148\3\2\2\2\u0147\u0144\3\2\2\2\u0148\u014b"+
		"\3\2\2\2\u0149\u0147\3\2\2\2\u0149\u014a\3\2\2\2\u014a\61\3\2\2\2\u014b"+
		"\u0149\3\2\2\2\u014c\u014f\5\64\33\2\u014d\u014f\5$\23\2\u014e\u014c\3"+
		"\2\2\2\u014e\u014d\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u014e\3\2\2\2\u0150"+
		"\u0151\3\2\2\2\u0151\63\3\2\2\2\u0152\u0154\5:\36\2\u0153\u0152\3\2\2"+
		"\2\u0154\u0157\3\2\2\2\u0155\u0153\3\2\2\2\u0155\u0156\3\2\2\2\u0156\u0158"+
		"\3\2\2\2\u0157\u0155\3\2\2\2\u0158\u015c\t\b\2\2\u0159\u015b\5<\37\2\u015a"+
		"\u0159\3\2\2\2\u015b\u015e\3\2\2\2\u015c\u015a\3\2\2\2\u015c\u015d\3\2"+
		"\2\2\u015d\65\3\2\2\2\u015e\u015c\3\2\2\2\u015f\u0160\t\5\2\2\u0160\67"+
		"\3\2\2\2\u0161\u0162\t\5\2\2\u01629\3\2\2\2\u0163\u0164\t\t\2\2\u0164"+
		";\3\2\2\2\u0165\u0166\t\n\2\2\u0166=\3\2\2\2\u0167\u0168\7\t\2\2\u0168"+
		"?\3\2\2\2\u0169\u016a\7\60\2\2\u016aA\3\2\2\2\u016b\u016c\7\61\2\2\u016c"+
		"C\3\2\2\2\60UWjms\u0087\u0089\u008b\u0094\u0098\u009c\u00a1\u00a5\u00ac"+
		"\u00b1\u00b9\u00bf\u00c2\u00c7\u00ca\u00cd\u00d5\u00e3\u00ed\u00f0\u00f4"+
		"\u00fc\u0101\u0107\u010c\u0110\u0113\u0119\u011b\u0126\u0128\u012f\u0131"+
		"\u0137\u013c\u013f\u0149\u014e\u0150\u0155\u015c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}