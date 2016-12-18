package net.certiv.fluentmark.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.eclipse.ui.handlers.HandlerUtil;

public class OpenStylesheetsHandler extends AbstractHandler {

	private static final String STYLES_ID = "net.certiv.fluentmark.preferences.PrefPageStyles";

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		Shell shell = HandlerUtil.getActiveShell(event);
		PreferencesUtil.createPreferenceDialogOn(shell, STYLES_ID, null, null).open();
		return null;
	}
}
