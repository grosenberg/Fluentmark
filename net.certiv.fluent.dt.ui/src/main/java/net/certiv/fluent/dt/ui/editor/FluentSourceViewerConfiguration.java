package net.certiv.fluent.dt.ui.editor;

import org.eclipse.jface.text.DefaultIndentLineAutoEditStrategy;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.formatter.IContentFormatter;
import org.eclipse.jface.text.formatter.MultiPassContentFormatter;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.ui.texteditor.ITextEditor;

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.core.color.IColorManager;
import net.certiv.dsl.core.preferences.DslPrefsManager;
import net.certiv.dsl.core.preferences.IDslPrefsManager;
import net.certiv.dsl.ui.DslUI;
import net.certiv.dsl.ui.editor.DslPresentationReconciler;
import net.certiv.dsl.ui.editor.DslSourceViewerConfiguration;
import net.certiv.dsl.ui.editor.reconcile.DslReconciler;
import net.certiv.dsl.ui.editor.text.completion.DslCompletionProcessor;
import net.certiv.dsl.ui.formatter.strategies.DslFormattingStrategy;
import net.certiv.fluent.dt.core.FluentCore;
import net.certiv.fluent.dt.ui.FluentUI;
import net.certiv.fluent.dt.ui.editor.completion.FmCompletionProcessor;
import net.certiv.fluent.dt.ui.editor.reconcilers.MdReconcilingStrategy;
import net.certiv.fluent.dt.ui.editor.strategies.FluentDoubleClickStrategy;
import net.certiv.fluent.dt.ui.editor.strategies.LineWrapEditStrategy;
import net.certiv.fluent.dt.ui.editor.strategies.SmartAutoEditStrategy;
import net.certiv.fluent.dt.ui.editor.text.ScannerCode;
import net.certiv.fluent.dt.ui.editor.text.ScannerComment;
import net.certiv.fluent.dt.ui.editor.text.ScannerDot;
import net.certiv.fluent.dt.ui.editor.text.ScannerFrontMatter;
import net.certiv.fluent.dt.ui.editor.text.ScannerHtml;
import net.certiv.fluent.dt.ui.editor.text.ScannerMarkup;
import net.certiv.fluent.dt.ui.editor.text.ScannerMath;
import net.certiv.fluent.dt.ui.editor.text.ScannerUml;
import net.certiv.fluent.dt.ui.formatter.MdFormatter;

public class FluentSourceViewerConfiguration extends DslSourceViewerConfiguration {

	private FluentDoubleClickStrategy doubleClickStrategy;

	private ScannerFrontMatter frontScanner;
	private ScannerCode codeScanner;
	private ScannerDot dotScanner;
	private ScannerUml umlScanner;
	private ScannerMath mathScanner;
	private ScannerHtml htmlScanner;
	private ScannerComment commentScanner;
	private ScannerMarkup markupScanner;

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

	@Override
	protected void initializeScanners() {
		IDslPrefsManager store = getPrefStore();

		frontScanner = new ScannerFrontMatter(store);
		codeScanner = new ScannerCode(store);
		dotScanner = new ScannerDot(store);
		umlScanner = new ScannerUml(store);
		mathScanner = new ScannerMath(store);
		htmlScanner = new ScannerHtml(store);
		commentScanner = new ScannerComment(store);
		markupScanner = new ScannerMarkup(store);
	}

	@Override
	public String[] getConfiguredContentTypes(ISourceViewer viewer) {
		return Partitions.getAllContentTypes();
	}

	@Override
	public ITextDoubleClickStrategy getDoubleClickStrategy(ISourceViewer viewer, String contentType) {
		if (doubleClickStrategy == null) {
			doubleClickStrategy = new FluentDoubleClickStrategy(getEditor());
		}
		return doubleClickStrategy;
	}

	@Override
	public IPresentationReconciler getPresentationReconciler(ISourceViewer viewer) {
		PresentationReconciler reconciler = new DslPresentationReconciler();
		reconciler.setDocumentPartitioning(getConfiguredDocumentPartitioning(viewer));

		buildRepairer(reconciler, frontScanner, Partitions.FRONT_MATTER);
		buildRepairer(reconciler, commentScanner, Partitions.COMMENT);
		buildRepairer(reconciler, codeScanner, Partitions.CODEBLOCK);
		buildRepairer(reconciler, dotScanner, Partitions.DOTBLOCK);
		buildRepairer(reconciler, umlScanner, Partitions.UMLBLOCK);
		buildRepairer(reconciler, mathScanner, Partitions.MATHBLOCK);
		buildRepairer(reconciler, htmlScanner, Partitions.HTMLBLOCK);
		buildRepairer(reconciler, markupScanner, IDocument.DEFAULT_CONTENT_TYPE);

		return reconciler;
	}

	@Override
	public void handlePropertyChangeEvent(PropertyChangeEvent event) {
		if (markupScanner.affectsBehavior(event)) markupScanner.adaptToPreferenceChange(event);
		if (codeScanner.affectsBehavior(event)) codeScanner.adaptToPreferenceChange(event);
		if (dotScanner.affectsBehavior(event)) dotScanner.adaptToPreferenceChange(event);
		if (umlScanner.affectsBehavior(event)) umlScanner.adaptToPreferenceChange(event);
		if (mathScanner.affectsBehavior(event)) mathScanner.adaptToPreferenceChange(event);
		if (htmlScanner.affectsBehavior(event)) htmlScanner.adaptToPreferenceChange(event);
		if (commentScanner.affectsBehavior(event)) commentScanner.adaptToPreferenceChange(event);
		if (frontScanner.affectsBehavior(event)) frontScanner.adaptToPreferenceChange(event);
	}

	@Override
	public boolean affectsTextPresentation(PropertyChangeEvent event) {
		return markupScanner.affectsBehavior(event) //
				|| codeScanner.affectsBehavior(event) //
				|| dotScanner.affectsBehavior(event) //
				|| umlScanner.affectsBehavior(event) //
				|| mathScanner.affectsBehavior(event) //
				|| htmlScanner.affectsBehavior(event) //
				|| commentScanner.affectsBehavior(event) //
				|| frontScanner.affectsBehavior(event);
	}

	@Override
	public DslReconciler getReconciler(ISourceViewer viewer) {
		DslReconciler reconciler = super.getReconciler(viewer);

		// // CompositeReconcilingStrategy multi = new CompositeReconcilingStrategy();
		// // multi.addReconcilingStrategy(new MdReconcilingStrategy(getEditor(),
		// viewer));
		// // multi.addReconcilingStrategy(getSpellingReconcileStrategy(viewer));
		// // reconciler.setReconcilingStrategy(multi, IDocument.DEFAULT_CONTENT_TYPE);
		// // reconciler.setReconcilingStrategy(new DotReconcilingStrategy(getEditor(),
		// // viewer),
		// // Partitions.DOTBLOCK);

		MdReconcilingStrategy mdStrategy = new MdReconcilingStrategy(getEditor(), viewer);
		reconciler.setReconcilingStrategy(mdStrategy, IDocument.DEFAULT_CONTENT_TYPE);

		return reconciler;
	}

	@Override
	public IAutoEditStrategy[] getAutoEditStrategies(ISourceViewer viewer, String contentType) {
		String partitioning = getConfiguredDocumentPartitioning(viewer);
		switch (contentType) {

			case IDocument.DEFAULT_CONTENT_TYPE:
				return new IAutoEditStrategy[] { new DefaultIndentLineAutoEditStrategy(),
						new LineWrapEditStrategy(getEditor()) };

			case Partitions.COMMENT:
			case Partitions.FRONT_MATTER:
			case Partitions.HTMLBLOCK:
			case Partitions.MATHBLOCK:
				return new IAutoEditStrategy[] { new DefaultIndentLineAutoEditStrategy() };

			case Partitions.CODEBLOCK:
			case Partitions.DOTBLOCK:
			case Partitions.UMLBLOCK:
			default:
				return new IAutoEditStrategy[] { new SmartAutoEditStrategy(partitioning) };
		}
	}

	@Override
	public IContentFormatter getContentFormatter(ISourceViewer viewer) {
		MultiPassContentFormatter formatter = (MultiPassContentFormatter) super.getContentFormatter(viewer);

		MdFormatter mdFormatter = new MdFormatter();
		formatter.setMasterStrategy(new DslFormattingStrategy(getPrefsMgr(), mdFormatter));

		// if (getPrefsMgr().getBoolean(Formatter.FORMATTER_NATIVE_ENABLE)) {
		// formatter.setSlaveStrategy(new ActionCodeFormattingStrategy(),
		// Partitions.ACTION);
		// }

		return formatter;
	}

	@Override
	protected void alterContentAssistant(ContentAssistant assistant) {
		DslCompletionProcessor processor = new FmCompletionProcessor(getEditor(), assistant,
				IDocument.DEFAULT_CONTENT_TYPE);
		assistant.setContentAssistProcessor(processor, IDocument.DEFAULT_CONTENT_TYPE);

		// DslCompletionProcessor dotProcessor = new DotCompletionProcessor(getEditor(),
		// assistant, Partitions.DOTBLOCK);
		// assistant.setContentAssistProcessor(dotProcessor, Partitions.DOTBLOCK);
	}

	@Override
	protected String getCommentPrefix() {
		return "<!--";
	}
}
