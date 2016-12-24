/*******************************************************************************
 * Copyright (c) 2016 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.assist;

import java.io.IOException;

import org.eclipse.jface.text.templates.ContextTypeRegistry;
import org.eclipse.jface.text.templates.persistence.TemplateStore;
import org.eclipse.ui.editors.text.templates.ContributionContextTypeRegistry;
import org.eclipse.ui.editors.text.templates.ContributionTemplateStore;

import net.certiv.fluentmark.Log;
import net.certiv.fluentmark.FluentMkUI;

public class CustomTemplateAccess {

	// preference store key used to store the template.xml content as a string
	private static final String CUSTOM_TEMPLATES_KEY = "net.certiv.fluentmark.customtemplates"; //$NON-NLS-1$

	private static CustomTemplateAccess instance;

	private ContextTypeRegistry registry;
	private TemplateStore templateStore;

	public static CustomTemplateAccess getInstance() {
		if (instance == null) {
			instance = new CustomTemplateAccess();
		}
		return instance;
	}

	public ContextTypeRegistry getContextTypeRegistry() {
		if (registry == null) {
			if (FluentMkUI.getDefault() != null) {
				ContributionContextTypeRegistry contributionRegistry = new ContributionContextTypeRegistry();
				contributionRegistry.addContextType(SourceTemplateContextType.ID);
				registry = contributionRegistry;
			} else {
				ContextTypeRegistry contextTypeRegistry = new ContextTypeRegistry();
				contextTypeRegistry.addContextType(new SourceTemplateContextType());
				registry = contextTypeRegistry;
			}
		}
		return registry;
	}

	/**
	 * @return this template store, or null if there is no template store.
	 */
	public TemplateStore getTemplateStore() {
		if (templateStore == null) {
			if (FluentMkUI.getDefault() != null) {
				templateStore = new ContributionTemplateStore(getContextTypeRegistry(),
						FluentMkUI.getDefault().getPreferenceStore(), CUSTOM_TEMPLATES_KEY);
				try {
					templateStore.load();
				} catch (IOException e) {
					Log.error(e);
				}
			}
		}
		return templateStore;
	}
}
