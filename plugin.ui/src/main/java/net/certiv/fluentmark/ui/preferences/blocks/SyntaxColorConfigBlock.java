package net.certiv.fluentmark.ui.preferences.blocks;

import java.io.InputStream;
import java.util.List;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.IOverviewRuler;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.texteditor.ITextEditor;

import net.certiv.dsl.core.color.DslColorManager;
import net.certiv.dsl.core.color.IColorManager;
import net.certiv.dsl.core.preferences.DslPrefsManagerDelta;
import net.certiv.dsl.core.preferences.IDslPrefsManager;
import net.certiv.dsl.ui.editor.DslSourceViewerConfiguration;
import net.certiv.dsl.ui.preferences.blocks.AbstractSyntaxColorConfigBlock;
import net.certiv.fluentmark.core.preferences.Prefs;
import net.certiv.fluentmark.ui.FluentUI;
import net.certiv.fluentmark.ui.editor.FluentSimpleSourceViewerConfiguration;
import net.certiv.fluentmark.ui.editor.FluentSourceViewer;
import net.certiv.fluentmark.ui.editor.Partitions;
import net.certiv.fluentmark.ui.preferences.pages.SyntaxColorPage;

public class SyntaxColorConfigBlock extends AbstractSyntaxColorConfigBlock {

	public SyntaxColorConfigBlock(SyntaxColorPage page, DslPrefsManagerDelta delta, FormToolkit formkit,
			DslColorManager colorMgr) {
		super(page, delta, formkit, colorMgr);
	}

	@Override
	protected List<String> createDeltaMatchKeys(List<String> keys) {
		keys.add(Prefs.EDITOR_FRONTMATTER_COLOR);
		keys.add(Prefs.EDITOR_COMMENT_VISIBLE_COLOR);
		keys.add(Prefs.EDITOR_COMMENT_HIDDEN_COLOR);
		keys.add(Prefs.EDITOR_HTML_KEYWORD_COLOR);
		keys.add(Prefs.EDITOR_HTML_SYMBOL_COLOR);
		keys.add(Prefs.EDITOR_HTML_STRING_COLOR);

		keys.add(Prefs.EDITOR_CODE_COLOR);
		keys.add(Prefs.EDITOR_CODEBLOCK_COLOR);

		keys.add(Prefs.EDITOR_DOT_KEYWORD_COLOR);
		keys.add(Prefs.EDITOR_DOT_ATTRIBS_COLOR);
		keys.add(Prefs.EDITOR_DOT_SYMBOL_COLOR);
		keys.add(Prefs.EDITOR_DOT_COMMENT_COLOR);
		keys.add(Prefs.EDITOR_DOT_STRING_COLOR);

		keys.add(Prefs.EDITOR_HEADER_COLOR);
		keys.add(Prefs.EDITOR_LIST_COLOR);
		keys.add(Prefs.EDITOR_LINK_COLOR);
		keys.add(Prefs.EDITOR_HRULE_COLOR);
		keys.add(Prefs.EDITOR_BOLD_COLOR);
		keys.add(Prefs.EDITOR_ITALIC_COLOR);
		keys.add(Prefs.EDITOR_STRIKEOUT_COLOR);
		keys.add(Prefs.EDITOR_TASK_TAG_COLOR);

		keys.add(Prefs.EDITOR_MATH_KEYWORD_COLOR);
		keys.add(Prefs.EDITOR_MATH_SYMBOL_COLOR);
		keys.add(Prefs.EDITOR_MATH_COMMENT_COLOR);

		keys.add(Prefs.EDITOR_UML_KEYWORD_COLOR);
		keys.add(Prefs.EDITOR_UML_ATTRIBS_COLOR);
		keys.add(Prefs.EDITOR_UML_SYMBOL_COLOR);
		keys.add(Prefs.EDITOR_UML_COMMENT_COLOR);
		keys.add(Prefs.EDITOR_UML_STRING_COLOR);

		return keys;
	}

	@Override
	protected void initCatPrefsModel() {
		addColorPreference("Comments", "Front Matter", Prefs.EDITOR_FRONTMATTER_COLOR);
		addColorPreference("Comments", "Visible Comments", Prefs.EDITOR_COMMENT_VISIBLE_COLOR);
		addColorPreference("Comments", "Hidden Comments", Prefs.EDITOR_COMMENT_HIDDEN_COLOR);
		addColorPreference("Comments", "Keywords", Prefs.EDITOR_HTML_KEYWORD_COLOR);
		addColorPreference("Comments", "Symbols", Prefs.EDITOR_HTML_SYMBOL_COLOR);
		addColorPreference("Comments", "Strings", Prefs.EDITOR_HTML_STRING_COLOR);

		addColorPreference("Code & Code Blocks", "Code", Prefs.EDITOR_CODE_COLOR);
		addColorPreference("Code & Code Blocks", "Code Blocks", Prefs.EDITOR_CODEBLOCK_COLOR);

		addColorPreference("Dot", "Keywords", Prefs.EDITOR_DOT_KEYWORD_COLOR);
		addColorPreference("Dot", "AttrMap", Prefs.EDITOR_DOT_ATTRIBS_COLOR);
		addColorPreference("Dot", "Symbols", Prefs.EDITOR_DOT_SYMBOL_COLOR);
		addColorPreference("Dot", "Comments", Prefs.EDITOR_DOT_COMMENT_COLOR);
		addColorPreference("Dot", "Strings", Prefs.EDITOR_DOT_STRING_COLOR);

		addColorPreference("Markup", "Headers", Prefs.EDITOR_HEADER_COLOR);
		addColorPreference("Markup", "Lists", Prefs.EDITOR_LIST_COLOR);
		addColorPreference("Markup", "Links", Prefs.EDITOR_LINK_COLOR);
		addColorPreference("Markup", "Horz Rules", Prefs.EDITOR_HRULE_COLOR);
		addColorPreference("Markup", "Bold", Prefs.EDITOR_BOLD_COLOR);
		addColorPreference("Markup", "Italic", Prefs.EDITOR_ITALIC_COLOR);
		addColorPreference("Markup", "Strikeout", Prefs.EDITOR_STRIKEOUT_COLOR);
		addColorPreference("Markup", "Task Tags", Prefs.EDITOR_TASK_TAG_COLOR);

		addColorPreference("Math", "Keywords", Prefs.EDITOR_MATH_KEYWORD_COLOR);
		addColorPreference("Math", "Symbols", Prefs.EDITOR_MATH_SYMBOL_COLOR);
		addColorPreference("Math", "Comments", Prefs.EDITOR_MATH_COMMENT_COLOR);

		addColorPreference("Uml", "Keywords", Prefs.EDITOR_UML_KEYWORD_COLOR);
		addColorPreference("Uml", "Types", Prefs.EDITOR_UML_ATTRIBS_COLOR);
		addColorPreference("Uml", "Symbols", Prefs.EDITOR_UML_SYMBOL_COLOR);
		addColorPreference("Uml", "Comments", Prefs.EDITOR_UML_COMMENT_COLOR);
		addColorPreference("Uml", "Strings", Prefs.EDITOR_UML_STRING_COLOR);
	}

	@Override
	protected ProjectionViewer createPreviewViewer(Composite parent, IVerticalRuler verticalRuler,
			IOverviewRuler overviewRuler, boolean showAnnotationsOverview, int styles, IDslPrefsManager store) {

		return new FluentSourceViewer(parent, null, null, false, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER, store);
	}

	@Override
	protected DslSourceViewerConfiguration createSimpleSourceViewerConfiguration(IColorManager colorMgr,
			IDslPrefsManager store, ITextEditor editor, boolean configFormatter) {

		return new FluentSimpleSourceViewerConfiguration(colorMgr, store, null, Partitions.PARTITIONING, false);
	}

	@Override
	protected void setDocumentPartitioning(IDocument document) {
		FluentUI.getDefault().getTextTools().setupDocumentPartitioner(document, Partitions.PARTITIONING);
	}

	@Override
	protected InputStream getPreviewContentStream() {
		return getClass().getResourceAsStream("ColorsPreview.md"); //$NON-NLS-1$
	}
}
