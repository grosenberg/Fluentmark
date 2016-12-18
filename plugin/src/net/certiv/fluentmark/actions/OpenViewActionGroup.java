package net.certiv.fluentmark.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchCommandConstants;
import org.eclipse.ui.IWorkbenchSite;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionGroup;
import org.eclipse.ui.actions.ContributionItemFactory;
import org.eclipse.ui.dialogs.PropertyDialogAction;
import org.eclipse.ui.navigator.ICommonMenuConstants;
import org.eclipse.ui.part.Page;

import net.certiv.fluentmark.editor.FluentMkEditor;

/**
 * Action group that adds actions to open a new JDT view part or an external viewer to a context
 * menu and the global menu bar.
 * <p>
 * This class may be instantiated; it is not intended to be subclassed.
 * </p>
 *
 * @since 2.0
 * @noextend This class is not intended to be subclassed by clients.
 */
public class OpenViewActionGroup extends ActionGroup {

	private boolean fEditorIsOwner;

	private PropertyDialogAction fOpenPropertiesDialog;

	private boolean fShowOpenPropertiesAction = true;
	// private boolean fShowShowInMenu = true;

	/**
	 * Creates a new <code>OpenActionGroup</code>. The group requires that the selection provided by
	 * the page's selection provider is of type {@link IStructuredSelection}.
	 *
	 * @param page the page that owns this action group
	 */
	public OpenViewActionGroup(Page page) {
		createSiteActions(page.getSite(), null);
	}

	/**
	 * Creates a new <code>OpenActionGroup</code>. The group requires that the selection provided by
	 * the given selection provider is of type {@link IStructuredSelection}.
	 *
	 * @param page the page that owns this action group
	 * @param selectionProvider the selection provider used instead of the page selection provider.
	 * @since 3.2
	 */
	public OpenViewActionGroup(Page page, ISelectionProvider selectionProvider) {
		createSiteActions(page.getSite(), selectionProvider);
	}

	/**
	 * Creates a new <code>OpenActionGroup</code>. The group requires that the selection provided by
	 * the part's selection provider is of type {@link IStructuredSelection}.
	 *
	 * @param part the view part that owns this action group
	 */
	public OpenViewActionGroup(IViewPart part) {
		this(part, null);
	}

	/**
	 * Creates a new <code>OpenActionGroup</code>. The group requires that the selection provided by
	 * the given selection provider is of type {@link IStructuredSelection}.
	 *
	 * @param part the view part that owns this action group
	 * @param selectionProvider the selection provider used instead of the page selection provider.
	 * @since 3.2
	 */
	public OpenViewActionGroup(IViewPart part, ISelectionProvider selectionProvider) {
		createSiteActions(part.getSite(), selectionProvider);
	}

	/**
	 * Creates a new <code>OpenActionGroup</code>. The group requires that the selection provided by
	 * the given selection provider is of type {@link IStructuredSelection}.
	 *
	 * @param site the site that will own the action group.
	 * @param selectionProvider the selection provider used instead of the page selection provider.
	 * @since 3.2
	 */
	public OpenViewActionGroup(IWorkbenchSite site, ISelectionProvider selectionProvider) {
		createSiteActions(site, selectionProvider);
	}

	/**
	 * Note: This constructor is for internal use only. Clients should not call this constructor.
	 * 
	 * @param part the editor part
	 * @noreference This constructor is not intended to be referenced by clients.
	 */
	public OpenViewActionGroup(FluentMkEditor part) {
		fEditorIsOwner = true;
		// fShowShowInMenu = false;
		initialize(part.getEditorSite().getSelectionProvider());
	}

	/**
	 * Specifies if this action group also contains the 'Properties' action
	 * ({@link PropertyDialogAction}). By default, the action is contained in the group.
	 *
	 * @param enable If set, the 'Properties' action is part of this action group
	 * @since 3.3
	 */
	public void containsOpenPropertiesAction(boolean enable) {
		fShowOpenPropertiesAction = enable;
	}

	/**
	 * Specifies if this action group also contains the 'Show In' menu (See
	 * {@link ContributionItemFactory#VIEWS_SHOW_IN}). By default, the action is contained in the
	 * group except for editors.
	 *
	 * @param enable If set, the 'Show In' menu is part of this action group
	 * @since 3.3
	 */
	public void containsShowInMenu(boolean enable) {
		// fShowShowInMenu = enable;
	}

	private void createSiteActions(IWorkbenchSite site, ISelectionProvider specialProvider) {
		ISelectionProvider provider = specialProvider != null ? specialProvider : site.getSelectionProvider();

		fOpenPropertiesDialog = new PropertyDialogAction(site, provider);
		fOpenPropertiesDialog.setActionDefinitionId(IWorkbenchCommandConstants.FILE_PROPERTIES);

		initialize(provider);
	}

	private void initialize(ISelectionProvider provider) {
		ISelection selection = provider.getSelection();
		if (!fEditorIsOwner) {
			if (fShowOpenPropertiesAction) {
				if (selection instanceof IStructuredSelection) {
					fOpenPropertiesDialog.selectionChanged((IStructuredSelection) selection);
				} else {
					fOpenPropertiesDialog.selectionChanged(selection);
				}
			}
		}
	}

	@Override
	public void fillActionBars(IActionBars actionBar) {
		super.fillActionBars(actionBar);
		setGlobalActionHandlers(actionBar);
	}

	@Override
	public void fillContextMenu(IMenuManager menu) {
		super.fillContextMenu(menu);
		// if (fShowShowInMenu) {
		// MenuManager showInSubMenu = new MenuManager(getShowInMenuLabel());
		// IWorkbenchWindow workbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		// showInSubMenu.add(ContributionItemFactory.VIEWS_SHOW_IN.create(workbenchWindow));
		// menu.appendToGroup(ICommonMenuConstants.GROUP_OPEN, showInSubMenu);
		// }

		IStructuredSelection selection = getStructuredSelection();
		if (fShowOpenPropertiesAction && selection != null && fOpenPropertiesDialog.isApplicableForSelection())
			menu.appendToGroup(ICommonMenuConstants.GROUP_PROPERTIES, fOpenPropertiesDialog);
	}

	// private String getShowInMenuLabel() {
	// String keyBinding = null;
	//
	// IBindingService bindingService = PlatformUI.getWorkbench().getAdapter(IBindingService.class);
	// if (bindingService != null) keyBinding = bindingService
	// .getBestActiveBindingFormattedFor(IWorkbenchCommandConstants.NAVIGATE_SHOW_IN_QUICK_MENU);
	//
	// if (keyBinding == null) keyBinding = ""; //$NON-NLS-1$
	//
	// return "Show in" + '\t' + keyBinding; //$NON-NLS-1$
	// }

	private void setGlobalActionHandlers(IActionBars actionBars) {
		if (!fEditorIsOwner && fShowOpenPropertiesAction)
			actionBars.setGlobalActionHandler(ActionFactory.PROPERTIES.getId(), fOpenPropertiesDialog);
	}

	@SuppressWarnings("unused")
	private void appendToGroup(IMenuManager menu, IAction action) {
		if (action.isEnabled()) menu.appendToGroup(ICommonMenuConstants.GROUP_OPEN, action);
	}

	private IStructuredSelection getStructuredSelection() {
		ISelection selection = getContext().getSelection();
		if (selection instanceof IStructuredSelection) return (IStructuredSelection) selection;
		return null;
	}
}
