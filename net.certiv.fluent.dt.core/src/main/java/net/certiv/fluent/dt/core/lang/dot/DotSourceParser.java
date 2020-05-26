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

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.core.parser.DslErrorListener;
import net.certiv.dsl.core.parser.DslErrorStrategy;
import net.certiv.dsl.core.parser.DslParseRecord;
import net.certiv.dsl.core.parser.DslSourceParser;
import net.certiv.fluent.dt.core.FluentCore;
import net.certiv.fluent.dt.core.lang.dot.gen.DotLexer;
import net.certiv.fluent.dt.core.lang.dot.gen.DotParser;
import net.certiv.fluent.dt.core.lang.dot.model.Verifier;

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
	public boolean doVerify() {
		return true;
	}

	@Override
	public boolean doAnalysis() {
		return false;
	}

	@Override
	public Throwable parse() {
		DslErrorListener auditor = getErrorListener();
		try {
			record.setCharStream(CharStreams.fromString(getContent(), record.unit.getFile().getName()));
			Lexer lexer = new DotLexer(record.getCharStream());
			lexer.removeErrorListeners();
			lexer.addErrorListener(auditor);
			record.setTokenStream(new CommonTokenStream(lexer));

			DotParser parser = new DotParser(record.getTokenStream());
			parser.setErrorHandler(errStrategy);
			parser.removeErrorListeners();
			parser.addErrorListener(auditor);
			record.setParser(parser);
			record.setTree(parser.document());

			return null;

		} catch (Exception | Error e) {
			auditor.generalError(ERR_PARSER, e);
			return e;
		}
	}

	@Override
	public Throwable verify() {
		try {
			Verifier.INST.check(this, record.getCollector());
			return null;

		} catch (Exception | Error e) {
			getErrorListener().generalError(ERR_VALIDATE, e);
			return e;
		}
	}
}
