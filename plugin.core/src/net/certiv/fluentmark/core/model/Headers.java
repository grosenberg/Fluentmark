/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.core.model;

import java.util.Stack;

import net.certiv.fluentmark.core.model.Lines.Line;

public class Headers {

	private Stack<Header> headers = new Stack<>();
	private Page page;

	public Headers(Page page) {
		this.page = page;
		headers.push(new Header(page.root())); // header 0 is the root
	}

	public void putHeader(IPageElement current, Line line) {
		headers.push(new Header(current, line));
	}

	public IPageElement getCurrentParent() {
		Header top = headers.peek();
		return top.element;
	}

	public IPageElement getEnclosingParent(int level) {
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
		headers.clear();
		headers.push(new Header(page.root())); // make ready
	}

	public void dispose() {
		headers.clear();
	}

	public static class Header {

		IPageElement element;
		int level;
		Line line;

		public Header(IPageElement element) {
			this.element = element; // for header 0, text is null
		}

		public Header(IPageElement element, Line line) {
			this(element);
			this.line = line;
			this.level = computeLevel(line.text);
		}

		@Override
		public String toString() {
			return "level: " + level;
		}
	}
}
