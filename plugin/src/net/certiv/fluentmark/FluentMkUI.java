/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
/**
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package net.certiv.fluentmark;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.forms.FormColors;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.service.prefs.BackingStoreException;

import net.certiv.fluentmark.editor.FluentMkTextTools;
import net.certiv.fluentmark.editor.color.ColorManager;
import net.certiv.fluentmark.editor.color.IColorManager;
import net.certiv.fluentmark.preferences.Prefs;

/**
 * The activator class controls the plug-in life cycle
 */
public class FluentMkUI extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "net.certiv.fluentmark"; //$NON-NLS-1$

	// The shared instance
	private static FluentMkUI plugin;

	private IPreferenceStore combinedStore;
	private FluentMkImages fluentMkImages;
	private FormToolkit dialogsFormToolkit;
	private ColorManager colorManager;
	private FluentMkTextTools fluentMkTextTools;

	public FluentMkUI() {
		super();
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		fluentMkImages = new FluentMkImages(context.getBundle(), this);

		// ISaveParticipant saveParticipant = new MyWorkspaceSaveParticipant();
		// ISavedState lastState = ResourcesPlugin.getWorkspace().addSaveParticipant(PLUGIN_ID,
		// saveParticipant);
		// if (lastState == null) return;
		//
		// IPath location = lastState.lookup(new Path("save"));
		// if (location == null) return;
		//
		// // the plugin instance should read any important state from the file.
		// File f = getStateLocation().append(location).toFile();
		// readStateFrom(f);

	}

	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 */
	public static FluentMkUI getDefault() {
		return plugin;
	}

	public IColorManager getColorMgr() {
		if (colorManager == null) {
			colorManager = new ColorManager(true);
		}
		return colorManager;
	}

	/**
	 * Returns a chained preference store representing the combined values of the FluentMkUI, EditorsUI,
	 * and PlatformUI stores.
	 */
	public IPreferenceStore getCombinedPreferenceStore() {
		if (combinedStore == null) {
			List<IPreferenceStore> stores = new ArrayList<>();
			stores.add(getPreferenceStore()); // FluentMkUI store
			stores.add(EditorsUI.getPreferenceStore());
			stores.add(PlatformUI.getPreferenceStore());
			combinedStore = new WritableChainedPreferenceStore(stores.toArray(new IPreferenceStore[stores.size()]));
		}
		return combinedStore;
	}

	public FormToolkit getDialogsFormToolkit() {
		if (dialogsFormToolkit == null) {
			FormColors colors = new FormColors(Display.getCurrent());
			colors.setBackground(null);
			colors.setForeground(null);
			dialogsFormToolkit = new FormToolkit(colors);
		}
		return dialogsFormToolkit;
	}

	public FluentMkTextTools getTextTools() {
		if (fluentMkTextTools == null) {
			fluentMkTextTools = new FluentMkTextTools(true);
		}
		return fluentMkTextTools;
	}

	/** Returns the image provider */
	public FluentMkImages getImageProvider() {
		return fluentMkImages;
	}

	public static Image getImage(String key) {
		return plugin.fluentMkImages.get(key);
	}

	public static ImageDescriptor getDescriptor(String key) {
		return plugin.fluentMkImages.getDescriptor(key);
	}

	/**
	 * Returns the content assist additional info focus affordance string.
	 *
	 * @return the affordance string which is <code>null</code> if the preference is disabled
	 * @see EditorsUI#getTooltipAffordanceString()
	 * @since 3.4
	 */
	public static String getAdditionalInfoAffordanceString() {
		if (EditorsUI.getPreferenceStore().getBoolean(Prefs.EDITOR_SHOW_TEXT_HOVER_AFFORDANCE)) {
			return "Press 'Tab' from proposal table or click for focus"; //$NON-NLS-1$
		}
		return null;
	}

	public IStatus createStatus(int statusCode, Throwable exception) {
		return createStatus(null, statusCode, exception);
	}

	public IStatus createStatus(String message, int statusCode, Throwable exception) {
		if (message == null && exception != null) {
			message = exception.getClass().getName() + ": " + exception.getMessage(); //$NON-NLS-1$
		}
		Status status = new Status(statusCode, PLUGIN_ID, statusCode, message, exception);
		return status;
	}

	/**
	 * Returns the workspace root default charset encoding.
	 *
	 * @return the name of the default charset encoding for workspace root.
	 * @see IContainer#getDefaultCharset()
	 * @see ResourcesPlugin#getEncoding()
	 */
	public static String getEncoding() {
		try {
			return ResourcesPlugin.getWorkspace().getRoot().getDefaultCharset();
		} catch (IllegalStateException e) {
			return System.getProperty("file.encoding"); //$NON-NLS-1$
		} catch (CoreException e) {
			return ResourcesPlugin.getEncoding();
		}
	}

	/**
	 * Flushes the instance scope of this plug-in.
	 */
	public static void flushInstanceScope() {
		try {
			InstanceScope.INSTANCE.getNode(PLUGIN_ID).flush();
		} catch (BackingStoreException e) {
			Log.error(e);
		}
	}
}
