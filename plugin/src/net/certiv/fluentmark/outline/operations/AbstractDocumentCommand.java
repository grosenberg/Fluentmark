/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.outline.operations;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IUndoManager;

import net.certiv.fluentmark.FluentMkUI;

public abstract class AbstractDocumentCommand {

	protected String problemText;

	public void execute(IUndoManager undoManager, IDocument document) throws CoreException {
		if (!isEnabled()) {
			throw new IllegalStateException();
		}
		try {
			undoManager.beginCompoundChange();
			try {
				doCommand(document);
			} finally {
				undoManager.endCompoundChange();
			}
		} catch (BadLocationException e) {
			throw new CoreException(FluentMkUI.getDefault().createStatus(IStatus.ERROR, e));
		}
	}

	/**
	 * indicate if the command can be exectued
	 */
	public boolean isEnabled() {
		return getProblemText() == null;
	}

	/**
	 * indicate the cause of any problems (why the command cannot be executed).
	 */
	public String getProblemText() {
		return problemText;
	}

	protected void setProblemText(String problemText) {
		this.problemText = problemText;
	}

	protected abstract void doCommand(IDocument document) throws BadLocationException;
}
