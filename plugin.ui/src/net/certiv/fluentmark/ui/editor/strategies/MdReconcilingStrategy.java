package net.certiv.fluentmark.ui.editor.strategies;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.texteditor.ITextEditor;

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.core.parser.ISourceParser;
import net.certiv.dsl.ui.DslUI;
import net.certiv.dsl.ui.editor.reconcile.DslReconcilingStrategy;
import net.certiv.fluentmark.core.FluentCore;
import net.certiv.fluentmark.core.md.parser.MdSourceParser;
import net.certiv.fluentmark.ui.FluentUI;

public class MdReconcilingStrategy extends DslReconcilingStrategy {

	private static final String MARK_ID = ".md_marker";
	private static final String[] TargetContentTypes = {}; // the entire document will be parsed

	public MdReconcilingStrategy(ITextEditor editor, ISourceViewer viewer) {
		super(editor, viewer, MARK_ID, TargetContentTypes);
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
	protected ISourceParser createSourceParser() {
		return new MdSourceParser();
	}

	@Override
	public void initialReconcile() {
		deleteMarkers(true, IResource.DEPTH_INFINITE);
		reconcile(new Region(0, record.doc.getLength()));
	}
}
