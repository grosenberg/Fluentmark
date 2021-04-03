/*******************************************************************************
 * Copyright (c) 2016 - 2018 Certiv Analytics and others. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluent.dt.vis.convert;

import java.awt.Desktop;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.text.edits.TextEdit;

import net.certiv.common.exec.Cmd;
import net.certiv.common.log.Log;
import net.certiv.common.util.FsUtil;
import net.certiv.common.util.Strings;
import net.certiv.dsl.core.model.ICodeUnit;
import net.certiv.dsl.core.model.IStatement;
import net.certiv.dsl.core.model.IStatementVisitor;
import net.certiv.dsl.core.model.ModelType;
import net.certiv.dsl.core.model.Statement;
import net.certiv.dsl.core.model.builder.SourceRange;
import net.certiv.dsl.core.preferences.PrefsManager;
import net.certiv.dsl.core.util.TextUtil;
import net.certiv.dsl.ui.DslUI;
import net.certiv.fluent.dt.core.FluentCore;
import net.certiv.fluent.dt.core.lang.md.model.SpecializationType;
import net.certiv.fluent.dt.core.model.SpecUtil;
import net.certiv.fluent.dt.core.preferences.Prefs;
import net.certiv.fluent.dt.vis.FluentVis;
import net.sourceforge.plantuml.FileFormat;
import net.sourceforge.plantuml.FileFormatOption;
import net.sourceforge.plantuml.SourceStringReader;

public class PdfGen {

	private static final String[] DOT2PDF = new String[] { "", "-Tpdf", "-o", "" };

	private static final String[] PDF_OPS = new String[] { //
			"--standalone", "--variable", "graphics", "-f", "markdown", "-t", "latex" //
	};

	// TODO: support caption and label?
	// "\\caption{%s}\n"
	// "\\label{%s}\n"
	private static final String GRAPHIC = "" //
			+ "\\begin{figure}[htp]\n" //
			+ "  \\begin{center}\n" //
			+ "    \\graphicspath{{%s}}\n" //
			+ "    \\includegraphics[width=0.8\\textwidth]{%s}\n" //
			+ "  \\end{center}\n" //
			+ "\\end{figure}\n";

	private PdfGen() {}

	/**
	 * Generate and Save PDF_OPS
	 *
	 * @param base the working directory
	 * @param template the latex template
	 * @param pathname the output pathname
	 */
	public static void save(ICodeUnit unit, String template, String pathname) {
		final File loc = unit.getResource().getParent().getLocation().toFile();

		Job job = new Job("Generating Pdf") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				try {
					File out = new File(pathname);
					if (out.isFile()) out.delete();

					// generate images and patch document
					File dir = createPdfTmpFolder(/* loc */);
					Document doc = buildGraphs(dir, unit);

					// send document to pandoc to convert & save
					String content = doc.get();
					String err = convert(loc, template, content, out);
					if (!err.isEmpty()) Log.error(this, "Error generating Pdf %s\n%s", pathname, err);

					// open the converted document
					if (out.isFile()) {
						PrefsManager store = FluentCore.getDefault().getPrefsManager();
						if (store.getBoolean(Prefs.VIEW_PDF_OPEN)) {
							if (Desktop.isDesktopSupported()) {
								try {
									Desktop.getDesktop().open(out);
								} catch (Exception e) {
									Log.error(this, "Cannot open Pdf %s: %s", pathname, e.getMessage());
								}
							}
						}
					}

				} catch (Exception e) {
					Log.error(this, "Error generating Pdf %s: %s", pathname, e.getMessage());
				}

				return Status.OK_STATUS;
			}
		};

		job.setPriority(Job.BUILD);
		job.setSystem(true);
		job.schedule();
	}

	// evaluate parts representing dot and uml code blocks
	// build latex 'graphics include' blocks
	private static Document buildGraphs(File dir, ICodeUnit unit) throws IOException {
		unit.lock();
		Document doc = new Document(unit.getDocument().get());
		MultiTextEdit edit = new MultiTextEdit();

		try {
			unit.getModuleStatement().decend(new IStatementVisitor() {

				@Override
				public boolean onEntry(IStatement element) throws CoreException {
					if (element.getModelType() == ModelType.STATEMENT) {
						Statement stmt = (Statement) element;
						SourceRange range = stmt.getRange();
						SpecializationType type = SpecUtil.getSpecializedType(stmt);

						switch (type) {
							case DotBlock:
								SourceRange subRange = calcDotRange(doc, range);
								if (subRange == null) break;

								File dot = createTmpFile(dir, "pdf");
								if (dot == null) break;

								String text = extractText(doc, subRange);
								if (text == null) break;

								// convert to pdf
								boolean ok = dot2pdf(dot, text);

								// splice in latex blocks to include the pdf
								if (ok) edit.addChild(splice(unit, doc, range, dot));
								break;

							case UmlBlock:
								File uml = createTmpFile(dir, "eps");
								if (uml == null) break;

								text = extractText(doc, range);
								if (text == null) break;

								// convert to eps
								ok = uml2eps(uml, text);

								// splice in latex blocks to include the pdf
								if (ok) edit.addChild(splice(unit, doc, range, uml));
								break;

							default:
						}
					}
					return true;
				}
			});

			edit.apply(doc);

		} catch (MalformedTreeException | BadLocationException | CoreException e) {
			String msg = String.format("Failed applying AUX block edits (%s)", e.getMessage());
			throw new IOException(msg);

		} finally {
			unit.unlock();
		}
		return doc;
	}

	// Note: to specify multiple filters, provide multiple
	// instances of "--filter xxxx" on the command line.
	// The filters will be applied in sequence.
	protected static String convert(File loc, String template, String content, File out) {
		IPreferenceStore store = FluentCore.getDefault().getPrefsManager();
		List<String> ops = new ArrayList<>();

		String cmd = store.getString(Prefs.EDITOR_PANDOC_PROGRAM);
		if (cmd.trim().isEmpty()) return Strings.EMPTY;

		ops.add(cmd);
		ops.addAll(Arrays.asList(PDF_OPS));

		ops.add("--pdf-engine=pdflatex");
		ops.add("--pdf-engine-opt=--shell-escape");
		if (!template.isEmpty()) ops.add("--template=" + template);
		if (store.getBoolean(Prefs.EDITOR_PANDOC_ADDTOC)) ops.add("--table-of-contents");

		ops.add("-o");
		ops.add(out.getPath());

		String[] args = ops.toArray(new String[ops.size()]);
		return Cmd.process(args, loc.getAbsolutePath(), content);
	}

	protected static IStatus makeStatus(int type, String msg) {
		return new Status(type, DslUI.PLUGIN_ID, msg);
	}

	private static SourceRange calcDotRange(IDocument doc, SourceRange clipRange) {
		int beg = clipRange.begLine;
		int end = clipRange.endLine;

		try {
			String text = TextUtil.getText(doc, beg);
			if (text.startsWith("~~~") || text.startsWith("```")) beg++;

			text = TextUtil.getText(doc, end);
			if (text.startsWith("~~~") || text.startsWith("```")) end--;

			return TextUtil.getSourceRange(doc, beg, end, true);

		} catch (BadLocationException e) {
			return null;
		}
	}

	private static boolean dot2pdf(File file, String data) {
		PrefsManager store = FluentCore.getDefault().getPrefsManager();
		String cmd = store.getString(Prefs.EDITOR_DOT_PROGRAM);
		if (cmd.trim().isEmpty() || data.trim().isEmpty()) return false;

		// generate a new value by executing dot
		String[] args = DOT2PDF;
		args[0] = cmd;
		args[DOT2PDF.length - 1] = file.getPath();

		Cmd.process(args, null, data);
		return true;
	}

	private static boolean uml2eps(File file, String text) {
		try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
			SourceStringReader reader = new SourceStringReader(text);
			reader.outputImage(os, new FileFormatOption(FileFormat.EPS));
			String result = new String(os.toByteArray(), Strings.UTF_8);
			FsUtil.write(file, result);
			return true;

		} catch (IOException e) {
			Log.error(PdfGen.class, "Uml exception (%s)\n%s", e.getMessage(), text);
		}
		return false;
	}

	private static TextEdit splice(ICodeUnit unit, IDocument doc, SourceRange range, File file) {
		IPath loc = unit.getResource().getParent().getLocation();
		IPath src = new Path(file.getPath());
		src = src.makeRelativeTo(loc);

		String dir = src.removeLastSegments(1).toString();
		String name = src.lastSegment();

		String delim = Strings.EOL;
		try {
			delim = doc.getLineDelimiter(range.getBegLine());
		} catch (BadLocationException e) {}
		String latex = GRAPHIC.replaceAll("\\R", delim);
		latex = String.format(latex, dir, name);
		return new ReplaceEdit(range.getOffset(), range.getLength(), latex);
	}

	private static String extractText(IDocument doc, SourceRange range) {
		try {
			return doc.get(range.getOffset(), range.getLength());
		} catch (BadLocationException e) {
			Log.error(PdfGen.class, "Failed extracting text at %s (%s)", range, e.getMessage());
			return null;
		}
	}

	// create "tmp/liveview/pdf-XXXX"
	private static File createPdfTmpFolder() throws IOException {
		PrefsManager mgr = FluentVis.getDefault().getPrefsManager();
		String wctx = mgr.getString(Prefs.VIEW_WS_CONTEXT);

		int num = FsUtil.nextRandom(999);
		File root = FsUtil.createTmpFolder(wctx);
		FsUtil.deleteTmpFolderOnExit(root);
		return FsUtil.createTmpFolder(String.format("%s/pdf-%04d", wctx, num));
	}

	private static File createTmpFile(File dir, String ext) {
		try {
			return FsUtil.createTmpFile("fluent", Strings.DOT + ext, dir);
		} catch (IOException e) {
			Log.error(PdfGen.class, String.format("Failed creating tmp file (%s)", e.getMessage()));
			return null;
		}
	}

	// // create "./pdf-XXXX"
	// private static File createPdfTmpFolder(File dir) throws IOException {
	// int num = FileUtils.nextRandom(999);
	// String dirname = String.format("pdf-%04d", num);
	//
	// File root = FileUtils.createTmpFolder(dir, dirname);
	// FileUtils.deleteTmpFolderOnExit(root);
	// return root;
	// }

}
