package net.certiv.fluent.dt.ui;

import net.certiv.dsl.core.model.IStatement;
import net.certiv.dsl.ui.DslUI;
import net.certiv.dsl.ui.templates.CompletionManager;

public class FluentCompletionManager extends CompletionManager {

	public static final String PAGE = "page";
	public static final String YAML = "yaml";
	public static final String HTML = "html";
	public static final String MATH = "math";
	public static final String DOT = "dot";
	public static final String TEX = "tex";
	public static final String UML = "uml";

	public FluentCompletionManager(DslUI ui, String editorId) {
		super(ui, editorId, PAGE, YAML, HTML, MATH, DOT, TEX, UML);
	}

	@Override
	public String getContentAssistScope(IStatement stmt) {
		if (stmt == null) return PAGE;

		switch (stmt.getModelType()) {
			case STATEMENT:
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
					default:
						return PAGE;
				}

			default:
				return null;
		}
	}
}
