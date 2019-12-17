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
import org.antlr.v4.runtime.Lexer;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.core.log.Log;
import net.certiv.dsl.core.model.builder.ModelBuilder;
import net.certiv.dsl.core.parser.DslErrorStrategy;
import net.certiv.dsl.core.parser.DslParseRecord;
import net.certiv.dsl.core.parser.DslSourceParser;
import net.certiv.fluent.dt.core.FluentCore;
import net.certiv.fluent.dt.core.lang.dot.gen.DotLexer;
import net.certiv.fluent.dt.core.lang.dot.gen.DotParser;

public class DotSourceParser extends DslSourceParser {

	private static final DotTokenFactory TokenFactory = new DotTokenFactory();

	private final DslErrorStrategy errStrategy = new DslErrorStrategy();

	public DotSourceParser(DslParseRecord record) {
		super(record);
		TokenFactory.setTabWidth(record.tabWidth);
	}

	@Override
	public DslCore getDslCore() {
		return FluentCore.getDefault();
	}

	@Override
	public void parse() {
		record.cs = CharStreams.fromString(getContent(), record.unit.getFile().getName());
		Lexer lexer = new DotLexer(record.cs);
		lexer.removeErrorListeners();
		lexer.addErrorListener(getDslErrorListener());

		record.ts = new CommonTokenStream(lexer);
		record.parser = new DotParser(record.ts);
		record.parser.setErrorHandler(errStrategy);
		record.parser.removeErrorListeners();
		record.parser.addErrorListener(getDslErrorListener());
		record.tree = ((DotParser) record.parser).document();

		if (record.tree != null) Verifier.INST.check(this, record.getCollector());
	}

	@Override
	public String getContent() {
		String content = super.getContent();
		if (content.startsWith("~~~") || content.startsWith("```")) {
			try {
				IDocument doc = record.unit.getDocument();
				record.docLine += 1;
				record.docOffset = doc.getLineOffset(record.docLine);

				int ln = doc.getLineOfOffset(record.region.getOffset() + record.region.getLength()) - 1;
				int end = doc.getLineOffset(ln);

				content = doc.get(record.docOffset, end - record.docOffset);

			} catch (BadLocationException e) {
				Log.error(this, ErrMsg, e);
			}
		}
		return content;
	}

	@Override
	public boolean modelContributor() {
		return false;
	}

	@Override
	public void analyzeStructure(ModelBuilder maker) {
		// GraphContext graph = (GraphContext) getTree();
		// String name = graph.id() != null ? graph.id().getText() : "Dot Block";
		// ModelData data = new ModelData(ModelType.DotBlock, graph, name);
		// data.type = Type.RAW;
		// maker.statement(graph, graph.id(), data);
	}
}
