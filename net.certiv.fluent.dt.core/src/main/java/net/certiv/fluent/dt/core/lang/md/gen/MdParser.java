// Generated from D:/DevFiles/Eclipse/Tools/Editors/net.certiv.fluent.dt/net.certiv.fluent.dt.core/src/main/java/net/certiv/fluent/dt/core/lang/md/MdParser.g4 by ANTLR 4.7.2

	package net.certiv.fluent.dt.core.lang.md.gen;
	import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
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

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MdParser extends MdParserBase {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WORD=1, HDR_END=2, RBOLD=3, RITALIC=4, RSTRIKE=5, RSPAN=6, RDQUOTE=7, 
		RSQUOTE=8, HIDN_COMMENT=9, HTML_COMMENT=10, URL=11, LSTYLE=12, LINK=13, 
		LDEF=14, LREF=15, LURL=16, LTXT=17, CODE_BEG=18, YAML_BLOCK=19, HTML_BLOCK=20, 
		MATH_BLOCK=21, TEX_BLOCK=22, UML_BLOCK=23, UNICODE=24, ENTITY=25, TEX=26, 
		MATH=27, HTML=28, TABLE=29, PIPE=30, HRULE=31, HASHES=32, DASHES=33, EQUALS=34, 
		COLON=35, SIMPLE_MARK=36, PAREN_MARK=37, UALPHA_MARK=38, LALPHA_MARK=39, 
		LBOLD=40, LITALIC=41, LSTRIKE=42, LSPAN=43, LDQUOTE=44, LSQUOTE=45, BQUOTE=46, 
		BLANK=47, BREAK=48, VWS=49, HWS=50, CHAR=51, ERR=52, HASH=53, CHAR_h=54, 
		RSTYLE=55, CLASS=56, ID=57, EQ=58, QUOTE=59, MARK=60, CHAR_sd=61, LINK_MARK=62, 
		REF_MARK=63, DEF_MARK=64, RBRACK=65, RPAREN=66, CHAR_l=67, CODE_END=68, 
		WORD_b=69, WORD_t=70;
	public static final int
		RULE_page = 0, RULE_yamlBlock = 1, RULE_htmlBlock = 2, RULE_mathBlock = 3, 
		RULE_texBlock = 4, RULE_umlBlock = 5, RULE_codeBlock = 6, RULE_header = 7, 
		RULE_hrule = 8, RULE_list = 9, RULE_listItem = 10, RULE_listMark = 11, 
		RULE_table = 12, RULE_tableDef = 13, RULE_tableRow = 14, RULE_tableCell = 15, 
		RULE_definition = 16, RULE_paragraph = 17, RULE_content = 18, RULE_link = 19, 
		RULE_text = 20, RULE_word = 21, RULE_style = 22, RULE_attrLeft = 23, RULE_attrRight = 24, 
		RULE_comment = 25, RULE_lnBlank = 26, RULE_lnBreak = 27, RULE_ignore = 28;
	private static String[] makeRuleNames() {
		return new String[] {
			"page", "yamlBlock", "htmlBlock", "mathBlock", "texBlock", "umlBlock", 
			"codeBlock", "header", "hrule", "list", "listItem", "listMark", "table", 
			"tableDef", "tableRow", "tableCell", "definition", "paragraph", "content", 
			"link", "text", "word", "style", "attrLeft", "attrRight", "comment", 
			"lnBlank", "lnBreak", "ignore"
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
			null, "WORD", "HDR_END", "RBOLD", "RITALIC", "RSTRIKE", "RSPAN", "RDQUOTE", 
			"RSQUOTE", "HIDN_COMMENT", "HTML_COMMENT", "URL", "LSTYLE", "LINK", "LDEF", 
			"LREF", "LURL", "LTXT", "CODE_BEG", "YAML_BLOCK", "HTML_BLOCK", "MATH_BLOCK", 
			"TEX_BLOCK", "UML_BLOCK", "UNICODE", "ENTITY", "TEX", "MATH", "HTML", 
			"TABLE", "PIPE", "HRULE", "HASHES", "DASHES", "EQUALS", "COLON", "SIMPLE_MARK", 
			"PAREN_MARK", "UALPHA_MARK", "LALPHA_MARK", "LBOLD", "LITALIC", "LSTRIKE", 
			"LSPAN", "LDQUOTE", "LSQUOTE", "BQUOTE", "BLANK", "BREAK", "VWS", "HWS", 
			"CHAR", "ERR", "HASH", "CHAR_h", "RSTYLE", "CLASS", "ID", "EQ", "QUOTE", 
			"MARK", "CHAR_sd", "LINK_MARK", "REF_MARK", "DEF_MARK", "RBRACK", "RPAREN", 
			"CHAR_l", "CODE_END", "WORD_b", "WORD_t"
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
		public List<CodeBlockContext> codeBlock() {
			return getRuleContexts(CodeBlockContext.class);
		}
		public CodeBlockContext codeBlock(int i) {
			return getRuleContext(CodeBlockContext.class,i);
		}
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
		public List<ListContext> list() {
			return getRuleContexts(ListContext.class);
		}
		public ListContext list(int i) {
			return getRuleContext(ListContext.class,i);
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
		public List<ParagraphContext> paragraph() {
			return getRuleContexts(ParagraphContext.class);
		}
		public ParagraphContext paragraph(int i) {
			return getRuleContext(ParagraphContext.class,i);
		}
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public List<LnBreakContext> lnBreak() {
			return getRuleContexts(LnBreakContext.class);
		}
		public LnBreakContext lnBreak(int i) {
			return getRuleContext(LnBreakContext.class,i);
		}
		public List<LnBlankContext> lnBlank() {
			return getRuleContexts(LnBlankContext.class);
		}
		public LnBlankContext lnBlank(int i) {
			return getRuleContext(LnBlankContext.class,i);
		}
		public List<IgnoreContext> ignore() {
			return getRuleContexts(IgnoreContext.class);
		}
		public IgnoreContext ignore(int i) {
			return getRuleContext(IgnoreContext.class,i);
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << HIDN_COMMENT) | (1L << HTML_COMMENT) | (1L << CODE_BEG) | (1L << YAML_BLOCK) | (1L << HTML_BLOCK) | (1L << MATH_BLOCK) | (1L << TEX_BLOCK) | (1L << UML_BLOCK) | (1L << BLANK) | (1L << BREAK) | (1L << ERR))) != 0)) {
				{
				setState(74);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(58);
					codeBlock();
					}
					break;
				case 2:
					{
					setState(59);
					yamlBlock();
					}
					break;
				case 3:
					{
					setState(60);
					htmlBlock();
					}
					break;
				case 4:
					{
					setState(61);
					mathBlock();
					}
					break;
				case 5:
					{
					setState(62);
					texBlock();
					}
					break;
				case 6:
					{
					setState(63);
					umlBlock();
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
					list();
					}
					break;
				case 10:
					{
					setState(67);
					table();
					}
					break;
				case 11:
					{
					setState(68);
					definition();
					}
					break;
				case 12:
					{
					setState(69);
					paragraph();
					}
					break;
				case 13:
					{
					setState(70);
					comment();
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
					lnBlank();
					}
					break;
				case 16:
					{
					setState(73);
					ignore();
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
		public Token WORD;
		public List<Token> code = new ArrayList<Token>();
		public Token HWS;
		public Token VWS;
		public Token _tset181;
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
		public List<TerminalNode> HWS() { return getTokens(MdParser.HWS); }
		public TerminalNode HWS(int i) {
			return getToken(MdParser.HWS, i);
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
			setState(99);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==HWS) {
					{
					{
					setState(92);
					match(HWS);
					}
					}
					setState(97);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(98);
				((CodeBlockContext)_localctx).lang = match(WORD);
				}
				break;
			}
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LSTYLE || _la==HWS) {
				{
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==HWS) {
					{
					{
					setState(101);
					match(HWS);
					}
					}
					setState(106);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(107);
				style();
				}
			}

			setState(111); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(110);
					match(VWS);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(113); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << VWS) | (1L << HWS))) != 0)) {
				{
				{
				setState(115);
				((CodeBlockContext)_localctx)._tset181 = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << VWS) | (1L << HWS))) != 0)) ) {
					((CodeBlockContext)_localctx)._tset181 = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				((CodeBlockContext)_localctx).code.add(((CodeBlockContext)_localctx)._tset181);
				}
				}
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(121);
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
		public TerminalNode BLANK() { return getToken(MdParser.BLANK, 0); }
		public TerminalNode HASHES() { return getToken(MdParser.HASHES, 0); }
		public List<ContentContext> content() {
			return getRuleContexts(ContentContext.class);
		}
		public ContentContext content(int i) {
			return getRuleContext(ContentContext.class,i);
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
			setState(148);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(123);
				match(BLANK);
				setState(124);
				match(HASHES);
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << URL) | (1L << LINK) | (1L << LDEF) | (1L << LREF) | (1L << LURL) | (1L << LTXT) | (1L << UNICODE) | (1L << ENTITY) | (1L << TEX) | (1L << MATH) | (1L << HTML) | (1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LSPAN) | (1L << LDQUOTE) | (1L << LSQUOTE))) != 0)) {
					{
					{
					setState(125);
					content();
					}
					}
					setState(130);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==HASH) {
					{
					{
					setState(131);
					match(HASH);
					}
					}
					setState(136);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LSTYLE) {
					{
					setState(137);
					style();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(140);
				match(BLANK);
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << URL) | (1L << LINK) | (1L << LDEF) | (1L << LREF) | (1L << LURL) | (1L << LTXT) | (1L << UNICODE) | (1L << ENTITY) | (1L << TEX) | (1L << MATH) | (1L << HTML) | (1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LSPAN) | (1L << LDQUOTE) | (1L << LSQUOTE))) != 0)) {
					{
					{
					setState(141);
					content();
					}
					}
					setState(146);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(147);
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
		public TerminalNode BLANK() { return getToken(MdParser.BLANK, 0); }
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
			setState(150);
			match(BLANK);
			setState(151);
			match(HRULE);
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LSTYLE) {
				{
				setState(152);
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

	public static class ListContext extends ParserRuleContext {
		public TerminalNode BLANK() { return getToken(MdParser.BLANK, 0); }
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
		enterRule(_localctx, 18, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			match(BLANK);
			setState(157); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(156);
				listItem();
				}
				}
				setState(159); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SIMPLE_MARK) | (1L << PAREN_MARK) | (1L << UALPHA_MARK) | (1L << LALPHA_MARK))) != 0) );
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
		public List<ContentContext> content() {
			return getRuleContexts(ContentContext.class);
		}
		public ContentContext content(int i) {
			return getRuleContext(ContentContext.class,i);
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
		enterRule(_localctx, 20, RULE_listItem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			listMark();
			setState(163); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(162);
				content();
				}
				}
				setState(165); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << URL) | (1L << LINK) | (1L << LDEF) | (1L << LREF) | (1L << LURL) | (1L << LTXT) | (1L << UNICODE) | (1L << ENTITY) | (1L << TEX) | (1L << MATH) | (1L << HTML) | (1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LSPAN) | (1L << LDQUOTE) | (1L << LSQUOTE))) != 0) );
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
		public TerminalNode SIMPLE_MARK() { return getToken(MdParser.SIMPLE_MARK, 0); }
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
		enterRule(_localctx, 22, RULE_listMark);
		try {
			setState(171);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SIMPLE_MARK:
				enterOuterAlt(_localctx, 1);
				{
				setState(167);
				((ListMarkContext)_localctx).mark = match(SIMPLE_MARK);
				}
				break;
			case PAREN_MARK:
				enterOuterAlt(_localctx, 2);
				{
				setState(168);
				((ListMarkContext)_localctx).mark = match(PAREN_MARK);
				}
				break;
			case UALPHA_MARK:
				enterOuterAlt(_localctx, 3);
				{
				setState(169);
				((ListMarkContext)_localctx).mark = match(UALPHA_MARK);
				}
				break;
			case LALPHA_MARK:
				enterOuterAlt(_localctx, 4);
				{
				setState(170);
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

	public static class TableContext extends ParserRuleContext {
		public TableRowContext hdr;
		public TableRowContext tableRow;
		public List<TableRowContext> rows = new ArrayList<TableRowContext>();
		public TerminalNode BLANK() { return getToken(MdParser.BLANK, 0); }
		public TableDefContext tableDef() {
			return getRuleContext(TableDefContext.class,0);
		}
		public List<TableRowContext> tableRow() {
			return getRuleContexts(TableRowContext.class);
		}
		public TableRowContext tableRow(int i) {
			return getRuleContext(TableRowContext.class,i);
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
		enterRule(_localctx, 24, RULE_table);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(BLANK);
			setState(174);
			((TableContext)_localctx).hdr = tableRow();
			setState(175);
			tableDef();
			setState(177); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(176);
				((TableContext)_localctx).tableRow = tableRow();
				((TableContext)_localctx).rows.add(((TableContext)_localctx).tableRow);
				}
				}
				setState(179); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << URL) | (1L << LINK) | (1L << LDEF) | (1L << LREF) | (1L << LURL) | (1L << LTXT) | (1L << UNICODE) | (1L << ENTITY) | (1L << TEX) | (1L << MATH) | (1L << HTML) | (1L << PIPE) | (1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LSPAN) | (1L << LDQUOTE) | (1L << LSQUOTE))) != 0) );
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

	public static class TableDefContext extends ParserRuleContext {
		public TerminalNode TABLE() { return getToken(MdParser.TABLE, 0); }
		public TableDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterTableDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitTableDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitTableDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableDefContext tableDef() throws RecognitionException {
		TableDefContext _localctx = new TableDefContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_tableDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			match(TABLE);
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
		public List<TableCellContext> tableCell() {
			return getRuleContexts(TableCellContext.class);
		}
		public TableCellContext tableCell(int i) {
			return getRuleContext(TableCellContext.class,i);
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
		enterRule(_localctx, 28, RULE_tableRow);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(183);
				match(PIPE);
				}
				break;
			}
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << URL) | (1L << LINK) | (1L << LDEF) | (1L << LREF) | (1L << LURL) | (1L << LTXT) | (1L << UNICODE) | (1L << ENTITY) | (1L << TEX) | (1L << MATH) | (1L << HTML) | (1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LSPAN) | (1L << LDQUOTE) | (1L << LSQUOTE))) != 0)) {
				{
				setState(186);
				tableCell();
				}
			}

			setState(193); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(189);
					match(PIPE);
					setState(191);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						setState(190);
						tableCell();
						}
						break;
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(195); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(198);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(197);
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

	public static class TableCellContext extends ParserRuleContext {
		public ContentContext content() {
			return getRuleContext(ContentContext.class,0);
		}
		public TableCellContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableCell; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterTableCell(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitTableCell(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitTableCell(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableCellContext tableCell() throws RecognitionException {
		TableCellContext _localctx = new TableCellContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_tableCell);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			content();
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
		public TerminalNode BLANK() { return getToken(MdParser.BLANK, 0); }
		public List<WordContext> word() {
			return getRuleContexts(WordContext.class);
		}
		public WordContext word(int i) {
			return getRuleContext(WordContext.class,i);
		}
		public List<TerminalNode> BREAK() { return getTokens(MdParser.BREAK); }
		public TerminalNode BREAK(int i) {
			return getToken(MdParser.BREAK, i);
		}
		public List<TerminalNode> COLON() { return getTokens(MdParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(MdParser.COLON, i);
		}
		public List<ParagraphContext> paragraph() {
			return getRuleContexts(ParagraphContext.class);
		}
		public ParagraphContext paragraph(int i) {
			return getRuleContext(ParagraphContext.class,i);
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
		enterRule(_localctx, 32, RULE_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			match(BLANK);
			setState(206); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(203);
				word();
				setState(204);
				match(BREAK);
				}
				}
				setState(208); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << URL) | (1L << UNICODE) | (1L << ENTITY) | (1L << TEX) | (1L << MATH) | (1L << HTML) | (1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LSPAN) | (1L << LDQUOTE) | (1L << LSQUOTE))) != 0) );
			setState(212); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(210);
				match(COLON);
				setState(211);
				paragraph();
				}
				}
				setState(214); 
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
		public TerminalNode BLANK() { return getToken(MdParser.BLANK, 0); }
		public List<ContentContext> content() {
			return getRuleContexts(ContentContext.class);
		}
		public ContentContext content(int i) {
			return getRuleContext(ContentContext.class,i);
		}
		public List<TerminalNode> BQUOTE() { return getTokens(MdParser.BQUOTE); }
		public TerminalNode BQUOTE(int i) {
			return getToken(MdParser.BQUOTE, i);
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
		enterRule(_localctx, 34, RULE_paragraph);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			match(BLANK);
			setState(221); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(218);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BQUOTE) {
					{
					setState(217);
					match(BQUOTE);
					}
				}

				setState(220);
				content();
				}
				}
				setState(223); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << URL) | (1L << LINK) | (1L << LDEF) | (1L << LREF) | (1L << LURL) | (1L << LTXT) | (1L << UNICODE) | (1L << ENTITY) | (1L << TEX) | (1L << MATH) | (1L << HTML) | (1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LSPAN) | (1L << LDQUOTE) | (1L << LSQUOTE) | (1L << BQUOTE))) != 0) );
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

	public static class ContentContext extends ParserRuleContext {
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
		public List<LnBreakContext> lnBreak() {
			return getRuleContexts(LnBreakContext.class);
		}
		public LnBreakContext lnBreak(int i) {
			return getRuleContext(LnBreakContext.class,i);
		}
		public ContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_content; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContentContext content() throws RecognitionException {
		ContentContext _localctx = new ContentContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_content);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(227); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(227);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case WORD:
					case URL:
					case UNICODE:
					case ENTITY:
					case TEX:
					case MATH:
					case HTML:
					case LBOLD:
					case LITALIC:
					case LSTRIKE:
					case LSPAN:
					case LDQUOTE:
					case LSQUOTE:
						{
						setState(225);
						word();
						}
						break;
					case LINK:
					case LDEF:
					case LREF:
					case LURL:
					case LTXT:
						{
						setState(226);
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
				setState(229); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(240);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(231);
					lnBreak();
					setState(234); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							setState(234);
							_errHandler.sync(this);
							switch (_input.LA(1)) {
							case WORD:
							case URL:
							case UNICODE:
							case ENTITY:
							case TEX:
							case MATH:
							case HTML:
							case LBOLD:
							case LITALIC:
							case LSTRIKE:
							case LSPAN:
							case LDQUOTE:
							case LSQUOTE:
								{
								setState(232);
								word();
								}
								break;
							case LINK:
							case LDEF:
							case LREF:
							case LURL:
							case LTXT:
								{
								setState(233);
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
						setState(236); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					} 
				}
				setState(242);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
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

	public static class LinkContext extends ParserRuleContext {
		public TerminalNode LINK() { return getToken(MdParser.LINK, 0); }
		public List<TextContext> text() {
			return getRuleContexts(TextContext.class);
		}
		public TextContext text(int i) {
			return getRuleContext(TextContext.class,i);
		}
		public TerminalNode LINK_MARK() { return getToken(MdParser.LINK_MARK, 0); }
		public TerminalNode URL() { return getToken(MdParser.URL, 0); }
		public TerminalNode RPAREN() { return getToken(MdParser.RPAREN, 0); }
		public List<TerminalNode> QUOTE() { return getTokens(MdParser.QUOTE); }
		public TerminalNode QUOTE(int i) {
			return getToken(MdParser.QUOTE, i);
		}
		public StyleContext style() {
			return getRuleContext(StyleContext.class,0);
		}
		public TerminalNode LDEF() { return getToken(MdParser.LDEF, 0); }
		public TerminalNode DEF_MARK() { return getToken(MdParser.DEF_MARK, 0); }
		public TerminalNode LDQUOTE() { return getToken(MdParser.LDQUOTE, 0); }
		public TerminalNode RDQUOTE() { return getToken(MdParser.RDQUOTE, 0); }
		public TerminalNode LREF() { return getToken(MdParser.LREF, 0); }
		public TerminalNode REF_MARK() { return getToken(MdParser.REF_MARK, 0); }
		public TerminalNode RBRACK() { return getToken(MdParser.RBRACK, 0); }
		public TerminalNode LURL() { return getToken(MdParser.LURL, 0); }
		public TerminalNode LTXT() { return getToken(MdParser.LTXT, 0); }
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
		enterRule(_localctx, 38, RULE_link);
		int _la;
		try {
			setState(287);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LINK:
				enterOuterAlt(_localctx, 1);
				{
				setState(243);
				match(LINK);
				setState(244);
				text();
				setState(245);
				match(LINK_MARK);
				setState(246);
				match(URL);
				setState(251);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==QUOTE) {
					{
					setState(247);
					match(QUOTE);
					setState(248);
					text();
					setState(249);
					match(QUOTE);
					}
				}

				setState(253);
				match(RPAREN);
				setState(255);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
				case 1:
					{
					setState(254);
					style();
					}
					break;
				}
				}
				break;
			case LDEF:
				enterOuterAlt(_localctx, 2);
				{
				setState(257);
				match(LDEF);
				setState(258);
				text();
				setState(259);
				match(DEF_MARK);
				setState(260);
				match(URL);
				setState(265);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
				case 1:
					{
					setState(261);
					match(LDQUOTE);
					setState(262);
					text();
					setState(263);
					match(RDQUOTE);
					}
					break;
				}
				}
				break;
			case LREF:
				enterOuterAlt(_localctx, 3);
				{
				setState(267);
				match(LREF);
				setState(268);
				text();
				setState(269);
				match(REF_MARK);
				setState(270);
				text();
				setState(271);
				match(RBRACK);
				setState(273);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
				case 1:
					{
					setState(272);
					style();
					}
					break;
				}
				}
				break;
			case LURL:
				enterOuterAlt(_localctx, 4);
				{
				setState(275);
				match(LURL);
				setState(276);
				match(URL);
				setState(277);
				match(RBRACK);
				setState(279);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
				case 1:
					{
					setState(278);
					style();
					}
					break;
				}
				}
				break;
			case LTXT:
				enterOuterAlt(_localctx, 5);
				{
				setState(281);
				match(LTXT);
				setState(282);
				text();
				setState(283);
				match(RBRACK);
				setState(285);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
				case 1:
					{
					setState(284);
					style();
					}
					break;
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
			setState(290); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(289);
				word();
				}
				}
				setState(292); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << URL) | (1L << UNICODE) | (1L << ENTITY) | (1L << TEX) | (1L << MATH) | (1L << HTML) | (1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LSPAN) | (1L << LDQUOTE) | (1L << LSQUOTE))) != 0) );
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
		public TerminalNode WORD() { return getToken(MdParser.WORD, 0); }
		public TerminalNode UNICODE() { return getToken(MdParser.UNICODE, 0); }
		public TerminalNode ENTITY() { return getToken(MdParser.ENTITY, 0); }
		public TerminalNode HTML() { return getToken(MdParser.HTML, 0); }
		public TerminalNode TEX() { return getToken(MdParser.TEX, 0); }
		public TerminalNode MATH() { return getToken(MdParser.MATH, 0); }
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
			setState(297);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LSPAN) | (1L << LDQUOTE) | (1L << LSQUOTE))) != 0)) {
				{
				{
				setState(294);
				attrLeft();
				}
				}
				setState(299);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(300);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << URL) | (1L << UNICODE) | (1L << ENTITY) | (1L << TEX) | (1L << MATH) | (1L << HTML))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(304);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(301);
					attrRight();
					}
					} 
				}
				setState(306);
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
			setState(307);
			match(LSTYLE);
			setState(330); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(330);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CLASS:
					{
					setState(308);
					match(CLASS);
					setState(309);
					match(WORD);
					}
					break;
				case ID:
					{
					setState(310);
					match(ID);
					setState(311);
					match(WORD);
					}
					break;
				case WORD:
					{
					setState(312);
					match(WORD);
					setState(313);
					match(EQ);
					setState(328);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
					case 1:
						{
						setState(315);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==QUOTE) {
							{
							setState(314);
							match(QUOTE);
							}
						}

						setState(317);
						match(WORD);
						setState(319);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==QUOTE) {
							{
							setState(318);
							match(QUOTE);
							}
						}

						}
						break;
					case 2:
						{
						setState(322);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==MARK) {
							{
							setState(321);
							match(MARK);
							}
						}

						setState(324);
						match(WORD);
						setState(326);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==MARK) {
							{
							setState(325);
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
				setState(332); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << CLASS) | (1L << ID))) != 0) );
			setState(334);
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
			setState(336);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LSPAN) | (1L << LDQUOTE) | (1L << LSQUOTE))) != 0)) ) {
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
			setState(338);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RBOLD) | (1L << RITALIC) | (1L << RSTRIKE) | (1L << RSPAN) | (1L << RDQUOTE) | (1L << RSQUOTE))) != 0)) ) {
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
		public TerminalNode HIDN_COMMENT() { return getToken(MdParser.HIDN_COMMENT, 0); }
		public TerminalNode HTML_COMMENT() { return getToken(MdParser.HTML_COMMENT, 0); }
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			_la = _input.LA(1);
			if ( !(_la==HIDN_COMMENT || _la==HTML_COMMENT) ) {
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

	public static class LnBlankContext extends ParserRuleContext {
		public TerminalNode BLANK() { return getToken(MdParser.BLANK, 0); }
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
			setState(342);
			match(BLANK);
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
		public TerminalNode BREAK() { return getToken(MdParser.BREAK, 0); }
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
			setState(344);
			match(BREAK);
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

	public static class IgnoreContext extends ParserRuleContext {
		public List<TerminalNode> ERR() { return getTokens(MdParser.ERR); }
		public TerminalNode ERR(int i) {
			return getToken(MdParser.ERR, i);
		}
		public List<TerminalNode> BLANK() { return getTokens(MdParser.BLANK); }
		public TerminalNode BLANK(int i) {
			return getToken(MdParser.BLANK, i);
		}
		public List<TerminalNode> BREAK() { return getTokens(MdParser.BREAK); }
		public TerminalNode BREAK(int i) {
			return getToken(MdParser.BREAK, i);
		}
		public IgnoreContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ignore; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterIgnore(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitIgnore(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitIgnore(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IgnoreContext ignore() throws RecognitionException {
		IgnoreContext _localctx = new IgnoreContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_ignore);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(347); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(346);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BLANK) | (1L << BREAK) | (1L << ERR))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(349); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3H\u0162\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2M\n\2\f\2\16\2P\13\2\3"+
		"\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\7\b`\n\b\f\b\16"+
		"\bc\13\b\3\b\5\bf\n\b\3\b\7\bi\n\b\f\b\16\bl\13\b\3\b\5\bo\n\b\3\b\6\b"+
		"r\n\b\r\b\16\bs\3\b\7\bw\n\b\f\b\16\bz\13\b\3\b\3\b\3\t\3\t\3\t\7\t\u0081"+
		"\n\t\f\t\16\t\u0084\13\t\3\t\7\t\u0087\n\t\f\t\16\t\u008a\13\t\3\t\5\t"+
		"\u008d\n\t\3\t\3\t\7\t\u0091\n\t\f\t\16\t\u0094\13\t\3\t\5\t\u0097\n\t"+
		"\3\n\3\n\3\n\5\n\u009c\n\n\3\13\3\13\6\13\u00a0\n\13\r\13\16\13\u00a1"+
		"\3\f\3\f\6\f\u00a6\n\f\r\f\16\f\u00a7\3\r\3\r\3\r\3\r\5\r\u00ae\n\r\3"+
		"\16\3\16\3\16\3\16\6\16\u00b4\n\16\r\16\16\16\u00b5\3\17\3\17\3\20\5\20"+
		"\u00bb\n\20\3\20\5\20\u00be\n\20\3\20\3\20\5\20\u00c2\n\20\6\20\u00c4"+
		"\n\20\r\20\16\20\u00c5\3\20\5\20\u00c9\n\20\3\21\3\21\3\22\3\22\3\22\3"+
		"\22\6\22\u00d1\n\22\r\22\16\22\u00d2\3\22\3\22\6\22\u00d7\n\22\r\22\16"+
		"\22\u00d8\3\23\3\23\5\23\u00dd\n\23\3\23\6\23\u00e0\n\23\r\23\16\23\u00e1"+
		"\3\24\3\24\6\24\u00e6\n\24\r\24\16\24\u00e7\3\24\3\24\3\24\6\24\u00ed"+
		"\n\24\r\24\16\24\u00ee\7\24\u00f1\n\24\f\24\16\24\u00f4\13\24\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00fe\n\25\3\25\3\25\5\25\u0102\n"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u010c\n\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\5\25\u0114\n\25\3\25\3\25\3\25\3\25\5\25\u011a\n"+
		"\25\3\25\3\25\3\25\3\25\5\25\u0120\n\25\5\25\u0122\n\25\3\26\6\26\u0125"+
		"\n\26\r\26\16\26\u0126\3\27\7\27\u012a\n\27\f\27\16\27\u012d\13\27\3\27"+
		"\3\27\7\27\u0131\n\27\f\27\16\27\u0134\13\27\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\5\30\u013e\n\30\3\30\3\30\5\30\u0142\n\30\3\30\5\30\u0145"+
		"\n\30\3\30\3\30\5\30\u0149\n\30\5\30\u014b\n\30\6\30\u014d\n\30\r\30\16"+
		"\30\u014e\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35"+
		"\3\36\6\36\u015e\n\36\r\36\16\36\u015f\3\36\2\2\37\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:\2\t\4\2\3\3\63\64\3\2#$\5\2"+
		"\3\3\r\r\32\36\3\2*/\3\2\5\n\3\2\13\f\4\2\61\62\66\66\2\u018a\2N\3\2\2"+
		"\2\4S\3\2\2\2\6U\3\2\2\2\bW\3\2\2\2\nY\3\2\2\2\f[\3\2\2\2\16]\3\2\2\2"+
		"\20\u0096\3\2\2\2\22\u0098\3\2\2\2\24\u009d\3\2\2\2\26\u00a3\3\2\2\2\30"+
		"\u00ad\3\2\2\2\32\u00af\3\2\2\2\34\u00b7\3\2\2\2\36\u00ba\3\2\2\2 \u00ca"+
		"\3\2\2\2\"\u00cc\3\2\2\2$\u00da\3\2\2\2&\u00e5\3\2\2\2(\u0121\3\2\2\2"+
		"*\u0124\3\2\2\2,\u012b\3\2\2\2.\u0135\3\2\2\2\60\u0152\3\2\2\2\62\u0154"+
		"\3\2\2\2\64\u0156\3\2\2\2\66\u0158\3\2\2\28\u015a\3\2\2\2:\u015d\3\2\2"+
		"\2<M\5\16\b\2=M\5\4\3\2>M\5\6\4\2?M\5\b\5\2@M\5\n\6\2AM\5\f\7\2BM\5\20"+
		"\t\2CM\5\22\n\2DM\5\24\13\2EM\5\32\16\2FM\5\"\22\2GM\5$\23\2HM\5\64\33"+
		"\2IM\58\35\2JM\5\66\34\2KM\5:\36\2L<\3\2\2\2L=\3\2\2\2L>\3\2\2\2L?\3\2"+
		"\2\2L@\3\2\2\2LA\3\2\2\2LB\3\2\2\2LC\3\2\2\2LD\3\2\2\2LE\3\2\2\2LF\3\2"+
		"\2\2LG\3\2\2\2LH\3\2\2\2LI\3\2\2\2LJ\3\2\2\2LK\3\2\2\2MP\3\2\2\2NL\3\2"+
		"\2\2NO\3\2\2\2OQ\3\2\2\2PN\3\2\2\2QR\7\2\2\3R\3\3\2\2\2ST\7\25\2\2T\5"+
		"\3\2\2\2UV\7\26\2\2V\7\3\2\2\2WX\7\27\2\2X\t\3\2\2\2YZ\7\30\2\2Z\13\3"+
		"\2\2\2[\\\7\31\2\2\\\r\3\2\2\2]e\7\24\2\2^`\7\64\2\2_^\3\2\2\2`c\3\2\2"+
		"\2a_\3\2\2\2ab\3\2\2\2bd\3\2\2\2ca\3\2\2\2df\7\3\2\2ea\3\2\2\2ef\3\2\2"+
		"\2fn\3\2\2\2gi\7\64\2\2hg\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2km\3\2"+
		"\2\2lj\3\2\2\2mo\5.\30\2nj\3\2\2\2no\3\2\2\2oq\3\2\2\2pr\7\63\2\2qp\3"+
		"\2\2\2rs\3\2\2\2sq\3\2\2\2st\3\2\2\2tx\3\2\2\2uw\t\2\2\2vu\3\2\2\2wz\3"+
		"\2\2\2xv\3\2\2\2xy\3\2\2\2y{\3\2\2\2zx\3\2\2\2{|\7F\2\2|\17\3\2\2\2}~"+
		"\7\61\2\2~\u0082\7\"\2\2\177\u0081\5&\24\2\u0080\177\3\2\2\2\u0081\u0084"+
		"\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0088\3\2\2\2\u0084"+
		"\u0082\3\2\2\2\u0085\u0087\7\67\2\2\u0086\u0085\3\2\2\2\u0087\u008a\3"+
		"\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008c\3\2\2\2\u008a"+
		"\u0088\3\2\2\2\u008b\u008d\5.\30\2\u008c\u008b\3\2\2\2\u008c\u008d\3\2"+
		"\2\2\u008d\u0097\3\2\2\2\u008e\u0092\7\61\2\2\u008f\u0091\5&\24\2\u0090"+
		"\u008f\3\2\2\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2"+
		"\2\2\u0093\u0095\3\2\2\2\u0094\u0092\3\2\2\2\u0095\u0097\t\3\2\2\u0096"+
		"}\3\2\2\2\u0096\u008e\3\2\2\2\u0097\21\3\2\2\2\u0098\u0099\7\61\2\2\u0099"+
		"\u009b\7!\2\2\u009a\u009c\5.\30\2\u009b\u009a\3\2\2\2\u009b\u009c\3\2"+
		"\2\2\u009c\23\3\2\2\2\u009d\u009f\7\61\2\2\u009e\u00a0\5\26\f\2\u009f"+
		"\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2"+
		"\2\2\u00a2\25\3\2\2\2\u00a3\u00a5\5\30\r\2\u00a4\u00a6\5&\24\2\u00a5\u00a4"+
		"\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8"+
		"\27\3\2\2\2\u00a9\u00ae\7&\2\2\u00aa\u00ae\7\'\2\2\u00ab\u00ae\7(\2\2"+
		"\u00ac\u00ae\7)\2\2\u00ad\u00a9\3\2\2\2\u00ad\u00aa\3\2\2\2\u00ad\u00ab"+
		"\3\2\2\2\u00ad\u00ac\3\2\2\2\u00ae\31\3\2\2\2\u00af\u00b0\7\61\2\2\u00b0"+
		"\u00b1\5\36\20\2\u00b1\u00b3\5\34\17\2\u00b2\u00b4\5\36\20\2\u00b3\u00b2"+
		"\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6"+
		"\33\3\2\2\2\u00b7\u00b8\7\37\2\2\u00b8\35\3\2\2\2\u00b9\u00bb\7 \2\2\u00ba"+
		"\u00b9\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bd\3\2\2\2\u00bc\u00be\5 "+
		"\21\2\u00bd\u00bc\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00c3\3\2\2\2\u00bf"+
		"\u00c1\7 \2\2\u00c0\u00c2\5 \21\2\u00c1\u00c0\3\2\2\2\u00c1\u00c2\3\2"+
		"\2\2\u00c2\u00c4\3\2\2\2\u00c3\u00bf\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5"+
		"\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c8\3\2\2\2\u00c7\u00c9\7 "+
		"\2\2\u00c8\u00c7\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\37\3\2\2\2\u00ca\u00cb"+
		"\5&\24\2\u00cb!\3\2\2\2\u00cc\u00d0\7\61\2\2\u00cd\u00ce\5,\27\2\u00ce"+
		"\u00cf\7\62\2\2\u00cf\u00d1\3\2\2\2\u00d0\u00cd\3\2\2\2\u00d1\u00d2\3"+
		"\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d6\3\2\2\2\u00d4"+
		"\u00d5\7%\2\2\u00d5\u00d7\5$\23\2\u00d6\u00d4\3\2\2\2\u00d7\u00d8\3\2"+
		"\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9#\3\2\2\2\u00da\u00df"+
		"\7\61\2\2\u00db\u00dd\7\60\2\2\u00dc\u00db\3\2\2\2\u00dc\u00dd\3\2\2\2"+
		"\u00dd\u00de\3\2\2\2\u00de\u00e0\5&\24\2\u00df\u00dc\3\2\2\2\u00e0\u00e1"+
		"\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2%\3\2\2\2\u00e3"+
		"\u00e6\5,\27\2\u00e4\u00e6\5(\25\2\u00e5\u00e3\3\2\2\2\u00e5\u00e4\3\2"+
		"\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8"+
		"\u00f2\3\2\2\2\u00e9\u00ec\58\35\2\u00ea\u00ed\5,\27\2\u00eb\u00ed\5("+
		"\25\2\u00ec\u00ea\3\2\2\2\u00ec\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee"+
		"\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f1\3\2\2\2\u00f0\u00e9\3\2"+
		"\2\2\u00f1\u00f4\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3"+
		"\'\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f5\u00f6\7\17\2\2\u00f6\u00f7\5*\26"+
		"\2\u00f7\u00f8\7@\2\2\u00f8\u00fd\7\r\2\2\u00f9\u00fa\7=\2\2\u00fa\u00fb"+
		"\5*\26\2\u00fb\u00fc\7=\2\2\u00fc\u00fe\3\2\2\2\u00fd\u00f9\3\2\2\2\u00fd"+
		"\u00fe\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0101\7D\2\2\u0100\u0102\5.\30"+
		"\2\u0101\u0100\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0122\3\2\2\2\u0103\u0104"+
		"\7\20\2\2\u0104\u0105\5*\26\2\u0105\u0106\7B\2\2\u0106\u010b\7\r\2\2\u0107"+
		"\u0108\7.\2\2\u0108\u0109\5*\26\2\u0109\u010a\7\t\2\2\u010a\u010c\3\2"+
		"\2\2\u010b\u0107\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u0122\3\2\2\2\u010d"+
		"\u010e\7\21\2\2\u010e\u010f\5*\26\2\u010f\u0110\7A\2\2\u0110\u0111\5*"+
		"\26\2\u0111\u0113\7C\2\2\u0112\u0114\5.\30\2\u0113\u0112\3\2\2\2\u0113"+
		"\u0114\3\2\2\2\u0114\u0122\3\2\2\2\u0115\u0116\7\22\2\2\u0116\u0117\7"+
		"\r\2\2\u0117\u0119\7C\2\2\u0118\u011a\5.\30\2\u0119\u0118\3\2\2\2\u0119"+
		"\u011a\3\2\2\2\u011a\u0122\3\2\2\2\u011b\u011c\7\23\2\2\u011c\u011d\5"+
		"*\26\2\u011d\u011f\7C\2\2\u011e\u0120\5.\30\2\u011f\u011e\3\2\2\2\u011f"+
		"\u0120\3\2\2\2\u0120\u0122\3\2\2\2\u0121\u00f5\3\2\2\2\u0121\u0103\3\2"+
		"\2\2\u0121\u010d\3\2\2\2\u0121\u0115\3\2\2\2\u0121\u011b\3\2\2\2\u0122"+
		")\3\2\2\2\u0123\u0125\5,\27\2\u0124\u0123\3\2\2\2\u0125\u0126\3\2\2\2"+
		"\u0126\u0124\3\2\2\2\u0126\u0127\3\2\2\2\u0127+\3\2\2\2\u0128\u012a\5"+
		"\60\31\2\u0129\u0128\3\2\2\2\u012a\u012d\3\2\2\2\u012b\u0129\3\2\2\2\u012b"+
		"\u012c\3\2\2\2\u012c\u012e\3\2\2\2\u012d\u012b\3\2\2\2\u012e\u0132\t\4"+
		"\2\2\u012f\u0131\5\62\32\2\u0130\u012f\3\2\2\2\u0131\u0134\3\2\2\2\u0132"+
		"\u0130\3\2\2\2\u0132\u0133\3\2\2\2\u0133-\3\2\2\2\u0134\u0132\3\2\2\2"+
		"\u0135\u014c\7\16\2\2\u0136\u0137\7:\2\2\u0137\u014d\7\3\2\2\u0138\u0139"+
		"\7;\2\2\u0139\u014d\7\3\2\2\u013a\u013b\7\3\2\2\u013b\u014a\7<\2\2\u013c"+
		"\u013e\7=\2\2\u013d\u013c\3\2\2\2\u013d\u013e\3\2\2\2\u013e\u013f\3\2"+
		"\2\2\u013f\u0141\7\3\2\2\u0140\u0142\7=\2\2\u0141\u0140\3\2\2\2\u0141"+
		"\u0142\3\2\2\2\u0142\u014b\3\2\2\2\u0143\u0145\7>\2\2\u0144\u0143\3\2"+
		"\2\2\u0144\u0145\3\2\2\2\u0145\u0146\3\2\2\2\u0146\u0148\7\3\2\2\u0147"+
		"\u0149\7>\2\2\u0148\u0147\3\2\2\2\u0148\u0149\3\2\2\2\u0149\u014b\3\2"+
		"\2\2\u014a\u013d\3\2\2\2\u014a\u0144\3\2\2\2\u014b\u014d\3\2\2\2\u014c"+
		"\u0136\3\2\2\2\u014c\u0138\3\2\2\2\u014c\u013a\3\2\2\2\u014d\u014e\3\2"+
		"\2\2\u014e\u014c\3\2\2\2\u014e\u014f\3\2\2\2\u014f\u0150\3\2\2\2\u0150"+
		"\u0151\79\2\2\u0151/\3\2\2\2\u0152\u0153\t\5\2\2\u0153\61\3\2\2\2\u0154"+
		"\u0155\t\6\2\2\u0155\63\3\2\2\2\u0156\u0157\t\7\2\2\u0157\65\3\2\2\2\u0158"+
		"\u0159\7\61\2\2\u0159\67\3\2\2\2\u015a\u015b\7\62\2\2\u015b9\3\2\2\2\u015c"+
		"\u015e\t\b\2\2\u015d\u015c\3\2\2\2\u015e\u015f\3\2\2\2\u015f\u015d\3\2"+
		"\2\2\u015f\u0160\3\2\2\2\u0160;\3\2\2\2\64LNaejnsx\u0082\u0088\u008c\u0092"+
		"\u0096\u009b\u00a1\u00a7\u00ad\u00b5\u00ba\u00bd\u00c1\u00c5\u00c8\u00d2"+
		"\u00d8\u00dc\u00e1\u00e5\u00e7\u00ec\u00ee\u00f2\u00fd\u0101\u010b\u0113"+
		"\u0119\u011f\u0121\u0126\u012b\u0132\u013d\u0141\u0144\u0148\u014a\u014c"+
		"\u014e\u015f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}