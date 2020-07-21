/*******************************************************************************
 * Copyright (c) 2016 - 2020 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluent.dt.ui.editor.strategies.tables;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.swt.SWT;

import net.certiv.dsl.core.model.ICodeUnit;
import net.certiv.dsl.core.model.IStatement;
import net.certiv.dsl.core.model.Statement;
import net.certiv.dsl.core.util.Strings;
import net.certiv.dsl.core.util.TextUtils;

public class TableModel {

	public static class Row {

		int num; // doc line #
		int row; // table row #
		String[] data;

		public Row(int num, int row, String[] data) {
			this.num = num;
			this.row = row;
			this.data = data;
		}

		public Row(int numCols) {
			data = new String[numCols];
			for (int idx = 0; idx < data.length; idx++) {
				data[idx] = Strings.EMPTY;
			}
		}

		@Override
		public String toString() {
			return num + " [" + String.join(Strings.COMMA, data) + "]";
		}
	}

	private Statement stmt;
	private String delim;

	List<Row> rows;
	int formatRow = -1; // row in model
	int numCols;
	int[] aligns;
	int[] colWidths;
	String[] headers;

	public TableModel(String delim) {
		this.delim = delim;
		rows = new ArrayList<>();
	}

	public boolean load(IStatement stmt) {
		this.stmt = (Statement) stmt;
		ICodeUnit unit = stmt.getCodeUnit();

		try {
			for (int lnum = this.stmt.getStartLine(), row = 0; lnum <= this.stmt.getEndLine(); lnum++) {
				String text = TextUtils.getText(unit.getDocument(), lnum - 1);
				String[] cols = parseRow(text.substring(1));
				if (text.trim().contains("---")) {
					formatRow = row;
					aligns = getAligns(cols);
					numCols = cols.length;
				}
				rows.add(new Row(lnum, row, cols));
				row++;
			}
			if (rows.isEmpty()) return false;

			headers = rows.get(0).data;
			calcColWidths();
			return true;

		} catch (BadLocationException e) {
			return false;
		}
	}

	public void insertCol(int target) {
		numCols++;
		aligns = ArrayUtils.insert(target, aligns, SWT.LEFT);
		for (Row row : rows) {
			if (row.row == formatRow) {
				row.data = ArrayUtils.insert(target, row.data, ":---");
			} else {
				row.data = ArrayUtils.insert(target, row.data, Strings.EMPTY);
			}
		}
		headers = rows.get(0).data;
		calcColWidths();
	}

	public void removeCol(int target) {
		numCols--;
		aligns = ArrayUtils.remove(aligns, target);
		for (Row row : rows) {
			row.data = ArrayUtils.remove(row.data, target);
		}
		headers = rows.get(0).data;
		calcColWidths();
	}

	public void addRow(int target) {
		if (target <= rows.size()) {
			rows.add(target, new Row(numCols));
		}
		for (int idx = 0, num = stmt.getStartLine(); idx < rows.size(); idx++) {
			rows.get(idx).row = idx;
			rows.get(idx).num = num;
			num++;
		}
	}

	public void removeRow(int target) {
		if (target > formatRow && target < rows.size()) {
			rows.remove(target);
		}
	}

	public int getFormatRow() {
		return formatRow;
	}

	public int getNumCols() {
		return numCols;
	}

	public int[] getAligns() {
		return aligns;
	}

	public List<Row> getRows() {
		return rows;
	}

	public Object[] getElements() {
		Row[] elements = new Row[rows.size() - 1];
		for (int idx = 0, cnt = 0; idx < rows.size(); idx++) {
			if (idx == formatRow) continue;
			elements[cnt] = rows.get(idx);
			cnt++;
		}
		return elements;
	}

	public String build() {
		calcColWidths();
		StringBuilder sb = new StringBuilder();
		try {
			for (int idx = 0; idx < rows.size(); idx++) {
				boolean last = idx == rows.size() - 1;
				if (idx == formatRow) {
					addFormatRow(sb, rows.get(idx), last);
				} else {
					addDataRow(sb, rows.get(idx), last);
				}
			}
		} catch (BadLocationException e) {
			return null;
		}
		return sb.toString();
	}

	private void calcColWidths() {
		colWidths = new int[numCols];
		for (int col = 0; col < numCols; col++) {
			colWidths[col] = aligns[col] == SWT.CENTER ? 5 : 4;
			for (Row row : rows) {
				if (row.row == formatRow) continue;
				colWidths[col] = Math.max(colWidths[col], row.data[col].length());
			}
		}
	}

	private void addFormatRow(StringBuilder sb, Row row, boolean last) throws BadLocationException {
		sb.append(Strings.PIPE);
		for (int col = 0; col < numCols; col++) {
			if (aligns[col] == SWT.LEFT || aligns[col] == SWT.CENTER) sb.append(Strings.COLON);

			int min = aligns[col] == SWT.CENTER ? 5 : 4;
			sb.append("---");
			sb.append(Strings.dup(colWidths[col] - min, "-"));

			if (aligns[col] == SWT.RIGHT || aligns[col] == SWT.CENTER) sb.append(Strings.COLON);
			sb.append(Strings.PIPE);
		}

		// add any text following the table row
		String txt = TextUtils.getText(stmt.getCodeUnit().getDocument(), row.num - 1);
		int dot = txt.lastIndexOf(Strings.PIPE);
		if (dot < txt.length() - 1) {
			sb.append(Strings.trimRight(txt.substring(dot + 1)));
		}
		if (!last) sb.append(delim);
	}

	private void addDataRow(StringBuilder sb, Row row, boolean last) throws BadLocationException {
		sb.append(Strings.PIPE);
		for (int col = 0; col < numCols; col++) {
			int colWidth = colWidths[col];
			int padLeft = 0;
			int padRight = colWidth - row.data[col].length();
			if (aligns[col] == SWT.CENTER) {
				padLeft = padRight / 2;
				padRight -= padLeft;
			} else if (aligns[col] == SWT.RIGHT) {
				padLeft = padRight;
				padRight = 0;
			}
			sb.append(Strings.dup(padLeft, Strings.SPACE));
			sb.append(row.data[col]);
			sb.append(Strings.dup(padRight, Strings.SPACE));
			sb.append(Strings.PIPE);
		}

		// add any text following the table row
		String txt = TextUtils.getText(stmt.getCodeUnit().getDocument(), row.num - 1);
		int dot = txt.lastIndexOf(Strings.PIPE);
		if (dot < txt.length() - 1) {
			sb.append(Strings.trimRight(txt.substring(dot + 1)));
		}
		if (!last) sb.append(delim);
	}

	private String[] parseRow(String text) {
		int end = text.lastIndexOf('|');
		text = text.substring(0, end);
		String[] cols = text.split("(?<!\\\\)\\|", -1);
		for (int idx = 0; idx < cols.length; idx++) {
			cols[idx] = cols[idx].trim();
		}
		return cols;
	}

	private int[] getAligns(String[] cols) {
		int[] aligns = new int[cols.length];
		for (int idx = 0; idx < cols.length; idx++) {
			aligns[idx] = characterize(cols[idx]);
		}
		return aligns;
	}

	private int characterize(String col) {
		col = col.trim();
		if (col.matches("\\:---+\\:")) return SWT.CENTER;
		if (col.matches("---+\\:")) return SWT.RIGHT;
		return SWT.LEFT;
	}
}
