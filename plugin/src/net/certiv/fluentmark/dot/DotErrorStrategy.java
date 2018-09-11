package net.certiv.fluentmark.dot;

import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.IntervalSet;

/** Overrides to include typed exceptions. */
public class DotErrorStrategy extends DefaultErrorStrategy {

	@Override
	protected void reportUnwantedToken(Parser recognizer) {
		if (inErrorRecoveryMode(recognizer)) return;

		beginErrorCondition(recognizer);
		Token t = recognizer.getCurrentToken();
		String tokenName = getTokenErrorDisplay(t);
		IntervalSet expecting = getExpectedTokens(recognizer);
		String msg = "extraneous input " + tokenName + " expecting " + expecting.toString(recognizer.getVocabulary());
		UnwantedTokenException e = new UnwantedTokenException(recognizer);
		recognizer.notifyErrorListeners(t, msg, e);
	}

	@Override
	protected void reportMissingToken(Parser recognizer) {
		if (inErrorRecoveryMode(recognizer)) return;

		beginErrorCondition(recognizer);
		Token t = recognizer.getCurrentToken();
		IntervalSet expecting = getExpectedTokens(recognizer);
		String msg = "missing " + expecting.toString(recognizer.getVocabulary()) + " at " + getTokenErrorDisplay(t);
		MissingTokenException e = new MissingTokenException(recognizer);
		recognizer.notifyErrorListeners(t, msg, e);
	}
}
