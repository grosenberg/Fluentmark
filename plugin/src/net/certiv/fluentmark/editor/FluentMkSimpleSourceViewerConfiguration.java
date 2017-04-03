/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.editor;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.formatter.IContentFormatter;
import org.eclipse.jface.text.hyperlink.IHyperlinkDetector;
import org.eclipse.jface.text.information.IInformationPresenter;
import org.eclipse.jface.text.source.IAnnotationHover;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.texteditor.ITextEditor;

import net.certiv.fluentmark.editor.color.IColorManager;

/**
 * A simple source viewer configuration. Provides syntax coloring and disables all other features
 * like code assist, quick outlines, hyperlinking, etc.
 *
 * @since 3.1
 */
public class FluentMkSimpleSourceViewerConfiguration extends FluentMkSourceViewerConfiguration {

	private boolean fConfigureFormatter;

	/**
	 * Creates a new source viewer configuration for viewers in the given editor using the given
	 * preference store, the color manager and the specified document partitioning.
	 *
	 * @param colorManager the color manager
	 * @param store the preference store, can be read-only
	 * @param editor the editor in which the configured viewer(s) will reside, or <code>null</code>
	 *            if none
	 * @param partitioning the document partitioning for this configuration, or <code>null</code>
	 *            for the default partitioning
	 * @param configureFormatter <code>true</code> if a content formatter should be configured
	 */
	public FluentMkSimpleSourceViewerConfiguration(IColorManager colorManager, IPreferenceStore store, ITextEditor editor,
			String partitioning, boolean configureFormatter) {
		super(colorManager, store, editor, partitioning);
		fConfigureFormatter = configureFormatter;
	}

	@Override
	public IAutoEditStrategy[] getAutoEditStrategies(ISourceViewer sourceViewer, String contentType) {
		return null;
	}

	@Override
	public IAnnotationHover getAnnotationHover(ISourceViewer sourceViewer) {
		return null;
	}

	@Override
	public IAnnotationHover getOverviewRulerAnnotationHover(ISourceViewer sourceViewer) {
		return null;
	}

	@Override
	public int[] getConfiguredTextHoverStateMasks(ISourceViewer sourceViewer, String contentType) {
		return null;
	}

	@Override
	public ITextHover getTextHover(ISourceViewer sourceViewer, String contentType, int stateMask) {
		return null;
	}

	@Override
	public ITextHover getTextHover(ISourceViewer sourceViewer, String contentType) {
		return null;
	}

	@Override
	public IContentFormatter getContentFormatter(ISourceViewer sourceViewer) {
		if (fConfigureFormatter)
			return super.getContentFormatter(sourceViewer);
		else
			return null;
	}

	@Override
	public IInformationControlCreator getInformationControlCreator(ISourceViewer sourceViewer) {
		return null;
	}

	@Override
	public IInformationPresenter getInformationPresenter(ISourceViewer sourceViewer) {
		return null;
	}

	@Override
	public IInformationPresenter getOutlinePresenter(ISourceViewer sourceViewer, boolean doCodeResolve) {
		return null;
	}

	@Override
	public IInformationPresenter getHierarchyPresenter(ISourceViewer sourceViewer, boolean doCodeResolve) {
		return null;
	}

	@Override
	public IHyperlinkDetector[] getHyperlinkDetectors(ISourceViewer sourceViewer) {
		return null;
	}
}
