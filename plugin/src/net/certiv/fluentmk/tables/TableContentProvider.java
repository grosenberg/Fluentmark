package net.certiv.fluentmk.tables;

import org.eclipse.jface.viewers.ArrayContentProvider;

import net.certiv.fluentmark.model.PagePart;

public class TableContentProvider extends ArrayContentProvider {

	private TableModel tableModel;

	public TableContentProvider(TableModel tableModel) {
		this.tableModel = tableModel;
	}

	@Override
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof PagePart) {
			return tableModel.getElements();
		}
		return super.getElements(inputElement);
	}
}
