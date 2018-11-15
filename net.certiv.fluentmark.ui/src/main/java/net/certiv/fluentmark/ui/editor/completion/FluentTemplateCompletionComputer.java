/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.ui.editor.completion;

import net.certiv.dsl.ui.editor.text.completion.DslContentAssistInvocationContext;
import net.certiv.dsl.ui.editor.text.completion.tmpl.DslTemplateCompletionProposalComputer;
import net.certiv.dsl.ui.editor.text.completion.tmpl.DslTemplateEngine;

public class FluentTemplateCompletionComputer extends DslTemplateCompletionProposalComputer {

	@Override
	protected DslTemplateEngine computeCompletionEngine(DslContentAssistInvocationContext context) {
		return null;
	}

}
