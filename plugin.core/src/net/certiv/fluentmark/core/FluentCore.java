package net.certiv.fluentmark.core;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.osgi.framework.BundleContext;

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.core.parser.DslSourceParser;
import net.certiv.fluentmark.core.dot.parser.DotSourceParser;
import net.certiv.fluentmark.core.md.parser.MdSourceParser;

public class FluentCore extends DslCore {

	public static final String PLUGIN_ID = "net.certiv.fluentmark.core";
	public static final String[] EXTENSIONS = new String[] { "md", "dot", "mdown", "mkd", "text" };

	// unique parser language types
	public static final String MD = "md";
	public static final String DOT = "dot";

	private static FluentCore plugin;

	public FluentCore() {
		super();
	}

	public static FluentCore getDefault() {
		return plugin;
	}

	@Override
	public DslCore getDslCore() {
		return plugin;
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
		return getDefault().getBundle().getSymbolicName();
	}

	@Override
	public String[] getDslFileExtensions() {
		return EXTENSIONS;
	}

	@Override
	public DslSourceParser createSourceParser(String type) {
		switch (type) {
			case DOT:
				return new DotSourceParser();
			case MD:
				return new MdSourceParser();
			default:
				return null;
		}
	}

	@Override
	public String getProblemMakerId(String type) {
		return getPluginId() + String.format(".%s_marker", type);
	}

	@Override
	public IPath convertImport(IPath container, String name) {
		IPath path = new Path(name);
		String ext = path.getFileExtension();
		if (ext == null) {
			path = path.append("." + EXTENSIONS[0]);
		}
		if (!path.isAbsolute() && container != null) {
			path = container.append(path);
		}
		return path;
	}
}
