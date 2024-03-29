package net.certiv.fluent.dt.ui.editor.outline;

import org.antlr.v4.runtime.misc.Interval;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.swt.graphics.Image;

import net.certiv.common.log.Log;
import net.certiv.common.util.Chars;
import net.certiv.common.util.Strings;
import net.certiv.dsl.ui.editor.outline.OutlineLabelProvider;
import net.certiv.fluent.dt.core.lang.md.gen.MdParser.FnLinkContext;
import net.certiv.fluent.dt.core.lang.md.gen.MdParser.ImgLinkContext;
import net.certiv.fluent.dt.core.lang.md.gen.MdParser.LinkContext;
import net.certiv.fluent.dt.core.lang.md.gen.MdParser.PhraseContext;
import net.certiv.fluent.dt.core.lang.md.model.Specialization;
import net.certiv.fluent.dt.core.lang.md.model.SpecializedType;
import net.certiv.fluent.dt.core.model.SpecUtil;
import net.certiv.fluent.dt.ui.FluentUI;
import net.certiv.fluent.dt.ui.ImageManager;

public class FluentOutlineLabelProvider extends OutlineLabelProvider {

	public FluentOutlineLabelProvider() {
		super(FluentUI.getDefault().getImageManager());
	}

	@Override
	public String decorateText(String text) {

		switch (getStatementType()) {
			case MODULE:
				if (hasData()) {
					Specialization data = (Specialization) getData();
					return data.name;
				}
				return text;

			case DECLARATION:
				return text;

			case STATEMENT:
			case FIELD:
				if (!hasData()) return text;

				Specialization data = (Specialization) getData();
				String msg = Strings.EMPTY;
				switch ((SpecializedType) data.getSpecializedType()) {
					case Paragraph:
					case Phrase:
					case Setext:
						return summary(text);

					case Header:
						return summary(text).replace(Chars.HASH, Chars.SP).trim();

					case Table:
					case Definition:
					case Quote:
						return data.ruleName;

					case ListOrdered:
						return "Ordered List";
					case ListUnordered:
						return "Unordered List";

					case ListItem:
						return summary(text);

					case Link:
						LinkContext lc = (LinkContext) data.stmtNode;
						return textOf(lc.txt);

					case Image:
						ImgLinkContext ilc = (ImgLinkContext) data.stmtNode;
						return textOf(ilc.txt);

					case Footnote:
						FnLinkContext flc = (FnLinkContext) data.stmtNode;
						return textOf(flc.ref);

					case CodeBlock:
					case CodeBlockIndented:
						msg = summary(text);
						msg = msg.replace(msg.charAt(0), Chars.SP).trim();
						if (!msg.isEmpty()) {
							int dot = msg.indexOf(Strings.LBRACE);
							if (dot > -1) {
								msg = msg.substring(0, dot).trim();
							}
						}
						if (msg.isEmpty()) return data.getSpecializedType().toString();
						return String.format("%s %s", Strings.titleCase(msg.trim()),
								data.getSpecializedType());

					case Comment:
					case HRule:
					case DotBlock:
					case UmlBlock:
					case YamlBlock:
					case HtmlBlock:
					case TexBlock:
					case MathBlock:
						return data.getSpecializedType().toString();

					default:
						return data.name;
				}

			case BEG_BLOCK:
				return "group";

			case END_BLOCK:
				return null;

			default:
				return text + " [" + getStatementType() + "]";
		}
	}

	private String summary(String text) {
		String src = text;
		try {
			src = stmt.getSource().trim();
			int dot = src.indexOf(Strings.EOL);
			if (dot > -1) {
				src = src.substring(0, dot);
			}
		} catch (BadLocationException e) {
			Log.error(e.getMessage(), e);
		}
		return Strings.ellipsize(src, 32);
	}

	private String textOf(PhraseContext phrase) {
		if (phrase == null) return Strings.EMPTY;

		int beg = phrase.start.getStartIndex();
		int end = phrase.stop.getStopIndex();
		String txt = phrase.start.getInputStream().getText(Interval.of(beg, end));
		return Strings.ellipsize(txt, 32);
	}

	@Override
	public Image decorateImage(Image image) {
		ImageManager mgr = (ImageManager) imgMgr;

		ImageDescriptor desc = null;
		switch (getStatementType()) {
			case MODULE:
				desc = mgr.getDescriptor(mgr.IMG_OBJS_UNIT);
				break;

			case DECLARATION:
				desc = mgr.getDescriptor(mgr.IMG_OBJS_CORE);
				break;

			case STATEMENT:
			case FIELD:
				desc = mgr.getDescriptor(mgr.IMG_OBJS_STATEMENT);
				switch (SpecUtil.getSpecializedType(getStatement())) {
					case Header:
						desc = mgr.getDescriptor(mgr.IMG_OBJ_HEADER);
						break;
					case HRule:
						desc = mgr.getDescriptor(mgr.IMG_OBJ_HRULE);
						break;

					case Paragraph:
						desc = mgr.getDescriptor(mgr.IMG_OBJ_TEXT);
						break;

					case Phrase:
						desc = mgr.getDescriptor(mgr.IMG_OBJ_TEXT);
						break;

					case ListOrdered:
						desc = mgr.getDescriptor(mgr.IMG_OBJ_ORDERED_LIST);
						break;
					case ListUnordered:
						desc = mgr.getDescriptor(mgr.IMG_OBJ_UNORDERED_LIST);
						break;

					case ListItem:
						if (stmt.hasData()) {
							Specialization data = (Specialization) stmt.getData();
							if (data.getSpecializedType() == SpecializedType.ListUnordered) {
								desc = mgr.getDescriptor(mgr.IMG_OBJ_UNORDERED_ITEM);
							} else {
								desc = mgr.getDescriptor(mgr.IMG_OBJ_ORDERED_ITEM);
							}
						} else {
							desc = mgr.getDescriptor(mgr.IMG_OBJ_LIST_ITEM);
						}
						break;

					case Link:
					case Image:
					case Footnote:
						desc = mgr.getDescriptor(mgr.IMG_OBJ_LINK);
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

					case CodeBlock:
						desc = mgr.getDescriptor(mgr.IMG_OBJ_CODE);
						break;
					case CodeBlockIndented:
						desc = mgr.getDescriptor(mgr.IMG_OBJ_CODE_INDENTED);
						break;

					case HtmlBlock:
						desc = mgr.getDescriptor(mgr.IMG_OBJ_HTML);
						break;
					case YamlBlock:
						desc = mgr.getDescriptor(mgr.IMG_OBJ_YAMLBLOCK);
						break;
					case TexBlock:
						desc = mgr.getDescriptor(mgr.IMG_OBJ_TEXBLOCK);
						break;
					case MathBlock:
						desc = mgr.getDescriptor(mgr.IMG_OBJ_MATHBLOCK);
						break;
					case DotBlock:
						desc = mgr.getDescriptor(mgr.IMG_OBJ_DOTBLOCK);
						break;
					case UmlBlock:
						desc = mgr.getDescriptor(mgr.IMG_OBJ_UMLBLOCK);
						break;

					case Comment:
						desc = mgr.getDescriptor(mgr.IMG_OBJ_COMMENT);
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
