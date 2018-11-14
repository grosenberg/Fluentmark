package net.certiv.fluentmark.ui.preferences.tabs;

import static net.certiv.fluentmark.core.preferences.Prefs.EDITOR_UMLMODE_ENABLED;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.swt.widgets.Composite;

import net.certiv.dsl.core.preferences.DslPrefsManagerDelta;
import net.certiv.dsl.ui.preferences.pages.IDslPreferencePage;
import net.certiv.dsl.ui.util.SWTFactory;

public class UmlTab extends AbstractTab {

	private BooleanFieldEditor umlEn;

	public UmlTab(IDslPreferencePage page, Composite parent, DslPrefsManagerDelta delta, String title) {
		super(page, parent, title);
	}

	@Override
	protected void createControls(Composite comp) {
		Composite bools = SWTFactory.createComposite(comp, 3, 1);
		umlEn = new BooleanFieldEditor(EDITOR_UMLMODE_ENABLED, "Enable PlantUML diagram generator", bools);
		addField(umlEn);

	}

	@Override
	public boolean validateSettings() {
		return true;
	}
}
