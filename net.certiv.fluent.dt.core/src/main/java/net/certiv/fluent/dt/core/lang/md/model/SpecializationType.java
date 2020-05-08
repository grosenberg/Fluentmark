package net.certiv.fluent.dt.core.lang.md.model;

import net.certiv.dsl.core.model.builder.ISpecializedType;
import net.certiv.dsl.core.util.Strings;

public enum SpecializationType implements ISpecializedType {

	Page("Page", "body"),

	Header("Header", "h"),
	Setext("Header", "h"),
	Paragraph("Paragraph", "p"),
	HRule("Horizontal Rule", "hr"),

	Bold("Bold", "b"),
	Italic("Italic", "i"),
	Underline("Underline", "u"),
	Strike("Strikethrough", "span.strikethrough"),

	Span("Span", "span"),
	CodeSpan("Code span", "code"),
	MathSpan("Math span", "span.math"),

	Link("Link", "a"),
	Cite("Link cite", "cite"),

	ListOrdered("Ordered list", "ol"),
	ListUnordered("Unordered list", "ul"),
	ListItem("List Item", "li"),

	Table("Table", "table"),
	TableRow("Table Row", "tr"),

	Quote("Quote", "q"),
	Definition("Definition", "dl"),

	CodeBlock("Code Block", "code"),
	CodeBlockIndented("Indented Block", "code"),

	YamlBlock("YAML Block", Strings.EMPTY),
	HtmlBlock("HTML Block", Strings.EMPTY),
	MathBlock("Math Block", Strings.EMPTY),
	TexBlock("LaTex Block", Strings.EMPTY),
	DotBlock("Dot Block", Strings.EMPTY),
	UmlBlock("UML Block", Strings.EMPTY),

	Comment("Comment", "comment"),

	Terminal("Blank Line", Strings.EMPTY),
	Unknown("Unknown", Strings.EMPTY),

	;

	public final String name;
	public final String css;

	SpecializationType(String name, String css) {
		this.name = name;
		this.css = css;
	}

	@Override
	public String getStyle() {
		return css;
	}

	@Override
	public String toString() {
		return name;
	}
}
