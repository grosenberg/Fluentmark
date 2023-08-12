package net.certiv.fluent.dt.ui.handlers;

import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.commands.IElementUpdater;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.menus.UIElement;

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.ui.DslUI;
import net.certiv.dsl.ui.IDslUIDef;
import net.certiv.fluent.dt.core.FluentCore;
import net.certiv.fluent.dt.ui.FluentUI;
import net.certiv.fluent.dt.ui.editor.FluentEditor;

public class ToggleEditorFeaturebarHandler extends AbstractHandler implements IElementUpdater, IDslUIDef {

	public ToggleEditorFeaturebarHandler() {
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
	public Object execute(ExecutionEvent event) throws ExecutionException {
		FluentEditor editor = (FluentEditor) HandlerUtil.getActiveEditor(event);
		boolean state = !editor.isEditorToolbarShown();
		editor.showEditorToolbar(state);
		return null;
	}

	@Override
	@SuppressWarnings({ "rawtypes" })
	public void updateElement(UIElement element, Map parameters) {
		IWorkbenchWindow window = element.getServiceLocator().getService(IWorkbenchWindow.class);
		if (window == null) return;

		IWorkbenchPage page = window.getActivePage();
		if (page == null) return;

		IEditorPart editor = page.getActiveEditor();
		if (editor == null) return;

		if (editor instanceof FluentEditor) {
			boolean state = ((FluentEditor) editor).isEditorToolbarShown();
			element.setChecked(state);
		}
	}
}
