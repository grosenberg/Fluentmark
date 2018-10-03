/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.ui.editor.completion;

import org.eclipse.jface.preference.IPreferenceStore;

import net.certiv.dsl.ui.templates.DslTemplateAccess;
import net.certiv.fluentmark.core.FluentCore;

public class FluentTemplateAccess extends DslTemplateAccess {

	private static FluentTemplateAccess INST;

	public static FluentTemplateAccess getInstance() {
		if (INST == null) {
			INST = new FluentTemplateAccess();
		}
		return INST;
	}

	@Override
	protected String getContextTypeId() {
		return FluentTemplateContextType.CONTEXT_TYPE_ID;
	}

	@Override
	protected String getCustomTemplatesKey() {
		return FluentTemplateContextType.CUSTOM_TEMPLATES_KEY;
	}

	@Override
	protected IPreferenceStore getPreferenceStore() {
		return FluentCore.getDefault().getPrefsManager();
	}
}
