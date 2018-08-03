/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.preferences;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Locale;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.texteditor.AbstractDecoratedTextEditorPreferenceConstants;
import org.eclipse.ui.texteditor.spelling.SpellingService;
import org.osgi.framework.Bundle;

import net.certiv.fluentmark.FluentUI;
import net.certiv.fluentmark.spell.SpellingEngine;
import net.certiv.spellchecker.SpellCheckEngine;

/**
 * Initialize default preference values
 */
public class PrefsInit extends AbstractPreferenceInitializer implements Prefs {

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
	public void initializeDefaultPreferences() {
		IPreferenceStore store = FluentUI.getDefault().getPreferenceStore();

		store.setDefault(EDITOR_TAB_WIDTH, 4);
		store.setDefault(EDITOR_TAB_CHAR, false); // always use spaces
		store.setDefault(EDITOR_FORMATTING_ENABLED, true);
		store.setDefault(EDITOR_FORMATTING_COLUMN, 80);
		store.setDefault(EDITOR_WORD_WRAP, false);
		store.setDefault(EDITOR_SHOW_SEGMENTS, false);

		store.setDefault(EDITOR_OUTLINE_SHOW_BLANKLINES, false);
		store.setDefault(EDITOR_OUTLINE_SYNC_ON_CURSOR_MOVE, true);

		store.setDefault(EDITOR_TASK_TAGS, true);
		store.setDefault(EDITOR_TASK_TAGS_DEFINED, "TODO,FIXME,NOTE");

		store.setDefault(EDITOR_MD_CONVERTER, KEY_TXTMARK);

		store.setDefault(EDITOR_UMLMODE_ENABLED, false);
		store.setDefault(EDITOR_DOTMODE_ENABLED, false);
		store.setDefault(EDITOR_DOT_PROGRAM, "");

		store.setDefault(EDITOR_TXTMARK_SAFEMODE, false);
		store.setDefault(EDITOR_TXTMARK_EXTENDED, true);

		store.setDefault(EDITOR_BLACKFRIDAY_ADDTOC, false);
		store.setDefault(EDITOR_BLACKFRIDAY_SMART, true);
		store.setDefault(EDITOR_BLACKFRIDAY_PROGRAM, "");

		store.setDefault(EDITOR_PANDOC_ADDTOC, false);
		store.setDefault(EDITOR_PANDOC_MATHJAX, false);
		store.setDefault(EDITOR_PANDOC_SMART, true);
		store.setDefault(EDITOR_PANDOC_PROGRAM, "");
		store.setDefault(EDITOR_PANDOC_TEMPLATES, "");
		store.setDefault(EDITOR_PANDOC_TEMPLATE, "");

		store.setDefault(EDITOR_EXTERNAL_COMMAND, "");
		store.setDefault(EDITOR_SECTION_NUMBERS, true);

		store.setDefault(EDITOR_CSS_BUILTIN, cssDefault());
		store.setDefault(EDITOR_CSS_EXTERNAL, "");
		store.setDefault(EDITOR_GITHUB_SYNTAX, true);
		store.setDefault(EDITOR_MULTIMARKDOWN_METADATA, true);

		store.setDefault(EDITOR_SMART_BACKSPACE, true);
		store.setDefault(EDITOR_SMART_OPENING_BRACE, false);
		store.setDefault(EDITOR_SMART_SEMICOLON, false);
		store.setDefault(EDITOR_FORMATTING_ENABLED, true);
		store.setDefault(EDITOR_FORMATTING_COLUMN, colDefault());

		store.setDefault(EDITOR_PDF_OPEN, true);

		// colors

		PreferenceConverter.setDefault(store, EDITOR_DEFAULT_COLOR, DEF_DEFAULT);

		PreferenceConverter.setDefault(store, EDITOR_FRONTMATTER_COLOR, DEF_COMMENT);
		PreferenceConverter.setDefault(store, EDITOR_COMMENT_VISIBLE_COLOR, DEF_COMMENT);
		PreferenceConverter.setDefault(store, EDITOR_COMMENT_HIDDEN_COLOR, DEF_COMMENT);

		PreferenceConverter.setDefault(store, EDITOR_HEADER_COLOR, DEF_HEADER);
		PreferenceConverter.setDefault(store, EDITOR_LIST_COLOR, DEF_DEFAULT);
		PreferenceConverter.setDefault(store, EDITOR_LINK_COLOR, DEF_LINK);
		PreferenceConverter.setDefault(store, EDITOR_HRULE_COLOR, DEF_LINK);
		PreferenceConverter.setDefault(store, EDITOR_BOLD_COLOR, DEF_DEFAULT);
		PreferenceConverter.setDefault(store, EDITOR_ITALIC_COLOR, DEF_DEFAULT);
		PreferenceConverter.setDefault(store, EDITOR_STRIKEOUT_COLOR, DEF_DEFAULT);

		PreferenceConverter.setDefault(store, EDITOR_HTML_KEYWORD_COLOR, DEF_KEYWORD);
		PreferenceConverter.setDefault(store, EDITOR_HTML_SYMBOL_COLOR, DEF_SYMBOL);
		PreferenceConverter.setDefault(store, EDITOR_HTML_STRING_COLOR, DEF_STRING);
		PreferenceConverter.setDefault(store, EDITOR_HTML_BG_COLOR, DEF_DEFAULT);

		PreferenceConverter.setDefault(store, EDITOR_CODE_COLOR, DEF_CODE);
		PreferenceConverter.setDefault(store, EDITOR_CODEBLOCK_COLOR, DEF_CODE);

		PreferenceConverter.setDefault(store, EDITOR_DOT_KEYWORD_COLOR, DEF_KEYWORD);
		PreferenceConverter.setDefault(store, EDITOR_DOT_ATTRIBS_COLOR, DEF_KEYWORD);
		PreferenceConverter.setDefault(store, EDITOR_DOT_SYMBOL_COLOR, DEF_SYMBOL);
		PreferenceConverter.setDefault(store, EDITOR_DOT_COMMENT_COLOR, DEF_COMMENT);
		PreferenceConverter.setDefault(store, EDITOR_DOT_STRING_COLOR, DEF_STRING);
		PreferenceConverter.setDefault(store, EDITOR_DOT_BG_COLOR, DEF_DEFAULT);

		PreferenceConverter.setDefault(store, EDITOR_UML_KEYWORD_COLOR, DEF_KEYWORD);
		PreferenceConverter.setDefault(store, EDITOR_UML_ATTRIBS_COLOR, DEF_KEYWORD);
		PreferenceConverter.setDefault(store, EDITOR_UML_SYMBOL_COLOR, DEF_SYMBOL);
		PreferenceConverter.setDefault(store, EDITOR_UML_COMMENT_COLOR, DEF_COMMENT);
		PreferenceConverter.setDefault(store, EDITOR_UML_STRING_COLOR, DEF_STRING);
		PreferenceConverter.setDefault(store, EDITOR_UML_BG_COLOR, DEF_DEFAULT);

		PreferenceConverter.setDefault(store, EDITOR_CODE_BG_COLOR, DEF_CODE_BG);
		PreferenceConverter.setDefault(store, EDITOR_CODEBLOCK_BG_COLOR, DEF_CODE_BG);

		PreferenceConverter.setDefault(store, EDITOR_MATH_KEYWORD_COLOR, DEF_KEYWORD);
		PreferenceConverter.setDefault(store, EDITOR_MATH_SYMBOL_COLOR, DEF_SYMBOL);
		PreferenceConverter.setDefault(store, EDITOR_MATH_COMMENT_COLOR, DEF_COMMENT);

		store.setDefault(VIEW_UPDATE_DELAY, 1000);

		// spelling

		store.setDefault(SPELLING_ENABLED, true);

		// hides the corresponding EditorUI preference values
		store.setDefault(SpellingService.PREFERENCE_SPELLING_ENABLED, true);
		store.setDefault(SpellingService.PREFERENCE_SPELLING_ENGINE, SpellingEngine.ID);

		store.setDefault(SPELLING_LOCALE, "en_US"); //$NON-NLS-1$
		String isInitializedKey = "spelling_locale_initialized"; //$NON-NLS-1$
		if (!store.getBoolean(isInitializedKey)) {
			store.setValue(isInitializedKey, true);
			Locale locale = SpellCheckEngine.getDefaultLocale();
			locale = SpellCheckEngine.findClosestLocale(locale);
			if (locale != null) store.setValue(SPELLING_LOCALE, locale.toString());
		}
		store.setDefault(SPELLING_IGNORE_DIGITS, true);
		store.setDefault(SPELLING_IGNORE_MIXED, true);
		store.setDefault(SPELLING_IGNORE_SENTENCE, true);
		store.setDefault(SPELLING_IGNORE_UPPER, true);
		store.setDefault(SPELLING_IGNORE_URLS, true);
		store.setDefault(SPELLING_IGNORE_SINGLE_LETTERS, true);
		store.setDefault(SPELLING_IGNORE_AMPERSAND_IN_PROPERTIES, true);
		store.setDefault(SPELLING_IGNORE_NON_LETTERS, true);
		store.setDefault(SPELLING_IGNORE_JAVA_STRINGS, false);
		store.setDefault(SPELLING_USER_DICTIONARY, ""); //$NON-NLS-1$

		// For backwards compatibility we must use the property and not the workspace default
		store.setDefault(SPELLING_USER_DICTIONARY_ENCODING, System.getProperty("file.encoding")); //$NON-NLS-1$

		store.setDefault(SPELLING_PROPOSAL_THRESHOLD, 20);
		store.setDefault(SPELLING_PROBLEMS_THRESHOLD, 1000);

		// This is currently disabled because the spelling engine cannot return word proposals but
		// only correction proposals.
		store.setToDefault(SPELLING_ENABLE_CONTENTASSIST);

		// folding

		store.setDefault(FOLDING_LINES_LIMIT, 2);

		store.setDefault(FOLDING_FRONTMATTER_ENABLED, true);
		store.setDefault(FOLDING_HIDDEN_COMMENTS_ENABLED, true);
		store.setDefault(FOLDING_CODEBLOCKS_ENABLED, true);
		store.setDefault(FOLDING_HTMLBLOCKS_ENABLED, true);

		store.setDefault(FOLDING_INITIAL_FRONT_MATTER, false);
		store.setDefault(FOLDING_INITIAL_HIDDEN_COMMENTS, false);
		store.setDefault(FOLDING_INITIAL_CODEBLOCKS, false);
		store.setDefault(FOLDING_INITIAL_HTMLBLOCKS, false);

		// code assist

		store.setDefault(CODEASSIST_AUTOACTIVATION, false);
		store.setDefault(CODEASSIST_AUTOACTIVATION_DELAY, 0);
		store.setDefault(CODEASSIST_AUTOINSERT, true);
		store.setDefault(CODEASSIST_AUTOACTIVATION_TRIGGERS_MD, "."); //$NON-NLS-1$
		store.setDefault(CODEASSIST_AUTOACTIVATION_TRIGGERS_DOT, "@#"); //$NON-NLS-1$
		store.setDefault(CODEASSIST_SHOW_VISIBLE_PROPOSALS, true);
		store.setDefault(CODEASSIST_CASE_SENSITIVITY, false);
		store.setDefault(CODEASSIST_INSERT_COMPLETION, true);
		store.setDefault(CODEASSIST_FILL_ARGUMENT_NAMES, true);
		store.setDefault(CODEASSIST_PREFIX_COMPLETION, false);

		PreferenceConverter.setDefault(store, CODEASSIST_PARAMETERS_BACKGROUND, new RGB(255, 255, 255));
		PreferenceConverter.setDefault(store, CODEASSIST_PARAMETERS_FOREGROUND, new RGB(0, 0, 0));
		PreferenceConverter.setDefault(store, CODEASSIST_REPLACEMENT_BACKGROUND, new RGB(255, 255, 0));
		PreferenceConverter.setDefault(store, CODEASSIST_REPLACEMENT_FOREGROUND, new RGB(255, 0, 0));

	}

	private int colDefault() {
		return EditorsUI.getPreferenceStore()
				.getInt(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_PRINT_MARGIN_COLUMN);
	}

	// create bundle cache URL for the default stylesheet
	private String cssDefault() {
		Bundle bundle = Platform.getBundle(FluentUI.PLUGIN_ID);
		URL url = FileLocator.find(bundle, new Path(CSS_RESOURCE_DIR + CSS_DEFAULT), null);
		try {
			url = FileLocator.toFileURL(url);
			return url.toURI().toString();
		} catch (IOException | URISyntaxException e) {}
		return CSS_DEFAULT; // really an error
	}
}
