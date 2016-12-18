package net.certiv.fluentmark.editor.text;

import org.eclipse.jface.text.rules.IWordDetector;

public class HtmlWordDetector implements IWordDetector {

	@Override
	public boolean isWordStart(char c) {
		return Character.isLetter(c);
	}

	@Override
	public boolean isWordPart(char c) {
		return Character.isLetter(c);
	}
}
