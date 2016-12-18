package net.certiv.fluentmark;

import org.eclipse.core.runtime.NullProgressMonitor;

import net.certiv.fluentmark.editor.ICancelable;
import net.certiv.fluentmark.editor.ICanceler;

/**
 * A progress monitor accepting a <code>ICancelable</code> object to receive the cancel request.
 * 
 * @since 5.0
 */
public class ProgressMonitorAndCanceler extends NullProgressMonitor implements ICanceler {

	private ICancelable fCancelable;

	public void setCancelable(ICancelable cancelable) {
		fCancelable = cancelable;
		checkCanceled();
	}

	@Override
	public void setCanceled(boolean canceled) {
		super.setCanceled(canceled);
		checkCanceled();
	}

	private void checkCanceled() {
		if (fCancelable != null && isCanceled()) {
			fCancelable.cancel();
			fCancelable = null;
		}
	}

}
