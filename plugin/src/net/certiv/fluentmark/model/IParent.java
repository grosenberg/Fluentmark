/*******************************************************************************
 * Copyright (c) 2016 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.model;

import java.util.List;

import org.eclipse.core.runtime.CoreException;

/**
 * Common protocol for elements that contain other elements.
 */
public interface IParent extends IElement {

	IParent getParent();

	void addChild(IParent part);

	IParent getLastChild();

	/**
	 * Returns whether this element has one or more immediate children. This is a convenience
	 * method, and may be more efficient than testing whether <code>getChildren</code> is an empty
	 * array.
	 * 
	 * @exception CoreException if this element does not exist or if an exception occurs while
	 *                accessing its corresponding resource
	 */
	boolean hasChildren();

	/**
	 * Returns the immediate children of this element. The children are in no particular order.
	 * 
	 * @exception CoreException if this element does not exist or if an exception occurs while
	 *                accessing its corresponding resource
	 */
	IParent[] getChildren();

	List<IParent> getChildList();

	/**
	 * returns the children of a certain kind
	 */
	List<IParent> getChildrenOfKind(Kind kind) throws CoreException;

	/**
	 * Returns whether the receiver is an ancestor of the given child.
	 */
	boolean isAncestor(IParent child);
}
