package net.certiv.fluent.dt.core.lang.md;

import static net.certiv.fluent.dt.core.lang.md.gen.MdLexer.*;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Interval;
import org.apache.commons.lang3.StringUtils;

import net.certiv.common.log.Log;
import net.certiv.common.stores.TreeList;
import net.certiv.common.util.Chars;
import net.certiv.common.util.Strings;
import net.certiv.common.util.TxtUtil;
import net.certiv.fluent.dt.core.lang.LexerNlp;

public abstract class MdLexerBase extends LexerNlp {

	private static final String TXT = "\\V*";
	private static final String SPC = "\\h*";

	private static final String CLASS_ID = "[\\.#]\\w+" + SPC;
	private static final String KEY = "\\w+";
	private static final String VALUE = "('" + TXT + "'|\"" + TXT + "\")";
	private static final String KEY_VALUE = KEY + SPC + "=" + SPC + VALUE + SPC;

	// { .class #id word="valid" }
	private static final Pattern Style = Pattern.compile("" //
			+ "\\{" + SPC 		// optional space
			+ "(" + CLASS_ID	// .class or #id
			+ "|" + KEY_VALUE 	// key/value pair
			+ ")+" 				// multi
			+ "\\}" 			// optional space
	);

	private static final String SelfLink = "" //
			+ "\\!?\\["	//
			+ "\\V*?"	//
			+ "\\][ ]?"	//
	;
	private static final String FullLink = SelfLink + "[\\(\\[]";
	private static final String RefLink = SelfLink + "\\:";

	private static final Pattern SELF_LINK = Pattern.compile(SelfLink);
	private static final Pattern FULL_LINK = Pattern.compile(FullLink);
	private static final Pattern REF_LINK = Pattern.compile(RefLink);

	private static final Pattern PAT_HDR = Pattern.compile("" //
			+ "[ ]{0,3}" //
			+ "(-{2,}" //
			+ "|={2,}" //
			+ ")\\h*" //
	);
	private static final Pattern PAT_HRULE = Pattern.compile("" //
			+ "[ ]{0,3}" //
			+ "(\\-\\h*\\-(\\h*\\-)+" //
			+ "|\\*\\h*\\*(\\h*\\*)+" //
			+ "|\\_\\h*\\_(\\h*\\_)+" //
			+ ")\\h*(\\{.*?\\}\\h*)?" //
	);

	private static final String QUOTED_MARK = "[ ]{0,3}>([ ]?>)*";
	private static final Pattern PAT_QUOTED = Pattern.compile(QUOTED_MARK);

	private static final String LIST_MARK = "" //
			+ "([ ]{0,3}>([ ]?>)*)?\\h*"  //
			+ "([*+-]" //
			+ "|[0-9a-zA-Z][.)]" //
			+ ") " //
	;

	private static final String LIST_TASK_MARK = LIST_MARK + "\\[[0-9a-zA-Z ]\\] ";//

	private static final Pattern PAT_LIST = Pattern.compile(LIST_MARK);
	private static final Pattern PAT_LIST_TASK = Pattern.compile(LIST_TASK_MARK);

	private static final String DEF_TERM = "[ ]{0,2}(\\w+(\\.\\w+)*(\\h+\\w+(\\.\\w+)*)*)+\\h*\\R";
	private static final String DEF_MARK = "^[ ]{0,2}[:]"; // only supports ':'

	private static final Pattern DEFINE_LIST = Pattern.compile("" //
			+ "(?m)" // multiline
			+ DEF_TERM //
			+ "(" + DEF_MARK + ".*?)*" //
			+ DEF_MARK  //
	);

	private static final Pattern EDGE = Pattern.compile("" //
			+ "[*_~'\"]*" //
			+ "(\\s" //
			+ "|[!#$%&()+,-./:;<=>?@[\\\\]^`{|}]" //
			+ "|$" //
			+ ")"//
	);

	class Span {
		int beg;
		int end;

		Span(int beg) {
			this(beg, beg);
		}

		Span(int beg, int end) {
			this.beg = beg;
			this.end = end;
		}
	}

	// key=line num; value=line tokens
	private final TreeList<Integer, Token> history = new TreeList<>();
	private final LinkedList<String> htmlBlocks = new LinkedList<>();

	private String data;
	private boolean lfin;
	private MdToken lastBlank;

	public MdLexerBase(CharStream input) {
		super(input);
		data = input.toString();

		setBofToken(LINE_BLANK, Strings.EMPTY);
		setEofToken(LINE_BLANK, Strings.EMPTY);

		setBlockBeg(LINE_BLANK);
		setBlkBegPrefixes(LINE_BLANK, LINE_BREAK, VWS, HWS, LINE_DENT, CODE_DENT, QUOTE_DENT);
		setLnBegPrefixes(HWS, LINE_DENT, CODE_DENT, QUOTE_DENT);
	}

	@Override
	public MdToken getToken() {
		return (MdToken) super.getToken();
	}

	@Override
	public void emit(Token t) {
		MdToken token = (MdToken) t;
		switch (token.getType()) {
			case LINE_BLANK:
				lastBlank = token;
				htmlBlocks.clear();
				break;

			case BULLET_MARK:
			case NUMBER_MARK:
				token.calcDents();
				if (_begBlock) {
					lastBlank.setListMark();
				} else if (!lastBlank.inList()) {
					Log.debug("Unmarking %s", token);
					token.setType(WORD);
				}
				break;

			case HTML_BLOCK_BEG:
				if (!htmlBlocks.isEmpty()) token.setType(HTML);
				htmlBlocks.push(blockName(token));
				break;
			case HTML_BLOCK_END:
				String tagname = blockName(token);
				while (!htmlBlocks.isEmpty()) {
					if (tagname.equals(htmlBlocks.peek())) break;
					htmlBlocks.pop();
				}
				htmlBlocks.pop();
				if (!htmlBlocks.isEmpty()) token.setType(HTML);
				break;

			case EOF:
				if (!history.isEmpty()) {
					history.clear();
					htmlBlocks.clear();
				}
				break;
			default:
		}

		if (token.getChannel() == Token.DEFAULT_CHANNEL) {
			history.add(token.getLine(), token);
		}

		// Log.debug("Emit: %s %s", //
		// getVocabulary().getDisplayName(token.getType()), token);
		super.emit(token);
	}

	private static final Pattern TN = Pattern.compile("</?(\\w+).*?>");

	private String blockName(MdToken token) {
		Matcher m = TN.matcher(token.getText());
		if (!m.find()) throw new RecognitionException(this, getInputStream(), null);
		return m.group(1);
	}

	/** Sets the current token type and performs a double mode pop. */
	protected int popMode2(int ttype) {
		setType(ttype);
		popMode();
		return popMode();
	}

	// setext-style header
	protected boolean hdr() {
		return lastBlank.lastLine() + 1 == getLine() && check(PAT_HDR, true);
	}

	protected boolean hrule() {
		return !hdr() && check(PAT_HRULE, true);
	}

	/**
	 * Nominally, every line is left-aligned: starts in col [0,3].
	 * <p>
	 * List items are indented at multiples of the tab width; default of 2 spaces.
	 * Paragraphs within lists are nominally indented aligned to their list item.
	 * <p>
	 * Block quotes are marked by RANGLE (sp? RANGLE)* sp?. The quote is marked on at at
	 * least the first line.
	 * <p>
	 * Un-fenced code blocks follow a LINE_BLANK with all lines indented at [4,].
	 */
	protected boolean dents() {
		if (!bol()) return false; // treat as plain HWS -> HIDDEN

		if (bob()) {
			if (!isListMark() && !quote()) { // adjust by side-effect!
				String ws = currentMatched();
				int cnt = TxtUtil.measureIndentInSpaces(ws, lastBlank.tabWidth());
				if (cnt >= 4) {
					lastBlank.setCodeBlock();
					setType(CODE_DENT);
				}
			}
		}

		if (lastBlank.inList()) {
			setChannel(HIDDEN); // emit as hidden LINE_DENT
			return true;
		}

		if (lastBlank.inCodeBlock()) {
			setChannel(HIDDEN); // emit as hidden CODE_DENT
			setType(CODE_DENT);
			return true;
		}

		if (lastBlank.inQuoteBlock()) {
			setChannel(HIDDEN); // emit as hidden QUOTE_DENT
			setType(QUOTE_DENT);
			return true;
		}

		return false;
	}

	/**
	 * Returns {@code true} if lexer is currently within the scope of a list.
	 *
	 * <pre>
	 * LINE_BLANK
	 * List intro:
	 * - first element
	 *   - nested paragraph element
	 *
	 *   - next nested element continues list
	 *
	 * List done.
	 * </pre>
	 *
	 * A list starts immediatly with:
	 * <ul>
	 * <li>new line token & list mark token sequence
	 * <li>blank line token, possible line begin tokens, & list mark token sequence
	 * </ul>
	 * Local emit sets the last seen LINE_BLANK token to the list type. The current list
	 * continues until the next blank line token.
	 */
	protected boolean isListMark() {
		if (!bol() || !check(PAT_LIST, true)) return false;
		if (!lastBlank.inList()) lastBlank.setListMark();
		return true;
	}

	protected boolean isTaskMark() {
		return check(PAT_LIST_TASK, true);
	}

	private boolean quote() {
		if (!bol() || !check(PAT_QUOTED, true)) return false;
		if (!lastBlank.inQuoteBlock()) lastBlank.setQuoteBlock();
		return true;
	}

	/**
	 * Returns {@code true} if lexer is currently within the scope of a list.
	 *
	 * <pre>
	 * LINE_BLANK
	 * Term
	 * : multi-paragraph definition
	 * LINE_BLANK
	 * </pre>
	 *
	 * A list starts immediatly with:
	 * <ul>
	 * <li>new line token & list mark token sequence
	 * <li>blank line token, possible line begin tokens, & list mark token sequence
	 * </ul>
	 * Local emit sets the last seen LINE_BLANK token to the list type. The current list
	 * continues until the next blank line token.
	 */
	protected boolean define() {
		if (!bol() || !inDefineList()) return false;
		if (!lastBlank.inDefineList()) lastBlank.setDefineList();
		return true;
	}

	private boolean inDefineList() {
		int beg = lastBlank.getStopIndex() + 1;
		int end = _pStartCharIndex;
		String txt = getInputStream().getText(Interval.of(beg, end));
		return DEFINE_LIST.matcher(txt).lookingAt();
	}

	protected boolean notDigit() {
		return !Character.isDigit(_input.LA(1));
	}

	protected boolean notTic() {
		return _input.LA(1) != Chars.TIC;
	}

	protected boolean attr() {
		boolean lft = attrLeftEdge();
		boolean rgt = attrRightEdge();

		if (lft && rgt || !lft && !rgt) { // alone or mid
			if (isListMark() || hrule()) return false;
			setType(WORD);
			return true;
		}

		String attr = currentMatched();
		switch (attr) {
			case "**":
			case "__":
				setType(lft ? LBOLD : RBOLD);
				return true;

			case "*":
			case "_":
				setType(lft ? LITALIC : RITALIC);
				return true;

			case "~~":
				setType(lft ? LSTRIKE : RSTRIKE);
				return true;

			case "\"":
				setType(lft ? LDQUOTE : RDQUOTE);
				return true;

			case "'":
				setType(lft ? LSQUOTE : RSQUOTE);
				return true;

			default:
				return true;
		}
	}

	private boolean attrLeftEdge() {
		String line = linePrefix(_pStartCharIndex + currentMatched().length());
		boolean lf = EDGE.matcher(StringUtils.reverse(line)).lookingAt();
		// Log.debug("Left_Edge[%b] %s <%s:%s:%s> %s", //
		// lf, currentMatched(), _pStartLine, _pStartCharPositionInLine, _pStartCharIndex,
		// Strings.encode(line));
		return lf;
	}

	private boolean attrRightEdge() {
		String line = lineSuffix(_pStartCharIndex);
		boolean rt = EDGE.matcher(line).lookingAt();
		// Log.debug("RightEdge[%b] %s <%s:%s:%s> %s", //
		// rt, currentMatched(), _pStartLine, _pStartCharPositionInLine, _pStartCharIndex,
		// Strings.encode(line));
		return rt;
	}

	protected boolean link() {
		boolean found = false;
		String line = lineSuffix(_pStartCharIndex);
		if (FULL_LINK.matcher(line).lookingAt()) {
			lfin = false;
			found = true;
		} else if (REF_LINK.matcher(line).lookingAt()) {
			lfin = true;
			found = true;
		} else if (SELF_LINK.matcher(line).lookingAt()) {
			lfin = true;
			found = true;
		}
		return found;
	}

	protected boolean chkVws() {
		if (lfin) popMode();
		return lfin;
	}

	protected boolean style() {
		return check(Style, false);
	}

	/**
	 * @param pat   pattern to check
	 * @param whole {@code true} to check against whole line, otherwise from the current
	 *              token start position
	 */
	private boolean check(Pattern pat, boolean whole) {
		String line = whole ? line(_pStartCharIndex) : lineSuffix(_pStartCharIndex);
		// Log.debug("Checking line (%s) at %s: %s", //
		// whole ? "whole" : "suffix", _pStartCharIndex, Strings.encode(line));
		Matcher m = pat.matcher(line);
		return m.lookingAt();
	}

	/** Returns the entire current line for the given pos. */
	private String line(int pos) {
		return linePrefix(pos) + lineSuffix(pos);
	}

	/** Returns the current line suffix: {@code [pos,eol)}. */
	private String lineSuffix(int pos) {
		int end = data.indexOf(Chars.NL, pos);
		return end > 0 ? data.substring(pos, end - 1) : data.substring(pos);
	}

	/** Returns the current line prefix: {@code [0,pos)}. */
	private String linePrefix(int pos) {
		int beg = data.lastIndexOf(Chars.NL, pos);
		beg = beg > 0 ? beg + 1 : 0;
		return data.substring(beg, pos);
	}
}
