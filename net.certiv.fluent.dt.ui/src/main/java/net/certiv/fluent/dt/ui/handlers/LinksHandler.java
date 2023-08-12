package net.certiv.fluent.dt.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.ui.DslUI;
import net.certiv.dsl.ui.IDslUIDef;
import net.certiv.fluent.dt.core.FluentCore;
import net.certiv.fluent.dt.ui.FluentUI;
import net.certiv.fluent.dt.ui.editor.FluentEditor;
import net.certiv.fluent.dt.ui.editor.toolbar.links.LinksDialog;

public class LinksHandler extends AbstractHandler implements IDslUIDef {

	public LinksHandler() {
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
		Shell shell = HandlerUtil.getActiveShell(event);
		FluentEditor editor = (FluentEditor) HandlerUtil.getActiveEditor(event);
		TextSelection sel = (TextSelection) HandlerUtil.getCurrentSelection(event);
		LinksDialog links = new LinksDialog(shell, editor, sel);
		links.open();
		return null;
	}
}
