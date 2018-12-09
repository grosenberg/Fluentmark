package net.certiv.fluentmark.ui.editor.completion;

import org.eclipse.jface.resource.ImageDescriptor;

import net.certiv.dsl.core.completion.CompletionProposal;
import net.certiv.dsl.core.log.Log;
import net.certiv.dsl.ui.editor.text.completion.CompletionLabelProvider;
import net.certiv.fluentmark.ui.FluentUI;

public class FluentCompletionLabelProvider extends CompletionLabelProvider {

	public FluentCompletionLabelProvider() {
		super(FluentUI.getDefault());
	}

	@Override
	public ImageDescriptor createImageDescriptor(CompletionProposal proposal) {
		ImageDescriptor descriptor = null;
		switch (proposal.getKind()) {
			case CompletionProposal.KEYWORD:
				descriptor = imgMgr.getDescriptor(imgMgr.IMG_OBJS_KEYWORD);
				break;
			default:
				descriptor = null;
				Log.warn(this, "Unknown proposal type");
		}

		if (descriptor == null) return null;
		return decorateImageDescriptor(descriptor, proposal);
	}

	@Override
	public String createLabel(CompletionProposal proposal) {
		switch (proposal.getKind()) {
			case CompletionProposal.KEYWORD:
				return createKeywordLabel(proposal);
			default:
				return createSimpleLabel(proposal);
		}
	}
}
