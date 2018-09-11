/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.preferences.pages;

import org.eclipse.ui.texteditor.templates.TemplatePreferencePage;

import net.certiv.fluentmark.FluentUI;
import net.certiv.fluentmark.editor.assist.CustomTemplateAccess;

public class PrefPageTemplates extends TemplatePreferencePage {

	public PrefPageTemplates() {
		setPreferenceStore(FluentUI.getDefault().getPreferenceStore());
		setTemplateStore(CustomTemplateAccess.getInstance().getTemplateStore());
		setContextTypeRegistry(CustomTemplateAccess.getInstance().getContextTypeRegistry());
	}

	@Override
	protected boolean isShowFormatterSetting() {
		return false;
	}
}
