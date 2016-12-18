package net.certiv.fluentmark.editor.text;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.WhitespaceRule;

import net.certiv.fluentmark.preferences.Prefs;

public class ScannerCode extends AbstractBufferedRuleBasedScanner {

	private String[] tokenProperties;

	public ScannerCode() {
		super();
		initialize();
	}

	@Override
	protected String[] getTokenProperties() {
		if (tokenProperties == null) {
			tokenProperties = new String[] { Prefs.EDITOR_CODE_COLOR, Prefs.EDITOR_CODEBLOCK_COLOR };
		}
		return tokenProperties;
	}

	@Override
	protected List<IRule> createRules() {
		IToken code = getToken(Prefs.EDITOR_CODE_COLOR);
		IToken block = getToken(Prefs.EDITOR_CODEBLOCK_COLOR);

		List<IRule> rules = new ArrayList<IRule>();
		rules.add(new MultiLineRule("```", "```", block, '\\', true));
		rules.add(new MultiLineRule("~~~", "~~~", block, '\\', true));
		rules.add(new SingleLineRule("`", "`", code, '\\', true));
		rules.add(new WhitespaceRule(new WhitespaceDetector()));
		return rules;
	}
}
