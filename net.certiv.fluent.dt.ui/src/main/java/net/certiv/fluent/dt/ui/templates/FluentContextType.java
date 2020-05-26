package net.certiv.fluent.dt.ui.templates;

import org.eclipse.jface.text.templates.TemplateVariableResolver;

import net.certiv.dsl.ui.editor.text.completion.DslTemplateContextType;

public class FluentContextType extends DslTemplateContextType {

	public FluentContextType(String id, TemplateVariableResolver... resolvers) {
		super(id, resolvers);
	}
}
