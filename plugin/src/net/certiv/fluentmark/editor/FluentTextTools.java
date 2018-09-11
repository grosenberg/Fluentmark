/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.editor;

import org.eclipse.core.filebuffers.LocationKind;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.jface.text.rules.IPartitionTokenScanner;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.ui.texteditor.ITextEditor;

import net.certiv.fluentmark.FluentUI;
import net.certiv.fluentmark.editor.color.IColorManager;

public class FluentTextTools {

	/** The document partitioning */
	private String partitioning;
	private String[] legalContentTypes;
	private PartitionScanner partitionScanner;

	public FluentTextTools(boolean autoDispose) {
		this(Partitions.PARTITIONING, Partitions.getLegalContentTypes(), autoDispose);
	}

	/**
	 * Creates a new Dsl text tools collection and eagerly creates and initializes all members of this
	 * collection.
	 */
	public FluentTextTools(String partitioning, String[] legalContentTypes, boolean autoDispose) {
		this.partitioning = partitioning;
		this.legalContentTypes = legalContentTypes;
	}

	/**
	 * Disposes all the individual tools of this tools collection.
	 */
	public void dispose() {}

	/**
	 * Get the known context types for documents handled by this editor. Does not include
	 * IDocument.DEFAULT_CONTENT_TYPE
	 */
	public String[] getContextTypes() {
		return legalContentTypes;
	}

	/**
	 * Get the document partitioning used for the Dsl partitioner.
	 *
	 * @return the document partitioning used for the Dsl partitioner
	 */
	public String getDocumentPartitioning() {
		return partitioning;
	}

	/**
	 * Set the document partitioning to be used for the Dsl partitioner.
	 */
	public void setDocumentPartitioning(String partitioning) {
		this.partitioning = partitioning;
	}

	/**
	 * Sets up the given document for the default partitioning.
	 *
	 * @param document the document to be set up
	 */
	public void setupDocument(IDocument document) {
		setupDocumentPartitioner(document, partitioning);
	}

	/**
	 * Sets up the given document for the default partitioning.
	 *
	 * @param document the document to be set up
	 * @param location the path of the resource backing the document. May be null.
	 * @param locationKind the type of path specified above. May be null.
	 */
	public void setupDocument(IDocument document, IPath location, LocationKind locationKind) {
		setupDocumentPartitioner(document, partitioning);
	}

	/**
	 * Sets up the document partitioner for the given document for the given partitioning.
	 */
	public void setupDocumentPartitioner(IDocument document, String partitioning) {
		IDocumentPartitioner partitioner = createDocumentPartitioner();
		if (partitioner != null) {
			partitioner.connect(document);
			if (document instanceof IDocumentExtension3) {
				IDocumentExtension3 extension3 = (IDocumentExtension3) document;
				extension3.setDocumentPartitioner(partitioning, partitioner);
			} else {
				document.setDocumentPartitioner(partitioner);
			}
		}
	}

	/** Factory method for creating an dsl editor specific document partitioner */
	public IDocumentPartitioner createDocumentPartitioner() {
		IPartitionTokenScanner scanner = createPartitionScanner();
		if (scanner == null) return null;
		return new FastPartitioner(scanner, legalContentTypes);
	}

	public IPartitionTokenScanner createPartitionScanner() {
		if (partitionScanner == null) {
			partitionScanner = new PartitionScanner();
		}
		return partitionScanner;
	}

	public SourceViewerConfiguration createSourceViewerConfiguraton(IPreferenceStore store, ITextEditor editor) {
		return createSourceViewerConfiguraton(store, editor, partitioning);
	}

	public SourceViewerConfiguration createSourceViewerConfiguraton(IPreferenceStore store, ITextEditor editor,
			String partitioning) {
		return new FluentSourceViewerConfiguration(getColorMgr(), store, editor, partitioning);
	}

	public SourceViewerConfiguration createSimpleSourceViewerConfiguration(IPreferenceStore store) {
		return createSimpleSourceViewerConfiguration(store, partitioning);
	}

	public SourceViewerConfiguration createSimpleSourceViewerConfiguration(IPreferenceStore store,
			String partitioning) {
		return new FluentSimpleSourceViewerConfiguration(getColorMgr(), store, null, partitioning, false);
	}

	private IColorManager getColorMgr() {
		return FluentUI.getDefault().getColorMgr();
	}

	// public SemanticHighlighting[] getSemanticHighlightings() {
	// return new SemanticHighlighting[0];
	// }

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
