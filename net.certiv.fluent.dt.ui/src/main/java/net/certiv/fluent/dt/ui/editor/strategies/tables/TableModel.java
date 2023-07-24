/*******************************************************************************
 * Copyright (c) 2016 - 2020 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluent.dt.ui.editor.strategies.tables;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.swt.SWT;

import net.certiv.common.util.Strings;
import net.certiv.dsl.core.model.ICodeUnit;
import net.certiv.dsl.core.model.Statement;
import net.certiv.dsl.core.util.TextUtil;

public class TableModel {

	private String delim;

	private Statement stmt;

	private final LinkedList<Row> rows = new LinkedList<>();
	private int[] aligns;
	private int[] widths;

	private int numCols = 0; 	// rows in model
	private int defRowNum = -1; // key row in model

	public TableModel(String delim) {
		this.delim = delim;
	}

	public boolean load(Statement stmt) {
		this.stmt = stmt;
		ICodeUnit unit = stmt.getCodeUnit();

		try {
			int beg = stmt.getStartLine();
			int end = stmt.getEndLine();

			for (int line = beg, num = 0; line <= end; line++) {
				String text = TextUtil.getText(unit.getDocument(), line - 1);
				Row row = new Row(line, num, text);
				rows.add(row);
				numCols = Math.max(numCols, row.size());
				if (row.isDefRow()) defRowNum = num;
				num++;
			}

			if (rows.isEmpty()) return false;

			rows.forEach(r -> r.adjustColCount(numCols));
			initAligns();
			calcColWidths();
			return true;

		} catch (BadLocationException e) {
			return false;
		}
	}

	private void initAligns() {
		aligns = rows.get(defRowNum).row().stream() //
				.mapToInt(c -> characterize(c)).toArray();
	}

	private void calcColWidths() {
		widths = new int[numCols];
		for (int col = 0; col < numCols; col++) {
			widths[col] = aligns[col] == SWT.CENTER ? 5 : 4;
			for (Row row : rows) {
				if (row.isDefRow()) continue;
				widths[col] = Math.max(widths[col], row.get(col).length());
			}
		}
	}

	private int characterize(String col) {
		col = col.trim();
		if (col.matches("\\:---+\\:")) return SWT.CENTER;
		if (col.matches("---+\\:")) return SWT.RIGHT;
		return SWT.LEFT;
	}

	public void insertCol(int idx) {
		numCols++;
		aligns = ArrayUtils.insert(idx, aligns, SWT.LEFT);
		for (Row row : rows) {
			if (row.isDefRow()) {
				row.insert(idx, ":---");
			} else {
				row.insert(idx, Strings.EMPTY);
			}
		}
		calcColWidths();
	}

	public void removeCol(int idx) {
		numCols--;
		aligns = ArrayUtils.remove(aligns, idx);
		for (Row row : rows) {
			row.remove(idx);
		}
		calcColWidths();
	}

	public void addRow(int at) {
		if (at <= rows.size()) {
			rows.add(at, new Row(numCols));
		} else {
			rows.add(new Row(numCols));
		}
		for (int num = 0, line = stmt.getStartLine(); num < rows.size(); num++) {
			Row row = rows.get(num);
			row.setLine(line);
			row.setNum(num);
			line++;
		}
	}

	public void removeRow(int idx) {
		if (idx > defRowNum && idx < rows.size()) {
			rows.remove(idx);
		}
	}

	public int getDefineRow() {
		return defRowNum;
	}

	public int getNumCols() {
		return numCols;
	}

	public int[] getAligns() {
		return aligns;
	}

	public int getAlign(int idx) {
		return aligns[idx];
	}

	public void setAlign(int idx, int align) {
		aligns[idx] = align;
	}

	public int width(int idx) {
		return widths[idx];
	}

	public String getHeader(int idx) {
		return rows.get(0).get(idx);
	}

	public List<Row> getRows() {
		return rows;
	}

	public Object[] getElements() {
		Row[] elems = new Row[rows.size() - 1];
		for (int idx = 0, cnt = 0; idx < rows.size(); idx++) {
			if (idx == defRowNum) continue;
			elems[cnt] = rows.get(idx);
			cnt++;
		}
		return elems;
	}

	public String build() {
		calcColWidths();
		StringBuilder sb = new StringBuilder();
		try {
			for (int idx = 0; idx < rows.size(); idx++) {
				boolean last = idx == rows.size() - 1;
				if (idx == defRowNum) {
					bldDefRow(sb, rows.get(idx), last);
				} else {
					bldDataRow(sb, rows.get(idx), last);
				}
			}
		} catch (BadLocationException e) {
			return null;
		}
		return sb.toString();
	}

	private void bldDefRow(StringBuilder sb, Row row, boolean last) {
		sb.append(Strings.PIPE);
		for (int idx = 0; idx < numCols; idx++) {
			int align = aligns[idx];
			if (align == SWT.LEFT || align == SWT.CENTER) sb.append(Strings.COLON);

			int min = align == SWT.CENTER ? 5 : 4;
			sb.append("---");
			sb.append(Strings.DASH.repeat(widths[idx] - min));

			if (align == SWT.RIGHT || align == SWT.CENTER) sb.append(Strings.COLON);
			sb.append(Strings.PIPE);
		}
		sb.append(row.style());
		if (!last) sb.append(delim);
	}

	private void bldDataRow(StringBuilder sb, Row row, boolean last) throws BadLocationException {
		sb.append(Strings.PIPE);
		for (int idx = 0; idx < numCols; idx++) {
			String data = row.get(idx);
			int len = data.length();

			int colWidth = widths[idx];
			int padLeft = 0;
			int padRight = colWidth - len;
			if (aligns[idx] == SWT.CENTER) {
				padLeft = padRight / 2;
				padRight -= padLeft;
			} else if (aligns[idx] == SWT.RIGHT) {
				padLeft = padRight;
				padRight = 0;
			}
			sb.append(Strings.spaces(padLeft));
			sb.append(data);
			sb.append(Strings.spaces(padRight));
			sb.append(Strings.PIPE);
		}
		if (!last) sb.append(delim);
	}
}
