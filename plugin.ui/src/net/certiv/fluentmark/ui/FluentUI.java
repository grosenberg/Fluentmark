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
import net.certiv.dsl.ui.DslImages;
import net.certiv.dsl.ui.DslUI;
import net.certiv.dsl.ui.editor.text.DslTextTools;
import net.certiv.dsl.ui.formatter.IDslFormatterFactory;
import net.certiv.fluentmark.core.FluentCore;
import net.certiv.fluentmark.ui.editor.FluentTextTools;

public class FluentUI extends DslUI {

	// Should be unique, lower case, single word
	private static final String DSL_NAME = "fluent";

	private static FluentUI plugin;

	private FluentImages imageProvider;
	private DslTextTools textTools;

	public FluentUI() {
		super();
	}

	/** Returns the shared instance */
	public static FluentUI getDefault() {
		return plugin;
	}

	@Override
	public String getPluginId() {
		return plugin.getBundle().getSymbolicName();
	}

	@Override
	public String getDslLanguageName() {
		return DSL_NAME;
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
		super.start(context);
		plugin = this;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	@Override
	public DslTextTools getTextTools() {
		if (textTools == null) {
			textTools = new FluentTextTools(true);
		}
		return textTools;
	}

	@Override
	public DslImages getImageProvider() {
		if (imageProvider == null) {
			imageProvider = new FluentImages();
		}
		return imageProvider;
	}

	@Override
	public IDslFormatterFactory getFormatterFactory() {
		return null;
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
