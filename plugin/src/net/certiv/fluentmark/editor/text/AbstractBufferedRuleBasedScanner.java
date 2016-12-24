/*******************************************************************************
 * Copyright (c) 2016 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.editor.text;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.BufferedRuleBasedScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

import net.certiv.fluentmark.Log;
import net.certiv.fluentmark.FluentMkUI;
import net.certiv.fluentmark.editor.color.IColorManager;
import net.certiv.fluentmark.preferences.Prefs;

/**
 * Initialized with a color manager and a preference delta, its subclasses are only responsible for
 * providing a list of preference keys for based on which tokens are generated and to use this
 * tokens to define the rules controlling this scanner.
 * <p>
 * This scanner stores the color defined by the color preference key into the color manager under
 * the same key.
 * </p>
 * <p>
 * Preference color key + {@link DslPrefsKey#EDITOR_BOLD_SUFFIX} are used to retrieve whether the
 * token is rendered in bold.
 * </p>
 * <p>
 * Preference color key + {@link DslPrefsKey#EDITOR_ITALIC_SUFFIX} are used to retrieve whether the
 * token is rendered in italic.
 * </p>
 * <p>
 * Preference color key + {@link DslPrefsKey#EDITOR_STRIKETHROUGH_SUFFIX} are used to retrieve
 * whether the token is rendered in strikethrough.
 * </p>
 * <p>
 * Preference color key + {@link DslPrefsKey#EDITOR_UNDERLINE_SUFFIX} are used to retrieve whether
 * the token is rendered in underline.
 * </p>
 */
public abstract class AbstractBufferedRuleBasedScanner extends BufferedRuleBasedScanner {

	private Map<String, Token> tokenMap = new HashMap<String, Token>();
	private String[] namesColor;
	private String[] namesBold;
	private String[] namesItalic;
	private String[] namesStrikethrough;
	private String[] namesUnderline;
	private boolean needsLazyLoading;
	private IDocument document;
	private IPreferenceStore store;
	private IColorManager colorMgr;

	/**
	 * Returns an array of preference keys which define the tokens used in the rules of this
	 * scanner.
	 * <p>
	 * The preference key is used access the color in the preference delta and in the color manager.
	 * </p>
	 * <p>
	 * Preference key + {@link DslPrefsKey#EDITOR_BOLD_SUFFIX} is used to retrieve whether the token
	 * is rendered in bold.
	 * </p>
	 * <p>
	 * Preference key + {@link DslPrefsKey#EDITOR_ITALIC_SUFFIX} is used to retrieve whether the
	 * token is rendered in italic.
	 * </p>
	 * <p>
	 * Preference key + {@link DslPrefsKey#EDITOR_UNDERLINE_SUFFIX} is used to retrieve whether the
	 * token is rendered underlined.
	 * </p>
	 * <p>
	 * Preference key + {@link DslPrefsKey#EDITOR_STRIKETHROUGH_SUFFIX} is used to retrieve whether
	 * the token is rendered stricken out.
	 * </p>
	 */
	abstract protected String[] getTokenProperties();

	/**
	 * Creates the list of rules controlling this scanner.
	 */
	abstract protected List<IRule> createRules();

	/** Creates an abstract script scanner. */
	public AbstractBufferedRuleBasedScanner() {
		super();
		store = FluentMkUI.getDefault().getPreferenceStore();
		colorMgr = FluentMkUI.getDefault().getColorMgr();
	}

	public void setRange(final IDocument document, int offset, int length) {
		super.setRange(document, offset, length);
		this.document = document;
	}

	/**
	 * Returns an array of the one work prefix string and the two word prefix string ending at the
	 * given document offset.
	 */
	public String getPrefix() {
		try {
			int idx = getTokenOffset();
			while (idx > 0 && Character.isWhitespace(document.getChar(idx - 1))) {
				idx--;
			}
			int jdx = idx;
			while (jdx > 0 && !Character.isWhitespace(document.getChar(jdx - 1))) {
				jdx--;
			}
			return document.get(jdx, idx - jdx);
		} catch (BadLocationException e) {
			Log.error("No prefix scan string found");
		}
		return "";
	}

	/** Must be called after the constructor has been called. */
	public final void initialize() {

		namesColor = getTokenProperties();
		int length = namesColor.length;
		namesBold = new String[length];
		namesItalic = new String[length];
		namesStrikethrough = new String[length];
		namesUnderline = new String[length];

		for (int i = 0; i < length; i++) {
			namesBold[i] = getBoldKey(namesColor[i]);
			namesItalic[i] = getItalicKey(namesColor[i]);
			namesStrikethrough[i] = getStrikethroughKey(namesColor[i]);
			namesUnderline[i] = getUnderlineKey(namesColor[i]);
		}

		needsLazyLoading = Display.getCurrent() == null;
		for (int i = 0; i < length; i++) {
			if (needsLazyLoading) {
				addTokenWithProxyAttribute(namesColor[i], namesBold[i], namesItalic[i], namesStrikethrough[i],
						namesUnderline[i]);
			} else {
				addToken(namesColor[i], namesBold[i], namesItalic[i], namesStrikethrough[i], namesUnderline[i]);
			}
		}
		initializeRules();
	}

	protected String getBoldKey(String colorKey) {
		return colorKey + Prefs.EDITOR_BOLD_SUFFIX;
	}

	protected String getItalicKey(String colorKey) {
		return colorKey + Prefs.EDITOR_ITALIC_SUFFIX;
	}

	protected String getStrikethroughKey(String colorKey) {
		return colorKey + Prefs.EDITOR_STRIKETHROUGH_SUFFIX;
	}

	protected String getUnderlineKey(String colorKey) {
		return colorKey + Prefs.EDITOR_UNDERLINE_SUFFIX;
	}

	public IToken nextToken() {
		if (needsLazyLoading) resolveProxyAttributes();
		return super.nextToken();
	}

	private void resolveProxyAttributes() {
		if (needsLazyLoading && Display.getCurrent() != null) {
			for (int i = 0; i < namesColor.length; i++) {
				addToken(namesColor[i], namesBold[i], namesItalic[i], namesStrikethrough[i], namesUnderline[i]);
			}
			needsLazyLoading = false;
		}
	}

	private void addTokenWithProxyAttribute(String colorKey, String boldKey, String italicKey, String strikeKey,
			String underlineKey) {
		tokenMap.put(colorKey, new Token(createTextAttribute(null, boldKey, italicKey, strikeKey, underlineKey)));
	}

	private void addToken(String colorKey, String boldKey, String italicKey, String strikeKey, String underlineKey) {
		if (colorKey != null) {
			PreferenceConverter.getColor(store, colorKey);	// pre-loads the color manager
			TextAttribute ta = createTextAttribute(colorKey, boldKey, italicKey, strikeKey, underlineKey);
			if (!needsLazyLoading) {
				tokenMap.put(colorKey, new Token(ta));
			} else {
				Token token = tokenMap.get(colorKey);
				if (token != null) {
					token.setData(ta);
				}
			}
		}
	}

	/**
	 * Create a text attribute based on the given color, bold, italic, strikethrough and underline
	 * preference keys.
	 * 
	 * @param colorKey the color preference key
	 * @param boldKey the bold preference key
	 * @param italicKey the italic preference key
	 * @param strikeKey the strikethrough preference key
	 * @param underlineKey the italic preference key
	 * @return the created text attribute
	 */
	private TextAttribute createTextAttribute(String colorKey, String boldKey, String italicKey, String strikeKey,
			String underlineKey) {

		Color color = null;
		if (colorKey != null) color = colorMgr.getColor(colorKey);
		int style = store.getBoolean(boldKey) ? SWT.BOLD : SWT.NORMAL;
		if (store.getBoolean(italicKey)) style |= SWT.ITALIC;
		if (store.getBoolean(strikeKey)) style |= TextAttribute.STRIKETHROUGH;
		if (store.getBoolean(underlineKey)) style |= TextAttribute.UNDERLINE;

		return new TextAttribute(color, null, style);
	}

	protected Token getToken(String key) {
		if (needsLazyLoading) resolveProxyAttributes();
		return tokenMap.get(key);
	}

	private void initializeRules() {
		List<IRule> rules = createRules();
		if (rules != null) {
			IRule[] result = new IRule[rules.size()];
			rules.toArray(result);
			setRules(result);
		}
	}

	private int indexOf(String property) {
		if (property != null) {
			int length = namesColor.length;
			for (int i = 0; i < length; i++) {
				if (property.equals(namesColor[i]) || property.equals(namesBold[i]) || property.equals(namesItalic[i])
						|| property.equals(namesStrikethrough[i]) || property.equals(namesUnderline[i]))
					return i;
			}
		}
		return -1;
	}

	public boolean affectsBehavior(PropertyChangeEvent event) {
		return indexOf(event.getProperty()) >= 0;
	}

	public void adaptToPreferenceChange(PropertyChangeEvent event) {
		String p = event.getProperty();
		int index = indexOf(p);
		Token token = getToken(namesColor[index]);
		if (namesColor[index].equals(p))
			adaptToColorChange(token, event);
		else if (namesBold[index].equals(p))
			adaptToStyleChange(token, event, SWT.BOLD);
		else if (namesItalic[index].equals(p))
			adaptToStyleChange(token, event, SWT.ITALIC);
		else if (namesStrikethrough[index].equals(p))
			adaptToStyleChange(token, event, TextAttribute.STRIKETHROUGH);
		else if (namesUnderline[index].equals(p)) adaptToStyleChange(token, event, TextAttribute.UNDERLINE);
	}

	private void adaptToColorChange(Token token, PropertyChangeEvent event) {
		RGB rgb = null;

		Object value = event.getNewValue();
		if (value instanceof RGB) {
			rgb = (RGB) value;
		} else if (value instanceof String) {
			rgb = StringConverter.asRGB((String) value);
		}

		if (rgb != null) {

			String property = event.getProperty();
			Color color = colorMgr.getColor(property);
			if (!rgb.equals(color.getRGB())) {
				colorMgr.setValue(property, rgb);
				color = colorMgr.getColor(property);
			}

			Object data = token.getData();
			if (data instanceof TextAttribute) {
				TextAttribute oldAttr = (TextAttribute) data;
				token.setData(new TextAttribute(color, oldAttr.getBackground(), oldAttr.getStyle()));
			}
		}
	}

	private void adaptToStyleChange(Token token, PropertyChangeEvent event, int styleAttribute) {
		boolean eventValue = false;
		Object value = event.getNewValue();
		if (value instanceof Boolean)
			eventValue = ((Boolean) value).booleanValue();
		else if (IPreferenceStore.TRUE.equals(value)) eventValue = true;

		Object data = token.getData();
		if (data instanceof TextAttribute) {
			TextAttribute oldAttr = (TextAttribute) data;
			boolean activeValue = (oldAttr.getStyle() & styleAttribute) == styleAttribute;
			if (activeValue != eventValue)
				token.setData(new TextAttribute(oldAttr.getForeground(), oldAttr.getBackground(),
						eventValue ? oldAttr.getStyle() | styleAttribute : oldAttr.getStyle() & ~styleAttribute));
		}
	}
}
