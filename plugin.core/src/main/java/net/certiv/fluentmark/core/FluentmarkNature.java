package net.certiv.fluentmark.core;

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.core.DslNature;

public class FluentmarkNature extends DslNature {

	@Override
	public DslCore getDslCore() {
		return FluentCore.getDefault();
	}
}
