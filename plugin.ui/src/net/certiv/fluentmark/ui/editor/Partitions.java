/*******************************************************************************
 * Copyright (c) 2016 - 2018 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.ui.editor;

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
	public static final String[] LEGAL_TYPES = new String[] { COMMENT, CODEBLOCK, HTMLBLOCK, DOTBLOCK, UMLBLOCK,
			MATHBLOCK, FRONT_MATTER };

	private Partitions() {}

	public static String[] getLegalContentTypes() {
		return LEGAL_TYPES;
	}

	public static String[] getAllContentTypes() {
		String[] dest = new String[LEGAL_TYPES.length + 1];
		dest[0] = IDocument.DEFAULT_CONTENT_TYPE;
		System.arraycopy(LEGAL_TYPES, 0, dest, 1, LEGAL_TYPES.length);
		return dest;
	}
}
