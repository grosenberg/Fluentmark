package net.certiv.fluentmark.dot;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AttrMap {

	public static class Props {
		public final TYPE type;
		public final String[] values;
		public final String defval;

		public Props(TYPE type, String[] values, String defval) {
			this.type = type;
			this.values = values;
			this.defval = defval;
		}
	}

	public static enum TYPE {
		BOOL,	// unquoted true or false
		COLOR,	// single color
		COLORS, // color or colorlist
		NUMBER,
		POINT,
		RECT,
		SPLINE,	// point or splineType
		STRING;	// quoted text
	}

	private static final Map<Attr, Props> attrs = new HashMap<>();

	private static final String[] None = new String[] {};
	private static final String Empty = "";

	private static final String[] ArrowType = new String[] { "box", "crow", "curve", "icurve", "diamond", "dot", "odot",
			"ediamond", "empty", "inv", "invdot", "invodot", "invempty", "none", "normal", "open", "tee", "vee", "o",
			"l", "r" };
	private static final String[] Boolean = new String[] { "true", "false" };
	private static final String[] ClusterMode = new String[] { "local", "global", "none" };
	private static final String[] DirType = new String[] { "forward", "back", "both", "none" };
	private static final String[] OutputMode = new String[] { "breadthfirst", "nodesfirst", "edgesfirst" };
	private static final String[] PageDir = new String[] { "BL", "BR", "TL", "TR", "RB", "RT", "LB", "LT" };
	private static final String[] RankType = new String[] { "same", "min", "source", "max", "sink" };
	private static final String[] RankDir = new String[] { "TB", "LR", "BT", "RL" };
	private static final String[] Shape = new String[] { "assembly", "box", "box3d", "cds", "circle", "component",
			"cylinder", "diamond", "doublecircle", "doubleoctagon", "egg", "ellipse", "fivepoverhang", "folder",
			"hexagon", "house", "insulator", "invhouse", "invtrapezium", "invtriange", "larrow", "lpromoter", "Mcircle",
			"Mdiamond", "Mrecord", "Mhouse", "none", "note", "noverhang", "octagon", "oval", "parallelogram",
			"pentagon", "plain", "plaintext", "point", "polygon", "primersite", "promotor", "proteasite", "proteinstab",
			"rarrow", "record", "rect", "rectangle", "restrictionsite", "ribosite", "rnastab", "rpromoter", "septagon",
			"signature", "square", "star", "tab", "terminator", "threepoverhang", "trapezium", "triange",
			"tripleoctagon", "underline", "utr" };
	private static final String[] Style = new String[] { "bold", "dashed", "diagonals", "dotted", "filled", "invis",
			"radial", "rounded", "solid", "striped", "tapered", "wedged" };

	static {
		put(Attr.ARROWHEAD, TYPE.STRING, ArrowType, "normal");
		put(Attr.ARROWSIZE, TYPE.NUMBER, None, "1.0");
		put(Attr.ARROWTAIL, TYPE.STRING, ArrowType, "normal");
		put(Attr.BB, TYPE.RECT, None, Empty);
		put(Attr.BGCOLOR, TYPE.COLORS, None, Empty);
		put(Attr.CLUSTERRANK, TYPE.STRING, ClusterMode, Empty);
		put(Attr.COLOR, TYPE.COLORS, None, "black");
		put(Attr.COLORSCHEME, TYPE.STRING, None, Empty);
		put(Attr.DIR, TYPE.STRING, DirType, "forward");
		put(Attr.DISTORTION, TYPE.NUMBER, None, "0.0");
		put(Attr.EDGETOOLTIP, TYPE.STRING, None, Empty);
		put(Attr.FILLCOLOR, TYPE.COLORS, None, "lightgrey");
		put(Attr.FIXEDSIZE, TYPE.STRING, None, "false");
		put(Attr.FONTCOLOR, TYPE.COLOR, None, "black");
		put(Attr.FORCELABELS, TYPE.BOOL, Boolean, "true");
		put(Attr.HEAD_LP, TYPE.POINT, None, Empty);
		put(Attr.HEADLABEL, TYPE.STRING, None, Empty);
		put(Attr.HEADPORT, TYPE.STRING, None, "center");
		put(Attr.HEADTOOLTIP, TYPE.STRING, None, "");
		put(Attr.HEIGHT, TYPE.NUMBER, None, "0.5");
		put(Attr.ID, TYPE.STRING, None, Empty);
		put(Attr.LABEL, TYPE.STRING, None, Empty);
		put(Attr.LABELFONTCOLOR, TYPE.COLOR, None, "black");
		put(Attr.LABELTOOLTIP, TYPE.STRING, None, "");
		put(Attr.LAYOUT, TYPE.STRING, None, Empty);
		put(Attr.LP, TYPE.POINT, None, Empty);
		put(Attr.NODESEP, TYPE.NUMBER, None, "0.25");
		put(Attr.OUTPUTORDER, TYPE.STRING, OutputMode, "breadthfirst");
		put(Attr.PAGEDIR, TYPE.STRING, PageDir, "BL");
		put(Attr.POS, TYPE.SPLINE, None, Empty);
		put(Attr.RANK, TYPE.STRING, RankType, Empty);
		put(Attr.RANKDIR, TYPE.STRING, RankDir, Empty);
		put(Attr.SHAPE, TYPE.STRING, Shape, "ellipse");
		put(Attr.SIDES, TYPE.NUMBER, None, "4");
		put(Attr.SKEW, TYPE.NUMBER, None, "0.0");
		put(Attr.SPLINES, TYPE.STRING, None, Empty);
		put(Attr.STYLE, TYPE.STRING, Style, Empty);
		put(Attr.TAIL_LP, TYPE.POINT, None, Empty);
		put(Attr.TAILLABEL, TYPE.STRING, None, Empty);
		put(Attr.TAILPORT, TYPE.STRING, None, "center");
		put(Attr.TAILTOOLTIP, TYPE.STRING, None, Empty);
		put(Attr.TOOLTIP, TYPE.STRING, None, Empty);
		put(Attr.WIDTH, TYPE.NUMBER, None, "0.75");
		put(Attr.XLABEL, TYPE.STRING, None, Empty);
		put(Attr.XLP, TYPE.POINT, None, Empty);
	}

	private AttrMap() {}

	public static Props get(Attr name) {
		return attrs.get(name);
	}

	public static TYPE getType(Attr name) {
		return attrs.get(name).type;
	}

	public static List<String> getValues(Attr name) {
		return Arrays.asList(attrs.get(name).values);
	}

	public static String getDefault(Attr name) {
		return attrs.get(name).defval;
	}

	private static void put(Attr name, TYPE type, String[] values, String defval) {
		attrs.put(name, new Props(type, values, defval));
	}
}
