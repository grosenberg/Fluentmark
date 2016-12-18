package net.certiv.fluentmark.handlers;

public class AddVisibleCommentHandler extends AddHiddenCommentHandler {

	@Override
	protected String getCommentStart() {
		return "<!--";
	}

	@Override
	protected String getCommentEnd() {
		return "-->";
	}
}
