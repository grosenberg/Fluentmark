/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.editor.assist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.contentassist.BoldStylerProvider;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposalExtension;
import org.eclipse.jface.text.contentassist.ICompletionProposalExtension2;
import org.eclipse.jface.text.contentassist.ICompletionProposalExtension3;
import org.eclipse.jface.text.contentassist.ICompletionProposalExtension4;
import org.eclipse.jface.text.contentassist.ICompletionProposalExtension6;
import org.eclipse.jface.text.contentassist.ICompletionProposalExtension7;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.texteditor.ITextEditor;

import net.certiv.fluentmark.dot.Attr;
import net.certiv.fluentmark.dot.AttrMap;
import net.certiv.fluentmark.dot.ContextVisitor;
import net.certiv.fluentmark.dot.Record;
import net.certiv.fluentmark.editor.FluentEditor;
import net.certiv.fluentmark.editor.Partitions;

public class DotCompletionProcessor implements IContentAssistProcessor {

	private static final ICompletionProposal[] NO_PROPOSALS = new ICompletionProposal[0];
	private static final IContextInformation[] NO_CONTEXTS = new IContextInformation[0];

	private static final class Proposal implements ICompletionProposal, ICompletionProposalExtension,
			ICompletionProposalExtension2, ICompletionProposalExtension3, ICompletionProposalExtension4,
			ICompletionProposalExtension6, ICompletionProposalExtension7 {

		private final String fString;
		private final String fPrefix;
		private final int fOffset;
		private StyledString fDisplayString;

		public Proposal(String string, String prefix, int offset) {
			this.fString = string;
			this.fPrefix = prefix;
			this.fOffset = offset;
		}

		@Override
		public void apply(IDocument document) {
			apply(null, '\0', 0, fOffset);
		}

		@Override
		public Point getSelection(IDocument document) {
			return new Point(fOffset + fString.length(), 0);
		}

		@Override
		public String getAdditionalProposalInfo() {
			return null;
		}

		@Override
		public String getDisplayString() {
			return fPrefix + fString;
		}

		@Override
		public Image getImage() {
			return null;
		}

		@Override
		public IContextInformation getContextInformation() {
			return null;
		}

		@Override
		public void apply(IDocument document, char trigger, int offset) {
			try {
				String replacement = fString.substring(offset - fOffset);
				document.replace(offset, 0, replacement);
			} catch (BadLocationException e) {}
		}

		@Override
		public boolean isValidFor(IDocument document, int offset) {
			return validate(document, offset, null);
		}

		@Override
		public char[] getTriggerCharacters() {
			return null;
		}

		@Override
		public int getContextInformationPosition() {
			return 0;
		}

		@Override
		public void apply(ITextViewer viewer, char trigger, int stateMask, int offset) {
			apply(viewer.getDocument(), trigger, offset);
		}

		@Override
		public void selected(ITextViewer viewer, boolean smartToggle) {}

		@Override
		public void unselected(ITextViewer viewer) {}

		@Override
		public boolean validate(IDocument document, int offset, DocumentEvent event) {
			try {
				int prefixStart = fOffset - fPrefix.length();
				return offset >= fOffset && offset < fOffset + fString.length()
						&& document.get(prefixStart, offset - (prefixStart))
								.equals((fPrefix + fString).substring(0, offset - prefixStart));
			} catch (BadLocationException x) {
				return false;
			}
		}

		@Override
		public IInformationControlCreator getInformationControlCreator() {
			return null;
		}

		@Override
		public CharSequence getPrefixCompletionText(IDocument document, int completionOffset) {
			return fPrefix + fString;
		}

		@Override
		public int getPrefixCompletionStart(IDocument document, int completionOffset) {
			return fOffset - fPrefix.length();
		}

		@Override
		public boolean isAutoInsertable() {
			return true;
		}

		@Override
		public StyledString getStyledDisplayString() {
			if (fDisplayString == null) {
				fDisplayString = new StyledString(getDisplayString());
			}
			return fDisplayString;
		}

		@Override
		public StyledString getStyledDisplayString(IDocument document, int offset,
				BoldStylerProvider boldStylerProvider) {
			StyledString styledDisplayString = new StyledString();
			styledDisplayString.append(getStyledDisplayString());

			int start = getPrefixCompletionStart(document, offset);
			int patternLength = offset - start;
			if (patternLength > 0) {
				styledDisplayString.setStyle(0, patternLength, boldStylerProvider.getBoldStyler());
			}
			return styledDisplayString;
		}
	}

	private FluentEditor editor;

	public DotCompletionProcessor(ITextEditor editor) {
		if (editor instanceof FluentEditor) {
			this.editor = (FluentEditor) editor;
		}
	}

	@Override
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
		try {
			String prefix = getPrefix(viewer, offset);
			List<String> suggestions = getSuggestions(viewer, offset, prefix);

			List<ICompletionProposal> result = new ArrayList<>();
			for (String string : suggestions) {
				if (string.length() > 0) result.add(createProposal(string, prefix, offset));
			}
			return result.toArray(new ICompletionProposal[result.size()]);

		} catch (BadLocationException e) {
			return NO_PROPOSALS;
		}
	}

	private List<String> getSuggestions(ITextViewer viewer, int offset, String prefix) throws BadLocationException {
		IDocument doc = viewer.getDocument();
		ITypedRegion region = doc.getPartition(offset);
		if (region == null || !region.getType().equals(Partitions.DOTBLOCK)) return Collections.emptyList();

		Record record = editor.getParseRecord(region);
		if (record == null) return Collections.emptyList();

		return createSuggestions(doc, region, record, offset, prefix);
	}

	private List<String> createSuggestions(IDocument doc, ITypedRegion region, Record record, int offset, String prefix)
			throws BadLocationException {

		int lnum = doc.getLineOfOffset(region.getOffset());
		offset -= doc.getLineOffset(lnum + 1);

		ParserRuleContext node = ContextVisitor.INST.getNode(record, offset);
		ParserRuleContext rule = node.getParent();

		String value = node.getText();

		List<String> values = AttrMap.getValues(Attr.SHAPE);
		return values;
	}

	private String getPrefix(ITextViewer viewer, int offset) throws BadLocationException {
		IDocument doc = viewer.getDocument();
		if (doc == null || offset > doc.getLength()) return null;

		int length = 0;
		while (--offset >= 0 && Character.isJavaIdentifierPart(doc.getChar(offset)))
			length++;

		return doc.get(offset + 1, length);
	}

	private ICompletionProposal createProposal(String string, String prefix, int offset) {
		return new Proposal(string, prefix, offset);
	}

	// -------------------

	@Override
	public IContextInformation[] computeContextInformation(ITextViewer viewer, int offset) {
		return NO_CONTEXTS;
	}

	@Override
	public char[] getCompletionProposalAutoActivationCharacters() {
		return null;
	}

	@Override
	public char[] getContextInformationAutoActivationCharacters() {
		return null;
	}

	@Override
	public String getErrorMessage() {
		return null;
	}

	@Override
	public IContextInformationValidator getContextInformationValidator() {
		return null;
	}
}
