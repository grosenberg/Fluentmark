package net.certiv.fluentmark.preferences.pages;

import static net.certiv.fluentmark.preferences.Prefs.*;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.swt.widgets.Composite;

import net.certiv.fluentmark.preferences.AbstractOptionsBlock;
import net.certiv.fluentmark.preferences.editors.ProgramFieldEditor;
import net.certiv.fluentmark.util.SwtUtil;

public class ConverterPandocOps extends AbstractOptionsBlock {

	private static final String PANDOC = "pandoc";
	private static final String[] PD_MSG = { "Invalid Pandoc executable",
			"Full pathname of the Pandoc executable [pandoc|pandoc.exe]", "pandoc" };

	private ProgramFieldEditor pandocExe;
	private DirectoryFieldEditor pandocTmplDir;

	public ConverterPandocOps(PrefPageConvert page, Composite parent, String title) {
		super(page, parent, title);
	}

	@Override
	protected void createControls(Composite comp) {
		Composite bools = SwtUtil.makeComposite(comp, 3, 1);
		addField(new BooleanFieldEditor(EDITOR_PANDOC_SMART, "Use smart typography", bools));
		addField(new BooleanFieldEditor(EDITOR_PANDOC_ADDTOC, "Add table of contents", bools));
		addField(new BooleanFieldEditor(EDITOR_PANDOC_MATHJAX, "Enable Mathjax rendering", bools));

		SwtUtil.addSpacer(comp, 3);
		pandocExe = new ProgramFieldEditor(EDITOR_PANDOC_PROGRAM, "Program:", comp, PD_MSG);
		addField(pandocExe);

		pandocTmplDir = new DirectoryFieldEditor(EDITOR_PANDOC_TEMPLATES, "LaTex Templates:", comp);
		addField(pandocTmplDir);
	}

	@Override
	public boolean validateSettings() {
		boolean ok = true;
		if (getPage().isSelected(KEY_PANDOC)) {
			ok = ok && checkPathExe(pandocExe.getStringValue(), PANDOC);
			ok = ok && checkPathDir(pandocTmplDir.getStringValue(), true);
		}
		return ok;
	}
}
