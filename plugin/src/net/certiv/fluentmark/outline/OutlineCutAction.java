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
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.ui.ISharedImages;

import net.certiv.fluentmark.FluentUI;

public class OutlineCutAction extends Action {

	private FluentOutlinePage outline;

	public OutlineCutAction(FluentOutlinePage outline) {
		super("Cut");
		this.outline = outline;

		setToolTipText("Cut");
		setImageDescriptor(FluentUI.getDefault().getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_TOOL_CUT));
		setDisabledImageDescriptor(FluentUI.getDefault().getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_TOOL_CUT_DISABLED));

	}

	public void run() {
		if (outline.getEditor().isPageModelDirty()) return;

		String text = outline.getSelectedText();
		if (text != null) {
			outline.getClipboard().setContents(new Object[] { text }, new Transfer[] { TextTransfer.getInstance() });
			outline.removeSelectedText();
		}
	}
}
