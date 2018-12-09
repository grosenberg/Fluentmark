/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.ui.gen;

import java.util.List;

import com.github.rjeschke.txtmark.BlockEmitter;

import net.certiv.dsl.core.util.Strings;
import net.certiv.fluentmark.core.model.ModelUtil;

public class DotCodeBlockEmitter implements BlockEmitter {

	public DotCodeBlockEmitter() {
		super();
	}

	@Override
	public void emitBlock(StringBuilder out, List<String> lines, String meta) {
		meta = meta == null || meta.isEmpty() ? meta = ModelUtil.PLAIN : meta;

		switch (meta) {
			case ModelUtil.DOT:
				out.append(DotGen.runDot(lines));
				break;

			default:
				out.append("<pre><code class=\"" + meta + "\">");
				for (final String line : lines) {
					out.append(Symbol.encode(line) + Strings.EOL);
				}
				out.append("</code></pre>" + Strings.EOL);
				break;
		}
	}
}
