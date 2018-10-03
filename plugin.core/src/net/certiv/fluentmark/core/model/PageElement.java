/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.core.model;

import java.util.List;

import org.eclipse.core.resources.IResource;

import net.certiv.dsl.core.model.IDslElement;
import net.certiv.dsl.core.model.SourceRef;
import net.certiv.dsl.core.model.util.ISourceRange;
import net.certiv.dsl.core.model.util.SourceRange;

public class PageElement extends SourceRef implements IPageElement {

	private IResource resource;
	private Item item;
	private int level;
	private String content;
	private ISourceRange range;

	// Page constructor
	public PageElement() {
		super(null, Item.PAGE.toString(), IDslElement.DSL_UNIT);
		this.item = Item.PAGE;
	}

	// PagePart constructor
	public PageElement(IPageElement parent, Item item, ISourceRange range) {
		super(parent, item.toString(), IDslElement.STATEMENT);
		this.item = item;
		this.range = range;
	}

	public void set(IResource resource, String content) {
		this.resource = resource;
		this.content = content;
		if (range == null) {
			range = new SourceRange(0, content.length());
		}
	}

	public void appendContent(String text) {
		content += text;
	}

	@Override
	public Item getItem() {
		return item;
	}

	public void setKind(Item item) {
		this.item = item;
	}

	@Override
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public IResource getResource() {
		return resource;
	}

	/**
	 * Returns the content of this element with lines separated by EOLs. The content is terminated by an
	 * EOL.
	 */
	@Override
	public String getContent() {
		return getContent(false);
	}

	/**
	 * Returns the content of this element with lines separated by EOLs. The content is not terminated
	 * by an EOL if <code>noTerm</code> is true. Otherwise, the content is terminated by an EOL.
	 */
	@Override
	public String getContent(boolean noTerm) {
		if (noTerm && content.length() > 0) {
			return content.substring(0, content.length() - 2);
		}
		return content;
	}

	@Override
	public ISourceRange getSourceRange() {
		return range;
	}

	@Override
	public IPageElement getLastChild() {
		List<IDslElement> children = getChildList();
		if (children.isEmpty()) return null;
		return (IPageElement) children.get(children.size() - 1);
	}

	@Override
	public void clear() {}

	@Override
	public void dispose() {
		resource = null;
		item = Item.UNDEFINED;
		content = "";
		range = null;
	}

	@Override
	public boolean canParent(int type) {
		return false;
	}

	@Override
	public boolean isBlockEnd() {
		return false;
	}
}
