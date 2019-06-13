package net.certiv.fluent.dt.core.formatter;

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.core.formatter.DslCodeFormatter;
import net.certiv.fluent.dt.core.FluentCore;

public class FmSourceFormatter extends DslCodeFormatter {

	public FmSourceFormatter() {
		super();
	}

	@Override
	public DslCore getDslCore() {
		return FluentCore.getDefault();
	}
}
