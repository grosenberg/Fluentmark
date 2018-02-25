/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.util;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.LinkedHashMap;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.URIUtil;
import org.osgi.framework.Bundle;

import net.certiv.fluentmark.FluentUI;
import net.certiv.fluentmark.Log;

public final class FileUtils {

	public FileUtils() {}

	/**
	 * Creates a file resource handle for the file with the given workspace path. This method does not
	 * create the file resource; this is the responsibility of <code>createFile</code>.
	 *
	 * @param path the path of the file resource to create a handle for
	 * @return the new file resource handle
	 */
	public static IFile createFileHandle(IPath path) {
		if (path.isValidPath(path.toString()) && path.segmentCount() >= 2) {
			return ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		}
		return null;
	}

	public static BufferedReader getReader(File file) {
		try {
			return getReader(((new FileInputStream(file))));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static BufferedReader getReader(InputStream in) {
		InputStreamReader reader;
		try {
			reader = new InputStreamReader(in, Strings.UTF_8);
			return new BufferedReader(reader);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Loads the content of a file from within a bundle. Returns null if not found.
	 * 
	 * @param pathname of the file within the bundle.
	 * @return null if not found.
	 */
	public static String fromBundle(String pathname) {
		Bundle bundle = Platform.getBundle(FluentUI.PLUGIN_ID);
		URL url = bundle.getEntry(pathname);
		if (url == null) return null;
		try {
			url = FileLocator.toFileURL(url);
			return read(URIUtil.toFile(URIUtil.toURI(url)));
		} catch (Exception e) {
			Log.error(e);
			return "";
		}
	}

	public static String read(File file) throws RuntimeException {
		try {
			return read(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static String read(InputStream in) {
		return read(getReader(in));
	}

	public static String read(URL url) {
		try {
			return read(url.openStream());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static String read(Reader r) {
		try (BufferedReader reader = (r instanceof BufferedReader) ? (BufferedReader) r : new BufferedReader(r);) {
			int bufSize = 8192;
			StringBuilder sb = new StringBuilder(bufSize);
			char cbuf[] = new char[bufSize];
			do {
				int chars = reader.read(cbuf);
				if (chars == -1) break;
				if (sb.length() == 0 && cbuf[0] == '\uFEFF') {
					sb.append(cbuf, 1, chars - 1);
				} else {
					sb.append(cbuf, 0, chars);
				}
			} while (true);
			return sb.toString();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static BufferedWriter getWriter(File file) {
		try {
			return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), Strings.UTF_8));
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static BufferedWriter getWriter(OutputStream out) {
		OutputStreamWriter writer;
		try {
			writer = new OutputStreamWriter(out, Strings.UTF_8);
			return new BufferedWriter(writer);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

	public static void write(File out, CharSequence page) {
		try (BufferedWriter writer = getWriter(new FileOutputStream(out))) {
			writer.append(page);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void close(Closeable io) {
		if (io == null) return;
		try {
			io.close();
		} catch (IOException e) {
			if (e.getMessage() != null && e.getMessage().contains("Closed")) {
				return;
			}
			e.printStackTrace();
		}
	}

	public static void delete(File file) {
		if (!file.exists()) return;
		if (file.delete()) return;
		System.gc();
		if (file.delete()) return;

		try {
			Thread.sleep(50L);
		} catch (InterruptedException interruptedexception) {}
		file.delete();
		if (!file.exists()) return;

		// if (file.isDirectory() && isSymLink(file)
		// && (Utils.getOperatingSystem().contains("linux") ||
		// Utils.getOperatingSystem().contains("unix"))) {
		// String path = file.getAbsolutePath();
		// DotGen p = new DotGen((new StringBuilder("rm -f ")).append(path).toString());
		// p.run();
		// p.waitFor(1000L);
		// if (!file.exists()) {
		// return;
		// } else {
		// throw new RuntimeException(new IOException((new StringBuilder("Could not delete
		// file")).append(file)
		// .append("; ").append(p.getError()).toString()));
		// }
		// } else {
		// throw new RuntimeException(
		// new IOException((new StringBuilder("Could not delete file ")).append(file).toString()));
		// }

		throw new RuntimeException(
				new IOException((new StringBuilder("Could not delete file ")).append(file).toString()));
	}

	@SuppressWarnings("unchecked")
	public static LinkedHashMap<String, String> getTemplateMap() {
		LinkedHashMap<String, String> map = null;
		File file = getTemplateStateFile();
		if (file != null && file.isFile()) {
			try (XMLDecoder coder = new XMLDecoder(new BufferedInputStream(new FileInputStream(file)));) {
				map = (LinkedHashMap<String, String>) coder.readObject();
			} catch (FileNotFoundException e) {}
		}
		if (map == null) {
			map = new LinkedHashMap<>();
		}
		return map;
	}

	public static boolean putTemplateMap(LinkedHashMap<String, String> map) {
		File file = getTemplateStateFile();
		try (XMLEncoder coder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(file)));) {
			coder.writeObject(map);
			return true;
		} catch (FileNotFoundException e) {
			return false;
		}
	}

	private static File getTemplateStateFile() {
		return FluentUI.getDefault().getStateLocation().append("TemplateMap.xml").toFile();
	}
}
