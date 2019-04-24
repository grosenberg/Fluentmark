package net.certiv.fluent.dt.ui.templates;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.BadPartitioningException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.templates.ContextTypeRegistry;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.TemplateContextType;

import net.certiv.fluent.dt.ui.FluentUI;
import net.certiv.fluent.dt.ui.editor.Partitions;

import net.certiv.dsl.ui.editor.text.completion.DslContentAssistInvocationContext;
import net.certiv.dsl.ui.editor.text.completion.tmpl.DslTemplateCompletionProcessor;
import net.certiv.dsl.ui.templates.CompletionManager;

@SuppressWarnings("deprecation")
public class MdTemplateCompletionProcessor extends DslTemplateCompletionProcessor {

	private static final char[] IGNORE = new char[] { '.' };

	public MdTemplateCompletionProcessor(DslContentAssistInvocationContext context) {
		super(FluentUI.getDefault(), context);
	}

	private CompletionManager getCompletionMgr() {
		return FluentUI.getDefault().getCompletionMgr();
	}

	@Override
	protected String getContextTypeId() {
		return MdContextType.CONTEXT_TYPE_ID;
	}

	@Override
	protected char[] getIgnore() {
		return IGNORE;
	}

	@Override
	protected Template[] getTemplates(String contextTypeId) {
		if (!isValidContextType(contextTypeId)) return new Template[0];
		return getCompletionMgr().getTemplateStore().getTemplates(contextTypeId);
	}

	@Override
	protected TemplateContextType getContextType(ITextViewer viewer, IRegion region) {
		IDocumentExtension3 doc = (IDocumentExtension3) viewer.getDocument();
		ITypedRegion typedRegion = null;
		try {
			typedRegion = doc.getPartition(Partitions.PARTITIONING, region.getOffset(), true);
		} catch (BadLocationException | BadPartitioningException e) {
			e.printStackTrace();
		}
		if (typedRegion == null) return null;

		ContextTypeRegistry registry = getCompletionMgr().getTemplateContextTypeRegistry();
		String type = typedRegion.getType();

		switch (type) {
			case IDocument.DEFAULT_CONTENT_TYPE:
				return registry.getContextType(MdContextType.MD_CONTEXT_TYPE_ID);
			case Partitions.DOTBLOCK:
				return registry.getContextType(MdContextType.DOT_CONTEXT_TYPE_ID);
			case Partitions.FRONT_MATTER:
				return registry.getContextType(MdContextType.FM_CONTEXT_TYPE_ID);
			case Partitions.HTMLBLOCK:
				return registry.getContextType(MdContextType.HTML_CONTEXT_TYPE_ID);
			case Partitions.MATHBLOCK:
				return registry.getContextType(MdContextType.MATH_CONTEXT_TYPE_ID);
			case Partitions.UMLBLOCK:
				return registry.getContextType(MdContextType.UML_CONTEXT_TYPE_ID);
			default:
				return super.getContextType(viewer, region);
		}
	}

	protected boolean isValid(ITextViewer viewer, Region region, String prefix) {
		if (prefix == null) return false;
		if (prefix.length() == 0) {
			TemplateContextType contextType = getContextType(viewer, region);
			if (isValidContextType(contextType.getId())) return true;
			return false;
		}
		return true;
	}

	private boolean isValidContextType(String id) {
		for (String known : MdContextType.CONTEXT_TYPE_IDS) {
			if (known.equals(id)) return true;
		}
		return false;
	}
}
