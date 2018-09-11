/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.editor.assist;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;

/**
 * @author David Green
 */
public class MultiContentAssistProcessor implements IContentAssistProcessor {

	private IContentAssistProcessor[] delegates;

	private final char[] autoActivationCharacters = new char[0];

	private final char[] contextInformationCharacters = new char[0];

	public void addDelegate(IContentAssistProcessor processor) {
		if (delegates == null) {
			delegates = new IContentAssistProcessor[] { processor };
		} else {
			IContentAssistProcessor[] processors = new IContentAssistProcessor[delegates.length + 1];
			System.arraycopy(delegates, 0, processors, 0, delegates.length);
			processors[delegates.length] = processor;
			delegates = processors;
		}
	}

	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
		ICompletionProposal[] allProposals = null;
		for (IContentAssistProcessor delegate : delegates) {
			allProposals = merge(allProposals, delegate.computeCompletionProposals(viewer, offset));
		}
		return allProposals;
	}

	private ICompletionProposal[] merge(ICompletionProposal[] proposals1, ICompletionProposal[] proposals2) {
		ICompletionProposal[] proposals = proposals1;
		if (proposals1 == null) {
			proposals = proposals2;
		} else if (proposals2 == null) {
			proposals = proposals1;
		} else {
			proposals = new ICompletionProposal[proposals1.length + proposals2.length];
			System.arraycopy(proposals1, 0, proposals, 0, proposals1.length);
			System.arraycopy(proposals2, 0, proposals, proposals1.length, proposals2.length);
		}
		return proposals;
	}

	private IContextInformation[] merge(IContextInformation[] information1, IContextInformation[] information2) {
		IContextInformation[] information = information1;
		if (information1 == null) {
			information = information2;
		} else if (information2 == null) {
			information = information1;
		} else {
			information = new IContextInformation[information1.length + information2.length];
			System.arraycopy(information1, 0, information, 0, information1.length);
			System.arraycopy(information2, 0, information, information1.length, information2.length);
		}
		return information;
	}

	public IContextInformation[] computeContextInformation(ITextViewer viewer, int offset) {
		IContextInformation[] allInformation = null;
		for (IContentAssistProcessor delegate : delegates) {
			IContextInformation[] information = delegate.computeContextInformation(viewer, offset);
			allInformation = merge(allInformation, information);
		}
		return allInformation;
	}

	public char[] getCompletionProposalAutoActivationCharacters() {
		return autoActivationCharacters;
	}

	public char[] getContextInformationAutoActivationCharacters() {
		return contextInformationCharacters;
	}

	public IContextInformationValidator getContextInformationValidator() {
		List<IContextInformationValidator> validators = null;
		for (IContentAssistProcessor delegate : delegates) {
			IContextInformationValidator validator = delegate.getContextInformationValidator();
			if (validator != null) {
				if (validators == null) {
					validators = new ArrayList<IContextInformationValidator>();
				}
			}
		}
		if (validators != null) {
			// FIXME: return a compound validator
			return validators.get(0);
		}
		return null;
	}

	public String getErrorMessage() {
		for (IContentAssistProcessor delegate : delegates) {
			String message = delegate.getErrorMessage();
			if (message != null) {
				return message;
			}
		}
		return null;
	}

}
