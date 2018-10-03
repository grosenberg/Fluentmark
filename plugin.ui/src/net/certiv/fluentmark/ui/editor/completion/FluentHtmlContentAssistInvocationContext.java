package net.certiv.fluentmark.ui.editor.completion;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.ui.IEditorPart;

import net.certiv.dsl.ui.editor.text.completion.CompletionLabelProvider;
import net.certiv.dsl.ui.editor.text.completion.html.HtmlContentAssistInvocationContext;

public class FluentHtmlContentAssistInvocationContext extends HtmlContentAssistInvocationContext {

	public FluentHtmlContentAssistInvocationContext(ITextViewer viewer, int offset, IEditorPart editor, String natureId,
			int flags) {
		super(viewer, offset, editor, natureId, flags);
	}

	@Override
	protected CompletionLabelProvider createLabelProvider() {
		return new FluentCompletionLabelProvider();
	}
}
