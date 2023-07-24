package net.certiv.fluent.dt.ui.editor.toolbar;

import org.eclipse.swt.graphics.Image;

public interface IToolbarItemDef {

	/** Command id */
	String id();

	/** Image */
	Image img();

	/** Tooltip text */
	String tip();
}
