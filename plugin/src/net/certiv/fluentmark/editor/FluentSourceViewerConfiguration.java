/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.editor;

import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.text.DefaultInformationControl;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IInformationControl;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.information.IInformationPresenter;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.reconciler.IReconciler;
import org.eclipse.jface.text.reconciler.MonoReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPreferenceConstants;
import org.eclipse.ui.editors.text.TextSourceViewerConfiguration;
import org.eclipse.ui.part.IShowInTarget;
import org.eclipse.ui.texteditor.HippieProposalProcessor;
import org.eclipse.ui.texteditor.ITextEditor;

import net.certiv.fluentmark.FluentUI;
import net.certiv.fluentmark.ProgressMonitorAndCanceler;
import net.certiv.fluentmark.assist.FluentTemplateCompletionProcessor;
import net.certiv.fluentmark.assist.MultiContentAssistProcessor;
import net.certiv.fluentmark.editor.color.IColorManager;
import net.certiv.fluentmark.editor.strategies.DoubleClickStrategy;
import net.certiv.fluentmark.editor.strategies.LineWrapEditStrategy;
import net.certiv.fluentmark.editor.strategies.PairEditStrategy;
import net.certiv.fluentmark.editor.strategies.SmartAutoEditStrategy;
import net.certiv.fluentmark.editor.text.AbstractBufferedRuleBasedScanner;
import net.certiv.fluentmark.editor.text.MkReconcilingStrategy;
import net.certiv.fluentmark.editor.text.ScannerCode;
import net.certiv.fluentmark.editor.text.ScannerComment;
import net.certiv.fluentmark.editor.text.ScannerDot;
import net.certiv.fluentmark.editor.text.ScannerFrontMatter;
import net.certiv.fluentmark.editor.text.ScannerHtml;
import net.certiv.fluentmark.editor.text.ScannerMarkup;
import net.certiv.fluentmark.editor.text.ScannerMath;
import net.certiv.fluentmark.editor.text.ScannerUml;
import net.certiv.fluentmark.preferences.Prefs;

public class FluentSourceViewerConfiguration extends TextSourceViewerConfiguration {

	private static final String AUTOACTIVATION = Prefs.CODEASSIST_AUTOACTIVATION;
	private static final String AUTOACTIVATION_DELAY = Prefs.CODEASSIST_AUTOACTIVATION_DELAY;
	private static final String PARAMETERS_FOREGROUND = Prefs.CODEASSIST_PARAMETERS_FOREGROUND;
	private static final String PARAMETERS_BACKGROUND = Prefs.CODEASSIST_PARAMETERS_BACKGROUND;
	private static final String AUTOINSERT = Prefs.CODEASSIST_AUTOINSERT;
	private static final String AUTOACTIVATION_TRIGGERS_MD = Prefs.CODEASSIST_AUTOACTIVATION_TRIGGERS_MD;
	// private static final String AUTOACTIVATION_TRIGGERS_DOT =
	// Prefs.CODEASSIST_AUTOACTIVATION_TRIGGERS_DOT;

	private static final String SHOW_VISIBLE_PROPOSALS = Prefs.CODEASSIST_SHOW_VISIBLE_PROPOSALS;
	private static final String CASE_SENSITIVITY = Prefs.CODEASSIST_CASE_SENSITIVITY;
	// private static final String FILL_METHOD_ARGUMENTS = Prefs.CODEASSIST_FILL_ARGUMENT_NAMES;
	private static final String PREFIX_COMPLETION = Prefs.CODEASSIST_PREFIX_COMPLETION;
	private static final String USE_COLORED_LABELS = IWorkbenchPreferenceConstants.USE_COLORED_LABELS;

	private IColorManager colorManager;
	private ITextEditor editor;
	private ITextHover textHover;
	private IShowInTarget showInTarget;

	private IContentAssistProcessor templatesProcessor;
	private boolean enableHippie = true;
	private HippieProposalProcessor hippieProcessor;
	private ScannerMarkup markup;
	private ScannerFrontMatter frontMatter;
	private ScannerCode codeScanner;
	private ScannerDot dotScanner;
	private ScannerUml umlScanner;
	private ScannerMath mathScanner;
	private ScannerHtml htmlScanner;
	private ScannerComment commentScanner;
	private String partitioning;

	private boolean debugModel;

	// private OutlineItem outline;
	// private IInformationPresenter informationPresenter;

	public FluentSourceViewerConfiguration(IColorManager colorManager, IPreferenceStore store, ITextEditor editor,
			String partitioning) {
		super(store);
		this.colorManager = colorManager;
		this.editor = editor;
		this.partitioning = partitioning;
		initializeScanners();
	}

	/**
	 * Initializes the scanners.
	 */
	private void initializeScanners() {
		codeScanner = new ScannerCode();
		commentScanner = new ScannerComment();
		dotScanner = new ScannerDot();
		umlScanner = new ScannerUml();
		mathScanner = new ScannerMath();
		htmlScanner = new ScannerHtml();
		frontMatter = new ScannerFrontMatter();
		markup = new ScannerMarkup();
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

	protected void buildRepairer(PresentationReconciler reconciler, AbstractBufferedRuleBasedScanner scanner,
			String token) {
		DefaultDamagerRepairer dr = new DefaultDamagerRepairer(scanner);
		reconciler.setDamager(dr, token);
		reconciler.setRepairer(dr, token);
	}

	/**
	 * Adapts the behavior of the contained components to the change encoded in the given event.
	 */
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

	/**
	 * Determines whether the preference change encoded by the given event changes the behavior of one
	 * of its contained components.
	 *
	 * @param event the event to be investigated
	 * @return <code>true</code> if event causes a behavioral change
	 */
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
		if (editor != null && editor.isEditable()) {
			MkReconcilingStrategy strategy = new MkReconcilingStrategy(viewer, editor,
					getConfiguredDocumentPartitioning(viewer));
			MonoReconciler reconciler = new MonoReconciler(strategy, false);
			reconciler.setProgressMonitor(new ProgressMonitorAndCanceler());
			reconciler.setDelay(500);
			return reconciler;
		}
		return null;
	}

	@Override
	public IAutoEditStrategy[] getAutoEditStrategies(ISourceViewer sourceViewer, String contentType) {
		return new IAutoEditStrategy[] { new SmartAutoEditStrategy(partitioning), new LineWrapEditStrategy(editor),
				new PairEditStrategy() };
	}

	@Override
	public ITextDoubleClickStrategy getDoubleClickStrategy(ISourceViewer sourceViewer, String contentType) {
		return new DoubleClickStrategy(editor);
	}

	@Override
	public ITextHover getTextHover(ISourceViewer sourceViewer, String contentType) {
		if (textHover == null) {
			if (debugModel) {
				textHover = new FluentTextHover(editor, sourceViewer, contentType);
			} else {
				textHover = super.getTextHover(sourceViewer, contentType);
			}
		}
		return textHover;
	}

	@Override
	public IContentAssistant getContentAssistant(ISourceViewer sourceViewer) {
		if (templatesProcessor == null) {
			templatesProcessor = new FluentTemplateCompletionProcessor(editor, IDocument.DEFAULT_CONTENT_TYPE);
		}
		if (enableHippie && hippieProcessor == null) {
			hippieProcessor = new HippieProposalProcessor();
		}

		MultiContentAssistProcessor processor = new MultiContentAssistProcessor();
		processor.addDelegate(templatesProcessor);
		if (enableHippie) processor.addDelegate(hippieProcessor);

		ContentAssistant assistant = new ContentAssistant();
		assistant.setDocumentPartitioning(getConfiguredDocumentPartitioning(sourceViewer));
		assistant.setRestoreCompletionProposalSize(getSettings("completion_proposal_size")); //$NON-NLS-1$
		assistant.setContentAssistProcessor(processor, IDocument.DEFAULT_CONTENT_TYPE);
		// assistant.setContentAssistProcessor(new FluentCodeCompletionProcessor(),
		// Partitions.CODEBLOCK);

		configure(assistant, fPreferenceStore);

		assistant.setContextInformationPopupOrientation(IContentAssistant.CONTEXT_INFO_ABOVE);
		assistant.setInformationControlCreator(new IInformationControlCreator() {

			@Override
			public IInformationControl createInformationControl(Shell parent) {
				return new DefaultInformationControl(parent, FluentUI.getAdditionalInfoAffordanceString());
			}
		});

		return assistant;
	}

	/**
	 * provide a {@link IShowInTarget show in target} to connect the quick-outline popup with the
	 * editor.
	 */
	public IShowInTarget getShowInTarget() {
		return showInTarget;
	}

	/**
	 * provide a {@link IShowInTarget show in target} to connect the quick-outline popup with the
	 * editor.
	 */
	public void setShowInTarget(IShowInTarget showInTarget) {
		this.showInTarget = showInTarget;
	}

	/**
	 * Indicate if Hippie content assist should be enabled. The default is true.
	 *
	 * @since 1.4
	 * @see HippieProposalProcessor
	 */
	public boolean isEnableHippieContentAssist() {
		return enableHippie;
	}

	/**
	 * Indicate if Hippie content assist should be enabled.
	 *
	 * @since 1.4
	 */
	public void setEnableHippieContentAssist(boolean enableHippieContentAssist) {
		this.enableHippie = enableHippieContentAssist;
	}

	/**
	 * Configure the given content assistant from the given store.
	 *
	 * @param assistant the content assistant
	 * @param store the preference store
	 */
	private void configure(ContentAssistant assistant, IPreferenceStore store) {

		boolean enabled = store.getBoolean(AUTOACTIVATION);
		assistant.enableAutoActivation(enabled);

		int delay = store.getInt(AUTOACTIVATION_DELAY);
		assistant.setAutoActivationDelay(delay);

		Color c = getColor(store, PARAMETERS_FOREGROUND, colorManager);
		assistant.setContextInformationPopupForeground(c);
		assistant.setContextSelectorForeground(c);

		c = getColor(store, PARAMETERS_BACKGROUND, colorManager);
		assistant.setContextInformationPopupBackground(c);
		assistant.setContextSelectorBackground(c);

		enabled = store.getBoolean(AUTOINSERT);
		assistant.enableAutoInsert(enabled);

		enabled = store.getBoolean(PREFIX_COMPLETION);
		assistant.enablePrefixCompletion(enabled);

		enabled = store.getBoolean(USE_COLORED_LABELS);
		assistant.enableColoredLabels(enabled);

		configureTemplateProcessor(assistant, store);
	}

	private void configureTemplateProcessor(ContentAssistant assistant, IPreferenceStore store) {
		FluentTemplateCompletionProcessor processor = getTemplateProcessor(assistant);
		if (processor == null) return;

		String triggers = store.getString(AUTOACTIVATION_TRIGGERS_MD);
		if (triggers != null) processor.setCompletionProposalAutoActivationCharacters(triggers.toCharArray());

		boolean enabled = store.getBoolean(SHOW_VISIBLE_PROPOSALS);
		processor.restrictProposalsToVisibility(enabled);

		enabled = store.getBoolean(CASE_SENSITIVITY);
		processor.restrictProposalsToMatchingCases(enabled);
	}

	private FluentTemplateCompletionProcessor getTemplateProcessor(ContentAssistant assistant) {
		IContentAssistProcessor p = assistant.getContentAssistProcessor(IDocument.DEFAULT_CONTENT_TYPE);
		if (p instanceof FluentTemplateCompletionProcessor) return (FluentTemplateCompletionProcessor) p;
		return null;
	}

	private Color getColor(IPreferenceStore store, String key, IColorManager manager) {
		RGB rgb = PreferenceConverter.getColor(store, key);
		return manager.getColor(rgb);
	}

	/**
	 * Returns the settings for the given section.
	 *
	 * @param sectionName the section name
	 * @return the settings
	 */
	private IDialogSettings getSettings(String sectionName) {
		IDialogSettings settings = FluentUI.getDefault().getDialogSettings().getSection(sectionName);
		if (settings == null) settings = FluentUI.getDefault().getDialogSettings().addNewSection(sectionName);
		return settings;
	}

	public IInformationPresenter getOutlinePresenter(ISourceViewer sourceViewer, boolean doCodeResolve) {
		return null;
	}

	public IInformationPresenter getHierarchyPresenter(ISourceViewer sourceViewer, boolean doCodeResolve) {
		return null;
	}

	@Override
	public String getConfiguredDocumentPartitioning(ISourceViewer sourceViewer) {
		if (partitioning != null) return partitioning;
		return super.getConfiguredDocumentPartitioning(sourceViewer);
	}

	// /**
	// * Set the outline on this configuration. Outlines are used for document-internal references
	// as
	// * well as for quick outline. Editors that call this method must keep the outline up to date
	// as
	// * the source document changes. Editors that do not maintain an outline need not call this
	// * method, since the outline will be computed as needed for the quick outline.
	// *
	// * @param outlineModel
	// */
	// public void setOutline(OutlineItem outlineModel) {
	// this.outline = outlineModel;
	// if (anchorCompletionProcessor != null) {
	// anchorCompletionProcessor.setOutline(outline);
	// }
	// }

	// /**
	// * Provide access to an information presenter that can be used to pop-up a quick outline.
	// */
	// public IInformationPresenter getOutlineInformationPresenter(ISourceViewer sourceViewer) {
	// if (informationPresenter == null) {
	// IInformationControlCreator controlCreator = getOutlineInformationControlCreator();
	// informationPresenter = new InformationPresenter(controlCreator);
	// informationPresenter.setDocumentPartitioning(getConfiguredDocumentPartitioning(sourceViewer));
	//
	// // Register information provider
	// IInformationProvider provider = new InformationProvider(controlCreator);
	// String[] contentTypes = getConfiguredContentTypes(sourceViewer);
	// for (String contentType : contentTypes) {
	// informationPresenter.setInformationProvider(provider, contentType);
	// }
	//
	// informationPresenter.setSizeConstraints(60, 20, true, true);
	// }
	// return informationPresenter;
	// }

	// private class InformationProvider
	// implements IInformationProvider, IInformationProviderExtension,
	// IInformationProviderExtension2 {
	//
	// private final IInformationControlCreator controlCreator;
	//
	// public InformationProvider(IInformationControlCreator controlCreator) {
	// this.controlCreator = controlCreator;
	// }
	//
	// @Deprecated
	// public String getInformation(ITextViewer textViewer, IRegion subject) {
	// return getInformation2(textViewer, subject).toString();
	// }
	//
	// public Object getInformation2(ITextViewer textViewer, IRegion subject) {
	// if (outline == null) {
	// // If the outline was not set then parse it. This can happen in a task editor
	// if (markupLanguage != null) {
	// IDocument document = textViewer.getDocument();
	// if (document != null && document.getLength() > 0) {
	// MarkupLanguage language = markupLanguage.clone();
	// OutlineParser outlineParser = new OutlineParser();
	// outlineParser.setMarkupLanguage(language.clone());
	// String markup = document.get();
	// final OutlineItem outline = outlineParser.parse(markup);
	// if (MarkupSourceViewerConfiguration.this.file != null) {
	// outline.setResourcePath(MarkupSourceViewerConfiguration.this.file.getFullPath().toString());
	// }
	// return outline;
	// }
	// }
	// }
	// return outline;
	// }
	//
	// public IRegion getSubject(ITextViewer textViewer, int offset) {
	// return new Region(offset, 0);
	// }
	//
	// public IInformationControlCreator getInformationPresenterControlCreator() {
	// return controlCreator;
	// }
	// }
}
