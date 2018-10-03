/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.ui.preferences.pages;

import org.eclipse.ui.texteditor.templates.TemplatePreferencePage;

import net.certiv.fluentmark.core.FluentCore;
import net.certiv.fluentmark.ui.editor.completion.FluentTemplateAccess;

public class TemplatesPage extends TemplatePreferencePage {

	public TemplatesPage() {
		setPreferenceStore(FluentCore.getDefault().getPrefsManager());
		setTemplateStore(FluentTemplateAccess.getInstance().getTemplateStore());
		setContextTypeRegistry(FluentTemplateAccess.getInstance().getContextTypeRegistry());
	}

	@Override
	protected boolean isShowFormatterSetting() {
		return false;
	}
}
