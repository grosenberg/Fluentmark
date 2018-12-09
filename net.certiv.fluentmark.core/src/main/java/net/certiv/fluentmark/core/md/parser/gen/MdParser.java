// Generated from D:/DevFiles/Eclipse/DslEditors/net.certiv.fluentmark/net.certiv.fluentmark.core/src/main/java/net/certiv/fluentmark/core/md/parser/MdParser.g4 by ANTLR 4.7.1

	package net.certiv.fluentmark.core.md.parser.gen;
	import net.certiv.fluentmark.core.md.parser.MdToken;

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
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WORD=1, LINE=2, IMAGE=3, LINK=4, LINK_REF=5, INVS_COMMENT=6, HTML_COMMENT=7, 
		FRONT_MATTER=8, CODE_BLOCK_BT=9, CODE_BLOCK_TD=10, MATH_BLOCK=11, TEX_BEG=12, 
		HEADER=13, SEMARK=14, LIST_ITEM=15, QUOTE_BLOCK=16, DEFINE_BLOCK=17, HRULE=18, 
		TABLE_DEF=19, PIPE=20, UNICODE=21, ENTITY=22, TEX=23, HTML=24, INMATH=25, 
		URL=26, LBOLD=27, LITALIC=28, LSTRIKE=29, LSPAN=30, LQUOTE=31, LAPSTP=32, 
		RBOLD=33, RITALIC=34, RSTRIKE=35, RSPAN=36, RQUOTE=37, RAPSTP=38, REF=39, 
		TERM=40, LBRK=41, VWS=42, HWS=43, CHAR=44, ERR=45, LBRACE=46, HASH=47, 
		CHAR_ht=48, RBRACE=49, CLASS=50, ID=51, EQ=52, QUOTE=53, APSTP=54, CHAR_sd=55, 
		LINK_DEF=56, REF_DEF=57, RBRACK=58, RPAREN=59, CHAR_lk=60, CHAR_fm=61, 
		CHAR_bt=62, CHAR_btl=63, CHAR_td=64, CHAR_tdl=65, CHAR_mb=66, TEX_END=67, 
		CHAR_tb=68;
	public static final int
		RULE_page = 0, RULE_frontMatter = 1, RULE_header = 2, RULE_hrule = 3, 
		RULE_list = 4, RULE_listItem = 5, RULE_table = 6, RULE_tableDef = 7, RULE_tableRow = 8, 
		RULE_tableCell = 9, RULE_html = 10, RULE_codeBlock = 11, RULE_mathBlock = 12, 
		RULE_texBlock = 13, RULE_quote = 14, RULE_definition = 15, RULE_paragraph = 16, 
		RULE_link = 17, RULE_text = 18, RULE_word = 19, RULE_style = 20, RULE_attrLeft = 21, 
		RULE_attrRight = 22, RULE_content = 23, RULE_terminal = 24, RULE_comment = 25, 
		RULE_unknown = 26;
	public static final String[] ruleNames = {
		"page", "frontMatter", "header", "hrule", "list", "listItem", "table", 
		"tableDef", "tableRow", "tableCell", "html", "codeBlock", "mathBlock", 
		"texBlock", "quote", "definition", "paragraph", "link", "text", "word", 
		"style", "attrLeft", "attrRight", "content", "terminal", "comment", "unknown"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "WORD", "LINE", "IMAGE", "LINK", "LINK_REF", "INVS_COMMENT", "HTML_COMMENT", 
		"FRONT_MATTER", "CODE_BLOCK_BT", "CODE_BLOCK_TD", "MATH_BLOCK", "TEX_BEG", 
		"HEADER", "SEMARK", "LIST_ITEM", "QUOTE_BLOCK", "DEFINE_BLOCK", "HRULE", 
		"TABLE_DEF", "PIPE", "UNICODE", "ENTITY", "TEX", "HTML", "INMATH", "URL", 
		"LBOLD", "LITALIC", "LSTRIKE", "LSPAN", "LQUOTE", "LAPSTP", "RBOLD", "RITALIC", 
		"RSTRIKE", "RSPAN", "RQUOTE", "RAPSTP", "REF", "TERM", "LBRK", "VWS", 
		"HWS", "CHAR", "ERR", "LBRACE", "HASH", "CHAR_ht", "RBRACE", "CLASS", 
		"ID", "EQ", "QUOTE", "APSTP", "CHAR_sd", "LINK_DEF", "REF_DEF", "RBRACK", 
		"RPAREN", "CHAR_lk", "CHAR_fm", "CHAR_bt", "CHAR_btl", "CHAR_td", "CHAR_tdl", 
		"CHAR_mb", "TEX_END", "CHAR_tb"
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
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public FrontMatterContext frontMatter() {
			return getRuleContext(FrontMatterContext.class,0);
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
		public List<HtmlContext> html() {
			return getRuleContexts(HtmlContext.class);
		}
		public HtmlContext html(int i) {
			return getRuleContext(HtmlContext.class,i);
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
		public List<TerminalContext> terminal() {
			return getRuleContexts(TerminalContext.class);
		}
		public TerminalContext terminal(int i) {
			return getRuleContext(TerminalContext.class,i);
		}
		public List<ParagraphContext> paragraph() {
			return getRuleContexts(ParagraphContext.class);
		}
		public ParagraphContext paragraph(int i) {
			return getRuleContext(ParagraphContext.class,i);
		}
		public List<UnknownContext> unknown() {
			return getRuleContexts(UnknownContext.class);
		}
		public UnknownContext unknown(int i) {
			return getRuleContext(UnknownContext.class,i);
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(54);
				comment();
				}
				break;
			}
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FRONT_MATTER) {
				{
				setState(57);
				frontMatter();
				}
			}

			setState(76);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					setState(74);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						setState(60);
						header();
						}
						break;
					case 2:
						{
						setState(61);
						hrule();
						}
						break;
					case 3:
						{
						setState(62);
						list();
						}
						break;
					case 4:
						{
						setState(63);
						table();
						}
						break;
					case 5:
						{
						setState(64);
						html();
						}
						break;
					case 6:
						{
						setState(65);
						codeBlock();
						}
						break;
					case 7:
						{
						setState(66);
						mathBlock();
						}
						break;
					case 8:
						{
						setState(67);
						texBlock();
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
						terminal();
						}
						break;
					case 12:
						{
						setState(71);
						paragraph();
						}
						break;
					case 13:
						{
						setState(72);
						comment();
						}
						break;
					case 14:
						{
						setState(73);
						unknown();
						}
						break;
					}
					} 
				}
				setState(78);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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

	public static class FrontMatterContext extends ParserRuleContext {
		public List<TerminalNode> FRONT_MATTER() { return getTokens(MdParser.FRONT_MATTER); }
		public TerminalNode FRONT_MATTER(int i) {
			return getToken(MdParser.FRONT_MATTER, i);
		}
		public ContentContext content() {
			return getRuleContext(ContentContext.class,0);
		}
		public FrontMatterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_frontMatter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterFrontMatter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitFrontMatter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitFrontMatter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FrontMatterContext frontMatter() throws RecognitionException {
		FrontMatterContext _localctx = new FrontMatterContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_frontMatter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(FRONT_MATTER);
			setState(82);
			content();
			setState(83);
			match(FRONT_MATTER);
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode HEADER() { return getToken(MdParser.HEADER, 0); }
		public TerminalContext terminal() {
			return getRuleContext(TerminalContext.class,0);
		}
		public List<TextContext> text() {
			return getRuleContexts(TextContext.class);
		}
		public TextContext text(int i) {
			return getRuleContext(TextContext.class,i);
		}
		public List<LinkContext> link() {
			return getRuleContexts(LinkContext.class);
		}
		public LinkContext link(int i) {
			return getRuleContext(LinkContext.class,i);
		}
		public List<TerminalNode> HASH() { return getTokens(MdParser.HASH); }
		public TerminalNode HASH(int i) {
			return getToken(MdParser.HASH, i);
		}
		public StyleContext style() {
			return getRuleContext(StyleContext.class,0);
		}
		public TerminalNode SEMARK() { return getToken(MdParser.SEMARK, 0); }
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
			setState(112);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HEADER:
				enterOuterAlt(_localctx, 1);
				{
				setState(85);
				match(HEADER);
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << IMAGE) | (1L << LINK) | (1L << UNICODE) | (1L << ENTITY) | (1L << TEX) | (1L << HTML) | (1L << INMATH) | (1L << URL) | (1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LSPAN) | (1L << LQUOTE) | (1L << LAPSTP) | (1L << REF))) != 0)) {
					{
					setState(88);
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
					case LQUOTE:
					case LAPSTP:
						{
						setState(86);
						text();
						}
						break;
					case IMAGE:
					case LINK:
					case REF:
						{
						setState(87);
						link();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(92);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==HASH) {
					{
					{
					setState(93);
					match(HASH);
					}
					}
					setState(98);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACE) {
					{
					setState(99);
					style();
					}
				}

				setState(102);
				terminal();
				}
				break;
			case WORD:
			case IMAGE:
			case LINK:
			case SEMARK:
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
			case LQUOTE:
			case LAPSTP:
			case REF:
				enterOuterAlt(_localctx, 2);
				{
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << IMAGE) | (1L << LINK) | (1L << UNICODE) | (1L << ENTITY) | (1L << TEX) | (1L << HTML) | (1L << INMATH) | (1L << URL) | (1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LSPAN) | (1L << LQUOTE) | (1L << LAPSTP) | (1L << REF))) != 0)) {
					{
					setState(105);
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
					case LQUOTE:
					case LAPSTP:
						{
						setState(103);
						text();
						}
						break;
					case IMAGE:
					case LINK:
					case REF:
						{
						setState(104);
						link();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(109);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(110);
				match(SEMARK);
				setState(111);
				terminal();
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
		public TerminalContext terminal() {
			return getRuleContext(TerminalContext.class,0);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(HRULE);
			setState(115);
			terminal();
			}
		}
		catch (RecognitionException re) {
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
		public TerminalContext terminal() {
			return getRuleContext(TerminalContext.class,0);
		}
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(117);
				listItem();
				}
				}
				setState(120); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==LIST_ITEM );
			setState(122);
			terminal();
			}
		}
		catch (RecognitionException re) {
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
		public List<TextContext> text() {
			return getRuleContexts(TextContext.class);
		}
		public TextContext text(int i) {
			return getRuleContext(TextContext.class,i);
		}
		public List<LinkContext> link() {
			return getRuleContexts(LinkContext.class);
		}
		public LinkContext link(int i) {
			return getRuleContext(LinkContext.class,i);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(LIST_ITEM);
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << IMAGE) | (1L << LINK) | (1L << UNICODE) | (1L << ENTITY) | (1L << TEX) | (1L << HTML) | (1L << INMATH) | (1L << URL) | (1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LSPAN) | (1L << LQUOTE) | (1L << LAPSTP) | (1L << REF))) != 0)) {
				{
				setState(127);
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
				case LQUOTE:
				case LAPSTP:
					{
					setState(125);
					text();
					}
					break;
				case IMAGE:
				case LINK:
				case REF:
					{
					setState(126);
					link();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(131);
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

	public static class TableContext extends ParserRuleContext {
		public TableRowContext hdr;
		public TableRowContext tableRow;
		public List<TableRowContext> rows = new ArrayList<TableRowContext>();
		public TableDefContext tableDef() {
			return getRuleContext(TableDefContext.class,0);
		}
		public TerminalContext terminal() {
			return getRuleContext(TerminalContext.class,0);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			((TableContext)_localctx).hdr = tableRow();
			setState(133);
			tableDef();
			setState(135); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(134);
				((TableContext)_localctx).tableRow = tableRow();
				((TableContext)_localctx).rows.add(((TableContext)_localctx).tableRow);
				}
				}
				setState(137); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << IMAGE) | (1L << LINK) | (1L << PIPE) | (1L << UNICODE) | (1L << ENTITY) | (1L << TEX) | (1L << HTML) | (1L << INMATH) | (1L << URL) | (1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LSPAN) | (1L << LQUOTE) | (1L << LAPSTP) | (1L << REF))) != 0) );
			setState(139);
			terminal();
			}
		}
		catch (RecognitionException re) {
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
			setState(141);
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
		public List<TableCellContext> tableCell() {
			return getRuleContexts(TableCellContext.class);
		}
		public TableCellContext tableCell(int i) {
			return getRuleContext(TableCellContext.class,i);
		}
		public List<TerminalNode> PIPE() { return getTokens(MdParser.PIPE); }
		public TerminalNode PIPE(int i) {
			return getToken(MdParser.PIPE, i);
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(143);
				match(PIPE);
				}
				break;
			}
			setState(146);
			tableCell();
			setState(149); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(147);
					match(PIPE);
					setState(148);
					tableCell();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(151); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(154);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(153);
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
		public List<TextContext> text() {
			return getRuleContexts(TextContext.class);
		}
		public TextContext text(int i) {
			return getRuleContext(TextContext.class,i);
		}
		public List<LinkContext> link() {
			return getRuleContexts(LinkContext.class);
		}
		public LinkContext link(int i) {
			return getRuleContext(LinkContext.class,i);
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(158);
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
					case LQUOTE:
					case LAPSTP:
						{
						setState(156);
						text();
						}
						break;
					case IMAGE:
					case LINK:
					case REF:
						{
						setState(157);
						link();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(162);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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

	public static class HtmlContext extends ParserRuleContext {
		public TerminalNode HTML() { return getToken(MdParser.HTML, 0); }
		public TerminalContext terminal() {
			return getRuleContext(TerminalContext.class,0);
		}
		public HtmlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_html; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterHtml(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitHtml(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitHtml(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlContext html() throws RecognitionException {
		HtmlContext _localctx = new HtmlContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_html);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(HTML);
			setState(164);
			terminal();
			}
		}
		catch (RecognitionException re) {
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
		public List<TerminalNode> CODE_BLOCK_BT() { return getTokens(MdParser.CODE_BLOCK_BT); }
		public TerminalNode CODE_BLOCK_BT(int i) {
			return getToken(MdParser.CODE_BLOCK_BT, i);
		}
		public ContentContext content() {
			return getRuleContext(ContentContext.class,0);
		}
		public List<TerminalNode> WORD() { return getTokens(MdParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(MdParser.WORD, i);
		}
		public StyleContext style() {
			return getRuleContext(StyleContext.class,0);
		}
		public List<TerminalNode> CODE_BLOCK_TD() { return getTokens(MdParser.CODE_BLOCK_TD); }
		public TerminalNode CODE_BLOCK_TD(int i) {
			return getToken(MdParser.CODE_BLOCK_TD, i);
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
			setState(192);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CODE_BLOCK_BT:
				enterOuterAlt(_localctx, 1);
				{
				setState(166);
				match(CODE_BLOCK_BT);
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WORD) {
					{
					{
					setState(167);
					match(WORD);
					}
					}
					setState(172);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(174);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACE) {
					{
					setState(173);
					style();
					}
				}

				setState(176);
				content();
				setState(177);
				match(CODE_BLOCK_BT);
				}
				break;
			case CODE_BLOCK_TD:
				enterOuterAlt(_localctx, 2);
				{
				setState(179);
				match(CODE_BLOCK_TD);
				setState(183);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WORD) {
					{
					{
					setState(180);
					match(WORD);
					}
					}
					setState(185);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(187);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACE) {
					{
					setState(186);
					style();
					}
				}

				setState(189);
				content();
				setState(190);
				match(CODE_BLOCK_TD);
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
		public List<TerminalNode> MATH_BLOCK() { return getTokens(MdParser.MATH_BLOCK); }
		public TerminalNode MATH_BLOCK(int i) {
			return getToken(MdParser.MATH_BLOCK, i);
		}
		public ContentContext content() {
			return getRuleContext(ContentContext.class,0);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			match(MATH_BLOCK);
			setState(195);
			content();
			setState(196);
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
		public TerminalNode TEX_BEG() { return getToken(MdParser.TEX_BEG, 0); }
		public ContentContext content() {
			return getRuleContext(ContentContext.class,0);
		}
		public TerminalNode TEX_END() { return getToken(MdParser.TEX_END, 0); }
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(TEX_BEG);
			setState(199);
			content();
			setState(200);
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

	public static class QuoteContext extends ParserRuleContext {
		public TerminalNode QUOTE_BLOCK() { return getToken(MdParser.QUOTE_BLOCK, 0); }
		public TerminalContext terminal() {
			return getRuleContext(TerminalContext.class,0);
		}
		public List<TextContext> text() {
			return getRuleContexts(TextContext.class);
		}
		public TextContext text(int i) {
			return getRuleContext(TextContext.class,i);
		}
		public List<LinkContext> link() {
			return getRuleContexts(LinkContext.class);
		}
		public LinkContext link(int i) {
			return getRuleContext(LinkContext.class,i);
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
		enterRule(_localctx, 28, RULE_quote);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			match(QUOTE_BLOCK);
			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << IMAGE) | (1L << LINK) | (1L << UNICODE) | (1L << ENTITY) | (1L << TEX) | (1L << HTML) | (1L << INMATH) | (1L << URL) | (1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LSPAN) | (1L << LQUOTE) | (1L << LAPSTP) | (1L << REF))) != 0)) {
				{
				setState(205);
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
				case LQUOTE:
				case LAPSTP:
					{
					setState(203);
					text();
					}
					break;
				case IMAGE:
				case LINK:
				case REF:
					{
					setState(204);
					link();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(209);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(210);
			terminal();
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode DEFINE_BLOCK() { return getToken(MdParser.DEFINE_BLOCK, 0); }
		public TerminalContext terminal() {
			return getRuleContext(TerminalContext.class,0);
		}
		public List<TextContext> text() {
			return getRuleContexts(TextContext.class);
		}
		public TextContext text(int i) {
			return getRuleContext(TextContext.class,i);
		}
		public List<LinkContext> link() {
			return getRuleContexts(LinkContext.class);
		}
		public LinkContext link(int i) {
			return getRuleContext(LinkContext.class,i);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(214);
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
				case LQUOTE:
				case LAPSTP:
					{
					setState(212);
					text();
					}
					break;
				case IMAGE:
				case LINK:
				case REF:
					{
					setState(213);
					link();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(216); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << IMAGE) | (1L << LINK) | (1L << UNICODE) | (1L << ENTITY) | (1L << TEX) | (1L << HTML) | (1L << INMATH) | (1L << URL) | (1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LSPAN) | (1L << LQUOTE) | (1L << LAPSTP) | (1L << REF))) != 0) );
			setState(218);
			match(DEFINE_BLOCK);
			setState(223);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << IMAGE) | (1L << LINK) | (1L << UNICODE) | (1L << ENTITY) | (1L << TEX) | (1L << HTML) | (1L << INMATH) | (1L << URL) | (1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LSPAN) | (1L << LQUOTE) | (1L << LAPSTP) | (1L << REF))) != 0)) {
				{
				setState(221);
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
				case LQUOTE:
				case LAPSTP:
					{
					setState(219);
					text();
					}
					break;
				case IMAGE:
				case LINK:
				case REF:
					{
					setState(220);
					link();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(225);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(226);
			terminal();
			}
		}
		catch (RecognitionException re) {
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
		public TerminalContext terminal() {
			return getRuleContext(TerminalContext.class,0);
		}
		public List<TextContext> text() {
			return getRuleContexts(TextContext.class);
		}
		public TextContext text(int i) {
			return getRuleContext(TextContext.class,i);
		}
		public List<LinkContext> link() {
			return getRuleContexts(LinkContext.class);
		}
		public LinkContext link(int i) {
			return getRuleContext(LinkContext.class,i);
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
		enterRule(_localctx, 32, RULE_paragraph);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(230);
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
				case LQUOTE:
				case LAPSTP:
					{
					setState(228);
					text();
					}
					break;
				case IMAGE:
				case LINK:
				case REF:
					{
					setState(229);
					link();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(232); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << IMAGE) | (1L << LINK) | (1L << UNICODE) | (1L << ENTITY) | (1L << TEX) | (1L << HTML) | (1L << INMATH) | (1L << URL) | (1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LSPAN) | (1L << LQUOTE) | (1L << LAPSTP) | (1L << REF))) != 0) );
			setState(234);
			terminal();
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode LINK_DEF() { return getToken(MdParser.LINK_DEF, 0); }
		public TerminalNode RPAREN() { return getToken(MdParser.RPAREN, 0); }
		public TerminalNode IMAGE() { return getToken(MdParser.IMAGE, 0); }
		public List<TextContext> text() {
			return getRuleContexts(TextContext.class);
		}
		public TextContext text(int i) {
			return getRuleContext(TextContext.class,i);
		}
		public List<TerminalNode> QUOTE() { return getTokens(MdParser.QUOTE); }
		public TerminalNode QUOTE(int i) {
			return getToken(MdParser.QUOTE, i);
		}
		public StyleContext style() {
			return getRuleContext(StyleContext.class,0);
		}
		public TerminalNode LINK_REF() { return getToken(MdParser.LINK_REF, 0); }
		public TerminalNode RBRACK() { return getToken(MdParser.RBRACK, 0); }
		public TerminalNode REF() { return getToken(MdParser.REF, 0); }
		public TerminalNode REF_DEF() { return getToken(MdParser.REF_DEF, 0); }
		public TerminalNode URL() { return getToken(MdParser.URL, 0); }
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
			setState(294);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(237);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IMAGE) {
					{
					setState(236);
					match(IMAGE);
					}
				}

				setState(239);
				match(LINK);
				setState(241);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << UNICODE) | (1L << ENTITY) | (1L << TEX) | (1L << HTML) | (1L << INMATH) | (1L << URL) | (1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LSPAN) | (1L << LQUOTE) | (1L << LAPSTP))) != 0)) {
					{
					setState(240);
					text();
					}
				}

				setState(243);
				match(LINK_DEF);
				setState(245);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << UNICODE) | (1L << ENTITY) | (1L << TEX) | (1L << HTML) | (1L << INMATH) | (1L << URL) | (1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LSPAN) | (1L << LQUOTE) | (1L << LAPSTP))) != 0)) {
					{
					setState(244);
					text();
					}
				}

				setState(252);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==QUOTE) {
					{
					setState(247);
					match(QUOTE);
					setState(249);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << UNICODE) | (1L << ENTITY) | (1L << TEX) | (1L << HTML) | (1L << INMATH) | (1L << URL) | (1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LSPAN) | (1L << LQUOTE) | (1L << LAPSTP))) != 0)) {
						{
						setState(248);
						text();
						}
					}

					setState(251);
					match(QUOTE);
					}
				}

				setState(254);
				match(RPAREN);
				setState(256);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
				case 1:
					{
					setState(255);
					style();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(259);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IMAGE) {
					{
					setState(258);
					match(IMAGE);
					}
				}

				setState(261);
				match(LINK);
				setState(263);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << UNICODE) | (1L << ENTITY) | (1L << TEX) | (1L << HTML) | (1L << INMATH) | (1L << URL) | (1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LSPAN) | (1L << LQUOTE) | (1L << LAPSTP))) != 0)) {
					{
					setState(262);
					text();
					}
				}

				setState(265);
				match(LINK_REF);
				setState(267);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << UNICODE) | (1L << ENTITY) | (1L << TEX) | (1L << HTML) | (1L << INMATH) | (1L << URL) | (1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LSPAN) | (1L << LQUOTE) | (1L << LAPSTP))) != 0)) {
					{
					setState(266);
					text();
					}
				}

				setState(269);
				match(RBRACK);
				setState(271);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
				case 1:
					{
					setState(270);
					style();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(273);
				match(LINK);
				setState(275);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << UNICODE) | (1L << ENTITY) | (1L << TEX) | (1L << HTML) | (1L << INMATH) | (1L << URL) | (1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LSPAN) | (1L << LQUOTE) | (1L << LAPSTP))) != 0)) {
					{
					setState(274);
					text();
					}
				}

				setState(277);
				match(RBRACK);
				setState(279);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
				case 1:
					{
					setState(278);
					style();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(281);
				match(REF);
				setState(283);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << UNICODE) | (1L << ENTITY) | (1L << TEX) | (1L << HTML) | (1L << INMATH) | (1L << URL) | (1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LSPAN) | (1L << LQUOTE) | (1L << LAPSTP))) != 0)) {
					{
					setState(282);
					text();
					}
				}

				setState(285);
				match(REF_DEF);
				setState(286);
				match(URL);
				setState(292);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==QUOTE) {
					{
					setState(287);
					match(QUOTE);
					setState(289);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << UNICODE) | (1L << ENTITY) | (1L << TEX) | (1L << HTML) | (1L << INMATH) | (1L << URL) | (1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LSPAN) | (1L << LQUOTE) | (1L << LAPSTP))) != 0)) {
						{
						setState(288);
						text();
						}
					}

					setState(291);
					match(QUOTE);
					}
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
		enterRule(_localctx, 36, RULE_text);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(297); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(296);
					word();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(299); 
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
		enterRule(_localctx, 38, RULE_word);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LSPAN) | (1L << LQUOTE) | (1L << LAPSTP))) != 0)) {
				{
				{
				setState(301);
				attrLeft();
				}
				}
				setState(306);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(307);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << UNICODE) | (1L << ENTITY) | (1L << TEX) | (1L << HTML) | (1L << INMATH) | (1L << URL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(311);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RBOLD) | (1L << RITALIC) | (1L << RSTRIKE) | (1L << RSPAN) | (1L << RQUOTE) | (1L << RAPSTP))) != 0)) {
				{
				{
				setState(308);
				attrRight();
				}
				}
				setState(313);
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

	public static class StyleContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(MdParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(MdParser.RBRACE, 0); }
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
		public List<TerminalNode> APSTP() { return getTokens(MdParser.APSTP); }
		public TerminalNode APSTP(int i) {
			return getToken(MdParser.APSTP, i);
		}
		public List<TerminalNode> QUOTE() { return getTokens(MdParser.QUOTE); }
		public TerminalNode QUOTE(int i) {
			return getToken(MdParser.QUOTE, i);
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
		enterRule(_localctx, 40, RULE_style);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			match(LBRACE);
			setState(345);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WORD) | (1L << CLASS) | (1L << ID))) != 0)) {
				{
				setState(343);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CLASS:
					{
					setState(315);
					match(CLASS);
					setState(316);
					match(WORD);
					}
					break;
				case ID:
					{
					setState(317);
					match(ID);
					setState(318);
					match(WORD);
					}
					break;
				case WORD:
					{
					setState(319);
					match(WORD);
					setState(320);
					match(EQ);
					setState(341);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case WORD:
					case RBRACE:
					case CLASS:
					case ID:
					case QUOTE:
						{
						setState(322);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
						case 1:
							{
							setState(321);
							match(QUOTE);
							}
							break;
						}
						setState(327);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(324);
								match(WORD);
								}
								} 
							}
							setState(329);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
						}
						setState(331);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==QUOTE) {
							{
							setState(330);
							match(QUOTE);
							}
						}

						}
						break;
					case APSTP:
						{
						setState(333);
						match(APSTP);
						setState(337);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==WORD) {
							{
							{
							setState(334);
							match(WORD);
							}
							}
							setState(339);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(340);
						match(APSTP);
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
				setState(347);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(348);
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

	public static class AttrLeftContext extends ParserRuleContext {
		public TerminalNode LBOLD() { return getToken(MdParser.LBOLD, 0); }
		public TerminalNode LITALIC() { return getToken(MdParser.LITALIC, 0); }
		public TerminalNode LSTRIKE() { return getToken(MdParser.LSTRIKE, 0); }
		public TerminalNode LSPAN() { return getToken(MdParser.LSPAN, 0); }
		public TerminalNode LQUOTE() { return getToken(MdParser.LQUOTE, 0); }
		public TerminalNode LAPSTP() { return getToken(MdParser.LAPSTP, 0); }
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
		enterRule(_localctx, 42, RULE_attrLeft);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(350);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LBOLD) | (1L << LITALIC) | (1L << LSTRIKE) | (1L << LSPAN) | (1L << LQUOTE) | (1L << LAPSTP))) != 0)) ) {
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
		public TerminalNode RQUOTE() { return getToken(MdParser.RQUOTE, 0); }
		public TerminalNode RAPSTP() { return getToken(MdParser.RAPSTP, 0); }
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
		enterRule(_localctx, 44, RULE_attrRight);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(352);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RBOLD) | (1L << RITALIC) | (1L << RSTRIKE) | (1L << RSPAN) | (1L << RQUOTE) | (1L << RAPSTP))) != 0)) ) {
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

	public static class ContentContext extends ParserRuleContext {
		public List<TerminalNode> LINE() { return getTokens(MdParser.LINE); }
		public TerminalNode LINE(int i) {
			return getToken(MdParser.LINE, i);
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
		enterRule(_localctx, 46, RULE_content);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(357);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LINE) {
				{
				{
				setState(354);
				match(LINE);
				}
				}
				setState(359);
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

	public static class TerminalContext extends ParserRuleContext {
		public TerminalNode TERM() { return getToken(MdParser.TERM, 0); }
		public TerminalNode EOF() { return getToken(MdParser.EOF, 0); }
		public TerminalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_terminal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).enterTerminal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MdParserListener ) ((MdParserListener)listener).exitTerminal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MdParserVisitor ) return ((MdParserVisitor<? extends T>)visitor).visitTerminal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TerminalContext terminal() throws RecognitionException {
		TerminalContext _localctx = new TerminalContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_terminal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(360);
			_la = _input.LA(1);
			if ( !(_la==EOF || _la==TERM) ) {
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
		public TerminalNode INVS_COMMENT() { return getToken(MdParser.INVS_COMMENT, 0); }
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
			setState(362);
			_la = _input.LA(1);
			if ( !(_la==INVS_COMMENT || _la==HTML_COMMENT) ) {
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
		enterRule(_localctx, 52, RULE_unknown);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(365); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(364);
					match(ERR);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(367); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3F\u0174\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\3\2\5\2:\n\2\3\2\5\2=\n\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2M\n\2\f\2\16\2P\13\2\3\2"+
		"\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\7\4[\n\4\f\4\16\4^\13\4\3\4\7\4a\n\4"+
		"\f\4\16\4d\13\4\3\4\5\4g\n\4\3\4\3\4\3\4\7\4l\n\4\f\4\16\4o\13\4\3\4\3"+
		"\4\5\4s\n\4\3\5\3\5\3\5\3\6\6\6y\n\6\r\6\16\6z\3\6\3\6\3\7\3\7\3\7\7\7"+
		"\u0082\n\7\f\7\16\7\u0085\13\7\3\b\3\b\3\b\6\b\u008a\n\b\r\b\16\b\u008b"+
		"\3\b\3\b\3\t\3\t\3\n\5\n\u0093\n\n\3\n\3\n\3\n\6\n\u0098\n\n\r\n\16\n"+
		"\u0099\3\n\5\n\u009d\n\n\3\13\3\13\7\13\u00a1\n\13\f\13\16\13\u00a4\13"+
		"\13\3\f\3\f\3\f\3\r\3\r\7\r\u00ab\n\r\f\r\16\r\u00ae\13\r\3\r\5\r\u00b1"+
		"\n\r\3\r\3\r\3\r\3\r\3\r\7\r\u00b8\n\r\f\r\16\r\u00bb\13\r\3\r\5\r\u00be"+
		"\n\r\3\r\3\r\3\r\5\r\u00c3\n\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17"+
		"\3\20\3\20\3\20\7\20\u00d0\n\20\f\20\16\20\u00d3\13\20\3\20\3\20\3\21"+
		"\3\21\6\21\u00d9\n\21\r\21\16\21\u00da\3\21\3\21\3\21\7\21\u00e0\n\21"+
		"\f\21\16\21\u00e3\13\21\3\21\3\21\3\22\3\22\6\22\u00e9\n\22\r\22\16\22"+
		"\u00ea\3\22\3\22\3\23\5\23\u00f0\n\23\3\23\3\23\5\23\u00f4\n\23\3\23\3"+
		"\23\5\23\u00f8\n\23\3\23\3\23\5\23\u00fc\n\23\3\23\5\23\u00ff\n\23\3\23"+
		"\3\23\5\23\u0103\n\23\3\23\5\23\u0106\n\23\3\23\3\23\5\23\u010a\n\23\3"+
		"\23\3\23\5\23\u010e\n\23\3\23\3\23\5\23\u0112\n\23\3\23\3\23\5\23\u0116"+
		"\n\23\3\23\3\23\5\23\u011a\n\23\3\23\3\23\5\23\u011e\n\23\3\23\3\23\3"+
		"\23\3\23\5\23\u0124\n\23\3\23\5\23\u0127\n\23\5\23\u0129\n\23\3\24\6\24"+
		"\u012c\n\24\r\24\16\24\u012d\3\25\7\25\u0131\n\25\f\25\16\25\u0134\13"+
		"\25\3\25\3\25\7\25\u0138\n\25\f\25\16\25\u013b\13\25\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\5\26\u0145\n\26\3\26\7\26\u0148\n\26\f\26\16\26"+
		"\u014b\13\26\3\26\5\26\u014e\n\26\3\26\3\26\7\26\u0152\n\26\f\26\16\26"+
		"\u0155\13\26\3\26\5\26\u0158\n\26\7\26\u015a\n\26\f\26\16\26\u015d\13"+
		"\26\3\26\3\26\3\27\3\27\3\30\3\30\3\31\7\31\u0166\n\31\f\31\16\31\u0169"+
		"\13\31\3\32\3\32\3\33\3\33\3\34\6\34\u0170\n\34\r\34\16\34\u0171\3\34"+
		"\3N\2\35\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\66\2"+
		"\7\4\2\3\3\27\34\3\2\35\"\3\2#(\3\3**\3\2\b\t\2\u01a4\29\3\2\2\2\4S\3"+
		"\2\2\2\6r\3\2\2\2\bt\3\2\2\2\nx\3\2\2\2\f~\3\2\2\2\16\u0086\3\2\2\2\20"+
		"\u008f\3\2\2\2\22\u0092\3\2\2\2\24\u00a2\3\2\2\2\26\u00a5\3\2\2\2\30\u00c2"+
		"\3\2\2\2\32\u00c4\3\2\2\2\34\u00c8\3\2\2\2\36\u00cc\3\2\2\2 \u00d8\3\2"+
		"\2\2\"\u00e8\3\2\2\2$\u0128\3\2\2\2&\u012b\3\2\2\2(\u0132\3\2\2\2*\u013c"+
		"\3\2\2\2,\u0160\3\2\2\2.\u0162\3\2\2\2\60\u0167\3\2\2\2\62\u016a\3\2\2"+
		"\2\64\u016c\3\2\2\2\66\u016f\3\2\2\28:\5\64\33\298\3\2\2\29:\3\2\2\2:"+
		"<\3\2\2\2;=\5\4\3\2<;\3\2\2\2<=\3\2\2\2=N\3\2\2\2>M\5\6\4\2?M\5\b\5\2"+
		"@M\5\n\6\2AM\5\16\b\2BM\5\26\f\2CM\5\30\r\2DM\5\32\16\2EM\5\34\17\2FM"+
		"\5\36\20\2GM\5 \21\2HM\5\62\32\2IM\5\"\22\2JM\5\64\33\2KM\5\66\34\2L>"+
		"\3\2\2\2L?\3\2\2\2L@\3\2\2\2LA\3\2\2\2LB\3\2\2\2LC\3\2\2\2LD\3\2\2\2L"+
		"E\3\2\2\2LF\3\2\2\2LG\3\2\2\2LH\3\2\2\2LI\3\2\2\2LJ\3\2\2\2LK\3\2\2\2"+
		"MP\3\2\2\2NO\3\2\2\2NL\3\2\2\2OQ\3\2\2\2PN\3\2\2\2QR\7\2\2\3R\3\3\2\2"+
		"\2ST\7\n\2\2TU\5\60\31\2UV\7\n\2\2V\5\3\2\2\2W\\\7\17\2\2X[\5&\24\2Y["+
		"\5$\23\2ZX\3\2\2\2ZY\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]b\3\2\2\2"+
		"^\\\3\2\2\2_a\7\61\2\2`_\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2cf\3\2\2"+
		"\2db\3\2\2\2eg\5*\26\2fe\3\2\2\2fg\3\2\2\2gh\3\2\2\2hs\5\62\32\2il\5&"+
		"\24\2jl\5$\23\2ki\3\2\2\2kj\3\2\2\2lo\3\2\2\2mk\3\2\2\2mn\3\2\2\2np\3"+
		"\2\2\2om\3\2\2\2pq\7\20\2\2qs\5\62\32\2rW\3\2\2\2rm\3\2\2\2s\7\3\2\2\2"+
		"tu\7\24\2\2uv\5\62\32\2v\t\3\2\2\2wy\5\f\7\2xw\3\2\2\2yz\3\2\2\2zx\3\2"+
		"\2\2z{\3\2\2\2{|\3\2\2\2|}\5\62\32\2}\13\3\2\2\2~\u0083\7\21\2\2\177\u0082"+
		"\5&\24\2\u0080\u0082\5$\23\2\u0081\177\3\2\2\2\u0081\u0080\3\2\2\2\u0082"+
		"\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\r\3\2\2\2"+
		"\u0085\u0083\3\2\2\2\u0086\u0087\5\22\n\2\u0087\u0089\5\20\t\2\u0088\u008a"+
		"\5\22\n\2\u0089\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u0089\3\2\2\2"+
		"\u008b\u008c\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e\5\62\32\2\u008e\17"+
		"\3\2\2\2\u008f\u0090\7\25\2\2\u0090\21\3\2\2\2\u0091\u0093\7\26\2\2\u0092"+
		"\u0091\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0097\5\24"+
		"\13\2\u0095\u0096\7\26\2\2\u0096\u0098\5\24\13\2\u0097\u0095\3\2\2\2\u0098"+
		"\u0099\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009c\3\2"+
		"\2\2\u009b\u009d\7\26\2\2\u009c\u009b\3\2\2\2\u009c\u009d\3\2\2\2\u009d"+
		"\23\3\2\2\2\u009e\u00a1\5&\24\2\u009f\u00a1\5$\23\2\u00a0\u009e\3\2\2"+
		"\2\u00a0\u009f\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3"+
		"\3\2\2\2\u00a3\25\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5\u00a6\7\32\2\2\u00a6"+
		"\u00a7\5\62\32\2\u00a7\27\3\2\2\2\u00a8\u00ac\7\13\2\2\u00a9\u00ab\7\3"+
		"\2\2\u00aa\u00a9\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac"+
		"\u00ad\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00b1\5*"+
		"\26\2\u00b0\u00af\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2"+
		"\u00b3\5\60\31\2\u00b3\u00b4\7\13\2\2\u00b4\u00c3\3\2\2\2\u00b5\u00b9"+
		"\7\f\2\2\u00b6\u00b8\7\3\2\2\u00b7\u00b6\3\2\2\2\u00b8\u00bb\3\2\2\2\u00b9"+
		"\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb\u00b9\3\2"+
		"\2\2\u00bc\u00be\5*\26\2\u00bd\u00bc\3\2\2\2\u00bd\u00be\3\2\2\2\u00be"+
		"\u00bf\3\2\2\2\u00bf\u00c0\5\60\31\2\u00c0\u00c1\7\f\2\2\u00c1\u00c3\3"+
		"\2\2\2\u00c2\u00a8\3\2\2\2\u00c2\u00b5\3\2\2\2\u00c3\31\3\2\2\2\u00c4"+
		"\u00c5\7\r\2\2\u00c5\u00c6\5\60\31\2\u00c6\u00c7\7\r\2\2\u00c7\33\3\2"+
		"\2\2\u00c8\u00c9\7\16\2\2\u00c9\u00ca\5\60\31\2\u00ca\u00cb\7E\2\2\u00cb"+
		"\35\3\2\2\2\u00cc\u00d1\7\22\2\2\u00cd\u00d0\5&\24\2\u00ce\u00d0\5$\23"+
		"\2\u00cf\u00cd\3\2\2\2\u00cf\u00ce\3\2\2\2\u00d0\u00d3\3\2\2\2\u00d1\u00cf"+
		"\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d4\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d4"+
		"\u00d5\5\62\32\2\u00d5\37\3\2\2\2\u00d6\u00d9\5&\24\2\u00d7\u00d9\5$\23"+
		"\2\u00d8\u00d6\3\2\2\2\u00d8\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00d8"+
		"\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00e1\7\23\2\2"+
		"\u00dd\u00e0\5&\24\2\u00de\u00e0\5$\23\2\u00df\u00dd\3\2\2\2\u00df\u00de"+
		"\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2"+
		"\u00e4\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e4\u00e5\5\62\32\2\u00e5!\3\2\2"+
		"\2\u00e6\u00e9\5&\24\2\u00e7\u00e9\5$\23\2\u00e8\u00e6\3\2\2\2\u00e8\u00e7"+
		"\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb"+
		"\u00ec\3\2\2\2\u00ec\u00ed\5\62\32\2\u00ed#\3\2\2\2\u00ee\u00f0\7\5\2"+
		"\2\u00ef\u00ee\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f3"+
		"\7\6\2\2\u00f2\u00f4\5&\24\2\u00f3\u00f2\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4"+
		"\u00f5\3\2\2\2\u00f5\u00f7\7:\2\2\u00f6\u00f8\5&\24\2\u00f7\u00f6\3\2"+
		"\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00fe\3\2\2\2\u00f9\u00fb\7\67\2\2\u00fa"+
		"\u00fc\5&\24\2\u00fb\u00fa\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fd\3\2"+
		"\2\2\u00fd\u00ff\7\67\2\2\u00fe\u00f9\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff"+
		"\u0100\3\2\2\2\u0100\u0102\7=\2\2\u0101\u0103\5*\26\2\u0102\u0101\3\2"+
		"\2\2\u0102\u0103\3\2\2\2\u0103\u0129\3\2\2\2\u0104\u0106\7\5\2\2\u0105"+
		"\u0104\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0109\7\6"+
		"\2\2\u0108\u010a\5&\24\2\u0109\u0108\3\2\2\2\u0109\u010a\3\2\2\2\u010a"+
		"\u010b\3\2\2\2\u010b\u010d\7\7\2\2\u010c\u010e\5&\24\2\u010d\u010c\3\2"+
		"\2\2\u010d\u010e\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0111\7<\2\2\u0110"+
		"\u0112\5*\26\2\u0111\u0110\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0129\3\2"+
		"\2\2\u0113\u0115\7\6\2\2\u0114\u0116\5&\24\2\u0115\u0114\3\2\2\2\u0115"+
		"\u0116\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0119\7<\2\2\u0118\u011a\5*\26"+
		"\2\u0119\u0118\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u0129\3\2\2\2\u011b\u011d"+
		"\7)\2\2\u011c\u011e\5&\24\2\u011d\u011c\3\2\2\2\u011d\u011e\3\2\2\2\u011e"+
		"\u011f\3\2\2\2\u011f\u0120\7;\2\2\u0120\u0126\7\34\2\2\u0121\u0123\7\67"+
		"\2\2\u0122\u0124\5&\24\2\u0123\u0122\3\2\2\2\u0123\u0124\3\2\2\2\u0124"+
		"\u0125\3\2\2\2\u0125\u0127\7\67\2\2\u0126\u0121\3\2\2\2\u0126\u0127\3"+
		"\2\2\2\u0127\u0129\3\2\2\2\u0128\u00ef\3\2\2\2\u0128\u0105\3\2\2\2\u0128"+
		"\u0113\3\2\2\2\u0128\u011b\3\2\2\2\u0129%\3\2\2\2\u012a\u012c\5(\25\2"+
		"\u012b\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012d\u012b\3\2\2\2\u012d\u012e"+
		"\3\2\2\2\u012e\'\3\2\2\2\u012f\u0131\5,\27\2\u0130\u012f\3\2\2\2\u0131"+
		"\u0134\3\2\2\2\u0132\u0130\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0135\3\2"+
		"\2\2\u0134\u0132\3\2\2\2\u0135\u0139\t\2\2\2\u0136\u0138\5.\30\2\u0137"+
		"\u0136\3\2\2\2\u0138\u013b\3\2\2\2\u0139\u0137\3\2\2\2\u0139\u013a\3\2"+
		"\2\2\u013a)\3\2\2\2\u013b\u0139\3\2\2\2\u013c\u015b\7\60\2\2\u013d\u013e"+
		"\7\64\2\2\u013e\u015a\7\3\2\2\u013f\u0140\7\65\2\2\u0140\u015a\7\3\2\2"+
		"\u0141\u0142\7\3\2\2\u0142\u0157\7\66\2\2\u0143\u0145\7\67\2\2\u0144\u0143"+
		"\3\2\2\2\u0144\u0145\3\2\2\2\u0145\u0149\3\2\2\2\u0146\u0148\7\3\2\2\u0147"+
		"\u0146\3\2\2\2\u0148\u014b\3\2\2\2\u0149\u0147\3\2\2\2\u0149\u014a\3\2"+
		"\2\2\u014a\u014d\3\2\2\2\u014b\u0149\3\2\2\2\u014c\u014e\7\67\2\2\u014d"+
		"\u014c\3\2\2\2\u014d\u014e\3\2\2\2\u014e\u0158\3\2\2\2\u014f\u0153\78"+
		"\2\2\u0150\u0152\7\3\2\2\u0151\u0150\3\2\2\2\u0152\u0155\3\2\2\2\u0153"+
		"\u0151\3\2\2\2\u0153\u0154\3\2\2\2\u0154\u0156\3\2\2\2\u0155\u0153\3\2"+
		"\2\2\u0156\u0158\78\2\2\u0157\u0144\3\2\2\2\u0157\u014f\3\2\2\2\u0158"+
		"\u015a\3\2\2\2\u0159\u013d\3\2\2\2\u0159\u013f\3\2\2\2\u0159\u0141\3\2"+
		"\2\2\u015a\u015d\3\2\2\2\u015b\u0159\3\2\2\2\u015b\u015c\3\2\2\2\u015c"+
		"\u015e\3\2\2\2\u015d\u015b\3\2\2\2\u015e\u015f\7\63\2\2\u015f+\3\2\2\2"+
		"\u0160\u0161\t\3\2\2\u0161-\3\2\2\2\u0162\u0163\t\4\2\2\u0163/\3\2\2\2"+
		"\u0164\u0166\7\4\2\2\u0165\u0164\3\2\2\2\u0166\u0169\3\2\2\2\u0167\u0165"+
		"\3\2\2\2\u0167\u0168\3\2\2\2\u0168\61\3\2\2\2\u0169\u0167\3\2\2\2\u016a"+
		"\u016b\t\5\2\2\u016b\63\3\2\2\2\u016c\u016d\t\6\2\2\u016d\65\3\2\2\2\u016e"+
		"\u0170\7/\2\2\u016f\u016e\3\2\2\2\u0170\u0171\3\2\2\2\u0171\u016f\3\2"+
		"\2\2\u0171\u0172\3\2\2\2\u0172\67\3\2\2\2?9<LNZ\\bfkmrz\u0081\u0083\u008b"+
		"\u0092\u0099\u009c\u00a0\u00a2\u00ac\u00b0\u00b9\u00bd\u00c2\u00cf\u00d1"+
		"\u00d8\u00da\u00df\u00e1\u00e8\u00ea\u00ef\u00f3\u00f7\u00fb\u00fe\u0102"+
		"\u0105\u0109\u010d\u0111\u0115\u0119\u011d\u0123\u0126\u0128\u012d\u0132"+
		"\u0139\u0144\u0149\u014d\u0153\u0157\u0159\u015b\u0167\u0171";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}