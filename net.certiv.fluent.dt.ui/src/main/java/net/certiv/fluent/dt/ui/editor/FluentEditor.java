package net.certiv.fluent.dt.ui.editor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.source.DefaultCharacterPairMatcher;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.texteditor.SourceViewerDecorationSupport;

import net.certiv.common.util.Strings;
import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.core.preferences.PrefsManager;
import net.certiv.dsl.core.preferences.consts.Editor;
import net.certiv.dsl.ui.DslUI;
import net.certiv.dsl.ui.editor.DslEditor;
import net.certiv.dsl.ui.editor.DslSourceViewer;
import net.certiv.dsl.ui.editor.text.DslWordFinder;
import net.certiv.dsl.ui.editor.text.folding.IFoldingStructureProvider;
import net.certiv.fluent.dt.core.FluentCore;
import net.certiv.fluent.dt.core.preferences.Prefs;
import net.certiv.fluent.dt.ui.FluentUI;
import net.certiv.fluent.dt.ui.editor.folding.FmFoldingStructureProvider;
import net.certiv.fluent.dt.ui.editor.outline.FluentOutlinePage;
import net.certiv.fluent.dt.ui.editor.toolbar.EditorToolbar;
import net.certiv.fluent.dt.ui.editor.toolbar.FluentEditorToolbar;

public class FluentEditor extends DslEditor {

	public static final String EDITOR_ID = "net.certiv.fluent.dt.ui.editor.FluentEditor";
	public static final String EDITOR_CONTEXT = "#FluentEditorContext";
	public static final String RULER_CONTEXT = "#FluentRulerContext";

	private static final String[] EDITOR_KEY_SCOPE = { "net.certiv.fluent.dt.ui.fluentEditorScope" };
	private static final String MARK_OCCURRENCES_ANNOTATION_TYPE = "net.certiv.fluent.dt.ui.occurrences";

	private final DslWordFinder finder = new DslWordFinder();
	private final DefaultCharacterPairMatcher pairMatcher = new DefaultCharacterPairMatcher(STD_PAIRS,
			Partitions.PARTITIONING);

	private IFoldingStructureProvider foldingProvider;
	private EditorToolbar toolbar;

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

	@Override
	protected void performSave(boolean overwrite, IProgressMonitor monitor) {
		PrefsManager mgr = getPrefsMgr();
		boolean enabled = mgr.getBoolean(Prefs.FORMATTER_ENABLED);
		boolean save = mgr.getBoolean(Prefs.FORMATTER_ON_SAVE);
		if (enabled && save) {
			DslSourceViewer viewer = (DslSourceViewer) getSourceViewer();
			viewer.doOperation(ISourceViewer.FORMAT);
		}
		super.performSave(overwrite, monitor);
	}

	public FluentEditor ensureLastLineBlank() {
		IDocument doc = getDocument();
		String text = doc.get();
		if (!text.endsWith(Strings.EOL)) {
			doc.set(text + Strings.EOL);
		}
		return this;
	}

	// --------------------------------

	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		toolbar = createEditorToolbar();

	}

	/**
	 * Creates the toolbar to be used by this editor. Returns {@code null} if this editor
	 * can not show a toolbar.
	 *
	 * @return the toolbar or {@code null}
	 */
	protected EditorToolbar createEditorToolbar() {
		return new FluentEditorToolbar(this);
	}

	/**
	 * @return the toolbar used by this viewer if any.
	 */
	public EditorToolbar getEditorToolbar() {
		return toolbar;
	}

	/**
	 * Returns the preference key for the toolbar. The value depends on the current
	 * perspective.
	 *
	 * @return the preference key or {@code null} if there's no perspective
	 */
	String getEditorToolbarPrefKey() {
		IPerspectiveDescriptor perspective = getSite().getPage().getPerspective();
		if (perspective == null) return null;
		return bind(Prefs.EDITOR_SHOW_TOOLBAR) + Strings.DOT + perspective.getId();
	}

	public boolean isEditorToolbarShown() {
		PrefsManager mgr = getPrefsMgr();
		String key = getEditorToolbarPrefKey();
		return mgr.getBoolean(key, false);
	}

	public void showEditorToolbar(boolean show) {
		PrefsManager mgr = getPrefsMgr();
		String key = getEditorToolbarPrefKey();
		mgr.setValue(key, show);
		if (show) {
			showEditorToolbar();
		} else {
			hideEditorToolbar();
		}
	}

	/**
	 * Makes the toolbar visible. Creates its content if this is the first time it is made
	 * visible.
	 */
	private void showEditorToolbar() {
		if (toolbar == null) return;

		Composite tbComp = getInterposerComposite();
		if (tbComp.isDisposed()) {
			SWT.error(SWT.ERROR_WIDGET_DISPOSED, null, ". Editor not properly disposed.");
		}
		if (tbComp.getChildren().length == 0) {
			toolbar.createContent(tbComp);
		}

		((GridData) tbComp.getLayoutData()).exclude = false;
		tbComp.setVisible(true);

		DslSelection selection = (DslSelection) getSelectionProvider().getSelection();
		if (selection == null) {
			selection = new DslSelection(getDocument(), 0, 0);
		}
		setToolbarInput(selection);
		tbComp.getParent().layout(true, true);
	}

	/** Hides the toolbar. */
	private void hideEditorToolbar() {
		if (toolbar == null) return;

		Composite tbComp = getInterposerComposite();
		((GridData) tbComp.getLayoutData()).exclude = true;
		tbComp.setVisible(false);
		tbComp.getParent().layout(true, true);
	}

	/**
	 * Sets the toolbar input.
	 *
	 * @param selection the toolbar input
	 */
	private void setToolbarInput(DslSelection selection) {
		if (toolbar == null) return;
		toolbar.setInput(selection);
	}
}
