package net.certiv.fluentmark.editor.text;

import org.eclipse.jface.text.rules.IWordDetector;

public class WordDetector implements IWordDetector {

	@Override
	public boolean isWordStart(char c) {
		return Character.isLetterOrDigit(c);
	}

	@Override
	public boolean isWordPart(char c) {
		return Character.isLetterOrDigit(c) || c == '_';
	}
}
