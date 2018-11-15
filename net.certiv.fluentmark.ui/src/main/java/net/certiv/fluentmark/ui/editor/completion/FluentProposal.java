package net.certiv.fluentmark.ui.editor.completion;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.ui.DslUI;
import net.certiv.dsl.ui.editor.text.completion.DslCompletionProposal;
import net.certiv.fluentmark.core.FluentCore;
import net.certiv.fluentmark.ui.FluentUI;

public class FluentProposal extends DslCompletionProposal {

	public FluentProposal(String completion, int start, int length, Image image, StyledString label, int relevance,
			boolean inDoc) {
		super(completion, start, length, image, label, relevance, inDoc);
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
	public char[] getPrefixCompletionTextStops() {
		return new char[] { LBRACK, LBRACE };
	}

	@Override
	public String getIdString() {
		return getDisplayString();
	}

	@Override
	protected boolean isSmartTrigger(char trigger) {
		return false;
		// trigger == SEMI && getPrefsMgr().getBoolean(Editor.EDITOR_SMART_SEMICOLON)
		// || trigger == LBRACE && getPrefsMgr().getBoolean(Editor.EDITOR_SMART_OPENING_BRACE);
	}

	@Override
	protected void handleSmartTrigger(IDocument document, char trigger, int referenceOffset)
			throws BadLocationException {

		// DocumentCommand cmd = new DocumentCommand() {};
		//
		// cmd.offset = referenceOffset;
		// cmd.length = 0;
		// cmd.text = Character.toString(trigger);
		// cmd.doit = true;
		// cmd.shiftsCaret = true;
		// cmd.caretOffset = getReplacementOffset() + getCursorPosition();
		//
		// SmartAutoEditSemicolonStrategy strategy = new
		// SmartAutoEditSemicolonStrategy(Partitions.PARTITIONING);
		// strategy.customizeDocumentCommand(document, cmd);
		//
		// replace(document, cmd.offset, cmd.length, cmd.text);
		// setCursorPosition(cmd.caretOffset - getReplacementOffset() + cmd.text.length());
	}
}
