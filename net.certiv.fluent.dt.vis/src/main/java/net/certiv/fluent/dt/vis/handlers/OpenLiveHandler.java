/*******************************************************************************
 * Copyright (c) 2016 - 2020 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluent.dt.vis.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

import net.certiv.common.log.Log;
import net.certiv.dsl.core.preferences.PrefsManager;
import net.certiv.fluent.dt.core.preferences.Prefs;
import net.certiv.fluent.dt.ui.editor.FluentEditor;
import net.certiv.fluent.dt.vis.FluentVis;
import net.certiv.fluent.dt.vis.server.LiveUtil;

public class OpenLiveHandler extends AbstractHandler {

	private static final String HTTPS = "http://%s:%s/%s";

	private static final String MsgOpen = "Live client page at %s";
	private static final String ErrOpen = "Failed to open live client: %s";
	private static final String ErrMsg = "Failed opening live view (%s): %s";

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		IEditorPart part = HandlerUtil.getActiveEditorChecked(event);
		if (part instanceof FluentEditor) {
			PrefsManager mgr = FluentVis.getDefault().getPrefsManager();
			String host = mgr.getString(Prefs.VIEW_HOST_NAME);
			int port = mgr.getInt(Prefs.VIEW_HOST_PORT);
			String appl = mgr.getString(Prefs.VIEW_CLNT_APPL);

			// open client browser at https://localhost:9025/index.html
			Shell shell = HandlerUtil.getActiveShellChecked(event);
			shell.getDisplay().asyncExec(() -> {
				String addr = String.format(HTTPS, host, port, appl);
				Exception e = LiveUtil.openBrowser(addr);
				if (e == null) {
					Log.debug(this, MsgOpen, addr);

				} else {
					Log.error(this, ErrOpen, e.getMessage());
					String msg = String.format(ErrMsg, FluentVis.ID, e.getMessage());
					MessageDialog.openError(shell, "Fluentmark Live View", msg);
				}
			});
		}
		return null;
	}
}
