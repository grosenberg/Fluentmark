package net.certiv.fluentmark.editor.color;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.jface.text.source.ISharedTextColors;

/**
 * Manages SWT color objects for the given color keys and given <code>RGB</code> objects. Until the
 * <code>dispose</code> method is called, the same color object is returned for equal keys and equal
 * <code>RGB</code> values.
 */
public interface IColorManager extends ISharedTextColors {

	/**
	 * Returns a color object for the given key. The color objects are remembered internally; the
	 * same color object is returned for equal keys.
	 *
	 * @param key the color key
	 * @return the color object for the given key
	 */
	Color getColor(String key);

	void setValue(String property, RGB rgb);
}
