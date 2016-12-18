package net.certiv.fluentmark.model;

import net.certiv.fluentmark.model.Lines.Line;

/**
 * A source range defines an element's source coordinates
 */
public interface ISourceRange {

	/** Add the given line to this range */
	public void addLine(Line line);

	/**
	 * Returns the number of characters of the source code for this element.
	 */
	public int getLength();

	/**
	 * Returns the 0-based index of the first character of the source code for this element,
	 * relative to the source buffer in which this element is contained.
	 * 
	 * @return the 0-based index of the first character of the source code for this element,
	 *         relative to the source buffer in which this element is contained
	 */
	int getOffset();

	/**
	 * Returns the 0-based starting position of this element.
	 */
	public int getStartPos();

	/**
	 * Returns the 1-based starting line of this element.
	 */
	public int getBeginLine();

	/**
	 * Returns the 1-based ending line of this element.
	 */
	public int getEndLine();
}
