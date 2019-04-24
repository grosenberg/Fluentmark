/*******************************************************************************
 * Copyright (c) 2017, 2018 Certiv Analytics. All rights reserved.
 *
 * Use of this file is governed by the Eclipse Public License v1.0
 * that can be found in the LICENSE.txt file in the project root,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package net.certiv.fluent.dt.core.lang.dot;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.eclipse.jface.text.BadLocationException;

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.core.log.Log;
import net.certiv.dsl.core.model.builder.DslModelMaker;
import net.certiv.dsl.core.parser.DslErrorListener;
import net.certiv.dsl.core.parser.DslErrorStrategy;
import net.certiv.dsl.core.parser.DslParseRecord;
import net.certiv.dsl.core.parser.DslSourceParser;
import net.certiv.fluent.dt.core.FluentCore;
import net.certiv.fluent.dt.core.lang.dot.gen.DotLexer;
import net.certiv.fluent.dt.core.lang.dot.gen.DotParser;

public class DotSourceParser extends DslSourceParser {

	private static final DotTokenFactory TokenFactory = new DotTokenFactory();
	private static final String ErrMsg = "Failed to extract DOT text from document.";

	private final DslErrorStrategy errStrategy = new DslErrorStrategy();

	public DotSourceParser(DslParseRecord record) {
		super(record);
		TokenFactory.setTabWidth(record.tabWidth);
	}

	@Override
	public DslCore getDslCore() {
		return FluentCore.getDefault();
	}

	/**
	 * Builds a ParseTree for the given content representing the source of a
	 * corresponding unit.
	 */
	@Override
	public void parse() {
		String content = "";
		try {
			record.docLine = record.doc.getLineOfOffset(record.region.getOffset()) + 1; // trim markup
			record.docOffset = record.doc.getLineOffset(record.docLine);

			int endLine = record.doc.getLineOfOffset(record.region.getOffset() + record.region.getLength()) - 1;
			int endOffset = record.doc.getLineOffset(endLine);

			content = record.doc.get(record.docOffset, endOffset - record.docOffset);
		} catch (BadLocationException e) {
			Log.error(this, ErrMsg, e);
			return;
		}

		DslErrorListener errListener = new DslErrorListener(this, record.collector, record.reportAmbiguities());

		record.cs = CharStreams.fromString(content);
		DotLexer lexer = new DotLexer(record.cs);
		lexer.removeErrorListeners();
		lexer.addErrorListener(errListener);

		record.ts = new CommonTokenStream(lexer);
		record.parser = new DotParser(record.ts);
		record.parser.setErrorHandler(errStrategy);
		record.parser.removeErrorListeners();
		record.parser.addErrorListener(errListener);
		record.tree = ((DotParser) record.parser).graph();

		if (record.tree != null) Verifier.INST.check(this, record.collector);
	}

	@Override
	public boolean modelContributor() {
		return false;
	}

	@Override
	public void analyzeStructure(DslModelMaker maker) {
		// GraphContext graph = (GraphContext) getTree();
		// String name = graph.id() != null ? graph.id().getText() : "Dot Block";
		// ModelData data = new ModelData(ModelType.DotBlock, graph, name);
		// data.type = Type.RAW;
		// maker.statement(graph, graph.id(), data);
	}
}
