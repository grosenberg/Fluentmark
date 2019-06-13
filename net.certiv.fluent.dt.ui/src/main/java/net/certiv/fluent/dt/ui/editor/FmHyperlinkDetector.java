package net.certiv.fluent.dt.ui.editor;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;

import net.certiv.dsl.core.model.DslModel;
import net.certiv.dsl.core.model.IStatement;
import net.certiv.dsl.ui.editor.hyperlink.DslHyperlinkDetector;
import net.certiv.dsl.ui.editor.text.DslWordFinder;
import net.certiv.fluent.dt.core.FluentCore;

public class FmHyperlinkDetector extends DslHyperlinkDetector {

	private DslWordFinder finder;

	public FmHyperlinkDetector() {
		super();
		finder = new DslWordFinder();
	}

	@Override
	public IRegion findWord(IDocument doc, int offset) {
		return finder.findWord(doc, offset);
	}

	@Override
	public String getWord(IDocument doc, IRegion word) {
		return finder.getWord(doc, word);
	}

	/** Filter/modify the elements for display on the popup */
	@Override
	public IStatement[] selectOpenableElements(IStatement[] elements) {
		return elements;
	}

	@Override
	public DslModel getDslModel() {
		return FluentCore.getDefault().getDslModel();
	}
}
