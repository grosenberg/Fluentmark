/*******************************************************************************
 * Copyright (c) 2016 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.outline;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.ISharedImages;

import net.certiv.fluentmark.FluentMkUI;

public class OutlineDeleteAction extends Action {

	private MkOutlinePage outline;

	public OutlineDeleteAction(MkOutlinePage outline) {
		super("Delete");
		this.outline = outline;

		setToolTipText("Delete");
		setImageDescriptor(FluentMkUI.getDefault().getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
		setDisabledImageDescriptor(FluentMkUI.getDefault().getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE_DISABLED));
	}

	public void run() {
		if (outline.getEditor().isPageModelDirty()) return;
		outline.removeSelectedText();
	}
}
