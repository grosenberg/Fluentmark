package net.certiv.fluentmark.editor;

/**
 * Interface of an object listening to reconciling.
 */
public interface IReconcilingListener {

	/**
	 * Called after reconciling has been finished.
	 */
	void reconciled();
}
