package net.certiv.fluent.dt.ui.handlers;

import org.eclipse.osgi.util.NLS;

public final class ActionMessages extends NLS {

	private static final String BUNDLE_NAME = "net.certiv.antlr.dt.ui.editor.ActionMessages";

	private ActionMessages() {}

	public static String MemberFilterActionGroup_hide_rules_label;
	public static String MemberFilterActionGroup_hide_rules_tooltip;
	public static String MemberFilterActionGroup_hide_rules_description;
	public static String MemberFilterActionGroup_hide_tokens_label;
	public static String MemberFilterActionGroup_hide_tokens_tooltip;
	public static String MemberFilterActionGroup_hide_tokens_description;
	public static String MemberFilterActionGroup_hide_options_label;
	public static String MemberFilterActionGroup_hide_options_tooltip;
	public static String MemberFilterActionGroup_hide_options_description;
	public static String MemberFilterActionGroup_hide_at_label;
	public static String MemberFilterActionGroup_hide_at_tooltip;
	public static String MemberFilterActionGroup_hide_at_description;

	static {
		NLS.initializeMessages(BUNDLE_NAME, ActionMessages.class);
	}
}
