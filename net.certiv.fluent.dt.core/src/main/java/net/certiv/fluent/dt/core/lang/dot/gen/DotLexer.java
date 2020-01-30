// Generated from D:/DevFiles/Eclipse/Tools/Editors/net.certiv.fluent.dt/net.certiv.fluent.dt.core/src/main/java/net/certiv/fluent/dt/core/lang/dot/DotLexer.g4 by ANTLR 4.7.2

	package net.certiv.fluent.dt.core.lang.dot.gen;
	import net.certiv.fluent.dt.core.lang.dot.LexerBase; 

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DotLexer extends LexerBase {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

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
		DOT=1;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "DOT"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"DOTCODE", "DOT_END", "DOTUML", "VWS", "HWS", "OTHER", "UMLBEG", "GRAPH", 
			"LBRACE", "RBRACE", "UMLEND", "DOTEND", "RGB", "HSV", "POINT", "RECT", 
			"COLORS", "STRING", "SPLINE", "SPOINT", "HTML", "NUMBER", "ML_COMMENT", 
			"SL_COMMENT", "COMMA", "SEMI", "LBRACK", "RBRACK", "COLON", "EQ", "DIRECTED", 
			"UNDIRECTED", "SUBGRAPH", "NODE", "EDGE", "N", "NE", "E", "SE", "S", 
			"SW", "W", "NW", "C", "ID", "VX", "HX", "ERR", "CodeMark", "Vws", "Hws", 
			"Alpha", "Html", "RgbSeq", "HsvSeq", "Color", "SplineStart", "SplineEnd", 
			"Decimal", "UDecimal", "Fract", "Digit", "HexDigit", "HsvDigit", "EscSeq", 
			"UnicodeEsc", "Quote", "TagOpen", "TagClose", "Esc", "Colon", "LParen", 
			"RParen", "LBrace", "RBrace", "LBrack", "RBrack", "Question", "Bang", 
			"Star", "Slash", "Percent", "Caret", "Plus", "Minus", "Underscore", "Pipe", 
			"Dollar", "Comma", "Semi", "Dot", "At", "Pound", "Tilde"
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


	public DotLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "DotLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0:
			return DOTCODE_sempred((RuleContext)_localctx, predIndex);
		case 1:
			return DOT_END_sempred((RuleContext)_localctx, predIndex);
		case 2:
			return DOTUML_sempred((RuleContext)_localctx, predIndex);
		case 6:
			return UMLBEG_sempred((RuleContext)_localctx, predIndex);
		case 7:
			return GRAPH_sempred((RuleContext)_localctx, predIndex);
		case 10:
			return UMLEND_sempred((RuleContext)_localctx, predIndex);
		case 11:
			return DOTEND_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean DOTCODE_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return  at() ;
		}
		return true;
	}
	private boolean DOT_END_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return  at() ;
		}
		return true;
	}
	private boolean DOTUML_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return  at() ;
		}
		return true;
	}
	private boolean UMLBEG_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return  at() ;
		}
		return true;
	}
	private boolean GRAPH_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return  at() ;
		}
		return true;
	}
	private boolean UMLEND_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return  at() ;
		}
		return true;
	}
	private boolean DOTEND_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return  at() ;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2)\u02c2\b\1\b\1\4"+
		"\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n"+
		"\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4"+
		"I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\t"+
		"T\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_"+
		"\3\2\3\2\7\2\u00c3\n\2\f\2\16\2\u00c6\13\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\6\t\u0106\n\t\r\t\16\t\u0107\5\t\u010a\n\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0118\n\t\3\t\3\t\3\n\3\n\3\n\3\n"+
		"\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\20\5\20\u0144\n\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\6\22\u0157\n\22\r\22"+
		"\16\22\u0158\3\22\3\22\3\23\3\23\3\23\7\23\u0160\n\23\f\23\16\23\u0163"+
		"\13\23\3\23\3\23\3\24\3\24\3\24\3\24\6\24\u016b\n\24\r\24\16\24\u016c"+
		"\3\25\5\25\u0170\n\25\3\25\5\25\u0173\n\25\3\25\3\25\3\25\3\25\3\25\6"+
		"\25\u017a\n\25\r\25\16\25\u017b\3\26\3\26\3\26\3\26\7\26\u0182\n\26\f"+
		"\26\16\26\u0185\13\26\3\26\3\26\3\27\5\27\u018a\n\27\3\27\3\27\6\27\u018e"+
		"\n\27\r\27\16\27\u018f\3\27\6\27\u0193\n\27\r\27\16\27\u0194\3\27\3\27"+
		"\7\27\u0199\n\27\f\27\16\27\u019c\13\27\5\27\u019e\n\27\5\27\u01a0\n\27"+
		"\3\30\3\30\3\30\3\30\7\30\u01a6\n\30\f\30\16\30\u01a9\13\30\3\30\3\30"+
		"\3\30\3\31\3\31\3\31\5\31\u01b1\n\31\3\31\7\31\u01b4\n\31\f\31\16\31\u01b7"+
		"\13\31\3\31\5\31\u01ba\n\31\3\31\3\31\5\31\u01be\n\31\3\32\3\32\3\33\3"+
		"\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\""+
		"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3%\3%\3&\3"+
		"&\3&\3\'\3\'\3(\3(\3(\3)\3)\3*\3*\3*\3+\3+\3,\3,\3,\3-\3-\3.\3.\3.\7."+
		"\u01fe\n.\f.\16.\u0201\13.\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\61"+
		"\3\61\3\61\3\61\3\62\3\62\3\62\3\62\6\62\u0215\n\62\r\62\16\62\u0216\3"+
		"\62\3\62\3\62\3\62\6\62\u021d\n\62\r\62\16\62\u021e\5\62\u0221\n\62\3"+
		"\63\3\63\3\64\3\64\3\65\5\65\u0228\n\65\3\66\6\66\u022b\n\66\r\66\16\66"+
		"\u022c\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\5\67\u0239\n"+
		"\67\38\38\38\38\39\69\u0240\n9\r9\169\u0241\39\39\39\59\u0247\n9\3:\3"+
		":\3:\3:\3:\3:\3;\3;\3;\3;\3;\3;\3<\5<\u0256\n<\3<\3<\3=\6=\u025b\n=\r"+
		"=\16=\u025c\3=\3=\7=\u0261\n=\f=\16=\u0264\13=\3>\3>\3>\6>\u0269\n>\r"+
		">\16>\u026a\3?\3?\3@\3@\3A\3A\3A\3A\3A\3A\3B\3B\3B\3B\3B\5B\u027c\nB\3"+
		"C\3C\3C\3C\3C\5C\u0283\nC\5C\u0285\nC\5C\u0287\nC\5C\u0289\nC\3D\3D\3"+
		"E\3E\3F\3F\3G\3G\3H\3H\3I\3I\3J\3J\3K\3K\3L\3L\3M\3M\3N\3N\3O\3O\3P\3"+
		"P\3Q\3Q\3R\3R\3S\3S\3T\3T\3U\3U\3V\3V\3W\3W\3X\3X\3Y\3Y\3Z\3Z\3[\3[\3"+
		"\\\3\\\3]\3]\3^\3^\3_\3_\4\u01a7\u01b5\2`\4\2\6\2\b\2\n\3\f\4\16\5\20"+
		"\2\22\6\24\7\26\b\30\2\32\2\34\t\36\n \13\"\f$\r&\16(\17*\20,\21.\22\60"+
		"\23\62\24\64\25\66\268\27:\30<\31>\32@\33B\34D\35F\36H\37J L!N\"P#R$T"+
		"%V&X\'Z(\\)^\2`\2b\2d\2f\2h\2j\2l\2n\2p\2r\2t\2v\2x\2z\2|\2~\2\u0080\2"+
		"\u0082\2\u0084\2\u0086\2\u0088\2\u008a\2\u008c\2\u008e\2\u0090\2\u0092"+
		"\2\u0094\2\u0096\2\u0098\2\u009a\2\u009c\2\u009e\2\u00a0\2\u00a2\2\u00a4"+
		"\2\u00a6\2\u00a8\2\u00aa\2\u00ac\2\u00ae\2\u00b0\2\u00b2\2\u00b4\2\u00b6"+
		"\2\u00b8\2\u00ba\2\u00bc\2\u00be\2\4\2\3\f\6\2\f\f\17\17$$^^\4\2\f\f\16"+
		"\17\4\2\13\13\"\"\6\2C\\aac|\u0082\u0101\4\2>>@@\4\2--//\3\2\62;\5\2\62"+
		";CHch\3\2\62\63\n\2$$))^^ddhhppttvv\2\u02c0\2\4\3\2\2\2\2\6\3\2\2\2\2"+
		"\b\3\2\2\2\2\n\3\2\2\2\2\f\3\2\2\2\2\16\3\2\2\2\3\20\3\2\2\2\3\22\3\2"+
		"\2\2\3\24\3\2\2\2\3\26\3\2\2\2\3\30\3\2\2\2\3\32\3\2\2\2\3\34\3\2\2\2"+
		"\3\36\3\2\2\2\3 \3\2\2\2\3\"\3\2\2\2\3$\3\2\2\2\3&\3\2\2\2\3(\3\2\2\2"+
		"\3*\3\2\2\2\3,\3\2\2\2\3.\3\2\2\2\3\60\3\2\2\2\3\62\3\2\2\2\3\64\3\2\2"+
		"\2\3\66\3\2\2\2\38\3\2\2\2\3:\3\2\2\2\3<\3\2\2\2\3>\3\2\2\2\3@\3\2\2\2"+
		"\3B\3\2\2\2\3D\3\2\2\2\3F\3\2\2\2\3H\3\2\2\2\3J\3\2\2\2\3L\3\2\2\2\3N"+
		"\3\2\2\2\3P\3\2\2\2\3R\3\2\2\2\3T\3\2\2\2\3V\3\2\2\2\3X\3\2\2\2\3Z\3\2"+
		"\2\2\3\\\3\2\2\2\3^\3\2\2\2\3`\3\2\2\2\3b\3\2\2\2\4\u00c0\3\2\2\2\6\u00d0"+
		"\3\2\2\2\b\u00d5\3\2\2\2\n\u00e4\3\2\2\2\f\u00e8\3\2\2\2\16\u00ec\3\2"+
		"\2\2\20\u00ee\3\2\2\2\22\u0109\3\2\2\2\24\u011b\3\2\2\2\26\u011f\3\2\2"+
		"\2\30\u0123\3\2\2\2\32\u0130\3\2\2\2\34\u0136\3\2\2\2\36\u013a\3\2\2\2"+
		" \u013e\3\2\2\2\"\u0147\3\2\2\2$\u0151\3\2\2\2&\u015c\3\2\2\2(\u0166\3"+
		"\2\2\2*\u016f\3\2\2\2,\u017d\3\2\2\2.\u0189\3\2\2\2\60\u01a1\3\2\2\2\62"+
		"\u01bd\3\2\2\2\64\u01bf\3\2\2\2\66\u01c1\3\2\2\28\u01c3\3\2\2\2:\u01c5"+
		"\3\2\2\2<\u01c7\3\2\2\2>\u01c9\3\2\2\2@\u01cb\3\2\2\2B\u01ce\3\2\2\2D"+
		"\u01d1\3\2\2\2F\u01da\3\2\2\2H\u01df\3\2\2\2J\u01e4\3\2\2\2L\u01e6\3\2"+
		"\2\2N\u01e9\3\2\2\2P\u01eb\3\2\2\2R\u01ee\3\2\2\2T\u01f0\3\2\2\2V\u01f3"+
		"\3\2\2\2X\u01f5\3\2\2\2Z\u01f8\3\2\2\2\\\u01fa\3\2\2\2^\u0202\3\2\2\2"+
		"`\u0207\3\2\2\2b\u020c\3\2\2\2d\u0220\3\2\2\2f\u0222\3\2\2\2h\u0224\3"+
		"\2\2\2j\u0227\3\2\2\2l\u022a\3\2\2\2n\u022e\3\2\2\2p\u023a\3\2\2\2r\u023f"+
		"\3\2\2\2t\u0248\3\2\2\2v\u024e\3\2\2\2x\u0255\3\2\2\2z\u025a\3\2\2\2|"+
		"\u0265\3\2\2\2~\u026c\3\2\2\2\u0080\u026e\3\2\2\2\u0082\u0270\3\2\2\2"+
		"\u0084\u0276\3\2\2\2\u0086\u027d\3\2\2\2\u0088\u028a\3\2\2\2\u008a\u028c"+
		"\3\2\2\2\u008c\u028e\3\2\2\2\u008e\u0290\3\2\2\2\u0090\u0292\3\2\2\2\u0092"+
		"\u0294\3\2\2\2\u0094\u0296\3\2\2\2\u0096\u0298\3\2\2\2\u0098\u029a\3\2"+
		"\2\2\u009a\u029c\3\2\2\2\u009c\u029e\3\2\2\2\u009e\u02a0\3\2\2\2\u00a0"+
		"\u02a2\3\2\2\2\u00a2\u02a4\3\2\2\2\u00a4\u02a6\3\2\2\2\u00a6\u02a8\3\2"+
		"\2\2\u00a8\u02aa\3\2\2\2\u00aa\u02ac\3\2\2\2\u00ac\u02ae\3\2\2\2\u00ae"+
		"\u02b0\3\2\2\2\u00b0\u02b2\3\2\2\2\u00b2\u02b4\3\2\2\2\u00b4\u02b6\3\2"+
		"\2\2\u00b6\u02b8\3\2\2\2\u00b8\u02ba\3\2\2\2\u00ba\u02bc\3\2\2\2\u00bc"+
		"\u02be\3\2\2\2\u00be\u02c0\3\2\2\2\u00c0\u00c4\5d\62\2\u00c1\u00c3\5h"+
		"\64\2\u00c2\u00c1\3\2\2\2\u00c3\u00c6\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4"+
		"\u00c5\3\2\2\2\u00c5\u00c7\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c7\u00c8\7f"+
		"\2\2\u00c8\u00c9\7q\2\2\u00c9\u00ca\7v\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cc"+
		"\6\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00ce\b\2\2\2\u00ce\u00cf\b\2\3\2\u00cf"+
		"\5\3\2\2\2\u00d0\u00d1\5d\62\2\u00d1\u00d2\6\3\3\2\u00d2\u00d3\3\2\2\2"+
		"\u00d3\u00d4\b\3\2\2\u00d4\7\3\2\2\2\u00d5\u00d6\7B\2\2\u00d6\u00d7\7"+
		"u\2\2\u00d7\u00d8\7v\2\2\u00d8\u00d9\7c\2\2\u00d9\u00da\7t\2\2\u00da\u00db"+
		"\7v\2\2\u00db\u00dc\7f\2\2\u00dc\u00dd\7q\2\2\u00dd\u00de\7v\2\2\u00de"+
		"\u00df\3\2\2\2\u00df\u00e0\6\4\4\2\u00e0\u00e1\3\2\2\2\u00e1\u00e2\b\4"+
		"\2\2\u00e2\u00e3\b\4\3\2\u00e3\t\3\2\2\2\u00e4\u00e5\5f\63\2\u00e5\u00e6"+
		"\3\2\2\2\u00e6\u00e7\b\5\4\2\u00e7\13\3\2\2\2\u00e8\u00e9\5h\64\2\u00e9"+
		"\u00ea\3\2\2\2\u00ea\u00eb\b\6\4\2\u00eb\r\3\2\2\2\u00ec\u00ed\13\2\2"+
		"\2\u00ed\17\3\2\2\2\u00ee\u00ef\7B\2\2\u00ef\u00f0\7u\2\2\u00f0\u00f1"+
		"\7v\2\2\u00f1\u00f2\7c\2\2\u00f2\u00f3\7t\2\2\u00f3\u00f4\7v\2\2\u00f4"+
		"\u00f5\7f\2\2\u00f5\u00f6\7q\2\2\u00f6\u00f7\7v\2\2\u00f7\u00f8\3\2\2"+
		"\2\u00f8\u00f9\6\b\5\2\u00f9\u00fa\3\2\2\2\u00fa\u00fb\b\b\2\2\u00fb\u00fc"+
		"\b\b\3\2\u00fc\21\3\2\2\2\u00fd\u00fe\7u\2\2\u00fe\u00ff\7v\2\2\u00ff"+
		"\u0100\7t\2\2\u0100\u0101\7k\2\2\u0101\u0102\7e\2\2\u0102\u0103\7v\2\2"+
		"\u0103\u0105\3\2\2\2\u0104\u0106\5h\64\2\u0105\u0104\3\2\2\2\u0106\u0107"+
		"\3\2\2\2\u0107\u0105\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u010a\3\2\2\2\u0109"+
		"\u00fd\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u0117\3\2\2\2\u010b\u010c\7i"+
		"\2\2\u010c\u010d\7t\2\2\u010d\u010e\7c\2\2\u010e\u010f\7r\2\2\u010f\u0118"+
		"\7j\2\2\u0110\u0111\7f\2\2\u0111\u0112\7k\2\2\u0112\u0113\7i\2\2\u0113"+
		"\u0114\7t\2\2\u0114\u0115\7c\2\2\u0115\u0116\7r\2\2\u0116\u0118\7j\2\2"+
		"\u0117\u010b\3\2\2\2\u0117\u0110\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u011a"+
		"\6\t\6\2\u011a\23\3\2\2\2\u011b\u011c\7}\2\2\u011c\u011d\3\2\2\2\u011d"+
		"\u011e\b\n\3\2\u011e\25\3\2\2\2\u011f\u0120\7\177\2\2\u0120\u0121\3\2"+
		"\2\2\u0121\u0122\b\13\5\2\u0122\27\3\2\2\2\u0123\u0124\7B\2\2\u0124\u0125"+
		"\7g\2\2\u0125\u0126\7p\2\2\u0126\u0127\7f\2\2\u0127\u0128\7f\2\2\u0128"+
		"\u0129\7q\2\2\u0129\u012a\7v\2\2\u012a\u012b\3\2\2\2\u012b\u012c\6\f\7"+
		"\2\u012c\u012d\3\2\2\2\u012d\u012e\b\f\2\2\u012e\u012f\b\f\5\2\u012f\31"+
		"\3\2\2\2\u0130\u0131\5d\62\2\u0131\u0132\6\r\b\2\u0132\u0133\3\2\2\2\u0133"+
		"\u0134\b\r\2\2\u0134\u0135\b\r\5\2\u0135\33\3\2\2\2\u0136\u0137\5\u0088"+
		"D\2\u0137\u0138\5n\67\2\u0138\u0139\5\u0088D\2\u0139\35\3\2\2\2\u013a"+
		"\u013b\5\u0088D\2\u013b\u013c\5p8\2\u013c\u013d\5\u0088D\2\u013d\37\3"+
		"\2\2\2\u013e\u013f\5\u0088D\2\u013f\u0140\5x<\2\u0140\u0141\5\u00b4Z\2"+
		"\u0141\u0143\5x<\2\u0142\u0144\5\u00a0P\2\u0143\u0142\3\2\2\2\u0143\u0144"+
		"\3\2\2\2\u0144\u0145\3\2\2\2\u0145\u0146\5\u0088D\2\u0146!\3\2\2\2\u0147"+
		"\u0148\5\u0088D\2\u0148\u0149\5x<\2\u0149\u014a\5\u00b4Z\2\u014a\u014b"+
		"\5x<\2\u014b\u014c\5\u00b4Z\2\u014c\u014d\5x<\2\u014d\u014e\5\u00b4Z\2"+
		"\u014e\u014f\5x<\2\u014f\u0150\5\u0088D\2\u0150#\3\2\2\2\u0151\u0152\5"+
		"\u0088D\2\u0152\u0156\5r9\2\u0153\u0154\5\u0090H\2\u0154\u0155\5r9\2\u0155"+
		"\u0157\3\2\2\2\u0156\u0153\3\2\2\2\u0157\u0158\3\2\2\2\u0158\u0156\3\2"+
		"\2\2\u0158\u0159\3\2\2\2\u0159\u015a\3\2\2\2\u015a\u015b\5\u0088D\2\u015b"+
		"%\3\2\2\2\u015c\u0161\5\u0088D\2\u015d\u0160\5\u0084B\2\u015e\u0160\n"+
		"\2\2\2\u015f\u015d\3\2\2\2\u015f\u015e\3\2\2\2\u0160\u0163\3\2\2\2\u0161"+
		"\u015f\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u0164\3\2\2\2\u0163\u0161\3\2"+
		"\2\2\u0164\u0165\5\u0088D\2\u0165\'\3\2\2\2\u0166\u016a\5*\25\2\u0167"+
		"\u0168\5\u00b6[\2\u0168\u0169\5*\25\2\u0169\u016b\3\2\2\2\u016a\u0167"+
		"\3\2\2\2\u016b\u016c\3\2\2\2\u016c\u016a\3\2\2\2\u016c\u016d\3\2\2\2\u016d"+
		")\3\2\2\2\u016e\u0170\5v;\2\u016f\u016e\3\2\2\2\u016f\u0170\3\2\2\2\u0170"+
		"\u0172\3\2\2\2\u0171\u0173\5t:\2\u0172\u0171\3\2\2\2\u0172\u0173\3\2\2"+
		"\2\u0173\u0174\3\2\2\2\u0174\u0179\5 \20\2\u0175\u0176\5 \20\2\u0176\u0177"+
		"\5 \20\2\u0177\u0178\5 \20\2\u0178\u017a\3\2\2\2\u0179\u0175\3\2\2\2\u017a"+
		"\u017b\3\2\2\2\u017b\u0179\3\2\2\2\u017b\u017c\3\2\2\2\u017c+\3\2\2\2"+
		"\u017d\u0183\5\u008aE\2\u017e\u0182\5\u008aE\2\u017f\u0182\5\u008cF\2"+
		"\u0180\u0182\5l\66\2\u0181\u017e\3\2\2\2\u0181\u017f\3\2\2\2\u0181\u0180"+
		"\3\2\2\2\u0182\u0185\3\2\2\2\u0183\u0181\3\2\2\2\u0183\u0184\3\2\2\2\u0184"+
		"\u0186\3\2\2\2\u0185\u0183\3\2\2\2\u0186\u0187\5\u008cF\2\u0187-\3\2\2"+
		"\2\u0188\u018a\5\u00acV\2\u0189\u0188\3\2\2\2\u0189\u018a\3\2\2\2\u018a"+
		"\u019f\3\2\2\2\u018b\u018d\5\u00b8\\\2\u018c\u018e\5~?\2\u018d\u018c\3"+
		"\2\2\2\u018e\u018f\3\2\2\2\u018f\u018d\3\2\2\2\u018f\u0190\3\2\2\2\u0190"+
		"\u01a0\3\2\2\2\u0191\u0193\5~?\2\u0192\u0191\3\2\2\2\u0193\u0194\3\2\2"+
		"\2\u0194\u0192\3\2\2\2\u0194\u0195\3\2\2\2\u0195\u019d\3\2\2\2\u0196\u019a"+
		"\5\u00b8\\\2\u0197\u0199\5~?\2\u0198\u0197\3\2\2\2\u0199\u019c\3\2\2\2"+
		"\u019a\u0198\3\2\2\2\u019a\u019b\3\2\2\2\u019b\u019e\3\2\2\2\u019c\u019a"+
		"\3\2\2\2\u019d\u0196\3\2\2\2\u019d\u019e\3\2\2\2\u019e\u01a0\3\2\2\2\u019f"+
		"\u018b\3\2\2\2\u019f\u0192\3\2\2\2\u01a0/\3\2\2\2\u01a1\u01a2\7\61\2\2"+
		"\u01a2\u01a3\7,\2\2\u01a3\u01a7\3\2\2\2\u01a4\u01a6\13\2\2\2\u01a5\u01a4"+
		"\3\2\2\2\u01a6\u01a9\3\2\2\2\u01a7\u01a8\3\2\2\2\u01a7\u01a5\3\2\2\2\u01a8"+
		"\u01aa\3\2\2\2\u01a9\u01a7\3\2\2\2\u01aa\u01ab\7,\2\2\u01ab\u01ac\7\61"+
		"\2\2\u01ac\61\3\2\2\2\u01ad\u01ae\7\61\2\2\u01ae\u01b1\7\61\2\2\u01af"+
		"\u01b1\5\u00bc^\2\u01b0\u01ad\3\2\2\2\u01b0\u01af\3\2\2\2\u01b1\u01b5"+
		"\3\2\2\2\u01b2\u01b4\13\2\2\2\u01b3\u01b2\3\2\2\2\u01b4\u01b7\3\2\2\2"+
		"\u01b5\u01b6\3\2\2\2\u01b5\u01b3\3\2\2\2\u01b6\u01b9\3\2\2\2\u01b7\u01b5"+
		"\3\2\2\2\u01b8\u01ba\7\17\2\2\u01b9\u01b8\3\2\2\2\u01b9\u01ba\3\2\2\2"+
		"\u01ba\u01bb\3\2\2\2\u01bb\u01be\7\f\2\2\u01bc\u01be\7\2\2\3\u01bd\u01b0"+
		"\3\2\2\2\u01bd\u01bc\3\2\2\2\u01be\63\3\2\2\2\u01bf\u01c0\7.\2\2\u01c0"+
		"\65\3\2\2\2\u01c1\u01c2\7=\2\2\u01c2\67\3\2\2\2\u01c3\u01c4\7]\2\2\u01c4"+
		"9\3\2\2\2\u01c5\u01c6\7_\2\2\u01c6;\3\2\2\2\u01c7\u01c8\7<\2\2\u01c8="+
		"\3\2\2\2\u01c9\u01ca\7?\2\2\u01ca?\3\2\2\2\u01cb\u01cc\7/\2\2\u01cc\u01cd"+
		"\7@\2\2\u01cdA\3\2\2\2\u01ce\u01cf\7/\2\2\u01cf\u01d0\7/\2\2\u01d0C\3"+
		"\2\2\2\u01d1\u01d2\7u\2\2\u01d2\u01d3\7w\2\2\u01d3\u01d4\7d\2\2\u01d4"+
		"\u01d5\7i\2\2\u01d5\u01d6\7t\2\2\u01d6\u01d7\7c\2\2\u01d7\u01d8\7r\2\2"+
		"\u01d8\u01d9\7j\2\2\u01d9E\3\2\2\2\u01da\u01db\7p\2\2\u01db\u01dc\7q\2"+
		"\2\u01dc\u01dd\7f\2\2\u01dd\u01de\7g\2\2\u01deG\3\2\2\2\u01df\u01e0\7"+
		"g\2\2\u01e0\u01e1\7f\2\2\u01e1\u01e2\7i\2\2\u01e2\u01e3\7g\2\2\u01e3I"+
		"\3\2\2\2\u01e4\u01e5\7p\2\2\u01e5K\3\2\2\2\u01e6\u01e7\7p\2\2\u01e7\u01e8"+
		"\7g\2\2\u01e8M\3\2\2\2\u01e9\u01ea\7g\2\2\u01eaO\3\2\2\2\u01eb\u01ec\7"+
		"u\2\2\u01ec\u01ed\7g\2\2\u01edQ\3\2\2\2\u01ee\u01ef\7u\2\2\u01efS\3\2"+
		"\2\2\u01f0\u01f1\7u\2\2\u01f1\u01f2\7y\2\2\u01f2U\3\2\2\2\u01f3\u01f4"+
		"\7y\2\2\u01f4W\3\2\2\2\u01f5\u01f6\7p\2\2\u01f6\u01f7\7y\2\2\u01f7Y\3"+
		"\2\2\2\u01f8\u01f9\7e\2\2\u01f9[\3\2\2\2\u01fa\u01ff\5j\65\2\u01fb\u01fe"+
		"\5j\65\2\u01fc\u01fe\5~?\2\u01fd\u01fb\3\2\2\2\u01fd\u01fc\3\2\2\2\u01fe"+
		"\u0201\3\2\2\2\u01ff\u01fd\3\2\2\2\u01ff\u0200\3\2\2\2\u0200]\3\2\2\2"+
		"\u0201\u01ff\3\2\2\2\u0202\u0203\5f\63\2\u0203\u0204\3\2\2\2\u0204\u0205"+
		"\b/\6\2\u0205\u0206\b/\4\2\u0206_\3\2\2\2\u0207\u0208\5h\64\2\u0208\u0209"+
		"\3\2\2\2\u0209\u020a\b\60\7\2\u020a\u020b\b\60\4\2\u020ba\3\2\2\2\u020c"+
		"\u020d\13\2\2\2\u020d\u020e\3\2\2\2\u020e\u020f\b\61\2\2\u020fc\3\2\2"+
		"\2\u0210\u0211\7b\2\2\u0211\u0212\7b\2\2\u0212\u0214\3\2\2\2\u0213\u0215"+
		"\7b\2\2\u0214\u0213\3\2\2\2\u0215\u0216\3\2\2\2\u0216\u0214\3\2\2\2\u0216"+
		"\u0217\3\2\2\2\u0217\u0221\3\2\2\2\u0218\u0219\7\u0080\2\2\u0219\u021a"+
		"\7\u0080\2\2\u021a\u021c\3\2\2\2\u021b\u021d\7\u0080\2\2\u021c\u021b\3"+
		"\2\2\2\u021d\u021e\3\2\2\2\u021e\u021c\3\2\2\2\u021e\u021f\3\2\2\2\u021f"+
		"\u0221\3\2\2\2\u0220\u0210\3\2\2\2\u0220\u0218\3\2\2\2\u0221e\3\2\2\2"+
		"\u0222\u0223\t\3\2\2\u0223g\3\2\2\2\u0224\u0225\t\4\2\2\u0225i\3\2\2\2"+
		"\u0226\u0228\t\5\2\2\u0227\u0226\3\2\2\2\u0228k\3\2\2\2\u0229\u022b\n"+
		"\6\2\2\u022a\u0229\3\2\2\2\u022b\u022c\3\2\2\2\u022c\u022a\3\2\2\2\u022c"+
		"\u022d\3\2\2\2\u022dm\3\2\2\2\u022e\u022f\5\u00bc^\2\u022f\u0230\5\u0080"+
		"@\2\u0230\u0231\5\u0080@\2\u0231\u0232\5\u0080@\2\u0232\u0233\5\u0080"+
		"@\2\u0233\u0234\5\u0080@\2\u0234\u0238\5\u0080@\2\u0235\u0236\5\u0080"+
		"@\2\u0236\u0237\5\u0080@\2\u0237\u0239\3\2\2\2\u0238\u0235\3\2\2\2\u0238"+
		"\u0239\3\2\2\2\u0239o\3\2\2\2\u023a\u023b\5\u0082A\2\u023b\u023c\5\u0082"+
		"A\2\u023c\u023d\5\u0082A\2\u023dq\3\2\2\2\u023e\u0240\5j\65\2\u023f\u023e"+
		"\3\2\2\2\u0240\u0241\3\2\2\2\u0241\u023f\3\2\2\2\u0241\u0242\3\2\2\2\u0242"+
		"\u0246\3\2\2\2\u0243\u0244\5\u00b6[\2\u0244\u0245\5|>\2\u0245\u0247\3"+
		"\2\2\2\u0246\u0243\3\2\2\2\u0246\u0247\3\2\2\2\u0247s\3\2\2\2\u0248\u0249"+
		"\5\u0088D\2\u0249\u024a\7g\2\2\u024a\u024b\5\u00b4Z\2\u024b\u024c\5x<"+
		"\2\u024c\u024d\5\u0088D\2\u024du\3\2\2\2\u024e\u024f\5\u0088D\2\u024f"+
		"\u0250\7u\2\2\u0250\u0251\5\u00b4Z\2\u0251\u0252\5x<\2\u0252\u0253\5\u0088"+
		"D\2\u0253w\3\2\2\2\u0254\u0256\t\7\2\2\u0255\u0254\3\2\2\2\u0255\u0256"+
		"\3\2\2\2\u0256\u0257\3\2\2\2\u0257\u0258\5z=\2\u0258y\3\2\2\2\u0259\u025b"+
		"\5~?\2\u025a\u0259\3\2\2\2\u025b\u025c\3\2\2\2\u025c\u025a\3\2\2\2\u025c"+
		"\u025d\3\2\2\2\u025d\u025e\3\2\2\2\u025e\u0262\5\u00b8\\\2\u025f\u0261"+
		"\5~?\2\u0260\u025f\3\2\2\2\u0261\u0264\3\2\2\2\u0262\u0260\3\2\2\2\u0262"+
		"\u0263\3\2\2\2\u0263{\3\2\2\2\u0264\u0262\3\2\2\2\u0265\u0266\7\62\2\2"+
		"\u0266\u0268\5\u00b8\\\2\u0267\u0269\5~?\2\u0268\u0267\3\2\2\2\u0269\u026a"+
		"\3\2\2\2\u026a\u0268\3\2\2\2\u026a\u026b\3\2\2\2\u026b}\3\2\2\2\u026c"+
		"\u026d\t\b\2\2\u026d\177\3\2\2\2\u026e\u026f\t\t\2\2\u026f\u0081\3\2\2"+
		"\2\u0270\u0271\t\n\2\2\u0271\u0272\5\u00b8\\\2\u0272\u0273\5~?\2\u0273"+
		"\u0274\5~?\2\u0274\u0275\5~?\2\u0275\u0083\3\2\2\2\u0276\u027b\5\u008e"+
		"G\2\u0277\u027c\t\13\2\2\u0278\u027c\5\u0086C\2\u0279\u027c\13\2\2\2\u027a"+
		"\u027c\7\2\2\3\u027b\u0277\3\2\2\2\u027b\u0278\3\2\2\2\u027b\u0279\3\2"+
		"\2\2\u027b\u027a\3\2\2\2\u027c\u0085\3\2\2\2\u027d\u0288\7w\2\2\u027e"+
		"\u0286\5\u0080@\2\u027f\u0284\5\u0080@\2\u0280\u0282\5\u0080@\2\u0281"+
		"\u0283\5\u0080@\2\u0282\u0281\3\2\2\2\u0282\u0283\3\2\2\2\u0283\u0285"+
		"\3\2\2\2\u0284\u0280\3\2\2\2\u0284\u0285\3\2\2\2\u0285\u0287\3\2\2\2\u0286"+
		"\u027f\3\2\2\2\u0286\u0287\3\2\2\2\u0287\u0289\3\2\2\2\u0288\u027e\3\2"+
		"\2\2\u0288\u0289\3\2\2\2\u0289\u0087\3\2\2\2\u028a\u028b\7$\2\2\u028b"+
		"\u0089\3\2\2\2\u028c\u028d\7>\2\2\u028d\u008b\3\2\2\2\u028e\u028f\7@\2"+
		"\2\u028f\u008d\3\2\2\2\u0290\u0291\7^\2\2\u0291\u008f\3\2\2\2\u0292\u0293"+
		"\7<\2\2\u0293\u0091\3\2\2\2\u0294\u0295\7*\2\2\u0295\u0093\3\2\2\2\u0296"+
		"\u0297\7+\2\2\u0297\u0095\3\2\2\2\u0298\u0299\7}\2\2\u0299\u0097\3\2\2"+
		"\2\u029a\u029b\7\177\2\2\u029b\u0099\3\2\2\2\u029c\u029d\7]\2\2\u029d"+
		"\u009b\3\2\2\2\u029e\u029f\7_\2\2\u029f\u009d\3\2\2\2\u02a0\u02a1\7A\2"+
		"\2\u02a1\u009f\3\2\2\2\u02a2\u02a3\7#\2\2\u02a3\u00a1\3\2\2\2\u02a4\u02a5"+
		"\7,\2\2\u02a5\u00a3\3\2\2\2\u02a6\u02a7\7\61\2\2\u02a7\u00a5\3\2\2\2\u02a8"+
		"\u02a9\7\'\2\2\u02a9\u00a7\3\2\2\2\u02aa\u02ab\7`\2\2\u02ab\u00a9\3\2"+
		"\2\2\u02ac\u02ad\7-\2\2\u02ad\u00ab\3\2\2\2\u02ae\u02af\7/\2\2\u02af\u00ad"+
		"\3\2\2\2\u02b0\u02b1\7a\2\2\u02b1\u00af\3\2\2\2\u02b2\u02b3\7~\2\2\u02b3"+
		"\u00b1\3\2\2\2\u02b4\u02b5\7&\2\2\u02b5\u00b3\3\2\2\2\u02b6\u02b7\7.\2"+
		"\2\u02b7\u00b5\3\2\2\2\u02b8\u02b9\7=\2\2\u02b9\u00b7\3\2\2\2\u02ba\u02bb"+
		"\7\60\2\2\u02bb\u00b9\3\2\2\2\u02bc\u02bd\7B\2\2\u02bd\u00bb\3\2\2\2\u02be"+
		"\u02bf\7%\2\2\u02bf\u00bd\3\2\2\2\u02c0\u02c1\7\u0080\2\2\u02c1\u00bf"+
		"\3\2\2\2\60\2\3\u00c4\u0107\u0109\u0117\u0143\u0158\u015f\u0161\u016c"+
		"\u016f\u0172\u017b\u0181\u0183\u0189\u018f\u0194\u019a\u019d\u019f\u01a7"+
		"\u01b0\u01b5\u01b9\u01bd\u01fd\u01ff\u0216\u021e\u0220\u0227\u022c\u0238"+
		"\u0241\u0246\u0255\u025c\u0262\u026a\u027b\u0282\u0284\u0286\u0288\b\t"+
		"\5\2\7\3\2\2\3\2\6\2\2\t\3\2\t\4\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}