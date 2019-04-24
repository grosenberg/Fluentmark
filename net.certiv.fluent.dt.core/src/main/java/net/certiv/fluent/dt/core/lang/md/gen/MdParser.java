// Generated from D:/DevFiles/Eclipse/Tools/Editors/net.certiv.fluent.dt/net.certiv.fluent.dt.core/src/main/java/net/certiv/fluent/dt/core/lang/md/MdParser.g4 by ANTLR 4.7.2

	package net.certiv.fluent.dt.core.lang.md.gen;
	import net.certiv.fluent.dt.core.lang.md.MdToken;
	import net.certiv.fluent.dt.core.lang.md.MdParserBase;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MdParser extends MdParserBase {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WORD=1, HIDN_COMMENT=2, HTML_COMMENT=3, META=4, TICS=5, TILDES=6, MATH_MARK=7, 
		TEX_BEG=8, UML_BEG=9, LIST_ITEM=10, TABLE_DEF=11, DEFINITION=12, HRULE=13, 
		DASHES=14, DOTS=15, HASHES=16, EQUALS=17, QUOTES=18, UNICODE=19, ENTITY=20, 
		TEX=21, HTML=22, INMATH=23, URL=24, LBOLD=25, LITALIC=26, LSTRIKE=27, 
		LSPAN=28, LDQUOTE=29, LSQUOTE=30, RBOLD=31, RITALIC=32, RSTRIKE=33, RSPAN=34, 
		RDQUOTE=35, RSQUOTE=36, LSTYLE=37, LINK=38, LREF=39, LURL=40, LDEF=41, 
		HASH=42, PIPE=43, LN_BLANK=44, LN_BREAK=45, VWS=46, HWS=47, CHAR=48, ERR=49, 
		RSTYLE=50, CLASS=51, ID=52, EQ=53, QUOTE=54, MARK=55, CHAR_sd=56, LINK_MARK=57, 
		REF_MARK=58, DEF_MARK=59, RBRACK=60, RPAREN=61, CHAR_l=62, WORD_b=63, 
		WORD_t=64, WORD_y=65, WORD_m=66, TEX_END=67, WORD_x=68, UML_END=69, WORD_u=70;
	public static final int
		RULE_page = 0, RULE_metaBlock = 1, RULE_header = 2, RULE_hrule = 3, RULE_list = 4, 
		RULE_listItem = 5, RULE_table = 6, RULE_tableDef = 7, RULE_tableRow = 8, 
		RULE_tableCell = 9, RULE_htmlBlock = 10, RULE_codeBlock = 11, RULE_mathBlock = 12, 
		RULE_texBlock = 13, RULE_umlBlock = 14, RULE_quote = 15, RULE_definition = 16, 
		RULE_paragraph = 17, RULE_content = 18, RULE_text = 19, RULE_line = 20, 
		RULE_lnBlank = 21, RULE_lnBreak = 22, RULE_word = 23, RULE_link = 24, 
		RULE_style = 25, RULE_attrLeft = 26, RULE_attrRight = 27, RULE_comment = 28, 
		RULE_unknown = 29;
	private static String[] makeRuleNames() {
		return new String[] {
			"page", "metaBlock", "header", "hrule", "list", "listItem", "table", 
			"tableDef", "tableRow", "tableCell", "htmlBlock", "codeBlock", "mathBlock", 
			"texBlock", "umlBlock", "quote", "definition", "paragraph", "content", 
			"text", "line", "lnBlank", "lnBreak", "word", "link", "style", "attrLeft", 
			"attrRight", "comment", "unknown"
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
			null, "WORD", "HIDN_COMMENT", "HTML_COMMENT", "META", "TICS", "TILDES", 
			"MATH_MARK", "TEX_BEG", "UML_BEG", "LIST_ITEM", "TABLE_DEF", "DEFINITION", 
			"HRULE", "DASHES", "DOTS", "HASHES", "EQUALS", "QUOTES", "UNICODE", "ENTITY", 
			"TEX", "HTML", "INMATH", "URL", "LBOLD", "LITALIC", "LSTRIKE", "LSPAN", 
			"LDQUOTE", "LSQUOTE", "RBOLD", "RITALIC", "RSTRIKE", "RSPAN", "RDQUOTE", 
			"RSQUOTE", "LSTYLE", "LINK", "LREF", "LURL", "LDEF", "HASH", "PIPE", 
			"LN_BLANK", "LN_BREAK", "VWS", "HWS", "CHAR", "ERR", "RSTYLE", "CLASS", 
			"ID", "EQ", "QUOTE", "MARK", "CHAR_sd", "LINK_MARK", "REF_MARK", "DEF_MARK", 
			"RBRACK", "RPAREN", "CHAR_l", "WORD_b", "WORD_t", "WORD_y", "WORD_m", 
			"TEX_END", "WORD_x", "UML_END", "WORD_u"
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
		public List<MetaBlockContext> metaBlock() {
			return getRuleContexts(MetaBlockContext.class);
		}
		public MetaBlockContext metaBlock(int i) {
			return getRuleContext(MetaBlockContext.class,i);
		}
		public List<CodeBlockContext> codeBlock() {
			return getRuleContexts(CodeBlockContext.class);
		}
		public CodeBlockContext codeBlock(int i) {
			return getRuleContext(CodeBlockContext.class,i);
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
		public List<HtmlBlockContext> htmlBlock() {
			return getRuleContexts(HtmlBlockContext.class);
		}
		public HtmlBlockContext htmlBlock(int i) {
			return getRuleContext(HtmlBlockContext.class,i);
		}
		public List<UmlBlockContext> umlBlock() {
			return getRuleContexts(UmlBlockContext.class);
		}
		public UmlBlockContext umlBlock(int i) {
			return getRuleContext(UmlBlockContext.class,i);
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
		public List<QuoteContext> quote() {
			return getRuleContexts(QuoteContext.class);
		}
		public QuoteContext quote(int i) {
			return getRuleContext(QuoteContext.class,i);
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
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public List<UnknownContext> unknown() {
			return getRuleContexts(UnknownContext.class);
		}
		public UnknownContext unknown(int i) {
			return getRuleContext(UnknownContext.class,i);
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
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << HIDN_COMMENT) | (1L << HTML_COMMENT) | (1L << META) | (1L << TICS) | (1L << TILDES) | (1L << MATH_MARK) | (1L << TEX_BEG) | (1L << UML_BEG) | (1L << HRULE) | (1L << LN_BLANK) | (1L << LN_BREAK) | (1L << ERR))) != 0)) {
				{
				setState(77);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(60);
					metaBlock();
					}
					break;
				case 2:
					{
					setState(61);
					codeBlock();
					}
					break;
				case 3:
					{
					setState(62);
					mathBlock();
					}
					break;
				case 4:
					{
					setState(63);
					texBlock();
					}
					break;
				case 5:
					{
					setState(64);
					htmlBlock();
					}
					break;
				case 6:
					{
					setState(65);
					umlBlock();
					}
					break;
				case 7:
					{
					setState(66);
					list();
					}
					break;
				case 8:
					{
					setState(67);
					table();
					}
					break;
				case 9:
					{
					setState(68);
					quote();
					}
					break;
				case 10:
					{
					setState(69);
					definition();
					}
					break;
				case 11:
					{
					setState(70);
					paragraph();
					}
					break;
				case 12:
					{
					setState(71);
					header();
					}
					break;
				case 13:
					{
					setState(72);
					hrule();
					}
					break;
				case 14:
					{
					setState(73);
					comment();
					}
					break;
				case 15:
					{
					setState(74);
					unknown();
					}
					break;
				case 16:
					{
					setState(75);
					lnBreak();
					}
					break;
				case 17:
					{
					setState(76);
					lnBlank();
					}
					break;
				}
				}
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(82);
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

	public static class MetaBlockContext extends ParserRuleContext {
		public List<TerminalNode> META() { return getTokens(MdParser.META); }
		public TerminalNode META(int i) {
			return getToken(MdParser.META, i);
		}
		public List<TerminalNode> VWS() { return getTokens(MdParser.VWS); }
		public TerminalNode VWS(int i) {
			return getToken(MdParser.VWS, i);
		}
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public MetaBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_metaBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterMetaBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitMetaBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitMetaBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MetaBlockContext metaBlock() throws RecognitionException {
		MetaBlockContext _localctx = new MetaBlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_metaBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(META);
			setState(85);
			match(VWS);
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WORD) {
				{
				{
				setState(86);
				line();
				setState(88); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(87);
					match(VWS);
					}
					}
					setState(90); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==VWS );
				}
				}
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(97);
			match(META);
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode LN_BLANK() { return getToken(MdParser.LN_BLANK, 0); }
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
		enterRule(_localctx, 4, RULE_header);
		int _la;
		try {
			int _alt;
			setState(124);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(99);
				match(LN_BLANK);
				setState(100);
				match(HASHES);
				setState(104);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(101);
						content();
						}
						} 
					}
					setState(106);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				}
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==HASH) {
					{
					{
					setState(107);
					match(HASH);
					}
					}
					setState(112);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LSTYLE) {
					{
					setState(113);
					style();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				match(LN_BLANK);
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << UNICODE) | (1L << ENTITY) | (1L << TEX) | (1L << HTML) | (1L << INMATH) | (1L << URL) | (1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LSPAN) | (1L << LDQUOTE) | (1L << LSQUOTE) | (1L << LINK) | (1L << LREF) | (1L << LURL) | (1L << LDEF) | (1L << LN_BREAK))) != 0)) {
					{
					{
					setState(117);
					content();
					}
					}
					setState(122);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 6, RULE_hrule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(HRULE);
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LSTYLE) {
				{
				setState(127);
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
		public TerminalNode LN_BLANK() { return getToken(MdParser.LN_BLANK, 0); }
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
		enterRule(_localctx, 8, RULE_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(LN_BLANK);
			setState(132); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(131);
					listItem();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(134); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(136);
			if (!( befBL() )) throw new FailedPredicateException(this, " befBL() ");
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode LIST_ITEM() { return getToken(MdParser.LIST_ITEM, 0); }
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
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
		enterRule(_localctx, 10, RULE_listItem);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(LIST_ITEM);
			setState(142);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(139);
					line();
					}
					} 
				}
				setState(144);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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
		public TableRowContext hdr;
		public TableRowContext tableRow;
		public List<TableRowContext> rows = new ArrayList<TableRowContext>();
		public TerminalNode LN_BLANK() { return getToken(MdParser.LN_BLANK, 0); }
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
		enterRule(_localctx, 12, RULE_table);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(LN_BLANK);
			setState(146);
			((TableContext)_localctx).hdr = tableRow();
			setState(147);
			tableDef();
			setState(149); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(148);
					((TableContext)_localctx).tableRow = tableRow();
					((TableContext)_localctx).rows.add(((TableContext)_localctx).tableRow);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(151); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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

	public static class TableDefContext extends ParserRuleContext {
		public TerminalNode TABLE_DEF() { return getToken(MdParser.TABLE_DEF, 0); }
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
		enterRule(_localctx, 14, RULE_tableDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(TABLE_DEF);
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 16, RULE_tableRow);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(155);
				match(PIPE);
				}
				break;
			}
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << UNICODE) | (1L << ENTITY) | (1L << TEX) | (1L << HTML) | (1L << INMATH) | (1L << URL) | (1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LSPAN) | (1L << LDQUOTE) | (1L << LSQUOTE) | (1L << LINK) | (1L << LREF) | (1L << LURL) | (1L << LDEF) | (1L << LN_BREAK))) != 0)) {
				{
				setState(158);
				tableCell();
				}
			}

			setState(165); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(161);
					match(PIPE);
					setState(163);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						setState(162);
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
				setState(167); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(170);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(169);
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
		enterRule(_localctx, 18, RULE_tableCell);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
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

	public static class HtmlBlockContext extends ParserRuleContext {
		public TerminalNode LN_BLANK() { return getToken(MdParser.LN_BLANK, 0); }
		public TerminalNode HTML() { return getToken(MdParser.HTML, 0); }
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
		enterRule(_localctx, 20, RULE_htmlBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(LN_BLANK);
			setState(175);
			match(HTML);
			}
		}
		catch (RecognitionException re) {
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
		public List<TerminalNode> TICS() { return getTokens(MdParser.TICS); }
		public TerminalNode TICS(int i) {
			return getToken(MdParser.TICS, i);
		}
		public TerminalNode WORD() { return getToken(MdParser.WORD, 0); }
		public StyleContext style() {
			return getRuleContext(StyleContext.class,0);
		}
		public List<TerminalNode> VWS() { return getTokens(MdParser.VWS); }
		public TerminalNode VWS(int i) {
			return getToken(MdParser.VWS, i);
		}
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public List<TerminalNode> TILDES() { return getTokens(MdParser.TILDES); }
		public TerminalNode TILDES(int i) {
			return getToken(MdParser.TILDES, i);
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
		enterRule(_localctx, 22, RULE_codeBlock);
		int _la;
		try {
			setState(225);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TICS:
				enterOuterAlt(_localctx, 1);
				{
				setState(177);
				match(TICS);
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WORD) {
					{
					setState(178);
					match(WORD);
					}
				}

				setState(182);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LSTYLE) {
					{
					setState(181);
					style();
					}
				}

				setState(185); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(184);
					match(VWS);
					}
					}
					setState(187); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==VWS );
				setState(197);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WORD) {
					{
					{
					setState(189);
					line();
					setState(191); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(190);
						match(VWS);
						}
						}
						setState(193); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==VWS );
					}
					}
					setState(199);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(200);
				match(TICS);
				}
				break;
			case TILDES:
				enterOuterAlt(_localctx, 2);
				{
				setState(201);
				match(TILDES);
				setState(203);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WORD) {
					{
					setState(202);
					match(WORD);
					}
				}

				setState(206);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LSTYLE) {
					{
					setState(205);
					style();
					}
				}

				setState(209); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(208);
					match(VWS);
					}
					}
					setState(211); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==VWS );
				setState(221);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WORD) {
					{
					{
					setState(213);
					line();
					setState(215); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(214);
						match(VWS);
						}
						}
						setState(217); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==VWS );
					}
					}
					setState(223);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(224);
				match(TILDES);
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

	public static class MathBlockContext extends ParserRuleContext {
		public List<TerminalNode> MATH_MARK() { return getTokens(MdParser.MATH_MARK); }
		public TerminalNode MATH_MARK(int i) {
			return getToken(MdParser.MATH_MARK, i);
		}
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
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
		enterRule(_localctx, 24, RULE_mathBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			match(MATH_MARK);
			setState(231);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WORD) {
				{
				{
				setState(228);
				line();
				}
				}
				setState(233);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(234);
			match(MATH_MARK);
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode TEX_BEG() { return getToken(MdParser.TEX_BEG, 0); }
		public TerminalNode TEX_END() { return getToken(MdParser.TEX_END, 0); }
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
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
		enterRule(_localctx, 26, RULE_texBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			match(TEX_BEG);
			setState(240);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WORD) {
				{
				{
				setState(237);
				line();
				}
				}
				setState(242);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(243);
			match(TEX_END);
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode UML_BEG() { return getToken(MdParser.UML_BEG, 0); }
		public TerminalNode UML_END() { return getToken(MdParser.UML_END, 0); }
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
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
		enterRule(_localctx, 28, RULE_umlBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			match(UML_BEG);
			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WORD) {
				{
				{
				setState(246);
				line();
				}
				}
				setState(251);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(252);
			match(UML_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuoteContext extends ParserRuleContext {
		public TerminalNode LN_BLANK() { return getToken(MdParser.LN_BLANK, 0); }
		public List<TerminalNode> QUOTES() { return getTokens(MdParser.QUOTES); }
		public TerminalNode QUOTES(int i) {
			return getToken(MdParser.QUOTES, i);
		}
		public ParagraphContext paragraph() {
			return getRuleContext(ParagraphContext.class,0);
		}
		public List<ContentContext> content() {
			return getRuleContexts(ContentContext.class);
		}
		public ContentContext content(int i) {
			return getRuleContext(ContentContext.class,i);
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
		enterRule(_localctx, 30, RULE_quote);
		int _la;
		try {
			setState(264);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(254);
				match(LN_BLANK);
				setState(255);
				match(QUOTES);
				setState(256);
				paragraph();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(257);
				match(LN_BLANK);
				setState(260); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(258);
					match(QUOTES);
					setState(259);
					content();
					}
					}
					setState(262); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==QUOTES );
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

	public static class DefinitionContext extends ParserRuleContext {
		public TerminalNode LN_BLANK() { return getToken(MdParser.LN_BLANK, 0); }
		public ContentContext content() {
			return getRuleContext(ContentContext.class,0);
		}
		public List<TerminalNode> DEFINITION() { return getTokens(MdParser.DEFINITION); }
		public TerminalNode DEFINITION(int i) {
			return getToken(MdParser.DEFINITION, i);
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
			setState(266);
			match(LN_BLANK);
			setState(267);
			content();
			setState(270); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(268);
				match(DEFINITION);
				setState(269);
				paragraph();
				}
				}
				setState(272); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DEFINITION );
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode LN_BLANK() { return getToken(MdParser.LN_BLANK, 0); }
		public List<ContentContext> content() {
			return getRuleContexts(ContentContext.class);
		}
		public ContentContext content(int i) {
			return getRuleContext(ContentContext.class,i);
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			match(LN_BLANK);
			setState(276); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(275);
					content();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(278); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
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

	public static class ContentContext extends ParserRuleContext {
		public List<WordContext> word() {
			return getRuleContexts(WordContext.class);
		}
		public WordContext word(int i) {
			return getRuleContext(WordContext.class,i);
		}
		public LinkContext link() {
			return getRuleContext(LinkContext.class,0);
		}
		public LnBreakContext lnBreak() {
			return getRuleContext(LnBreakContext.class,0);
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
			setState(287);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WORD:
			case UNICODE:
			case ENTITY:
			case TEX:
			case HTML:
			case INMATH:
			case URL:
			case LBOLD:
			case LITALIC:
			case LSTRIKE:
			case LSPAN:
			case LDQUOTE:
			case LSQUOTE:
				enterOuterAlt(_localctx, 1);
				{
				setState(281); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(280);
						word();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(283); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case LINK:
			case LREF:
			case LURL:
			case LDEF:
				enterOuterAlt(_localctx, 2);
				{
				setState(285);
				link();
				}
				break;
			case LN_BREAK:
				enterOuterAlt(_localctx, 3);
				{
				setState(286);
				lnBreak();
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
		enterRule(_localctx, 38, RULE_text);
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
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << UNICODE) | (1L << ENTITY) | (1L << TEX) | (1L << HTML) | (1L << INMATH) | (1L << URL) | (1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LSPAN) | (1L << LDQUOTE) | (1L << LSQUOTE))) != 0) );
			}
		}
		catch (RecognitionException re) {
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
		public List<TerminalNode> WORD() { return getTokens(MdParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(MdParser.WORD, i);
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
		enterRule(_localctx, 40, RULE_line);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(295); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(294);
					match(WORD);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(297); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
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

	public static class LnBlankContext extends ParserRuleContext {
		public TerminalNode LN_BLANK() { return getToken(MdParser.LN_BLANK, 0); }
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
		enterRule(_localctx, 42, RULE_lnBlank);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			match(LN_BLANK);
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode LN_BREAK() { return getToken(MdParser.LN_BREAK, 0); }
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
		enterRule(_localctx, 44, RULE_lnBreak);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			match(LN_BREAK);
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode INMATH() { return getToken(MdParser.INMATH, 0); }
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
		enterRule(_localctx, 46, RULE_word);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LSPAN) | (1L << LDQUOTE) | (1L << LSQUOTE))) != 0)) {
				{
				{
				setState(303);
				attrLeft();
				}
				}
				setState(308);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(309);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << UNICODE) | (1L << ENTITY) | (1L << TEX) | (1L << HTML) | (1L << INMATH) | (1L << URL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(313);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(310);
					attrRight();
					}
					} 
				}
				setState(315);
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
		public TerminalNode LREF() { return getToken(MdParser.LREF, 0); }
		public TerminalNode REF_MARK() { return getToken(MdParser.REF_MARK, 0); }
		public TerminalNode RBRACK() { return getToken(MdParser.RBRACK, 0); }
		public TerminalNode LURL() { return getToken(MdParser.LURL, 0); }
		public TerminalNode LDEF() { return getToken(MdParser.LDEF, 0); }
		public TerminalNode DEF_MARK() { return getToken(MdParser.DEF_MARK, 0); }
		public TerminalNode LDQUOTE() { return getToken(MdParser.LDQUOTE, 0); }
		public TerminalNode RDQUOTE() { return getToken(MdParser.RDQUOTE, 0); }
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
		enterRule(_localctx, 48, RULE_link);
		int _la;
		try {
			setState(354);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LINK:
				enterOuterAlt(_localctx, 1);
				{
				setState(316);
				match(LINK);
				setState(317);
				text();
				setState(318);
				match(LINK_MARK);
				setState(319);
				match(URL);
				setState(324);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==QUOTE) {
					{
					setState(320);
					match(QUOTE);
					setState(321);
					text();
					setState(322);
					match(QUOTE);
					}
				}

				setState(326);
				match(RPAREN);
				setState(328);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
				case 1:
					{
					setState(327);
					style();
					}
					break;
				}
				}
				break;
			case LREF:
				enterOuterAlt(_localctx, 2);
				{
				setState(330);
				match(LREF);
				setState(331);
				text();
				setState(332);
				match(REF_MARK);
				setState(333);
				text();
				setState(334);
				match(RBRACK);
				setState(336);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
				case 1:
					{
					setState(335);
					style();
					}
					break;
				}
				}
				break;
			case LURL:
				enterOuterAlt(_localctx, 3);
				{
				setState(338);
				match(LURL);
				setState(339);
				match(URL);
				setState(340);
				match(RBRACK);
				setState(342);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
				case 1:
					{
					setState(341);
					style();
					}
					break;
				}
				}
				break;
			case LDEF:
				enterOuterAlt(_localctx, 4);
				{
				setState(344);
				match(LDEF);
				setState(345);
				text();
				setState(346);
				match(DEF_MARK);
				setState(347);
				match(URL);
				setState(352);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
				case 1:
					{
					setState(348);
					match(LDQUOTE);
					setState(349);
					text();
					setState(350);
					match(RDQUOTE);
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
		enterRule(_localctx, 50, RULE_style);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(356);
			match(LSTYLE);
			setState(379); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(379);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CLASS:
					{
					setState(357);
					match(CLASS);
					setState(358);
					match(WORD);
					}
					break;
				case ID:
					{
					setState(359);
					match(ID);
					setState(360);
					match(WORD);
					}
					break;
				case WORD:
					{
					setState(361);
					match(WORD);
					setState(362);
					match(EQ);
					setState(377);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
					case 1:
						{
						setState(364);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==QUOTE) {
							{
							setState(363);
							match(QUOTE);
							}
						}

						setState(366);
						match(WORD);
						setState(368);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==QUOTE) {
							{
							setState(367);
							match(QUOTE);
							}
						}

						}
						break;
					case 2:
						{
						setState(371);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==MARK) {
							{
							setState(370);
							match(MARK);
							}
						}

						setState(373);
						match(WORD);
						setState(375);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==MARK) {
							{
							setState(374);
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
				setState(381); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << CLASS) | (1L << ID))) != 0) );
			setState(383);
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
		enterRule(_localctx, 52, RULE_attrLeft);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(385);
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
		enterRule(_localctx, 54, RULE_attrRight);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(387);
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
		enterRule(_localctx, 56, RULE_comment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(389);
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

	public static class UnknownContext extends ParserRuleContext {
		public List<TerminalNode> ERR() { return getTokens(MdParser.ERR); }
		public TerminalNode ERR(int i) {
			return getToken(MdParser.ERR, i);
		}
		public UnknownContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unknown; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterUnknown(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitUnknown(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitUnknown(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnknownContext unknown() throws RecognitionException {
		UnknownContext _localctx = new UnknownContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_unknown);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(392); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(391);
					match(ERR);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(394); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return list_sempred((ListContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean list_sempred(ListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return  befBL() ;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3H\u018f\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2P\n\2\f"+
		"\2\16\2S\13\2\3\2\3\2\3\3\3\3\3\3\3\3\6\3[\n\3\r\3\16\3\\\7\3_\n\3\f\3"+
		"\16\3b\13\3\3\3\3\3\3\4\3\4\3\4\7\4i\n\4\f\4\16\4l\13\4\3\4\7\4o\n\4\f"+
		"\4\16\4r\13\4\3\4\5\4u\n\4\3\4\3\4\7\4y\n\4\f\4\16\4|\13\4\3\4\5\4\177"+
		"\n\4\3\5\3\5\5\5\u0083\n\5\3\6\3\6\6\6\u0087\n\6\r\6\16\6\u0088\3\6\3"+
		"\6\3\7\3\7\7\7\u008f\n\7\f\7\16\7\u0092\13\7\3\b\3\b\3\b\3\b\6\b\u0098"+
		"\n\b\r\b\16\b\u0099\3\t\3\t\3\n\5\n\u009f\n\n\3\n\5\n\u00a2\n\n\3\n\3"+
		"\n\5\n\u00a6\n\n\6\n\u00a8\n\n\r\n\16\n\u00a9\3\n\5\n\u00ad\n\n\3\13\3"+
		"\13\3\f\3\f\3\f\3\r\3\r\5\r\u00b6\n\r\3\r\5\r\u00b9\n\r\3\r\6\r\u00bc"+
		"\n\r\r\r\16\r\u00bd\3\r\3\r\6\r\u00c2\n\r\r\r\16\r\u00c3\7\r\u00c6\n\r"+
		"\f\r\16\r\u00c9\13\r\3\r\3\r\3\r\5\r\u00ce\n\r\3\r\5\r\u00d1\n\r\3\r\6"+
		"\r\u00d4\n\r\r\r\16\r\u00d5\3\r\3\r\6\r\u00da\n\r\r\r\16\r\u00db\7\r\u00de"+
		"\n\r\f\r\16\r\u00e1\13\r\3\r\5\r\u00e4\n\r\3\16\3\16\7\16\u00e8\n\16\f"+
		"\16\16\16\u00eb\13\16\3\16\3\16\3\17\3\17\7\17\u00f1\n\17\f\17\16\17\u00f4"+
		"\13\17\3\17\3\17\3\20\3\20\7\20\u00fa\n\20\f\20\16\20\u00fd\13\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\3\21\3\21\6\21\u0107\n\21\r\21\16\21\u0108\5"+
		"\21\u010b\n\21\3\22\3\22\3\22\3\22\6\22\u0111\n\22\r\22\16\22\u0112\3"+
		"\23\3\23\6\23\u0117\n\23\r\23\16\23\u0118\3\24\6\24\u011c\n\24\r\24\16"+
		"\24\u011d\3\24\3\24\5\24\u0122\n\24\3\25\6\25\u0125\n\25\r\25\16\25\u0126"+
		"\3\26\6\26\u012a\n\26\r\26\16\26\u012b\3\27\3\27\3\30\3\30\3\31\7\31\u0133"+
		"\n\31\f\31\16\31\u0136\13\31\3\31\3\31\7\31\u013a\n\31\f\31\16\31\u013d"+
		"\13\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u0147\n\32\3\32\3"+
		"\32\5\32\u014b\n\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u0153\n\32\3\32"+
		"\3\32\3\32\3\32\5\32\u0159\n\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\5\32\u0163\n\32\5\32\u0165\n\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3"+
		"\33\5\33\u016f\n\33\3\33\3\33\5\33\u0173\n\33\3\33\5\33\u0176\n\33\3\33"+
		"\3\33\5\33\u017a\n\33\5\33\u017c\n\33\6\33\u017e\n\33\r\33\16\33\u017f"+
		"\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\6\37\u018b\n\37\r\37\16"+
		"\37\u018c\3\37\2\2 \2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\64\668:<\2\7\4\2\20\20\23\23\4\2\3\3\25\32\3\2\33 \3\2!&\3\2\4\5\2"+
		"\u01bb\2Q\3\2\2\2\4V\3\2\2\2\6~\3\2\2\2\b\u0080\3\2\2\2\n\u0084\3\2\2"+
		"\2\f\u008c\3\2\2\2\16\u0093\3\2\2\2\20\u009b\3\2\2\2\22\u009e\3\2\2\2"+
		"\24\u00ae\3\2\2\2\26\u00b0\3\2\2\2\30\u00e3\3\2\2\2\32\u00e5\3\2\2\2\34"+
		"\u00ee\3\2\2\2\36\u00f7\3\2\2\2 \u010a\3\2\2\2\"\u010c\3\2\2\2$\u0114"+
		"\3\2\2\2&\u0121\3\2\2\2(\u0124\3\2\2\2*\u0129\3\2\2\2,\u012d\3\2\2\2."+
		"\u012f\3\2\2\2\60\u0134\3\2\2\2\62\u0164\3\2\2\2\64\u0166\3\2\2\2\66\u0183"+
		"\3\2\2\28\u0185\3\2\2\2:\u0187\3\2\2\2<\u018a\3\2\2\2>P\5\4\3\2?P\5\30"+
		"\r\2@P\5\32\16\2AP\5\34\17\2BP\5\26\f\2CP\5\36\20\2DP\5\n\6\2EP\5\16\b"+
		"\2FP\5 \21\2GP\5\"\22\2HP\5$\23\2IP\5\6\4\2JP\5\b\5\2KP\5:\36\2LP\5<\37"+
		"\2MP\5.\30\2NP\5,\27\2O>\3\2\2\2O?\3\2\2\2O@\3\2\2\2OA\3\2\2\2OB\3\2\2"+
		"\2OC\3\2\2\2OD\3\2\2\2OE\3\2\2\2OF\3\2\2\2OG\3\2\2\2OH\3\2\2\2OI\3\2\2"+
		"\2OJ\3\2\2\2OK\3\2\2\2OL\3\2\2\2OM\3\2\2\2ON\3\2\2\2PS\3\2\2\2QO\3\2\2"+
		"\2QR\3\2\2\2RT\3\2\2\2SQ\3\2\2\2TU\7\2\2\3U\3\3\2\2\2VW\7\6\2\2W`\7\60"+
		"\2\2XZ\5*\26\2Y[\7\60\2\2ZY\3\2\2\2[\\\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]"+
		"_\3\2\2\2^X\3\2\2\2_b\3\2\2\2`^\3\2\2\2`a\3\2\2\2ac\3\2\2\2b`\3\2\2\2"+
		"cd\7\6\2\2d\5\3\2\2\2ef\7.\2\2fj\7\22\2\2gi\5&\24\2hg\3\2\2\2il\3\2\2"+
		"\2jh\3\2\2\2jk\3\2\2\2kp\3\2\2\2lj\3\2\2\2mo\7,\2\2nm\3\2\2\2or\3\2\2"+
		"\2pn\3\2\2\2pq\3\2\2\2qt\3\2\2\2rp\3\2\2\2su\5\64\33\2ts\3\2\2\2tu\3\2"+
		"\2\2u\177\3\2\2\2vz\7.\2\2wy\5&\24\2xw\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3"+
		"\2\2\2{}\3\2\2\2|z\3\2\2\2}\177\t\2\2\2~e\3\2\2\2~v\3\2\2\2\177\7\3\2"+
		"\2\2\u0080\u0082\7\17\2\2\u0081\u0083\5\64\33\2\u0082\u0081\3\2\2\2\u0082"+
		"\u0083\3\2\2\2\u0083\t\3\2\2\2\u0084\u0086\7.\2\2\u0085\u0087\5\f\7\2"+
		"\u0086\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089"+
		"\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008b\6\6\2\2\u008b\13\3\2\2\2\u008c"+
		"\u0090\7\f\2\2\u008d\u008f\5*\26\2\u008e\u008d\3\2\2\2\u008f\u0092\3\2"+
		"\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\r\3\2\2\2\u0092\u0090"+
		"\3\2\2\2\u0093\u0094\7.\2\2\u0094\u0095\5\22\n\2\u0095\u0097\5\20\t\2"+
		"\u0096\u0098\5\22\n\2\u0097\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u0097"+
		"\3\2\2\2\u0099\u009a\3\2\2\2\u009a\17\3\2\2\2\u009b\u009c\7\r\2\2\u009c"+
		"\21\3\2\2\2\u009d\u009f\7-\2\2\u009e\u009d\3\2\2\2\u009e\u009f\3\2\2\2"+
		"\u009f\u00a1\3\2\2\2\u00a0\u00a2\5\24\13\2\u00a1\u00a0\3\2\2\2\u00a1\u00a2"+
		"\3\2\2\2\u00a2\u00a7\3\2\2\2\u00a3\u00a5\7-\2\2\u00a4\u00a6\5\24\13\2"+
		"\u00a5\u00a4\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a8\3\2\2\2\u00a7\u00a3"+
		"\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa"+
		"\u00ac\3\2\2\2\u00ab\u00ad\7-\2\2\u00ac\u00ab\3\2\2\2\u00ac\u00ad\3\2"+
		"\2\2\u00ad\23\3\2\2\2\u00ae\u00af\5&\24\2\u00af\25\3\2\2\2\u00b0\u00b1"+
		"\7.\2\2\u00b1\u00b2\7\30\2\2\u00b2\27\3\2\2\2\u00b3\u00b5\7\7\2\2\u00b4"+
		"\u00b6\7\3\2\2\u00b5\u00b4\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b8\3\2"+
		"\2\2\u00b7\u00b9\5\64\33\2\u00b8\u00b7\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9"+
		"\u00bb\3\2\2\2\u00ba\u00bc\7\60\2\2\u00bb\u00ba\3\2\2\2\u00bc\u00bd\3"+
		"\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00c7\3\2\2\2\u00bf"+
		"\u00c1\5*\26\2\u00c0\u00c2\7\60\2\2\u00c1\u00c0\3\2\2\2\u00c2\u00c3\3"+
		"\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c6\3\2\2\2\u00c5"+
		"\u00bf\3\2\2\2\u00c6\u00c9\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2"+
		"\2\2\u00c8\u00ca\3\2\2\2\u00c9\u00c7\3\2\2\2\u00ca\u00e4\7\7\2\2\u00cb"+
		"\u00cd\7\b\2\2\u00cc\u00ce\7\3\2\2\u00cd\u00cc\3\2\2\2\u00cd\u00ce\3\2"+
		"\2\2\u00ce\u00d0\3\2\2\2\u00cf\u00d1\5\64\33\2\u00d0\u00cf\3\2\2\2\u00d0"+
		"\u00d1\3\2\2\2\u00d1\u00d3\3\2\2\2\u00d2\u00d4\7\60\2\2\u00d3\u00d2\3"+
		"\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6"+
		"\u00df\3\2\2\2\u00d7\u00d9\5*\26\2\u00d8\u00da\7\60\2\2\u00d9\u00d8\3"+
		"\2\2\2\u00da\u00db\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc"+
		"\u00de\3\2\2\2\u00dd\u00d7\3\2\2\2\u00de\u00e1\3\2\2\2\u00df\u00dd\3\2"+
		"\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e2\3\2\2\2\u00e1\u00df\3\2\2\2\u00e2"+
		"\u00e4\7\b\2\2\u00e3\u00b3\3\2\2\2\u00e3\u00cb\3\2\2\2\u00e4\31\3\2\2"+
		"\2\u00e5\u00e9\7\t\2\2\u00e6\u00e8\5*\26\2\u00e7\u00e6\3\2\2\2\u00e8\u00eb"+
		"\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00ec\3\2\2\2\u00eb"+
		"\u00e9\3\2\2\2\u00ec\u00ed\7\t\2\2\u00ed\33\3\2\2\2\u00ee\u00f2\7\n\2"+
		"\2\u00ef\u00f1\5*\26\2\u00f0\u00ef\3\2\2\2\u00f1\u00f4\3\2\2\2\u00f2\u00f0"+
		"\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f5\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f5"+
		"\u00f6\7E\2\2\u00f6\35\3\2\2\2\u00f7\u00fb\7\13\2\2\u00f8\u00fa\5*\26"+
		"\2\u00f9\u00f8\3\2\2\2\u00fa\u00fd\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fb\u00fc"+
		"\3\2\2\2\u00fc\u00fe\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fe\u00ff\7G\2\2\u00ff"+
		"\37\3\2\2\2\u0100\u0101\7.\2\2\u0101\u0102\7\24\2\2\u0102\u010b\5$\23"+
		"\2\u0103\u0106\7.\2\2\u0104\u0105\7\24\2\2\u0105\u0107\5&\24\2\u0106\u0104"+
		"\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u0106\3\2\2\2\u0108\u0109\3\2\2\2\u0109"+
		"\u010b\3\2\2\2\u010a\u0100\3\2\2\2\u010a\u0103\3\2\2\2\u010b!\3\2\2\2"+
		"\u010c\u010d\7.\2\2\u010d\u0110\5&\24\2\u010e\u010f\7\16\2\2\u010f\u0111"+
		"\5$\23\2\u0110\u010e\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0110\3\2\2\2\u0112"+
		"\u0113\3\2\2\2\u0113#\3\2\2\2\u0114\u0116\7.\2\2\u0115\u0117\5&\24\2\u0116"+
		"\u0115\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u0116\3\2\2\2\u0118\u0119\3\2"+
		"\2\2\u0119%\3\2\2\2\u011a\u011c\5\60\31\2\u011b\u011a\3\2\2\2\u011c\u011d"+
		"\3\2\2\2\u011d\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u0122\3\2\2\2\u011f"+
		"\u0122\5\62\32\2\u0120\u0122\5.\30\2\u0121\u011b\3\2\2\2\u0121\u011f\3"+
		"\2\2\2\u0121\u0120\3\2\2\2\u0122\'\3\2\2\2\u0123\u0125\5\60\31\2\u0124"+
		"\u0123\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0124\3\2\2\2\u0126\u0127\3\2"+
		"\2\2\u0127)\3\2\2\2\u0128\u012a\7\3\2\2\u0129\u0128\3\2\2\2\u012a\u012b"+
		"\3\2\2\2\u012b\u0129\3\2\2\2\u012b\u012c\3\2\2\2\u012c+\3\2\2\2\u012d"+
		"\u012e\7.\2\2\u012e-\3\2\2\2\u012f\u0130\7/\2\2\u0130/\3\2\2\2\u0131\u0133"+
		"\5\66\34\2\u0132\u0131\3\2\2\2\u0133\u0136\3\2\2\2\u0134\u0132\3\2\2\2"+
		"\u0134\u0135\3\2\2\2\u0135\u0137\3\2\2\2\u0136\u0134\3\2\2\2\u0137\u013b"+
		"\t\3\2\2\u0138\u013a\58\35\2\u0139\u0138\3\2\2\2\u013a\u013d\3\2\2\2\u013b"+
		"\u0139\3\2\2\2\u013b\u013c\3\2\2\2\u013c\61\3\2\2\2\u013d\u013b\3\2\2"+
		"\2\u013e\u013f\7(\2\2\u013f\u0140\5(\25\2\u0140\u0141\7;\2\2\u0141\u0146"+
		"\7\32\2\2\u0142\u0143\78\2\2\u0143\u0144\5(\25\2\u0144\u0145\78\2\2\u0145"+
		"\u0147\3\2\2\2\u0146\u0142\3\2\2\2\u0146\u0147\3\2\2\2\u0147\u0148\3\2"+
		"\2\2\u0148\u014a\7?\2\2\u0149\u014b\5\64\33\2\u014a\u0149\3\2\2\2\u014a"+
		"\u014b\3\2\2\2\u014b\u0165\3\2\2\2\u014c\u014d\7)\2\2\u014d\u014e\5(\25"+
		"\2\u014e\u014f\7<\2\2\u014f\u0150\5(\25\2\u0150\u0152\7>\2\2\u0151\u0153"+
		"\5\64\33\2\u0152\u0151\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0165\3\2\2\2"+
		"\u0154\u0155\7*\2\2\u0155\u0156\7\32\2\2\u0156\u0158\7>\2\2\u0157\u0159"+
		"\5\64\33\2\u0158\u0157\3\2\2\2\u0158\u0159\3\2\2\2\u0159\u0165\3\2\2\2"+
		"\u015a\u015b\7+\2\2\u015b\u015c\5(\25\2\u015c\u015d\7=\2\2\u015d\u0162"+
		"\7\32\2\2\u015e\u015f\7\37\2\2\u015f\u0160\5(\25\2\u0160\u0161\7%\2\2"+
		"\u0161\u0163\3\2\2\2\u0162\u015e\3\2\2\2\u0162\u0163\3\2\2\2\u0163\u0165"+
		"\3\2\2\2\u0164\u013e\3\2\2\2\u0164\u014c\3\2\2\2\u0164\u0154\3\2\2\2\u0164"+
		"\u015a\3\2\2\2\u0165\63\3\2\2\2\u0166\u017d\7\'\2\2\u0167\u0168\7\65\2"+
		"\2\u0168\u017e\7\3\2\2\u0169\u016a\7\66\2\2\u016a\u017e\7\3\2\2\u016b"+
		"\u016c\7\3\2\2\u016c\u017b\7\67\2\2\u016d\u016f\78\2\2\u016e\u016d\3\2"+
		"\2\2\u016e\u016f\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u0172\7\3\2\2\u0171"+
		"\u0173\78\2\2\u0172\u0171\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u017c\3\2"+
		"\2\2\u0174\u0176\79\2\2\u0175\u0174\3\2\2\2\u0175\u0176\3\2\2\2\u0176"+
		"\u0177\3\2\2\2\u0177\u0179\7\3\2\2\u0178\u017a\79\2\2\u0179\u0178\3\2"+
		"\2\2\u0179\u017a\3\2\2\2\u017a\u017c\3\2\2\2\u017b\u016e\3\2\2\2\u017b"+
		"\u0175\3\2\2\2\u017c\u017e\3\2\2\2\u017d\u0167\3\2\2\2\u017d\u0169\3\2"+
		"\2\2\u017d\u016b\3\2\2\2\u017e\u017f\3\2\2\2\u017f\u017d\3\2\2\2\u017f"+
		"\u0180\3\2\2\2\u0180\u0181\3\2\2\2\u0181\u0182\7\64\2\2\u0182\65\3\2\2"+
		"\2\u0183\u0184\t\4\2\2\u0184\67\3\2\2\2\u0185\u0186\t\5\2\2\u01869\3\2"+
		"\2\2\u0187\u0188\t\6\2\2\u0188;\3\2\2\2\u0189\u018b\7\63\2\2\u018a\u0189"+
		"\3\2\2\2\u018b\u018c\3\2\2\2\u018c\u018a\3\2\2\2\u018c\u018d\3\2\2\2\u018d"+
		"=\3\2\2\2:OQ\\`jptz~\u0082\u0088\u0090\u0099\u009e\u00a1\u00a5\u00a9\u00ac"+
		"\u00b5\u00b8\u00bd\u00c3\u00c7\u00cd\u00d0\u00d5\u00db\u00df\u00e3\u00e9"+
		"\u00f2\u00fb\u0108\u010a\u0112\u0118\u011d\u0121\u0126\u012b\u0134\u013b"+
		"\u0146\u014a\u0152\u0158\u0162\u0164\u016e\u0172\u0175\u0179\u017b\u017d"+
		"\u017f\u018c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}