/*******************************************************************************
 * Copyright (c) 2016 - 2020 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluent.dt.ui.views;

import org.eclipse.jface.text.ITextListener;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.TextEvent;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;

import net.certiv.dsl.core.preferences.PrefsManager;
import net.certiv.dsl.core.util.eclipse.PartAdaptor;
import net.certiv.fluent.dt.core.FluentCore;
import net.certiv.fluent.dt.core.preferences.Prefs;
import net.certiv.fluent.dt.ui.editor.FluentEditor;

public class FluentPreview extends ViewPart implements PartAdaptor, ITextListener, IPropertyChangeListener {

	public static final String ID = "net.certiv.fluent.dt.ui.views.FluentPreview";

	private static FluentPreview viewpart;
	private Browser browser;
	private ViewJob viewjob;

	public FluentPreview() {
		viewpart = this;
	}

	/**
	 * Callback to create and initialize the browser.
	 * <p>
	 * https://www.eclipse.org/swt/faq.php#howusechromium
	 * <p>
	 * CEF p2 repo from Make technology
	 * <p>
	 * http://dl.maketechnology.io/chromium-cef/rls/repository
	 */
	@Override
	public void createPartControl(Composite parent) {
		int engine = Integer.valueOf(getPrefsMgr().getString(Prefs.EDITOR_MD_ENGINE));
		browser = new Browser(parent, engine);
		browser.setRedraw(true);
		browser.setJavascriptEnabled(true);

		viewjob = new ViewJob(viewpart);
		getPrefsMgr().addPropertyChangeListener(this);
		getActivePage().addPartListener(this);
	}

	// -------------------------------------------------------------------------

	@Override
	public void partActivated(IWorkbenchPart part) { // view opened
		if (part instanceof FluentEditor) {
			((FluentEditor) part).getViewer().addTextListener(this);
			viewjob.update();
		}
	}

	@Override
	public void partClosed(IWorkbenchPart part) { // view closed
		if (part instanceof FluentEditor) {
			// try {
			// for (IWorkbenchPage page : CoreUtil.getActiveWorkbenchWindow().getPages()) {
			// for (IEditorReference ed : page.getEditorReferences()) {
			// ???
			// }
			// }
			// if (!CoreUtil.getActiveWorkbench().isClosing())
			// getActivePage().hideView(viewpart);
			// } catch (Exception e) {}
		}
	}

	@Override
	public void textChanged(TextEvent event) { // on editor content change
		if (viewjob != null) viewjob.update();
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) { // on property store change
		if (viewjob != null) {
			PrefsManager mgr = FluentCore.getDefault().getPrefsManager();
			if (mgr.keyMatch(event.getProperty(), //
					Prefs.EDITOR_PREVIEW_FILE, //
					Prefs.EDITOR_PREVIEW_EXTERNAL_ENABLE, //
					Prefs.EDITOR_PREVIEW_EXTERNAL_DIR //
			)) viewjob.load();
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

	protected PrefsManager getPrefsMgr() {
		return FluentCore.getDefault().getPrefsManager();
	}

	@Override
	public void dispose() {
		getPrefsMgr().removePropertyChangeListener(this);
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
