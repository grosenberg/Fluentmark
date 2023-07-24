package net.certiv.fluent.dt.ui.editor.toolbar;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.ActionGroup;
import org.eclipse.ui.texteditor.ITextEditor;

import net.certiv.dsl.core.util.eclipse.PartAdaptor;

/**
 * The editor toolbar shows the parent chain of the active editor item inside a
 * {@link EditorToolbarViewer}.
 * <p>
 * Clients must implement the abstract methods.
 */
public abstract class EditorToolbar /* implements IEditorToolbar */ {

	private static final String ACTIVE_TAB_BG_END = "org.eclipse.ui.workbench.ACTIVE_TAB_BG_END"; //$NON-NLS-1$

	private ITextEditor editor;
	private ITextViewer viewer;
	private EditorToolbarViewer toolbarViewer;

	private boolean fHasFocus;
	private boolean fIsActive;

	/** Toolbar base composite */
	private Composite fComposite;

	private Listener fDisplayFocusListener;
	private Listener fDisplayKeyListener;

	private IPropertyChangeListener fPropertyChangeListener;

	private ISelection fOldTextSelection;

	private IPartListener fPartListener;

	/**
	 * Constructor.
	 *
	 * @param editor the hosting editor
	 */
	public EditorToolbar(ITextEditor editor) {
		setTextEditor(editor);
	}

	/**
	 * The active element of the editor.
	 *
	 * @return the active element of the editor, or {@code null} if none
	 */
	protected abstract Object getCurrentInput();

	/**
	 * Create and configure the viewer used to display the parent chain.
	 *
	 * @param parent the parent composite
	 * @return the viewer
	 */
	protected abstract EditorToolbarViewer createViewer(Composite parent);

	/**
	 * Reveal the given element in the editor if possible.
	 *
	 * @param element the element to reveal
	 * @return true if the element could be revealed
	 */
	protected abstract boolean reveal(Object element);

	/**
	 * Open the element in a new editor if possible.
	 *
	 * @param element the element to open
	 * @return true if the element could be opened
	 */
	protected abstract boolean open(Object element);

	/**
	 * Create an action group for the context menu shown for the selection of the given
	 * selection provider or {@code null} if no context menu should be shown.
	 *
	 * @param selectionProvider the provider of the context selection
	 * @return action group to use to fill the context menu or {@code null}
	 */
	protected abstract ActionGroup createContextMenuActionGroup(ISelectionProvider selectionProvider);

	/**
	 * The toolbar has been activated. Implementors must retarget the editor actions to
	 * the toolbar aware actions.
	 */
	protected abstract void activateEditorToolbar();

	/**
	 * The toolbar has been deactivated. Implementors must retarget the toolbar actions to
	 * the editor actions.
	 */
	protected abstract void deactivateEditorToolbar();

	public ISelectionProvider getSelectionProvider() {
		return toolbarViewer;
	}

	protected void setTextViewer(ITextViewer viewer) {
		this.viewer = viewer;
	}

	public void setInput(Object element) {
		if (element == null) return;

		Object input = toolbarViewer.getInput();
		if (input == element || element.equals(input)) return;

		toolbarViewer.setInput(element);
	}

	public boolean isActive() {
		return fIsActive;
	}

	public Control createContent(Composite parent) {
		Assert.isTrue(fComposite == null, "Content must only be created once."); //$NON-NLS-1$

		boolean rtl = (getTextEditor().getSite().getShell().getStyle() & SWT.RIGHT_TO_LEFT) != 0;

		fComposite = new Composite(parent, rtl ? SWT.RIGHT_TO_LEFT : SWT.NONE);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.TOP).grab(true, false).applyTo(fComposite);
		GridLayoutFactory.fillDefaults().spacing(0, 0).applyTo(fComposite);

		fDisplayFocusListener = event -> {
			if (isEditorToolbarEvent(event)) {
				if (fHasFocus) return;
				fIsActive = true;
				focusGained();

			} else {
				if (!fIsActive) return;
				boolean hasTextFocus = viewer.getTextWidget().isFocusControl();
				if (hasTextFocus) {
					fIsActive = false;
				}
				if (!fHasFocus) return;
				focusLost();
			}
		};

		Display.getCurrent().addFilter(SWT.FocusIn, fDisplayFocusListener);

		toolbarViewer = createViewer(fComposite);
		toolbarViewer.getControl().setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));

		toolbarViewer.addOpenListener(event -> doRevealOrOpen(event.getSelection()));

		fPropertyChangeListener = event -> {
			if (ACTIVE_TAB_BG_END.equals(event.getProperty())) {
				if (fComposite.isFocusControl()) {
					fComposite.setBackground(JFaceResources.getColorRegistry().get(ACTIVE_TAB_BG_END));
				}
			}
		};
		JFaceResources.getColorRegistry().addListener(fPropertyChangeListener);

		return fComposite;
	}

	public void dispose() {
		if (fPropertyChangeListener != null) {
			JFaceResources.getColorRegistry().removeListener(fPropertyChangeListener);
		}
		if (fDisplayFocusListener != null) {
			Display.getDefault().removeFilter(SWT.FocusIn, fDisplayFocusListener);
		}
		deinstallDisplayListeners();
		if (fPartListener != null) {
			getTextEditor().getSite().getPage().removePartListener(fPartListener);
		}

		setTextEditor(null);
	}

	/**
	 * Either reveal the selection in the editor or open the selection in a new editor. If
	 * both fail open the child pop up of the selected element.
	 *
	 * @param selection the selection to open
	 */
	private void doRevealOrOpen(ISelection selection) {
		if (doReveal(selection)) {
			viewer.getTextWidget().setFocus();
		} else if (doOpen(selection)) {
			fIsActive = false;
			focusLost();
			toolbarViewer.setInput(getCurrentInput());
		}
	}

	private boolean doOpen(ISelection selection) {
		if (!(selection instanceof StructuredSelection)) return false;

		StructuredSelection structuredSelection = (StructuredSelection) selection;
		if (structuredSelection.isEmpty()) return false;

		return open(structuredSelection.getFirstElement());
	}

	private boolean doReveal(ISelection selection) {
		if (!(selection instanceof StructuredSelection)) return false;

		StructuredSelection structuredSelection = (StructuredSelection) selection;
		if (structuredSelection.isEmpty()) return false;

		if (fOldTextSelection != null) {
			getTextEditor().getSelectionProvider().setSelection(fOldTextSelection);

			boolean result = reveal(structuredSelection.getFirstElement());

			fOldTextSelection = getTextEditor().getSelectionProvider().getSelection();
			getTextEditor().getSelectionProvider().setSelection(new StructuredSelection(this));
			return result;
		} else {
			return reveal(structuredSelection.getFirstElement());
		}
	}

	/**
	 * Focus has been transfered into the toolbar.
	 */
	private void focusGained() {
		if (fHasFocus) focusLost();

		fComposite.setBackground(JFaceResources.getColorRegistry().get(ACTIVE_TAB_BG_END));
		fHasFocus = true;

		installDisplayListeners();

		activateEditorToolbar();

		getTextEditor().getEditorSite().getActionBars().updateActionBars();

		fOldTextSelection = getTextEditor().getSelectionProvider().getSelection();

		getTextEditor().getSelectionProvider().setSelection(new StructuredSelection(this));
	}

	/**
	 * Focus has been revoked from the toolbar.
	 */
	private void focusLost() {
		if (!fHasFocus) return;

		fComposite.setBackground(null);
		fHasFocus = false;

		deinstallDisplayListeners();

		deactivateEditorToolbar();

		getTextEditor().getEditorSite().getActionBars().updateActionBars();

		getTextEditor().getSelectionProvider().setSelection(fOldTextSelection);
		fOldTextSelection = null;
	}

	/**
	 * Installs all display listeners.
	 */
	private void installDisplayListeners() {
		// Sanity check
		deinstallDisplayListeners();

		fDisplayKeyListener = event -> {
			if (event.keyCode != SWT.ESC) return;

			if (!isEditorToolbarEvent(event)) return;

			viewer.getTextWidget().setFocus();
		};
		Display.getDefault().addFilter(SWT.KeyDown, fDisplayKeyListener);
	}

	/**
	 * Removes all previously installed display listeners.
	 */
	private void deinstallDisplayListeners() {
		if (fDisplayKeyListener != null) {
			Display.getDefault().removeFilter(SWT.KeyDown, fDisplayKeyListener);
			fDisplayKeyListener = null;
		}
	}

	/**
	 * Tells whether the given event was issued inside the toolbar viewer's control.
	 *
	 * @param event the event to inspect
	 * @return {@code true} if event was generated by a toolbar child
	 */
	private boolean isEditorToolbarEvent(Event event) {
		if (toolbarViewer == null) return false;

		Widget item = event.widget;
		if (!(item instanceof Control)) return false;

		// Shell dropDownShell = toolbarViewer.getDropDownShell();
		// if (dropDownShell != null && isChild((Control) item, dropDownShell)) return
		// true;

		return isChild((Control) item, toolbarViewer.getControl());
	}

	private boolean isChild(Control child, Control parent) {
		if (child == null) return false;

		if (child == parent) return true;

		return isChild(child.getParent(), parent);
	}

	/**
	 * Sets the text editor for which this toolbar is.
	 *
	 * @param editor the text editor to be used
	 */
	protected void setTextEditor(ITextEditor editor) {
		this.editor = editor;
		if (editor == null) return;

		fPartListener = new PartAdaptor() {

			@Override
			public void partActivated(IWorkbenchPart part) {
				if (part == editor && fHasFocus) {
					// focus-in event comes before part activation and the
					// workbench activates the editor -> reactivate the toolbar
					// if it is the active part.
					focusGained();
				}
			}

			@Override
			public void partDeactivated(IWorkbenchPart part) {
				if (part == editor && fHasFocus) {
					focusLost();
				}
			}
		};
		editor.getSite().getPage().addPartListener(fPartListener);
	}

	/**
	 * This toolbar's text editor.
	 *
	 * @return the text editor
	 */
	protected ITextEditor getTextEditor() {
		return editor;
	}
}
