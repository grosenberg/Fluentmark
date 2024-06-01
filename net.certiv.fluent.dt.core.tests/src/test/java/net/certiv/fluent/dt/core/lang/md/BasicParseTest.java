package net.certiv.fluent.dt.core.lang.md;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Test;

import net.certiv.common.diff.Differ;
import net.certiv.common.util.FsUtil;
import net.certiv.fluent.dt.core.lang.MdSupport;
import net.certiv.fluent.dt.core.lang.md.gen.MdParser.PageContext;

class BasicParseTest extends MdSupport {

	static final boolean UPDATE = false;

	@Test
	void attrTest() {
		String name = "attr";
		String src = name + ".md";
		String tgt = name + ".tree.txt";

		CommonTokenStream ts = createMdTokenStream(null, src, false);
		PageContext page = createMdParserTree(ts);
		String tree = renderTree(name, page);
		if (required(tgt, UPDATE)) FsUtil.writeResource(getClass(), tgt, tree);

		String txt = FsUtil.loadResource(getClass(), tgt).value;
		Differ.diff(name, txt, tree).sdiff(true, 200).out();

		assertEquals(txt, tree);
	}

	@Test
	void paraTest() {
		String name = "paragraph";
		String src = name + ".md";
		String tgt = name + ".tree.txt";

		CommonTokenStream ts = createMdTokenStream(null, src, false);
		PageContext page = createMdParserTree(ts);
		String tree = renderTree(name, page);
		if (required(tgt, UPDATE)) FsUtil.writeResource(getClass(), tgt, tree);

		String txt = FsUtil.loadResource(getClass(), tgt).value;
		Differ.diff(name, txt, tree).sdiff(true, 200).out();

		assertEquals(txt, tree);
	}

	@Test
	void basicTest() {
		String name = "basic";
		String src = name + ".md";
		String tgt = name + ".tree.txt";

		CommonTokenStream ts = createMdTokenStream(null, src, false);
		PageContext page = createMdParserTree(ts);
		String tree = renderTree(name, page);
		if (required(tgt, UPDATE)) FsUtil.writeResource(getClass(), tgt, tree);

		String txt = FsUtil.loadResource(getClass(), tgt).value;
		Differ.diff(name, txt, tree).sdiff(true, 200).out();

		assertEquals(txt, tree);
	}

	@Test
	void codeTest() {
		String name = "code";
		String src = name + ".md";
		String tgt = name + ".tree.txt";

		CommonTokenStream ts = createMdTokenStream(null, src, false);
		PageContext page = createMdParserTree(ts);
		String tree = renderTree(name, page);
		if (required(tgt, UPDATE)) FsUtil.writeResource(getClass(), tgt, tree);

		String txt = FsUtil.loadResource(getClass(), tgt).value;
		Differ.diff(name, txt, tree).sdiff(true, 200).out();

		assertEquals(txt, tree);
	}
}
