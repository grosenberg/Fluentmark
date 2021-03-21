package net.certiv.fluent.dt.vis;

import java.io.File;

import org.apache.logging.log4j.Level;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.BundleContext;

import net.certiv.common.log.Log;
import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.core.preferences.PrefsManager;
import net.certiv.dsl.ui.DslImageManager;
import net.certiv.dsl.ui.DslUI;
import net.certiv.dsl.ui.editor.text.DslTextTools;
import net.certiv.dsl.ui.templates.CompletionManager;
import net.certiv.fluent.dt.core.FluentCore;
import net.certiv.fluent.dt.core.preferences.Prefs;
import net.certiv.fluent.dt.ui.FluentUI;
import net.certiv.fluent.dt.ui.editor.FluentEditor;
import net.certiv.fluent.dt.vis.convert.Converter;
import net.certiv.fluent.dt.vis.server.LiveServer;
import net.certiv.fluent.dt.vis.util.LiveUtil;

public class FluentVis extends DslUI {

	public static final String ID = "net.certiv.fluent.dt.vis"; //$NON-NLS-1$

	private static FluentVis plugin;

	private final LiveServer srvr = new LiveServer();
	private final Converter converter = new Converter();

	public FluentVis() {
		super();
		Log.defLevel(Level.DEBUG);
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		startLiveServer();
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		stopLiveServer();
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
		return FluentVis.getDefault();
	}

	@Override
	public DslCore getDslCore() {
		return FluentCore.getDefault();
	}

	public Converter getConverter() {
		return converter;
	}

	/** Start, or restart, the Live server. */
	public void startLiveServer() {
		PlatformUI.getWorkbench().getDisplay().asyncExec(() -> {
			Log.debug(this, "Liveserver starting...");
			srvr.start();
			Log.debug(this, "Liveserver started.");
		});
	}

	public void stopLiveServer() {
		srvr.stop();
		Log.debug(this, "Server stopped: %s", srvr.isStopped());
	}

	public boolean isLiveServerRunning() {
		return srvr.isRunning();
	}

	public boolean isLiveServerStopped() {
		return srvr.isStopped();
	}

	/**
	 * Return the effective Web page address representing the content of the given
	 * editor.
	 * <p>
	 * The server, on startup, will create a fresh copy of the client application.
	 *
	 * <pre>
	 * {tmp}/liveview/client.zip
	 * {tmp}/liveview/app/index.html
	 * {tmp}/liveview/app/assets/...
	 * </pre>
	 *
	 * On opening a new live view page, the handler will create a new, unique index
	 * page.
	 *
	 * <pre>
	 * {tmp}/liveview/app/indexXXXX.html
	 * {tmp}/liveview/app/<page local external resources>   <-- ripe for conflicts
	 * </pre>
	 */
	public String prepUniqueAppl(FluentEditor editor) {
		PrefsManager mgr = getPrefsManager();
		String host = mgr.getString(Prefs.VIEW_HOST_NAME);
		int port = mgr.getInt(Prefs.VIEW_HOST_PORT);
		String appl = mgr.getString(Prefs.VIEW_CLNT_APPL);

		File base = srvr.getResourceBase();
		String appx = LiveUtil.prepUniqueAppl(base, appl).getName();
		String addr = LiveUtil.prepUniqueAddr(host, port, appx);

		String target = editor.getInputDslElement().getPackageName();
		srvr.createSessionEntry(target, editor, base);

		return addr;
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
