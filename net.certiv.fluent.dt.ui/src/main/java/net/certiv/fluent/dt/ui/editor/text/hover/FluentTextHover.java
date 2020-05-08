/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluent.dt.ui.editor.text.hover;

import org.eclipse.ui.IEditorPart;

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.core.preferences.IPrefsManager;
import net.certiv.dsl.ui.DslUI;
import net.certiv.dsl.ui.editor.text.hover.DslSourceHover;
import net.certiv.fluent.dt.core.FluentCore;
import net.certiv.fluent.dt.ui.FluentUI;

public class FluentTextHover extends DslSourceHover {

	public FluentTextHover(IEditorPart editor, IPrefsManager store) {
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

	// private FluentEditor editor;
	//
	// public FluentTextHover(ITextEditor editor, ISourceViewer sourceViewer, String contentType) {
	// super(sourceViewer);
	// this.editor = (FluentEditor) editor;
	// }
	//
	// @Override
	// public Object getHoverInfo2(ITextViewer textViewer, IRegion hoverRegion) {
	// int offset = hoverRegion.getOffset();
	// Page model = editor.getPageModel();
	// PagePart part = model.partAtOffset(offset);
	// return part.details(offset).replaceAll("\\r?\\n", "<br>");
	// }
	//
	// @Override
	// public IInformationControlCreator getHoverControlCreator() {
	// return new IInformationControlCreator() {
	//
	// @Override
	// public IInformationControl createInformationControl(Shell parent) {
	// return new DefaultInformationControl(parent, EditorsUI.getTooltipAffordanceString());
	// }
	// };
	// }
}
