/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluent.dt.ui.editor.convert;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITypedRegion;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.parser.ParserEmulationProfile;
import com.vladsch.flexmark.util.data.MutableDataHolder;
import com.vladsch.flexmark.util.data.MutableDataSet;

import net.certiv.dsl.core.util.Strings;
import net.certiv.dsl.core.util.exec.Cmd;
import net.certiv.fluent.dt.core.FluentCore;
import net.certiv.fluent.dt.core.preferences.Prefs;
import net.certiv.fluent.dt.ui.editor.Partitions;

public class Converter {

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

	public String convert(String basepath, IDocument doc, ITypedRegion[] regions) {
		String text;
		switch (store.getString(Prefs.EDITOR_MD_CONVERTER)) {
			case Prefs.KEY_PANDOC:
				text = getText(doc, regions, true);
				return usePandoc(basepath, text);

			case Prefs.KEY_FLEXMARK:
				text = getText(doc, regions, true);
				return useFlexmark(basepath, text);

			case Prefs.KEY_BLACKFRIDAY:
				text = getText(doc, regions, false);
				return useBlackFriday(basepath, text);

			case Prefs.EDITOR_EXTERNAL_COMMAND:
				text = getText(doc, regions, true);
				return useExternal(basepath, text);
		}
		return Strings.EMPTY;
	}

	private String usePandoc(String basepath, String text) {
		String cmd = store.getString(Prefs.EDITOR_PANDOC_PROGRAM);
		if (cmd.trim().isEmpty()) return Strings.EMPTY;

		List<String> args = new ArrayList<>();
		args.add(cmd);
		args.add("--no-highlight"); // use highlightjs instead
		if (store.getBoolean(Prefs.EDITOR_PANDOC_ADDTOC)) args.add("--toc");
		if (store.getBoolean(Prefs.EDITOR_PANDOC_MATHJAX)) args.add("--mathjax");
		if (!store.getBoolean(Prefs.EDITOR_PANDOC_SMART)) {
			args.add("-f");
			args.add("markdown-smart");
		} else {
			args.add("--ascii");
		}
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
		if (cmd.trim().isEmpty()) return Strings.EMPTY;

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
		if (cmd.trim().isEmpty()) {
			return "Specify an external markdown converter command in preferences.";
		}

		String[] args = Cmd.parse(cmd);
		if (args.length > 0) {
			return Cmd.process(args, basepath, text);
		}
		return Strings.EMPTY;
	}

	private String getText(IDocument doc, ITypedRegion[] regions, boolean inclYaml) {
		List<String> parts = new ArrayList<>();
		for (ITypedRegion region : regions) {
			String text = null;
			try {
				text = doc.get(region.getOffset(), region.getLength());
			} catch (BadLocationException e) {
				continue;
			}
			switch (region.getType()) {
				case Partitions.YAMLBLOCK:
					if (!inclYaml) continue;
					break;
				case Partitions.DOTBLOCK:
					if (store.getBoolean(Prefs.EDITOR_DOTMODE_ENABLED)) {
						text = DotGen.runDot(text);
					}
					break;
				case Partitions.UMLBLOCK:
					if (store.getBoolean(Prefs.EDITOR_UMLMODE_ENABLED)) {
						text = UmlGen.uml2svg(text);
					}
					break;
				default:
					break;
			}
			parts.add(text);
		}
		return String.join(Strings.SPACE, parts);
	}
}
