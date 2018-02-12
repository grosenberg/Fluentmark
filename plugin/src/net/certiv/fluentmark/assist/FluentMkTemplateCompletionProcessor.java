/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.assist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.templates.ContextTypeRegistry;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.TemplateCompletionProcessor;
import org.eclipse.jface.text.templates.TemplateContext;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.jface.text.templates.TemplateException;
import org.eclipse.jface.text.templates.TemplateProposal;
import org.eclipse.jface.text.templates.persistence.TemplateStore;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.texteditor.ITextEditor;

import net.certiv.fluentmark.util.Strings;

public class FluentMkTemplateCompletionProcessor extends TemplateCompletionProcessor {

	private static final Pattern VARIABLE_PATTERN = Pattern.compile("\\$\\{([^\\}]+)\\}"); //$NON-NLS-1$
	private static final Template[] NO_TEMPLATES = new Template[0];

	private final SourceTemplateContextType contextType;
	private Templates templates;

	private static final Comparator<ICompletionProposal> proposalComparator = new Comparator<ICompletionProposal>() {

		public int compare(ICompletionProposal o1, ICompletionProposal o2) {
			int r1= o1 instanceof TemplateProposal ? ((TemplateProposal) o1).getRelevance() : 0;
			int r2= o2 instanceof TemplateProposal ? ((TemplateProposal) o2).getRelevance() : 0;
			return r2 - r1;
		}
	};

	public FluentMkTemplateCompletionProcessor(ITextEditor editor, String partition) {
		ContextTypeRegistry contextTypeRegistry = CustomTemplateAccess.getInstance().getContextTypeRegistry();
		contextType = (SourceTemplateContextType) contextTypeRegistry.getContextType(SourceTemplateContextType.ID);
		if (contextType == null) {
			throw new IllegalStateException();
		}
	}

	@Override
	protected TemplateContextType getContextType(ITextViewer viewer, IRegion region) {
		return contextType;
	}

	@Override
	protected Image getImage(Template template) {
		return null;
	}

	@SuppressWarnings("deprecation")
	@Override
	protected Template[] getTemplates(String contextTypeId) {
		if (contextType.getId().equals(contextTypeId)) {
			Template[] computedTemplates = null;
			if (templates != null) {
				computedTemplates = templates.getTemplate().toArray(new Template[templates.getTemplate().size()]);
			}
			TemplateStore templateStore = CustomTemplateAccess.getInstance().getTemplateStore();
			if (templateStore != null) {
				Template[] customTemplates = templateStore.getTemplates(contextTypeId);
				if (customTemplates != null && customTemplates.length > 0) {
					if (computedTemplates == null) {
						computedTemplates = customTemplates;
					} else {
						List<Template> allTempaltes = new ArrayList<Template>(
								computedTemplates.length + customTemplates.length);
						allTempaltes.addAll(Arrays.asList(computedTemplates));
						allTempaltes.addAll(Arrays.asList(customTemplates));
						computedTemplates = allTempaltes.toArray(new Template[allTempaltes.size()]);
					}
				}
			}
			if (computedTemplates != null) {
				for (Template template : computedTemplates) {
					String pattern = template.getPattern();
					pattern = pattern.replace("\r\n", "\n");
					pattern = pattern.replace("\n", Strings.EOL);
					template.setPattern(pattern);					
				}
				return computedTemplates;
			}
		}
		return NO_TEMPLATES;
	}

	/**
	 * Override improves matching accuracy
	 */
	@Override
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {

		ITextSelection selection = (ITextSelection) viewer.getSelectionProvider().getSelection();

		// adjust offset to end of normalized selection
		if (selection.getOffset() == offset) {
			offset = selection.getOffset() + selection.getLength();
		}

		String prefix = extractPrefix(viewer, offset);
		Region region = new Region(offset - prefix.length(), prefix.length());
		TemplateContext context = createContext(viewer, region);
		if (context == null) {
			return new ICompletionProposal[0];
		}
		Region selectionRegion = new Region(selection.getOffset(), selection.getLength());
		TemplateContext selectionContext = createContext(viewer, selectionRegion);

		int lineOffset = 0;
		try {
			IRegion lineInformationOfOffset = viewer.getDocument().getLineInformationOfOffset(offset);
			lineOffset = offset - lineInformationOfOffset.getOffset();
		} catch (BadLocationException e1) {}

		String selectionText = selection.getText();
		context.setVariable("selection", selectionText); //$NON-NLS-1$
		selectionContext.setVariable("selection", selectionText); //$NON-NLS-1$
		context.setVariable("text", selectionText); //$NON-NLS-1$
		selectionContext.setVariable("text", selectionText); //$NON-NLS-1$

		Template[] templates = getTemplates(context.getContextType().getId());

		List<ICompletionProposal> matches = new ArrayList<ICompletionProposal>(templates.length);
		for (Template template : templates) {
			try {
				context.getContextType().validate(template.getPattern());
			} catch (TemplateException e) {
				continue;
			}
			if (!template.matches(prefix, context.getContextType().getId())) {
				continue;
			}
			boolean selectionBasedMatch = isSelectionBasedMatch(template, context);
			if (template.getName().startsWith(prefix) || selectionBasedMatch) {

				int relevance = getRelevance(template, lineOffset, prefix);
				if (selectionBasedMatch) {
					matches.add(createProposal(template, selectionContext, (IRegion) selectionRegion, relevance));
				} else {
					matches.add(createProposal(template, context, (IRegion) region, relevance));
				}
			}
		}

		Collections.sort(matches, proposalComparator);

		return matches.toArray(new ICompletionProposal[matches.size()]);
	}

	private int getRelevance(Template template, int lineOffset, String prefix) {
		boolean blockTemplate = templates == null ? false : templates.isBlock(template);
		if (blockTemplate) {
			if (template.getName().startsWith(prefix)) {
				return lineOffset == 0 ? 95 : 75;
			}
			return lineOffset == 0 ? 85 : 0;
		}
		return super.getRelevance(template, prefix);
	}

	private boolean isSelectionBasedMatch(Template template, TemplateContext context) {
		String pattern = template.getPattern();
		Set<String> vars = new HashSet<String>();
		Matcher matcher = VARIABLE_PATTERN.matcher(pattern);
		while (matcher.find()) {
			String variableName = matcher.group(1);
			if (vars.add(variableName)) {
				String variable = context.getVariable(variableName);
				if (variable != null && variable.length() > 0) {
					return true;
				}
			}
		}
		return false;
	}

	public void setCompletionProposalAutoActivationCharacters(char[] charArray) {}

	public void restrictProposalsToVisibility(boolean enabled) {}

	public void restrictProposalsToMatchingCases(boolean enabled) {}
}
