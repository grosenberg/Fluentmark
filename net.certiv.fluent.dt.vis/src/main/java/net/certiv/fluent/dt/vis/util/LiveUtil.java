package net.certiv.fluent.dt.vis.util;

import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.SystemUtils;
import org.eclipse.core.runtime.Path;

import net.certiv.common.log.Log;
import net.certiv.common.util.FsUtil;
import net.certiv.common.util.Maths;
import net.certiv.common.util.Strings;
import net.certiv.dsl.core.preferences.PrefsManager;
import net.certiv.dsl.core.util.Resources;
import net.certiv.fluent.dt.core.preferences.Prefs;
import net.certiv.fluent.dt.vis.FluentVis;
import net.certiv.fluent.dt.vis.ex.OperationCanceledException;

public class LiveUtil {

	private static final String CLIENT_ZIP = "liveview/client.zip";
	private static final String ErrRes = "Invalid static resource for '%s' (%s).";
	private static final String ErrZip = "Failed to copy client '%s' -> '%s'.";

	private static final String HTTPS = "http://%s:%s/%s";
	private static final String DATA64 = "data:image/%s;base64,%s";

	private static final String IMG_TAG1 = "(<img\\s.*?src\\s*=\\s*')(.*?)('.*?>)";
	private static final String IMG_TAG2 = "(<img\\s.*?src\\s*=\\s*\")(.*?)(\".*?>)";

	private static final Pattern IMG_P1 = Pattern.compile(IMG_TAG1, Pattern.DOTALL);
	private static final Pattern IMG_P2 = Pattern.compile(IMG_TAG2, Pattern.DOTALL);

	private LiveUtil() {}

	/**
	 * Incorporate images identified by relative paths within the given Html content
	 * as base64 encoded data. The relative paths are evaluated as relative to the
	 * given loc directory.
	 *
	 * @param content html content
	 * @param loc source directory
	 */
	public static String encodeImages(String content, File loc) {
		String results = content;
		for (Pattern pat : Arrays.asList(IMG_P1, IMG_P2)) {
			StringBuilder sb = new StringBuilder();
			Matcher m = pat.matcher(results);
			while (m.find()) {
				String beg = m.group(1);
				String ref = m.group(2);
				String end = m.group(3);

				Path imgpath = new Path(ref);
				if (!imgpath.isAbsolute()) {
					File img = new File(loc, ref);
					try {
						img = img.getCanonicalFile();
						if (img.isFile()) {
							String ext = FilenameUtils.getExtension(img.getName());
							try (InputStream is = new FileInputStream(img)) {
								byte[] bytes = IOUtils.toByteArray(is);
								String data = Base64.getEncoder().encodeToString(bytes);
								data = String.format(DATA64, ext, data);
								m.appendReplacement(sb, beg + data + end);
							}

						} else {
							sb.append(m.group(0));
							Log.error(LiveUtil.class, "Image '%s' does not exist.", img);
						}

					} catch (IOException e) {
						sb.append(m.group(0));
						Log.error(LiveUtil.class, "Image encode failed '%s': %s", img, e.getMessage());
					}

				} else {
					sb.append(m.group(0));
				}
			}
			m.appendTail(sb);
			results = sb.toString();
		}
		return results;
	}

	/**
	 * Copy images identified by relative paths within the given content from under
	 * the given loc directory to under the given base directory.
	 *
	 * @param content html content
	 * @param loc source directory
	 * @param base destination directory
	 */
	public static void rebaseImages(String content, File loc, File base) {
		for (Pattern pat : Arrays.asList(IMG_P1, IMG_P2)) {
			Matcher m = pat.matcher(content);
			while (m.find()) {
				String ref = m.group(2);
				Path imgpath = new Path(ref);
				if (!imgpath.isAbsolute()) {
					File img = new File(loc, ref);
					File dst = new File(base, ref);
					try {
						img = img.getCanonicalFile();
						if (!img.isFile()) {
							Log.error(LiveUtil.class, "Image '%s' does not exist.", img);
							continue;
						}

						dst = dst.getCanonicalFile();
						dst.getParentFile().mkdirs();
						if (dst.isFile()) Log.warn(LiveUtil.class, "Replacing image '%s'", dst);

						Files.copy(img.toPath(), dst.toPath(), StandardCopyOption.REPLACE_EXISTING);

					} catch (IOException e) {
						Log.error(LiveUtil.class, "Image copy failed '%s' -> '%s'", img, dst);
					}
				}
			}
		}
	}

	/**
	 * Extract the client application from the client.zip.
	 * <p>
	 * extracts "<bundle>/liveview/client.zip" to "tmp/liveview/client.zip"
	 * <p>
	 * extracts "tmp/liveview/client.zip" to "tmp/liveview/app..."
	 * <p>
	 * returns the File for "tmp/liveview/app" or {@code null}
	 *
	 * @return the File of the static resource directory or {@code null}
	 */
	public static File extractClient() {
		PrefsManager mgr = FluentVis.getDefault().getPrefsManager();
		String wctx = mgr.getString(Prefs.VIEW_WS_CONTEXT);
		String base = mgr.getString(Prefs.VIEW_CLNT_BASE);
		String appl = mgr.getString(Prefs.VIEW_CLNT_APPL);

		try {
			// create "tmp/liveview"
			File root = FsUtil.createTmpFolder(wctx);
			FsUtil.deleteTmpFolderOnExit(root);

			// copy "<bundle>/liveview/client.zip" to "tmp/liveview/client.zip"
			File zip = Resources.fromBundle(FluentVis.ID, CLIENT_ZIP, root);
			if (zip == null) throw new IllegalArgumentException(String.format(ErrZip, CLIENT_ZIP, root));

			// extract "tmp/liveview/client.zip" to "tmp/liveview/app..."
			File dst = new File(root, base);
			Resources.expandZip(zip, dst);

			// verify existance of "tmp/liveview/app/index.html"
			File file = new File(dst, appl);
			if (!file.isFile()) throw new IOException(String.format("Failed to create '%s/%s'", dst, appl));
			return dst;

		} catch (Exception e) {
			Log.error(LiveUtil.class, ErrRes, wctx, e.getMessage());
			return null;
		}
	}

	/**
	 * Returns the web address of a unique instance of the client application.
	 *
	 * @param base dir containing the default client application
	 * @return web address of the unique client application instance
	 */
	public static File prepUniqueAppl(File base, String appl) {
		try {
			File tmpl = new File(base, appl);
			String content = FsUtil.readToString(tmpl);
			// content = content.replace(BASE_DEF, String.format(BASE_ACT, loc));
			// content = content.replace(WS_DEF, String.format(WS_ACT, host, port, cntx));

			File page = new File(base, ran(appl));
			FsUtil.write(page, content);
			return page;

		} catch (Exception e) {
			Log.error(LiveUtil.class, "Failed creating unique %s: %s", appl, e.getMessage());
			return null;
		}
	}

	public static String prepUniqueAddr(String host, int port, String name) {
		return String.format(HTTPS, host, port, name);
	}

	// create unique appl name
	private static String ran(String appl) {
		int num = Maths.nextRandom(999);
		return appl.replace(Strings.DOT, String.format("-%04d.", num));
	}

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
		if (url == null) return new OperationCanceledException("Invalid browser URL: null.");

		if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
			try {
				Desktop.getDesktop().browse(url.toURI());
			} catch (IOException | URISyntaxException e) {
				return new OperationCanceledException("Desktop browser open failed.", e);
			}

		} else {
			Runtime runtime = Runtime.getRuntime();
			if (SystemUtils.IS_OS_WINDOWS) {
				try {
					runtime.exec(new String[] { "rundll32", "url.dll,FileProtocolHandler", url.toString() });
				} catch (IOException e) {
					return new OperationCanceledException("Windows browser open failed.", e);
				}

			} else if (SystemUtils.IS_OS_LINUX || SystemUtils.IS_OS_UNIX) {
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
}
