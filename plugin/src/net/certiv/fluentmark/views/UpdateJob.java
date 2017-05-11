/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.views;

import java.math.BigDecimal;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.ProgressAdapter;
import org.eclipse.swt.browser.ProgressEvent;
import org.eclipse.swt.browser.ProgressListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;

import net.certiv.fluentmark.Log;
import net.certiv.fluentmark.editor.FluentMkEditor;

public class UpdateJob extends Job {

	// script to return the current top scroll position of the browser widget
	private static final String GETSCROLLTOP = "function getScrollTop() { " //$NON-NLS-1$
			+ "  if(typeof pageYOffset!='undefined') return pageYOffset;" //$NON-NLS-1$
			+ "  else{" //$NON-NLS-1$
			+ "var B=document.body;" //$NON-NLS-1$
			+ "var D=document.documentElement;" //$NON-NLS-1$
			+ "D=(D.clientHeight)?D:B;return D.scrollTop;}" //$NON-NLS-1$
			+ "}; return getScrollTop();"; //$NON-NLS-1$

	private ProgressListener htmlLoad = new ProgressAdapter() {

		@Override
		public void completed(ProgressEvent event) {
			updateComplete();
		}
	};

	private FluentMkPreview view;
	private Browser browser;
	private boolean jaxed;
	private int scrollTop;
	private long begTime;

	public UpdateJob(FluentMkPreview view) {
		super("Update");
		this.view = view;
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		if (view != null) {
			begTime = System.nanoTime();
			browser = view.getBrowser();
			IEditorPart part = getActiveEditor();
			if (part == null || !(part instanceof FluentMkEditor)) {
				return Status.CANCEL_STATUS;
			}

			FluentMkEditor editor = (FluentMkEditor) part;
			String html = editor.getHtml(true);
			if (html == null) return Status.CANCEL_STATUS;
			jaxed = editor.useMathJax();

			Display.getDefault().asyncExec(new Runnable() {

				@Override
				public void run() {
					try {
						if (browser != null && !browser.isDisposed()) {
							Object result = browser.evaluate(GETSCROLLTOP);
							scrollTop = result != null ? ((Number) result).intValue() : 0;
							if (!jaxed) {
								browser.addProgressListener(htmlLoad);
							}
							browser.setRedraw(false);
							browser.setText(html);
						}
					} catch (SWTException e) {
						browser.setRedraw(true);
						Log.error("UpdateJob async failed: " + e.getMessage());
					}
				}
			});
		}
		return Status.OK_STATUS;
	}

	/**
	 * Invoked in response to either (1) the html load completed progress event; or (2) the MathJax signal
	 * indicating that typsetting has completed.
	 */
	protected void updateComplete() {
		Display.getDefault().asyncExec(new Runnable() {

			@Override
			public void run() {
				if (!jaxed) {
					browser.removeProgressListener(htmlLoad);
				}
				browser.execute(String.format("window.scrollTo(0,%d);", scrollTop)); //$NON-NLS-1$
				browser.setRedraw(true);
				long elapsed = System.nanoTime() - begTime;
				String value = BigDecimal.valueOf(elapsed, 6).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
				if (value.indexOf('.') > 3) {
					Log.info("Html conversion time (ms): " + value);
				}
			}
		});
	}

	protected IWorkbenchPage getActivePage() {
		return view.getSite().getWorkbenchWindow().getActivePage();
	}

	protected IEditorPart getActiveEditor() {
		return getActivePage().getActiveEditor();
	}
}
