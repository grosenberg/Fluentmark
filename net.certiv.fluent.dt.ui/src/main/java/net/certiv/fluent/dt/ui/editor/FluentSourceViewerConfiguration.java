package net.certiv.fluent.dt.ui.editor;

import static net.certiv.dsl.ui.editor.text.completion.engines.IPrefixStops.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.jface.text.DefaultIndentLineAutoEditStrategy;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.formatter.IContentFormatter;
import org.eclipse.jface.text.formatter.MultiPassContentFormatter;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.graphics.Image;

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.core.color.DslColorRegistry;
import net.certiv.dsl.core.preferences.IPrefsManager;
import net.certiv.dsl.core.preferences.PrefsManager;
import net.certiv.dsl.ui.DslImageManager;
import net.certiv.dsl.ui.DslUI;
import net.certiv.dsl.ui.editor.DslEditor;
import net.certiv.dsl.ui.editor.DslSourceViewerConfiguration;
import net.certiv.dsl.ui.editor.reconcile.PresentationReconciler;
import net.certiv.dsl.ui.editor.semantic.StylesManager;
import net.certiv.dsl.ui.editor.text.completion.CompletionCategory;
import net.certiv.dsl.ui.editor.text.completion.CompletionProcessor;
import net.certiv.dsl.ui.editor.text.completion.engines.ICompletionEngine;
import net.certiv.dsl.ui.editor.text.completion.engines.KeywordEngine;
import net.certiv.dsl.ui.editor.text.completion.engines.TemplateEngine;
import net.certiv.dsl.ui.formatter.strategies.DslFormattingStrategy;
import net.certiv.fluent.dt.core.FluentCore;
import net.certiv.fluent.dt.ui.FluentUI;
import net.certiv.fluent.dt.ui.editor.outline.FluentOutlineLabelProvider;
import net.certiv.fluent.dt.ui.editor.semantic.MdSematicAnalyzer;
import net.certiv.fluent.dt.ui.editor.strategies.FluentDoubleClickStrategy;
import net.certiv.fluent.dt.ui.editor.strategies.LineWrapEditStrategy;
import net.certiv.fluent.dt.ui.editor.strategies.SmartAutoEditStrategy;
import net.certiv.fluent.dt.ui.editor.text.ScannerCode;
import net.certiv.fluent.dt.ui.editor.text.ScannerComment;
import net.certiv.fluent.dt.ui.editor.text.ScannerDot;
import net.certiv.fluent.dt.ui.editor.text.ScannerFrontMatter;
import net.certiv.fluent.dt.ui.editor.text.ScannerHtml;
import net.certiv.fluent.dt.ui.editor.text.ScannerMath;
import net.certiv.fluent.dt.ui.editor.text.ScannerUml;
import net.certiv.fluent.dt.ui.formatter.MdFormatter;

public class FluentSourceViewerConfiguration extends DslSourceViewerConfiguration {

	private FluentDoubleClickStrategy doubleClickStrategy;

	private ScannerFrontMatter yamlScanner;
	private ScannerCode codeScanner;
	private ScannerDot dotScanner;
	private ScannerUml umlScanner;
	private ScannerMath mathScanner;
	private ScannerHtml htmlScanner;
	private ScannerComment commentScanner;
	// private ScannerMarkup markupScanner;

	private MdSematicAnalyzer markupAnalyzer;

	public FluentSourceViewerConfiguration(DslColorRegistry reg, IPrefsManager store, DslEditor editor,
			String partitioning) {
		super(FluentCore.getDefault(), reg, store, editor, partitioning);
	}

	@Override
	public DslUI getDslUI() {
		return FluentUI.getDefault();
	}

	@Override
	public DslCore getDslCore() {
		return FluentCore.getDefault();
	}

	private PrefsManager getPrefsMgr() {
		return getDslCore().getPrefsManager();
	}

	@Override
	protected void initializeScanners() {
		IPrefsManager store = getPrefStore();
		StylesManager mgr = getDslUI().getStylesManager();

		yamlScanner = new ScannerFrontMatter(store, mgr);
		codeScanner = new ScannerCode(store, mgr);
		dotScanner = new ScannerDot(store, mgr);
		umlScanner = new ScannerUml(store, mgr);
		mathScanner = new ScannerMath(store, mgr);
		htmlScanner = new ScannerHtml(store, mgr);
		commentScanner = new ScannerComment(store, mgr);
		markupAnalyzer = new MdSematicAnalyzer(getDslUI());
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
	public void specializeContentAssistant(ContentAssistant assistant) {
		FluentOutlineLabelProvider provider = new FluentOutlineLabelProvider();
		DslUI ui = getDslUI();
		DslImageManager mgr = ui.getImageManager();
		Image img = mgr.get(mgr.IMG_OBJS_KEYWORD);
		Set<Character> stops = new HashSet<>(Arrays.asList(LBRACE, LBRACE, LPAREN, COLON, COMMA, SEMI, PIPE, AT));

		ICompletionEngine dotWords = new KeywordEngine(img, stops, ScannerDot.keywords, ScannerDot.attribs);
		ICompletionEngine umlWords = new KeywordEngine(img, stops, ScannerUml.keywords, ScannerUml.preprocs,
				ScannerUml.types);
		ICompletionEngine tagWords = new KeywordEngine(img, stops, ScannerHtml.keywords);
		ICompletionEngine templates = new TemplateEngine(provider, stops);

		CompletionCategory dot = new CompletionCategory("Dot", false, true, dotWords);
		CompletionCategory uml = new CompletionCategory("Uml", false, true, umlWords);
		CompletionCategory tag = new CompletionCategory("Html", false, true, tagWords);
		CompletionCategory tmp = new CompletionCategory("Templates", true, true, templates);

		CompletionProcessor dotProc = new CompletionProcessor(ui, assistant, dot, tmp);
		assistant.setContentAssistProcessor(dotProc, Partitions.DOTBLOCK);

		CompletionProcessor umlProc = new CompletionProcessor(ui, assistant, uml, tmp);
		assistant.setContentAssistProcessor(umlProc, Partitions.UMLBLOCK);

		CompletionProcessor tagProc = new CompletionProcessor(ui, assistant, tag, tmp);
		assistant.setContentAssistProcessor(tagProc, Partitions.HTMLBLOCK);

		CompletionProcessor proc = new CompletionProcessor(ui, assistant, tmp);
		assistant.setContentAssistProcessor(proc, IDocument.DEFAULT_CONTENT_TYPE);
	}

	@Override
	public IPresentationReconciler getPresentationReconciler(ISourceViewer viewer) {
		PresentationReconciler reconciler = new PresentationReconciler(getDslUI());
		reconciler.setDocumentPartitioning(getConfiguredDocumentPartitioning(viewer));

		buildRepairer(reconciler, yamlScanner, Partitions.YAMLBLOCK);
		buildRepairer(reconciler, commentScanner, Partitions.COMMENT);
		buildRepairer(reconciler, codeScanner, Partitions.CODEBLOCK);
		buildRepairer(reconciler, dotScanner, Partitions.DOTBLOCK);
		buildRepairer(reconciler, umlScanner, Partitions.UMLBLOCK);
		buildRepairer(reconciler, mathScanner, Partitions.MATHBLOCK);
		buildRepairer(reconciler, htmlScanner, Partitions.HTMLBLOCK);

		buildRepairer(getEditor(), viewer, reconciler, markupAnalyzer, IDocument.DEFAULT_CONTENT_TYPE);

		return reconciler;
	}

	@Override
	public void handlePropertyChangeEvent(PropertyChangeEvent event) {
		// if (markupScanner.affectsBehavior(event))
		// markupScanner.adaptToPreferenceChange(event);
		if (codeScanner.affectsBehavior(event)) codeScanner.adaptToPreferenceChange(event);
		if (dotScanner.affectsBehavior(event)) dotScanner.adaptToPreferenceChange(event);
		if (umlScanner.affectsBehavior(event)) umlScanner.adaptToPreferenceChange(event);
		if (mathScanner.affectsBehavior(event)) mathScanner.adaptToPreferenceChange(event);
		if (htmlScanner.affectsBehavior(event)) htmlScanner.adaptToPreferenceChange(event);
		if (commentScanner.affectsBehavior(event)) commentScanner.adaptToPreferenceChange(event);
		if (yamlScanner.affectsBehavior(event)) yamlScanner.adaptToPreferenceChange(event);
	}

	@Override
	public boolean affectsTextPresentation(PropertyChangeEvent event) {
		return codeScanner.affectsBehavior(event) //
				|| dotScanner.affectsBehavior(event) //
				|| umlScanner.affectsBehavior(event) //
				|| mathScanner.affectsBehavior(event) //
				|| htmlScanner.affectsBehavior(event) //
				|| commentScanner.affectsBehavior(event) //
				|| yamlScanner.affectsBehavior(event);
		// markupScanner.affectsBehavior(event) //
	}

	@Override
	public IAutoEditStrategy[] getAutoEditStrategies(ISourceViewer viewer, String contentType) {
		String partitioning = getConfiguredDocumentPartitioning(viewer);
		switch (contentType) {

			case IDocument.DEFAULT_CONTENT_TYPE:
				return new IAutoEditStrategy[] { new DefaultIndentLineAutoEditStrategy(),
						new LineWrapEditStrategy(getEditor()) };

			case Partitions.COMMENT:
			case Partitions.YAMLBLOCK:
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
	protected String getCommentPrefix() {
		return "<!--";
	}
}
