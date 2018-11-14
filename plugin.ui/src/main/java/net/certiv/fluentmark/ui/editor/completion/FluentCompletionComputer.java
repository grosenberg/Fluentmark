package net.certiv.fluentmark.ui.editor.completion;

import net.certiv.dsl.ui.editor.text.completion.DslCompletionProposalCollector;
import net.certiv.dsl.ui.editor.text.completion.DslCompletionProposalComputer;
import net.certiv.dsl.ui.editor.text.completion.DslContentAssistInvocationContext;

public class FluentCompletionComputer extends DslCompletionProposalComputer {

	@Override
	protected DslCompletionProposalCollector createCollector(DslContentAssistInvocationContext context) {
		return new FluentCollector(context.getUnit());
	}
}
