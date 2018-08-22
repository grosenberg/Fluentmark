/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.outline;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IOpenListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.jface.viewers.OpenEvent;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.ToolTip;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.actions.ActionContext;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionGroup;
import org.eclipse.ui.navigator.ICommonMenuConstants;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.part.IShowInSource;
import org.eclipse.ui.part.IShowInTarget;
import org.eclipse.ui.part.ShowInContext;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;

import net.certiv.fluentmark.FluentUI;
import net.certiv.fluentmark.actions.CollapseAllAction;
import net.certiv.fluentmark.actions.CompositeActionGroup;
import net.certiv.fluentmark.actions.ExpandAllAction;
import net.certiv.fluentmark.actions.OpenViewActionGroup;
import net.certiv.fluentmark.actions.ToggleLinkingAction;
import net.certiv.fluentmark.editor.FluentEditor;
import net.certiv.fluentmark.editor.ISourceReference;
import net.certiv.fluentmark.model.ElementChangedEvent;
import net.certiv.fluentmark.model.IElement;
import net.certiv.fluentmark.model.IElementChangedListener;
import net.certiv.fluentmark.model.IParent;
import net.certiv.fluentmark.model.ISourceRange;
import net.certiv.fluentmark.model.PagePart;
import net.certiv.fluentmark.model.PageRoot;
import net.certiv.fluentmark.model.Type;
import net.certiv.fluentmark.outline.dnd.DndConfigurationStrategy;
import net.certiv.fluentmark.preferences.Prefs;

/**
 * The content outline page of the Fluent editor. Publishes its context menu under
 * <code>FluentUI.getDefault().getPluginId() + ".outline"</code>.
 */
public class FluentOutlinePage extends ContentOutlinePage implements IShowInSource, IShowInTarget {

	/**
	 * Content provider for the children of a PageRoot
	 *
	 * @see ITreeContentProvider
	 */
	protected class ChildrenProvider implements ITreeContentProvider {

		private ElementChangedListener listener;

		@Override
		public void dispose() {
			if (listener != null) {
				editor.getPageModel().removeElementChangedListener(listener);
				listener = null;
			}
		}

		protected IElement[] filter(IElement[] children) {
			if (store.getBoolean(Prefs.EDITOR_OUTLINE_SHOW_BLANKLINES)) return children;

			List<IElement> filtered = new ArrayList<>();
			for (IElement child : children) {
				if (child.getKind() != Type.BLANK) {
					filtered.add(child);
				}
			}
			return filtered.toArray(new IElement[filtered.size()]);
		}

		@Override
		public Object[] getChildren(Object parent) {
			if (parent instanceof IParent) {
				IParent p = (IParent) parent;
				return filter(p.getChildren());
			}
			return FluentOutlinePage.NO_CHILDREN;
		}

		@Override
		public Object[] getElements(Object parent) {
			return getChildren(parent);
		}

		@Override
		public Object getParent(Object child) {
			if (child instanceof PagePart) {
				PagePart e = (PagePart) child;
				return e.getParent();
			}
			return null;
		}

		@Override
		public boolean hasChildren(Object parent) {
			if (parent instanceof IParent) {
				IParent c = (IParent) parent;
				IElement[] children = filter(c.getChildren());
				return children != null && children.length > 0;
			}
			return false;
		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			boolean isPage = newInput instanceof PageRoot;

			if (isPage && listener == null) {
				listener = new ElementChangedListener();
				editor.getPageModel().addElementChangedListener(listener);
			} else if (!isPage && listener != null) {
				editor.getPageModel().removeElementChangedListener(listener);
				listener = null;
			}
		}

		public boolean isDeleted(Object o) {
			return false;
		}
	}

	/** The model change listener to update the outline viewer. */
	protected class ElementChangedListener implements IElementChangedListener {

		@Override
		public void elementChanged(final ElementChangedEvent e) {
			if (getControl() == null) return;

			Display display = getControl().getDisplay();
			if (display != null) {
				display.asyncExec(new Runnable() {

					@Override
					public void run() {
						if (viewer != null) {
							FluentOutlinePage.this.setInput((PageRoot) e.getDelta());
						}
					}
				});
			}
		}
	}

	/**
	 * The tree viewer used for displaying the outline.
	 *
	 * @see TreeViewer
	 */
	public static class OutlineViewer extends TreeViewer {

		public OutlineViewer(Tree tree) {
			super(tree);
			setAutoExpandLevel(ALL_LEVELS);
			setUseHashlookup(true);
		}

		protected boolean filtered(PagePart parent, PagePart child) {
			Object[] result = new Object[] { child };
			ViewerFilter[] filters = getFilters();
			for (ViewerFilter filter : filters) {
				result = filter.filter(this, parent, result);
				if (result.length == 0) return true;
			}
			return false;
		}

		protected ISourceRange getSourceRange(PagePart element) throws CoreException {
			if (element instanceof ISourceReference) {
				return ((ISourceReference) element).getSourceRange();
			}
			return null;
		}

		private IResource getUnderlyingResource() {
			PageRoot input = (PageRoot) getInput();
			return input.getResource();
		}

		@Override
		protected void handleLabelProviderChanged(LabelProviderChangedEvent event) {
			// Object input = getInput();
			// if (event instanceof ProblemsLabelChangedEvent) {
			// ProblemsLabelChangedEvent e = (ProblemsLabelChangedEvent) event;
			// if (e.isMarkerChange() && input instanceof PageRoot) {
			// return; // marker changes can be ignored
			// }
			// }
			// look if the underlying resource changed
			Object[] changed = event.getElements();
			if (changed != null) {
				IResource resource = getUnderlyingResource();
				if (resource != null) {
					for (Object element : changed) {
						if (element != null && element.equals(resource)) {
							// change event to a full refresh
							event = new LabelProviderChangedEvent((IBaseLabelProvider) event.getSource());
							break;
						}
					}
				}
			}
			super.handleLabelProviderChanged(event);
		}

		@Override
		public boolean isExpandable(Object element) {
			if (hasFilters()) {
				return getFilteredChildren(element).length > 0;
			}
			return super.isExpandable(element);
		}

		/**
		 * Investigates the given element change event and if affected incrementally updates the outline.
		 *
		 * @param delta the Dsl element delta used to reconcile the Dsl outline
		 */
		public void reconcile(PagePart delta) {
			refresh(true);
		}
	}

	private static final String ACTION_EXPAND = "expand";
	private static final String ACTION_COLLAPSE = "collapse";
	private static final String ACTION_TOGGLE = "toggle";
	private static final String ACTION_COPY = "copy";
	private static final String ACTION_CUT = "cut";
	private static final String ACTION_PASTE = "paste";
	private static final String ACTION_DELETE = "delete";

	static Object[] NO_CHILDREN = new Object[0];

	private PageRoot input;
	private Menu menu;
	protected OutlineViewer viewer;

	private FluentEditor editor;
	protected IPreferenceStore store;

	private IPropertyChangeListener fPropertyChangeListener;
	private Clipboard clipboard;

	private CompositeActionGroup actionGroups;
	private Hashtable<String, Action> actions = new Hashtable<>();
	private DndConfigurationStrategy dndStrategy;

	public FluentOutlinePage(FluentEditor editor, IPreferenceStore store) {
		super();
		Assert.isNotNull(editor);
		this.editor = editor;
		this.store = store;

		fPropertyChangeListener = new IPropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent event) {
				// Log.error("preference store changed: " + event.getProperty());
				doPropertyChange(event);
			}
		};
		this.store.addPropertyChangeListener(fPropertyChangeListener);
	}

	public FluentEditor getEditor() {
		return editor;
	}

	@Override
	public void createControl(Composite parent) {
		Tree tree = new Tree(parent, SWT.MULTI);
		viewer = new OutlineViewer(tree);
		viewer.setContentProvider(new ChildrenProvider());
		viewer.setLabelProvider(new FluentOutlineLabelProvider());
		viewer.setInput(input);

		viewer.addOpenListener(new IOpenListener() {

			@Override
			public void open(OpenEvent event) {
				revealInEditor(event.getSelection());
			}
		});

		viewer.addPostSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				revealInEditor(event.getSelection());
			}
		});

		viewer.expandAll();

		// createToolTip();
		createActionControls(tree);
		initDragAndDrop();
		initCopyPaste();
	}

	private void createActionControls(Tree tree) {
		String outlineId = FluentUI.PLUGIN_ID + ".outline";
		MenuManager menuMgr = new MenuManager(outlineId, outlineId);
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {

			@Override
			public void menuAboutToShow(IMenuManager m) {
				contextMenuAboutToShow(m);
			}
		});
		menu = menuMgr.createContextMenu(tree);
		tree.setMenu(menu);

		IPageSite site = getSite();
		site.registerContextMenu(outlineId, menuMgr, viewer); // $NON-NLS-1$
		site.setSelectionProvider(viewer);

		actionGroups = new CompositeActionGroup(new ActionGroup[] { new OpenViewActionGroup(this) });

		setAction(ACTION_EXPAND, new ExpandAllAction(viewer));
		setAction(ACTION_COLLAPSE, new CollapseAllAction(viewer));
		setAction(ACTION_TOGGLE, new ToggleLinkingAction(editor));

		setAction(ACTION_COPY, new OutlineCopyAction(this));
		setAction(ACTION_CUT, new OutlineCutAction(this));
		setAction(ACTION_PASTE, new OutlinePasteAction(this));
		setAction(ACTION_DELETE, new OutlineDeleteAction(this));

		createToolBar();
	}

	@SuppressWarnings("unused")
	private void createToolTip() {
		new ToolTip(viewer.getControl(), ToolTip.RECREATE, false) {

			@Override
			protected Composite createToolTipContentArea(Event event, Composite parent) {

				Composite comp = new Composite(parent, SWT.NONE);
				comp.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_INFO_BACKGROUND));
				GridLayoutFactory.swtDefaults().margins(2, 2).spacing(4, 1).applyTo(comp);

				Object tipItem = getToolTipItem(new Point(event.x, event.y));
				if (tipItem instanceof PagePart) {
					PagePart part = (PagePart) tipItem;
					Label label = new Label(comp, SWT.WRAP);
					label.setBackground(comp.getBackground());
					label.setText(part.getTooltip());
				}
				return comp;
			}

			@Override
			protected boolean shouldCreateToolTip(Event event) {
				final Object eventItem = getToolTipItem(new Point(event.x, event.y));
				boolean shouldCreate = eventItem != null && eventItem instanceof PagePart
						&& super.shouldCreateToolTip(event);
				if (!shouldCreate) hide();
				return shouldCreate;
			}

			protected Object getToolTipItem(Point point) {
				Tree control = (Tree) viewer.getControl();
				TreeItem item = control.getItem(point);
				if (item != null) return item.getData();
				return null;
			}
		};
	}

	private void createToolBar() {
		IToolBarManager mgr = getSite().getActionBars().getToolBarManager();
		mgr.removeAll();

		mgr.add(new Separator(ICommonMenuConstants.GROUP_SHOW));
		mgr.add(new Separator(ICommonMenuConstants.GROUP_ADDITIONS));
		mgr.add(new Separator(ICommonMenuConstants.GROUP_VIEWER_SETUP));

		mgr.appendToGroup(ICommonMenuConstants.GROUP_SHOW, actions.get(ACTION_TOGGLE));
		mgr.appendToGroup(ICommonMenuConstants.GROUP_VIEWER_SETUP, actions.get(ACTION_EXPAND));
		mgr.appendToGroup(ICommonMenuConstants.GROUP_VIEWER_SETUP, actions.get(ACTION_COLLAPSE));

		mgr.update(false);
	}

	protected void contextMenuAboutToShow(IMenuManager mgr) {
		if (mgr.isEmpty()) {
			mgr.add(new GroupMarker(ICommonMenuConstants.GROUP_GOTO));
			mgr.add(new Separator(ICommonMenuConstants.GROUP_EDIT));
			mgr.add(new Separator(ICommonMenuConstants.GROUP_ADDITIONS));
			mgr.add(new Separator(ICommonMenuConstants.GROUP_PROPERTIES));

			mgr.appendToGroup(ICommonMenuConstants.GROUP_EDIT, actions.get(ACTION_COPY));
			mgr.appendToGroup(ICommonMenuConstants.GROUP_EDIT, actions.get(ACTION_CUT));
			mgr.appendToGroup(ICommonMenuConstants.GROUP_EDIT, actions.get(ACTION_PASTE));
			mgr.appendToGroup(ICommonMenuConstants.GROUP_EDIT, actions.get(ACTION_DELETE));
		}

		actionGroups.setContext(new ActionContext(getSite().getSelectionProvider().getSelection()));
		actionGroups.fillContextMenu(mgr);
	}

	public void setInput(PageRoot inputElement) {
		input = inputElement;
		if (viewer != null) {
			Object[] expandedElements = viewer.getExpandedElements();
			TreePath[] expandedTreePaths = viewer.getExpandedTreePaths();

			viewer.setInput(input);

			viewer.setExpandedElements(expandedElements);
			viewer.setExpandedTreePaths(expandedTreePaths);

			actions.get(ACTION_COPY).setEnabled(true);
			actions.get(ACTION_CUT).setEnabled(true);
			actions.get(ACTION_PASTE).setEnabled(true);
			actions.get(ACTION_DELETE).setEnabled(true);
		}
	}

	@Override
	public void dispose() {
		if (editor == null) return;
		editor.outlinePageClosed();
		editor = null;
		if (fPropertyChangeListener != null) {
			store.removePropertyChangeListener(fPropertyChangeListener);
			fPropertyChangeListener = null;
		}

		if (menu != null && !menu.isDisposed()) {
			menu.dispose();
			menu = null;
		}

		if (actionGroups != null) {
			actionGroups.dispose();
		}

		this.clipboard.dispose();
		this.clipboard = null;
		viewer = null;
		super.dispose();
	}

	@Override
	public void setFocus() {
		if (viewer != null) {
			viewer.getControl().setFocus();
		}
	}

	public void setAction(String id, Action action) {
		Assert.isNotNull(id);
		if (action == null) {
			actions.remove(id);
		} else {
			actions.put(id, action);
		}
	}

	/**
	 * Gets the clipboard. Used by copy paste actions.
	 *
	 * @return the clipboard associated with this outline
	 */
	public Clipboard getClipboard() {
		return this.clipboard;
	}

	@Override
	public Control getControl() {
		if (viewer != null) {
			return viewer.getControl();
		}
		return null;
	}

	/**
	 * Returns the <code>OutlineViewer</code> of this view.
	 */
	@Override
	protected OutlineViewer getTreeViewer() {
		return viewer;
	}

	@Override
	public ISelection getSelection() {
		if (viewer == null) return StructuredSelection.EMPTY;
		return viewer.getSelection();
	}

	@Override
	public void setSelection(ISelection selection) {
		if (viewer != null) {
			viewer.setSelection(selection);
		}
	}

	@Override
	public ShowInContext getShowInContext() {
		return editor.getShowInContext();
	}

	@Override
	public boolean show(ShowInContext context) {
		return editor.show(context);
	}

	private void doPropertyChange(PropertyChangeEvent event) {
		if (viewer != null) {
			viewer.refresh(false);
		}
	}

	public void select(ISourceReference reference) {
		if (viewer != null) {
			ISelection sel = viewer.getSelection();
			if (sel instanceof IStructuredSelection) {
				IStructuredSelection ssel = (IStructuredSelection) sel;
				List<?> elements = ssel.toList();
				if (!elements.contains(reference)) {
					sel = reference == null ? StructuredSelection.EMPTY : new StructuredSelection(reference);
					viewer.setSelection(sel, true);
				}
			}
		}
	}

	private void revealInEditor(ISelection sel) {
		if (sel instanceof IStructuredSelection) {
			IStructuredSelection ssel = (IStructuredSelection) sel;
			Object element = ssel.getFirstElement();
			if (element instanceof PagePart) {
				PagePart part = (PagePart) element;
				editor.revealPart(part);
			}
		}
	}

	/**
	 * Gets the text of the currently selected item. Use by copy paste and drag'n'drop operations.
	 *
	 * @return text of the currently selected item or null if no item is selected.
	 */
	public String getSelectedText() {
		IStructuredSelection selection = (IStructuredSelection) getTreeViewer().getSelection();
		if (selection == null) return null;

		PagePart part = (PagePart) selection.getFirstElement();
		ISourceRange range = part.getSourceRange();

		try {
			return editor.getDocument().get(range.getOffset(), range.getLength());
		} catch (BadLocationException e) {}
		return null;
	}

	/**
	 * Pastes given text after the selected item. Used by the paste action.
	 *
	 * @param text the text to be pasted
	 * @return true if pasting was succesful, otherwise false
	 */
	public boolean paste(String text) {
		IStructuredSelection selection = (IStructuredSelection) getTreeViewer().getSelection();
		if (selection == null) return false;

		PagePart part = (PagePart) selection.getFirstElement();
		ISourceRange range = part.getSourceRange();

		try {
			editor.getDocument().replace(range.getOffset() + range.getLength(), 0, text);
		} catch (BadLocationException e) {
			return false;
		}
		return true;
	}

	/**
	 * Removes the text of the currently selected item From the document. Used by copy paste and
	 * drag'n'drop operations.
	 */
	public void removeSelectedText() {
		IStructuredSelection selection = (IStructuredSelection) getTreeViewer().getSelection();
		if (selection == null) return;

		PagePart part = (PagePart) selection.getFirstElement();
		ISourceRange range = part.getSourceRange();

		try {
			editor.getDocument().replace(range.getOffset(), range.getLength(), "");
		} catch (BadLocationException e) {}
	}

	private void initDragAndDrop() {
		dndStrategy = new DndConfigurationStrategy();
		dndStrategy.configure(editor, getControl(), getTreeViewer());
	}

	private void initCopyPaste() {
		this.clipboard = new Clipboard(getSite().getShell().getDisplay());
		IActionBars bars = getSite().getActionBars();
		bars.setGlobalActionHandler(ActionFactory.CUT.getId(), actions.get(ACTION_CUT));
		bars.setGlobalActionHandler(ActionFactory.COPY.getId(), actions.get(ACTION_COPY));
		bars.setGlobalActionHandler(ActionFactory.PASTE.getId(), actions.get(ACTION_PASTE));
		bars.setGlobalActionHandler(ActionFactory.DELETE.getId(), actions.get(ACTION_DELETE));
	}
}
