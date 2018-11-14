package net.certiv.fluentmark.core.dot.parser;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.TokenSource;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.misc.Pair;

import net.certiv.dsl.core.util.Strings;
import net.certiv.fluentmark.core.md.parser.gen.MdLexer;

public class DotToken extends CommonToken {

	private int _mode;
	private int tabWidth;

	private boolean bof;
	private boolean bol;
	private int dents;

	public DotToken(int type, String text, int tabWidth) {
		super(type, text);
		this.tabWidth = tabWidth;
	}

	public DotToken(Pair<TokenSource, CharStream> source, int type, int channel, int start, int stop, int tabWidth) {
		super(source, type, channel, start, stop);
		this.tabWidth = tabWidth;
	}

	public void setMode(int mode) {
		_mode = mode;
	}

	public void setHit(boolean bof, boolean bol) {
		this.bof = bof;
		this.bol = bol;
		if (bof || bol) calcDents();
	}

	public boolean isBof() {
		return bof;
	}

	public void setBof(boolean bof) {
		this.bof = bof;
		if (bof) calcDents();
	}

	public boolean isBol() {
		return bol;
	}

	public void setBol(boolean bol) {
		this.bol = bol;
		if (bol) calcDents();
	}

	public int getDents() {
		return dents;
	}

	private void calcDents() {
		int begOffset = start - charPositionInLine;
		String prefix = source.b.getText(Interval.of(begOffset, start));
		dents = Strings.measureIndentLength(prefix, tabWidth);
	}

	@Override
	public String toString() {
		String text = "";
		try {
			text = Strings.encode(getText());
		} catch (Exception e) {}
		String tname = MdLexer.VOCABULARY.getDisplayName(type);
		String mname = _mode == 0 ? "default" : MdLexer.modeNames[_mode];
		String chan = channel == 0 ? "DEFAULT" : MdLexer.channelNames[channel];
		String mark = "/   ";
		if (bol) mark = "/BOL";
		if (bof) mark = "/BOF";

		String msg = "%-2d %2d:%-2d %s%s (%s:%s:%s) '%s'";
		return String.format(msg, index, line, charPositionInLine, tname, mark, type, mname, chan, text);
	}
}
