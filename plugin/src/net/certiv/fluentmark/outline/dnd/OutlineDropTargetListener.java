/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.outline.dnd;

import java.util.List;

import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.jface.util.TransferDropTargetListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.PlatformUI;

import net.certiv.fluentmark.Log;
import net.certiv.fluentmark.model.PagePart;
import net.certiv.fluentmark.outline.operations.AbstractDocumentCommand;
import net.certiv.fluentmark.outline.operations.CommandManager;
import net.certiv.fluentmark.outline.operations.Insert;
import net.certiv.fluentmark.outline.operations.MovePartsCommand;

public class OutlineDropTargetListener implements TransferDropTargetListener {

	private static final double THRESHOLD = 0.5f;

	private final CommandManager commandManager;

	public OutlineDropTargetListener(CommandManager commandManager) {
		this.commandManager = commandManager;
	}

	public void dragEnter(DropTargetEvent event) {}

	public void dragLeave(DropTargetEvent event) {}

	public void dragOperationChanged(DropTargetEvent event) {}

	public void dropAccept(DropTargetEvent event) {}

	public void dragOver(DropTargetEvent event) {
		event.feedback = DND.FEEDBACK_SELECT;
		float location = computeRelativeLocation(event);
		if (location > THRESHOLD) {
			event.feedback = DND.FEEDBACK_INSERT_AFTER;
		} else {
			event.feedback = DND.FEEDBACK_INSERT_BEFORE;
		}
		// always provide expand/scroll capability when dragging
		event.feedback |= DND.FEEDBACK_EXPAND | DND.FEEDBACK_SCROLL;
	}

	public void drop(DropTargetEvent event) {
		List<PagePart> dropItems = getDropItems(event);
		if (dropItems != null) {
			Insert location = computeInsertLocation(event);
			Object targetData = event.item.getData();

			final AbstractDocumentCommand command = computeCommand(targetData, dropItems, location);
			if (command != null) {
				if (command.isEnabled()) {
					SafeRunnable.run(new ISafeRunnable() {

						public void run() throws Exception {
							commandManager.perform(command);
						}

						public void handleException(Throwable exception) {
							Log.error(exception);
							MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
									Messages.OutlineDropTargetListener_0, NLS.bind(Messages.OutlineDropTargetListener_1,
											new Object[] { exception.getMessage() }));
						}
					});
				} else {
					MessageDialog.openInformation(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
							Messages.OutlineDropTargetListener_2,
							NLS.bind(Messages.OutlineDropTargetListener_3, new Object[] { command.getProblemText() }));
				}
			}
		}
	}

	private AbstractDocumentCommand computeCommand(Object targetData, List<PagePart> dropItems, Insert location) {
		return new MovePartsCommand((PagePart) targetData, dropItems, location);
	}

	/**
	 * get the outline items being dropped, or null if there are none or if the event does not
	 * qualify for a drop.
	 */
	@SuppressWarnings("unchecked")
	private List<PagePart> getDropItems(DropTargetEvent event) {
		if (event.operations == DND.DROP_NONE || event.item == null) {
			return null;
		}
		Object targetData = event.item.getData();
		if (!(targetData instanceof PagePart)) {
			return null;
		}

		ISelection selection = LocalSelectionTransfer.getTransfer().getSelection();
		if (selection instanceof IStructuredSelection && !selection.isEmpty()) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			List<?> list = structuredSelection.toList();
			if (!list.isEmpty()) {
				for (Object i : list) {
					if (!(i instanceof PagePart)) return null;
				}
				return (List<PagePart>) list;
			}
		}
		return null;
	}

	private Insert computeInsertLocation(DropTargetEvent event) {
		float location = computeRelativeLocation(event);
		if (location > THRESHOLD) return Insert.AFTER;
		return Insert.BEFORE;
	}

	private float computeRelativeLocation(DropTargetEvent event) {
		if (event.item == null) return 0.0f;

		if (event.item instanceof TreeItem) {
			TreeItem treeItem = (TreeItem) event.item;
			Control control = treeItem.getParent();
			Point eventAt = control.toControl(new Point(event.x, event.y));
			Rectangle bounds = treeItem.getBounds();
			return (float) (eventAt.y - bounds.y) / (float) bounds.height;
		}

		return 0.0f;
	}

	public Transfer getTransfer() {
		return LocalSelectionTransfer.getTransfer();
	}

	public boolean isEnabled(DropTargetEvent event) {
		return getTransfer().isSupportedType(event.currentDataType) && getDropItems(event) != null;
	}
}
