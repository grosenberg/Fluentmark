package net.certiv.fluent.dt.ui.formatter;

import java.text.BreakIterator;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.List;

/**
 * A word break iterator sensetive to markdown constructs
 */
public class WordBreakIterator extends BreakIterator {

	public static class Feature {

		int offset;
		int length;

		public Feature(int offset, int length) {
			super();
			this.offset = offset;
			this.length = length;
		}
	}

	private BreakIterator breaker;
	private List<Feature> features;

	// private String text;
	// private int textLength;
	// private boolean inXml;
	// private boolean inHyphenatedToken;

	public WordBreakIterator() {
		super();
		breaker = BreakIterator.getWordInstance();
		features = new ArrayList<>();
	}

	public void addFeature(int offset, int length) {
		features.add(new Feature(offset, length));
	}

	@Override
	public void setText(String newText) {
		// this.text = newText;
		// this.textLength = text.length();
		this.setText(new StringCharacterIterator(newText));
	}

	@Override
	public int next() {
		int next = breaker.next();

		// int current = breaker.current();
		// if (current == BreakIterator.DONE) return current;
		//
		// int next = breaker.next();
		// while (next != BreakIterator.DONE) {
		// if (next + Strings.EOL.length() >= textLength) break;
		//
		// if (breaker.isBoundary(next)) {
		// char c = text.charAt(next);
		// if (c == '!' || c == '[') {
		// if (text.substring(next).matches("")) {
		// text.m
		//
		// }
		// inXml = true;
		// break;
		// }
		// if (c == '-') {
		// // when a '-' is encountered, we need to keep going until we encounter
		// // a whitespace boundary. But we don't return the token in this case.
		// inHyphenatedToken = true;
		// }
		// if (inXml) {
		// // xml pattern tokenization, keep accumulating until the closing
		// // tag is encountered, then advance the breaker to the
		// // next token and return
		// if (c != '>') {
		// current = next;
		// continue;
		// }
		// // reset the inXml when '>' encountered
		// next = breaker.next();
		// current = next;
		// inXml = false;
		// break;
		// } else if (inHyphenatedToken) {
		// while (!Character.isWhitespace(c)) {
		// next = breaker.next();
		// if (next >= textLength) {
		// break;
		// }
		// c = text.charAt(next);
		// current = next;
		// continue;
		// }
		// inHyphenatedToken = false;
		// break;
		// } else {
		// if (Character.isLetterOrDigit(c)) {
		// // if the next boundary starts with a letter or digit, there is
		// // not much confusion as to whether it is a boundary or not.
		// break;
		// }
		// char precedingChar = text.substring(next - 1, next).charAt(0);
		// char followingChar = text.substring(next + 1, next + 2).charAt(0);
		// System.out.println("text[" + next + "]=" + c + ", preceding char=" + precedingChar
		// + ", following char=" + followingChar);
		// // Default rule: If the boundary is not a letter or digit, it can be one of
		// // the many punctuation chars. If the character before and after the boundary
		// // character is alphanumeric, then we consider this a boundary.
		// if (Character.isLetterOrDigit(precedingChar) && Character.isLetterOrDigit(followingChar))
		// {
		// break;
		// }
		// current = next;
		// }
		// } else {
		// break;
		// }
		// }
		return next;
	}

	@Override
	public int current() {
		return breaker.current();
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
	public int next(int n) {
		return breaker.next(n);
	}

	@Override
	public int previous() {
		return breaker.previous();
	}

	@Override
	public CharacterIterator getText() {
		return breaker.getText();
	}

	@Override
	public void setText(CharacterIterator newText) {
		breaker.setText(newText);
	}
}
