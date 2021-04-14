package net.certiv.fluent.dt.vis.preferences.blocks;

import java.util.List;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;

import net.certiv.dsl.core.color.DslColorRegistry;
import net.certiv.dsl.core.preferences.PrefsDeltaManager;
import net.certiv.dsl.ui.preferences.blocks.AbstractConfigBlock;
import net.certiv.dsl.ui.preferences.pages.IDslPreferencePage;
import net.certiv.dsl.ui.util.SWTFactory;
import net.certiv.fluent.dt.core.preferences.Prefs;
import net.certiv.fluent.dt.vis.FluentVis;

public class LiveviewConfigBlock extends AbstractConfigBlock {

	public LiveviewConfigBlock(IDslPreferencePage page, PrefsDeltaManager delta, FormToolkit formkit,
			DslColorRegistry reg) {
		super(page, delta, formkit, reg);
	}

	@Override
	protected List<String> createDeltaMatchKeys(List<String> keys) {
		keys.add(Prefs.VIEW_HOST_NAME);
		keys.add(Prefs.VIEW_HOST_PORT);
		keys.add(Prefs.VIEW_WS_CONTEXT);

		keys.add(Prefs.VIEW_CLNT_BASE);
		keys.add(Prefs.VIEW_CLNT_APPL);

		keys.add(Prefs.VIEW_HTML_OPEN);
		keys.add(Prefs.VIEW_PDF_OPEN);

		// keys.add(Prefs.VIEW_UPDATE_DELAY);

		return keys;
	}

	@Override
	public Composite createContents(Composite parent) {
		Composite contents = super.createContents(parent);
		createServerGroup(contents);
		createActionGroup(contents);
		// createUpdateGroup(contents);
		return contents;
	}

	protected Composite createServerGroup(Composite parent) {
		Composite comp = SWTFactory.createGroupComposite(parent, 3, 2, "Liveview Server");
		addTextField(comp, "Server host name", Prefs.VIEW_HOST_NAME, 16, 0).setEditable(false);
		addTextField(comp, "Server host port", Prefs.VIEW_HOST_PORT, 16, 0, FType.INTEGER).setEditable(false);
		addTextField(comp, "Websocket context", Prefs.VIEW_WS_CONTEXT, 16, 0).setEditable(false);
		addTextField(comp, "Client resource path", Prefs.VIEW_CLNT_BASE, 16, 0).setEditable(false);
		addTextField(comp, "Client page", Prefs.VIEW_CLNT_APPL, 16, 0).setEditable(false);
		addButton(comp, "Stop server");
		return comp;
	}

	private void addButton(Composite comp, String label) {
		Button push = SWTFactory.createPushButton(comp, label);
		push.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));

		push.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				FluentVis.getDefault().stopLiveServer();
			}
		});
	}

	protected Composite createActionGroup(Composite parent) {
		Composite comp = SWTFactory.createGroupComposite(parent, 3, 2, "Export Actions");
		addCheckBox(comp, "Open HTML file after creation", Prefs.VIEW_HTML_OPEN, 2, 0);
		addCheckBox(comp, "Open PDF file after creation", Prefs.VIEW_PDF_OPEN, 2, 0);
		return comp;
	}

	// protected Composite createUpdateGroup(Composite parent) {
	// Composite comp = SWTFactory.createGroupComposite(parent, 3, 2, "Update
	// Controls");
	// addTextField(comp, "Update delay (ms) ", Prefs.VIEW_UPDATE_DELAY, 6, 0,
	// FType.INTEGER);
	// return comp;
	// }
}
