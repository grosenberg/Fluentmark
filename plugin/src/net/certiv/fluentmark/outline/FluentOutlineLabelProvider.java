/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.outline;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;

import net.certiv.fluentmark.FluentUI;
import net.certiv.fluentmark.FluentImages;
import net.certiv.fluentmark.model.PagePart;

public class FluentOutlineLabelProvider extends LabelProvider implements IStyledLabelProvider {

	private class Pair {

		Image img;
		ImageDescriptor desc;
	}

	private Map<String, Pair> iMap = new HashMap<>();

	public FluentOutlineLabelProvider() {
		super();
	}

	// see PagePart#toString
	@Override
	public StyledString getStyledText(Object element) {
		return null;
	}

	@Override
	public Image getImage(Object element) {
		if (element instanceof PagePart) {
			PagePart part = (PagePart) element;
			String imageKey = "";
			switch (part.getKind()) {
				case PAGE:
					imageKey = FluentImages.DESC_OBJ_PAGE;
					break;
				case CODE_BLOCK:
					imageKey = FluentImages.DESC_OBJ_CODEBLOCK;
					break;
				case CODE_BLOCK_INDENTED:
					imageKey = FluentImages.DESC_OBJ_CODEBLOCK_INDENTED;
					break;
				case COMMENT:
					imageKey = FluentImages.DESC_OBJ_COMMENT;
					break;
				case DEFINITION:
					imageKey = FluentImages.DESC_OBJ_DEFINITION;
					break;
				case FRONT_MATTER:
					imageKey = FluentImages.DESC_OBJ_FRONTMATTER;
					break;
				case HEADER:
					imageKey = FluentImages.DESC_OBJ_HEADER;
					break;
				case HRULE:
					imageKey = FluentImages.DESC_OBJ_HRULE;
					break;
				case HTML_BLOCK:
					imageKey = FluentImages.DESC_OBJ_HTML;
					break;
				case LIST:
					imageKey = FluentImages.DESC_OBJ_LIST;
					break;
				case MATH_BLOCK:
					imageKey = FluentImages.DESC_OBJ_SUM;
					break;
				case QUOTE:
					imageKey = FluentImages.DESC_OBJ_QUOTE;
					break;
				case REFERENCE:
					imageKey = FluentImages.DESC_OBJ_REFERENCE;
					break;
				case TABLE:
					imageKey = FluentImages.DESC_OBJ_TABLE;
					break;
				case TEXT:
					imageKey = FluentImages.DESC_OBJ_TEXT;
					break;
				default:
					imageKey = FluentImages.DESC_OBJ_UNDEFINED;
					break;
			}

			Image img = fetchImage(imageKey);
			return img;
		}

		return super.getImage(element);
	}

	private FluentImages imageProvider() {
		return (FluentImages) FluentUI.getDefault().getImageProvider();
	}

	protected Image fetchImage(String imageKey) {
		Pair pair = iMap.get(imageKey);
		if (pair == null) {
			pair = new Pair();
			pair.desc = imageProvider().getDescriptor(imageKey);
			pair.img = pair.desc.createImage();
			iMap.put(imageKey, pair);
		}
		return pair.img;
	}

	@Override
	public void dispose() {
		for (Pair pair : iMap.values()) {
			pair.img.dispose();
		}
		super.dispose();
	}
}
