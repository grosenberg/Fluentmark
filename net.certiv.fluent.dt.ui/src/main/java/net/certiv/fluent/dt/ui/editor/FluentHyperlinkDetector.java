package net.certiv.fluent.dt.ui.editor;

import net.certiv.dsl.core.model.DslModel;
import net.certiv.dsl.ui.editor.hyperlink.DslHyperlinkDetector;
import net.certiv.fluent.dt.core.FluentCore;

public class FluentHyperlinkDetector extends DslHyperlinkDetector {

	public FluentHyperlinkDetector() {
		super();
	}

	@Override
	public DslModel getDslModel() {
		return FluentCore.getDefault().getDslModel();
	}
}
