/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.ui.editor.completion;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.templates.TemplateContextType;

import net.certiv.dsl.ui.editor.text.completion.DslContentAssistInvocationContext;
import net.certiv.dsl.ui.editor.text.completion.tmpl.DslTemplateCompletionProcessor;
import net.certiv.dsl.ui.templates.DslTemplateAccess;
import net.certiv.fluentmark.ui.FluentUI;

public class FluentTemplateCompletionProcessor extends DslTemplateCompletionProcessor {

	public FluentTemplateCompletionProcessor(DslContentAssistInvocationContext context) {
		super(FluentUI.getDefault(), context);
	}

	@Override
	protected String getContextTypeId() {
		return FluentTemplateContextType.CONTEXT_TYPE_ID;
	}

	@Override
	protected DslTemplateAccess getTemplateAccess() {
		return FluentTemplateAccess.getInstance();
	}

	// NOTE: this handles empty prefixes
	// TODO: implement for globally enabling blank line template completions
	protected boolean isValid(ITextViewer viewer, Region region, String prefix) {
		if (prefix == null) return false;
		if (prefix.length() == 0) {
			TemplateContextType contextType = getContextType(viewer, region);
			String cId = contextType.getId();
			if (FluentTemplateContextType.CONTEXT_TYPE_ID.equals(cId)) return true;
			return false;
		}
		return true;
	}

	@Override
	protected TemplateContextType getContextType(ITextViewer viewer, IRegion region) {
		// IDocumentExtension3 doc = (IDocumentExtension3) viewer.getDocument();
		// ITypedRegion typedRegion = null;
		// try {
		// typedRegion = doc.getPartition(Partitions.PARTITIONING, region.getOffset(), true);
		// } catch (BadLocationException | BadPartitioningException e) {
		// e.printStackTrace();
		// }
		// if (typedRegion == null) return null;
		// String type = typedRegion.getType();
		//
		// if (type.equals(IDocument.DEFAULT_CONTENT_TYPE)) {
		// return getTemplateAccess().getContextTypeRegistry()
		// .getContextType(FluentTemplateContextType.GRAMMAR_CONTEXT_TYPE_ID);
		// } else if (type.equals(Partitions.COMMENT_JD)) {
		// return getTemplateAccess().getContextTypeRegistry()
		// .getContextType(FluentTemplateContextType.JAVADOC_CONTEXT_TYPE_ID);
		// } else if (isValidPartition(type)) {
		// return getTemplateAccess().getContextTypeRegistry()
		// .getContextType(FluentTemplateContextType.ACTIONS_CONTEXT_TYPE_ID);
		// }

		return super.getContextType(viewer, region);
	}

	// private boolean isValidPartition(String type) {
	// for (String partition : Partitions.getContentTypes()) {
	// if (type.equals(partition)) return true;
	// }
	// return false;
	// }
	//
	// @Override
	// protected Template[] getTemplates(String contextTypeId) {
	// if (contextTypeId.equals(FluentTemplateContextType.GRAMMAR_CONTEXT_TYPE_ID)
	// || contextTypeId.equals(FluentTemplateContextType.OPTIONS_CONTEXT_TYPE_ID)
	// || contextTypeId.equals(FluentTemplateContextType.ACTIONS_CONTEXT_TYPE_ID)
	// || contextTypeId.equals(FluentTemplateContextType.JAVADOC_CONTEXT_TYPE_ID)) {
	// return getTemplateAccess().getTemplateStore().getTemplates(contextTypeId);
	// }
	// return new Template[0];
	// }
}
