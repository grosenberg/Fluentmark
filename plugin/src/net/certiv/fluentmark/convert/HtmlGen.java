package net.certiv.fluentmark.convert;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.TextUtilities;
import org.eclipse.ui.IPathEditorInput;
import org.osgi.framework.Bundle;

import net.certiv.fluentmark.FluentMkUI;
import net.certiv.fluentmark.Log;
import net.certiv.fluentmark.editor.FluentMkEditor;
import net.certiv.fluentmark.editor.Partitions;
import net.certiv.fluentmark.preferences.Prefs;
import net.certiv.fluentmark.util.FileUtils;
import net.certiv.fluentmark.util.Strings;

public class HtmlGen {

	private static final String Update = "<html><head>" + Strings.EOL + "<title>%s</title>" + Strings.EOL
			+ "</head><body>" + Strings.EOL + "%s" + Strings.EOL + "</body></html>";

	private FluentMkEditor editor;
	private FluentMkConverter converter;

	public HtmlGen(FluentMkEditor editor, FluentMkConverter converter) {
		this.editor = editor;
		this.converter = converter;
	}

	/**
	 * Gets the current document html content with a header as determined by HtmlKind.
	 * 
	 * @param hdr defines the intended use of the HTML: for export, for the embedded view, or minimal.
	 */
	public String getPage(HtmlKind hdr) {
		IPathEditorInput input = (IPathEditorInput) editor.getEditorInput();
		return addHeader(hdr, convert(), input.getPath());
	}

	/**
	 * Gets the current document html content with a header containing only the title. Intended only for
	 * React updates of the body content.
	 */
	public String getUpdate() {
		IPathEditorInput input = (IPathEditorInput) editor.getEditorInput();
		if (input == null) return "";

		String title = input.getPath().toString();
		return String.format(Update, title, convert().trim());
	}

	private String convert() {
		IDocument doc = editor.getDocument();
		int beg = 0;
		int len = doc.getLength();

		// check for and skip front matter
		ITypedRegion region;
		try {
			region = TextUtilities.getPartition(editor.getDocument(), Partitions.MK_PARTITIONING, beg, true);
		} catch (BadLocationException e) {
			Log.error("Failed to get partition at offset: " + beg);
			return "";
		}
		if (region.getType().equals(Partitions.FRONT_MATTER)) {
			beg += region.getLength();
			len -= region.getLength();
		}

		try {
			String text = editor.getDocument().get(beg, len);
			return converter.convert(text);
		} catch (BadLocationException e) {
			Log.error("Bad front matter exclusion: " + beg + ":" + len + "; " + region.getLength());
			return "";
		}
	}

	private String addHeader(HtmlKind hdr, String html, IPath path) {
		StringBuilder sb = new StringBuilder("<html><head>" + Strings.EOL);

		if (hdr != HtmlKind.MIN) {
			String highlight = FileUtils.fromBundle("resources/highlight.html");
			sb.append(highlight + Strings.EOL);

			if (editor.useMathJax()) {
				String jax = FileUtils.fromBundle("resources/mathjax.html");
				sb.append(jax + Strings.EOL);
			}

			if (hdr == HtmlKind.VIEW) {
				// String react = FileUtils.fromBundle("resources/react.html");
				// sb.append(react + Strings.EOL);
				//
				// String reactor = FileUtils.fromBundle("resources/js/reactor.js");
				// sb.append("<script type=\"text/javascript\">" + Strings.EOL);
				// sb.append(reactor + Strings.EOL);
				// sb.append("</script>" + Strings.EOL);

				if (path != null) {
					String docPath = path.removeLastSegments(1).toString();
					sb.append("<base href=\"" + docPath + "/\">" + Strings.EOL);
				}
			}

			if (path != null) {
				try {
					String stylesPathname = getStyles(path);
					String stylesheet = FileUtils.read(new File(stylesPathname));
					sb.append("<style media=\"screen\" type=\"text/css\">" + Strings.EOL);
					sb.append(stylesheet + Strings.EOL);
					sb.append("</style>" + Strings.EOL);
				} catch (RuntimeException e) {
					Log.error("Failed reading stylesheet", e);
				}
			}
		}

		sb.append("</head><body>" + Strings.EOL);
		sb.append(html + Strings.EOL);

		if (hdr == HtmlKind.VIEW) {
			sb.append(FileUtils.fromBundle("resources/react.html") + Strings.EOL);
			sb.append("<script type=\"text/javascript\">" + Strings.EOL);
			sb.append(FileUtils.fromBundle("resources/js/reactor.min.js") + Strings.EOL);
			sb.append("</script>" + Strings.EOL);
		}

		sb.append("</body></html>");
		return sb.toString();
	}

	private String getStyles(IPath path) {
		// 1) look for a file having the same name as the input file, beginning in the
		// current directory, parent directories, and the current project directory.
		IPath styles = path.removeFileExtension().addFileExtension(Prefs.CSS);
		String pathname = find(styles);
		if (pathname != null) return pathname;

		// 2) look for a file with the name 'markfluent.css' in the same set of directories
		styles = path.removeLastSegments(1).append(Prefs.CSS_DEFAULT);
		pathname = find(styles);
		if (pathname != null) return pathname;

		// 3) read the file identified by the pref key 'EDITOR_CSS_CUSTOM' from the filesystem
		IPreferenceStore store = FluentMkUI.getDefault().getPreferenceStore();
		String customCss = store.getString(Prefs.EDITOR_CSS_CUSTOM);
		if (!customCss.isEmpty()) {
			File file = new File(customCss);
			if (file.isFile() && file.getName().endsWith("." + Prefs.CSS)) {
				return customCss;
			}
		}

		// 4) read the file identified by the pref key 'EDITOR_CSS_DEFAULT' from the bundle
		String defaultCss = store.getString(Prefs.EDITOR_CSS_DEFAULT);
		if (!defaultCss.isEmpty()) {
			try {
				URI uri = new URI(defaultCss);
				File file = new File(uri);
				if (file.isFile()) return file.getPath();
			} catch (URISyntaxException e) {
				MessageDialog.openInformation(null, "Default CSS from bundle", defaultCss);
			}
		}

		// 5) read 'markdown.css' from the bundle
		Bundle bundle = Platform.getBundle(FluentMkUI.PLUGIN_ID);
		URL url = FileLocator.find(bundle, new Path(Prefs.CSS_RESOURCE_DIR + Prefs.CSS_DEFAULT), null);
		try {
			url = FileLocator.toFileURL(url);
			return url.toURI().toString();
		} catch (IOException | URISyntaxException e) {
			Log.error(e);
			return null;
		}
	}

	private String find(IPath styles) {
		String name = styles.lastSegment();
		IPath base = styles.removeLastSegments(1);

		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IContainer dir = root.getContainerForLocation(base);

		while (dir != null && dir.getType() != IResource.ROOT) {
			IResource member = dir.findMember(name);
			if (member != null) {
				return root.getLocation().append(member.getFullPath()).toFile().toURI().toString();
			}
			dir = dir.getParent();
		}
		return null;
	}
}
