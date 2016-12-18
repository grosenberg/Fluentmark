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
public class FluentMkImages {

	public static final IPath ICONS_PATH = new Path("$nl$/icons"); //$NON-NLS-1$

	private static FluentMkUI plugin;
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
	public static String DESC_OBJ_TEXT;
	public static String DESC_OBJ_UNDEFINED;

	// public static String IMG_OBJS_FOLDER = prefix + "fldr_obj.gif";
	// public static String IMG_OBJS_TEMPLATE = prefix + "template_obj.gif";
	// public static String IMG_OBJS_VARIABLE = prefix + "variable_obj.gif";
	// public static String IMG_OBJS_LOCAL_VARIABLE = prefix + "variable_local_obj.gif";

	// ****************************************************************************************

	public FluentMkImages(Bundle bundle, FluentMkUI plugin) {
		FluentMkImages.bundle = bundle;
		FluentMkImages.plugin = plugin;
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
		DESC_OBJ_TEXT = prefix + "text.png"; //$NON-NLS-1$
		DESC_OBJ_UNDEFINED = IMG_OBJS_UNKNOWN;

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
		create(OBJ, DESC_OBJ_TEXT);
		create(OBJ, DESC_OBJ_UNDEFINED);

		create(TOOL, IMG_MENU_EXPORT_HTML);

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
			Log.error("FluentMkImages: Bad icon url", e);
			return null;
		}
	}
}
