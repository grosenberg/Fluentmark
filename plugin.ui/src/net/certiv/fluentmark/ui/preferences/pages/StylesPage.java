/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.ui.preferences.pages;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.osgi.framework.Bundle;

import net.certiv.dsl.ui.DslUI;
import net.certiv.fluentmark.core.FluentCore;
import net.certiv.fluentmark.core.preferences.Prefs;

public class StylesPage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public StylesPage() {
		super(GRID);
		setDescription("");
	}

	@Override
	public void init(IWorkbench workbench) {
		setPreferenceStore(FluentCore.getDefault().getPrefsManager());
	}

	/** Creates the field editors. */
	@Override
	public void createFieldEditors() {
		Composite parent = getFieldEditorParent();

		Group frame = new Group(parent, SWT.NONE);
		frame.setText("Stylesheets");
		GridDataFactory.fillDefaults().indent(0, 6).grab(true, false).span(2, 1).applyTo(frame);
		GridLayoutFactory.fillDefaults().numColumns(3).margins(6, 6).applyTo(frame);

		Composite pane = new Composite(frame, SWT.NONE);
		GridDataFactory.fillDefaults().indent(0, 4).grab(true, false).applyTo(pane);
		GridLayoutFactory.fillDefaults().numColumns(3).applyTo(pane);

		// Github Syntax support
		addField(new BooleanFieldEditor(Prefs.EDITOR_GITHUB_SYNTAX, "Support Github Syntax", pane));

		// Multi-Markdown support
		addField(new BooleanFieldEditor(Prefs.EDITOR_MULTIMARKDOWN_METADATA, "Support Multi-Markdown Metadata", pane));

		// Browser CSS
		addField(new ComboFieldEditor(Prefs.EDITOR_CSS_BUILTIN, "Built-in Stylesheet", builtins(), pane));
		addField(new FileFieldEditor(Prefs.EDITOR_CSS_EXTERNAL, "External Stylesheet", pane));
	}

	// build list of builtin stylesheets
	// key=name, value=bundle cache URL as string
	private String[][] builtins() {
		Bundle bundle = Platform.getBundle(DslUI.PLUGIN_ID);
		URL url = bundle.getEntry(Prefs.CSS_RESOURCE_DIR);
		File dir = null;
		try {
			url = FileLocator.toFileURL(url); // extracts to bundle cache
			dir = new File(url.toURI());
		} catch (IOException | URISyntaxException e) {
			String[][] values = new String[1][2];
			values[0][0] = "<invalid resources/ >";
			values[0][1] = "";
			return values;
		}
		List<String> cssNames = new ArrayList<>();
		if (dir.isDirectory()) {
			for (String name : dir.list()) {
				if (name.endsWith("." + Prefs.CSS) && !name.endsWith(".min." + Prefs.CSS)) {
					cssNames.add(name);
				}
			}
		}

		String[][] values = new String[cssNames.size()][2];
		for (int idx = 0; idx < cssNames.size(); idx++) {
			String cssName = cssNames.get(idx);
			values[idx][0] = cssName;
			try {
				values[idx][1] = url.toURI().resolve(cssName).toString();
			} catch (URISyntaxException e) {
				values[idx][0] = cssName + " <invalid>";
			}
		}
		return values;
	}
}
