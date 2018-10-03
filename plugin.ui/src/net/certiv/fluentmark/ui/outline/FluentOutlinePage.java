/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.ui.outline;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;

import net.certiv.dsl.core.model.IDslElement;
import net.certiv.dsl.core.model.util.ISourceRef;
import net.certiv.dsl.ui.editor.DslOutlinePage;
import net.certiv.fluentmark.core.model.IPageElement;
import net.certiv.fluentmark.core.model.Item;
import net.certiv.fluentmark.core.preferences.Prefs;
import net.certiv.fluentmark.ui.FluentUI;
import net.certiv.fluentmark.ui.editor.FluentEditor;

/**
 * The content outline page of the Fluent editor. Publishes its context menu under
 * <code>FluentUI.getDefault().getPluginId() + ".outline"</code>.
 */
public class FluentOutlinePage extends DslOutlinePage {

	/** Content provider for the PagePart children of a Page. */
	protected class ChildrenProvider extends DefaultChildrenProvider {

		// conditional blank lines filter
		@Override
		protected IDslElement[] filter(ISourceRef node) {
			if (store.getBoolean(Prefs.EDITOR_OUTLINE_SHOW_BLANKLINES)) {
				return super.filter(node);
			}

			List<IPageElement> filtered = new ArrayList<>();
			for (IDslElement child : node.getChildren()) {
				if (child instanceof IPageElement) {
					IPageElement elem = (IPageElement) child;
					if (elem.getItem() != Item.BLANK) {
						filtered.add(elem);
					}
				}
			}
			return filtered.toArray(new IPageElement[filtered.size()]);
		}
	}

	public FluentOutlinePage(FluentEditor editor, IPreferenceStore store) {
		super(FluentUI.getDefault(), editor, store);
	}

	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		viewer.setContentProvider(new ChildrenProvider());
	}

	@Override
	protected ILabelDecorator getLabelDecorator() {
		return new FluentOutlineLabelProvider();
	}

	@Override
	public void registerSpecialToolbarActions(IActionBars actionBars) {}
}
