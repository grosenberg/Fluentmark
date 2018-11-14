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
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelDecorator;

import net.certiv.dsl.core.model.IDslElement;
import net.certiv.dsl.core.model.ISourceRef;
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

	/** Content provider for the children of a Page. */
	protected class FluentDataProvider extends OutlineDataProvider {

		// conditional blank lines filter
		@Override
		protected IDslElement[] filterChildren(ISourceRef node) {
			if (store.getBoolean(Prefs.EDITOR_OUTLINE_SHOW_BLANKLINES)) {
				return super.filterChildren(node);
			}

			List<IPageElement> filtered = new ArrayList<>();
			for (IDslElement child : node.getChildren()) {
				if (child instanceof IPageElement) {
					IPageElement elem = (IPageElement) child;
					if (elem.getItem() != Item.BLANK) filtered.add(elem);
				}
			}
			return filtered.toArray(new IPageElement[filtered.size()]);
		}
	}

	public FluentOutlinePage(FluentEditor editor, IPreferenceStore store) {
		super(FluentUI.getDefault(), editor, store);
	}

	@Override
	protected ILabelDecorator getLabelDecorator() {
		return new FluentOutlineLabelDecorator();
	}

	@Override
	protected IContentProvider getOutlineDataProvider() {
		return new FluentDataProvider();
	}
}
