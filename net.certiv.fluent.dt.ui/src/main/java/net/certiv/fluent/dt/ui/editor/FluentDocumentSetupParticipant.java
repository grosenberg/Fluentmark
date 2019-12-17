package net.certiv.fluent.dt.ui.editor;

import org.eclipse.core.filebuffers.IDocumentSetupParticipant;

import net.certiv.fluent.dt.ui.FluentUI;

import net.certiv.dsl.ui.editor.DslDocumentSetupParticipant;

/**
 * Reference in the extension point is used to associate the contextTypeId with
 * a file extension
 */
public class FmDocumentSetupParticipant extends DslDocumentSetupParticipant implements IDocumentSetupParticipant {

	public FmDocumentSetupParticipant() {
		super(FluentUI.getDefault().getTextTools());
	}
}
