package net.certiv.fluent.dt.ui.editor.completion;

import net.certiv.dsl.ui.editor.text.completion.DslCompletionProposalCollector;
import net.certiv.dsl.ui.editor.text.completion.DslCompletionProposalComputer;
import net.certiv.dsl.ui.editor.text.completion.DslContentAssistInvocationContext;

public class FmCodeCompletionComputer extends DslCompletionProposalComputer {

	@Override
	protected DslCompletionProposalCollector createCollector(DslContentAssistInvocationContext context) {
		return null;
	}

}
