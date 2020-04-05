package net.certiv.fluent.dt.core.lang.eqn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AttrMap {

	public static class Props {
		public final EqnAttr name;
		public final TYPE type;
		public final String[] values;
		public final String defval;

		public Props(EqnAttr name, TYPE type, String[] values, String defval) {
			this.name = name;
			this.type = type;
			this.values = values;
			this.defval = defval;
		}
	}

	// attribute value types
	public static enum TYPE {
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

	private static final Map<EqnAttr, Props> attrs = new HashMap<>();
	private static final Map<String, EqnAttr> names = new HashMap<>();

	private static final String[] None = new String[] {};
	private static final String Empty = "";

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
		put(EqnAttr.INVALID, TYPE.INVALID, None, Empty);
		put(EqnAttr.ARROWHEAD, TYPE.LIST, ArrowType, "normal");
		put(EqnAttr.ARROWSIZE, TYPE.NUMBER, None, "1.0");
		put(EqnAttr.ARROWTAIL, TYPE.LIST, ArrowType, "normal");
		put(EqnAttr.BB, TYPE.RECT, None, Empty);
		put(EqnAttr.BGCOLOR, TYPE.COLORS, None, Empty);
		put(EqnAttr.CLUSTERRANK, TYPE.LIST, ClusterMode, Empty);
		put(EqnAttr.COLOR, TYPE.COLORS, None, "black");
		put(EqnAttr.COLORSCHEME, TYPE.LIST, Schemes, "x11");
		put(EqnAttr.CONSTRAINT, TYPE.LIST, Boolean, "true");
		put(EqnAttr.DIR, TYPE.LIST, DirType, "forward");
		put(EqnAttr.DISTORTION, TYPE.NUMBER, None, "0.0");
		put(EqnAttr.EDGETOOLTIP, TYPE.STRING, None, Empty);
		put(EqnAttr.FILLCOLOR, TYPE.COLORS, None, "lightgrey");
		put(EqnAttr.FIXEDSIZE, TYPE.STRING, None, "false");
		put(EqnAttr.FONTCOLOR, TYPE.COLOR, None /* ColorNames */, "black");
		put(EqnAttr.FORCELABELS, TYPE.LIST, Boolean, "true");
		put(EqnAttr.HEAD_LP, TYPE.POINT, None, Empty);
		put(EqnAttr.HEADLABEL, TYPE.STRING, None, Empty);
		put(EqnAttr.HEADPORT, TYPE.STRING, None, "center");
		put(EqnAttr.HEADTOOLTIP, TYPE.STRING, None, "");
		put(EqnAttr.HEIGHT, TYPE.NUMBER, None, "0.5");
		put(EqnAttr.ID, TYPE.STRING, None, Empty);
		put(EqnAttr.LABEL, TYPE.STRING, None, Empty);
		put(EqnAttr.LABELFONTCOLOR, TYPE.COLOR, None /* ColorNames */, "black");
		put(EqnAttr.LABELTOOLTIP, TYPE.STRING, None, "");
		put(EqnAttr.LAYOUT, TYPE.STRING, None, Empty);
		put(EqnAttr.LP, TYPE.POINT, None, Empty);
		put(EqnAttr.NODESEP, TYPE.NUMBER, None, "0.25");
		put(EqnAttr.OUTPUTORDER, TYPE.LIST, OutputMode, "breadthfirst");
		put(EqnAttr.PAGEDIR, TYPE.LIST, PageDir, "BL");
		put(EqnAttr.POS, TYPE.SPLINE, None, Empty);
		put(EqnAttr.RANK, TYPE.STRING, RankType, Empty);
		put(EqnAttr.RANKDIR, TYPE.LIST, RankDir, Empty);
		put(EqnAttr.SHAPE, TYPE.LIST, Shape, "ellipse");
		put(EqnAttr.SIDES, TYPE.NUMBER, None, "4");
		put(EqnAttr.SKEW, TYPE.NUMBER, None, "0.0");
		put(EqnAttr.SPLINES, TYPE.STRING, None, Empty);
		put(EqnAttr.STYLE, TYPE.LIST, Style, Empty);
		put(EqnAttr.TAIL_LP, TYPE.POINT, None, Empty);
		put(EqnAttr.TAILLABEL, TYPE.STRING, None, Empty);
		put(EqnAttr.TAILPORT, TYPE.STRING, None, "center");
		put(EqnAttr.TAILTOOLTIP, TYPE.STRING, None, Empty);
		put(EqnAttr.TOOLTIP, TYPE.STRING, None, Empty);
		put(EqnAttr.WIDTH, TYPE.NUMBER, None, "0.75");
		put(EqnAttr.XLABEL, TYPE.STRING, None, Empty);
		put(EqnAttr.XLP, TYPE.POINT, None, Empty);
	}

	private AttrMap() {}

	public static boolean in(String[] values, String value) {
		for (String v : values) {
			if (v.equals(value)) return true;
		}
		return false;
	}

	public static EqnAttr find(String id) {
		EqnAttr name = names.get(id);
		return name != null ? name : EqnAttr.INVALID;
	}

	public static Set<String> getAttrNames() {
		return names.keySet();
	}

	public static Props get(String id) {
		try {
			return get(EqnAttr.valueOf(id.toUpperCase()));
		} catch (Exception e) {
			return get(EqnAttr.INVALID);
		}
	}

	public static Props get(EqnAttr name) {
		return attrs.get(name);
	}

	public static TYPE getType(EqnAttr name) {
		return attrs.get(name).type;
	}

	public static List<String> getValues(EqnAttr name) {
		return Arrays.asList(attrs.get(name).values);
	}

	public static String getDefault(EqnAttr name) {
		return attrs.get(name).defval;
	}

	private static void put(EqnAttr name, TYPE type, String[] values, String defval) {
		attrs.put(name, new Props(name, type, values, defval));
		if (name != EqnAttr.INVALID) names.put(name.toString(), name);
	}
}
