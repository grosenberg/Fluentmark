package net.certiv.fluent.dt.core.lang.md;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Test;

import net.certiv.common.diff.Differ;
import net.certiv.common.util.FsUtil;
import net.certiv.fluent.dt.core.lang.MdSupport;

class BasicLexTest extends MdSupport {

	static final boolean UPDATE = false;

	@Test
	void attrTest() {
		String name = "attr";
		String src = name + ".md";
		String tgt = name + ".tokens.txt";

		CommonTokenStream ts = createMdTokenStream(null, src, true);
		String tokens = render(name, ts);
		if (required(tgt, UPDATE)) FsUtil.writeResource(getClass(), tgt, tokens);

		String txt = FsUtil.loadResource(getClass(), tgt).value;
		Differ.diff(name, txt, tokens).sdiff(true, 200).out();

		assertEquals(txt, tokens);
	}

	@Test
	void paraTest() {
		String name = "paragraph";
		String src = name + ".md";
		String tgt = name + ".tokens.txt";

		CommonTokenStream ts = createMdTokenStream(null, src, true);
		String tokens = render(name, ts);
		if (required(tgt, UPDATE)) FsUtil.writeResource(getClass(), tgt, tokens);

		String txt = FsUtil.loadResource(getClass(), tgt).value;
		Differ.diff(name, txt, tokens).sdiff(true, 200).out();

		assertEquals(txt, tokens);
	}

	@Test
	void basicTest() {
		String name = "basic";
		String src = name + ".md";
		String tgt = name + ".tokens.txt";

		CommonTokenStream ts = createMdTokenStream(null, src, true);
		String tokens = render(name, ts);
		if (required(tgt, UPDATE)) FsUtil.writeResource(getClass(), tgt, tokens);

		String txt = FsUtil.loadResource(getClass(), tgt).value;
		Differ.diff(name, txt, tokens).sdiff(true, 200).out();

		assertEquals(txt, tokens);
	}

	@Test
	void codeTest() {
		String name = "code";
		String src = name + ".md";
		String tgt = name + ".tokens.txt";

		CommonTokenStream ts = createMdTokenStream(null, src, true);
		String tokens = render(name, ts);
		if (required(tgt, UPDATE)) FsUtil.writeResource(getClass(), tgt, tokens);

		String txt = FsUtil.loadResource(getClass(), tgt).value;
		Differ.diff(name, txt, tokens).sdiff(true, 200).out();

		assertEquals(txt, tokens);
	}
}
