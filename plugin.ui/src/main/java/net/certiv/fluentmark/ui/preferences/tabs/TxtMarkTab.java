package net.certiv.fluentmark.ui.preferences.tabs;

import static net.certiv.fluentmark.core.preferences.Prefs.EDITOR_TXTMARK_EXTENDED;
import static net.certiv.fluentmark.core.preferences.Prefs.EDITOR_TXTMARK_SAFEMODE;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.swt.widgets.Composite;

import net.certiv.dsl.core.preferences.DslPrefsManagerDelta;
import net.certiv.dsl.ui.preferences.pages.IDslPreferencePage;
import net.certiv.dsl.ui.util.SWTFactory;

public class TxtMarkTab extends AbstractTab {

	public TxtMarkTab(IDslPreferencePage page, Composite parent, DslPrefsManagerDelta delta, String title) {
		super(page, parent, title);
	}

	@Override
	protected void createControls(Composite comp) {
		Composite bools = SWTFactory.createComposite(comp, 3, 1);
		addField(new BooleanFieldEditor(EDITOR_TXTMARK_SAFEMODE, "Use safe mode", bools));
		addField(new BooleanFieldEditor(EDITOR_TXTMARK_EXTENDED, "Use extended profile", bools));
	}

	@Override
	public boolean validateSettings() {
		return true;
	}
}
