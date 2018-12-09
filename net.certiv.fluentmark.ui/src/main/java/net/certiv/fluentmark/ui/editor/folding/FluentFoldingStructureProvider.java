/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.ui.editor.folding;

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.ui.DslUI;
import net.certiv.dsl.ui.editor.text.folding.AbstractDslFoldingStructureProvider;
import net.certiv.fluentmark.core.FluentCore;
import net.certiv.fluentmark.ui.FluentUI;
import net.certiv.fluentmark.ui.editor.Partitions;

public class FluentFoldingStructureProvider extends AbstractDslFoldingStructureProvider {

	public FluentFoldingStructureProvider() {
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
	protected String getPartitioning() {
		return Partitions.PARTITIONING;
	}

	@Override
	protected String getMultiLineCommentPartition() {
		return Partitions.COMMENT;
	}

	@Override
	protected String getSingleLineCommentPartition() {
		return null;
	}
}
