/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.model;

/**
 * An element changed listener receives notification of changes to C elements
 * maintained by the C model.
 */
public interface IElementChangedListener {
	
	/**
	 * Notifies that one or more attributes of one or more C elements have changed.
	 * The specific details of the change are described by the given event.
	 *
	 * @param event the change event
	 */
	public void elementChanged(ElementChangedEvent event);
}
