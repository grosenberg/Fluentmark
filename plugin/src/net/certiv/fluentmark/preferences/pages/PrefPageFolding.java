/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.preferences.pages;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;

import net.certiv.fluentmark.FluentMkUI;
import net.certiv.fluentmark.preferences.BaseFieldEditorPreferencePage;
import net.certiv.fluentmark.preferences.Prefs;
import net.certiv.fluentmark.preferences.SwtUtil;

public class PrefPageFolding extends BaseFieldEditorPreferencePage implements Prefs {

	private Composite baseComp;

	public PrefPageFolding() {
		super(GRID);
		setDescription("");
	}

	@Override
	public void init(IWorkbench workbench) {
		setPreferenceStore(FluentMkUI.getDefault().getPreferenceStore());
	}

	/** Create fields controlling editing assist behavior */
	@Override
	public void createFieldEditors() {

		baseComp = SwtUtil.makeGroupComposite(getFieldEditorParent(), 1, 1, "");

		SwtUtil.addLabel(baseComp, "Enable folding of:", 2);
		addField(new BooleanFieldEditor(FOLDING_FRONTMATTER_ENABLED, "Front matter block", baseComp));
		addField(new BooleanFieldEditor(FOLDING_HIDDEN_COMMENTS_ENABLED, "Hidden comments", baseComp));
		addField(new BooleanFieldEditor(FOLDING_CODEBLOCKS_ENABLED, "Code blocks", baseComp));
		SwtUtil.addSpacer(baseComp, 2);

		SwtUtil.addLabel(baseComp, "Initially fold:", 2);
		addField(new BooleanFieldEditor(FOLDING_INITIAL_FRONT_MATTER, "Front matter block", baseComp));
		addField(new BooleanFieldEditor(FOLDING_INITIAL_HIDDEN_COMMENTS, "Hidden comments", baseComp));
		addField(new BooleanFieldEditor(FOLDING_INITIAL_CODEBLOCKS, "Code blocks", baseComp));
		SwtUtil.addSpacer(baseComp, 2);

		addField(new IntegerFieldEditor(FOLDING_LINES_LIMIT, "Minimum number of lines to fold: ", baseComp, 6));
	}

	@Override
	protected void adjustSubLayout() {
		adjust(baseComp, 1);
	}
}
