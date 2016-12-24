/*******************************************************************************
 * Copyright (c) 2016 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.TreeViewer;

import net.certiv.fluentmark.FluentMkUI;
import net.certiv.fluentmark.outline.MkOutlinePage.OutlineViewer;
import net.certiv.fluentmark.FluentMkImages;

public class ExpandAllAction extends Action {

	private TreeViewer viewer;

	public ExpandAllAction(OutlineViewer viewer) {
		super(ActionMessages.ExpandAllAction_0);
		this.viewer = viewer;

		setToolTipText(ActionMessages.ExpandAllAction_1);
		FluentMkUI.getDefault().getImageProvider().setImageDescriptors(this, FluentMkImages.OBJ,
				FluentMkImages.IMG_MENU_EXPAND_ALL);
	}

	@Override
	public void run() {
		if (viewer != null) {
			viewer.expandAll();
		}
	}
}
