/*******************************************************************************
 * Copyright (c) 2000, 2008 QNX Software Systems and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Elazar Leibovich (IDF) - Code folding of compound statements (bug 174597)
 *******************************************************************************/
package net.certiv.fluentmark.editor.folding;

import org.eclipse.osgi.util.NLS;

public final class FoldingMessages extends NLS {

	private static final String BUNDLE_NAME = "net.certiv.fluentmark.editor.folding.FoldingMessages";//$NON-NLS-1$

	private FoldingMessages() {}

	public static String DefaultFoldingPreferenceBlock_title;
	public static String DefaultFoldingPreferenceBlock_methods;
	public static String DefaultFoldingPreferenceBlock_blocks;
	public static String DefaultFoldingPreferenceBlock_statements;
	public static String DefaultFoldingPreferenceBlock_comment_header;
	public static String DefaultFoldingPreferenceBlock_comment_doc;
	public static String DefaultFoldingPreferenceBlock_comment_blocks;
	public static String DefaultFoldingPreferenceBlock_comment_line;
	public static String DefaultFoldingPreferenceBlock_folding_enabled;
	public static String EmptyFoldingPreferenceBlock_caption;

	static {
		NLS.initializeMessages(BUNDLE_NAME, FoldingMessages.class);
	}
}
