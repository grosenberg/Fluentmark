package net.certiv.fluentmark.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.TreeViewer;

import net.certiv.fluentmark.FluentMkUI;
import net.certiv.fluentmark.FluentMkImages;
import net.certiv.fluentmark.editor.FluentMkOutlinePage.OutlineViewer;

public class CollapseAllAction extends Action {

	private TreeViewer viewer;

	public CollapseAllAction(OutlineViewer viewer) {
		super(ActionMessages.CollapseAllAction_0);
		this.viewer = viewer;

		setToolTipText(ActionMessages.CollapseAllAction_1);
		FluentMkUI.getDefault().getImageProvider().setImageDescriptors(this, FluentMkImages.OBJ,
				FluentMkImages.IMG_MENU_COLLAPSE_ALL);
	}

	@Override
	public void run() {
		if (viewer != null) {
			viewer.collapseAll();
		}
	}
}
