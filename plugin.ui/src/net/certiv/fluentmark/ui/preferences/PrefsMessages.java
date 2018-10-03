package net.certiv.fluentmark.ui.preferences;

import org.eclipse.osgi.util.NLS;

public class PrefsMessages extends NLS {

	private static final String BUNDLE_NAME = "net.certiv.fluentmark.ui.preferences.PrefsMessages"; //$NON-NLS-1$

	private PrefsMessages() {}

	static {
		NLS.initializeMessages(BUNDLE_NAME, PrefsMessages.class);
	}

	public static String GlobalPreferencePage_description;
	public static String EditorPreferencePage_general;

	public static String SmartTypingConfigurationBlock_smartPaste;
	public static String SmartTypingConfigurationBlock_typing_smartTab;
	public static String SmartTypingConfigurationBlock_closeBrackets;
	public static String SmartTypingConfigurationBlock_closeStrings;
	public static String SmartTypingConfigurationBlock_typing_tabTitle;
}
