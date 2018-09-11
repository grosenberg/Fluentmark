/*******************************************************************************
 * Copyright (c) 2018 itemis AG and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Tamas Miklossy (itemis AG) - initial API and implementation
 *******************************************************************************/
package net.certiv.fluentmark.editor.color;

import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

public class DotImageHelper {

	/*
	 * The same hex color code can belong to more than one color names (synonyms) within one color
	 * scheme
	 */
	protected void initializeImageRegistry(ImageRegistry reg) {
		for (String colorScheme : DotColorsHelper.getColorSchemes()) {
			for (String colorName : DotColorsHelper.getColorNames(colorScheme)) {
				String hex = DotColorsHelper.get(colorScheme, colorName);
				if (reg.get(hex) == null) {
					Image image = createImage(hex);
					reg.put(hex, image);
				}
			}
		}
	}

	/**
	 * Creates an SWT Image (16x16) that's background color corresponds to the given <i>colorCode</i>.
	 *
	 * @param colorCode The color code in hexadecimal format.
	 * @return The SWT Image (16x16) that's background color corresponds to the given <i>colorCode</i>.
	 */
	private Image createImage(String colorCode) {
		Display display = Display.getDefault();
		Image image = new Image(display, 16, 16);
		GC gc = new GC(image);
		Color color = hex2Rgb(display, colorCode);

		gc.setBackground(color);
		gc.fillRectangle(1, 1, 14, 14);
		gc.setForeground(display.getSystemColor(SWT.COLOR_BLACK));
		gc.drawLine(0, 0, 15, 0); // top border
		gc.drawLine(15, 0, 15, 15); // right border
		gc.drawLine(15, 15, 0, 15); // bottom border
		gc.drawLine(0, 15, 0, 0); // left border

		gc.dispose();
		return image;
	}

	private Color hex2Rgb(Display display, String colorStr) {
		return new Color(display, Integer.valueOf(colorStr.substring(1, 3), 16),
				Integer.valueOf(colorStr.substring(3, 5), 16), Integer.valueOf(colorStr.substring(5, 7), 16));
	}
}
