/*******************************************************************************
 * Copyright (c) 2016 - 2020 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluent.dt.ui.vis.handlers;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import net.certiv.common.log.Log;
import net.certiv.common.util.FileUtils;
import net.certiv.dsl.core.preferences.PrefsManager;
import net.certiv.fluent.dt.core.preferences.Prefs;
import net.certiv.fluent.dt.ui.editor.FluentEditor;
import net.certiv.fluent.dt.ui.vis.FluentVis;
import net.certiv.fluent.dt.ui.vis.convert.HtmlGen;
import net.certiv.fluent.dt.ui.vis.convert.Kind;
import net.certiv.fluent.dt.ui.vis.ws.LiveUtil;

public class OpenLiveHandler extends AbstractHandler {

	private static final String ErrMsg = "Failed opening live view (%s): %s";
	private static final String MsgOpen = "Live client page at %s";
	private static final String ErrOpen = "Failed to open live client: %s";

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		IEditorPart part = HandlerUtil.getActiveEditorChecked(event);
		if (part instanceof FluentEditor) {
			FluentEditor editor = (FluentEditor) part;
			HtmlGen htmlGen = new HtmlGen(editor, FluentVis.getDefault().getConverter());
			String content = htmlGen.getHtml(Kind.VIEW);

			PrefsManager mgr = FluentVis.getDefault().getPrefsManager();
			String path = mgr.getString(Prefs.VIEW_WS_PATH);
			String appl = mgr.getString(Prefs.VIEW_CLNT_APPL);

			File dst;
			try {
				dst = FileUtils.createTmpFolder(path);
			} catch (IOException e) {
				Log.error(this, "Failed to create temporary directory");
				return null;
			}

			FileUtils.clearFolder(dst);
			File page = new File(dst, appl);
			FileUtils.write(page, content);

			URL url;
			try {
				url = page.toURI().toURL();
			} catch (MalformedURLException e1) {
				Log.error(this, "Failed to create temporary file URL");
				return null;
			}

			// open a local client browser and load the url
			// the appl will execute to open a websocket at url {host:port/path}
			Exception e = LiveUtil.openBrowser(url);
			if (e == null) {
				Log.debug(this, MsgOpen, url);

			} else {
				Log.error(this, ErrOpen, e.getMessage());
				String msg = String.format(ErrMsg, FluentVis.ID, e.getMessage());
				MessageDialog.openError(window.getShell(), "Fluentmark Live View", msg);
			}
		}
		return null;
	}
}
