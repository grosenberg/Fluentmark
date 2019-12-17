package net.certiv.fluent.dt.core.lang.md;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.IntStream;
import org.antlr.v4.runtime.Token;

import net.certiv.dsl.core.util.Chars;
import net.certiv.dsl.core.util.Strings;
import net.certiv.dsl.core.util.stores.Extent;
import net.certiv.dsl.core.util.stores.HashList;
import net.certiv.dsl.core.util.stores.NearMap;
import net.certiv.fluent.dt.core.lang.md.gen.MdLexer;

public abstract class MdLexerBase extends LexerNeo {

	private static final String TXT = "\\V*";
	private static final String SPC = "\\h*";

	private static final String CLASS_ID = "[\\.#]\\w+" + SPC;
	private static final String KEY = "\\w+";
	private static final String VALUE = "('" + TXT + "'|\"" + TXT + "\")";
	private static final String KEY_VALUE = KEY + SPC + "=" + SPC + VALUE + SPC;

	// { .class #id word="valid" }
	private static final Pattern Style = Pattern.compile("" //
			+ "\\{" + SPC 		//
			+ "(" + CLASS_ID	//
			+ "|" + KEY_VALUE 	//
			+ ")+" 				//
			+ "\\}" 			//
	);

	private static final Pattern LTerm = Pattern.compile("\\s\\p{Punct}*?([*_~`'\"]+)\\p{Punct}*?\\w",
			Pattern.UNICODE_CHARACTER_CLASS);
	private static final Pattern RTerm = Pattern.compile("\\w\\p{Punct}*?([*_~`'\"]+)\\p{Punct}*?\\s",
			Pattern.UNICODE_CHARACTER_CLASS);

	private final NearMap<Extent<Integer>> attrL = new NearMap<>();
	private final NearMap<Extent<Integer>> attrR = new NearMap<>();

	private final String data;
	private boolean done;

	// key=line no; value=visible tokens
	private final HashList<Integer, MdToken> section = new HashList<>();

	public MdLexerBase(CharStream input) {
		super(input);
		data = input.toString();

		insertBOFToken(MdLexer.LINE_BLANK, Strings.EOL + Strings.EOL);

		Matcher m = LTerm.matcher(data);
		while (m.find()) {
			attrL.put(m.start(1), new Extent<>(m.start(1), m.end(1)));
		}
		m = RTerm.matcher(data);
		while (m.find()) {
			attrR.put(m.start(1), new Extent<>(m.start(1), m.end(1)));
		}
	}

	@Override
	public void emit(Token tok) {
		MdToken token = (MdToken) tok;
		switch (token.getType()) {
			case MdLexer.LINE_BLANK:
				section.clear();
				break;

			// list marks
			case MdLexer.SIMPLE_MARK:
			case MdLexer.PAREN_MARK:
			case MdLexer.UALPHA_MARK:
			case MdLexer.LALPHA_MARK:
				if (!inList()) token.setType(MdLexer.WORD);
				break;

			// attributes
			case MdLexer.LBOLD:
				fixAttr(token, MdLexer.LBOLD, MdLexer.RBOLD, MdLexer.WORD);
				break;

			case MdLexer.LITALIC:
				fixAttr(token, MdLexer.LITALIC, MdLexer.RITALIC, MdLexer.WORD);
				break;

			case MdLexer.LSTRIKE:
				fixAttr(token, MdLexer.LSTRIKE, MdLexer.RSTRIKE, MdLexer.WORD);
				break;

			case MdLexer.LSPAN:
				fixAttr(token, MdLexer.LSPAN, MdLexer.RSPAN, MdLexer.WORD);
				break;

			case MdLexer.LDQUOTE:
				fixAttr(token, MdLexer.LDQUOTE, MdLexer.RDQUOTE, MdLexer.WORD);
				break;

			case MdLexer.LSQUOTE:
				fixAttr(token, MdLexer.LSQUOTE, MdLexer.RSQUOTE, MdLexer.WORD);
				break;

			default:
				break;
		}
		if (token.getChannel() == Token.DEFAULT_CHANNEL) {
			section.put(token.getLine(), token);
		}
		super.emit(token);
	}

	private boolean inList() {
		for (Integer num : section.keySet()) {
			List<MdToken> line = section.get(num);
			if (!line.isEmpty()) {
				MdToken first = line.get(0);
				if (first.getType() == MdLexer.LINE_BLANK) continue;
				if (!first.isListMark()) return false;
			}
		}
		return true;
	}

	private void fixAttr(MdToken token, int left, int right, int none) {
		int idx = token.getStartIndex();
		if (attrL.contains(idx)) {
			token.setType(left);
		} else if (attrR.contains(idx)) {
			token.setType(right);
		} else {
			token.setType(none);
		}
	}

	@Override
	protected void queueEOF() {
		if (!done) {
			done = true;
			if (_lastToken.getType() != MdLexer.LINE_BLANK) {
				queue(MdLexer.LINE_BLANK, Strings.EOL + Strings.EOL);
			}
		}
		super.queueEOF();
	}

	/**
	 * Return {@code true} if there is no leading text, the leading text is
	 * whitespace and the whitespace contains at least {@code cnt} newlines, or if
	 * the leading text is all whitespace. Ignores the block quote character.
	 */
	protected boolean at(int cnt) {
		int idx = _mStartCharIndex;
		if (idx > 0) {
			for (char ch = 0; ch != IntStream.EOF && idx >= 0; idx--) {
				ch = data.charAt(idx - 1);
				if (ch == '>') continue;
				if (!Character.isWhitespace(ch)) return false;
				if (ch == Chars.EOL) {
					cnt--;
					if (cnt == 0) return true;
				}
			}
		}
		return true;
	}

	protected boolean style() {
		return check(Style);
	}

	private boolean check(Pattern pat) {
		int dot = data.indexOf(Chars.EOL, _mStartCharIndex);
		String line = dot > 0 ? data.substring(_mStartCharIndex, dot - 1) : data.substring(_mStartCharIndex);
		Matcher m = pat.matcher(line);
		boolean found = m.lookingAt();
		// Log.debug(this, String.format("Cond %s '%s'", found, line));
		return found;
	}
}
