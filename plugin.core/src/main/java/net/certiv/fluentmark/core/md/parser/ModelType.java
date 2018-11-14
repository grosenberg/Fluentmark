package net.certiv.fluentmark.core.md.parser;

public enum ModelType {
	Page("Page"),
	FrontMatter("Front Matter"),

	Header("Header"),
	Paragraph("Paragraph"),

	HRule("Horizontal Rule"),
	Comment("Commment"),

	List("List"),
	ListItem("List Item"),
	Table("Table"),
	TableRow("Table Row"),

	Quote("Quote"),
	Definition("Definition"),

	HtmlBlock("HTML Block"),
	CodeBlock("Code Block"),
	MathBlock("Math Block"),

	DotGraph("Dot Graph"),
	UmlGraph("UML Graph"),

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
