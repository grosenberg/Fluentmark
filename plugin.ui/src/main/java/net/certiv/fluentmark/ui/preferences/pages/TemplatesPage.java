/*******************************************************************************
 * Copyright (c) 2016 - 2018 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.ui.preferences.pages;

import org.eclipse.jface.text.IDocument;

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.core.preferences.DslPrefsManagerDelta;
import net.certiv.dsl.core.preferences.IDslPrefsManager;
import net.certiv.dsl.ui.DslUI;
import net.certiv.dsl.ui.editor.DslSourceViewerConfiguration;
import net.certiv.dsl.ui.templates.CompletionManager;
import net.certiv.dsl.ui.templates.DslTemplatePreferencePage;
import net.certiv.fluentmark.core.FluentCore;
import net.certiv.fluentmark.ui.FluentUI;
import net.certiv.fluentmark.ui.editor.FluentSimpleSourceViewerConfiguration;
import net.certiv.fluentmark.ui.editor.Partitions;

public class TemplatesPage extends DslTemplatePreferencePage {

	public TemplatesPage() {
		super();
		DslPrefsManagerDelta delta = FluentCore.getDefault().getPrefsManager().createDeltaManager();
		delta.setDefaultProject(null);
		setPreferenceStore(delta);
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
	protected DslSourceViewerConfiguration createSourceViewerConfiguration() {
		return new FluentSimpleSourceViewerConfiguration(getDslCore().getColorManager(),
				(IDslPrefsManager) getPreferenceStore(), null, Partitions.PARTITIONING, false);
	}

	@Override
	protected void setDocumentPartitioner(IDocument document) {
		getDslUI().getTextTools().setupDocumentPartitioner(document, Partitions.PARTITIONING);
	}

	@Override
	protected CompletionManager getCompletionMgr() {
		return getDslUI().getCompletionMgr();
	}
}
