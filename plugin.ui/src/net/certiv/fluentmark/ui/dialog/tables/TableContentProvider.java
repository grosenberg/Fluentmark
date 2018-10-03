/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.ui.dialog.tables;

import org.eclipse.jface.viewers.ArrayContentProvider;

import net.certiv.fluentmark.core.model.PagePart;

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
