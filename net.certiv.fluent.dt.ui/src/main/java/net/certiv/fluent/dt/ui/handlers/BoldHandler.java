package net.certiv.fluent.dt.ui.handlers;

public class BoldHandler extends AbstractMarksHandler {

	private static final String[] BOLDS = { "**", "__" };

	@Override
	public String[] getMark() {
		return BOLDS;
	}

	@Override
	public boolean qualified(String mark) {
		if (BOLDS[0].equals(mark) || BOLDS[1].equals(mark)) return true;
		return false;
	}
}
