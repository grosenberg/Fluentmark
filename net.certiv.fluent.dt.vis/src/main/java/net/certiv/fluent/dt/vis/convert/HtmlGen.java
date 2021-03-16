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
import net.certiv.common.util.FileUtils;
import net.certiv.common.util.Strings;
import net.certiv.dsl.core.preferences.PrefsManager;
import net.certiv.dsl.core.preferences.consts.Editor;
import net.certiv.dsl.core.util.Resources;
import net.certiv.fluent.dt.core.FluentCore;
import net.certiv.fluent.dt.core.preferences.Prefs;
import net.certiv.fluent.dt.ui.FluentUI;
import net.certiv.fluent.dt.ui.editor.FluentEditor;
import net.certiv.fluent.dt.ui.editor.Partitions;
import net.certiv.fluent.dt.vis.FluentVis;

/**
 * Generate Html files for:
 * <ul>
 * <li>View
 * <ul>
 * <li>Base html to be loaded to the browser
 * <li>Body to be updated to the base
 * </ul>
 * <li>Export
 * <ul>
 * <li>Full, self contanied Html document
 * <li>Minimal Html document
 * </ul>
 * </ul>
 */
public class HtmlGen {

	private FluentEditor editor;
	private Converter converter;

	public HtmlGen(FluentEditor editor, Converter converter) {
		this.editor = editor;
		this.converter = converter;
	}

	/**
	 * Gets the current document content with a header as determined by item.
	 *
	 * @param item defines the intended use of the HTML: for export, for the
	 *            embedded view, or minimal.
	 */
	public String getHtml(Kind kind) {
		IPathEditorInput input = (IPathEditorInput) editor.getEditorInput();
		if (input == null) return Strings.EMPTY;

		IPath pathname = input.getPath();
		String basepath = pathname.removeLastSegments(1).addTrailingSeparator().toString();
		return build(kind, convert(basepath), basepath, pathname);
	}

	private String build(Kind kind, String content, String base, IPath pathname) {
		TextStringBuilder sb = new TextStringBuilder();
		switch (kind) {
			case EXPORT:
				sb.appendln("<html><head>");
				sb.appendln(Resources.fromBundle(FluentVis.ID, "app/html/meta.html"));
				sb.appendln(Resources.fromBundle(FluentVis.ID, "app/html/highlight.html"));
				if (converter.useMathJax()) {
					sb.appendln(Resources.fromBundle(FluentVis.ID, "app/html/mathjax.html"));
				}
				sb.appendln("<style media=\"screen\" type=\"text/css\">");
				sb.appendln(getStyle(pathname));
				sb.appendln("</style>");
				sb.appendln("</head><body>");
				sb.appendln(content);
				sb.appendln("</body></html>");
				break;

			case MIN:
				sb.appendln("<html><head>");
				sb.appendln("</head><body>");
				sb.appendln(content);
				sb.appendln("</body></html>");
				break;

			case VIEW:
				String preview = Resources.fromBundle(FluentVis.ID, "app/html/liveview.html");
				preview = preview.replaceFirst("%path%", base);
				preview = preview.replaceFirst("%styles%", getStyle(pathname));
				preview = preview.replaceFirst("%socket%", getSocket());
				sb.appendln(preview);
				break;

			case UPDATE:
				sb.appendln(content);
				break;
		}

		return sb.toString();
	}

	private String getSocket() {
		PrefsManager mgr = editor.getPrefsMgr();
		String host = mgr.getString(Prefs.VIEW_HOST_NAME);
		int port = mgr.getInt(Prefs.VIEW_HOST_PORT);
		String path = mgr.getString(Prefs.VIEW_WS_CONTEXT);
		return String.format("ws://%s:%s/%s", host, port, path);
	}

	private String convert(String basepath) {
		IDocument doc = editor.getDocument();
		int beg = 0;
		int len = doc.getLength();

		ITypedRegion[] regions;
		try {
			regions = TextUtilities.computePartitioning(doc, Partitions.PARTITIONING, beg, len, false);
		} catch (BadLocationException e) {
			Log.error(this, "Failed to compute partition at %s", beg);
			return Strings.EMPTY;
		}

		return converter.convert(basepath, doc, regions);
	}

	// path is the searchable base for the style to use; returns the content
	private String getStyle(IPath path) {
		try {
			URL url = findStyle(path);
			return FileUtils.readFromStream(url.openStream());
		} catch (Exception e) {
			Log.error(this, "Failed reading stylesheet", e);
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
