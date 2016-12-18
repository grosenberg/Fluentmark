package net.certiv.fluentmark.editor;

import net.certiv.fluentmark.model.ISourceRange;

public interface ISourceReference {

	/**
	 * Returns the source code associated with this element.
	 * 
	 * @return the source code, or <code>null</code> if this element has no associated source code
	 */
	String getContent();

	/**
	 * Returns the source range associated with this element.
	 * 
	 * @return the source range
	 */
	ISourceRange getSourceRange();
}
