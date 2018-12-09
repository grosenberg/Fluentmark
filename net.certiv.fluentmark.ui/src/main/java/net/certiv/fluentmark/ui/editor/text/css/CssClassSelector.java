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
 * a selector that selects elements based on their having a CSS class
 *
 * @author David Green
 * @see ElementInfo#hasCssClass(String)
 * @since 3.0
 */
public class CssClassSelector extends Selector {
	private final String cssClass;

	public CssClassSelector(String cssClass) {
		this.cssClass = cssClass;
	}

	@Override
	public boolean select(ElementInfo info) {
		return info.hasCssClass(cssClass);
	}

	public String getCssClass() {
		return cssClass;
	}
}
