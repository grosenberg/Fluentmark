/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.views;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.preference.IPreferenceStore;

import net.certiv.fluentmark.FluentMkUI;
import net.certiv.fluentmark.preferences.Prefs;

/**
 * Rate limits view updates by ignoring all but the last update trigger received within a limit
 * window.
 * <p>
 * A trigger received outside of an active limit window causes an immediate update and the opening
 * of a an active limit window.
 * <p>
 * All triggers received within an active limit window causes, on termination of that active limit
 * window, a single update and the start of a new active limit window.
 * <p>
 * If no trigger is received within the an active limit window, no terminal update is performed and
 * no new active limit window is opened.
 */
public class LimitJob extends Job {

	private FluentMkPreview view;
	private UpdateJob updater;
	private IPreferenceStore store;

	private boolean run;
	private int delay;
	private long start;
	private long mark;

	public LimitJob(FluentMkPreview view, UpdateJob updater) {
		super("Limiter");
		this.view = view;
		this.updater = updater;
		this.store = FluentMkUI.getDefault().getPreferenceStore();
	}

	/** Main entry point for requesting view updates. Conditionally schedules an UpdateJob. **/
	public void trigger() {
		if (view != null) {
			if (!run) {
				run = true;
				updater.schedule();
				schedule();
			} else {
				mark(System.currentTimeMillis());
			}
		}
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		while (!monitor.isCanceled() && run) {
			delay = store.getInt(Prefs.VIEW_UPDATE_DELAY);
			start = System.currentTimeMillis();
			mark(start);
			while (System.currentTimeMillis() < start + delay) {
				try {
					Thread.sleep(delay);
				} catch (InterruptedException e) {}
			}
			if (mark > start) {	// triggered during window
				updater.schedule();
			} else {			// no trigger, so close window
				run = false;
			}
		}
		return Status.OK_STATUS;
	}

	protected synchronized void mark(long mark) {
		this.mark = mark;
	}

	public void dispose() {
		this.view = null;
	}
}
