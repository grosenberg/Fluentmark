/*******************************************************************************
 * Copyright (c) 2016 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.preferences.pages;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import net.certiv.fluentmark.FluentMkUI;
import net.certiv.fluentmark.preferences.AbstractConfigurationBlockPreferencePage;
import net.certiv.fluentmark.preferences.IPreferenceConfigurationBlock;
import net.certiv.fluentmark.preferences.OverlayPreferenceStore;

/**
 * Appearance preference page.
 */
public class PrefPageAppearance extends AbstractConfigurationBlockPreferencePage {

	@Override
	protected String getHelpId() {
		return null;
	}

	@Override
	protected void setDescription() {
		setDescription("Markup");
	}

	@Override
	protected Label createDescriptionLabel(Composite parent) {
		return null;
	}

	@Override
	protected void setPreferenceStore() {
		setPreferenceStore(FluentMkUI.getDefault().getPreferenceStore());
	}

	@Override
	protected IPreferenceConfigurationBlock createConfigurationBlock(OverlayPreferenceStore overlayPreferenceStore) {
		return new AppearanceConfigurationBlock(overlayPreferenceStore);
	}
}
