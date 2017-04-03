/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.preferences.pages;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.ui.editors.text.ITextEditorHelpContextIds;

import eclipse.spellchecker.etc.IStatusChangeListener;
import net.certiv.fluentmark.FluentMkUI;
import net.certiv.fluentmark.editor.StatusUtil;
import net.certiv.fluentmark.preferences.AbstractConfigurationBlockPreferencePage;
import net.certiv.fluentmark.preferences.IPreferenceConfigurationBlock;
import net.certiv.fluentmark.preferences.OverlayPreferenceStore;
import net.certiv.fluentmark.spelling.MkSpellingConfigurationBlock;

/**
 * Spelling preference page for options specific to Markdown.
 */
public class PrefPageSpeller extends AbstractConfigurationBlockPreferencePage {

	/**
	 * Status monitor.
	 */
	private class StatusMonitor implements IStatusChangeListener {

		@Override
		public void statusChanged(IStatus status) {
			handleStatusChanged(status);
		}
	}

	public PrefPageSpeller() {
		super();
	}

	@Override
	protected IPreferenceConfigurationBlock createConfigurationBlock(OverlayPreferenceStore overlayPreferenceStore) {
		return new MkSpellingConfigurationBlock(overlayPreferenceStore, new StatusMonitor());
	}

	/**
	 * Handles status changes.
	 *
	 * @param status the new status
	 */
	protected void handleStatusChanged(IStatus status) {
		setValid(!status.matches(IStatus.ERROR));
		StatusUtil.applyToStatusLine(this, status);
	}

	@Override
	protected void setDescription() {
		setDescription("Spell Checker");
	}

	@Override
	protected void setPreferenceStore() {
		setPreferenceStore(FluentMkUI.getDefault().getPreferenceStore());
	}

	@Override
	protected String getHelpId() {
		return ITextEditorHelpContextIds.SPELLING_PREFERENCE_PAGE;
	}
}
