/*******************************************************************************
 * Copyright (c) 2017 - 2023 Certiv Analytics. All rights reserved.
 * Use of this file is governed by the Eclipse Public License v1.0
 * that can be found in the LICENSE.txt file in the project root,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package net.certiv.fluent.dt.core.lang;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.IntStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.LexerNoViableAltException;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.misc.Interval;

import net.certiv.common.util.Strings;

/**
 * Modifies the {@code emit} related methods to implement new structured NLP supporting
 * behaviors:
 * <ol>
 * <li>Adds structured-NLP flags
 * <ol>
 * <li><b>_atBOF</b> : {@code true} until <b>_bol</b> first becomes {@code false}
 * <li><b>_bol</b> : {@code true} from column-0 up to the first character not within a
 * line-prefix filter set
 * <li><b>_bob</b> : {@code true} once a defined Vws token series is encountered and until
 * the first token not within a block-prefix filter set is emitted
 * <li><b>_hitEOF</b> : {@code true} once an EOF condition is hit
 * </ol>
 * <li>Adds a parameterized <b>more</b> action.
 * <ul>
 * <li>matched text accumulates into a synthetic token of the type defined by the
 * parameterized <b>more</b> action
 * <li>the synthetic token is emitted when any other non-skipped rule is matched
 * </ul>
 * <li>Retains the native <b>more</b> action.
 * <ul>
 * <li>matched text accumulates into the first token, other than skipped token text,
 * matched by a non-<b>more</b> rule.
 * <li>while <b>more</b> mode is active, no BOL or DENT tokens will be emitted.
 */
public abstract class LexerNlp extends Lexer {

	/** Token type that marks a new block start. */
	protected int blockType = Token.INVALID_TYPE;
	/** Token types to ignore at the beginning of a new line. */
	protected final Set<Integer> preLineTypes = new HashSet<>();
	/** Token types to ignore at the beginning of a new block. */
	protected final Set<Integer> preBlockTypes = new HashSet<>();

	// flags & data for 'beginning of' state
	protected boolean _atBOF = true;	// beginning of file
	protected boolean _atNL = true;		// new line
	protected boolean _begLine = true;	// beginning of line
	protected boolean _begBlock = true;	// beginning of block

	// flags & data for 'parameterized more' mode
	protected boolean _pmore;		// parameterized more mode flag
	protected int _ptype;			// parameterized more token type
	protected int _pStartCharIndex;	// offset after last match
	protected int _pStartCharPositionInLine;
	protected int _pStartLine;
	protected int _pChannel;

	// fields for synthetic BOF/preEOF tokens
	private boolean bofToken = false;
	private int bofType = Token.INVALID_TYPE;
	private String bofText = Strings.EMPTY;
	private boolean eofToken = false;
	private int eofType = Token.INVALID_TYPE;
	private String eofText = Strings.EMPTY;

	/** Tokens internally cached pending external emit */
	protected final ArrayDeque<Token> _queue = new ArrayDeque<>();

	public LexerNlp(CharStream input) {
		super(input);
		preBlockTypes.add(Token.EPSILON); // internal/never emitted
		preLineTypes.add(Token.EPSILON);
	}

	/**
	 * Defines a single token to be emitted once immediately at BOF.
	 *
	 * @param ttype the token type
	 * @param text  the token text content
	 */
	public void setBofToken(int ttype, String text) {
		bofToken = true;
		bofType = ttype;
		bofText = text;
	}

	/**
	 * Defines a token to be emitted once immediately prior to an EOF.
	 *
	 * @param ttype the token type
	 * @param text  the token text content
	 */
	public void setEofToken(int ttype, String text) {
		eofToken = true;
		eofType = ttype;
		eofText = text;
	}

	/**
	 * Defines the token types to be ignored when determining when the significant text of
	 * a line begins.
	 *
	 * @param ttypes token types to ignore
	 * @see LexerNlp#bof()
	 * @see LexerNlp#bol()
	 */
	public void setLnBegPrefixes(Integer... ttypes) {
		preLineTypes.addAll(Arrays.asList(ttypes));
	}

	/**
	 * Defines a single token that identifies the beginning of a block.
	 *
	 * @param ttype the token type
	 */
	public void setBlockBeg(int ttype) {
		blockType = ttype;
	}

	/**
	 * Defines the token types to be ignored when determining when the significant text of
	 * a block begins.
	 *
	 * @param ttypes token types to ignore
	 */
	public void setBlkBegPrefixes(Integer... ttypes) {
		preBlockTypes.addAll(Arrays.asList(ttypes));
	}

	/**
	 * Returns {@code true} if the lexer is functionally at the beginning of file: until
	 * the first non-line begin prefix token has been internally emitted.
	 */
	public boolean bof() {
		return _atBOF;
	}

	/**
	 * Returns {@code true} if the lexer is functionally at start of a new line: until the
	 * first token of the line has been internally emitted.
	 */
	public boolean nl() {
		return _atNL;
	}

	/** Returns {@code true} while at beginning of a line. */
	public boolean bol() {
		return _begLine;
	}

	/**
	 * Returns {@code true} while at beginning of block: until the first non-block begin
	 * prefix token has been externally emitted.
	 */
	public boolean bob() {
		return _begBlock;
	}

	/** Returns {@code true} if the lexer has hit the end-of-file. */
	public boolean eof() {
		return _hitEOF;
	}

	/**
	 * Enables the conventional more mode.
	 */
	@Override
	public void more() {
		_type = MORE;
		_pmore = false;
	}

	/**
	 * Enables the parameterized {@code more} mode to collect continuing text to a token
	 * of the given type.
	 *
	 * @param a target token type
	 */
	public void more(int ttype) {
		_type = MORE;
		_pmore = true;
		_ptype = ttype;
	}

	@Override
	public int getLine() {
		LexerATNSimulator sim = getInterpreter();
		return sim != null ? sim.getLine() : 0;
	}

	@Override
	public int getCharPositionInLine() {
		LexerATNSimulator sim = getInterpreter();
		return sim != null ? sim.getCharPositionInLine() : 0;
	}

	@Override
	public void emit(Token token) {
		int type = token.getType();
		if (blockType == type) _begBlock = true;
		if (_begBlock && !preBlockTypes.contains(type)) _begBlock = false;
		super.emit(token);
	}

	@Override
	public Token nextToken() {
		if (_input == null)
			throw new IllegalStateException("'nextToken()' requires a non-null input stream.");

		if (bofToken) {
			queue(bofType, bofText);
			bofToken = false;
		}

		int mark = _input.mark();
		try {
			outer:
			while (true) {
				if (_queue.isEmpty()) {
					if (_hitEOF) {
						queueEOF();
						emit(_queue.remove());
						return _token;
					}

					_token = null;
					_text = null;
					_channel = _pChannel = Token.DEFAULT_CHANNEL;
					_tokenStartCharIndex = _pStartCharIndex = _input.index();
					_tokenStartCharPositionInLine = _pStartCharPositionInLine = getInterpreter()
							.getCharPositionInLine();
					_tokenStartLine = _pStartLine = getInterpreter().getLine();
					_atNL = _tokenStartCharPositionInLine == 0;
					if (_atNL) {
						_begLine = true;
					}

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
						if (_begLine && !preLineTypes.contains(_type)) {
							_atBOF = _begLine = false;
							// Log.debug("Start of text @%s:%s : %s", _pStartLine,
							// _pStartCharPositionInLine,
							// getVocabulary().getDisplayName(_type));
						}

						if (_type == SKIP && !_pmore) continue outer;
						if (_type == MORE && _pmore) {
							_pStartCharIndex = _input.index();
							_pStartCharPositionInLine = getInterpreter().getCharPositionInLine();
							_pStartLine = getInterpreter().getLine();
							_pChannel = _channel;
						}
					} while (_type == MORE);

					if (_pmore) {
						queueMore();

					} else {
						queueMatched();
					}
				}

				emit(_queue.remove());
				return _token;
			}

		} finally {
			_input.release(mark);
		}
	}

	private Token createMatched() {
		return _factory.create(_tokenFactorySourcePair, _type, _text, _channel, _tokenStartCharIndex,
				getCharIndex() - 1, _tokenStartLine, _tokenStartCharPositionInLine);
	}

	private void queueMatched() {
		_queue.add(createMatched());
	}

	private void queueMore() {
		_pmore = false;
		Token token = _factory.create(_tokenFactorySourcePair, _ptype, _text, _pChannel, _tokenStartCharIndex,
				_pStartCharIndex - 1, _tokenStartLine, _tokenStartCharPositionInLine);
		_queue.add(token);

		if (_type != SKIP) {
			// queue token terminating the parameterized more
			token = _factory.create(_tokenFactorySourcePair, _type, _text, _channel, _pStartCharIndex,
					getCharIndex() - 1, _pStartLine, _pStartCharPositionInLine);
			_queue.add(token);
		}
	}

	protected void queueEOF() {
		if (eofToken) {
			queue(eofType, eofText);
			eofToken = false;
		}
		queue(Token.EOF);
	}

	protected void queue(int ttype) {
		queue(ttype, null);
	}

	protected void queue(int ttype, String text) {
		Token token = _factory.create(_tokenFactorySourcePair, ttype, text, Token.DEFAULT_CHANNEL,
				_input.index(), _input.index() - 1, getLine(), getCharPositionInLine());
		_queue.add(token);
	}

	/** Returns the current matched string pending internal emit */
	protected String currentMatched() {
		int end = getCharIndex() - 1;
		// if (_pStartCharIndex == end) return Strings.EMPTY;
		return _input.getText(Interval.of(_pStartCharIndex, end));
	}

	/**
	 * Returns {@code true} if the next character in the input data stream is a space.
	 */
	protected boolean laWS() {
		return Character.isSpaceChar(la(1).charAt(0));
	}

	/**
	 * Returns {@code true} if the prior character in the input data stream is a space.
	 */
	protected boolean lbWS() {
		return Character.isSpaceChar(la(-1).charAt(0));
	}

	protected String la(int cnt) {
		if (cnt < 0) {
			int beg = Math.min(0, _tokenStartCharIndex + cnt);
			return _input.getText(Interval.of(beg, _tokenStartCharIndex));
		}
		int end = Math.min(_tokenStartCharIndex + cnt, _input.size() - 1);
		return _input.getText(Interval.of(_tokenStartCharIndex, end));
	}

	/** Debug. */
	protected String laDebug(int cnt) {
		String content = Strings.ellipsize(Strings.encode(la(cnt)), Math.abs(cnt));
		return String.format("@%s [%s:%s] (%s) %s", _tokenStartCharIndex, _tokenStartLine,
				_tokenStartCharPositionInLine, _mode, content);
	}
}
