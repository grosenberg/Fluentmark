package net.certiv.fluent.dt.ui.handlers;

public class StrikeHandler extends AbstractMarksHandler {

	public StrikeHandler() {
		super();
		marks.put("<s>", "</s>");
		marks.put("<del>", "</del>");
		marks.put("~~", "~~");
	}
}
