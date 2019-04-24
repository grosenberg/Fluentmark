package net.certiv.fluent.dt.ui.editor.completion;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.resource.ImageDescriptor;

import net.certiv.fluent.dt.ui.FluentUI;

import net.certiv.dsl.core.completion.CompletionProposal;
import net.certiv.dsl.core.log.Log;
import net.certiv.dsl.ui.editor.text.completion.CompletionLabelProvider;

public class FmCompletionProposalLabelProvider extends CompletionLabelProvider {

	public FmCompletionProposalLabelProvider() {
		super(FluentUI.getDefault());
	}

	@Override
	public String createLabel(CompletionProposal proposal) {
		switch (proposal.getKind()) {
			case CompletionProposal.KEYWORD:
				return createKeywordLabel(proposal);
			case CompletionProposal.LABEL_REF:
				return createSimpleLabel(proposal);
			case CompletionProposal.FIELD_REF:
				return createSimpleLabel(proposal);
			default:
				Assert.isTrue(false);
				return null;
		}
	}

	@Override
	public ImageDescriptor createImageDescriptor(CompletionProposal proposal) {
		ImageDescriptor descriptor;
		switch (proposal.getKind()) {
			case CompletionProposal.KEYWORD:
				descriptor = imgMgr.getDescriptor(imgMgr.IMG_OBJS_KEYWORD);
				break;
			case CompletionProposal.LABEL_REF:
				descriptor = imgMgr.getDescriptor(imgMgr.IMG_OBJS_LABEL);
				break;
			case CompletionProposal.FIELD_REF:
				descriptor = imgMgr.getDescriptor(imgMgr.IMG_OBJS_FUNCTION);
				break;
			default:
				descriptor = null;
				Log.warn(this, "Unknown proposal type");
		}

		if (descriptor == null) return null;
		return decorateImageDescriptor(descriptor, proposal);
	}
}
