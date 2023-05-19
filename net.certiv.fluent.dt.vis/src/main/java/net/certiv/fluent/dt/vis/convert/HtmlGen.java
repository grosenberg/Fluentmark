package net.certiv.fluent.dt.vis.convert;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.commons.text.TextStringBuilder;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.URIUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.TextUtilities;
import org.eclipse.ui.IPathEditorInput;
import org.osgi.framework.Bundle;

import net.certiv.common.log.Log;
import net.certiv.common.util.FsUtil;
import net.certiv.common.util.Strings;
import net.certiv.dsl.core.preferences.consts.Editor;
import net.certiv.dsl.core.util.Resources;
import net.certiv.fluent.dt.core.FluentCore;
import net.certiv.fluent.dt.core.preferences.Prefs;
import net.certiv.fluent.dt.ui.FluentUI;
import net.certiv.fluent.dt.ui.editor.FluentEditor;
import net.certiv.fluent.dt.ui.editor.Partitions;
import net.certiv.fluent.dt.vis.FluentVis;
import net.certiv.fluent.dt.vis.util.LiveUtil;

public class HtmlGen {

	private FluentEditor editor;
	private Converter converter;
	private int linenum;

	public HtmlGen(FluentEditor editor, Converter converter, int linenum) {
		this.editor = editor;
		this.converter = converter;
		this.linenum = linenum;
	}

	/**
	 * Returns the current document content with a header as determined by {@code kind}.
	 *
	 * @param kind defines the intended use of the HTML: for export, for the embedded
	 *             view, or minimal.
	 */
	public String getHtml(Kind kind) {
		IPathEditorInput input = (IPathEditorInput) editor.getEditorInput();
		if (input == null) return Strings.EMPTY;

		IPath loc = editor.getInputDslElement().getResource().getParent().getLocation();
		String basepath = loc.addTrailingSeparator().toString();
		IPath pathname = input.getPath();
		// TODO: restructure/reduce parameters
		return build(kind, gather(basepath), loc, basepath, pathname);
	}

	private String build(Kind kind, String content, IPath loc, String basepath, IPath pathname) {
		TextStringBuilder sb = new TextStringBuilder();
		switch (kind) {
			case UPDATE:
				sb.appendln(content); // body content for WS transfer
				break;

			case EXPORT:
				sb.appendln("<html><head>");
				sb.appendln(Resources.fromBundle(FluentVis.ID, "app/html/meta.html"));
				sb.appendln(Resources.fromBundle(FluentVis.ID, "app/html/highlight.html"));
				if (converter.useMathJax()) {
					sb.appendln(Resources.fromBundle(FluentVis.ID, "app/html/mathjax.html"));
				}
				sb.appendln("<style media='screen' type='text/css'>");
				sb.appendln(getStyle(pathname));
				sb.appendln("</style>");
				sb.appendln("</head><body>");
				sb.appendln(LiveUtil.encodeImages(content, loc.toFile()));
				sb.appendln("</body></html>");
				break;

			case MIN:
				sb.appendln("<html><head>");
				sb.appendln("</head><body>");
				sb.appendln(content);
				sb.appendln("</body></html>");
				break;
		}

		return sb.toString();
	}

	private String gather(String basepath) {
		IDocument doc = editor.getDocument();
		int beg = 0;
		int len = doc.getLength();

		ITypedRegion[] regions;
		try {
			regions = TextUtilities.computePartitioning(doc, Partitions.PARTITIONING, beg, len, false);
		} catch (BadLocationException e) {
			Log.error("Failed to compute partition at %s", beg);
			return Strings.EMPTY;
		}

		return converter.convert(basepath, doc, regions, linenum);
	}

	// path is the searchable base for the style to use; returns the content
	private String getStyle(IPath path) {
		try {
			URL url = findStyle(path);
			return FsUtil.readFromStream(url.openStream());
		} catch (Exception e) {
			Log.error("Failed reading stylesheet", e);
		}
		return Strings.EMPTY;
	}

	private URL findStyle(IPath path) throws Exception {
		// 1) look for a file having the same name as the input file, beginning in the
		// current directory, parent directories, and the current project directory.
		IPath style = path.removeFileExtension().addFileExtension(Editor.CSS);
		URL pathUrl = find(style);
		if (pathUrl != null) return pathUrl;

		// 2) look for a file with the name 'markdown.css' in the same set of
		// directories
		style = path.removeLastSegments(1).append(Prefs.MARKDOWN_CSS);
		pathUrl = find(style);
		if (pathUrl != null) return pathUrl;

		// 3) read the file identified by the pref key 'EDITOR_CSS_EXTERNAL' from the
		// filesystem
		IPreferenceStore store = FluentCore.getDefault().getPrefsManager();
		String customCss = store.getString(Prefs.EDITOR_PREVIEW_EXTERNAL_DIR);
		if (!customCss.isEmpty()) {
			File file = new File(customCss);
			if (file.isFile() && file.getName().endsWith(Editor.DOT_CSS)) {
				return toURL(file);
			}
		}

		// 4) read the file identified by the pref key 'EDITOR_CSS_BUILTIN' from the
		// bundle
		String builtinCss = store.getString(Prefs.EDITOR_PREVIEW_INTERNAL_DIR);
		if (!builtinCss.isEmpty()) {
			try {
				URI uri = new URI(builtinCss.replace(Editor.DOT_CSS, Editor.DOT_MIN_CSS));
				URL url = FileLocator.toFileURL(uri.toURL());
				File file = URIUtil.toFile(URIUtil.toURI(url));
				if (file.isFile()) return url;
			} catch (URISyntaxException e) {
				MessageDialog.openInformation(null, "Default CSS from bundle", builtinCss);
			}
		}

		// 5) read 'markdown.css' from the bundle
		Bundle bundle = Platform.getBundle(FluentUI.PLUGIN_ID);
		URL url = FileLocator.find(bundle, new Path(Prefs.PREVIEW).append(Prefs.MARKDOWN_CSS), null);
		url = FileLocator.toFileURL(url);
		return url;
	}

	private URL find(IPath style) {
		String name = style.lastSegment();
		IPath base = style.removeLastSegments(1);
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IContainer dir = root.getContainerForLocation(base);

		while (dir != null && dir.getType() != IResource.ROOT) {
			IResource member = dir.findMember(name);
			if (member != null) {
				File file = root.getLocation().append(member.getFullPath()).toFile();
				return toURL(file);
			}
			dir = dir.getParent();
		}
		return null;
	}

	private URL toURL(File file) {
		try {
			return file.toURI().toURL();
		} catch (MalformedURLException e) {}
		return null;
	}
}
