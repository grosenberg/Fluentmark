package net.certiv.fluent.dt.core.lang.md;

import static net.certiv.fluent.dt.core.lang.md.gen.MdLexer.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;

import net.certiv.common.stores.Extent;
import net.certiv.common.stores.NearMap;
import net.certiv.common.stores.TreeList;
import net.certiv.common.util.Chars;
import net.certiv.common.util.Strings;
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
			+ "\\{" + SPC 		//
			+ "(" + CLASS_ID	//
			+ "|" + KEY_VALUE 	//
			+ ")+" 				//
			+ "\\}" 			//
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

	private static final Pattern PUNCT = Pattern.compile("(\\p{Punct}+)");
	private final NearMap<Extent<Integer>> lEdges = new NearMap<>();
	private final NearMap<Extent<Integer>> rEdges = new NearMap<>();

	// key=line num; value=line tokens
	private final TreeList<Integer, Token> history = new TreeList<>();

	// key=line num; value=pipe tokens
	private final TreeList<Integer, Token> pipes = new TreeList<>();
	private final Map<Integer, Span> tables = new LinkedHashMap<>();

	private String data;
	private boolean lfin;
	private MdToken lastBlank;

	public MdLexerBase(CharStream input) {
		super(input);
		data = input.toString();
		defineExtents();

		setBofToken(LINE_BLANK, Strings.EMPTY);
		setEofToken(LINE_BLANK, Strings.EMPTY);

		setLnBegPrefixes(HWS, BLOCKQUOTE, LINE_DENT);

		setBlockBeg(LINE_BLANK);
		setBlkBegPrefixes(LINE_BLANK, VWS, HWS, BLOCKQUOTE, LINE_DENT);
	}

	private void defineExtents() {
		Matcher m = PUNCT.matcher(data);
		int len = data.length();
		boolean lWs;
		boolean lCh;
		boolean rWs;
		boolean rCh;

		while (m.find()) {
			int beg = m.start(1);
			int end = m.end(1);

			if (beg > 0) {
				int ch = data.charAt(beg - 1);
				lWs = Character.isWhitespace(ch);
				lCh = Character.isLetterOrDigit(ch);
			} else {
				lWs = true;
				lCh = false;
			}

			if (end < len) {
				int ch = data.charAt(end);
				rWs = Character.isWhitespace(ch);
				rCh = Character.isLetterOrDigit(ch);
			} else {
				rWs = true;
				rCh = false;
			}

			if (lWs && rCh) lEdges.put(beg, new Extent<>(beg, end));
			if (lCh && rWs) rEdges.put(beg, new Extent<>(beg, end));
		}
	}

	@Override
	public void emit(Token t) {
		MdToken token = (MdToken) t;
		switch (token.getType()) {
			case LINE_BLANK:
				lastBlank = token;
				break;

			case BULLET_MARK:
			case NUMBER_MARK:
			case PAREN_MARK:
			case LALPHA_MARK:
			case UALPHA_MARK:
				token.calcDents();
				if (_begBlock) {
					lastBlank.setListMark();
				} else if (!lastBlank.inList()) {
					token.setType(WORD);
				}
				break;

			case PIPE:
				pipes.put(token.getLine(), token);
				break;
			case TABLE:
				tables.put(token.getLine(), new Span(token.getLine()));
				break;

			case EOF:
				if (!history.isEmpty()) {
					expandTables();
					associateAttrs();
					history.clear();
				}
				break;
			default:
		}
		if (token.getChannel() == Token.DEFAULT_CHANNEL) {
			history.add(token.getLine(), token);
		}
		super.emit(token);
	}

	private void expandTables() {
		if (!tables.isEmpty() && !pipes.isEmpty()) {
			int beg = pipes.firstKey();
			int end = pipes.lastKey();
			for (Entry<Integer, Span> table : tables.entrySet()) {
				expandTable(table.getKey(), table.getValue(), beg, end, -1);
				expandTable(table.getKey(), table.getValue(), beg, end, +1);
			}
		}
		for (Token token : pipes.values()) {
			((MdToken) token).setType(WORD);
		}
	}

	private void expandTable(int tdx, Span span, int beg, int end, int inc) {
		for (int idx = tdx + inc; idx >= beg && idx <= end; idx += inc) {
			if (!pipes.containsKey(idx)) break;
			if (inc < 0) {
				span.beg = idx;
			} else {
				span.end = idx;
			}
			pipes.remove(idx);
		}
	}

	// word attributes: make left/right association
	private void associateAttrs() {
		for (Token token : history.values()) {
			switch (token.getType()) {
				case LBOLD:
					adjAttr(token, LBOLD, RBOLD, WORD);
					break;

				case LITALIC:
					adjAttr(token, LITALIC, RITALIC, WORD);
					break;

				case LSTRIKE:
					adjAttr(token, LSTRIKE, RSTRIKE, WORD);
					break;

				case LDQUOTE:
					adjAttr(token, LDQUOTE, RDQUOTE, WORD);
					break;

				case LSQUOTE:
					adjAttr(token, LSQUOTE, RSQUOTE, WORD);
					break;

				default:
			}
		}
	}

	private void adjAttr(Token token, int left, int right, int norm) {
		int idx = token.getStartIndex();
		if (lEdges.contains(idx)) {
			((MdToken) token).setType(left);
		} else if (rEdges.contains(idx)) {
			((MdToken) token).setType(right);
		} else {
			((MdToken) token).setType(norm);
		}
	}

	// setext-style header
	protected boolean hdr() {
		return lastBlank.lastLine() + 1 == getLine();
	}

	protected boolean list() {
		if (_begBlock) return true;
		return _begLine && lastBlank.inList();
	}

	protected boolean notDigit() {
		return !Character.isDigit(_input.LA(1));
	}

	protected boolean notTic() {
		return _input.LA(1) != Chars.TIC;
	}

	protected boolean link() {
		boolean found = false;
		String line = line(_pStartCharIndex);
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
		return check(Style);
	}

	private boolean check(Pattern pat) {
		Matcher m = pat.matcher(line(_pStartCharIndex));
		boolean found = m.lookingAt();
		// Log.debug(this, String.format("Cond %s '%s'", found, line));
		return found;
	}

	private String line(int from) {
		int dot = data.indexOf(Chars.NL, from);
		return dot > 0 ? data.substring(from, dot - 1) : data.substring(from);
	}
}
