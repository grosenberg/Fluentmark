/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.preferences;

import org.eclipse.ui.texteditor.spelling.SpellingService;

import net.certiv.fluentmark.FluentMkUI;

public interface Prefs extends PrefsSpelling {

	// preference related values
	public static final String CSS_RESOURCE_DIR = "resources/css/";
	public static final String CSS = "css";
	public static final String CSS_DEFAULT = "markdown.css";

	// preference store keys

	static final String MD_ID = "net.certiv.fluentmark";
	static final String EDITOR_TAB_WIDTH = MD_ID + ".tabWidth";
	static final String EDITOR_TAB_CHAR = MD_ID + ".tabChar";

	static final String EDITOR_BOLD_SUFFIX = "_bold"; //$NON-NLS-1$
	static final String EDITOR_ITALIC_SUFFIX = "_italic"; //$NON-NLS-1$
	static final String EDITOR_STRIKETHROUGH_SUFFIX = "_strikethrough"; //$NON-NLS-1$
	static final String EDITOR_UNDERLINE_SUFFIX = "_underline"; //$NON-NLS-1$

	public static final String EDITOR_SEMANTIC_HIGHLIGHTING_ENABLED_SUFFIX = MD_ID + ".sematicHighlighting"; //$NON-NLS-1$

	static final String EDITOR_KEYWORDS_COLOR = MD_ID + ".keyWords"; //$NON-NLS-1$
	public static final String EDITOR_KEYWORDS_BOLD = EDITOR_KEYWORDS_COLOR + EDITOR_BOLD_SUFFIX;
	public static final String EDITOR_KEYWORDS_ITALIC = EDITOR_KEYWORDS_COLOR + EDITOR_ITALIC_SUFFIX;
	public static final String EDITOR_KEYWORDS_STRIKETHROUGH = EDITOR_KEYWORDS_COLOR + EDITOR_STRIKETHROUGH_SUFFIX;
	public static final String EDITOR_KEYWORDS_UNDERLINE = EDITOR_KEYWORDS_COLOR + EDITOR_UNDERLINE_SUFFIX;

	public static final String EDITOR_SHOW_SEGMENTS = MD_ID + ".ShowSegments";
	public static final String EDITOR_WORD_WRAP = MD_ID + ".WordWrap";
	public static final String EDITOR_TASK_TAGS = MD_ID + ".TaskTagsOn";
	public static final String EDITOR_TASK_TAGS_DEFINED = MD_ID + ".TaskTags";
	public static final String EDITOR_SECTION_NUMBERS = MD_ID + ".SectionNumbers";

	public static final String EDITOR_MD_CONVERTER = MD_ID + ".converterSelection";

	public static final String KEY_MARDOWNJ = MD_ID + ".markdownJ";
	public static final String KEY_BLACKFRIDAY = MD_ID + ".blackFriday";
	public static final String KEY_COMMONMARK = MD_ID + ".commonmark";
	public static final String KEY_PANDOC = MD_ID + ".pandoc";
	public static final String KEY_PEGDOWN = MD_ID + ".pegDown";
	public static final String KEY_TXTMARK = MD_ID + ".txtMark";
	public static final String KEY_EXTERNAL = MD_ID + ".external";

	public static final String EDITOR_BLACKFRIDAY_PROGRAM = MD_ID + ".blackFridayProgram";
	public static final String EDITOR_BLACKFRIDAY_ADDTOC = MD_ID + ".blackFridayAddToc";
	public static final String EDITOR_BLACKFRIDAY_SMART = MD_ID + ".blackFridaySmart";

	public static final String EDITOR_TXTMARK_SAFEMODE = MD_ID + ".txtMark_SafeMode";
	public static final String EDITOR_TXTMARK_EXTENDED = MD_ID + ".txtMark_ExtendedMode";

	public static final String EDITOR_PANDOC_PROGRAM = MD_ID + ".pandocProgram";
	public static final String EDITOR_PANDOC_ADDTOC = MD_ID + ".pandocAddToc";
	public static final String EDITOR_PANDOC_SMART = MD_ID + ".pandocSmart";
	public static final String EDITOR_PANDOC_MATHJAX = MD_ID + ".pandocMathjax";

	public static final String EDITOR_DOTMODE_ENABLED = MD_ID + ".txtMarkDotMode";
	public static final String EDITOR_DOT_PROGRAM = MD_ID + ".dotProgram";

	public static final String EDITOR_EXTERNAL_COMMAND = MD_ID + ".externalConverterProgram";

	public static final String EDITOR_DEFAULT_COLOR = MD_ID + ".defaultColor";
	public static final String EDITOR_FRONTMATTER_COLOR = MD_ID + ".frontMatterColor";
	public static final String EDITOR_COMMENT_VISIBLE_COLOR = MD_ID + ".visibleCommentColor";
	public static final String EDITOR_COMMENT_HIDDEN_COLOR = MD_ID + ".hiddenCommentColor";

	public static final String EDITOR_HEADER_COLOR = MD_ID + ".headerColor";
	public static final String EDITOR_LIST_COLOR = MD_ID + ".listColor";
	public static final String EDITOR_LINK_COLOR = MD_ID + ".linkColor";
	public static final String EDITOR_HRULE_COLOR = MD_ID + ".hruleColor";
	public static final String EDITOR_BOLD_COLOR = MD_ID + ".boldColor";
	public static final String EDITOR_ITALIC_COLOR = MD_ID + ".italicColor";
	public static final String EDITOR_STRIKEOUT_COLOR = MD_ID + ".strikeoutColor";
	public static final String EDITOR_TASK_TAG_COLOR = MD_ID + ".taskTagColor";

	public static final String EDITOR_CODE_COLOR = MD_ID + ".codeColor";
	public static final String EDITOR_CODEBLOCK_COLOR = MD_ID + ".codeblockColor";

	public static final String EDITOR_CODE_BG_COLOR = MD_ID + ".codeBackgroundColor";
	public static final String EDITOR_CODEBLOCK_BG_COLOR = MD_ID + ".codeblockBackgroundColor";

	public static final String EDITOR_HTML_KEYWORD_COLOR = MD_ID + ".htmlKeywordColor";
	public static final String EDITOR_HTML_SYMBOL_COLOR = MD_ID + ".htmlSymbolColor";
	public static final String EDITOR_HTML_STRING_COLOR = MD_ID + ".htmlStringColor";
	public static final String EDITOR_HTML_BG_COLOR = MD_ID + ".htmlBackgroundColor";

	public static final String EDITOR_MATH_KEYWORD_COLOR = MD_ID + ".mathKeywordColor";
	public static final String EDITOR_MATH_SYMBOL_COLOR = MD_ID + ".mathSymbolColor";
	public static final String EDITOR_MATH_COMMENT_COLOR = MD_ID + ".mathCommentColor";
	public static final String EDITOR_MATH_BG_COLOR = MD_ID + ".mathBackgroundColor";

	public static final String EDITOR_DOT_KEYWORD_COLOR = MD_ID + ".dotKeywordColor";
	public static final String EDITOR_DOT_ATTRIBS_COLOR = MD_ID + ".dotAttribsColor";
	public static final String EDITOR_DOT_SYMBOL_COLOR = MD_ID + ".dotSymbolColor";
	public static final String EDITOR_DOT_COMMENT_COLOR = MD_ID + ".dotCommentColor";
	public static final String EDITOR_DOT_STRING_COLOR = MD_ID + ".dotStringColor";
	public static final String EDITOR_DOT_BG_COLOR = MD_ID + ".dotBackgroundColor";

	public static final String EDITOR_GITHUB_SYNTAX = MD_ID + ".github_Syntax";
	public static final String EDITOR_MULTIMARKDOWN_METADATA = MD_ID + ".multiMarkdown_Metadata";

	public static final String EDITOR_CSS_BUILTIN = MD_ID + ".markdown_Css";
	public static final String EDITOR_CSS_EXTERNAL = "";

	public static final String EDITOR_FORMATTING_ENABLED = MD_ID + ".formattingEnabled";
	public static final String EDITOR_FORMATTING_COLUMN = MD_ID + ".formattingCol";

	public static final String EDITOR_HTML_OPEN = MD_ID + ".htmlOpen";
	public static final String EDITOR_PDF_OPEN = MD_ID + ".pdfOpen";

	public static final String EDITOR_SMART_BACKSPACE = MD_ID + ".smartBackspace";
	public static final String EDITOR_SMART_SEMICOLON = MD_ID + ".smartSemicolon";
	public static final String EDITOR_SMART_OPENING_BRACE = MD_ID + ".smartOpenBrace";

	public static final String SPELLING_ENABLED = MD_ID + ".spellingEnabled";
	public static final String SPELLING_ENGINE = SpellingService.PREFERENCE_SPELLING_ENGINE;

	public static final String EDITOR_OUTLINE_SHOW_BLANKLINES = MD_ID + ".outlineShowBlanklines";
	public static final String EDITOR_OUTLINE_SYNC_ON_CURSOR_MOVE = MD_ID + ".outlineSync";

	public static final String EDITOR_SHOW_TEXT_HOVER_AFFORDANCE = "showTextHoverAffordance"; //$NON-NLS-1$

	public static final String EDITOR_TEXT_FONT = "org.eclipse.jface.textfont";

	public static final String FOLDING_LINES_LIMIT = MD_ID + ".foldingLineLimit";

	public static final String FOLDING_FRONTMATTER_ENABLED = MD_ID + ".foldingFrontMatter";
	public static final String FOLDING_CODEBLOCKS_ENABLED = MD_ID + ".foldingCodeblocks";
	public static final String FOLDING_HTMLBLOCKS_ENABLED = MD_ID + ".foldingHtmlblocks";
	public static final String FOLDING_HIDDEN_COMMENTS_ENABLED = MD_ID + ".foldingHiddenComments";

	public static final String FOLDING_INITIAL_FRONT_MATTER = MD_ID + ".foldInitFrontmatter";
	public static final String FOLDING_INITIAL_HIDDEN_COMMENTS = MD_ID + ".foldInitHiddenComments";
	public static final String FOLDING_INITIAL_CODEBLOCKS = MD_ID + ".foldInitCodeblocks";
	public static final String FOLDING_INITIAL_HTMLBLOCKS = MD_ID + ".foldInitHtmlblocks";

	public static final String VIEW_UPDATE_DELAY = MD_ID + ".viewUpdateDelay";

	// code assist preferences

	/**
	 * A named preference that controls if the code assist gets auto activated.
	 */
	public final static String CODEASSIST_AUTOACTIVATION = MD_ID + ".content_assist_autoactivation"; //$NON-NLS-1$

	/**
	 * A name preference that holds the auto activation delay time in milliseconds.
	 */
	public final static String CODEASSIST_AUTOACTIVATION_DELAY = MD_ID + ".content_assist_autoactivation_delay"; //$NON-NLS-1$

	/**
	 * A named preference that controls if code assist contains only visible proposals.
	 */
	public final static String CODEASSIST_SHOW_VISIBLE_PROPOSALS = MD_ID + ".content_assist_show_visible_proposals"; //$NON-NLS-1$

	/**
	 * A named preference that controls if the code assist inserts a proposal automatically if only
	 * one proposal is available.
	 */
	public final static String CODEASSIST_AUTOINSERT = MD_ID + ".content_assist_autoinsert"; //$NON-NLS-1$

	/**
	 * A named preference that controls if the code assist only inserts completions. If set to false
	 * the proposals can also _replace_ code.
	 */
	public final static String CODEASSIST_INSERT_COMPLETION = MD_ID + ".content_assist_insert_completion"; //$NON-NLS-1$

	/**
	 * A named preference that controls whether code assist proposals filtering is case sensitive or
	 * not.
	 */
	public final static String CODEASSIST_CASE_SENSITIVITY = MD_ID + ".content_assist_case_sensitivity"; //$NON-NLS-1$

	/**
	 * A named preference that controls if argument names are filled in when a method is selected
	 * from as list of code assist proposal.
	 */
	public final static String CODEASSIST_FILL_ARGUMENT_NAMES = MD_ID + ".content_assist_fill_method_arguments"; //$NON-NLS-1$

	/**
	 * A named preference that controls if content assist inserts the common prefix of all proposals
	 * before presenting choices.
	 */
	public final static String CODEASSIST_PREFIX_COMPLETION = MD_ID + ".content_assist_prefix_completion"; //$NON-NLS-1$

	/**
	 * A named preference that holds the characters that auto activate code assist in Markdown.
	 */
	public final static String CODEASSIST_AUTOACTIVATION_TRIGGERS_MD = MD_ID
			+ ".content_assist_autoactivation_triggers_markdown"; //$NON-NLS-1$

	/**
	 * A named preference that holds the characters that auto activate code assist in DOT blocks.
	 */
	public final static String CODEASSIST_AUTOACTIVATION_TRIGGERS_DOT = MD_ID
			+ ".content_assist_autoactivation_triggers_dot"; //$NON-NLS-1$

	/**
	 * A named preference that holds the background color used for parameter hints.
	 */
	public final static String CODEASSIST_PARAMETERS_BACKGROUND = MD_ID + ".content_assist_parameters_background"; //$NON-NLS-1$

	/**
	 * A named preference that holds the foreground color used in the code assist selection dialog.
	 */
	public final static String CODEASSIST_PARAMETERS_FOREGROUND = MD_ID + ".content_assist_parameters_foreground"; //$NON-NLS-1$

	/**
	 * A named preference that holds the background color used in the code assist selection dialog
	 * to mark replaced code.
	 */
	public final static String CODEASSIST_REPLACEMENT_BACKGROUND = MD_ID
			+ ".content_assist_completion_replacement_background"; //$NON-NLS-1$

	/**
	 * A named preference that holds the foreground color used in the code assist selection dialog
	 * to mark replaced code.
	 */
	public final static String CODEASSIST_REPLACEMENT_FOREGROUND = MD_ID
			+ ".content_assist_completion_replacement_foreground"; //$NON-NLS-1$

	/**
	 * Code assist option ID: Activate Visibility Sensitive Completion.
	 */
	public static final String CODEASSIST_VISIBILITY_CHECK = FluentMkUI.PLUGIN_ID + ".codeComplete.visibilityCheck"; //$NON-NLS-1$
}
