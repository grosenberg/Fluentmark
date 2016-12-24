/*******************************************************************************
 * Copyright (c) 2016 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.model;

import java.util.EventObject;

/**
 * An element changed event describes a change to the structure or contents of a tree of elements.
 * The changes to the elements are described by the associated delta object carried by this event.
 */
public class ElementChangedEvent extends EventObject {

	private static final long serialVersionUID = 3257572793326252855L;

	/**
	 * Event type constant (bit mask) indicating an after-the-fact report of creations, deletions,
	 * and modifications to one or more Dsl element(s) expressed as a hierarchical Dsl element delta
	 * as returned by <code>getDelta()</code>. Note: this notification occurs during the
	 * corresponding POST_CHANGE resource change notification, and contains a full delta accounting
	 * for any DslModel operation and/or resource change.
	 */
	public static final int POST_CHANGE = 1;

	/**
	 * Event type constant (bit mask) indicating an after-the-fact report of creations, deletions,
	 * and modifications to one or more element(s) expressed as a hierarchical element delta as
	 * returned by <code>getDelta</code>. Note: this notification occurs as a result of a reconcile
	 * operation.
	 */
	public static final int POST_RECONCILE = 4;

	private IElement part;
	/* Event type indicating the nature of this event. */
	private int type;

	public ElementChangedEvent(IElement delta, IElement part, int type) {
		super(delta);
		this.part = part;
		this.type = type;
	}

	/**
	 * Returns the delta describing the change.
	 */
	public IElement getDelta() {
		return (IElement) source;
	}

	public IElement getPart() {
		return part;
	}

	/**
	 * Returns the type of event being reported.
	 * 
	 * @return one of the event type constants
	 */
	public int getType() {
		return type;
	}
}
