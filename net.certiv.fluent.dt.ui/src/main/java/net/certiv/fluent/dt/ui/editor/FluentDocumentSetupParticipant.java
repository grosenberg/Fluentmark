package net.certiv.fluent.dt.ui.editor;

import net.certiv.dsl.ui.editor.DslDocumentSetupParticipant;
import net.certiv.fluent.dt.ui.FluentUI;

/**
 * Referenced in the extension point used to associate the contextTypeId with a
 * file extension
 */
public class FluentDocumentSetupParticipant extends DslDocumentSetupParticipant {

	public FluentDocumentSetupParticipant() {
		super(FluentUI.getDefault().getTextTools());
	}
}
