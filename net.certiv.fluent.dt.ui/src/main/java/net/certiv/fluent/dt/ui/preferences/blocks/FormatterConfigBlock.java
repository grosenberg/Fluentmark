package net.certiv.fluent.dt.ui.preferences.blocks;

import java.util.List;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.widgets.FormToolkit;

import net.certiv.dsl.core.color.DslColorRegistry;
import net.certiv.dsl.core.preferences.PrefsDeltaManager;
import net.certiv.dsl.ui.preferences.blocks.AbstractConfigBlock;
import net.certiv.dsl.ui.preferences.pages.IDslPreferencePage;
import net.certiv.dsl.ui.util.SWTFactory;
import net.certiv.fluent.dt.core.preferences.Prefs;

public class FormatterConfigBlock extends AbstractConfigBlock {

	public FormatterConfigBlock(IDslPreferencePage page, PrefsDeltaManager delta, FormToolkit formkit,
			DslColorRegistry reg) {
		super(page, delta, formkit, reg);
	}

	@Override
	protected List<String> createDeltaMatchKeys(List<String> keys) {
		keys.add(Prefs.FORMATTER_ENABLED);
		keys.add(Prefs.FORMATTER_ON_SAVE);

		return keys;
	}

	@Override
	public Composite createContents(Composite parent) {
		Composite comp = super.createContents(parent);
		Button fmt = addCheckBox(comp, "Enable Formatting", Prefs.FORMATTER_ENABLED, 3, 0);

		Composite options = SWTFactory.createComposite(comp, 2, 2, 4);
		addCheckBox(options, "Format on save", Prefs.FORMATTER_ON_SAVE, 3, 0);

		fmt.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				enableOptions(fmt, options);
			}
		});

		enableOptions(fmt, options);
		return comp;
	}

	public void enableOptions(Button fmt, Composite options) {
		boolean state = fmt.getSelection();
		enableControls(options, state);
	}

	protected void enableControls(Composite comp, boolean enable) {
		for (Control control : comp.getChildren()) {
			if (control instanceof Composite) {
				enableControls((Composite) control, enable);
			} else {
				control.setEnabled(enable);
			}
		}
	}
}
