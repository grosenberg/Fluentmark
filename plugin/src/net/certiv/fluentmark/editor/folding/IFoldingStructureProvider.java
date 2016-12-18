package net.certiv.fluentmark.editor.folding;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.ui.texteditor.ITextEditor;

/**
 * Allows the default folding to be supplied by the source viewer.
 */
public interface IFoldingStructureProvider {

	/**
	 * Installs this structure provider on the given editor and viewer.
	 * 
	 * @param editor
	 *        the editor that this provider works on
	 * @param viewer
	 *        the projection viewer that displays the annotations created by this structure provider
	 * @param iPreferenceStore
	 */
	public abstract void install(ITextEditor editor, ProjectionViewer viewer, IPreferenceStore store);

	/**
	 * Uninstalls this structure provider. Any references to editors or viewers should be cleared.
	 */
	public abstract void uninstall();

	/**
	 * (Re-)initializes the structure provided by the receiver.
	 */
	public abstract void initialize();
}
