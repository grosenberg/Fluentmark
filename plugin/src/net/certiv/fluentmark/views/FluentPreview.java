/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.views;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.ITextListener;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.TextEvent;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;

import net.certiv.fluentmark.FluentUI;
import net.certiv.fluentmark.editor.FluentEditor;
import net.certiv.fluentmark.preferences.Prefs;
import net.certiv.fluentmark.util.PartListener;

public class FluentPreview extends ViewPart implements PartListener, ITextListener, IPropertyChangeListener, Prefs {

	public static final String ID = "net.certiv.fluentmark.views.FluentPreview";

	private static FluentPreview viewpart;
	private Browser browser;
	private ViewJob viewjob;

	public FluentPreview() {
		viewpart = this;
	}

	/** Callback to create and initialize the browser. */
	@Override
	public void createPartControl(Composite parent) {
		browser = new Browser(parent, SWT.NONE);
		browser.setRedraw(true);
		browser.setJavascriptEnabled(true);

		viewjob = new ViewJob(viewpart);
		getPreferenceStore().addPropertyChangeListener(this);
		getActivePage().addPartListener(this);
	}

	// -------------------------------------------------------------------------
	// view opened
	@Override
	public void partActivated(IWorkbenchPart part) {
		if (part instanceof FluentEditor) {
			((FluentEditor) part).getViewer().addTextListener(this);
			viewjob.update();
		}
	}

	// view closed
	@Override
	public void partClosed(IWorkbenchPart part) {
		if (part instanceof FluentEditor) {
			try { // exception when workbench close closes the editor
				getActivePage().hideView(viewpart);
			} catch (Exception e) {}
		}
	}

	// on content change in the editor's text viewer
	@Override
	public void textChanged(TextEvent event) {
		if (viewjob != null) viewjob.update();
	}

	// on property store change
	@Override
	public void propertyChange(PropertyChangeEvent event) {
		switch (event.getProperty()) {
			case EDITOR_CSS_EXTERNAL:
			case EDITOR_CSS_BUILTIN:
				if (viewjob != null) viewjob.load();
		}
	}

	// -------------------------------------------------------------------------

	// called only by refresh view icon
	public void trigger() {
		viewjob.update();
	}

	// called only by firebug view icon
	public void debug() {
		viewjob.load(true);
	}

	// -------------------------------------------------------------------------

	public Browser getBrowser() {
		return browser;
	}

	@Override
	public void setFocus() {
		if (browser != null) browser.setFocus();
	}

	protected IWorkbenchPage getActivePage() {
		return getSite().getWorkbenchWindow().getActivePage();
	}

	protected FluentEditor getEditor() {
		IEditorPart editor = getActivePage().getActiveEditor();
		if (editor != null && editor instanceof FluentEditor) {
			return (FluentEditor) editor;
		}
		return null;
	}

	protected ISourceViewer getSourceViewer() {
		FluentEditor editor = getEditor();
		if (editor == null) return null;
		return editor.getViewer();
	}

	protected IPreferenceStore getPreferenceStore() {
		return FluentUI.getDefault().getPreferenceStore();
	}

	@Override
	public void dispose() {
		getPreferenceStore().removePropertyChangeListener(this);
		getActivePage().removePartListener(this);
		ITextViewer srcViewer = getSourceViewer();
		if (srcViewer != null) {
			srcViewer.removeTextListener(this);
		}

		if (viewjob != null) {
			viewjob.cancel();
			viewjob.dispose();
			viewjob = null;
		}
		browser = null;
		super.dispose();
	}
}
