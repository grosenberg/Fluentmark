package net.certiv.fluent.dt.core.lang.md;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.TokenSource;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.misc.Pair;

import net.certiv.dsl.core.parser.IDslToken;
import net.certiv.dsl.core.util.Strings;
import net.certiv.fluent.dt.core.lang.md.gen.MdLexer;

public class MdToken extends CommonToken implements IDslToken {

	private int _mode;
	private int tabWidth;

	private boolean bof;
	private boolean bol;
	private int dents;

	private boolean quoted;
	private boolean inList;

	public MdToken(int type, String text, int tabWidth) {
		super(type, text);
		this.tabWidth = tabWidth;
	}

	public MdToken(Pair<TokenSource, CharStream> source, int type, int channel, int start, int stop, int tabWidth) {
		super(source, type, channel, start, stop);
		this.tabWidth = tabWidth;
	}

	public int lastLine() {
		return getLine() + Strings.countLines(getText());
	}

	@Override
	public int getMode() {
		return _mode;
	}

	public void setMode(int mode) {
		_mode = mode;
	}

	public boolean inList() {
		return inList;
	}

	public void setListMark() {
		inList = true;
	}

	public int getDents() {
		return dents;
	}

	public int calcDents() {
		int begOffset = start - charPositionInLine;
		if (begOffset == start) {
			dents = 0;
		} else {
			String prefix = source.b.getText(Interval.of(begOffset, start - 1));
			dents = Strings.computeIndentUnits(prefix, tabWidth);
		}
		return dents;
	}

	public boolean isQuoted() {
		return quoted;
	}

	public void setQuoted(boolean quoted) {
		this.quoted = quoted;
	}

	@Override
	public String toString() {
		String text = Strings.encode(getText());
		String tname = MdLexer.VOCABULARY.getDisplayName(type);
		String mname = _mode == 0 ? "default" : MdLexer.modeNames[_mode];
		String chan = channel == 0 ? "DEFAULT" : MdLexer.channelNames[channel];
		String mark = "    ";
		if (bol) mark = "/BOL";
		if (bof) mark = "/BOF";

		String msg = "%-2d %2d:%-2d %s%s (%s:%s:%s) '%s'";
		return String.format(msg, index, line, charPositionInLine, tname, mark, type, mname, chan, text);
	}
}
