/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluent.dt.ui.editor.text.rules;

import org.eclipse.jface.text.rules.IWordDetector;

import net.certiv.dsl.core.util.Chars;

public class UmlSymbolDetector implements IWordDetector {

	@Override
	public boolean isWordStart(char c) {
		return Chars.isPunctuation(c) || Chars.isSymbol(c);
	}

	@Override
	public boolean isWordPart(char c) {
		return Chars.isPunctuation(c) || Chars.isSymbol(c);
	}
}
