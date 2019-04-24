/*******************************************************************************
 * Copyright (c) 2016 - 2018 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluent.dt.ui.editor;

import org.eclipse.jface.text.IDocument;

public class Partitions {

	// unique partitioning type
	public final static String PARTITIONING = "__fluent_partitioning";

	// specialized partition content types
	public static final String FRONT_MATTER = "__frontmatter";
	public static final String COMMENT = "__comment";
	public static final String CODEBLOCK = "__codeblock";
	public static final String HTMLBLOCK = "__htmlblock";
	public static final String DOTBLOCK = "__dotblock";
	public static final String UMLBLOCK = "__umlblock";
	public static final String MATHBLOCK = "__mathblock";

	/** Partition type groups by similar treatment */
	public static final String[] SPECIAL_TYPES = new String[] { FRONT_MATTER, COMMENT, CODEBLOCK, HTMLBLOCK, DOTBLOCK,
			UMLBLOCK, MATHBLOCK };
	public static final String[] STRING_AND_COMMENT_TYPES = new String[] { COMMENT };
	public static final String[] COMMENT_TYPES = new String[] { COMMENT };
	public static final String[] STRING_TYPES = new String[] {};

	private Partitions() {}

	public static String[] getContentTypes() {
		return getContentTypes(null);
	}

	public static String[] getCommentContentTypes() {
		return COMMENT_TYPES;
	}

	public static String[] getStringContentTypes() {
		return STRING_TYPES;
	}

	public static String[] getAllContentTypes() {
		return getContentTypes(IDocument.DEFAULT_CONTENT_TYPE);
	}

	public static String[] getContentTypes(String type) {
		if (type != null) {
			String[] dest = new String[SPECIAL_TYPES.length + 1];
			dest[0] = type;
			System.arraycopy(SPECIAL_TYPES, 0, dest, 1, SPECIAL_TYPES.length);
			return dest;
		}
		return SPECIAL_TYPES;
	}
}
