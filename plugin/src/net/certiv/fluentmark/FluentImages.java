/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Bundle;

/**
 * Bundle of all images used by the Markdown plugin.
 */
public class FluentImages {

	public static final IPath ICONS_PATH = new Path("$nl$/icons"); //$NON-NLS-1$

	private static FluentUI plugin;
	private static Bundle bundle;
	private static String prefix;
	private static int prefixLen;

	public static final String OBJ = "obj16/"; //$NON-NLS-1$
	public static final String TOOL = "etool16/"; //$NON-NLS-1$
	private static final String LCL = "lcl16/"; //$NON-NLS-1$
	// private static final String DLCL = "dlcl16/"; //$NON-NLS-1$
	// private static final String ELCL = "elcl16/"; //$NON-NLS-1$
	// private static final String OVR = "ovr16/"; //$NON-NLS-1$
	// private static final String VIEW = "view16/"; //$NON-NLS-1$
	// private static final String WIZ = "wizban/"; //$NON-NLS-1$

	// ****************************************************************************************
	// keys

	public static String IMG_MENU_COLLAPSE_ALL;
	public static String IMG_MENU_EXPAND_ALL;

	// public static String IMG_MENU_PROMOTE;
	// public static String IMG_MENU_DEOMOTE;
	// public static String IMG_MENU_DOWN;
	// public static String IMG_MENU_UP;

	public static String IMG_MENU_EXPORT_HTML;
	public static String IMG_MENU_REFRESH;
	public static String IMG_MENU_SYNC;
	public static String IMG_OBJS_UNKNOWN;

	public static String DESC_OBJ_PAGE;
	public static String DESC_OBJ_CODEBLOCK;
	public static String DESC_OBJ_CODEBLOCK_INDENTED;
	public static String DESC_OBJ_COMMENT;
	public static String DESC_OBJ_DEFINITION;
	public static String DESC_OBJ_FRONTMATTER;
	public static String DESC_OBJ_HEADER;
	public static String DESC_OBJ_HRULE;
	public static String DESC_OBJ_HTML;
	public static String DESC_OBJ_LIST;
	public static String DESC_OBJ_QUOTE;
	public static String DESC_OBJ_REFERENCE;
	public static String DESC_OBJ_SUM;
	public static String DESC_OBJ_TABLE;
	public static String DESC_OBJ_TEXT;
	public static String DESC_OBJ_UNDEFINED;

	public static String DESC_OBJ_LEFT;
	public static String DESC_OBJ_CENTER;
	public static String DESC_OBJ_RIGHT;
	public static String DESC_OBJ_COL_DEL;
	public static String DESC_OBJ_COL_INS_BEF;
	public static String DESC_OBJ_COL_INS_AFT;
	public static String DESC_OBJ_ROW_DEL;
	public static String DESC_OBJ_ROW_INS_ABV;
	public static String DESC_OBJ_ROW_INS_BLW;

	// public static String IMG_OBJS_FOLDER = prefix + "fldr_obj.gif";
	// public static String IMG_OBJS_TEMPLATE = prefix + "template_obj.gif";
	// public static String IMG_OBJS_VARIABLE = prefix + "variable_obj.gif";
	// public static String IMG_OBJS_LOCAL_VARIABLE = prefix + "variable_local_obj.gif";

	// ****************************************************************************************

	public FluentImages(Bundle bundle, FluentUI plugin) {
		FluentImages.bundle = bundle;
		FluentImages.plugin = plugin;
		init();
	}

	private void init() {
		prefix = bundle.getSymbolicName() + '.';
		prefixLen = prefix.length();

		IMG_MENU_COLLAPSE_ALL = prefix + "collapseall.gif"; //$NON-NLS-1$
		IMG_MENU_EXPAND_ALL = prefix + "expandall.gif"; //$NON-NLS-1$

		// IMG_MENU_PROMOTE = prefix + "item_promote.png"; //$NON-NLS-1$
		// IMG_MENU_DEOMOTE = prefix + "item_demote.png"; //$NON-NLS-1$
		// IMG_MENU_DOWN = prefix + "sec_down.gif"; //$NON-NLS-1$
		// IMG_MENU_UP = prefix + "sec_up.gif"; //$NON-NLS-1$

		IMG_MENU_EXPORT_HTML = prefix + "htmlexport.gif"; //$NON-NLS-1$
		IMG_MENU_REFRESH = prefix + "refresh.gif"; //$NON-NLS-1$
		IMG_MENU_SYNC = prefix + "sync.png"; //$NON-NLS-1$
		IMG_OBJS_UNKNOWN = prefix + "unknown_obj.gif"; //$NON-NLS-1$

		DESC_OBJ_PAGE = prefix + "page.png"; //$NON-NLS-1$
		DESC_OBJ_CODEBLOCK = prefix + "code.png"; //$NON-NLS-1$
		DESC_OBJ_CODEBLOCK_INDENTED = prefix + "code.png"; //$NON-NLS-1$
		DESC_OBJ_COMMENT = prefix + "comment.gif"; //$NON-NLS-1$
		DESC_OBJ_DEFINITION = prefix + "definition.gif"; //$NON-NLS-1$
		DESC_OBJ_FRONTMATTER = prefix + "codeblock.png"; //$NON-NLS-1$
		DESC_OBJ_HEADER = prefix + "header.png"; //$NON-NLS-1$
		DESC_OBJ_HRULE = prefix + "hr.png"; //$NON-NLS-1$
		DESC_OBJ_HTML = prefix + "html.png"; //$NON-NLS-1$
		DESC_OBJ_LIST = prefix + "list.png"; //$NON-NLS-1$
		DESC_OBJ_QUOTE = prefix + "quote.png"; //$NON-NLS-1$
		DESC_OBJ_REFERENCE = prefix + "url_link.gif"; //$NON-NLS-1$
		DESC_OBJ_SUM= prefix + "sum.png"; //$NON-NLS-1$
		DESC_OBJ_TABLE = prefix + "table.png"; //$NON-NLS-1$
		DESC_OBJ_TEXT = prefix + "text.png"; //$NON-NLS-1$
		DESC_OBJ_UNDEFINED = IMG_OBJS_UNKNOWN;

		DESC_OBJ_LEFT = prefix + "align_left.png"; //$NON-NLS-1$
		DESC_OBJ_CENTER = prefix + "align_center.png"; //$NON-NLS-1$
		DESC_OBJ_RIGHT = prefix + "align_right.png"; //$NON-NLS-1$
		DESC_OBJ_COL_DEL = prefix + "col_delete.gif"; //$NON-NLS-1$
		DESC_OBJ_COL_INS_BEF = prefix + "col_insert_before.gif"; //$NON-NLS-1$
		DESC_OBJ_COL_INS_AFT = prefix + "col_insert_after.gif"; //$NON-NLS-1$
		DESC_OBJ_ROW_DEL = prefix + "row_delete.gif"; //$NON-NLS-1$
		DESC_OBJ_ROW_INS_ABV = prefix + "row_insert_above.gif"; //$NON-NLS-1$
		DESC_OBJ_ROW_INS_BLW = prefix + "row_insert_below.gif"; //$NON-NLS-1$

		create(OBJ, IMG_MENU_COLLAPSE_ALL);
		create(OBJ, IMG_MENU_EXPAND_ALL);
		create(OBJ, IMG_MENU_REFRESH);
		create(OBJ, IMG_MENU_SYNC);
		create(OBJ, IMG_OBJS_UNKNOWN);

		// create(OBJ, IMG_MENU_PROMOTE);
		// create(OBJ, IMG_MENU_DEOMOTE);
		// create(OBJ, IMG_MENU_DOWN);
		// create(OBJ, IMG_MENU_UP);

		create(OBJ, DESC_OBJ_PAGE);
		create(OBJ, DESC_OBJ_CODEBLOCK);
		create(OBJ, DESC_OBJ_CODEBLOCK_INDENTED);
		create(OBJ, DESC_OBJ_COMMENT);
		create(OBJ, DESC_OBJ_DEFINITION);
		create(OBJ, DESC_OBJ_FRONTMATTER);
		create(OBJ, DESC_OBJ_HEADER);
		create(OBJ, DESC_OBJ_HRULE);
		create(OBJ, DESC_OBJ_HTML);
		create(OBJ, DESC_OBJ_LIST);
		create(OBJ, DESC_OBJ_QUOTE);
		create(OBJ, DESC_OBJ_REFERENCE);
		create(OBJ, DESC_OBJ_SUM);
		create(OBJ, DESC_OBJ_TABLE);
		create(OBJ, DESC_OBJ_TEXT);
		create(OBJ, DESC_OBJ_UNDEFINED);

		create(TOOL, IMG_MENU_EXPORT_HTML);

		create(OBJ, DESC_OBJ_LEFT);
		create(OBJ, DESC_OBJ_CENTER);
		create(OBJ, DESC_OBJ_RIGHT);
		create(OBJ, DESC_OBJ_COL_DEL);
		create(OBJ, DESC_OBJ_COL_INS_BEF);
		create(OBJ, DESC_OBJ_COL_INS_AFT);
		create(OBJ, DESC_OBJ_ROW_DEL);
		create(OBJ, DESC_OBJ_ROW_INS_ABV);
		create(OBJ, DESC_OBJ_ROW_INS_BLW);
	}

	/** Retrieve the existing managed image for the given key */
	public Image get(String key) {
		return plugin.getImageRegistry().get(key);
	}

	/** Retrieve the existing managed image descriptor for the given key */
	public ImageDescriptor getDescriptor(String key) {
		return plugin.getImageRegistry().getDescriptor(key);
	}

	/**
	 * Create, register, and return an image descriptor for the given prefix and named icon file in
	 * the default bundle. The path can contain variables like $NL$. If no image could be found, the
	 * 'missing image descriptor' is returned.
	 */
	public ImageDescriptor create(String prefix, String name) {
		ImageDescriptor result = createUnmanaged(prefix, name);
		plugin.getImageRegistry().put(name, result);
		return result;
	}

	/**
	 * Create, register, and return an image descriptor for the given prefix and named icon file in
	 * the given bundle. The path can contain variables like $NL$. If no image could be found, the
	 * 'missing image descriptor' is returned.
	 */
	public ImageDescriptor create(Bundle bundle, String prefix, String name) {
		ImageDescriptor result = createUnmanaged(bundle, prefix, name);
		plugin.getImageRegistry().put(name, result);
		return result;
	}

	/**
	 * Creates and returns an image descriptor for the given prefix and name in the default bundle.
	 * The path can contain variables like $NL$. If no image could be found, the 'missing image
	 * descriptor' is returned.
	 */
	public ImageDescriptor createUnmanaged(String prefix, String name) {
		URL url = makeIconFileURL(prefix, name.substring(prefixLen));
		return ImageDescriptor.createFromURL(url);
	}

	/**
	 * Creates and returns an image descriptor for the given prefix and name in the given bundle.
	 * The path can contain variables like $NL$. If no image could be found, the 'missing image
	 * descriptor' is returned.
	 */
	public ImageDescriptor createUnmanaged(Bundle bundle, String prefix, String name) {
		int prefixLen = bundle.getSymbolicName().length() + 1;
		URL url = makeIconFileURL(bundle, prefix, name.substring(prefixLen));
		return ImageDescriptor.createFromURL(url);
	}

	/**
	 * Sets all available image descriptors for the given action.
	 */
	public void setImageDescriptors(IAction action, String type, String relPath) {
		if (!relPath.startsWith(prefix)) relPath = prefix + relPath;
		if (type.equals(LCL)) {
			action.setDisabledImageDescriptor(create("d" + type, relPath)); //$NON-NLS-1$
			action.setHoverImageDescriptor(create("c" + type, relPath)); //$NON-NLS-1$
			action.setImageDescriptor(create("e" + type, relPath)); //$NON-NLS-1$
		} else {
			action.setImageDescriptor(create(type, relPath));
		}
	}

	private URL makeIconFileURL(String prefix, String name) {
		return makeIconFileURL(bundle, prefix, name);
	}

	private URL makeIconFileURL(Bundle bundle, String prefix, String name) {
		try {
			URL url = new URL(bundle.getEntry("/"), "icons/");
			return new URL(url, prefix + name);
		} catch (MalformedURLException e) {
			Log.error("FluentImages: Bad icon url", e);
			return null;
		}
	}
}
