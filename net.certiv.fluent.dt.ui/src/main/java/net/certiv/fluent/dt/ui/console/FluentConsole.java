package net.certiv.fluent.dt.ui.console;

import java.util.List;

import net.certiv.dsl.core.console.CS;
import net.certiv.dsl.core.console.ConsoleRecordFactory.ConsoleRecord;
import net.certiv.dsl.ui.console.StyledConsole;
import net.certiv.fluent.dt.core.console.Aspect;
import net.certiv.fluent.dt.ui.FluentUI;

public class FluentConsole extends StyledConsole {

	public static final String CONSOLE_TYPE = "antlr_console"; //$NON-NLS-1$

	public FluentConsole() {
		super(FluentUI.getDefault(), "AntlrDT Console", CONSOLE_TYPE, null, true);
	}

	@Override
	public void append(List<ConsoleRecord> records, boolean clear) {
		super.append(records, clear);
		append(Aspect.GENERAL, CS.NORMAL, null, "%s\n", BREAK);
	}
}
