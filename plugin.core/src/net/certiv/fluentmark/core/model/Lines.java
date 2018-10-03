/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.core.model;

import java.util.LinkedHashMap;
import java.util.Map;

import net.certiv.dsl.core.preferences.consts.Editor;
import net.certiv.dsl.core.util.Indent;
import net.certiv.dsl.core.util.stores.FloorKeyMap;
import net.certiv.fluentmark.core.FluentCore;

public class Lines {

	public static class Line {

		public String text = "";
		public int offset = 0;
		public int length = 0;
		public int idx = -1;
		public Item item = Item.UNDEFINED;	// effective
		Item nKind = item; 			// natural/original
		PagePart part;

		private boolean blankPrior;
		private boolean blankNext;

		public Line() {
			blankPrior = true;
			blankNext = true;
		}

		public Line(int delimLen, Line prior, String line) {
			this();
			this.text = line;
			this.offset = prior.offset + prior.length;
			this.length = line.length() + delimLen;
			this.idx = prior.idx + 1;

			blankPrior = prior.isBlank();
			prior.blankNext = isBlank();
		}

		@Override
		public String toString() {
			return String.format("%4d %-6.6s/%-6.6s [%5d:%3d] %s", //
					idx, item.toString(), nKind.toString(), offset, length, text);
		}

		/** Just ws. */
		public boolean isBlank() {
			return text.trim().isEmpty();
		}

		public boolean isBlankPrior() {
			return blankPrior;
		}

		public boolean isBlankNext() {
			return blankNext;
		}
	}

	private String lineDelim;
	private Map<Integer, Line> lineList = new LinkedHashMap<>();
	private FloorKeyMap lineMap;

	public Lines() {}

	public void setup(String content, String lineDelim) {
		this.lineDelim = lineDelim;
		load(content);
	}

	private void load(String content) {
		String[] lines = content.split(lineDelim, -1); // do not skip blank lines
		int delimLen = lineDelim != null ? lineDelim.length() : 0;
		if (lineMap != null) lineMap.clear();
		lineMap = new FloorKeyMap(lines.length);
		Line prior = new Line();
		for (int idx = 0; idx < lines.length; idx++) {
			Line line = new Line(delimLen, prior, lines[idx]);
			lineList.put(idx, line);
			lineMap.put(line.offset, idx);
			prior = line;
		}
	}

	/** Number of lines in content */
	public int length() {
		return lineList.size();
	}

	public FloorKeyMap getOffsetMap() {
		return lineMap;
	}

	public Line getLine(int idx) {
		return lineList.get(idx);
	}

	public int getOffset(int idx) {
		return lineList.get(idx).offset;
	}

	public String getText(int idx) {
		return lineList.get(idx).text;
	}

	public int getTextLength(int idx) {
		return lineList.get(idx).length;
	}

	public Item getKind(int idx) {
		return lineList.get(idx).item;
	}

	public Item getOriginalKind(int idx) {
		return lineList.get(idx).nKind;
	}

	public void setKind(int idx, Item item) {
		Line line = lineList.get(idx);
		line.item = item;
		if (line.nKind == Item.UNDEFINED) {
			line.nKind = item; // preserve the original item
		}
	}

	public PagePart getPagePart(int idx) {
		return lineList.get(idx).part;
	}

	public void setPagePart(int idx, PagePart part) {
		lineList.get(idx).part = part;
	}

	public Item identifyKind(int idx) {
		Line curr = lineList.get(idx);
		Line next = lineList.size() > idx + 1 ? lineList.get(idx + 1) : null;

		String curTxt = curr.text;
		String nxtTxt = next != null ? next.text : "";

		boolean priorblank = curr.isBlankPrior();
		boolean curblank = curr.isBlank();
		boolean nxtblank = next != null ? next.isBlank() : true;
		boolean nxtnxtblank = next != null ? next.isBlankNext() : true;

		if (curblank) return Item.BLANK;

		if (idx == 0 && curTxt.startsWith("---")) return Item.FRONT_MATTER;

		if (curTxt.startsWith("#")) return Item.HEADER;
		if (!curblank && nxtnxtblank && (nxtTxt.startsWith("---") || nxtTxt.startsWith("==="))) return Item.HEADER;
		if (!priorblank && nxtblank && (curTxt.startsWith("---") || curTxt.startsWith("==="))) return Item.SETEXT;

		if (curTxt.startsWith("$$")) return Item.MATH_BLOCK;
		if (priorblank && nxtblank && curTxt.matches("\\$\\S.*?\\S\\$.*")) return Item.MATH_BLOCK_INLINE;

		if (curTxt.startsWith("<!---")) return Item.COMMENT;
		if (curTxt.startsWith("--->")) return Item.COMMENT;

		if (priorblank && nxtblank && curTxt.startsWith("___")) return Item.HRULE;
		if (priorblank && nxtblank && curTxt.startsWith("***")) return Item.HRULE;
		if (priorblank && nxtblank && curTxt.startsWith("---")) return Item.HRULE;

		if (curTxt.matches("(\\|\\s?\\:?---+\\:?\\s?)+\\|.*")) return Item.TABLE;

		if (curTxt.matches("\\s*\\*\\s+.*")) return Item.LIST;
		if (curTxt.matches("\\s*\\-\\s+.*")) return Item.LIST;
		if (curTxt.matches("\\s*\\+\\s+.*")) return Item.LIST;
		if (curTxt.matches("\\s*\\d+\\.\\s+.*")) return Item.LIST;

		if (curTxt.matches("(\\>+\\s+)+.*")) return Item.QUOTE;
		if (curTxt.matches("\\:\\s+.*")) return Item.DEFINITION;
		if (curTxt.matches("\\[\\^?\\d+\\]\\:\\s+.*")) return Item.REFERENCE;

		if (curTxt.matches("\\</?\\w+(\\s+.*?)?/?\\>.*")) return Item.HTML_BLOCK;

		if (curTxt.startsWith("```")) return Item.CODE_BLOCK;
		if (curTxt.startsWith("~~~")) return Item.CODE_BLOCK;
		if (curTxt.matches("    .*")) return Item.CODE_BLOCK_INDENTED;

		if (priorblank && curTxt.startsWith("@start")) return Item.CODE_BLOCK;
		if (nxtblank && curTxt.startsWith("@end")) return Item.CODE_BLOCK;

		return Item.TEXT;
	}

	public int nextMatching(int mark, String exact) {
		return nextMatching(mark, null, exact);
	}

	public int nextMatching(int mark, Item item) {
		return nextMatching(mark, item, null);
	}

	public int nextMatching(int mark, Item item, String exact) {
		for (int idx = mark + 1; idx < length(); idx++) {
			boolean ok = item != null ? item == identifyKind(idx) : true;
			ok = ok && (exact != null) ? lineList.get(idx).text.startsWith(exact) : ok;
			if (ok) return idx;
		}
		return length() - 1;
	}

	public void clear() {
		lineList.clear();
	}

	public void dispose() {
		clear();
	}

	public static int computeLevel(String text) {
		int width = FluentCore.getDefault().getPrefsManager().getInt(Editor.EDITOR_TAB_WIDTH);
		return Indent.measureIndentInSpaces(text, width);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Line line : lineList.values()) {
			sb.append(line.toString());
		}
		return sb.toString();
	}
}
