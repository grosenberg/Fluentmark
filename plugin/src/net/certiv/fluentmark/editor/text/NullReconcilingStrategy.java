/*******************************************************************************
 * Copyright (c) 2016 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.editor.text;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.reconciler.DirtyRegion;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;

public class NullReconcilingStrategy implements IReconcilingStrategy {

	public NullReconcilingStrategy() {}

	@Override
	public void setDocument(IDocument document) {}

	@Override
	public void reconcile(DirtyRegion dirtyRegion, IRegion subRegion) {}

	@Override
	public void reconcile(IRegion partition) {}
}
