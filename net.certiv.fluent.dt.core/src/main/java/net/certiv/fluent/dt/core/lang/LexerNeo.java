/*******************************************************************************
 * Copyright (c) 2017 - 2019 Certiv Analytics. All rights reserved.
 * Use of this file is governed by the Eclipse Public License v1.0
 * that can be found in the LICENSE.txt file in the project root,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package net.certiv.fluent.dt.core.lang;

import java.util.ArrayDeque;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.IntStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.LexerNoViableAltException;
import org.antlr.v4.runtime.Token;

import net.certiv.fluent.dt.core.lang.md.MdToken;

/**
 * Modifies the {@code emit} related methods to implement new behaviors:
 * <p>
 * The {@code more} mode is unchanged from the native {@code Lexer}
 * implementation. If {@code more} mode is enabled, the token match is
 * effectively extended to include the first token, other than skipped tokens,
 * matched by a non-{@code more}ed rule. While {@code more} mode is active, no
 * BOL or DENT tokens will be emitted.
 * <p>
 * If {@code modified more} mode is enabled, the token match is effectively
 * extended to include all tokens matched by a the {@code modified more}ed rule.
 * When any other token is matched, the emit of that token is deferred and a
 * constructed token of the {@code modified more} defined type is immediately
 * emitted.
 */
public abstract class LexerNeo extends Lexer {

	// pending queue of tokens for emit
	protected final ArrayDeque<MdToken> _queue = new ArrayDeque<>();

	protected MdToken _lastToken;	// last token emit'd

	private boolean _mmore;			// modified more mode flag
	private int _mtype;				// token type to emit with content of 'mmore' matches
	protected int _mStartCharIndex;	// state after last 'mmore' match
	protected int _mStartCharPositionInLine;
	protected int _mStartLine;
	protected int _mChannel;

	private boolean _atBOL;

	private int _typeBOF = Token.EOF;
	private String _textBOF = null;

	public LexerNeo(CharStream input) {
		super(input);
	}

	public void insertBOFToken(int ttype, String ttext) {
		_typeBOF = ttype;
		_textBOF = ttext;
	}

	public boolean bol() {
		return _atBOL || _lastToken == null;
	}

	public boolean eof() {
		return _hitEOF;
	}

	protected MdToken lastToken() {
		return _lastToken;
	}

	protected void queueEOF() {
		queue(Token.EOF);
	}

	/** Enables the conventional more mode. */
	@Override
	public void more() {
		_mmore = false;
		_type = MORE;
	}

	/** Enables the modified more mode to use the given token type. */
	public void more(int mtype) {
		_type = MORE;
		_mmore = true;
		_mtype = mtype;
	}

	@Override
	public Token nextToken() {
		if (_input == null) {
			throw new IllegalStateException("nextToken requires a non-null input stream.");
		}

		int mark = _input.mark();
		try {
			outer: while (true) {
				if (_hitEOF) {
					queueEOF();
					emit(_queue.remove());
					return _token;
				}

				_token = null;
				_text = null;
				_channel = _mChannel = Token.DEFAULT_CHANNEL;
				_tokenStartCharIndex = _mStartCharIndex = _input.index();
				_tokenStartCharPositionInLine = _mStartCharPositionInLine = getInterpreter().getCharPositionInLine();
				_tokenStartLine = _mStartLine = getInterpreter().getLine();
				_atBOL = _tokenStartCharPositionInLine == 0;

				do {
					_type = Token.INVALID_TYPE;
					int ttype;
					try {
						ttype = getInterpreter().match(_input, _mode);
						// Log.debug(this, "...matched " + createMatched().toString());
					} catch (LexerNoViableAltException e) {
						notifyListeners(e); // report error
						recover(e);
						ttype = SKIP;
					}

					if (_input.LA(1) == IntStream.EOF) _hitEOF = true;
					if (_type == Token.INVALID_TYPE) _type = ttype;
					if (_type == SKIP && !_mmore) continue outer;
					if (_type == MORE && _mmore) {
						_mStartCharIndex = _input.index();
						_mStartCharPositionInLine = getInterpreter().getCharPositionInLine();
						_mStartLine = getInterpreter().getLine();
						_mChannel = _channel;
					}
				} while (_type == MORE);

				if (_mmore) {
					queueModified();

				} else {
					queueMatched();
				}

				emit(_queue.remove());
				return _token;
			}

		} finally {
			_input.release(mark);
		}
	}

	private void queueMatched() {
		MdToken token = (MdToken) _factory.create(_tokenFactorySourcePair, _type, _text, _channel, _tokenStartCharIndex,
				getCharIndex() - 1, _tokenStartLine, _tokenStartCharPositionInLine);
		token.setHit(_lastToken == null, _atBOL);
		_queue.add(token);
	}

	private void queueModified() {
		_mmore = false;
		MdToken token = (MdToken) _factory.create(_tokenFactorySourcePair, _mtype, _text, _mChannel,
				_tokenStartCharIndex, _mStartCharIndex - 1, _tokenStartLine, _tokenStartCharPositionInLine);
		token.setHit(_lastToken == null, _atBOL);
		_queue.add(token);

		if (_type != SKIP) {
			// queue the token that terminated the modified more
			token = (MdToken) _factory.create(_tokenFactorySourcePair, _type, _text, _channel, _mStartCharIndex,
					getCharIndex() - 1, _mStartLine, _mStartCharPositionInLine);
			token.setHit(_lastToken == null, _atBOL);
			_queue.add(token);
		}
	}

	protected void queue(int ttype) {
		queue(ttype, null);
	}

	protected void queue(int ttype, String text) {
		MdToken token = (MdToken) _factory.create(_tokenFactorySourcePair, ttype, text, Token.DEFAULT_CHANNEL,
				_input.index(), _input.index() - 1, getLine(), getCharPositionInLine());
		token.setHit(_lastToken == null, _atBOL);
		_queue.add(token);
	}

	@Override
	public void emit(Token token) {
		if (_lastToken == null && _typeBOF > Token.EOF) {
			_queue.addFirst((MdToken) token);
			token = _factory.create(_tokenFactorySourcePair, _typeBOF, _textBOF, Token.DEFAULT_CHANNEL, 0, -1, 0, 0);
			((MdToken) token).setHit(true, true);
		}
		_lastToken = (MdToken) token;
		super.emit(token);
	}
}
