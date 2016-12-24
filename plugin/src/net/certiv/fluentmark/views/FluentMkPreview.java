/*******************************************************************************
 * Copyright (c) 2016 Certiv Analytics and others.
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
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;

import net.certiv.fluentmark.Log;
import net.certiv.fluentmark.FluentMkUI;
import net.certiv.fluentmark.editor.FluentMkEditor;
import net.certiv.fluentmark.preferences.Prefs;
import net.certiv.fluentmark.util.PartListener;

public class FluentMkPreview extends ViewPart implements Prefs {

	public static final String ID = "net.certiv.fluentmark.views.FluentMkPreview";

	private IPartListener partListener = new PartListener() {

		@Override
		public void partActivated(IWorkbenchPart part) {
			if (part instanceof FluentMkEditor) {
				((FluentMkEditor) part).getViewer().addTextListener(textListener);
				limiter.trigger();
			} else if (part instanceof FluentMkPreview) {
				limiter.trigger();
			}
		}

		@Override
		public void partClosed(IWorkbenchPart part) {
			if (part instanceof FluentMkEditor) {
				try { // exception when workbench close closes the editor
					getActivePage().hideView(view);
				} catch (Exception e) {}
			}
		}
	};

	private final IPropertyChangeListener styleListener = new IPropertyChangeListener() {

		@Override
		public void propertyChange(PropertyChangeEvent event) {
			switch (event.getProperty()) {
				case EDITOR_CSS_CUSTOM:
				case EDITOR_CSS_DEFAULT:
					limiter.trigger();
			}
		}
	};

	private ITextListener textListener = new ITextListener() {

		@Override
		public void textChanged(TextEvent event) {
			limiter.trigger();
		}
	};

	private static FluentMkPreview view;
	private Browser browser;
	private LimitJob limiter;
	private UpdateJob updater;

	public FluentMkPreview() {
		view = this;
	}

	/**
	 * Callback to create and initialize the browser.
	 */
	@Override
	public void createPartControl(Composite parent) {
		browser = new Browser(parent, SWT.MULTI);
		updater = new UpdateJob(view);
		limiter = new LimitJob(view, updater);

		getPreferenceStore().addPropertyChangeListener(styleListener);
		getActivePage().addPartListener(partListener);
	}

	@Override
	public void dispose() {
		getPreferenceStore().removePropertyChangeListener(styleListener);
		getActivePage().removePartListener(partListener);
		ITextViewer srcViewer = getSourceViewer();
		if (srcViewer != null) {
			srcViewer.removeTextListener(textListener);
		}

		if (updater != null) {
			updater.cancel();
			updater = null;
		}
		if (limiter != null) {
			limiter.cancel();
			limiter.dispose();
			limiter = null;
		}
		browser = null;
		super.dispose();
	}

	// called only by refresh handler
	public void trigger() {
		Log.info("trigger");
		limiter.trigger();
	}

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

	protected FluentMkEditor getActiveEditor() {
		return (FluentMkEditor) getActivePage().getActiveEditor();
	}

	protected ISourceViewer getSourceViewer() {
		FluentMkEditor editor = getActiveEditor();
		return editor != null ? editor.getViewer() : null;
	}

	protected IPreferenceStore getPreferenceStore() {
		return FluentMkUI.getDefault().getPreferenceStore();
	}

	// void update() {
	// if (browser == null || updateBusy) return;
	//
	// try {
	// IEditorPart editor = getActiveEditor();
	// if (editor == null || !(editor instanceof FluentMkEditor)) {
	// browser.setText("");
	// return;
	// }
	//
	// String html = ((FluentMkEditor) editor).getHtml();
	// if (html == null) {
	// browser.setText("");
	// return;
	// }
	//
	// Object result = browser.evaluate(GETSCROLLTOP);
	// scrollTop = result != null ? ((Number) result).intValue() : 0;
	//
	// Log.error("Starting update...");
	// browser.setRedraw(false);
	// browser.addProgressListener(htmlLoad);
	// browser.setText(html);
	//
	// // The Browser widget flickers when made visible while it is not completely
	// // loaded. The fix is to delay the call to setVisible until either loading is
	// // completed (see ProgressListener in constructor), or a timeout has been reached.
	// final Display display = Display.getCurrent();
	// display.timerExec(100, new Runnable() {
	//
	// public void run() {
	// updateBusy = false;
	// }
	// });
	//
	// while (updateBusy) {
	// // Drive the event loop while waiting for the browser to load
	// if (!display.readAndDispatch()) {
	// display.sleep();
	// }
	// }
	// browser.setRedraw(true);
	//
	// } catch (Exception e) {
	// browser.setRedraw(true);
	// updateBusy = false;
	//
	// StringWriter errors = new StringWriter();
	// e.printStackTrace(new PrintWriter(errors));
	// Log.error(e.getLocalizedMessage() + Strings.EOL + errors.toString());
	//
	// List<Status> lines = new ArrayList<>();
	// for (StackTraceElement line : e.getStackTrace()) {
	// lines.add(new Status(IStatus.ERROR, FluentMkUI.PLUGIN_ID, line.toString()));
	// }
	// MultiStatus status = new MultiStatus(FluentMkUI.PLUGIN_ID, IStatus.ERROR,
	// lines.toArray(new Status[lines.size()]), e.getLocalizedMessage(), e);
	// ErrorDialog.openError(null, "Viewer error", e.getMessage(), status);
	// }
	// }
}
