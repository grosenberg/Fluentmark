package net.certiv.fluentmark.editor.text;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.reconciler.DirtyRegion;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;

public class NullReconcilingStrategy implements IReconcilingStrategy {

	public NullReconcilingStrategy() {}

	@Override
	public void setDocument(IDocument document) {}

	@Override
	public void reconcile(DirtyRegion dirtyRegion, IRegion subRegion) {}

	@Override
	public void reconcile(IRegion partition) {}
}
