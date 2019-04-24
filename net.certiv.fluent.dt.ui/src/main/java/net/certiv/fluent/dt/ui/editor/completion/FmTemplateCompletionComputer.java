package net.certiv.fluent.dt.ui.editor.completion;

import net.certiv.dsl.ui.editor.text.completion.DslContentAssistInvocationContext;
import net.certiv.dsl.ui.editor.text.completion.tmpl.DslTemplateCompletionProposalComputer;
import net.certiv.dsl.ui.editor.text.completion.tmpl.DslTemplateEngine;

public class FmTemplateCompletionComputer extends DslTemplateCompletionProposalComputer {

	@Override
	protected DslTemplateEngine computeCompletionEngine(DslContentAssistInvocationContext context) {
		return null;
	}

}
