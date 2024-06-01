package net.certiv.fluent.dt.core.lang.md;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.certiv.common.diff.Differ;
import net.certiv.common.util.test.CommonTestBase;
import net.certiv.fluent.dt.core.lang.MdSupport;

class HRuleLexTest extends CommonTestBase {

	static final boolean FORCE = false;
	static final MdSupport MS = new MdSupport();

	@BeforeEach
	void setup() {
		MS.setup();
	}

	@Test
	void hrulesTest() {
		String name = "horz_rules";
		String src = name + ".md";
		String tgt = name + ".tokens.txt";

		CommonTokenStream ts = MS.createMdTokenStream(getClass(), src, true);
		String tokens = MS.render(name, ts);
		writeResource(getClass(), tgt, tokens, FORCE);
		String txt = loadResource(getClass(), tgt);
		Differ.diff(name, txt, tokens).sdiff(true, 200).out();

		assertEquals(txt, tokens);
	}
}
