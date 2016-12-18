package net.certiv.fluentmark.assist;

import org.eclipse.osgi.util.NLS;

class Messages extends NLS {

	private static final String BUNDLE_NAME = "net.certiv.fluentmark.assist.messages"; //$NON-NLS-1$

	public static String MarkupTemplateCompletionProcessor_contextName;

	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {}
}
