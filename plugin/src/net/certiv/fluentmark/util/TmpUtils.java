/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.util;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class TmpUtils {

	public static final Random RANDOM = new Random(System.currentTimeMillis());
	private static File sysTmp;

	public synchronized static File getSysTmp() {
		if (sysTmp == null) {
			String path = System.getProperty("java.io.tmpdir");
			sysTmp = new File(path);
			if (!sysTmp.exists()) sysTmp.mkdirs();
		}
		return sysTmp;
	}

	public static File createTempFolder(String tmpName) throws IOException {
		String tmp = getSysTmp().getPath() + "/" + tmpName;
		File tmpDir = new File(tmp);
		tmpDir.mkdirs();
		return tmpDir;
	}

	public static File createTempFile(String prefix, String suffix, File dir) throws IOException {
		try {
			return File.createTempFile(prefix, suffix, dir);
		} catch (IOException ex) {
			throw new IOException(ex);
		}
	}

	public static void deleteFolder(File dir) throws IOException {
		if (!dir.exists()) return;

		clearFolder(dir);
		if (dir.list().length == 0) {
			if (!dir.delete()) {
				String message = "Delete failed for " + dir;
				throw new IOException(message);
			}
		}
	}

	public static void clearFolder(File folder) {
		assert folder != null;
		assert folder.exists();
		assert folder.isDirectory();

		File[] files = folder.listFiles();
		for (File file : files) {
			if (file.isDirectory()) clearFolder(file);
			file.delete();
		}
	}
}
