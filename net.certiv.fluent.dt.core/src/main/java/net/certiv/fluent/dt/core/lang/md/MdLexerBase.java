package net.certiv.fluent.dt.core.lang.md;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Interval;

import net.certiv.dsl.core.util.Strings;
import net.certiv.dsl.core.util.stores.Extent;
import net.certiv.fluent.dt.core.lang.md.gen.MdLexer;

public abstract class MdLexerBase extends LexerNeo {

	private static final Set<Character> Attrs = new HashSet<>(Arrays.asList(new Character[] { '*', '_', '~' }));

	private static final String BLN = "\\R\\h*\\R";
	private static final Pattern HdrDef = Pattern.compile(BLN + "\\h*#+.*?");

	private static final String PipeLN = "(?:\\V*?\\|\\V*?)+\\R";
	private static final String PipeLNx = PipeLN + "*";
	private static final String PipeLNs = PipeLN + "+";
	private static final String TDefLN = "\\V*?(?:\\|\\h*:?---+:?\\h*|\\h*:?---+:?\\h*\\|)+\\V*?\\R";
	private static final Pattern Tables = Pattern.compile(BLN + PipeLNx + TDefLN + PipeLNs);

	// { .class #id word="valid" } :: \{\h*([.#]\w+\h*|\w+\h*=\h*["']\w+["']\h*)+\}
	private static final Pattern Style = Pattern.compile("\\{\\h*([.#]\\w+\\h*|\\w+\\h*=\\h*[\"']\\w+[\"']\\h*)+\\}");

	// URL ::
	// (\w(\w|-)*\://)?(www\.)?(\w[A-z0-9#?&@=:-]*[/.]+)+(\w[A-z0-9#?&@=:-]*[/.]*)+
	private static final String URL = "(\\w(\\w|-)*\\://)?(www\\.)?(\\w[A-z0-9#?&@=:-]*[/.]+)+(\\w[A-z0-9#?&@=:-]*[/.]*)+";
	private static final String KEY = "\\[\\w+\\]";
	private static final String TITLE = "(\\h+[\"']\\w+[\"']\\h*)?";

	// Link :: [word](URL "title")
	// LRef :: [word][ref]
	// LUrl :: [URL]
	// LDef :: [ref]: URL "title"
	private static final Pattern Link = Pattern.compile("!?" + KEY + "\\h?\\(\\h*" + URL + TITLE + "\\)");
	private static final Pattern LRef = Pattern.compile("!?" + KEY + KEY);
	private static final Pattern LUrl = Pattern.compile("\\[" + URL + "\\]");
	private static final Pattern LDef = Pattern.compile(KEY + "\\:\\h*" + URL + TITLE);

	private final String data;
	private final char[] chars;
	private Token last;

	private List<Extent<Integer>> tables;
	private boolean done;

	public MdLexerBase(CharStream input) {
		super(input);
		data = input.toString();
		chars = data.toCharArray();
	}

	@Override
	public void emit(Token token) {
		super.emit(token);
		last = token;
	}

	@Override
	protected void queueBOF() {
		queue(MdLexer.LN_BLANK);
	}

	@Override
	protected void queueEOF() {
		if (!done) {
			done = true;
			if (last.getType() != MdLexer.LN_BLANK) queue(MdLexer.LN_BLANK);
		}
		super.queueEOF();
	}

	protected boolean inHeader() {
		int idx = _tokenStartCharIndex - _tokenStartCharPositionInLine;
		for (; idx >= 0; idx--) {
			if (Character.isWhitespace((int) chars[idx])) {
				if (HdrDef.matcher(data.substring(idx, _tokenStartCharIndex)).matches()) return true;
			}
		}
		return idx == 0 ? true : false;
	}

	protected boolean inTable() {
		if (tables == null) {
			tables = new ArrayList<>();
			Matcher m = Tables.matcher(data);
			while (m.find()) {
				tables.add(new Extent<>(m.start(), m.end()));
			}
		}
		for (Extent<Integer> table : tables) {
			if (table.contains(_tokenStartCharIndex)) return true;
		}
		return false;
	}

	protected boolean befBL() {
		String txt = _input.getText(Interval.of(_input.index(), _input.size()));
		return txt.matches("\\h*\\R\\h*\\R.*");
	}

	public static void infoBox(String msg, String title) {
		JOptionPane.showMessageDialog(null, msg, "Info: " + title, JOptionPane.INFORMATION_MESSAGE);
	}

	protected boolean style() {
		Matcher m = Style.matcher(data.substring(_tokenStartCharIndex));
		return m.lookingAt();
	}

	protected boolean link() {
		Matcher m = Link.matcher(data.substring(_tokenStartCharIndex));
		return m.lookingAt();
	}

	protected boolean lRef() {
		Matcher m = LRef.matcher(data.substring(_tokenStartCharIndex));
		return m.lookingAt();
	}

	protected boolean lUrl() {
		Matcher m = LUrl.matcher(data.substring(_tokenStartCharIndex));
		return m.lookingAt();
	}

	protected boolean lDef() {
		Matcher m = LDef.matcher(data.substring(_tokenStartCharIndex));
		return m.lookingAt();
	}

	protected boolean leftEdge(int len) {
		int at = _input.index() - len;
		boolean left = ws(at, -1);
		boolean right = ws(at, +1);
		// Log.debug(this, String.format("Left '%s' @%s %s:%s\n", enAt(at), at, left,
		// right));
		return left && !right;
	}

	protected boolean rightEdge(int len) {
		int at = _input.index() - len;
		boolean left = ws(at, -1);
		boolean right = ws(at, +1);
		// Log.debug(this, String.format("Right '%s' @%s %s:%s\n", enAt(at), at, left,
		// right));
		return !left && right;
	}

	// Some **word.**
	// (some **word!**)
	private boolean ws(int beg, int dir) {
		int idx = beg;
		do {
			idx += dir;
			if (idx < 0 || idx >= chars.length) return true;
			// Log.debug(this, String.format("Check '%s' @%s", enAt(idx), idx));
		} while (Attrs.contains(charAt(idx)) || Strings.isPunctuation(charAt(idx)));
		return Character.isWhitespace((int) charAt(idx));
	}

	private char charAt(int idx) {
		return _input.getText(Interval.of(idx, idx)).charAt(0);
	}

	@SuppressWarnings("unused")
	private String enAt(int idx) {
		return Strings.encode(_input.getText(Interval.of(idx, idx)));
	}

	// protected boolean next(char ch) {
	// return _input.LA(1) == ch;
	// }
	//
	// /**
	// * Gets the value of the symbol at offset {@code i} from the current position.
	// When {@code i==1},
	// * this method returns the value of the current symbol in the stream (which is
	// the next symbol to
	// be
	// * consumed). When {@code i==-1}, this method returns the value of the
	// previously read symbol in
	// the
	// * stream.
	// */
	// protected int la(int i) {
	// return _input.LA(i);
	// }
	//
	// /** Returns {@code true} if immediately after {@code Md2Lexer.LN_BLANK}. */
	// protected boolean aftLnBlank() {
	// if (bof()) return true;
	// if (!bol()) return false;
	// if (!_queue.isEmpty()) return _queue.peekLast().getType() ==
	// Md2Lexer.LN_BLANK;
	// return last.getType() == Md2Lexer.LN_BLANK;
	// }
}
