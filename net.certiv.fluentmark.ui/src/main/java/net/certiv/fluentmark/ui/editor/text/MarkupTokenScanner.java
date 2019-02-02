/*******************************************************************************
 * Copyright (c) 2007, 2013 David Green and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     David Green - initial API and implementation
 *******************************************************************************/
package net.certiv.fluentmark.ui.editor.text;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.prefs.Preferences;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.graphics.Font;

import net.certiv.dsl.core.model.Block;
import net.certiv.dsl.ui.Messages;
import net.certiv.fluentmark.ui.editor.text.css.CssParser;
import net.certiv.fluentmark.ui.editor.text.css.CssRule;
import net.certiv.fluentmark.ui.editor.text.css.CssStyleManager;
import net.certiv.fluentmark.ui.editor.text.css.FontState;

/**
 * A token scanner that uses the results of the {@link FastMarkupPartitioner} to identify tokens.
 *
 * @author David Green
 */
public class MarkupTokenScanner implements ITokenScanner {

	private Token currentToken = null;

	private Iterator<Token> tokenIt = null;

	private CssStyleManager styleManager;

	private FontState defaultState;

	private Preferences preferences;

	private final CssParser cssParser = new CssParser();

	public MarkupTokenScanner(Font defaultFont, Font defaultMonospaceFont) {
		initialize(defaultFont, defaultMonospaceFont);
		reloadPreferences();
	}

	/**
	 * Reset the fonts used by this token scanner.
	 *
	 * @param defaultFont the default font, must not be null.
	 * @param defaultMonospaceFont the default monospace font, or null if a suitable default should be
	 *            selected
	 */
	public void resetFonts(Font defaultFont, Font defaultMonospaceFont) {
		if (defaultFont == null) {
			throw new IllegalArgumentException();
		}
		initialize(defaultFont, defaultMonospaceFont);
	}

	private void initialize(Font defaultFont, Font defaultMonospaceFont) {
		styleManager = new CssStyleManager(defaultFont, defaultMonospaceFont);
		defaultState = styleManager.createDefaultFontState();
	}

	public void reloadPreferences() {
		preferences = WikiTextUiPlugin.getDefault().getPreferences();
	}

	@Override
	public int getTokenLength() {
		return currentToken == null ? -1 : currentToken.getLength();
	}

	@Override
	public int getTokenOffset() {
		return currentToken == null ? -1 : currentToken.getOffset();
	}

	@Override
	public IToken nextToken() {
		if (tokenIt != null && tokenIt.hasNext()) {
			currentToken = tokenIt.next();
		} else {
			currentToken = null;
			tokenIt = null;
			return org.eclipse.jface.text.rules.Token.EOF;
		}
		return currentToken;
	}

	@Override
	public void setRange(IDocument document, int offset, int length) {
		IDocumentPartitioner partitioner = document.getDocumentPartitioner();
		List<Token> tokens = null;

		if (partitioner instanceof FastMarkupPartitioner) {
			FastMarkupPartitioner fastMarkupPartitioner = (FastMarkupPartitioner) partitioner;
			ITypedRegion[] partitioning = partitioner.computePartitioning(offset, length);
			if (partitioning != null) {
				tokens = new ArrayList<>();

				ITypedRegion[] partitions = ((FastMarkupPartitioner) partitioner).getScanner()
						.computePartitions(document, offset, length);
				int lastEnd = offset;

				Token defaultToken;
				{
					StyleRange styleRange = styleManager.createStyleRange(defaultState, 0, 1);
					TextAttribute textAttribute = createTextAttribute(styleRange);
					defaultToken = new Token(defaultState, textAttribute, offset, length);
				}
				if (partitions != null) {
					for (ITypedRegion region : partitions) {
						if (region.getOffset() >= (offset + length)) {
							break;
						}
						if ((region.getOffset() + region.getLength()) < offset) {
							continue;
						}
						if (region instanceof MarkupPartition) {
							MarkupPartition partition = (MarkupPartition) region;

							if (lastEnd < partition.getOffset()) {
								Token blockBridgeToken = new Token(defaultToken.fontState, defaultToken.getData(),
										lastEnd, partition.getOffset() - lastEnd);
								addToken(tokens, blockBridgeToken);
							}

							// a token that spans the whole block
							Token blockToken = createToken(partition);
							if (blockToken == null) {
								blockToken = defaultToken;
							}
							if (!partition.getBlock().isSpansComputed()) {
								fastMarkupPartitioner.reparse(document, partition.getBlock());
							}
							List<Span> spans = partition.getSpans();
							if (spans != null) {
								for (Span span : spans) {
									if (span.getOffset() < lastEnd) {
										continue;
									}
									Token spanToken = createToken(blockToken.getFontState(), span);
									if (spanToken != null) {
										int blockTokenStartOffset = lastEnd < offset ? offset : lastEnd;
										if (blockTokenStartOffset < spanToken.getOffset()) {
											int blockTokenLength = spanToken.getOffset() - blockTokenStartOffset;
											final Token blockBridgeToken = new Token(blockToken.fontState,
													blockToken.getData(), blockTokenStartOffset, blockTokenLength);
											addToken(tokens, blockBridgeToken);
										}

										Token[] spanTokens = null;
										if (!span.getChildren().isEmpty()) {
											spanTokens = splitSpan(spanToken, span, defaultToken);
										}
										if (spanTokens != null) {
											for (Token spanSplitToken : spanTokens) {
												addToken(tokens, spanSplitToken);
											}
										} else {
											addToken(tokens, spanToken);
										}
										lastEnd = spanToken.offset + spanToken.length;
										if (lastEnd > partition.getOffset() + partition.getLength()) {
											throw new IllegalStateException();
										}
									}
								}
							}
							final int partitionEnd = partition.getOffset() + partition.getLength();
							if (lastEnd < partitionEnd) {
								final int realLastEnd = Math.max(lastEnd, partition.getOffset());
								int diff = (partitionEnd) - realLastEnd;
								if (diff > 0) {
									int blockTokenStartOffset = realLastEnd;
									int blockTokenLength = diff;
									final Token blockBridgeToken = new Token(blockToken.fontState, blockToken.getData(),
											blockTokenStartOffset, blockTokenLength);
									addToken(tokens, blockBridgeToken);
									lastEnd = blockTokenStartOffset + blockTokenLength;
									if (lastEnd > partition.getOffset() + partition.getLength()) {
										throw new IllegalStateException();
									}
								}
							}
						}
					}
				}
				if (lastEnd < (offset + length)) {
					addToken(tokens, new Token(defaultToken.fontState, defaultToken.getData(), lastEnd,
							length - (lastEnd - offset)));
				}
			}
		}

		currentToken = null;
		if (tokens == null || tokens.isEmpty()) {
			tokenIt = null;
		} else {
			Iterator<Token> it = tokens.iterator();
			while (it.hasNext()) {
				Token next = it.next();
				if (next.getOffset() < offset) {
					it.remove();
				} else if (next.getOffset() + next.getLength() > (offset + length)) {
					it.remove();
				}
			}
			tokenIt = tokens.iterator();
		}

	}

	protected TextAttribute createTextAttribute(StyleRange styleRange) {
		int fontStyle = styleRange.fontStyle;
		if (styleRange.strikeout) {
			fontStyle |= TextAttribute.STRIKETHROUGH;
		}
		if (styleRange.underline) {
			fontStyle |= TextAttribute.UNDERLINE;
		}
		return new TextAttribute(styleRange.foreground, styleRange.background, fontStyle, styleRange.font);
	}

	/**
	 * handle nested spans: given a token for a specific span, split it into one or more tokens based on
	 * analyzing its children
	 *
	 * @return an array of tokens that contiguously cover the region represented by the original span.
	 */
	private Token[] splitSpan(Token spanToken, Span span, Token defaultToken) {
		List<Token> tokens = new ArrayList<>(span.getChildren().size() + 1);
		int previousEnd = spanToken.offset;
		for (Span child : span.getChildren().asList()) {
			if (child.getOffset() > previousEnd) {
				tokens.add(new Token(spanToken.fontState, spanToken.getData(), previousEnd,
						child.getOffset() - previousEnd));
			}
			Token childToken = createToken(spanToken.fontState, child);
			if (childToken == null) {
				StyleRange styleRange = styleManager.createStyleRange(spanToken.fontState, 0, 1);
				TextAttribute textAttribute = createTextAttribute(styleRange);
				childToken = new Token(spanToken.fontState, textAttribute, child.getOffset(), child.getLength());
			}
			if (child.getChildren().isEmpty()) {
				tokens.add(childToken);
			} else {
				// recursively apply to children
				for (Token t : splitSpan(childToken, child, defaultToken)) {
					tokens.add(t);
				}
			}
			previousEnd = child.getEndOffset();
		}
		if (previousEnd < span.getEndOffset()) {
			tokens.add(new Token(spanToken.fontState, spanToken.getData(), previousEnd,
					span.getEndOffset() - previousEnd));
		}
		return tokens.toArray(new Token[tokens.size()]);
	}

	private void addToken(List<Token> tokens, Token newToken) {
		checkAddToken(tokens, newToken);
		tokens.add(newToken);
	}

	private void checkAddToken(List<Token> tokens, Token newToken) {
		if (newToken.getLength() <= 0) {
			throw new IllegalStateException(
					NLS.bind(Messages.MarkupTokenScanner_badTokenLength, new Object[] { newToken.getLength() }));
		}
		if (newToken.getOffset() < 0) {
			throw new IllegalStateException(
					NLS.bind(Messages.MarkupTokenScanner_badTokenOffset, new Object[] { newToken.getOffset() }));
		}
		if (!tokens.isEmpty()) {
			Token previous = tokens.get(tokens.size() - 1);
			if (previous.getOffset() >= newToken.getOffset()) {
				throw new IllegalStateException(Messages.MarkupTokenScanner_2);
			} else if (previous.getOffset() + previous.getLength() > newToken.getOffset()) {
				throw new IllegalStateException(Messages.MarkupTokenScanner_3);
			}
		}
	}

	private Token createToken(FontState parentState, Span span) {
		if (span.getLength() == 0) {
			return null;
		}
		String cssStyles = null;
		String key = null;
		switch (span.getType()) {
			case BOLD:
				key = Preferences.PHRASE_BOLD;
				break;
			case CITATION:
				key = Preferences.PHRASE_CITATION;
				break;
			case CODE:
				key = Preferences.PHRASE_CODE;
				break;
			case DELETED:
				key = Preferences.PHRASE_DELETED_TEXT;
				break;
			case EMPHASIS:
				key = Preferences.PHRASE_EMPHASIS;
				break;
			case INSERTED:
				key = Preferences.PHRASE_INSERTED_TEXT;
				break;
			case ITALIC:
				key = Preferences.PHRASE_ITALIC;
				break;
			case MONOSPACE:
				key = Preferences.PHRASE_MONOSPACE;
				break;
			case QUOTE:
				key = Preferences.PHRASE_QUOTE;
				break;
			case SPAN:
				key = Preferences.PHRASE_SPAN;
				break;
			case STRONG:
				key = Preferences.PHRASE_STRONG;
				break;
			case SUBSCRIPT:
				key = Preferences.PHRASE_SUBSCRIPT;
				break;
			case SUPERSCRIPT:
				key = Preferences.PHRASE_SUPERSCRIPT;
				break;
			case UNDERLINED:
				key = Preferences.PHRASE_UNDERLINED;
				break;
			case MARK:
				key = Preferences.PHRASE_MARK;
				break;
		}
		cssStyles = preferences.getCssByPhraseModifierType().get(key);
		if (cssStyles == null && span.getAttributes().getCssStyle() == null && span.getChildren().isEmpty()) {
			return null;
		}
		FontState fontState = new FontState(parentState);
		if (cssStyles != null) {
			processCssStyles(fontState, parentState, cssStyles);
		}
		if (span.getAttributes().getCssStyle() != null) {
			processCssStyles(fontState, parentState, span.getAttributes().getCssStyle());
		}
		StyleRange styleRange = styleManager.createStyleRange(fontState, 0, 1);

		TextAttribute textAttribute = createTextAttribute(styleRange);
		return new Token(fontState, textAttribute, span.getOffset(), span.getLength());
	}

	private Token createToken(MarkupPartition partition) {
		if (partition.getLength() == 0) {
			return null;
		}
		FontState fontState = new FontState(defaultState);
		boolean hasStyles = processStyles(partition.getBlock(), partition, fontState);

		if (partition.getBlock().getAttributes().getCssStyle() != null) {
			processCssStyles(fontState, defaultState, partition.getBlock().getAttributes().getCssStyle());
		} else {
			if (!hasStyles) {
				return null;
			}
		}
		StyleRange styleRange = styleManager.createStyleRange(fontState, 0, 1);

		TextAttribute textAttribute = createTextAttribute(styleRange);
		return new Token(fontState, textAttribute, partition.getOffset(), partition.getLength());
	}

	private boolean processStyles(Block block, MarkupPartition partition, FontState fontState) {
		boolean hasStyles = false;
		if (block.getParent() != null) {
			hasStyles = processStyles(block.getParent(), partition, fontState);
		}
		String cssStyles = computeCssStyles(block, partition);
		if (cssStyles != null) {
			hasStyles = true;
			processCssStyles(fontState, defaultState, cssStyles);
		}
		return hasStyles;
	}

	private String computeCssStyles(Block block, MarkupPartition partition) {
		String cssStyles = null;
		if (block.getHeadingLevel() > 0) {
			cssStyles = preferences.getCssByBlockModifierType()
					.get(Preferences.HEADING_PREFERENCES[block.getHeadingLevel()]);
		} else if (block.getType() != null) {
			String key = null;
			switch (block.getType()) {
				case CODE:
					key = Preferences.BLOCK_BC;
					break;
				case QUOTE:
					key = Preferences.BLOCK_QUOTE;
					break;
				case PREFORMATTED:
					key = Preferences.BLOCK_PRE;
					break;
				case DEFINITION_TERM:
					key = Preferences.BLOCK_DT;
					break;
			}
			cssStyles = preferences.getCssByBlockModifierType().get(key);
		}
		return cssStyles;
	}

	private void processCssStyles(FontState fontState, FontState parentState, String cssStyles) {
		Iterator<CssRule> ruleIterator = cssParser.createRuleIterator(cssStyles);
		while (ruleIterator.hasNext()) {
			styleManager.processCssStyles(fontState, parentState, ruleIterator.next());
		}
	}

	/**
	 * public for testing purposes
	 */
	public static class Token extends org.eclipse.jface.text.rules.Token {

		private final int offset;

		private final int length;

		private final FontState fontState;

		public Token(FontState fontState, TextAttribute attribute, int offset, int length) {
			super(attribute);
			this.fontState = fontState;
			if (offset < 0) {
				throw new IllegalArgumentException();
			}
			if (length < 0) {
				throw new IllegalArgumentException();
			}
			this.offset = offset;
			this.length = length;
		}

		public int getOffset() {
			return offset;
		}

		public int getLength() {
			return length;
		}

		public FontState getFontState() {
			return fontState;
		}

		@Override
		public TextAttribute getData() {
			return (TextAttribute) super.getData();
		}

		@Override
		public String toString() {
			return "Token [offset=" + offset + ", length=" + length + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}
	}
}
