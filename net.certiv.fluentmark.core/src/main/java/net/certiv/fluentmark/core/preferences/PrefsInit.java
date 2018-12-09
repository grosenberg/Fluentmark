/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.core.preferences;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Locale;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.ui.texteditor.AbstractDecoratedTextEditorPreferenceConstants;
import org.eclipse.ui.texteditor.spelling.SpellingService;
import org.osgi.framework.Bundle;

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.core.log.Log;
import net.certiv.dsl.core.preferences.DslPrefsInit;
import net.certiv.fluentmark.core.FluentCore;
import net.certiv.spellchecker.SpellCheckEngine;

/** Initialize default preference values */
public class PrefsInit extends DslPrefsInit {

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

		setInt(Prefs.EDITOR_TAB_WIDTH, 4);
		setBool(Prefs.EDITOR_TAB_CHAR, false); // always use spaces
		setBool(Prefs.EDITOR_FORMATTING_ENABLED, true);
		setInt(Prefs.EDITOR_FORMATTING_COLUMN, 80);
		setBool(Prefs.EDITOR_WORD_WRAP, false);
		setBool(Prefs.EDITOR_SHOW_SEGMENTS, false);

		setBool(Prefs.EDITOR_OUTLINE_SHOW_BLANKLINES, false);
		setBool(Prefs.EDITOR_OUTLINE_SYNC_ON_CURSOR_MOVE, true);

		setBool(Prefs.EDITOR_CORRECTION_INDICATION, true);

		setBool(Prefs.EDITOR_TASK_TAGS, true);
		setString(Prefs.EDITOR_TASK_TAGS_DEFINED, "TODO,FIXME,NOTE");

		setString(Prefs.EDITOR_MD_CONVERTER, Prefs.KEY_PANDOC);

		setBool(Prefs.EDITOR_UMLMODE_ENABLED, false);
		setBool(Prefs.EDITOR_DOTMODE_ENABLED, false);
		setString(Prefs.EDITOR_DOT_PROGRAM, "");

		setBool(Prefs.EDITOR_TXTMARK_SAFEMODE, false);
		setBool(Prefs.EDITOR_TXTMARK_EXTENDED, true);

		setBool(Prefs.EDITOR_BLACKFRIDAY_ADDTOC, false);
		setBool(Prefs.EDITOR_BLACKFRIDAY_SMART, true);
		setString(Prefs.EDITOR_BLACKFRIDAY_PROGRAM, "");

		setBool(Prefs.EDITOR_PANDOC_ADDTOC, false);
		setBool(Prefs.EDITOR_PANDOC_MATHJAX, false);
		setBool(Prefs.EDITOR_PANDOC_SMART, true);
		setString(Prefs.EDITOR_PANDOC_PROGRAM, "");
		setString(Prefs.EDITOR_PANDOC_TEMPLATES, "");
		setString(Prefs.EDITOR_PANDOC_TEMPLATE, "");

		setString(Prefs.EDITOR_EXTERNAL_COMMAND, "");
		setBool(Prefs.EDITOR_SECTION_NUMBERS, true);

		setString(Prefs.EDITOR_CSS_BUILTIN, cssDefault());
		setString(Prefs.EDITOR_CSS_EXTERNAL, "");
		setBool(Prefs.EDITOR_GITHUB_SYNTAX, true);
		setBool(Prefs.EDITOR_MULTIMARKDOWN_METADATA, true);

		setBool(Prefs.EDITOR_SMART_BACKSPACE, true);
		setBool(Prefs.EDITOR_SMART_OPENING_BRACE, false);
		setBool(Prefs.EDITOR_SMART_SEMICOLON, false);
		setBool(Prefs.EDITOR_FORMATTING_ENABLED, true);
		setInt(Prefs.EDITOR_FORMATTING_COLUMN, colDefault());
		setBool(Prefs.EDITOR_FORMATTING_UNWRAP, false);

		setBool(Prefs.EDITOR_PDF_OPEN, true);

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

		setInt(Prefs.VIEW_UPDATE_DELAY, 1000);

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
		setString(PrefsSpelling.SPELLING_USER_DICTIONARY, ""); //$NON-NLS-1$

		// For backwards compatibility we must use the property and not the workspace default
		setString(PrefsSpelling.SPELLING_USER_DICTIONARY_ENCODING, System.getProperty("file.encoding")); //$NON-NLS-1$

		setInt(PrefsSpelling.SPELLING_PROPOSAL_THRESHOLD, 20);
		setInt(PrefsSpelling.SPELLING_PROBLEMS_THRESHOLD, 1000);

		// This is currently disabled because the spelling engine cannot return word proposals but
		// only correction proposals.
		boolean def = getPrefs().getDefaultBoolean(PrefsSpelling.SPELLING_ENABLE_CONTENTASSIST);
		setBool(PrefsSpelling.SPELLING_ENABLE_CONTENTASSIST, def);

		// folding

		setInt(Prefs.FOLDING_LINES_LIMIT, 2);

		setBool(Prefs.FOLDING_FRONTMATTER_ENABLED, true);
		setBool(Prefs.FOLDING_HIDDEN_COMMENTS_ENABLED, true);
		setBool(Prefs.FOLDING_CODEBLOCKS_ENABLED, true);
		setBool(Prefs.FOLDING_HTMLBLOCKS_ENABLED, true);

		setBool(Prefs.FOLDING_INITIAL_FRONT_MATTER, false);
		setBool(Prefs.FOLDING_INITIAL_HIDDEN_COMMENTS, false);
		setBool(Prefs.FOLDING_INITIAL_CODEBLOCKS, false);
		setBool(Prefs.FOLDING_INITIAL_HTMLBLOCKS, false);

		// code assist

		setBool(Prefs.CODEASSIST_AUTOACTIVATION, false);
		setInt(Prefs.CODEASSIST_AUTOACTIVATION_DELAY, 0);
		setBool(Prefs.CODEASSIST_AUTOINSERT, true);
		setString(Prefs.CODEASSIST_AUTOACTIVATION_TRIGGERS_MD, "."); //$NON-NLS-1$
		setString(Prefs.CODEASSIST_AUTOACTIVATION_TRIGGERS_DOT, "@#"); //$NON-NLS-1$
		setBool(Prefs.CODEASSIST_SHOW_VISIBLE_PROPOSALS, true);
		setBool(Prefs.CODEASSIST_CASE_SENSITIVITY, false);
		setBool(Prefs.CODEASSIST_INSERT_COMPLETION, true);
		setBool(Prefs.CODEASSIST_FILL_ARGUMENT_NAMES, true);
		setBool(Prefs.CODEASSIST_PREFIX_COMPLETION, false);

		setRGB(Prefs.CODEASSIST_PARAMETERS_BACKGROUND, new RGB(255, 255, 255));
		setRGB(Prefs.CODEASSIST_PARAMETERS_FOREGROUND, new RGB(0, 0, 0));
		setRGB(Prefs.CODEASSIST_REPLACEMENT_BACKGROUND, new RGB(255, 255, 0));
		setRGB(Prefs.CODEASSIST_REPLACEMENT_FOREGROUND, new RGB(255, 0, 0));

	}

	private int colDefault() {
		return getInt(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_PRINT_MARGIN_COLUMN);
	}

	// create bundle cache URL for the default stylesheet
	private String cssDefault() {
		Bundle bundle = Platform.getBundle(getDslCore().getPluginId());
		Path path = new Path(getString(Prefs.CSS_RESOURCE_DIR) + getString(Prefs.CSS_DEFAULT));
		URL url = FileLocator.find(bundle, path, null);
		try {
			url = FileLocator.toFileURL(url);
			return url.toURI().toString();
		} catch (IOException | URISyntaxException e) {
			Log.error(this, "Failed to access CSS cache at: " + path.toString());
			return "";
		}
	}
}
