/*******************************************************************************
 * Copyright (c) 2016 - 2018 Certiv Analytics and others. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.ui.editor;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.source.DefaultCharacterPairMatcher;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.texteditor.SourceViewerDecorationSupport;

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.core.preferences.consts.Editor;
import net.certiv.dsl.core.util.Strings;
import net.certiv.dsl.ui.DslUI;
import net.certiv.dsl.ui.editor.DslEditor;
import net.certiv.dsl.ui.editor.text.DslWordFinder;
import net.certiv.dsl.ui.editor.text.folding.IFoldingStructureProvider;
import net.certiv.fluentmark.core.FluentCore;
import net.certiv.fluentmark.ui.FluentUI;
import net.certiv.fluentmark.ui.editor.folding.FluentFoldingStructureProvider;
import net.certiv.fluentmark.ui.gen.Converter;
import net.certiv.fluentmark.ui.gen.HtmlGen;
import net.certiv.fluentmark.ui.gen.Kind;

/** Text editor with markdown support. */
public class FluentEditor extends DslEditor {

	public static final String EDITOR_ID = "net.certiv.fluentmark.ui.editor.FluentEditor";
	public static final String EDITOR_CONTEXT = "#FluentEditorContext";
	public static final String RULER_CONTEXT = "#FluentRulerContext";

	private static final String[] KEY_SCOPES = new String[] { "net.certiv.fluentmark.ui.editorScope" };
	private static final String MARK_OCCURRENCES_ANNOTATION_TYPE = "net.certiv.fluentmark.ui.editor.occurrences";

	private final DslWordFinder finder = new DslWordFinder();
	private final DefaultCharacterPairMatcher pairMatcher = new DefaultCharacterPairMatcher(STD_PAIRS,
			Partitions.PARTITIONING);

	private FluentFoldingStructureProvider foldingProvider;

	private Converter converter;
	private HtmlGen htmlGen;

	public FluentEditor() {
		super();
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
	public String getEditorId() {
		return EDITOR_ID;
	}

	@Override
	public char[] getBrackets() {
		return STD_PAIRS;
	}

	@Override
	protected void initializeEditor() {
		super.initializeEditor();
		setEditorContextMenuId(EDITOR_CONTEXT);
		setRulerContextMenuId(RULER_CONTEXT);

		converter = new Converter();
		htmlGen = new HtmlGen(this, converter);
	}

	@Override
	protected void initializeKeyBindingScopes() {
		setKeyBindingScopes(KEY_SCOPES);
	}

	@Override
	public String getMarkOccurrencesAnnotationType() {
		return MARK_OCCURRENCES_ANNOTATION_TYPE;
	}

	@Override
	protected IRegion findWord(IDocument doc, int offset) {
		return finder.findWord(doc, offset);
	}

	@Override
	protected FluentOutlinePage doCreateOutlinePage() {
		return new FluentOutlinePage(this, getPreferenceStore());
	}

	@Override
	protected IFoldingStructureProvider createFoldingStructureProvider() {
		if (foldingProvider == null) {
			foldingProvider = new FluentFoldingStructureProvider();
		}
		return foldingProvider;
	}

	@Override
	protected void connectPartitioningToElement(IEditorInput input, IDocument document) {
		if (document instanceof IDocumentExtension3) {
			IDocumentExtension3 extension = (IDocumentExtension3) document;
			if (extension.getDocumentPartitioner(Partitions.PARTITIONING) == null) {
				FluentDocumentSetupParticipant participant = new FluentDocumentSetupParticipant();
				participant.setup(document);
			}
		}
	}

	@Override
	protected void configureSourceViewerDecorationSupport(SourceViewerDecorationSupport support) {
		support.setCharacterPairMatcher(pairMatcher);
		support.setMatchingCharacterPainterPreferenceKeys(bind(Editor.EDITOR_MATCHING_BRACKETS),
				bind(Editor.EDITOR_MATCHING_BRACKETS_COLOR));
		super.configureSourceViewerDecorationSupport(support);
	}

	public FluentEditor ensureLastLineBlank() {
		IDocument doc = getDocument();
		String text = doc.get();
		if (!text.endsWith(Strings.EOL)) {
			doc.set(text + Strings.EOL);
		}
		return this;
	}

	/** Returns the Html content. */
	public String getHtml(Kind kind) {
		return htmlGen.getHtml(kind);
	}

	public boolean useMathJax() {
		return converter.useMathJax();
	}
}
