package net.certiv.fluent.dt.ui.preferences.formatter;

import java.net.URL;

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.core.formatter.IDslCodeFormatter;
import net.certiv.dsl.ui.DslUI;
import net.certiv.dsl.ui.formatter.DslFormatterFactory;
import net.certiv.dsl.ui.formatter.IFormatterModifyDialog;
import net.certiv.dsl.ui.formatter.IFormatterModifyDialogOwner;
import net.certiv.fluent.dt.core.FluentCore;
import net.certiv.fluent.dt.core.formatter.FmSourceFormatter;
import net.certiv.fluent.dt.ui.FluentUI;

public class FormatterFactory extends DslFormatterFactory {

	private IDslCodeFormatter formatter;

	public FormatterFactory() {
		super();
	}

	@Override
	public DslUI getDslUI() {
		return FluentUI.getDefault();
	}

	@Override
	public DslCore getDslCore() {
		return FluentCore.getDefault();
	}

	@Override
	public IDslCodeFormatter createFormatter() {
		if (formatter == null) {
			formatter = new FmSourceFormatter();
		}
		return formatter;
	}

	@Override
	public IFormatterModifyDialog createDialog(IFormatterModifyDialogOwner dialogOwner) {
		return new ModifyDialog(dialogOwner, this);
	}

	@Override
	public URL getPreviewContent() {
		return getClass().getResource("FormatPreview.fluent");
	}
}
