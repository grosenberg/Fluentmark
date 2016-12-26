/*******************************************************************************
 * Copyright (c) 2016 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.model;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.PlatformObject;

public class Element extends PlatformObject implements IElement {

	public static final IElement[] NO_ELEMENTS = new Element[0];

	private IResource resource;
	private Kind kind;
	private int level;
	private String content;
	private ISourceRange range;

	// Part constructor
	public Element(Kind kind, ISourceRange range) {
		this.kind = kind;
		this.range = range;
	}

	// PageRoot constructor
	public Element() {
		this.kind = Kind.PAGE;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Object getAdapter(Class adapter) {
		if (IResource.class.isAssignableFrom(adapter)) {
			if (resource != null && adapter.isAssignableFrom(resource.getClass())) {
				return resource;
			}
		}
		return super.getAdapter(adapter);
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
	public Kind getKind() {
		return kind;
	}

	public void setKind(Kind kind) {
		this.kind = kind;
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
	 * Returns the content of this element with lines separated by EOLs. The content is terminated
	 * by an EOL.
	 */
	@Override
	public String getContent() {
		return getContent(false);
	}

	/**
	 * Returns the content of this element with lines separated by EOLs. The content is not
	 * terminated by an EOL if <code>noTerm</code> is true. Otherwise, the content is terminated by
	 * an EOL.
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
	public void dispose() {
		resource = null;
		kind = Kind.UNDEFINED;
		content = "";
		range = null;
	}

}
