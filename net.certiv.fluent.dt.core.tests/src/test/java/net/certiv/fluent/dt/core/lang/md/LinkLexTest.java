package net.certiv.fluent.dt.core.lang.md;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Test;

import net.certiv.common.diff.Differ;
import net.certiv.common.util.FsUtil;

class LinkLexTest extends MdTestBase {

	static final boolean UPDATE = false;

	@Test
	void linkSimpleTest() {
		String name = "link_simple";
		String src = name + ".md";
		String tgt = name + ".tokens.txt";

		CommonTokenStream ts = createMdTokenStream(src, true);
		String tokens = render(name, ts);
		if (required(tgt, UPDATE)) FsUtil.writeResource(getClass(), tgt, tokens);

		String txt = FsUtil.loadResource(getClass(), tgt).value;
		Differ.diff(name, txt, tokens).sdiff(true, 200).out();

		assertEquals(txt, tokens);
	}

	@Test
	void linkAutoTest() {
		String name = "link_auto";
		String src = name + ".md";
		String tgt = name + ".tokens.txt";

		CommonTokenStream ts = createMdTokenStream(src, true);
		String tokens = render(name, ts);
		if (required(tgt, UPDATE)) FsUtil.writeResource(getClass(), tgt, tokens);

		String txt = FsUtil.loadResource(getClass(), tgt).value;
		Differ.diff(name, txt, tokens).sdiff(true, 200).out();

		assertEquals(txt, tokens);
	}

	@Test
	void linkDefTest() {
		String name = "link_def";
		String src = name + ".md";
		String tgt = name + ".tokens.txt";

		CommonTokenStream ts = createMdTokenStream(src, true);
		String tokens = render(name, ts);
		if (required(tgt, UPDATE)) FsUtil.writeResource(getClass(), tgt, tokens);

		String txt = FsUtil.loadResource(getClass(), tgt).value;
		Differ.diff(name, txt, tokens).sdiff(true, 200).out();

		assertEquals(txt, tokens);
	}

	@Test
	void linkParaTest() {
		String name = "link_para";
		String src = name + ".md";
		String tgt = name + ".tokens.txt";

		CommonTokenStream ts = createMdTokenStream(src, true);
		String tokens = render(name, ts);
		if (required(tgt, UPDATE)) FsUtil.writeResource(getClass(), tgt, tokens);

		String txt = FsUtil.loadResource(getClass(), tgt).value;
		Differ.diff(name, txt, tokens).sdiff(true, 200).out();

		assertEquals(txt, tokens);
	}

	@Test
	void linkFootnoteTest() {
		String name = "link_footnote";
		String src = name + ".md";
		String tgt = name + ".tokens.txt";

		CommonTokenStream ts = createMdTokenStream(src, true);
		String tokens = render(name, ts);
		if (required(tgt, UPDATE)) FsUtil.writeResource(getClass(), tgt, tokens);

		String txt = FsUtil.loadResource(getClass(), tgt).value;
		Differ.diff(name, txt, tokens).sdiff(true, 200).out();

		assertEquals(txt, tokens);
	}

	@Test
	void linkInlineTest() {
		String name = "link_inline";
		String src = name + ".md";
		String tgt = name + ".tokens.txt";

		CommonTokenStream ts = createMdTokenStream(src, true);
		String tokens = render(name, ts);
		if (required(tgt, UPDATE)) FsUtil.writeResource(getClass(), tgt, tokens);

		String txt = FsUtil.loadResource(getClass(), tgt).value;
		Differ.diff(name, txt, tokens).sdiff(true, 200).out();

		assertEquals(txt, tokens);
	}

	@Test
	void linkRefTest() {
		String name = "link_ref";
		String src = name + ".md";
		String tgt = name + ".tokens.txt";

		CommonTokenStream ts = createMdTokenStream(src, true);
		String tokens = render(name, ts);
		if (required(tgt, UPDATE)) FsUtil.writeResource(getClass(), tgt, tokens);

		String txt = FsUtil.loadResource(getClass(), tgt).value;
		Differ.diff(name, txt, tokens).sdiff(true, 200).out();

		assertEquals(txt, tokens);
	}

	@Test
	void linkRelTest() {
		String name = "link_rel";
		String src = name + ".md";
		String tgt = name + ".tokens.txt";

		CommonTokenStream ts = createMdTokenStream(src, true);
		String tokens = render(name, ts);
		if (required(tgt, UPDATE)) FsUtil.writeResource(getClass(), tgt, tokens);

		String txt = FsUtil.loadResource(getClass(), tgt).value;
		Differ.diff(name, txt, tokens).sdiff(true, 200).out();

		assertEquals(txt, tokens);
	}

	@Test
	void linkSelfTest() {
		String name = "link_self";
		String src = name + ".md";
		String tgt = name + ".tokens.txt";

		CommonTokenStream ts = createMdTokenStream(src, true);
		String tokens = render(name, ts);
		if (required(tgt, UPDATE)) FsUtil.writeResource(getClass(), tgt, tokens);

		String txt = FsUtil.loadResource(getClass(), tgt).value;
		Differ.diff(name, txt, tokens).sdiff(true, 200).out();

		assertEquals(txt, tokens);
	}

	@Test
	void linkTitleTest() {
		String name = "link_title";
		String src = name + ".md";
		String tgt = name + ".tokens.txt";

		CommonTokenStream ts = createMdTokenStream(src, true);
		String tokens = render(name, ts);
		if (required(tgt, UPDATE)) FsUtil.writeResource(getClass(), tgt, tokens);

		String txt = FsUtil.loadResource(getClass(), tgt).value;
		Differ.diff(name, txt, tokens).sdiff(true, 200).out();

		assertEquals(txt, tokens);
	}

	@Test
	void linkAllTest() {
		String name = "link_all";
		String src = name + ".md";
		String tgt = name + ".tokens.txt";

		CommonTokenStream ts = createMdTokenStream(src, true);
		String tokens = render(name, ts);
		if (required(tgt, UPDATE)) FsUtil.writeResource(getClass(), tgt, tokens);

		String txt = FsUtil.loadResource(getClass(), tgt).value;
		Differ.diff(name, txt, tokens).sdiff(true, 200).out();

		assertEquals(txt, tokens);
	}

}
