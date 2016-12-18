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
	IParent[] getChildren() throws CoreException;

	List<IParent> getChildList() throws CoreException;

	/**
	 * returns the children of a certain kind
	 */
	List<IParent> getChildrenOfKind(Kind kind) throws CoreException;
}
