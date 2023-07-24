package net.certiv.fluent.dt.ui.editor.toolbar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.NotEnabledException;
import org.eclipse.core.commands.NotHandledException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreePathContentProvider;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.OpenEvent;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.MenuDetectEvent;
import org.eclipse.swt.events.MenuDetectListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.handlers.IHandlerService;

import net.certiv.common.log.Log;

/**
 * An in-editor toolbar viewer capable of showing a set of toolbar buttons allowing
 * invocation of existing handlers associated with the editor.
 * <p>
 * Set the editor as the input to allow editor selection events to affect the selected
 * state of the toolbar items.
 *
 * @see JavaEditor#showBreadcrumb
 */
public abstract class EditorToolbarViewer extends StructuredViewer {

	private static final boolean IS_GTK = "gtk".equals(SWT.getPlatform()); //$NON-NLS-1$

	private final int style;
	private final ToolBar toolbar;
	private final ICommandService cmds;
	private final IHandlerService hdlr;

	/**
	 * Create a new <code>ToolbarViewer</code>.
	 * <p>
	 * Style is one of:
	 * <ul>
	 * <li>SWT.NONE</li>
	 * <li>SWT.VERTICAL</li>
	 * <li>SWT.HORIZONTAL</li>
	 * <li>SWT.BOTTOM</li>
	 * <li>SWT.RIGHT</li>
	 * </ul>
	 *
	 * @param site
	 * @param parent the parent container for this viewer
	 * @param style  the style flag used for this viewer
	 */
	public EditorToolbarViewer(IWorkbenchPartSite site, Composite parent, int style) {
		this.style = style;
		this.toolbar = new ToolBar(parent, style | SWT.FLAT);

		cmds = site.getService(ICommandService.class);
		hdlr = site.getService(IHandlerService.class);

		hookControl(toolbar);
	}

	protected void createCheckItem(IToolbarItemDef def) {
		ToolItem item = new ToolItem(getControl(), SWT.CHECK);
		item.setImage(def.img());
		item.setToolTipText(def.tip());
		item.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				handle(def);
			}
		});
	}

	private Object handle(IToolbarItemDef def) {
		Command cmd = cmds.getCommand(def.id());
		ExecutionEvent event = hdlr.createExecutionEvent(cmd, new Event());
		try {
			cmd.executeWithChecks(event);
		} catch (ExecutionException | NotDefinedException | NotEnabledException | NotHandledException e) {
			Log.debug("Handler failure for %s[%s] %s", def.tip(), def.id(), e.getMessage());
		}
		return null;
	}

	int getStyle() {
		return style;
	}

	@Override
	public ToolBar getControl() {
		return toolbar;
	}

	@Override
	public void reveal(Object element) {}

	@Override
	protected void assertContentProviderType(IContentProvider provider) {
		super.assertContentProviderType(provider);
	}

	@Override
	protected void inputChanged(final Object input, Object prior) {
		if (toolbar.isDisposed()) return;

		disableRedraw();
		try {
			preservingSelection(() -> buildItemChain(input));
		} finally {
			enableRedraw();
		}
	}

	@Override
	protected Widget doFindInputItem(Object element) {
		if (element == null) return null;

		if (element == getInput() || element.equals(getInput())) {
			return doFindItem(element);
		}
		return null;
	}

	@Override
	protected Widget doFindItem(Object element) {
		if (element == null) return null;

		for (ToolItem item : toolItems) {
			if (item.getData() == element || element.equals(item.getData())) {
				return item;
			}
		}
		return null;
	}

	@Override
	protected void doUpdateItem(Widget widget, Object element, boolean fullMap) {
		myDoUpdateItem(widget, element, fullMap);
	}

	private boolean myDoUpdateItem(Widget widget, Object element, boolean fullMap) {
		if (widget instanceof ToolItem) {
			final ToolItem item = (ToolItem) widget;

			// remember element we are showing
			if (fullMap) {
				associate(element, item);
			} else {
				Object data = item.getData();
				if (data != null) {
					unmapElement(data, item);
				}
				item.setData(element);
				mapElement(element, item);
			}

			refreshItem(item);
		}
		return false;
	}

	/**
	 * This implementation of getSelection() returns an instance of ITreeSelection.
	 *
	 * @return the current selection
	 */
	@Override
	public ISelection getSelection() {
		Control control = getControl();
		if (control == null || control.isDisposed()) {
			return TreeSelection.EMPTY;
		}
		if (fSelectedItem != null) {
			TreePath path = getTreePathFromItem(fSelectedItem);
			if (path != null) {
				return new TreeSelection(new TreePath[] { path });
			}
		}
		return TreeSelection.EMPTY;
	}

	protected TreePath getTreePathFromItem(ToolItem item) {
		List<Object> elements = new ArrayList<>(toolItems.size());
		for (ToolItem currItem : toolItems) {
			elements.add(currItem.getData());
			if (currItem.equals(item)) {
				return new TreePath(elements.toArray());
			}
		}
		return null;
	}

	@Override
	protected List getSelectionFromWidget() {
		if (fSelectedItem == null) {
			return Collections.EMPTY_LIST;
		}

		if (fSelectedItem.getData() == null) {
			return Collections.EMPTY_LIST;
		}

		ArrayList<Object> result = new ArrayList<>();
		result.add(fSelectedItem.getData());
		return result;
	}

	@Override
	protected void internalRefresh(Object element) {

		disableRedraw();
		try {
			boolean layoutChanged = false;

			ToolItem item = (ToolItem) doFindItem(element);
			if (item == null || element != null && element.equals(getInput())) {
				for (ToolItem currItem : toolItems) {
					layoutChanged = refreshItem(currItem) || layoutChanged;
				}
			} else {
				layoutChanged = refreshItem(item) || layoutChanged;
			}

			if (layoutChanged) {
				updateSize();
				toolbar.layout(true, true);
			}
		} finally {
			enableRedraw();
		}
	}

	@Override
	protected void setSelectionToWidget(List l, boolean reveal) {
		ToolItem focusItem = null;

		// Unselect the currently selected items, and remember the focused item.
		for (ToolItem item : toolItems) {
			if (item.hasFocus()) {
				focusItem = item;
			}

			item.setSelected(false);
		}

		if (l == null) {
			l = Collections.EMPTY_LIST;
		}

		// Set the new selection to items.
		fSelectedItem = null;
		for (Iterator<Object> iterator = l.iterator(); iterator.hasNext();) {
			Object element = iterator.next();
			ToolItem item = (ToolItem) doFindItem(element);
			if (item != null) {
				item.setSelected(true);
				fSelectedItem = item;
				if (item == focusItem) {
					focusItem = null;
				}
			}
		}

		// If there is a new selection, and it does not overlap the old selection,
		// remove the focus marker from the old focus item.
		if (fSelectedItem != null && focusItem != null) {
			focusItem.setFocus(false);
		}
	}

	/**
	 * Set a single selection to the given item. <code>null</code> to deselect all.
	 *
	 * @param item the item to select or <code>null</code>
	 */
	void selectItem(ToolItem item) {
		if (fSelectedItem != null) {
			fSelectedItem.setSelected(false);
		}

		fSelectedItem = item;
		setSelectionToWidget(getSelection(), false);
		setFocus();

		fireSelectionChanged(new SelectionChangedEvent(this, getSelection()));
	}

	/**
	 * Returns the item count.
	 *
	 * @return number of items shown in the viewer
	 */
	int getItemCount() {
		return toolItems.size();
	}

	/**
	 * Returns the item for the given item index.
	 *
	 * @param index the index of the item
	 * @return the item ad the given <code>index</code>
	 */
	ToolItem getItem(int index) {
		return toolItems.get(index);
	}

	/**
	 * Returns the index of the given item.
	 *
	 * @param item the item to search
	 * @return the index of the item or -1 if not found
	 */
	int getIndexOfItem(ToolItem item) {
		for (int i = 0, size = toolItems.size(); i < size; i++) {
			ToolItem pItem = toolItems.get(i);
			if (pItem == item) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * Notifies all double click listeners.
	 */
	void fireDoubleClick() {
		fireDoubleClick(new DoubleClickEvent(this, getSelection()));
	}

	/**
	 * Notifies all open listeners.
	 */
	void fireOpen() {
		fireOpen(new OpenEvent(this, getSelection()));
	}

	/**
	 * The given element was selected from a drop down menu.
	 *
	 * @param selection the selected element
	 */
	void fireMenuSelection(ISelection selection) {
		fireOpen(new OpenEvent(this, selection));
	}

	/**
	 * A context menu has been requested for the selected breadcrumb item.
	 *
	 * @param event the event issued the menu detection
	 */
	void fireMenuDetect(MenuDetectEvent event) {
		for (MenuDetectListener menuDetectListener : fMenuListeners) {
			menuDetectListener.menuDetected(event);
		}
	}

	/**
	 * Set selection to the next or previous element if possible.
	 *
	 * @param next <code>true</code> if the next element should be selected, otherwise the
	 *             previous one will be selected
	 */
	void doTraverse(boolean next) {
		if (fSelectedItem == null) {
			return;
		}

		int index = toolItems.indexOf(fSelectedItem);
		if (next) {
			if (index == toolItems.size() - 1) {
				ToolItem current = toolItems.get(index);

				current.openDropDownMenu();
				current.getDropDownShell().setFocus();
			} else {
				ToolItem nextItem = toolItems.get(index + 1);
				selectItem(nextItem);
			}
		} else {
			if (index == 0) {
				ToolItem root = toolItems.get(index);
				root.openDropDownMenu();
				root.getDropDownShell().setFocus();
			} else {
				selectItem(toolItems.get(index - 1));
			}
		}
	}

	/**
	 * Generates the parent chain of the given element.
	 *
	 * @param input element to build the parent chain for
	 */
	private void buildItemChain(Object input) {
		if (toolItems.size() > 0) {
			ToolItem last = toolItems.get(toolItems.size() - 1);
			last.setIsLastItem(false);
		}

		int index = 0;
		boolean updateLayout = false;
		if (input != null) {
			ITreePathContentProvider contentProvider = (ITreePathContentProvider) getContentProvider();
			TreePath path = new TreePath(new Object[0]);

			// Top level elements need to be retrieved using getElements(), rest
			// using getChildren().
			Object[] children = contentProvider.getElements(input);
			Object element = children != null && children.length != 0 ? children[0] : null;
			while (element != null) {
				path = path.createChildPath(element);

				// All but last item are hidden if the viewer is in a vertical toolbar.
				children = contentProvider.getChildren(path);
				if ((getStyle() & SWT.VERTICAL) == 0 || children == null || children.length == 0) {
					updateLayout = updateOrCreateItem(index++, path, element) || updateLayout;
				}

				if (children != null && children.length != 0) {
					element = children[0];
				} else {
					break;
				}

			}
		}

		ToolItem last = null;
		if (index <= toolItems.size()) {
			last = (toolItems.get(index - 1));
			last.setIsLastItem(true);
		}

		while (index < toolItems.size()) {
			updateLayout = true;
			ToolItem item = toolItems.remove(toolItems.size() - 1);
			if (item.hasFocus() && last != null) {
				last.setFocus(true);
			}
			if (item == fSelectedItem) {
				selectItem(null);
			}
			if (item.getData() != null) {
				unmapElement(item.getData());
			}
			item.dispose();
		}

		if (updateLayout) {
			updateSize();
			toolbar.layout(true, true);
		}
	}

	/**
	 * @param item Item to refresh.
	 * @return returns whether the item's size and layout needs to be updated.
	 */
	private boolean refreshItem(ToolItem item) {
		boolean layoutChanged = false;

		TreePath path = getTreePathFromItem(item);

		ViewerLabel label = new ViewerLabel(item.getText(), item.getImage());
		((ITreePathLabelProvider) getLabelProvider()).updateLabel(label, path);

		if (label.hasNewText()) {
			item.setText(label.getText());
			layoutChanged = true;
		}
		if (label.hasNewImage()) {
			item.setImage(label.getImage());
			layoutChanged = true;
		}
		if (label.hasNewTooltipText()) {
			item.setToolTip(label.getTooltipText());
		}
		return layoutChanged;
	}

	/**
	 * Creates or updates a breadcrumb item.
	 *
	 * @param index   the index
	 * @param path    the path
	 * @param element the element
	 * @return whether breadcrumb layout needs to be updated due to this change
	 */
	private boolean updateOrCreateItem(int index, TreePath path, Object element) {
		ToolItem item;
		if (toolItems.size() > index) {
			item = toolItems.get(index);
			if (item.getData() != null) {
				unmapElement(item.getData());
			}
		} else {
			item = new ToolItem(this, toolbar);
			toolItems.add(item);
		}

		boolean updateLayout = false;

		if (equals(element, item.getData())) {
			item.setPath(path);
			updateLayout = myDoUpdateItem(item, element, false);
		} else {
			item.setData(element);
			item.setPath(path);
			mapElement(element, item);
			updateLayout = refreshItem(item);
		}

		return updateLayout;
	}

	/**
	 * Enables redrawing of the toolbar.
	 */
	private void enableRedraw() {
		if (IS_GTK) return;
		toolbar.setRedraw(true);
	}

	/**
	 * Disables redrawing of the breadcrumb.
	 * <p>
	 * <strong>A call to this method must be followed by a call to
	 * {@link #enableRedraw()}</strong>
	 */
	private void disableRedraw() {
		if (IS_GTK) return;
		toolbar.setRedraw(false);
	}

	@Override
	protected void handleDispose(DisposeEvent event) {
		if (toolItems != null) {
			for (ToolItem item : toolItems) {
				item.dispose();
			}
		}

		super.handleDispose(event);
	}

	@Override
	protected void handleDispose(DisposeEvent event) {
		if (toolItems != null) {
			for (ToolItem item : toolItems) {
				item.dispose();
			}
		}

		super.handleDispose(event);
	}

	/**
	 * Blends c1 and c2 based in the provided ratio.
	 *
	 * @param c1    first color
	 * @param c2    second color
	 * @param ratio percentage of the first color in the blend (0-100)
	 * @return the RGB value of the blended color
	 * @since 3.1
	 */
	public static RGB blend(RGB c1, RGB c2, int ratio) {
		int r = blend(c1.red, c2.red, ratio);
		int g = blend(c1.green, c2.green, ratio);
		int b = blend(c1.blue, c2.blue, ratio);
		return new RGB(r, g, b);
	}

	/**
	 * Blends two primary color components based on the provided ratio.
	 *
	 * @param v1    first component
	 * @param v2    second component
	 * @param ratio percentage of the first component in the blend
	 * @return the blended color
	 */
	private static int blend(int v1, int v2, int ratio) {
		int b = (ratio * v1 + (100 - ratio) * v2) / 100;
		return Math.min(255, b);
	}
}
