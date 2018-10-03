package net.certiv.fluentmark.ui.preferences.blocks;

import static net.certiv.fluentmark.core.preferences.Prefs.EDITOR_TXTMARK_EXTENDED;
import static net.certiv.fluentmark.core.preferences.Prefs.EDITOR_TXTMARK_SAFEMODE;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.swt.widgets.Composite;

import net.certiv.dsl.ui.util.SWTFactory;
import net.certiv.fluentmark.ui.preferences.pages.ConvertersPage;

public class TxtmarkConfigBlock extends AbstractConverterBlock {

	public TxtmarkConfigBlock(ConvertersPage page, Composite parent, String title) {
		super(page, parent, title);
	}

	@Override
	protected void createControls(Composite comp) {
		Composite bools = SWTFactory.makeComposite(comp, 3, 1);
		addField(new BooleanFieldEditor(EDITOR_TXTMARK_SAFEMODE, "Use safe mode", bools));
		addField(new BooleanFieldEditor(EDITOR_TXTMARK_EXTENDED, "Use extended profile", bools));
	}

	@Override
	public boolean validateSettings() {
		return true;
	}
}
