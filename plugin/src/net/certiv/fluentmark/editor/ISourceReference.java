/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.editor;

import net.certiv.fluentmark.model.ISourceRange;

public interface ISourceReference {

	/**
	 * Returns the source code associated with this element.
	 * 
	 * @return the source code, or <code>null</code> if this element has no associated source code
	 */
	String getContent();

	/**
	 * Returns the source range associated with this element.
	 * 
	 * @return the source range
	 */
	ISourceRange getSourceRange();

	String getContent(boolean noTerm);
}
