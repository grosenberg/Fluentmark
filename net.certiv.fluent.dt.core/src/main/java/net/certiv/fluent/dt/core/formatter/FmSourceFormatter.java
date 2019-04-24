package net.certiv.fluent.dt.core.formatter;

import net.certiv.fluent.dt.core.FluentCore;

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.core.formatter.DslCodeFormatter;

public class FmSourceFormatter extends DslCodeFormatter {

	public FmSourceFormatter() {
		super();
	}

	@Override
	public DslCore getDslCore() {
		return FluentCore.getDefault();
	}
}
