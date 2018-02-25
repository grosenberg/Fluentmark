/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.convert;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.text.edits.TextEdit;

import net.certiv.fluentmark.FluentUI;
import net.certiv.fluentmark.Log;
import net.certiv.fluentmark.model.ISourceRange;
import net.certiv.fluentmark.model.PagePart;
import net.certiv.fluentmark.model.PageRoot;
import net.certiv.fluentmark.model.SourceRange;
import net.certiv.fluentmark.model.Type;
import net.certiv.fluentmark.preferences.Prefs;
import net.certiv.fluentmark.util.Cmd;
import net.certiv.fluentmark.util.Strings;
import net.certiv.fluentmark.util.Temps;

public class PdfGen {

	private static final String[] DOT2PDF = new String[] { "", "-Tpdf", "-o", "" };

	private static final String[] PDF_OPS = new String[] { //
			"--standalone", "--variable", "graphics", "-f", "markdown", "-t", "latex" //
	};

	// TODO: support caption and label?
	private static final String GRAPHIC = "\\begin{figure}[htp]" + Strings.EOL //
			+ "\\begin{center}" + Strings.EOL //
			+ "\\graphicspath{{%s}}" + Strings.EOL //
			+ "\\includegraphics[width=0.8\\textwidth]{%s}" + Strings.EOL //
			// + "\\caption{%s}" + Strings.EOL //
			// + "\\label{%s}" + Strings.EOL //
			+ "\\end{center}" + Strings.EOL //
			+ "\\end{figure}" + Strings.EOL;

	private PdfGen() {}

	/**
	 * Generate and Save PDF_OPS
	 * 
	 * @param base the working directory
	 * @param doc the source document
	 * @param model contains the dot code blocks
	 * @param template the latex template
	 * @param pathname the output pathname
	 */
	public static void save(String base, IDocument doc, PageRoot model, String template, String pathname) {

		Job job = new Job("Pdf generating") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {

				// generate images to 'dir' and patch document
				File dir = null;
				try {
					try {
						dir = spliceDotGraphs(doc, model);
					} catch (IOException e) {
						return makeStatus(IStatus.ERROR, e.getMessage());
					}

					// send document to pandoc to convert & save
					File out = new File(pathname);
					String content = doc.get();
					String err = convert(base, template, content, out);

					cleanup(dir);
					if (!err.isEmpty()) {
						return makeStatus(IStatus.ERROR, "Pdf generation failed: " + err);
					}

					// open the converted document
					if (FluentUI.getDefault().getPreferenceStore().getBoolean(Prefs.EDITOR_PDF_OPEN)) {
						if (Desktop.isDesktopSupported()) {
							try {
								Desktop.getDesktop().open(out);
							} catch (Exception e) {
								String msg = String.format("Cannot open %s (%s)", pathname, e.getMessage());
								return makeStatus(IStatus.ERROR, msg);
							}
						}
					}

					return makeStatus(IStatus.OK, "");

				} finally {
					cleanup(dir);
				}
			}
		};

		job.setPriority(Job.LONG);
		job.schedule();
	}

	protected static File spliceDotGraphs(IDocument doc, PageRoot model) throws IOException {
		File dir = null;

		// collect parts representing dot code blocks
		List<PagePart> parts = new ArrayList<>();
		for (PagePart part : model.getPageParts(Type.CODE_BLOCK)) {
			if (part.getMeta().equals(DotGen.DOT)) {
				parts.add(part);
			}
		}

		if (!parts.isEmpty()) {
			try {
				dir = Temps.createFolder("mk_" + Temps.nextRandom());
			} catch (IOException e) {
				String msg = String.format("Failed creating tmp folder (%s)", e.getMessage());
				throw new IOException(msg);
			}

			MultiTextEdit edit = new MultiTextEdit();
			for (PagePart part : parts) {
				if (part.getMeta().equals(DotGen.DOT)) {
					ISourceRange clipRange = part.getSourceRange();
					ISourceRange dotRange = calcDotRange(clipRange);
					if (dotRange == null) continue;

					// extract the dot block
					String dot;
					File tmpfile;
					try {
						dot = doc.get(dotRange.getOffset(), dotRange.getLength());
						tmpfile = Temps.createFile("fluent_", ".pdf", dir);
					} catch (BadLocationException e) {
						Log.error(String.format("Failed extracting DOT block at %s (%s)", dotRange, e.getMessage()));
						continue;
					} catch (IOException e) {
						Log.error(String.format("Failed creating tmp file (%s)", e.getMessage()));
						continue;
					}

					// convert to pdf
					boolean ok = dot2pdf(tmpfile, dot);

					// splice in latex blocks to include the pdfs
					if (ok) edit.addChild(splice(doc, clipRange, tmpfile));
				}
			}

			try {
				edit.apply(doc);
			} catch (MalformedTreeException | BadLocationException e) {
				String msg = String.format("Failed applying DOT block edits (%s)", e.getMessage());
				throw new IOException(msg);
			}
		}
		return dir;
	}

	public static String convert(String base, String template, String content, File out) {
		IPreferenceStore store = FluentUI.getDefault().getPreferenceStore();
		List<String> ops = new ArrayList<>();

		String cmd = store.getString(Prefs.EDITOR_PANDOC_PROGRAM);
		if (cmd.trim().isEmpty()) return "";

		ops.add(cmd);
		ops.addAll(Arrays.asList(PDF_OPS));

		ops.add("--pdf-engine=xelatex");
		if (!template.isEmpty()) ops.add("--template=" + template);
		if (store.getBoolean(Prefs.EDITOR_PANDOC_ADDTOC)) ops.add("--table-of-contents");

		ops.add("-o");
		ops.add(out.getPath());

		String[] args = ops.toArray(new String[ops.size()]);
		return Cmd.process(args, base, content);
	}

	// clean up temporary files
	protected static void cleanup(File dir) {
		try {
			Temps.deleteFolder(dir);
		} catch (IOException e) {}
	}

	protected static ISourceRange calcDotRange(ISourceRange clipRange) {
		int dotBegLine = clipRange.getBeginLine() + 1;
		int dotEndLine = clipRange.getEndLine() - 1;
		PageRoot model = PageRoot.MODEL;
		while (dotEndLine > dotBegLine) {
			String text = model.getText(dotEndLine);
			if (!text.trim().isEmpty() && !text.startsWith("~~~") && !text.startsWith("```")) {
				break;
			}
			dotEndLine--;
		}
		if (dotBegLine >= dotEndLine) return null;

		int begOffset = model.getOffset(dotBegLine);
		int endOffset = model.getOffset(dotEndLine);
		endOffset += model.getTextLength(dotEndLine) + model.getLineDelim().length();
		return new SourceRange(begOffset, endOffset - begOffset, dotBegLine, dotEndLine);
	}

	protected static boolean dot2pdf(File tmpfile, String data) {
		String cmd = FluentUI.getDefault().getPreferenceStore().getString(Prefs.EDITOR_DOT_PROGRAM);
		if (cmd.trim().isEmpty() || data.trim().isEmpty()) return false;

		// generate a new value by executing dot
		String[] args = DOT2PDF;
		args[0] = cmd;
		args[DOT2PDF.length - 1] = tmpfile.getPath();

		Cmd.process(args, null, data);
		return true;
	}

	protected static TextEdit splice(IDocument doc, ISourceRange range, File tmpfile) {
		String dir = tmpfile.getParent().replace("\\", "/") + "/";
		String name = tmpfile.getName();

		String figure = GRAPHIC.replaceAll("\\R", PageRoot.MODEL.getLineDelim());
		String latex = String.format(figure, dir, name);
		return new ReplaceEdit(range.getOffset(), range.getLength(), latex);
	}

	private static IStatus makeStatus(int type, String msg) {
		return new Status(type, FluentUI.PLUGIN_ID, msg);
	}
}
