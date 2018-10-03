package net.certiv.fluentmark.ui.preferences.blocks;

import org.eclipse.swt.widgets.Composite;

import net.certiv.fluentmark.ui.preferences.pages.ConvertersPage;

public class NullConfigBlock extends AbstractConverterBlock {

	public NullConfigBlock(ConvertersPage page, Composite parent, String title) {
		super(page, parent, title);
	}

	@Override
	protected void createControls(Composite comp) {}

	@Override
	public boolean validateSettings() {
		return true;
	}
}
