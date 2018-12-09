/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.ui.editor;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.IPartitionTokenScanner;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.ui.texteditor.ITextEditor;

import net.certiv.dsl.core.color.IColorManager;
import net.certiv.dsl.core.preferences.IDslPrefsManager;
import net.certiv.dsl.core.util.Strings;
import net.certiv.dsl.ui.editor.text.DslTextTools;
import net.certiv.fluentmark.core.FluentCore;

public class FluentTextTools extends DslTextTools {

	private PartitionScanner partitionScanner;

	public FluentTextTools(boolean autoDispose) {
		super(Partitions.PARTITIONING, Partitions.getLegalContentTypes(), autoDispose);
	}

	@Override
	public void createAutoClosePairs() {
		for (String contentType : Partitions.getAllContentTypes()) {
			addAutoClosePair(contentType, "{", "}");
			addAutoClosePair(contentType, "(", ")");
			addAutoClosePair(contentType, "[", "]");
			addAutoClosePair(contentType, "<", ">");
		}
	}

	@Override
	public void createAutoIndentPairs() {
		String[] contentTypes = { Partitions.CODEBLOCK, Partitions.DOTBLOCK, Partitions.UMLBLOCK };
		for (String contentType : contentTypes) {
			addAutoIndentPair(contentType, "{", "}");
		}
	}

	@Override
	public void createAutoCommentPairs() {
		addAutoCommentPair(Partitions.DOTBLOCK, "<!--", "-->");
		addAutoCommentPair(Partitions.HTMLBLOCK, "<!--", "-->");
	}

	@Override
	public void createStringDelimPairs() {
		String[] contentTypes = { IDocument.DEFAULT_CONTENT_TYPE, Partitions.DOTBLOCK, Partitions.CODEBLOCK,
				Partitions.HTMLBLOCK, Partitions.UMLBLOCK };
		for (String contentType : contentTypes) {
			addStringDelimPairs(contentType, '\'');
			addStringDelimPairs(contentType, '"');
		}
		addStringDelimPairs(IDocument.DEFAULT_CONTENT_TYPE, '`');
	}

	@Override
	public SourceViewerConfiguration createSourceViewerConfiguraton(IDslPrefsManager store, ITextEditor editor) {
		return createSourceViewerConfiguraton(store, editor, Partitions.PARTITIONING);
	}

	@Override
	public SourceViewerConfiguration createSourceViewerConfiguraton(IDslPrefsManager store, ITextEditor editor,
			String partitioning) {
		return new FluentSourceViewerConfiguration(getColorManager(), store, editor, partitioning);
	}

	@Override
	public SourceViewerConfiguration createSimpleSourceViewerConfiguration(IDslPrefsManager store) {
		return createSimpleSourceViewerConfiguration(store, Partitions.PARTITIONING);
	}

	@Override
	public SourceViewerConfiguration createSimpleSourceViewerConfiguration(IDslPrefsManager store,
			String partitioning) {
		return new FluentSimpleSourceViewerConfiguration(getColorManager(), store, null, partitioning, false);
	}

	@Override
	public IPartitionTokenScanner createPartitionScanner() {
		if (partitionScanner == null) {
			partitionScanner = new PartitionScanner();
		}
		return partitionScanner;
	}

	private IColorManager getColorManager() {
		return FluentCore.getDefault().getColorManager();
	}

	@Override
	public String[] getStringContentPartitions() {
		return Strings.EMPTY_STRINGS;
	}

	@Override
	public String[] getCommentContentPartitions() {
		return Strings.EMPTY_STRINGS;
	}

	@Override
	public String[] getStringAndCommentContentPartitions() {
		return Strings.EMPTY_STRINGS;
	}

	// /**
	// * Creates {@link SourceViewerConfiguration} to use in code template editor. Should
	// be
	// * overridden in ancestors.
	// *
	// * @param preferenceStore
	// * @param variableProcessor
	// * @return
	// */
	// public SourceViewerConfiguration createSourceViewerConfiguraton(IDslPrefsManager
	// preferenceStore,
	// ITextEditor editor, TemplateVariableProcessor variableProcessor) {
	// return createSourceViewerConfiguraton(preferenceStore, editor,
	// partitioning);
	// }
}
