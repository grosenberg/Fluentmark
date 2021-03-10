package net.certiv.fluent.dt.ui.vis.ws;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.SystemUtils;

import net.certiv.common.util.Strings;
import net.certiv.fluent.dt.ui.vis.ws.ex.OperationCanceledException;

public class LiveUtil {

	private LiveUtil() {}

	// public boolean load(FluentEditor editor, boolean firebug) {
	// if (editor == null) return false;
	//
	// IPathEditorInput input = (IPathEditorInput) editor.getEditorInput();
	// if (input == null) return false;
	//
	// if (editor.useMathJax()) {
	// mathjax = true;
	// func = new DoneFunction(browser, "typeset");
	// } else {
	// mathjax = false;
	// func = null;
	// }
	// browser.addProgressListener(watcher);
	// String content = editor.getHtml(Kind.VIEW);
	// if (firebug) {
	// String pluginId = FluentUI.getDefault().getPluginId();
	// String script = Resources.fromBundle(pluginId, Editor.HTML + "/firebug.html")
	// + Strings.EOL;
	// content = content.replaceFirst(_HEAD, script + _HEAD);
	// }
	// browser.setText(content);
	// return true;
	// }
	//
	// protected IStatus run(IProgressMonitor monitor) {
	// FluentEditor editor = view.getEditor();
	// if (editor == null || view == null || browser == null ||
	// browser.isDisposed()) {
	// return Status.CANCEL_STATUS;
	// }
	// timer = System.nanoTime();
	//
	// String html = editor.getHtml(Kind.UPDATE);
	// if (html.trim().isEmpty()) return Status.CANCEL_STATUS;
	//
	// if (mathjax) state = State.READY;
	//
	// // execute script on UI thread
	// Display.getDefault().asyncExec(new Runnable() {
	//
	// @Override
	// public void run() {
	// if (browser != null && !browser.isDisposed()) {
	// String script = String.format(Render,
	// StringEscapeUtils.escapeEcmaScript(html));
	// boolean ok = browser.execute(script);
	// if (!ok) Log.error(this, "Script execute failed.");
	// }
	// }
	// });
	//
	// return Status.OK_STATUS;
	// }

	public static Exception openBrowser(String host, int port, String path) {
		path = path.startsWith(Strings.SLASH) ? path : Strings.SLASH + path;
		return openBrowser(String.format("http://%s:%s%s", host, port, path));
	}

	public static Exception openBrowser(String url) {
		try {
			URL target = new URL(url);
			return openBrowser(target);
		} catch (MalformedURLException e) {
			return new OperationCanceledException(String.format("Bad server URL '%'.", url), e);
		}
	}

	public static Exception openBrowser(URL url) {
		if (Desktop.isDesktopSupported()) {
			try {
				Desktop.getDesktop().browse(url.toURI());
			} catch (IOException | URISyntaxException e) {
				return new OperationCanceledException("Desktop browser open failed.", e);
			}

		} else {
			Runtime runtime = Runtime.getRuntime();
			if (SystemUtils.IS_OS_LINUX) {
				try {
					runtime.exec("xdg-open " + url.toString());
				} catch (IOException e) {
					return new OperationCanceledException("Linux browser open failed.", e);
				}

			} else if (SystemUtils.IS_OS_MAC) {
				try {
					runtime.exec("open " + url.toString());
				} catch (IOException e) {
					return new OperationCanceledException("Mac browser open failed.", e);
				}

			} else {
				return new OperationCanceledException("Unknown system type: browser open failed.");
			}
		}
		return null;
	}

	public void copyToFile(InputStream inputStream, File file) throws IOException {
		try (OutputStream outputStream = new FileOutputStream(file)) {
			IOUtils.copy(inputStream, outputStream);
		}
	}

	public static void extractArchive(Path archive, Path srcRoot) throws IOException {
		Files.createDirectories(srcRoot);
		try (ZipFile zip = new ZipFile(archive.toFile())) {

			// sort entries by name to always create folders first
			List<? extends ZipEntry> entries = zip.stream().sorted(Comparator.comparing(ZipEntry::getName))
					.collect(Collectors.toList());

			// copy each entry in the dest path
			for (ZipEntry entry : entries) {
				Path dstPath = srcRoot.resolve(entry.getName());
				if (entry.isDirectory()) {
					Files.createDirectory(dstPath);
					continue;
				}
				Files.copy(zip.getInputStream(entry), dstPath);
			}
		}
	}
}
