/*******************************************************************************
 * Copyright (c) 2016 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.actions;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.eclipse.osgi.util.NLS;

/**
 * Class that gives access to the action messages resource bundle.
 */
public class ActionMessages {

	private static final String BUNDLE_NAME = "net.certiv.fluentmark.actions.ActionMessages"; //$NON-NLS-1$

	public static String CollapseAllAction_0;
	public static String CollapseAllAction_1;
	public static String ExpandAllAction_0;
	public static String ExpandAllAction_1;

	public static String CopyToClipboardAction_label;
	public static String CopyToClipboardAction_tooltip;
	public static String CopyToClipboardAction_error_title;
	public static String CopyToClipboardAction_error_message;

	public static String ActionUtil_notOnBuildPath_title;
	public static String ActionUtil_notOnBuildPath_message;
	// public static String ActionUtil_notOnBuildPath_resource_message;
	// public static String ActionUtil_not_possible;
	// public static String ActionUtil_no_linked;
	// public static String ActionUtil_warning_derived_dontShowAgain;
	// public static String ActionUtil_warning_derived_message;
	// public static String ActionUtil_warning_derived_title;

	// public static String BuildPath_label;
	// public static String BuildAction_label;

	// public static String DefaultEditorDescription_name;

	// public static String FormatAction_label;

	// public static String NewWizardsActionGroup_new;

	public static String OpenAction_label;
	public static String OpenAction_tooltip;
	public static String OpenAction_description;
	public static String OpenAction_declaration_label;
	public static String OpenAction_select_element;

	public static String OpenAction_error_title;
	public static String OpenAction_error_message;
	public static String OpenAction_error_messageArgs;
	public static String OpenAction_error_messageProblems;
	public static String OpenAction_error_messageBadSelection;

	// public static String OpenNewSourceFolderWizardAction_text2;
	// public static String OpenNewSourceFolderWizardAction_description;
	// public static String OpenNewSourceFolderWizardAction_tooltip;

	// public static String OpenTypeHierarchyAction_label;
	// public static String OpenTypeHierarchyAction_tooltip;
	// public static String OpenTypeHierarchyAction_description;
	// public static String OpenTypeHierarchyAction_messages_no_script_element;
	// public static String OpenTypeHierarchyAction_messages_title;
	// public static String OpenTypeHierarchyAction_dialog_title;
	// public static String OpenTypeHierarchyAction_messages_no_script_resources;
	// public static String OpenTypeHierarchyAction_messages_no_types;
	// public static String OpenTypeHierarchyAction_messages_no_valid_script_element;

	// public static String OpenProjectAction_dialog_title;
	// public static String OpenProjectAction_dialog_message;
	// public static String OpenProjectAction_error_message;

	// public static String OpenTypeInHierarchyAction_label;
	// public static String OpenTypeInHierarchyAction_description;
	// public static String OpenTypeInHierarchyAction_tooltip;
	// public static String OpenTypeInHierarchyAction_dialogMessage;
	// public static String OpenTypeInHierarchyAction_dialogTitle;

	public static String OpenWithMenu_label;

	// public static String RefactorActionGroup_noRefactoringAvailable;
	// public static String RefactorMenu_label;

	// public static String RefreshAction_label;
	// public static String RefreshAction_toolTip;
	// public static String RefreshAction_progressMessage;
	// public static String RefreshAction_error_title;
	// public static String RefreshAction_error_message;
	// public static String RefreshAction_locationDeleted_title;
	// public static String RefreshAction_locationDeleted_message;

	public static String SelectAllAction_label;
	public static String SelectAllAction_tooltip;

	public static String SelectionConverter_codeResolve_failed;

	public static String ToggleLinkingAction_label;
	public static String ToggleLinkingAction_tooltip;
	public static String ToggleLinkingAction_description;

	static {
		NLS.initializeMessages(BUNDLE_NAME, ActionMessages.class);
	}

	private static ResourceBundle fgResourceBundle;
	static {
		try {
			fgResourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);
		} catch (MissingResourceException x) {
			fgResourceBundle = null;
		}
	}

	private ActionMessages() {}

	/**
	 * Returns the resource bundle managed by the receiver.
	 * 
	 * @return the resource bundle
	 * @since 3.0
	 */
	public static ResourceBundle getResourceBundle() {
		return fgResourceBundle;
	}

	/**
	 * Returns the resource string associated with the given key in the resource bundle. If there
	 * isn't any value under the given key, the key is returned.
	 * 
	 * @param key the resource key
	 * @return the string
	 */
	public static String getString(String key) {
		try {
			return fgResourceBundle.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		} catch (NullPointerException e) {
			return "#" + key + "#"; //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * Returns the formatted resource string associated with the given key in the resource bundle.
	 * <code>MessageFormat</code> is used to format the message. If there isn't any value under the
	 * given key, the key is returned.
	 * 
	 * @param key the resource key
	 * @param arg the message argument
	 * @return the string
	 */
	public static String getFormattedString(String key, Object arg) {
		return getFormattedString(key, new Object[] { arg });
	}

	/**
	 * Returns the formatted resource string associated with the given key in the resource bundle.
	 * <code>MessageFormat</code> is used to format the message. If there isn't any value under the
	 * given key, the key is returned.
	 * 
	 * @param key the resource key
	 * @param args the message arguments
	 * @return the string
	 */
	public static String getFormattedString(String key, Object[] args) {
		return MessageFormat.format(getString(key), args);
	}
}
