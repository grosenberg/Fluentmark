package net.certiv.fluent.dt.ui.editor.toolbar.links.tabs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import net.certiv.common.util.Strings;
import net.certiv.dsl.ui.util.SWTFactory;
import net.certiv.fluent.dt.core.lang.md.model.SpecSubType;
import net.certiv.fluent.dt.core.lang.md.model.SpecializedType;
import net.certiv.fluent.dt.ui.editor.toolbar.links.AbstractLinkTab;
import net.certiv.fluent.dt.ui.editor.toolbar.links.LinksInfo;

public class FootnoteRefTab extends AbstractLinkTab {

	private Text refField;
	private Text defField;

	public FootnoteRefTab(LinksInfo info, int idx) {
		super(info, idx, SpecializedType.Footnote, SpecSubType.REF);
	}

	@Override
	protected void createControls(Composite parent) {
		Composite comp = SWTFactory.createGroupComposite(parent, 2, 2, Strings.EMPTY);

		lineNum(comp, "Line", 6, info.selLn);
		refField = labeledText(comp, "Ref", 80, info.ref, new RefValidator());
		SWTFactory.createVerticalSpacer(comp, 1, 2);

		lineNum(comp, "Line", 6, info.defLn);
		defField = labeledText(comp, SWT.MULTI, SWT.BEGINNING, "Def", 80, 6, info.def, null);
		SWTFactory.createVerticalSpacer(comp, 1, 2);
	}

	@Override
	protected String getLinkText() {
		String ref = refField.getText().trim();
		return String.format("[^%s]", ref);
	}

	@Override
	protected String getDefText() {
		String ref = refField.getText().trim();
		String def = defField.getText().trim();
		return String.format("[^%s]: %s", ref, def);
	}
}
