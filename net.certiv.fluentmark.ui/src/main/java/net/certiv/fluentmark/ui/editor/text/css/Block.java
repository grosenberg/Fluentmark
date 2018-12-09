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

import java.util.ArrayList;
import java.util.List;

/**
 * An abstraction for a block of CSS rules
 *
 * @author David Green
 * @since 3.0
 */
public class Block {

	private final Selector selector;

	private final List<CssRule> rules;

	Block(Selector selector) {
		this(selector, new ArrayList<CssRule>());
	}

	Block(Selector selector, List<CssRule> rules) {
		this.selector = selector;
		this.rules = rules;
	}

	public Selector getSelector() {
		return selector;
	}

	public List<CssRule> getRules() {
		return rules;
	}
}
