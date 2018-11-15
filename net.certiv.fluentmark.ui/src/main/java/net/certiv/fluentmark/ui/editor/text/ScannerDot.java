/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.ui.editor.text;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.jface.text.rules.WordRule;

import net.certiv.dsl.core.preferences.IDslPrefsManager;
import net.certiv.dsl.ui.editor.scanners.AbstractBufferedRuleBasedScanner;
import net.certiv.fluentmark.core.preferences.Prefs;
import net.certiv.fluentmark.ui.editor.text.rules.DotSymbolDetector;
import net.certiv.fluentmark.ui.editor.text.rules.DotWordDetector;
import net.certiv.fluentmark.ui.editor.text.rules.WhitespaceDetector;

public class ScannerDot extends AbstractBufferedRuleBasedScanner implements IScannerExt {

	private String[] tokenProperties;

	private static final String[] keywords = { "strict", "graph", "digraph", "subgraph", "node", "edge", "fill",
			"compress", "auto", "out", "dot", "neato", "twopi", "fdp", "circo", "true", "false", "scale", "polyline",
			"line", "ortho", "90", "same", "min", "max", "lr", "rl", "bt", "kk", "circuit", "subset", "plaintext",
			"ellipse", "oval", "circle", "egg", "triangle", "box", "diamond", "trapezium", "parallelogram", "house",
			"hexagon", "octagon", "note", "tab", "box3d", "component", "filled", "solid", "dashed", "dotted", "bold",
			"invis", "forward", "back", "both", "none", };

	private static final String[] attribs = { "href", "URL", "fontcolor", "fontname", "fontsize", "label", "size",
			"ratio", "layout", "margin", "ordering", "rotate", "center", "color", "bgcolor", "overlap", "stylesheet",
			"splines", "nodesep", "ranksep", "rankdir", "rank", "mode", "model", "start", "epsilon", "root", "mindist",
			"k", "maxiter", "height", "width", "fixedsize", "shape", "fillcolor", "style", "xlabel", "target",
			"tooltip", "regular", "peripheries", "sides", "orientation", "outputorder", "distortion", "skew", "pin",
			"weight", "dir", "headclip", "tailclip", "arrowhead", "arrowsize", "arrowtail", "headlabel", "taillabel",
			"headtarget", "tailtarget", "headtooltip", "tailtooltip", "tailhref", "tailURL", "labelangle",
			"labeldistance", "decorate", "samehead", "sametail", "constraint", "minlen",

			"_background", "colorList", "charset", "clusterrank", "colorList", "colorscheme", "comment", "compound",
			"concentrate", "diredgeconstraints", "dpi", "edgeURL", "edgehref", "edgetarget", "edgetooltip", "esep",
			"fontpath", "forcelabels", "gradientangle", "group", "headport", "id", "image", "imagepath", "imagescale",
			"labelURL", "labelfloat", "labelfontcolor", "labelfontname", "labelfontsize", "labelhref", "labeljust",
			"labelloc", "labeltarget", "labeltooltip", "landscape", "layer", "layerlistsep", "layers", "layerselect",
			"layersep", "lhead", "ltail", "mclimit", "nojustify", "normalize", "nslimit", "nslimit1", "pack",
			"packmode", "pad", "point", "page", "point", "pagedir", "pencolor", "penwidth", "pos", "quadtree",
			"quantum", "rects", "remincross", "resolution", "samplepoints", "searchsize", "sep", "shapefile",
			"showboxes", "sortv", "string", "tail_lp", "vertices", "viewport", "z" };

	private static final String[] symbols = { "{", "}", "[", "]", "=", "->" };

	public ScannerDot(IDslPrefsManager store) {
		super(store);
		initialize();
	}

	@Override
	protected String[] getTokenProperties() {
		if (tokenProperties == null) {
			tokenProperties = new String[] { Prefs.EDITOR_DOT_KEYWORD_COLOR, Prefs.EDITOR_DOT_ATTRIBS_COLOR,
					Prefs.EDITOR_DOT_COMMENT_COLOR, Prefs.EDITOR_DOT_SYMBOL_COLOR, Prefs.EDITOR_DOT_STRING_COLOR,
					Prefs.EDITOR_DEFAULT_COLOR };
		}
		return tokenProperties;
	}

	@Override
	protected List<IRule> createRules() {
		IToken keywordToken = getToken(Prefs.EDITOR_DOT_KEYWORD_COLOR);
		IToken attribsToken = getToken(Prefs.EDITOR_DOT_ATTRIBS_COLOR);
		IToken symbolToken = getToken(Prefs.EDITOR_DOT_SYMBOL_COLOR);
		IToken stringToken = getToken(Prefs.EDITOR_DOT_STRING_COLOR);
		IToken commentToken = getToken(Prefs.EDITOR_DOT_COMMENT_COLOR);
		IToken defaultToken = getToken(Prefs.EDITOR_DEFAULT_COLOR);

		WordRule wordRule = new WordRule(new DotWordDetector(), defaultToken, true);
		for (String keyword : keywords) {
			wordRule.addWord(keyword, keywordToken);
		}

		WordRule attribRule = new WordRule(new DotWordDetector(), defaultToken, true);
		for (String attrib : attribs) {
			wordRule.addWord(attrib, attribsToken);
		}

		WordRule symbolRule = new WordRule(new DotSymbolDetector(), defaultToken, true);
		for (String symbol : symbols) {
			symbolRule.addWord(symbol, symbolToken);
		}

		List<IRule> rules = new ArrayList<>();
		rules.add(new MultiLineRule("/*", "*/", commentToken, '\\', true));
		rules.add(new SingleLineRule("//", null, commentToken, '\\', true));
		rules.add(new SingleLineRule("\"", "\"", stringToken, '\\', true));
		rules.add(wordRule);
		rules.add(attribRule);
		rules.add(symbolRule);
		rules.add(new WhitespaceRule(new WhitespaceDetector()));
		return rules;
	}

	@Override
	public IDocument getDocument() {
		return fDocument;
	}

	@Override
	public int getOffset() {
		return fOffset;
	}

	@Override
	public int getRangeEnd() {
		return fRangeEnd;
	}
}
