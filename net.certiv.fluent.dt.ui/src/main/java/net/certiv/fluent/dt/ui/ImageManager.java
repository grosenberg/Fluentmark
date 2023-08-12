package net.certiv.fluent.dt.ui;

import org.eclipse.jface.resource.ImageRegistry;
import org.osgi.framework.Bundle;

import net.certiv.common.util.Chars;
import net.certiv.dsl.ui.DslImageManager;

/** Bundle of all images used by the Fluentmark plugin. */
public class ImageManager extends DslImageManager {

	private static final Bundle locBundle = FluentUI.getDefault().getBundle();
	private static final String locPrefix = locBundle.getSymbolicName() + Chars.DOT;

	public final String IMG_MENU_COLLAPSE_ALL = create(locBundle, OBJ, locPrefix + "collapseall.png"); //$NON-NLS-1$
	public final String IMG_MENU_EXPAND_ALL = create(locBundle, OBJ, locPrefix + "expandall.png"); //$NON-NLS-1$

	public final String IMG_MENU_EXPORT_HTML = create(locBundle, OBJ, locPrefix + "htmlexport.png"); //$NON-NLS-1$
	public final String IMG_MENU_REFRESH = create(locBundle, OBJ, locPrefix + "refresh.png"); //$NON-NLS-1$
	public final String IMG_MENU_SYNC = create(locBundle, OBJ, locPrefix + "sync.png"); //$NON-NLS-1$
	public final String IMG_OBJS_UNKNOWN = create(locBundle, OBJ, locPrefix + "unknown_obj.png"); //$NON-NLS-1$
	public final String IMG_OBJ_UNDEFINED = IMG_OBJS_UNKNOWN;

	public final String IMG_OBJ_PAGE = create(locBundle, OBJ, locPrefix + "page.png"); //$NON-NLS-1$
	public final String IMG_OBJ_COMMENT = create(locBundle, OBJ, locPrefix + "comment.png"); //$NON-NLS-1$
	public final String IMG_OBJ_DEFINITION = create(locBundle, OBJ, locPrefix + "definition.png"); //$NON-NLS-1$
	public final String IMG_OBJ_YAMLBLOCK = create(locBundle, OBJ, locPrefix + "codeblock.png"); //$NON-NLS-1$

	public final String IMG_OBJ_HEADER = create(locBundle, OBJ, locPrefix + "header.png"); //$NON-NLS-1$
	public final String IMG_OBJ_HRULE = create(locBundle, OBJ, locPrefix + "hrule.png"); //$NON-NLS-1$
	public final String IMG_OBJ_HTML = create(locBundle, OBJ, locPrefix + "html.png"); //$NON-NLS-1$

	public final String IMG_OBJ_CODE = create(locBundle, OBJ, locPrefix + "code.png"); //$NON-NLS-1$
	public final String IMG_OBJ_CODE_INDENTED = create(locBundle, OBJ, locPrefix + "code.png"); //$NON-NLS-1$

	public final String IMG_OBJ_DOTBLOCK = create(locBundle, OBJ, locPrefix + "graph.png"); //$NON-NLS-1$
	public final String IMG_OBJ_UMLBLOCK = create(locBundle, OBJ, locPrefix + "uml.png"); //$NON-NLS-1$
	public final String IMG_OBJ_MATHBLOCK = create(locBundle, OBJ, locPrefix + "function.png"); //$NON-NLS-1$
	public final String IMG_OBJ_TEXBLOCK = create(locBundle, OBJ, locPrefix + "tex.png"); //$NON-NLS-1$

	public final String IMG_OBJ_BOLD = create(locBundle, OBJ, locPrefix + "bold.png"); //$NON-NLS-1$
	public final String IMG_OBJ_ITALIC = create(locBundle, OBJ, locPrefix + "italic.png"); //$NON-NLS-1$
	public final String IMG_OBJ_STRIKE = create(locBundle, OBJ, locPrefix + "strike.png"); //$NON-NLS-1$
	public final String IMG_OBJ_UNDERLINE = create(locBundle, OBJ, locPrefix + "underline.png"); //$NON-NLS-1$
	public final String IMG_OBJ_LINK = create(locBundle, OBJ, locPrefix + "link_obj.png"); //$NON-NLS-1$

	public final String IMG_OBJ_LIST = create(locBundle, OBJ, locPrefix + "list.png"); //$NON-NLS-1$
	public final String IMG_OBJ_LIST_ITEM = create(locBundle, OBJ, locPrefix + "listItem.png"); //$NON-NLS-1$
	public final String IMG_OBJ_UNORDERED_LIST = create(locBundle, OBJ, locPrefix + "unorderList.png"); //$NON-NLS-1$
	public final String IMG_OBJ_UNORDERED_ITEM = create(locBundle, OBJ, locPrefix + "unorderItem.png"); //$NON-NLS-1$
	public final String IMG_OBJ_ORDERED_LIST = create(locBundle, OBJ, locPrefix + "orderList.png"); //$NON-NLS-1$
	public final String IMG_OBJ_ORDERED_ITEM = create(locBundle, OBJ, locPrefix + "orderItem.png"); //$NON-NLS-1$

	public final String IMG_OBJ_CODE_BLOCK = create(locBundle, OBJ, locPrefix + "codeblock.png"); //$NON-NLS-1$
	public final String IMG_OBJ_QUOTE = create(locBundle, OBJ, locPrefix + "quote.png"); //$NON-NLS-1$
	public final String IMG_OBJ_REFERENCE = create(locBundle, OBJ, locPrefix + "url_link.png"); //$NON-NLS-1$
	public final String IMG_OBJ_SUM = create(locBundle, OBJ, locPrefix + "sum.png"); //$NON-NLS-1$
	public final String IMG_OBJ_TABLE = create(locBundle, OBJ, locPrefix + "table.png"); //$NON-NLS-1$
	public final String IMG_OBJ_TEXT = create(locBundle, OBJ, locPrefix + "text.png"); //$NON-NLS-1$

	public final String IMG_OBJ_LEFT = create(locBundle, OBJ, locPrefix + "align_left.png"); //$NON-NLS-1$
	public final String IMG_OBJ_CENTER = create(locBundle, OBJ, locPrefix + "align_center.png"); //$NON-NLS-1$
	public final String IMG_OBJ_RIGHT = create(locBundle, OBJ, locPrefix + "align_right.png"); //$NON-NLS-1$
	public final String IMG_OBJ_COL_DEL = create(locBundle, OBJ, locPrefix + "col_delete.png"); //$NON-NLS-1$
	public final String IMG_OBJ_COL_INS_BEF = create(locBundle, OBJ, locPrefix + "col_insert_before.png"); //$NON-NLS-1$
	public final String IMG_OBJ_COL_INS_AFT = create(locBundle, OBJ, locPrefix + "col_insert_after.png"); //$NON-NLS-1$
	public final String IMG_OBJ_ROW_DEL = create(locBundle, OBJ, locPrefix + "row_delete.png"); //$NON-NLS-1$
	public final String IMG_OBJ_ROW_INS_ABV = create(locBundle, OBJ, locPrefix + "row_insert_above.png"); //$NON-NLS-1$
	public final String IMG_OBJ_ROW_INS_BLW = create(locBundle, OBJ, locPrefix + "row_insert_below.png"); //$NON-NLS-1$

	public final String IMG_OBJS_FIXABLE_PROBLEM = create(locBundle, OBJ,
			locPrefix + "quickfix_warning_obj.png"); //$NON-NLS-1$
	public final String IMG_OBJS_FIXABLE_ERROR = create(locBundle, OBJ, locPrefix + "quickfix_error_obj.png"); //$NON-NLS-1$

	protected ImageManager() {
		super();
		IMG_OBJS_UNIT = create(locBundle, OBJ, locPrefix + "fluentmark_doc.png"); //$NON-NLS-1$
	}

	@Override
	public ImageRegistry getRegistry() {
		return FluentUI.getDefault().getImageRegistry();
	}
}
