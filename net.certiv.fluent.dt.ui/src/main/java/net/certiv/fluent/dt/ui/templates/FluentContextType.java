package net.certiv.fluent.dt.ui.templates;

import org.eclipse.jface.text.templates.TemplateVariableResolver;

import net.certiv.dsl.ui.editor.text.completion.DslTemplateContextType;

public class FluentContextType extends DslTemplateContextType {

	public static final String MD_CONTEXT = "markdown";
	public static final String YAML_CONTEXT = "yaml";
	public static final String HTML_CONTEXT = "html";
	public static final String MATH_CONTEXT = "math";
	public static final String DOT_CONTEXT = "dot";
	public static final String UML_CONTEXT = "uml";

	public FluentContextType(String id, TemplateVariableResolver... resolvers) {
		super(id, resolvers);
	}
}
