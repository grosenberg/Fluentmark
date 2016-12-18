package net.certiv.fluentmark.editor;

/**
 * An interface for objects accepting an instance of {@link ICancelable}.
 * 
 * @since 5.0
 */
public interface ICanceler {

	/**
	 * Set the cancelable object.
	 * 
	 * @param cancelable the cancelable object
	 */
	void setCancelable(ICancelable cancelable);

}
