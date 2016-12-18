package net.certiv.fluentmark.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;

public class MoveSectionHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// IWorkbenchPart part = HandlerUtil.getActivePart(event);
		return null;
	}

	// /**
	// * Move the selected sections up/down
	// *
	// * @param i 1 or -1. 1==move later, -1=earlier
	// * @throws BadLocationException
	// */
	// protected void doMove(int i) throws BadLocationException {
	// assert i == 1 || i == -1;
	// if (selectedHeaders == null || selectedHeaders.size() == 0) return;
	// // Get text region to move
	// PageModel.Header first = selectedHeaders.get(0);
	// PageModel.Header last = selectedHeaders.get(selectedHeaders.size() - 1);
	// int start = editor.getDocument().getLineOffset(first.getLineNumber());
	// IRegion r = getRegion(last);
	// int end = r.getOffset() + r.getLength();
	// // int length = end - start;
	// // Get new insertion point
	// int insert;
	// if (i == 1) {
	// Header nextSection = last.getNext();
	// if (nextSection == null) return;
	// IRegion nr = getRegion(nextSection);
	// insert = nr.getOffset() + nr.getLength();
	// } else {
	// Header prevSection = first.getPrevious();
	// if (prevSection == null) return;
	// IRegion nr = getRegion(prevSection);
	// insert = nr.getOffset();
	// }
	// // Get text
	// String text = editor.getDocument().get();
	// // Move text
	// String section = text.substring(start, end);
	// String pre, post;
	// if (i == 1) {
	// pre = text.substring(0, start) + text.substring(end, insert);
	// post = text.substring(insert);
	// } else {
	// pre = text.substring(0, insert);
	// post = text.substring(insert, start) + text.substring(end);
	// }
	// text = pre + section + post;
	// assert text.length() == editor.getDocument().get().length() : text.length()
	// - editor.getDocument().get().length() + " chars gained/lost";
	// // Update doc
	// editor.getDocument().set(text);
	// }
}
