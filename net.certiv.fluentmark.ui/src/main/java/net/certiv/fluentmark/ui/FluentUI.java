/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.ui;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.ui.DslUI;
import net.certiv.dsl.ui.editor.text.DslTextTools;
import net.certiv.fluentmark.core.FluentCore;
import net.certiv.fluentmark.ui.editor.FluentEditor;
import net.certiv.fluentmark.ui.editor.FluentTextTools;
import net.certiv.fluentmark.ui.templates.MdContextType;

public class FluentUI extends DslUI {

	private static FluentUI plugin;

	private FluentImageManager imgMgr;
	private DslTextTools textTools;

	public FluentUI() {
		super();
	}

	/** Returns the shared instance */
	public static FluentUI getDefault() {
		return plugin;
	}

	@Override
	public DslUI getDslUI() {
		return plugin;
	}

	@Override
	public DslCore getDslCore() {
		return FluentCore.getDefault();
	}

	@Override
	public void start(BundleContext context) throws Exception {
		plugin = this;
		super.start(context);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		plugin = null;
	}

	@Override
	public String getPluginId() {
		return plugin.getBundle().getSymbolicName();
	}

	@Override
	public String getDslLanguageName() {
		return FluentCore.DSL_NAME;
	}

	@Override
	protected String getEditorId() {
		return FluentEditor.EDITOR_ID;
	}

	@Override
	public FluentImageManager getImageManager() {
		if (imgMgr == null) {
			imgMgr = new FluentImageManager();
		}
		return imgMgr;
	}

	@Override
	public DslTextTools getTextTools() {
		if (textTools == null) {
			textTools = new FluentTextTools(true);
		}
		return textTools;
	}

	@Override
	protected String[] getDslContextTypes() {
		return MdContextType.CONTEXT_TYPE_IDS;
	}

	public IStatus createStatus(int statusCode, Throwable exception) {
		return createStatus(null, statusCode, exception);
	}

	public IStatus createStatus(String message, int statusCode, Throwable exception) {
		if (message == null && exception != null) {
			message = exception.getClass().getName() + ": " + exception.getMessage(); //$NON-NLS-1$
		}
		Status status = new Status(statusCode, getPluginId(), statusCode, message, exception);
		return status;
	}
}
