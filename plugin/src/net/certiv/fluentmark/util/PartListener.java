/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.util;

import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;

public interface PartListener extends IPartListener {

	@Override
	default public void partActivated(IWorkbenchPart part) {}

	@Override
	default public void partBroughtToTop(IWorkbenchPart part) {}

	@Override
	default public void partClosed(IWorkbenchPart part) {}

	@Override
	default public void partDeactivated(IWorkbenchPart part) {}

	@Override
	default public void partOpened(IWorkbenchPart part) {}
}
