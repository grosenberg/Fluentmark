package net.certiv.fluentmark.dot;

import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.text.IRegion;

import net.certiv.fluentmark.dot.gen.DotParser;
import net.certiv.fluentmark.dot.gen.DotParser.GraphContext;

public class Record {

	public IResource res;
	public IRegion region;	// typically corresponds to a partition
	public int docOffset;	// start offset of parsed text
	public int docLine;		// start line of parsed text

	public GraphContext tree;
	public DotParser parser;
	public CommonTokenStream ts;
	public CodePointCharStream cs;

	public Record(IResource res, IRegion region, int docOffset, int docLine) {
		this.res = res;
		this.region = region;
		this.docOffset = docOffset;
		this.docLine = docLine;
	}

	public void dispose() {
		res = null;
		region = null;
		tree = null;
		parser = null;
		ts = null;
		cs = null;
	}
}
