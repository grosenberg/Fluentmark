/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.editor;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IInformationControl;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.IInformationControlExtension;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import net.certiv.fluentmark.FluentUI;
import net.certiv.fluentmark.preferences.Prefs;

/**
 * Source viewer based implementation of <code>IInformationControl</code>. Displays information in a
 * source viewer.
 */
public class FluentSourceViewerInfoControl
		implements IInformationControl, IInformationControlExtension, DisposeListener {

	private Shell shell;
	private StyledText text;
	private SourceViewer viewer;
	private Font textFont;
	private Label statusField;
	private Label separator;
	private Font statusTextFont;
	private int maxWidth = SWT.DEFAULT;
	private int maxHeight = SWT.DEFAULT;
	private final int orientation;

	private Color backgroundColor;
	private boolean isSystemBackgroundColor = true;

	/**
	 * Creates a default information control with the given shell as parent. The given information
	 * presenter is used to process the information to be displayed. The given styles are applied to the
	 * created styled text widget.
	 *
	 * @param dslUI
	 * @param parent the parent shell
	 * @param isResizeable
	 * @param orientation
	 * @param statusFieldText the text to be used in the optional status field or <code>null</code> if
	 *            the status field should be hidden
	 */
	public FluentSourceViewerInfoControl(Shell parent, boolean isResizable, int orientation, String statusFieldText) {

		Assert.isLegal(orientation == SWT.RIGHT_TO_LEFT || orientation == SWT.LEFT_TO_RIGHT || orientation == SWT.NONE);
		this.orientation = orientation;

		GridLayout layout;
		GridData gd;

		int shellStyle = SWT.TOOL | SWT.ON_TOP | orientation | (isResizable ? SWT.RESIZE : 0);
		int textStyle = isResizable ? SWT.V_SCROLL | SWT.H_SCROLL : SWT.NONE;

		shell = new Shell(parent, SWT.NO_FOCUS | SWT.ON_TOP | shellStyle);
		Display display = shell.getDisplay();

		initializeColors();

		Composite composite = shell;
		layout = new GridLayout(1, false);
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		composite.setLayout(layout);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		composite.setLayoutData(gd);

		if (statusFieldText != null) {
			composite = new Composite(composite, SWT.NONE);
			layout = new GridLayout(1, false);
			layout.marginHeight = 0;
			layout.marginWidth = 0;
			layout.verticalSpacing = 1;
			composite.setLayout(layout);
			gd = new GridData(GridData.FILL_BOTH);
			composite.setLayoutData(gd);
			composite.setForeground(display.getSystemColor(SWT.COLOR_INFO_FOREGROUND));
			composite.setBackground(backgroundColor);
		}

		// Source viewer
		createViewer(textStyle, composite);
		viewer.setEditable(false);

		text = viewer.getTextWidget();
		gd = new GridData(GridData.BEGINNING | GridData.FILL_BOTH);
		text.setLayoutData(gd);
		text.setForeground(display.getSystemColor(SWT.COLOR_INFO_FOREGROUND));
		text.setBackground(backgroundColor);

		initializeFont();

		text.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.character == 0x1B) {
					shell.dispose();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {}
		});

		// Status field
		if (statusFieldText != null) {

			// Horizontal separator line
			separator = new Label(composite, SWT.SEPARATOR | SWT.HORIZONTAL | SWT.LINE_DOT);
			separator.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

			// Status field label
			statusField = new Label(composite, SWT.RIGHT);
			statusField.setText(statusFieldText);
			Font font = statusField.getFont();
			FontData[] fontDatas = font.getFontData();
			for (FontData fontData : fontDatas) {
				fontData.setHeight(fontData.getHeight() * 9 / 10);
			}
			statusTextFont = new Font(statusField.getDisplay(), fontDatas);
			statusField.setFont(statusTextFont);
			GridData gd2 = new GridData(GridData.FILL_HORIZONTAL | GridData.VERTICAL_ALIGN_BEGINNING);
			statusField.setLayoutData(gd2);

			// Regarding the color see bug 41128
			statusField.setForeground(display.getSystemColor(SWT.COLOR_WIDGET_DARK_SHADOW));
			statusField.setBackground(backgroundColor);
		}

		addDisposeListener(this);
	}

	protected void createViewer(int style, Composite composite) {
		FluentUI mkUI = FluentUI.getDefault();
		FluentTextTools textTools = mkUI.getTextTools();
		IPreferenceStore store = mkUI.getPreferenceStore();
		SourceViewerConfiguration viewerConfig = textTools.createSimpleSourceViewerConfiguration(store);
		viewer = new FluentSourceViewer(composite, null, null, false, style, store);
		viewer.configure(viewerConfig);
	}

	private void initializeColors() {
		RGB bgRGB = getHoverBackgroundColorRGB();
		if (bgRGB != null) {
			backgroundColor = new Color(shell.getDisplay(), bgRGB);
			isSystemBackgroundColor = false;
		} else {
			backgroundColor = shell.getDisplay().getSystemColor(SWT.COLOR_INFO_BACKGROUND);
			isSystemBackgroundColor = true;
		}
	}

	private RGB getHoverBackgroundColorRGB() {
		return null;
	}

	private void initializeFont() {
		textFont = JFaceResources.getFont(Prefs.EDITOR_TEXT_FONT);
		StyledText styledText = getViewer().getTextWidget();
		styledText.setFont(textFont);
	}

	public void setInput(Object input) {
		if (input instanceof String) {
			setInformation((String) input);
		} else {
			setInformation(null);
		}
	}

	@Override
	public void setInformation(String content) {
		if (content == null) {
			viewer.setInput(null);
			return;
		}

		IDocument doc = new Document(content);
		FluentTextTools textTools = FluentUI.getDefault().getTextTools();
		if (textTools != null) {
			textTools.setupDocument(doc);
		}
		viewer.setInput(doc);
	}

	@Override
	public void setVisible(boolean visible) {
		shell.setVisible(visible);
	}

	@Override
	public void widgetDisposed(DisposeEvent event) {
		if (statusTextFont != null && !statusTextFont.isDisposed()) {
			statusTextFont.dispose();
		}

		statusTextFont = null;
		// textFont = null;
		shell = null;
		text = null;
	}

	@Override
	public final void dispose() {
		if (!isSystemBackgroundColor) {
			backgroundColor.dispose();
		}
		if (shell != null && !shell.isDisposed()) {
			shell.dispose();
		} else {
			widgetDisposed(null);
		}
	}

	@Override
	public void setSize(int width, int height) {
		shell.setSize(width, height);
	}

	@Override
	public void setLocation(Point location) {
		shell.setLocation(location);
	}

	@Override
	public void setSizeConstraints(int maxWidth, int maxHeight) {
		this.maxWidth = maxWidth;
		this.maxHeight = maxHeight;
	}

	@Override
	public Point computeSizeHint() {
		// compute the preferred size
		int x = SWT.DEFAULT;
		int y = SWT.DEFAULT;
		Point size = shell.computeSize(x, y);
		if (size.x > maxWidth) {
			x = maxWidth;
		}
		if (size.y > maxHeight) {
			y = maxHeight;
		}

		// recompute using constraints if preferred size is larger than constraints
		if (x != SWT.DEFAULT || y != SWT.DEFAULT) {
			size = shell.computeSize(x, y, false);
		}

		return size;
	}

	@Override
	public void addDisposeListener(DisposeListener listener) {
		shell.addDisposeListener(listener);
	}

	@Override
	public void removeDisposeListener(DisposeListener listener) {
		shell.removeDisposeListener(listener);
	}

	@Override
	public void setForegroundColor(Color foreground) {
		text.setForeground(foreground);
	}

	@Override
	public void setBackgroundColor(Color background) {
		text.setBackground(background);
	}

	@Override
	public boolean isFocusControl() {
		return text.isFocusControl();
	}

	@Override
	public void setFocus() {
		shell.forceFocus();
		text.setFocus();
	}

	@Override
	public void addFocusListener(FocusListener listener) {
		text.addFocusListener(listener);
	}

	@Override
	public void removeFocusListener(FocusListener listener) {
		text.removeFocusListener(listener);
	}

	@Override
	public boolean hasContents() {
		return text.getCharCount() > 0;
	}

	protected ISourceViewer getViewer() {
		return viewer;
	}

	public Rectangle computeTrim() {
		Rectangle trim = shell.computeTrim(0, 0, 0, 0);
		addInternalTrim(trim);
		return trim;
	}

	private void addInternalTrim(Rectangle trim) {
		Rectangle textTrim = text.computeTrim(0, 0, 0, 0);
		trim.x += textTrim.x;
		trim.y += textTrim.y;
		trim.width += textTrim.width;
		trim.height += textTrim.height;

		if (statusField != null) {
			trim.height += separator.computeSize(SWT.DEFAULT, SWT.DEFAULT).y;
			trim.height += statusField.computeSize(SWT.DEFAULT, SWT.DEFAULT).y;
			trim.height += 1; // verticalSpacing
		}
	}

	public Rectangle getBounds() {
		return shell.getBounds();
	}

	public boolean restoresLocation() {
		return false;
	}

	public boolean restoresSize() {
		return false;
	}

	public IInformationControlCreator getInformationPresenterControlCreator() {
		return new IInformationControlCreator() {

			@Override
			public IInformationControl createInformationControl(Shell parent) {
				return new FluentSourceViewerInfoControl(parent, true, orientation, null);
			}
		};
	}

	public boolean containsControl(Control control) {
		do {
			if (control == shell) return true;
			if (control instanceof Shell) return false;
			control = control.getParent();
		} while (control != null);
		return false;
	}

	public boolean isVisible() {
		return shell != null && !shell.isDisposed() && shell.isVisible();
	}
}
