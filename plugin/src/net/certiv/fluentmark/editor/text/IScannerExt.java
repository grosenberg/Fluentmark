package net.certiv.fluentmark.editor.text;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.ICharacterScanner;

public interface IScannerExt extends ICharacterScanner {

	IDocument getDocument();

	int getOffset();

	int getRangeEnd();

	String getContentType();

}
