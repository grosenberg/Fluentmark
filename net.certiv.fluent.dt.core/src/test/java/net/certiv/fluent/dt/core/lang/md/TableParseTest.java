package net.certiv.fluent.dt.core.lang.md;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.certiv.common.diff.Differ;
import net.certiv.common.util.test.CommonTestBase;
import net.certiv.fluent.dt.core.lang.MdSupport;
import net.certiv.fluent.dt.core.lang.md.gen.MdParser.PageContext;

class TableParseTest extends CommonTestBase {

	static final boolean FORCE = false;
	static final MdSupport MS = new MdSupport();

	@BeforeEach
	void setup() {
		MS.setup();
	}

	@Test
	void tableTest() {
		String name = "table";
		String src = name + ".md";
		String tgt = name + ".tree.txt";

		CommonTokenStream ts = MS.createMdTokenStream(getClass(), src, true);
		PageContext page = MS.createMdParserTree(ts);
		String tree = MS.renderTree(name, page);
		writeResource(getClass(), tgt, tree, FORCE);
		String txt = loadResource(getClass(), tgt);
		Differ.diff(name, txt, tree).sdiff(true, 200).out();

		assertEquals(txt, tree);
	}

	@Test
	void table1Test() {
		String name = "table1";
		String src = name + ".md";
		String tgt = name + ".tree.txt";

		CommonTokenStream ts = MS.createMdTokenStream(getClass(), src, true);
		PageContext page = MS.createMdParserTree(ts);
		String tree = MS.renderTree(name, page);
		writeResource(getClass(), tgt, tree, FORCE);
		String txt = loadResource(getClass(), tgt);
		Differ.diff(name, txt, tree).sdiff(true, 200).out();

		assertEquals(txt, tree);
	}
}
