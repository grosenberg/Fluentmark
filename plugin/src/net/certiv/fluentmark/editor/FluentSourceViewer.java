/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.editor;

import static org.eclipse.ui.texteditor.AbstractDecoratedTextEditorPreferenceConstants.EDITOR_SELECTION_BACKGROUND_COLOR;
import static org.eclipse.ui.texteditor.AbstractDecoratedTextEditorPreferenceConstants.EDITOR_SELECTION_BACKGROUND_DEFAULT_COLOR;
import static org.eclipse.ui.texteditor.AbstractDecoratedTextEditorPreferenceConstants.EDITOR_SELECTION_FOREGROUND_COLOR;
import static org.eclipse.ui.texteditor.AbstractDecoratedTextEditorPreferenceConstants.EDITOR_SELECTION_FOREGROUND_DEFAULT_COLOR;
import static org.eclipse.ui.texteditor.AbstractTextEditor.PREFERENCE_COLOR_BACKGROUND;
import static org.eclipse.ui.texteditor.AbstractTextEditor.PREFERENCE_COLOR_BACKGROUND_SYSTEM_DEFAULT;
import static org.eclipse.ui.texteditor.AbstractTextEditor.PREFERENCE_COLOR_FOREGROUND;
import static org.eclipse.ui.texteditor.AbstractTextEditor.PREFERENCE_COLOR_FOREGROUND_SYSTEM_DEFAULT;

import java.util.ArrayList;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextPresentationListener;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.information.IInformationPresenter;
import org.eclipse.jface.text.reconciler.IReconciler;
import org.eclipse.jface.text.source.IOverviewRuler;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

import net.certiv.fluentmark.editor.text.SmartBackspaceManager;
import net.certiv.fluentmark.preferences.Prefs;

/** Source viewer for the editor */
public class FluentSourceViewer extends ProjectionViewer implements IPropertyChangeListener {

	/** Show outline operation id. */
	public static final int SHOW_OUTLINE = 51;
	/** Show element at the current position. */
	public static final int OPEN_STRUCTURE = 52;
	/** Show type hierarchy operation id. */
	public static final int SHOW_HIERARCHY = 53;

	/** Presents outline. */
	private IInformationPresenter fOutlinePresenter;
	/** Presents type structure. */
	private IInformationPresenter fStructurePresenter;
	/** Presents type hierarchy. */
	private IInformationPresenter fHierarchyPresenter;

	/** This viewer's foreground color */
	private Color fForegroundColor;
	/** The viewer's background color */
	private Color fBackgroundColor;
	/** This viewer's selection foreground color */
	private Color fSelectionForegroundColor;
	/** The viewer's selection background color */
	private Color fSelectionBackgroundColor;

	private IPreferenceStore store;
	private SmartBackspaceManager backspaceMgr;
	private boolean isConfigured;
	private boolean isSetVisibleDocumentDelayed = false;

	/** Creates new source viewer. */
	public FluentSourceViewer(Composite parent, IVerticalRuler ruler, IOverviewRuler overviewRuler,
			boolean isOverviewRulerShowing, int styles, IPreferenceStore store) {
		super(parent, ruler, overviewRuler, isOverviewRulerShowing, styles);
		setPreferenceStore(store);
	}

	public IContentAssistant getContentAssistant() {
		return fContentAssistant;
	}

	@Override
	public void configure(SourceViewerConfiguration configuration) {
		StyledText textWidget = getTextWidget();

		// Prevent access to colors disposed in unconfigure().
		if (textWidget != null && !textWidget.isDisposed()) {
			Color foregroundColor = textWidget.getForeground();
			if (foregroundColor != null && foregroundColor.isDisposed()) {
				textWidget.setForeground(null);
			}
			Color backgroundColor = textWidget.getBackground();
			if (backgroundColor != null && backgroundColor.isDisposed()) {
				textWidget.setBackground(null);
			}
		}

		super.configure(configuration);

		if (configuration instanceof FluentSourceViewerConfiguration) {

			// FluentSourceViewerConfiguration cConfiguration = (FluentSourceViewerConfiguration)
			// configuration;
			//
			// fOutlinePresenter = cConfiguration.getOutlinePresenter(this, false);
			// if (fOutlinePresenter != null) {
			// fOutlinePresenter.install(this);
			// }
			// fStructurePresenter = cConfiguration.getOutlinePresenter(this, true);
			// if (fStructurePresenter != null) {
			// fStructurePresenter.install(this);
			// }
			// fHierarchyPresenter = cConfiguration.getHierarchyPresenter(this);
			// if (fHierarchyPresenter != null) {
			// fHierarchyPresenter.install(this);
			// }

			if (textWidget != null) {
				textWidget.setFont(JFaceResources.getFont(Prefs.EDITOR_TEXT_FONT));
			}
		}
		if (store != null) {
			this.store.addPropertyChangeListener(this);
			initializeViewerColors();
		}
		isConfigured = true;
	}

	protected void initializeViewerColors() {
		if (store != null) {

			StyledText styledText = getTextWidget();
			Color color = null;

			// ----------- foreground color --------------------
			if (!store.getBoolean(PREFERENCE_COLOR_FOREGROUND_SYSTEM_DEFAULT)) {
				color = createColor(store, PREFERENCE_COLOR_FOREGROUND, styledText.getDisplay());
				styledText.setForeground(color);
			}
			if (fForegroundColor != null) fForegroundColor.dispose();
			fForegroundColor = color;

			// ---------- background color ----------------------
			if (!store.getBoolean(PREFERENCE_COLOR_BACKGROUND_SYSTEM_DEFAULT)) {
				color = createColor(store, PREFERENCE_COLOR_BACKGROUND, styledText.getDisplay());
				styledText.setBackground(color);
			}
			if (fBackgroundColor != null) fBackgroundColor.dispose();
			fBackgroundColor = color;

			// ----------- selection foreground color --------------------
			if (!store.getBoolean(EDITOR_SELECTION_FOREGROUND_DEFAULT_COLOR)) {
				color = createColor(store, EDITOR_SELECTION_FOREGROUND_COLOR, styledText.getDisplay());
				styledText.setSelectionForeground(color);
			}
			if (fSelectionForegroundColor != null) fSelectionForegroundColor.dispose();
			fSelectionForegroundColor = color;

			// ---------- selection background color ----------------------
			if (!store.getBoolean(EDITOR_SELECTION_BACKGROUND_DEFAULT_COLOR)) {
				color = createColor(store, EDITOR_SELECTION_BACKGROUND_COLOR, styledText.getDisplay());
				styledText.setSelectionBackground(color);
			}
			if (fSelectionBackgroundColor != null) fSelectionBackgroundColor.dispose();
			fSelectionBackgroundColor = color;
		}
	}

	/**
	 * Creates a color from the information stored in the given preference delta. Returns
	 * <code>null</code> if there is no such information available. TODO: move or fix store.getColor
	 *
	 * @param delta the delta to read from
	 * @param key the key used for the lookup in the preference delta
	 * @param display the display used create the color
	 * @return the created color according to the specification in the preference delta
	 */
	public Color createColor(IPreferenceStore store, String key, Display display) {
		RGB rgb = null;
		if (store.contains(key)) {
			if (store.isDefault(key)) {
				rgb = PreferenceConverter.getDefaultColor(store, key);
			} else {
				rgb = PreferenceConverter.getColor(store, key);
			}
			if (rgb != null) return new Color(display, rgb);
		}
		return null;
	}

	@Override
	public void unconfigure() {
		if (fOutlinePresenter != null) {
			fOutlinePresenter.uninstall();
			fOutlinePresenter = null;
		}
		if (fStructurePresenter != null) {
			fStructurePresenter.uninstall();
			fStructurePresenter = null;
		}
		if (fHierarchyPresenter != null) {
			fHierarchyPresenter.uninstall();
			fHierarchyPresenter = null;
		}
		if (fForegroundColor != null) {
			fForegroundColor.dispose();
			fForegroundColor = null;
		}
		if (fBackgroundColor != null) {
			fBackgroundColor.dispose();
			fBackgroundColor = null;
		}
		if (store != null) this.store.removePropertyChangeListener(this);
		super.unconfigure();
		isConfigured = false;
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		String property = event.getProperty();
		if (PREFERENCE_COLOR_FOREGROUND.equals(property) || PREFERENCE_COLOR_FOREGROUND_SYSTEM_DEFAULT.equals(property)
				|| PREFERENCE_COLOR_BACKGROUND.equals(property)
				|| PREFERENCE_COLOR_BACKGROUND_SYSTEM_DEFAULT.equals(property)
				|| EDITOR_SELECTION_FOREGROUND_COLOR.equals(property)
				|| EDITOR_SELECTION_FOREGROUND_DEFAULT_COLOR.equals(property)
				|| EDITOR_SELECTION_BACKGROUND_COLOR.equals(property)
				|| EDITOR_SELECTION_BACKGROUND_DEFAULT_COLOR.equals(property)) {
			initializeViewerColors();
		}
	}

	/** Sets the preference delta on this viewer. */
	public void setPreferenceStore(IPreferenceStore store) {
		if (isConfigured && store != null) {
			this.store.removePropertyChangeListener(this);
		}
		this.store = store;
		if (isConfigured && store != null) {
			this.store.addPropertyChangeListener(this);
			initializeViewerColors();
		}
	}

	@Override
	protected void createControl(Composite parent, int styles) {
		// Use LEFT_TO_RIGHT unless otherwise specified.
		if ((styles & SWT.RIGHT_TO_LEFT) == 0 && (styles & SWT.LEFT_TO_RIGHT) == 0) {
			styles |= SWT.LEFT_TO_RIGHT;
		}

		super.createControl(parent, styles);

		backspaceMgr = new SmartBackspaceManager();
		backspaceMgr.install(this);
	}

	@Override
	public void doOperation(int operation) {
		if (getTextWidget() == null) {
			return;
		}
		switch (operation) {
			case SHOW_OUTLINE:
				if (fOutlinePresenter != null) {
					fOutlinePresenter.showInformation();
				}
				return;
			case OPEN_STRUCTURE:
				if (fStructurePresenter != null) {
					fStructurePresenter.showInformation();
				}
				return;
			case SHOW_HIERARCHY:
				if (fHierarchyPresenter != null) {
					fHierarchyPresenter.showInformation();
				}
				return;
		}
		super.doOperation(operation);
	}

	@Override
	public boolean canDoOperation(int operation) {
		switch (operation) {
			case SHOW_OUTLINE:
				return fOutlinePresenter != null;
			case OPEN_STRUCTURE:
				return fStructurePresenter != null;
			case SHOW_HIERARCHY:
				return fHierarchyPresenter != null;
		}
		return super.canDoOperation(operation);
	}

	/** Prepend given listener to the list of presentation listeners */
	public void prependTextPresentationListener(ITextPresentationListener listener) {
		Assert.isNotNull(listener);

		if (fTextPresentationListeners == null) {
			fTextPresentationListeners = new ArrayList<ITextPresentationListener>();
		}

		fTextPresentationListeners.remove(listener);
		fTextPresentationListeners.add(0, listener);
	}

	/**
	 * Sets the given reconciler.
	 *
	 * @param reconciler the reconciler
	 */
	void setReconciler(IReconciler reconciler) {
		this.fReconciler = reconciler;
	}

	/**
	 * Returns the reconciler.
	 *
	 * @return the reconciler or <code>null</code> if not set
	 */
	IReconciler getReconciler() {
		return fReconciler;
	}

	/**
	 * Delays setting the visual document until after the projection has been computed. This method
	 * must only be called before the document is set on the viewer.
	 * <p>
	 * This is a performance optimization to reduce the computation of the text presentation
	 * triggered by <code>setVisibleDocument(IDocument)</code>.
	 * </p>
	 */
	void prepareDelayedProjection() {
		Assert.isTrue(!isSetVisibleDocumentDelayed);
		isSetVisibleDocumentDelayed = true;
	}

	@Override
	protected void setVisibleDocument(IDocument document) {
		if (isSetVisibleDocumentDelayed) {
			isSetVisibleDocumentDelayed = false;
			IDocument previous = getVisibleDocument();
			// will set the visible document if anything is folded
			enableProjection();
			IDocument current = getVisibleDocument();
			// if the visible document was not replaced, continue as usual
			if (current != null && current != previous) return;
		}
		super.setVisibleDocument(document);
	}

	@Override
	protected StyleRange modelStyleRange2WidgetStyleRange(StyleRange range) {
		IRegion region = modelRange2WidgetRange(new Region(range.start, range.length));
		if (region != null) {			// don't clone the style range, but simply reuse it.
			range.start = region.getOffset();
			range.length = region.getLength();
			return range;
		}
		return null;
	}

	@Override
	public void resetVisibleRegion() {
		super.resetVisibleRegion();
		// re-enable folding if ProjectionViewer failed to due so
		if (store != null && !isProjectionMode()) enableProjection();
	}

	public SmartBackspaceManager getBackspaceManager() {
		return backspaceMgr;
	}

	@Override
	protected void handleDispose() {
		if (backspaceMgr != null) {
			backspaceMgr.uninstall();
			backspaceMgr = null;
		}
		super.handleDispose();
	}

}
