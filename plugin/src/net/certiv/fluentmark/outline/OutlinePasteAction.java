/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.outline;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.ui.ISharedImages;

import net.certiv.fluentmark.FluentUI;

public class OutlinePasteAction extends Action {

	private FluentOutlinePage outline;

	public OutlinePasteAction(FluentOutlinePage outline) {
		super("Paste");
		this.outline = outline;

		setToolTipText("Paste");
		setImageDescriptor(FluentUI.getDefault().getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_TOOL_PASTE));
		setDisabledImageDescriptor(FluentUI.getDefault().getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_TOOL_PASTE_DISABLED));
	}

	public void run() {
		if (outline.getEditor().isPageModelDirty()) return;

		String text = (String) outline.getClipboard().getContents(TextTransfer.getInstance());
		if (text == null) return;
		outline.paste(text);
	}
}
