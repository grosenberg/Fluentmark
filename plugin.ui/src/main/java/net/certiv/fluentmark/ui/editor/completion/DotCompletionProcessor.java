/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.ui.editor.completion;

import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.ui.IEditorPart;

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.ui.DslUI;
import net.certiv.dsl.ui.editor.text.completion.CompletionLabelProvider;
import net.certiv.dsl.ui.editor.text.completion.DslCompletionProcessor;
import net.certiv.fluentmark.core.FluentCore;
import net.certiv.fluentmark.ui.FluentUI;

public class DotCompletionProcessor extends DslCompletionProcessor {

	public DotCompletionProcessor(IEditorPart editor, ContentAssistant assistant, String partition) {
		super(editor, assistant, partition);
	}

	@Override
	public DslUI getDslUI() {
		return FluentUI.getDefault();
	}

	@Override
	public DslCore getDslCore() {
		return FluentCore.getDefault();
	}

	@Override
	protected CompletionLabelProvider getProposalLabelProvider() {
		return new FluentCompletionLabelProvider();
	}

	// public DotCompletionProcessor(ITextEditor editor, String partition, String name, String icon)
	// {
	// super(FluentUI.getDefault(), editor, partition, name, icon);
	// }
	//
	// public void setCategory(String name, String icon) {
	// category = new CompletionProposalCategory(DslUI.PLUGIN_ID, name, icon);
	// }

	// @Override
	// public List<String> getSuggestions(IDocument doc, ITypedRegion partition, int offset, String
	// prefix)
	// throws BadLocationException {
	//
	// Record record = editor.getParseRecord(partition);
	// if (record == null) return Collections.emptyList();
	//
	// int dotLine = doc.getLineOfOffset(partition.getOffset()) + 1;
	// int dotOffset = doc.getLineOffset(dotLine);
	//
	// List<String> suggestions = new ArrayList<>();
	//
	// ParserRuleContext node = ContextVisitor.INST.getNode(record, offset - dotOffset);
	// List<ParserRuleContext> path = getParents(node);
	// AttributeContext ctx = getAttributeContext(path);
	//
	// if (ctx != null) {
	// if (ctx.id() == node) {
	// suggestions.addAll(AttrMap.getAttrNames());
	//
	// } else {
	// Attr attr = AttrMap.find(ctx.id().getText());
	// Props props = AttrMap.get(attr);
	// switch (props.type) {
	// case COLOR:
	// case COLORS:
	// suggestions.addAll(DotColors.getColorNames("x11")); // TODO: handle colorScheme
	// break;
	//
	// case LIST:
	// suggestions.addAll(Arrays.asList(props.values));
	// break;
	//
	// case NUMBER:
	// break;
	// case POINT:
	// break;
	// case RECT:
	// break;
	// case SPLINE:
	// break;
	// case STRING:
	// break;
	//
	// case INVALID:
	// default:
	// break;
	// }
	// }
	// }
	//
	// if (!prefix.isEmpty()) {
	// suggestions = suggestions.stream().filter(s -> s.contains(prefix)).collect(Collectors.toList());
	// }
	// return suggestions;
	// }

	// private AttributeContext getAttributeContext(List<ParserRuleContext> path) {
	// for (ParserRuleContext node : path) {
	// if (node.getRuleIndex() == DotParser.RULE_attribute) {
	// return (AttributeContext) node;
	// }
	// }
	// return null;
	// }
	//
	// private List<ParserRuleContext> getParents(ParserRuleContext node) {
	// List<ParserRuleContext> path = new ArrayList<>();
	// ParserRuleContext parent = node;
	// while (parent != null) {
	// path.add(parent);
	// parent = parent.getParent();
	// }
	// return path;
	// }

	// private static final class Proposal implements ICompletionProposal, ICompletionProposalExtension,
	// ICompletionProposalExtension2, ICompletionProposalExtension3, ICompletionProposalExtension4,
	// ICompletionProposalExtension6, ICompletionProposalExtension7 {
	//
	// private final String suggestion;
	// private final String prefix;
	// private final int offset;
	// private StyledString displayString;
	// private int relevance;
	//
	// public Proposal(String suggestion, String prefix, int offset) {
	// this.suggestion = suggestion;
	// this.prefix = prefix;
	// this.offset = offset;
	// }
	//
	// @Override
	// public void apply(IDocument document) {
	// apply(null, '\0', 0, offset);
	// }
	//
	// @Override
	// public Point getSelection(IDocument document) {
	// return new Point(offset + suggestion.length(), 0);
	// }
	//
	// @Override
	// public String getAdditionalProposalInfo() {
	// return null;
	// }
	//
	// @Override
	// public String getDisplayString() {
	// return /* prefix + */ suggestion;
	// }
	//
	// @Override
	// public Image getImage() {
	// return null;
	// }
	//
	// @Override
	// public IContextInformation getContextInformation() {
	// return null;
	// }
	//
	// @Override
	// public void apply(IDocument document, char trigger, int offset) {
	// try {
	// String replacement = suggestion.substring(offset - this.offset);
	// document.replace(offset, 0, replacement);
	// } catch (BadLocationException e) {}
	// }
	//
	// @Override
	// public boolean isValidFor(IDocument document, int offset) {
	// return validate(document, offset, null);
	// }
	//
	// @Override
	// public char[] getTriggerCharacters() {
	// return null;
	// }
	//
	// @Override
	// public int getContextInformationPosition() {
	// return 0;
	// }
	//
	// @Override
	// public void apply(ITextViewer viewer, char trigger, int stateMask, int offset) {
	// apply(viewer.getDocument(), trigger, offset);
	// }
	//
	// @Override
	// public void selected(ITextViewer viewer, boolean smartToggle) {}
	//
	// @Override
	// public void unselected(ITextViewer viewer) {}
	//
	// @Override
	// public boolean validate(IDocument document, int offset, DocumentEvent event) {
	// try {
	// int prefixStart = this.offset - prefix.length();
	// return offset >= this.offset && offset < this.offset + suggestion.length()
	// && document.get(prefixStart, offset - (prefixStart))
	// .equals((prefix + suggestion).substring(0, offset - prefixStart));
	// } catch (BadLocationException x) {
	// return false;
	// }
	// }
	//
	// @Override
	// public IInformationControlCreator getInformationControlCreator() {
	// return null;
	// }
	//
	// @Override
	// public CharSequence getPrefixCompletionText(IDocument document, int completionOffset) {
	// return prefix + suggestion;
	// }
	//
	// @Override
	// public int getPrefixCompletionStart(IDocument document, int completionOffset) {
	// return offset - prefix.length();
	// }
	//
	// @Override
	// public boolean isAutoInsertable() {
	// return true;
	// }
	//
	// @Override
	// public StyledString getStyledDisplayString() {
	// if (displayString == null) {
	// displayString = new StyledString(getDisplayString());
	// }
	// return displayString;
	// }
	//
	// @Override
	// public StyledString getStyledDisplayString(IDocument document, int offset,
	// BoldStylerProvider boldStylerProvider) {
	// StyledString styledDisplayString = new StyledString();
	// styledDisplayString.append(getStyledDisplayString());
	//
	// int start = getPrefixCompletionStart(document, offset);
	// int patternLength = offset - start;
	// if (patternLength > 0) {
	// styledDisplayString.setStyle(0, patternLength, boldStylerProvider.getBoldStyler());
	// }
	// return styledDisplayString;
	// }
	//
	// public int getRelevance() {
	// return relevance;
	// }
	//
	// public void setRelevance(int relevance) {
	// this.relevance = relevance;
	// }
	// }
}
