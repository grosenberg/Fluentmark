/*******************************************************************************
 * Copyright (c) 2017, 2018 Certiv Analytics. All rights reserved.
 * Use of this file is governed by the Eclipse Public License v1.0
 * that can be found in the LICENSE.txt file in the project root,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package net.certiv.fluentmark.dot;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.ui.ide.ResourceUtil;

import net.certiv.fluentmark.FluentUI;
import net.certiv.fluentmark.dot.gen.DotLexer;
import net.certiv.fluentmark.dot.gen.DotParser;
import net.certiv.fluentmark.editor.FluentEditor;
import net.certiv.fluentmark.editor.text.DotReconcilingStrategy.DotProblemCollector;

public class DotSourceParser {

	private static final String ErrMsg = "Failed to extract DOT text from document.";
	private final DotErrorStrategy errStrategy = new DotErrorStrategy();
	private final DotErrorListener errListener = new DotErrorListener();
	private FluentEditor editor;

	public DotSourceParser(FluentEditor editor) {
		this.editor = editor;
	}

	public void eval(IDocument doc, IRegion partition, DotProblemCollector collector) {
		int docOffset = -1;
		int docLine = -1;
		String text = null;
		try {
			docLine = doc.getLineOfOffset(partition.getOffset()) + 1; // trim markup
			docOffset = doc.getLineOffset(docLine);

			int endLine = doc.getLineOfOffset(partition.getOffset() + partition.getLength()) - 1;
			int endOffset = doc.getLineOffset(endLine);

			text = doc.get(docOffset, endOffset - docOffset);
		} catch (BadLocationException e) {
			FluentUI.log(IStatus.ERROR, ErrMsg, e);
			return;
		}

		IResource res = ResourceUtil.getResource(editor.getEditorInput());
		Record record = new Record(res, partition, docOffset, docLine);
		errListener.setup(record, collector);

		record.cs = CharStreams.fromString(text);
		DotLexer lexer = new DotLexer(record.cs);
		lexer.addErrorListener(errListener);
		record.ts = new CommonTokenStream(lexer);
		record.parser = new DotParser(record.ts);
		record.parser.setErrorHandler(errStrategy);
		record.parser.removeErrorListeners();
		record.parser.addErrorListener(errListener);
		record.tree = record.parser.graph();

		VerifyVisitor.INST.check(record, collector);
		editor.setParseRecord(record);
	}
}
