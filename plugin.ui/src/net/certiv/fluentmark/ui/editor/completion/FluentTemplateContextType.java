/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.ui.editor.completion;

import org.eclipse.jface.text.templates.GlobalTemplateVariables;
import org.eclipse.jface.text.templates.TemplateContextType;

public class FluentTemplateContextType extends TemplateContextType {

	public static final String CONTEXT_TYPE_ID = "net.certiv.fluentmark.ui.templateContext"; //$NON-NLS-1$
	// preference key used to store the template.xml content as a string
	public static final String CUSTOM_TEMPLATES_KEY = "net.certiv.fluentmark.ui.customtemplates"; //$NON-NLS-1$

	public FluentTemplateContextType() {
		super(CONTEXT_TYPE_ID, Messages.MarkupTemplateCompletionProcessor_contextName);
		addGlobalResolvers();
	}

	private void addGlobalResolvers() {
		addResolver(new GlobalTemplateVariables.Cursor());
		addResolver(new GlobalTemplateVariables.WordSelection());
		addResolver(new GlobalTemplateVariables.LineSelection());
		addResolver(new GlobalTemplateVariables.Dollar());
		addResolver(new GlobalTemplateVariables.Date());
		addResolver(new GlobalTemplateVariables.Year());
		addResolver(new GlobalTemplateVariables.Time());
		addResolver(new GlobalTemplateVariables.User());
	}
}
