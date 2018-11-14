/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.ui.preferences.pages;

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.core.preferences.DslPrefsManagerDelta;
import net.certiv.dsl.ui.DslUI;
import net.certiv.dsl.ui.preferences.blocks.IPreferenceConfigBlock;
import net.certiv.dsl.ui.preferences.pages.AbstractPreferencePage;
import net.certiv.fluentmark.core.FluentCore;
import net.certiv.fluentmark.ui.FluentUI;
import net.certiv.fluentmark.ui.preferences.PrefsMessages;
import net.certiv.fluentmark.ui.preferences.blocks.EditorConfigBlock;

public class EditorPage extends AbstractPreferencePage {

	public EditorPage() {
		super();
	}

	@Override
	public DslUI getDslUI() {
		return FluentUI.getDefault();
	}

	@Override
	public DslCore getDslCore() {
		return FluentCore.getDefault();
	}

	@Override
	protected IPreferenceConfigBlock createConfigurationBlock(DslPrefsManagerDelta delta) {
		return new EditorConfigBlock(this, delta, getFormkit(), getColorMgr());
	}

	@Override
	protected void setDescription() {
		setDescription(PrefsMessages.EditorPreferencePage_general);
	}
}
