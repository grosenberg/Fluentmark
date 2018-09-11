/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.preferences;

import org.eclipse.ui.texteditor.spelling.SpellingService;

import net.certiv.fluentmark.FluentUI;

public interface Prefs extends PrefsSpelling {

	// preference related values
	String CSS_RESOURCE_DIR = "resources/css/";
	String CSS = "css";
	String CSS_DEFAULT = "markdown.css";

	// preference store keys

	String MD_ID = "net.certiv.fluentmark";
	String EDITOR_TAB_WIDTH = MD_ID + ".tabWidth";
	String EDITOR_TAB_CHAR = MD_ID + ".tabChar";

	String EDITOR_BOLD_SUFFIX = "_bold"; //$NON-NLS-1$
	String EDITOR_ITALIC_SUFFIX = "_italic"; //$NON-NLS-1$
	String EDITOR_STRIKETHROUGH_SUFFIX = "_strikethrough"; //$NON-NLS-1$
	String EDITOR_UNDERLINE_SUFFIX = "_underline"; //$NON-NLS-1$

	String EDITOR_SEMANTIC_HIGHLIGHTING_ENABLED_SUFFIX = MD_ID + ".sematicHighlighting"; //$NON-NLS-1$

	String EDITOR_KEYWORDS_COLOR = MD_ID + ".keyWords"; //$NON-NLS-1$
	String EDITOR_KEYWORDS_BOLD = EDITOR_KEYWORDS_COLOR + EDITOR_BOLD_SUFFIX;
	String EDITOR_KEYWORDS_ITALIC = EDITOR_KEYWORDS_COLOR + EDITOR_ITALIC_SUFFIX;
	String EDITOR_KEYWORDS_STRIKETHROUGH = EDITOR_KEYWORDS_COLOR + EDITOR_STRIKETHROUGH_SUFFIX;
	String EDITOR_KEYWORDS_UNDERLINE = EDITOR_KEYWORDS_COLOR + EDITOR_UNDERLINE_SUFFIX;

	String EDITOR_SHOW_SEGMENTS = MD_ID + ".ShowSegments";
	String EDITOR_WORD_WRAP = MD_ID + ".WordWrap";
	String EDITOR_TASK_TAGS = MD_ID + ".TaskTagsOn";
	String EDITOR_TASK_TAGS_DEFINED = MD_ID + ".TaskTags";
	String EDITOR_SECTION_NUMBERS = MD_ID + ".SectionNumbers";

	String EDITOR_MD_CONVERTER = MD_ID + ".converterSelection";

	String KEY_MARDOWNJ = MD_ID + ".markdownJ";
	String KEY_BLACKFRIDAY = MD_ID + ".blackFriday";
	String KEY_COMMONMARK = MD_ID + ".commonmark";
	String KEY_PANDOC = MD_ID + ".pandoc";
	String KEY_PEGDOWN = MD_ID + ".pegDown";
	String KEY_TXTMARK = MD_ID + ".txtMark";
	String KEY_EXTERNAL = MD_ID + ".external";

	String EDITOR_BLACKFRIDAY_PROGRAM = MD_ID + ".blackFridayProgram";
	String EDITOR_BLACKFRIDAY_ADDTOC = MD_ID + ".blackFridayAddToc";
	String EDITOR_BLACKFRIDAY_SMART = MD_ID + ".blackFridaySmart";

	String EDITOR_TXTMARK_SAFEMODE = MD_ID + ".txtMark_SafeMode";
	String EDITOR_TXTMARK_EXTENDED = MD_ID + ".txtMark_ExtendedMode";

	String EDITOR_PANDOC_PROGRAM = MD_ID + ".pandocProgram";
	String EDITOR_PANDOC_TEMPLATES = MD_ID + ".pandocTemplates";
	String EDITOR_PANDOC_TEMPLATE = MD_ID + ".pandocTemplate";
	String EDITOR_PANDOC_ADDTOC = MD_ID + ".pandocAddToc";
	String EDITOR_PANDOC_SMART = MD_ID + ".pandocSmart";
	String EDITOR_PANDOC_MATHJAX = MD_ID + ".pandocMathjax";

	String EDITOR_UMLMODE_ENABLED = MD_ID + ".umlMode";
	String EDITOR_DOTMODE_ENABLED = MD_ID + ".dotMode";
	String EDITOR_DOT_PROGRAM = MD_ID + ".dotProgram";

	String EDITOR_EXTERNAL_COMMAND = MD_ID + ".externalConverterProgram";

	String EDITOR_DEFAULT_COLOR = MD_ID + ".defaultColor";
	String EDITOR_FRONTMATTER_COLOR = MD_ID + ".frontMatterColor";
	String EDITOR_COMMENT_VISIBLE_COLOR = MD_ID + ".visibleCommentColor";
	String EDITOR_COMMENT_HIDDEN_COLOR = MD_ID + ".hiddenCommentColor";

	String EDITOR_HEADER_COLOR = MD_ID + ".headerColor";
	String EDITOR_LIST_COLOR = MD_ID + ".listColor";
	String EDITOR_LINK_COLOR = MD_ID + ".linkColor";
	String EDITOR_HRULE_COLOR = MD_ID + ".hruleColor";
	String EDITOR_BOLD_COLOR = MD_ID + ".boldColor";
	String EDITOR_ITALIC_COLOR = MD_ID + ".italicColor";
	String EDITOR_STRIKEOUT_COLOR = MD_ID + ".strikeoutColor";
	String EDITOR_TASK_TAG_COLOR = MD_ID + ".taskTagColor";

	String EDITOR_CODE_COLOR = MD_ID + ".codeColor";
	String EDITOR_CODEBLOCK_COLOR = MD_ID + ".codeblockColor";

	String EDITOR_CODE_BG_COLOR = MD_ID + ".codeBackgroundColor";
	String EDITOR_CODEBLOCK_BG_COLOR = MD_ID + ".codeblockBackgroundColor";

	String EDITOR_HTML_KEYWORD_COLOR = MD_ID + ".htmlKeywordColor";
	String EDITOR_HTML_SYMBOL_COLOR = MD_ID + ".htmlSymbolColor";
	String EDITOR_HTML_STRING_COLOR = MD_ID + ".htmlStringColor";
	String EDITOR_HTML_BG_COLOR = MD_ID + ".htmlBackgroundColor";

	String EDITOR_MATH_KEYWORD_COLOR = MD_ID + ".mathKeywordColor";
	String EDITOR_MATH_SYMBOL_COLOR = MD_ID + ".mathSymbolColor";
	String EDITOR_MATH_COMMENT_COLOR = MD_ID + ".mathCommentColor";
	String EDITOR_MATH_BG_COLOR = MD_ID + ".mathBackgroundColor";

	String EDITOR_DOT_KEYWORD_COLOR = MD_ID + ".dotKeywordColor";
	String EDITOR_DOT_ATTRIBS_COLOR = MD_ID + ".dotAttribsColor";
	String EDITOR_DOT_SYMBOL_COLOR = MD_ID + ".dotSymbolColor";
	String EDITOR_DOT_COMMENT_COLOR = MD_ID + ".dotCommentColor";
	String EDITOR_DOT_STRING_COLOR = MD_ID + ".dotStringColor";
	String EDITOR_DOT_BG_COLOR = MD_ID + ".dotBackgroundColor";

	String EDITOR_UML_KEYWORD_COLOR = MD_ID + ".umlKeywordColor";
	String EDITOR_UML_ATTRIBS_COLOR = MD_ID + ".umlAttribsColor";
	String EDITOR_UML_SYMBOL_COLOR = MD_ID + ".umlSymbolColor";
	String EDITOR_UML_COMMENT_COLOR = MD_ID + ".umlCommentColor";
	String EDITOR_UML_STRING_COLOR = MD_ID + ".umlStringColor";
	String EDITOR_UML_BG_COLOR = MD_ID + ".umlBackgroundColor";

	String EDITOR_GITHUB_SYNTAX = MD_ID + ".github_Syntax";
	String EDITOR_MULTIMARKDOWN_METADATA = MD_ID + ".multiMarkdown_Metadata";

	String EDITOR_CSS_BUILTIN = MD_ID + ".markdown_Css";
	String EDITOR_CSS_EXTERNAL = "";

	String EDITOR_FORMATTING_ENABLED = MD_ID + ".formattingEnabled";
	String EDITOR_FORMATTING_COLUMN = MD_ID + ".formattingCol";

	String EDITOR_HTML_OPEN = MD_ID + ".htmlOpen";
	String EDITOR_PDF_OPEN = MD_ID + ".pdfOpen";

	String EDITOR_SMART_BACKSPACE = MD_ID + ".smartBackspace";
	String EDITOR_SMART_SEMICOLON = MD_ID + ".smartSemicolon";
	String EDITOR_SMART_OPENING_BRACE = MD_ID + ".smartOpenBrace";

	String EDITOR_CORRECTION_INDICATION = MD_ID + ".correction";

	String SPELLING_ENABLED = MD_ID + ".spellingEnabled";
	String SPELLING_ENGINE = SpellingService.PREFERENCE_SPELLING_ENGINE;

	String EDITOR_OUTLINE_SHOW_BLANKLINES = MD_ID + ".outlineShowBlanklines";
	String EDITOR_OUTLINE_SYNC_ON_CURSOR_MOVE = MD_ID + ".outlineSync";

	String EDITOR_SHOW_TEXT_HOVER_AFFORDANCE = "showTextHoverAffordance"; //$NON-NLS-1$

	String EDITOR_TEXT_FONT = "org.eclipse.jface.textfont";

	String FOLDING_LINES_LIMIT = MD_ID + ".foldingLineLimit";

	String FOLDING_FRONTMATTER_ENABLED = MD_ID + ".foldingFrontMatter";
	String FOLDING_CODEBLOCKS_ENABLED = MD_ID + ".foldingCodeblocks";
	String FOLDING_HTMLBLOCKS_ENABLED = MD_ID + ".foldingHtmlblocks";
	String FOLDING_HIDDEN_COMMENTS_ENABLED = MD_ID + ".foldingHiddenComments";

	String FOLDING_INITIAL_FRONT_MATTER = MD_ID + ".foldInitFrontmatter";
	String FOLDING_INITIAL_HIDDEN_COMMENTS = MD_ID + ".foldInitHiddenComments";
	String FOLDING_INITIAL_CODEBLOCKS = MD_ID + ".foldInitCodeblocks";
	String FOLDING_INITIAL_HTMLBLOCKS = MD_ID + ".foldInitHtmlblocks";

	String VIEW_UPDATE_DELAY = MD_ID + ".viewUpdateDelay";

	// code assist preferences

	/**
	 * A named preference that controls if the code assist gets auto activated.
	 */
	String CODEASSIST_AUTOACTIVATION = MD_ID + ".content_assist_autoactivation"; //$NON-NLS-1$

	/**
	 * A name preference that holds the auto activation delay time in milliseconds.
	 */
	String CODEASSIST_AUTOACTIVATION_DELAY = MD_ID + ".content_assist_autoactivation_delay"; //$NON-NLS-1$

	/**
	 * A named preference that controls if code assist contains only visible proposals.
	 */
	String CODEASSIST_SHOW_VISIBLE_PROPOSALS = MD_ID + ".content_assist_show_visible_proposals"; //$NON-NLS-1$

	/**
	 * A named preference that controls if the code assist inserts a proposal automatically if only one
	 * proposal is available.
	 */
	String CODEASSIST_AUTOINSERT = MD_ID + ".content_assist_autoinsert"; //$NON-NLS-1$

	/**
	 * A named preference that controls if the code assist only inserts completions. If set to false the
	 * proposals can also _replace_ code.
	 */
	String CODEASSIST_INSERT_COMPLETION = MD_ID + ".content_assist_insert_completion"; //$NON-NLS-1$

	/**
	 * A named preference that controls whether code assist proposals filtering is case sensitive or
	 * not.
	 */
	String CODEASSIST_CASE_SENSITIVITY = MD_ID + ".content_assist_case_sensitivity"; //$NON-NLS-1$

	/**
	 * A named preference that controls if argument names are filled in when a method is selected from
	 * as list of code assist proposal.
	 */
	String CODEASSIST_FILL_ARGUMENT_NAMES = MD_ID + ".content_assist_fill_method_arguments"; //$NON-NLS-1$

	/**
	 * A named preference that controls if content assist inserts the common prefix of all proposals
	 * before presenting choices.
	 */
	String CODEASSIST_PREFIX_COMPLETION = MD_ID + ".content_assist_prefix_completion"; //$NON-NLS-1$

	/**
	 * A named preference that holds the characters that auto activate code assist in Markdown.
	 */
	String CODEASSIST_AUTOACTIVATION_TRIGGERS_MD = MD_ID + ".content_assist_autoactivation_triggers_markdown"; //$NON-NLS-1$

	/**
	 * A named preference that holds the characters that auto activate code assist in DOT blocks.
	 */
	String CODEASSIST_AUTOACTIVATION_TRIGGERS_DOT = MD_ID + ".content_assist_autoactivation_triggers_dot"; //$NON-NLS-1$

	/**
	 * A named preference that holds the background color used for parameter hints.
	 */
	String CODEASSIST_PARAMETERS_BACKGROUND = MD_ID + ".content_assist_parameters_background"; //$NON-NLS-1$

	/**
	 * A named preference that holds the foreground color used in the code assist selection dialog.
	 */
	String CODEASSIST_PARAMETERS_FOREGROUND = MD_ID + ".content_assist_parameters_foreground"; //$NON-NLS-1$

	/**
	 * A named preference that holds the background color used in the code assist selection dialog to
	 * mark replaced code.
	 */
	String CODEASSIST_REPLACEMENT_BACKGROUND = MD_ID + ".content_assist_completion_replacement_background"; //$NON-NLS-1$

	/**
	 * A named preference that holds the foreground color used in the code assist selection dialog to
	 * mark replaced code.
	 */
	String CODEASSIST_REPLACEMENT_FOREGROUND = MD_ID + ".content_assist_completion_replacement_foreground"; //$NON-NLS-1$

	/**
	 * Code assist option ID: Activate Visibility Sensitive Completion.
	 */
	String CODEASSIST_VISIBILITY_CHECK = FluentUI.PLUGIN_ID + ".codeComplete.visibilityCheck"; //$NON-NLS-1$
}
