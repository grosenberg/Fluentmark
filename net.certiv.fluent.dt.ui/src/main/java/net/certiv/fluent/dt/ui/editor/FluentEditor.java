package net.certiv.fluent.dt.ui.editor;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.source.DefaultCharacterPairMatcher;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.texteditor.SourceViewerDecorationSupport;

import net.certiv.common.util.Strings;
import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.core.preferences.consts.Editor;
import net.certiv.dsl.ui.DslUI;
import net.certiv.dsl.ui.editor.DslEditor;
import net.certiv.dsl.ui.editor.text.DslWordFinder;
import net.certiv.dsl.ui.editor.text.folding.IFoldingStructureProvider;
import net.certiv.fluent.dt.core.FluentCore;
import net.certiv.fluent.dt.ui.FluentUI;
import net.certiv.fluent.dt.ui.editor.convert.Converter;
import net.certiv.fluent.dt.ui.editor.convert.HtmlGen;
import net.certiv.fluent.dt.ui.editor.convert.Kind;
import net.certiv.fluent.dt.ui.editor.folding.FmFoldingStructureProvider;
import net.certiv.fluent.dt.ui.editor.outline.FluentOutlinePage;

public class FluentEditor extends DslEditor {

	public static final String EDITOR_ID = "net.certiv.fluent.dt.ui.editor.FluentEditor";
	public static final String EDITOR_CONTEXT = "#FluentEditorContext";
	public static final String RULER_CONTEXT = "#FluentRulerContext";

	private static final String[] EDITOR_KEY_SCOPE = new String[] { "net.certiv.fluent.dt.ui.fluentEditorScope" };
	private static final String MARK_OCCURRENCES_ANNOTATION_TYPE = "net.certiv.fluent.dt.ui.occurrences";

	private final DslWordFinder finder = new DslWordFinder();
	private final DefaultCharacterPairMatcher pairMatcher = new DefaultCharacterPairMatcher(STD_PAIRS,
			Partitions.PARTITIONING);

	private IFoldingStructureProvider foldingProvider;

	private Converter converter;
	private HtmlGen htmlGen;

	public FluentEditor() {
		super();
	}

	@Override
	public DslUI getDslUI() {
		return FluentUI.getDefault();
	}

	@Override
	public DslCore getDslCore() {
		return FluentCore.getDefault();
	}

	@Override
	public String getEditorId() {
		return EDITOR_ID;
	}

	@Override
	public char[] getBrackets() {
		return STD_PAIRS;
	}

	@Override
	protected void initializeEditor() {
		super.initializeEditor();
		setEditorContextMenuId(EDITOR_CONTEXT);
		setRulerContextMenuId(RULER_CONTEXT);

		converter = new Converter();
		htmlGen = new HtmlGen(this, converter);
	}

	@Override
	protected void initializeKeyBindingScopes() {
		setKeyBindingScopes(EDITOR_KEY_SCOPE);
	}

	@Override
	public String getMarkOccurrencesAnnotationType() {
		return MARK_OCCURRENCES_ANNOTATION_TYPE;
	}

	@Override
	protected IRegion findWord(IDocument doc, int offset) {
		return finder.findWord(doc, offset);
	}

	@Override
	protected FluentOutlinePage doCreateOutlinePage() {
		return new FluentOutlinePage(getPreferenceStore());
	}

	@Override
	protected IFoldingStructureProvider createFoldingStructureProvider() {
		if (foldingProvider == null) {
			foldingProvider = new FmFoldingStructureProvider();
		}
		return foldingProvider;
	}

	@Override
	protected void connectPartitioningToElement(IEditorInput input, IDocument document) {
		if (document instanceof IDocumentExtension3) {
			IDocumentExtension3 extension = (IDocumentExtension3) document;
			if (extension.getDocumentPartitioner(Partitions.PARTITIONING) == null) {
				FluentDocumentSetupParticipant participant = new FluentDocumentSetupParticipant();
				participant.setup(document);
			}
		}
	}

	@Override
	protected void configureSourceViewerDecorationSupport(SourceViewerDecorationSupport support) {
		support.setCharacterPairMatcher(pairMatcher);
		support.setMatchingCharacterPainterPreferenceKeys(bind(Editor.EDITOR_MATCHING_BRACKETS),
				bind(Editor.EDITOR_MATCHING_BRACKETS_COLOR));
		super.configureSourceViewerDecorationSupport(support);
	}

	public FluentEditor ensureLastLineBlank() {
		IDocument doc = getDocument();
		String text = doc.get();
		if (!text.endsWith(Strings.EOL)) {
			doc.set(text + Strings.EOL);
		}
		return this;
	}

	/** Returns the Html content. */
	public String getHtml(Kind kind) {
		return htmlGen.getHtml(kind);
	}

	public boolean useMathJax() {
		return converter.useMathJax();
	}
}
