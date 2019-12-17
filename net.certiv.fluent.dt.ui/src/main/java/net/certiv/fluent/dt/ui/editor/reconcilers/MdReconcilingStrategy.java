package net.certiv.fluent.dt.ui.editor.reconcilers;

import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.texteditor.ITextEditor;

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.ui.DslUI;
import net.certiv.dsl.ui.editor.reconcile.ReconcilingStrategy;
import net.certiv.fluent.dt.core.FluentCore;
import net.certiv.fluent.dt.core.lang.FluentLangManager;
import net.certiv.fluent.dt.ui.FluentUI;

public class MdReconcilingStrategy extends ReconcilingStrategy {

	public MdReconcilingStrategy(ITextEditor editor, ISourceViewer viewer) {
		super(editor, viewer, FluentLangManager.MD);
	}

	@Override
	public DslUI getDslUI() {
		return FluentUI.getDefault();
	}

	@Override
	public DslCore getDslCore() {
		return FluentCore.getDefault();
	}
}
