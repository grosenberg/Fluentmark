package net.certiv.fluent.dt.ui.preferences.formatter;

import java.net.URL;

import org.eclipse.swt.widgets.Composite;

import net.certiv.fluent.dt.core.FluentCore;
import net.certiv.fluent.dt.ui.FluentUI;

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.core.preferences.consts.Formatter;
import net.certiv.dsl.ui.DslUI;
import net.certiv.dsl.ui.formatter.FormatterModifyTabPage;
import net.certiv.dsl.ui.formatter.IFormatterModifyDialog;
import net.certiv.dsl.ui.preferences.bind.IControlCreationManager;

public class TabBlankLines extends FormatterModifyTabPage {

	public TabBlankLines(IFormatterModifyDialog dialog) {
		super(dialog);
	}

	@Override
	protected void createOptions(final IControlCreationManager manager, Composite parent) {

		Composite blanks = createOptionGroup(parent, "Blank Lines", 2);

		manager.createNumber(blanks, bind(Formatter.FORMATTER_EMPTY_LINES_TO_PRESERVE), "Blank lines to preserve: ");
		manager.createNumber(blanks, bind(Formatter.FORMATTER_EMPTY_LINES_AFTER_TERMINAL),
				"Required blank lines after terminal: ");
	}

	@Override
	protected URL getPreviewContent() {
		return getClass().getResource("BlankLinesPreview.fluent"); //$NON-NLS-1$
	}

	@Override
	public DslUI getDslUI() {
		return FluentUI.getDefault();
	}

	@Override
	public DslCore getDslCore() {
		return FluentCore.getDefault();
	}
}
