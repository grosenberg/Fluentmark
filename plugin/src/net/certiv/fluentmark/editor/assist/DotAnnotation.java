package net.certiv.fluentmark.editor.assist;

import org.eclipse.jface.text.quickassist.IQuickFixableAnnotation;
import org.eclipse.ui.texteditor.SimpleMarkerAnnotation;

public class DotAnnotation extends SimpleMarkerAnnotation implements IQuickFixableAnnotation {

	/** DOT marker type. */
	public static final String TYPE = "net.certiv.fluentmark.editor.dot"; //$NON-NLS-1$

	private DotProblem problem;

	public DotAnnotation(DotProblem problem) {
		super(problem.getMarker());
		this.problem = problem;
	}

	public DotProblem getProblem() {
		return problem;
	}

	public void deleteMarker() {
		problem.deleteMarker();
	}

	@Override
	public boolean isQuickFixable() {
		return false;
	}

	@Override
	public boolean isQuickFixableStateSet() {
		return true;
	}

	@Override
	public void setQuickFixable(boolean state) {}
}
