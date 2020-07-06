package net.certiv.fluent.dt.ui.editor.strategies;

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.ui.DslUI;
import net.certiv.dsl.ui.editor.text.AbstractAutoEditStrategy;
import net.certiv.fluent.dt.core.FluentCore;
import net.certiv.fluent.dt.ui.FluentUI;

public class FmAutoEditStrategy extends AbstractAutoEditStrategy {

	public FmAutoEditStrategy(String partitioning) {
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
