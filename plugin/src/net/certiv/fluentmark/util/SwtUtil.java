/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.util;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.layout.LayoutConstants;
import org.eclipse.jface.layout.PixelConverter;
import org.eclipse.jface.preference.ColorSelector;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

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

	public static Composite makeCompositeStack(Composite parent, int span, int cols) {
		Composite stack = new Composite(parent, SWT.NONE);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).span(span, 1).grab(true, false).applyTo(stack);
		stack.setLayout(new StackLayout());
		return stack;
	}

	public static Composite makeComposite(Composite parent, int span, int cols) {
		Composite base = new Composite(parent, SWT.NONE);
		GridDataFactory.fillDefaults().indent(0, 4).span(span, 1).grab(true, false).applyTo(base);
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

	public static Composite makeGroupComposite(Composite parent, int span, int cols, String title) {
		Group frame = new Group(parent, SWT.NONE);
		GridDataFactory.fillDefaults().indent(0, 4).span(span, 1).grab(true, false).applyTo(frame);
		GridLayoutFactory.fillDefaults().margins(6, 6).applyTo(frame);
		frame.setText(title);

		Composite comp = new Composite(frame, SWT.NONE);
		GridDataFactory.fillDefaults().indent(0, 4).grab(true, false).applyTo(comp);
		GridLayoutFactory.fillDefaults().numColumns(cols).applyTo(comp);
		return comp;
	}

	public static void setGroupTitle(Composite comp, String title) {
		Group frame = null;
		Composite parent = comp.getParent();
		if (comp instanceof Group) {
			frame = (Group) comp;
		} else if (parent instanceof Group) {
			frame = (Group) parent;
		}
		if (frame != null) frame.setText(title);
	}

	public static Button makeButton(Composite comp, String label, int span) {
		return makeButton(comp, SWT.PUSH, label, span);
	}

	public static Button makeButton(Composite comp, int type, String label, int span) {
		Button button = new Button(comp, type);
		button.setText(label);
		GridDataFactory.fillDefaults().span(span, 1).applyTo(button);
		return button;
	}

	public static Text makeText(Composite comp, int span) {
		Text text = new Text(comp, SWT.BORDER | SWT.SINGLE);
		text.setLayoutData(SwtUtil.createHorizontalFillData(span));
		return text;
	}

	public static Button makeColorSelect(Composite options, int span) {
		ColorSelector selector = new ColorSelector(options);
		Button button = selector.getButton();
		GridDataFactory.fillDefaults().span(span, 1).applyTo(button);
		return button;
	}

	/** Insert blank line */
	public static void addSpacer(Composite parent, int span) {
		makeLabel(parent, "", span);
	}

	/** Insert label */
	public static void makeLabel(Composite parent, String text, int span) {
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

	// ---------------------------------------------------------------

	private final static int HORIZONTAL_DIALOG_UNIT_PER_CHAR = 4;
	private final static int BUTTON_WIDTH = 61;

	public static Point computeSizeConstraints(Control control, int widthInChars, int heightInChars) {
		GC gc = new GC(control);
		gc.setFont(control.getFont());
		int width = (int) gc.getFontMetrics().getAverageCharacterWidth();
		int height = gc.getFontMetrics().getHeight();
		gc.dispose();
		return new Point(widthInChars * width, heightInChars * height);
	}

	public static int getAvgCharWidth(Control control) {
		GC gc = new GC(control);
		gc.setFont(control.getFont());
		int width = (int) gc.getFontMetrics().getAverageCharacterWidth();
		gc.dispose();
		return width;
	}

	public static GridLayout createGridLayout(int columns, int margin, int spacing) {
		GridLayout layout = new GridLayout(columns, false);
		layout.marginWidth = margin;
		layout.marginHeight = margin;
		layout.horizontalSpacing = spacing;
		layout.verticalSpacing = spacing;
		return layout;
	}

	public static GridData createHorizontalFillData(int hSpan) {
		return new GridData(SWT.FILL, GridData.CENTER, true, false, hSpan, 1);
	}

	public static GridData createFillData() {
		return new GridData(SWT.FILL, SWT.FILL, true, true);
	}

	public static GridData createButtonLayoutData(Control control) {
		GridData layoutData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		int minWidth = getButtonMinWidth(control);
		Point preferedSize = control.computeSize(SWT.DEFAULT, SWT.DEFAULT, true);
		layoutData.widthHint = Math.max(minWidth, preferedSize.x);
		return layoutData;
	}

	private static int getButtonMinWidth(Control control) {
		float charWidth = getAvgCharWidth(control);
		float width = charWidth * BUTTON_WIDTH + HORIZONTAL_DIALOG_UNIT_PER_CHAR / 2;
		return (int) (width / HORIZONTAL_DIALOG_UNIT_PER_CHAR);
	}
}
