package net.certiv.fluent.dt.ui;

import net.certiv.dsl.core.model.IDslElement;
import net.certiv.dsl.core.model.IStatement;
import net.certiv.dsl.ui.DslUI;
import net.certiv.dsl.ui.templates.CompletionManager;

public class FluentCompletionManager extends CompletionManager {

	private static final String PAGE = "page";
	private static final String YAML = "yaml";
	private static final String HTML = "html";
	private static final String MATH = "math";
	private static final String DOT = "dot";
	private static final String TEX = "tex";
	private static final String UML = "uml";

	public FluentCompletionManager(DslUI ui, String editorId) {
		super(ui, editorId, PAGE, YAML, HTML, MATH, DOT, TEX, UML);
	}

	@Override
	public String getContentAssistScope(IStatement stmt) {
		switch (stmt.getKind()) {
			case IDslElement.DSL_UNIT:
			case IDslElement.MODULE:
			case IDslElement.DECLARATION:
				return PAGE;

			case IDslElement.STATEMENT:
				switch (stmt.getRulename()) {
					case YAML:
						return YAML;
					case HTML:
						return HTML;
					case MATH:
						return MATH;
					case DOT:
						return DOT;
					case TEX:
						return TEX;
					case UML:
						return UML;
				}
				return PAGE;

			case IDslElement.IMPORT:
			case IDslElement.FIELD:
			case IDslElement.BEG_BLOCK:
			case IDslElement.END_BLOCK:
			default:
				return null;
		}
	}
}
