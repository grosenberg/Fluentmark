/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.preferences.pages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.Preferences;
import org.eclipse.jface.layout.PixelConverter;
import org.eclipse.jface.preference.ColorSelector;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.Scrollable;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.eclipse.ui.texteditor.ChainedPreferenceStore;

import net.certiv.fluentmark.FluentMkUI;
import net.certiv.fluentmark.Log;
import net.certiv.fluentmark.editor.FluentMkSimpleSourceViewerConfiguration;
import net.certiv.fluentmark.editor.FluentMkSourceViewer;
import net.certiv.fluentmark.editor.Partitions;
import net.certiv.fluentmark.editor.color.IColorManager;
import net.certiv.fluentmark.preferences.AbstractConfigurationBlock;
import net.certiv.fluentmark.preferences.OverlayPreferenceStore;
import net.certiv.fluentmark.preferences.OverlayPreferenceStore.OverlayKey;
import net.certiv.fluentmark.preferences.PreferencesAdapter;
import net.certiv.fluentmark.preferences.Prefs;
import net.certiv.fluentmark.preferences.PreviewSourceUpdater;
import net.certiv.fluentmark.preferences.ScrolledPageContent;
import net.certiv.fluentmark.preferences.SwtUtil;
import net.certiv.fluentmark.util.Strings;

/**
 * Configures Editor appearance preferences.
 */
@SuppressWarnings("deprecation")
class AppearanceConfigurationBlock extends AbstractConfigurationBlock {

	/**
	 * Item in the highlighting color list.
	 */
	private static class HighlightingColorListItem {

		/** Display name */
		private String fDisplayName;
		/** Color preference key */
		private String fColorKey;
		/** Bold preference key */
		private String fBoldKey;
		/** Italic preference key */
		private String fItalicKey;
		/** Strikethrough preference key */
		private String fStrikethroughKey;
		/** Underline preference key */
		private String fUnderlineKey;

		/**
		 * Initialize the item with the given values.
		 * 
		 * @param displayName the display name
		 * @param colorKey the color preference key
		 * @param boldKey the bold preference key
		 * @param italicKey the italic preference key
		 * @param strikethroughKey the strikethrough preference key
		 * @param underlineKey the underline preference key
		 */
		public HighlightingColorListItem(String displayName, String colorKey, String boldKey, String italicKey,
				String strikethroughKey, String underlineKey) {
			fDisplayName = displayName;
			fColorKey = colorKey;
			fBoldKey = boldKey;
			fItalicKey = italicKey;
			fStrikethroughKey = strikethroughKey;
			fUnderlineKey = underlineKey;
		}

		/**
		 * @return the bold preference key
		 */
		public String getBoldKey() {
			return fBoldKey;
		}

		/**
		 * @return the bold preference key
		 */
		public String getItalicKey() {
			return fItalicKey;
		}

		/**
		 * @return the strikethrough preference key
		 */
		public String getStrikethroughKey() {
			return fStrikethroughKey;
		}

		/**
		 * @return the underline preference key
		 */
		public String getUnderlineKey() {
			return fUnderlineKey;
		}

		/**
		 * @return the color preference key
		 */
		public String getColorKey() {
			return fColorKey;
		}

		/**
		 * @return the display name
		 */
		public String getDisplayName() {
			return fDisplayName;
		}
	}

	private static class SemanticHighlightingColorListItem extends HighlightingColorListItem {

		/** Enablement preference key */
		private final String fEnableKey;

		/**
		 * Initialize the item with the given values.
		 * 
		 * @param displayName the display name
		 * @param colorKey the color preference key
		 * @param boldKey the bold preference key
		 * @param italicKey the italic preference key
		 * @param strikethroughKey the strikethroughKey preference key
		 * @param underlineKey the underlineKey preference key
		 * @param enableKey the enable preference key
		 */
		public SemanticHighlightingColorListItem(String displayName, String colorKey, String boldKey, String italicKey,
				String strikethroughKey, String underlineKey, String enableKey) {
			super(displayName, colorKey, boldKey, italicKey, strikethroughKey, underlineKey);
			fEnableKey = enableKey;
		}

		/**
		 * @return the enablement preference key
		 */
		public String getEnableKey() {
			return fEnableKey;
		}
	}

	/**
	 * Color list label provider.
	 */
	private class ColorListLabelProvider extends LabelProvider {

		@Override
		public String getText(Object element) {
			if (element instanceof String) return (String) element;
			return ((HighlightingColorListItem) element).getDisplayName();
		}
	}

	/**
	 * Color list content provider.
	 */
	private class ColorListContentProvider implements ITreeContentProvider {

		@Override
		public Object[] getElements(Object inputElement) {
			return new String[] { fMarkupCategory, fCodeCategory, fCommentsCategory, fMathCategory, fHtmlCategory,
					fDotCategory };
		}

		@Override
		public void dispose() {}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {}

		@Override
		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof String) {
				String entry = (String) parentElement;
				if (fCommentsCategory.equals(entry)) return fListModel.subList(0, 3).toArray();
				if (fHtmlCategory.equals(entry)) return fListModel.subList(3, 6).toArray();
				if (fCodeCategory.equals(entry)) return fListModel.subList(6, 8).toArray();
				if (fDotCategory.equals(entry)) return fListModel.subList(8, 13).toArray();
				if (fMarkupCategory.equals(entry)) return fListModel.subList(13, 21).toArray();
				if (fMathCategory.equals(entry)) return fListModel.subList(21, fListModel.size()).toArray();
			}
			return new Object[0];
		}

		@Override
		public Object getParent(Object element) {
			if (element instanceof String) return null;
			int index = fListModel.indexOf(element);

			if (index >= 21) return fMathCategory;
			if (index >= 13) return fMarkupCategory;
			if (index >= 8) return fDotCategory;
			if (index >= 6) return fCodeCategory;
			if (index >= 3) return fCommentsCategory;
			if (index < 3) return fCommentsCategory;
			return fCodeCategory;
		}

		@Override
		public boolean hasChildren(Object element) {
			return element instanceof String;
		}
	}

	private static final String BOLD = Prefs.EDITOR_BOLD_SUFFIX;
	private static final String ITALIC = Prefs.EDITOR_ITALIC_SUFFIX;
	private static final String STRIKETHROUGH = Prefs.EDITOR_STRIKETHROUGH_SUFFIX;
	private static final String UNDERLINE = Prefs.EDITOR_UNDERLINE_SUFFIX;

	private static final String LINK_MSG = "Default colors and font can be configured on the "
			+ "<a href=\"org.eclipse.ui.preferencePages.GeneralTextEditor\">'Text Editors'</a> "
			+ "and on the <a href=\"org.eclipse.ui.preferencePages.ColorsAndFonts\">'Colors "
			+ "and Fonts'</a> preference page.";

	/** The keys of the overlay store. */
	private final String[][] fSyntaxColorListModel = new String[][] {
			{ "Front Matter", Prefs.EDITOR_FRONTMATTER_COLOR }, // 0
			{ "Visible Comments", Prefs.EDITOR_COMMENT_VISIBLE_COLOR }, //
			{ "Hidden Comments", Prefs.EDITOR_COMMENT_HIDDEN_COLOR }, //

			{ "Keywords", Prefs.EDITOR_HTML_KEYWORD_COLOR }, // 3
			{ "Symbols", Prefs.EDITOR_HTML_SYMBOL_COLOR }, //
			{ "Strings", Prefs.EDITOR_HTML_STRING_COLOR }, //

			{ "Code", Prefs.EDITOR_CODE_COLOR }, // 6
			{ "Code Blocks", Prefs.EDITOR_CODEBLOCK_COLOR }, //

			{ "Keywords", Prefs.EDITOR_DOT_KEYWORD_COLOR }, // 8
			{ "Attributes", Prefs.EDITOR_DOT_ATTRIBS_COLOR }, //
			{ "Symbols", Prefs.EDITOR_DOT_SYMBOL_COLOR }, //
			{ "Comments", Prefs.EDITOR_DOT_COMMENT_COLOR }, //
			{ "Strings", Prefs.EDITOR_DOT_STRING_COLOR }, //

			{ "Headers", Prefs.EDITOR_HEADER_COLOR }, // 13
			{ "Lists", Prefs.EDITOR_LIST_COLOR }, //
			{ "Links", Prefs.EDITOR_LINK_COLOR }, //
			{ "Horz Rules", Prefs.EDITOR_HRULE_COLOR }, //
			{ "Bold", Prefs.EDITOR_BOLD_COLOR }, //
			{ "Italic", Prefs.EDITOR_ITALIC_COLOR }, //
			{ "Strikeout", Prefs.EDITOR_STRIKEOUT_COLOR }, //
			{ "Task Tags", Prefs.EDITOR_TASK_TAG_COLOR }, //

			{ "Keywords", Prefs.EDITOR_MATH_KEYWORD_COLOR }, // 21
			{ "Symbols", Prefs.EDITOR_MATH_SYMBOL_COLOR }, //
			{ "Comments", Prefs.EDITOR_MATH_COMMENT_COLOR }, //

	};

	private final String fMarkupCategory = "Markup";
	private final String fCodeCategory = "Code & Code Blocks";
	private final String fCommentsCategory = "Comments";
	private final String fHtmlCategory = "Html";
	private final String fMathCategory = "Math";
	private final String fDotCategory = "Dot";

	private ColorSelector fSyntaxForegroundColorEditor;
	private Label fColorEditorLabel;
	private Button fBoldCheckBox;
	private Button fEnableCheckbox;
	private Button fItalicCheckBox;
	private Button fStrikethroughCheckBox;
	private Button fUnderlineCheckBox;

	/** Highlighting color list */
	private final List<HighlightingColorListItem> fListModel = new ArrayList<>();
	/** Highlighting color tree viewer */
	private TreeViewer fTreeViewer;
	/** The previewer. */
	private FluentMkSourceViewer fPreviewViewer;

	private IColorManager fColorManager;

	public AppearanceConfigurationBlock(OverlayPreferenceStore store) {
		super(store);

		fColorManager = FluentMkUI.getDefault().getColorMgr();

		for (int i = 0, n = fSyntaxColorListModel.length; i < n; i++)
			fListModel.add(new HighlightingColorListItem(fSyntaxColorListModel[i][0], fSyntaxColorListModel[i][1],
					fSyntaxColorListModel[i][1] + BOLD, fSyntaxColorListModel[i][1] + ITALIC,
					fSyntaxColorListModel[i][1] + STRIKETHROUGH, fSyntaxColorListModel[i][1] + UNDERLINE));

		store.addKeys(createOverlayStoreKeys());
	}

	private OverlayPreferenceStore.OverlayKey[] createOverlayStoreKeys() {

		ArrayList<OverlayKey> overlayKeys = new ArrayList<>();

		for (int i = 0, n = fListModel.size(); i < n; i++) {
			HighlightingColorListItem item = fListModel.get(i);
			overlayKeys.add(new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.STRING, item.getColorKey()));
			overlayKeys.add(new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.BOOLEAN, item.getBoldKey()));
			overlayKeys.add(new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.BOOLEAN, item.getItalicKey()));
			overlayKeys.add(
					new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.BOOLEAN, item.getStrikethroughKey()));
			overlayKeys
					.add(new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.BOOLEAN, item.getUnderlineKey()));

			if (item instanceof SemanticHighlightingColorListItem)
				overlayKeys.add(new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.BOOLEAN,
						((SemanticHighlightingColorListItem) item).getEnableKey()));
		}

		OverlayPreferenceStore.OverlayKey[] keys = new OverlayPreferenceStore.OverlayKey[overlayKeys.size()];
		overlayKeys.toArray(keys);
		return keys;
	}

	/**
	 * Creates page for hover preferences.
	 *
	 * @param parent the parent composite
	 * @return the control for the preference page
	 */
	@Override
	public Control createControl(Composite parent) {
		super.createControl(parent);

		ScrolledPageContent scrolled = new ScrolledPageContent(parent, SWT.H_SCROLL | SWT.V_SCROLL);
		scrolled.setExpandHorizontal(true);
		scrolled.setExpandVertical(true);

		Control control = createSyntaxPage(scrolled);

		scrolled.setContent(control);
		final Point size = control.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		scrolled.setMinSize(size.x, size.y);

		return scrolled;
	}

	@Override
	public void initialize() {
		super.initialize();

		fTreeViewer.setInput(fListModel);
		fTreeViewer.setSelection(new StructuredSelection(fMarkupCategory));
	}

	@Override
	public void performDefaults() {
		super.performDefaults();
		handleSyntaxColorListSelection();
		fPreviewViewer.invalidateTextPresentation();
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	private void handleSyntaxColorListSelection() {
		HighlightingColorListItem item = getHighlightingColorListItem();
		if (item == null) {
			fEnableCheckbox.setEnabled(false);
			fSyntaxForegroundColorEditor.getButton().setEnabled(false);
			fColorEditorLabel.setEnabled(false);
			fBoldCheckBox.setEnabled(false);
			fItalicCheckBox.setEnabled(false);
			fStrikethroughCheckBox.setEnabled(false);
			fUnderlineCheckBox.setEnabled(false);
			return;
		}
		RGB rgb = PreferenceConverter.getColor(getPreferenceStore(), item.getColorKey());
		fSyntaxForegroundColorEditor.setColorValue(rgb);
		fBoldCheckBox.setSelection(getPreferenceStore().getBoolean(item.getBoldKey()));
		fItalicCheckBox.setSelection(getPreferenceStore().getBoolean(item.getItalicKey()));
		fStrikethroughCheckBox.setSelection(getPreferenceStore().getBoolean(item.getStrikethroughKey()));
		fUnderlineCheckBox.setSelection(getPreferenceStore().getBoolean(item.getUnderlineKey()));
		if (item instanceof SemanticHighlightingColorListItem) {
			fEnableCheckbox.setEnabled(true);
			boolean enable = getPreferenceStore().getBoolean(((SemanticHighlightingColorListItem) item).getEnableKey());
			fEnableCheckbox.setSelection(enable);
			fSyntaxForegroundColorEditor.getButton().setEnabled(enable);
			fColorEditorLabel.setEnabled(enable);
			fBoldCheckBox.setEnabled(enable);
			fItalicCheckBox.setEnabled(enable);
			fStrikethroughCheckBox.setEnabled(enable);
			fUnderlineCheckBox.setEnabled(enable);
		} else {
			fSyntaxForegroundColorEditor.getButton().setEnabled(true);
			fColorEditorLabel.setEnabled(true);
			fBoldCheckBox.setEnabled(true);
			fItalicCheckBox.setEnabled(true);
			fStrikethroughCheckBox.setEnabled(true);
			fUnderlineCheckBox.setEnabled(true);
			fEnableCheckbox.setEnabled(false);
			fEnableCheckbox.setSelection(true);
		}
	}

	private Control createSyntaxPage(final Composite parent) {

		Composite colorComposite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		colorComposite.setLayout(layout);

		Link link = new Link(colorComposite, SWT.NONE);
		link.setText(LINK_MSG);
		link.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if ("org.eclipse.ui.preferencePages.GeneralTextEditor".equals(e.text)) //$NON-NLS-1$
					PreferencesUtil.createPreferenceDialogOn(parent.getShell(), e.text, null, null);
				else if ("org.eclipse.ui.preferencePages.ColorsAndFonts".equals(e.text)) //$NON-NLS-1$
					PreferencesUtil.createPreferenceDialogOn(parent.getShell(), e.text, null,
							"selectFont:org.eclipse.jdt.ui.editors.textfont"); //$NON-NLS-1$
			}
		});

		GridData gridData = new GridData(SWT.FILL, SWT.BEGINNING, true, false);
		gridData.widthHint = 150; // only expand further if anyone else requires it
		gridData.horizontalSpan = 2;
		link.setLayoutData(gridData);

		addFiller(colorComposite, 1);

		Label label;
		label = new Label(colorComposite, SWT.LEFT);
		label.setText("Element");
		label.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		Composite editorComposite = new Composite(colorComposite, SWT.NONE);
		layout = new GridLayout();
		layout.numColumns = 2;
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		editorComposite.setLayout(layout);
		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
		gd.heightHint = convertHeightInCharsToPixels(7);
		editorComposite.setLayoutData(gd);

		fTreeViewer = new TreeViewer(editorComposite, SWT.SINGLE | SWT.BORDER);
		fTreeViewer.setLabelProvider(new ColorListLabelProvider());
		fTreeViewer.setContentProvider(new ColorListContentProvider());
		fTreeViewer.setComparator(new ViewerComparator() {

			@Override
			public int category(Object element) {
				// don't sort the top level categories
				if (fMarkupCategory.equals(element)) return 0;
				if (fCodeCategory.equals(element)) return 1;
				if (fCommentsCategory.equals(element)) return 2;
				// to sort semantic settings after partition based ones:
				// if (element instanceof SemanticHighlightingColorListItem)
				// return 1;
				return 0;
			}
		});
		gd = new GridData(SWT.BEGINNING, SWT.FILL, false, true);
		gd.heightHint = convertHeightInCharsToPixels(7);
		int maxWidth = 0;
		for (Iterator<HighlightingColorListItem> it = fListModel.iterator(); it.hasNext();) {
			HighlightingColorListItem item = it.next();
			maxWidth = Math.max(maxWidth, convertWidthInCharsToPixels(item.getDisplayName().length()));
		}
		ScrollBar vBar = ((Scrollable) fTreeViewer.getControl()).getVerticalBar();
		if (vBar != null) maxWidth += vBar.getSize().x * 3; // scrollbars and tree indentation guess
		gd.widthHint = maxWidth;

		fTreeViewer.getControl().setLayoutData(gd);
		installDoubleClickListener();

		Composite stylesComposite = new Composite(editorComposite, SWT.NONE);
		layout = new GridLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		layout.numColumns = 2;
		stylesComposite.setLayout(layout);
		stylesComposite.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, true, false));

		fEnableCheckbox = new Button(stylesComposite, SWT.CHECK);
		fEnableCheckbox.setText("Enable");
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalAlignment = GridData.BEGINNING;
		gd.horizontalSpan = 2;
		fEnableCheckbox.setLayoutData(gd);

		fColorEditorLabel = new Label(stylesComposite, SWT.LEFT);
		fColorEditorLabel.setText("Color");
		gd = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		gd.horizontalIndent = SwtUtil.getIndent();
		fColorEditorLabel.setLayoutData(gd);

		fSyntaxForegroundColorEditor = new ColorSelector(stylesComposite);
		Button foregroundColorButton = fSyntaxForegroundColorEditor.getButton();
		gd = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		foregroundColorButton.setLayoutData(gd);

		fBoldCheckBox = new Button(stylesComposite, SWT.CHECK);
		fBoldCheckBox.setText("Bold");
		gd = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		gd.horizontalIndent = SwtUtil.getIndent();
		gd.horizontalSpan = 2;
		fBoldCheckBox.setLayoutData(gd);

		fItalicCheckBox = new Button(stylesComposite, SWT.CHECK);
		fItalicCheckBox.setText("Italic");
		gd = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		gd.horizontalIndent = SwtUtil.getIndent();
		gd.horizontalSpan = 2;
		fItalicCheckBox.setLayoutData(gd);

		fStrikethroughCheckBox = new Button(stylesComposite, SWT.CHECK);
		fStrikethroughCheckBox.setText("Strikethrough");
		gd = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		gd.horizontalIndent = SwtUtil.getIndent();
		gd.horizontalSpan = 2;
		fStrikethroughCheckBox.setLayoutData(gd);

		fUnderlineCheckBox = new Button(stylesComposite, SWT.CHECK);
		fUnderlineCheckBox.setText("Underline");
		gd = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		gd.horizontalIndent = SwtUtil.getIndent();
		gd.horizontalSpan = 2;
		fUnderlineCheckBox.setLayoutData(gd);

		label = new Label(colorComposite, SWT.LEFT);
		label.setText("Preview");
		label.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		Control previewer = createPreviewer(colorComposite);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.widthHint = convertWidthInCharsToPixels(20);
		gd.heightHint = convertWidthInCharsToPixels(40);
		previewer.setLayoutData(gd);

		fTreeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				handleSyntaxColorListSelection();
			}
		});

		foregroundColorButton.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// do nothing
			}

			@Override
			public void widgetSelected(SelectionEvent e) {
				HighlightingColorListItem item = getHighlightingColorListItem();
				PreferenceConverter.setValue(getPreferenceStore(), item.getColorKey(),
						fSyntaxForegroundColorEditor.getColorValue());
			}
		});

		fBoldCheckBox.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// do nothing
			}

			@Override
			public void widgetSelected(SelectionEvent e) {
				HighlightingColorListItem item = getHighlightingColorListItem();
				getPreferenceStore().setValue(item.getBoldKey(), fBoldCheckBox.getSelection());
			}
		});

		fItalicCheckBox.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// do nothing
			}

			@Override
			public void widgetSelected(SelectionEvent e) {
				HighlightingColorListItem item = getHighlightingColorListItem();
				getPreferenceStore().setValue(item.getItalicKey(), fItalicCheckBox.getSelection());
			}
		});
		fStrikethroughCheckBox.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// do nothing
			}

			@Override
			public void widgetSelected(SelectionEvent e) {
				HighlightingColorListItem item = getHighlightingColorListItem();
				getPreferenceStore().setValue(item.getStrikethroughKey(), fStrikethroughCheckBox.getSelection());
			}
		});

		fUnderlineCheckBox.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// do nothing
			}

			@Override
			public void widgetSelected(SelectionEvent e) {
				HighlightingColorListItem item = getHighlightingColorListItem();
				getPreferenceStore().setValue(item.getUnderlineKey(), fUnderlineCheckBox.getSelection());
			}
		});

		fEnableCheckbox.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}

			@Override
			public void widgetSelected(SelectionEvent e) {
				HighlightingColorListItem item = getHighlightingColorListItem();
				if (item instanceof SemanticHighlightingColorListItem) {
					boolean enable = fEnableCheckbox.getSelection();
					getPreferenceStore().setValue(((SemanticHighlightingColorListItem) item).getEnableKey(), enable);
					fEnableCheckbox.setSelection(enable);
					fSyntaxForegroundColorEditor.getButton().setEnabled(enable);
					fColorEditorLabel.setEnabled(enable);
					fBoldCheckBox.setEnabled(enable);
					fItalicCheckBox.setEnabled(enable);
					fStrikethroughCheckBox.setEnabled(enable);
					fUnderlineCheckBox.setEnabled(enable);
				}
			}
		});

		colorComposite.layout();

		return colorComposite;
	}

	/**
	 * Installs a double-click listener which allows to expand and collapse tree items.
	 *
	 * @since 3.4
	 */
	private void installDoubleClickListener() {
		fTreeViewer.addDoubleClickListener(new IDoubleClickListener() {

			/*
			 * @see
			 * org.eclipse.jface.viewers.IDoubleClickListener#doubleClick(org.eclipse.jface.viewers.
			 * DoubleClickEvent)
			 */
			@Override
			public void doubleClick(DoubleClickEvent event) {
				IStructuredSelection s = (IStructuredSelection) event.getSelection();
				Object element = s.getFirstElement();
				if (fTreeViewer.isExpandable(element))
					fTreeViewer.setExpandedState(element, !fTreeViewer.getExpandedState(element));
			}
		});
	}

	private void addFiller(Composite composite, int horizontalSpan) {
		PixelConverter pixelConverter = new PixelConverter(composite);
		Label filler = new Label(composite, SWT.LEFT);
		GridData gd = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		gd.horizontalSpan = horizontalSpan;
		gd.heightHint = pixelConverter.convertHeightInCharsToPixels(1) / 2;
		filler.setLayoutData(gd);
	}

	private Control createPreviewer(Composite parent) {

		IPreferenceStore generalTextStore = FluentMkUI.getDefault().getPreferenceStore();
		IPreferenceStore store = new ChainedPreferenceStore(new IPreferenceStore[] { getPreferenceStore(),
				new PreferencesAdapter(createTemporaryCorePreferenceStore()), generalTextStore });
		fPreviewViewer = new FluentMkSourceViewer(parent, null, null, false, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER,
				store);
		FluentMkSimpleSourceViewerConfiguration configuration = new FluentMkSimpleSourceViewerConfiguration(
				fColorManager, store, null, Partitions.MK_PARTITIONING, false);
		fPreviewViewer.configure(configuration);
		Font font = JFaceResources.getFont(Prefs.EDITOR_TEXT_FONT);
		fPreviewViewer.getTextWidget().setFont(font);
		new PreviewSourceUpdater(fPreviewViewer, configuration, store);

		fPreviewViewer.setEditable(false);
		Cursor arrowCursor = fPreviewViewer.getTextWidget().getDisplay().getSystemCursor(SWT.CURSOR_ARROW);
		fPreviewViewer.getTextWidget().setCursor(arrowCursor);

		// Don't set caret to 'null' as this causes https://bugs.eclipse.org/293263
		// fPreviewViewer.getTextWidget().setCaret(null);

		String content = loadPreviewContentFromFile("ColorsPreview.md"); //$NON-NLS-1$
		IDocument document = new Document(content);
		FluentMkUI.getDefault().getTextTools().setupDocumentPartitioner(document, Partitions.MK_PARTITIONING);
		fPreviewViewer.setDocument(document);

		return fPreviewViewer.getControl();
	}

	private Preferences createTemporaryCorePreferenceStore() {
		Preferences result = new Preferences();
		result.setValue(Prefs.EDITOR_TASK_TAGS, "TASK,TODO"); //$NON-NLS-1$
		return result;
	}

	private String loadPreviewContentFromFile(String filename) {
		String line;
		StringBuffer buffer = new StringBuffer(512);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(filename)));
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
				buffer.append(Strings.EOL);
			}
			buffer.setLength(buffer.length() - Strings.EOL.length());
		} catch (IOException io) {
			Log.error(io);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {}
			}
		}
		return buffer.toString();
	}

	/**
	 * Returns the current highlighting color list item.
	 *
	 * @return the current highlighting color list item
	 */
	private HighlightingColorListItem getHighlightingColorListItem() {
		IStructuredSelection selection = (IStructuredSelection) fTreeViewer.getSelection();
		Object element = selection.getFirstElement();
		if (element instanceof String) return null;
		return (HighlightingColorListItem) element;
	}
}
