package net.certiv.fluentmark.ui.editor.folding;

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.ui.DslUI;
import net.certiv.dsl.ui.editor.text.folding.AbstractDslFoldingStructureProvider;

public class FluentFoldingStructureProvier extends AbstractDslFoldingStructureProvider {

	@Override
	public DslUI getDslUI() {
		return null;
	}

	@Override
	public DslCore getDslCore() {
		return null;
	}

	@Override
	protected String getPartitioning() {
		return null;
	}

	@Override
	protected String getMultiLineCommentPartition() {
		return null;
	}

	@Override
	protected String getSingleLineCommentPartition() {
		return null;
	}

}
