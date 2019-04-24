/*******************************************************************************
 * Copyright (c) 2017 - 2019 Certiv Analytics. All rights reserved.
 * Use of this file is governed by the Eclipse Public License v1.0
 * that can be found in the LICENSE.txt file in the project root,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package net.certiv.fluent.dt.core.lang.md;

import java.util.ArrayDeque;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.IntStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.LexerNoViableAltException;
import org.antlr.v4.runtime.Token;

/**
 * Modifies the {@code emit} related methods to implement new behaviors:
 * <p>
 * The {@code more} mode is unchanged from the native {@code Lexer} implementation. If {@code more}
 * mode is enabled, the token match is effectively extended to include the first token, other than
 * skipped tokens, matched by a non-{@code more}ed rule. While {@code more} mode is active, no BOL
 * or DENT tokens will be emitted.
 * <p>
 * If {@code modified more} mode is enabled, the token match is effectively extended to include all
 * tokens matched by a the {@code modified more}ed rule. When any other token is matched, the emit
 * of that token is deferred and a constructed token of the {@code modified more} defined type is
 * immediately emitted.
 */
public abstract class LexerNeo extends Lexer {

	// emit pending queue of tokens
	protected final ArrayDeque<MdToken> _queue = new ArrayDeque<>();

	private boolean _mmore;			// modified more mode flag
	private int _mtype;				// token type to emit with content of 'mmore' matches
	private int _mStartCharIndex;	// state after last 'mmore' match
	private int _mStartCharPositionInLine;
	private int _mStartLine;
	private int _mChannel;

	private int _startMatch = -1;
	private int _lastStartLine = -2; // line of last matched token

	public boolean _hitBOF;
	public boolean _hitBOL;

	public LexerNeo(CharStream input) {
		super(input);
	}

	/** Returns the initial index of the current match operation. */
	public int matchStart() {
		return _startMatch;
	}

	public boolean bof() {
		return _hitBOF;
	}

	public boolean bol() {
		return _hitBOL;
	}

	public boolean eof() {
		return _hitEOF;
	}

	protected void queueBOF() {}

	protected void queueBOL() {}

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

		if (_lastStartLine == -2) {
			_lastStartLine = -1;
			_hitBOF = true;
			queueBOF();

		} else if (_lastStartLine > -1) {
			_hitBOF = false;
		}

		if (!_queue.isEmpty()) {
			emit(_queue.remove());
			return _token;
		}

		_startMatch = _input.index();
		int mark = _input.mark();
		try {
			outer: while (true) {
				if (_hitEOF) {
					queueEOF();
					emit(_queue.remove());
					return _token;
				}

				_token = null;
				_channel = Token.DEFAULT_CHANNEL;
				_tokenStartCharIndex = _input.index();
				_tokenStartCharPositionInLine = getInterpreter().getCharPositionInLine();
				_tokenStartLine = getInterpreter().getLine();
				_hitBOL = _lastStartLine < _tokenStartLine;
				_lastStartLine = _tokenStartLine;
				_text = null;
				if (_hitBOL) queueBOL();

				do {
					_type = Token.INVALID_TYPE;
					int ttype;
					try {
						ttype = getInterpreter().match(_input, _mode);
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
		token.setHit(_hitBOF, _hitBOL);
		_queue.add(token);
	}

	private void queueModified() {
		_mmore = false;
		MdToken token = (MdToken) _factory.create(_tokenFactorySourcePair, _mtype, _text, _mChannel,
				_tokenStartCharIndex, _mStartCharIndex - 1, _tokenStartLine, _tokenStartCharPositionInLine);
		token.setHit(_hitBOF, _hitBOL);
		_queue.add(token);

		if (_type != SKIP) {
			// queue the token that terminated the modified more
			token = (MdToken) _factory.create(_tokenFactorySourcePair, _type, _text, _channel, _mStartCharIndex,
					getCharIndex() - 1, _mStartLine, _mStartCharPositionInLine);
			token.setHit(_hitBOF, _hitBOL);
			_queue.add(token);
		}
	}

	protected void queue(int ttype) {
		MdToken token = (MdToken) _factory.create(_tokenFactorySourcePair, ttype, null, Token.DEFAULT_CHANNEL,
				_input.index(), _input.index() - 1, getLine(), getCharPositionInLine());
		token.setHit(_hitBOF, _hitBOL);
		_queue.add(token);
	}
}
