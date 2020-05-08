package net.certiv.fluent.dt.core.lang.dot.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.certiv.dsl.core.util.Strings;

public class AttrMap {

	public static class Props {
		public final DotAttr name;
		public final TYPE type;
		public final String[] values;
		public final String defval;

		public Props(DotAttr name, TYPE type, String[] values, String defval) {
			this.name = name;
			this.type = type;
			this.values = values;
			this.defval = defval;
		}
	}

	// attribute value types
	public enum TYPE {
		COLOR, // single color
		COLORS, // color or colorlist
		LIST,	// constrained to values, unquoted
		NUMBER,
		POINT,
		RECT,
		SPLINE,	// point or splineType
		STRING,	// quoted text

		INVALID;
	}

	private static final Map<DotAttr, Props> attrs = new HashMap<>();
	private static final Map<String, DotAttr> names = new HashMap<>();

	private static final String[] None = Strings.EMPTY_STRINGS;
	private static final String Empty = Strings.EMPTY;

	private static final String[] ArrowType = new String[] { "box", "crow", "curve", "icurve", "diamond", "dot", "odot",
			"ediamond", "empty", "inv", "invdot", "invodot", "invempty", "none", "normal", "open", "tee", "vee", "o",
			"l", "r" };
	private static final String[] Boolean = new String[] { "true", "false" };
	private static final String[] ClusterMode = new String[] { "local", "global", "none" };
	// private static final String[] ColorNames = DotColors.getColorNames();
	private static final String[] DirType = new String[] { "forward", "back", "both", "none" };
	private static final String[] OutputMode = new String[] { "breadthfirst", "nodesfirst", "edgesfirst" };
	private static final String[] PageDir = new String[] { "BL", "BR", "TL", "TR", "RB", "RT", "LB", "LT" };
	private static final String[] RankType = new String[] { "same", "min", "source", "max", "sink" };
	private static final String[] RankDir = new String[] { "TB", "LR", "BT", "RL" };
	private static final String[] Schemes = new String[] { "x11", "svg", "brewer" };
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
		put(DotAttr.INVALID, TYPE.INVALID, None, Empty);
		put(DotAttr.ARROWHEAD, TYPE.LIST, ArrowType, "normal");
		put(DotAttr.ARROWSIZE, TYPE.NUMBER, None, "1.0");
		put(DotAttr.ARROWTAIL, TYPE.LIST, ArrowType, "normal");
		put(DotAttr.BB, TYPE.RECT, None, Empty);
		put(DotAttr.BGCOLOR, TYPE.COLORS, None, Empty);
		put(DotAttr.CLUSTERRANK, TYPE.LIST, ClusterMode, Empty);
		put(DotAttr.COLOR, TYPE.COLORS, None, "black");
		put(DotAttr.COLORSCHEME, TYPE.LIST, Schemes, "x11");
		put(DotAttr.CONSTRAINT, TYPE.LIST, Boolean, "true");
		put(DotAttr.DIR, TYPE.LIST, DirType, "forward");
		put(DotAttr.DISTORTION, TYPE.NUMBER, None, "0.0");
		put(DotAttr.EDGETOOLTIP, TYPE.STRING, None, Empty);
		put(DotAttr.FILLCOLOR, TYPE.COLORS, None, "lightgrey");
		put(DotAttr.FIXEDSIZE, TYPE.STRING, None, "false");
		put(DotAttr.FONTCOLOR, TYPE.COLOR, None /* ColorNames */, "black");
		put(DotAttr.FONTSIZE, TYPE.NUMBER, None, "0.0");
		put(DotAttr.FORCELABELS, TYPE.LIST, Boolean, "true");
		put(DotAttr.HEAD_LP, TYPE.POINT, None, Empty);
		put(DotAttr.HEADLABEL, TYPE.STRING, None, Empty);
		put(DotAttr.HEADPORT, TYPE.STRING, None, "center");
		put(DotAttr.HEADTOOLTIP, TYPE.STRING, None, "");
		put(DotAttr.HEIGHT, TYPE.NUMBER, None, "0.5");
		put(DotAttr.ID, TYPE.STRING, None, Empty);
		put(DotAttr.LABEL, TYPE.STRING, None, Empty);
		put(DotAttr.LABELFONTCOLOR, TYPE.COLOR, None /* ColorNames */, "black");
		put(DotAttr.LABELTOOLTIP, TYPE.STRING, None, "");
		put(DotAttr.LAYOUT, TYPE.STRING, None, Empty);
		put(DotAttr.LP, TYPE.POINT, None, Empty);
		put(DotAttr.NODESEP, TYPE.NUMBER, None, "0.25");
		put(DotAttr.OUTPUTORDER, TYPE.LIST, OutputMode, "breadthfirst");
		put(DotAttr.PAGEDIR, TYPE.LIST, PageDir, "BL");
		put(DotAttr.POS, TYPE.SPLINE, None, Empty);
		put(DotAttr.RANK, TYPE.STRING, RankType, Empty);
		put(DotAttr.RANKDIR, TYPE.LIST, RankDir, Empty);
		put(DotAttr.SHAPE, TYPE.LIST, Shape, "ellipse");
		put(DotAttr.SIDES, TYPE.NUMBER, None, "4");
		put(DotAttr.SKEW, TYPE.NUMBER, None, "0.0");
		put(DotAttr.SPLINES, TYPE.STRING, None, Empty);
		put(DotAttr.STYLE, TYPE.LIST, Style, Empty);
		put(DotAttr.TAIL_LP, TYPE.POINT, None, Empty);
		put(DotAttr.TAILLABEL, TYPE.STRING, None, Empty);
		put(DotAttr.TAILPORT, TYPE.STRING, None, "center");
		put(DotAttr.TAILTOOLTIP, TYPE.STRING, None, Empty);
		put(DotAttr.TOOLTIP, TYPE.STRING, None, Empty);
		put(DotAttr.WIDTH, TYPE.NUMBER, None, "0.75");
		put(DotAttr.XLABEL, TYPE.STRING, None, Empty);
		put(DotAttr.XLP, TYPE.POINT, None, Empty);
	}

	private AttrMap() {}

	public static boolean in(String[] values, String value) {
		for (String v : values) {
			if (v.equals(value)) return true;
		}
		return false;
	}

	public static DotAttr find(String id) {
		DotAttr name = names.get(id);
		return name != null ? name : DotAttr.INVALID;
	}

	public static Set<String> getAttrNames() {
		return names.keySet();
	}

	public static Props get(String id) {
		try {
			return get(DotAttr.valueOf(id.toUpperCase()));
		} catch (Exception e) {
			return get(DotAttr.INVALID);
		}
	}

	public static Props get(DotAttr name) {
		return attrs.get(name);
	}

	public static TYPE getType(DotAttr name) {
		return attrs.get(name).type;
	}

	public static List<String> getValues(DotAttr name) {
		return Arrays.asList(attrs.get(name).values);
	}

	public static String getDefault(DotAttr name) {
		return attrs.get(name).defval;
	}

	private static void put(DotAttr name, TYPE type, String[] values, String defval) {
		attrs.put(name, new Props(name, type, values, defval));
		if (name != DotAttr.INVALID) names.put(name.toString(), name);
	}
}
