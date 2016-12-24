/*******************************************************************************
 * Copyright (c) 2016 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.model;

import net.certiv.fluentmark.convert.DotGen;
import net.certiv.fluentmark.model.Lines.Line;
import net.certiv.fluentmark.util.FloorKeyMap;
import net.certiv.fluentmark.util.Strings;

public class PagePart extends Parent {

	private PageRoot root;
	private Object data;

	// key=line idx, value=n/a
	private FloorKeyMap listMarkedLines;
	private PagePart separator;

	public PagePart(PageRoot root, IParent parent, Kind kind, int offset, int length) {
		this(root, parent, kind, offset, length, -1, -1);
	}

	public PagePart(PageRoot root, IParent parent, Kind kind, int offset, int length, int begLine, int endLine) {
		super(parent, kind, new SourceRange(offset, length, begLine, endLine));
		this.root = root;
		listMarkedLines = new FloorKeyMap();
	}

	public void addLine(Line line) {
		line.part = this;
		getSourceRange().addLine(line);
		appendContent(line.text + Strings.EOL);
	}

	public PagePart getSeparator() {
		return separator;
	}

	public void setSeparator(PagePart separator) {
		this.separator = separator;
	}

	/** Returns the full length of this part including blank separator */
	public int getLengthWithSep() {
		int len = getSourceRange().getLength();
		len += separator.getSourceRange().getLength();
		return len;
	}

	public PageRoot getPageModel() {
		return root;
	}

	public int getBeginLine() {
		return getSourceRange().getBeginLine();
	}

	public int getEndLine() {
		return getSourceRange().getEndLine();
	}

	public String getDisplayName() {
		return getKind().toString();
	}

	public boolean hasData() {
		return data != null;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getTooltip() {
		if (getKind() == Kind.CODE_BLOCK) return getMetaName();
		return getDisplayName();
	}

	private String getMetaName() {
		String meta = getMeta();
		return Strings.capitalize(meta) + " " + getDisplayName();
	}

	public String getMeta() {
		String meta = getFirstLine();
		if (meta.isEmpty()) {
			meta = "unknown";
		}
		if (meta.startsWith("    ")) {
			meta = "indented";
		}
		if (meta.startsWith("~~~") || meta.startsWith("```")) {
			meta = Strings.trimLeadingPunctuation(meta).trim();
			if (meta.isEmpty()) meta = DotGen.PLAIN;
		}
		return meta;
	}

	private String getFirstLine() {
		return getContent().split(Strings.EOL, 2)[0];
	}

	public String details(int offset) {

		int idx = PageRoot.MODEL.lineAtOffset(offset);
		int off = PageRoot.MODEL.getOffset(idx);

		int line = idx + 1;
		int col = offset - off + 1;

		StringBuilder sb = new StringBuilder();
		sb.append(getKind() + Strings.EOL);
		sb.append("Offset=" + offset + "; line=" + line + "; column=" + col + Strings.EOL);
		sb.append(getSourceRange() + Strings.EOL);
		sb.append(toString() + Strings.EOL);
		return sb.toString();
	}

	@Override
	public void clear() {
		super.clear();
		listMarkedLines.clear();
	}

	@Override
	public void dispose() {
		super.dispose();
		listMarkedLines.clear();
	}

	// controls text display in outline view
	public String toString() {
		switch (getKind()) {
			case CODE_BLOCK:
				return getMetaName();

			case HEADER:
			case LIST:
			case TABLE:
			case TEXT:
				String text = Strings.trimLeadingPunctuation(getFirstLine()).trim();
				return Strings.ellipsize(text, 40);

			case HRULE:
				return "";

			default:
				return getDisplayName();
		}
	}

	public void addListMarkedLine(int idx) {
		listMarkedLines.add(idx);
	}

	/**
	 * Returns the line index of the nearest lower marked list line given a line index in a list
	 * containing lines originally TEXT.
	 * 
	 * @param idx
	 * @return
	 */
	public int getPriorListMarkedLine(int idx) {
		if (listMarkedLines.isEmpty()) return -1;
		return listMarkedLines.find(idx);
	}

	/**
	 * Returns the line index of the next marked list line given a line index in a list containing
	 * lines originally TEXT.
	 * 
	 * @param idx
	 * @return
	 */
	public int getNextListMarkedLine(int idx) {
		int mark = getPriorListMarkedLine(idx);
		for (int key : listMarkedLines.keySet()) {
			if (key > mark) return key;
		}
		return -1;
	}

	public String getSublistContent(int idx) {
		int beg = getPriorListMarkedLine(idx);
		if (beg == -1) return "";
		int end = getNextListMarkedLine(idx);
		if (end == -1) end = getSourceRange().getEndLine() + 1;

		String marked = Strings.trimRight(root.getText(beg));

		StringBuilder sb = new StringBuilder(marked);
		for (int num = beg + 1; num < end; num++) {
			String text = Strings.trimRight(root.getText(num));
			sb.append(" " + text.trim());
		}
		return sb.toString();
	}
}
