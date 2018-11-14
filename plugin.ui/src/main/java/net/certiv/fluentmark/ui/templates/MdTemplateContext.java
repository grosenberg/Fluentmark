package net.certiv.fluentmark.ui.templates;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.templates.TemplateContextType;

import net.certiv.dsl.core.model.ICodeUnit;
import net.certiv.dsl.ui.editor.text.completion.tmpl.DslTemplateContext;

public class MdTemplateContext extends DslTemplateContext {

	protected MdTemplateContext(TemplateContextType type, IDocument document, int completionOffset,
			int completionLength, ICodeUnit sourceModule) {

		super(type, document, completionOffset, completionLength, sourceModule);
	}
}
