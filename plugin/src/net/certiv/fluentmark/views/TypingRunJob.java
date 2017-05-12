package net.certiv.fluentmark.views;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

import net.certiv.fluentmark.FluentMkUI;
import net.certiv.fluentmark.preferences.Prefs;

/** Waits for the end of a typing run to trigger the limit job. */
public class TypingRunJob extends Job {

	private LimitJob limiter;
	private boolean delaying;
	private long lastHit;

	public TypingRunJob(LimitJob limiter) {
		super("Typing delay");
		this.limiter = limiter;
	}

	public void trigger() {
		lastHit = System.currentTimeMillis();
		if (!delaying) {
			delaying = true;
			schedule(SHORT);
		}
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		while (!monitor.isCanceled() && delaying) {
			int delay = FluentMkUI.getDefault().getPreferenceStore().getInt(Prefs.VIEW_UPDATE_DELAY);
			int incr = delay / 4;
			while (System.currentTimeMillis() < lastHit + delay) {
				try {
					Thread.sleep(incr);
				} catch (InterruptedException e) {}
			}
			if (limiter != null) limiter.trigger();
			delaying = false;
		}
		return Status.OK_STATUS;
	}

	public void dispose() {
		this.limiter = null;
	}
}
