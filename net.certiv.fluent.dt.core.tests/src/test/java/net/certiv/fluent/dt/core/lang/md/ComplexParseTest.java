package net.certiv.fluent.dt.core.lang.md;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Test;

import net.certiv.common.diff.Differ;
import net.certiv.common.util.FsUtil;
import net.certiv.fluent.dt.core.lang.MdSupport;
import net.certiv.fluent.dt.core.lang.md.gen.MdParser.PageContext;

class ComplexParseTest extends MdSupport {

	static final boolean UPDATE = false;

	@Test
	void fullTest() {
		String name = "FullDemo";
		String src = name + ".md";
		String tgt = name + ".tree.txt";

		CommonTokenStream ts = createMdTokenStream(null, src, true);
		PageContext page = createMdParserTree(ts);
		String tree = renderTree(name, page);
		if (required(tgt, UPDATE)) FsUtil.writeResource(getClass(), tgt, tree);

		String txt = FsUtil.loadResource(getClass(), tgt).value;
		Differ.diff(name, txt, tree).sdiff(true, 200).out();

		assertEquals(txt, tree);
	}
}
