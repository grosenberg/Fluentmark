// Generated from D:/DevFiles/Eclipse/Tools/Editors/net.certiv.fluent.dt/net.certiv.fluent.dt.core/src/main/java/net/certiv/fluent/dt/core/lang/md/MdParser.g4 by ANTLR 4.12.0

package net.certiv.fluent.dt.core.lang.md.gen;

import java.util.List;

import org.antlr.v4.runtime.FailedPredicateException;
import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
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

@SuppressWarnings({ "all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue" })
public class MdParser extends MdParserBase {
	static {
		RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION);
	}

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
	public static final int WORD = 1, RBOLD = 2, RITALIC = 3, RSTRIKE = 4, RDQUOTE = 5, RSQUOTE = 6,
			COMMENT = 7, CODE_BEG = 8, HTML_BLOCK_BEG = 9, HTML_BLOCK_END = 10, YAML_BLOCK = 11,
			DOT_BLOCK = 12, MATH_BLOCK = 13, TEX_BLOCK = 14, UML_BLOCK = 15, MATHS = 16, SPAN = 17,
			LSTYLE = 18, URL = 19, URLTAG = 20, HTML = 21, TEX = 22, UNICODE = 23, ENTITY = 24, IMAGE = 25,
			FNOTE = 26, LINK = 27, TABLE = 28, PIPE = 29, HASHES = 30, DASHES = 31, EQUALS = 32, HRULE = 33,
			COLON = 34, BULLET_MARK = 35, NUMBER_MARK = 36, PAREN_MARK = 37, UALPHA_MARK = 38,
			LALPHA_MARK = 39, LBOLD = 40, LITALIC = 41, LSTRIKE = 42, LDQUOTE = 43, LSQUOTE = 44,
			BLOCKQUOTE = 45, LINE_DENT = 46, LINE_BLANK = 47, LINE_BREAK = 48, VWS = 49, HWS = 50, CHAR = 51,
			HASH = 52, CHAR_h = 53, RSTYLE = 54, CLASS = 55, ID = 56, EQ = 57, DASH = 58, DQUOTE = 59,
			SQUOTE = 60, CHAR_s = 61, CODE_END = 62, CHR_c = 63, CHR_t = 64, LNK_SEP = 65, LNK_REF = 66,
			LNK_DEF = 67, RBRACK = 68, CHR_l = 69, RPAREN = 70, CHR_d = 71, CHR_r = 72;
	public static final int RULE_page = 0, RULE_yamlBlock = 1, RULE_dotBlock = 2, RULE_mathBlock = 3,
			RULE_texBlock = 4, RULE_umlBlock = 5, RULE_htmlBlock = 6, RULE_codeBlock = 7, RULE_style = 8,
			RULE_header = 9, RULE_hrule = 10, RULE_table = 11, RULE_tableRow = 12, RULE_list = 13,
			RULE_listItem = 14, RULE_definition = 15, RULE_defineItem = 16, RULE_link = 17, RULE_lnkDef = 18,
			RULE_lnkRef = 19, RULE_url = 20, RULE_alt = 21, RULE_paragraph = 22, RULE_lines = 23,
			RULE_note = 24, RULE_line = 25, RULE_word = 26, RULE_nl = 27, RULE_nl2 = 28, RULE_attrLeft = 29,
			RULE_attrRight = 30, RULE_comment = 31, RULE_lnBlank = 32, RULE_lnBreak = 33;

	private static String[] makeRuleNames() {
		return new String[] { "page", "yamlBlock", "dotBlock", "mathBlock", "texBlock", "umlBlock",
				"htmlBlock", "codeBlock", "style", "header", "hrule", "table", "tableRow", "list", "listItem",
				"definition", "defineItem", "link", "lnkDef", "lnkRef", "url", "alt", "paragraph", "lines",
				"note", "line", "word", "nl", "nl2", "attrLeft", "attrRight", "comment", "lnBlank",
				"lnBreak" };
	}

	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {};
	}

	private static final String[] _LITERAL_NAMES = makeLiteralNames();

	private static String[] makeSymbolicNames() {
		return new String[] { null, "WORD", "RBOLD", "RITALIC", "RSTRIKE", "RDQUOTE", "RSQUOTE", "COMMENT",
				"CODE_BEG", "HTML_BLOCK_BEG", "HTML_BLOCK_END", "YAML_BLOCK", "DOT_BLOCK", "MATH_BLOCK",
				"TEX_BLOCK", "UML_BLOCK", "MATHS", "SPAN", "LSTYLE", "URL", "URLTAG", "HTML", "TEX",
				"UNICODE", "ENTITY", "IMAGE", "FNOTE", "LINK", "TABLE", "PIPE", "HASHES", "DASHES", "EQUALS",
				"HRULE", "COLON", "BULLET_MARK", "NUMBER_MARK", "PAREN_MARK", "UALPHA_MARK", "LALPHA_MARK",
				"LBOLD", "LITALIC", "LSTRIKE", "LDQUOTE", "LSQUOTE", "BLOCKQUOTE", "LINE_DENT", "LINE_BLANK",
				"LINE_BREAK", "VWS", "HWS", "CHAR", "HASH", "CHAR_h", "RSTYLE", "CLASS", "ID", "EQ", "DASH",
				"DQUOTE", "SQUOTE", "CHAR_s", "CODE_END", "CHR_c", "CHR_t", "LNK_SEP", "LNK_REF", "LNK_DEF",
				"RBRACK", "CHR_l", "RPAREN", "CHR_d", "CHR_r" };
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
	public String getGrammarFileName() {
		return "MdParser.g4";
	}

	@Override
	public String[] getRuleNames() {
		return ruleNames;
	}

	@Override
	public String getSerializedATN() {
		return _serializedATN;
	}

	@Override
	public ATN getATN() {
		return _ATN;
	}

	public MdParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PageContext extends ParserRuleContext {
		public TerminalNode EOF() {
			return getToken(Recognizer.EOF, 0);
		}

		public List<YamlBlockContext> yamlBlock() {
			return getRuleContexts(YamlBlockContext.class);
		}

		public YamlBlockContext yamlBlock(int i) {
			return getRuleContext(YamlBlockContext.class, i);
		}

		public List<DotBlockContext> dotBlock() {
			return getRuleContexts(DotBlockContext.class);
		}

		public DotBlockContext dotBlock(int i) {
			return getRuleContext(DotBlockContext.class, i);
		}

		public List<MathBlockContext> mathBlock() {
			return getRuleContexts(MathBlockContext.class);
		}

		public MathBlockContext mathBlock(int i) {
			return getRuleContext(MathBlockContext.class, i);
		}

		public List<HtmlBlockContext> htmlBlock() {
			return getRuleContexts(HtmlBlockContext.class);
		}

		public HtmlBlockContext htmlBlock(int i) {
			return getRuleContext(HtmlBlockContext.class, i);
		}

		public List<TexBlockContext> texBlock() {
			return getRuleContexts(TexBlockContext.class);
		}

		public TexBlockContext texBlock(int i) {
			return getRuleContext(TexBlockContext.class, i);
		}

		public List<UmlBlockContext> umlBlock() {
			return getRuleContexts(UmlBlockContext.class);
		}

		public UmlBlockContext umlBlock(int i) {
			return getRuleContext(UmlBlockContext.class, i);
		}

		public List<CodeBlockContext> codeBlock() {
			return getRuleContexts(CodeBlockContext.class);
		}

		public CodeBlockContext codeBlock(int i) {
			return getRuleContext(CodeBlockContext.class, i);
		}

		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}

		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class, i);
		}

		public List<HeaderContext> header() {
			return getRuleContexts(HeaderContext.class);
		}

		public HeaderContext header(int i) {
			return getRuleContext(HeaderContext.class, i);
		}

		public List<HruleContext> hrule() {
			return getRuleContexts(HruleContext.class);
		}

		public HruleContext hrule(int i) {
			return getRuleContext(HruleContext.class, i);
		}

		public List<ParagraphContext> paragraph() {
			return getRuleContexts(ParagraphContext.class);
		}

		public ParagraphContext paragraph(int i) {
			return getRuleContext(ParagraphContext.class, i);
		}

		public List<TableContext> table() {
			return getRuleContexts(TableContext.class);
		}

		public TableContext table(int i) {
			return getRuleContext(TableContext.class, i);
		}

		public List<ListContext> list() {
			return getRuleContexts(ListContext.class);
		}

		public ListContext list(int i) {
			return getRuleContext(ListContext.class, i);
		}

		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}

		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class, i);
		}

		public List<LnBlankContext> lnBlank() {
			return getRuleContexts(LnBlankContext.class);
		}

		public LnBlankContext lnBlank(int i) {
			return getRuleContext(LnBlankContext.class, i);
		}

		public List<LnBreakContext> lnBreak() {
			return getRuleContexts(LnBreakContext.class);
		}

		public LnBreakContext lnBreak(int i) {
			return getRuleContext(LnBreakContext.class, i);
		}

		public List<TerminalNode> VWS() {
			return getTokens(MdParser.VWS);
		}

		public TerminalNode VWS(int i) {
			return getToken(MdParser.VWS, i);
		}

		public PageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_page;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).enterPage(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).exitPage(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof MdParserVisitor)
				return ((MdParserVisitor<? extends T>) visitor).visitPage(this);
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
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1020323167992706L) != 0)) {
					{
						setState(85);
						_errHandler.sync(this);
						switch (getInterpreter().adaptivePredict(_input, 0, _ctx)) {
							case 1: {
								setState(68);
								yamlBlock();
							}
								break;
							case 2: {
								setState(69);
								dotBlock();
							}
								break;
							case 3: {
								setState(70);
								mathBlock();
							}
								break;
							case 4: {
								setState(71);
								htmlBlock();
							}
								break;
							case 5: {
								setState(72);
								texBlock();
							}
								break;
							case 6: {
								setState(73);
								umlBlock();
							}
								break;
							case 7: {
								setState(74);
								codeBlock();
							}
								break;
							case 8: {
								setState(75);
								comment();
							}
								break;
							case 9: {
								setState(76);
								header();
							}
								break;
							case 10: {
								setState(77);
								hrule();
							}
								break;
							case 11: {
								setState(78);
								paragraph();
							}
								break;
							case 12: {
								setState(79);
								table();
							}
								break;
							case 13: {
								setState(80);
								list();
							}
								break;
							case 14: {
								setState(81);
								definition();
							}
								break;
							case 15: {
								setState(82);
								lnBlank();
							}
								break;
							case 16: {
								setState(83);
								lnBreak();
							}
								break;
							case 17: {
								setState(84);
								match(VWS);
							}
								break;
						}
					}
					setState(89);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(90);
				match(EOF);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class YamlBlockContext extends ParserRuleContext {
		public TerminalNode YAML_BLOCK() {
			return getToken(MdParser.YAML_BLOCK, 0);
		}

		public YamlBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_yamlBlock;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).enterYamlBlock(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).exitYamlBlock(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof MdParserVisitor)
				return ((MdParserVisitor<? extends T>) visitor).visitYamlBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final YamlBlockContext yamlBlock() throws RecognitionException {
		YamlBlockContext _localctx = new YamlBlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_yamlBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(92);
				match(YAML_BLOCK);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DotBlockContext extends ParserRuleContext {
		public TerminalNode DOT_BLOCK() {
			return getToken(MdParser.DOT_BLOCK, 0);
		}

		public DotBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_dotBlock;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).enterDotBlock(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).exitDotBlock(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof MdParserVisitor)
				return ((MdParserVisitor<? extends T>) visitor).visitDotBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DotBlockContext dotBlock() throws RecognitionException {
		DotBlockContext _localctx = new DotBlockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_dotBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(94);
				match(DOT_BLOCK);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MathBlockContext extends ParserRuleContext {
		public TerminalNode MATH_BLOCK() {
			return getToken(MdParser.MATH_BLOCK, 0);
		}

		public MathBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_mathBlock;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).enterMathBlock(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).exitMathBlock(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof MdParserVisitor)
				return ((MdParserVisitor<? extends T>) visitor).visitMathBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MathBlockContext mathBlock() throws RecognitionException {
		MathBlockContext _localctx = new MathBlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_mathBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(96);
				match(MATH_BLOCK);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TexBlockContext extends ParserRuleContext {
		public TerminalNode TEX_BLOCK() {
			return getToken(MdParser.TEX_BLOCK, 0);
		}

		public TexBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_texBlock;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).enterTexBlock(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).exitTexBlock(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof MdParserVisitor)
				return ((MdParserVisitor<? extends T>) visitor).visitTexBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TexBlockContext texBlock() throws RecognitionException {
		TexBlockContext _localctx = new TexBlockContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_texBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(98);
				match(TEX_BLOCK);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UmlBlockContext extends ParserRuleContext {
		public TerminalNode UML_BLOCK() {
			return getToken(MdParser.UML_BLOCK, 0);
		}

		public UmlBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_umlBlock;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).enterUmlBlock(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).exitUmlBlock(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof MdParserVisitor)
				return ((MdParserVisitor<? extends T>) visitor).visitUmlBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UmlBlockContext umlBlock() throws RecognitionException {
		UmlBlockContext _localctx = new UmlBlockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_umlBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(100);
				match(UML_BLOCK);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlBlockContext extends ParserRuleContext {
		public TerminalNode HTML_BLOCK_BEG() {
			return getToken(MdParser.HTML_BLOCK_BEG, 0);
		}

		public TerminalNode HTML_BLOCK_END() {
			return getToken(MdParser.HTML_BLOCK_END, 0);
		}

		public List<TerminalNode> COMMENT() {
			return getTokens(MdParser.COMMENT);
		}

		public TerminalNode COMMENT(int i) {
			return getToken(MdParser.COMMENT, i);
		}

		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}

		public LineContext line(int i) {
			return getRuleContext(LineContext.class, i);
		}

		public List<NlContext> nl() {
			return getRuleContexts(NlContext.class);
		}

		public NlContext nl(int i) {
			return getRuleContext(NlContext.class, i);
		}

		public HtmlBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_htmlBlock;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).enterHtmlBlock(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).exitHtmlBlock(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof MdParserVisitor)
				return ((MdParserVisitor<? extends T>) visitor).visitHtmlBlock(this);
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
				setState(102);
				match(HTML_BLOCK_BEG);
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 878510058700930L) != 0)) {
					{
						setState(106);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
							case COMMENT: {
								setState(103);
								match(COMMENT);
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
							case LSQUOTE: {
								setState(104);
								line();
							}
								break;
							case LINE_BREAK:
							case VWS: {
								setState(105);
								nl();
							}
								break;
							default:
								throw new NoViableAltException(this);
						}
					}
					setState(110);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(111);
				match(HTML_BLOCK_END);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CodeBlockContext extends ParserRuleContext {
		public Token lang;

		public TerminalNode CODE_BEG() {
			return getToken(MdParser.CODE_BEG, 0);
		}

		public List<TerminalNode> VWS() {
			return getTokens(MdParser.VWS);
		}

		public TerminalNode VWS(int i) {
			return getToken(MdParser.VWS, i);
		}

		public TerminalNode CODE_END() {
			return getToken(MdParser.CODE_END, 0);
		}

		public StyleContext style() {
			return getRuleContext(StyleContext.class, 0);
		}

		public List<TerminalNode> WORD() {
			return getTokens(MdParser.WORD);
		}

		public TerminalNode WORD(int i) {
			return getToken(MdParser.WORD, i);
		}

		public CodeBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_codeBlock;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).enterCodeBlock(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).exitCodeBlock(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof MdParserVisitor)
				return ((MdParserVisitor<? extends T>) visitor).visitCodeBlock(this);
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
				setState(113);
				match(CODE_BEG);
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la == WORD) {
					{
						setState(114);
						((CodeBlockContext) _localctx).lang = match(WORD);
					}
				}

				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la == LSTYLE) {
					{
						setState(117);
						style();
					}
				}

				setState(120);
				match(VWS);
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la == WORD || _la == VWS) {
					{
						{
							setState(121);
							_la = _input.LA(1);
							if (!(_la == WORD || _la == VWS)) {
								_errHandler.recoverInline(this);
							} else {
								if (_input.LA(1) == Token.EOF) matchedEOF = true;
								_errHandler.reportMatch(this);
								consume();
							}
						}
					}
					setState(126);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(127);
				match(CODE_END);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StyleContext extends ParserRuleContext {
		public TerminalNode LSTYLE() {
			return getToken(MdParser.LSTYLE, 0);
		}

		public TerminalNode RSTYLE() {
			return getToken(MdParser.RSTYLE, 0);
		}

		public List<TerminalNode> DASH() {
			return getTokens(MdParser.DASH);
		}

		public TerminalNode DASH(int i) {
			return getToken(MdParser.DASH, i);
		}

		public List<TerminalNode> CLASS() {
			return getTokens(MdParser.CLASS);
		}

		public TerminalNode CLASS(int i) {
			return getToken(MdParser.CLASS, i);
		}

		public List<TerminalNode> WORD() {
			return getTokens(MdParser.WORD);
		}

		public TerminalNode WORD(int i) {
			return getToken(MdParser.WORD, i);
		}

		public List<TerminalNode> ID() {
			return getTokens(MdParser.ID);
		}

		public TerminalNode ID(int i) {
			return getToken(MdParser.ID, i);
		}

		public List<TerminalNode> EQ() {
			return getTokens(MdParser.EQ);
		}

		public TerminalNode EQ(int i) {
			return getToken(MdParser.EQ, i);
		}

		public List<TerminalNode> SQUOTE() {
			return getTokens(MdParser.SQUOTE);
		}

		public TerminalNode SQUOTE(int i) {
			return getToken(MdParser.SQUOTE, i);
		}

		public List<TerminalNode> DQUOTE() {
			return getTokens(MdParser.DQUOTE);
		}

		public TerminalNode DQUOTE(int i) {
			return getToken(MdParser.DQUOTE, i);
		}

		public StyleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_style;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).enterStyle(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).exitStyle(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof MdParserVisitor)
				return ((MdParserVisitor<? extends T>) visitor).visitStyle(this);
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
				setState(129);
				match(LSTYLE);
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
						setState(146);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
							case DASH: {
								setState(130);
								match(DASH);
							}
								break;
							case CLASS: {
								setState(131);
								match(CLASS);
								setState(132);
								match(WORD);
							}
								break;
							case ID: {
								setState(133);
								match(ID);
								setState(134);
								match(WORD);
							}
								break;
							case WORD: {
								setState(135);
								match(WORD);
								setState(136);
								match(EQ);
								setState(144);
								_errHandler.sync(this);
								switch (_input.LA(1)) {
									case SQUOTE: {
										setState(137);
										match(SQUOTE);
										setState(138);
										match(WORD);
										setState(139);
										match(SQUOTE);
									}
										break;
									case DQUOTE: {
										setState(140);
										match(DQUOTE);
										setState(141);
										match(WORD);
										setState(142);
										match(DQUOTE);
									}
										break;
									case WORD: {
										setState(143);
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
					setState(148);
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 396316767208603650L) != 0));
				setState(150);
				match(RSTYLE);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HeaderContext extends ParserRuleContext {
		public TerminalNode HASHES() {
			return getToken(MdParser.HASHES, 0);
		}

		public LineContext line() {
			return getRuleContext(LineContext.class, 0);
		}

		public List<TerminalNode> HASH() {
			return getTokens(MdParser.HASH);
		}

		public TerminalNode HASH(int i) {
			return getToken(MdParser.HASH, i);
		}

		public StyleContext style() {
			return getRuleContext(StyleContext.class, 0);
		}

		public NlContext nl() {
			return getRuleContext(NlContext.class, 0);
		}

		public TerminalNode EQUALS() {
			return getToken(MdParser.EQUALS, 0);
		}

		public TerminalNode DASHES() {
			return getToken(MdParser.DASHES, 0);
		}

		public HeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_header;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).enterHeader(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).exitHeader(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof MdParserVisitor)
				return ((MdParserVisitor<? extends T>) visitor).visitHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_header);
		int _la;
		try {
			setState(170);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
				case HASHES:
					enterOuterAlt(_localctx, 1); {
					setState(152);
					match(HASHES);
					setState(153);
					line();
					setState(157);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la == HASH) {
						{
							{
								setState(154);
								match(HASH);
							}
						}
						setState(159);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(161);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la == LSTYLE) {
						{
							setState(160);
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
					enterOuterAlt(_localctx, 2); {
					setState(163);
					line();
					setState(165);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la == LSTYLE) {
						{
							setState(164);
							style();
						}
					}

					setState(167);
					nl();
					setState(168);
					_la = _input.LA(1);
					if (!(_la == DASHES || _la == EQUALS)) {
						_errHandler.recoverInline(this);
					} else {
						if (_input.LA(1) == Token.EOF) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
				}
					break;
				default:
					throw new NoViableAltException(this);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HruleContext extends ParserRuleContext {
		public TerminalNode HRULE() {
			return getToken(MdParser.HRULE, 0);
		}

		public StyleContext style() {
			return getRuleContext(StyleContext.class, 0);
		}

		public HruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_hrule;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).enterHrule(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).exitHrule(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof MdParserVisitor)
				return ((MdParserVisitor<? extends T>) visitor).visitHrule(this);
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
				setState(172);
				match(HRULE);
				setState(174);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la == LSTYLE) {
					{
						setState(173);
						style();
					}
				}

			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TableContext extends ParserRuleContext {
		public TerminalNode TABLE() {
			return getToken(MdParser.TABLE, 0);
		}

		public List<NlContext> nl() {
			return getRuleContexts(NlContext.class);
		}

		public NlContext nl(int i) {
			return getRuleContext(NlContext.class, i);
		}

		public List<TableRowContext> tableRow() {
			return getRuleContexts(TableRowContext.class);
		}

		public TableRowContext tableRow(int i) {
			return getRuleContext(TableRowContext.class, i);
		}

		public StyleContext style() {
			return getRuleContext(StyleContext.class, 0);
		}

		public TableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_table;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).enterTable(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).exitTable(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof MdParserVisitor)
				return ((MdParserVisitor<? extends T>) visitor).visitTable(this);
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
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34085665439746L) != 0)) {
					{
						{
							setState(176);
							tableRow();
							setState(177);
							nl();
						}
					}
					setState(183);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(184);
				match(TABLE);
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la == LSTYLE) {
					{
						setState(185);
						style();
					}
				}

				setState(188);
				nl();
				setState(194);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input, 17, _ctx);
				while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
					if (_alt == 1) {
						{
							{
								setState(189);
								tableRow();
								setState(190);
								nl();
							}
						}
					}
					setState(196);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input, 17, _ctx);
				}
				setState(197);
				tableRow();
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TableRowContext extends ParserRuleContext {
		public List<TerminalNode> PIPE() {
			return getTokens(MdParser.PIPE);
		}

		public TerminalNode PIPE(int i) {
			return getToken(MdParser.PIPE, i);
		}

		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}

		public LineContext line(int i) {
			return getRuleContext(LineContext.class, i);
		}

		public TableRowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_tableRow;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).enterTableRow(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).exitTableRow(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof MdParserVisitor)
				return ((MdParserVisitor<? extends T>) visitor).visitTableRow(this);
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
				setState(200);
				_errHandler.sync(this);
				switch (getInterpreter().adaptivePredict(_input, 18, _ctx)) {
					case 1: {
						setState(199);
						match(PIPE);
					}
						break;
				}
				setState(206);
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
						case 1: {
							{
								setState(203);
								_errHandler.sync(this);
								_la = _input.LA(1);
								if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34085128568834L) != 0)) {
									{
										setState(202);
										line();
									}
								}

								setState(205);
								match(PIPE);
							}
						}
							break;
						default:
							throw new NoViableAltException(this);
					}
					setState(208);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input, 20, _ctx);
				} while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER);
				setState(211);
				_errHandler.sync(this);
				switch (getInterpreter().adaptivePredict(_input, 21, _ctx)) {
					case 1: {
						setState(210);
						line();
					}
						break;
				}
				setState(214);
				_errHandler.sync(this);
				switch (getInterpreter().adaptivePredict(_input, 22, _ctx)) {
					case 1: {
						setState(213);
						match(PIPE);
					}
						break;
				}
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
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
			return getRuleContext(ListItemContext.class, i);
		}

		public List<NlContext> nl() {
			return getRuleContexts(NlContext.class);
		}

		public NlContext nl(int i) {
			return getRuleContext(NlContext.class, i);
		}

		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_list;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).enterList(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).exitList(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof MdParserVisitor)
				return ((MdParserVisitor<? extends T>) visitor).visitList(this);
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
				setState(216);
				listItem();
				setState(222);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input, 23, _ctx);
				while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
					if (_alt == 1) {
						{
							{
								setState(217);
								nl();
								setState(218);
								listItem();
							}
						}
					}
					setState(224);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input, 23, _ctx);
				}
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListItemContext extends ParserRuleContext {
		public Token mark;

		public LinesContext lines() {
			return getRuleContext(LinesContext.class, 0);
		}

		public TerminalNode BULLET_MARK() {
			return getToken(MdParser.BULLET_MARK, 0);
		}

		public TerminalNode NUMBER_MARK() {
			return getToken(MdParser.NUMBER_MARK, 0);
		}

		public TerminalNode PAREN_MARK() {
			return getToken(MdParser.PAREN_MARK, 0);
		}

		public TerminalNode UALPHA_MARK() {
			return getToken(MdParser.UALPHA_MARK, 0);
		}

		public TerminalNode LALPHA_MARK() {
			return getToken(MdParser.LALPHA_MARK, 0);
		}

		public ListItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_listItem;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).enterListItem(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).exitListItem(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof MdParserVisitor)
				return ((MdParserVisitor<? extends T>) visitor).visitListItem(this);
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
				setState(225);
				((ListItemContext) _localctx).mark = _input.LT(1);
				_la = _input.LA(1);
				if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 1065151889408L) != 0))) {
					((ListItemContext) _localctx).mark = (Token) _errHandler.recoverInline(this);
				} else {
					if (_input.LA(1) == Token.EOF) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(226);
				lines();
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefinitionContext extends ParserRuleContext {
		public LineContext line() {
			return getRuleContext(LineContext.class, 0);
		}

		public List<NlContext> nl() {
			return getRuleContexts(NlContext.class);
		}

		public NlContext nl(int i) {
			return getRuleContext(NlContext.class, i);
		}

		public List<DefineItemContext> defineItem() {
			return getRuleContexts(DefineItemContext.class);
		}

		public DefineItemContext defineItem(int i) {
			return getRuleContext(DefineItemContext.class, i);
		}

		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_definition;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).enterDefinition(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).exitDefinition(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof MdParserVisitor)
				return ((MdParserVisitor<? extends T>) visitor).visitDefinition(this);
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
				setState(228);
				line();
				setState(229);
				nl();
				setState(230);
				defineItem();
				setState(236);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input, 24, _ctx);
				while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
					if (_alt == 1) {
						{
							{
								setState(231);
								nl();
								setState(232);
								defineItem();
							}
						}
					}
					setState(238);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input, 24, _ctx);
				}
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefineItemContext extends ParserRuleContext {
		public TerminalNode COLON() {
			return getToken(MdParser.COLON, 0);
		}

		public LinesContext lines() {
			return getRuleContext(LinesContext.class, 0);
		}

		public DefineItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_defineItem;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).enterDefineItem(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).exitDefineItem(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof MdParserVisitor)
				return ((MdParserVisitor<? extends T>) visitor).visitDefineItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefineItemContext defineItem() throws RecognitionException {
		DefineItemContext _localctx = new DefineItemContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_defineItem);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(239);
				match(COLON);
				setState(240);
				lines();
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LinkContext extends ParserRuleContext {
		public LnkDefContext lnkDef() {
			return getRuleContext(LnkDefContext.class, 0);
		}

		public LineContext line() {
			return getRuleContext(LineContext.class, 0);
		}

		public TerminalNode LNK_SEP() {
			return getToken(MdParser.LNK_SEP, 0);
		}

		public TerminalNode RPAREN() {
			return getToken(MdParser.RPAREN, 0);
		}

		public UrlContext url() {
			return getRuleContext(UrlContext.class, 0);
		}

		public AltContext alt() {
			return getRuleContext(AltContext.class, 0);
		}

		public StyleContext style() {
			return getRuleContext(StyleContext.class, 0);
		}

		public TerminalNode LNK_REF() {
			return getToken(MdParser.LNK_REF, 0);
		}

		public TerminalNode RBRACK() {
			return getToken(MdParser.RBRACK, 0);
		}

		public List<WordContext> word() {
			return getRuleContexts(WordContext.class);
		}

		public WordContext word(int i) {
			return getRuleContext(WordContext.class, i);
		}

		public LnkRefContext lnkRef() {
			return getRuleContext(LnkRefContext.class, 0);
		}

		public TerminalNode LNK_DEF() {
			return getToken(MdParser.LNK_DEF, 0);
		}

		public List<TerminalNode> VWS() {
			return getTokens(MdParser.VWS);
		}

		public TerminalNode VWS(int i) {
			return getToken(MdParser.VWS, i);
		}

		public List<TerminalNode> LINE_BREAK() {
			return getTokens(MdParser.LINE_BREAK);
		}

		public TerminalNode LINE_BREAK(int i) {
			return getToken(MdParser.LINE_BREAK, i);
		}

		public TerminalNode FNOTE() {
			return getToken(MdParser.FNOTE, 0);
		}

		public NoteContext note() {
			return getRuleContext(NoteContext.class, 0);
		}

		public LinkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_link;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).enterLink(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).exitLink(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof MdParserVisitor)
				return ((MdParserVisitor<? extends T>) visitor).visitLink(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LinkContext link() throws RecognitionException {
		LinkContext _localctx = new LinkContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_link);
		int _la;
		try {
			setState(299);
			_errHandler.sync(this);
			switch (getInterpreter().adaptivePredict(_input, 36, _ctx)) {
				case 1:
					enterOuterAlt(_localctx, 1); {
					setState(242);
					lnkDef();
					setState(243);
					line();
					setState(244);
					match(LNK_SEP);
					setState(246);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la == URL || _la == URLTAG) {
						{
							setState(245);
							url();
						}
					}

					setState(249);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1729408645189337088L) != 0)) {
						{
							setState(248);
							alt();
						}
					}

					setState(251);
					match(RPAREN);
					setState(253);
					_errHandler.sync(this);
					switch (getInterpreter().adaptivePredict(_input, 27, _ctx)) {
						case 1: {
							setState(252);
							style();
						}
							break;
					}
				}
					break;
				case 2:
					enterOuterAlt(_localctx, 2); {
					setState(255);
					lnkDef();
					setState(256);
					line();
					setState(257);
					match(LNK_REF);
					setState(261);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34084893687810L) != 0)) {
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
					match(RBRACK);
					setState(266);
					_errHandler.sync(this);
					switch (getInterpreter().adaptivePredict(_input, 29, _ctx)) {
						case 1: {
							setState(265);
							style();
						}
							break;
					}
				}
					break;
				case 3:
					enterOuterAlt(_localctx, 3); {
					setState(268);
					lnkRef();
					setState(272);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34084893687810L) != 0)) {
						{
							{
								setState(269);
								word();
							}
						}
						setState(274);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(275);
					match(LNK_DEF);
					setState(277);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la == LINE_BREAK || _la == VWS) {
						{
							setState(276);
							_la = _input.LA(1);
							if (!(_la == LINE_BREAK || _la == VWS)) {
								_errHandler.recoverInline(this);
							} else {
								if (_input.LA(1) == Token.EOF) matchedEOF = true;
								_errHandler.reportMatch(this);
								consume();
							}
						}
					}

					setState(279);
					url();
					setState(284);
					_errHandler.sync(this);
					switch (getInterpreter().adaptivePredict(_input, 33, _ctx)) {
						case 1: {
							setState(281);
							_errHandler.sync(this);
							_la = _input.LA(1);
							if (_la == LINE_BREAK || _la == VWS) {
								{
									setState(280);
									_la = _input.LA(1);
									if (!(_la == LINE_BREAK || _la == VWS)) {
										_errHandler.recoverInline(this);
									} else {
										if (_input.LA(1) == Token.EOF) matchedEOF = true;
										_errHandler.reportMatch(this);
										consume();
									}
								}
							}

							setState(283);
							alt();
						}
							break;
					}
				}
					break;
				case 4:
					enterOuterAlt(_localctx, 4); {
					setState(286);
					match(FNOTE);
					setState(287);
					word();
					setState(288);
					match(LNK_DEF);
					setState(289);
					note();
					setState(291);
					_errHandler.sync(this);
					switch (getInterpreter().adaptivePredict(_input, 34, _ctx)) {
						case 1: {
							setState(290);
							style();
						}
							break;
					}
				}
					break;
				case 5:
					enterOuterAlt(_localctx, 5); {
					setState(293);
					lnkDef();
					setState(294);
					line();
					setState(295);
					match(RBRACK);
					setState(297);
					_errHandler.sync(this);
					switch (getInterpreter().adaptivePredict(_input, 35, _ctx)) {
						case 1: {
							setState(296);
							style();
						}
							break;
					}
				}
					break;
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LnkDefContext extends ParserRuleContext {
		public TerminalNode IMAGE() {
			return getToken(MdParser.IMAGE, 0);
		}

		public TerminalNode FNOTE() {
			return getToken(MdParser.FNOTE, 0);
		}

		public TerminalNode LINK() {
			return getToken(MdParser.LINK, 0);
		}

		public LnkDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_lnkDef;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).enterLnkDef(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).exitLnkDef(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof MdParserVisitor)
				return ((MdParserVisitor<? extends T>) visitor).visitLnkDef(this);
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
				setState(301);
				_la = _input.LA(1);
				if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 234881024L) != 0))) {
					_errHandler.recoverInline(this);
				} else {
					if (_input.LA(1) == Token.EOF) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LnkRefContext extends ParserRuleContext {
		public TerminalNode LINK() {
			return getToken(MdParser.LINK, 0);
		}

		public LnkRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_lnkRef;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).enterLnkRef(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).exitLnkRef(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof MdParserVisitor)
				return ((MdParserVisitor<? extends T>) visitor).visitLnkRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LnkRefContext lnkRef() throws RecognitionException {
		LnkRefContext _localctx = new LnkRefContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_lnkRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(303);
				match(LINK);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UrlContext extends ParserRuleContext {
		public TerminalNode URLTAG() {
			return getToken(MdParser.URLTAG, 0);
		}

		public TerminalNode URL() {
			return getToken(MdParser.URL, 0);
		}

		public UrlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_url;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).enterUrl(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).exitUrl(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof MdParserVisitor)
				return ((MdParserVisitor<? extends T>) visitor).visitUrl(this);
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
				setState(305);
				_la = _input.LA(1);
				if (!(_la == URL || _la == URLTAG)) {
					_errHandler.recoverInline(this);
				} else {
					if (_input.LA(1) == Token.EOF) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AltContext extends ParserRuleContext {
		public List<TerminalNode> DQUOTE() {
			return getTokens(MdParser.DQUOTE);
		}

		public TerminalNode DQUOTE(int i) {
			return getToken(MdParser.DQUOTE, i);
		}

		public List<WordContext> word() {
			return getRuleContexts(WordContext.class);
		}

		public WordContext word(int i) {
			return getRuleContext(WordContext.class, i);
		}

		public List<TerminalNode> SQUOTE() {
			return getTokens(MdParser.SQUOTE);
		}

		public TerminalNode SQUOTE(int i) {
			return getToken(MdParser.SQUOTE, i);
		}

		public TerminalNode LDQUOTE() {
			return getToken(MdParser.LDQUOTE, 0);
		}

		public TerminalNode RDQUOTE() {
			return getToken(MdParser.RDQUOTE, 0);
		}

		public LineContext line() {
			return getRuleContext(LineContext.class, 0);
		}

		public TerminalNode LSQUOTE() {
			return getToken(MdParser.LSQUOTE, 0);
		}

		public TerminalNode RSQUOTE() {
			return getToken(MdParser.RSQUOTE, 0);
		}

		public AltContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_alt;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).enterAlt(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).exitAlt(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof MdParserVisitor)
				return ((MdParserVisitor<? extends T>) visitor).visitAlt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AltContext alt() throws RecognitionException {
		AltContext _localctx = new AltContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_alt);
		int _la;
		try {
			setState(335);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
				case DQUOTE:
					enterOuterAlt(_localctx, 1); {
					setState(307);
					match(DQUOTE);
					setState(312);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1152955589500534786L) != 0)) {
						{
							setState(310);
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
								case LSQUOTE: {
									setState(308);
									word();
								}
									break;
								case SQUOTE: {
									setState(309);
									match(SQUOTE);
								}
									break;
								default:
									throw new NoViableAltException(this);
							}
						}
						setState(314);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(315);
					match(DQUOTE);
				}
					break;
				case SQUOTE:
					enterOuterAlt(_localctx, 2); {
					setState(316);
					match(SQUOTE);
					setState(321);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 576494837197111298L) != 0)) {
						{
							setState(319);
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
								case LSQUOTE: {
									setState(317);
									word();
								}
									break;
								case DQUOTE: {
									setState(318);
									match(DQUOTE);
								}
									break;
								default:
									throw new NoViableAltException(this);
							}
						}
						setState(323);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(324);
					match(SQUOTE);
				}
					break;
				case LDQUOTE:
					enterOuterAlt(_localctx, 3); {
					setState(325);
					match(LDQUOTE);
					setState(327);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34085128568834L) != 0)) {
						{
							setState(326);
							line();
						}
					}

					setState(329);
					match(RDQUOTE);
				}
					break;
				case LSQUOTE:
					enterOuterAlt(_localctx, 4); {
					setState(330);
					match(LSQUOTE);
					setState(332);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34085128568834L) != 0)) {
						{
							setState(331);
							line();
						}
					}

					setState(334);
					match(RSQUOTE);
				}
					break;
				default:
					throw new NoViableAltException(this);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParagraphContext extends ParserRuleContext {
		public LinesContext lines() {
			return getRuleContext(LinesContext.class, 0);
		}

		public ParagraphContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_paragraph;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).enterParagraph(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).exitParagraph(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof MdParserVisitor)
				return ((MdParserVisitor<? extends T>) visitor).visitParagraph(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParagraphContext paragraph() throws RecognitionException {
		ParagraphContext _localctx = new ParagraphContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_paragraph);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(337);
				lines();
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LinesContext extends ParserRuleContext {
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}

		public LineContext line(int i) {
			return getRuleContext(LineContext.class, i);
		}

		public List<NlContext> nl() {
			return getRuleContexts(NlContext.class);
		}

		public NlContext nl(int i) {
			return getRuleContext(NlContext.class, i);
		}

		public LinesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_lines;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).enterLines(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).exitLines(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof MdParserVisitor)
				return ((MdParserVisitor<? extends T>) visitor).visitLines(this);
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
				setState(339);
				line();
				setState(345);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input, 44, _ctx);
				while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
					if (_alt == 1) {
						{
							{
								setState(340);
								nl();
								setState(341);
								line();
							}
						}
					}
					setState(347);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input, 44, _ctx);
				}
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NoteContext extends ParserRuleContext {
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}

		public LineContext line(int i) {
			return getRuleContext(LineContext.class, i);
		}

		public List<NlContext> nl() {
			return getRuleContexts(NlContext.class);
		}

		public NlContext nl(int i) {
			return getRuleContext(NlContext.class, i);
		}

		public NoteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_note;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).enterNote(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).exitNote(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof MdParserVisitor)
				return ((MdParserVisitor<? extends T>) visitor).visitNote(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NoteContext note() throws RecognitionException {
		NoteContext _localctx = new NoteContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_note);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
				setState(348);
				line();
				setState(355);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input, 45, _ctx);
				while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
					if (_alt == 1) {
						{
							{
								setState(349);
								nl();
								setState(350);
								if (!(twoSpaces())) throw new FailedPredicateException(this, "twoSpaces()");
								setState(351);
								line();
							}
						}
					}
					setState(357);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input, 45, _ctx);
				}
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LineContext extends ParserRuleContext {
		public List<WordContext> word() {
			return getRuleContexts(WordContext.class);
		}

		public WordContext word(int i) {
			return getRuleContext(WordContext.class, i);
		}

		public List<LinkContext> link() {
			return getRuleContexts(LinkContext.class);
		}

		public LinkContext link(int i) {
			return getRuleContext(LinkContext.class, i);
		}

		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_line;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).enterLine(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).exitLine(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof MdParserVisitor)
				return ((MdParserVisitor<? extends T>) visitor).visitLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_line);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
				setState(360);
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
						case 1: {
							setState(360);
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
								case LSQUOTE: {
									setState(358);
									word();
								}
									break;
								case IMAGE:
								case FNOTE:
								case LINK: {
									setState(359);
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
					setState(362);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input, 47, _ctx);
				} while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WordContext extends ParserRuleContext {
		public Token w;

		public TerminalNode WORD() {
			return getToken(MdParser.WORD, 0);
		}

		public TerminalNode ENTITY() {
			return getToken(MdParser.ENTITY, 0);
		}

		public TerminalNode UNICODE() {
			return getToken(MdParser.UNICODE, 0);
		}

		public TerminalNode URL() {
			return getToken(MdParser.URL, 0);
		}

		public TerminalNode URLTAG() {
			return getToken(MdParser.URLTAG, 0);
		}

		public TerminalNode SPAN() {
			return getToken(MdParser.SPAN, 0);
		}

		public TerminalNode MATHS() {
			return getToken(MdParser.MATHS, 0);
		}

		public TerminalNode HTML() {
			return getToken(MdParser.HTML, 0);
		}

		public TerminalNode TEX() {
			return getToken(MdParser.TEX, 0);
		}

		public List<AttrLeftContext> attrLeft() {
			return getRuleContexts(AttrLeftContext.class);
		}

		public AttrLeftContext attrLeft(int i) {
			return getRuleContext(AttrLeftContext.class, i);
		}

		public List<AttrRightContext> attrRight() {
			return getRuleContexts(AttrRightContext.class);
		}

		public AttrRightContext attrRight(int i) {
			return getRuleContext(AttrRightContext.class, i);
		}

		public WordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_word;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).enterWord(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).exitWord(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof MdParserVisitor)
				return ((MdParserVisitor<? extends T>) visitor).visitWord(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WordContext word() throws RecognitionException {
		WordContext _localctx = new WordContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_word);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
				setState(367);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34084860461056L) != 0)) {
					{
						{
							setState(364);
							attrLeft();
						}
					}
					setState(369);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(370);
				((WordContext) _localctx).w = _input.LT(1);
				_la = _input.LA(1);
				if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 33226754L) != 0))) {
					((WordContext) _localctx).w = (Token) _errHandler.recoverInline(this);
				} else {
					if (_input.LA(1) == Token.EOF) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(374);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input, 49, _ctx);
				while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
					if (_alt == 1) {
						{
							{
								setState(371);
								attrRight();
							}
						}
					}
					setState(376);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input, 49, _ctx);
				}
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NlContext extends ParserRuleContext {
		public TerminalNode LINE_BREAK() {
			return getToken(MdParser.LINE_BREAK, 0);
		}

		public TerminalNode VWS() {
			return getToken(MdParser.VWS, 0);
		}

		public NlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_nl;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).enterNl(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).exitNl(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof MdParserVisitor)
				return ((MdParserVisitor<? extends T>) visitor).visitNl(this);
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
				setState(377);
				_la = _input.LA(1);
				if (!(_la == LINE_BREAK || _la == VWS)) {
					_errHandler.recoverInline(this);
				} else {
					if (_input.LA(1) == Token.EOF) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Nl2Context extends ParserRuleContext {
		public TerminalNode LINE_BREAK() {
			return getToken(MdParser.LINE_BREAK, 0);
		}

		public TerminalNode VWS() {
			return getToken(MdParser.VWS, 0);
		}

		public Nl2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_nl2;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).enterNl2(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).exitNl2(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof MdParserVisitor)
				return ((MdParserVisitor<? extends T>) visitor).visitNl2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Nl2Context nl2() throws RecognitionException {
		Nl2Context _localctx = new Nl2Context(_ctx, getState());
		enterRule(_localctx, 56, RULE_nl2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(379);
				_la = _input.LA(1);
				if (!(_la == LINE_BREAK || _la == VWS)) {
					_errHandler.recoverInline(this);
				} else {
					if (_input.LA(1) == Token.EOF) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttrLeftContext extends ParserRuleContext {
		public TerminalNode LBOLD() {
			return getToken(MdParser.LBOLD, 0);
		}

		public TerminalNode LITALIC() {
			return getToken(MdParser.LITALIC, 0);
		}

		public TerminalNode LSTRIKE() {
			return getToken(MdParser.LSTRIKE, 0);
		}

		public TerminalNode LDQUOTE() {
			return getToken(MdParser.LDQUOTE, 0);
		}

		public TerminalNode LSQUOTE() {
			return getToken(MdParser.LSQUOTE, 0);
		}

		public AttrLeftContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_attrLeft;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).enterAttrLeft(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).exitAttrLeft(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof MdParserVisitor)
				return ((MdParserVisitor<? extends T>) visitor).visitAttrLeft(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttrLeftContext attrLeft() throws RecognitionException {
		AttrLeftContext _localctx = new AttrLeftContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_attrLeft);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(381);
				_la = _input.LA(1);
				if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 34084860461056L) != 0))) {
					_errHandler.recoverInline(this);
				} else {
					if (_input.LA(1) == Token.EOF) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttrRightContext extends ParserRuleContext {
		public TerminalNode RBOLD() {
			return getToken(MdParser.RBOLD, 0);
		}

		public TerminalNode RITALIC() {
			return getToken(MdParser.RITALIC, 0);
		}

		public TerminalNode RSTRIKE() {
			return getToken(MdParser.RSTRIKE, 0);
		}

		public TerminalNode RDQUOTE() {
			return getToken(MdParser.RDQUOTE, 0);
		}

		public TerminalNode RSQUOTE() {
			return getToken(MdParser.RSQUOTE, 0);
		}

		public AttrRightContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_attrRight;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).enterAttrRight(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).exitAttrRight(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof MdParserVisitor)
				return ((MdParserVisitor<? extends T>) visitor).visitAttrRight(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttrRightContext attrRight() throws RecognitionException {
		AttrRightContext _localctx = new AttrRightContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_attrRight);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(383);
				_la = _input.LA(1);
				if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 124L) != 0))) {
					_errHandler.recoverInline(this);
				} else {
					if (_input.LA(1) == Token.EOF) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CommentContext extends ParserRuleContext {
		public TerminalNode COMMENT() {
			return getToken(MdParser.COMMENT, 0);
		}

		public CommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_comment;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).enterComment(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).exitComment(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof MdParserVisitor)
				return ((MdParserVisitor<? extends T>) visitor).visitComment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommentContext comment() throws RecognitionException {
		CommentContext _localctx = new CommentContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_comment);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(385);
				match(COMMENT);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LnBlankContext extends ParserRuleContext {
		public TerminalNode LINE_BLANK() {
			return getToken(MdParser.LINE_BLANK, 0);
		}

		public LnBlankContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_lnBlank;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).enterLnBlank(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).exitLnBlank(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof MdParserVisitor)
				return ((MdParserVisitor<? extends T>) visitor).visitLnBlank(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LnBlankContext lnBlank() throws RecognitionException {
		LnBlankContext _localctx = new LnBlankContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_lnBlank);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(387);
				match(LINE_BLANK);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LnBreakContext extends ParserRuleContext {
		public TerminalNode LINE_BREAK() {
			return getToken(MdParser.LINE_BREAK, 0);
		}

		public LnBreakContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		@Override
		public int getRuleIndex() {
			return RULE_lnBreak;
		}

		@Override
		public void enterRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).enterLnBreak(this);
		}

		@Override
		public void exitRule(ParseTreeListener listener) {
			if (listener instanceof MdParserListener) ((MdParserListener) listener).exitLnBreak(this);
		}

		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if (visitor instanceof MdParserVisitor)
				return ((MdParserVisitor<? extends T>) visitor).visitLnBreak(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LnBreakContext lnBreak() throws RecognitionException {
		LnBreakContext _localctx = new LnBreakContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_lnBreak);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(389);
				match(LINE_BREAK);
			}
		} catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		} finally {
			exitRule();
		}
		return _localctx;
	}

	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
			case 24:
				return note_sempred((NoteContext) _localctx, predIndex);
		}
		return true;
	}

	private boolean note_sempred(NoteContext _localctx, int predIndex) {
		switch (predIndex) {
			case 0:
				return twoSpaces();
		}
		return true;
	}

	public static final String _serializedATN = "\u0004\u0001H\u0188\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"
			+ "\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"
			+ "\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"
			+ "\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"
			+ "\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"
			+ "\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"
			+ "\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"
			+ "\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"
			+ "\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"
			+ "\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"
			+ "\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0001\u0000\u0001"
			+ "\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"
			+ "\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"
			+ "\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000V\b\u0000\n\u0000"
			+ "\f\u0000Y\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"
			+ "\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"
			+ "\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005"
			+ "\u0006k\b\u0006\n\u0006\f\u0006n\t\u0006\u0001\u0006\u0001\u0006\u0001"
			+ "\u0007\u0001\u0007\u0003\u0007t\b\u0007\u0001\u0007\u0003\u0007w\b\u0007"
			+ "\u0001\u0007\u0001\u0007\u0005\u0007{\b\u0007\n\u0007\f\u0007~\t\u0007"
			+ "\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"
			+ "\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"
			+ "\b\u0003\b\u0091\b\b\u0004\b\u0093\b\b\u000b\b\f\b\u0094\u0001\b\u0001"
			+ "\b\u0001\t\u0001\t\u0001\t\u0005\t\u009c\b\t\n\t\f\t\u009f\t\t\u0001\t"
			+ "\u0003\t\u00a2\b\t\u0001\t\u0001\t\u0003\t\u00a6\b\t\u0001\t\u0001\t\u0001"
			+ "\t\u0003\t\u00ab\b\t\u0001\n\u0001\n\u0003\n\u00af\b\n\u0001\u000b\u0001"
			+ "\u000b\u0001\u000b\u0005\u000b\u00b4\b\u000b\n\u000b\f\u000b\u00b7\t\u000b"
			+ "\u0001\u000b\u0001\u000b\u0003\u000b\u00bb\b\u000b\u0001\u000b\u0001\u000b"
			+ "\u0001\u000b\u0001\u000b\u0005\u000b\u00c1\b\u000b\n\u000b\f\u000b\u00c4"
			+ "\t\u000b\u0001\u000b\u0001\u000b\u0001\f\u0003\f\u00c9\b\f\u0001\f\u0003"
			+ "\f\u00cc\b\f\u0001\f\u0004\f\u00cf\b\f\u000b\f\f\f\u00d0\u0001\f\u0003"
			+ "\f\u00d4\b\f\u0001\f\u0003\f\u00d7\b\f\u0001\r\u0001\r\u0001\r\u0001\r"
			+ "\u0005\r\u00dd\b\r\n\r\f\r\u00e0\t\r\u0001\u000e\u0001\u000e\u0001\u000e"
			+ "\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"
			+ "\u0005\u000f\u00eb\b\u000f\n\u000f\f\u000f\u00ee\t\u000f\u0001\u0010\u0001"
			+ "\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003"
			+ "\u0011\u00f7\b\u0011\u0001\u0011\u0003\u0011\u00fa\b\u0011\u0001\u0011"
			+ "\u0001\u0011\u0003\u0011\u00fe\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011"
			+ "\u0001\u0011\u0005\u0011\u0104\b\u0011\n\u0011\f\u0011\u0107\t\u0011\u0001"
			+ "\u0011\u0001\u0011\u0003\u0011\u010b\b\u0011\u0001\u0011\u0001\u0011\u0005"
			+ "\u0011\u010f\b\u0011\n\u0011\f\u0011\u0112\t\u0011\u0001\u0011\u0001\u0011"
			+ "\u0003\u0011\u0116\b\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u011a\b"
			+ "\u0011\u0001\u0011\u0003\u0011\u011d\b\u0011\u0001\u0011\u0001\u0011\u0001"
			+ "\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u0124\b\u0011\u0001\u0011\u0001"
			+ "\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u012a\b\u0011\u0003\u0011\u012c"
			+ "\b\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001"
			+ "\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u0137\b\u0015\n"
			+ "\u0015\f\u0015\u013a\t\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"
			+ "\u0015\u0005\u0015\u0140\b\u0015\n\u0015\f\u0015\u0143\t\u0015\u0001\u0015"
			+ "\u0001\u0015\u0001\u0015\u0003\u0015\u0148\b\u0015\u0001\u0015\u0001\u0015"
			+ "\u0001\u0015\u0003\u0015\u014d\b\u0015\u0001\u0015\u0003\u0015\u0150\b"
			+ "\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001"
			+ "\u0017\u0005\u0017\u0158\b\u0017\n\u0017\f\u0017\u015b\t\u0017\u0001\u0018"
			+ "\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0005\u0018\u0162\b\u0018"
			+ "\n\u0018\f\u0018\u0165\t\u0018\u0001\u0019\u0001\u0019\u0004\u0019\u0169"
			+ "\b\u0019\u000b\u0019\f\u0019\u016a\u0001\u001a\u0005\u001a\u016e\b\u001a"
			+ "\n\u001a\f\u001a\u0171\t\u001a\u0001\u001a\u0001\u001a\u0005\u001a\u0175"
			+ "\b\u001a\n\u001a\f\u001a\u0178\t\u001a\u0001\u001b\u0001\u001b\u0001\u001c"
			+ "\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001f"
			+ "\u0001\u001f\u0001 \u0001 \u0001!\u0001!\u0001!\u0000\u0000\"\u0000\u0002"
			+ "\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"
			+ " \"$&(*,.02468:<>@B\u0000\t\u0002\u0000\u0001\u000111\u0001\u0000\u001f"
			+ " \u0001\u0000#\'\u0001\u000001\u0001\u0000\u0019\u001b\u0001\u0000\u0013"
			+ "\u0014\u0003\u0000\u0001\u0001\u0010\u0011\u0013\u0018\u0001\u0000(,\u0001"
			+ "\u0000\u0002\u0006\u01af\u0000W\u0001\u0000\u0000\u0000\u0002\\\u0001"
			+ "\u0000\u0000\u0000\u0004^\u0001\u0000\u0000\u0000\u0006`\u0001\u0000\u0000"
			+ "\u0000\bb\u0001\u0000\u0000\u0000\nd\u0001\u0000\u0000\u0000\ff\u0001"
			+ "\u0000\u0000\u0000\u000eq\u0001\u0000\u0000\u0000\u0010\u0081\u0001\u0000"
			+ "\u0000\u0000\u0012\u00aa\u0001\u0000\u0000\u0000\u0014\u00ac\u0001\u0000"
			+ "\u0000\u0000\u0016\u00b5\u0001\u0000\u0000\u0000\u0018\u00c8\u0001\u0000"
			+ "\u0000\u0000\u001a\u00d8\u0001\u0000\u0000\u0000\u001c\u00e1\u0001\u0000"
			+ "\u0000\u0000\u001e\u00e4\u0001\u0000\u0000\u0000 \u00ef\u0001\u0000\u0000"
			+ "\u0000\"\u012b\u0001\u0000\u0000\u0000$\u012d\u0001\u0000\u0000\u0000"
			+ "&\u012f\u0001\u0000\u0000\u0000(\u0131\u0001\u0000\u0000\u0000*\u014f"
			+ "\u0001\u0000\u0000\u0000,\u0151\u0001\u0000\u0000\u0000.\u0153\u0001\u0000"
			+ "\u0000\u00000\u015c\u0001\u0000\u0000\u00002\u0168\u0001\u0000\u0000\u0000"
			+ "4\u016f\u0001\u0000\u0000\u00006\u0179\u0001\u0000\u0000\u00008\u017b"
			+ "\u0001\u0000\u0000\u0000:\u017d\u0001\u0000\u0000\u0000<\u017f\u0001\u0000"
			+ "\u0000\u0000>\u0181\u0001\u0000\u0000\u0000@\u0183\u0001\u0000\u0000\u0000"
			+ "B\u0185\u0001\u0000\u0000\u0000DV\u0003\u0002\u0001\u0000EV\u0003\u0004"
			+ "\u0002\u0000FV\u0003\u0006\u0003\u0000GV\u0003\f\u0006\u0000HV\u0003\b"
			+ "\u0004\u0000IV\u0003\n\u0005\u0000JV\u0003\u000e\u0007\u0000KV\u0003>"
			+ "\u001f\u0000LV\u0003\u0012\t\u0000MV\u0003\u0014\n\u0000NV\u0003,\u0016"
			+ "\u0000OV\u0003\u0016\u000b\u0000PV\u0003\u001a\r\u0000QV\u0003\u001e\u000f"
			+ "\u0000RV\u0003@ \u0000SV\u0003B!\u0000TV\u00051\u0000\u0000UD\u0001\u0000"
			+ "\u0000\u0000UE\u0001\u0000\u0000\u0000UF\u0001\u0000\u0000\u0000UG\u0001"
			+ "\u0000\u0000\u0000UH\u0001\u0000\u0000\u0000UI\u0001\u0000\u0000\u0000"
			+ "UJ\u0001\u0000\u0000\u0000UK\u0001\u0000\u0000\u0000UL\u0001\u0000\u0000"
			+ "\u0000UM\u0001\u0000\u0000\u0000UN\u0001\u0000\u0000\u0000UO\u0001\u0000"
			+ "\u0000\u0000UP\u0001\u0000\u0000\u0000UQ\u0001\u0000\u0000\u0000UR\u0001"
			+ "\u0000\u0000\u0000US\u0001\u0000\u0000\u0000UT\u0001\u0000\u0000\u0000"
			+ "VY\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000"
			+ "\u0000XZ\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000Z[\u0005\u0000"
			+ "\u0000\u0001[\u0001\u0001\u0000\u0000\u0000\\]\u0005\u000b\u0000\u0000"
			+ "]\u0003\u0001\u0000\u0000\u0000^_\u0005\f\u0000\u0000_\u0005\u0001\u0000"
			+ "\u0000\u0000`a\u0005\r\u0000\u0000a\u0007\u0001\u0000\u0000\u0000bc\u0005"
			+ "\u000e\u0000\u0000c\t\u0001\u0000\u0000\u0000de\u0005\u000f\u0000\u0000"
			+ "e\u000b\u0001\u0000\u0000\u0000fl\u0005\t\u0000\u0000gk\u0005\u0007\u0000"
			+ "\u0000hk\u00032\u0019\u0000ik\u00036\u001b\u0000jg\u0001\u0000\u0000\u0000"
			+ "jh\u0001\u0000\u0000\u0000ji\u0001\u0000\u0000\u0000kn\u0001\u0000\u0000"
			+ "\u0000lj\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000mo\u0001\u0000"
			+ "\u0000\u0000nl\u0001\u0000\u0000\u0000op\u0005\n\u0000\u0000p\r\u0001"
			+ "\u0000\u0000\u0000qs\u0005\b\u0000\u0000rt\u0005\u0001\u0000\u0000sr\u0001"
			+ "\u0000\u0000\u0000st\u0001\u0000\u0000\u0000tv\u0001\u0000\u0000\u0000"
			+ "uw\u0003\u0010\b\u0000vu\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000"
			+ "wx\u0001\u0000\u0000\u0000x|\u00051\u0000\u0000y{\u0007\u0000\u0000\u0000"
			+ "zy\u0001\u0000\u0000\u0000{~\u0001\u0000\u0000\u0000|z\u0001\u0000\u0000"
			+ "\u0000|}\u0001\u0000\u0000\u0000}\u007f\u0001\u0000\u0000\u0000~|\u0001"
			+ "\u0000\u0000\u0000\u007f\u0080\u0005>\u0000\u0000\u0080\u000f\u0001\u0000"
			+ "\u0000\u0000\u0081\u0092\u0005\u0012\u0000\u0000\u0082\u0093\u0005:\u0000"
			+ "\u0000\u0083\u0084\u00057\u0000\u0000\u0084\u0093\u0005\u0001\u0000\u0000"
			+ "\u0085\u0086\u00058\u0000\u0000\u0086\u0093\u0005\u0001\u0000\u0000\u0087"
			+ "\u0088\u0005\u0001\u0000\u0000\u0088\u0090\u00059\u0000\u0000\u0089\u008a"
			+ "\u0005<\u0000\u0000\u008a\u008b\u0005\u0001\u0000\u0000\u008b\u0091\u0005"
			+ "<\u0000\u0000\u008c\u008d\u0005;\u0000\u0000\u008d\u008e\u0005\u0001\u0000"
			+ "\u0000\u008e\u0091\u0005;\u0000\u0000\u008f\u0091\u0005\u0001\u0000\u0000"
			+ "\u0090\u0089\u0001\u0000\u0000\u0000\u0090\u008c\u0001\u0000\u0000\u0000"
			+ "\u0090\u008f\u0001\u0000\u0000\u0000\u0091\u0093\u0001\u0000\u0000\u0000"
			+ "\u0092\u0082\u0001\u0000\u0000\u0000\u0092\u0083\u0001\u0000\u0000\u0000"
			+ "\u0092\u0085\u0001\u0000\u0000\u0000\u0092\u0087\u0001\u0000\u0000\u0000"
			+ "\u0093\u0094\u0001\u0000\u0000\u0000\u0094\u0092\u0001\u0000\u0000\u0000"
			+ "\u0094\u0095\u0001\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000\u0000"
			+ "\u0096\u0097\u00056\u0000\u0000\u0097\u0011\u0001\u0000\u0000\u0000\u0098"
			+ "\u0099\u0005\u001e\u0000\u0000\u0099\u009d\u00032\u0019\u0000\u009a\u009c"
			+ "\u00054\u0000\u0000\u009b\u009a\u0001\u0000\u0000\u0000\u009c\u009f\u0001"
			+ "\u0000\u0000\u0000\u009d\u009b\u0001\u0000\u0000\u0000\u009d\u009e\u0001"
			+ "\u0000\u0000\u0000\u009e\u00a1\u0001\u0000\u0000\u0000\u009f\u009d\u0001"
			+ "\u0000\u0000\u0000\u00a0\u00a2\u0003\u0010\b\u0000\u00a1\u00a0\u0001\u0000"
			+ "\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000\u0000\u00a2\u00ab\u0001\u0000"
			+ "\u0000\u0000\u00a3\u00a5\u00032\u0019\u0000\u00a4\u00a6\u0003\u0010\b"
			+ "\u0000\u00a5\u00a4\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000"
			+ "\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7\u00a8\u00036\u001b\u0000"
			+ "\u00a8\u00a9\u0007\u0001\u0000\u0000\u00a9\u00ab\u0001\u0000\u0000\u0000"
			+ "\u00aa\u0098\u0001\u0000\u0000\u0000\u00aa\u00a3\u0001\u0000\u0000\u0000"
			+ "\u00ab\u0013\u0001\u0000\u0000\u0000\u00ac\u00ae\u0005!\u0000\u0000\u00ad"
			+ "\u00af\u0003\u0010\b\u0000\u00ae\u00ad\u0001\u0000\u0000\u0000\u00ae\u00af"
			+ "\u0001\u0000\u0000\u0000\u00af\u0015\u0001\u0000\u0000\u0000\u00b0\u00b1"
			+ "\u0003\u0018\f\u0000\u00b1\u00b2\u00036\u001b\u0000\u00b2\u00b4\u0001"
			+ "\u0000\u0000\u0000\u00b3\u00b0\u0001\u0000\u0000\u0000\u00b4\u00b7\u0001"
			+ "\u0000\u0000\u0000\u00b5\u00b3\u0001\u0000\u0000\u0000\u00b5\u00b6\u0001"
			+ "\u0000\u0000\u0000\u00b6\u00b8\u0001\u0000\u0000\u0000\u00b7\u00b5\u0001"
			+ "\u0000\u0000\u0000\u00b8\u00ba\u0005\u001c\u0000\u0000\u00b9\u00bb\u0003"
			+ "\u0010\b\u0000\u00ba\u00b9\u0001\u0000\u0000\u0000\u00ba\u00bb\u0001\u0000"
			+ "\u0000\u0000\u00bb\u00bc\u0001\u0000\u0000\u0000\u00bc\u00c2\u00036\u001b"
			+ "\u0000\u00bd\u00be\u0003\u0018\f\u0000\u00be\u00bf\u00036\u001b\u0000"
			+ "\u00bf\u00c1\u0001\u0000\u0000\u0000\u00c0\u00bd\u0001\u0000\u0000\u0000"
			+ "\u00c1\u00c4\u0001\u0000\u0000\u0000\u00c2\u00c0\u0001\u0000\u0000\u0000"
			+ "\u00c2\u00c3\u0001\u0000\u0000\u0000\u00c3\u00c5\u0001\u0000\u0000\u0000"
			+ "\u00c4\u00c2\u0001\u0000\u0000\u0000\u00c5\u00c6\u0003\u0018\f\u0000\u00c6"
			+ "\u0017\u0001\u0000\u0000\u0000\u00c7\u00c9\u0005\u001d\u0000\u0000\u00c8"
			+ "\u00c7\u0001\u0000\u0000\u0000\u00c8\u00c9\u0001\u0000\u0000\u0000\u00c9"
			+ "\u00ce\u0001\u0000\u0000\u0000\u00ca\u00cc\u00032\u0019\u0000\u00cb\u00ca"
			+ "\u0001\u0000\u0000\u0000\u00cb\u00cc\u0001\u0000\u0000\u0000\u00cc\u00cd"
			+ "\u0001\u0000\u0000\u0000\u00cd\u00cf\u0005\u001d\u0000\u0000\u00ce\u00cb"
			+ "\u0001\u0000\u0000\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000\u00d0\u00ce"
			+ "\u0001\u0000\u0000\u0000\u00d0\u00d1\u0001\u0000\u0000\u0000\u00d1\u00d3"
			+ "\u0001\u0000\u0000\u0000\u00d2\u00d4\u00032\u0019\u0000\u00d3\u00d2\u0001"
			+ "\u0000\u0000\u0000\u00d3\u00d4\u0001\u0000\u0000\u0000\u00d4\u00d6\u0001"
			+ "\u0000\u0000\u0000\u00d5\u00d7\u0005\u001d\u0000\u0000\u00d6\u00d5\u0001"
			+ "\u0000\u0000\u0000\u00d6\u00d7\u0001\u0000\u0000\u0000\u00d7\u0019\u0001"
			+ "\u0000\u0000\u0000\u00d8\u00de\u0003\u001c\u000e\u0000\u00d9\u00da\u0003"
			+ "6\u001b\u0000\u00da\u00db\u0003\u001c\u000e\u0000\u00db\u00dd\u0001\u0000"
			+ "\u0000\u0000\u00dc\u00d9\u0001\u0000\u0000\u0000\u00dd\u00e0\u0001\u0000"
			+ "\u0000\u0000\u00de\u00dc\u0001\u0000\u0000\u0000\u00de\u00df\u0001\u0000"
			+ "\u0000\u0000\u00df\u001b\u0001\u0000\u0000\u0000\u00e0\u00de\u0001\u0000"
			+ "\u0000\u0000\u00e1\u00e2\u0007\u0002\u0000\u0000\u00e2\u00e3\u0003.\u0017"
			+ "\u0000\u00e3\u001d\u0001\u0000\u0000\u0000\u00e4\u00e5\u00032\u0019\u0000"
			+ "\u00e5\u00e6\u00036\u001b\u0000\u00e6\u00ec\u0003 \u0010\u0000\u00e7\u00e8"
			+ "\u00036\u001b\u0000\u00e8\u00e9\u0003 \u0010\u0000\u00e9\u00eb\u0001\u0000"
			+ "\u0000\u0000\u00ea\u00e7\u0001\u0000\u0000\u0000\u00eb\u00ee\u0001\u0000"
			+ "\u0000\u0000\u00ec\u00ea\u0001\u0000\u0000\u0000\u00ec\u00ed\u0001\u0000"
			+ "\u0000\u0000\u00ed\u001f\u0001\u0000\u0000\u0000\u00ee\u00ec\u0001\u0000"
			+ "\u0000\u0000\u00ef\u00f0\u0005\"\u0000\u0000\u00f0\u00f1\u0003.\u0017"
			+ "\u0000\u00f1!\u0001\u0000\u0000\u0000\u00f2\u00f3\u0003$\u0012\u0000\u00f3"
			+ "\u00f4\u00032\u0019\u0000\u00f4\u00f6\u0005A\u0000\u0000\u00f5\u00f7\u0003"
			+ "(\u0014\u0000\u00f6\u00f5\u0001\u0000\u0000\u0000\u00f6\u00f7\u0001\u0000"
			+ "\u0000\u0000\u00f7\u00f9\u0001\u0000\u0000\u0000\u00f8\u00fa\u0003*\u0015"
			+ "\u0000\u00f9\u00f8\u0001\u0000\u0000\u0000\u00f9\u00fa\u0001\u0000\u0000"
			+ "\u0000\u00fa\u00fb\u0001\u0000\u0000\u0000\u00fb\u00fd\u0005F\u0000\u0000"
			+ "\u00fc\u00fe\u0003\u0010\b\u0000\u00fd\u00fc\u0001\u0000\u0000\u0000\u00fd"
			+ "\u00fe\u0001\u0000\u0000\u0000\u00fe\u012c\u0001\u0000\u0000\u0000\u00ff"
			+ "\u0100\u0003$\u0012\u0000\u0100\u0101\u00032\u0019\u0000\u0101\u0105\u0005"
			+ "B\u0000\u0000\u0102\u0104\u00034\u001a\u0000\u0103\u0102\u0001\u0000\u0000"
			+ "\u0000\u0104\u0107\u0001\u0000\u0000\u0000\u0105\u0103\u0001\u0000\u0000"
			+ "\u0000\u0105\u0106\u0001\u0000\u0000\u0000\u0106\u0108\u0001\u0000\u0000"
			+ "\u0000\u0107\u0105\u0001\u0000\u0000\u0000\u0108\u010a\u0005D\u0000\u0000"
			+ "\u0109\u010b\u0003\u0010\b\u0000\u010a\u0109\u0001\u0000\u0000\u0000\u010a"
			+ "\u010b\u0001\u0000\u0000\u0000\u010b\u012c\u0001\u0000\u0000\u0000\u010c"
			+ "\u0110\u0003&\u0013\u0000\u010d\u010f\u00034\u001a\u0000\u010e\u010d\u0001"
			+ "\u0000\u0000\u0000\u010f\u0112\u0001\u0000\u0000\u0000\u0110\u010e\u0001"
			+ "\u0000\u0000\u0000\u0110\u0111\u0001\u0000\u0000\u0000\u0111\u0113\u0001"
			+ "\u0000\u0000\u0000\u0112\u0110\u0001\u0000\u0000\u0000\u0113\u0115\u0005"
			+ "C\u0000\u0000\u0114\u0116\u0007\u0003\u0000\u0000\u0115\u0114\u0001\u0000"
			+ "\u0000\u0000\u0115\u0116\u0001\u0000\u0000\u0000\u0116\u0117\u0001\u0000"
			+ "\u0000\u0000\u0117\u011c\u0003(\u0014\u0000\u0118\u011a\u0007\u0003\u0000"
			+ "\u0000\u0119\u0118\u0001\u0000\u0000\u0000\u0119\u011a\u0001\u0000\u0000"
			+ "\u0000\u011a\u011b\u0001\u0000\u0000\u0000\u011b\u011d\u0003*\u0015\u0000"
			+ "\u011c\u0119\u0001\u0000\u0000\u0000\u011c\u011d\u0001\u0000\u0000\u0000"
			+ "\u011d\u012c\u0001\u0000\u0000\u0000\u011e\u011f\u0005\u001a\u0000\u0000"
			+ "\u011f\u0120\u00034\u001a\u0000\u0120\u0121\u0005C\u0000\u0000\u0121\u0123"
			+ "\u00030\u0018\u0000\u0122\u0124\u0003\u0010\b\u0000\u0123\u0122\u0001"
			+ "\u0000\u0000\u0000\u0123\u0124\u0001\u0000\u0000\u0000\u0124\u012c\u0001"
			+ "\u0000\u0000\u0000\u0125\u0126\u0003$\u0012\u0000\u0126\u0127\u00032\u0019"
			+ "\u0000\u0127\u0129\u0005D\u0000\u0000\u0128\u012a\u0003\u0010\b\u0000"
			+ "\u0129\u0128\u0001\u0000\u0000\u0000\u0129\u012a\u0001\u0000\u0000\u0000"
			+ "\u012a\u012c\u0001\u0000\u0000\u0000\u012b\u00f2\u0001\u0000\u0000\u0000"
			+ "\u012b\u00ff\u0001\u0000\u0000\u0000\u012b\u010c\u0001\u0000\u0000\u0000"
			+ "\u012b\u011e\u0001\u0000\u0000\u0000\u012b\u0125\u0001\u0000\u0000\u0000"
			+ "\u012c#\u0001\u0000\u0000\u0000\u012d\u012e\u0007\u0004\u0000\u0000\u012e"
			+ "%\u0001\u0000\u0000\u0000\u012f\u0130\u0005\u001b\u0000\u0000\u0130\'"
			+ "\u0001\u0000\u0000\u0000\u0131\u0132\u0007\u0005\u0000\u0000\u0132)\u0001"
			+ "\u0000\u0000\u0000\u0133\u0138\u0005;\u0000\u0000\u0134\u0137\u00034\u001a"
			+ "\u0000\u0135\u0137\u0005<\u0000\u0000\u0136\u0134\u0001\u0000\u0000\u0000"
			+ "\u0136\u0135\u0001\u0000\u0000\u0000\u0137\u013a\u0001\u0000\u0000\u0000"
			+ "\u0138\u0136\u0001\u0000\u0000\u0000\u0138\u0139\u0001\u0000\u0000\u0000"
			+ "\u0139\u013b\u0001\u0000\u0000\u0000\u013a\u0138\u0001\u0000\u0000\u0000"
			+ "\u013b\u0150\u0005;\u0000\u0000\u013c\u0141\u0005<\u0000\u0000\u013d\u0140"
			+ "\u00034\u001a\u0000\u013e\u0140\u0005;\u0000\u0000\u013f\u013d\u0001\u0000"
			+ "\u0000\u0000\u013f\u013e\u0001\u0000\u0000\u0000\u0140\u0143\u0001\u0000"
			+ "\u0000\u0000\u0141\u013f\u0001\u0000\u0000\u0000\u0141\u0142\u0001\u0000"
			+ "\u0000\u0000\u0142\u0144\u0001\u0000\u0000\u0000\u0143\u0141\u0001\u0000"
			+ "\u0000\u0000\u0144\u0150\u0005<\u0000\u0000\u0145\u0147\u0005+\u0000\u0000"
			+ "\u0146\u0148\u00032\u0019\u0000\u0147\u0146\u0001\u0000\u0000\u0000\u0147"
			+ "\u0148\u0001\u0000\u0000\u0000\u0148\u0149\u0001\u0000\u0000\u0000\u0149"
			+ "\u0150\u0005\u0005\u0000\u0000\u014a\u014c\u0005,\u0000\u0000\u014b\u014d"
			+ "\u00032\u0019\u0000\u014c\u014b\u0001\u0000\u0000\u0000\u014c\u014d\u0001"
			+ "\u0000\u0000\u0000\u014d\u014e\u0001\u0000\u0000\u0000\u014e\u0150\u0005"
			+ "\u0006\u0000\u0000\u014f\u0133\u0001\u0000\u0000\u0000\u014f\u013c\u0001"
			+ "\u0000\u0000\u0000\u014f\u0145\u0001\u0000\u0000\u0000\u014f\u014a\u0001"
			+ "\u0000\u0000\u0000\u0150+\u0001\u0000\u0000\u0000\u0151\u0152\u0003.\u0017"
			+ "\u0000\u0152-\u0001\u0000\u0000\u0000\u0153\u0159\u00032\u0019\u0000\u0154"
			+ "\u0155\u00036\u001b\u0000\u0155\u0156\u00032\u0019\u0000\u0156\u0158\u0001"
			+ "\u0000\u0000\u0000\u0157\u0154\u0001\u0000\u0000\u0000\u0158\u015b\u0001"
			+ "\u0000\u0000\u0000\u0159\u0157\u0001\u0000\u0000\u0000\u0159\u015a\u0001"
			+ "\u0000\u0000\u0000\u015a/\u0001\u0000\u0000\u0000\u015b\u0159\u0001\u0000"
			+ "\u0000\u0000\u015c\u0163\u00032\u0019\u0000\u015d\u015e\u00036\u001b\u0000"
			+ "\u015e\u015f\u0004\u0018\u0000\u0000\u015f\u0160\u00032\u0019\u0000\u0160"
			+ "\u0162\u0001\u0000\u0000\u0000\u0161\u015d\u0001\u0000\u0000\u0000\u0162"
			+ "\u0165\u0001\u0000\u0000\u0000\u0163\u0161\u0001\u0000\u0000\u0000\u0163"
			+ "\u0164\u0001\u0000\u0000\u0000\u01641\u0001\u0000\u0000\u0000\u0165\u0163"
			+ "\u0001\u0000\u0000\u0000\u0166\u0169\u00034\u001a\u0000\u0167\u0169\u0003"
			+ "\"\u0011\u0000\u0168\u0166\u0001\u0000\u0000\u0000\u0168\u0167\u0001\u0000"
			+ "\u0000\u0000\u0169\u016a\u0001\u0000\u0000\u0000\u016a\u0168\u0001\u0000"
			+ "\u0000\u0000\u016a\u016b\u0001\u0000\u0000\u0000\u016b3\u0001\u0000\u0000"
			+ "\u0000\u016c\u016e\u0003:\u001d\u0000\u016d\u016c\u0001\u0000\u0000\u0000"
			+ "\u016e\u0171\u0001\u0000\u0000\u0000\u016f\u016d\u0001\u0000\u0000\u0000"
			+ "\u016f\u0170\u0001\u0000\u0000\u0000\u0170\u0172\u0001\u0000\u0000\u0000"
			+ "\u0171\u016f\u0001\u0000\u0000\u0000\u0172\u0176\u0007\u0006\u0000\u0000"
			+ "\u0173\u0175\u0003<\u001e\u0000\u0174\u0173\u0001\u0000\u0000\u0000\u0175"
			+ "\u0178\u0001\u0000\u0000\u0000\u0176\u0174\u0001\u0000\u0000\u0000\u0176"
			+ "\u0177\u0001\u0000\u0000\u0000\u01775\u0001\u0000\u0000\u0000\u0178\u0176"
			+ "\u0001\u0000\u0000\u0000\u0179\u017a\u0007\u0003\u0000\u0000\u017a7\u0001"
			+ "\u0000\u0000\u0000\u017b\u017c\u0007\u0003\u0000\u0000\u017c9\u0001\u0000"
			+ "\u0000\u0000\u017d\u017e\u0007\u0007\u0000\u0000\u017e;\u0001\u0000\u0000"
			+ "\u0000\u017f\u0180\u0007\b\u0000\u0000\u0180=\u0001\u0000\u0000\u0000"
			+ "\u0181\u0182\u0005\u0007\u0000\u0000\u0182?\u0001\u0000\u0000\u0000\u0183"
			+ "\u0184\u0005/\u0000\u0000\u0184A\u0001\u0000\u0000\u0000\u0185\u0186\u0005"
			+ "0\u0000\u0000\u0186C\u0001\u0000\u0000\u00002UWjlsv|\u0090\u0092\u0094"
			+ "\u009d\u00a1\u00a5\u00aa\u00ae\u00b5\u00ba\u00c2\u00c8\u00cb\u00d0\u00d3"
			+ "\u00d6\u00de\u00ec\u00f6\u00f9\u00fd\u0105\u010a\u0110\u0115\u0119\u011c"
			+ "\u0123\u0129\u012b\u0136\u0138\u013f\u0141\u0147\u014c\u014f\u0159\u0163"
			+ "\u0168\u016a\u016f\u0176";
	public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
