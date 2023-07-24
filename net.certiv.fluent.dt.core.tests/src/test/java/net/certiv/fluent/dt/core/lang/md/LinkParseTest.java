package net.certiv.fluent.dt.core.lang.md;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Test;

import net.certiv.common.diff.Differ;
import net.certiv.common.util.FsUtil;
import net.certiv.fluent.dt.core.lang.md.gen.MdParser.PageContext;

class LinkParseTest extends MdTestBase {

	static final boolean UPDATE = true;

	@Test
	void linkSimpleTest() {
		String name = "link_simple";
		String src = name + ".md";
		String tgt = name + ".tree.txt";

		CommonTokenStream ts = createMdTokenStream(src, true);
		PageContext page = createMdParserTree(ts);
		String tree = renderTree(name, page);
		if (required(tgt, UPDATE)) FsUtil.writeResource(getClass(), tgt, tree);

		String txt = FsUtil.loadResource(getClass(), tgt).value;
		Differ.diff(name, txt, tree).sdiff(true, 200).out();

		assertEquals(txt, tree);
	}

	@Test
	void linkAutoTest() {
		String name = "link_auto";
		String src = name + ".md";
		String tgt = name + ".tree.txt";

		CommonTokenStream ts = createMdTokenStream(src, true);
		PageContext page = createMdParserTree(ts);
		String tree = renderTree(name, page);
		if (required(tgt, UPDATE)) FsUtil.writeResource(getClass(), tgt, tree);

		String txt = FsUtil.loadResource(getClass(), tgt).value;
		Differ.diff(name, txt, tree).sdiff(true, 200).out();

		assertEquals(txt, tree);
	}

	@Test
	void linkDefTest() {
		String name = "link_def";
		String src = name + ".md";
		String tgt = name + ".tree.txt";

		CommonTokenStream ts = createMdTokenStream(src, true);
		PageContext page = createMdParserTree(ts);
		String tree = renderTree(name, page);
		if (required(tgt, UPDATE)) FsUtil.writeResource(getClass(), tgt, tree);

		String txt = FsUtil.loadResource(getClass(), tgt).value;
		Differ.diff(name, txt, tree).sdiff(true, 200).out();

		assertEquals(txt, tree);
	}

	@Test
	void linkFootnoteTest() {
		String name = "link_footnote";
		String src = name + ".md";
		String tgt = name + ".tree.txt";

		CommonTokenStream ts = createMdTokenStream(src, true);
		PageContext page = createMdParserTree(ts);
		String tree = renderTree(name, page);
		if (required(tgt, UPDATE)) FsUtil.writeResource(getClass(), tgt, tree);

		String txt = FsUtil.loadResource(getClass(), tgt).value;
		Differ.diff(name, txt, tree).sdiff(true, 200).out();

		assertEquals(txt, tree);
	}

	@Test
	void linkInlineTest() {
		String name = "link_inline";
		String src = name + ".md";
		String tgt = name + ".tree.txt";

		CommonTokenStream ts = createMdTokenStream(src, true);
		PageContext page = createMdParserTree(ts);
		String tree = renderTree(name, page);
		if (required(tgt, UPDATE)) FsUtil.writeResource(getClass(), tgt, tree);

		String txt = FsUtil.loadResource(getClass(), tgt).value;
		Differ.diff(name, txt, tree).sdiff(true, 200).out();

		assertEquals(txt, tree);
	}

	@Test
	void linkRefTest() {
		String name = "link_ref";
		String src = name + ".md";
		String tgt = name + ".tree.txt";

		CommonTokenStream ts = createMdTokenStream(src, true);
		PageContext page = createMdParserTree(ts);
		String tree = renderTree(name, page);
		if (required(tgt, UPDATE)) FsUtil.writeResource(getClass(), tgt, tree);

		String txt = FsUtil.loadResource(getClass(), tgt).value;
		Differ.diff(name, txt, tree).sdiff(true, 200).out();

		assertEquals(txt, tree);
	}

	@Test
	void linkRelTest() {
		String name = "link_rel";
		String src = name + ".md";
		String tgt = name + ".tree.txt";

		CommonTokenStream ts = createMdTokenStream(src, true);
		PageContext page = createMdParserTree(ts);
		String tree = renderTree(name, page);
		if (required(tgt, UPDATE)) FsUtil.writeResource(getClass(), tgt, tree);

		String txt = FsUtil.loadResource(getClass(), tgt).value;
		Differ.diff(name, txt, tree).sdiff(true, 200).out();

		assertEquals(txt, tree);
	}

	@Test
	void linkSelfTest() {
		String name = "link_self";
		String src = name + ".md";
		String tgt = name + ".tree.txt";

		CommonTokenStream ts = createMdTokenStream(src, true);
		PageContext page = createMdParserTree(ts);
		String tree = renderTree(name, page);
		if (required(tgt, UPDATE)) FsUtil.writeResource(getClass(), tgt, tree);

		String txt = FsUtil.loadResource(getClass(), tgt).value;
		Differ.diff(name, txt, tree).sdiff(true, 200).out();

		assertEquals(txt, tree);
	}

	@Test
	void linkTitleTest() {
		String name = "link_title";
		String src = name + ".md";
		String tgt = name + ".tree.txt";

		CommonTokenStream ts = createMdTokenStream(src, true);
		PageContext page = createMdParserTree(ts);
		String tree = renderTree(name, page);
		if (required(tgt, UPDATE)) FsUtil.writeResource(getClass(), tgt, tree);

		String txt = FsUtil.loadResource(getClass(), tgt).value;
		Differ.diff(name, txt, tree).sdiff(true, 200).out();

		assertEquals(txt, tree);
	}

	@Test
	void linkAllTest() {
		String name = "link_all";
		String src = name + ".md";
		String tgt = name + ".tree.txt";

		CommonTokenStream ts = createMdTokenStream(src, true);
		PageContext page = createMdParserTree(ts);
		String tree = renderTree(name, page);
		if (required(tgt, UPDATE)) FsUtil.writeResource(getClass(), tgt, tree);

		String txt = FsUtil.loadResource(getClass(), tgt).value;
		Differ.diff(name, txt, tree).sdiff(true, 200).out();

		assertEquals(txt, tree);
	}
}
