/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.editor.color;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

import net.certiv.fluentmark.FluentUI;
import net.certiv.fluentmark.preferences.Prefs;

public class ColorManager implements IColorManager, IColorManagerExtension {

	private boolean autoDispose;
	private IPreferenceStore store;

	protected Map<String, RGB> keyTable = new HashMap<>(10);
	protected Map<Display, Map<RGB, Color>> displayTable = new HashMap<>(2);
	private Color defColor;

	public ColorManager() {
		this(true);
	}

	public ColorManager(boolean autoDispose) {
		this.autoDispose = autoDispose;
		this.store = FluentUI.getDefault().getPreferenceStore();
		this.defColor = getColor(Prefs.EDITOR_DEFAULT_COLOR);
	}

	@Override
	public Color getColor(RGB rgb) {
		if (rgb == null) return defColor;

		final Display display = Display.getCurrent();
		Map<RGB, Color> colorTable = displayTable.get(display);
		if (colorTable == null) {
			colorTable = new HashMap<>(10);
			displayTable.put(display, colorTable);
			if (autoDispose) {
				display.disposeExec(new Runnable() {

					@Override
					public void run() {
						if (!display.isDisposed()) dispose(display);
					}
				});
			}
		}

		Color color = colorTable.get(rgb);
		if (color == null) {
			color = new Color(Display.getCurrent(), rgb);
			colorTable.put(rgb, color);
		}

		return color;
	}

	@Override
	public Color getColor(String key) {
		if (key == null) return defColor;

		RGB rgb = keyTable.get(key);
		if (rgb == null) {
			rgb = PreferenceConverter.getColor(store, key);
		}
		return getColor(rgb);
	}

	@Override
	public void setValue(String key, RGB rgb) {
		if (rgb == null) return;

		keyTable.put(key, rgb);
		getColor(rgb);
	}

	@Override
	public void bindColor(String key, RGB rgb) {
		setValue(key, rgb);
	}

	@Override
	public void unbindColor(String key) {
		keyTable.remove(key);
	}

	@Override
	public void dispose() {
		if (!autoDispose) {
			dispose(Display.getCurrent());
		}
	}

	public void dispose(Display display) {
		Map<RGB, Color> colorTable = displayTable.get(display);
		if (colorTable != null) {
			for (Color color : colorTable.values()) {
				if (color != null && !color.isDisposed()) color.dispose();
			}
		}
	}
}
