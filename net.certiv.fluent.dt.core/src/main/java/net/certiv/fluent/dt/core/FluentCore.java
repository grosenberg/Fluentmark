package net.certiv.fluent.dt.core;

import org.apache.logging.log4j.Level;
import org.osgi.framework.BundleContext;

import net.certiv.common.log.Log;
import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.core.lang.LanguageManager;
import net.certiv.fluent.dt.core.lang.FluentLangManager;

public class FluentCore extends DslCore {

	public static FluentCore plugin;

	private FluentLangManager langMgr;

	public FluentCore() {
		super();
		Log.defLevel(Level.INFO);
	}

	public static FluentCore getDefault() {
		return plugin;
	}

	@Override
	public DslCore getDslCore() {
		return this;
	}

	@Override
	public void start(BundleContext context) throws Exception {
		plugin = this;
		super.start(context);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	@Override
	public String getPluginId() {
		return getDefault().getBundle().getSymbolicName();
	}

	@Override
	public LanguageManager getLangManager() {
		if (langMgr == null) {
			langMgr = new FluentLangManager(this);
		}
		return langMgr;
	}
}
