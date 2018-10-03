/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.ui.preferences.pages;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.ui.editors.text.ITextEditorHelpContextIds;

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.core.preferences.DslPrefsManagerDelta;
import net.certiv.dsl.ui.DslUI;
import net.certiv.dsl.ui.dialogs.StatusUtil;
import net.certiv.dsl.ui.preferences.blocks.IPreferenceConfigBlock;
import net.certiv.dsl.ui.preferences.pages.AbstractPreferencePage;
import net.certiv.fluentmark.core.FluentCore;
import net.certiv.fluentmark.ui.FluentUI;
import net.certiv.fluentmark.ui.preferences.blocks.SpellingConfigBlock;
import net.certiv.spellchecker.etc.IStatusChangeListener;

/** Spelling preference page for options specific to Markdown. */
public class SpellerPage extends AbstractPreferencePage {

	/** Status monitor. */
	private class StatusMonitor implements IStatusChangeListener {

		@Override
		public void statusChanged(IStatus status) {
			handleStatusChanged(status);
		}
	}

	public SpellerPage() {
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
		return new SpellingConfigBlock(this, delta, getFormkit(), getColorMgr(), new StatusMonitor());
	}

	protected void handleStatusChanged(IStatus status) {
		setValid(!status.matches(IStatus.ERROR));
		StatusUtil.applyToStatusLine(this, status);
	}

	@Override
	protected void setDescription() {
		setDescription("Spell Checker");
	}

	@Override
	protected String getHelpId() {
		return ITextEditorHelpContextIds.SPELLING_PREFERENCE_PAGE;
	}
}
