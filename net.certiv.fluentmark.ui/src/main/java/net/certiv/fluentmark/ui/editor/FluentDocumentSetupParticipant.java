/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.ui.editor;

import net.certiv.dsl.ui.editor.DslDocumentSetupParticipant;
import net.certiv.fluentmark.ui.FluentUI;

public class FluentDocumentSetupParticipant extends DslDocumentSetupParticipant {

	public FluentDocumentSetupParticipant() {
		super(FluentUI.getDefault().getTextTools());
	}
}
