package net.certiv.fluent.dt.vis;

import org.apache.logging.log4j.Level;
import org.eclipse.swt.widgets.Display;
import org.osgi.framework.BundleContext;

import net.certiv.common.log.Log;
import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.core.util.CoreUtil;
import net.certiv.dsl.ui.DslImageManager;
import net.certiv.dsl.ui.DslUI;
import net.certiv.dsl.ui.editor.text.DslTextTools;
import net.certiv.dsl.ui.templates.CompletionManager;
import net.certiv.fluent.dt.core.FluentCore;
import net.certiv.fluent.dt.ui.FluentUI;
import net.certiv.fluent.dt.vis.convert.Converter;
import net.certiv.fluent.dt.vis.server.LiveServer;

public class FluentVis extends DslUI {

	public static final String ID = "net.certiv.fluent.dt.vis"; //$NON-NLS-1$

	private static FluentVis plugin;

	private Converter converter;
	private LiveServer srvr;

	public FluentVis() {
		super();
		Log.defLevel(Level.DEBUG);
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;

		converter = new Converter();
		srvr = new LiveServer();

		Display display = CoreUtil.getActiveWorkbenchDisplay();
		display.asyncExec(() -> { srvr.start(); });
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		srvr.stop();
		plugin = null;
		super.stop(context);
	}

	public static FluentVis getDefault() {
		return plugin;
	}

	@Override
	public String getPluginId() {
		return plugin.getBundle().getSymbolicName();
	}

	@Override
	public DslUI getDslUI() {
		return FluentUI.getDefault();
	}

	@Override
	public DslCore getDslCore() {
		return FluentCore.getDefault();
	}

	public LiveServer getLiveServer() {
		return srvr;
	}

	public Converter getConverter() {
		return converter;
	}

	@Override
	public String getEditorId() {
		return FluentUI.getDefault().getEditorId();
	}

	@Override
	public DslImageManager getImageManager() {
		return FluentUI.getDefault().getImageManager();
	}

	@Override
	public DslTextTools getTextTools() {
		return FluentUI.getDefault().getTextTools();
	}

	@Override
	public CompletionManager getCompletionMgr() {
		return null;
	}
}
