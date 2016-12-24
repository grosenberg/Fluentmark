/*******************************************************************************
 * Copyright (c) 2016 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.preferences.pages;

import org.eclipse.ui.texteditor.templates.TemplatePreferencePage;

import net.certiv.fluentmark.FluentMkUI;
import net.certiv.fluentmark.assist.CustomTemplateAccess;

public class PrefPageTemplates extends TemplatePreferencePage {

	public PrefPageTemplates() {
		setPreferenceStore(FluentMkUI.getDefault().getPreferenceStore());
		setTemplateStore(CustomTemplateAccess.getInstance().getTemplateStore());
		setContextTypeRegistry(CustomTemplateAccess.getInstance().getContextTypeRegistry());
	}

	@Override
	protected boolean isShowFormatterSetting() {
		return false;
	}
}
