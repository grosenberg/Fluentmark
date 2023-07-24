package net.certiv.fluent.dt.core.lang.md;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import net.certiv.common.util.FsUtil;
import net.certiv.fluent.dt.core.lang.md.gen.MdLexer;

public class GrammarTestBase {

	@BeforeEach
	void setUp() throws Exception {}

	@AfterEach
	void tearDown() throws Exception {}

	public CommonTokenStream createMdTokenStream(String name, boolean fill) {
		String data = FsUtil.loadResource(getClass(), name).value;
		CodePointCharStream cs = CharStreams.fromString(data, name);
		MdLexer lexer = new MdLexer(cs);
		lexer.setTokenFactory(new MdTokenFactory());
		CommonTokenStream ts = new CommonTokenStream(lexer);
		if (fill) ts.fill();
		return ts;
	}

}
