/*******************************************************************************
 * Copyright (c) 2009, 2011 David Green and others.
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
 * @author David Green
 * @since 3.0
 */
public class DescendantSelector extends Selector {

	private final Selector ancestorSelector;

	public DescendantSelector(Selector ancestorSelector) {
		super();
		this.ancestorSelector = ancestorSelector;
	}

	@Override
	public boolean select(ElementInfo info) {
		ElementInfo ancestor = info.getParent();
		while (ancestor != null) {
			if (ancestorSelector.select(ancestor)) {
				return true;
			}
			ancestor = ancestor.getParent();
		}
		return false;
	}

	public Selector getAncestorSelector() {
		return ancestorSelector;
	}

}
