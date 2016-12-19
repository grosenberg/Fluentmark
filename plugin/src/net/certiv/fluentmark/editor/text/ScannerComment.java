package net.certiv.fluentmark.editor.text;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.WhitespaceRule;

import net.certiv.fluentmark.preferences.Prefs;

public class ScannerComment extends AbstractBufferedRuleBasedScanner {

	private String[] tokenProperties;

	public ScannerComment() {
		super();
		initialize();
	}

	@Override
	protected String[] getTokenProperties() {
		if (tokenProperties == null) {
			tokenProperties = new String[] { Prefs.EDITOR_COMMENT_HIDDEN_COLOR, Prefs.EDITOR_COMMENT_VISIBLE_COLOR, };
		}
		return tokenProperties;
	}

	@Override
	protected List<IRule> createRules() {
		IToken hidden = getToken(Prefs.EDITOR_COMMENT_HIDDEN_COLOR);
		IToken visible = getToken(Prefs.EDITOR_COMMENT_VISIBLE_COLOR);

		List<IRule> rules = new ArrayList<IRule>();
		rules.add(new MultiLineRule("<!---", "--->", hidden, '\\'));
		rules.add(new MultiLineRule("<!--", "-->", visible, '\\'));
		rules.add(new WhitespaceRule(new WhitespaceDetector()));
		return rules;
	}
}
