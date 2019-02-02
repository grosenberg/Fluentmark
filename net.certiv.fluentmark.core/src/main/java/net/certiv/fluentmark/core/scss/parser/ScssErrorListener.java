package net.certiv.fluentmark.core.scss.parser;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;

import net.certiv.dsl.core.util.antlr.AntlrUtil;

public class ScssErrorListener extends BaseErrorListener {

	private final List<String> errors = new ArrayList<>();

	@Override
	public void syntaxError(Recognizer<?, ?> recognizer, Object symbol, int line, int charPos, String msg,
			RecognitionException e) {

		Token token = symbol instanceof Token ? (Token) symbol : null;
		String cause = AntlrUtil.evalError(recognizer, token, line, charPos, msg, e);
		errors.add(cause);
	}

	public boolean hasErrors() {
		return !errors.isEmpty();
	}

	public void clear() {
		errors.clear();
	}

	public List<String> getErrors() {
		return errors;
	}
}
