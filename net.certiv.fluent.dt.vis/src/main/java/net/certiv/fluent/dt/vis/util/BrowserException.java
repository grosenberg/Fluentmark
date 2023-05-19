package net.certiv.fluent.dt.vis.util;

/** Thrown to cancel out of some operation. */
public final class BrowserException extends RuntimeException {

	/** Creates a new exception. */
	public BrowserException() {
		super("Browser operation canceled.");
	}

	/** Creates a new exception with the given message. */
	public BrowserException(String message) {
		super(message);
	}

	public BrowserException(Throwable cause) {
		super(cause);
	}

	public BrowserException(String message, Throwable cause) {
		super(message, cause);
	}

	public BrowserException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
