/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.editor.folding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.TextUtilities;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.projection.IProjectionListener;
import org.eclipse.jface.text.source.projection.IProjectionPosition;
import org.eclipse.jface.text.source.projection.ProjectionAnnotation;
import org.eclipse.jface.text.source.projection.ProjectionAnnotationModel;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;

import net.certiv.fluentmark.editor.DocumentCharacterIterator;
import net.certiv.fluentmark.editor.FluentEditor;
import net.certiv.fluentmark.editor.IReconcilingListener;
import net.certiv.fluentmark.editor.ISourceReference;
import net.certiv.fluentmark.editor.Partitions;
import net.certiv.fluentmark.model.ISourceRange;
import net.certiv.fluentmark.model.SourceRange;
import net.certiv.fluentmark.preferences.Prefs;

/** Implementation of a {@link IFoldingStructureProvider}. */
public class FoldingStructureProvider implements IFoldingStructureProvider {

	/** Update folding positions; triggered by reconciler. */
	private class FoldingStructureReconciler implements IReconcilingListener {

		private volatile boolean reconciling;

		@Override
		public void reconciled() {
			if (input == null) return;

			synchronized (this) {
				if (reconciling) return;
				reconciling = true;
			}
			try {
				final boolean initialReconcile = initialReconcilePending;
				initialReconcilePending = false;
				FoldingStructureComputationContext ctx = createContext(initialReconcile);
				if (ctx != null) update(ctx);
			} finally {
				reconciling = false;
			}
		}
	}

	/**
	 * A context that contains the information needed to compute the folding structure of an
	 * {@link ITranslationUnit}. Computed folding regions are collected via
	 * {@linkplain #addProjectionRange(FluentProjectionAnnotation.DslProjectionAnnotation, Position)
	 * addProjectionRange}.
	 */
	protected final class FoldingStructureComputationContext {

		private final ProjectionAnnotationModel model;
		private final IDocument doc;
		private final boolean allowCollapsing;

		private ISourceReference firstType;
		private boolean hasHeaderComment;
		private LinkedHashMap<FluentProjectionAnnotation, Position> fMap = new LinkedHashMap<>();

		FoldingStructureComputationContext(IDocument doc, ProjectionAnnotationModel model, boolean allowCollapsing) {
			Assert.isNotNull(doc);
			Assert.isNotNull(model);
			this.doc = doc;
			this.model = model;
			this.allowCollapsing = allowCollapsing;
		}

		void setFirstType(ISourceReference reference) {
			if (hasFirstType()) throw new IllegalStateException();
			firstType = reference;
		}

		boolean hasFirstType() {
			return firstType != null;
		}

		ISourceReference getFirstType() {
			return firstType;
		}

		boolean hasHeaderComment() {
			return hasHeaderComment;
		}

		void setHasHeaderComment() {
			hasHeaderComment = true;
		}

		/**
		 * Returns <code>true</code> if newly created folding regions may be collapsed, <code>false</code>
		 * if not. This is usually <code>false</code> when updating the folding structure while typing; it
		 * may be <code>true</code> when computing or restoring the initial folding structure.
		 *
		 * @return <code>true</code> if newly created folding regions may be collapsed, <code>false</code>
		 *         if not
		 */
		public boolean allowCollapsing() {
			return allowCollapsing;
		}

		/**
		 * Returns the document which contains the code being folded.
		 *
		 * @return the document which contains the code being folded
		 */
		IDocument getDocument() {
			return doc;
		}

		ProjectionAnnotationModel getModel() {
			return model;
		}

		/**
		 * Adds a projection (folding) region to this context. The created annotation / position pair will
		 * be added to the {@link ProjectionAnnotationModel} of the {@link ProjectionViewer} of the editor.
		 *
		 * @param annotation the annotation to add
		 * @param position the corresponding position
		 */
		public void addProjectionRange(FluentProjectionAnnotation annotation, Position position) {
			fMap.put(annotation, position);
		}

		public boolean collapseFrontMatter() {
			return allowCollapsing && collapseFrontMatter;
		}

		public boolean collapseComments() {
			return allowCollapsing && collapseComments;
		}

		public boolean collapseCodeblocks() {
			return allowCollapsing && collapseCodeBlocks;
		}

		public boolean collapseHtmlblocks() {
			return allowCollapsing && collapseHtmlBlocks;
		}
	}

	private static class FluentProjectionAnnotation extends ProjectionAnnotation {

		public final static int COMMENT = 0;

		private Object key;
		private int category;

		public FluentProjectionAnnotation(boolean isCollapsed, Object key, boolean isComment) {
			this(isCollapsed, key, isComment ? COMMENT : 0);
		}

		public FluentProjectionAnnotation(boolean isCollapsed, Object key, int category) {
			super(isCollapsed);
			this.key = key;
			this.category = category;
		}

		public Object getElement() {
			return key;
		}

		public void setElement(Object element) {
			this.key = element;
		}

		public int getCategory() {
			return category;
		}

		@Override
		public String toString() {
			return "FluentProjectionAnnotation:\n" + //$NON-NLS-1$
					"\tkey: \t" + key + "\n" + //$NON-NLS-1$ //$NON-NLS-2$
					"\tcollapsed: \t" + isCollapsed() + "\n" + //$NON-NLS-1$ //$NON-NLS-2$
					"\tcategory: \t" + getCategory() + "\n"; //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	private static final class Tuple {

		FluentProjectionAnnotation annotation;
		Position position;

		Tuple(FluentProjectionAnnotation annotation, Position position) {
			this.annotation = annotation;
			this.position = position;
		}
	}

	/**
	 * Projection position that will return two foldable regions: one folding away the region from after
	 * the start sequence to the beginning of the content, the other from after the first content line
	 * until after the end sequence.
	 */
	private static final class CommentPosition extends Position implements IProjectionPosition {

		CommentPosition(int offset, int length) {
			super(offset, length);
		}

		@Override
		public IRegion[] computeProjectionRegions(IDocument document) throws BadLocationException {
			DocumentCharacterIterator sequence = new DocumentCharacterIterator(document, offset, offset + length);
			int prefixEnd = 0;
			int contentStart = findFirstContent(sequence, prefixEnd);

			int firstLine = document.getLineOfOffset(offset + prefixEnd);
			int captionLine = document.getLineOfOffset(offset + contentStart);
			int lastLine = document.getLineOfOffset(offset + length);

			Assert.isTrue(firstLine <= captionLine, "first folded line is greater than the caption line"); //$NON-NLS-1$
			Assert.isTrue(captionLine <= lastLine, "caption line is greater than the last folded line"); //$NON-NLS-1$

			IRegion preRegion;
			if (firstLine < captionLine) {
				int preOffset = document.getLineOffset(firstLine);
				IRegion preEndLineInfo = document.getLineInformation(captionLine);
				int preEnd = preEndLineInfo.getOffset();
				preRegion = new Region(preOffset, preEnd - preOffset);
			} else {
				preRegion = null;
			}

			if (captionLine < lastLine) {
				int postOffset = document.getLineOffset(captionLine + 1);
				IRegion postRegion = new Region(postOffset, offset + length - postOffset);

				if (preRegion == null) return new IRegion[] { postRegion };

				return new IRegion[] { preRegion, postRegion };
			}

			if (preRegion != null) return new IRegion[] { preRegion };

			return null;
		}

		/**
		 * Finds the offset of the first identifier part within <code>content</code>. Returns 0 if none is
		 * found.
		 *
		 * @param content the content to search
		 * @return the first index of a unicode identifier part, or zero if none can be found
		 */
		private int findFirstContent(final CharSequence content, int prefixEnd) {
			int lenght = content.length();
			for (int i = prefixEnd; i < lenght; i++) {
				if (Character.isUnicodeIdentifierPart(content.charAt(i))) return i;
			}
			return 0;
		}

		@Override
		public int computeCaptionOffset(IDocument document) {
			DocumentCharacterIterator sequence = new DocumentCharacterIterator(document, offset, offset + length);
			return findFirstContent(sequence, 0);
		}
	}

	private final class ProjectionListener implements IProjectionListener {

		private ProjectionViewer viewer;

		/**
		 * Registers the listener with the viewer.
		 *
		 * @param viewer the viewer to register a listener with
		 */
		public ProjectionListener(ProjectionViewer viewer) {
			Assert.isLegal(viewer != null);
			this.viewer = viewer;
			this.viewer.addProjectionListener(this);
		}

		/**
		 * Disposes of this listener and removes the projection listener from the viewer.
		 */
		public void dispose() {
			if (viewer != null) {
				viewer.removeProjectionListener(this);
				viewer = null;
			}
		}

		@Override
		public void projectionEnabled() {
			handleProjectionEnabled();
		}

		@Override
		public void projectionDisabled() {
			handleProjectionDisabled();
		}
	}

	/** Implementation of <code>IRegion</code> that can be reused by setting offset and length. */
	private static class ModifiableRegion extends Position implements IRegion {

		ModifiableRegion() {
			super();
		}
	}

	/* context and listeners */
	private FluentEditor editor;
	private IPreferenceStore store;
	private ProjectionListener projectionListener;
	protected IEditorInput input;

	/* preferences */
	private int collapseMinLimit = 2;
	private boolean frontMatterFoldingEnabled;
	private boolean codeBlockFoldingEnabled;
	private boolean htmlBlockFoldingEnabled;
	private boolean commentFoldingEnabled;
	private boolean collapseFrontMatter;
	private boolean collapseComments;
	private boolean collapseCodeBlocks;
	private boolean collapseHtmlBlocks;

	private IReconcilingListener reconilingListener;
	private volatile boolean initialReconcilePending = true;

	@Override
	public void install(ITextEditor editor, ProjectionViewer viewer, IPreferenceStore store) {
		Assert.isLegal(editor != null);
		Assert.isLegal(viewer != null);

		internalUninstall();
		this.store = store;

		if (editor instanceof FluentEditor) {
			this.editor = (FluentEditor) editor;
			this.projectionListener = new ProjectionListener(viewer);
		}
	}

	@Override
	public void uninstall() {
		internalUninstall();
	}

	private void internalUninstall() {
		if (isInstalled()) {
			handleProjectionDisabled();
			projectionListener.dispose();
			projectionListener = null;
			editor = null;
		}
	}

	/**
	 * Returns <code>true</code> if the provider is installed, <code>false</code> otherwise.
	 *
	 * @return <code>true</code> if the provider is installed, <code>false</code> otherwise
	 */
	protected final boolean isInstalled() {
		return editor != null;
	}

	/**
	 * Called whenever projection is enabled, for example when the viewer issues a
	 * {@link IProjectionListener#projectionEnabled() projectionEnabled} message. When the provider is
	 * already enabled when this method is called, it is first {@link #handleProjectionDisabled()
	 * disabled}.
	 * <p>
	 * Subclasses may extend.
	 * </p>
	 */
	protected void handleProjectionEnabled() {
		// make sure to disable first when getting an enable message
		handleProjectionDisabled();

		if (isInstalled()) {
			initialize();
			reconilingListener = new FoldingStructureReconciler();
			editor.addReconcileListener(reconilingListener);
		}
	}

	/**
	 * Called whenever projection is disabled, for example when the provider is {@link #uninstall()
	 * uninstalled}, when the viewer issues a {@link IProjectionListener#projectionDisabled()
	 * projectionDisabled} message and before {@link #handleProjectionEnabled() enabling} the provider.
	 * Implementations must be prepared to handle multiple calls to this method even if the provider is
	 * already disabled.
	 * <p>
	 * Subclasses may extend.
	 * </p>
	 */
	protected void handleProjectionDisabled() {
		if (reconilingListener != null) {
			editor.removeReconcileListener(reconilingListener);
			reconilingListener = null;
		}
	}

	@Override
	public final void initialize() {
		initialReconcilePending = true;
		update(createInitialContext());
	}

	private FoldingStructureComputationContext createInitialContext() {
		initializePreferences();
		input = getInputElement();
		if (input == null) return null;

		return createContext(true);
	}

	private FoldingStructureComputationContext createContext(boolean allowCollapse) {
		if (!isInstalled()) return null;
		ProjectionAnnotationModel model = getModel();
		if (model == null) return null;
		IDocument doc = getDocument();
		if (doc == null) return null;

		return new FoldingStructureComputationContext(doc, model, allowCollapse);
	}

	private IEditorInput getInputElement() {
		if (editor == null) return null;
		return editor.getEditorInput();
	}

	private void initializePreferences() {
		collapseMinLimit = store.getInt(Prefs.FOLDING_LINES_LIMIT);

		frontMatterFoldingEnabled = store.getBoolean(Prefs.FOLDING_FRONTMATTER_ENABLED);
		commentFoldingEnabled = store.getBoolean(Prefs.FOLDING_HIDDEN_COMMENTS_ENABLED);
		codeBlockFoldingEnabled = store.getBoolean(Prefs.FOLDING_CODEBLOCKS_ENABLED);
		htmlBlockFoldingEnabled = store.getBoolean(Prefs.FOLDING_HTMLBLOCKS_ENABLED);

		collapseFrontMatter = store.getBoolean(Prefs.FOLDING_INITIAL_FRONT_MATTER);
		collapseComments = store.getBoolean(Prefs.FOLDING_INITIAL_HIDDEN_COMMENTS);
		collapseCodeBlocks = store.getBoolean(Prefs.FOLDING_INITIAL_CODEBLOCKS);
		collapseHtmlBlocks = store.getBoolean(Prefs.FOLDING_INITIAL_HTMLBLOCKS);
	}

	private void update(FoldingStructureComputationContext ctx) {
		if (ctx == null /* || !isConsistent(input) */) return;

		Map<FluentProjectionAnnotation, Position> additions = new HashMap<>();
		List<FluentProjectionAnnotation> deletions = new ArrayList<>();
		List<FluentProjectionAnnotation> updates = new ArrayList<>();

		computeFoldingStructure(ctx);
		Map<FluentProjectionAnnotation, Position> newStructure = ctx.fMap;
		Map<Object, List<Tuple>> oldStructure = computeCurrentStructure(ctx);

		Iterator<FluentProjectionAnnotation> e = newStructure.keySet().iterator();
		while (e.hasNext()) {
			FluentProjectionAnnotation newAnnotation = e.next();
			Object element = newAnnotation.getElement();
			Position newPosition = newStructure.get(newAnnotation);

			List<Tuple> annotations = oldStructure.get(element);
			if (annotations == null) {
				additions.put(newAnnotation, newPosition);
			} else {
				Iterator<Tuple> annoItr = annotations.iterator();
				boolean matched = false;
				while (annoItr.hasNext()) {
					Tuple tuple = annoItr.next();
					FluentProjectionAnnotation existingAnnotation = tuple.annotation;
					Position existingPosition = tuple.position;
					if (newAnnotation.getCategory() == existingAnnotation.getCategory()) {
						boolean collapseChanged = ctx.allowCollapsing()
								&& existingAnnotation.isCollapsed() != newAnnotation.isCollapsed();
						if (existingPosition != null && (collapseChanged || !newPosition.equals(existingPosition))) {
							existingPosition.setOffset(newPosition.getOffset());
							existingPosition.setLength(newPosition.getLength());
							if (collapseChanged) {
								if (newAnnotation.isCollapsed()) {
									existingAnnotation.markCollapsed();
								} else {
									existingAnnotation.markExpanded();
								}
							}
							updates.add(existingAnnotation);
						}
						matched = true;
						annoItr.remove();
						break;
					}
				}
				if (!matched) {
					additions.put(newAnnotation, newPosition);
				}
				if (annotations.isEmpty()) oldStructure.remove(element);
			}
		}

		Iterator<List<Tuple>> e2 = oldStructure.values().iterator();
		while (e2.hasNext()) {
			List<Tuple> list = e2.next();
			int size = list.size();
			for (int i = 0; i < size; i++) {
				FluentProjectionAnnotation annotation = list.get(i).annotation;
				deletions.add(annotation);
			}
		}

		match(deletions, additions, updates, ctx);

		Annotation[] removals = deletions.toArray(new Annotation[deletions.size()]);
		Annotation[] changes = updates.toArray(new Annotation[updates.size()]);
		ctx.getModel().modifyAnnotations(removals, additions, changes);
	}

	/**
	 * Matches deleted annotations to changed or added ones. A deleted annotation/position tuple that
	 * has a matching addition / change is updated and marked as changed. The matching tuple is not
	 * added (for additions) or marked as deletion instead (for changes). The result is that more
	 * annotations are changed and fewer get deleted/re-added.
	 */
	private void match(List<FluentProjectionAnnotation> deletions, Map<FluentProjectionAnnotation, Position> additions,
			List<FluentProjectionAnnotation> changes, FoldingStructureComputationContext ctx) {
		if (deletions.isEmpty() || additions.isEmpty() && changes.isEmpty()) return;

		List<FluentProjectionAnnotation> newDeletions = new ArrayList<>();
		List<FluentProjectionAnnotation> newChanges = new ArrayList<>();

		Iterator<FluentProjectionAnnotation> deletionIterator = deletions.iterator();
		while (deletionIterator.hasNext()) {
			FluentProjectionAnnotation deleted = deletionIterator.next();
			Position deletedPosition = ctx.getModel().getPosition(deleted);
			if (deletedPosition == null) continue;

			Tuple deletedTuple = new Tuple(deleted, deletedPosition);

			Tuple match = findMatch(deletedTuple, changes, null, ctx);
			boolean addToDeletions = true;
			if (match == null) {
				match = findMatch(deletedTuple, additions.keySet(), additions, ctx);
				addToDeletions = false;
			}

			if (match != null) {
				Object element = match.annotation.getElement();
				deleted.setElement(element);
				deletedPosition.setLength(match.position.getLength());
				deletionIterator.remove();
				newChanges.add(deleted);

				if (addToDeletions) {
					newDeletions.add(match.annotation);
				}
			}
		}

		deletions.addAll(newDeletions);
		changes.addAll(newChanges);
	}

	/**
	 * Finds a match for <code>tuple</code> in a collection of annotations. The positions for the
	 * <code>FluentProjectionAnnotation</code> instances in <code>annotations</code> can be found in the
	 * passed <code>positionMap</code> or in the model if <code>positionMap</code> is <code>null</code>.
	 * <p>
	 * A tuple is said to match another if their annotations have the same category and their position
	 * offsets are equal.
	 * </p>
	 * <p>
	 * If a match is found, the annotation gets removed from <code>annotations</code>.
	 * </p>
	 *
	 * @param tuple the tuple for which we want to find a match
	 * @param annotations collection of <code>FluentProjectionAnnotation</code>
	 * @param positionMap a <code>Map&lt;Annotation, Position&gt;</code> or <code>null</code>
	 * @return a matching tuple or <code>null</code> for no match
	 */
	private Tuple findMatch(Tuple tuple, Collection<FluentProjectionAnnotation> annotations,
			Map<FluentProjectionAnnotation, Position> positionMap, FoldingStructureComputationContext ctx) {
		Iterator<FluentProjectionAnnotation> it = annotations.iterator();
		while (it.hasNext()) {
			FluentProjectionAnnotation annotation = it.next();
			if (tuple.annotation.getCategory() == annotation.getCategory()) {
				Position position = positionMap == null ? ctx.getModel().getPosition(annotation)
						: positionMap.get(annotation);
				if (position == null) continue;

				if (tuple.position.getOffset() == position.getOffset()) {
					it.remove();
					return new Tuple(annotation, position);
				}
			}
		}

		return null;
	}

	private Map<Object, List<Tuple>> computeCurrentStructure(FoldingStructureComputationContext ctx) {
		Map<Object, List<Tuple>> map = new HashMap<>();
		ProjectionAnnotationModel model = ctx.getModel();
		Iterator<?> e = model.getAnnotationIterator();
		while (e.hasNext()) {
			Object annotation = e.next();
			if (annotation instanceof FluentProjectionAnnotation) {
				FluentProjectionAnnotation fpa = (FluentProjectionAnnotation) annotation;
				Position position = model.getPosition(fpa);
				assert position != null;
				List<Tuple> list = map.get(fpa.getElement());
				if (list == null) {
					list = new ArrayList<>(2);
					map.put(fpa.getElement(), list);
				}
				list.add(new Tuple(fpa, position));
			}
		}

		Comparator<Tuple> comparator = new Comparator<Tuple>() {

			@Override
			public int compare(Tuple t1, Tuple t2) {
				return t1.position.getOffset() - t2.position.getOffset();
			}
		};
		for (List<Tuple> list : map.values()) {
			Collections.sort(list, comparator);
		}
		return map;
	}

	private void computeFoldingStructure(final FoldingStructureComputationContext ctx) {
		try {
			IDocument doc = ctx.getDocument();
			ITypedRegion[] partitions = TextUtilities.computePartitioning(doc, Partitions.PARTITIONING, 0,
					doc.getLength(), false);
			computeBlockFoldingStructure(partitions, ctx);
		} catch (BadLocationException e) {}
	}

	/**
	 * Compute folding structure based on partioning information.
	 *
	 * @param partitions array of document partitions
	 * @param ctx the folding structure context
	 * @throws BadLocationException
	 */
	private void computeBlockFoldingStructure(ITypedRegion[] partitions, FoldingStructureComputationContext ctx)
			throws BadLocationException {
		boolean collapse = ctx.collapseComments();
		IDocument doc = ctx.getDocument();
		int startLine = -1;
		int endLine = -1;
		List<Tuple> comments = new ArrayList<>();
		ModifiableRegion commentRange = new ModifiableRegion();
		for (ITypedRegion partition : partitions) {
			if (isFoldablePartition(partition.getType())) {
				Position position = createBlockPosition(alignRegion(partition, ctx, true));
				if (position != null) {
					if (startLine >= 0 && endLine - startLine >= collapseMinLimit) {
						Position projection = createBlockPosition(alignRegion(commentRange, ctx, true));
						if (projection != null) {
							comments.add(new Tuple(
									new FluentProjectionAnnotation(collapse,
											doc.get(projection.offset, Math.min(16, projection.length)), true),
									projection));
						}
						startLine = -1;
					}
					comments.add(new Tuple(new FluentProjectionAnnotation(collapse,
							doc.get(position.offset, Math.min(16, position.length)), true), position));
				}
			}
		}
		if (startLine >= 0 && endLine - startLine >= collapseMinLimit) {
			Position projection = createBlockPosition(alignRegion(commentRange, ctx, true));
			if (projection != null) {
				comments.add(new Tuple(new FluentProjectionAnnotation(collapse,
						doc.get(projection.offset, Math.min(16, projection.length)), true), projection));
			}
		}
		if (!comments.isEmpty()) {
			Iterator<Tuple> iter = comments.iterator();
			Tuple tuple = iter.next();
			tuple.annotation.markExpanded();
			ctx.addProjectionRange(tuple.annotation, tuple.position);
			while (iter.hasNext()) {
				tuple = iter.next();
				ctx.addProjectionRange(tuple.annotation, tuple.position);
			}
		}
	}

	private boolean isFoldablePartition(String type) {
		switch (type) {
			case Partitions.FRONT_MATTER:
				return frontMatterFoldingEnabled;
			case Partitions.COMMENT:
				return commentFoldingEnabled;
			case Partitions.DOTBLOCK:
			case Partitions.CODEBLOCK:
			case Partitions.MATHBLOCK:
			case Partitions.UMLBLOCK:
				return codeBlockFoldingEnabled;
			case Partitions.HTMLBLOCK:
				return htmlBlockFoldingEnabled;
		}
		return false;
	}

	/**
	 * Computes the projection range for a given <code>ISourceReference</code> represenging a single
	 * Statement. If there are no foldable regions, an empty array is returned.
	 * <p>
	 * The region in the returned array (if not empty) describes the region for the DSL element that
	 * implements the source reference.
	 * </p>
	 *
	 * @param reference a Dsl element that is a source reference
	 * @param ctx the folding context
	 * @return the regions to be folded
	 */
	protected final IRegion[] computeProjectionRanges(ISourceReference reference,
			FoldingStructureComputationContext ctx) {

		ISourceRange range = reference.getSourceRange();
		if (!SourceRange.isAvailable(range)) return new IRegion[0];

		String contents = reference.getContent();
		if (contents == null) return new IRegion[0];

		return new IRegion[] { new Region(range.getStartPos(), range.getLength()) };
	}

	/**
	 * Creates a block folding position from an
	 * {@link #alignRegion(IRegion, DslFoldingStructureProvider.FoldingStructureComputationContext, boolean)
	 * aligned} region.
	 *
	 * @param aligned an aligned region
	 * @return a folding position corresponding to <code>aligned</code>
	 */
	protected final Position createBlockPosition(IRegion aligned) {
		if (aligned == null) return null;
		return new CommentPosition(aligned.getOffset(), aligned.getLength());
	}

	/**
	 * Aligns <code>region</code> to start and end at a line offset. The region's start is decreased to
	 * the next line offset, and the end offset increased to the next line start or the end of the
	 * document. <code>null</code> is returned if <code>region</code> is <code>null</code> itself or
	 * does not comprise at least one line delimiter, as a single line cannot be folded.
	 *
	 * @param region the region to align, may be <code>null</code>
	 * @param ctx the folding context
	 * @return a region equal or greater than <code>region</code> that is aligned with line offsets,
	 *         <code>null</code> if the region is too small to be foldable (e.g. covers only one line)
	 */
	protected final IRegion alignRegion(IRegion region, FoldingStructureComputationContext ctx) {
		return alignRegion(region, ctx, true);
	}

	/**
	 * Aligns <code>region</code> to start and end at a line offset. The region's start is decreased to
	 * the next line offset, and the end offset increased to the next line start or the end of the
	 * document. <code>null</code> is returned if <code>region</code> is <code>null</code> itself or
	 * does not comprise at least one line delimiter, as a single line cannot be folded.
	 *
	 * @param region the region to align, may be <code>null</code>
	 * @param ctx the folding context
	 * @param inclusive include line of end offset
	 * @return a region equal or greater than <code>region</code> that is aligned with line offsets,
	 *         <code>null</code> if the region is too small to be foldable (e.g. covers only one line)
	 */
	protected final IRegion alignRegion(IRegion region, FoldingStructureComputationContext ctx, boolean inclusive) {
		if (region == null) return null;

		IDocument doc = ctx.getDocument();
		try {
			int start = doc.getLineOfOffset(region.getOffset());
			int end = doc.getLineOfOffset(region.getOffset() + region.getLength());
			if (start >= end) return null;

			int offset = doc.getLineOffset(start);
			int endOffset;
			if (inclusive) {
				if (doc.getNumberOfLines() > end + 1) {
					endOffset = doc.getLineOffset(end + 1);
				} else {
					endOffset = doc.getLineOffset(end) + doc.getLineLength(end);
				}
			} else {
				endOffset = doc.getLineOffset(end);
			}
			return new Region(offset, endOffset - offset);

		} catch (BadLocationException e) {
			return null;
		}
	}

	private ProjectionAnnotationModel getModel() {
		return editor.getAdapter(ProjectionAnnotationModel.class);
	}

	private IDocument getDocument() {
		if (editor == null) return null;
		IDocumentProvider provider = editor.getDocumentProvider();
		if (provider == null) return null;
		return provider.getDocument(editor.getEditorInput());
	}
}
