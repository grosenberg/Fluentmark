package net.certiv.fluent.dt.core.lang.md.model;

import net.certiv.common.util.Strings;
import net.certiv.dsl.core.model.builder.ISpecializedType;

public enum SpecializedType implements ISpecializedType {

	Page("Page", "body"),

	Header("Header", "h"),
	Setext("Header", "h"),
	HRule("Horizontal Rule", "hr"),

	Paragraph("Paragraph", "p"),
	Phrase("Phrase", ""),

	Bold("Bold", "b"),
	Italic("Italic", "i"),
	Underline("Underline", "u"),
	Strike("Strikethrough", "span.strikethrough"),

	Span("Span", "span"),
	CodeSpan("Code span", "code"),
	MathSpan("Math span", "span.math"),

	Link("Link", "a"),
	Image("Image", "img"),
	Footnote("Footnote", "a"),

	ListOrdered("Ordered list", "ol"),
	ListUnordered("Unordered list", "ul"),
	ListItem("List Item", "li"),

	Table("Table", "table"),
	TableRow("Table Row", "tr"),

	Quote("Quote", "q"),

	Cite("Link cite", "cite"),
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

	SpecializedType(String name, String css) {
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
