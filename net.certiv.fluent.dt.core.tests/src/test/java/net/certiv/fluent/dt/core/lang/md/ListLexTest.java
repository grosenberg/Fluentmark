package net.certiv.fluent.dt.core.lang.md;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Test;

import net.certiv.common.diff.Differ;
import net.certiv.common.util.FsUtil;
import net.certiv.fluent.dt.core.lang.MdSupport;

class ListLexTest extends MdSupport {

	static final boolean UPDATE = false;

	@Test
	void listTest() {
		String name = "list";
		String src = name + ".md";
		String tgt = name + ".tokens.txt";

		CommonTokenStream ts = createMdTokenStream(null, src, true);
		String tokens = render(name, ts, false);
		if (required(tgt, UPDATE)) FsUtil.writeResource(getClass(), tgt, tokens);

		String txt = FsUtil.loadResource(getClass(), tgt).value;
		Differ.diff(name, txt, tokens).sdiff(true, 200).out();

		assertEquals(txt, tokens);
	}

	@Test
	void listLinksTest() {
		String name = "list_links";
		String src = name + ".md";
		String tgt = name + ".tokens.txt";

		CommonTokenStream ts = createMdTokenStream(null, src, true);
		String tokens = render(name, ts, false);
		if (required(tgt, UPDATE)) FsUtil.writeResource(getClass(), tgt, tokens);

		String txt = FsUtil.loadResource(getClass(), tgt).value;
		Differ.diff(name, txt, tokens).sdiff(true, 200).out();

		assertEquals(txt, tokens);
	}

	@Test
	void multilevelTest() {
		String name = "list_multilevel";
		String src = name + ".md";
		String tgt = name + ".tokens.txt";

		CommonTokenStream ts = createMdTokenStream(null, src, true);
		String tokens = render(name, ts, true);
		if (required(tgt, UPDATE)) FsUtil.writeResource(getClass(), tgt, tokens);

		String txt = FsUtil.loadResource(getClass(), tgt).value;
		Differ.diff(name, txt, tokens).sdiff(true, 200).out();

		assertEquals(txt, tokens);
	}

	@Test
	void allTest() {
		String name = "list_all";
		String src = name + ".md";
		String tgt = name + ".tokens.txt";

		CommonTokenStream ts = createMdTokenStream(null, src, true);
		String tokens = render(name, ts, false);
		if (required(tgt, UPDATE)) FsUtil.writeResource(getClass(), tgt, tokens);

		String txt = FsUtil.loadResource(getClass(), tgt).value;
		Differ.diff(name, txt, tokens).sdiff(true, 200).out();

		assertEquals(txt, tokens);
	}
}
