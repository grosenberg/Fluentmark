package net.certiv.fluent.dt.core.lang.scss;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import net.certiv.fluent.dt.core.lang.scss.gen.ScssLexer;
import net.certiv.fluent.dt.core.lang.scss.gen.ScssParser;
import net.certiv.fluent.dt.core.lang.scss.gen.ScssParser.StylesheetContext;

public class ScssSourceParser {

	private final ScssTokenFactory TokenFactory = new ScssTokenFactory();
	private final ScssErrorListener ErrListener = new ScssErrorListener();
	private StylesheetContext tree;
	private StyleManager styleMgr;

	public ScssSourceParser() {
		super();
		TokenFactory.setTabWidth(4);
	}

	/** Builds a ParseTree for the given content */
	public void parse(InputStream is) throws IOException {
		CharStream cs = CharStreams.fromStream(is);
		Lexer lexer = new ScssLexer(cs);
		lexer.setTokenFactory(TokenFactory);
		lexer.removeErrorListeners();
		lexer.addErrorListener(ErrListener);

		CommonTokenStream ts = new CommonTokenStream(lexer);
		ScssParser parser = new ScssParser(ts);
		parser.setTokenFactory(TokenFactory);
		parser.removeErrorListeners();
		parser.addErrorListener(ErrListener);
		tree = parser.stylesheet();
	}

	public void analyze() {
		if (tree != null && styleMgr == null) {
			styleMgr = new StyleManager();
			ParseTreeWalker.DEFAULT.walk(styleMgr, tree);
		}

	}

	public boolean hasErrors() {
		return ErrListener.hasErrors();
	}

	public List<String> getErrors() {
		return ErrListener.getErrors();
	}

	public void clear() {
		ErrListener.clear();
		tree = null;
	}
}
