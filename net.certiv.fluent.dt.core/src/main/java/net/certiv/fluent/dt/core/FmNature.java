package net.certiv.fluent.dt.core;

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.core.DslNature;

public class FmNature extends DslNature {

	@Override
	public DslCore getDslCore() {
		return FluentCore.getDefault();
	}
}
