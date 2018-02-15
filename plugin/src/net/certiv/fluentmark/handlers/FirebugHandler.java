package net.certiv.fluentmark.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;

import net.certiv.fluentmark.views.FluentMkPreview;

public class FirebugHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchPart part = HandlerUtil.getActivePart(event);
		if (part instanceof FluentMkPreview) {
			FluentMkPreview view = (FluentMkPreview) part;
			view.debug();
		}
		return null;
	}
}
