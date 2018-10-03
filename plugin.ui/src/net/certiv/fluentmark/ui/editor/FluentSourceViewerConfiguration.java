/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.ui.editor;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.formatter.IContentFormatter;
import org.eclipse.jface.text.formatter.MultiPassContentFormatter;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.reconciler.IReconciler;
import org.eclipse.jface.text.reconciler.Reconciler;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.ui.IWorkbenchPreferenceConstants;
import org.eclipse.ui.texteditor.ITextEditor;

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.core.color.IColorManager;
import net.certiv.dsl.core.preferences.DslPrefsManager;
import net.certiv.dsl.core.preferences.IDslPrefsManager;
import net.certiv.dsl.ui.DslUI;
import net.certiv.dsl.ui.editor.DslSourceViewerConfiguration;
import net.certiv.dsl.ui.editor.reconcile.CompositeReconcilingStrategy;
import net.certiv.dsl.ui.editor.text.completion.DslCompletionProcessor;
import net.certiv.dsl.ui.formatter.strategies.DslFormattingStrategy;
import net.certiv.fluentmark.core.FluentCore;
import net.certiv.fluentmark.core.preferences.Prefs;
import net.certiv.fluentmark.ui.FluentUI;
import net.certiv.fluentmark.ui.editor.completion.DotCompletionProcessor;
import net.certiv.fluentmark.ui.editor.completion.FluentTemplateCompletionProcessor;
import net.certiv.fluentmark.ui.editor.strategies.DotReconcilingStrategy;
import net.certiv.fluentmark.ui.editor.strategies.DoubleClickStrategy;
import net.certiv.fluentmark.ui.editor.strategies.LineWrapEditStrategy;
import net.certiv.fluentmark.ui.editor.strategies.MdReconcilingStrategy;
import net.certiv.fluentmark.ui.editor.text.ScannerCode;
import net.certiv.fluentmark.ui.editor.text.ScannerComment;
import net.certiv.fluentmark.ui.editor.text.ScannerDot;
import net.certiv.fluentmark.ui.editor.text.ScannerFrontMatter;
import net.certiv.fluentmark.ui.editor.text.ScannerHtml;
import net.certiv.fluentmark.ui.editor.text.ScannerMarkup;
import net.certiv.fluentmark.ui.editor.text.ScannerMath;
import net.certiv.fluentmark.ui.editor.text.ScannerUml;
import net.certiv.fluentmark.ui.format.MdFormatter;

public class FluentSourceViewerConfiguration extends DslSourceViewerConfiguration {

	private ScannerFrontMatter frontMatter;
	private ScannerCode codeScanner;
	private ScannerDot dotScanner;
	private ScannerUml umlScanner;
	private ScannerMath mathScanner;
	private ScannerHtml htmlScanner;
	private ScannerComment commentScanner;
	private ScannerMarkup markup;
	private FluentTemplateCompletionProcessor templatesProcessor;
	private DotCompletionProcessor dotProcessor;

	public FluentSourceViewerConfiguration(IColorManager colorManager, IDslPrefsManager store, ITextEditor editor,
			String partitioning) {
		super(colorManager, store, editor, partitioning);
	}

	@Override
	public DslUI getDslUI() {
		return FluentUI.getDefault();
	}

	@Override
	public DslCore getDslCore() {
		return FluentCore.getDefault();
	}

	private DslPrefsManager getPrefsMgr() {
		return getDslCore().getPrefsManager();
	}

	/** Initializes the scanners. */
	@Override
	protected void initializeScanners() {
		IDslPrefsManager store = getPrefStore();
		codeScanner = new ScannerCode(store);
		commentScanner = new ScannerComment(store);
		dotScanner = new ScannerDot(store);
		umlScanner = new ScannerUml(store);
		mathScanner = new ScannerMath(store);
		htmlScanner = new ScannerHtml(store);
		frontMatter = new ScannerFrontMatter(store);
		markup = new ScannerMarkup(store);
	}

	@Override
	public String[] getConfiguredContentTypes(ISourceViewer sourceViewer) {
		return Partitions.getAllContentTypes();
	}

	@Override
	public ITextDoubleClickStrategy getDoubleClickStrategy(ISourceViewer sourceViewer, String contentType) {
		return new DoubleClickStrategy(getEditor());
	}

	@Override
	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
		PresentationReconciler reconciler = new FluentPresentationReconciler();
		reconciler.setDocumentPartitioning(getConfiguredDocumentPartitioning(sourceViewer));

		buildRepairer(reconciler, frontMatter, Partitions.FRONT_MATTER);
		buildRepairer(reconciler, commentScanner, Partitions.COMMENT);
		buildRepairer(reconciler, codeScanner, Partitions.CODEBLOCK);
		buildRepairer(reconciler, dotScanner, Partitions.DOTBLOCK);
		buildRepairer(reconciler, umlScanner, Partitions.UMLBLOCK);
		buildRepairer(reconciler, mathScanner, Partitions.MATHBLOCK);
		buildRepairer(reconciler, htmlScanner, Partitions.HTMLBLOCK);
		buildRepairer(reconciler, markup, IDocument.DEFAULT_CONTENT_TYPE);

		return reconciler;
	}

	@Override
	public void handlePropertyChangeEvent(PropertyChangeEvent event) {
		if (markup.affectsBehavior(event)) markup.adaptToPreferenceChange(event);
		if (codeScanner.affectsBehavior(event)) codeScanner.adaptToPreferenceChange(event);
		if (dotScanner.affectsBehavior(event)) dotScanner.adaptToPreferenceChange(event);
		if (umlScanner.affectsBehavior(event)) umlScanner.adaptToPreferenceChange(event);
		if (mathScanner.affectsBehavior(event)) mathScanner.adaptToPreferenceChange(event);
		if (htmlScanner.affectsBehavior(event)) htmlScanner.adaptToPreferenceChange(event);
		if (commentScanner.affectsBehavior(event)) commentScanner.adaptToPreferenceChange(event);
		if (frontMatter.affectsBehavior(event)) frontMatter.adaptToPreferenceChange(event);
	}

	@Override
	public boolean affectsTextPresentation(PropertyChangeEvent event) {
		return markup.affectsBehavior(event) //
				|| codeScanner.affectsBehavior(event) //
				|| dotScanner.affectsBehavior(event) //
				|| umlScanner.affectsBehavior(event) //
				|| mathScanner.affectsBehavior(event) //
				|| htmlScanner.affectsBehavior(event) //
				|| commentScanner.affectsBehavior(event) //
				|| frontMatter.affectsBehavior(event);
	}

	@Override
	public IReconciler getReconciler(ISourceViewer viewer) {
		Reconciler reconciler = (Reconciler) super.getReconciler(viewer);

		CompositeReconcilingStrategy multi = new CompositeReconcilingStrategy();
		multi.addReconcilingStrategy(new MdReconcilingStrategy(getEditor(), viewer));
		multi.addReconcilingStrategy(getSpellingReconcileStrategy(viewer));
		reconciler.setReconcilingStrategy(multi, IDocument.DEFAULT_CONTENT_TYPE);

		reconciler.setReconcilingStrategy(new DotReconcilingStrategy(getEditor(), viewer), Partitions.DOTBLOCK);

		return reconciler;
	}

	@Override
	public IAutoEditStrategy[] getAutoEditStrategies(ISourceViewer viewer, String contentType) {
		String partitioning = getConfiguredDocumentPartitioning(viewer);
		switch (contentType) {
			case Partitions.CODEBLOCK:
			case Partitions.COMMENT:
			case Partitions.DOTBLOCK:
			case Partitions.FRONT_MATTER:
			case Partitions.HTMLBLOCK:
			case Partitions.MATHBLOCK:
			case Partitions.UMLBLOCK:
				return new IAutoEditStrategy[] { new SmartAutoEditStrategy(partitioning) };

			default:
				return new IAutoEditStrategy[] { new SmartAutoEditStrategy(partitioning),
						new LineWrapEditStrategy(getEditor()) };
		}
	}

	@Override
	public IContentFormatter getContentFormatter(ISourceViewer sourceViewer) {
		MultiPassContentFormatter formatter = (MultiPassContentFormatter) super.getContentFormatter(sourceViewer);
		formatter.setMasterStrategy(new DslFormattingStrategy(getPrefsMgr(), new MdFormatter()));
		return formatter;
	}

	@Override
	protected void alterContentAssistant(ContentAssistant assistant) {
		DslCompletionProcessor templatesProcessor = new FluentTemplateCompletionProcessor(getEditor(), assistant,
				IDocument.DEFAULT_CONTENT_TYPE);
		assistant.setContentAssistProcessor(templatesProcessor, IDocument.DEFAULT_CONTENT_TYPE);

		DslCompletionProcessor dotProcessor = new DotCompletionProcessor(getEditor(), assistant, Partitions.DOTBLOCK);
		assistant.setContentAssistProcessor(dotProcessor, Partitions.DOTBLOCK);
	}

	@Override
	protected String getCommentPrefix() {
		return "<!--";
	}

	private void configure(ContentAssistant assistant, IPreferenceStore store) {
		assistant.setDocumentPartitioning(Partitions.PARTITIONING);
		assistant.setContextInformationPopupOrientation(IContentAssistant.CONTEXT_INFO_BELOW);
		assistant.setProposalPopupOrientation(IContentAssistant.PROPOSAL_REMOVE);
		assistant.setAutoActivationDelay(0);
		assistant.enableColoredLabels(true);
		assistant.enableAutoActivation(true);
		assistant.setShowEmptyList(true);

		boolean enabled = store.getBoolean(Prefs.CODEASSIST_AUTOACTIVATION);
		assistant.enableAutoActivation(enabled);

		int delay = store.getInt(Prefs.CODEASSIST_AUTOACTIVATION_DELAY);
		assistant.setAutoActivationDelay(delay);

		Color c = getColor(store, Prefs.CODEASSIST_PARAMETERS_FOREGROUND, getColorManager());
		assistant.setContextInformationPopupForeground(c);
		assistant.setContextSelectorForeground(c);

		c = getColor(store, Prefs.CODEASSIST_PARAMETERS_BACKGROUND, getColorManager());
		assistant.setContextInformationPopupBackground(c);
		assistant.setContextSelectorBackground(c);

		enabled = store.getBoolean(Prefs.CODEASSIST_AUTOINSERT);
		assistant.enableAutoInsert(enabled);

		enabled = store.getBoolean(Prefs.CODEASSIST_PREFIX_COMPLETION);
		assistant.enablePrefixCompletion(enabled);

		enabled = store.getBoolean(IWorkbenchPreferenceConstants.USE_COLORED_LABELS);
		assistant.enableColoredLabels(enabled);

		configureTemplateProcessor(assistant, store);
	}

	private void configureTemplateProcessor(ContentAssistant assistant, IPreferenceStore store) {
		IContentAssistProcessor p = assistant.getContentAssistProcessor(IDocument.DEFAULT_CONTENT_TYPE);
		if (p == null || !(p instanceof FluentTemplateCompletionProcessor)) return;

		FluentTemplateCompletionProcessor processor = (FluentTemplateCompletionProcessor) p;

		String triggers = store.getString(Prefs.CODEASSIST_AUTOACTIVATION_TRIGGERS_MD);
		if (triggers != null) processor.setCompletionProposalAutoActivationCharacters(triggers.toCharArray());

		processor.restrictProposalsToVisibility(store.getBoolean(Prefs.CODEASSIST_SHOW_VISIBLE_PROPOSALS));
		processor.restrictProposalsToMatchingCases(store.getBoolean(Prefs.CODEASSIST_CASE_SENSITIVITY));
	}

	private Color getColor(IPreferenceStore store, String key, IColorManager manager) {
		RGB rgb = PreferenceConverter.getColor(store, key);
		return manager.getColor(rgb);
	}
}
