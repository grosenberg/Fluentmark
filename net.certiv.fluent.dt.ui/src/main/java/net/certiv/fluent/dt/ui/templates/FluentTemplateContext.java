package net.certiv.fluent.dt.ui.templates;

import org.eclipse.jface.text.IRegion;

import net.certiv.dsl.ui.editor.text.completion.CompletionContext;
import net.certiv.dsl.ui.editor.text.completion.DslTemplateContext;

public class FluentTemplateContext extends DslTemplateContext {

	protected FluentTemplateContext(FluentContextType type, CompletionContext context, IRegion region) {
		super(type, context, region);
	}
}
