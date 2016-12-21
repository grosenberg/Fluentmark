package net.certiv.fluentmark.editor;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.swing.event.EventListenerList;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.IInformationControl;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.ITextViewerExtension5;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.TextUtilities;
import org.eclipse.jface.text.reconciler.IReconciler;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.jface.text.source.projection.ProjectionAnnotationModel;
import org.eclipse.jface.text.source.projection.ProjectionSupport;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPartService;
import org.eclipse.ui.IPathEditorInput;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.ui.part.IShowInSource;
import org.eclipse.ui.part.IShowInTarget;
import org.eclipse.ui.part.ShowInContext;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditorActionConstants;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.osgi.framework.Bundle;

import net.certiv.fluentmark.FluentMkUI;
import net.certiv.fluentmark.Log;
import net.certiv.fluentmark.convert.FluentMkConverter;
import net.certiv.fluentmark.editor.color.IColorManager;
import net.certiv.fluentmark.editor.folding.FoldingStructureProvider;
import net.certiv.fluentmark.editor.folding.IFoldingStructureProvider;
import net.certiv.fluentmark.editor.text.SmartBackspaceManager;
import net.certiv.fluentmark.model.ISourceRange;
import net.certiv.fluentmark.model.PagePart;
import net.certiv.fluentmark.model.PageRoot;
import net.certiv.fluentmark.preferences.Prefs;
import net.certiv.fluentmark.preferences.pages.PrefPageEditor;
import net.certiv.fluentmark.util.FileUtils;
import net.certiv.fluentmark.util.Strings;

/**
 * Text editor with markdown support.
 */
public class FluentMkEditor extends TextEditor implements IShowInTarget, IShowInSource, IReconcilingListener {

	public static final String ID = "net.certiv.fluentmark.editor.FluentMkEditor";

	private static final String HIGHLIGHT_CSS = "https://cdnjs.cloudflare.com/ajax/libs/highlight.js/9.8.0/styles/default.min.css";
	private static final String HIGHLIGHT_JS = "https://cdnjs.cloudflare.com/ajax/libs/highlight.js/9.8.0/highlight.min.js";

	/**
	 * Updates the DslOutline pageModel selection and this editor's range indicator.
	 */
	private class EditorSelectionChangedListener extends AbstractSelectionChangedListener {

		@Override
		public void selectionChanged(SelectionChangedEvent event) {
			FluentMkEditor.this.selectionChanged();
		}
	}

	private FluentMkSourceViewer viewer;
	private FluentMkOutlinePage outlinePage;
	private FluentMkTextTools tools;
	private IColorManager colorManager;
	private FluentMkConverter converter;
	private PageRoot pageModel;
	private IFoldingStructureProvider projectionProvider;
	private ProjectionSupport projectionSupport;
	private IDocumentListener docListener;
	private EventListenerList docListenerList;
	private IPropertyChangeListener prefChangeListener;
	// private SemanticHighlightingManager semanticManager;
	private boolean pageDirty = true;

	private ListenerList<IReconcilingListener> reconcilingListeners;
	private EditorSelectionChangedListener editorSelectionChangedListener;

	public FluentMkEditor() {
		super();
	}

	@Override
	protected void initializeKeyBindingScopes() {
		setKeyBindingScopes(new String[] { "org.eclipse.ui.textEditorScope", "net.certiv.fluentmark.ui.editorScope" });
	}

	@Override
	protected boolean isTabsToSpacesConversionEnabled() {
		return true;
	}

	@Override
	protected void initializeEditor() {
		super.initializeEditor();
		createListeners();
		initEditorPreferenceStore();
		colorManager = FluentMkUI.getDefault().getColorMgr();
		tools = FluentMkUI.getDefault().getTextTools();
		SourceViewerConfiguration config = tools.createSourceViewerConfiguraton(getPreferenceStore(), this);
		setSourceViewerConfiguration(config);
		setDocumentProvider(getDocumentProvider());
		pageModel = new PageRoot(this);
		converter = new FluentMkConverter();
	}

	private void createListeners() {
		reconcilingListeners = new ListenerList<>(ListenerList.IDENTITY);
		docListenerList = new EventListenerList();
		docListener = new IDocumentListener() {

			@Override
			public void documentChanged(DocumentEvent event) {
				pageDirty = true;
				fireDocumentChanged(event);
			}

			@Override
			public void documentAboutToBeChanged(DocumentEvent event) {}
		};

		prefChangeListener = new IPropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent event) {
				if (event.getProperty().equals(PrefPageEditor.EDITOR_WORD_WRAP)) {
					getViewer().getTextWidget().setWordWrap(isWordWrap());
				}
			}
		};
	}

	@Override
	protected void doSetInput(IEditorInput input) throws CoreException {
		if (getDocument() != null) getDocument().removeDocumentListener(docListener);
		setPreferenceStore(getPrefsStore());
		super.doSetInput(input);
		IDocument doc = getDocumentProvider().getDocument(input);

		// check and correct line endings
		String tmp = doc.get();
		int hash = tmp.hashCode();
		tmp = Strings.normalize(tmp);
		if (hash != tmp.hashCode()) doc.set(tmp);

		connectPartitioningToElement(input, doc);

		FluentMkSourceViewer sourceViewer = (FluentMkSourceViewer) getSourceViewer();
		if (sourceViewer != null && sourceViewer.getReconciler() == null) {
			IReconciler reconciler = getSourceViewerConfiguration().getReconciler(sourceViewer);
			if (reconciler != null) {
				reconciler.install(sourceViewer);
				sourceViewer.setReconciler(reconciler);
			}
		}

		// Attach listener to new doc
		getDocument().addDocumentListener(docListener);
		installSemanticHighlighting();

		// Initialize code folding
		if (projectionProvider != null) {
			projectionProvider.initialize();
		}
	}

	private void connectPartitioningToElement(IEditorInput input, IDocument document) {
		if (document instanceof IDocumentExtension3) {
			IDocumentExtension3 extension = (IDocumentExtension3) document;
			if (extension.getDocumentPartitioner(Partitions.MK_PARTITIONING) == null) {
				FluentMkDocumentSetupParticipant participant = new FluentMkDocumentSetupParticipant(tools);
				participant.setup(document);
			}
		}
	}

	/**
	 * Returns the editor's source viewer. May return null before the editor's part has been created
	 * and after disposal.
	 */
	public ISourceViewer getViewer() {
		return getSourceViewer();
	}

	@Override
	protected ISourceViewer createSourceViewer(Composite parent, IVerticalRuler ruler, int styles) {
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayoutFactory.fillDefaults().spacing(0, 0).applyTo(composite);

		Composite editorComposite = new Composite(composite, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(editorComposite);
		editorComposite.setLayout(new FillLayout(SWT.VERTICAL));

		viewer = new FluentMkSourceViewer(editorComposite, ruler, getOverviewRuler(), isOverviewRulerVisible(), styles,
				getPreferenceStore());
		if (isFoldingEnabled() && !getPreferenceStore().getBoolean(Prefs.EDITOR_SHOW_SEGMENTS)) {
			viewer.prepareDelayedProjection();
		}

		projectionSupport = new ProjectionSupport(viewer, getAnnotationAccess(), getSharedColors());
		projectionSupport.addSummarizableAnnotationType("org.eclipse.ui.workbench.texteditor.error"); // $NON-NLS-1$
		projectionSupport.addSummarizableAnnotationType("org.eclipse.ui.workbench.texteditor.warning");	// $NON-NLS-1$
		projectionSupport.addSummarizableAnnotationType("org.eclipse.search.results"); // $NON-NLS-1$
		projectionSupport.setHoverControlCreator(new IInformationControlCreator() {

			@Override
			public IInformationControl createInformationControl(Shell shell) {
				String statusFieldText = EditorsUI.getTooltipAffordanceString();
				return new FluentMkSourceViewerInfoControl(shell, false, getOrientation(), statusFieldText);
			}
		});
		projectionSupport.install();

		projectionProvider = new FoldingStructureProvider();
		if (projectionProvider != null) {
			projectionProvider.install(this, viewer, getPreferenceStore());
		}

		if (isFoldingEnabled()) {
			viewer.doOperation(ProjectionViewer.TOGGLE);
		}

		getSourceViewerDecorationSupport(viewer);
		viewer.getTextWidget().setWordWrap(isWordWrap());
		return viewer;
	}

	private boolean isWordWrap() {
		return getPreferenceStore().getBoolean(Prefs.EDITOR_WORD_WRAP);
	}

	public void dispose() {
		removePreferenceStoreListener();
		uninstallSemanticHighlighting();
		colorManager.dispose();
		colorManager = null;
		super.dispose();
	}

	@Override
	protected boolean affectsTextPresentation(PropertyChangeEvent event) {
		SourceViewerConfiguration configuration = getSourceViewerConfiguration();
		if (configuration instanceof FluentMkSourceViewerConfiguration) {
			return ((FluentMkSourceViewerConfiguration) configuration).affectsTextPresentation(event);
		}
		return false;
	}

	@Override
	protected void performRevert() {
		ProjectionViewer projectionViewer = (ProjectionViewer) getSourceViewer();
		projectionViewer.setRedraw(false);
		try {

			boolean projectionMode = projectionViewer.isProjectionMode();
			if (projectionMode) {
				projectionViewer.disableProjection();
				if (projectionProvider != null) {
					projectionProvider.uninstall();
				}
			}

			super.performRevert();

			if (projectionMode) {
				if (projectionProvider != null) {
					projectionProvider.install(this, projectionViewer, getPreferenceStore());
				}
				projectionViewer.enableProjection();
			}

		} finally {
			projectionViewer.setRedraw(true);
		}
	}

	/**
	 * Initializes the preference store for this editor. The constucted store represents the
	 * combined values of the FluentMkUI, EditorsUI, and PlatformUI stores.
	 */
	private void initEditorPreferenceStore() {
		IPreferenceStore store = FluentMkUI.getDefault().getCombinedPreferenceStore();
		store.addPropertyChangeListener(prefChangeListener);
		setPreferenceStore(store);
	}

	private void removePreferenceStoreListener() {
		if (getPreferenceStore() != null) {
			getPreferenceStore().removePropertyChangeListener(prefChangeListener);
		}
	}

	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);

		editorSelectionChangedListener = new EditorSelectionChangedListener();
		editorSelectionChangedListener.install(getSelectionProvider());

		if (isMarkingOccurrences()) {
			installOccurrencesFinder(false);
		}
	}

	private FluentMkOutlinePage createOutlinePage() {
		final FluentMkOutlinePage page = new FluentMkOutlinePage(this, getPreferenceStore());
		setOutlinePageInput(page, getEditorInput());
		return page;
	}

	private boolean isOutlinePageValid() {
		return outlinePage != null && outlinePage.getControl() != null && !outlinePage.getControl().isDisposed();
	}

	/**
	 * Informs the editor that its outliner has been closed.
	 */
	public void outlinePageClosed() {
		if (outlinePage != null) {
			outlinePage = null;
			resetHighlightRange();
		}
	}

	private void setOutlinePageInput(FluentMkOutlinePage page, IEditorInput input) {
		if (page == null) return;
		PageRoot model = PageRoot.MODEL;
		if (model != null) {
			page.setInput(model);
		} else {
			page.setInput(null);
		}
	}

	/**
	 * Handles a property change event describing a change of the editor's preference delta and
	 * updates the preference related editor properties.
	 *
	 * @param event the property change event
	 */
	@Override
	protected void handlePreferenceStoreChanged(PropertyChangeEvent event) {
		String property = event.getProperty();
		try {
			SourceViewerConfiguration config = getSourceViewerConfiguration();
			if (config != null) ((FluentMkSourceViewerConfiguration) config).handlePropertyChangeEvent(event);

			if (Prefs.EDITOR_TAB_WIDTH.equals(property)) {
				StyledText textWidget = getViewer().getTextWidget();
				int tabWidth = getSourceViewerConfiguration().getTabWidth(getViewer());
				if (textWidget.getTabs() != tabWidth) {
					textWidget.setTabs(tabWidth);
				}
				uninstallTabsToSpacesConverter();
				if (isTabsToSpacesConversionEnabled()) {
					installTabsToSpacesConverter();
				} else {
					updateIndentPrefixes();
				}
				return;
			}
		} finally {
			super.handlePreferenceStoreChanged(event);
		}
	}

	/**
	 * Determines if folding is enabled.
	 *
	 * @return <code>true</code> if folding is enabled, <code>false</code> otherwise.
	 */
	boolean isFoldingEnabled() {
		IPreferenceStore store = getPreferenceStore();
		return store.getBoolean(Prefs.FOLDING_FRONTMATTER_ENABLED)
				|| store.getBoolean(Prefs.FOLDING_HIDDEN_COMMENTS_ENABLED)
				|| store.getBoolean(Prefs.FOLDING_CODEBLOCKS_ENABLED);
	}

	@SuppressWarnings({ "unchecked" })
	public <T> T getAdapter(Class<T> target) {
		if (IContentOutlinePage.class.equals(target)) {
			if (!isOutlinePageValid()) {
				outlinePage = createOutlinePage();
			}
			return (T) outlinePage;
		}
		if (SmartBackspaceManager.class.equals(target)) {
			if (getSourceViewer() instanceof FluentMkSourceViewer) {
				return (T) ((FluentMkSourceViewer) getSourceViewer()).getBackspaceManager();
			}
		}
		if (PagePart.class.equals(target)) {
			return (T) getPageModel();
		}
		if (ProjectionAnnotationModel.class.equals(target)) {
			if (projectionSupport != null) {
				Object adapter = projectionSupport.getAdapter(getSourceViewer(), target);
				if (adapter != null) return (T) adapter;
			}
		}
		if (target == IFoldingStructureProvider.class) {
			return (T) projectionProvider;
		}
		return super.getAdapter(target);
	}

	public IDocument getDocument() {
		IEditorInput input = getEditorInput();
		IDocumentProvider docProvider = getDocumentProvider();
		return docProvider == null ? null : docProvider.getDocument(input);
	}

	public PageRoot getPageModel() {
		if (pageDirty) updatePageModel();
		return pageModel;
	}

	public PageRoot getPageModel(boolean forceUpdate) {
		if (forceUpdate) pageDirty = true;
		return getPageModel();
	}

	/** Make the store visible outside of the editor */
	public IPreferenceStore getPrefsStore() {
		return getPreferenceStore();
	}

	/** Gets the text of the current document, or null. */
	public String getText() {
		IDocument doc = getDocument();
		return doc == null ? null : doc.get();
	}

	/**
	 * Gets the html content generated from the current document, or null.
	 * 
	 * @param extended if true, a full header is added suitable for HTML presentation. Otherwise, a
	 *            minimal header is added.
	 */
	public String getHtml(boolean extended) {
		IDocument doc = getDocument();
		int beg = 0;
		int len = doc.getLength();

		// check for and skip front matter
		ITypedRegion region;
		try {
			region = TextUtilities.getPartition(getDocument(), Partitions.MK_PARTITIONING, beg, true);
		} catch (BadLocationException e) {
			Log.error("Failed to get partition at offset: " + beg);
			return "";
		}
		if (region.getType().equals(Partitions.FRONT_MATTER)) {
			beg += region.getLength();
			len -= region.getLength();
		}

		try {
			String text = getDocument().get(beg, len);
			String html = converter.convert(text);
			IPathEditorInput input = (IPathEditorInput) getEditorInput();
			return addHeader(html, getStyles(input.getPath()), extended);
		} catch (BadLocationException e) {
			Log.error("Bad front matter exclusion: " + beg + ":" + len + "; " + region.getLength());
			return "";
		}
	}

	private String addHeader(String html, String style, boolean extended) {
		StringBuilder sb = new StringBuilder("<html><head>" + Strings.EOL);

		if (extended) {
			sb.append("<link rel=\"stylesheet\" " + "href=\"" + HIGHLIGHT_CSS + "\">" + Strings.EOL);
			sb.append("<script src=\"" + HIGHLIGHT_JS + "\">" + "</script>" + Strings.EOL);
			sb.append("<script>hljs.initHighlightingOnLoad();</script>" + Strings.EOL);

			if (style != null) {
				try {
					String stylesheet = FileUtils.read(new File(style));
					sb.append("<style media=\"screen\" type=\"text/css\">" + Strings.EOL);
					sb.append(stylesheet + Strings.EOL);
					sb.append("</style>" + Strings.EOL);
				} catch (RuntimeException e) {
					Log.error("Failed reading stylesheet", e);
				}
			}
		}

		sb.append("</head><body>" + Strings.EOL);
		sb.append(html + Strings.EOL);
		sb.append("</body></html>");
		return sb.toString();
	}

	private String getStyles(IPath path) {
		// 1) look for a file having the same name as the input file, beginning in the
		// current directory, parent directories, and the current project directory.
		IPath styles = path.removeFileExtension().addFileExtension(Prefs.CSS);
		String pathname = find(styles);
		if (pathname != null) return pathname;

		// 2) look for a file with the name 'markfluent.css' in the same set of directories
		styles = path.removeLastSegments(1).append(Prefs.CSS_DEFAULT);
		pathname = find(styles);
		if (pathname != null) return pathname;

		// 3) read the file identified by the pref key 'EDITOR_CSS_CUSTOM' from the filesystem
		IPreferenceStore store = FluentMkUI.getDefault().getPreferenceStore();
		String customCss = store.getString(Prefs.EDITOR_CSS_CUSTOM);
		if (!customCss.isEmpty()) {
			File file = new File(customCss);
			if (file.isFile() && file.getName().endsWith("." + Prefs.CSS)) {
				return customCss;
			}
		}

		// 4) read the file identified by the pref key 'EDITOR_CSS_DEFAULT' from the bundle
		String defaultCss = store.getString(Prefs.EDITOR_CSS_DEFAULT);
		if (!defaultCss.isEmpty()) {
			try {
				URI uri = new URI(defaultCss);
				File file = new File(uri);
				if (file.isFile()) return file.getPath();
			} catch (URISyntaxException e) {
				MessageDialog.openInformation(null, "Default CSS from bundle", defaultCss);
			}
		}

		// 5) read 'markdown.css' from the bundle
		Bundle bundle = Platform.getBundle(FluentMkUI.PLUGIN_ID);
		URL url = FileLocator.find(bundle, new Path(Prefs.CSS_RESOURCE_DIR + Prefs.CSS_DEFAULT), null);
		try {
			url = FileLocator.toFileURL(url);
			return url.toURI().toString();
		} catch (IOException | URISyntaxException e) {
			Log.error(e);
			return null;
		}
	}

	private String find(IPath styles) {
		String name = styles.lastSegment();
		IPath base = styles.removeLastSegments(1);

		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IContainer dir = root.getContainerForLocation(base);

		while (dir.getType() != IResource.ROOT) {
			IResource member = dir.findMember(name);
			if (member != null) {
				return root.getLocation().append(member.getFullPath()).toFile().toURI().toString();
			}
			dir = dir.getParent();
		}
		return null;
	}

	/**
	 * React to change selection event in the editor and outline!
	 */
	public void selectionChanged() {
		if (getSelectionProvider() == null) return;
		ISourceReference element = computeHighlightRange();
		if (element != null) {
			if (isOutlinePageValid()) outlinePage.select(element);
			setSelection(element.getSourceRange(), false);
		}
		updateStatusLine();
	}

	/**
	 * Sets the current editor selection to the source range. Optionally sets the current editor
	 * position.
	 *
	 * @param range the source range to be shown in the editor, can be null.
	 * @param moveCursor if true the editor is scrolled to show the range.
	 */
	private void setSelection(ISourceRange range, boolean moveCursor) {
		if (range == null) return;

		try {
			int start = range.getOffset();
			int length = range.getLength();
			setHighlightRange(start, length, moveCursor);

			if (moveCursor) {
				if (start > -1 && getSourceViewer() != null) {
					getSourceViewer().revealRange(start, length);
					// getSourceViewer().setSelectedRange(start, length);
				}
				updateStatusField(ITextEditorActionConstants.STATUS_CATEGORY_INPUT_POSITION);
			}
			return;
		} catch (IllegalArgumentException e) {}

		if (moveCursor) resetHighlightRange();
	}

	public void revealPart(PagePart part) {
		reveal(part.getSourceRange().getOffset(), part.getSourceRange().getLength());
		// TODO: scroll browser
	}

	/**
	 * Reveals the specified ranges in this text editor.
	 *
	 * @param offset the offset of the revealed range
	 * @param len the length of the revealed range
	 */
	protected void reveal(int offset, int len) {
		if (viewer == null) return;

		ISelection sel = getSelectionProvider().getSelection();
		if (sel instanceof ITextSelection) {
			ITextSelection tsel = (ITextSelection) sel;
			if (tsel.getOffset() != 0 || tsel.getLength() != 0) markInNavigationHistory();
		}

		StyledText widget = viewer.getTextWidget();
		widget.setRedraw(false);
		setHighlightRange(offset, len, false);
		viewer.revealRange(offset, len);
		markInNavigationHistory();
		widget.setRedraw(true);
	}

	protected void updateStatusLine() {
		ITextSelection selection = (ITextSelection) getSelectionProvider().getSelection();
		Annotation annotation = getAnnotation(selection.getOffset(), selection.getLength());
		String message = null;
		if (annotation != null) {
			updateMarkerViews(annotation);
			if (annotation instanceof IAnnotation && ((IAnnotation) annotation).isProblem()) {
				message = annotation.getText();
			}
		}
		setStatusLineErrorMessage(null);
		setStatusLineMessage(message);
	}

	/**
	 * Computes and returns the source reference that includes the caret and serves as provider for
	 * the outline pageModel selection and the editor range indication.
	 *
	 * @return the computed source reference
	 */
	public ISourceReference computeHighlightRange() {
		ISourceViewer sourceViewer = getSourceViewer();
		if (sourceViewer == null) return null;

		StyledText styledText = sourceViewer.getTextWidget();
		if (styledText == null) return null;

		int caret = 0;
		if (sourceViewer instanceof ITextViewerExtension5) {
			ITextViewerExtension5 extension = (ITextViewerExtension5) sourceViewer;
			caret = extension.widgetOffset2ModelOffset(styledText.getSelection().x);
		} else {
			int offset = sourceViewer.getVisibleRegion().getOffset();
			caret = offset + styledText.getSelection().x;
		}

		PagePart part = getPagePartAt(caret, false);
		return (ISourceReference) part;
	}

	private PagePart getMatchingPagePart() {
		Point selectedRange = getSourceViewer().getSelectedRange();
		if (selectedRange != null) {
			return getPagePartAt(selectedRange.x, false);
		}
		return null;
	}

	/**
	 * Returns the most narrow element including the given offset. If <code>reconcile</code> is
	 * <code>true</code> the editor's input element is reconciled in advance. If it is
	 * <code>false</code> this method only returns a result if the editor's input element does not
	 * need to be reconciled.
	 *
	 * @param offset the offset included by the retrieved element
	 * @param reconcile <code>true</code> if should be reconciled
	 * @return the most narrow element which includes the given offset
	 */
	private PagePart getPagePartAt(int offset, boolean reconcile) {
		return pageModel.partAtOffset(offset);
	}

	int offset = 0; // crap!!!

	public int getCursorOffset() {
		Display.getDefault().syncExec(new Runnable() {

			@Override
			public void run() {
				offset = getSourceViewer().getTextWidget().getCaretOffset();
			}
		});
		return offset;
	}

	/**
	 * Returns the annotation overlapping with the given range or <code>null</code>.
	 *
	 * @param offset the region offset
	 * @param length the region length
	 * @return the found annotation or <code>null</code>
	 */
	private Annotation getAnnotation(int offset, int length) {
		IAnnotationModel model = getDocumentProvider().getAnnotationModel(getEditorInput());
		if (model == null) {
			return null;
		}

		Iterator<Annotation> e = new AnnotationIterator(model, true, false);
		while (e.hasNext()) {
			Annotation a = e.next();
			Position p = model.getPosition(a);
			if (p != null && p.overlapsWith(offset, length)) {
				return a;
			}
		}
		return null;
	}

	private void updatePageModel() {
		String text = getText();
		if (text == null) text = "";
		IResource resource = ResourceUtil.getResource(getEditorInput());
		pageModel.updateModel(resource, text);
		pageDirty = false;
	}

	public boolean isActiveOn(IResource resource) {
		IFile current = getResource();
		if (current != null && current.equals(resource)) return true;
		return false;
	}

	private IFile getResource() {
		return ResourceUtil.getFile(getEditorInput());
	}

	void updateTaskTags(IRegion region) {
		boolean useTags = getPreferenceStore().getBoolean(PrefPageEditor.EDITOR_TASK_TAGS);
		if (!useTags) return;

		String tagString = getPreferenceStore().getString(PrefPageEditor.EDITOR_TASK_TAGS_DEFINED);
		List<String> tags = new ArrayList<>();
		for (String tag : tagString.split(",")) {
			tags.add(tag.trim());
		}

		IFile markFile = getResource();
		IMarker[] taskMarkers;
		try {
			taskMarkers = markFile.findMarkers(IMarker.TASK, true, IResource.DEPTH_INFINITE);
		} catch (CoreException e) {
			return;
		}

		List<IMarker> markers = new ArrayList<IMarker>(Arrays.asList(taskMarkers));
		pageModel.markTaggedLines(markFile, tags, markers);

	}

	protected void installSemanticHighlighting() {
		// if (semanticManager == null) {
		// semanticManager = new SemanticHighlightingManager();
		// semanticManager.install(this, (FluentMkSourceViewer) getSourceViewer(), colorManager,
		// getPreferenceStore());
		// }
	}

	private void uninstallSemanticHighlighting() {
		// if (semanticManager != null) {
		// semanticManager.uninstall();
		// semanticManager = null;
		// }
	}

	public boolean isMarkingOccurrences() {
		return false;
	}

	public void uninstallOccurrencesFinder() {}

	public void installOccurrencesFinder(boolean b) {}

	public void reconciled() {
		Object[] listeners = reconcilingListeners.getListeners();
		for (Object listener : listeners) {
			((IReconcilingListener) listener).reconciled();
		}
	}

	/**
	 * Adds the given listener. Has no effect if an identical listener was not already registered.
	 *
	 * @param listener The reconcile listener to be added
	 */
	public final void addReconcileListener(IReconcilingListener listener) {
		reconcilingListeners.add(listener);
	}

	/**
	 * Removes the given listener. Has no effect if an identical listener was not already
	 * registered.
	 *
	 * @param listener the reconcile listener to be removed
	 */
	public final void removeReconcileListener(IReconcilingListener listener) {
		reconcilingListeners.remove(listener);
	}

	protected IWorkbenchPart getActivePart() {
		IWorkbenchWindow window = getSite().getWorkbenchWindow();
		IPartService service = window.getPartService();
		IWorkbenchPart part = service.getActivePart();
		return part;
	}

	@Override
	public ShowInContext getShowInContext() {
		PagePart part = getMatchingPagePart();
		StructuredSelection sel;
		if (part == null) {
			sel = new StructuredSelection();
		} else {
			sel = new StructuredSelection(part);
		}
		return new ShowInContext(getEditorInput(), sel);
	}

	@Override
	public boolean show(ShowInContext context) {
		ISelection selection = context.getSelection();
		if (selection instanceof IStructuredSelection) {
			for (Object element : ((IStructuredSelection) selection).toArray()) {
				if (element instanceof PagePart) {
					PagePart item = (PagePart) element;
					revealPart(item);
					if (isOutlinePageValid()) {
						outlinePage.setSelection(selection);
					}
					return true;
				}
			}
		} else if (selection instanceof ITextSelection) {
			ITextSelection textSel = (ITextSelection) selection;
			selectAndReveal(textSel.getOffset(), textSel.getLength());
			return true;
		}
		return false;
	}

	public void addDocChangeListener(IDocumentChangedListener listener) {
		docListenerList.add(IDocumentChangedListener.class, listener);
	}

	public void removeDocChangeListener(IDocumentChangedListener listener) {
		docListenerList.remove(IDocumentChangedListener.class, listener);
	}

	protected void fireDocumentChanged(DocumentEvent event) {
		IDocumentChangedListener[] listeners;
		synchronized (docListenerList) {
			Object[] src = docListenerList.getListeners(IDocumentChangedListener.class);
			int len = docListenerList.getListenerCount();
			listeners = new IDocumentChangedListener[len];
			System.arraycopy(src, 0, listeners, 0, len);
		}
		for (IDocumentChangedListener listener : listeners) {
			listener.documentChanged(event);
		}
	}
}
