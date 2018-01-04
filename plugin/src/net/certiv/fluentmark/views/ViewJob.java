package net.certiv.fluentmark.views;

import java.math.BigDecimal;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;
import org.eclipse.swt.browser.ProgressAdapter;
import org.eclipse.swt.browser.ProgressEvent;
import org.eclipse.swt.browser.ProgressListener;
import org.eclipse.swt.widgets.Display;

import net.certiv.fluentmark.FluentMkUI;
import net.certiv.fluentmark.Log;
import net.certiv.fluentmark.convert.HtmlKind;
import net.certiv.fluentmark.editor.FluentMkEditor;
import net.certiv.fluentmark.preferences.Prefs;

public class ViewJob extends Job {

	private static final String RENDER = "Reactor.update('%s');";

	enum State {
		LOAD,
		READY,
		NONE;
	}

	private ProgressListener watcher = new ProgressAdapter() {

		@Override
		public void completed(ProgressEvent event) {
			done();
		}
	};

	private FluentMkPreview view;
	private Browser browser;
	private IPreferenceStore store;
	private DoneFunction func;

	private State state = State.NONE;
	private long timer;

	public ViewJob(FluentMkPreview view) {
		super("Preview");
		this.view = view;
		this.browser = view.getBrowser();
		this.store = FluentMkUI.getDefault().getPreferenceStore();

		load();
	}

	public void load() {
		FluentMkEditor editor = view.getEditor();
		if (editor != null) {
			state = State.LOAD;
			func = new DoneFunction(browser, "typeset");	// MathJax callback
			browser.addProgressListener(watcher);
			timer = System.nanoTime();
			browser.setText(editor.getHtmlGen().getPage(HtmlKind.VIEW));
		}
	}

	public void update() {
		if (state != State.READY) return;
		switch (getState()) {
			case Job.WAITING:
			case Job.RUNNING:
				schedule(store.getInt(Prefs.VIEW_UPDATE_DELAY));
				break;
			default:
				schedule(SHORT);
				break;
		}
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		FluentMkEditor editor = view.getEditor();
		if (editor == null || view == null || browser == null || browser.isDisposed()) {
			return Status.CANCEL_STATUS;
		}
		timer = System.nanoTime();

		String html = editor.getHtmlGen().getUpdate();
		if (html.isEmpty()) return Status.CANCEL_STATUS;
		String script = String.format(RENDER, html).replace("\r\n", "\\r\\n");

		// run on UI thread
		Display.getDefault().asyncExec(new Runnable() {

			@Override
			public void run() {
				if (browser != null && !browser.isDisposed()) {
					boolean ok = browser.execute(script);
					if (!ok) Log.error("Reactor.update(...) failed.");
				}
			}
		});

		return Status.OK_STATUS;
	}

	protected void done() {
		switch (state) {
			case LOAD:
				result("ViewJob ready");
				state = State.READY;
				break;
			default:
				result("Update complete.");
				break;
		}
	}

	protected void dispose() {
		if (func != null) {
			func.dispose();
			func = null;
		}
		if (browser != null && !browser.isDisposed()) {
			browser.removeProgressListener(watcher);
		}
	}

	private void result(String msg) {
		if (timer == 0) {
			Log.info(msg);
		} else {
			long elapsed = System.nanoTime() - timer;
			String value = BigDecimal.valueOf(elapsed, 6).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
			if (value.indexOf('.') > 3) {
				Log.info(String.format("%s %s (ms): ", msg, value));
			}
		}
		timer = 0;
	}

	class DoneFunction extends BrowserFunction {

		DoneFunction(Browser browser, String name) {
			super(browser, name);
		}

		@Override
		public Object function(Object[] args) {
			if (args.length > 0 && "End".equals(args[0])) {
				// System.out.println("typeset() called [args=" + args + "]");
				done();
			}
			return null;
		}
	}
}
