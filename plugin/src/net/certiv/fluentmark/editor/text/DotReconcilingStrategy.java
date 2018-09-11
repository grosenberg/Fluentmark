package net.certiv.fluentmark.editor.text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ISynchronizable;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.TextUtilities;
import org.eclipse.jface.text.reconciler.DirtyRegion;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.eclipse.jface.text.reconciler.IReconcilingStrategyExtension;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.IAnnotationModelExtension;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.ui.texteditor.ITextEditor;

import net.certiv.fluentmark.FluentUI;
import net.certiv.fluentmark.dot.DotSourceParser;
import net.certiv.fluentmark.editor.FluentEditor;
import net.certiv.fluentmark.editor.Partitions;
import net.certiv.fluentmark.editor.assist.DotAnnotation;
import net.certiv.fluentmark.editor.assist.DotProblem;

public class DotReconcilingStrategy implements IReconcilingStrategy, IReconcilingStrategyExtension {

	protected static final String ErrMsg = "DOT reconcile error";

	private IDocument doc;
	private FluentEditor editor;
	private ISourceViewer viewer;
	private DotSourceParser reconciler;
	private DotProblemCollector collector;

	public DotReconcilingStrategy(ITextEditor editor, ISourceViewer viewer) {
		this.editor = (FluentEditor) editor;
		this.viewer = viewer;

		reconciler = new DotSourceParser(this.editor);
	}

	@Override
	public void setDocument(IDocument doc) {
		this.doc = doc;
		collector = createDotProblemCollector();
	}

	@Override
	public void setProgressMonitor(IProgressMonitor monitor) {}

	@Override
	public void initialReconcile() {
		IResource res = ResourceUtil.getResource(editor.getEditorInput());
		try {
			res.deleteMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
		} catch (CoreException e) {}
		reconcile(new Region(0, doc.getLength()));
	}

	@Override
	public void reconcile(DirtyRegion dirtyRegion, IRegion subRegion) {}

	@Override
	public void reconcile(IRegion region) {
		collector.beginCollecting();
		ITypedRegion[] partitions = null;
		try {
			partitions = TextUtilities.computePartitioning(doc, Partitions.PARTITIONING, region.getOffset(),
					region.getLength(), false);
		} catch (BadLocationException e) {
			return;
		}

		for (ITypedRegion partition : partitions) {
			if (partition.getType().equals(Partitions.DOTBLOCK)) {
				SafeRunner.run(new ISafeRunnable() {

					@Override
					public void run() throws Exception {
						reconciler.eval(doc, partition, collector);
					}

					@Override
					public void handleException(Throwable e) {
						IStatus status = new Status(IStatus.ERROR, FluentUI.PLUGIN_ID, IStatus.OK, ErrMsg, e);
						FluentUI.getDefault().getLog().log(status);
					}
				});
			} ;
		}
		collector.endCollecting();
	}

	protected DotProblemCollector createDotProblemCollector() {
		IAnnotationModel model = viewer.getAnnotationModel();
		if (model == null) return null;
		return new DotProblemCollector(model);
	}

	public class DotProblemCollector {

		private IAnnotationModel model;
		private Map<Annotation, Position> annotations;
		private Object lock;

		/** Initializes this collector with the given annotation model. */
		public DotProblemCollector(IAnnotationModel model) {
			Assert.isLegal(model != null);
			this.model = model;
			if (model instanceof ISynchronizable) {
				lock = ((ISynchronizable) model).getLockObject();
			} else {
				lock = model;
			}
		}

		public void beginCollecting() {
			annotations = new HashMap<>();
		}

		public void accept(DotProblem problem) {
			annotations.put(new DotAnnotation(problem), new Position(problem.getOffset(), problem.getLength()));
		}

		public void endCollecting() {
			synchronized (lock) {

				// create list of obsolete annotations (to be removed)
				List<Annotation> obsolete = new ArrayList<>();
				Iterator<Annotation> existingItr = model.getAnnotationIterator();
				while (existingItr.hasNext()) {
					Annotation existing = existingItr.next();
					if (existing instanceof DotAnnotation) {
						obsolete.add(existing);
						((DotAnnotation) existing).deleteMarker();
					}
				}

				Annotation[] obsoletes = obsolete.toArray(new Annotation[obsolete.size()]);
				if (model instanceof IAnnotationModelExtension) {
					((IAnnotationModelExtension) model).replaceAnnotations(obsoletes, annotations);

				} else {
					for (Annotation old : obsoletes) {
						model.removeAnnotation(old);
					}
					for (Entry<Annotation, Position> entry : annotations.entrySet()) {
						model.addAnnotation(entry.getKey(), entry.getValue());
					}
				}
			}

			annotations.clear();
			annotations = null;
		}
	}
}
