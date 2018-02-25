package net.certiv.fluentmark.views;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringEscapeUtils;
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
import org.eclipse.ui.IPathEditorInput;

import net.certiv.fluentmark.FluentUI;
import net.certiv.fluentmark.Log;
import net.certiv.fluentmark.convert.Kind;
import net.certiv.fluentmark.editor.FluentEditor;
import net.certiv.fluentmark.preferences.Prefs;
import net.certiv.fluentmark.util.FileUtils;
import net.certiv.fluentmark.util.Strings;

public class ViewJob extends Job {

	private static final String Render = "Fluent.set('%s');";

	private enum State {
		NONE,
		LOAD,
		READY,
		TYPESET;
	}

	private ProgressListener watcher = new ProgressAdapter() {

		@Override
		public void completed(ProgressEvent event) {
			done();
		}
	};

	private FluentPreview view;
	private Browser browser;
	private IPreferenceStore store;
	private DoneFunction func;

	private State state = State.NONE;
	private long timer;

	private boolean mathjax;

	public ViewJob(FluentPreview view) {
		super("Preview");
		this.view = view;
		this.browser = view.getBrowser();
		this.store = FluentUI.getDefault().getPreferenceStore();

		load();
	}

	public boolean load() {
		return load(false);
	}

	public boolean load(boolean firebug) {
		FluentEditor editor = view.getEditor();
		if (editor == null) return false;

		IPathEditorInput input = (IPathEditorInput) editor.getEditorInput();
		if (input == null) return false;

		state = State.LOAD;
		if (editor.useMathJax()) {
			mathjax = true;
			func = new DoneFunction(browser, "typeset");
		} else {
			mathjax = false;
			func = null;
		}
		browser.addProgressListener(watcher);
		timer = System.nanoTime();
		String script = FileUtils.fromBundle("resources/html/firebug.html") + Strings.EOL;
		String content = editor.getHtml(Kind.VIEW);
		if (firebug) {
			content = content.replaceFirst("</head>", script + "</head>");
		}
		browser.setText(content);
		return true;
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

	/** The job to run when scheduled */
	@Override
	protected IStatus run(IProgressMonitor monitor) {
		FluentEditor editor = view.getEditor();
		if (editor == null || view == null || browser == null || browser.isDisposed()) {
			return Status.CANCEL_STATUS;
		}
		timer = System.nanoTime();

		String html = editor.getHtml(Kind.UPDATE);
		if (html.isEmpty()) return Status.CANCEL_STATUS;

		String script = String.format(Render, StringEscapeUtils.escapeEcmaScript(html));
		if (mathjax) state = State.READY;

		// execute script on UI thread
		Display.getDefault().asyncExec(new Runnable() {

			@Override
			public void run() {
				if (browser != null && !browser.isDisposed()) {
					boolean ok = browser.execute(script);
					if (!ok) Log.error("Script execute failed.");
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
				update();
				break;
			default:
				state = State.READY;
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

	// called on completion of MathJax typesetting
	class DoneFunction extends BrowserFunction {

		DoneFunction(Browser browser, String name) {
			super(browser, name);
		}

		@Override
		public Object function(Object[] args) {
			Log.info(String.format("typeset(%s", args));
			if (args.length > 0 && "End".equals(args[0])) {
				state = State.READY;
				done();
			}
			return null;
		}
	}
}
