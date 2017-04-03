/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.editor;

/**
 * An interface for objects accepting an instance of {@link ICancelable}.
 * 
 * @since 5.0
 */
public interface ICanceler {

	/**
	 * Set the cancelable object.
	 * 
	 * @param cancelable the cancelable object
	 */
	void setCancelable(ICancelable cancelable);

}
