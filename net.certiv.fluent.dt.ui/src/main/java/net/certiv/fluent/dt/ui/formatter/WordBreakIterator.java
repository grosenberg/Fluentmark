package net.certiv.fluent.dt.ui.formatter;

import java.text.BreakIterator;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class WordBreakIterator extends BreakIterator {

	private BreakIterator breaker;

	public WordBreakIterator() {
		super();
		breaker = BreakIterator.getWordInstance();
	}

	@Override
	public CharacterIterator getText() {
		return breaker.getText();
	}

	@Override
	public void setText(CharacterIterator txt) {
		breaker.setText(txt);
	}

	@Override
	public void setText(String txt) {
		setText(new StringCharacterIterator(txt));
	}

	/**
	 * Advance the current position of this iterator by the given number of characters.
	 *
	 * @param inc advancement count
	 * @return updated iterator position
	 */
	public int advance(int inc) {
		int dot = current();
		if (inc <= 0) return dot;
		return following(dot + inc - 1);
	}

	@Override
	public int current() {
		return breaker.current();
	}

	@Override
	public int next() {
		return breaker.next();
	}

	@Override
	public int next(int n) {
		return breaker.next(n);
	}

	@Override
	public int first() {
		return breaker.first();
	}

	@Override
	public int following(int offset) {
		return breaker.following(offset);
	}

	@Override
	public int last() {
		return breaker.last();
	}

	@Override
	public int previous() {
		return breaker.previous();
	}
}
