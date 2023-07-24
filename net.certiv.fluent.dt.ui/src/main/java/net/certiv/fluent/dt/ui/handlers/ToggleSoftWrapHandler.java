package net.certiv.fluent.dt.ui.handlers;

import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.commands.IElementUpdater;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.menus.UIElement;

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.ui.DslUI;
import net.certiv.dsl.ui.IDslUIDef;
import net.certiv.dsl.ui.editor.DslEditor;
import net.certiv.fluent.dt.core.FluentCore;
import net.certiv.fluent.dt.core.preferences.Prefs;
import net.certiv.fluent.dt.ui.FluentUI;

public class ToggleSoftWrapHandler extends AbstractHandler implements IElementUpdater, IDslUIDef {

	public ToggleSoftWrapHandler() {
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
		DslEditor editor = (DslEditor) HandlerUtil.getActiveEditor(event);
		boolean state = !editor.isWordWrapEnabled();
		editor.getPrefsMgr().setValue(Prefs.EDITOR_SOFT_WRAP, state);
		editor.setWordWrap(state);
		return null;
	}

	@SuppressWarnings({ "rawtypes" })
	@Override
	public void updateElement(UIElement element, Map parameters) {
		boolean soft = getDslCore().getPrefsManager().getBoolean(Prefs.EDITOR_SOFT_WRAP);
		element.setChecked(soft);
	}
}
