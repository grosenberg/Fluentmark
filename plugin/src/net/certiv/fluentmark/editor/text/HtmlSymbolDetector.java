package net.certiv.fluentmark.editor.text;

import org.eclipse.jface.text.rules.IWordDetector;

public class HtmlSymbolDetector implements IWordDetector {

	@Override
	public boolean isWordStart(char c) {
		return c == '<' || c == '=' || c == '>';

	}

	@Override
	public boolean isWordPart(char c) {
		return c == '<' || c == '=' || c == '/' || c == '>';
	}
}
