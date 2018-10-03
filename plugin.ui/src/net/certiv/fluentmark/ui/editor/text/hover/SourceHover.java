/*******************************************************************************
 * Copyright (c) 2000, 2007 IBM Corporation and others. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Contributors: IBM Corporation - initial API and
 * implementation
 *******************************************************************************/
package net.certiv.fluentmark.ui.editor.text.hover;

import org.eclipse.ui.IEditorPart;

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.core.preferences.IDslPrefsManager;
import net.certiv.dsl.ui.DslUI;
import net.certiv.dsl.ui.editor.text.hover.DslSourceHover;
import net.certiv.fluentmark.core.FluentCore;
import net.certiv.fluentmark.ui.FluentUI;

/** Provides source as hover info for Fluent elements. */
public class SourceHover extends DslSourceHover {

	public SourceHover(IEditorPart editor, IDslPrefsManager store) {
		super(editor, store);
	}

	@Override
	public DslUI getDslUI() {
		return FluentUI.getDefault();
	}

	@Override
	public DslCore getDslCore() {
		return FluentCore.getDefault();
	}
}
