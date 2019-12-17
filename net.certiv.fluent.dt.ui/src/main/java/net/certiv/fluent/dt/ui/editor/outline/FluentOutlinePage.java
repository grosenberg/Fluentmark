package net.certiv.fluent.dt.ui.editor.outline;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ILabelDecorator;

import net.certiv.fluent.dt.ui.FluentUI;

import net.certiv.dsl.ui.editor.DslEditor;
import net.certiv.dsl.ui.editor.DslOutlinePage;

public class FmOutlinePage extends DslOutlinePage {

	public FmOutlinePage(DslEditor editor, IPreferenceStore store) {
		super(FluentUI.getDefault(), editor, store);
	}

	@Override
	protected ILabelDecorator getLabelDecorator() {
		return new FmOutlineLabelDecorator();
	}
}
