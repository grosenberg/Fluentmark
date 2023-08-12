package net.certiv.fluent.dt.ui.handlers;

public class BoldHandler extends AbstractMarksHandler {

	public BoldHandler() {
		super();
		marks.put("**", "**");
		marks.put("__", "__");
	}
}
