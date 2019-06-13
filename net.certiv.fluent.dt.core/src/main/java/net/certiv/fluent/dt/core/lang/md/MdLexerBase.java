package net.certiv.fluent.dt.core.lang.md;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.IntStream;
import org.antlr.v4.runtime.Token;

import net.certiv.dsl.core.util.Strings;
import net.certiv.dsl.core.util.stores.Extent;
import net.certiv.dsl.core.util.stores.NearMap;
import net.certiv.fluent.dt.core.lang.md.gen.MdLexer;

public abstract class MdLexerBase extends LexerNeo {

	private static final String REF = "\\[\\V*?\\]";
	private static final String TXT = "\\V*?";
	private static final String SPC = "\\h*";
	private static final String SEGMENT = "[A-z0-9#?&*@=:-]+";

	// URL :: (\w(\w|-)*\://|[./]+/)?[A-z0-9#?&@=:-]+([./]+[A-z0-9#?&*@=:-]+)+/?
	private static final String URL = ""	//
			+ "("						// optional
			+ "\\w(\\w|-)*\\://"		// device & separator
			+ "|"						// or
			+ "[./]+/"					// path separator
			+ ")?"						//
			+ SEGMENT					// first segment
			+ "([./]+" + SEGMENT + ")*"	// separator & second segment(s)
			+ "/?"						// optional ending slash
	;

	// Link :: [text](URL "title")
	// LDef :: [ref]: URL "title"
	// LRef :: [text][ref]
	// LUrl :: [URL]
	// LTxt :: [ref]
	private static final Pattern Link = Pattern.compile("!?" + REF + "[ ]?\\(" + TXT + "\\)");
	private static final Pattern LDef = Pattern.compile(REF + "\\:" + SPC + URL + SPC + "(\"\\V*?\")?");
	private static final Pattern LRef = Pattern.compile("!?" + REF + REF);
	private static final Pattern LUrl = Pattern.compile("!?" + "\\[" + SPC + URL + SPC + "\\]");
	private static final Pattern LTxt = Pattern.compile("!?" + REF);

	private static final Pattern Left = Pattern.compile("\\s[!?:;,.]*([*_~`'\"]+)\\S");
	private static final Pattern Right = Pattern.compile("\\S([*_~`'\"]+)[!?:;,.]*\\s");

	// { .class #id word="valid" }
	private static final String CLASS_ID = "[\\.#]\\w+" + SPC;
	private static final String KEY = "\\w+";
	private static final String VALUE = "('" + TXT + "'|\"" + TXT + "\")";
	private static final String KEY_VALUE = KEY + SPC + "=" + SPC + VALUE + SPC;
	private static final Pattern Style = Pattern.compile("" //
			+ "\\{" + SPC 		//
			+ "(" + CLASS_ID	//
			+ "|" + KEY_VALUE 	//
			+ ")+" 				//
			+ "\\}" 			//
	);

	private final String data;
	private boolean done;

	// private final NearMap<Extent<Integer>> blocks = new NearMap<>();
	private final NearMap<Extent<Integer>> attrL = new NearMap<>();
	private final NearMap<Extent<Integer>> attrR = new NearMap<>();

	public MdLexerBase(CharStream input) {
		super(input);
		data = input.toString();
		insertBOFToken(MdLexer.BLANK);

		Matcher m = Left.matcher(data);
		while (m.find()) {
			attrL.put(m.start(1), new Extent<>(m.start(1), m.end(1)));
		}
		m = Right.matcher(data);
		while (m.find()) {
			attrR.put(m.start(1), new Extent<>(m.start(1), m.end(1)));
		}
	}

	@Override
	public void emit(Token token) {
		switch (token.getType()) {
			case MdLexer.LBOLD:
				int idx = token.getStartIndex();
				if (attrR.contains(idx)) {
					((MdToken) token).setType(MdLexer.RBOLD);
				} else if (!attrL.contains(idx)) {
					((MdToken) token).setType(MdLexer.WORD);
				}
				break;

			case MdLexer.LITALIC:
				idx = token.getStartIndex();
				if (attrR.contains(idx)) {
					((MdToken) token).setType(MdLexer.RITALIC);
				} else if (!attrL.contains(idx)) {
					((MdToken) token).setType(MdLexer.WORD);
				}
				break;

			case MdLexer.LSTRIKE:
				idx = token.getStartIndex();
				if (attrR.contains(idx)) {
					((MdToken) token).setType(MdLexer.RSTRIKE);
				} else if (!attrL.contains(idx)) {
					((MdToken) token).setType(MdLexer.WORD);
				}
				break;

			case MdLexer.LSPAN:
				idx = token.getStartIndex();
				if (attrR.contains(idx)) {
					((MdToken) token).setType(MdLexer.RSPAN);
				} else if (!attrL.contains(idx)) {
					((MdToken) token).setType(MdLexer.WORD);
				}
				break;

			case MdLexer.LDQUOTE:
				idx = token.getStartIndex();
				if (attrR.contains(idx)) {
					((MdToken) token).setType(MdLexer.RDQUOTE);
				} else if (!attrL.contains(idx)) {
					((MdToken) token).setType(MdLexer.WORD);
				}
				break;

			case MdLexer.LSQUOTE:
				idx = token.getStartIndex();
				if (attrR.contains(idx)) {
					((MdToken) token).setType(MdLexer.RSQUOTE);
				} else if (!attrL.contains(idx)) {
					((MdToken) token).setType(MdLexer.WORD);
				}
				break;

			default:
				break;
		}
		super.emit(token);
	}

	@Override
	protected void queueEOF() {
		if (!done) {
			done = true;
			if (_lastToken.getType() != MdLexer.BLANK) queue(MdLexer.BLANK);
		}
		super.queueEOF();
	}

	/**
	 * Return {@code true} if there is no leading text, the leading text is whitespace and the
	 * whitespace contains at least {@code cnt} newlines, or if the leading text is all
	 * whitespace.
	 */
	protected boolean at(int cnt) {
		int idx = _mStartCharIndex;
		if (idx > 0) {
			char ch = data.charAt(idx - 1);
			while (ch != IntStream.EOF) {
				if (!Character.isWhitespace(ch)) return false;
				if (ch == Strings.NLC) {
					cnt--;
					if (cnt == 0) return true;
				}
				idx--;
				ch = data.charAt(idx - 1);
			}
		}
		return true;
	}

	protected boolean style() {
		Matcher m = Style.matcher(data.substring(_mStartCharIndex));
		return m.lookingAt();
	}

	protected boolean link() {
		Matcher m = Link.matcher(data.substring(_mStartCharIndex));
		return m.lookingAt();
	}

	protected boolean lRef() {
		Matcher m = LRef.matcher(data.substring(_mStartCharIndex));
		return m.lookingAt();
	}

	protected boolean lTxt() {
		Matcher m = LTxt.matcher(data.substring(_mStartCharIndex));
		return m.lookingAt();
	}

	protected boolean lUrl() {
		Matcher m = LUrl.matcher(data.substring(_mStartCharIndex));
		return m.lookingAt();
	}

	protected boolean lDef() {
		Matcher m = LDef.matcher(data.substring(_mStartCharIndex));
		return m.lookingAt();
	}
}
