// Generated from D:/DevFiles/Eclipse/Tools/Editors/net.certiv.fluent.dt/net.certiv.fluent.dt.core/src/main/java/net/certiv/fluent/dt/core/lang/md/MdParser.g4 by ANTLR 4.13.1

	package net.certiv.fluent.dt.core.lang.md.gen;
	import java.util.ArrayList;
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
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WORD=1, CODE_BEG=2, CODE_END=3, CODE_TYPE=4, CODE_LINE=5, CODE_DENT=6, 
		CODE_BLANK=7, QUOTE_BLANK=8, QUOTE_DENT=9, ESC_SQUOTE=10, ESC_DQUOTE=11, 
		LBOLD=12, LITALIC=13, LSTRIKE=14, LDQUOTE=15, LSQUOTE=16, RBOLD=17, RITALIC=18, 
		RSTRIKE=19, RDQUOTE=20, RSQUOTE=21, COMMENT=22, HTML_BLOCK_BEG=23, HTML_BLOCK_END=24, 
		YAML_BLOCK=25, DOT_BLOCK=26, MATH_BLOCK=27, TEX_BLOCK=28, UML_BLOCK=29, 
		MATHS=30, SPAN=31, LSTYLE=32, URL=33, URLTAG=34, HTML=35, TEX=36, UNICODE=37, 
		ENTITY=38, HASHES=39, SETEXT=40, HRULE=41, DEFINE=42, TABLE_DEF=43, PIPE=44, 
		BULLET_MARK=45, NUMBER_MARK=46, TASK_MARK=47, LNK_IMG=48, LNK_FN=49, LNK_SEP=50, 
		LNK_REF=51, LNK_DEF=52, LBRACK=53, RBRACK=54, LPAREN=55, RPAREN=56, BOLD=57, 
		ITALIC=58, STRIKE=59, DQUOTE=60, SQUOTE=61, LINE_BLANK=62, LINE_BREAK=63, 
		LINE_DENT=64, VWS=65, HWS=66, CHAR=67, RSTYLE=68, CLASS=69, ID=70, EQ=71, 
		DASH=72, CHAR_s=73, TYP_c=74, END_cb=75, CHR_cb=76, TYP_d=77, END_db=78, 
		CHR_db=79;
	public static final int
		RULE_page = 0, RULE_yamlBlock = 1, RULE_dotBlock = 2, RULE_mathBlock = 3, 
		RULE_texBlock = 4, RULE_umlBlock = 5, RULE_htmlBlock = 6, RULE_codeBlock = 7, 
		RULE_style = 8, RULE_header = 9, RULE_hrule = 10, RULE_table = 11, RULE_tableRow = 12, 
		RULE_list = 13, RULE_listItem = 14, RULE_definition = 15, RULE_definitionItem = 16, 
		RULE_link = 17, RULE_linkRef = 18, RULE_imgLink = 19, RULE_imgLinkRef = 20, 
		RULE_fnLink = 21, RULE_fnLinkRef = 22, RULE_autoLink = 23, RULE_refLinkDef = 24, 
		RULE_fnLinkDef = 25, RULE_paragraph = 26, RULE_line = 27, RULE_phrase = 28, 
		RULE_quote = 29, RULE_url = 30, RULE_lineBlank = 31, RULE_codeBlank = 32, 
		RULE_quoteBlank = 33, RULE_lineBreak = 34, RULE_nl = 35, RULE_attrLeft = 36, 
		RULE_attrRight = 37, RULE_comment = 38;
	private static String[] makeRuleNames() {
		return new String[] {
			"page", "yamlBlock", "dotBlock", "mathBlock", "texBlock", "umlBlock", 
			"htmlBlock", "codeBlock", "style", "header", "hrule", "table", "tableRow", 
			"list", "listItem", "definition", "definitionItem", "link", "linkRef", 
			"imgLink", "imgLinkRef", "fnLink", "fnLinkRef", "autoLink", "refLinkDef", 
			"fnLinkDef", "paragraph", "line", "phrase", "quote", "url", "lineBlank", 
			"codeBlank", "quoteBlank", "lineBreak", "nl", "attrLeft", "attrRight", 
			"comment"
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
			"CODE_BLANK", "QUOTE_BLANK", "QUOTE_DENT", "ESC_SQUOTE", "ESC_DQUOTE", 
			"LBOLD", "LITALIC", "LSTRIKE", "LDQUOTE", "LSQUOTE", "RBOLD", "RITALIC", 
			"RSTRIKE", "RDQUOTE", "RSQUOTE", "COMMENT", "HTML_BLOCK_BEG", "HTML_BLOCK_END", 
			"YAML_BLOCK", "DOT_BLOCK", "MATH_BLOCK", "TEX_BLOCK", "UML_BLOCK", "MATHS", 
			"SPAN", "LSTYLE", "URL", "URLTAG", "HTML", "TEX", "UNICODE", "ENTITY", 
			"HASHES", "SETEXT", "HRULE", "DEFINE", "TABLE_DEF", "PIPE", "BULLET_MARK", 
			"NUMBER_MARK", "TASK_MARK", "LNK_IMG", "LNK_FN", "LNK_SEP", "LNK_REF", 
			"LNK_DEF", "LBRACK", "RBRACK", "LPAREN", "RPAREN", "BOLD", "ITALIC", 
			"STRIKE", "DQUOTE", "SQUOTE", "LINE_BLANK", "LINE_BREAK", "LINE_DENT", 
			"VWS", "HWS", "CHAR", "RSTYLE", "CLASS", "ID", "EQ", "DASH", "CHAR_s", 
			"TYP_c", "END_cb", "CHR_cb", "TYP_d", "END_db", "CHR_db"
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
		public List<RefLinkDefContext> refLinkDef() {
			return getRuleContexts(RefLinkDefContext.class);
		}
		public RefLinkDefContext refLinkDef(int i) {
			return getRuleContext(RefLinkDefContext.class,i);
		}
		public List<FnLinkDefContext> fnLinkDef() {
			return getRuleContexts(FnLinkDefContext.class);
		}
		public FnLinkDefContext fnLinkDef(int i) {
			return getRuleContext(FnLinkDefContext.class,i);
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
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -1016833855241192058L) != 0) || _la==VWS) {
				{
				setState(99);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(78);
					yamlBlock();
					}
					break;
				case 2:
					{
					setState(79);
					dotBlock();
					}
					break;
				case 3:
					{
					setState(80);
					mathBlock();
					}
					break;
				case 4:
					{
					setState(81);
					htmlBlock();
					}
					break;
				case 5:
					{
					setState(82);
					texBlock();
					}
					break;
				case 6:
					{
					setState(83);
					umlBlock();
					}
					break;
				case 7:
					{
					setState(84);
					codeBlock();
					}
					break;
				case 8:
					{
					setState(85);
					comment();
					}
					break;
				case 9:
					{
					setState(86);
					header();
					}
					break;
				case 10:
					{
					setState(87);
					hrule();
					}
					break;
				case 11:
					{
					setState(88);
					table();
					}
					break;
				case 12:
					{
					setState(89);
					definition();
					}
					break;
				case 13:
					{
					setState(90);
					list();
					}
					break;
				case 14:
					{
					setState(91);
					paragraph();
					}
					break;
				case 15:
					{
					setState(92);
					refLinkDef();
					}
					break;
				case 16:
					{
					setState(93);
					fnLinkDef();
					}
					break;
				case 17:
					{
					setState(94);
					lineBlank();
					}
					break;
				case 18:
					{
					setState(95);
					codeBlank();
					}
					break;
				case 19:
					{
					setState(96);
					quoteBlank();
					}
					break;
				case 20:
					{
					setState(97);
					lineBreak();
					}
					break;
				case 21:
					{
					setState(98);
					match(VWS);
					}
					break;
				}
				}
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(104);
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
			setState(106);
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
			setState(108);
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
			setState(110);
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
			setState(112);
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
			setState(114);
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
			setState(116);
			match(HTML_BLOCK_BEG);
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -5628636972705514494L) != 0) || _la==VWS) {
				{
				setState(120);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case COMMENT:
					{
					setState(117);
					match(COMMENT);
					}
					break;
				case WORD:
				case ESC_SQUOTE:
				case ESC_DQUOTE:
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
				case DQUOTE:
				case SQUOTE:
					{
					setState(118);
					line();
					}
					break;
				case LINE_BREAK:
				case VWS:
					{
					setState(119);
					nl();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(125);
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
			setState(127);
			match(CODE_BEG);
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CODE_TYPE) {
				{
				setState(128);
				((CodeBlockContext)_localctx).lang = match(CODE_TYPE);
				}
			}

			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LSTYLE) {
				{
				setState(131);
				style();
				}
			}

			setState(134);
			match(VWS);
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CODE_LINE || _la==VWS) {
				{
				{
				setState(135);
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
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(141);
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
			setState(143);
			match(LSTYLE);
			setState(163); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(163);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DASH:
					{
					setState(144);
					match(DASH);
					}
					break;
				case CLASS:
					{
					setState(145);
					match(CLASS);
					setState(146);
					match(WORD);
					}
					break;
				case ID:
					{
					setState(147);
					match(ID);
					setState(148);
					match(WORD);
					}
					break;
				case WORD:
					{
					setState(149);
					match(WORD);
					setState(150);
					match(EQ);
					setState(161);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case SQUOTE:
						{
						setState(151);
						match(SQUOTE);
						setState(152);
						match(WORD);
						setState(153);
						match(SQUOTE);
						}
						break;
					case DQUOTE:
						{
						setState(154);
						match(DQUOTE);
						setState(155);
						match(WORD);
						setState(156);
						match(DQUOTE);
						}
						break;
					case WORD:
					case DASH:
						{
						setState(158);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==DASH) {
							{
							setState(157);
							match(DASH);
							}
						}

						setState(160);
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
				setState(165); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WORD || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 11L) != 0) );
			setState(167);
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
			setState(184);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HASHES:
				enterOuterAlt(_localctx, 1);
				{
				setState(169);
				((HeaderContext)_localctx).hdr = match(HASHES);
				setState(170);
				line();
				setState(172);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(171);
					match(HASHES);
					}
					break;
				}
				setState(175);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LSTYLE) {
					{
					setState(174);
					style();
					}
				}

				}
				break;
			case WORD:
			case ESC_SQUOTE:
			case ESC_DQUOTE:
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
			case DQUOTE:
			case SQUOTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(177);
				line();
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LSTYLE) {
					{
					setState(178);
					style();
					}
				}

				setState(181);
				nl();
				setState(182);
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
			setState(186);
			match(HRULE);
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LSTYLE) {
				{
				setState(187);
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
			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3594735064145067010L) != 0)) {
				{
				{
				setState(190);
				tableRow();
				setState(191);
				nl();
				}
				}
				setState(197);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(198);
			match(TABLE_DEF);
			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LSTYLE) {
				{
				setState(199);
				style();
				}
			}

			setState(202);
			nl();
			setState(208);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(203);
					tableRow();
					setState(204);
					nl();
					}
					} 
				}
				setState(210);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			setState(211);
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
			setState(214);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(213);
				match(PIPE);
				}
				break;
			}
			setState(220); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(217);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						setState(216);
						line();
						}
						break;
					}
					setState(219);
					match(PIPE);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(222); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(225);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(224);
				line();
				}
				break;
			}
			setState(228);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(227);
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
			setState(230);
			listItem();
			setState(236);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(231);
					nl();
					setState(232);
					listItem();
					}
					} 
				}
				setState(238);
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
			setState(239);
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
			setState(241);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TASK_MARK) {
				{
				setState(240);
				match(TASK_MARK);
				}
			}

			setState(243);
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
		public List<DefinitionItemContext> definitionItem() {
			return getRuleContexts(DefinitionItemContext.class);
		}
		public DefinitionItemContext definitionItem(int i) {
			return getRuleContext(DefinitionItemContext.class,i);
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
			setState(245);
			line();
			setState(246);
			match(VWS);
			setState(247);
			definitionItem();
			setState(252);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(248);
					match(VWS);
					setState(249);
					definitionItem();
					}
					} 
				}
				setState(254);
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
	public static class DefinitionItemContext extends ParserRuleContext {
		public TerminalNode DEFINE() { return getToken(MdParser.DEFINE, 0); }
		public ParagraphContext paragraph() {
			return getRuleContext(ParagraphContext.class,0);
		}
		public DefinitionItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definitionItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterDefinitionItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitDefinitionItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitDefinitionItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefinitionItemContext definitionItem() throws RecognitionException {
		DefinitionItemContext _localctx = new DefinitionItemContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_definitionItem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			match(DEFINE);
			setState(256);
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
		public PhraseContext txt;
		public TerminalNode LBRACK() { return getToken(MdParser.LBRACK, 0); }
		public TerminalNode LNK_SEP() { return getToken(MdParser.LNK_SEP, 0); }
		public TerminalNode RPAREN() { return getToken(MdParser.RPAREN, 0); }
		public UrlContext url() {
			return getRuleContext(UrlContext.class,0);
		}
		public QuoteContext quote() {
			return getRuleContext(QuoteContext.class,0);
		}
		public StyleContext style() {
			return getRuleContext(StyleContext.class,0);
		}
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
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
			setState(258);
			match(LBRACK);
			setState(260);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3576157715682163714L) != 0)) {
				{
				setState(259);
				((LinkContext)_localctx).txt = phrase();
				}
			}

			setState(262);
			match(LNK_SEP);
			setState(264);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==URL) {
				{
				setState(263);
				url();
				}
			}

			setState(267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LDQUOTE || _la==LSQUOTE) {
				{
				setState(266);
				quote();
				}
			}

			setState(269);
			match(RPAREN);
			setState(271);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(270);
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
	public static class LinkRefContext extends ParserRuleContext {
		public PhraseContext txt;
		public PhraseContext ref;
		public TerminalNode LBRACK() { return getToken(MdParser.LBRACK, 0); }
		public TerminalNode LNK_REF() { return getToken(MdParser.LNK_REF, 0); }
		public TerminalNode RBRACK() { return getToken(MdParser.RBRACK, 0); }
		public List<PhraseContext> phrase() {
			return getRuleContexts(PhraseContext.class);
		}
		public PhraseContext phrase(int i) {
			return getRuleContext(PhraseContext.class,i);
		}
		public StyleContext style() {
			return getRuleContext(StyleContext.class,0);
		}
		public LinkRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_linkRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterLinkRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitLinkRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitLinkRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LinkRefContext linkRef() throws RecognitionException {
		LinkRefContext _localctx = new LinkRefContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_linkRef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			match(LBRACK);
			setState(288);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(275);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3576157715682163714L) != 0)) {
					{
					setState(274);
					((LinkRefContext)_localctx).txt = phrase();
					}
				}

				setState(277);
				match(LNK_REF);
				setState(278);
				((LinkRefContext)_localctx).ref = phrase();
				setState(279);
				match(RBRACK);
				}
				break;
			case 2:
				{
				setState(281);
				((LinkRefContext)_localctx).ref = phrase();
				setState(282);
				match(LNK_REF);
				setState(283);
				match(RBRACK);
				}
				break;
			case 3:
				{
				setState(285);
				((LinkRefContext)_localctx).ref = phrase();
				setState(286);
				match(RBRACK);
				}
				break;
			}
			setState(291);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
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
		public PhraseContext txt;
		public TerminalNode LNK_IMG() { return getToken(MdParser.LNK_IMG, 0); }
		public TerminalNode LNK_SEP() { return getToken(MdParser.LNK_SEP, 0); }
		public TerminalNode RPAREN() { return getToken(MdParser.RPAREN, 0); }
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
		}
		public UrlContext url() {
			return getRuleContext(UrlContext.class,0);
		}
		public QuoteContext quote() {
			return getRuleContext(QuoteContext.class,0);
		}
		public StyleContext style() {
			return getRuleContext(StyleContext.class,0);
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
		enterRule(_localctx, 38, RULE_imgLink);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			match(LNK_IMG);
			setState(294);
			((ImgLinkContext)_localctx).txt = phrase();
			setState(295);
			match(LNK_SEP);
			setState(297);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==URL) {
				{
				setState(296);
				url();
				}
			}

			setState(300);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LDQUOTE || _la==LSQUOTE) {
				{
				setState(299);
				quote();
				}
			}

			setState(302);
			match(RPAREN);
			setState(304);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(303);
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
	public static class ImgLinkRefContext extends ParserRuleContext {
		public PhraseContext txt;
		public PhraseContext ref;
		public TerminalNode LNK_IMG() { return getToken(MdParser.LNK_IMG, 0); }
		public TerminalNode LNK_REF() { return getToken(MdParser.LNK_REF, 0); }
		public TerminalNode RBRACK() { return getToken(MdParser.RBRACK, 0); }
		public List<PhraseContext> phrase() {
			return getRuleContexts(PhraseContext.class);
		}
		public PhraseContext phrase(int i) {
			return getRuleContext(PhraseContext.class,i);
		}
		public StyleContext style() {
			return getRuleContext(StyleContext.class,0);
		}
		public ImgLinkRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_imgLinkRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterImgLinkRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitImgLinkRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitImgLinkRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImgLinkRefContext imgLinkRef() throws RecognitionException {
		ImgLinkRefContext _localctx = new ImgLinkRefContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_imgLinkRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			match(LNK_IMG);
			setState(319);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				setState(307);
				((ImgLinkRefContext)_localctx).txt = phrase();
				setState(308);
				match(LNK_REF);
				setState(309);
				((ImgLinkRefContext)_localctx).ref = phrase();
				setState(310);
				match(RBRACK);
				}
				break;
			case 2:
				{
				setState(312);
				((ImgLinkRefContext)_localctx).ref = phrase();
				setState(313);
				match(LNK_REF);
				setState(314);
				match(RBRACK);
				}
				break;
			case 3:
				{
				setState(316);
				((ImgLinkRefContext)_localctx).ref = phrase();
				setState(317);
				match(RBRACK);
				}
				break;
			}
			setState(322);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				setState(321);
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
		public PhraseContext ref;
		public TerminalNode LNK_FN() { return getToken(MdParser.LNK_FN, 0); }
		public TerminalNode LNK_SEP() { return getToken(MdParser.LNK_SEP, 0); }
		public TerminalNode RPAREN() { return getToken(MdParser.RPAREN, 0); }
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
		}
		public UrlContext url() {
			return getRuleContext(UrlContext.class,0);
		}
		public QuoteContext quote() {
			return getRuleContext(QuoteContext.class,0);
		}
		public StyleContext style() {
			return getRuleContext(StyleContext.class,0);
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
		enterRule(_localctx, 42, RULE_fnLink);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324);
			match(LNK_FN);
			setState(325);
			((FnLinkContext)_localctx).ref = phrase();
			setState(326);
			match(LNK_SEP);
			setState(328);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==URL) {
				{
				setState(327);
				url();
				}
			}

			setState(331);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LDQUOTE || _la==LSQUOTE) {
				{
				setState(330);
				quote();
				}
			}

			setState(333);
			match(RPAREN);
			setState(335);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				{
				setState(334);
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
	public static class FnLinkRefContext extends ParserRuleContext {
		public PhraseContext ref;
		public TerminalNode LNK_FN() { return getToken(MdParser.LNK_FN, 0); }
		public TerminalNode RBRACK() { return getToken(MdParser.RBRACK, 0); }
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
		}
		public StyleContext style() {
			return getRuleContext(StyleContext.class,0);
		}
		public FnLinkRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fnLinkRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterFnLinkRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitFnLinkRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitFnLinkRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FnLinkRefContext fnLinkRef() throws RecognitionException {
		FnLinkRefContext _localctx = new FnLinkRefContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_fnLinkRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337);
			match(LNK_FN);
			setState(338);
			((FnLinkRefContext)_localctx).ref = phrase();
			setState(339);
			match(RBRACK);
			setState(341);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				{
				setState(340);
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
	public static class AutoLinkContext extends ParserRuleContext {
		public TerminalNode URLTAG() { return getToken(MdParser.URLTAG, 0); }
		public TerminalNode LBRACK() { return getToken(MdParser.LBRACK, 0); }
		public TerminalNode URL() { return getToken(MdParser.URL, 0); }
		public TerminalNode RBRACK() { return getToken(MdParser.RBRACK, 0); }
		public AutoLinkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_autoLink; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterAutoLink(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitAutoLink(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitAutoLink(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AutoLinkContext autoLink() throws RecognitionException {
		AutoLinkContext _localctx = new AutoLinkContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_autoLink);
		try {
			setState(348);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case URLTAG:
				enterOuterAlt(_localctx, 1);
				{
				setState(343);
				match(URLTAG);
				}
				break;
			case LBRACK:
				enterOuterAlt(_localctx, 2);
				{
				setState(344);
				match(LBRACK);
				setState(345);
				match(URL);
				setState(346);
				match(RBRACK);
				}
				break;
			case URL:
				enterOuterAlt(_localctx, 3);
				{
				setState(347);
				match(URL);
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
	public static class RefLinkDefContext extends ParserRuleContext {
		public PhraseContext ref;
		public TerminalNode LBRACK() { return getToken(MdParser.LBRACK, 0); }
		public TerminalNode LNK_DEF() { return getToken(MdParser.LNK_DEF, 0); }
		public UrlContext url() {
			return getRuleContext(UrlContext.class,0);
		}
		public List<NlContext> nl() {
			return getRuleContexts(NlContext.class);
		}
		public NlContext nl(int i) {
			return getRuleContext(NlContext.class,i);
		}
		public QuoteContext quote() {
			return getRuleContext(QuoteContext.class,0);
		}
		public StyleContext style() {
			return getRuleContext(StyleContext.class,0);
		}
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
		}
		public RefLinkDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_refLinkDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterRefLinkDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitRefLinkDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitRefLinkDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RefLinkDefContext refLinkDef() throws RecognitionException {
		RefLinkDefContext _localctx = new RefLinkDefContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_refLinkDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(350);
			match(LBRACK);
			setState(352);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3576157715682163714L) != 0)) {
				{
				setState(351);
				((RefLinkDefContext)_localctx).ref = phrase();
				}
			}

			setState(354);
			match(LNK_DEF);
			setState(356);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LINE_BREAK || _la==VWS) {
				{
				setState(355);
				nl();
				}
			}

			setState(358);
			url();
			setState(363);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				{
				setState(360);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LINE_BREAK || _la==VWS) {
					{
					setState(359);
					nl();
					}
				}

				setState(362);
				quote();
				}
				break;
			}
			setState(366);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LSTYLE) {
				{
				setState(365);
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
	public static class FnLinkDefContext extends ParserRuleContext {
		public PhraseContext ref;
		public LineContext line;
		public List<LineContext> def = new ArrayList<LineContext>();
		public TerminalNode LNK_FN() { return getToken(MdParser.LNK_FN, 0); }
		public TerminalNode LNK_DEF() { return getToken(MdParser.LNK_DEF, 0); }
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
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
		public FnLinkDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fnLinkDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterFnLinkDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitFnLinkDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitFnLinkDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FnLinkDefContext fnLinkDef() throws RecognitionException {
		FnLinkDefContext _localctx = new FnLinkDefContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_fnLinkDef);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(368);
			match(LNK_FN);
			setState(369);
			((FnLinkDefContext)_localctx).ref = phrase();
			setState(370);
			match(LNK_DEF);
			setState(371);
			((FnLinkDefContext)_localctx).line = line();
			((FnLinkDefContext)_localctx).def.add(((FnLinkDefContext)_localctx).line);
			setState(378);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(372);
					nl();
					setState(373);
					if (!( twoSpaces() )) throw new FailedPredicateException(this, " twoSpaces() ");
					setState(374);
					((FnLinkDefContext)_localctx).line = line();
					((FnLinkDefContext)_localctx).def.add(((FnLinkDefContext)_localctx).line);
					}
					} 
				}
				setState(380);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
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
		enterRule(_localctx, 52, RULE_paragraph);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(381);
			line();
			setState(387);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(382);
					nl();
					setState(383);
					line();
					}
					} 
				}
				setState(389);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
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
		public List<QuoteContext> quote() {
			return getRuleContexts(QuoteContext.class);
		}
		public QuoteContext quote(int i) {
			return getRuleContext(QuoteContext.class,i);
		}
		public List<TerminalNode> WORD() { return getTokens(MdParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(MdParser.WORD, i);
		}
		public List<TerminalNode> PIPE() { return getTokens(MdParser.PIPE); }
		public TerminalNode PIPE(int i) {
			return getToken(MdParser.PIPE, i);
		}
		public List<TerminalNode> LPAREN() { return getTokens(MdParser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(MdParser.LPAREN, i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(MdParser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(MdParser.RPAREN, i);
		}
		public List<TerminalNode> ENTITY() { return getTokens(MdParser.ENTITY); }
		public TerminalNode ENTITY(int i) {
			return getToken(MdParser.ENTITY, i);
		}
		public List<TerminalNode> SQUOTE() { return getTokens(MdParser.SQUOTE); }
		public TerminalNode SQUOTE(int i) {
			return getToken(MdParser.SQUOTE, i);
		}
		public List<TerminalNode> DQUOTE() { return getTokens(MdParser.DQUOTE); }
		public TerminalNode DQUOTE(int i) {
			return getToken(MdParser.DQUOTE, i);
		}
		public List<TerminalNode> ESC_SQUOTE() { return getTokens(MdParser.ESC_SQUOTE); }
		public TerminalNode ESC_SQUOTE(int i) {
			return getToken(MdParser.ESC_SQUOTE, i);
		}
		public List<TerminalNode> ESC_DQUOTE() { return getTokens(MdParser.ESC_DQUOTE); }
		public TerminalNode ESC_DQUOTE(int i) {
			return getToken(MdParser.ESC_DQUOTE, i);
		}
		public List<TerminalNode> HTML() { return getTokens(MdParser.HTML); }
		public TerminalNode HTML(int i) {
			return getToken(MdParser.HTML, i);
		}
		public List<TerminalNode> SPAN() { return getTokens(MdParser.SPAN); }
		public TerminalNode SPAN(int i) {
			return getToken(MdParser.SPAN, i);
		}
		public List<TerminalNode> MATHS() { return getTokens(MdParser.MATHS); }
		public TerminalNode MATHS(int i) {
			return getToken(MdParser.MATHS, i);
		}
		public List<TerminalNode> TEX() { return getTokens(MdParser.TEX); }
		public TerminalNode TEX(int i) {
			return getToken(MdParser.TEX, i);
		}
		public List<TerminalNode> UNICODE() { return getTokens(MdParser.UNICODE); }
		public TerminalNode UNICODE(int i) {
			return getToken(MdParser.UNICODE, i);
		}
		public List<LinkContext> link() {
			return getRuleContexts(LinkContext.class);
		}
		public LinkContext link(int i) {
			return getRuleContext(LinkContext.class,i);
		}
		public List<LinkRefContext> linkRef() {
			return getRuleContexts(LinkRefContext.class);
		}
		public LinkRefContext linkRef(int i) {
			return getRuleContext(LinkRefContext.class,i);
		}
		public List<ImgLinkContext> imgLink() {
			return getRuleContexts(ImgLinkContext.class);
		}
		public ImgLinkContext imgLink(int i) {
			return getRuleContext(ImgLinkContext.class,i);
		}
		public List<ImgLinkRefContext> imgLinkRef() {
			return getRuleContexts(ImgLinkRefContext.class);
		}
		public ImgLinkRefContext imgLinkRef(int i) {
			return getRuleContext(ImgLinkRefContext.class,i);
		}
		public List<FnLinkContext> fnLink() {
			return getRuleContexts(FnLinkContext.class);
		}
		public FnLinkContext fnLink(int i) {
			return getRuleContext(FnLinkContext.class,i);
		}
		public List<FnLinkRefContext> fnLinkRef() {
			return getRuleContexts(FnLinkRefContext.class);
		}
		public FnLinkRefContext fnLinkRef(int i) {
			return getRuleContext(FnLinkRefContext.class,i);
		}
		public List<AutoLinkContext> autoLink() {
			return getRuleContexts(AutoLinkContext.class);
		}
		public AutoLinkContext autoLink(int i) {
			return getRuleContext(AutoLinkContext.class,i);
		}
		public List<TerminalNode> LBRACK() { return getTokens(MdParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(MdParser.LBRACK, i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(MdParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(MdParser.RBRACK, i);
		}
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
		enterRule(_localctx, 54, RULE_line);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(428); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(393);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 28672L) != 0)) {
						{
						{
						setState(390);
						attrLeft();
						}
						}
						setState(395);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(420);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
					case 1:
						{
						setState(396);
						quote();
						}
						break;
					case 2:
						{
						setState(397);
						match(WORD);
						}
						break;
					case 3:
						{
						setState(398);
						match(PIPE);
						}
						break;
					case 4:
						{
						setState(399);
						match(LPAREN);
						}
						break;
					case 5:
						{
						setState(400);
						match(RPAREN);
						}
						break;
					case 6:
						{
						setState(401);
						match(ENTITY);
						}
						break;
					case 7:
						{
						setState(402);
						match(SQUOTE);
						}
						break;
					case 8:
						{
						setState(403);
						match(DQUOTE);
						}
						break;
					case 9:
						{
						setState(404);
						match(ESC_SQUOTE);
						}
						break;
					case 10:
						{
						setState(405);
						match(ESC_DQUOTE);
						}
						break;
					case 11:
						{
						setState(406);
						match(HTML);
						}
						break;
					case 12:
						{
						setState(407);
						match(SPAN);
						}
						break;
					case 13:
						{
						setState(408);
						match(MATHS);
						}
						break;
					case 14:
						{
						setState(409);
						match(TEX);
						}
						break;
					case 15:
						{
						setState(410);
						match(UNICODE);
						}
						break;
					case 16:
						{
						setState(411);
						link();
						}
						break;
					case 17:
						{
						setState(412);
						linkRef();
						}
						break;
					case 18:
						{
						setState(413);
						imgLink();
						}
						break;
					case 19:
						{
						setState(414);
						imgLinkRef();
						}
						break;
					case 20:
						{
						setState(415);
						fnLink();
						}
						break;
					case 21:
						{
						setState(416);
						fnLinkRef();
						}
						break;
					case 22:
						{
						setState(417);
						autoLink();
						}
						break;
					case 23:
						{
						setState(418);
						match(LBRACK);
						}
						break;
					case 24:
						{
						setState(419);
						match(RBRACK);
						}
						break;
					}
					setState(425);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 917504L) != 0)) {
						{
						{
						setState(422);
						attrRight();
						}
						}
						setState(427);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(430); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
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
	public static class PhraseContext extends ParserRuleContext {
		public List<QuoteContext> quote() {
			return getRuleContexts(QuoteContext.class);
		}
		public QuoteContext quote(int i) {
			return getRuleContext(QuoteContext.class,i);
		}
		public List<TerminalNode> WORD() { return getTokens(MdParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(MdParser.WORD, i);
		}
		public List<TerminalNode> PIPE() { return getTokens(MdParser.PIPE); }
		public TerminalNode PIPE(int i) {
			return getToken(MdParser.PIPE, i);
		}
		public List<TerminalNode> LPAREN() { return getTokens(MdParser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(MdParser.LPAREN, i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(MdParser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(MdParser.RPAREN, i);
		}
		public List<TerminalNode> ENTITY() { return getTokens(MdParser.ENTITY); }
		public TerminalNode ENTITY(int i) {
			return getToken(MdParser.ENTITY, i);
		}
		public List<TerminalNode> SQUOTE() { return getTokens(MdParser.SQUOTE); }
		public TerminalNode SQUOTE(int i) {
			return getToken(MdParser.SQUOTE, i);
		}
		public List<TerminalNode> DQUOTE() { return getTokens(MdParser.DQUOTE); }
		public TerminalNode DQUOTE(int i) {
			return getToken(MdParser.DQUOTE, i);
		}
		public List<TerminalNode> ESC_SQUOTE() { return getTokens(MdParser.ESC_SQUOTE); }
		public TerminalNode ESC_SQUOTE(int i) {
			return getToken(MdParser.ESC_SQUOTE, i);
		}
		public List<TerminalNode> ESC_DQUOTE() { return getTokens(MdParser.ESC_DQUOTE); }
		public TerminalNode ESC_DQUOTE(int i) {
			return getToken(MdParser.ESC_DQUOTE, i);
		}
		public List<TerminalNode> HTML() { return getTokens(MdParser.HTML); }
		public TerminalNode HTML(int i) {
			return getToken(MdParser.HTML, i);
		}
		public List<TerminalNode> SPAN() { return getTokens(MdParser.SPAN); }
		public TerminalNode SPAN(int i) {
			return getToken(MdParser.SPAN, i);
		}
		public List<TerminalNode> MATHS() { return getTokens(MdParser.MATHS); }
		public TerminalNode MATHS(int i) {
			return getToken(MdParser.MATHS, i);
		}
		public List<TerminalNode> TEX() { return getTokens(MdParser.TEX); }
		public TerminalNode TEX(int i) {
			return getToken(MdParser.TEX, i);
		}
		public List<TerminalNode> UNICODE() { return getTokens(MdParser.UNICODE); }
		public TerminalNode UNICODE(int i) {
			return getToken(MdParser.UNICODE, i);
		}
		public List<LinkContext> link() {
			return getRuleContexts(LinkContext.class);
		}
		public LinkContext link(int i) {
			return getRuleContext(LinkContext.class,i);
		}
		public List<LinkRefContext> linkRef() {
			return getRuleContexts(LinkRefContext.class);
		}
		public LinkRefContext linkRef(int i) {
			return getRuleContext(LinkRefContext.class,i);
		}
		public List<ImgLinkContext> imgLink() {
			return getRuleContexts(ImgLinkContext.class);
		}
		public ImgLinkContext imgLink(int i) {
			return getRuleContext(ImgLinkContext.class,i);
		}
		public List<ImgLinkRefContext> imgLinkRef() {
			return getRuleContexts(ImgLinkRefContext.class);
		}
		public ImgLinkRefContext imgLinkRef(int i) {
			return getRuleContext(ImgLinkRefContext.class,i);
		}
		public List<AutoLinkContext> autoLink() {
			return getRuleContexts(AutoLinkContext.class);
		}
		public AutoLinkContext autoLink(int i) {
			return getRuleContext(AutoLinkContext.class,i);
		}
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
		public PhraseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_phrase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterPhrase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitPhrase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitPhrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PhraseContext phrase() throws RecognitionException {
		PhraseContext _localctx = new PhraseContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_phrase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(466); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(435);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 28672L) != 0)) {
					{
					{
					setState(432);
					attrLeft();
					}
					}
					setState(437);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(458);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
				case 1:
					{
					setState(438);
					quote();
					}
					break;
				case 2:
					{
					setState(439);
					match(WORD);
					}
					break;
				case 3:
					{
					setState(440);
					match(PIPE);
					}
					break;
				case 4:
					{
					setState(441);
					match(LPAREN);
					}
					break;
				case 5:
					{
					setState(442);
					match(RPAREN);
					}
					break;
				case 6:
					{
					setState(443);
					match(ENTITY);
					}
					break;
				case 7:
					{
					setState(444);
					match(SQUOTE);
					}
					break;
				case 8:
					{
					setState(445);
					match(DQUOTE);
					}
					break;
				case 9:
					{
					setState(446);
					match(ESC_SQUOTE);
					}
					break;
				case 10:
					{
					setState(447);
					match(ESC_DQUOTE);
					}
					break;
				case 11:
					{
					setState(448);
					match(HTML);
					}
					break;
				case 12:
					{
					setState(449);
					match(SPAN);
					}
					break;
				case 13:
					{
					setState(450);
					match(MATHS);
					}
					break;
				case 14:
					{
					setState(451);
					match(TEX);
					}
					break;
				case 15:
					{
					setState(452);
					match(UNICODE);
					}
					break;
				case 16:
					{
					setState(453);
					link();
					}
					break;
				case 17:
					{
					setState(454);
					linkRef();
					}
					break;
				case 18:
					{
					setState(455);
					imgLink();
					}
					break;
				case 19:
					{
					setState(456);
					imgLinkRef();
					}
					break;
				case 20:
					{
					setState(457);
					autoLink();
					}
					break;
				}
				setState(463);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 917504L) != 0)) {
					{
					{
					setState(460);
					attrRight();
					}
					}
					setState(465);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(468); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 3576157715682163714L) != 0) );
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
	public static class QuoteContext extends ParserRuleContext {
		public List<TerminalNode> LDQUOTE() { return getTokens(MdParser.LDQUOTE); }
		public TerminalNode LDQUOTE(int i) {
			return getToken(MdParser.LDQUOTE, i);
		}
		public List<TerminalNode> RDQUOTE() { return getTokens(MdParser.RDQUOTE); }
		public TerminalNode RDQUOTE(int i) {
			return getToken(MdParser.RDQUOTE, i);
		}
		public List<TerminalNode> WORD() { return getTokens(MdParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(MdParser.WORD, i);
		}
		public List<TerminalNode> PIPE() { return getTokens(MdParser.PIPE); }
		public TerminalNode PIPE(int i) {
			return getToken(MdParser.PIPE, i);
		}
		public List<TerminalNode> LPAREN() { return getTokens(MdParser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(MdParser.LPAREN, i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(MdParser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(MdParser.RPAREN, i);
		}
		public List<TerminalNode> ENTITY() { return getTokens(MdParser.ENTITY); }
		public TerminalNode ENTITY(int i) {
			return getToken(MdParser.ENTITY, i);
		}
		public List<TerminalNode> HTML() { return getTokens(MdParser.HTML); }
		public TerminalNode HTML(int i) {
			return getToken(MdParser.HTML, i);
		}
		public List<TerminalNode> SPAN() { return getTokens(MdParser.SPAN); }
		public TerminalNode SPAN(int i) {
			return getToken(MdParser.SPAN, i);
		}
		public List<TerminalNode> MATHS() { return getTokens(MdParser.MATHS); }
		public TerminalNode MATHS(int i) {
			return getToken(MdParser.MATHS, i);
		}
		public List<TerminalNode> TEX() { return getTokens(MdParser.TEX); }
		public TerminalNode TEX(int i) {
			return getToken(MdParser.TEX, i);
		}
		public List<TerminalNode> UNICODE() { return getTokens(MdParser.UNICODE); }
		public TerminalNode UNICODE(int i) {
			return getToken(MdParser.UNICODE, i);
		}
		public List<LinkContext> link() {
			return getRuleContexts(LinkContext.class);
		}
		public LinkContext link(int i) {
			return getRuleContext(LinkContext.class,i);
		}
		public List<LinkRefContext> linkRef() {
			return getRuleContexts(LinkRefContext.class);
		}
		public LinkRefContext linkRef(int i) {
			return getRuleContext(LinkRefContext.class,i);
		}
		public List<ImgLinkContext> imgLink() {
			return getRuleContexts(ImgLinkContext.class);
		}
		public ImgLinkContext imgLink(int i) {
			return getRuleContext(ImgLinkContext.class,i);
		}
		public List<ImgLinkRefContext> imgLinkRef() {
			return getRuleContexts(ImgLinkRefContext.class);
		}
		public ImgLinkRefContext imgLinkRef(int i) {
			return getRuleContext(ImgLinkRefContext.class,i);
		}
		public List<FnLinkContext> fnLink() {
			return getRuleContexts(FnLinkContext.class);
		}
		public FnLinkContext fnLink(int i) {
			return getRuleContext(FnLinkContext.class,i);
		}
		public List<FnLinkRefContext> fnLinkRef() {
			return getRuleContexts(FnLinkRefContext.class);
		}
		public FnLinkRefContext fnLinkRef(int i) {
			return getRuleContext(FnLinkRefContext.class,i);
		}
		public List<AutoLinkContext> autoLink() {
			return getRuleContexts(AutoLinkContext.class);
		}
		public AutoLinkContext autoLink(int i) {
			return getRuleContext(AutoLinkContext.class,i);
		}
		public List<TerminalNode> LBRACK() { return getTokens(MdParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(MdParser.LBRACK, i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(MdParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(MdParser.RBRACK, i);
		}
		public List<TerminalNode> SQUOTE() { return getTokens(MdParser.SQUOTE); }
		public TerminalNode SQUOTE(int i) {
			return getToken(MdParser.SQUOTE, i);
		}
		public List<TerminalNode> ESC_DQUOTE() { return getTokens(MdParser.ESC_DQUOTE); }
		public TerminalNode ESC_DQUOTE(int i) {
			return getToken(MdParser.ESC_DQUOTE, i);
		}
		public List<AttrLeftContext> attrLeft() {
			return getRuleContexts(AttrLeftContext.class);
		}
		public AttrLeftContext attrLeft(int i) {
			return getRuleContext(AttrLeftContext.class,i);
		}
		public List<TerminalNode> LSQUOTE() { return getTokens(MdParser.LSQUOTE); }
		public TerminalNode LSQUOTE(int i) {
			return getToken(MdParser.LSQUOTE, i);
		}
		public List<AttrRightContext> attrRight() {
			return getRuleContexts(AttrRightContext.class);
		}
		public AttrRightContext attrRight(int i) {
			return getRuleContext(AttrRightContext.class,i);
		}
		public List<TerminalNode> RSQUOTE() { return getTokens(MdParser.RSQUOTE); }
		public TerminalNode RSQUOTE(int i) {
			return getToken(MdParser.RSQUOTE, i);
		}
		public List<TerminalNode> DQUOTE() { return getTokens(MdParser.DQUOTE); }
		public TerminalNode DQUOTE(int i) {
			return getToken(MdParser.DQUOTE, i);
		}
		public List<TerminalNode> ESC_SQUOTE() { return getTokens(MdParser.ESC_SQUOTE); }
		public TerminalNode ESC_SQUOTE(int i) {
			return getToken(MdParser.ESC_SQUOTE, i);
		}
		public QuoteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quote; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterQuote(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitQuote(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitQuote(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuoteContext quote() throws RecognitionException {
		QuoteContext _localctx = new QuoteContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_quote);
		int _la;
		try {
			setState(558);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LDQUOTE:
				enterOuterAlt(_localctx, 1);
				{
				setState(470);
				match(LDQUOTE);
				setState(510);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2441813559538186242L) != 0)) {
					{
					{
					setState(475);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 94208L) != 0)) {
						{
						setState(473);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case LBOLD:
						case LITALIC:
						case LSTRIKE:
							{
							setState(471);
							attrLeft();
							}
							break;
						case LSQUOTE:
							{
							setState(472);
							match(LSQUOTE);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						setState(477);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(499);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
					case 1:
						{
						setState(478);
						match(WORD);
						}
						break;
					case 2:
						{
						setState(479);
						match(PIPE);
						}
						break;
					case 3:
						{
						setState(480);
						match(LPAREN);
						}
						break;
					case 4:
						{
						setState(481);
						match(RPAREN);
						}
						break;
					case 5:
						{
						setState(482);
						match(ENTITY);
						}
						break;
					case 6:
						{
						setState(483);
						match(HTML);
						}
						break;
					case 7:
						{
						setState(484);
						match(SPAN);
						}
						break;
					case 8:
						{
						setState(485);
						match(MATHS);
						}
						break;
					case 9:
						{
						setState(486);
						match(TEX);
						}
						break;
					case 10:
						{
						setState(487);
						match(UNICODE);
						}
						break;
					case 11:
						{
						setState(488);
						link();
						}
						break;
					case 12:
						{
						setState(489);
						linkRef();
						}
						break;
					case 13:
						{
						setState(490);
						imgLink();
						}
						break;
					case 14:
						{
						setState(491);
						imgLinkRef();
						}
						break;
					case 15:
						{
						setState(492);
						fnLink();
						}
						break;
					case 16:
						{
						setState(493);
						fnLinkRef();
						}
						break;
					case 17:
						{
						setState(494);
						autoLink();
						}
						break;
					case 18:
						{
						setState(495);
						match(LBRACK);
						}
						break;
					case 19:
						{
						setState(496);
						match(RBRACK);
						}
						break;
					case 20:
						{
						setState(497);
						match(SQUOTE);
						}
						break;
					case 21:
						{
						setState(498);
						match(ESC_DQUOTE);
						}
						break;
					}
					setState(505);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3014656L) != 0)) {
						{
						setState(503);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case RBOLD:
						case RITALIC:
						case RSTRIKE:
							{
							setState(501);
							attrRight();
							}
							break;
						case RSQUOTE:
							{
							setState(502);
							match(RSQUOTE);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						setState(507);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					setState(512);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(513);
				match(RDQUOTE);
				}
				break;
			case LSQUOTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(514);
				match(LSQUOTE);
				setState(554);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1288892054931305474L) != 0)) {
					{
					{
					setState(519);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 61440L) != 0)) {
						{
						setState(517);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case LBOLD:
						case LITALIC:
						case LSTRIKE:
							{
							setState(515);
							attrLeft();
							}
							break;
						case LDQUOTE:
							{
							setState(516);
							match(LDQUOTE);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						setState(521);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(543);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
					case 1:
						{
						setState(522);
						match(WORD);
						}
						break;
					case 2:
						{
						setState(523);
						match(PIPE);
						}
						break;
					case 3:
						{
						setState(524);
						match(LPAREN);
						}
						break;
					case 4:
						{
						setState(525);
						match(RPAREN);
						}
						break;
					case 5:
						{
						setState(526);
						match(ENTITY);
						}
						break;
					case 6:
						{
						setState(527);
						match(HTML);
						}
						break;
					case 7:
						{
						setState(528);
						match(SPAN);
						}
						break;
					case 8:
						{
						setState(529);
						match(MATHS);
						}
						break;
					case 9:
						{
						setState(530);
						match(TEX);
						}
						break;
					case 10:
						{
						setState(531);
						match(UNICODE);
						}
						break;
					case 11:
						{
						setState(532);
						link();
						}
						break;
					case 12:
						{
						setState(533);
						linkRef();
						}
						break;
					case 13:
						{
						setState(534);
						imgLink();
						}
						break;
					case 14:
						{
						setState(535);
						imgLinkRef();
						}
						break;
					case 15:
						{
						setState(536);
						fnLink();
						}
						break;
					case 16:
						{
						setState(537);
						fnLinkRef();
						}
						break;
					case 17:
						{
						setState(538);
						autoLink();
						}
						break;
					case 18:
						{
						setState(539);
						match(LBRACK);
						}
						break;
					case 19:
						{
						setState(540);
						match(RBRACK);
						}
						break;
					case 20:
						{
						setState(541);
						match(DQUOTE);
						}
						break;
					case 21:
						{
						setState(542);
						match(ESC_SQUOTE);
						}
						break;
					}
					setState(549);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1966080L) != 0)) {
						{
						setState(547);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case RBOLD:
						case RITALIC:
						case RSTRIKE:
							{
							setState(545);
							attrRight();
							}
							break;
						case RDQUOTE:
							{
							setState(546);
							match(RDQUOTE);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						setState(551);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					setState(556);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(557);
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
		enterRule(_localctx, 60, RULE_url);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(560);
			match(URL);
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
			setState(562);
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
			setState(564);
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
			setState(566);
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
			setState(568);
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
		enterRule(_localctx, 70, RULE_nl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(570);
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
		enterRule(_localctx, 72, RULE_attrLeft);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(572);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 28672L) != 0)) ) {
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
		enterRule(_localctx, 74, RULE_attrRight);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(574);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 917504L) != 0)) ) {
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
		enterRule(_localctx, 76, RULE_comment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(576);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 25:
			return fnLinkDef_sempred((FnLinkDefContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean fnLinkDef_sempred(FnLinkDefContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return  twoSpaces() ;
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001O\u0243\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0005\u0000d\b\u0000\n\u0000\f\u0000g\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006y\b\u0006\n\u0006\f\u0006"+
		"|\t\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0003\u0007"+
		"\u0082\b\u0007\u0001\u0007\u0003\u0007\u0085\b\u0007\u0001\u0007\u0001"+
		"\u0007\u0005\u0007\u0089\b\u0007\n\u0007\f\u0007\u008c\t\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u009f"+
		"\b\b\u0001\b\u0003\b\u00a2\b\b\u0004\b\u00a4\b\b\u000b\b\f\b\u00a5\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0003\t\u00ad\b\t\u0001\t\u0003\t\u00b0"+
		"\b\t\u0001\t\u0001\t\u0003\t\u00b4\b\t\u0001\t\u0001\t\u0001\t\u0003\t"+
		"\u00b9\b\t\u0001\n\u0001\n\u0003\n\u00bd\b\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0005\u000b\u00c2\b\u000b\n\u000b\f\u000b\u00c5\t\u000b\u0001\u000b"+
		"\u0001\u000b\u0003\u000b\u00c9\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0005\u000b\u00cf\b\u000b\n\u000b\f\u000b\u00d2\t\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0003\f\u00d7\b\f\u0001\f\u0003\f\u00da\b\f"+
		"\u0001\f\u0004\f\u00dd\b\f\u000b\f\f\f\u00de\u0001\f\u0003\f\u00e2\b\f"+
		"\u0001\f\u0003\f\u00e5\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u00eb"+
		"\b\r\n\r\f\r\u00ee\t\r\u0001\u000e\u0001\u000e\u0003\u000e\u00f2\b\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0005\u000f\u00fb\b\u000f\n\u000f\f\u000f\u00fe\t\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0003\u0011\u0105"+
		"\b\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u0109\b\u0011\u0001\u0011"+
		"\u0003\u0011\u010c\b\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u0110\b"+
		"\u0011\u0001\u0012\u0001\u0012\u0003\u0012\u0114\b\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u0121\b\u0012\u0001"+
		"\u0012\u0003\u0012\u0124\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0003\u0013\u012a\b\u0013\u0001\u0013\u0003\u0013\u012d\b\u0013"+
		"\u0001\u0013\u0001\u0013\u0003\u0013\u0131\b\u0013\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014"+
		"\u0140\b\u0014\u0001\u0014\u0003\u0014\u0143\b\u0014\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u0149\b\u0015\u0001\u0015\u0003"+
		"\u0015\u014c\b\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u0150\b\u0015"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u0156\b\u0016"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017"+
		"\u015d\b\u0017\u0001\u0018\u0001\u0018\u0003\u0018\u0161\b\u0018\u0001"+
		"\u0018\u0001\u0018\u0003\u0018\u0165\b\u0018\u0001\u0018\u0001\u0018\u0003"+
		"\u0018\u0169\b\u0018\u0001\u0018\u0003\u0018\u016c\b\u0018\u0001\u0018"+
		"\u0003\u0018\u016f\b\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0005\u0019\u0179\b\u0019"+
		"\n\u0019\f\u0019\u017c\t\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0005\u001a\u0182\b\u001a\n\u001a\f\u001a\u0185\t\u001a\u0001\u001b"+
		"\u0005\u001b\u0188\b\u001b\n\u001b\f\u001b\u018b\t\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u01a5"+
		"\b\u001b\u0001\u001b\u0005\u001b\u01a8\b\u001b\n\u001b\f\u001b\u01ab\t"+
		"\u001b\u0004\u001b\u01ad\b\u001b\u000b\u001b\f\u001b\u01ae\u0001\u001c"+
		"\u0005\u001c\u01b2\b\u001c\n\u001c\f\u001c\u01b5\t\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0003\u001c\u01cb\b\u001c\u0001\u001c\u0005\u001c\u01ce\b\u001c"+
		"\n\u001c\f\u001c\u01d1\t\u001c\u0004\u001c\u01d3\b\u001c\u000b\u001c\f"+
		"\u001c\u01d4\u0001\u001d\u0001\u001d\u0001\u001d\u0005\u001d\u01da\b\u001d"+
		"\n\u001d\f\u001d\u01dd\t\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0003"+
		"\u001d\u01f4\b\u001d\u0001\u001d\u0001\u001d\u0005\u001d\u01f8\b\u001d"+
		"\n\u001d\f\u001d\u01fb\t\u001d\u0005\u001d\u01fd\b\u001d\n\u001d\f\u001d"+
		"\u0200\t\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0005\u001d"+
		"\u0206\b\u001d\n\u001d\f\u001d\u0209\t\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0003\u001d\u0220\b\u001d\u0001\u001d\u0001\u001d\u0005\u001d\u0224"+
		"\b\u001d\n\u001d\f\u001d\u0227\t\u001d\u0005\u001d\u0229\b\u001d\n\u001d"+
		"\f\u001d\u022c\t\u001d\u0001\u001d\u0003\u001d\u022f\b\u001d\u0001\u001e"+
		"\u0001\u001e\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001!\u0001!\u0001"+
		"\"\u0001\"\u0001#\u0001#\u0001$\u0001$\u0001%\u0001%\u0001&\u0001&\u0001"+
		"&\u0000\u0000\'\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJL\u0000\u0005\u0002"+
		"\u0000\u0005\u0005AA\u0001\u0000-.\u0002\u0000??AA\u0001\u0000\f\u000e"+
		"\u0001\u0000\u0011\u0013\u02cb\u0000e\u0001\u0000\u0000\u0000\u0002j\u0001"+
		"\u0000\u0000\u0000\u0004l\u0001\u0000\u0000\u0000\u0006n\u0001\u0000\u0000"+
		"\u0000\bp\u0001\u0000\u0000\u0000\nr\u0001\u0000\u0000\u0000\ft\u0001"+
		"\u0000\u0000\u0000\u000e\u007f\u0001\u0000\u0000\u0000\u0010\u008f\u0001"+
		"\u0000\u0000\u0000\u0012\u00b8\u0001\u0000\u0000\u0000\u0014\u00ba\u0001"+
		"\u0000\u0000\u0000\u0016\u00c3\u0001\u0000\u0000\u0000\u0018\u00d6\u0001"+
		"\u0000\u0000\u0000\u001a\u00e6\u0001\u0000\u0000\u0000\u001c\u00ef\u0001"+
		"\u0000\u0000\u0000\u001e\u00f5\u0001\u0000\u0000\u0000 \u00ff\u0001\u0000"+
		"\u0000\u0000\"\u0102\u0001\u0000\u0000\u0000$\u0111\u0001\u0000\u0000"+
		"\u0000&\u0125\u0001\u0000\u0000\u0000(\u0132\u0001\u0000\u0000\u0000*"+
		"\u0144\u0001\u0000\u0000\u0000,\u0151\u0001\u0000\u0000\u0000.\u015c\u0001"+
		"\u0000\u0000\u00000\u015e\u0001\u0000\u0000\u00002\u0170\u0001\u0000\u0000"+
		"\u00004\u017d\u0001\u0000\u0000\u00006\u01ac\u0001\u0000\u0000\u00008"+
		"\u01d2\u0001\u0000\u0000\u0000:\u022e\u0001\u0000\u0000\u0000<\u0230\u0001"+
		"\u0000\u0000\u0000>\u0232\u0001\u0000\u0000\u0000@\u0234\u0001\u0000\u0000"+
		"\u0000B\u0236\u0001\u0000\u0000\u0000D\u0238\u0001\u0000\u0000\u0000F"+
		"\u023a\u0001\u0000\u0000\u0000H\u023c\u0001\u0000\u0000\u0000J\u023e\u0001"+
		"\u0000\u0000\u0000L\u0240\u0001\u0000\u0000\u0000Nd\u0003\u0002\u0001"+
		"\u0000Od\u0003\u0004\u0002\u0000Pd\u0003\u0006\u0003\u0000Qd\u0003\f\u0006"+
		"\u0000Rd\u0003\b\u0004\u0000Sd\u0003\n\u0005\u0000Td\u0003\u000e\u0007"+
		"\u0000Ud\u0003L&\u0000Vd\u0003\u0012\t\u0000Wd\u0003\u0014\n\u0000Xd\u0003"+
		"\u0016\u000b\u0000Yd\u0003\u001e\u000f\u0000Zd\u0003\u001a\r\u0000[d\u0003"+
		"4\u001a\u0000\\d\u00030\u0018\u0000]d\u00032\u0019\u0000^d\u0003>\u001f"+
		"\u0000_d\u0003@ \u0000`d\u0003B!\u0000ad\u0003D\"\u0000bd\u0005A\u0000"+
		"\u0000cN\u0001\u0000\u0000\u0000cO\u0001\u0000\u0000\u0000cP\u0001\u0000"+
		"\u0000\u0000cQ\u0001\u0000\u0000\u0000cR\u0001\u0000\u0000\u0000cS\u0001"+
		"\u0000\u0000\u0000cT\u0001\u0000\u0000\u0000cU\u0001\u0000\u0000\u0000"+
		"cV\u0001\u0000\u0000\u0000cW\u0001\u0000\u0000\u0000cX\u0001\u0000\u0000"+
		"\u0000cY\u0001\u0000\u0000\u0000cZ\u0001\u0000\u0000\u0000c[\u0001\u0000"+
		"\u0000\u0000c\\\u0001\u0000\u0000\u0000c]\u0001\u0000\u0000\u0000c^\u0001"+
		"\u0000\u0000\u0000c_\u0001\u0000\u0000\u0000c`\u0001\u0000\u0000\u0000"+
		"ca\u0001\u0000\u0000\u0000cb\u0001\u0000\u0000\u0000dg\u0001\u0000\u0000"+
		"\u0000ec\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000fh\u0001\u0000"+
		"\u0000\u0000ge\u0001\u0000\u0000\u0000hi\u0005\u0000\u0000\u0001i\u0001"+
		"\u0001\u0000\u0000\u0000jk\u0005\u0019\u0000\u0000k\u0003\u0001\u0000"+
		"\u0000\u0000lm\u0005\u001a\u0000\u0000m\u0005\u0001\u0000\u0000\u0000"+
		"no\u0005\u001b\u0000\u0000o\u0007\u0001\u0000\u0000\u0000pq\u0005\u001c"+
		"\u0000\u0000q\t\u0001\u0000\u0000\u0000rs\u0005\u001d\u0000\u0000s\u000b"+
		"\u0001\u0000\u0000\u0000tz\u0005\u0017\u0000\u0000uy\u0005\u0016\u0000"+
		"\u0000vy\u00036\u001b\u0000wy\u0003F#\u0000xu\u0001\u0000\u0000\u0000"+
		"xv\u0001\u0000\u0000\u0000xw\u0001\u0000\u0000\u0000y|\u0001\u0000\u0000"+
		"\u0000zx\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{}\u0001\u0000"+
		"\u0000\u0000|z\u0001\u0000\u0000\u0000}~\u0005\u0018\u0000\u0000~\r\u0001"+
		"\u0000\u0000\u0000\u007f\u0081\u0005\u0002\u0000\u0000\u0080\u0082\u0005"+
		"\u0004\u0000\u0000\u0081\u0080\u0001\u0000\u0000\u0000\u0081\u0082\u0001"+
		"\u0000\u0000\u0000\u0082\u0084\u0001\u0000\u0000\u0000\u0083\u0085\u0003"+
		"\u0010\b\u0000\u0084\u0083\u0001\u0000\u0000\u0000\u0084\u0085\u0001\u0000"+
		"\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086\u008a\u0005A\u0000"+
		"\u0000\u0087\u0089\u0007\u0000\u0000\u0000\u0088\u0087\u0001\u0000\u0000"+
		"\u0000\u0089\u008c\u0001\u0000\u0000\u0000\u008a\u0088\u0001\u0000\u0000"+
		"\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008b\u008d\u0001\u0000\u0000"+
		"\u0000\u008c\u008a\u0001\u0000\u0000\u0000\u008d\u008e\u0005\u0003\u0000"+
		"\u0000\u008e\u000f\u0001\u0000\u0000\u0000\u008f\u00a3\u0005 \u0000\u0000"+
		"\u0090\u00a4\u0005H\u0000\u0000\u0091\u0092\u0005E\u0000\u0000\u0092\u00a4"+
		"\u0005\u0001\u0000\u0000\u0093\u0094\u0005F\u0000\u0000\u0094\u00a4\u0005"+
		"\u0001\u0000\u0000\u0095\u0096\u0005\u0001\u0000\u0000\u0096\u00a1\u0005"+
		"G\u0000\u0000\u0097\u0098\u0005=\u0000\u0000\u0098\u0099\u0005\u0001\u0000"+
		"\u0000\u0099\u00a2\u0005=\u0000\u0000\u009a\u009b\u0005<\u0000\u0000\u009b"+
		"\u009c\u0005\u0001\u0000\u0000\u009c\u00a2\u0005<\u0000\u0000\u009d\u009f"+
		"\u0005H\u0000\u0000\u009e\u009d\u0001\u0000\u0000\u0000\u009e\u009f\u0001"+
		"\u0000\u0000\u0000\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0\u00a2\u0005"+
		"\u0001\u0000\u0000\u00a1\u0097\u0001\u0000\u0000\u0000\u00a1\u009a\u0001"+
		"\u0000\u0000\u0000\u00a1\u009e\u0001\u0000\u0000\u0000\u00a2\u00a4\u0001"+
		"\u0000\u0000\u0000\u00a3\u0090\u0001\u0000\u0000\u0000\u00a3\u0091\u0001"+
		"\u0000\u0000\u0000\u00a3\u0093\u0001\u0000\u0000\u0000\u00a3\u0095\u0001"+
		"\u0000\u0000\u0000\u00a4\u00a5\u0001\u0000\u0000\u0000\u00a5\u00a3\u0001"+
		"\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001"+
		"\u0000\u0000\u0000\u00a7\u00a8\u0005D\u0000\u0000\u00a8\u0011\u0001\u0000"+
		"\u0000\u0000\u00a9\u00aa\u0005\'\u0000\u0000\u00aa\u00ac\u00036\u001b"+
		"\u0000\u00ab\u00ad\u0005\'\u0000\u0000\u00ac\u00ab\u0001\u0000\u0000\u0000"+
		"\u00ac\u00ad\u0001\u0000\u0000\u0000\u00ad\u00af\u0001\u0000\u0000\u0000"+
		"\u00ae\u00b0\u0003\u0010\b\u0000\u00af\u00ae\u0001\u0000\u0000\u0000\u00af"+
		"\u00b0\u0001\u0000\u0000\u0000\u00b0\u00b9\u0001\u0000\u0000\u0000\u00b1"+
		"\u00b3\u00036\u001b\u0000\u00b2\u00b4\u0003\u0010\b\u0000\u00b3\u00b2"+
		"\u0001\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000\u0000\u0000\u00b4\u00b5"+
		"\u0001\u0000\u0000\u0000\u00b5\u00b6\u0003F#\u0000\u00b6\u00b7\u0005("+
		"\u0000\u0000\u00b7\u00b9\u0001\u0000\u0000\u0000\u00b8\u00a9\u0001\u0000"+
		"\u0000\u0000\u00b8\u00b1\u0001\u0000\u0000\u0000\u00b9\u0013\u0001\u0000"+
		"\u0000\u0000\u00ba\u00bc\u0005)\u0000\u0000\u00bb\u00bd\u0003\u0010\b"+
		"\u0000\u00bc\u00bb\u0001\u0000\u0000\u0000\u00bc\u00bd\u0001\u0000\u0000"+
		"\u0000\u00bd\u0015\u0001\u0000\u0000\u0000\u00be\u00bf\u0003\u0018\f\u0000"+
		"\u00bf\u00c0\u0003F#\u0000\u00c0\u00c2\u0001\u0000\u0000\u0000\u00c1\u00be"+
		"\u0001\u0000\u0000\u0000\u00c2\u00c5\u0001\u0000\u0000\u0000\u00c3\u00c1"+
		"\u0001\u0000\u0000\u0000\u00c3\u00c4\u0001\u0000\u0000\u0000\u00c4\u00c6"+
		"\u0001\u0000\u0000\u0000\u00c5\u00c3\u0001\u0000\u0000\u0000\u00c6\u00c8"+
		"\u0005+\u0000\u0000\u00c7\u00c9\u0003\u0010\b\u0000\u00c8\u00c7\u0001"+
		"\u0000\u0000\u0000\u00c8\u00c9\u0001\u0000\u0000\u0000\u00c9\u00ca\u0001"+
		"\u0000\u0000\u0000\u00ca\u00d0\u0003F#\u0000\u00cb\u00cc\u0003\u0018\f"+
		"\u0000\u00cc\u00cd\u0003F#\u0000\u00cd\u00cf\u0001\u0000\u0000\u0000\u00ce"+
		"\u00cb\u0001\u0000\u0000\u0000\u00cf\u00d2\u0001\u0000\u0000\u0000\u00d0"+
		"\u00ce\u0001\u0000\u0000\u0000\u00d0\u00d1\u0001\u0000\u0000\u0000\u00d1"+
		"\u00d3\u0001\u0000\u0000\u0000\u00d2\u00d0\u0001\u0000\u0000\u0000\u00d3"+
		"\u00d4\u0003\u0018\f\u0000\u00d4\u0017\u0001\u0000\u0000\u0000\u00d5\u00d7"+
		"\u0005,\u0000\u0000\u00d6\u00d5\u0001\u0000\u0000\u0000\u00d6\u00d7\u0001"+
		"\u0000\u0000\u0000\u00d7\u00dc\u0001\u0000\u0000\u0000\u00d8\u00da\u0003"+
		"6\u001b\u0000\u00d9\u00d8\u0001\u0000\u0000\u0000\u00d9\u00da\u0001\u0000"+
		"\u0000\u0000\u00da\u00db\u0001\u0000\u0000\u0000\u00db\u00dd\u0005,\u0000"+
		"\u0000\u00dc\u00d9\u0001\u0000\u0000\u0000\u00dd\u00de\u0001\u0000\u0000"+
		"\u0000\u00de\u00dc\u0001\u0000\u0000\u0000\u00de\u00df\u0001\u0000\u0000"+
		"\u0000\u00df\u00e1\u0001\u0000\u0000\u0000\u00e0\u00e2\u00036\u001b\u0000"+
		"\u00e1\u00e0\u0001\u0000\u0000\u0000\u00e1\u00e2\u0001\u0000\u0000\u0000"+
		"\u00e2\u00e4\u0001\u0000\u0000\u0000\u00e3\u00e5\u0005,\u0000\u0000\u00e4"+
		"\u00e3\u0001\u0000\u0000\u0000\u00e4\u00e5\u0001\u0000\u0000\u0000\u00e5"+
		"\u0019\u0001\u0000\u0000\u0000\u00e6\u00ec\u0003\u001c\u000e\u0000\u00e7"+
		"\u00e8\u0003F#\u0000\u00e8\u00e9\u0003\u001c\u000e\u0000\u00e9\u00eb\u0001"+
		"\u0000\u0000\u0000\u00ea\u00e7\u0001\u0000\u0000\u0000\u00eb\u00ee\u0001"+
		"\u0000\u0000\u0000\u00ec\u00ea\u0001\u0000\u0000\u0000\u00ec\u00ed\u0001"+
		"\u0000\u0000\u0000\u00ed\u001b\u0001\u0000\u0000\u0000\u00ee\u00ec\u0001"+
		"\u0000\u0000\u0000\u00ef\u00f1\u0007\u0001\u0000\u0000\u00f0\u00f2\u0005"+
		"/\u0000\u0000\u00f1\u00f0\u0001\u0000\u0000\u0000\u00f1\u00f2\u0001\u0000"+
		"\u0000\u0000\u00f2\u00f3\u0001\u0000\u0000\u0000\u00f3\u00f4\u00034\u001a"+
		"\u0000\u00f4\u001d\u0001\u0000\u0000\u0000\u00f5\u00f6\u00036\u001b\u0000"+
		"\u00f6\u00f7\u0005A\u0000\u0000\u00f7\u00fc\u0003 \u0010\u0000\u00f8\u00f9"+
		"\u0005A\u0000\u0000\u00f9\u00fb\u0003 \u0010\u0000\u00fa\u00f8\u0001\u0000"+
		"\u0000\u0000\u00fb\u00fe\u0001\u0000\u0000\u0000\u00fc\u00fa\u0001\u0000"+
		"\u0000\u0000\u00fc\u00fd\u0001\u0000\u0000\u0000\u00fd\u001f\u0001\u0000"+
		"\u0000\u0000\u00fe\u00fc\u0001\u0000\u0000\u0000\u00ff\u0100\u0005*\u0000"+
		"\u0000\u0100\u0101\u00034\u001a\u0000\u0101!\u0001\u0000\u0000\u0000\u0102"+
		"\u0104\u00055\u0000\u0000\u0103\u0105\u00038\u001c\u0000\u0104\u0103\u0001"+
		"\u0000\u0000\u0000\u0104\u0105\u0001\u0000\u0000\u0000\u0105\u0106\u0001"+
		"\u0000\u0000\u0000\u0106\u0108\u00052\u0000\u0000\u0107\u0109\u0003<\u001e"+
		"\u0000\u0108\u0107\u0001\u0000\u0000\u0000\u0108\u0109\u0001\u0000\u0000"+
		"\u0000\u0109\u010b\u0001\u0000\u0000\u0000\u010a\u010c\u0003:\u001d\u0000"+
		"\u010b\u010a\u0001\u0000\u0000\u0000\u010b\u010c\u0001\u0000\u0000\u0000"+
		"\u010c\u010d\u0001\u0000\u0000\u0000\u010d\u010f\u00058\u0000\u0000\u010e"+
		"\u0110\u0003\u0010\b\u0000\u010f\u010e\u0001\u0000\u0000\u0000\u010f\u0110"+
		"\u0001\u0000\u0000\u0000\u0110#\u0001\u0000\u0000\u0000\u0111\u0120\u0005"+
		"5\u0000\u0000\u0112\u0114\u00038\u001c\u0000\u0113\u0112\u0001\u0000\u0000"+
		"\u0000\u0113\u0114\u0001\u0000\u0000\u0000\u0114\u0115\u0001\u0000\u0000"+
		"\u0000\u0115\u0116\u00053\u0000\u0000\u0116\u0117\u00038\u001c\u0000\u0117"+
		"\u0118\u00056\u0000\u0000\u0118\u0121\u0001\u0000\u0000\u0000\u0119\u011a"+
		"\u00038\u001c\u0000\u011a\u011b\u00053\u0000\u0000\u011b\u011c\u00056"+
		"\u0000\u0000\u011c\u0121\u0001\u0000\u0000\u0000\u011d\u011e\u00038\u001c"+
		"\u0000\u011e\u011f\u00056\u0000\u0000\u011f\u0121\u0001\u0000\u0000\u0000"+
		"\u0120\u0113\u0001\u0000\u0000\u0000\u0120\u0119\u0001\u0000\u0000\u0000"+
		"\u0120\u011d\u0001\u0000\u0000\u0000\u0121\u0123\u0001\u0000\u0000\u0000"+
		"\u0122\u0124\u0003\u0010\b\u0000\u0123\u0122\u0001\u0000\u0000\u0000\u0123"+
		"\u0124\u0001\u0000\u0000\u0000\u0124%\u0001\u0000\u0000\u0000\u0125\u0126"+
		"\u00050\u0000\u0000\u0126\u0127\u00038\u001c\u0000\u0127\u0129\u00052"+
		"\u0000\u0000\u0128\u012a\u0003<\u001e\u0000\u0129\u0128\u0001\u0000\u0000"+
		"\u0000\u0129\u012a\u0001\u0000\u0000\u0000\u012a\u012c\u0001\u0000\u0000"+
		"\u0000\u012b\u012d\u0003:\u001d\u0000\u012c\u012b\u0001\u0000\u0000\u0000"+
		"\u012c\u012d\u0001\u0000\u0000\u0000\u012d\u012e\u0001\u0000\u0000\u0000"+
		"\u012e\u0130\u00058\u0000\u0000\u012f\u0131\u0003\u0010\b\u0000\u0130"+
		"\u012f\u0001\u0000\u0000\u0000\u0130\u0131\u0001\u0000\u0000\u0000\u0131"+
		"\'\u0001\u0000\u0000\u0000\u0132\u013f\u00050\u0000\u0000\u0133\u0134"+
		"\u00038\u001c\u0000\u0134\u0135\u00053\u0000\u0000\u0135\u0136\u00038"+
		"\u001c\u0000\u0136\u0137\u00056\u0000\u0000\u0137\u0140\u0001\u0000\u0000"+
		"\u0000\u0138\u0139\u00038\u001c\u0000\u0139\u013a\u00053\u0000\u0000\u013a"+
		"\u013b\u00056\u0000\u0000\u013b\u0140\u0001\u0000\u0000\u0000\u013c\u013d"+
		"\u00038\u001c\u0000\u013d\u013e\u00056\u0000\u0000\u013e\u0140\u0001\u0000"+
		"\u0000\u0000\u013f\u0133\u0001\u0000\u0000\u0000\u013f\u0138\u0001\u0000"+
		"\u0000\u0000\u013f\u013c\u0001\u0000\u0000\u0000\u0140\u0142\u0001\u0000"+
		"\u0000\u0000\u0141\u0143\u0003\u0010\b\u0000\u0142\u0141\u0001\u0000\u0000"+
		"\u0000\u0142\u0143\u0001\u0000\u0000\u0000\u0143)\u0001\u0000\u0000\u0000"+
		"\u0144\u0145\u00051\u0000\u0000\u0145\u0146\u00038\u001c\u0000\u0146\u0148"+
		"\u00052\u0000\u0000\u0147\u0149\u0003<\u001e\u0000\u0148\u0147\u0001\u0000"+
		"\u0000\u0000\u0148\u0149\u0001\u0000\u0000\u0000\u0149\u014b\u0001\u0000"+
		"\u0000\u0000\u014a\u014c\u0003:\u001d\u0000\u014b\u014a\u0001\u0000\u0000"+
		"\u0000\u014b\u014c\u0001\u0000\u0000\u0000\u014c\u014d\u0001\u0000\u0000"+
		"\u0000\u014d\u014f\u00058\u0000\u0000\u014e\u0150\u0003\u0010\b\u0000"+
		"\u014f\u014e\u0001\u0000\u0000\u0000\u014f\u0150\u0001\u0000\u0000\u0000"+
		"\u0150+\u0001\u0000\u0000\u0000\u0151\u0152\u00051\u0000\u0000\u0152\u0153"+
		"\u00038\u001c\u0000\u0153\u0155\u00056\u0000\u0000\u0154\u0156\u0003\u0010"+
		"\b\u0000\u0155\u0154\u0001\u0000\u0000\u0000\u0155\u0156\u0001\u0000\u0000"+
		"\u0000\u0156-\u0001\u0000\u0000\u0000\u0157\u015d\u0005\"\u0000\u0000"+
		"\u0158\u0159\u00055\u0000\u0000\u0159\u015a\u0005!\u0000\u0000\u015a\u015d"+
		"\u00056\u0000\u0000\u015b\u015d\u0005!\u0000\u0000\u015c\u0157\u0001\u0000"+
		"\u0000\u0000\u015c\u0158\u0001\u0000\u0000\u0000\u015c\u015b\u0001\u0000"+
		"\u0000\u0000\u015d/\u0001\u0000\u0000\u0000\u015e\u0160\u00055\u0000\u0000"+
		"\u015f\u0161\u00038\u001c\u0000\u0160\u015f\u0001\u0000\u0000\u0000\u0160"+
		"\u0161\u0001\u0000\u0000\u0000\u0161\u0162\u0001\u0000\u0000\u0000\u0162"+
		"\u0164\u00054\u0000\u0000\u0163\u0165\u0003F#\u0000\u0164\u0163\u0001"+
		"\u0000\u0000\u0000\u0164\u0165\u0001\u0000\u0000\u0000\u0165\u0166\u0001"+
		"\u0000\u0000\u0000\u0166\u016b\u0003<\u001e\u0000\u0167\u0169\u0003F#"+
		"\u0000\u0168\u0167\u0001\u0000\u0000\u0000\u0168\u0169\u0001\u0000\u0000"+
		"\u0000\u0169\u016a\u0001\u0000\u0000\u0000\u016a\u016c\u0003:\u001d\u0000"+
		"\u016b\u0168\u0001\u0000\u0000\u0000\u016b\u016c\u0001\u0000\u0000\u0000"+
		"\u016c\u016e\u0001\u0000\u0000\u0000\u016d\u016f\u0003\u0010\b\u0000\u016e"+
		"\u016d\u0001\u0000\u0000\u0000\u016e\u016f\u0001\u0000\u0000\u0000\u016f"+
		"1\u0001\u0000\u0000\u0000\u0170\u0171\u00051\u0000\u0000\u0171\u0172\u0003"+
		"8\u001c\u0000\u0172\u0173\u00054\u0000\u0000\u0173\u017a\u00036\u001b"+
		"\u0000\u0174\u0175\u0003F#\u0000\u0175\u0176\u0004\u0019\u0000\u0000\u0176"+
		"\u0177\u00036\u001b\u0000\u0177\u0179\u0001\u0000\u0000\u0000\u0178\u0174"+
		"\u0001\u0000\u0000\u0000\u0179\u017c\u0001\u0000\u0000\u0000\u017a\u0178"+
		"\u0001\u0000\u0000\u0000\u017a\u017b\u0001\u0000\u0000\u0000\u017b3\u0001"+
		"\u0000\u0000\u0000\u017c\u017a\u0001\u0000\u0000\u0000\u017d\u0183\u0003"+
		"6\u001b\u0000\u017e\u017f\u0003F#\u0000\u017f\u0180\u00036\u001b\u0000"+
		"\u0180\u0182\u0001\u0000\u0000\u0000\u0181\u017e\u0001\u0000\u0000\u0000"+
		"\u0182\u0185\u0001\u0000\u0000\u0000\u0183\u0181\u0001\u0000\u0000\u0000"+
		"\u0183\u0184\u0001\u0000\u0000\u0000\u01845\u0001\u0000\u0000\u0000\u0185"+
		"\u0183\u0001\u0000\u0000\u0000\u0186\u0188\u0003H$\u0000\u0187\u0186\u0001"+
		"\u0000\u0000\u0000\u0188\u018b\u0001\u0000\u0000\u0000\u0189\u0187\u0001"+
		"\u0000\u0000\u0000\u0189\u018a\u0001\u0000\u0000\u0000\u018a\u01a4\u0001"+
		"\u0000\u0000\u0000\u018b\u0189\u0001\u0000\u0000\u0000\u018c\u01a5\u0003"+
		":\u001d\u0000\u018d\u01a5\u0005\u0001\u0000\u0000\u018e\u01a5\u0005,\u0000"+
		"\u0000\u018f\u01a5\u00057\u0000\u0000\u0190\u01a5\u00058\u0000\u0000\u0191"+
		"\u01a5\u0005&\u0000\u0000\u0192\u01a5\u0005=\u0000\u0000\u0193\u01a5\u0005"+
		"<\u0000\u0000\u0194\u01a5\u0005\n\u0000\u0000\u0195\u01a5\u0005\u000b"+
		"\u0000\u0000\u0196\u01a5\u0005#\u0000\u0000\u0197\u01a5\u0005\u001f\u0000"+
		"\u0000\u0198\u01a5\u0005\u001e\u0000\u0000\u0199\u01a5\u0005$\u0000\u0000"+
		"\u019a\u01a5\u0005%\u0000\u0000\u019b\u01a5\u0003\"\u0011\u0000\u019c"+
		"\u01a5\u0003$\u0012\u0000\u019d\u01a5\u0003&\u0013\u0000\u019e\u01a5\u0003"+
		"(\u0014\u0000\u019f\u01a5\u0003*\u0015\u0000\u01a0\u01a5\u0003,\u0016"+
		"\u0000\u01a1\u01a5\u0003.\u0017\u0000\u01a2\u01a5\u00055\u0000\u0000\u01a3"+
		"\u01a5\u00056\u0000\u0000\u01a4\u018c\u0001\u0000\u0000\u0000\u01a4\u018d"+
		"\u0001\u0000\u0000\u0000\u01a4\u018e\u0001\u0000\u0000\u0000\u01a4\u018f"+
		"\u0001\u0000\u0000\u0000\u01a4\u0190\u0001\u0000\u0000\u0000\u01a4\u0191"+
		"\u0001\u0000\u0000\u0000\u01a4\u0192\u0001\u0000\u0000\u0000\u01a4\u0193"+
		"\u0001\u0000\u0000\u0000\u01a4\u0194\u0001\u0000\u0000\u0000\u01a4\u0195"+
		"\u0001\u0000\u0000\u0000\u01a4\u0196\u0001\u0000\u0000\u0000\u01a4\u0197"+
		"\u0001\u0000\u0000\u0000\u01a4\u0198\u0001\u0000\u0000\u0000\u01a4\u0199"+
		"\u0001\u0000\u0000\u0000\u01a4\u019a\u0001\u0000\u0000\u0000\u01a4\u019b"+
		"\u0001\u0000\u0000\u0000\u01a4\u019c\u0001\u0000\u0000\u0000\u01a4\u019d"+
		"\u0001\u0000\u0000\u0000\u01a4\u019e\u0001\u0000\u0000\u0000\u01a4\u019f"+
		"\u0001\u0000\u0000\u0000\u01a4\u01a0\u0001\u0000\u0000\u0000\u01a4\u01a1"+
		"\u0001\u0000\u0000\u0000\u01a4\u01a2\u0001\u0000\u0000\u0000\u01a4\u01a3"+
		"\u0001\u0000\u0000\u0000\u01a5\u01a9\u0001\u0000\u0000\u0000\u01a6\u01a8"+
		"\u0003J%\u0000\u01a7\u01a6\u0001\u0000\u0000\u0000\u01a8\u01ab\u0001\u0000"+
		"\u0000\u0000\u01a9\u01a7\u0001\u0000\u0000\u0000\u01a9\u01aa\u0001\u0000"+
		"\u0000\u0000\u01aa\u01ad\u0001\u0000\u0000\u0000\u01ab\u01a9\u0001\u0000"+
		"\u0000\u0000\u01ac\u0189\u0001\u0000\u0000\u0000\u01ad\u01ae\u0001\u0000"+
		"\u0000\u0000\u01ae\u01ac\u0001\u0000\u0000\u0000\u01ae\u01af\u0001\u0000"+
		"\u0000\u0000\u01af7\u0001\u0000\u0000\u0000\u01b0\u01b2\u0003H$\u0000"+
		"\u01b1\u01b0\u0001\u0000\u0000\u0000\u01b2\u01b5\u0001\u0000\u0000\u0000"+
		"\u01b3\u01b1\u0001\u0000\u0000\u0000\u01b3\u01b4\u0001\u0000\u0000\u0000"+
		"\u01b4\u01ca\u0001\u0000\u0000\u0000\u01b5\u01b3\u0001\u0000\u0000\u0000"+
		"\u01b6\u01cb\u0003:\u001d\u0000\u01b7\u01cb\u0005\u0001\u0000\u0000\u01b8"+
		"\u01cb\u0005,\u0000\u0000\u01b9\u01cb\u00057\u0000\u0000\u01ba\u01cb\u0005"+
		"8\u0000\u0000\u01bb\u01cb\u0005&\u0000\u0000\u01bc\u01cb\u0005=\u0000"+
		"\u0000\u01bd\u01cb\u0005<\u0000\u0000\u01be\u01cb\u0005\n\u0000\u0000"+
		"\u01bf\u01cb\u0005\u000b\u0000\u0000\u01c0\u01cb\u0005#\u0000\u0000\u01c1"+
		"\u01cb\u0005\u001f\u0000\u0000\u01c2\u01cb\u0005\u001e\u0000\u0000\u01c3"+
		"\u01cb\u0005$\u0000\u0000\u01c4\u01cb\u0005%\u0000\u0000\u01c5\u01cb\u0003"+
		"\"\u0011\u0000\u01c6\u01cb\u0003$\u0012\u0000\u01c7\u01cb\u0003&\u0013"+
		"\u0000\u01c8\u01cb\u0003(\u0014\u0000\u01c9\u01cb\u0003.\u0017\u0000\u01ca"+
		"\u01b6\u0001\u0000\u0000\u0000\u01ca\u01b7\u0001\u0000\u0000\u0000\u01ca"+
		"\u01b8\u0001\u0000\u0000\u0000\u01ca\u01b9\u0001\u0000\u0000\u0000\u01ca"+
		"\u01ba\u0001\u0000\u0000\u0000\u01ca\u01bb\u0001\u0000\u0000\u0000\u01ca"+
		"\u01bc\u0001\u0000\u0000\u0000\u01ca\u01bd\u0001\u0000\u0000\u0000\u01ca"+
		"\u01be\u0001\u0000\u0000\u0000\u01ca\u01bf\u0001\u0000\u0000\u0000\u01ca"+
		"\u01c0\u0001\u0000\u0000\u0000\u01ca\u01c1\u0001\u0000\u0000\u0000\u01ca"+
		"\u01c2\u0001\u0000\u0000\u0000\u01ca\u01c3\u0001\u0000\u0000\u0000\u01ca"+
		"\u01c4\u0001\u0000\u0000\u0000\u01ca\u01c5\u0001\u0000\u0000\u0000\u01ca"+
		"\u01c6\u0001\u0000\u0000\u0000\u01ca\u01c7\u0001\u0000\u0000\u0000\u01ca"+
		"\u01c8\u0001\u0000\u0000\u0000\u01ca\u01c9\u0001\u0000\u0000\u0000\u01cb"+
		"\u01cf\u0001\u0000\u0000\u0000\u01cc\u01ce\u0003J%\u0000\u01cd\u01cc\u0001"+
		"\u0000\u0000\u0000\u01ce\u01d1\u0001\u0000\u0000\u0000\u01cf\u01cd\u0001"+
		"\u0000\u0000\u0000\u01cf\u01d0\u0001\u0000\u0000\u0000\u01d0\u01d3\u0001"+
		"\u0000\u0000\u0000\u01d1\u01cf\u0001\u0000\u0000\u0000\u01d2\u01b3\u0001"+
		"\u0000\u0000\u0000\u01d3\u01d4\u0001\u0000\u0000\u0000\u01d4\u01d2\u0001"+
		"\u0000\u0000\u0000\u01d4\u01d5\u0001\u0000\u0000\u0000\u01d59\u0001\u0000"+
		"\u0000\u0000\u01d6\u01fe\u0005\u000f\u0000\u0000\u01d7\u01da\u0003H$\u0000"+
		"\u01d8\u01da\u0005\u0010\u0000\u0000\u01d9\u01d7\u0001\u0000\u0000\u0000"+
		"\u01d9\u01d8\u0001\u0000\u0000\u0000\u01da\u01dd\u0001\u0000\u0000\u0000"+
		"\u01db\u01d9\u0001\u0000\u0000\u0000\u01db\u01dc\u0001\u0000\u0000\u0000"+
		"\u01dc\u01f3\u0001\u0000\u0000\u0000\u01dd\u01db\u0001\u0000\u0000\u0000"+
		"\u01de\u01f4\u0005\u0001\u0000\u0000\u01df\u01f4\u0005,\u0000\u0000\u01e0"+
		"\u01f4\u00057\u0000\u0000\u01e1\u01f4\u00058\u0000\u0000\u01e2\u01f4\u0005"+
		"&\u0000\u0000\u01e3\u01f4\u0005#\u0000\u0000\u01e4\u01f4\u0005\u001f\u0000"+
		"\u0000\u01e5\u01f4\u0005\u001e\u0000\u0000\u01e6\u01f4\u0005$\u0000\u0000"+
		"\u01e7\u01f4\u0005%\u0000\u0000\u01e8\u01f4\u0003\"\u0011\u0000\u01e9"+
		"\u01f4\u0003$\u0012\u0000\u01ea\u01f4\u0003&\u0013\u0000\u01eb\u01f4\u0003"+
		"(\u0014\u0000\u01ec\u01f4\u0003*\u0015\u0000\u01ed\u01f4\u0003,\u0016"+
		"\u0000\u01ee\u01f4\u0003.\u0017\u0000\u01ef\u01f4\u00055\u0000\u0000\u01f0"+
		"\u01f4\u00056\u0000\u0000\u01f1\u01f4\u0005=\u0000\u0000\u01f2\u01f4\u0005"+
		"\u000b\u0000\u0000\u01f3\u01de\u0001\u0000\u0000\u0000\u01f3\u01df\u0001"+
		"\u0000\u0000\u0000\u01f3\u01e0\u0001\u0000\u0000\u0000\u01f3\u01e1\u0001"+
		"\u0000\u0000\u0000\u01f3\u01e2\u0001\u0000\u0000\u0000\u01f3\u01e3\u0001"+
		"\u0000\u0000\u0000\u01f3\u01e4\u0001\u0000\u0000\u0000\u01f3\u01e5\u0001"+
		"\u0000\u0000\u0000\u01f3\u01e6\u0001\u0000\u0000\u0000\u01f3\u01e7\u0001"+
		"\u0000\u0000\u0000\u01f3\u01e8\u0001\u0000\u0000\u0000\u01f3\u01e9\u0001"+
		"\u0000\u0000\u0000\u01f3\u01ea\u0001\u0000\u0000\u0000\u01f3\u01eb\u0001"+
		"\u0000\u0000\u0000\u01f3\u01ec\u0001\u0000\u0000\u0000\u01f3\u01ed\u0001"+
		"\u0000\u0000\u0000\u01f3\u01ee\u0001\u0000\u0000\u0000\u01f3\u01ef\u0001"+
		"\u0000\u0000\u0000\u01f3\u01f0\u0001\u0000\u0000\u0000\u01f3\u01f1\u0001"+
		"\u0000\u0000\u0000\u01f3\u01f2\u0001\u0000\u0000\u0000\u01f4\u01f9\u0001"+
		"\u0000\u0000\u0000\u01f5\u01f8\u0003J%\u0000\u01f6\u01f8\u0005\u0015\u0000"+
		"\u0000\u01f7\u01f5\u0001\u0000\u0000\u0000\u01f7\u01f6\u0001\u0000\u0000"+
		"\u0000\u01f8\u01fb\u0001\u0000\u0000\u0000\u01f9\u01f7\u0001\u0000\u0000"+
		"\u0000\u01f9\u01fa\u0001\u0000\u0000\u0000\u01fa\u01fd\u0001\u0000\u0000"+
		"\u0000\u01fb\u01f9\u0001\u0000\u0000\u0000\u01fc\u01db\u0001\u0000\u0000"+
		"\u0000\u01fd\u0200\u0001\u0000\u0000\u0000\u01fe\u01fc\u0001\u0000\u0000"+
		"\u0000\u01fe\u01ff\u0001\u0000\u0000\u0000\u01ff\u0201\u0001\u0000\u0000"+
		"\u0000\u0200\u01fe\u0001\u0000\u0000\u0000\u0201\u022f\u0005\u0014\u0000"+
		"\u0000\u0202\u022a\u0005\u0010\u0000\u0000\u0203\u0206\u0003H$\u0000\u0204"+
		"\u0206\u0005\u000f\u0000\u0000\u0205\u0203\u0001\u0000\u0000\u0000\u0205"+
		"\u0204\u0001\u0000\u0000\u0000\u0206\u0209\u0001\u0000\u0000\u0000\u0207"+
		"\u0205\u0001\u0000\u0000\u0000\u0207\u0208\u0001\u0000\u0000\u0000\u0208"+
		"\u021f\u0001\u0000\u0000\u0000\u0209\u0207\u0001\u0000\u0000\u0000\u020a"+
		"\u0220\u0005\u0001\u0000\u0000\u020b\u0220\u0005,\u0000\u0000\u020c\u0220"+
		"\u00057\u0000\u0000\u020d\u0220\u00058\u0000\u0000\u020e\u0220\u0005&"+
		"\u0000\u0000\u020f\u0220\u0005#\u0000\u0000\u0210\u0220\u0005\u001f\u0000"+
		"\u0000\u0211\u0220\u0005\u001e\u0000\u0000\u0212\u0220\u0005$\u0000\u0000"+
		"\u0213\u0220\u0005%\u0000\u0000\u0214\u0220\u0003\"\u0011\u0000\u0215"+
		"\u0220\u0003$\u0012\u0000\u0216\u0220\u0003&\u0013\u0000\u0217\u0220\u0003"+
		"(\u0014\u0000\u0218\u0220\u0003*\u0015\u0000\u0219\u0220\u0003,\u0016"+
		"\u0000\u021a\u0220\u0003.\u0017\u0000\u021b\u0220\u00055\u0000\u0000\u021c"+
		"\u0220\u00056\u0000\u0000\u021d\u0220\u0005<\u0000\u0000\u021e\u0220\u0005"+
		"\n\u0000\u0000\u021f\u020a\u0001\u0000\u0000\u0000\u021f\u020b\u0001\u0000"+
		"\u0000\u0000\u021f\u020c\u0001\u0000\u0000\u0000\u021f\u020d\u0001\u0000"+
		"\u0000\u0000\u021f\u020e\u0001\u0000\u0000\u0000\u021f\u020f\u0001\u0000"+
		"\u0000\u0000\u021f\u0210\u0001\u0000\u0000\u0000\u021f\u0211\u0001\u0000"+
		"\u0000\u0000\u021f\u0212\u0001\u0000\u0000\u0000\u021f\u0213\u0001\u0000"+
		"\u0000\u0000\u021f\u0214\u0001\u0000\u0000\u0000\u021f\u0215\u0001\u0000"+
		"\u0000\u0000\u021f\u0216\u0001\u0000\u0000\u0000\u021f\u0217\u0001\u0000"+
		"\u0000\u0000\u021f\u0218\u0001\u0000\u0000\u0000\u021f\u0219\u0001\u0000"+
		"\u0000\u0000\u021f\u021a\u0001\u0000\u0000\u0000\u021f\u021b\u0001\u0000"+
		"\u0000\u0000\u021f\u021c\u0001\u0000\u0000\u0000\u021f\u021d\u0001\u0000"+
		"\u0000\u0000\u021f\u021e\u0001\u0000\u0000\u0000\u0220\u0225\u0001\u0000"+
		"\u0000\u0000\u0221\u0224\u0003J%\u0000\u0222\u0224\u0005\u0014\u0000\u0000"+
		"\u0223\u0221\u0001\u0000\u0000\u0000\u0223\u0222\u0001\u0000\u0000\u0000"+
		"\u0224\u0227\u0001\u0000\u0000\u0000\u0225\u0223\u0001\u0000\u0000\u0000"+
		"\u0225\u0226\u0001\u0000\u0000\u0000\u0226\u0229\u0001\u0000\u0000\u0000"+
		"\u0227\u0225\u0001\u0000\u0000\u0000\u0228\u0207\u0001\u0000\u0000\u0000"+
		"\u0229\u022c\u0001\u0000\u0000\u0000\u022a\u0228\u0001\u0000\u0000\u0000"+
		"\u022a\u022b\u0001\u0000\u0000\u0000\u022b\u022d\u0001\u0000\u0000\u0000"+
		"\u022c\u022a\u0001\u0000\u0000\u0000\u022d\u022f\u0005\u0015\u0000\u0000"+
		"\u022e\u01d6\u0001\u0000\u0000\u0000\u022e\u0202\u0001\u0000\u0000\u0000"+
		"\u022f;\u0001\u0000\u0000\u0000\u0230\u0231\u0005!\u0000\u0000\u0231="+
		"\u0001\u0000\u0000\u0000\u0232\u0233\u0005>\u0000\u0000\u0233?\u0001\u0000"+
		"\u0000\u0000\u0234\u0235\u0005\u0007\u0000\u0000\u0235A\u0001\u0000\u0000"+
		"\u0000\u0236\u0237\u0005\b\u0000\u0000\u0237C\u0001\u0000\u0000\u0000"+
		"\u0238\u0239\u0005?\u0000\u0000\u0239E\u0001\u0000\u0000\u0000\u023a\u023b"+
		"\u0007\u0002\u0000\u0000\u023bG\u0001\u0000\u0000\u0000\u023c\u023d\u0007"+
		"\u0003\u0000\u0000\u023dI\u0001\u0000\u0000\u0000\u023e\u023f\u0007\u0004"+
		"\u0000\u0000\u023fK\u0001\u0000\u0000\u0000\u0240\u0241\u0005\u0016\u0000"+
		"\u0000\u0241M\u0001\u0000\u0000\u0000Hcexz\u0081\u0084\u008a\u009e\u00a1"+
		"\u00a3\u00a5\u00ac\u00af\u00b3\u00b8\u00bc\u00c3\u00c8\u00d0\u00d6\u00d9"+
		"\u00de\u00e1\u00e4\u00ec\u00f1\u00fc\u0104\u0108\u010b\u010f\u0113\u0120"+
		"\u0123\u0129\u012c\u0130\u013f\u0142\u0148\u014b\u014f\u0155\u015c\u0160"+
		"\u0164\u0168\u016b\u016e\u017a\u0183\u0189\u01a4\u01a9\u01ae\u01b3\u01ca"+
		"\u01cf\u01d4\u01d9\u01db\u01f3\u01f7\u01f9\u01fe\u0205\u0207\u021f\u0223"+
		"\u0225\u022a\u022e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}