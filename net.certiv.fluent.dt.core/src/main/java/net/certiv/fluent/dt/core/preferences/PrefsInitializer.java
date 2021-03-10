package net.certiv.fluent.dt.core.preferences;

import java.util.Locale;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.ui.texteditor.spelling.SpellingService;

import net.certiv.common.util.Strings;
import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.core.preferences.DslPrefsInit;
import net.certiv.dsl.core.preferences.consts.Editor;
import net.certiv.fluent.dt.core.FluentCore;
import net.certiv.spellchecker.SpellCheckEngine;

/** Initializer for the preferences unique to this plugin. */
public class PrefsInitializer extends DslPrefsInit {

	private static final RGB DEF_DEFAULT = new RGB(0, 0, 0);
	private static final RGB DEF_COMMENT = new RGB(128, 0, 0);
	private static final RGB DEF_HEADER = new RGB(0, 128, 0);
	private static final RGB DEF_LINK = new RGB(106, 131, 199);

	private static final RGB DEF_KEYWORD = new RGB(127, 0, 85);
	private static final RGB DEF_SYMBOL = new RGB(96, 96, 128);
	private static final RGB DEF_STRING = new RGB(42, 0, 255);

	private static final RGB DEF_CODE = new RGB(0, 0, 0);
	private static final RGB DEF_CODE_BG = new RGB(244, 244, 244);

	@Override
	public DslCore getDslCore() {
		return FluentCore.getDefault();
	}

	@Override
	public void initializeDefaultPreferences() {
		super.initializeDefaultPreferences();

		setInt(Editor.EDITOR_TAB_WIDTH, 2);

		setString(Editor.EDITOR_TAB_POLICY, Editor.SPACE);
		setBool(Editor.EDITOR_SMART_OPENING_BRACE, false);
		setBool(Editor.EDITOR_SMART_SEMICOLON, false);

		setBool(Prefs.EDITOR_WORD_WRAP, false);
		setBool(Prefs.EDITOR_SHOW_SEGMENTS, false);
		setBool(Prefs.FORMATTER_ENABLED, true);
		setInt(Prefs.FORMATTER_WRAP_COLUMN, 80);

		setBool(Prefs.EDITOR_OUTLINE_SHOW_BLANKLINES, false);
		setBool(Prefs.EDITOR_OUTLINE_SYNC_ON_CURSOR_MOVE, true);

		setBool(Prefs.EDITOR_TASK_TAGS, true);
		setString(Prefs.EDITOR_TASK_TAGS_DEFINED, "TODO,FIXME,NOTE");

		// converters

		setString(Prefs.EDITOR_MD_CONVERTER, Prefs.KEY_PANDOC);
		setString(Prefs.EDITOR_MD_ENGINE, String.valueOf(SWT.NONE));

		setBool(Prefs.EDITOR_UMLMODE_ENABLED, false);
		setBool(Prefs.EDITOR_DOTMODE_ENABLED, false);
		setString(Prefs.EDITOR_DOT_PROGRAM, Strings.EMPTY);

		setString(Prefs.EDITOR_FLEXMARK_PROFILE, "GITHUB_DOC");
		setBool(Prefs.EDITOR_FLEXMARK_MATHJAX, true);

		setBool(Prefs.EDITOR_BLACKFRIDAY_ADDTOC, false);
		setBool(Prefs.EDITOR_BLACKFRIDAY_SMART, true);
		setString(Prefs.EDITOR_BLACKFRIDAY_PROGRAM, Strings.EMPTY);

		setBool(Prefs.EDITOR_PANDOC_ADDTOC, false);
		setBool(Prefs.EDITOR_PANDOC_MATHJAX, false);
		setBool(Prefs.EDITOR_PANDOC_SMART, true);
		setString(Prefs.EDITOR_PANDOC_PROGRAM, Strings.EMPTY);
		setString(Prefs.EDITOR_PANDOC_TEMPLATES, Strings.EMPTY);
		setString(Prefs.EDITOR_PANDOC_TEMPLATE, Strings.EMPTY);

		setString(Prefs.EDITOR_EXTERNAL_COMMAND, Strings.EMPTY);

		setBool(Prefs.EDITOR_SECTION_NUMBERS, true);

		setBool(Prefs.FORMATTER_ENABLED, true);
		setBool(Prefs.FORMATTER_UNWRAP, false);

		setBool(Prefs.VIEW_HTML_OPEN, false);
		setBool(Prefs.VIEW_PDF_OPEN, true);

		setBool(Prefs.EDITOR_GITHUB_SYNTAX, true);
		setBool(Prefs.EDITOR_MULTIMARKDOWN_METADATA, true);

		// stylesheets

		String BUNDLE_ID = "net.certiv.fluent.dt.ui";
		String previewDir = resourceDir(BUNDLE_ID, Prefs.PREVIEW);
		setString(Prefs.EDITOR_PREVIEW_INTERNAL_DIR, previewDir);
		setString(Prefs.EDITOR_PREVIEW_FILE, previewDir + Prefs.MARKDOWN_CSS);

		setBool(Prefs.EDITOR_PREVIEW_EXTERNAL_ENABLE, false);
		setString(Prefs.EDITOR_PREVIEW_EXTERNAL_DIR, Strings.EMPTY);
		setInt(Prefs.EDITOR_PREVIEW_MAXDEPTH, 2);

		String semanticDir = resourceDir(BUNDLE_ID, Editor.SEMANTIC_DIR);
		setString(Editor.EDITOR_SEMANTIC_INTERNAL_DIR, semanticDir);
		setString(Editor.EDITOR_SEMANTIC_FILE, semanticDir + Editor.DEFAULT_CSS);

		// colors

		setRGB(Prefs.EDITOR_DEFAULT_COLOR, DEF_DEFAULT);

		setRGB(Prefs.EDITOR_FRONTMATTER_COLOR, DEF_COMMENT);
		setRGB(Prefs.EDITOR_COMMENT_VISIBLE_COLOR, DEF_COMMENT);
		setRGB(Prefs.EDITOR_COMMENT_HIDDEN_COLOR, DEF_COMMENT);

		setRGB(Prefs.EDITOR_HEADER_COLOR, DEF_HEADER);
		setRGB(Prefs.EDITOR_LIST_COLOR, DEF_DEFAULT);
		setRGB(Prefs.EDITOR_LINK_COLOR, DEF_LINK);
		setRGB(Prefs.EDITOR_HRULE_COLOR, DEF_LINK);
		setRGB(Prefs.EDITOR_BOLD_COLOR, DEF_DEFAULT);
		setRGB(Prefs.EDITOR_ITALIC_COLOR, DEF_DEFAULT);
		setRGB(Prefs.EDITOR_STRIKEOUT_COLOR, DEF_DEFAULT);

		setRGB(Prefs.EDITOR_HTML_KEYWORD_COLOR, DEF_KEYWORD);
		setRGB(Prefs.EDITOR_HTML_SYMBOL_COLOR, DEF_SYMBOL);
		setRGB(Prefs.EDITOR_HTML_STRING_COLOR, DEF_STRING);
		setRGB(Prefs.EDITOR_HTML_BG_COLOR, DEF_DEFAULT);

		setRGB(Prefs.EDITOR_CODE_COLOR, DEF_CODE);
		setRGB(Prefs.EDITOR_CODEBLOCK_COLOR, DEF_CODE);

		setRGB(Prefs.EDITOR_DOT_KEYWORD_COLOR, DEF_KEYWORD);
		setRGB(Prefs.EDITOR_DOT_ATTRIBS_COLOR, DEF_KEYWORD);
		setRGB(Prefs.EDITOR_DOT_SYMBOL_COLOR, DEF_SYMBOL);
		setRGB(Prefs.EDITOR_DOT_COMMENT_COLOR, DEF_COMMENT);
		setRGB(Prefs.EDITOR_DOT_STRING_COLOR, DEF_STRING);
		setRGB(Prefs.EDITOR_DOT_BG_COLOR, DEF_DEFAULT);

		setRGB(Prefs.EDITOR_UML_KEYWORD_COLOR, DEF_KEYWORD);
		setRGB(Prefs.EDITOR_UML_ATTRIBS_COLOR, DEF_KEYWORD);
		setRGB(Prefs.EDITOR_UML_SYMBOL_COLOR, DEF_SYMBOL);
		setRGB(Prefs.EDITOR_UML_COMMENT_COLOR, DEF_COMMENT);
		setRGB(Prefs.EDITOR_UML_STRING_COLOR, DEF_STRING);
		setRGB(Prefs.EDITOR_UML_BG_COLOR, DEF_DEFAULT);

		setRGB(Prefs.EDITOR_CODE_BG_COLOR, DEF_CODE_BG);
		setRGB(Prefs.EDITOR_CODEBLOCK_BG_COLOR, DEF_CODE_BG);

		setRGB(Prefs.EDITOR_MATH_KEYWORD_COLOR, DEF_KEYWORD);
		setRGB(Prefs.EDITOR_MATH_SYMBOL_COLOR, DEF_SYMBOL);
		setRGB(Prefs.EDITOR_MATH_COMMENT_COLOR, DEF_COMMENT);

		// live view

		setInt(Prefs.VIEW_UPDATE_DELAY, 1000);
		setString(Prefs.VIEW_SRVR_NAME, "127.0.0.1");
		setInt(Prefs.VIEW_SRVR_PORT, 9025);
		setString(Prefs.VIEW_WS_PATH, "/app");
		setString(Prefs.VIEW_CLNT_APPL, "html/liveview.html");

		// spelling

		setBool(Prefs.SPELLING_ENABLED, true);

		// hides the corresponding EditorUI preference values
		setBool(SpellingService.PREFERENCE_SPELLING_ENABLED, true);
		setString(SpellingService.PREFERENCE_SPELLING_ENGINE, getDslCore().getSpellingEngineId());

		setString(PrefsSpelling.SPELLING_LOCALE, "en_US"); //$NON-NLS-1$
		String isInitializedKey = "spelling_locale_initialized"; //$NON-NLS-1$
		if (!getBool(isInitializedKey)) {
			setBool(isInitializedKey, true);
			Locale locale = SpellCheckEngine.getDefaultLocale();
			locale = SpellCheckEngine.findClosestLocale(locale);
			if (locale != null) setString(PrefsSpelling.SPELLING_LOCALE, locale.toString());
		}
		setBool(PrefsSpelling.SPELLING_IGNORE_DIGITS, true);
		setBool(PrefsSpelling.SPELLING_IGNORE_MIXED, true);
		setBool(PrefsSpelling.SPELLING_IGNORE_SENTENCE, true);
		setBool(PrefsSpelling.SPELLING_IGNORE_UPPER, true);
		setBool(PrefsSpelling.SPELLING_IGNORE_URLS, true);
		setBool(PrefsSpelling.SPELLING_IGNORE_SINGLE_LETTERS, true);
		setBool(PrefsSpelling.SPELLING_IGNORE_AMPERSAND_IN_PROPERTIES, true);
		setBool(PrefsSpelling.SPELLING_IGNORE_NON_LETTERS, true);
		setBool(PrefsSpelling.SPELLING_IGNORE_JAVA_STRINGS, false);
		setString(PrefsSpelling.SPELLING_USER_DICTIONARY, Strings.EMPTY);

		// For backwards compatibility we must use the property and not the workspace
		// default
		setString(PrefsSpelling.SPELLING_USER_DICTIONARY_ENCODING, System.getProperty("file.encoding")); //$NON-NLS-1$

		setInt(PrefsSpelling.SPELLING_PROPOSAL_THRESHOLD, 20);
		setInt(PrefsSpelling.SPELLING_PROBLEMS_THRESHOLD, 1000);

		// This is currently disabled because the spelling engine cannot return word
		// proposals but only correction proposals.
		boolean def = store.getDefaultBoolean(PrefsSpelling.SPELLING_ENABLE_CONTENTASSIST);
		setBool(PrefsSpelling.SPELLING_ENABLE_CONTENTASSIST, def);

		// folding

		setBool(Prefs.FOLDING_FRONTMATTER, true);
		setBool(Prefs.FOLDING_COMMENTS, true);
		setBool(Prefs.FOLDING_CODEBLOCKS, false);
		setBool(Prefs.FOLDING_HTMLBLOCKS, false);
		setBool(Prefs.FOLDING_DOTBLOCKS, false);
		setBool(Prefs.FOLDING_UMLBLOCKS, false);
		setBool(Prefs.FOLDING_MATHBLOCKS, false);
	}
}
