package net.certiv.fluent.dt.ui.editor.toolbar;

import java.util.LinkedHashSet;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.handlers.IHandlerService;

import net.certiv.common.log.Log;
import net.certiv.fluent.dt.ui.FluentUI;
import net.certiv.fluent.dt.ui.ImageManager;
import net.certiv.fluent.dt.ui.editor.FluentEditor;

/**
 * Toolbar for the Fluent editor. Installs into the editor featurebar/interposer
 * composite.
 */
public class FluentEditorToolbar extends EditorFeaturebar implements ISelectionChangedListener {

	private static final String ERR_HANDLER = "Handler failure for %s[%s] %s";
	private static final String TOOL = "TOOL";

	private final LinkedHashSet<ToolItem> items = new LinkedHashSet<>();

	private ToolBar toolbar;
	private ICommandService cmdService;
	private IHandlerService hdlService;

	private ImageManager mgr;

	public FluentEditorToolbar(FluentEditor editor) {
		super(editor);
		mgr = FluentUI.getDefault().getImageManager();
	}

	@Override
	protected void activateFeaturebar() {
		getTextEditor().getSelectionProvider().addSelectionChangedListener(this);
	}

	@Override
	protected void deactivateFeaturebar() {
		getTextEditor().getSelectionProvider().removeSelectionChangedListener(this);
	}

	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		// ISelection sel = event.getSelection();
		// Log.debug("Selection %s [%s]", sel, sel.getClass().getName());
	}

	@Override
	public Composite createFeaturebar(Composite parent) {
		Composite comp = super.createFeaturebar(parent);
		toolbar = new ToolBar(comp, SWT.FLAT);
		toolbar.setBackground(BAR_BG);

		IEditorSite site = getTextEditor().getEditorSite();
		cmdService = site.getService(ICommandService.class);
		hdlService = site.getService(IHandlerService.class);

		separator(toolbar);
		pushItem(toolbar, Tool.BOLD);
		pushItem(toolbar, Tool.ITALIC);
		pushItem(toolbar, Tool.UNDERLINE);
		pushItem(toolbar, Tool.STRIKE);
		separator(toolbar);
		pushItem(toolbar, Tool.CODE);
		pushItem(toolbar, Tool.LINKS);
		// pushItem(toolbar, Tool.QUOTE);
		pushItem(toolbar, Tool.TABLE);
		separator(toolbar);

		return comp;
	}

	public void update() {
		toolbar.layout(true, true);
		toolbar.pack(true);
		featurebar().pack();
		featurebar().requestLayout();
	}

	private void pushItem(ToolBar tb, Tool tool) {
		ToolItem item = new ToolItem(tb, SWT.PUSH);
		items.add(item);
		item.setBackground(BAR_BG);
		item.setData(TOOL, tool);
		item.setImage(mgr.get(tool.img));
		item.setToolTipText(tool.tip());
		item.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent sel) {
				Command cmd = cmdService.getCommand(tool.id());
				ExecutionEvent event = hdlService.createExecutionEvent(cmd, new Event());
				try {
					cmd.executeWithChecks(event);
				} catch (Exception ex) {
					Log.debug(ERR_HANDLER, tool.tip(), tool.id(), ex.getMessage());
				}
			}
		});
	}

	private void separator(ToolBar tb) {
		new ToolItem(toolbar, SWT.SEPARATOR);
	}

	protected ToolItem findItem(Tool tool) {
		if (tool == null) return null;

		for (ToolItem item : items) {
			if (item.getData(TOOL) == tool) return item;
		}
		return null;
	}

	@Override
	public void dispose() {
		deactivateFeaturebar();
		super.dispose();
	}

	private enum Tool implements IToolDef {
		BOLD("net.certiv.fluent.dt.bold", Mgr.IMG_OBJ_BOLD, "Bold"),
		ITALIC("net.certiv.fluent.dt.italic", Mgr.IMG_OBJ_ITALIC, "Italic"),
		STRIKE("net.certiv.fluent.dt.strike", Mgr.IMG_OBJ_STRIKE, "Strike through"),
		UNDERLINE("net.certiv.fluent.dt.underline", Mgr.IMG_OBJ_UNDERLINE, "Underline"),

		LINKS("net.certiv.fluent.dt.links", Mgr.IMG_OBJ_LINK, "Links"),
		CODE("net.certiv.fluent.dt.code", Mgr.IMG_OBJ_CODE, "Code Block"),
		QUOTE("net.certiv.fluent.dt.quote", Mgr.IMG_OBJ_QUOTE, "Quote"),
		TABLE("net.certiv.fluent.dt.table", Mgr.IMG_OBJ_TABLE, "Table"),

		;

		public final String id;
		public final String img;
		public final String tip;

		Tool(String id, String img, String tip) {
			this.id = id;
			this.img = img;
			this.tip = tip;
		}

		@Override
		public String id() {
			return id;
		}

		@Override
		public String img() {
			return img;
		}

		@Override
		public String tip() {
			return tip;
		}
	}
}
