package net.certiv.fluent.dt.core;

import org.eclipse.jface.text.IDocument;
import org.osgi.framework.BundleContext;

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.core.log.Log;
import net.certiv.dsl.core.log.Log.LogLevel;
import net.certiv.dsl.core.model.ICodeUnit;
import net.certiv.dsl.core.parser.DslSourceParser;
import net.certiv.fluent.dt.core.lang.dot.DotSourceParser;
import net.certiv.fluent.dt.core.lang.md.MdSourceParser;

/** The activator class controls the plug-in life cycle. */
public class FluentCore extends DslCore {

	public static final String PLUGIN_ID = "net.certiv.fluent.dt.core";
	public static final String[] EXTENSIONS = new String[] { "md", "dot", "mdown", "mkd", "text" };

	// Should be unique, lower case, single word;
	public static final String DSL_NAME = "fluent";

	// unique parser language types
	public static final String MD = "md";
	public static final String DOT = "dot";

	public static FluentCore plugin;

	public FluentCore() {
		super();
		Log.defLevel(LogLevel.Debug);
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

	// @Override
	// public DslSourceParser createSourceParser(ICodeUnit unit, String contentType)
	// {
	// if (DSL_NAME.equals(contentType) || getContentTypeId().equals(contentType)) {
	// return new MdSourceParser(unit.getParseRecord());
	// }
	// return null;
	// }
}
