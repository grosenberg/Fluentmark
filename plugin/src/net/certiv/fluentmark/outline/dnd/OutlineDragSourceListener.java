/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.outline.dnd;

import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.util.TransferDragSourceListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.Transfer;

public class OutlineDragSourceListener implements TransferDragSourceListener {
	private final ISelectionProvider selectionProvider;

	public OutlineDragSourceListener(ISelectionProvider selectionProvider) {
		this.selectionProvider = selectionProvider;
	}

	public Transfer getTransfer() {
		return LocalSelectionTransfer.getTransfer();
	}

	public void dragFinished(DragSourceEvent event) {
		LocalSelectionTransfer.getTransfer().setSelection(null);
	}

	public void dragSetData(DragSourceEvent event) {
	}

	public void dragStart(DragSourceEvent event) {
		LocalSelectionTransfer.getTransfer().setSelection(selectionProvider.getSelection());
	}
}
