/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.actions;

import org.eclipse.jface.action.Action;

import net.certiv.fluentmark.FluentUI;
import net.certiv.fluentmark.FluentMkImages;
import net.certiv.fluentmark.editor.FluentEditor;
import net.certiv.fluentmark.preferences.Prefs;

/**
 * This action toggles whether the outline page links its selection to the active editor.
 */
public class ToggleLinkingAction extends Action {

	private FluentEditor editor;

	public ToggleLinkingAction(FluentEditor editor) {
		super(ActionMessages.getString(ActionMessages.ToggleLinkingAction_label));
		this.editor = editor;

		setDescription(ActionMessages.getString(ActionMessages.ToggleLinkingAction_description));
		setToolTipText(ActionMessages.getString(ActionMessages.ToggleLinkingAction_tooltip));
		FluentUI.getDefault().getImageProvider().setImageDescriptors(this, FluentMkImages.OBJ, FluentMkImages.IMG_MENU_SYNC);

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
