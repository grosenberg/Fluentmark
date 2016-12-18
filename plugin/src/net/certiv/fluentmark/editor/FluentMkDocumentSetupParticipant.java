package net.certiv.fluentmark.editor;

import org.eclipse.core.filebuffers.IDocumentSetupParticipant;
import org.eclipse.core.filebuffers.IDocumentSetupParticipantExtension;
import org.eclipse.core.filebuffers.LocationKind;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.text.IDocument;

import net.certiv.fluentmark.FluentMkUI;

/** FluentMkDocumentSetupParticipant */
public class FluentMkDocumentSetupParticipant implements IDocumentSetupParticipant, IDocumentSetupParticipantExtension {

	private FluentMkTextTools textTools;

	public FluentMkDocumentSetupParticipant() {
		this(FluentMkUI.getDefault().getTextTools());
	}

	public FluentMkDocumentSetupParticipant(FluentMkTextTools textTools) {
		this.textTools = textTools;
	}

	public void setup(IDocument document) {
		setup(document, null, null);
	}

	public void setup(IDocument document, IPath location, LocationKind locationKind) {
		textTools.setupDocument(document, location, locationKind);
	}
}
