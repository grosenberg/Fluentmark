/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.CoreException;

public abstract class Parent extends Element implements IParent {

	private IParent parent;
	private final List<IParent> children = new ArrayList<>();
	private boolean changed;
	private String lineDelim;

	public Parent(IParent parent, Kind kind, ISourceRange range) {
		super(kind, range);
		this.parent = parent;
		this.lineDelim = parent.getLineDelim();
	}

	public Parent(String lineDelim) {
		super();
		this.lineDelim = lineDelim;
	}

	@Override
	public IParent getParent() {
		return parent;
	}

	/** Adds a child to the current element. */
	@Override
	public void addChild(IParent member) {
		children.add(member);
	}

	@Override
	public IParent getLastChild() {
		synchronized (children) {
			if (!children.isEmpty()) {
				return children.get(children.size() - 1);
			}
		}
		return this;
	}

	/** Removes a child to the current element. */
	public void removeChild(IParent member) throws CoreException {
		children.remove(member);
	}

	public void removeChildren() throws CoreException {
		children.clear();
	}

	/** Gets the children of this element. */
	@Override
	public IParent[] getChildren() {
		synchronized (children) {
			return children.toArray(new IParent[children.size()]);
		}
	}

	/** Gets the children of a certain type */
	@Override
	public List<IParent> getChildrenOfKind(Kind kind) throws CoreException {
		ArrayList<IParent> list = new ArrayList<>();
		for (IParent child : getChildren()) {
			if (child.getKind() == kind) {
				list.add(child);
			}
		}
		return list;
	}

	@Override
	public List<IParent> getChildList() {
		return new ArrayList<>(Arrays.asList(getChildren()));
	}

	@Override
	public boolean hasChildren() {
		synchronized (children) {
			return !children.isEmpty();
		}
	}

	@Override
	public boolean isAncestor(IParent child) {
		IParent parent = child.getParent();
		if (parent == null) {
			return false;
		} else if (parent.equals(this)) {
			return true;
		} else {
			return isAncestor(parent);
		}
	}

	protected void setChanged() {
		this.changed = true;
	}

	protected boolean hasChanged() {
		return changed;
	}

	/** Return the line delimiter for the model content */
	public String getLineDelim() {
		return lineDelim;
	}

	@Override
	public void dispose() {
		for (IParent child : children) {
			child.dispose();
		}
		children.clear();
		super.dispose();
	}

	public void clear() {
		children.clear();
	}

	@Override
	public int hashCode() {
		return getContent().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (obj instanceof Parent) {
			return getContent().equals(((Parent) obj).getContent());
		}
		return false;
	}
}
