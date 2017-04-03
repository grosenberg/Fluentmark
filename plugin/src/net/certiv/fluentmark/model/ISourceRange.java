/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.model;

import net.certiv.fluentmark.model.Lines.Line;

/**
 * A source range defines an element's source coordinates
 */
public interface ISourceRange {

	/** Add the given line to this range */
	void addLine(Line line);

	/**
	 * Returns the number of characters of the source code for this element.
	 */
	int getLength();

	/**
	 * Returns the 0-based index of the first character of the source code for this element,
	 * relative to the source buffer in which this element is contained.
	 * 
	 * @return the 0-based index of the first character of the source code for this element,
	 *         relative to the source buffer in which this element is contained
	 */
	int getOffset();

	/**
	 * Returns the 0-based starting position of this element.
	 */
	int getStartPos();

	/**
	 * Returns the 1-based starting line of this element.
	 */
	int getBeginLine();

	/**
	 * Returns the 1-based ending line of this element.
	 */
	int getEndLine();
}
