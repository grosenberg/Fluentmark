/*******************************************************************************
 * Copyright (c) 2016 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.outline.operations;

import java.util.Comparator;
import java.util.List;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.text.edits.DeleteEdit;
import org.eclipse.text.edits.InsertEdit;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.TextEdit;

import net.certiv.fluentmark.model.ISourceRange;
import net.certiv.fluentmark.model.PagePart;
import net.certiv.fluentmark.util.Strings;

/**
 * A command that moves parts within a document.
 */
public class MovePartsCommand extends AbstractDocumentCommand {

	public static class OffsetComparator implements Comparator<PagePart> {

		@Override
		public int compare(PagePart o1, PagePart o2) {
			if (o1 == o2) return 0;
			if (o1.getSourceRange().getOffset() < o2.getSourceRange().getOffset()) return -1;
			if (o1.getSourceRange().getOffset() > o2.getSourceRange().getOffset()) return 1;
			return 0;
		}
	}

	private final PagePart target;
	private final List<PagePart> parts;
	private final Insert location;

	public MovePartsCommand(PagePart target, List<PagePart> parts, Insert location) {
		if (target == null || parts == null || parts.isEmpty() || location == null) {
			throw new IllegalArgumentException();
		}
		this.target = target;
		this.parts = parts;
		this.location = location;
		validate();
	}

	// insert target must not be contained by parts to be moved
	private void validate() {
		for (int idx = 0; idx < parts.size(); idx++) {
			PagePart item = parts.get(idx);
			if (target.isAncestor(item)) {
				setProblemText(Messages.MoveSectionsCommand_invalidTargetLocation_self);
			}
		}
	}

	@Override
	protected void doCommand(IDocument document) throws BadLocationException {
		ISourceRange srTarget = target.getSourceRange();
		int insertOffset = srTarget.getOffset(); // BEFORE
		if (location == Insert.AFTER) {
			insertOffset += target.getLengthWithSep();
		}

		int docLen = document.getLength();
		String prefix = "";
		if (insertOffset > docLen) {
			insertOffset -= Strings.EOL.length();
			prefix = Strings.EOL;
		}

		TextEdit edit = new MultiTextEdit();
		String suffix = "";
		for (PagePart part : parts) {
			ISourceRange range = part.getSourceRange();
			int offset = range.getOffset();
			int len = part.getLengthWithSep();

			if (offset + len > docLen) {
				len -= Strings.EOL.length();
				suffix = Strings.EOL;
			}

			String text = prefix + document.get(offset, len) + suffix;
			edit.addChild(new DeleteEdit(offset, len));
			edit.addChild(new InsertEdit(insertOffset, text));
		}

		edit.apply(document);
	}
}
