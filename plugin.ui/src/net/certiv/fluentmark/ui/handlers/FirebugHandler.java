package net.certiv.fluentmark.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;

import net.certiv.fluentmark.ui.views.FluentPreview;

public class FirebugHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchPart part = HandlerUtil.getActivePart(event);
		if (part instanceof FluentPreview) {
			FluentPreview view = (FluentPreview) part;
			view.debug();
		}
		return null;
	}
}
