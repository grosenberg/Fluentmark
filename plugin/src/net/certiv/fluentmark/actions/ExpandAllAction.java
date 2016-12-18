package net.certiv.fluentmark.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.TreeViewer;

import net.certiv.fluentmark.FluentMkUI;
import net.certiv.fluentmark.FluentMkImages;
import net.certiv.fluentmark.editor.FluentMkOutlinePage.OutlineViewer;

public class ExpandAllAction extends Action {

	private TreeViewer viewer;

	public ExpandAllAction(OutlineViewer viewer) {
		super(ActionMessages.ExpandAllAction_0);
		this.viewer = viewer;

		setToolTipText(ActionMessages.ExpandAllAction_1);
		FluentMkUI.getDefault().getImageProvider().setImageDescriptors(this, FluentMkImages.OBJ,
				FluentMkImages.IMG_MENU_EXPAND_ALL);
	}

	@Override
	public void run() {
		if (viewer != null) {
			viewer.expandAll();
		}
	}
}
