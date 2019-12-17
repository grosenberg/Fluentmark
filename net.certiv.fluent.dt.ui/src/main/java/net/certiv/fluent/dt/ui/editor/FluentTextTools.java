package net.certiv.fluent.dt.ui.editor;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.IPartitionTokenScanner;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.ui.texteditor.ITextEditor;

import net.certiv.fluent.dt.core.FluentCore;

import net.certiv.dsl.core.color.IColorManager;
import net.certiv.dsl.core.preferences.IDslPrefsManager;
import net.certiv.dsl.ui.editor.text.DslTextTools;

public class FmTextTools extends DslTextTools {

	private PartitionScanner partitionScanner;

	public FmTextTools(boolean autoDispose) {
		super(Partitions.PARTITIONING, Partitions.getContentTypes(), autoDispose);
	}

	@Override
	public void createAutoClosePairs() {
		for (String contentType : Partitions.getAllContentTypes()) {
			addAutoClosePair(contentType, "{", "}");
			addAutoClosePair(contentType, "(", ")");
			addAutoClosePair(contentType, "[", "]");
			addAutoClosePair(contentType, "<", ">");
		}
	}

	@Override
	public void createAutoIndentPairs() {
		String[] contentTypes = { IDocument.DEFAULT_CONTENT_TYPE };
		for (String contentType : contentTypes) {
			addAutoIndentPair(contentType, "{", "}");
		}
	}

	@Override
	public void createAutoCommentPairs() {
		String[] contentTypes = { IDocument.DEFAULT_CONTENT_TYPE };
		for (String contentType : contentTypes) {
			addAutoCommentPair(contentType, "/**", "*/");
			addAutoCommentPair(contentType, "/*", "*/");
		}
	}

	@Override
	public void createStringDelimPairs() {
		for (String contentType : Partitions.getAllContentTypes()) {
			addStringDelimPairs(contentType, '\'');
			addStringDelimPairs(contentType, '"');
		}
	}

	@Override
	public SourceViewerConfiguration createSourceViewerConfiguraton(IDslPrefsManager store, ITextEditor editor,
			String partitioning) {
		return new FluentSourceViewerConfiguration(getColorManager(), store, editor, partitioning);
	}

	@Override
	public SourceViewerConfiguration createSimpleSourceViewerConfiguration(IDslPrefsManager store,
			String partitioning) {
		return new FluentSimpleSourceViewerConfiguration(store, null, partitioning);
	}

	private IColorManager getColorManager() {
		return FluentCore.getDefault().getColorManager();
	}

	@Override
	public IPartitionTokenScanner createPartitionScanner() {
		if (partitionScanner == null) {
			partitionScanner = new PartitionScanner();
		}
		return partitionScanner;
	}

	@Override
	public String[] getStringContentPartitions() {
		return Partitions.STRING_TYPES;
	}

	@Override
	public String[] getCommentContentPartitions() {
		return Partitions.COMMENT_TYPES;
	}

	@Override
	public String[] getStringAndCommentContentPartitions() {
		return Partitions.STRING_AND_COMMENT_TYPES;
	}
}
