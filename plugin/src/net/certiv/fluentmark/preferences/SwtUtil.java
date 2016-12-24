/*******************************************************************************
 * Copyright (c) 2016 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.preferences;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.layout.LayoutConstants;
import org.eclipse.jface.layout.PixelConverter;
import org.eclipse.jface.preference.ColorSelector;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

public class SwtUtil {

	/**
	 * The default visible item count for {@link Combo}s. Workaround for
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=245569 .
	 *
	 * @see Combo#setVisibleItemCount(int)
	 * @since 3.5
	 */
	public static final int COMBO_VISIBLE_ITEM_COUNT = 30;

	private SwtUtil() {}

	public static Composite makeComposite(Composite parent, int cols) {
		Composite base = new Composite(parent, SWT.NONE);
		GridDataFactory.fillDefaults().indent(0, 4).grab(true, false).applyTo(base);
		GridLayoutFactory.fillDefaults().numColumns(cols).applyTo(base);
		return base;
	}

	public static Composite makeGroup(Composite parent, String text, int cols) {
		Group frame = new Group(parent, SWT.NONE);
		GridDataFactory.fillDefaults().indent(0, 4).grab(true, false).applyTo(frame);
		GridLayoutFactory.fillDefaults().margins(6, 6).numColumns(cols).applyTo(frame);
		frame.setText(text);
		return frame;
	}

	public static Composite makeGroupComposite(Composite parent, String text) {
		Group frame = new Group(parent, SWT.NONE);
		GridDataFactory.fillDefaults().indent(0, 4).grab(true, false).applyTo(frame);
		GridLayoutFactory.fillDefaults().margins(6, 6).applyTo(frame);
		frame.setText(text);

		Composite comp = new Composite(frame, SWT.NONE);
		GridDataFactory.fillDefaults().indent(0, 4).grab(true, false).applyTo(comp);
		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(comp);
		return comp;
	}

	public static Button makeButtonControl(Composite options, int type, String label, int span) {
		Button button = new Button(options, type);
		button.setText(label);
		GridDataFactory.fillDefaults().span(span, 1).applyTo(button);
		return button;
	}

	public static Button makeColorControl(Composite options, int span) {
		ColorSelector selector = new ColorSelector(options);
		Button button = selector.getButton();
		GridDataFactory.fillDefaults().span(span, 1).applyTo(button);
		return button;
	}

	/** Insert blank line */
	public static void addSpacer(Composite parent, int span) {
		addLabel(parent, "", span);
	}

	/** Insert label */
	public static void addLabel(Composite parent, String text, int span) {
		Label label = new Label(parent, SWT.NONE);
		label.setText(text);
		GridData gd = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		gd.horizontalSpan = span;
		label.setLayoutData(gd);
	}

	/**
	 * Returns the indent of dependent controls, in pixels.
	 * <p>
	 * <strong>Note:</strong> Use this method instead of {@link LayoutConstants#getIndent()} for
	 * compatibility reasons.
	 * </p>
	 * 
	 * @return the indent of dependent controls, in pixels.
	 * @since 3.9
	 */
	public static final int getIndent() {
		return LayoutConstants.getIndent();
	}

	/**
	 * Returns a width hint for the given button.
	 *
	 * @param button the button
	 * @return the width hint for the button
	 */
	public static int getButtonWidthHint(Button button) {
		button.setFont(JFaceResources.getDialogFont());
		PixelConverter converter = new PixelConverter(button);
		int widthHint = converter.convertHorizontalDLUsToPixels(IDialogConstants.BUTTON_WIDTH);
		return Math.max(widthHint, button.computeSize(SWT.DEFAULT, SWT.DEFAULT, true).x);
	}

	/**
	 * Sets width and height hint for the button control. <b>Note:</b> This is a NOP if the button's
	 * layout data is not an instance of <code>GridData</code>.
	 *
	 * @param button the button for which to set the dimension hint
	 */
	public static void setButtonDimensionHint(Button button) {
		Assert.isNotNull(button);
		Object gd = button.getLayoutData();
		if (gd instanceof GridData) {
			((GridData) gd).widthHint = getButtonWidthHint(button);
			((GridData) gd).horizontalAlignment = GridData.FILL;
		}
	}

	/**
	 * Sets the default visible item count for {@link Combo}s. Workaround for
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=7845 .
	 *
	 * @param combo the combo
	 * @see Combo#setVisibleItemCount(int)
	 * @see #COMBO_VISIBLE_ITEM_COUNT
	 * @since 3.5
	 */
	public static void setDefaultVisibleItemCount(Combo combo) {
		combo.setVisibleItemCount(COMBO_VISIBLE_ITEM_COUNT);
	}
}
