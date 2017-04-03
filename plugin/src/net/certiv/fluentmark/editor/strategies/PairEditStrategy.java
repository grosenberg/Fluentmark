/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.editor.strategies;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;

/**
 * AutoEdit strategy to determine when opening pair character is inserted and insert the
 * corresponding closing character.
 */
public class PairEditStrategy implements IAutoEditStrategy {

	@Override
	public void customizeDocumentCommand(IDocument doc, DocumentCommand cmd) {
		if (cmd.getCommandCount() != 1 || cmd.length != 0) return;

		try {
			switch (cmd.text) {

				case "[":
					AutoEdit.insert(cmd, "]");
					break;
				case "(":
					AutoEdit.insert(cmd, ")");
					break;
				case "{":
					AutoEdit.insert(cmd, "}");
					break;

				case "'":
				case "`":
				case "\"":
				case "]":
				case ")":
				case "}":
					if (AutoEdit.atSameChar(doc, cmd)) {
						AutoEdit.skipRight(cmd);
					} else {
						AutoEdit.insert(cmd);
					}
					break;
			}
		} catch (BadLocationException e) {}
	}
}
