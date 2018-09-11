// Generated from D:/DevFiles/Eclipse/Fluentmark/net.certiv.fluentmark/plugin/src/net/certiv/fluentmark/dot/DotLexer.g4 by ANTLR 4.7.1

	package net.certiv.fluentmark.dot.gen;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DotLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMA=1, SEMI=2, LBRACE=3, RBRACE=4, LBRACK=5, RBRACK=6, COLON=7, EQ=8, 
		DIRECTED=9, UNDIRECTED=10, STRICT=11, DIGRAPH=12, GRAPH=13, NODE=14, EDGE=15, 
		SUBGRAPH=16, N=17, NE=18, E=19, SE=20, S=21, SW=22, W=23, NW=24, C=25, 
		ID=26, NUMERAL=27, STRING=28, ALPHA=29, DIGIT=30, QUOTED_STRING=31, HTML_STRING=32, 
		ML_COMMENT=33, SL_COMMENT=34, WS=35, ERR=36;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"COMMA", "SEMI", "LBRACE", "RBRACE", "LBRACK", "RBRACK", "COLON", "EQ", 
		"DIRECTED", "UNDIRECTED", "STRICT", "DIGRAPH", "GRAPH", "NODE", "EDGE", 
		"SUBGRAPH", "N", "NE", "E", "SE", "S", "SW", "W", "NW", "C", "ID", "NUMERAL", 
		"STRING", "ALPHA", "DIGIT", "QUOTED_STRING", "HTML_STRING", "ML_COMMENT", 
		"SL_COMMENT", "WS", "ERR", "Esc", "Dot", "Minus", "TagOpen", "TagClose", 
		"HexDigit", "Html", "EscSeq", "UnicodeEsc"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "COMMA", "SEMI", "LBRACE", "RBRACE", "LBRACK", "RBRACK", "COLON", 
		"EQ", "DIRECTED", "UNDIRECTED", "STRICT", "DIGRAPH", "GRAPH", "NODE", 
		"EDGE", "SUBGRAPH", "N", "NE", "E", "SE", "S", "SW", "W", "NW", "C", "ID", 
		"NUMERAL", "STRING", "ALPHA", "DIGIT", "QUOTED_STRING", "HTML_STRING", 
		"ML_COMMENT", "SL_COMMENT", "WS", "ERR"
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2&\u013d\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3"+
		"\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3"+
		"\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\26\3"+
		"\26\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3"+
		"\33\5\33\u00b6\n\33\3\34\5\34\u00b9\n\34\3\34\3\34\6\34\u00bd\n\34\r\34"+
		"\16\34\u00be\3\34\6\34\u00c2\n\34\r\34\16\34\u00c3\3\34\3\34\7\34\u00c8"+
		"\n\34\f\34\16\34\u00cb\13\34\5\34\u00cd\n\34\5\34\u00cf\n\34\3\35\3\35"+
		"\3\35\7\35\u00d4\n\35\f\35\16\35\u00d7\13\35\3\36\5\36\u00da\n\36\3\37"+
		"\3\37\3 \3 \3 \7 \u00e1\n \f \16 \u00e4\13 \3 \3 \3!\3!\3!\3!\7!\u00ec"+
		"\n!\f!\16!\u00ef\13!\3!\3!\3\"\3\"\3\"\3\"\7\"\u00f7\n\"\f\"\16\"\u00fa"+
		"\13\"\3\"\3\"\3\"\3#\3#\3#\5#\u0102\n#\3#\7#\u0105\n#\f#\16#\u0108\13"+
		"#\3#\5#\u010b\n#\3#\3#\5#\u010f\n#\3$\3$\3$\3$\3%\3%\3%\3%\3&\3&\3\'\3"+
		"\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\6,\u0126\n,\r,\16,\u0127\3-\3-\3-\3-\3-"+
		"\5-\u012f\n-\3.\3.\3.\3.\3.\5.\u0136\n.\5.\u0138\n.\5.\u013a\n.\5.\u013c"+
		"\n.\4\u00f8\u0106\2/\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
		"\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\2M\2O\2Q\2S\2U\2W\2Y\2[\2\3\2\t\6"+
		"\2C\\aac|\u0082\u0101\3\2\62;\6\2\f\f\17\17$$^^\6\2\13\f\16\17\"\"))\5"+
		"\2\62;CHch\4\2>>@@\n\2$$))^^ddhhppttvv\2\u0150\2\3\3\2\2\2\2\5\3\2\2\2"+
		"\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3"+
		"\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2"+
		"\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2"+
		"\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2"+
		"\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2"+
		"\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\3]\3\2\2\2"+
		"\5_\3\2\2\2\7a\3\2\2\2\tc\3\2\2\2\13e\3\2\2\2\rg\3\2\2\2\17i\3\2\2\2\21"+
		"k\3\2\2\2\23m\3\2\2\2\25p\3\2\2\2\27s\3\2\2\2\31z\3\2\2\2\33\u0082\3\2"+
		"\2\2\35\u0088\3\2\2\2\37\u008d\3\2\2\2!\u0092\3\2\2\2#\u009b\3\2\2\2%"+
		"\u009d\3\2\2\2\'\u00a0\3\2\2\2)\u00a2\3\2\2\2+\u00a5\3\2\2\2-\u00a7\3"+
		"\2\2\2/\u00aa\3\2\2\2\61\u00ac\3\2\2\2\63\u00af\3\2\2\2\65\u00b5\3\2\2"+
		"\2\67\u00b8\3\2\2\29\u00d0\3\2\2\2;\u00d9\3\2\2\2=\u00db\3\2\2\2?\u00dd"+
		"\3\2\2\2A\u00e7\3\2\2\2C\u00f2\3\2\2\2E\u010e\3\2\2\2G\u0110\3\2\2\2I"+
		"\u0114\3\2\2\2K\u0118\3\2\2\2M\u011a\3\2\2\2O\u011c\3\2\2\2Q\u011e\3\2"+
		"\2\2S\u0120\3\2\2\2U\u0122\3\2\2\2W\u0125\3\2\2\2Y\u0129\3\2\2\2[\u0130"+
		"\3\2\2\2]^\7.\2\2^\4\3\2\2\2_`\7=\2\2`\6\3\2\2\2ab\7}\2\2b\b\3\2\2\2c"+
		"d\7\177\2\2d\n\3\2\2\2ef\7]\2\2f\f\3\2\2\2gh\7_\2\2h\16\3\2\2\2ij\7<\2"+
		"\2j\20\3\2\2\2kl\7?\2\2l\22\3\2\2\2mn\7/\2\2no\7@\2\2o\24\3\2\2\2pq\7"+
		"/\2\2qr\7/\2\2r\26\3\2\2\2st\7u\2\2tu\7v\2\2uv\7t\2\2vw\7k\2\2wx\7e\2"+
		"\2xy\7v\2\2y\30\3\2\2\2z{\7f\2\2{|\7k\2\2|}\7i\2\2}~\7t\2\2~\177\7c\2"+
		"\2\177\u0080\7r\2\2\u0080\u0081\7j\2\2\u0081\32\3\2\2\2\u0082\u0083\7"+
		"i\2\2\u0083\u0084\7t\2\2\u0084\u0085\7c\2\2\u0085\u0086\7r\2\2\u0086\u0087"+
		"\7j\2\2\u0087\34\3\2\2\2\u0088\u0089\7p\2\2\u0089\u008a\7q\2\2\u008a\u008b"+
		"\7f\2\2\u008b\u008c\7g\2\2\u008c\36\3\2\2\2\u008d\u008e\7g\2\2\u008e\u008f"+
		"\7f\2\2\u008f\u0090\7i\2\2\u0090\u0091\7g\2\2\u0091 \3\2\2\2\u0092\u0093"+
		"\7u\2\2\u0093\u0094\7w\2\2\u0094\u0095\7d\2\2\u0095\u0096\7i\2\2\u0096"+
		"\u0097\7t\2\2\u0097\u0098\7c\2\2\u0098\u0099\7r\2\2\u0099\u009a\7j\2\2"+
		"\u009a\"\3\2\2\2\u009b\u009c\7p\2\2\u009c$\3\2\2\2\u009d\u009e\7p\2\2"+
		"\u009e\u009f\7g\2\2\u009f&\3\2\2\2\u00a0\u00a1\7g\2\2\u00a1(\3\2\2\2\u00a2"+
		"\u00a3\7u\2\2\u00a3\u00a4\7g\2\2\u00a4*\3\2\2\2\u00a5\u00a6\7u\2\2\u00a6"+
		",\3\2\2\2\u00a7\u00a8\7u\2\2\u00a8\u00a9\7y\2\2\u00a9.\3\2\2\2\u00aa\u00ab"+
		"\7y\2\2\u00ab\60\3\2\2\2\u00ac\u00ad\7p\2\2\u00ad\u00ae\7y\2\2\u00ae\62"+
		"\3\2\2\2\u00af\u00b0\7e\2\2\u00b0\64\3\2\2\2\u00b1\u00b6\5\67\34\2\u00b2"+
		"\u00b6\59\35\2\u00b3\u00b6\5? \2\u00b4\u00b6\5A!\2\u00b5\u00b1\3\2\2\2"+
		"\u00b5\u00b2\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b4\3\2\2\2\u00b6\66"+
		"\3\2\2\2\u00b7\u00b9\5O(\2\u00b8\u00b7\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9"+
		"\u00ce\3\2\2\2\u00ba\u00bc\5M\'\2\u00bb\u00bd\5=\37\2\u00bc\u00bb\3\2"+
		"\2\2\u00bd\u00be\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf"+
		"\u00cf\3\2\2\2\u00c0\u00c2\5=\37\2\u00c1\u00c0\3\2\2\2\u00c2\u00c3\3\2"+
		"\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00cc\3\2\2\2\u00c5"+
		"\u00c9\5M\'\2\u00c6\u00c8\5=\37\2\u00c7\u00c6\3\2\2\2\u00c8\u00cb\3\2"+
		"\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cd\3\2\2\2\u00cb"+
		"\u00c9\3\2\2\2\u00cc\u00c5\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00cf\3\2"+
		"\2\2\u00ce\u00ba\3\2\2\2\u00ce\u00c1\3\2\2\2\u00cf8\3\2\2\2\u00d0\u00d5"+
		"\5;\36\2\u00d1\u00d4\5;\36\2\u00d2\u00d4\5=\37\2\u00d3\u00d1\3\2\2\2\u00d3"+
		"\u00d2\3\2\2\2\u00d4\u00d7\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d6\3\2"+
		"\2\2\u00d6:\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d8\u00da\t\2\2\2\u00d9\u00d8"+
		"\3\2\2\2\u00da<\3\2\2\2\u00db\u00dc\t\3\2\2\u00dc>\3\2\2\2\u00dd\u00e2"+
		"\7$\2\2\u00de\u00e1\5Y-\2\u00df\u00e1\n\4\2\2\u00e0\u00de\3\2\2\2\u00e0"+
		"\u00df\3\2\2\2\u00e1\u00e4\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e3\3\2"+
		"\2\2\u00e3\u00e5\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e5\u00e6\7$\2\2\u00e6"+
		"@\3\2\2\2\u00e7\u00ed\5Q)\2\u00e8\u00ec\5Q)\2\u00e9\u00ec\5S*\2\u00ea"+
		"\u00ec\5W,\2\u00eb\u00e8\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ea\3\2\2"+
		"\2\u00ec\u00ef\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00f0"+
		"\3\2\2\2\u00ef\u00ed\3\2\2\2\u00f0\u00f1\5S*\2\u00f1B\3\2\2\2\u00f2\u00f3"+
		"\7\61\2\2\u00f3\u00f4\7,\2\2\u00f4\u00f8\3\2\2\2\u00f5\u00f7\13\2\2\2"+
		"\u00f6\u00f5\3\2\2\2\u00f7\u00fa\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f8\u00f6"+
		"\3\2\2\2\u00f9\u00fb\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fb\u00fc\7,\2\2\u00fc"+
		"\u00fd\7\61\2\2\u00fdD\3\2\2\2\u00fe\u00ff\7\61\2\2\u00ff\u0102\7\61\2"+
		"\2\u0100\u0102\7%\2\2\u0101\u00fe\3\2\2\2\u0101\u0100\3\2\2\2\u0102\u0106"+
		"\3\2\2\2\u0103\u0105\13\2\2\2\u0104\u0103\3\2\2\2\u0105\u0108\3\2\2\2"+
		"\u0106\u0107\3\2\2\2\u0106\u0104\3\2\2\2\u0107\u010a\3\2\2\2\u0108\u0106"+
		"\3\2\2\2\u0109\u010b\7\17\2\2\u010a\u0109\3\2\2\2\u010a\u010b\3\2\2\2"+
		"\u010b\u010c\3\2\2\2\u010c\u010f\7\f\2\2\u010d\u010f\7\2\2\3\u010e\u0101"+
		"\3\2\2\2\u010e\u010d\3\2\2\2\u010fF\3\2\2\2\u0110\u0111\t\5\2\2\u0111"+
		"\u0112\3\2\2\2\u0112\u0113\b$\2\2\u0113H\3\2\2\2\u0114\u0115\13\2\2\2"+
		"\u0115\u0116\3\2\2\2\u0116\u0117\b%\2\2\u0117J\3\2\2\2\u0118\u0119\7^"+
		"\2\2\u0119L\3\2\2\2\u011a\u011b\7\60\2\2\u011bN\3\2\2\2\u011c\u011d\7"+
		"/\2\2\u011dP\3\2\2\2\u011e\u011f\7>\2\2\u011fR\3\2\2\2\u0120\u0121\7@"+
		"\2\2\u0121T\3\2\2\2\u0122\u0123\t\6\2\2\u0123V\3\2\2\2\u0124\u0126\n\7"+
		"\2\2\u0125\u0124\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u0125\3\2\2\2\u0127"+
		"\u0128\3\2\2\2\u0128X\3\2\2\2\u0129\u012e\5K&\2\u012a\u012f\t\b\2\2\u012b"+
		"\u012f\5[.\2\u012c\u012f\13\2\2\2\u012d\u012f\7\2\2\3\u012e\u012a\3\2"+
		"\2\2\u012e\u012b\3\2\2\2\u012e\u012c\3\2\2\2\u012e\u012d\3\2\2\2\u012f"+
		"Z\3\2\2\2\u0130\u013b\7w\2\2\u0131\u0139\5U+\2\u0132\u0137\5U+\2\u0133"+
		"\u0135\5U+\2\u0134\u0136\5U+\2\u0135\u0134\3\2\2\2\u0135\u0136\3\2\2\2"+
		"\u0136\u0138\3\2\2\2\u0137\u0133\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u013a"+
		"\3\2\2\2\u0139\u0132\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u013c\3\2\2\2\u013b"+
		"\u0131\3\2\2\2\u013b\u013c\3\2\2\2\u013c\\\3\2\2\2\34\2\u00b5\u00b8\u00be"+
		"\u00c3\u00c9\u00cc\u00ce\u00d3\u00d5\u00d9\u00e0\u00e2\u00eb\u00ed\u00f8"+
		"\u0101\u0106\u010a\u010e\u0127\u012e\u0135\u0137\u0139\u013b\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}