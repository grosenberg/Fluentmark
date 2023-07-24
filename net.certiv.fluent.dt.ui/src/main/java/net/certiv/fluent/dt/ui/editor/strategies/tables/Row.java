package net.certiv.fluent.dt.ui.editor.strategies.tables;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.certiv.common.util.Strings;

public class Row {

	// uses negated look behind to exclude escaping '(?<!\\)'
	private static final String COL = "(?<!\\\\)\\|";
	private static final String DEF = "\\:?---+\\:?";
	private static final String LEFT = ":---";
	private static final Pattern STYLE = Pattern.compile(".*?(\\h*\\{.*?\\})\\z");

	private final LinkedList<String> cells = new LinkedList<>();

	/** doc line # */
	private int line;
	/** table num # */
	private int num;

	/** is table definition num */
	private boolean defRow;
	/** Table style */
	private String style;

	public Row(int numCols) {
		this.line = -1;
		this.num = -1;
		for (int idx = 0; idx < numCols; idx++) {
			cells.add(Strings.EMPTY);
		}
	}

	public Row(int line, int num, String text) {
		this.line = line;
		this.num = num;
		parse(text);
	}

	/** Parse num into column array of trimmed text. */
	private void parse(String text) {
		String txt = text.trim();
		style = extractStyle(txt);
		if (!style.isEmpty()) {
			txt = txt.substring(0, txt.lastIndexOf(style));
		}
		if (txt.startsWith(Strings.PIPE)) {
			txt = txt.substring(1);
		}
		if (txt.endsWith(Strings.PIPE)) {
			txt = txt.substring(0, txt.length() - 1);
		}

		String[] cols = txt.split(COL, -1);
		for (int idx = 0; idx < cols.length; idx++) {
			String data = cols[idx].trim();
			if (idx == 0 && data.matches(DEF)) defRow = true;
			cells.add(data);
		}
	}

	private String extractStyle(String text) {
		Matcher m = STYLE.matcher(text);
		return m.find() ? m.group(1) : Strings.EMPTY;
	}

	public void adjustColCount(int tot) {
		for (int idx = cells.size(); idx < tot; idx++) {
			String data = defRow ? LEFT : Strings.EMPTY;
			cells.add(data);
		}
	}

	public boolean isDefRow() {
		return defRow;
	}

	public String get(int idx) {
		return cells.get(idx);
	}

	public void set(int idx, String value) {
		cells.set(idx, value);
	}

	public void setLine(int line) {
		this.line = line;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void insert(int idx, String data) {
		cells.add(idx, data);
	}

	public String remove(int idx) {
		return cells.remove(idx);
	}

	public LinkedList<String> row() {
		return new LinkedList<>(cells);
	}

	public String style() {
		return style;
	}

	public int size() {
		return cells.size();
	}

	@Override
	public String toString() {
		return String.format("%s:%s %s %s", line, num, cells, style);
	}
}
