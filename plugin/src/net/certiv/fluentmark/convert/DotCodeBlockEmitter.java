package net.certiv.fluentmark.convert;

import java.util.List;

import com.github.rjeschke.txtmark.BlockEmitter;

import net.certiv.fluentmark.util.Strings;

public class DotCodeBlockEmitter implements BlockEmitter {

	public DotCodeBlockEmitter() {
		super();
	}

	@Override
	public void emitBlock(StringBuilder out, List<String> lines, String meta) {
		meta = meta == null || meta.isEmpty() ? meta = DotGen.PLAIN : meta;

		switch (meta) {
			case DotGen.DOT:
				out.append(DotGen.runDot(lines));
				break;
			default:
				out.append("<pre><code class=\"" + meta + "\">");
				for (final String line : lines) {
					out.append(Convert.encode(line) + Strings.EOL);
				}
				out.append("</code></pre>" + Strings.EOL);
				break;
		}
	}
}
