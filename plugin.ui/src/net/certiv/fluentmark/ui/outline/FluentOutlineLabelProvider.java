/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.ui.outline;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import net.certiv.dsl.ui.editor.OutlineLabelDecorator;
import net.certiv.fluentmark.core.model.PagePart;
import net.certiv.fluentmark.ui.FluentImages;
import net.certiv.fluentmark.ui.FluentUI;

public class FluentOutlineLabelProvider extends OutlineLabelDecorator {

	public FluentOutlineLabelProvider() {
		super();
	}

	@Override
	public Image getImage(Object element) {
		if (element instanceof PagePart) {
			PagePart part = (PagePart) element;
			FluentImages provider = (FluentImages) FluentUI.getDefault().getImageProvider();
			ImageDescriptor desc = null;
			switch (part.getItem()) {
				case PAGE:
					desc = provider.DESC_OBJ_PAGE;
					break;
				case CODE_BLOCK:
					desc = provider.DESC_OBJ_CODEBLOCK;
					break;
				case CODE_BLOCK_INDENTED:
					desc = provider.DESC_OBJ_CODEBLOCK_INDENTED;
					break;
				case COMMENT:
					desc = provider.DESC_OBJ_COMMENT;
					break;
				case DEFINITION:
					desc = provider.DESC_OBJ_DEFINITION;
					break;
				case FRONT_MATTER:
					desc = provider.DESC_OBJ_FRONTMATTER;
					break;
				case HEADER:
					desc = provider.DESC_OBJ_HEADER;
					break;
				case HRULE:
					desc = provider.DESC_OBJ_HRULE;
					break;
				case HTML_BLOCK:
					desc = provider.DESC_OBJ_HTML;
					break;
				case LIST:
					desc = provider.DESC_OBJ_LIST;
					break;
				case MATH_BLOCK:
					desc = provider.DESC_OBJ_SUM;
					break;
				case QUOTE:
					desc = provider.DESC_OBJ_QUOTE;
					break;
				case REFERENCE:
					desc = provider.DESC_OBJ_REFERENCE;
					break;
				case TABLE:
					desc = provider.DESC_OBJ_TABLE;
					break;
				case TEXT:
					desc = provider.DESC_OBJ_TEXT;
					break;
				default:
					desc = provider.DESC_OBJ_UNDEFINED;
					break;
			}
			return findImage(desc);
		}
		return super.getImage(element);
	}

	@Override
	public String decorateText(String text) {
		return text;
	}

	@Override
	public Image decorateImage(Image image) {
		return image;
	}
}
