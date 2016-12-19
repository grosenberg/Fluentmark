package net.certiv.fluentmark.handlers;

public class ToggleVisibleCommentHandler extends ToggleHiddenCommentHandler {

	@Override
	protected String getCommentBeg() {
		return VISIBLE_BEG;
	}

	@Override
	protected String getCommentEnd() {
		return VISIBLE_END;
	}
}
