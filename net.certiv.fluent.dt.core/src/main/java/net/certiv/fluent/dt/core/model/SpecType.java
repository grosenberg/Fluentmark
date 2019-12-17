package net.certiv.fluent.dt.core.model;

import net.certiv.dsl.core.model.builder.ISpecType;

public enum SpecType implements ISpecType {
	Page("Page", "*"),

	Header("Header", "h"),
	Setext("Header", "h"),
	Paragraph("Paragraph", "p"),
	HRule("Horizontal Rule", "hr"),

	Bold("Bold", "b"),
	Italic("Italic", "i"),
	Underline("Underline", "u"),

	Span("Span", "pre"),

	Link("Link", "u"),
	Cite("Link cite", "u"),

	List("List", "ul"),
	ListItem("List Item", "li"),
	Table("Table", "td"),
	TableRow("Table Row", "tr"),

	Quote("Quote", "q"),
	Definition("Definition", "dl"),

	YamlBlock("YAML Block", ""),
	HtmlBlock("HTML Block", ""),
	MathBlock("Math Block", ""),
	TexBlock("LaTex Block", ""),
	DotBlock("Dot Block", ""),
	UmlBlock("UML Block", ""),

	CodeBlock("Code Block", "code"),
	CodeBlockIndented("Code Block (indented)", "code"),

	Comment("Comment", "comment"),
	Terminal("Blank Line", ""),

	Unknown("Unknown", ""),

	;

	public final String name;
	public final String css;

	SpecType(String name, String css) {
		this.name = name;
		this.css = css;
	}

	@Override
	public String toString() {
		return name;
	}
}
