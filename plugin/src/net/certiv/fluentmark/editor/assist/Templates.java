/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.editor.assist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.text.templates.Template;

public class Templates {

	private final List<Template> template = new ArrayList<Template>();
	private final Set<Template> blockTemplates = new HashSet<Template>();
	private Templates parent;

	public List<Template> getTemplate() {
		if (parent != null) {
			List<Template> parentTemplate = parent.getTemplate();
			List<Template> list = new ArrayList<Template>(template.size() + parentTemplate.size());
			list.addAll(parentTemplate);
			list.addAll(template);
			return Collections.unmodifiableList(list);
		}
		return Collections.unmodifiableList(template);
	}

	public void addTemplate(Template template, boolean block) {
		this.template.add(template);
		if (block) {
			this.blockTemplates.add(template);
		}
	}

	public void addAll(Templates other) {
		this.template.addAll(other.template);
		this.blockTemplates.addAll(other.template);
	}

	public boolean isBlock(Template template) {
		return blockTemplates.contains(template) || (parent != null && parent.isBlock(template));
	}

	public Templates getParent() {
		return parent;
	}

	public void setParent(Templates parent) {
		this.parent = parent;
	}
}
