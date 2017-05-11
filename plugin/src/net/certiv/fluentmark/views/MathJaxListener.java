package net.certiv.fluentmark.views;

import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.BrowserFunction;
import org.eclipse.swt.browser.CloseWindowListener;
import org.eclipse.swt.browser.WindowEvent;
import org.eclipse.swt.widgets.Display;

public class MathJaxListener {

	private CustomFunction cfunc;
	private UpdateJob updater;

	public MathJaxListener(Browser browser, UpdateJob updater) {
		this.updater = updater;

		Display.getDefault().asyncExec(new Runnable() {

			@Override
			public void run() {
				// create persistent Javascript callback function named 'typeset()'
				cfunc = new CustomFunction(browser, "typeset");
				browser.addCloseWindowListener(new CloseWindowListener() {

					@Override
					public void close(WindowEvent event) {
						browser.removeCloseWindowListener(this);
						dispose();
					}
				});
			}
		});
	}

	// call after the very last update of the browser
	public void dispose() {
		if (cfunc != null) cfunc.dispose();
	}

	class CustomFunction extends BrowserFunction {

		CustomFunction(Browser browser, String name) {
			super(browser, name);
		}

		@Override
		public Object function(Object[] args) {
			if (args.length > 0 && "End".equals(args[0])) {
				// System.out.println("typeset() called [args=" + args + "]");
				updater.updateComplete();
			}
			return null;
		}
	}
}
