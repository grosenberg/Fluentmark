/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluent.dt.ui.editor.strategies.tables;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationEvent;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationStrategy;
import org.eclipse.jface.viewers.FocusCellOwnerDrawHighlighter;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerEditor;
import org.eclipse.jface.viewers.TableViewerFocusCellManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ToolBar;

import net.certiv.dsl.core.model.IStatement;

public class TableDialog extends TableDialogActions {

	private IStatement stmt;
	private int style;

	/** Creates a new TableDialog with default SWT styles. */
	public TableDialog(IStatement stmt) {
		this(stmt, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER | SWT.FULL_SELECTION);
	}

	/** Creates a new TableDialog with the given style. */
	public TableDialog(IStatement stmt, int style) {
		super(Display.getCurrent().getActiveShell(), "Table Editor", null, null, MessageDialog.NONE, 1, "Apply",
				"Cancel");

		this.stmt = stmt;
		this.style = style;
		setShellStyle(getShellStyle() | SWT.RESIZE);
	}

	public String build() {
		return tableModel.build();
	}

	@Override
	protected Control createCustomArea(final Composite parent) {
		Composite body = new Composite(parent, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).span(2, 1).applyTo(body);
		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(body);

		ToolBar bar = new ToolBar(body, SWT.HORIZONTAL);
		ToolBarManager barMgr = new ToolBarManager(bar);
		barMgr.add(new AlignLeftAction());
		barMgr.add(new AlignCenterAction());
		barMgr.add(new AlignRightAction());
		barMgr.add(new InsColBeforeAction());
		barMgr.add(new InsColAfterAction());
		barMgr.add(new RmvColAction());
		barMgr.add(new InsRowAboveAction());
		barMgr.add(new InsRowBelowAction());
		barMgr.add(new RmvRowAction());
		barMgr.update(true);
		bar.pack();

		viewer = new TableViewer(body, style);
		GridDataFactory.fillDefaults().grab(true, true).span(2, 1).applyTo(viewer.getControl());

		table = viewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		cellMgr = new TableViewerFocusCellManager(viewer, new FocusCellOwnerDrawHighlighter(viewer));

		ColumnViewerEditorActivationStrategy activator = new ColumnViewerEditorActivationStrategy(viewer) {

			@Override
			protected boolean isEditorActivationEvent(ColumnViewerEditorActivationEvent event) {
				return event.eventType == ColumnViewerEditorActivationEvent.TRAVERSAL
						|| event.eventType == ColumnViewerEditorActivationEvent.MOUSE_DOUBLE_CLICK_SELECTION
						|| (event.eventType == ColumnViewerEditorActivationEvent.KEY_PRESSED && event.keyCode == SWT.CR)
						|| event.eventType == ColumnViewerEditorActivationEvent.PROGRAMMATIC;
			}
		};

		TableViewerEditor.create(viewer, cellMgr, activator, features);

		MenuManager mgr = new MenuManager();
		mgr.add(new InsColBeforeAction());
		mgr.add(new InsColAfterAction());
		mgr.add(new RmvColAction());
		mgr.add(new Separator());
		mgr.add(new InsRowAboveAction());
		mgr.add(new InsRowBelowAction());
		mgr.add(new RmvRowAction());
		viewer.getControl().setMenu(mgr.createContextMenu(viewer.getControl()));

		tableModel = new TableModel(stmt.getCodeUnit().getDefaultLineDelimiter());
		setInput(stmt);
		return body;
	}

	private void setInput(IStatement stmt) {
		if (tableModel.load(stmt)) {
			createColumns();
			TableContentProvider provider = new TableContentProvider(tableModel);
			viewer.setContentProvider(provider);
			viewer.setInput(stmt);
		}
	}
}
