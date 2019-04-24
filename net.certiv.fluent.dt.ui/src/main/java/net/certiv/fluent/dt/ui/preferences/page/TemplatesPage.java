package net.certiv.fluent.dt.ui.preferences.page;

import org.eclipse.jface.text.IDocument;

import net.certiv.fluent.dt.core.FluentCore;
import net.certiv.fluent.dt.ui.FluentUI;
import net.certiv.fluent.dt.ui.editor.Partitions;
import net.certiv.fluent.dt.ui.editor.FluentSimpleSourceViewerConfiguration;
import net.certiv.fluent.dt.ui.editor.FluentSourceViewerConfiguration;

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.core.color.IColorManager;
import net.certiv.dsl.core.preferences.DslPrefsManagerDelta;
import net.certiv.dsl.core.preferences.IDslPrefsManager;
import net.certiv.dsl.ui.DslUI;
import net.certiv.dsl.ui.editor.text.DslTextTools;
import net.certiv.dsl.ui.preferences.pages.DslTemplatePreferencePage;
import net.certiv.dsl.ui.templates.CompletionManager;

public class TemplatesPage extends DslTemplatePreferencePage {

	public TemplatesPage() {
		super();
		DslPrefsManagerDelta delta = getDslCore().getPrefsManager().createDeltaManager();
		delta.setDefaultProject(null);
		setPreferenceStore(delta);
	}

	@Override
	public DslUI getDslUI() {
		return FluentUI.getDefault();
	}

	@Override
	public DslCore getDslCore() {
		return FluentCore.getDefault();
	}

	@Override
	protected FluentSourceViewerConfiguration createSourceViewerConfiguration() {
		return new FluentSimpleSourceViewerConfiguration(getColorManager(), (IDslPrefsManager) getPreferenceStore(), null,
				Partitions.PARTITIONING, false);
	}

	@Override
	protected void setDocumentPartitioner(IDocument document) {
		getTextTools().setupDocumentPartitioner(document, Partitions.PARTITIONING);
	}

	@Override
	protected CompletionManager getCompletionMgr() {
		return getDslUI().getCompletionMgr();
	}

	private IColorManager getColorManager() {
		return getDslCore().getColorManager();
	}

	private DslTextTools getTextTools() {
		return getDslUI().getTextTools();
	}
}
