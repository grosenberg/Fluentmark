package net.certiv.fluentmark.editor.assist;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Interval;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;

import net.certiv.fluentmark.dot.Record;
import net.certiv.fluentmark.util.Strings;

public class DotProblem {

	private final int severity;
	private final String cause;
	private final Token token;
	private final IResource res;
	private final int offset;	// start offset of DOT text
	private final int line;		// start line of DOT text
	private final int tabWidth;

	private IMarker marker;

	public DotProblem(int severity, String cause, Token token, Record record) {
		this.severity = severity;
		this.token = token;
		this.res = record.res;
		this.offset = record.docOffset;
		this.line = record.docLine;
		this.tabWidth = record.tabWidth;

		this.cause = String.format(cause, getLine(), getCharPos() + 1);
	}

	public IMarker getMarker() {
		if (marker == null) {
			try {
				marker = res.createMarker(IMarker.PROBLEM);
				marker.setAttribute(IMarker.SOURCE_ID, DotAnnotation.TYPE);
				marker.setAttribute(IMarker.SEVERITY, severity);
				marker.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_NORMAL);
				marker.setAttribute(IMarker.MESSAGE, cause);
				marker.setAttribute(IMarker.LOCATION, String.format("@%s:%s", getLine(), getVisualCharPos()));
				marker.setAttribute(IMarker.LINE_NUMBER, getLine() + 1);
				marker.setAttribute(IMarker.CHAR_START, getOffset());
				marker.setAttribute(IMarker.CHAR_END, getOffset() + getLength());
			} catch (CoreException e) {}
		}
		return marker;
	}

	public void deleteMarker() {
		if (marker != null) {
			try {
				marker.delete();
			} catch (CoreException e) {}
		}
	}

	/** Returns the assigned severity of the problem: IMarker#SEVERITY_{ERROR,WARNING,INFO}. */
	public int getSeverity() {
		return severity;
	}

	/** Returns a message string that describes the problem. */
	public String getCause() {
		return cause;
	}

	/** Returns the line of the error within the document. */
	public int getLine() {
		return line + token.getLine();
	}

	/** Returns the char position of the error in the line. */
	public int getCharPos() {
		return token.getCharPositionInLine();
	}

	/** Returns the char position of the error in the line. */
	public int getVisualCharPos() {
		int end = token.getStartIndex();
		int beg = end - token.getCharPositionInLine();
		String txt = token.getInputStream().getText(Interval.of(beg, end));
		int width = Strings.measureVisualWidth(txt, tabWidth);
		return width + 1;
	}

	/** Returns the offset of the error text within the document. */
	public int getOffset() {
		return offset + token.getStartIndex();
	}

	/** Returns the length of the error text. */
	public int getLength() {
		return token.getStopIndex() - token.getStartIndex() + 1;
	}

	@Override
	public String toString() {
		return cause;
	}

	// public ICompletionProposal[] getProposals() {}
	//
	// public ICompletionProposal[] getProposals(IQuickAssistInvocationContext context) {
	// return getProposals();
	// }
}
