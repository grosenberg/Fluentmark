package net.certiv.fluent.dt.ui.formatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.BreakIterator;
import java.util.LinkedList;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

import net.certiv.common.util.Strings;

class BreakerTest {

	private static final String SENTENCE = "Some number   of words in a sentence. ";
	private static final Pattern SPACES = Pattern.compile("\\s+");

	@Test
	void breakerTest() {
		WordBreakIterator breaker = new WordBreakIterator();
		breaker.setText(SENTENCE.trim());

		LinkedList<String> words = new LinkedList<>();

		int mark = 0;
		int dot = breaker.next();
		while (dot != BreakIterator.DONE) {
			String word = SENTENCE.substring(mark, dot);
			word = SPACES.matcher(word).replaceAll(Strings.SPACE);
			words.add(word);

			mark = dot;
			dot = breaker.next();
		}

		assertEquals(14, words.size());

		String join = String.join(Strings.EMPTY, words);
		assertEquals(35, join.length());
	}
}
