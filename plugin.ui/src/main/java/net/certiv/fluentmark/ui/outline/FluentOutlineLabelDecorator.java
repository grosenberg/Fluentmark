/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.ui.outline;

import static net.certiv.dsl.core.model.IDslElement.*;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import net.certiv.dsl.ui.editor.OutlineLabelDecorator;
import net.certiv.fluentmark.core.model.PageUtil;
import net.certiv.fluentmark.ui.FluentImages;
import net.certiv.fluentmark.ui.FluentUI;

public class FluentOutlineLabelDecorator extends OutlineLabelDecorator {

	public FluentOutlineLabelDecorator() {
		super();
	}

	@Override
	public String decorateText(String text) {
		return text;
	}

	@Override
	public Image decorateImage(Image image) {
		FluentImages provider = FluentUI.getDefault().getImageProvider();
		ImageDescriptor desc = null;

		switch (getElementKind()) {
			case DSL_CONTAINER:
			case DSL_UNIT:
				desc = provider.DESC_OBJS_CONTAINER;
				break;

			case MODULE:
				desc = provider.DESC_OBJ_PAGE;
				break;

			case DECLARATION:
				desc = provider.DESC_OBJS_CORE;
				break;

			case STATEMENT:
			case FIELD:
				desc = provider.DESC_OBJS_STATEMENT;
				switch (PageUtil.getModelType(getStatement())) {
					case FrontMatter:
						desc = provider.DESC_OBJ_FRONTMATTER;
						break;
					case Header:
						desc = provider.DESC_OBJ_HEADER;
						break;
					case Paragraph:
						desc = provider.DESC_OBJ_TEXT;
						break;
					case HRule:
						desc = provider.DESC_OBJ_HRULE;
						break;
					case List:
						desc = provider.DESC_OBJ_LIST;
						// if (addOverlay(data.decoration & ModelData.ORDERED)) {
						// desc = createOverlayImageDescriptor(desc, provider.DESC_OVR_ORDERED, TOP_RIGHT);
						// } else if (addOverlay(data.decoration & ModelData.UNORDERED)) {
						// desc = createOverlayImageDescriptor(desc, provider.DESC_OVR_UNORDERED, TOP_RIGHT);
						// }
						break;
					case ListItem:
						desc = provider.DESC_OBJ_LIST;
						break;
					case Table:
						desc = provider.DESC_OBJ_TABLE;
						break;
					case TableRow:
						desc = provider.DESC_OBJ_TABLE;
						break;
					case Quote:
						desc = provider.DESC_OBJ_QUOTE;
						break;
					case Definition:
						desc = provider.DESC_OBJ_DEFINITION;
						break;
					case HtmlBlock:
						desc = provider.DESC_OBJ_HTML;
						break;
					case CodeBlock:
						desc = provider.DESC_OBJ_CODEBLOCK;
						break;
					case MathBlock:
						desc = provider.DESC_OBJ_SUM;
						break;
					case DotGraph:
						desc = provider.DESC_OBJS_DECLARARION;
						break;
					case UmlGraph:
						desc = provider.DESC_OBJS_TYPEDEF;
						break;
					case Terminal:
						desc = provider.DESC_OBJS_BREAKPOINT;
						break;
					default:
						desc = provider.DESC_OBJS_UNKNOWN;
						break;
				}

				break;

			case BEG_BLOCK:
				desc = provider.DESC_OBJS_BLOCK;
				break;

			case END_BLOCK:
				break;

			default:
				desc = createMissingImageDescriptor(image);

		}
		return findImage(desc);
	}
}
