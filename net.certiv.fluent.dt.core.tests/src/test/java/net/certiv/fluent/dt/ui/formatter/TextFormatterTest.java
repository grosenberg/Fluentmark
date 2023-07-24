package net.certiv.fluent.dt.ui.formatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.certiv.common.util.Strings;

class TextFormatterTest {

	@Test
	void fmtTestSpaces() {
		String src = "Some number   of words in a sentence. ";
		String fmt = "Some number of words in a sentence.";

		String sent = TextFormatter.para(src, Strings.EOL);
		assertEquals(fmt, sent);
	}

	@Test
	void fmtTestQuotes() {
		String src = "Some `number   of words`   in a sentence.   ";
		String fmt = "Some `number   of words` in a sentence.";

		String sent = TextFormatter.para(src, Strings.EOL);
		assertEquals(fmt, sent);
	}

	@Test
	void fmtTestQuotesEscaped() {
		String src = "Some \"number  \\\"  of words\"   in a sentence.   ";
		String fmt = "Some \"number  \\\"  of words\" in a sentence.";

		String sent = TextFormatter.para(src, Strings.EOL);
		assertEquals(fmt, sent);
	}

	@Test
	void fmtTestNoBreak() {
		String src = "Some number    of \r\nwords   in a sentence.   ";
		String fmt = "Some number of words in a sentence.";

		String sent = TextFormatter.para(src, Strings.EOL);
		assertEquals(fmt, sent);
	}

	@Test
	void fmtTestBreak() {
		String src = "Some number   \r\n  of words   in a sentence.   ";
		String fmt = "Some number  \r\nof words in a sentence.";

		String sent = TextFormatter.para(src, Strings.EOL);
		assertEquals(fmt, sent);
	}

	@Test
	void fmtTestEOP() {
		String src = "Some number    of words   in a sentence.   \r\n  ";
		String fmt = "Some number of words in a sentence.";

		String sent = TextFormatter.para(src, Strings.EOL);
		assertEquals(fmt, sent);
	}

	@Test
	void fmtTestList() {
		String src = " -  First list  line   \r\n  Second line in list.   ";
		String fmt = "    - First list line  \r\n      Second line in list.";

		String sent = TextFormatter.para(src, 4, 6, Strings.EOL);
		assertEquals(fmt, sent);
	}
}
