package net.certiv.fluent.dt.core.lang.eqn;

public enum EqnAttr {
	ARROWHEAD("arrowhead"),
	ARROWSIZE("arrowsize"),
	ARROWTAIL("arrowtail"),
	BB("bb"),
	BGCOLOR("bgcolor"),
	CLUSTERRANK("clusterrank"),
	COLOR("color"),
	COLORSCHEME("colorscheme"),
	CONSTRAINT("constraint"),
	DIR("dir"),
	DISTORTION("distortion"),
	EDGETOOLTIP("edgetooltip"),
	FILLCOLOR("fillcolor"),
	FIXEDSIZE("fixedsize"),
	FONTCOLOR("fontcolor"),
	FORCELABELS("forcelabels"),
	HEAD_LP("head_lp"),
	HEADLABEL("headlabel"),
	HEADPORT("headport"),
	HEADTOOLTIP("headtooltip"),
	HEIGHT("height"),
	ID("id"),
	LABEL("label"),
	LABELFONTCOLOR("labelfontcolor"),
	LABELTOOLTIP("labeltooltip"),
	LAYOUT("layout"),
	LP("lp"),
	NODESEP("nodesep"),
	OUTPUTORDER("outputorder"),
	PAGEDIR("pagedir"),
	POS("pos"),
	RANK("rank"),
	RANKDIR("rankdir"),
	SHAPE("shape"),
	SIDES("sides"),
	SKEW("skew"),
	SPLINES("splines"),
	STYLE("style"),
	TAIL_LP("tail_lp"),
	TAILLABEL("taillabel"),
	TAILPORT("tailport"),
	TAILTOOLTIP("tailtooltip"),
	TOOLTIP("tooltip"),
	WIDTH("width"),
	XLABEL("xlabel"),
	XLP("xlp"),

	INVALID("Invalid")

	;

	private String _attribute;

	private EqnAttr(String attribute) {
		_attribute = attribute;
	}

	@Override
	public String toString() {
		return _attribute;
	}
}
