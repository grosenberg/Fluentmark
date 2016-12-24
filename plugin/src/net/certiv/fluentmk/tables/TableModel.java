/*******************************************************************************
 * Copyright (c) 2016 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmk.tables;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.eclipse.swt.SWT;

import net.certiv.fluentmark.model.PagePart;
import net.certiv.fluentmark.model.PageRoot;
import net.certiv.fluentmark.util.Strings;

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
				data[idx] = "";
			}
		}

		public String toString() {
			return num + " [" + String.join(",", data) + "]";
		}
	}

	private PagePart part;
	List<Row> rows;
	int formatRow = -1; // row in model
	int numCols;
	int[] aligns;
	int[] colWidths;
	String[] headers;

	public TableModel() {
		rows = new ArrayList<>();
	}

	public boolean load(PagePart part) {
		this.part = part;
		PageRoot model = part.getPageModel();
		for (int idx = part.getBeginLine(), row = 0; idx <= part.getEndLine(); idx++) {
			String text = model.getText(idx);
			String[] cols = parseRow(text.substring(1));
			if (text.trim().contains("---")) {
				formatRow = row;
				aligns = getAligns(cols);
				numCols = cols.length;
			}
			rows.add(new Row(idx, row, cols));
			row++;
		}
		if (rows.isEmpty()) return false;

		headers = rows.get(0).data;
		calcColWidths();
		return true;
	}

	public void insertCol(int target) {
		numCols++;
		aligns = ArrayUtils.add(aligns, target, SWT.LEFT);
		for (Row row : rows) {
			if (row.row == formatRow) {
				row.data = ArrayUtils.add(row.data, target, ":---");
			} else {
				row.data = ArrayUtils.add(row.data, target, "");
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
		for (int idx = 0, num = part.getBeginLine(); idx < rows.size(); idx++) {
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
		for (int idx = 0; idx < rows.size(); idx++) {
			if (idx == formatRow) {
				addFormatRow(sb, rows.get(idx));
				continue;
			}
			addDataRow(sb, rows.get(idx));
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

	private void addFormatRow(StringBuilder sb, Row row) {
		sb.append("|");
		for (int col = 0; col < numCols; col++) {
			if (aligns[col] == SWT.LEFT || aligns[col] == SWT.CENTER) sb.append(":");

			int min = aligns[col] == SWT.CENTER ? 5 : 4;
			sb.append("---");
			sb.append(dup("-", colWidths[col] - min));

			if (aligns[col] == SWT.RIGHT || aligns[col] == SWT.CENTER) sb.append(":");
			sb.append("|");
		}
		String existing = part.getPageModel().getText(row.num);
		int mark = existing.lastIndexOf("|");
		if (mark < existing.length() - 1) {
			sb.append(existing.substring(mark + 1));
		}
		sb.append(Strings.EOL);
	}

	private void addDataRow(StringBuilder sb, Row row) {
		sb.append("|");
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
			sb.append(dup(" ", padLeft));
			sb.append(row.data[col]);
			sb.append(dup(" ", padRight));
			sb.append("|");
		}
		String existing = part.getPageModel().getText(row.num);
		int mark = existing.lastIndexOf("|");
		if (mark < existing.length() - 1) {
			sb.append(existing.substring(mark + 1));
		}
		sb.append(Strings.EOL);
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

	private String dup(String value, int cnt) {
		StringBuilder sb = new StringBuilder();
		for (int idx = 0; idx < cnt; idx++) {
			sb.append(value);
		}
		return sb.toString();
	}
}
