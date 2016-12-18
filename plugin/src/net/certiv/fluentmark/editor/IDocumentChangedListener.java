package net.certiv.fluentmark.editor;

import java.util.EventListener;

import org.eclipse.jface.text.DocumentEvent;

public interface IDocumentChangedListener extends EventListener {

	void documentChanged(DocumentEvent event);
}
