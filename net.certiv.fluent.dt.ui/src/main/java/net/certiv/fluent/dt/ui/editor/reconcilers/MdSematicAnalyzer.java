package net.certiv.fluent.dt.ui.editor.reconcilers;

import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;

import net.certiv.dsl.core.log.Log;
import net.certiv.dsl.core.model.IStatement;
import net.certiv.dsl.core.util.Chars;
import net.certiv.dsl.core.util.Strings;
import net.certiv.dsl.ui.DslUI;
import net.certiv.dsl.ui.editor.semantic.HighlightPosition;
import net.certiv.dsl.ui.editor.semantic.HighlightStyle;
import net.certiv.dsl.ui.editor.semantic.SemanticAnalyzer;
import net.certiv.dsl.ui.styles.Selector;
import net.certiv.fluent.dt.core.lang.FluentLangManager;
import net.certiv.fluent.dt.core.model.SpecType;

public class MdSematicAnalyzer extends SemanticAnalyzer {

	public MdSematicAnalyzer(DslUI ui) {
		super(ui, FluentLangManager.MD);
	}

	@Override
	protected boolean qualified(IStatement stmt) {
		switch ((SpecType) stmt.getSpecType()) {
			case Header:
			case Setext:
			case ListItem:
				return true;

			default:
				return false;
		}
	}

	@Override
	protected void applySemanticEffects(HighlightPosition position, IStatement stmt) {
		SpecType type = (SpecType) stmt.getSpecType();
		switch (type) {
			case Header:
			case Setext:
				update(position, getLevel(stmt));
				break;

			case ListItem:
				update(position, getIndent(stmt));
				break;

			default:
				update(position, type.css);
		}
	}

	private void update(HighlightPosition position, String sel) {
		update(position, Arrays.asList(sel));
	}

	private void update(HighlightPosition position, List<String> sel) {
		Selector selector = getRegistry().createSelector(sel);
		HighlightStyle style = stylesMgr.update(position.getStyle(), sheetRef, selector);
		position.setStyle(style);
	}

	private String getLevel(IStatement stmt) {
		int level = 0;
		String src = Strings.EMPTY;
		try {
			src = stmt.getSource().trim();
		} catch (BadLocationException e) {
			Log.error(this, e.getMessage(), e);
		}
		if (src.startsWith(Strings.HASH)) {
			while (src.charAt(level) == Chars.HASH && level < 7) {
				level++;
			}

		} else if (src.contains("----")) {
			level = 1;
		} else if (src.contains("====")) {
			level = 2;
		}
		return SpecType.Header.css + level;
	}

	private List<String> getIndent(IStatement stmt) {
		try {
			IDocument doc = stmt.getCodeUnit().getDocument();
			IRegion info = doc.getLineInformationOfOffset(stmt.getOffset());
			String dent = doc.get(info.getOffset(), stmt.getOffset() - info.getOffset());
			int dents = Strings.measureIndentLength(dent, 2);
			return Strings.dupList(dents + 1, SpecType.ListItem.css);

		} catch (Exception e) {
			Log.error(this, "Failed to determine list item indent: " + e.getMessage());
			return Arrays.asList(SpecType.ListItem.css);
		}
	}
}
