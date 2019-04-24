package net.certiv.fluent.dt.ui.handlers;

public class ItalicHandler extends AbstractMarksHandler {

	private static final String[] ITALICS = { "*", "_" };

	@Override
	public String[] getMark() {
		return ITALICS;
	}

	@Override
	public boolean qualified(String mark) {
		if (ITALICS[0].equals(mark) || ITALICS[1].equals(mark)) return true;
		return false;
	}
}
