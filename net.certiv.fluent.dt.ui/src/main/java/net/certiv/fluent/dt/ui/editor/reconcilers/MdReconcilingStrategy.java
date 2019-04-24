package net.certiv.fluent.dt.ui.editor.reconcilers;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.texteditor.ITextEditor;

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.ui.DslUI;
import net.certiv.dsl.ui.editor.reconcile.DslReconcilingStrategy;
import net.certiv.fluent.dt.core.FluentCore;
import net.certiv.fluent.dt.ui.FluentUI;

public class MdReconcilingStrategy extends DslReconcilingStrategy {

	public MdReconcilingStrategy(ITextEditor editor, ISourceViewer viewer) {
		super(editor, viewer, FluentCore.MD);
	}

	@Override
	public DslUI getDslUI() {
		return FluentUI.getDefault();
	}

	@Override
	public DslCore getDslCore() {
		return FluentCore.getDefault();
	}

	@Override
	public void initialReconcile() {
		deleteMarkers(true, IResource.DEPTH_INFINITE);
		reconcile(new Region(0, getRecord().doc.getLength()));
	}

	@Override
	public boolean incremental() {
		return false;
	}
}
