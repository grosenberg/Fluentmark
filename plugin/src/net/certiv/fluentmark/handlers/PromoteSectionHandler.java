package net.certiv.fluentmark.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;

public class PromoteSectionHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// IWorkbenchPart part = HandlerUtil.getActivePart(event);
		return null;
	}

	// /**
	// * Does not support -------- / ========= underlining, only # headers
	// *
	// * @param upDown 1 for demote (e.g. h2 -> h3), -1 for promote (e.g. h2 -> h1)
	// */
	// protected void doPromoteDemote(int upDown) {
	// assert upDown == 1 || upDown == -1;
	// if (selectedHeaders == null || selectedHeaders.size() == 0) return;
	// HashSet<Header> toAdjust = new HashSet<Header>(selectedHeaders);
	// HashSet<Header> adjusted = new HashSet<Header>();
	// // Adjust
	// PageModel mdPage = editor.getMarkdownPage();
	// List<String> lines = new ArrayList<String>(mdPage.getText());
	// while (toAdjust.size() != 0) {
	// Header h = toAdjust.iterator().next();
	// toAdjust.remove(h);
	// adjusted.add(h);
	// String line = lines.get(h.getLineNumber());
	// if (upDown == -1) {
	// if (h.getLevel() == 1) return; // Level 1; can't promote
	// if (line.startsWith("##"))
	// line = line.substring(1);
	// else {
	// return; // TODO support for ------ / ========
	// }
	// } else
	// line = "#" + line;
	// int ln = h.getLineNumber();
	// lines.set(ln, line);
	// // kids
	// ArrayList<Header> kids = new ArrayList<Header>(h.getSubHeaders());
	// for (Header header : kids) {
	// if (!adjusted.contains(header)) toAdjust.add(header);
	// }
	// }
	// // Set
	// StringBuilder sb = new StringBuilder();
	// for (String line : lines) {
	// sb.append(line);
	// }
	// editor.getDocument().set(sb.toString());
	// }
}
