package net.certiv.fluentmark.model;

public enum Kind {
	PAGE("Page"),

	FRONT_MATTER("Front matter"),
	COMMENT("Comment"),
	CODE_BLOCK("Code block"),
	CODE_BLOCK_INDENTED("Code block"),
	HTML_BLOCK("Html block"),

	BLANK("Blank line"),
	TEXT("Text"),

	LIST("List"),
	TABLE("Table"),

	HEADER("Header"),
	HRULE("Horizontal Rule"),
	QUOTE("Quote"),
	DEFINITION("Definition"),
	REFERENCE("Link reference"),

	UNDEFINED("Undefined");

	private String displayName;

	private Kind(String name) {
		displayName = name;
	}

	public String toString() {
		return displayName;
	}
}
