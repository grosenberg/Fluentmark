/*******************************************************************************
 * Copyright (c) 2009 David Green and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     David Green - initial API and implementation
 *******************************************************************************/

package net.certiv.fluentmark.ui.editor.text.css;

/**
 * A selector that selects elements having an id equal to a specific value.
 *
 * @author David Green
 * @since 3.0
 */
public class IdSelector extends Selector {

	private final String id;

	public IdSelector(String id) {
		this.id = id;
	}

	@Override
	public boolean select(ElementInfo info) {
		return info.hasId(id);
	}

	public String getId() {
		return id;
	}

}
