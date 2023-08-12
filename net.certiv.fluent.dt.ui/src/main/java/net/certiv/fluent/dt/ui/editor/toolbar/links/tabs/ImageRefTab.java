package net.certiv.fluent.dt.ui.editor.toolbar.links.tabs;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import net.certiv.common.util.Strings;
import net.certiv.dsl.ui.util.SWTFactory;
import net.certiv.fluent.dt.core.lang.md.model.SpecSubType;
import net.certiv.fluent.dt.core.lang.md.model.SpecializedType;
import net.certiv.fluent.dt.ui.editor.toolbar.links.AbstractLinkTab;
import net.certiv.fluent.dt.ui.editor.toolbar.links.LinksInfo;

public class ImageRefTab extends AbstractLinkTab {

	private Text txtField;
	private Text refField;

	private Text uriField;
	private Text altField;

	public ImageRefTab(LinksInfo info, int idx) {
		super(info, idx, SpecializedType.Image, SpecSubType.REF);
	}

	@Override
	protected void createControls(Composite parent) {
		Composite comp = SWTFactory.createGroupComposite(parent, 2, 2, Strings.EMPTY);

		lineNum(comp, "Line", 6, info.selLn);
		txtField = labeledText(comp, "Text", 80, info.txt, null);
		refField = labeledText(comp, "Ref", 80, info.ref, new RefValidator(txtField));
		SWTFactory.createVerticalSpacer(comp, 1, 2);

		lineNum(comp, "Line", 6, info.defLn);
		uriField = labeledText(comp, "URI", 80, info.uri, new URIValidator());
		altField = labeledText(comp, "Alt", 80, info.alt, new AltValidator());
		SWTFactory.createVerticalSpacer(comp, 1, 2);
	}

	@Override
	protected String getLinkText() {
		String txt = txtField.getText().trim();
		String ref = refField.getText().trim();
		return String.format("![%s][%s]", txt, ref);
	}

	@Override
	protected String getDefText() {
		String ref = refField.getText().trim();
		String uri = uriField.getText().trim();
		String alt = altField.getText().trim();
		if (!alt.isEmpty()) return String.format("[%s]: %s \"%s\"", ref, uri, alt);
		return String.format("[%s]: %s", ref, uri);
	}
}
