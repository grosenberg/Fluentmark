package net.certiv.fluent.dt.ui.editor.strategies;

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.ui.DslUI;
import net.certiv.dsl.ui.editor.text.AbstractStringEditStrategy;
import net.certiv.fluent.dt.core.FluentCore;
import net.certiv.fluent.dt.ui.FluentUI;

public class FmAutoEditStringStrategy extends AbstractStringEditStrategy {

	public FmAutoEditStringStrategy(String partitioning) {
		super(partitioning);
	}

	@Override
	public DslUI getDslUI() {
		return FluentUI.getDefault();
	}

	@Override
	public DslCore getDslCore() {
		return FluentCore.getDefault();
	}
}
