package net.certiv.fluent.dt.ui.editor.toolbar;

import net.certiv.fluent.dt.ui.FluentUI;
import net.certiv.fluent.dt.ui.ImageManager;

public interface IToolDef {

	static final ImageManager Mgr = FluentUI.getDefault().getImageManager();

	/** Command id used to invoke tool handler */
	String id();

	/** Toolbar image */
	String img();

	/** Tooltip text */
	String tip();
}
