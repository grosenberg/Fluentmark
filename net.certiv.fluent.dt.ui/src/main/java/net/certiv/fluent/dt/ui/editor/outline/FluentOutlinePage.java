package net.certiv.fluent.dt.ui.editor.outline;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelDecorator;

import net.certiv.dsl.core.model.ISourceUnit;
import net.certiv.dsl.core.model.IStatement;
import net.certiv.dsl.ui.editor.DslOutlinePage;
import net.certiv.fluent.dt.core.model.Specialization;
import net.certiv.fluent.dt.ui.FluentUI;

public class FluentOutlinePage extends DslOutlinePage {

	protected class FluentDataProvider extends OutlineDataProvider {

		@Override
		protected IStatement[] filterChildren(ISourceUnit node) {
			List<IStatement> filtered = new ArrayList<>();
			IStatement[] children = super.filterChildren(node);
			for (IStatement child : children) {
				if (!excluded(child)) filtered.add(child);
			}
			return filtered.toArray(new IStatement[filtered.size()]);
		}

		private boolean excluded(IStatement child) {
			if (child.hasData()) {
				Specialization data = (Specialization) child.getData();
				switch (data.specializedType) {
					case Bold:
					case Italic:
					case Underline:
					case Strike:

					case Span:
					case CodeSpan:
					case MathSpan:
						return true;

					default:
						return false;
				}
			}
			return false;
		}
	}

	public FluentOutlinePage(IPreferenceStore store) {
		super(FluentUI.getDefault(), store);
	}

	@Override
	protected ILabelDecorator getLabelDecorator() {
		return new FluentStatementLabelProvider();
	}

	@Override
	protected IContentProvider getOutlineDataProvider() {
		return new FluentDataProvider();
	}
}
