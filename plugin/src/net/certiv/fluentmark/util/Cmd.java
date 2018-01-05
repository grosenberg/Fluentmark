/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import net.certiv.fluentmark.Log;

public class Cmd {

	/**
	 * Execute a command in a subprocess
	 * 
	 * @param cmd command line argument array defining the command and options. The command must
	 *            execute as a standard filter: stdIn to stdOut.
	 * @param data input data
	 * @return output data
	 */
	public static synchronized String process(String[] cmd, String data) {
		final StringBuilder sb = new StringBuilder();
		final ProcessBuilder pb = new ProcessBuilder(cmd);
		try {
			pb.redirectErrorStream(true);
			Process process = pb.start();

			// prep for ouput from the process
			InputStreamReader in = new InputStreamReader(process.getInputStream());
			BufferedReader br = new BufferedReader(in);

			// prep and feed input to the processs
			OutputStreamWriter out = new OutputStreamWriter(process.getOutputStream());
			BufferedWriter bw = new BufferedWriter(out);
			bw.write(data);
			bw.close();

			// read output from the process
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line + Strings.EOL);
			}
			return sb.toString();

		} catch (IOException e) {
			Log.error("Cmd execution error: " + e.getMessage());
			return "";
		}
	}

	/**
	 * Parse a string into an array of command line arguments
	 */
	public static String[] parse(String command) {
		List<String> args = new ArrayList<>();
		StringBuilder qStr = new StringBuilder();
		boolean quoted = false;
		char ac[] = command.toCharArray();
		for (char c : ac) {
			if (quoted) {
				qStr.append(c);
				if (c == '"') {
					quoted = false;
				}
			} else if (Character.isWhitespace(c)) {
				if (qStr.length() != 0) {
					args.add(qStr.toString());
					qStr = new StringBuilder();
				}
			} else {
				qStr.append(c);
				if (c == '"') {
					quoted = true;
				}
			}
		}

		if (qStr.length() != 0) {
			args.add(qStr.toString());
		}
		String osName = System.getProperty("os.name");
		if (osName.equals("Windows 95")) {
			ArrayList<String> cmd = new ArrayList<>(args.size() + 2);
			cmd.add("command.com");
			cmd.add("/C");
			cmd.addAll(args);
			args = cmd;
		} else if (osName.startsWith("Windows")) {
			ArrayList<String> cmd = new ArrayList<>(args.size() + 2);
			cmd.add("cmd.exe");
			cmd.add("/C");
			cmd.addAll(args);
			args = cmd;
		}
		return args.toArray(new String[args.size()]);
	}
}
