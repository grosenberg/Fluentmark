/*******************************************************************************
 * Copyright (c) 2016 - 2020 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluent.dt.vis.handlers;

import java.util.concurrent.TimeUnit;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

import net.certiv.common.log.Log;
import net.certiv.common.util.Time;
import net.certiv.fluent.dt.ui.editor.FluentEditor;
import net.certiv.fluent.dt.vis.FluentVis;
import net.certiv.fluent.dt.vis.util.LiveUtil;

public class OpenLiveHandler extends AbstractHandler {

	private static final String MsgOpen = "Live client page at %s";

	private static final String ErrStart = "Timeout waiting for websocket server to start.";
	private static final String ErrOpen = "Failed to open live client: %s";
	private static final String ErrMsg = "Failed opening live view (%s): %s";

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		IEditorPart part = HandlerUtil.getActiveEditorChecked(event);
		Shell shell = HandlerUtil.getActiveShellChecked(event);

		if (part instanceof FluentEditor) {
			FluentVis vis = FluentVis.getDefault();
			if (!vis.isLiveServerRunning()) vis.startLiveServer();

			Job job = new Job("Open Liveview") {

				@Override
				protected IStatus run(IProgressMonitor monitor) {
					for (int cnt = 0; cnt < 10; cnt++) {
						if (vis.isLiveServerRunning()) break;

						Log.debug(this, "Waiting (%s)...", cnt);
						Time.sleep(100, TimeUnit.MILLISECONDS);
					}

					if (!vis.isLiveServerRunning()) {
						Log.error(this, ErrStart);
						MessageDialog.openError(shell, "Fluentmark Live View", ErrStart);
						return Status.CANCEL_STATUS;
					}

					String addr = vis.prepUniqueAppl((FluentEditor) part);

					// open client browser at https://host:port/indexXXXX.html
					Exception e = LiveUtil.openBrowser(addr);
					if (e == null) {
						Log.debug(this, MsgOpen, addr);

					} else {
						Log.error(this, ErrOpen, e.getMessage());
						String msg = String.format(ErrMsg, FluentVis.ID, e.getMessage());
						MessageDialog.openError(shell, "Fluentmark Live View", msg);
					}

					return Status.OK_STATUS;
				}

			};
			job.setSystem(true);
			job.setPriority(Job.SHORT);
			job.schedule();
		}
		return Status.OK_STATUS;
	}
}
