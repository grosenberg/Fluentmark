package net.certiv.fluentmark.editor.color;

import org.eclipse.swt.graphics.RGB;


/**
 * Extends {@link net.certiv.fluentmark.editor.color.jdt.ui.text.IColorManager} with
 * the ability to bind and un-bind colors.
 *
 * @since 2.0
 */
public interface IColorManagerExtension {

	/**
	 * Remembers the given color specification under the given key.
	 *
	 * @param key the color key
	 * @param rgb the color specification
	 * @throws java.lang.UnsupportedOperationException if there is already a
	 * 	color specification remembered under the given key
	 */
	void bindColor(String key, RGB rgb);


	/**
	 * Forgets the color specification remembered under the given key.
	 *
	 * @param key the color key
	 */
	void unbindColor(String key);
}
