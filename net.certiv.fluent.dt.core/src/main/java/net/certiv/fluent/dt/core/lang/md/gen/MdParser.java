// Generated from D:/DevFiles/Eclipse/Tools/Editors/net.certiv.fluent.dt/net.certiv.fluent.dt.core/src/main/java/net/certiv/fluent/dt/core/lang/md/MdParser.g4 by ANTLR 4.12.0

	package net.certiv.fluent.dt.core.lang.md.gen;
	import java.util.List;

import org.antlr.v4.runtime.FailedPredicateException;
import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.VocabularyImpl;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import net.certiv.fluent.dt.core.lang.md.MdParserBase;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class MdParser extends MdParserBase {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WORD=1, CODE_BEG=2, CODE_END=3, CODE_TYPE=4, CODE_LINE=5, CODE_DENT=6, 
		CODE_BLANK=7, QUOTE_BLANK=8, QUOTE_DENT=9, LBOLD=10, LITALIC=11, LSTRIKE=12, 
		LDQUOTE=13, LSQUOTE=14, RBOLD=15, RITALIC=16, RSTRIKE=17, RDQUOTE=18, 
		RSQUOTE=19, COMMENT=20, HTML_BLOCK_BEG=21, HTML_BLOCK_END=22, YAML_BLOCK=23, 
		DOT_BLOCK=24, MATH_BLOCK=25, TEX_BLOCK=26, UML_BLOCK=27, MATHS=28, SPAN=29, 
		LSTYLE=30, URL=31, URLTAG=32, HTML=33, TEX=34, UNICODE=35, ENTITY=36, 
		HASHES=37, SETEXT=38, HRULE=39, DEFINE=40, TABLE_DEF=41, PIPE=42, BULLET_MARK=43, 
		NUMBER_MARK=44, TASK_MARK=45, LNK_IMG=46, LNK_FN=47, LNK_SEP=48, LNK_REF=49, 
		LNK_DEF=50, LBRACK=51, RBRACK=52, LPAREN=53, RPAREN=54, BOLD=55, ITALIC=56, 
		STRIKE=57, DQUOTE=58, SQUOTE=59, LINE_BLANK=60, LINE_BREAK=61, LINE_DENT=62, 
		VWS=63, HWS=64, CHAR=65, RSTYLE=66, CLASS=67, ID=68, EQ=69, DASH=70, CHAR_s=71, 
		TYP_c=72, END_cb=73, CHR_cb=74, TYP_d=75, END_db=76, CHR_db=77;
	public static final int
		RULE_page = 0, RULE_yamlBlock = 1, RULE_dotBlock = 2, RULE_mathBlock = 3, 
		RULE_texBlock = 4, RULE_umlBlock = 5, RULE_htmlBlock = 6, RULE_codeBlock = 7, 
		RULE_style = 8, RULE_header = 9, RULE_hrule = 10, RULE_table = 11, RULE_tableRow = 12, 
		RULE_list = 13, RULE_listItem = 14, RULE_definition = 15, RULE_defineItem = 16, 
		RULE_link = 17, RULE_imgLink = 18, RULE_fnLink = 19, RULE_alt = 20, RULE_url = 21, 
		RULE_paragraph = 22, RULE_line = 23, RULE_word = 24, RULE_l_line = 25, 
		RULE_l_word = 26, RULE_nl = 27, RULE_attrLeft = 28, RULE_attrRight = 29, 
		RULE_comment = 30, RULE_lineBlank = 31, RULE_codeBlank = 32, RULE_quoteBlank = 33, 
		RULE_lineBreak = 34;
	private static String[] makeRuleNames() {
		return new String[] {
			"page", "yamlBlock", "dotBlock", "mathBlock", "texBlock", "umlBlock", 
			"htmlBlock", "codeBlock", "style", "header", "hrule", "table", "tableRow", 
			"list", "listItem", "definition", "defineItem", "link", "imgLink", "fnLink", 
			"alt", "url", "paragraph", "line", "word", "l_line", "l_word", "nl", 
			"attrLeft", "attrRight", "comment", "lineBlank", "codeBlank", "quoteBlank", 
			"lineBreak"
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
			null, "WORD", "CODE_BEG", "CODE_END", "CODE_TYPE", "CODE_LINE", "CODE_DENT", 
			"CODE_BLANK", "QUOTE_BLANK", "QUOTE_DENT", "LBOLD", "LITALIC", "LSTRIKE", 
			"LDQUOTE", "LSQUOTE", "RBOLD", "RITALIC", "RSTRIKE", "RDQUOTE", "RSQUOTE", 
			"COMMENT", "HTML_BLOCK_BEG", "HTML_BLOCK_END", "YAML_BLOCK", "DOT_BLOCK", 
			"MATH_BLOCK", "TEX_BLOCK", "UML_BLOCK", "MATHS", "SPAN", "LSTYLE", "URL", 
			"URLTAG", "HTML", "TEX", "UNICODE", "ENTITY", "HASHES", "SETEXT", "HRULE", 
			"DEFINE", "TABLE_DEF", "PIPE", "BULLET_MARK", "NUMBER_MARK", "TASK_MARK", 
			"LNK_IMG", "LNK_FN", "LNK_SEP", "LNK_REF", "LNK_DEF", "LBRACK", "RBRACK", 
			"LPAREN", "RPAREN", "BOLD", "ITALIC", "STRIKE", "DQUOTE", "SQUOTE", "LINE_BLANK", 
			"LINE_BREAK", "LINE_DENT", "VWS", "HWS", "CHAR", "RSTYLE", "CLASS", "ID", 
			"EQ", "DASH", "CHAR_s", "TYP_c", "END_cb", "CHR_cb", "TYP_d", "END_db", 
			"CHR_db"
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

	@SuppressWarnings("CheckReturnValue")
	public static class PageContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(MdParser.EOF, 0); }
		public List<YamlBlockContext> yamlBlock() {
			return getRuleContexts(YamlBlockContext.class);
		}
		public YamlBlockContext yamlBlock(int i) {
			return getRuleContext(YamlBlockContext.class,i);
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
		public List<HtmlBlockContext> htmlBlock() {
			return getRuleContexts(HtmlBlockContext.class);
		}
		public HtmlBlockContext htmlBlock(int i) {
			return getRuleContext(HtmlBlockContext.class,i);
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
		public List<TableContext> table() {
			return getRuleContexts(TableContext.class);
		}
		public TableContext table(int i) {
			return getRuleContext(TableContext.class,i);
		}
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
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
		public List<LineBlankContext> lineBlank() {
			return getRuleContexts(LineBlankContext.class);
		}
		public LineBlankContext lineBlank(int i) {
			return getRuleContext(LineBlankContext.class,i);
		}
		public List<CodeBlankContext> codeBlank() {
			return getRuleContexts(CodeBlankContext.class);
		}
		public CodeBlankContext codeBlank(int i) {
			return getRuleContext(CodeBlankContext.class,i);
		}
		public List<QuoteBlankContext> quoteBlank() {
			return getRuleContexts(QuoteBlankContext.class);
		}
		public QuoteBlankContext quoteBlank(int i) {
			return getRuleContext(QuoteBlankContext.class,i);
		}
		public List<LineBreakContext> lineBreak() {
			return getRuleContexts(LineBreakContext.class);
		}
		public LineBreakContext lineBreak(int i) {
			return getRuleContext(LineBreakContext.class,i);
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
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -5730585610692821626L) != 0)) {
				{
				setState(89);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(70);
					yamlBlock();
					}
					break;
				case 2:
					{
					setState(71);
					dotBlock();
					}
					break;
				case 3:
					{
					setState(72);
					mathBlock();
					}
					break;
				case 4:
					{
					setState(73);
					htmlBlock();
					}
					break;
				case 5:
					{
					setState(74);
					texBlock();
					}
					break;
				case 6:
					{
					setState(75);
					umlBlock();
					}
					break;
				case 7:
					{
					setState(76);
					codeBlock();
					}
					break;
				case 8:
					{
					setState(77);
					comment();
					}
					break;
				case 9:
					{
					setState(78);
					header();
					}
					break;
				case 10:
					{
					setState(79);
					hrule();
					}
					break;
				case 11:
					{
					setState(80);
					table();
					}
					break;
				case 12:
					{
					setState(81);
					definition();
					}
					break;
				case 13:
					{
					setState(82);
					list();
					}
					break;
				case 14:
					{
					setState(83);
					paragraph();
					}
					break;
				case 15:
					{
					setState(84);
					lineBlank();
					}
					break;
				case 16:
					{
					setState(85);
					codeBlank();
					}
					break;
				case 17:
					{
					setState(86);
					quoteBlank();
					}
					break;
				case 18:
					{
					setState(87);
					lineBreak();
					}
					break;
				case 19:
					{
					setState(88);
					match(VWS);
					}
					break;
				}
				}
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(94);
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

	@SuppressWarnings("CheckReturnValue")
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
			setState(96);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 4, RULE_dotBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
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

	@SuppressWarnings("CheckReturnValue")
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
			setState(100);
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

	@SuppressWarnings("CheckReturnValue")
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
			setState(102);
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

	@SuppressWarnings("CheckReturnValue")
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
			setState(104);
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

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlBlockContext extends ParserRuleContext {
		public TerminalNode HTML_BLOCK_BEG() { return getToken(MdParser.HTML_BLOCK_BEG, 0); }
		public TerminalNode HTML_BLOCK_END() { return getToken(MdParser.HTML_BLOCK_END, 0); }
		public List<TerminalNode> COMMENT() { return getTokens(MdParser.COMMENT); }
		public TerminalNode COMMENT(int i) {
			return getToken(MdParser.COMMENT, i);
		}
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
		enterRule(_localctx, 12, RULE_htmlBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(HTML_BLOCK_BEG);
			setState(112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -6883536390058902526L) != 0)) {
				{
				setState(110);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case COMMENT:
					{
					setState(107);
					match(COMMENT);
					}
					break;
				case WORD:
				case LBOLD:
				case LITALIC:
				case LSTRIKE:
				case LDQUOTE:
				case LSQUOTE:
				case MATHS:
				case SPAN:
				case URL:
				case URLTAG:
				case HTML:
				case TEX:
				case UNICODE:
				case ENTITY:
				case PIPE:
				case LNK_IMG:
				case LNK_FN:
				case LBRACK:
				case RBRACK:
				case LPAREN:
				case RPAREN:
					{
					setState(108);
					line();
					}
					break;
				case LINE_BREAK:
				case VWS:
					{
					setState(109);
					nl();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(115);
			match(HTML_BLOCK_END);
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

	@SuppressWarnings("CheckReturnValue")
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
		public TerminalNode CODE_TYPE() { return getToken(MdParser.CODE_TYPE, 0); }
		public List<TerminalNode> CODE_LINE() { return getTokens(MdParser.CODE_LINE); }
		public TerminalNode CODE_LINE(int i) {
			return getToken(MdParser.CODE_LINE, i);
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
			setState(117);
			match(CODE_BEG);
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CODE_TYPE) {
				{
				setState(118);
				((CodeBlockContext)_localctx).lang = match(CODE_TYPE);
				}
			}

			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LSTYLE) {
				{
				setState(121);
				style();
				}
			}

			setState(124);
			match(VWS);
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CODE_LINE || _la==VWS) {
				{
				{
				setState(125);
				_la = _input.LA(1);
				if ( !(_la==CODE_LINE || _la==VWS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(131);
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

	@SuppressWarnings("CheckReturnValue")
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
			setState(133);
			match(LSTYLE);
			setState(153); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(153);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DASH:
					{
					setState(134);
					match(DASH);
					}
					break;
				case CLASS:
					{
					setState(135);
					match(CLASS);
					setState(136);
					match(WORD);
					}
					break;
				case ID:
					{
					setState(137);
					match(ID);
					setState(138);
					match(WORD);
					}
					break;
				case WORD:
					{
					setState(139);
					match(WORD);
					setState(140);
					match(EQ);
					setState(151);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case SQUOTE:
						{
						setState(141);
						match(SQUOTE);
						setState(142);
						match(WORD);
						setState(143);
						match(SQUOTE);
						}
						break;
					case DQUOTE:
						{
						setState(144);
						match(DQUOTE);
						setState(145);
						match(WORD);
						setState(146);
						match(DQUOTE);
						}
						break;
					case WORD:
					case DASH:
						{
						setState(148);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==DASH) {
							{
							setState(147);
							match(DASH);
							}
						}

						setState(150);
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
				setState(155); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WORD || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 11L) != 0) );
			setState(157);
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

	@SuppressWarnings("CheckReturnValue")
	public static class HeaderContext extends ParserRuleContext {
		public Token hdr;
		public LineContext line() {
			return getRuleContext(LineContext.class,0);
		}
		public List<TerminalNode> HASHES() { return getTokens(MdParser.HASHES); }
		public TerminalNode HASHES(int i) {
			return getToken(MdParser.HASHES, i);
		}
		public StyleContext style() {
			return getRuleContext(StyleContext.class,0);
		}
		public NlContext nl() {
			return getRuleContext(NlContext.class,0);
		}
		public TerminalNode SETEXT() { return getToken(MdParser.SETEXT, 0); }
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
			setState(174);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HASHES:
				enterOuterAlt(_localctx, 1);
				{
				setState(159);
				((HeaderContext)_localctx).hdr = match(HASHES);
				setState(160);
				line();
				setState(162);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(161);
					match(HASHES);
					}
					break;
				}
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LSTYLE) {
					{
					setState(164);
					style();
					}
				}

				}
				break;
			case WORD:
			case LBOLD:
			case LITALIC:
			case LSTRIKE:
			case LDQUOTE:
			case LSQUOTE:
			case MATHS:
			case SPAN:
			case URL:
			case URLTAG:
			case HTML:
			case TEX:
			case UNICODE:
			case ENTITY:
			case PIPE:
			case LNK_IMG:
			case LNK_FN:
			case LBRACK:
			case RBRACK:
			case LPAREN:
			case RPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(167);
				line();
				setState(169);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LSTYLE) {
					{
					setState(168);
					style();
					}
				}

				setState(171);
				nl();
				setState(172);
				match(SETEXT);
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

	@SuppressWarnings("CheckReturnValue")
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
			setState(176);
			match(HRULE);
			setState(178);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LSTYLE) {
				{
				setState(177);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TableContext extends ParserRuleContext {
		public TerminalNode TABLE_DEF() { return getToken(MdParser.TABLE_DEF, 0); }
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
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 33992637581130754L) != 0)) {
				{
				{
				setState(180);
				tableRow();
				setState(181);
				nl();
				}
				}
				setState(187);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(188);
			match(TABLE_DEF);
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LSTYLE) {
				{
				setState(189);
				style();
				}
			}

			setState(192);
			nl();
			setState(198);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(193);
					tableRow();
					setState(194);
					nl();
					}
					} 
				}
				setState(200);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			setState(201);
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

	@SuppressWarnings("CheckReturnValue")
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(203);
				match(PIPE);
				}
				break;
			}
			setState(210); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(207);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						setState(206);
						line();
						}
						break;
					}
					setState(209);
					match(PIPE);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(212); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(215);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(214);
				line();
				}
				break;
			}
			setState(218);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(217);
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

	@SuppressWarnings("CheckReturnValue")
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
			setState(220);
			listItem();
			setState(226);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(221);
					nl();
					setState(222);
					listItem();
					}
					} 
				}
				setState(228);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ListItemContext extends ParserRuleContext {
		public Token mark;
		public ParagraphContext paragraph() {
			return getRuleContext(ParagraphContext.class,0);
		}
		public TerminalNode BULLET_MARK() { return getToken(MdParser.BULLET_MARK, 0); }
		public TerminalNode NUMBER_MARK() { return getToken(MdParser.NUMBER_MARK, 0); }
		public TerminalNode TASK_MARK() { return getToken(MdParser.TASK_MARK, 0); }
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
			setState(229);
			((ListItemContext)_localctx).mark = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==BULLET_MARK || _la==NUMBER_MARK) ) {
				((ListItemContext)_localctx).mark = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(231);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TASK_MARK) {
				{
				setState(230);
				match(TASK_MARK);
				}
			}

			setState(233);
			paragraph();
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

	@SuppressWarnings("CheckReturnValue")
	public static class DefinitionContext extends ParserRuleContext {
		public LineContext line() {
			return getRuleContext(LineContext.class,0);
		}
		public List<TerminalNode> VWS() { return getTokens(MdParser.VWS); }
		public TerminalNode VWS(int i) {
			return getToken(MdParser.VWS, i);
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
			setState(235);
			line();
			setState(236);
			match(VWS);
			setState(237);
			defineItem();
			setState(242);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(238);
					match(VWS);
					setState(239);
					defineItem();
					}
					} 
				}
				setState(244);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DefineItemContext extends ParserRuleContext {
		public TerminalNode DEFINE() { return getToken(MdParser.DEFINE, 0); }
		public ParagraphContext paragraph() {
			return getRuleContext(ParagraphContext.class,0);
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
			setState(245);
			match(DEFINE);
			setState(246);
			paragraph();
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

	@SuppressWarnings("CheckReturnValue")
	public static class LinkContext extends ParserRuleContext {
		public TerminalNode LBRACK() { return getToken(MdParser.LBRACK, 0); }
		public TerminalNode LNK_DEF() { return getToken(MdParser.LNK_DEF, 0); }
		public UrlContext url() {
			return getRuleContext(UrlContext.class,0);
		}
		public TerminalNode LNK_SEP() { return getToken(MdParser.LNK_SEP, 0); }
		public TerminalNode RPAREN() { return getToken(MdParser.RPAREN, 0); }
		public TerminalNode LNK_REF() { return getToken(MdParser.LNK_REF, 0); }
		public TerminalNode RBRACK() { return getToken(MdParser.RBRACK, 0); }
		public List<L_lineContext> l_line() {
			return getRuleContexts(L_lineContext.class);
		}
		public L_lineContext l_line(int i) {
			return getRuleContext(L_lineContext.class,i);
		}
		public StyleContext style() {
			return getRuleContext(StyleContext.class,0);
		}
		public List<L_wordContext> l_word() {
			return getRuleContexts(L_wordContext.class);
		}
		public L_wordContext l_word(int i) {
			return getRuleContext(L_wordContext.class,i);
		}
		public List<NlContext> nl() {
			return getRuleContexts(NlContext.class);
		}
		public NlContext nl(int i) {
			return getRuleContext(NlContext.class,i);
		}
		public AltContext alt() {
			return getRuleContext(AltContext.class,0);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			match(LBRACK);
			setState(288);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(252);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 27026131907542018L) != 0)) {
					{
					{
					setState(249);
					l_word();
					}
					}
					setState(254);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(255);
				match(LNK_DEF);
				setState(257);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LINE_BREAK || _la==VWS) {
					{
					setState(256);
					nl();
					}
				}

				setState(259);
				url();
				setState(264);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
				case 1:
					{
					setState(261);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==LINE_BREAK || _la==VWS) {
						{
						setState(260);
						nl();
						}
					}

					setState(263);
					alt();
					}
					break;
				}
				}
				break;
			case 2:
				{
				setState(267);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 29489037953760258L) != 0)) {
					{
					setState(266);
					l_line();
					}
				}

				setState(269);
				match(LNK_SEP);
				setState(271);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==URL || _la==URLTAG) {
					{
					setState(270);
					url();
					}
				}

				setState(274);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 864691128455159808L) != 0)) {
					{
					setState(273);
					alt();
					}
				}

				setState(276);
				match(RPAREN);
				}
				break;
			case 3:
				{
				setState(278);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 29489037953760258L) != 0)) {
					{
					setState(277);
					l_line();
					}
				}

				setState(280);
				match(LNK_REF);
				setState(282);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 29489037953760258L) != 0)) {
					{
					setState(281);
					l_line();
					}
				}

				setState(284);
				match(RBRACK);
				}
				break;
			case 4:
				{
				setState(285);
				l_line();
				setState(286);
				match(RBRACK);
				}
				break;
			}
			setState(291);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				setState(290);
				style();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ImgLinkContext extends ParserRuleContext {
		public TerminalNode LNK_IMG() { return getToken(MdParser.LNK_IMG, 0); }
		public List<L_lineContext> l_line() {
			return getRuleContexts(L_lineContext.class);
		}
		public L_lineContext l_line(int i) {
			return getRuleContext(L_lineContext.class,i);
		}
		public TerminalNode LNK_SEP() { return getToken(MdParser.LNK_SEP, 0); }
		public TerminalNode RPAREN() { return getToken(MdParser.RPAREN, 0); }
		public TerminalNode LNK_REF() { return getToken(MdParser.LNK_REF, 0); }
		public TerminalNode RBRACK() { return getToken(MdParser.RBRACK, 0); }
		public StyleContext style() {
			return getRuleContext(StyleContext.class,0);
		}
		public UrlContext url() {
			return getRuleContext(UrlContext.class,0);
		}
		public AltContext alt() {
			return getRuleContext(AltContext.class,0);
		}
		public ImgLinkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_imgLink; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterImgLink(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitImgLink(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitImgLink(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImgLinkContext imgLink() throws RecognitionException {
		ImgLinkContext _localctx = new ImgLinkContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_imgLink);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			match(LNK_IMG);
			setState(317);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				{
				setState(294);
				l_line();
				setState(295);
				match(LNK_SEP);
				setState(297);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==URL || _la==URLTAG) {
					{
					setState(296);
					url();
					}
				}

				setState(300);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 864691128455159808L) != 0)) {
					{
					setState(299);
					alt();
					}
				}

				setState(302);
				match(RPAREN);
				}
				break;
			case 2:
				{
				setState(304);
				l_line();
				setState(305);
				match(LNK_REF);
				setState(309);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 29489037953760258L) != 0)) {
					{
					{
					setState(306);
					l_line();
					}
					}
					setState(311);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(312);
				match(RBRACK);
				}
				break;
			case 3:
				{
				setState(314);
				l_line();
				setState(315);
				match(RBRACK);
				}
				break;
			}
			setState(320);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				{
				setState(319);
				style();
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

	@SuppressWarnings("CheckReturnValue")
	public static class FnLinkContext extends ParserRuleContext {
		public TerminalNode LNK_FN() { return getToken(MdParser.LNK_FN, 0); }
		public L_wordContext l_word() {
			return getRuleContext(L_wordContext.class,0);
		}
		public TerminalNode LNK_DEF() { return getToken(MdParser.LNK_DEF, 0); }
		public List<L_lineContext> l_line() {
			return getRuleContexts(L_lineContext.class);
		}
		public L_lineContext l_line(int i) {
			return getRuleContext(L_lineContext.class,i);
		}
		public TerminalNode LNK_SEP() { return getToken(MdParser.LNK_SEP, 0); }
		public TerminalNode RPAREN() { return getToken(MdParser.RPAREN, 0); }
		public TerminalNode LNK_REF() { return getToken(MdParser.LNK_REF, 0); }
		public TerminalNode RBRACK() { return getToken(MdParser.RBRACK, 0); }
		public StyleContext style() {
			return getRuleContext(StyleContext.class,0);
		}
		public List<NlContext> nl() {
			return getRuleContexts(NlContext.class);
		}
		public NlContext nl(int i) {
			return getRuleContext(NlContext.class,i);
		}
		public UrlContext url() {
			return getRuleContext(UrlContext.class,0);
		}
		public AltContext alt() {
			return getRuleContext(AltContext.class,0);
		}
		public FnLinkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fnLink; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterFnLink(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitFnLink(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitFnLink(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FnLinkContext fnLink() throws RecognitionException {
		FnLinkContext _localctx = new FnLinkContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_fnLink);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(322);
			match(LNK_FN);
			setState(358);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				{
				setState(323);
				l_word();
				setState(324);
				match(LNK_DEF);
				setState(325);
				l_line();
				setState(332);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(326);
						nl();
						setState(327);
						if (!( twoSpaces() )) throw new FailedPredicateException(this, " twoSpaces() ");
						setState(328);
						l_line();
						}
						} 
					}
					setState(334);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
				}
				}
				break;
			case 2:
				{
				setState(335);
				l_line();
				setState(336);
				match(LNK_SEP);
				setState(338);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==URL || _la==URLTAG) {
					{
					setState(337);
					url();
					}
				}

				setState(341);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 864691128455159808L) != 0)) {
					{
					setState(340);
					alt();
					}
				}

				setState(343);
				match(RPAREN);
				}
				break;
			case 3:
				{
				setState(345);
				l_line();
				setState(346);
				match(LNK_REF);
				setState(350);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 29489037953760258L) != 0)) {
					{
					{
					setState(347);
					l_line();
					}
					}
					setState(352);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(353);
				match(RBRACK);
				}
				break;
			case 4:
				{
				setState(355);
				l_line();
				setState(356);
				match(RBRACK);
				}
				break;
			}
			setState(361);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				{
				setState(360);
				style();
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 40, RULE_alt);
		int _la;
		try {
			setState(391);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DQUOTE:
				enterOuterAlt(_localctx, 1);
				{
				setState(363);
				match(DQUOTE);
				setState(368);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 610242283652021250L) != 0)) {
					{
					setState(366);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case WORD:
					case LBOLD:
					case LITALIC:
					case LSTRIKE:
					case LDQUOTE:
					case LSQUOTE:
					case MATHS:
					case SPAN:
					case URL:
					case URLTAG:
					case HTML:
					case TEX:
					case UNICODE:
					case ENTITY:
					case PIPE:
					case LBRACK:
					case RBRACK:
					case LPAREN:
					case RPAREN:
						{
						setState(364);
						word();
						}
						break;
					case SQUOTE:
						{
						setState(365);
						match(SQUOTE);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(370);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(371);
				match(DQUOTE);
				}
				break;
			case SQUOTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(372);
				match(SQUOTE);
				setState(377);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 322011907500309506L) != 0)) {
					{
					setState(375);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case WORD:
					case LBOLD:
					case LITALIC:
					case LSTRIKE:
					case LDQUOTE:
					case LSQUOTE:
					case MATHS:
					case SPAN:
					case URL:
					case URLTAG:
					case HTML:
					case TEX:
					case UNICODE:
					case ENTITY:
					case PIPE:
					case LBRACK:
					case RBRACK:
					case LPAREN:
					case RPAREN:
						{
						setState(373);
						word();
						}
						break;
					case DQUOTE:
						{
						setState(374);
						match(DQUOTE);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(379);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(380);
				match(SQUOTE);
				}
				break;
			case LDQUOTE:
				enterOuterAlt(_localctx, 3);
				{
				setState(381);
				match(LDQUOTE);
				setState(383);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 33992637581130754L) != 0)) {
					{
					setState(382);
					line();
					}
				}

				setState(385);
				match(RDQUOTE);
				}
				break;
			case LSQUOTE:
				enterOuterAlt(_localctx, 4);
				{
				setState(386);
				match(LSQUOTE);
				setState(388);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 33992637581130754L) != 0)) {
					{
					setState(387);
					line();
					}
				}

				setState(390);
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

	@SuppressWarnings("CheckReturnValue")
	public static class UrlContext extends ParserRuleContext {
		public TerminalNode URL() { return getToken(MdParser.URL, 0); }
		public TerminalNode URLTAG() { return getToken(MdParser.URLTAG, 0); }
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
		enterRule(_localctx, 42, RULE_url);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(393);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParagraphContext extends ParserRuleContext {
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(395);
			line();
			setState(401);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(396);
					nl();
					setState(397);
					line();
					}
					} 
				}
				setState(403);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LineContext extends ParserRuleContext {
		public List<LinkContext> link() {
			return getRuleContexts(LinkContext.class);
		}
		public LinkContext link(int i) {
			return getRuleContext(LinkContext.class,i);
		}
		public List<ImgLinkContext> imgLink() {
			return getRuleContexts(ImgLinkContext.class);
		}
		public ImgLinkContext imgLink(int i) {
			return getRuleContext(ImgLinkContext.class,i);
		}
		public List<FnLinkContext> fnLink() {
			return getRuleContexts(FnLinkContext.class);
		}
		public FnLinkContext fnLink(int i) {
			return getRuleContext(FnLinkContext.class,i);
		}
		public List<WordContext> word() {
			return getRuleContexts(WordContext.class);
		}
		public WordContext word(int i) {
			return getRuleContext(WordContext.class,i);
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
		enterRule(_localctx, 46, RULE_line);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(408); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(408);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
					case 1:
						{
						setState(404);
						link();
						}
						break;
					case 2:
						{
						setState(405);
						imgLink();
						}
						break;
					case 3:
						{
						setState(406);
						fnLink();
						}
						break;
					case 4:
						{
						setState(407);
						word();
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(410); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class WordContext extends ParserRuleContext {
		public Token w;
		public TerminalNode WORD() { return getToken(MdParser.WORD, 0); }
		public TerminalNode ENTITY() { return getToken(MdParser.ENTITY, 0); }
		public TerminalNode UNICODE() { return getToken(MdParser.UNICODE, 0); }
		public TerminalNode URL() { return getToken(MdParser.URL, 0); }
		public TerminalNode URLTAG() { return getToken(MdParser.URLTAG, 0); }
		public TerminalNode HTML() { return getToken(MdParser.HTML, 0); }
		public TerminalNode SPAN() { return getToken(MdParser.SPAN, 0); }
		public TerminalNode MATHS() { return getToken(MdParser.MATHS, 0); }
		public TerminalNode TEX() { return getToken(MdParser.TEX, 0); }
		public TerminalNode LPAREN() { return getToken(MdParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(MdParser.RPAREN, 0); }
		public TerminalNode PIPE() { return getToken(MdParser.PIPE, 0); }
		public TerminalNode LBRACK() { return getToken(MdParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(MdParser.RBRACK, 0); }
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
		enterRule(_localctx, 48, RULE_word);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(415);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 31744L) != 0)) {
				{
				{
				setState(412);
				attrLeft();
				}
				}
				setState(417);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(418);
			((WordContext)_localctx).w = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 33781531348566018L) != 0)) ) {
				((WordContext)_localctx).w = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(422);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(419);
					attrRight();
					}
					} 
				}
				setState(424);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class L_lineContext extends ParserRuleContext {
		public List<LinkContext> link() {
			return getRuleContexts(LinkContext.class);
		}
		public LinkContext link(int i) {
			return getRuleContext(LinkContext.class,i);
		}
		public List<ImgLinkContext> imgLink() {
			return getRuleContexts(ImgLinkContext.class);
		}
		public ImgLinkContext imgLink(int i) {
			return getRuleContext(ImgLinkContext.class,i);
		}
		public List<FnLinkContext> fnLink() {
			return getRuleContexts(FnLinkContext.class);
		}
		public FnLinkContext fnLink(int i) {
			return getRuleContext(FnLinkContext.class,i);
		}
		public List<L_wordContext> l_word() {
			return getRuleContexts(L_wordContext.class);
		}
		public L_wordContext l_word(int i) {
			return getRuleContext(L_wordContext.class,i);
		}
		public L_lineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_l_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterL_line(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitL_line(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitL_line(this);
			else return visitor.visitChildren(this);
		}
	}

	public final L_lineContext l_line() throws RecognitionException {
		L_lineContext _localctx = new L_lineContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_l_line);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(429); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(429);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case LBRACK:
						{
						setState(425);
						link();
						}
						break;
					case LNK_IMG:
						{
						setState(426);
						imgLink();
						}
						break;
					case LNK_FN:
						{
						setState(427);
						fnLink();
						}
						break;
					case WORD:
					case LBOLD:
					case LITALIC:
					case LSTRIKE:
					case LDQUOTE:
					case LSQUOTE:
					case MATHS:
					case SPAN:
					case URL:
					case URLTAG:
					case HTML:
					case TEX:
					case UNICODE:
					case ENTITY:
					case PIPE:
					case LPAREN:
					case RPAREN:
						{
						setState(428);
						l_word();
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
				setState(431); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class L_wordContext extends ParserRuleContext {
		public Token w;
		public TerminalNode WORD() { return getToken(MdParser.WORD, 0); }
		public TerminalNode ENTITY() { return getToken(MdParser.ENTITY, 0); }
		public TerminalNode UNICODE() { return getToken(MdParser.UNICODE, 0); }
		public TerminalNode URL() { return getToken(MdParser.URL, 0); }
		public TerminalNode URLTAG() { return getToken(MdParser.URLTAG, 0); }
		public TerminalNode HTML() { return getToken(MdParser.HTML, 0); }
		public TerminalNode SPAN() { return getToken(MdParser.SPAN, 0); }
		public TerminalNode MATHS() { return getToken(MdParser.MATHS, 0); }
		public TerminalNode TEX() { return getToken(MdParser.TEX, 0); }
		public TerminalNode LPAREN() { return getToken(MdParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(MdParser.RPAREN, 0); }
		public TerminalNode PIPE() { return getToken(MdParser.PIPE, 0); }
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
		public L_wordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_l_word; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterL_word(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitL_word(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitL_word(this);
			else return visitor.visitChildren(this);
		}
	}

	public final L_wordContext l_word() throws RecognitionException {
		L_wordContext _localctx = new L_wordContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_l_word);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(436);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 31744L) != 0)) {
				{
				{
				setState(433);
				attrLeft();
				}
				}
				setState(438);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(439);
			((L_wordContext)_localctx).w = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 27026131907510274L) != 0)) ) {
				((L_wordContext)_localctx).w = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(443);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(440);
					attrRight();
					}
					} 
				}
				setState(445);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
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
		enterRule(_localctx, 54, RULE_nl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(446);
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

	@SuppressWarnings("CheckReturnValue")
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
			setState(448);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 31744L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
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
			setState(450);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1015808L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
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
			setState(452);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LineBlankContext extends ParserRuleContext {
		public TerminalNode LINE_BLANK() { return getToken(MdParser.LINE_BLANK, 0); }
		public LineBlankContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lineBlank; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterLineBlank(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitLineBlank(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitLineBlank(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LineBlankContext lineBlank() throws RecognitionException {
		LineBlankContext _localctx = new LineBlankContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_lineBlank);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(454);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CodeBlankContext extends ParserRuleContext {
		public TerminalNode CODE_BLANK() { return getToken(MdParser.CODE_BLANK, 0); }
		public CodeBlankContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_codeBlank; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterCodeBlank(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitCodeBlank(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitCodeBlank(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CodeBlankContext codeBlank() throws RecognitionException {
		CodeBlankContext _localctx = new CodeBlankContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_codeBlank);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(456);
			match(CODE_BLANK);
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

	@SuppressWarnings("CheckReturnValue")
	public static class QuoteBlankContext extends ParserRuleContext {
		public TerminalNode QUOTE_BLANK() { return getToken(MdParser.QUOTE_BLANK, 0); }
		public QuoteBlankContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quoteBlank; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterQuoteBlank(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitQuoteBlank(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitQuoteBlank(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuoteBlankContext quoteBlank() throws RecognitionException {
		QuoteBlankContext _localctx = new QuoteBlankContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_quoteBlank);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(458);
			match(QUOTE_BLANK);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LineBreakContext extends ParserRuleContext {
		public TerminalNode LINE_BREAK() { return getToken(MdParser.LINE_BREAK, 0); }
		public LineBreakContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lineBreak; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterLineBreak(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitLineBreak(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitLineBreak(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LineBreakContext lineBreak() throws RecognitionException {
		LineBreakContext _localctx = new LineBreakContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_lineBreak);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(460);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 19:
			return fnLink_sempred((FnLinkContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean fnLink_sempred(FnLinkContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return  twoSpaces() ;
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001M\u01cf\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0005\u0000Z\b\u0000\n\u0000\f\u0000]\t\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0005\u0006o\b\u0006\n\u0006\f\u0006r\t"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0003\u0007x\b"+
		"\u0007\u0001\u0007\u0003\u0007{\b\u0007\u0001\u0007\u0001\u0007\u0005"+
		"\u0007\u007f\b\u0007\n\u0007\f\u0007\u0082\t\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u0095\b\b\u0001"+
		"\b\u0003\b\u0098\b\b\u0004\b\u009a\b\b\u000b\b\f\b\u009b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\t\u0003\t\u00a3\b\t\u0001\t\u0003\t\u00a6\b\t"+
		"\u0001\t\u0001\t\u0003\t\u00aa\b\t\u0001\t\u0001\t\u0001\t\u0003\t\u00af"+
		"\b\t\u0001\n\u0001\n\u0003\n\u00b3\b\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0005\u000b\u00b8\b\u000b\n\u000b\f\u000b\u00bb\t\u000b\u0001\u000b\u0001"+
		"\u000b\u0003\u000b\u00bf\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0005\u000b\u00c5\b\u000b\n\u000b\f\u000b\u00c8\t\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0003\f\u00cd\b\f\u0001\f\u0003\f\u00d0\b\f\u0001"+
		"\f\u0004\f\u00d3\b\f\u000b\f\f\f\u00d4\u0001\f\u0003\f\u00d8\b\f\u0001"+
		"\f\u0003\f\u00db\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u00e1\b\r"+
		"\n\r\f\r\u00e4\t\r\u0001\u000e\u0001\u000e\u0003\u000e\u00e8\b\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0005\u000f\u00f1\b\u000f\n\u000f\f\u000f\u00f4\t\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0005\u0011\u00fb\b\u0011"+
		"\n\u0011\f\u0011\u00fe\t\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u0102"+
		"\b\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u0106\b\u0011\u0001\u0011"+
		"\u0003\u0011\u0109\b\u0011\u0001\u0011\u0003\u0011\u010c\b\u0011\u0001"+
		"\u0011\u0001\u0011\u0003\u0011\u0110\b\u0011\u0001\u0011\u0003\u0011\u0113"+
		"\b\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u0117\b\u0011\u0001\u0011"+
		"\u0001\u0011\u0003\u0011\u011b\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0003\u0011\u0121\b\u0011\u0001\u0011\u0003\u0011\u0124\b"+
		"\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u012a"+
		"\b\u0012\u0001\u0012\u0003\u0012\u012d\b\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u0134\b\u0012\n\u0012"+
		"\f\u0012\u0137\t\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0003\u0012\u013e\b\u0012\u0001\u0012\u0003\u0012\u0141\b"+
		"\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u014b\b\u0013\n\u0013\f\u0013"+
		"\u014e\t\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0153\b"+
		"\u0013\u0001\u0013\u0003\u0013\u0156\b\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u015d\b\u0013\n\u0013\f\u0013"+
		"\u0160\t\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0003\u0013\u0167\b\u0013\u0001\u0013\u0003\u0013\u016a\b\u0013\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0005\u0014\u016f\b\u0014\n\u0014\f\u0014"+
		"\u0172\t\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0005\u0014"+
		"\u0178\b\u0014\n\u0014\f\u0014\u017b\t\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0003\u0014\u0180\b\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003"+
		"\u0014\u0185\b\u0014\u0001\u0014\u0003\u0014\u0188\b\u0014\u0001\u0015"+
		"\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0005\u0016"+
		"\u0190\b\u0016\n\u0016\f\u0016\u0193\t\u0016\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0004\u0017\u0199\b\u0017\u000b\u0017\f\u0017\u019a"+
		"\u0001\u0018\u0005\u0018\u019e\b\u0018\n\u0018\f\u0018\u01a1\t\u0018\u0001"+
		"\u0018\u0001\u0018\u0005\u0018\u01a5\b\u0018\n\u0018\f\u0018\u01a8\t\u0018"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0004\u0019\u01ae\b\u0019"+
		"\u000b\u0019\f\u0019\u01af\u0001\u001a\u0005\u001a\u01b3\b\u001a\n\u001a"+
		"\f\u001a\u01b6\t\u001a\u0001\u001a\u0001\u001a\u0005\u001a\u01ba\b\u001a"+
		"\n\u001a\f\u001a\u01bd\t\u001a\u0001\u001b\u0001\u001b\u0001\u001c\u0001"+
		"\u001c\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001f\u0001"+
		"\u001f\u0001 \u0001 \u0001!\u0001!\u0001\"\u0001\"\u0001\"\u0000\u0000"+
		"#\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"$&(*,.02468:<>@BD\u0000\b\u0002\u0000\u0005\u0005??\u0001"+
		"\u0000+,\u0001\u0000\u001f \u0005\u0000\u0001\u0001\u001c\u001d\u001f"+
		"$**36\u0005\u0000\u0001\u0001\u001c\u001d\u001f$**56\u0002\u0000==??\u0001"+
		"\u0000\n\u000e\u0001\u0000\u000f\u0013\u020c\u0000[\u0001\u0000\u0000"+
		"\u0000\u0002`\u0001\u0000\u0000\u0000\u0004b\u0001\u0000\u0000\u0000\u0006"+
		"d\u0001\u0000\u0000\u0000\bf\u0001\u0000\u0000\u0000\nh\u0001\u0000\u0000"+
		"\u0000\fj\u0001\u0000\u0000\u0000\u000eu\u0001\u0000\u0000\u0000\u0010"+
		"\u0085\u0001\u0000\u0000\u0000\u0012\u00ae\u0001\u0000\u0000\u0000\u0014"+
		"\u00b0\u0001\u0000\u0000\u0000\u0016\u00b9\u0001\u0000\u0000\u0000\u0018"+
		"\u00cc\u0001\u0000\u0000\u0000\u001a\u00dc\u0001\u0000\u0000\u0000\u001c"+
		"\u00e5\u0001\u0000\u0000\u0000\u001e\u00eb\u0001\u0000\u0000\u0000 \u00f5"+
		"\u0001\u0000\u0000\u0000\"\u00f8\u0001\u0000\u0000\u0000$\u0125\u0001"+
		"\u0000\u0000\u0000&\u0142\u0001\u0000\u0000\u0000(\u0187\u0001\u0000\u0000"+
		"\u0000*\u0189\u0001\u0000\u0000\u0000,\u018b\u0001\u0000\u0000\u0000."+
		"\u0198\u0001\u0000\u0000\u00000\u019f\u0001\u0000\u0000\u00002\u01ad\u0001"+
		"\u0000\u0000\u00004\u01b4\u0001\u0000\u0000\u00006\u01be\u0001\u0000\u0000"+
		"\u00008\u01c0\u0001\u0000\u0000\u0000:\u01c2\u0001\u0000\u0000\u0000<"+
		"\u01c4\u0001\u0000\u0000\u0000>\u01c6\u0001\u0000\u0000\u0000@\u01c8\u0001"+
		"\u0000\u0000\u0000B\u01ca\u0001\u0000\u0000\u0000D\u01cc\u0001\u0000\u0000"+
		"\u0000FZ\u0003\u0002\u0001\u0000GZ\u0003\u0004\u0002\u0000HZ\u0003\u0006"+
		"\u0003\u0000IZ\u0003\f\u0006\u0000JZ\u0003\b\u0004\u0000KZ\u0003\n\u0005"+
		"\u0000LZ\u0003\u000e\u0007\u0000MZ\u0003<\u001e\u0000NZ\u0003\u0012\t"+
		"\u0000OZ\u0003\u0014\n\u0000PZ\u0003\u0016\u000b\u0000QZ\u0003\u001e\u000f"+
		"\u0000RZ\u0003\u001a\r\u0000SZ\u0003,\u0016\u0000TZ\u0003>\u001f\u0000"+
		"UZ\u0003@ \u0000VZ\u0003B!\u0000WZ\u0003D\"\u0000XZ\u0005?\u0000\u0000"+
		"YF\u0001\u0000\u0000\u0000YG\u0001\u0000\u0000\u0000YH\u0001\u0000\u0000"+
		"\u0000YI\u0001\u0000\u0000\u0000YJ\u0001\u0000\u0000\u0000YK\u0001\u0000"+
		"\u0000\u0000YL\u0001\u0000\u0000\u0000YM\u0001\u0000\u0000\u0000YN\u0001"+
		"\u0000\u0000\u0000YO\u0001\u0000\u0000\u0000YP\u0001\u0000\u0000\u0000"+
		"YQ\u0001\u0000\u0000\u0000YR\u0001\u0000\u0000\u0000YS\u0001\u0000\u0000"+
		"\u0000YT\u0001\u0000\u0000\u0000YU\u0001\u0000\u0000\u0000YV\u0001\u0000"+
		"\u0000\u0000YW\u0001\u0000\u0000\u0000YX\u0001\u0000\u0000\u0000Z]\u0001"+
		"\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000"+
		"\\^\u0001\u0000\u0000\u0000][\u0001\u0000\u0000\u0000^_\u0005\u0000\u0000"+
		"\u0001_\u0001\u0001\u0000\u0000\u0000`a\u0005\u0017\u0000\u0000a\u0003"+
		"\u0001\u0000\u0000\u0000bc\u0005\u0018\u0000\u0000c\u0005\u0001\u0000"+
		"\u0000\u0000de\u0005\u0019\u0000\u0000e\u0007\u0001\u0000\u0000\u0000"+
		"fg\u0005\u001a\u0000\u0000g\t\u0001\u0000\u0000\u0000hi\u0005\u001b\u0000"+
		"\u0000i\u000b\u0001\u0000\u0000\u0000jp\u0005\u0015\u0000\u0000ko\u0005"+
		"\u0014\u0000\u0000lo\u0003.\u0017\u0000mo\u00036\u001b\u0000nk\u0001\u0000"+
		"\u0000\u0000nl\u0001\u0000\u0000\u0000nm\u0001\u0000\u0000\u0000or\u0001"+
		"\u0000\u0000\u0000pn\u0001\u0000\u0000\u0000pq\u0001\u0000\u0000\u0000"+
		"qs\u0001\u0000\u0000\u0000rp\u0001\u0000\u0000\u0000st\u0005\u0016\u0000"+
		"\u0000t\r\u0001\u0000\u0000\u0000uw\u0005\u0002\u0000\u0000vx\u0005\u0004"+
		"\u0000\u0000wv\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000xz\u0001"+
		"\u0000\u0000\u0000y{\u0003\u0010\b\u0000zy\u0001\u0000\u0000\u0000z{\u0001"+
		"\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000|\u0080\u0005?\u0000\u0000"+
		"}\u007f\u0007\u0000\u0000\u0000~}\u0001\u0000\u0000\u0000\u007f\u0082"+
		"\u0001\u0000\u0000\u0000\u0080~\u0001\u0000\u0000\u0000\u0080\u0081\u0001"+
		"\u0000\u0000\u0000\u0081\u0083\u0001\u0000\u0000\u0000\u0082\u0080\u0001"+
		"\u0000\u0000\u0000\u0083\u0084\u0005\u0003\u0000\u0000\u0084\u000f\u0001"+
		"\u0000\u0000\u0000\u0085\u0099\u0005\u001e\u0000\u0000\u0086\u009a\u0005"+
		"F\u0000\u0000\u0087\u0088\u0005C\u0000\u0000\u0088\u009a\u0005\u0001\u0000"+
		"\u0000\u0089\u008a\u0005D\u0000\u0000\u008a\u009a\u0005\u0001\u0000\u0000"+
		"\u008b\u008c\u0005\u0001\u0000\u0000\u008c\u0097\u0005E\u0000\u0000\u008d"+
		"\u008e\u0005;\u0000\u0000\u008e\u008f\u0005\u0001\u0000\u0000\u008f\u0098"+
		"\u0005;\u0000\u0000\u0090\u0091\u0005:\u0000\u0000\u0091\u0092\u0005\u0001"+
		"\u0000\u0000\u0092\u0098\u0005:\u0000\u0000\u0093\u0095\u0005F\u0000\u0000"+
		"\u0094\u0093\u0001\u0000\u0000\u0000\u0094\u0095\u0001\u0000\u0000\u0000"+
		"\u0095\u0096\u0001\u0000\u0000\u0000\u0096\u0098\u0005\u0001\u0000\u0000"+
		"\u0097\u008d\u0001\u0000\u0000\u0000\u0097\u0090\u0001\u0000\u0000\u0000"+
		"\u0097\u0094\u0001\u0000\u0000\u0000\u0098\u009a\u0001\u0000\u0000\u0000"+
		"\u0099\u0086\u0001\u0000\u0000\u0000\u0099\u0087\u0001\u0000\u0000\u0000"+
		"\u0099\u0089\u0001\u0000\u0000\u0000\u0099\u008b\u0001\u0000\u0000\u0000"+
		"\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u0099\u0001\u0000\u0000\u0000"+
		"\u009b\u009c\u0001\u0000\u0000\u0000\u009c\u009d\u0001\u0000\u0000\u0000"+
		"\u009d\u009e\u0005B\u0000\u0000\u009e\u0011\u0001\u0000\u0000\u0000\u009f"+
		"\u00a0\u0005%\u0000\u0000\u00a0\u00a2\u0003.\u0017\u0000\u00a1\u00a3\u0005"+
		"%\u0000\u0000\u00a2\u00a1\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000"+
		"\u0000\u0000\u00a3\u00a5\u0001\u0000\u0000\u0000\u00a4\u00a6\u0003\u0010"+
		"\b\u0000\u00a5\u00a4\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000"+
		"\u0000\u00a6\u00af\u0001\u0000\u0000\u0000\u00a7\u00a9\u0003.\u0017\u0000"+
		"\u00a8\u00aa\u0003\u0010\b\u0000\u00a9\u00a8\u0001\u0000\u0000\u0000\u00a9"+
		"\u00aa\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab"+
		"\u00ac\u00036\u001b\u0000\u00ac\u00ad\u0005&\u0000\u0000\u00ad\u00af\u0001"+
		"\u0000\u0000\u0000\u00ae\u009f\u0001\u0000\u0000\u0000\u00ae\u00a7\u0001"+
		"\u0000\u0000\u0000\u00af\u0013\u0001\u0000\u0000\u0000\u00b0\u00b2\u0005"+
		"\'\u0000\u0000\u00b1\u00b3\u0003\u0010\b\u0000\u00b2\u00b1\u0001\u0000"+
		"\u0000\u0000\u00b2\u00b3\u0001\u0000\u0000\u0000\u00b3\u0015\u0001\u0000"+
		"\u0000\u0000\u00b4\u00b5\u0003\u0018\f\u0000\u00b5\u00b6\u00036\u001b"+
		"\u0000\u00b6\u00b8\u0001\u0000\u0000\u0000\u00b7\u00b4\u0001\u0000\u0000"+
		"\u0000\u00b8\u00bb\u0001\u0000\u0000\u0000\u00b9\u00b7\u0001\u0000\u0000"+
		"\u0000\u00b9\u00ba\u0001\u0000\u0000\u0000\u00ba\u00bc\u0001\u0000\u0000"+
		"\u0000\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bc\u00be\u0005)\u0000\u0000"+
		"\u00bd\u00bf\u0003\u0010\b\u0000\u00be\u00bd\u0001\u0000\u0000\u0000\u00be"+
		"\u00bf\u0001\u0000\u0000\u0000\u00bf\u00c0\u0001\u0000\u0000\u0000\u00c0"+
		"\u00c6\u00036\u001b\u0000\u00c1\u00c2\u0003\u0018\f\u0000\u00c2\u00c3"+
		"\u00036\u001b\u0000\u00c3\u00c5\u0001\u0000\u0000\u0000\u00c4\u00c1\u0001"+
		"\u0000\u0000\u0000\u00c5\u00c8\u0001\u0000\u0000\u0000\u00c6\u00c4\u0001"+
		"\u0000\u0000\u0000\u00c6\u00c7\u0001\u0000\u0000\u0000\u00c7\u00c9\u0001"+
		"\u0000\u0000\u0000\u00c8\u00c6\u0001\u0000\u0000\u0000\u00c9\u00ca\u0003"+
		"\u0018\f\u0000\u00ca\u0017\u0001\u0000\u0000\u0000\u00cb\u00cd\u0005*"+
		"\u0000\u0000\u00cc\u00cb\u0001\u0000\u0000\u0000\u00cc\u00cd\u0001\u0000"+
		"\u0000\u0000\u00cd\u00d2\u0001\u0000\u0000\u0000\u00ce\u00d0\u0003.\u0017"+
		"\u0000\u00cf\u00ce\u0001\u0000\u0000\u0000\u00cf\u00d0\u0001\u0000\u0000"+
		"\u0000\u00d0\u00d1\u0001\u0000\u0000\u0000\u00d1\u00d3\u0005*\u0000\u0000"+
		"\u00d2\u00cf\u0001\u0000\u0000\u0000\u00d3\u00d4\u0001\u0000\u0000\u0000"+
		"\u00d4\u00d2\u0001\u0000\u0000\u0000\u00d4\u00d5\u0001\u0000\u0000\u0000"+
		"\u00d5\u00d7\u0001\u0000\u0000\u0000\u00d6\u00d8\u0003.\u0017\u0000\u00d7"+
		"\u00d6\u0001\u0000\u0000\u0000\u00d7\u00d8\u0001\u0000\u0000\u0000\u00d8"+
		"\u00da\u0001\u0000\u0000\u0000\u00d9\u00db\u0005*\u0000\u0000\u00da\u00d9"+
		"\u0001\u0000\u0000\u0000\u00da\u00db\u0001\u0000\u0000\u0000\u00db\u0019"+
		"\u0001\u0000\u0000\u0000\u00dc\u00e2\u0003\u001c\u000e\u0000\u00dd\u00de"+
		"\u00036\u001b\u0000\u00de\u00df\u0003\u001c\u000e\u0000\u00df\u00e1\u0001"+
		"\u0000\u0000\u0000\u00e0\u00dd\u0001\u0000\u0000\u0000\u00e1\u00e4\u0001"+
		"\u0000\u0000\u0000\u00e2\u00e0\u0001\u0000\u0000\u0000\u00e2\u00e3\u0001"+
		"\u0000\u0000\u0000\u00e3\u001b\u0001\u0000\u0000\u0000\u00e4\u00e2\u0001"+
		"\u0000\u0000\u0000\u00e5\u00e7\u0007\u0001\u0000\u0000\u00e6\u00e8\u0005"+
		"-\u0000\u0000\u00e7\u00e6\u0001\u0000\u0000\u0000\u00e7\u00e8\u0001\u0000"+
		"\u0000\u0000\u00e8\u00e9\u0001\u0000\u0000\u0000\u00e9\u00ea\u0003,\u0016"+
		"\u0000\u00ea\u001d\u0001\u0000\u0000\u0000\u00eb\u00ec\u0003.\u0017\u0000"+
		"\u00ec\u00ed\u0005?\u0000\u0000\u00ed\u00f2\u0003 \u0010\u0000\u00ee\u00ef"+
		"\u0005?\u0000\u0000\u00ef\u00f1\u0003 \u0010\u0000\u00f0\u00ee\u0001\u0000"+
		"\u0000\u0000\u00f1\u00f4\u0001\u0000\u0000\u0000\u00f2\u00f0\u0001\u0000"+
		"\u0000\u0000\u00f2\u00f3\u0001\u0000\u0000\u0000\u00f3\u001f\u0001\u0000"+
		"\u0000\u0000\u00f4\u00f2\u0001\u0000\u0000\u0000\u00f5\u00f6\u0005(\u0000"+
		"\u0000\u00f6\u00f7\u0003,\u0016\u0000\u00f7!\u0001\u0000\u0000\u0000\u00f8"+
		"\u0120\u00053\u0000\u0000\u00f9\u00fb\u00034\u001a\u0000\u00fa\u00f9\u0001"+
		"\u0000\u0000\u0000\u00fb\u00fe\u0001\u0000\u0000\u0000\u00fc\u00fa\u0001"+
		"\u0000\u0000\u0000\u00fc\u00fd\u0001\u0000\u0000\u0000\u00fd\u00ff\u0001"+
		"\u0000\u0000\u0000\u00fe\u00fc\u0001\u0000\u0000\u0000\u00ff\u0101\u0005"+
		"2\u0000\u0000\u0100\u0102\u00036\u001b\u0000\u0101\u0100\u0001\u0000\u0000"+
		"\u0000\u0101\u0102\u0001\u0000\u0000\u0000\u0102\u0103\u0001\u0000\u0000"+
		"\u0000\u0103\u0108\u0003*\u0015\u0000\u0104\u0106\u00036\u001b\u0000\u0105"+
		"\u0104\u0001\u0000\u0000\u0000\u0105\u0106\u0001\u0000\u0000\u0000\u0106"+
		"\u0107\u0001\u0000\u0000\u0000\u0107\u0109\u0003(\u0014\u0000\u0108\u0105"+
		"\u0001\u0000\u0000\u0000\u0108\u0109\u0001\u0000\u0000\u0000\u0109\u0121"+
		"\u0001\u0000\u0000\u0000\u010a\u010c\u00032\u0019\u0000\u010b\u010a\u0001"+
		"\u0000\u0000\u0000\u010b\u010c\u0001\u0000\u0000\u0000\u010c\u010d\u0001"+
		"\u0000\u0000\u0000\u010d\u010f\u00050\u0000\u0000\u010e\u0110\u0003*\u0015"+
		"\u0000\u010f\u010e\u0001\u0000\u0000\u0000\u010f\u0110\u0001\u0000\u0000"+
		"\u0000\u0110\u0112\u0001\u0000\u0000\u0000\u0111\u0113\u0003(\u0014\u0000"+
		"\u0112\u0111\u0001\u0000\u0000\u0000\u0112\u0113\u0001\u0000\u0000\u0000"+
		"\u0113\u0114\u0001\u0000\u0000\u0000\u0114\u0121\u00056\u0000\u0000\u0115"+
		"\u0117\u00032\u0019\u0000\u0116\u0115\u0001\u0000\u0000\u0000\u0116\u0117"+
		"\u0001\u0000\u0000\u0000\u0117\u0118\u0001\u0000\u0000\u0000\u0118\u011a"+
		"\u00051\u0000\u0000\u0119\u011b\u00032\u0019\u0000\u011a\u0119\u0001\u0000"+
		"\u0000\u0000\u011a\u011b\u0001\u0000\u0000\u0000\u011b\u011c\u0001\u0000"+
		"\u0000\u0000\u011c\u0121\u00054\u0000\u0000\u011d\u011e\u00032\u0019\u0000"+
		"\u011e\u011f\u00054\u0000\u0000\u011f\u0121\u0001\u0000\u0000\u0000\u0120"+
		"\u00fc\u0001\u0000\u0000\u0000\u0120\u010b\u0001\u0000\u0000\u0000\u0120"+
		"\u0116\u0001\u0000\u0000\u0000\u0120\u011d\u0001\u0000\u0000\u0000\u0121"+
		"\u0123\u0001\u0000\u0000\u0000\u0122\u0124\u0003\u0010\b\u0000\u0123\u0122"+
		"\u0001\u0000\u0000\u0000\u0123\u0124\u0001\u0000\u0000\u0000\u0124#\u0001"+
		"\u0000\u0000\u0000\u0125\u013d\u0005.\u0000\u0000\u0126\u0127\u00032\u0019"+
		"\u0000\u0127\u0129\u00050\u0000\u0000\u0128\u012a\u0003*\u0015\u0000\u0129"+
		"\u0128\u0001\u0000\u0000\u0000\u0129\u012a\u0001\u0000\u0000\u0000\u012a"+
		"\u012c\u0001\u0000\u0000\u0000\u012b\u012d\u0003(\u0014\u0000\u012c\u012b"+
		"\u0001\u0000\u0000\u0000\u012c\u012d\u0001\u0000\u0000\u0000\u012d\u012e"+
		"\u0001\u0000\u0000\u0000\u012e\u012f\u00056\u0000\u0000\u012f\u013e\u0001"+
		"\u0000\u0000\u0000\u0130\u0131\u00032\u0019\u0000\u0131\u0135\u00051\u0000"+
		"\u0000\u0132\u0134\u00032\u0019\u0000\u0133\u0132\u0001\u0000\u0000\u0000"+
		"\u0134\u0137\u0001\u0000\u0000\u0000\u0135\u0133\u0001\u0000\u0000\u0000"+
		"\u0135\u0136\u0001\u0000\u0000\u0000\u0136\u0138\u0001\u0000\u0000\u0000"+
		"\u0137\u0135\u0001\u0000\u0000\u0000\u0138\u0139\u00054\u0000\u0000\u0139"+
		"\u013e\u0001\u0000\u0000\u0000\u013a\u013b\u00032\u0019\u0000\u013b\u013c"+
		"\u00054\u0000\u0000\u013c\u013e\u0001\u0000\u0000\u0000\u013d\u0126\u0001"+
		"\u0000\u0000\u0000\u013d\u0130\u0001\u0000\u0000\u0000\u013d\u013a\u0001"+
		"\u0000\u0000\u0000\u013e\u0140\u0001\u0000\u0000\u0000\u013f\u0141\u0003"+
		"\u0010\b\u0000\u0140\u013f\u0001\u0000\u0000\u0000\u0140\u0141\u0001\u0000"+
		"\u0000\u0000\u0141%\u0001\u0000\u0000\u0000\u0142\u0166\u0005/\u0000\u0000"+
		"\u0143\u0144\u00034\u001a\u0000\u0144\u0145\u00052\u0000\u0000\u0145\u014c"+
		"\u00032\u0019\u0000\u0146\u0147\u00036\u001b\u0000\u0147\u0148\u0004\u0013"+
		"\u0000\u0000\u0148\u0149\u00032\u0019\u0000\u0149\u014b\u0001\u0000\u0000"+
		"\u0000\u014a\u0146\u0001\u0000\u0000\u0000\u014b\u014e\u0001\u0000\u0000"+
		"\u0000\u014c\u014a\u0001\u0000\u0000\u0000\u014c\u014d\u0001\u0000\u0000"+
		"\u0000\u014d\u0167\u0001\u0000\u0000\u0000\u014e\u014c\u0001\u0000\u0000"+
		"\u0000\u014f\u0150\u00032\u0019\u0000\u0150\u0152\u00050\u0000\u0000\u0151"+
		"\u0153\u0003*\u0015\u0000\u0152\u0151\u0001\u0000\u0000\u0000\u0152\u0153"+
		"\u0001\u0000\u0000\u0000\u0153\u0155\u0001\u0000\u0000\u0000\u0154\u0156"+
		"\u0003(\u0014\u0000\u0155\u0154\u0001\u0000\u0000\u0000\u0155\u0156\u0001"+
		"\u0000\u0000\u0000\u0156\u0157\u0001\u0000\u0000\u0000\u0157\u0158\u0005"+
		"6\u0000\u0000\u0158\u0167\u0001\u0000\u0000\u0000\u0159\u015a\u00032\u0019"+
		"\u0000\u015a\u015e\u00051\u0000\u0000\u015b\u015d\u00032\u0019\u0000\u015c"+
		"\u015b\u0001\u0000\u0000\u0000\u015d\u0160\u0001\u0000\u0000\u0000\u015e"+
		"\u015c\u0001\u0000\u0000\u0000\u015e\u015f\u0001\u0000\u0000\u0000\u015f"+
		"\u0161\u0001\u0000\u0000\u0000\u0160\u015e\u0001\u0000\u0000\u0000\u0161"+
		"\u0162\u00054\u0000\u0000\u0162\u0167\u0001\u0000\u0000\u0000\u0163\u0164"+
		"\u00032\u0019\u0000\u0164\u0165\u00054\u0000\u0000\u0165\u0167\u0001\u0000"+
		"\u0000\u0000\u0166\u0143\u0001\u0000\u0000\u0000\u0166\u014f\u0001\u0000"+
		"\u0000\u0000\u0166\u0159\u0001\u0000\u0000\u0000\u0166\u0163\u0001\u0000"+
		"\u0000\u0000\u0167\u0169\u0001\u0000\u0000\u0000\u0168\u016a\u0003\u0010"+
		"\b\u0000\u0169\u0168\u0001\u0000\u0000\u0000\u0169\u016a\u0001\u0000\u0000"+
		"\u0000\u016a\'\u0001\u0000\u0000\u0000\u016b\u0170\u0005:\u0000\u0000"+
		"\u016c\u016f\u00030\u0018\u0000\u016d\u016f\u0005;\u0000\u0000\u016e\u016c"+
		"\u0001\u0000\u0000\u0000\u016e\u016d\u0001\u0000\u0000\u0000\u016f\u0172"+
		"\u0001\u0000\u0000\u0000\u0170\u016e\u0001\u0000\u0000\u0000\u0170\u0171"+
		"\u0001\u0000\u0000\u0000\u0171\u0173\u0001\u0000\u0000\u0000\u0172\u0170"+
		"\u0001\u0000\u0000\u0000\u0173\u0188\u0005:\u0000\u0000\u0174\u0179\u0005"+
		";\u0000\u0000\u0175\u0178\u00030\u0018\u0000\u0176\u0178\u0005:\u0000"+
		"\u0000\u0177\u0175\u0001\u0000\u0000\u0000\u0177\u0176\u0001\u0000\u0000"+
		"\u0000\u0178\u017b\u0001\u0000\u0000\u0000\u0179\u0177\u0001\u0000\u0000"+
		"\u0000\u0179\u017a\u0001\u0000\u0000\u0000\u017a\u017c\u0001\u0000\u0000"+
		"\u0000\u017b\u0179\u0001\u0000\u0000\u0000\u017c\u0188\u0005;\u0000\u0000"+
		"\u017d\u017f\u0005\r\u0000\u0000\u017e\u0180\u0003.\u0017\u0000\u017f"+
		"\u017e\u0001\u0000\u0000\u0000\u017f\u0180\u0001\u0000\u0000\u0000\u0180"+
		"\u0181\u0001\u0000\u0000\u0000\u0181\u0188\u0005\u0012\u0000\u0000\u0182"+
		"\u0184\u0005\u000e\u0000\u0000\u0183\u0185\u0003.\u0017\u0000\u0184\u0183"+
		"\u0001\u0000\u0000\u0000\u0184\u0185\u0001\u0000\u0000\u0000\u0185\u0186"+
		"\u0001\u0000\u0000\u0000\u0186\u0188\u0005\u0013\u0000\u0000\u0187\u016b"+
		"\u0001\u0000\u0000\u0000\u0187\u0174\u0001\u0000\u0000\u0000\u0187\u017d"+
		"\u0001\u0000\u0000\u0000\u0187\u0182\u0001\u0000\u0000\u0000\u0188)\u0001"+
		"\u0000\u0000\u0000\u0189\u018a\u0007\u0002\u0000\u0000\u018a+\u0001\u0000"+
		"\u0000\u0000\u018b\u0191\u0003.\u0017\u0000\u018c\u018d\u00036\u001b\u0000"+
		"\u018d\u018e\u0003.\u0017\u0000\u018e\u0190\u0001\u0000\u0000\u0000\u018f"+
		"\u018c\u0001\u0000\u0000\u0000\u0190\u0193\u0001\u0000\u0000\u0000\u0191"+
		"\u018f\u0001\u0000\u0000\u0000\u0191\u0192\u0001\u0000\u0000\u0000\u0192"+
		"-\u0001\u0000\u0000\u0000\u0193\u0191\u0001\u0000\u0000\u0000\u0194\u0199"+
		"\u0003\"\u0011\u0000\u0195\u0199\u0003$\u0012\u0000\u0196\u0199\u0003"+
		"&\u0013\u0000\u0197\u0199\u00030\u0018\u0000\u0198\u0194\u0001\u0000\u0000"+
		"\u0000\u0198\u0195\u0001\u0000\u0000\u0000\u0198\u0196\u0001\u0000\u0000"+
		"\u0000\u0198\u0197\u0001\u0000\u0000\u0000\u0199\u019a\u0001\u0000\u0000"+
		"\u0000\u019a\u0198\u0001\u0000\u0000\u0000\u019a\u019b\u0001\u0000\u0000"+
		"\u0000\u019b/\u0001\u0000\u0000\u0000\u019c\u019e\u00038\u001c\u0000\u019d"+
		"\u019c\u0001\u0000\u0000\u0000\u019e\u01a1\u0001\u0000\u0000\u0000\u019f"+
		"\u019d\u0001\u0000\u0000\u0000\u019f\u01a0\u0001\u0000\u0000\u0000\u01a0"+
		"\u01a2\u0001\u0000\u0000\u0000\u01a1\u019f\u0001\u0000\u0000\u0000\u01a2"+
		"\u01a6\u0007\u0003\u0000\u0000\u01a3\u01a5\u0003:\u001d\u0000\u01a4\u01a3"+
		"\u0001\u0000\u0000\u0000\u01a5\u01a8\u0001\u0000\u0000\u0000\u01a6\u01a4"+
		"\u0001\u0000\u0000\u0000\u01a6\u01a7\u0001\u0000\u0000\u0000\u01a71\u0001"+
		"\u0000\u0000\u0000\u01a8\u01a6\u0001\u0000\u0000\u0000\u01a9\u01ae\u0003"+
		"\"\u0011\u0000\u01aa\u01ae\u0003$\u0012\u0000\u01ab\u01ae\u0003&\u0013"+
		"\u0000\u01ac\u01ae\u00034\u001a\u0000\u01ad\u01a9\u0001\u0000\u0000\u0000"+
		"\u01ad\u01aa\u0001\u0000\u0000\u0000\u01ad\u01ab\u0001\u0000\u0000\u0000"+
		"\u01ad\u01ac\u0001\u0000\u0000\u0000\u01ae\u01af\u0001\u0000\u0000\u0000"+
		"\u01af\u01ad\u0001\u0000\u0000\u0000\u01af\u01b0\u0001\u0000\u0000\u0000"+
		"\u01b03\u0001\u0000\u0000\u0000\u01b1\u01b3\u00038\u001c\u0000\u01b2\u01b1"+
		"\u0001\u0000\u0000\u0000\u01b3\u01b6\u0001\u0000\u0000\u0000\u01b4\u01b2"+
		"\u0001\u0000\u0000\u0000\u01b4\u01b5\u0001\u0000\u0000\u0000\u01b5\u01b7"+
		"\u0001\u0000\u0000\u0000\u01b6\u01b4\u0001\u0000\u0000\u0000\u01b7\u01bb"+
		"\u0007\u0004\u0000\u0000\u01b8\u01ba\u0003:\u001d\u0000\u01b9\u01b8\u0001"+
		"\u0000\u0000\u0000\u01ba\u01bd\u0001\u0000\u0000\u0000\u01bb\u01b9\u0001"+
		"\u0000\u0000\u0000\u01bb\u01bc\u0001\u0000\u0000\u0000\u01bc5\u0001\u0000"+
		"\u0000\u0000\u01bd\u01bb\u0001\u0000\u0000\u0000\u01be\u01bf\u0007\u0005"+
		"\u0000\u0000\u01bf7\u0001\u0000\u0000\u0000\u01c0\u01c1\u0007\u0006\u0000"+
		"\u0000\u01c19\u0001\u0000\u0000\u0000\u01c2\u01c3\u0007\u0007\u0000\u0000"+
		"\u01c3;\u0001\u0000\u0000\u0000\u01c4\u01c5\u0005\u0014\u0000\u0000\u01c5"+
		"=\u0001\u0000\u0000\u0000\u01c6\u01c7\u0005<\u0000\u0000\u01c7?\u0001"+
		"\u0000\u0000\u0000\u01c8\u01c9\u0005\u0007\u0000\u0000\u01c9A\u0001\u0000"+
		"\u0000\u0000\u01ca\u01cb\u0005\b\u0000\u0000\u01cbC\u0001\u0000\u0000"+
		"\u0000\u01cc\u01cd\u0005=\u0000\u0000\u01cdE\u0001\u0000\u0000\u0000A"+
		"Y[npwz\u0080\u0094\u0097\u0099\u009b\u00a2\u00a5\u00a9\u00ae\u00b2\u00b9"+
		"\u00be\u00c6\u00cc\u00cf\u00d4\u00d7\u00da\u00e2\u00e7\u00f2\u00fc\u0101"+
		"\u0105\u0108\u010b\u010f\u0112\u0116\u011a\u0120\u0123\u0129\u012c\u0135"+
		"\u013d\u0140\u014c\u0152\u0155\u015e\u0166\u0169\u016e\u0170\u0177\u0179"+
		"\u017f\u0184\u0187\u0191\u0198\u019a\u019f\u01a6\u01ad\u01af\u01b4\u01bb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}