package net.certiv.fluentmark.actions;

import org.eclipse.jface.action.Action;

import net.certiv.fluentmark.FluentMkUI;
import net.certiv.fluentmark.FluentMkImages;
import net.certiv.fluentmark.editor.FluentMkEditor;
import net.certiv.fluentmark.preferences.Prefs;

/**
 * This action toggles whether the outline page links its selection to the active editor.
 */
public class ToggleLinkingAction extends Action {

	private FluentMkEditor editor;

	public ToggleLinkingAction(FluentMkEditor editor) {
		super(ActionMessages.getString(ActionMessages.ToggleLinkingAction_label));
		this.editor = editor;

		setDescription(ActionMessages.getString(ActionMessages.ToggleLinkingAction_description));
		setToolTipText(ActionMessages.getString(ActionMessages.ToggleLinkingAction_tooltip));
		FluentMkUI.getDefault().getImageProvider().setImageDescriptors(this, FluentMkImages.OBJ, FluentMkImages.IMG_MENU_SYNC);

		boolean isLinkingEnabled = editor.getPrefsStore().getBoolean(Prefs.EDITOR_OUTLINE_SYNC_ON_CURSOR_MOVE);
		setChecked(isLinkingEnabled);
	}

	/**
	 * Runs the action.
	 */
	@Override
	public void run() {
		editor.getPrefsStore().setValue(Prefs.EDITOR_OUTLINE_SYNC_ON_CURSOR_MOVE, isChecked());
		if (isChecked()) editor.selectionChanged();
	}
}
