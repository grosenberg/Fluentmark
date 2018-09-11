/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.editor.text;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.reconciler.DirtyRegion;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.spelling.SpellingReconcileStrategy;
import org.eclipse.ui.texteditor.spelling.SpellingService;

import net.certiv.fluentmark.FluentUI;
import net.certiv.fluentmark.editor.FluentEditor;
import net.certiv.fluentmark.editor.IProblemRequestorExtension;
import net.certiv.fluentmark.preferences.Prefs;

/**
 * Reconciling strategy containing the regular Markdown strategy and the spelling strategy.
 */
public class CompositeReconcilingStrategy extends MultiReconcilingStrategy {

	private ITextEditor editor;
	private IPreferenceStore store;
	private ISourceViewer viewer;

	/**
	 * Creates a new Dsl reconciling strategy.
	 *
	 * @param viewer the source viewer
	 * @param editor the editor of the strategy's reconciler
	 * @param documentPartitioning the document partitioning this strategy uses for configuration
	 */
	public CompositeReconcilingStrategy(ISourceViewer viewer, ITextEditor editor, String documentPartitioning) {
		this.viewer = viewer;
		this.editor = editor;
		this.store = FluentUI.getDefault().getPreferenceStore();
		setReconcilingStrategies(getReconcilingStrategies());

		// TODO: figure out how to dispose
		this.store.addPropertyChangeListener(new IPropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent event) {
				if (event.getProperty().equals(Prefs.SPELLING_ENABLED)) {
					setReconcilingStrategies(getReconcilingStrategies());
				}
			}
		});
	}

	@Override
	public IReconcilingStrategy[] getReconcilingStrategies() {
		List<IReconcilingStrategy> strategies = new ArrayList<>();
		if (store.getBoolean(Prefs.SPELLING_ENABLED)) {
			SpellingService service = new SpellingService(store);
			if (service.getActiveSpellingEngineDescriptor(store) != null) {
				IReconcilingStrategy spellStrategy = new SpellingReconcileStrategy(viewer, service);
				strategies.add(spellStrategy);
			}
		}
		if (store.getBoolean(Prefs.EDITOR_DOTMODE_ENABLED)) {
			strategies.add(new DotReconcilingStrategy(editor, viewer));
		}
		if (strategies.isEmpty()) {
			strategies.add(new NullReconcilingStrategy());
		}
		return strategies.toArray(new IReconcilingStrategy[strategies.size()]);
	}

	/**
	 * Returns the problem requestor for the editor's input element.
	 *
	 * @return the problem requestor for the editor's input element
	 */
	private IProblemRequestorExtension getProblemRequestorExtension() {
		IDocumentProvider p = editor.getDocumentProvider();
		if (p == null) return null;

		IAnnotationModel m = p.getAnnotationModel(editor.getEditorInput());
		if (m instanceof IProblemRequestorExtension) {
			return (IProblemRequestorExtension) m;
		}
		return null;
	}

	@Override
	public void initialReconcile() {
		reconcile(null, null);
	}

	@Override
	public void reconcile(IRegion partition) {
		reconcile(null, partition);
	}

	@Override
	public void reconcile(DirtyRegion dirty, IRegion partition) {
		try {
			IProblemRequestorExtension e = getProblemRequestorExtension();
			if (e != null) {
				try {
					e.beginReportingSequence();
					doReconcile(dirty, partition);
				} finally {
					e.endReportingSequence();
				}
			} else {
				doReconcile(dirty, partition);
			}
		} finally {
			((FluentEditor) editor).reconciled();
		}
	}

	private void doReconcile(DirtyRegion dirty, IRegion partition) {
		if (partition == null) {
			super.initialReconcile();
		} else if (dirty == null) {
			super.reconcile(partition);
		} else {
			super.reconcile(dirty, partition);
		}
	}
}
