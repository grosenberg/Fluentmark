/*******************************************************************************
 * Copyright (c) 2016 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.model;

public interface Key {

	/** Bold marker */
	String BOLD_MARKER = "**";

	/** Emphasis marker */
	String EMPHASIS_MARKER = "*";

	/** Escape character */
	char ESCAPE_CHARACTER = '\\';

	/** Characters composing a grid border line */
	char[] GRID_TABLE_BORDERS_CHARACTERS = { '+', '-', '=' };

	/** Beginning and end of a grid border line */
	char GRID_TABLE_MARKER = '+';

	/** Beginning (and end) of a row line */
	char GRID_TABLE_ROW_MARKER = '|';

	/** In-line Literal marker */
	String LITERAL_MARKER = "`";

	/** List markers (with the trailing space) */
	String[] LIST_MARKERS = { "* ", "+ ", "- ", "#. " };
}
