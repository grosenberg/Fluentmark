/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.core.model;

import java.util.ArrayList;
import java.util.List;

import net.certiv.dsl.core.model.util.ISourceRange;

public class Page {

	private PagePart root;
	private String delim;

	private final List<PagePart> parts = new ArrayList<>();	// all page parts
	private final Headers headers = new Headers(this);		// all header page parts
	private final Lines lines = new Lines();				// all lines

	public Page(String content, String delim) {
		this.root = new PagePart(this, null, Item.PAGE, 0, content.length());
		this.delim = delim;
		lines.setup(content, delim);
	}

	public IPageElement root() {
		return root;
	}

	public List<PagePart> parts() {
		return parts;
	}

	public Headers headers() {
		return headers;
	}

	public Lines lines() {
		return lines;
	}

	public String delim() {
		return delim;
	}

	public ISourceRange regionAtOffset(int offset) {
		return partAtOffset(offset).getSourceRange();
	}

	/** Return the part of the given doc offset */
	public PagePart partAtOffset(int offset) {
		int idx = lineAtOffset(offset);
		return lines.getPagePart(idx);
	}

	/** Return the index of the line at the given doc offset */
	public int lineAtOffset(int offset) {
		if (lines.getOffsetMap() == null) return 0;
		Integer idx = lines.getOffsetMap().get(offset);
		if (idx == null) return 0;
		return idx;
	}

	/** Return the offset of the given line index */
	public int getOffset(int idx) {
		return lines.getOffset(idx);
	}

	/** Return the text of the given line index */
	public String getText(int idx) {
		return lines.getText(idx);
	}

	/** Return the length of the text of the given line index */
	public int getTextLength(int idx) {
		return lines.getTextLength(idx);
	}

	/** Return the iTEM of the line at the given line index */
	public Item getKind(int idx) {
		return lines.getKind(idx);
	}

	/** Returns the page parts in the order created */
	public List<PagePart> getPageParts() {
		return new ArrayList<>(parts);
	}

	/** Returns the page parts of the given item */
	public List<PagePart> getPageParts(Item item) {
		List<PagePart> itemParts = new ArrayList<>();
		for (PagePart part : parts) {
			if (part.getItem() == item) {
				itemParts.add(part);
			}
		}
		return itemParts;
	}

	/** Return the page part of the line at the given line index */
	public PagePart getPagePart(int idx) {
		return lines.getPagePart(idx);
	}

	/** Returns the part that follows the given part, or null */
	public PagePart getNext(PagePart part) {
		int idx = parts.indexOf(part);
		if (idx == -1) return null;
		if (idx < parts.size() - 2) return parts.get(idx + 1);
		return null;
	}

	public boolean isDotCodeBlock(int offset) {
		PagePart part = partAtOffset(offset);
		if (part.getMeta().startsWith(IPageElement.DOT)) return true;
		return false;
	}

	public void dispose() {
		if (root != null) root.dispose();
		if (parts != null) parts.clear();
		if (headers != null) headers.clear();
		if (lines != null) lines.clear();
	}
}
