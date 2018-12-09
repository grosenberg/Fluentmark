/*******************************************************************************
 * Copyright (c) 2007, 2009 David Green and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     David Green - initial API and implementation
 *******************************************************************************/
/**
 *
 */
package net.certiv.fluentmark.ui.editor.text.css;

import org.eclipse.swt.graphics.RGB;

/**
 * @author David Green
 */
public class FontState {
	public static final int STATE_BOLD = 0x1;

	public static final int STATE_ITALIC = 0x2;

	public static final int STATE_STRIKETHROUGH = 0x4;

	public static final int STATE_UNDERLINE = 0x8;

	public static final int STATE_SUPERSCRIPT = 0x10;

	public static final int STATE_SUBSCRIPT = 0x20;

	public static final int STATE_FIXED_WIDTH = 0x40;

	/**
	 * RGB foreground color
	 */
	public RGB foreground;

	/**
	 * RGB background color
	 */
	public RGB background;

	/**
	 * State bits
	 */
	public int state;

	/**
	 * Font size multiplier
	 */
	public float sizeFactor = 1.0f;

	public FontState() {}

	public FontState(FontState copy) {
		this.foreground = copy.foreground;
		this.background = copy.background;
		this.state = copy.state;
		this.sizeFactor = copy.sizeFactor;
	}

	public boolean isBold() {
		return isSet(STATE_BOLD);
	}

	public boolean isItalic() {
		return isSet(STATE_ITALIC);
	}

	public boolean isStrikethrough() {
		return isSet(STATE_STRIKETHROUGH);
	}

	public boolean isUnderline() {
		return isSet(STATE_UNDERLINE);
	}

	public boolean isSuperscript() {
		return isSet(STATE_SUPERSCRIPT);
	}

	public boolean isSubscript() {
		return isSet(STATE_SUBSCRIPT);
	}

	public boolean isFixedWidth() {
		return isSet(STATE_FIXED_WIDTH);
	}

	public void setBold(boolean bold) {
		set(bold, STATE_BOLD);
	}

	public void setItalic(boolean value) {
		set(value, STATE_ITALIC);
	}

	public void setStrikethrough(boolean value) {
		set(value, STATE_STRIKETHROUGH);
	}

	public void setUnderline(boolean value) {
		set(value, STATE_UNDERLINE);
	}

	public void setSuperscript(boolean value) {
		set(value, STATE_SUPERSCRIPT);
	}

	public void setSubscript(boolean value) {
		set(value, STATE_SUBSCRIPT);
	}

	public void setFixedWidth(boolean value) {
		set(value, STATE_FIXED_WIDTH);
	}

	private boolean isSet(int bits) {
		return (state & bits) == bits;
	}

	private void set(boolean value, int bits) {
		if (value) {
			state |= bits;
		} else {
			state &= ~bits;
		}
	}

	public RGB getForeground() {
		return foreground;
	}

	public void setForeground(RGB foreground) {
		this.foreground = foreground;
	}

	public RGB getBackground() {
		return background;
	}

	public void setBackground(RGB background) {
		this.background = background;
	}

	public float getSizeFactor() {
		return sizeFactor;
	}

	public void setSizeFactor(float sizeFactor) {
		this.sizeFactor = sizeFactor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((background == null) ? 0 : background.hashCode());
		result = prime * result + ((foreground == null) ? 0 : foreground.hashCode());
		result = prime * result + Float.floatToIntBits(sizeFactor);
		result = prime * result + state;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final FontState other = (FontState) obj;
		if (background == null) {
			if (other.background != null) {
				return false;
			}
		} else if (!background.equals(other.background)) {
			return false;
		}
		if (foreground == null) {
			if (other.foreground != null) {
				return false;
			}
		} else if (!foreground.equals(other.foreground)) {
			return false;
		}
		if (Float.floatToIntBits(sizeFactor) != Float.floatToIntBits(other.sizeFactor)) {
			return false;
		}
		if (state != other.state) {
			return false;
		}
		return true;
	}

}
