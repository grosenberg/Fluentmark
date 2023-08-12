package net.certiv.fluent.dt.ui.editor.toolbar.links;

import static net.certiv.fluent.dt.core.lang.md.model.SpecSubType.INLINE;
import static net.certiv.fluent.dt.core.lang.md.model.SpecSubType.REF;
import static net.certiv.fluent.dt.core.lang.md.model.SpecSubType.REF_DEF;
import static net.certiv.fluent.dt.core.lang.md.model.SpecializedType.Footnote;
import static net.certiv.fluent.dt.core.lang.md.model.SpecializedType.Image;
import static net.certiv.fluent.dt.core.lang.md.model.SpecializedType.Link;
import static net.certiv.fluent.dt.core.lang.md.model.SpecializedType.Phrase;

import java.util.EnumSet;
import java.util.List;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Interval;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.widgets.Shell;

import net.certiv.common.util.Strings;
import net.certiv.dsl.core.model.IStatement;
import net.certiv.dsl.core.model.Statement;
import net.certiv.dsl.core.model.builder.ISpecialization;
import net.certiv.fluent.dt.core.lang.md.gen.MdParser.FnLinkContext;
import net.certiv.fluent.dt.core.lang.md.gen.MdParser.FnLinkDefContext;
import net.certiv.fluent.dt.core.lang.md.gen.MdParser.FnLinkRefContext;
import net.certiv.fluent.dt.core.lang.md.gen.MdParser.ImgLinkContext;
import net.certiv.fluent.dt.core.lang.md.gen.MdParser.ImgLinkRefContext;
import net.certiv.fluent.dt.core.lang.md.gen.MdParser.LineContext;
import net.certiv.fluent.dt.core.lang.md.gen.MdParser.LinkContext;
import net.certiv.fluent.dt.core.lang.md.gen.MdParser.LinkRefContext;
import net.certiv.fluent.dt.core.lang.md.gen.MdParser.PhraseContext;
import net.certiv.fluent.dt.core.lang.md.gen.MdParser.QuoteContext;
import net.certiv.fluent.dt.core.lang.md.gen.MdParser.RefLinkDefContext;
import net.certiv.fluent.dt.core.lang.md.gen.MdParser.UrlContext;
import net.certiv.fluent.dt.core.lang.md.model.SpecSubType;
import net.certiv.fluent.dt.core.lang.md.model.Specialization;
import net.certiv.fluent.dt.core.lang.md.model.SpecializedType;
import net.certiv.fluent.dt.core.model.SpecUtil;
import net.certiv.fluent.dt.ui.editor.FluentEditor;

public class LinksInfo {

	public static final EnumSet<SpecializedType> LINK_TYPES = EnumSet.of(Link, Image, Footnote);
	public static final EnumSet<SpecSubType> REF_TYPES = EnumSet.of(REF, REF_DEF);

	public final Shell shell;
	public final FluentEditor editor;
	public final IDocument doc;
	public final TextSelection sel;

	public int pos; 	// initial caret/selection offset

	public int selLn;	// selection/statement line
	public int selOff;	// selection/statement offset
	public int selLen;	// selection/statement length

	public int defLn;	// reference definition line
	public int defOff;	// reference definition offset
	public int defLen;	// reference definition length

	public SpecializedType type = Link;
	public SpecSubType subtype = INLINE;

	public String txt = Strings.EMPTY;
	public String ref = Strings.EMPTY;
	public String uri = Strings.EMPTY;
	public String alt = Strings.EMPTY;
	public String def = Strings.EMPTY;

	public LinksInfo(Shell shell, FluentEditor editor, TextSelection sel) {
		this.shell = shell;
		this.editor = editor;
		this.doc = editor.getDocument();
		this.sel = sel;
	}

	public void initialize() {
		if (doc != null) {
			selLn = sel.getStartLine();
			selLen = sel.getLength();
			pos = selOff = selLen != 0 ? sel.getOffset() : getCursorOffset();

			Statement stmt = (Statement) getStatementAt(selOff);
			if (stmt == null || stmt.getSpecializedType() == null) {
				if (selLen != 0) {
					txt = sel.getText();
				}

			} else {
				Specialization data = (Specialization) stmt.getData();
				type = (SpecializedType) data.getSpecializedType();
				subtype = data.getSpecSubType();
				switch (subtype) {
					case INLINE:
						decode(stmt, data);
						break;
					case REF:
						decodeRef(stmt, data);
						break;
					case REF_DEF:
						decodeDef(stmt, data);
						break;
				}
			}
		}
	}

	private IStatement getStatementAt(int off) {
		IStatement stmt = editor.getStatementAt(off, true);
		if (stmt == null) return null;

		SpecializedType type = (SpecializedType) stmt.getSpecializedType();
		if (Phrase == type) {
			stmt = stmt.getParent();
			type = (SpecializedType) stmt.getSpecializedType();
		}
		if (!LINK_TYPES.contains(type)) return null;
		return stmt;
	}

	private void decode(Statement stmt, Specialization data) {
		selLn = stmt.getStartLine();
		selOff = stmt.getOffset();
		selLen = stmt.getLength();
		switch (type) {
			case Link:
				handleLink(data);
				break;
			case Image:
				handleImg(data);
				break;
			case Footnote:
				handleFn(data);
				break;
			default:
				// cannot occur
		}
	}

	private void handleLink(ISpecialization data) {
		LinkContext link = (LinkContext) data.getStmtNode();
		txt = textOf(link.txt);
		uri = textOf(link.url());
		alt = textOf(link.quote());
	}

	private void handleImg(Specialization data) {
		ImgLinkContext link = (ImgLinkContext) data.getStmtNode();
		txt = textOf(link.txt);
		uri = textOf(link.url());
		alt = textOf(link.quote());
	}

	private void handleFn(Specialization data) {
		FnLinkContext link = (FnLinkContext) data.getStmtNode();
		ref = textOf(link.ref);
		uri = textOf(link.url());
		alt = textOf(link.quote());
	}

	private void decodeRef(Statement stmt, Specialization data) {
		selLn = stmt.getStartLine();
		selOff = stmt.getOffset();
		selLen = stmt.getLength();
		switch (type) {
			case Link:
				handleLinkRef(stmt, data);
				break;
			case Image:
				handleImgRef(stmt, data);
				break;
			case Footnote:
				handleFnRef(stmt, data);
				break;
			default:
				// cannot occur
		}
	}

	private void handleLinkRef(Statement stmt, Specialization data) {
		LinkRefContext link = (LinkRefContext) data.getStmtNode();
		txt = textOf(link.txt);
		ref = textOf(link.ref);

		handleRef2Def(stmt, ref.isBlank() ? txt : ref);
	}

	private void handleImgRef(Statement stmt, Specialization data) {
		ImgLinkRefContext link = (ImgLinkRefContext) data.getStmtNode();
		txt = textOf(link.txt);
		ref = textOf(link.ref);

		handleRef2Def(stmt, ref.isBlank() ? txt : ref);
	}

	private void handleRef2Def(Statement stmt, String ref) {
		Statement defStmt = findDef(stmt, Link, ref);
		if (defStmt != null) {
			defLn = defStmt.getStartLine();
			defOff = defStmt.getOffset();
			defLen = defStmt.getLength();

			Specialization defData = (Specialization) defStmt.getData();
			RefLinkDefContext defCtx = (RefLinkDefContext) defData.stmtNode;
			uri = textOf(defCtx.url());
			alt = textOf(defCtx.quote());

		} else {
			defLn = -1;
			defOff = -1;
			defLen = -1;
		}
	}

	private void handleFnRef(Statement stmt, Specialization data) {
		FnLinkRefContext fnCtx = (FnLinkRefContext) data.stmtNode;
		ref = textOf(fnCtx.ref);

		Statement defStmt = findDef(stmt, Footnote, ref);
		if (defStmt != null) {
			defLn = defStmt.getStartLine();
			defOff = defStmt.getOffset();
			defLen = defStmt.getLength();

			Specialization defData = (Specialization) defStmt.getData();
			FnLinkDefContext defCtx = (FnLinkDefContext) defData.stmtNode;
			def = textOf(defCtx.def);

		} else {
			defLn = -1;
			defOff = -1;
			defLen = -1;
		}
	}

	private Statement findDef(Statement reference, SpecializedType type, String ref) {
		List<IStatement> stmts = SpecUtil.findStatements(reference, type, REF_DEF);
		if (stmts.isEmpty()) return null;

		for (IStatement stmt : stmts) {
			Specialization data = (Specialization) stmt.getData();
			if (Link == type) {
				RefLinkDefContext ctx = (RefLinkDefContext) data.stmtNode;
				if (ref.equals(textOf(ctx.ref))) return (Statement) stmt;

			} else if (Footnote == type) {
				FnLinkDefContext ctx = (FnLinkDefContext) data.stmtNode;
				if (ref.equals(textOf(ctx.ref))) return (Statement) stmt;
			}
		}
		return null;
	}

	private void decodeDef(Statement stmt, Specialization data) {
		defLn = stmt.getStartLine();
		defOff = stmt.getOffset();
		defLen = stmt.getLength();

		switch (type) {
			case Link:
				handleLinkDef(stmt, data);
				break;
			case Footnote:
				handleFnDef(stmt, data);
				break;
			default:
				// cannot occur
		}
	}

	private void handleLinkDef(Statement stmt, Specialization data) {
		RefLinkDefContext link = (RefLinkDefContext) data.getStmtNode();
		ref = textOf(link.ref);
		uri = textOf(link.url());
		alt = textOf(link.quote());
		subtype = REF;

		Statement refStmt = findRef(stmt, Link, ref);
		if (refStmt != null) {
			type = Link;
			selLn = refStmt.getStartLine();
			selOff = refStmt.getOffset();
			selLen = refStmt.getLength();

			data = (Specialization) refStmt.getData();
			LinkRefContext ctx = (LinkRefContext) data.getStmtNode();
			txt = textOf(ctx.txt);
			ref = textOf(ctx.ref);

		} else {
			refStmt = findRef(stmt, Image, ref);
			if (refStmt != null) {
				type = Image;
				selLn = refStmt.getStartLine();
				selOff = refStmt.getOffset();
				selLen = refStmt.getLength();

				data = (Specialization) refStmt.getData();
				ImgLinkRefContext ctx = (ImgLinkRefContext) data.getStmtNode();
				txt = textOf(ctx.txt);
				ref = textOf(ctx.ref);

			} else {
				selLn = -1;
				selOff = -1;
				selLen = -1;
			}
		}
	}

	private void handleFnDef(Statement stmt, Specialization data) {
		FnLinkDefContext defCtx = (FnLinkDefContext) data.getStmtNode();
		ref = textOf(defCtx.ref);
		def = textOf(defCtx.def);
		subtype = REF;

		Statement refStmt = findRef(stmt, Footnote, ref);
		if (refStmt != null) {
			selLn = refStmt.getStartLine();
			selOff = refStmt.getOffset();
			selLen = refStmt.getLength();

		} else {
			selLn = -1;
			selOff = -1;
			selLen = -1;
		}
	}

	private Statement findRef(Statement reference, SpecializedType type, String ref) {
		List<IStatement> stmts = SpecUtil.findStatements(reference, type, REF);
		if (stmts.isEmpty()) return null;

		for (IStatement stmt : stmts) {
			Specialization data = (Specialization) stmt.getData();
			if (Link == type) {
				LinkRefContext ctx = (LinkRefContext) data.stmtNode;
				String tgt = textOf(ctx.ref);
				if (tgt.isBlank()) {
					tgt = textOf(ctx.txt);
				}
				if (ref.equals(tgt)) return (Statement) stmt;

			} else if (Image == type) {
				ImgLinkRefContext ctx = (ImgLinkRefContext) data.stmtNode;
				String tgt = textOf(ctx.ref);
				if (tgt.isBlank()) {
					tgt = textOf(ctx.txt);
				}
				if (ref.equals(tgt)) return (Statement) stmt;

			} else if (Footnote == type) {
				FnLinkRefContext ctx = (FnLinkRefContext) data.stmtNode;
				if (ref.equals(textOf(ctx.ref))) return (Statement) stmt;
			}
		}
		return null;
	}

	private String textOf(PhraseContext phrase) {
		if (phrase == null) return Strings.EMPTY;

		int beg = phrase.start.getStartIndex();
		int end = phrase.stop.getStopIndex();
		return phrase.start.getInputStream().getText(Interval.of(beg, end));
	}

	private String textOf(List<LineContext> lines) {
		if (lines.isEmpty()) return Strings.EMPTY;

		Token start = lines.get(0).getStart();
		int beg = start.getStartIndex();
		int end = lines.get(lines.size() - 1).getStop().getStopIndex();
		return start.getInputStream().getText(Interval.of(beg, end));
	}

	private String textOf(UrlContext url) {
		if (url == null) return Strings.EMPTY;

		int beg = url.start.getStartIndex();
		int end = url.stop.getStopIndex();
		return url.start.getInputStream().getText(Interval.of(beg, end));
	}

	private String textOf(QuoteContext alt) {
		if (alt == null) return Strings.EMPTY;

		int beg = alt.start.getStartIndex();
		int end = alt.stop.getStopIndex();
		String text = alt.start.getInputStream().getText(Interval.of(beg, end));
		return Strings.deQuote(text);
	}

	public int getCursorOffset() {
		SourceViewer viewer = editor.getViewer();
		return viewer.widgetOffset2ModelOffset(viewer.getTextWidget().getCaretOffset());
	}

	public void setCursorOffset(int offset) {
		SourceViewer viewer = editor.getViewer();
		viewer.getTextWidget().setCaretOffset(viewer.modelOffset2WidgetOffset(offset));
	}
}
