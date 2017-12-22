/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.outline.dnd;

import org.eclipse.osgi.util.NLS;

class Messages extends NLS {

	private static final String BUNDLE_NAME = "net.certiv.fluentmark.outline.dnd"; //$NON-NLS-1$

	public static String OutlineDropTargetListener_0;
	public static String OutlineDropTargetListener_1;
	public static String OutlineDropTargetListener_2;
	public static String OutlineDropTargetListener_3;

	private Messages() {}

	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}
}
