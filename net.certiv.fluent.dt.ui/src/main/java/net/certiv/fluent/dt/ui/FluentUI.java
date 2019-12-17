package net.certiv.fluent.dt.ui;

import org.osgi.framework.BundleContext;

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.core.log.Log;
import net.certiv.dsl.core.log.Log.LogLevel;
import net.certiv.dsl.ui.DslUI;
import net.certiv.dsl.ui.editor.text.DslTextTools;
import net.certiv.dsl.ui.templates.CompletionManager;
import net.certiv.fluent.dt.core.FluentCore;
import net.certiv.fluent.dt.ui.editor.FluentEditor;
import net.certiv.fluent.dt.ui.editor.FluentTextTools;

public class FluentUI extends DslUI {

	public static final String PLUGIN_ID = "net.certiv.fluent.dt.ui";

	private static FluentUI plugin;

	private ImageManager imgMgr;
	private DslTextTools textTools;
	private CompletionManager compMgr;

	public FluentUI() {
		super();
		Log.defLevel(LogLevel.Debug);
	}

	public static FluentUI getDefault() {
		return plugin;
	}

	@Override
	public DslUI getDslUI() {
		return plugin;
	}

	@Override
	public DslCore getDslCore() {
		return FluentCore.getDefault();
	}

	@Override
	public void start(BundleContext context) throws Exception {
		plugin = this;
		super.start(context);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		plugin = null;
	}

	@Override
	public String getPluginId() {
		return plugin.getBundle().getSymbolicName();
	}

	@Override
	public ImageManager getImageManager() {
		if (imgMgr == null) {
			imgMgr = new ImageManager();
		}
		return imgMgr;
	}

	@Override
	public DslTextTools getTextTools() {
		if (textTools == null) {
			textTools = new FluentTextTools(true);
		}
		return textTools;
	}

	@Override
	protected String getEditorId() {
		return FluentEditor.EDITOR_ID;
	}

	@Override
	public CompletionManager getCompletionMgr() {
		if (compMgr == null) {
			compMgr = new FluentCompletionManager(this, getEditorId());
		}
		return compMgr;
	}
}
