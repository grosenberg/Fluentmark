/*******************************************************************************
 * Copyright (c) 2016 - 2018 Certiv Analytics and others. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluent.dt.ui.vis.convert;

import java.awt.Desktop;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
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
import net.certiv.common.util.FileUtils;
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
import net.sourceforge.plantuml.FileFormat;
import net.sourceforge.plantuml.FileFormatOption;
import net.sourceforge.plantuml.SourceStringReader;

public class PdfGen {

	private static final String[] DOT2PDF = new String[] { "", "-Tpdf", "-o", "" };

	private static final String[] PDF_OPS = new String[] { //
			"--standalone", "--variable", "graphics", "-f", "markdown", "-t", "latex" //
	};

	// TODO: support caption and label?
	// "\\caption{%s}" + Strings.EOL + //
	// "\\label{%s}" + Strings.EOL + //
	private static final String GRAPHIC = "\\begin{figure}[htp]" + Strings.EOL +  //
			"\\begin{center}" + Strings.EOL + //
			"\\graphicspath{{%s}}" + Strings.EOL + //
			"\\includegraphics[width=0.8\\textwidth]{%s}" + Strings.EOL + //
			"\\end{center}" + Strings.EOL + //
			"\\end{figure}" + Strings.EOL;

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
	public static void save(ICodeUnit unit, String template, String pathname) {
		final String basepath = unit.getLocation().removeLastSegments(1).addTrailingSeparator().toString();
		Document doc = new Document(unit.getDocument().get());

		Job job = new Job("Generating Pdf") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {

				// generate images to 'dir' and patch document
				File dir = null;
				try {
					try {
						dir = buildGraphs(unit, doc);
					} catch (IOException e) {
						return makeStatus(IStatus.ERROR, e.getMessage());
					}

					// send document to pandoc to convert & save
					File out = new File(pathname);
					String content = doc.get();
					String err = convert(basepath, template, content, out);

					cleanup(dir);
					if (!err.isEmpty()) {
						return makeStatus(IStatus.ERROR, "Error: " + err);
					}

					// open the converted document
					PrefsManager store = FluentCore.getDefault().getPrefsManager();
					if (store.getBoolean(Prefs.VIEW_PDF_OPEN)) {
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

	protected static File buildGraphs(ICodeUnit unit, Document doc) throws IOException {
		File dir = getTmpFolder();

		// evaluate parts representing dot and uml code blocks
		// build latex 'graphics include' blocks
		MultiTextEdit edit = new MultiTextEdit();

		unit.lock();
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

								File tmpfile = createTmpFile(dir, "pdf");
								if (tmpfile == null) break;

								String text = extractText(doc, subRange);
								if (text == null) break;

								// convert to pdf
								boolean ok = dot2pdf(tmpfile, text);

								// splice in latex blocks to include the pdf
								if (ok) edit.addChild(splice(unit, doc, range, tmpfile));
								break;

							case UmlBlock:
								tmpfile = createTmpFile(dir, "eps");
								if (tmpfile == null) break;

								text = extractText(doc, range);
								if (text == null) break;

								// convert to pdf
								ok = uml2pdf(tmpfile, text);

								// splice in latex blocks to include the pdf
								if (ok) edit.addChild(splice(unit, doc, range, tmpfile));
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
		return dir;
	}

	protected static String convert(String base, String template, String content, File out) {
		IPreferenceStore store = FluentCore.getDefault().getPrefsManager();
		List<String> ops = new ArrayList<>();

		String cmd = store.getString(Prefs.EDITOR_PANDOC_PROGRAM);
		if (cmd.trim().isEmpty()) return Strings.EMPTY;

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
			FileUtils.deleteFolder(dir);
		} catch (IOException e) {}
	}

	protected static IStatus makeStatus(int type, String msg) {
		return new Status(type, DslUI.PLUGIN_ID, msg);
	}

	private static SourceRange calcDotRange(IDocument doc, SourceRange clipRange) {
		int begLine = clipRange.getBegLine() + 1;
		int endLine = clipRange.getEndLine() - 1;

		try {
			while (endLine > begLine) {
				String text = TextUtil.getText(doc, endLine);
				if (!text.trim().isEmpty() && !text.startsWith("~~~") && !text.startsWith("```")) {
					break;
				}
				endLine--;
			}
			if (begLine >= endLine) return null;
			return TextUtil.getSourceRange(doc, begLine, endLine, true);

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

	private static boolean uml2pdf(File file, String text) {
		try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
			SourceStringReader reader = new SourceStringReader(text);
			reader.outputImage(os, new FileFormatOption(FileFormat.EPS));
			String result = new String(os.toByteArray(), Charset.forName("UTF-8"));
			FileUtils.write(file, result);
			return true;
		} catch (IOException e) {
			Log.error(PdfGen.class, "Uml exception on" + Strings.EOL + text, e);
		}
		return false;
	}

	private static TextEdit splice(ICodeUnit unit, IDocument doc, SourceRange range, File tmpfile) {
		String dir = tmpfile.getParent().replace("\\", "/") + "/";
		String name = tmpfile.getName();

		String delim = Strings.EOL;
		try {
			delim = doc.getLineDelimiter(range.getBegLine());
		} catch (BadLocationException e) {}
		String figure = GRAPHIC.replaceAll("\\R", delim);
		String latex = String.format(figure, dir, name);
		return new ReplaceEdit(range.getOffset(), range.getLength(), latex);
	}

	private static String extractText(IDocument doc, SourceRange range) {
		try {
			return doc.get(range.getOffset(), range.getLength());
		} catch (BadLocationException e) {
			Log.error(PdfGen.class,
					String.format("Failed extracting text at %s (%s)", range, e.getMessage()));
			return null;
		}
	}

	private static File getTmpFolder() throws IOException {
		try {
			return FileUtils.createTmpFolder("mk_" + FileUtils.nextRandom());
		} catch (IOException e) {
			String msg = String.format("Failed creating tmp folder (%s)", e.getMessage());
			throw new IOException(msg);
		}
	}

	private static File createTmpFile(File dir, String ext) {
		try {
			return FileUtils.createTmpFile("fluent_", "." + ext, dir);
		} catch (IOException e) {
			Log.error(PdfGen.class, String.format("Failed creating tmp file (%s)", e.getMessage()));
			return null;
		}
	}
}
