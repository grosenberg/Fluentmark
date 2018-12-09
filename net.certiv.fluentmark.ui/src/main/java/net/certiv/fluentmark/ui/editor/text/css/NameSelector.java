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
 * a selector that selects elements based on their {@link ElementInfo#getLocalName() name}
 *
 * @author David Green
 * @since 3.0
 */
public class NameSelector extends Selector {
	private final String name;

	public NameSelector(String name) {
		this.name = name;
	}

	@Override
	public boolean select(ElementInfo info) {
		return name.equalsIgnoreCase(info.getLocalName());
	}

	public String getName() {
		return name;
	}
}
