package net.certiv.fluent.dt.ui.editor.strategies.tables;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.certiv.common.util.Strings;

class TableModelTest {

	String[] parseRow(String text) {
		String txt = text.trim();
		if (txt.startsWith(Strings.PIPE)) {
			txt = txt.substring(1);
		}
		if (txt.endsWith(Strings.PIPE)) {
			txt = txt.substring(0, txt.length() - 1);
		}

		// use look behind '(?<!\\)' to exclude escaping
		String[] cols = txt.split("(?<!\\\\)\\|", -1);
		for (int idx = 0; idx < cols.length; idx++) {
			cols[idx] = cols[idx].trim();
		}
		return cols;
	}

	static final String A = "a|b|c";
	static final String B = "|a|b|c";
	static final String C = "a|b|c|";
	static final String D = "|a|b|c|";

	@Test
	void parseRowTest() {
		String[] a = parseRow(A);
		String[] b = parseRow(B);
		String[] c = parseRow(C);
		String[] d = parseRow(D);

		assertEquals(3, a.length);
		assertEquals(3, b.length);
		assertEquals(3, c.length);
		assertEquals(3, d.length);
	}

}
