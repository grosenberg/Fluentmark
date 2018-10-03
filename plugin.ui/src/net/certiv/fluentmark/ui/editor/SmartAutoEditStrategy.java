package net.certiv.fluentmark.ui.editor;

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.ui.DslUI;
import net.certiv.dsl.ui.editor.text.AbstractAutoEditStrategy;
import net.certiv.fluentmark.core.FluentCore;
import net.certiv.fluentmark.ui.FluentUI;

public class SmartAutoEditStrategy extends AbstractAutoEditStrategy {

	public SmartAutoEditStrategy(String partitioning) {
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
