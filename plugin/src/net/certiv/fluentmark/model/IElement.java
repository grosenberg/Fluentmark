/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.model;

import org.eclipse.core.resources.IResource;

import net.certiv.fluentmark.editor.ISourceReference;

public interface IElement extends ISourceReference {

	IResource getResource();

	Kind getKind();

	int getLevel();

	void dispose();
}
