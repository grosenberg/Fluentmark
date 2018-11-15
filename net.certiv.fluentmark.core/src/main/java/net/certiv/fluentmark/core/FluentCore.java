package net.certiv.fluentmark.core;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.text.IDocument;
import org.osgi.framework.BundleContext;

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.core.model.ICodeUnit;
import net.certiv.dsl.core.parser.DslSourceParser;
import net.certiv.fluentmark.core.dot.parser.DotSourceParser;
import net.certiv.fluentmark.core.md.parser.MdSourceParser;

public class FluentCore extends DslCore {

	public static final String PLUGIN_ID = "net.certiv.fluentmark.core";
	public static final String[] EXTENSIONS = new String[] { "md", "dot", "mdown", "mkd", "text" };

	// Should be unique, lower case, single word
	public static final String DSL_NAME = "fluent";

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
	public DslSourceParser createSourceParser(ICodeUnit unit, String contentType) {
		switch (contentType) {
			case DOT:
				return new DotSourceParser(unit.getParseRecord());

			case IDocument.DEFAULT_CONTENT_TYPE:
			case MD:
				return new MdSourceParser(unit.getParseRecord());

			default:
				return null;
		}
	}

	@Override
	public IPath importNameToPath(String name) {
		return new Path(name);
	}
}
