/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluent.dt.ui.editor.strategies.tables;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ColumnViewerEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TableViewerFocusCellManager;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import net.certiv.fluent.dt.ui.FluentUI;
import net.certiv.fluent.dt.ui.ImageManager;
import net.certiv.fluent.dt.ui.editor.strategies.tables.TableModel.Row;

public class TableDialogActions extends MessageDialog {

	protected static final int features = ColumnViewerEditor.TABBING_HORIZONTAL
			| ColumnViewerEditor.TABBING_MOVE_TO_ROW_NEIGHBOR | ColumnViewerEditor.TABBING_VERTICAL
			| ColumnViewerEditor.KEYBOARD_ACTIVATION;

	protected ImageManager imgMgr;
	protected TableViewer viewer;
	protected Table table;
	protected TableModel tableModel;
	protected TableViewerFocusCellManager cellMgr;

	public class AlignLeftAction extends Action {

		public AlignLeftAction() {
			super("Left Align");
			setImageDescriptor(imgMgr.getDescriptor(imgMgr.IMG_OBJ_LEFT));
		}

		@Override
		public void run() {
			ViewerCell cell = cellMgr.getFocusCell();
			int target = cell != null ? cell.getColumnIndex() : 0;
			target = target < 0 ? tableModel.numCols : target;
			tableModel.aligns[target] = SWT.LEFT;
			recreateCols();
		}
	}

	public class AlignCenterAction extends Action {

		public AlignCenterAction() {
			super("Center Align");
			setImageDescriptor(imgMgr.getDescriptor(imgMgr.IMG_OBJ_CENTER));
		}

		@Override
		public void run() {
			ViewerCell cell = cellMgr.getFocusCell();
			int target = cell != null ? cell.getColumnIndex() : 0;
			target = target < 0 ? tableModel.numCols : target;
			tableModel.aligns[target] = SWT.CENTER;
			recreateCols();
		}
	}

	public class AlignRightAction extends Action {

		public AlignRightAction() {
			super("Right Align");
			setImageDescriptor(imgMgr.getDescriptor(imgMgr.IMG_OBJ_RIGHT));
		}

		@Override
		public void run() {
			ViewerCell cell = cellMgr.getFocusCell();
			int target = cell != null ? cell.getColumnIndex() : 0;
			target = target < 0 ? tableModel.numCols : target;
			tableModel.aligns[target] = SWT.RIGHT;
			recreateCols();
		}
	}

	public class InsColBeforeAction extends Action {

		public InsColBeforeAction() {
			super("Insert Column Before");
			setImageDescriptor(imgMgr.getDescriptor(imgMgr.IMG_OBJ_COL_INS_BEF));
		}

		@Override
		public void run() {
			ViewerCell cell = cellMgr.getFocusCell();
			int target = cell != null ? cell.getColumnIndex() : 0;
			target = target < 0 ? tableModel.numCols : target;
			tableModel.insertCol(target);
			recreateCols();
		}
	}

	public class InsColAfterAction extends Action {

		public InsColAfterAction() {
			super("Insert Column After");
			setImageDescriptor(imgMgr.getDescriptor(imgMgr.IMG_OBJ_COL_INS_AFT));
		}

		@Override
		public void run() {
			ViewerCell cell = cellMgr.getFocusCell();
			int target = cell != null ? cell.getColumnIndex() : 0;
			target = target < 0 ? tableModel.numCols : target;
			tableModel.insertCol(target + 1);
			recreateCols();
		}
	}

	public class RmvColAction extends Action {

		public RmvColAction() {
			super("Delete Column");
			setImageDescriptor(imgMgr.getDescriptor(imgMgr.IMG_OBJ_COL_DEL));
		}

		@Override
		public void run() {
			ViewerCell cell = cellMgr.getFocusCell();
			int target = cell != null ? cell.getColumnIndex() : 0;
			if (target < 0 || target >= tableModel.numCols) return;
			tableModel.removeCol(target);
			recreateCols();
		}
	}

	public class InsRowAboveAction extends Action {

		public InsRowAboveAction() {
			super("Insert Row Above");
			setImageDescriptor(imgMgr.getDescriptor(imgMgr.IMG_OBJ_ROW_INS_ABV));
		}

		@Override
		public void run() {
			TableItem[] items = table.getSelection();
			if (items == null || items.length == 0) return;
			int target = table.indexOf(items[0]);
			if (target < 1) return;

			tableModel.addRow(target + 1);
			viewer.refresh();
		}
	}

	public class InsRowBelowAction extends Action {

		public InsRowBelowAction() {
			super("Insert Row Below");
			setImageDescriptor(imgMgr.getDescriptor(imgMgr.IMG_OBJ_ROW_INS_BLW));
		}

		@Override
		public void run() {
			TableItem[] items = table.getSelection();
			if (items == null || items.length == 0) return;
			int target = table.indexOf(items[0]);
			if (target < 1) return;

			tableModel.addRow(target + 2);
			viewer.refresh();
		}
	}

	public class RmvRowAction extends Action {

		public RmvRowAction() {
			super("Delete Row");
			setImageDescriptor(imgMgr.getDescriptor(imgMgr.IMG_OBJ_ROW_DEL));
		}

		@Override
		public void run() {
			TableItem[] items = table.getSelection();
			if (items == null || items.length == 0) return;
			int target = table.indexOf(items[0]);
			if (target < 1) return;

			tableModel.removeRow(target + 1);
			viewer.refresh();
		}
	}

	private class TableEditingSupport extends EditingSupport {

		private TextCellEditor editor;
		private int idx;

		public TableEditingSupport(ColumnViewer viewer, int idx) {
			super(viewer);
			this.editor = new TextCellEditor((Composite) viewer.getControl());
			this.idx = idx;
		}

		@Override
		protected boolean canEdit(Object element) {
			return element instanceof Row;
		}

		@Override
		protected CellEditor getCellEditor(Object element) {
			return editor;
		}

		@Override
		protected Object getValue(Object element) {
			return ((Row) element).data[idx];
		}

		@Override
		protected void setValue(Object element, Object value) {
			((Row) element).data[idx] = (String) value;
			viewer.refresh();
		}
	}

	public TableDialogActions(Shell parentShell, String dialogTitle, Image dialogTitleImage, String dialogMessage,
			int dialogImageType, int defaultIndex, String... dialogButtonLabels) {
		super(parentShell, dialogTitle, dialogTitleImage, dialogMessage, dialogImageType, defaultIndex,
				dialogButtonLabels);
		imgMgr = FluentUI.getDefault().getImageManager();
	}

	protected void createColumns() {
		for (int idx = 0; idx < tableModel.numCols; idx++) {
			int align = tableModel.aligns[idx];
			createColumn(idx, align);
		}
	}

	private void createColumn(int idx, int align) {
		TableViewerColumn viewerColumn = new TableViewerColumn(viewer, align, idx);
		viewerColumn.setEditingSupport(new TableEditingSupport(viewer, idx));
		viewerColumn.setLabelProvider(new ColumnLabelProvider() {

			private int col = idx;

			@Override
			public String getText(Object element) {
				if (element instanceof Row) {
					return ((Row) element).data[col];
				}
				return super.getText(element);
			}
		});

		TableColumn column = viewerColumn.getColumn();
		column.setResizable(true);
		column.setMoveable(true);

		column.setText(tableModel.headers[idx]);

		int width = convertWidthInCharsToPixels(tableModel.colWidths[idx]);
		width = Math.max(width, 50);
		column.setWidth(width);
	}

	private void recreateCols() {
		int cnt = table.getColumnCount();
		for (int idx = 0; idx < cnt; idx++) {
			table.getColumn(0).dispose();
		}
		createColumns();
		viewer.refresh();
	}
}
