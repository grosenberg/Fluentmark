package net.certiv.fluent.dt.ui.editor.outline;

import static net.certiv.dsl.core.model.IDslElement.*;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.swt.graphics.Image;

import net.certiv.dsl.core.log.Log;
import net.certiv.dsl.core.util.Chars;
import net.certiv.dsl.core.util.Strings;
import net.certiv.dsl.ui.editor.StatementLabelProvider;
import net.certiv.fluent.dt.core.model.SpecData;
import net.certiv.fluent.dt.core.model.SpecUtil;
import net.certiv.fluent.dt.ui.FluentUI;
import net.certiv.fluent.dt.ui.ImageManager;

public class FluentStatementLabelProvider extends StatementLabelProvider {

	public FluentStatementLabelProvider() {
		super(FluentUI.getDefault().getImageManager());
	}

	@Override
	public String decorateText(String text) {
		switch (getElementKind()) {
			case MODULE:
				if (hasData()) {
					SpecData data = (SpecData) getData();
					return data.name;
				}
				return text;

			case DECLARATION:
				return text;

			case STATEMENT:
			case FIELD:
				if (!hasData()) return text;

				SpecData data = (SpecData) getData();
				String msg = Strings.EMPTY;
				switch (data.specType) {
					case Paragraph:
					case Setext:
						return summary(text);

					case Header:
						return summary(text).replace(Chars.HASH, Chars.SP).trim();

					case Table:
					case Definition:
					case Quote:
						return data.ruleName;

					case List:
					case ListItem:
						return summary(text);

					case CodeBlock:
						msg = summary(text);
						msg = msg.replace(msg.charAt(0), Chars.SP).trim();
						if (!msg.isEmpty()) {
							int dot = msg.indexOf(Strings.LBRACE);
							if (dot > -1) {
								msg = msg.substring(0, dot).trim();
							}
						}
						if (msg.isEmpty()) return data.specType.name;
						return String.format("%s %s", Strings.titleCase(msg.trim()), data.specType.name);

					case HRule:
					case DotBlock:
					case UmlBlock:
					case YamlBlock:
					case HtmlBlock:
					case TexBlock:
					case MathBlock:
					case CodeBlockIndented:
						return data.specType.name;

					default:
						return data.name;
				}

			case BEG_BLOCK:
				return "group";

			case END_BLOCK:
				return null;

			default:
				return text + " [" + getElementKind() + "]";
		}
	}

	private String summary(String text) {
		String src = text;
		try {
			src = element.getSource().trim();
			int dot = src.indexOf(Strings.EOL);
			if (dot > -1) {
				src = src.substring(0, dot);
			}
		} catch (BadLocationException e) {
			Log.error(this, e.getMessage(), e);
		}
		return Strings.ellipsize(src, 32);
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
				switch (SpecUtil.getSpecType(getStatement())) {
					case YamlBlock:
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
					case DotBlock:
						desc = mgr.getDescriptor(mgr.IMG_OBJS_DECLARATION);
						break;
					case UmlBlock:
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
