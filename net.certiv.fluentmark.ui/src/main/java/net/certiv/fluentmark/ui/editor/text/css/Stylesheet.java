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
import java.util.Collections;
import java.util.List;

/**
 * An abstraction for a CSS stylesheet.
 *
 * @author David Green
 * @since 3.0
 */
public class Stylesheet {
	private final List<Block> blocks = new ArrayList<>();

	public List<Block> getBlocks() {
		return Collections.unmodifiableList(blocks);
	}

	public interface Receiver {
		void apply(CssRule rule);
	}

	public void applyTo(ElementInfo context, Receiver receiver) {
		for (Block block : blocks) {
			if (block.getSelector().select(context)) {
				for (CssRule rule : block.getRules()) {
					receiver.apply(rule);
				}
			}
		}
	}

	void add(Block block) {
		blocks.add(block);
	}
}
