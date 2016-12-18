package net.certiv.fluentmark.model;

public interface Key {

	/** Bold marker */
	String BOLD_MARKER = "**";

	/** Emphasis marker */
	String EMPHASIS_MARKER = "*";

	/** Escape character */
	char ESCAPE_CHARACTER = '\\';

	/** Characters composing a grid border line */
	char[] GRID_TABLE_BORDERS_CHARACTERS = { '+', '-', '=' };

	/** Beginning and end of a grid border line */
	char GRID_TABLE_MARKER = '+';

	/** Beginning (and end) of a row line */
	char GRID_TABLE_ROW_MARKER = '|';

	/** In-line Literal marker */
	String LITERAL_MARKER = "`";

	/** List markers (with the trailing space) */
	String[] LIST_MARKERS = { "* ", "+ ", "- ", "#. " };

	/** Dot specific attributes */
	String[] DOT_ATTRS = { "_background", "arrowhead", "arrowsize", "arrowtail", "bgcolor", "colorList", "center",
			"charset", "clusterrank", "color", "colorList", "colorscheme", "comment", "compound", "concentrate",
			"constraint", "decorate", "dir", "diredgeconstraints", "distortion", "dpi", "edgeURL", "edgehref",
			"edgetarget", "edgetooltip", "esep", "fillcolor", "fixedsize", "fontcolor", "fontname", "fontpath",
			"fontsize", "forcelabels", "gradientangle", "group", "headclip", "headlabel", "headport", "height", "href",
			"id", "image", "imagepath", "imagescale", "label", "labelURL", "labelangle", "labeldistance", "labelfloat",
			"labelfontcolor", "labelfontname", "labelfontsize", "labelhref", "labeljust", "labelloc", "labeltarget",
			"labeltooltip", "landscape", "layer", "layerlistsep", "layers", "layerselect", "layersep", "layout",
			"lhead", "ltail", "margin", "maxiter", "mclimit", "minlen", "nodesep", "nojustify", "normalize", "nslimit",
			"nslimit1", "ordering", "orientation", "outputorder", "overlap", "pack", "packmode", "pad", "point", "page",
			"point", "pagedir", "pencolor", "penwidth", "peripheries", "pos", "quadtree", "quantum", "rank", "rankdir",
			"ranksep", "ratio", "rects", "regular", "remincross", "resolution", "root", "rotate", "samehead",
			"sametail", "samplepoints", "scale", "searchsize", "sep", "shape", "shapefile", "showboxes", "sides",
			"size", "skew", "sortv", "splines", "string", "style", "stylesheet", "tail_lp", "tailclip", "taillabel",
			"tailport", "tailtarget", "tailtooltip", "target", "tooltip", "vertices", "viewport", "weight", "width",
			"xlabel", "z" };
}
