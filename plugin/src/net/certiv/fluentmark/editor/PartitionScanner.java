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

import net.certiv.fluentmark.editor.text.FrontMatterRule;
import net.certiv.fluentmark.editor.text.HtmlCodeRule;
import net.certiv.fluentmark.editor.text.IScannerExt;
import net.certiv.fluentmark.editor.text.IndentedCodeRule;

public class PartitionScanner extends RuleBasedPartitionScanner implements IScannerExt {

	public PartitionScanner() {
		super();

		IToken matter = new Token(Partitions.FRONT_MATTER);
		IToken comment = new Token(Partitions.COMMENT);
		IToken codeblock = new Token(Partitions.CODEBLOCK);
		IToken htmlblock = new Token(Partitions.HTMLBLOCK);

		List<IRule> rules = new ArrayList<IRule>();

		rules.add(new FrontMatterRule("---", "---", matter, '\\'));
		rules.add(new MultiLineRule("<!--", "-->", comment, '\\'));
		rules.add(new HtmlCodeRule(htmlblock));
		rules.add(new MultiLineRule("~~~", "~~~", codeblock, '\\'));
		rules.add(new MultiLineRule("```", "```", codeblock, '\\'));
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

	@Override
	public String getContentType() {
		return fContentType;
	}
}
