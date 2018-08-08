/*******************************************************************************
 * Copyright (c) 2016 - 2018 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.editor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.Token;

import net.certiv.fluentmark.editor.text.DotCodeRule;
import net.certiv.fluentmark.editor.text.FrontMatterRule;
import net.certiv.fluentmark.editor.text.HtmlCodeRule;
import net.certiv.fluentmark.editor.text.IScannerExt;
import net.certiv.fluentmark.editor.text.IndentedCodeRule;
import net.certiv.fluentmark.editor.text.MatchRule;

public class PartitionScanner extends RuleBasedPartitionScanner implements IScannerExt {

	public PartitionScanner() {
		super();

		IToken matter = new Token(Partitions.FRONT_MATTER);
		IToken comment = new Token(Partitions.COMMENT);
		IToken codeblock = new Token(Partitions.CODEBLOCK);
		IToken htmlblock = new Token(Partitions.HTMLBLOCK);
		IToken dotblock = new Token(Partitions.DOTBLOCK);
		IToken umlblock = new Token(Partitions.UMLBLOCK);
		IToken mathblock = new Token(Partitions.MATHBLOCK);

		List<IRule> rules = new ArrayList<>();

		rules.add(new FrontMatterRule("---", "---", matter, '\\'));
		rules.add(new MultiLineRule("<!--", "-->", comment, '\\', true));
		rules.add(new MultiLineRule("$$", "$$", mathblock, '\\', true));
		rules.add(new MatchRule("\\$\\S", "\\S\\$\\D", mathblock, '\\', true, true));
		rules.add(new HtmlCodeRule(htmlblock));
		rules.add(new DotCodeRule(dotblock));
		rules.add(new MultiLineRule("@startuml", "@enduml", umlblock, '\\', true));
		rules.add(new MultiLineRule("@startdot", "@enddot", umlblock, '\\', true));
		rules.add(new MultiLineRule("@startsalt", "@endsalt", umlblock, '\\', true));
		rules.add(new MultiLineRule("~~~", "~~~", codeblock, '\\', true));
		rules.add(new MultiLineRule("```", "```", codeblock, '\\', true));
		rules.add(new IndentedCodeRule(codeblock));

		IPredicateRule[] rule = new IPredicateRule[rules.size()];
		setPredicateRules(rules.toArray(rule));
	}

	@Override
	public IDocument getDocument() {
		return fDocument;
	}

	@Override
	public int getOffset() {
		return fOffset;
	}

	@Override
	public int getRangeEnd() {
		return fRangeEnd;
	}
}
