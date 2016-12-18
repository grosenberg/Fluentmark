package net.certiv.fluentmark.model;

import java.util.Stack;

import net.certiv.fluentmark.model.Lines.Line;

public class Headers {

	public static class Header {

		IParent element;
		int level;
		Line line;

		public Header(IParent element) {
			this.element = element; // for header 0, text is null
		}

		public Header(IParent element, Line line) {
			this(element);
			this.line = line;
			this.level = computeLevel(line.text);
		}

		public String toString() {
			return "level: " + level;
		}
	}

	private Stack<Header> headers = new Stack<>();

	public Headers(PageRoot page) {
		headers.push(new Header(page)); // header 0 is the PageRoot
	}

	public void putHeader(IParent current, Line line) {
		headers.push(new Header(current, line));
	}

	public IParent getCurrentParent() {
		Header top = headers.peek();
		return top.element;
	}

	public IParent getEnclosingParent(int level) {
		if (level < 1) level = 1;
		if (level > 6) level = 6;
		while (headers.peek().level >= level) {
			headers.pop();
		}
		return headers.peek().element;
	}

	public static int computeLevel(String text) {
		int level = 0;
		while (level < text.length() && text.charAt(level) == '#' && level < 6) {
			level++;
		}
		return level;
	}

	public void clear() {
		while (headers.size() > 1) {
			headers.pop();
		}
	}

	public void dispose() {
		headers.clear();
	}
}
