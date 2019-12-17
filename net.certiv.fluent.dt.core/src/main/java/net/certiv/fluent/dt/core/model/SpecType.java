package net.certiv.fluent.dt.core.model;

public enum ModelType {
	Page("Page"),
	MetaMatter("Front Matter"),

	Header("Header"),
	Setext("Setext"),

	Paragraph("Paragraph"),

	HRule("Horizontal Rule"),

	List("List"),
	ListItem("List Item"),
	Table("Table"),
	TableRow("Table Row"),

	Quote("Quote"),
	Definition("Definition"),
	Reference("Link reference"),

	HtmlBlock("HTML Block"),
	MathBlock("Math Block"),
	TexBlock("LaTex Block"),

	CodeBlock("Code Block"),
	CodeBlockIndented("Indented Code Block"),
	DotGraph("Dot Graph"),
	UmlGraph("UML Graph"),

	Comment("Comment"),
	Terminal("Blank Line"),

	Unknown("Unknown"),

	;

	private String _displayName;

	ModelType(String displayName) {
		_displayName = displayName;
	}

	@Override
	public String toString() {
		return _displayName;
	}
}
