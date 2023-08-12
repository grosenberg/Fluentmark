package net.certiv.fluent.dt.core.lang.md.model;

import net.certiv.dsl.core.model.builder.ISpecSubType;

public enum SpecSubType implements ISpecSubType {
	INLINE("Inline"),
	REF("Reference"),
	REF_DEF("Defined");

	public final String title;

	SpecSubType(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return title;
	}
}
