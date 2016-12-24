/*******************************************************************************
 * Copyright (c) 2016 Certiv Analytics and others.
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

import net.certiv.fluentmark.FluentMkUI;

public class OutlineCutAction extends Action {

	private MkOutlinePage outline;

	public OutlineCutAction(MkOutlinePage outline) {
		super("Cut");
		this.outline = outline;

		setToolTipText("Cut");
		setImageDescriptor(FluentMkUI.getDefault().getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_TOOL_CUT));
		setDisabledImageDescriptor(FluentMkUI.getDefault().getWorkbench().getSharedImages()
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
