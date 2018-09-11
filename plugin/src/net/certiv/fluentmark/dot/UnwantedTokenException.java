package net.certiv.fluentmark.dot;

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;

/**
 * Indicates that the parser encountered an unwanted token. Reported by
 * DefaultErrorStrategy#reportUnwantedToken().
 */
public class UnwantedTokenException extends RecognitionException {

	public UnwantedTokenException(Parser recognizer) {
		super(recognizer, recognizer.getInputStream(), recognizer.getContext());
		this.setOffendingToken(recognizer.getCurrentToken());
	}
}
