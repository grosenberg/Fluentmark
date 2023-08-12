package net.certiv.fluent.dt.ui.handlers;

import net.certiv.dsl.core.model.builder.ISpecializedType;
import net.certiv.fluent.dt.core.lang.md.model.SpecializedType;

public class CodeHandler extends AbstractBlockHandler {

	public CodeHandler() {
		super();
		marks.put("```", "```");
		marks.put("~~~", "~~~");
	}

	@Override
	public ISpecializedType blockType() {
		return SpecializedType.CodeBlock;
	}
}
