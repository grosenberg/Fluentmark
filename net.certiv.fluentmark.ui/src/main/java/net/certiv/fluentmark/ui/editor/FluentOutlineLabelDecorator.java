/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.ui.editor;

import static net.certiv.dsl.core.model.IDslElement.*;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import net.certiv.dsl.ui.editor.OutlineLabelDecorator;
import net.certiv.fluentmark.core.model.ModelUtil;
import net.certiv.fluentmark.ui.FluentImageManager;
import net.certiv.fluentmark.ui.FluentUI;

public class FluentOutlineLabelDecorator extends OutlineLabelDecorator {

	public FluentOutlineLabelDecorator() {
		super(FluentUI.getDefault().getImageManager());
	}

	@Override
	public String decorateText(String text) {
		return text;
	}

	@Override
	public Image decorateImage(Image image) {
		FluentImageManager provider = (FluentImageManager) imgMgr;
		ImageDescriptor desc = null;

		switch (getElementKind()) {
			case DSL_CONTAINER:
			case DSL_UNIT:
				desc = provider.getDescriptor(provider.IMG_OBJS_CONTAINER);
				break;

			case MODULE:
				desc = provider.getDescriptor(provider.IMG_OBJ_PAGE);
				break;

			case DECLARATION:
				desc = provider.getDescriptor(provider.IMG_OBJS_CORE);
				break;

			case STATEMENT:
			case FIELD:
				desc = provider.getDescriptor(provider.IMG_OBJS_STATEMENT);
				switch (ModelUtil.getModelType(getStatement())) {
					case FrontMatter:
						desc = provider.getDescriptor(provider.IMG_OBJ_FRONTMATTER);
						break;
					case Header:
						desc = provider.getDescriptor(provider.IMG_OBJ_HEADER);
						break;
					case Paragraph:
						desc = provider.getDescriptor(provider.IMG_OBJ_TEXT);
						break;
					case HRule:
						desc = provider.getDescriptor(provider.IMG_OBJ_HRULE);
						break;
					case List:
						desc = provider.getDescriptor(provider.IMG_OBJ_LIST);
						// if (addOverlay(data.decoration & ModelData.ORDERED)) {
						// desc = createOverlayImageDescriptor(desc, provider.getDescriptor(provider.IMG_OVR_ORDERED),
						// TOP_RIGHT);
						// } else if (addOverlay(data.decoration & ModelData.UNORDERED)) {
						// desc = createOverlayImageDescriptor(desc, provider.getDescriptor(provider.IMG_OVR_UNORDERED),
						// TOP_RIGHT);
						// }
						break;
					case ListItem:
						desc = provider.getDescriptor(provider.IMG_OBJ_LIST);
						break;
					case Table:
						desc = provider.getDescriptor(provider.IMG_OBJ_TABLE);
						break;
					case TableRow:
						desc = provider.getDescriptor(provider.IMG_OBJ_TABLE);
						break;
					case Quote:
						desc = provider.getDescriptor(provider.IMG_OBJ_QUOTE);
						break;
					case Definition:
						desc = provider.getDescriptor(provider.IMG_OBJ_DEFINITION);
						break;
					case HtmlBlock:
						desc = provider.getDescriptor(provider.IMG_OBJ_HTML);
						break;
					case CodeBlock:
						desc = provider.getDescriptor(provider.IMG_OBJ_CODEBLOCK);
						break;
					case MathBlock:
						desc = provider.getDescriptor(provider.IMG_OBJ_SUM);
						break;
					case DotGraph:
						desc = provider.getDescriptor(provider.IMG_OBJS_DECLARATION);
						break;
					case UmlGraph:
						desc = provider.getDescriptor(provider.IMG_OBJS_TYPEDEF);
						break;
					case Terminal:
						desc = provider.getDescriptor(provider.IMG_OBJS_BREAKPOINT);
						break;
					default:
						desc = provider.getDescriptor(provider.IMG_OBJS_UNKNOWN);
						break;
				}

				break;

			case BEG_BLOCK:
				desc = provider.getDescriptor(provider.IMG_OBJS_BLOCK);
				break;

			case END_BLOCK:
				break;

			default:
				desc = ImageDescriptor.getMissingImageDescriptor();

		}
		return provider.get(desc);
	}
}
