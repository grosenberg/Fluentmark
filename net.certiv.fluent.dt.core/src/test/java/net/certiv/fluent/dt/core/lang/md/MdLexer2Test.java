package net.certiv.fluent.dt.core.lang.md;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.junit.jupiter.api.Test;

import net.certiv.common.diff.Differ;
import net.certiv.common.sheet.Sheet;
import net.certiv.common.util.FsUtil;

class MdLexer2Test extends GrammarTestBase {

	@Test
	void lexerTest() {
		String name = "basic.md";
		CommonTokenStream ts = createMdTokenStream(name, true);
		assertNotNull(ts);

		String tokens = render(ts);
		// FsUtil.writeResource(getClass(), XFuture+"Reduce1.md", dot);

		String txt = FsUtil.loadResource(getClass(), name + ".tokens").value;
		Differ.diff(name, txt, tokens).sdiff(true, 120).out();
		assertEquals(txt, tokens);
	}

	private String render(CommonTokenStream ts) {
		Sheet s = Sheet.define() //
				.cols(4) //
				.titles("Token,Line,Name,Len") //
				.aligns("L,R,L,R") //
				.build();

		for (Token t : ts.getTokens()) {
			MdToken token = (MdToken) t;

		}
		return null;
	}

}
