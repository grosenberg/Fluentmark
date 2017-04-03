/*******************************************************************************
 * Copyright (c) 2016 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.editor.text;

import org.eclipse.jface.text.rules.IWordDetector;

public class MathWordDetector implements IWordDetector {

	@Override
	public boolean isWordStart(char c) {
		return c == '\\';
	}

	@Override
	public boolean isWordPart(char c) {
		return Character.isLetter(c);
	}
}
