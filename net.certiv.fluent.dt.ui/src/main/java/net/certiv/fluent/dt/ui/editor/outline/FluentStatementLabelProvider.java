package net.certiv.fluent.dt.ui.editor.outline;

import static net.certiv.dsl.core.model.IDslElement.*;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import net.certiv.dsl.core.util.Strings;
import net.certiv.dsl.ui.editor.OutlineLabelDecorator;
import net.certiv.fluent.dt.core.model.ModelUtil;
import net.certiv.fluent.dt.ui.FluentUI;
import net.certiv.fluent.dt.ui.ImageManager;

public class FmOutlineLabelDecorator extends OutlineLabelDecorator {

	public FmOutlineLabelDecorator() {
		super(FluentUI.getDefault().getImageManager());
	}

	@Override
	public String decorateText(String text) {
		int dot = text.indexOf(Strings.PARA_MARK);
		if (dot > -1) {
			text = text.substring(0, dot);
		}
		return Strings.ellipsize(text, 32);
	}

	@Override
	public Image decorateImage(Image image) {
		ImageManager mgr = (ImageManager) imgMgr;

		ImageDescriptor desc = null;
		switch (getElementKind()) {
			case DSL_UNIT:
				desc = mgr.getDescriptor(mgr.IMG_OBJS_CONTAINER);
				break;

			case MODULE:
				desc = mgr.getDescriptor(mgr.IMG_OBJ_PAGE);
				break;

			case DECLARATION:
				desc = mgr.getDescriptor(mgr.IMG_OBJS_CORE);
				break;

			case STATEMENT:
			case FIELD:
				desc = mgr.getDescriptor(mgr.IMG_OBJS_STATEMENT);
				switch (ModelUtil.getModelType(getStatement())) {
					case MetaMatter:
						desc = mgr.getDescriptor(mgr.IMG_OBJ_FRONTMATTER);
						break;
					case Header:
						desc = mgr.getDescriptor(mgr.IMG_OBJ_HEADER);
						break;
					case Paragraph:
						desc = mgr.getDescriptor(mgr.IMG_OBJ_TEXT);
						break;
					case HRule:
						desc = mgr.getDescriptor(mgr.IMG_OBJ_HRULE);
						break;
					case List:
						desc = mgr.getDescriptor(mgr.IMG_OBJ_LIST);
						// if (addOverlay(data.decoration & ModelData.ORDERED)) {
						// desc = createOverlayImageDescriptor(desc,
						// provider.getDescriptor(provider.IMG_OVR_ORDERED),
						// TOP_RIGHT);
						// } else if (addOverlay(data.decoration & ModelData.UNORDERED)) {
						// desc = createOverlayImageDescriptor(desc,
						// provider.getDescriptor(provider.IMG_OVR_UNORDERED),
						// TOP_RIGHT);
						// }
						break;
					case ListItem:
						desc = mgr.getDescriptor(mgr.IMG_OBJ_LIST);
						break;
					case Table:
						desc = mgr.getDescriptor(mgr.IMG_OBJ_TABLE);
						break;
					case TableRow:
						desc = mgr.getDescriptor(mgr.IMG_OBJ_TABLE);
						break;
					case Quote:
						desc = mgr.getDescriptor(mgr.IMG_OBJ_QUOTE);
						break;
					case Definition:
						desc = mgr.getDescriptor(mgr.IMG_OBJ_DEFINITION);
						break;
					case HtmlBlock:
						desc = mgr.getDescriptor(mgr.IMG_OBJ_HTML);
						break;
					case CodeBlock:
						desc = mgr.getDescriptor(mgr.IMG_OBJ_CODEBLOCK);
						break;
					case MathBlock:
						desc = mgr.getDescriptor(mgr.IMG_OBJ_SUM);
						break;
					case DotGraph:
						desc = mgr.getDescriptor(mgr.IMG_OBJS_DECLARATION);
						break;
					case UmlGraph:
						desc = mgr.getDescriptor(mgr.IMG_OBJS_TYPEDEF);
						break;
					case Terminal:
						desc = mgr.getDescriptor(mgr.IMG_OBJS_BREAKPOINT);
						break;
					default:
						desc = mgr.getDescriptor(mgr.IMG_OBJS_UNKNOWN);
						break;
				}

				break;

			case BEG_BLOCK:
				desc = mgr.getDescriptor(mgr.IMG_OBJS_BLOCK);
				break;

			case END_BLOCK:
				break;

			default:
				desc = ImageDescriptor.getMissingImageDescriptor();
		}

		// // apply any overlay
		// ModelData data = (ModelData) getData();
		// if (data != null) {
		// if (hasOverlay(data.decoration & ModelData.COMBINED)) {
		// desc = createOverlayImageDescriptor(desc,
		// mgr.getDescriptor(mgr.IMG_OVR_COMBINED),
		// DslImageDescriptor.TOP_RIGHT);
		// }
		// }

		return mgr.get(desc);
	}
}
