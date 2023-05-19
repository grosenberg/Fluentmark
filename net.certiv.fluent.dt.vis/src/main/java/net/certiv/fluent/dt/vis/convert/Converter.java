/*******************************************************************************
 * Copyright (c) 2016 - 2023 Certiv Analytics and others. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluent.dt.vis.convert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITypedRegion;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.parser.ParserEmulationProfile;
import com.vladsch.flexmark.util.data.MutableDataHolder;
import com.vladsch.flexmark.util.data.MutableDataSet;

import net.certiv.common.exec.Cmd;
import net.certiv.common.util.Strings;
import net.certiv.fluent.dt.core.FluentCore;
import net.certiv.fluent.dt.core.preferences.Prefs;
import net.certiv.fluent.dt.ui.editor.Partitions;

public class Converter {

	private static final String PANDOC_MISSING = "Pandoc executable not set in preferences.";
	private static final String BLACKFRIDAY_MISSING = "Black Friday executable not set in preferences.";
	private static final String EXTERNAL_MISSING = "External markdown converter command not set in preferences.";

	private static final Pattern LANG = Pattern.compile("[~`\\h]+(\\w+).*");

	private static final String DOT = "graphviz|dot";
	private static final String UML = "plantuml|uml";

	private static final String MARK = "<span id='scrollToId' />";
	private static final String MARK_LN = Strings.EOL + MARK + Strings.EOL + Strings.EOL;

	private IPreferenceStore store;

	public Converter() {
		super();
		store = FluentCore.getDefault().getPrefsManager();
	}

	public boolean useMathJax() {
		switch (store.getString(Prefs.EDITOR_MD_CONVERTER)) {
			case Prefs.KEY_PANDOC:
				return store.getBoolean(Prefs.EDITOR_PANDOC_MATHJAX);
			default:
				return false;
		}
	}

	public String convert(String basepath, IDocument doc, ITypedRegion[] regions, int linenum) {
		String text;
		switch (store.getString(Prefs.EDITOR_MD_CONVERTER)) {
			default:
			case Prefs.KEY_PANDOC:
				text = getText(doc, regions, true, linenum);
				return usePandoc(basepath, text);

			case Prefs.KEY_FLEXMARK:
				text = getText(doc, regions, true, linenum);
				return useFlexmark(basepath, text);

			case Prefs.KEY_BLACKFRIDAY:
				text = getText(doc, regions, false, linenum);
				return useBlackFriday(basepath, text);

			case Prefs.EDITOR_EXTERNAL_COMMAND:
				text = getText(doc, regions, true, linenum);
				return useExternal(basepath, text);
		}
	}

	private String usePandoc(String basepath, String text) {
		String cmd = store.getString(Prefs.EDITOR_PANDOC_PROGRAM);
		if (cmd.trim().isEmpty()) return PANDOC_MISSING;

		List<String> args = new ArrayList<>();
		args.add(cmd);
		args.add("--no-highlight"); // using highlightjs instead
		if (store.getBoolean(Prefs.EDITOR_PANDOC_ADDTOC)) args.add("--toc");
		if (store.getBoolean(Prefs.EDITOR_PANDOC_MATHJAX)) args.add("--mathjax");
		return Cmd.process(args.toArray(new String[args.size()]), basepath, text);
	}

	private String useFlexmark(String basepath, String text) {
		String value = store.getString(Prefs.EDITOR_FLEXMARK_PROFILE);
		ParserEmulationProfile profile = ParserEmulationProfile.valueOf(value);

		MutableDataHolder options = new MutableDataSet();
		options.setFrom(profile);
		Parser parser = Parser.builder(options).build();
		HtmlRenderer renderer = HtmlRenderer.builder(options).build();
		return renderer.render(parser.parse(text));
	}

	private String useBlackFriday(String basepath, String text) {
		String cmd = store.getString(Prefs.EDITOR_BLACKFRIDAY_PROGRAM);
		if (cmd.trim().isEmpty()) return BLACKFRIDAY_MISSING;

		List<String> args = new ArrayList<>();
		args.add(cmd);
		if (store.getBoolean(Prefs.EDITOR_BLACKFRIDAY_ADDTOC)) {
			args.add("-toc");
		}
		if (store.getBoolean(Prefs.EDITOR_BLACKFRIDAY_SMART)) {
			args.add("-smartypants");
			args.add("-fractions");
		}

		return Cmd.process(args.toArray(new String[args.size()]), basepath, text);
	}

	private String useExternal(String basepath, String text) {
		String cmd = store.getString(Prefs.EDITOR_EXTERNAL_COMMAND);
		if (cmd.trim().isEmpty()) return EXTERNAL_MISSING;

		String[] args = Cmd.parse(cmd);
		if (args.length > 0) {
			return Cmd.process(args, basepath, text);
		}
		return Strings.EMPTY;
	}

	private String getText(IDocument doc, ITypedRegion[] regions, boolean inclYaml, int linenum) {
		List<String> parts = new ArrayList<>();
		for (ITypedRegion region : regions) {
			switch (region.getType()) {
				case Partitions.YAMLBLOCK:
					if (inclYaml) {
						try {
							parts.add(getText(doc, region, linenum));
						} catch (BadLocationException e) {}
					}
					break;

				case Partitions.DOTBLOCK:
					try {
						if (containsLine(doc, region, linenum)) {
							parts.add(MARK_LN);
						}
						if (store.getBoolean(Prefs.EDITOR_DOTMODE_ENABLED)) {
							parts.add(DotGen.runDot(getText(doc, region)));
						} else {
							parts.add(getText(doc, region));
						}
					} catch (BadLocationException e) {}
					break;

				case Partitions.UMLBLOCK:
					try {
						if (containsLine(doc, region, linenum)) {
							parts.add(MARK_LN);
						}
						if (store.getBoolean(Prefs.EDITOR_UMLMODE_ENABLED)) {
							parts.add(UmlGen.uml2svg(getText(doc, region)));
						} else {
							parts.add(getText(doc, region));
						}
					} catch (BadLocationException e) {}
					break;

				case Partitions.CODEBLOCK:
					try {
						if (containsLine(doc, region, linenum)) {
							parts.add(MARK_LN);
						}

						if (!store.getBoolean(Prefs.EDITOR_CODEBLOCK_CONVERT_ENABLED)) {
							parts.add(getText(doc, region));

						} else {
							LinkedList<String> lines = new LinkedList<>(
									Arrays.asList(Strings.PAT_NL.split(getText(doc, region))));

							if (lines.size() >= 2) {
								String first = lines.pollFirst();
								lines.pollLast();

								String lang = extractLang(first);

								if (lang.matches(DOT)) {
									if (store.getBoolean(Prefs.EDITOR_DOTMODE_ENABLED)) {
										parts.add(DotGen.runDot(lines));
									} else {
										parts.add(getText(doc, region));
									}

								} else if (lang.matches(UML)) {
									if (store.getBoolean(Prefs.EDITOR_UMLMODE_ENABLED)) {
										parts.add(UmlGen.uml2svg(getText(doc, region)));
									} else {
										parts.add(getText(doc, region));
									}

								} else {
									parts.add(getText(doc, region));
								}
							}
						}
					} catch (BadLocationException e) {}
					break;

				case Partitions.HTMLBLOCK:
				case Partitions.MATHBLOCK:
					try {
						if (containsLine(doc, region, linenum)) {
							parts.add(MARK_LN);
						}
						parts.add(getText(doc, region));
					} catch (BadLocationException e) {}
					break;

				case Partitions.COMMENT:
				default:
					try {
						parts.add(getText(doc, region, linenum));
					} catch (BadLocationException e) {}
					break;
			}
		}
		return String.join(Strings.EMPTY, parts);
	}

	private String extractLang(String first) {
		Matcher m = LANG.matcher(first);
		if (!m.matches()) return Strings.EMPTY;
		return m.group(1).toLowerCase();
	}

	/** Returns the region text, unconditionally. */
	private String getText(IDocument doc, ITypedRegion region) throws BadLocationException {
		return doc.get(region.getOffset(), region.getLength());
	}

	/** Returns the region text, conditionally marked. */
	private String getText(IDocument doc, ITypedRegion region, int linenum) throws BadLocationException {
		if (!containsLine(doc, region, linenum)) return getText(doc, region);

		return markedText(doc, region, linenum);
	}

	private boolean containsLine(IDocument doc, ITypedRegion region, int linenum)
			throws BadLocationException {
		int at = doc.getLineOffset(linenum);
		return at >= region.getOffset() && at < region.getOffset() + region.getLength();
	}

	/**
	 * If line is blank, surround the mark with blank lines.
	 * <p>
	 * If line contains text, insert before first simple text.
	 * <p>
	 * If non-blank and no simple text, insert mark on previous line
	 * <p>
	 * If no previous line, insert nothing
	 */
	private String markedText(IDocument doc, ITypedRegion region, int linenum) throws BadLocationException {
		IRegion info = doc.getLineInformation(linenum);
		int at = doc.getLineOffset(linenum);
		String line = doc.get(info.getOffset(), info.getLength());

		if (line.isBlank()) {
			return doc.get(region.getOffset(), at - region.getOffset()) //
					+ MARK_LN //
					+ doc.get(at, region.getLength() - (at - region.getOffset()));
		}

		for (int cnt = 0; cnt < line.length(); cnt++) {
			int ch = line.codePointAt(cnt);
			if (Character.isLetterOrDigit(ch) || ch == '<') {
				at += cnt;
				return doc.get(region.getOffset(), at - region.getOffset()) //
						+ MARK //
						+ doc.get(at, region.getLength() - (at - region.getOffset()));
			}
		}

		if (linenum > 0) return markedText(doc, region, linenum - 1);
		return getText(doc, region);
	}
}
