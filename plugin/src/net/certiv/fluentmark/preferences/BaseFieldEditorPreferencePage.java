/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.preferences;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * Fixes for the FieldEditorPreferencePage
 */
public abstract class BaseFieldEditorPreferencePage extends FieldEditorPreferencePage
		implements IWorkbenchPreferencePage {

	public BaseFieldEditorPreferencePage() {
		super();
	}

	public BaseFieldEditorPreferencePage(int style) {
		super(style);
	}

	public BaseFieldEditorPreferencePage(String title, ImageDescriptor image, int style) {
		super(title, image, style);
	}

	public BaseFieldEditorPreferencePage(String title, int style) {
		super(title, style);
	}

	/**
	 * Adjust the layout of the field editors so that they are properly aligned.
	 */
	@Override
	protected void adjustGridLayout() {
		super.adjustGridLayout();
		adjustSubLayout();
	}

	protected abstract void adjustSubLayout();

	/**
	 * Updates an embedded composite, typically in a nested Group, to the configuration of the
	 * parent composite.
	 * 
	 * @param comp the composite to adjust
	 * @param cols number of logical columns in the parent
	 */
	protected void adjust(Composite comp, int cols) {
		GridLayout layout = (GridLayout) getFieldEditorParent().getLayout();
		if (cols < 1 || cols >= layout.numColumns) return;

		((GridLayout) comp.getLayout()).numColumns = layout.numColumns;
		Composite outer = comp;
		if (comp.getParent() instanceof Group) {
			outer = comp.getParent();
		}
		((GridData) outer.getLayoutData()).horizontalSpan = layout.numColumns / cols;
	}
}
