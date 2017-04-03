/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.editor;

import org.eclipse.jface.text.DefaultInformationControl;
import org.eclipse.jface.text.DefaultTextHover;
import org.eclipse.jface.text.IInformationControl;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextHoverExtension;
import org.eclipse.jface.text.ITextHoverExtension2;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.texteditor.ITextEditor;

import net.certiv.fluentmark.model.PagePart;
import net.certiv.fluentmark.model.PageRoot;

public class FluentMkTextHover extends DefaultTextHover implements ITextHoverExtension, ITextHoverExtension2 {

	private FluentMkEditor editor;

	public FluentMkTextHover(ITextEditor editor, ISourceViewer sourceViewer, String contentType) {
		super(sourceViewer);
		this.editor = (FluentMkEditor) editor;
	}

	@Override
	public Object getHoverInfo2(ITextViewer textViewer, IRegion hoverRegion) {
		int offset = hoverRegion.getOffset();
		PageRoot model = editor.getPageModel();
		PagePart part = model.partAtOffset(offset);
		return part.details(offset).replaceAll("\\r?\\n", "<br>");
	}

	@Override
	public IInformationControlCreator getHoverControlCreator() {
		return new IInformationControlCreator() {

			@Override
			public IInformationControl createInformationControl(Shell parent) {
				return new DefaultInformationControl(parent, EditorsUI.getTooltipAffordanceString());
			}
		};
	}
}
