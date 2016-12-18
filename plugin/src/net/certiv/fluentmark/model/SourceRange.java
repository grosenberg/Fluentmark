package net.certiv.fluentmark.model;

import java.util.Arrays;
import java.util.Comparator;

import net.certiv.fluentmark.model.Lines.Line;

public class SourceRange implements ISourceRange {

	public static final ISourceRange UNKNOWN_RANGE = new SourceRange(-1, 0);

	protected int offset;
	protected int length;
	protected int begLine;
	protected int endLine;

	public SourceRange(int offset, int length) {
		this.offset = offset;
		this.length = length;
		begLine = 0;
		endLine = 0;
	}

	public SourceRange(int offset, int length, int begLine, int endLine) {
		this.offset = offset;
		this.length = length;
		this.begLine = begLine;
		this.endLine = endLine;
	}

	@Override
	public int getLength() {
		return length;
	}

	@Override
	public int getOffset() {
		return offset;
	}

	@Override
	public int getStartPos() {
		return offset;
	}

	@Override
	public int getBeginLine() {
		return begLine;
	}

	@Override
	public int getEndLine() {
		return endLine;
	}

	@Override
	public void addLine(Line line) {
		this.length += line.length;
		this.endLine++;
	}

	public boolean covers(SourceRange range) {
		return getStartPos() <= range.getStartPos() && getEndInclusive() >= range.getEndInclusive();
	}

	public int getEndExclusive() {
		return getStartPos() + getLength();
	}

	public int getEndInclusive() {
		return getEndExclusive() - 1;
	}

	/**
	 * Sorts the given ranges by offset (backwards). Note: modifies the parameter.
	 *
	 * @param ranges the ranges to sort
	 * @return the sorted ranges, which are identical to the parameter ranges
	 */
	public static ISourceRange[] reverseSortByOffset(ISourceRange[] ranges) {
		Comparator<ISourceRange> comparator = new Comparator<ISourceRange>() {

			@Override
			public int compare(ISourceRange o1, ISourceRange o2) {
				return o2.getStartPos() - o1.getStartPos();
			}
		};
		Arrays.sort(ranges, comparator);
		return ranges;
	}

	/**
	 * Workaround for https://bugs.eclipse.org/bugs/show_bug.cgi?id=130161 (Java Model returns
	 * ISourceRanges [-1, 0] if source not available).
	 *
	 * @param range a source range, can be <code>null</code>
	 * @return <code>true</code> iff range is not null and range.getOffset() is not -1
	 */
	public static boolean isAvailable(ISourceRange range) {
		return range != null && range.getStartPos() != -1;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Line range ");
		buffer.append(begLine + 1);
		buffer.append(" - ");
		buffer.append(endLine + 1);
		buffer.append(" ");
		buffer.append("[offset=");
		buffer.append(offset);
		buffer.append(":");
		buffer.append(length);
		buffer.append("; lines=");
		buffer.append(begLine);
		buffer.append(":");
		buffer.append(endLine);
		buffer.append("]");
		return buffer.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ISourceRange)) {
			return false;
		}
		return ((ISourceRange) obj).getStartPos() == offset && ((ISourceRange) obj).getLength() == length;
	}

	@Override
	public int hashCode() {
		return length ^ offset;
	}
}
