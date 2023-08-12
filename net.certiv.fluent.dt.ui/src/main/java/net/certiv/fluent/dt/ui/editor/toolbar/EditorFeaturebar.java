package net.certiv.fluent.dt.ui.editor.toolbar;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;

import net.certiv.dsl.core.util.eclipse.PartAdaptor;
import net.certiv.dsl.ui.editor.DslEditor;

/**
 * The editor featurebar provides a space within the active editor window to host feature
 * specific items.
 * <p>
 * Clients must implement the abstract methods.
 */
public abstract class EditorFeaturebar {

	protected static final String ACTIVE_TAB_BG_END = "org.eclipse.ui.workbench.ACTIVE_TAB_BG_END"; //$NON-NLS-1$
	protected static final Color BAR_BG = new Color(227, 227, 227);

	/** Featurebar composite */
	private Composite composite;

	/** Featurebar host editor */
	private DslEditor editor;
	/** Editor part listener */
	private IPartListener partListener;

	/** Featurebar active/shown */
	private boolean active;
	/** Featurebar active/focus */
	private boolean hasFocus;

	/**
	 * Constructor.
	 *
	 * @param editor the hosting editor
	 */
	public EditorFeaturebar(DslEditor editor) {
		setTextEditor(editor);
	}

	public Composite featurebar() {
		return composite;
	}

	public boolean isActive() {
		return active;
	}

	public Composite createFeaturebar(Composite parent) {
		Assert.isTrue(composite == null, "Featurebar must only be created once."); //$NON-NLS-1$

		boolean rtl = (getTextEditor().getSite().getShell().getStyle() & SWT.RIGHT_TO_LEFT) != 0;

		composite = new Composite(parent, rtl ? SWT.RIGHT_TO_LEFT : SWT.NONE);
		composite.setBackground(BAR_BG);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.TOP).grab(true, false).applyTo(composite);
		GridLayoutFactory.fillDefaults().spacing(0, 0).applyTo(composite);

		return composite;
	}

	/**
	 * This toolbar's text editor.
	 *
	 * @return the text editor
	 */
	protected DslEditor getTextEditor() {
		return editor;
	}

	/**
	 * Sets the text editor for this featurebar.
	 *
	 * @param editor the associated text editor
	 */
	protected void setTextEditor(DslEditor editor) {
		this.editor = editor;
		if (editor == null) return;

		partListener = new PartAdaptor() {

			@Override
			public void partActivated(IWorkbenchPart part) {
				if (part == editor) {
					focusGained();
				}
			}

			@Override
			public void partDeactivated(IWorkbenchPart part) {
				if (part == editor) {
					focusLost();
				}
			}
		};
		editor.getSite().getPage().addPartListener(partListener);
	}

	/** Focus has been transfered into the toolbar. */
	private void focusGained() {
		if (hasFocus) focusLost();

		hasFocus = true;
		activateFeaturebar();
	}

	/** Focus has been revoked from the toolbar. */
	private void focusLost() {
		if (!hasFocus) return;

		hasFocus = false;
		deactivateFeaturebar();
	}

	/**
	 * The toolbar has been activated. Implementors must retarget the editor actions to
	 * the toolbar aware actions.
	 */
	protected abstract void activateFeaturebar();

	/**
	 * The toolbar has been deactivated. Implementors must retarget the toolbar actions to
	 * the editor actions.
	 */
	protected abstract void deactivateFeaturebar();

	public void dispose() {
		if (partListener != null) {
			getTextEditor().getSite().getPage().removePartListener(partListener);
		}
		setTextEditor(null);
	}
}
