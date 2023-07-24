/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluent.dt.core.preferences;

import org.eclipse.ui.texteditor.spelling.SpellingService;

public class Prefs extends PrefsSpelling {

	// preference store keys

	public static final String EDITOR_SHOW_SEGMENTS = "{DSL_ID}" + ".ShowSegments";
	public static final String EDITOR_SOFT_WRAP = "{DSL_ID}" + ".softWrap";

	public static final String EDITOR_TASK_TAGS = "{DSL_ID}" + ".TaskTagsOn";
	public static final String EDITOR_TASK_TAGS_DEFINED = "{DSL_ID}" + ".TaskTags";
	public static final String EDITOR_SECTION_NUMBERS = "{DSL_ID}" + ".SectionNumbers";

	public static final String EDITOR_MD_CONVERTER = "{DSL_ID}" + ".converterSelection";

	public static final String FORMATTER_ENABLED = "{DSL_ID}" + ".formatEnabled";
	public static final String FORMATTER_ON_SAVE = "{DSL_ID}" + ".formatOnSave";

	public static final String EDITOR_SHOW_TOOLBAR = "{DSL_ID}" + ".showEditorToolbar";

	public static final String KEY_BLACKFRIDAY = "{DSL_ID}" + ".blackFriday";
	public static final String EDITOR_BLACKFRIDAY_PROGRAM = "{DSL_ID}" + ".blackFridayProgram";
	public static final String EDITOR_BLACKFRIDAY_ADDTOC = "{DSL_ID}" + ".blackFridayAddToc";
	public static final String EDITOR_BLACKFRIDAY_SMART = "{DSL_ID}" + ".blackFridaySmart";

	public static final String KEY_FLEXMARK = "{DSL_ID}" + ".flexMark";
	public static final String EDITOR_FLEXMARK_MATHJAX = "{DSL_ID}" + ".flexMark_Mathjax";
	public static final String EDITOR_FLEXMARK_PROFILE = "{DSL_ID}" + ".flexMark_Profile";

	public static final String KEY_PANDOC = "{DSL_ID}" + ".pandoc";
	public static final String EDITOR_PANDOC_PROGRAM = "{DSL_ID}" + ".pandocProgram";
	public static final String EDITOR_PANDOC_TEMPLATES = "{DSL_ID}" + ".pandocTemplates";
	public static final String EDITOR_PANDOC_TEMPLATE = "{DSL_ID}" + ".pandocTemplate";
	public static final String EDITOR_PANDOC_ADDTOC = "{DSL_ID}" + ".pandocAddToc";
	public static final String EDITOR_PANDOC_SMART = "{DSL_ID}" + ".pandocSmart";
	public static final String EDITOR_PANDOC_MATHJAX = "{DSL_ID}" + ".pandocMathjax";

	public static final String KEY_EXTERNAL = "{DSL_ID}" + ".external";
	public static final String EDITOR_EXTERNAL_COMMAND = "{DSL_ID}" + ".externalConverterProgram";

	public static final String KEY_GRAPHS = "{DSL_ID}" + ".dot";
	public static final String EDITOR_DOTMODE_ENABLED = "{DSL_ID}" + ".dotMode";
	public static final String EDITOR_DOT_PROGRAM = "{DSL_ID}" + ".dotProgram";
	public static final String EDITOR_UMLMODE_ENABLED = "{DSL_ID}" + ".umlMode";
	public static final String EDITOR_CODEBLOCK_CONVERT_ENABLED = "{DSL_ID}" + ".codeblockMode";

	public static final String EDITOR_DEFAULT_COLOR = "{DSL_ID}" + ".defaultColor";
	public static final String EDITOR_FRONTMATTER_COLOR = "{DSL_ID}" + ".frontMatterColor";
	public static final String EDITOR_COMMENT_VISIBLE_COLOR = "{DSL_ID}" + ".visibleCommentColor";
	public static final String EDITOR_COMMENT_HIDDEN_COLOR = "{DSL_ID}" + ".hiddenCommentColor";

	public static final String EDITOR_HEADER_COLOR = "{DSL_ID}" + ".headerColor";
	public static final String EDITOR_LIST_COLOR = "{DSL_ID}" + ".listColor";
	public static final String EDITOR_LINK_COLOR = "{DSL_ID}" + ".linkColor";
	public static final String EDITOR_HRULE_COLOR = "{DSL_ID}" + ".hruleColor";
	public static final String EDITOR_BOLD_COLOR = "{DSL_ID}" + ".boldColor";
	public static final String EDITOR_ITALIC_COLOR = "{DSL_ID}" + ".italicColor";
	public static final String EDITOR_STRIKEOUT_COLOR = "{DSL_ID}" + ".strikeoutColor";
	public static final String EDITOR_TASK_TAG_COLOR = "{DSL_ID}" + ".taskTagColor";

	public static final String EDITOR_CODE_COLOR = "{DSL_ID}" + ".codeColor";
	public static final String EDITOR_CODEBLOCK_COLOR = "{DSL_ID}" + ".codeblockColor";

	public static final String EDITOR_CODE_BG_COLOR = "{DSL_ID}" + ".codeBackgroundColor";
	public static final String EDITOR_CODEBLOCK_BG_COLOR = "{DSL_ID}" + ".codeblockBackgroundColor";

	public static final String EDITOR_HTML_KEYWORD_COLOR = "{DSL_ID}" + ".htmlKeywordColor";
	public static final String EDITOR_HTML_SYMBOL_COLOR = "{DSL_ID}" + ".htmlSymbolColor";
	public static final String EDITOR_HTML_STRING_COLOR = "{DSL_ID}" + ".htmlStringColor";
	public static final String EDITOR_HTML_BG_COLOR = "{DSL_ID}" + ".htmlBackgroundColor";

	public static final String EDITOR_MATH_KEYWORD_COLOR = "{DSL_ID}" + ".mathKeywordColor";
	public static final String EDITOR_MATH_SYMBOL_COLOR = "{DSL_ID}" + ".mathSymbolColor";
	public static final String EDITOR_MATH_COMMENT_COLOR = "{DSL_ID}" + ".mathCommentColor";
	public static final String EDITOR_MATH_BG_COLOR = "{DSL_ID}" + ".mathBackgroundColor";

	public static final String EDITOR_DOT_KEYWORD_COLOR = "{DSL_ID}" + ".dotKeywordColor";
	public static final String EDITOR_DOT_ATTRIBS_COLOR = "{DSL_ID}" + ".dotAttribsColor";
	public static final String EDITOR_DOT_SYMBOL_COLOR = "{DSL_ID}" + ".dotSymbolColor";
	public static final String EDITOR_DOT_COMMENT_COLOR = "{DSL_ID}" + ".dotCommentColor";
	public static final String EDITOR_DOT_STRING_COLOR = "{DSL_ID}" + ".dotStringColor";
	public static final String EDITOR_DOT_BG_COLOR = "{DSL_ID}" + ".dotBackgroundColor";

	public static final String EDITOR_UML_KEYWORD_COLOR = "{DSL_ID}" + ".umlKeywordColor";
	public static final String EDITOR_UML_ATTRIBS_COLOR = "{DSL_ID}" + ".umlAttribsColor";
	public static final String EDITOR_UML_SYMBOL_COLOR = "{DSL_ID}" + ".umlSymbolColor";
	public static final String EDITOR_UML_COMMENT_COLOR = "{DSL_ID}" + ".umlCommentColor";
	public static final String EDITOR_UML_STRING_COLOR = "{DSL_ID}" + ".umlStringColor";
	public static final String EDITOR_UML_BG_COLOR = "{DSL_ID}" + ".umlBackgroundColor";

	public static final String EDITOR_GITHUB_SYNTAX = "{DSL_ID}" + ".github_Syntax";
	public static final String EDITOR_MULTIMARKDOWN_METADATA = "{DSL_ID}" + ".multiMarkdown_Metadata";

	public static final String PREVIEW = "css/preview";
	public static final String MARKDOWN_CSS = "markdown.css";

	public static final String EDITOR_PREVIEW_FILE = "{DSL_ID}" + ".cssFile";
	public static final String EDITOR_PREVIEW_INTERNAL_DIR = "{DSL_ID}" + ".previewIntDir";
	public static final String EDITOR_PREVIEW_EXTERNAL_DIR = "{DSL_ID}" + ".previewExtDir";
	public static final String EDITOR_PREVIEW_EXTERNAL_ENABLE = "{DSL_ID}" + ".previewExtEnable";
	public static final String EDITOR_PREVIEW_MAXDEPTH = "{DSL_ID}" + ".previewExtMaxDepth";

	public static final String VIEW_HTML_OPEN = "{DSL_ID}" + ".htmlOpen";
	public static final String VIEW_PDF_OPEN = "{DSL_ID}" + ".pdfOpen";

	public static final String SPELLING_ENABLED = "{DSL_ID}" + ".spellingEnabled";
	public static final String SPELLING_ENGINE = SpellingService.PREFERENCE_SPELLING_ENGINE;

	public static final String EDITOR_OUTLINE_SHOW_BLANKLINES = "{DSL_ID}" + ".outlineShowBlanklines";
	public static final String EDITOR_OUTLINE_SYNC_ON_CURSOR_MOVE = "{DSL_ID}" + ".outlineSync";

	public static final String FOLDING_FRONTMATTER = "{DSL_ID}" + ".foldingFrontMatter";
	public static final String FOLDING_COMMENTS = "{DSL_ID}" + ".foldingComments";
	public static final String FOLDING_CODEBLOCKS = "{DSL_ID}" + ".foldingCodeblocks";
	public static final String FOLDING_HTMLBLOCKS = "{DSL_ID}" + ".foldingHtmlblocks";
	public static final String FOLDING_DOTBLOCKS = "{DSL_ID}" + ".foldingDotblocks";
	public static final String FOLDING_UMLBLOCKS = "{DSL_ID}" + ".foldingUmlblocks";
	public static final String FOLDING_MATHBLOCKS = "{DSL_ID}" + ".foldingMathblocks";

	/** Data source: internal debounce delay */
	public static final String VIEW_UPDATE_DELAY = "{DSL_ID}" + ".viewUpdateDelay";

	/** Embedded server hostname */
	public static final String VIEW_HOST_NAME = "{DSL_ID}" + ".viewHostname";
	/** Embedded server hostname */
	public static final String VIEW_HOST_PORT = "{DSL_ID}" + ".viewHostport";

	/** Server: websocket context pathname */
	public static final String VIEW_WS_CONTEXT = "{DSL_ID}" + ".viewWsContext";

	/** Client: static resource base dir (relative to a tmp folder) */
	public static final String VIEW_CLNT_BASE = "{DSL_ID}" + ".viewClientBase";
	/** Client: index page name */
	public static final String VIEW_CLNT_APPL = "{DSL_ID}" + ".viewClientAppl";
	/** Client: allow anonymous websocket connections */
	public static final String VIEW_WS_DEBUG = "{DSL_ID}" + ".viewDebugWsClient";
}
