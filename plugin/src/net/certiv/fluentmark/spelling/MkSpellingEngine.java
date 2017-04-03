/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.spelling;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.BadPartitioningException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.ui.texteditor.spelling.ISpellingProblemCollector;

import eclipse.spellchecker.TextSpellingEngine;
import eclipse.spellchecker.engine.ISpellChecker;
import net.certiv.fluentmark.FluentMkUI;
import net.certiv.fluentmark.Log;

public class MkSpellingEngine extends TextSpellingEngine {

	public static final String ID = "net.certiv.fluentmark.spelling.MkSpellingEngine";

	public MkSpellingEngine() {
		super(FluentMkUI.getDefault().getPreferenceStore());
	}

	/**
	 * Check the given document regions only for those regions that are in the default document
	 * partition.
	 */
	@Override
	protected void check(IDocument doc, IRegion[] regions, ISpellChecker checker, ISpellingProblemCollector collector,
			IProgressMonitor monitor) {

		Filter filter = new Filter();
		try {
			regions = filter.exec(doc, regions);
		} catch (BadLocationException | BadPartitioningException e) {
			Log.error("Failed to filter doc partitions: " + e.getMessage());
		}

		super.check(doc, regions, checker, collector, monitor);
	}
}
