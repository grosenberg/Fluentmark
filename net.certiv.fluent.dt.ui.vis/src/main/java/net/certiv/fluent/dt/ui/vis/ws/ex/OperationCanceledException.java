package net.certiv.fluent.dt.ui.vis.ws.ex;

/** Thrown to cancel out of some operation. */
public final class OperationCanceledException extends RuntimeException {

	/** Creates a new exception. */
	public OperationCanceledException() {
		super();
	}

	/** Creates a new exception with the given message. */
	public OperationCanceledException(String message) {
		super(message);
	}

	public OperationCanceledException(Throwable cause) {
		super(cause);
	}

	public OperationCanceledException(String message, Throwable cause) {
		super(message, cause);
	}

	public OperationCanceledException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
