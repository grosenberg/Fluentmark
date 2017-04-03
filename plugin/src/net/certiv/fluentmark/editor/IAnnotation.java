/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.editor;

import java.util.Iterator;

/**
 * IAnnotation Interface of annotations representing markers and problems.
 */
public interface IAnnotation {

	String getType();

	boolean isPersistent();

	boolean isMarkedDeleted();

	String getText();

	/**
	 * Returns whether this annotation is overlaid.
	 * 
	 * @return <code>true</code> if overlaid
	 */
	boolean hasOverlay();

	/**
	 * Returns the overlay of this annotation.
	 * 
	 * @return the annotation's overlay
	 */
	IAnnotation getOverlay();

	/**
	 * Returns an iterator for iterating over the annotation which are overlaid by this annotation.
	 * 
	 * @return an iterator over the overlaid annotations
	 */
	Iterator<IAnnotation> getOverlaidIterator();

	/**
	 * Adds the given annotation to the list of annotations which are overlaid by this annotations.
	 * 
	 * @param annotation the problem annotation
	 */
	void addOverlaid(IAnnotation annotation);

	/**
	 * Removes the given annotation from the list of annotations which are overlaid by this
	 * annotation.
	 * 
	 * @param annotation the problem annotation
	 */
	void removeOverlaid(IAnnotation annotation);

	/**
	 * Tells whether this annotation is a problem annotation.
	 * 
	 * @return <code>true</code> if it is a problem annotation
	 */
	boolean isProblem();

	/**
	 * Returns the problem arguments or <code>null</code> if no problem arguments can be evaluated.
	 * 
	 * @return returns the problem arguments or <code>null</code> if no problem arguments can be
	 *         evaluated.
	 */
	String[] getArguments();

	/**
	 * Returns the problem id or <code>-1</code> if no problem id can be evaluated.
	 * 
	 * @return returns the problem id or <code>-1</code>
	 */
	int getId();

	/**
	 * Returns the marker type associated to this problem or <code>null<code> if no marker type can
	 * be evaluated. See also {@link org.eclipse.cdt.ui.text.IProblemLocation#getMarkerType()}.
	 * 
	 * @return the type of the marker which would be associated to the problem or <code>null<code>
	 *         if no marker type can be evaluated.
	 */
	String getMarkerType();
}
