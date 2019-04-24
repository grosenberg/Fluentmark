package net.certiv.fluent.dt.ui.templates;

import org.eclipse.jface.text.IDocument;

import net.certiv.dsl.core.model.ICodeUnit;
import net.certiv.dsl.ui.editor.text.completion.tmpl.DslTemplateContext;
import net.certiv.dsl.ui.editor.text.completion.tmpl.DslTemplateContextType;

public class MdContextType extends DslTemplateContextType {

	public static final String CONTEXT_TYPE_ID = "net.certiv.fluent.dt.ui.DefaultContext";
	public static final String FM_CUSTOM_TEMPLATES_KEY = "net.certiv.fluent.dt.ui.CustomContext.templates";

	public static final String MD_CONTEXT_TYPE_ID = "markdown";
	public static final String FM_CONTEXT_TYPE_ID = "frontmatter";
	public static final String HTML_CONTEXT_TYPE_ID = "html";
	public static final String MATH_CONTEXT_TYPE_ID = "math";
	public static final String DOT_CONTEXT_TYPE_ID = "dot";
	public static final String UML_CONTEXT_TYPE_ID = "uml";

	public static final String[] CONTEXT_TYPE_IDS = { MD_CONTEXT_TYPE_ID, FM_CONTEXT_TYPE_ID, HTML_CONTEXT_TYPE_ID,
			MATH_CONTEXT_TYPE_ID, DOT_CONTEXT_TYPE_ID, UML_CONTEXT_TYPE_ID };

	public MdContextType() {
		super();
	}

	public MdContextType(String id) {
		super(id);
	}

	public MdContextType(String id, String name) {
		super(id, name);
	}

	@Override
	public DslTemplateContext createContext(IDocument document, int completionPosition, int length,
			ICodeUnit sourceModule) {
		return new MdTemplateContext(this, document, completionPosition, length, sourceModule);
	}

	@Override
	protected void addDslResolvers() {}
}
