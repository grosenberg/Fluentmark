package net.certiv.fluentmark.editor;

/**
 * Interface for cancelable objects.
 * 
 * @since 5.0
 */
public interface ICancelable {

	/**
	 * Marks the receiver cancelled.
	 */
	void cancel();
}
