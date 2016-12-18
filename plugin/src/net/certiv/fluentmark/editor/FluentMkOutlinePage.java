package net.certiv.fluentmark.editor;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.preference.IPreferenceStore;
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
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.actions.ActionContext;
import org.eclipse.ui.actions.ActionGroup;
import org.eclipse.ui.navigator.ICommonMenuConstants;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.part.IShowInSource;
import org.eclipse.ui.part.IShowInTarget;
import org.eclipse.ui.part.ShowInContext;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;

import net.certiv.fluentmark.Log;
import net.certiv.fluentmark.FluentMkUI;
import net.certiv.fluentmark.actions.CollapseAllAction;
import net.certiv.fluentmark.actions.CompositeActionGroup;
import net.certiv.fluentmark.actions.CopyToClipboardAction;
import net.certiv.fluentmark.actions.ExpandAllAction;
import net.certiv.fluentmark.actions.OpenViewActionGroup;
import net.certiv.fluentmark.actions.ToggleLinkingAction;
import net.certiv.fluentmark.model.ElementChangedEvent;
import net.certiv.fluentmark.model.IElement;
import net.certiv.fluentmark.model.IElementChangedListener;
import net.certiv.fluentmark.model.IParent;
import net.certiv.fluentmark.model.ISourceRange;
import net.certiv.fluentmark.model.Kind;
import net.certiv.fluentmark.model.PagePart;
import net.certiv.fluentmark.model.PageRoot;
import net.certiv.fluentmark.preferences.Prefs;
import net.certiv.fluentmark.providers.OutlineLabelProvider;

/**
 * The content outline page of the Fluent editor. Publishes its context menu under
 * <code>FluentMkUI.getDefault().getPluginId() + ".outline"</code>.
 */
public class FluentMkOutlinePage extends ContentOutlinePage implements IShowInSource, IShowInTarget {

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
				if (child.getKind() != Kind.BLANK) {
					filtered.add(child);
				}
			}
			return filtered.toArray(new IElement[filtered.size()]);
		}

		@Override
		public Object[] getChildren(Object parent) {
			if (parent instanceof IParent) {
				IParent p = (IParent) parent;
				try {
					return filter(p.getChildren());
				} catch (CoreException e) {}
			}
			return FluentMkOutlinePage.NO_CHILDREN;
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
				try {
					IElement[] children = filter(c.getChildren());
					return children != null && children.length > 0;
				} catch (CoreException e) {}
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

	/**
	 * The model change listener to update the outline viewer.
	 */
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
							FluentMkOutlinePage.this.setInput((PageRoot) e.getDelta());
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
		 * Investigates the given element change event and if affected incrementally updates the
		 * outline.
		 *
		 * @param delta the Dsl element delta used to reconcile the Dsl outline
		 */
		public void reconcile(PagePart delta) {
			refresh(true);
		}
	}

	static Object[] NO_CHILDREN = new Object[0];

	private PageRoot input;
	private Menu menu;
	protected OutlineViewer viewer;

	private FluentMkEditor editor;
	protected IPreferenceStore store;

	private IPropertyChangeListener fPropertyChangeListener;

	private Hashtable<String, IAction> fActions = new Hashtable<>();
	private CompositeActionGroup fActionGroups;
	private IAction expandAllAction;
	private IAction collapseAllAction;
	private IAction toggleLinkingAction;
	private IAction copyToClipboardAction;

	// private DslViewerDropSupport dropSupport;

	public FluentMkOutlinePage(FluentMkEditor editor, IPreferenceStore store) {
		super();
		Assert.isNotNull(editor);
		this.editor = editor;
		this.store = store;

		fPropertyChangeListener = new IPropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent event) {
				Log.error("preference store changed: " + event.getProperty());
				doPropertyChange(event);
			}
		};
		this.store.addPropertyChangeListener(fPropertyChangeListener);
	}

	@Override
	public void createControl(Composite parent) {
		Tree tree = new Tree(parent, SWT.MULTI);
		viewer = new OutlineViewer(tree);
		viewer.setContentProvider(new ChildrenProvider());
		viewer.setLabelProvider(new OutlineLabelProvider());
		viewer.setUseHashlookup(true);
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

		createToolTip();
		createActionControls(tree);
		// initDragAndDrop();
	}

	private void createActionControls(Tree tree) {
		String outlineId = FluentMkUI.PLUGIN_ID + ".outline";
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

		fActionGroups = new CompositeActionGroup(new ActionGroup[] { new OpenViewActionGroup(this) });
		toggleLinkingAction = new ToggleLinkingAction(editor);
		collapseAllAction = new CollapseAllAction(viewer);
		expandAllAction = new ExpandAllAction(viewer);
		copyToClipboardAction = new CopyToClipboardAction(viewer);

		createToolBar();
	}

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

		mgr.appendToGroup(ICommonMenuConstants.GROUP_SHOW, toggleLinkingAction);
		mgr.appendToGroup(ICommonMenuConstants.GROUP_VIEWER_SETUP, expandAllAction);
		mgr.appendToGroup(ICommonMenuConstants.GROUP_VIEWER_SETUP, collapseAllAction);

		mgr.update(false);
	}

	protected void contextMenuAboutToShow(IMenuManager mgr) {
		if (mgr.isEmpty()) {
			mgr.add(new GroupMarker(ICommonMenuConstants.GROUP_GOTO));
			mgr.add(new Separator(ICommonMenuConstants.GROUP_EDIT));
			mgr.add(new Separator(ICommonMenuConstants.GROUP_ADDITIONS));
			mgr.add(new Separator(ICommonMenuConstants.GROUP_PROPERTIES));

			mgr.appendToGroup(ICommonMenuConstants.GROUP_EDIT, copyToClipboardAction);
		}

		fActionGroups.setContext(new ActionContext(getSite().getSelectionProvider().getSelection()));
		fActionGroups.fillContextMenu(mgr);
	}

	public void setInput(PageRoot inputElement) {
		input = inputElement;
		if (viewer != null) {
			Object[] expandedElements = viewer.getExpandedElements();
			TreePath[] expandedTreePaths = viewer.getExpandedTreePaths();

			viewer.setInput(input);

			viewer.setExpandedElements(expandedElements);
			viewer.setExpandedTreePaths(expandedTreePaths);
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

		if (fActionGroups != null) {
			fActionGroups.dispose();
		}

		viewer = null;

		super.dispose();
	}

	@Override
	public void setFocus() {
		if (viewer != null) {
			viewer.getControl().setFocus();
		}
	}

	public void setAction(String actionID, IAction action) {
		Assert.isNotNull(actionID);
		if (action == null) {
			fActions.remove(actionID);
		} else {
			fActions.put(actionID, action);
		}
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
	protected final OutlineViewer getOutlineViewer() {
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

	// private void initDragAndDrop() {
	// dropSupport = new DslViewerDropSupport(dslUI, viewer);
	// dropSupport.start();
	//
	// new DslViewerDragSupport(viewer).start();
	// }
}
