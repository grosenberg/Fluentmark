package net.certiv.fluentmark.handlers;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.BadPartitioningException;
import org.eclipse.jface.text.BadPositionCategoryException;
import org.eclipse.jface.text.DefaultPositionUpdater;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.jface.text.IPositionUpdater;
import org.eclipse.jface.text.IRewriteTarget;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.Position;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.ITextEditorExtension;
import org.eclipse.ui.texteditor.ITextEditorExtension2;

import net.certiv.fluentmark.editor.FluentMkEditor;
import net.certiv.fluentmark.editor.Partitions;

/**
 * Action that encloses the editor's current selection with hidden comment terminators
 * (<code><!---</code> and <code>---></code>).
 */
public class AddHiddenCommentHandler extends AbstractHandler implements IHandler {

	/**
	 * An edit is a kind of <code>DocumentEvent</code>, in this case an edit instruction, that is
	 * affiliated with a <code>Position</code> on a document. The offset of the document event is
	 * not stored statically, but taken from the affiliated <code>Position</code>, which gets
	 * updated when other edits occur.
	 */
	static class Edit extends DocumentEvent {

		/**
		 * Factory for edits which manages the creation, installation and destruction of position
		 * categories, position updaters etc. on a certain document. Once a factory has been
		 * obtained, <code>Edit</code> objects can be obtained from it which will be linked to the
		 * document by positions of one position category.
		 * <p>
		 * Clients are required to call <code>release</code> once the <code>Edit</code>s are not
		 * used any more, so the positions can be discarded.
		 * </p>
		 */
		public static class EditFactory {

			/** The position category basename for this edits. */
			private static final String CATEGORY = "__positionalEditPositionCategory"; //$NON-NLS-1$

			/** The count of factories. */
			private static int fgCount = 0;

			/** This factory's category. */
			private final String fCategory;
			private IDocument fDocument;
			private IPositionUpdater fUpdater;

			/**
			 * Creates a new <code>EditFactory</code> with an unambiguous position category name.
			 * 
			 * @param document the document that is being edited.
			 */
			public EditFactory(IDocument document) {
				fCategory = CATEGORY + fgCount++;
				fDocument = document;
			}

			/**
			 * Creates a new edition on the document of this factory.
			 *
			 * @param offset the offset of the edition at the point when is created.
			 * @param length the length of the edition (not updated via the position update
			 *            mechanism)
			 * @param text the text to be replaced on the document
			 * @return an <code>Edit</code> reflecting the edition on the document
			 */
			public Edit createEdit(int offset, int length, String text) throws BadLocationException {

				if (!fDocument.containsPositionCategory(fCategory)) {
					fDocument.addPositionCategory(fCategory);
					fUpdater = new DefaultPositionUpdater(fCategory);
					fDocument.addPositionUpdater(fUpdater);
				}

				Position position = new Position(offset);
				try {
					fDocument.addPosition(fCategory, position);
				} catch (BadPositionCategoryException e) {
					Assert.isTrue(false);
				}
				return new Edit(fDocument, length, text, position);
			}

			/**
			 * Releases the position category on the document and uninstalls the position updater.
			 * <code>Edit</code>s managed by this factory are not updated after this call.
			 */
			public void release() {
				if (fDocument != null && fDocument.containsPositionCategory(fCategory)) {
					fDocument.removePositionUpdater(fUpdater);
					try {
						fDocument.removePositionCategory(fCategory);
					} catch (BadPositionCategoryException e) {
						Assert.isTrue(false);
					}
					fDocument = null;
					fUpdater = null;
				}
			}
		}

		/** The position in the document where this edit be executed. */
		private Position fPosition;

		/**
		 * Creates a new edition on <code>document</code>, taking its offset from
		 * <code>position</code>.
		 *
		 * @param document the document being edited
		 * @param length the length of the edition
		 * @param text the replacement text of the edition
		 * @param position the position keeping the edition's offset
		 */
		protected Edit(IDocument document, int length, String text, Position position) {
			super(document, 0, length, text);
			fPosition = position;
		}

		/*
		 * @see org.eclipse.jface.text.DocumentEvent#getOffset()
		 */
		@Override
		public int getOffset() {
			return fPosition.getOffset();
		}

		/**
		 * Executes the edition on document. The offset is taken from the position.
		 *
		 * @throws BadLocationException if the execution of the document fails.
		 */
		public void perform() throws BadLocationException {
			getDocument().replace(getOffset(), getLength(), getText());
		}

	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IEditorPart part = HandlerUtil.getActiveEditor(event);
		if (part instanceof FluentMkEditor) {
			FluentMkEditor editor = (FluentMkEditor) part;
			if (!isEnabled() || !ensureEditable(editor)) return null;
			if (!validateEditorInputState(editor)) return null;

			ITextSelection sel = (ITextSelection) HandlerUtil.getCurrentSelection(event);
			if (!isValidSelection(sel)) return null;

			IDocument doc = editor.getDocument();
			if (doc instanceof IDocumentExtension3) return null;
			IDocumentExtension3 doc3 = (IDocumentExtension3) doc;

			IRewriteTarget target = (IRewriteTarget) editor.getAdapter(IRewriteTarget.class);
			if (target != null) target.beginCompoundChange();

			Edit.EditFactory factory = new Edit.EditFactory(doc);

			try {
				int selectionOffset = sel.getOffset();
				int selectionEndOffset = selectionOffset + sel.getLength();
				List<Edit> edits = new LinkedList<>();
				ITypedRegion partition = doc3.getPartition(Partitions.MK_PARTITIONING, selectionOffset, false);

				handleFirstPartition(partition, edits, factory, selectionOffset);

				while (partition.getOffset() + partition.getLength() < selectionEndOffset) {
					partition = handleInteriorPartition(partition, edits, factory, doc3);
				}

				handleLastPartition(partition, edits, factory, selectionEndOffset);
				executeEdits(edits);

			} catch (BadLocationException e) {
				// can happen on concurrent modification, deletion etc. of the document
			} catch (BadPartitioningException e) {
				Assert.isTrue(false, "bad partitioning");  //$NON-NLS-1$
			} finally {
				factory.release();
				if (target != null) {
					target.endCompoundChange();
				}
			}
		}
		return null;
	}

	/**
	 * Handle the partition under the start offset of the selection.
	 *
	 * @param partition the partition under the start of the selection
	 * @param edits the list of edits to later execute
	 * @param factory the factory for edits
	 * @param offset the start of the selection, which must lie inside <code>partition</code>
	 */
	private void handleFirstPartition(ITypedRegion partition, List<Edit> edits, Edit.EditFactory factory, int offset)
			throws BadLocationException {

		int partOffset = partition.getOffset();
		String partType = partition.getType();

		Assert.isTrue(partOffset <= offset, "illegal partition"); //$NON-NLS-1$

		// first partition: mark start of comment
		if (partType == IDocument.DEFAULT_CONTENT_TYPE) {
			// Java code: right where selection starts
			edits.add(factory.createEdit(offset, 0, getCommentStart()));
		} else if (isSpecialPartition(partType)) {
			// special types: include the entire partition
			edits.add(factory.createEdit(partOffset, 0, getCommentStart()));
		}	// javadoc: no mark, will only start after comment

	}

	/**
	 * Handles partition boundaries within the selection. The end of the current partition and the
	 * start of the next partition are examined for whether they contain comment tokens that
	 * interfere with the created comment.
	 * <p>
	 * Comment tokens are removed from interior multi-line comments. Javadoc comments are left as
	 * is; instead, multi-line comment tokens are inserted before and after Javadoc partitions to
	 * ensure that the entire selected area is commented.
	 * </p>
	 * <p>
	 * The next partition is returned.
	 * </p>
	 *
	 * @param partition the current partition
	 * @param edits the list of edits to add to
	 * @param factory the edit factory
	 * @param docExtension the document to get the partitions from
	 * @return the next partition after the current
	 * @throws BadLocationException if accessing the document fails - this can only happen if the
	 *             document gets modified concurrently
	 * @throws BadPartitioningException if the document does not have a Java partitioning
	 */
	private ITypedRegion handleInteriorPartition(ITypedRegion partition, List<Edit> edits, Edit.EditFactory factory,
			IDocumentExtension3 docExtension) throws BadPartitioningException, BadLocationException {

		// end of previous partition
		String partType = partition.getType();
		int partEndOffset = partition.getOffset() + partition.getLength();
		int tokenLength = getCommentStart().length();

		if (partType == Partitions.COMMENT) {			// already in a comment - remove ending mark
			edits.add(factory.createEdit(partEndOffset - tokenLength, tokenLength, "")); //$NON-NLS-1$
		}

		// advance to next partition
		partition = docExtension.getPartition(Partitions.MK_PARTITIONING, partEndOffset, false);
		partType = partition.getType();

		if (partType == Partitions.COMMENT) {			// already in a comment - remove startToken
			edits.add(factory.createEdit(partition.getOffset(), getCommentStart().length(), "")); //$NON-NLS-1$
		}

		return partition;
	}

	/**
	 * Handles the partition under the end of the selection. For normal java code, the comment end
	 * token is inserted at the selection end; if the selection ends inside a special (i.e. string,
	 * character, line comment) partition, the entire partition is included inside the comment.
	 *
	 * @param partition the partition under the selection end offset
	 * @param edits the list of edits to add to
	 * @param factory the edit factory
	 * @param endOffset the end offset of the selection
	 */
	private void handleLastPartition(ITypedRegion partition, List<Edit> edits, Edit.EditFactory factory, int endOffset)
			throws BadLocationException {

		String partType = partition.getType();

		if (partType == IDocument.DEFAULT_CONTENT_TYPE) {
			// normal java: end comment where selection ends
			edits.add(factory.createEdit(endOffset, 0, getCommentEnd()));
		} else if (isSpecialPartition(partType)) {
			// special types: consume entire partition
			edits.add(factory.createEdit(partition.getOffset() + partition.getLength(), 0, getCommentEnd()));
		}

	}

	/**
	 * Returns whether <code>partType</code> is special, i.e. a Java
	 * <code>String</code>,<code>Character</code>, or <code>Line End Comment</code> partition.
	 *
	 * @param partType the partition type to check
	 * @return <code>true</code> if <code>partType</code> is special, <code>false</code> otherwise
	 */
	private boolean isSpecialPartition(String partType) {
		// return partType == Partitions.JAVA_CHARACTER || partType == Partitions.JAVA_STRING
		// || partType == Partitions.JAVA_SINGLE_LINE_COMMENT;
		return false;
	}

	protected boolean isValidSelection(ITextSelection selection) {
		return selection != null && !selection.isEmpty() && selection.getLength() > 0;
	}

	/**
	 * Checks and validates the editor's modifiable state. Returns <code>true</code> if an action
	 * can proceed modifying the editor's input, <code>false</code> if it should not.
	 * <p>
	 * If the editor implements <code>ITextEditorExtension2</code>, this method returns
	 * {@link ITextEditorExtension2#validateEditorInputState()};<br>
	 * else if the editor implements <code>ITextEditorExtension</code>, it returns
	 * {@link ITextEditorExtension#isEditorInputReadOnly()};<br>
	 * else, {@link ITextEditor#isEditable()} is returned, or <code>false</code> if the editor is
	 * <code>null</code>.
	 * </p>
	 * <p>
	 * There is only a difference to {@link #canModifyEditor()} if the editor implements
	 * <code>ITextEditorExtension2</code>.
	 * </p>
	 *
	 * @return <code>true</code> if a modifying action can proceed to modify the underlying
	 *         document, <code>false</code> otherwise
	 * @since 3.0
	 */
	protected boolean validateEditorInputState(FluentMkEditor editor) {
		if (editor instanceof ITextEditorExtension2)
			return ((ITextEditorExtension2) editor).validateEditorInputState();
		else if (editor instanceof ITextEditorExtension)
			return !((ITextEditorExtension) editor).isEditorInputReadOnly();
		else if (editor != null)
			return editor.isEditable();
		else
			return false;
	}

	/**
	 * Calls <code>perform</code> on all <code>Edit</code>s in <code>edits</code>.
	 *
	 * @param edits a list of <code>Edit</code>s
	 * @throws BadLocationException if an <code>Edit</code> threw such an exception.
	 */
	protected void executeEdits(List<Edit> edits) throws BadLocationException {
		for (Iterator<Edit> it = edits.iterator(); it.hasNext();) {
			Edit edit = it.next();
			edit.perform();
		}
	}

	/**
	 * Ensures that the editor is modifyable. If the editor is an instance of
	 * <code>ITextEditorExtension2</code>, its <code>validateEditorInputState</code> method is
	 * called, otherwise, the result of <code>isEditable</code> is returned.
	 *
	 * @param editor the editor to be checked
	 * @return <code>true</code> if the editor is editable, <code>false</code> otherwise
	 */
	protected boolean ensureEditable(ITextEditor editor) {
		Assert.isNotNull(editor);

		if (editor instanceof ITextEditorExtension2) {
			ITextEditorExtension2 ext = (ITextEditorExtension2) editor;
			return ext.validateEditorInputState();
		}

		return editor.isEditable();
	}

	/**
	 * Returns the text to be inserted at the selection start.
	 *
	 * @return the text to be inserted at the selection start
	 */
	protected String getCommentStart() {		// for now: no space story
		return "<!---"; //$NON-NLS-1$
	}

	/**
	 * Returns the text to be inserted at the selection end.
	 *
	 * @return the text to be inserted at the selection end
	 */
	protected String getCommentEnd() {		// for now: no space story
		return "--->"; //$NON-NLS-1$
	}
}
