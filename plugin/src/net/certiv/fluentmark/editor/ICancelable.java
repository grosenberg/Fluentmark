/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.editor;

/**
 * Interface for cancelable objects.
 * 
 * @since 5.0
 */
public interface ICancelable {

	/**
	 * Marks the receiver cancelled.
	 */
	void cancel();
}
