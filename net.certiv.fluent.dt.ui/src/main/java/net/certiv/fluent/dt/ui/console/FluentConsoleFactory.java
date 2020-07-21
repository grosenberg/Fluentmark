package net.certiv.fluent.dt.ui.console;

import net.certiv.dsl.ui.console.StyledConsoleFactory;

public class FluentConsoleFactory extends StyledConsoleFactory {

	private static FluentConsoleFactory _factory;

	public static FluentConsoleFactory getFactory() {
		if (_factory == null) {
			_factory = new FluentConsoleFactory();
		}
		return _factory;
	}

	@Override
	public FluentConsole getConsole() {
		return (FluentConsole) super.getConsole();
	}

	@Override
	protected FluentConsole createConsole() {
		return new FluentConsole();
	}
}
