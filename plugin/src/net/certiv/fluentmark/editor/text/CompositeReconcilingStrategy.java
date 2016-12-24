/*******************************************************************************
 * Copyright (c) 2016 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.editor.text;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.reconciler.DirtyRegion;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.eclipse.jface.text.reconciler.IReconcilingStrategyExtension;

/**
 * A reconciling strategy consisting of a sequence of internal reconciling strategies. By default,
 * all requests are passed on to the contained strategies.
 */
public class CompositeReconcilingStrategy implements IReconcilingStrategy, IReconcilingStrategyExtension {

	/** The list of internal reconciling strategies. */
	private IReconcilingStrategy[] strategies;

	/**
	 * Creates a new, empty composite reconciling strategy.
	 */
	public CompositeReconcilingStrategy() {}

	/**
	 * Sets the reconciling strategies for this composite strategy.
	 *
	 * @param strategies the strategies to be set or <code>null</code>
	 */
	public void setReconcilingStrategies(IReconcilingStrategy[] strategies) {
		this.strategies = strategies;
	}

	/**
	 * Returns the previously set strategies or <code>null</code>.
	 *
	 * @return the contained strategies or <code>null</code>
	 */
	public IReconcilingStrategy[] getReconcilingStrategies() {
		return strategies;
	}

	@Override
	public void setDocument(IDocument document) {
		if (strategies == null) return;

		for (IReconcilingStrategy strategy : strategies) {
			strategy.setDocument(document);
		}
	}

	@Override
	public void reconcile(DirtyRegion dirtyRegion, IRegion subRegion) {
		if (strategies == null) return;

		for (IReconcilingStrategy strategy : strategies) {
			strategy.reconcile(dirtyRegion, subRegion);
		}
	}

	@Override
	public void reconcile(IRegion partition) {
		if (strategies == null) return;

		for (IReconcilingStrategy strategy : strategies) {
			strategy.reconcile(partition);
		}
	}

	@Override
	public void setProgressMonitor(IProgressMonitor monitor) {
		if (strategies == null) return;

		for (IReconcilingStrategy strategy : strategies) {
			if (strategy instanceof IReconcilingStrategyExtension) {
				IReconcilingStrategyExtension extension = (IReconcilingStrategyExtension) strategy;
				extension.setProgressMonitor(monitor);
			}
		}
	}

	@Override
	public void initialReconcile() {
		if (strategies == null) return;

		for (IReconcilingStrategy strategy : strategies) {
			if (strategy instanceof IReconcilingStrategyExtension) {
				IReconcilingStrategyExtension extension = (IReconcilingStrategyExtension) strategy;
				extension.initialReconcile();
			}
		}
	}
}
