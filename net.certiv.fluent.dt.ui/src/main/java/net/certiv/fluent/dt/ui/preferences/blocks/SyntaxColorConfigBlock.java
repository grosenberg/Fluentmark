package net.certiv.fluent.dt.ui.preferences.blocks;

import java.io.InputStream;
import java.util.List;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.IOverviewRuler;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;

import net.certiv.dsl.core.color.DslColorManager;
import net.certiv.dsl.core.color.IColorManager;
import net.certiv.dsl.core.preferences.PrefsDeltaManager;
import net.certiv.dsl.core.preferences.IPrefsManager;
import net.certiv.dsl.ui.editor.DslEditor;
import net.certiv.dsl.ui.editor.DslSourceViewer;
import net.certiv.dsl.ui.editor.DslSourceViewerConfiguration;
import net.certiv.dsl.ui.preferences.blocks.AbstractSyntaxColorConfigBlock;
import net.certiv.fluent.dt.core.preferences.Prefs;
import net.certiv.fluent.dt.ui.FluentUI;
import net.certiv.fluent.dt.ui.editor.FluentSimpleSourceViewerConfiguration;
import net.certiv.fluent.dt.ui.editor.Partitions;
import net.certiv.fluent.dt.ui.preferences.page.SyntaxColorPage;

public class SyntaxColorConfigBlock extends AbstractSyntaxColorConfigBlock {

	private static final String PREVIEW_FILE_NAME = "ColorsPreview.md";

	public SyntaxColorConfigBlock(SyntaxColorPage page, PrefsDeltaManager delta, FormToolkit formkit,
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
			IOverviewRuler overviewRuler, boolean showAnnotationsOverview, int styles, IPrefsManager store) {

		return new DslSourceViewer(page.getDslUI(), parent, verticalRuler, overviewRuler, showAnnotationsOverview,
				styles, store);
	}

	@Override
	protected DslSourceViewerConfiguration createSimpleSourceViewerConfiguration(IColorManager colorMgr,
			IPrefsManager store, DslEditor editor, boolean configFormatter) {

		return new FluentSimpleSourceViewerConfiguration(colorMgr, store, editor, Partitions.PARTITIONING,
				configFormatter);
	}

	@Override
	protected void setDocumentPartitioning(IDocument document) {
		FluentUI.getDefault().getTextTools().setupDocument(document);
	}

	@Override
	protected InputStream getPreviewContentStream() {
		return getClass().getResourceAsStream(PREVIEW_FILE_NAME);
	}
}
