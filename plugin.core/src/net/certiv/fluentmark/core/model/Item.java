/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.core.model;

public enum Item {
	PAGE("Page"),

	FRONT_MATTER("Front matter"),
	COMMENT("Comment"),

	CODE_BLOCK("Code block"),
	CODE_BLOCK_INDENTED("Code block: indented"),

	HTML_BLOCK("Html block"),

	MATH_BLOCK("Math block"),
	MATH_BLOCK_INLINE("Inline math"),

	BLANK("Blank line"),
	TEXT("Text"),

	LIST("List"),
	TABLE("Table"),

	HEADER("Header"),
	SETEXT("Setext"),
	HRULE("Horizontal Rule"),
	QUOTE("Quote"),
	DEFINITION("Definition"),
	REFERENCE("Link reference"),

	UNDEFINED("Undefined"),

	;

	private String displayName;

	private Item(String name) {
		displayName = name;
	}

	@Override
	public String toString() {
		return displayName;
	}
}
