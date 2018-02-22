package net.certiv.fluentmark.preferences.pages;

import static net.certiv.fluentmark.preferences.Prefs.EDITOR_TXTMARK_EXTENDED;
import static net.certiv.fluentmark.preferences.Prefs.EDITOR_TXTMARK_SAFEMODE;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.swt.widgets.Composite;

import net.certiv.fluentmark.preferences.AbstractOptionsBlock;
import net.certiv.fluentmark.util.SwtUtil;

public class ConverterTxtmarkOps extends AbstractOptionsBlock {

	public ConverterTxtmarkOps(PrefPageConvert page, Composite parent, String title) {
		super(page, parent, title);
	}

	@Override
	protected void createControls(Composite comp) {
		Composite bools = SwtUtil.makeComposite(comp, 3, 1);
		addField(new BooleanFieldEditor(EDITOR_TXTMARK_SAFEMODE, "Use safe mode", bools));
		addField(new BooleanFieldEditor(EDITOR_TXTMARK_EXTENDED, "Use extended profile", bools));
	}

	@Override
	public boolean validateSettings() {
		return true;
	}
}
