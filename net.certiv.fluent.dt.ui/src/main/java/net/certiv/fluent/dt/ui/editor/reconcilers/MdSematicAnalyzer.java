package net.certiv.fluent.dt.ui.editor.reconcilers;

import net.certiv.dsl.core.model.IStatement;
import net.certiv.dsl.ui.DslUI;
import net.certiv.dsl.ui.editor.semantic.SemanticAnalyzer;
import net.certiv.dsl.ui.styles.Segment;
import net.certiv.dsl.ui.styles.Selector;
import net.certiv.fluent.dt.core.lang.FluentLangManager;
import net.certiv.fluent.dt.core.model.SpecData;
import net.certiv.fluent.dt.core.model.SpecType;

public class MdSematicAnalyzer extends SemanticAnalyzer {

	public MdSematicAnalyzer(DslUI ui) {
		super(ui, FluentLangManager.MD);
	}

	@Override
	protected boolean qualified(IStatement stmt) {
		switch ((SpecType) stmt.getSpecType()) {
			case Page:

			case Paragraph:
			case HRule:

			case Header:
			case Setext:

			case ListOrdered:
			case ListUnordered:
			case ListItem:

			case Table:
			case TableRow:

			case Link:
			case Cite:
			case Span:
			case Definition:
			case Quote:

			case Bold:
			case Italic:
			case Underline:

			case CodeBlock:
			case CodeBlockIndented:
				return true;

			default:
				return false;
		}
	}

	@Override
	protected Selector generateContextSelector(IStatement stmt) {
		Selector context = super.generateContextSelector(stmt);

		for (int idx = 0; idx < context.size(); idx++) {
			Segment seg = context.get(idx);
			if (seg.hasData()) {
				SpecData data = (SpecData) seg.getData();
				SpecType type = (SpecType) data.getSpecType();

				switch (type) {
					case Header:
						// update level if leading; remove others
						if (idx == 0) {
							seg.setName(seg.getName() + data.hdrLevel);
						} else {
							context.segments.remove(idx);
							idx--;
						}
						break;

					case ListItem:
						break;

					default:
						break;
				}
			}
		}
		return context;
	}
}
