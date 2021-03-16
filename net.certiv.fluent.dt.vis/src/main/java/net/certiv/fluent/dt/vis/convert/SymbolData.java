/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluent.dt.vis.convert;

import java.util.LinkedHashMap;

public abstract class SymbolData {

	private static LinkedHashMap<String, String[]> refMap;
	private static LinkedHashMap<String, String[]> tipMap;

	protected SymbolData() {}

	protected static LinkedHashMap<String, String[]> getRefMap() {
		if (refMap == null) init();
		return refMap;
	}

	protected static LinkedHashMap<String, String[]> getTipMap() {
		if (tipMap == null) init();
		return tipMap;
	}

	private static void init() {
		refMap = new LinkedHashMap<String, String[]>();
		tipMap = new LinkedHashMap<String, String[]>();

		// <!-- Special characters for HTML -->

		// <!-- C0 Controls and Basic Latin -->
		add("quot", "&#34;", "\"", "quotation mark = APL quote, U+0022"); // ISOnum
		add("amp", "&#38;", "\u0026", "ampersand, U+0026"); // ISOnum
		add("lt", "&#60;", "\u003C", "less-than sign, U+003C"); // ISOnum
		add("gt", "&#62;", "\u003E", "greater-than sign, U+003E"); // ISOnum

		// <!-- Latin Extended-A -->
		add("OElig", "&#338;", "\u0152", "latin capital ligature OE, U+0152"); // ISOlat2
		add("oelig", "&#339;", "\u0153", "latin small ligature oe, U+0153"); // ISOlat2
		// <!-- ligature is a misnomer, this is a separate character in some languages
		add("Scaron", "&#352;", "\u0160", "latin capital letter S with caron, U+0160"); // ISOlat2
		add("scaron", "&#353;", "\u0161", "latin small letter s with caron, U+0161"); // ISOlat2
		add("Yuml", "&#376;", "\u0178", "latin capital letter Y with diaeresis, U+0178"); // ISOlat2

		// <!-- Spacing Modifier Letters -->
		add("circ", "&#710;", "\u02C6", "modifier letter circumflex accent, U+02C6"); // ISOpub
		add("tilde", "&#732;", "\u02DC", "small tilde, U+02DC"); // ISOdia

		// <!-- General Punctuation -->
		add("ensp", "&#8194;", "\u2002", "en space, U+2002"); // ISOpub
		add("emsp", "&#8195;", "\u2003", "em space, U+2003"); // ISOpub
		add("thinsp", "&#8201;", "\u2009", "thin space, U+2009"); // ISOpub
		add("zwnj", "&#8204;", "\u200C", "zero width non-joiner, U+200C"); // NEW RFC 2070
		add("zwj", "&#8205;", "\u200D", "zero width joiner, U+200D"); // NEW RFC 2070
		add("lrm", "&#8206;", "\u200E", "left-to-right mark, U+200E"); // NEW RFC 2070
		add("rlm", "&#8207;", "\u200F", "right-to-left mark, U+200F"); // NEW RFC 2070
		add("ndash", "&#8211;", "\u2013", "en dash, U+2013"); // ISOpub
		add("mdash", "&#8212;", "\u2014", "em dash, U+2014"); // ISOpub
		add("lsquo", "&#8216;", "\u2018", "left single quotation mark, U+2018"); // ISOnum
		add("rsquo", "&#8217;", "\u2019", "right single quotation mark, U+2019"); // ISOnum
		add("sbquo", "&#8218;", "\u201A", "single low-9 quotation mark, U+201A"); // NEW
		add("ldquo", "&#8220;", "\u201C", "left double quotation mark, U+201C"); // ISOnum
		add("rdquo", "&#8221;", "\u201D", "right double quotation mark, U+201D"); // ISOnum
		add("bdquo", "&#8222;", "\u201E", "double low-9 quotation mark, U+201E"); // NEW
		add("dagger", "&#8224;", "\u2020", "dagger, U+2020"); // ISOpub
		add("Dagger", "&#8225;", "\u2021", "double dagger, U+2021"); // ISOpub
		add("permil", "&#8240;", "\u2030", "per mille sign, U+2030"); // ISOtech
		add("lsaquo", "&#8249;", "\u2039", "single left-pointing angle quotation mark, U+2039"); // ISO proposed
		// <!-- lsaquo is proposed but not yet ISO standardized -->
		add("rsaquo", "&#8250;", "\u203A", "single right-pointing angle quotation mark, U+203A"); // ISO proposed
		// <!-- rsaquo is proposed but not yet ISO standardized
		add("euro", "&#8364;", "\u20AC", "euro sign, U+20AC"); // NEW

		// <!-- Character entity set. -->

		add("nbsp", "&#160;", "\u00A0", "no-break space = non-breaking space,U+00A0"); // ISOnum
		add("iexcl", "&#161;", "\u00A1", "inverted exclamation mark, U+00A1"); // ISOnum
		add("cent", "&#162;", "\u00A2", "cent sign, U+00A2"); // ISOnum
		add("pound", "&#163;", "\u00A3", "pound sign, U+00A3"); // ISOnum
		add("curren", "&#164;", "\u00A4", "currency sign, U+00A4"); // ISOnum
		add("yen", "&#165;", "\u00A5", "yen sign = yuan sign, U+00A5"); // ISOnum
		add("brvbar", "&#166;", "\u00A6", "broken bar = broken vertical bar,U+00A6"); // ISOnum
		add("sect", "&#167;", "\u00A7", "section sign, U+00A7"); // ISOnum
		add("uml", "&#168;", "\u00A8", "diaeresis = spacing diaeresis,U+00A8"); // ISOdia
		add("copy", "&#169;", "\u00A9", "copyright sign, U+00A9"); // ISOnum
		add("ordf", "&#170;", "\u00AA", "feminine ordinal indicator, U+00AA"); // ISOnum
		add("laquo", "&#171;", "\u00AB", "left-pointing double angle quotation mark = left pointing guillemet, U+00AB"); // ISOnum
		add("not", "&#172;", "\u00AC", "not sign, U+00AC"); // ISOnum
		add("shy", "&#173;", "\u00AD", "soft hyphen = discretionary hyphen,U+00AD"); // ISOnum
		add("reg", "&#174;", "\u00AE", "registered sign = registered trade mark sign,U+00AE"); // ISOnum
		add("macr", "&#175;", "\u00AF", "macron = spacing macron = overline= APL overbar, U+00AF"); // ISOdia
		add("deg", "&#176;", "\u00B0", "degree sign, U+00B0"); // ISOnum
		add("plusmn", "&#177;", "\u00B1", "plus-minus sign = plus-or-minus sign,U+00B1"); // ISOnum
		add("sup2", "&#178;", "\u00B2", "superscript two = superscript digit two=squared, U+00B2"); // ISOnum
		add("sup3", "&#179;", "\u00B3", "superscript three = superscript digit three= cubed, U+00B3"); // ISOnum
		add("acute", "&#180;", "\u00B4", "acute accent = spacing acute,U+00B4"); // ISOdia
		add("micro", "&#181;", "\u00B5", "micro sign, U+00B5"); // ISOnum
		add("para", "&#182;", "\u00B6", "pilcrow sign = paragraph sign,U+00B6"); // ISOnum
		add("middot", "&#183;", "\u00B7", "middle dot = Georgian comma= Greek middle dot, U+00B7"); // ISOnum
		add("cedil", "&#184;", "\u00B8", "cedilla = spacing cedilla, U+00B8"); // ISOdia
		add("sup1", "&#185;", "\u00B9", "superscript one = superscript digit one, U+00B9"); // ISOnum
		add("ordm", "&#186;", "\u00BA", "masculine ordinal indicator, U+00BA"); // ISOnum
		add("raquo", "&#187;", "\u00BB", "right-pointing double angle quotation mark = right pointing guillemet, U+00BB"); // ISOnum
		add("frac14", "&#188;", "\u00BC", "vulgar fraction one quarter = fraction one quarter, U+00BC"); // ISOnum
		add("frac12", "&#189;", "\u00BD", "vulgar fraction one half = fraction one half, U+00BD"); // ISOnum
		add("frac34", "&#190;", "\u00BE", "vulgar fraction three quarters = fraction three quarters, U+00BE"); // ISOnum
		add("iquest", "&#191;", "\u00BF", "inverted question mark = turned question mark, U+00BF"); // ISOnum
		add("Agrave", "&#192;", "\u00C0", "latin capital letter A with grave = latin capital letter A grave, U+00C0"); // ISOlat1
		add("Aacute", "&#193;", "\u00C1", "latin capital letter A with acute, U+00C1"); // ISOlat1
		add("Acirc", "&#194;", "\u00C2", "latin capital letter A with circumflex, U+00C2"); // ISOlat1
		add("Atilde", "&#195;", "\u00C3", "latin capital letter A with tilde, U+00C3"); // ISOlat1
		add("Auml", "&#196;", "\u00C4", "latin capital letter A with diaeresis, U+00C4"); // ISOlat1
		add("Aring", "&#197;", "\u00C5", "latin capital letter A with ring above = latin capital letter A ring, U+00C5"); // ISOlat1
		add("AElig", "&#198;", "\u00C6", "latin capital letter AE = latin capital ligature AE, U+00C6"); // ISOlat1
		add("Ccedil", "&#199;", "\u00C7", "latin capital letter C with cedilla, U+00C7"); // ISOlat1
		add("Egrave", "&#200;", "\u00C8", "latin capital letter TYPE with grave, U+00C8"); // ISOlat1
		add("Eacute", "&#201;", "\u00C9", "latin capital letter TYPE with acute, U+00C9"); // ISOlat1
		add("Ecirc", "&#202;", "\u00CA", "latin capital letter TYPE with circumflex, U+00CA"); // ISOlat1
		add("Euml", "&#203;", "\u00CB", "latin capital letter TYPE with diaeresis, U+00CB"); // ISOlat1
		add("Igrave", "&#204;", "\u00CC", "latin capital letter I with grave, U+00CC"); // ISOlat1
		add("Iacute", "&#205;", "\u00CD", "latin capital letter I with acute, U+00CD"); // ISOlat1
		add("Icirc", "&#206;", "\u00CE", "latin capital letter I with circumflex, U+00CE"); // ISOlat1
		add("Iuml", "&#207;", "\u00CF", "latin capital letter I with diaeresis, U+00CF"); // ISOlat1
		add("ETH", "&#208;", "\u00D0", "latin capital letter ETH, U+00D0"); // ISOlat1
		add("Ntilde", "&#209;", "\u00D1", "latin capital letter N with tilde, U+00D1"); // ISOlat1
		add("Ograve", "&#210;", "\u00D2", "latin capital letter O with grave, U+00D2"); // ISOlat1
		add("Oacute", "&#211;", "\u00D3", "latin capital letter O with acute, U+00D3"); // ISOlat1
		add("Ocirc", "&#212;", "\u00D4", "latin capital letter O with circumflex, U+00D4"); // ISOlat1
		add("Otilde", "&#213;", "\u00D5", "latin capital letter O with tilde, U+00D5"); // ISOlat1
		add("Ouml", "&#214;", "\u00D6", "latin capital letter O with diaeresis, U+00D6"); // ISOlat1
		add("times", "&#215;", "\u00D7", "multiplication sign, U+00D7"); // ISOnum
		add("Oslash", "&#216;", "\u00D8", "latin capital letter O with stroke = latin capital letter O slash, U+00D8"); // ISOlat1
		add("Ugrave", "&#217;", "\u00D9", "latin capital letter U with grave, U+00D9"); // ISOlat1
		add("Uacute", "&#218;", "\u00DA", "latin capital letter U with acute, U+00DA"); // ISOlat1
		add("Ucirc", "&#219;", "\u00DB", "latin capital letter U with circumflex, U+00DB"); // ISOlat1
		add("Uuml", "&#220;", "\u00DC", "latin capital letter U with diaeresis, U+00DC"); // ISOlat1
		add("Yacute", "&#221;", "\u00DD", "latin capital letter Y with acute, U+00DD"); // ISOlat1
		add("THORN", "&#222;", "\u00DE", "latin capital letter THORN, U+00DE"); // ISOlat1
		add("szlig", "&#223;", "\u00DF", "latin small letter sharp s = ess-zed, U+00DF"); // ISOlat1
		add("agrave", "&#224;", "\u00E0", "latin small letter a with grave = latin small letter a grave, U+00E0"); // ISOlat1
		add("aacute", "&#225;", "\u00E1", "latin small letter a with acute, U+00E1"); // ISOlat1
		add("acirc", "&#226;", "\u00E2", "latin small letter a with circumflex, U+00E2"); // ISOlat1
		add("atilde", "&#227;", "\u00E3", "latin small letter a with tilde, U+00E3"); // ISOlat1
		add("auml", "&#228;", "\u00E4", "latin small letter a with diaeresis, U+00E4"); // ISOlat1
		add("aring", "&#229;", "\u00E5", "latin small letter a with ring above =latin small letter a ring, U+00E5"); // ISOlat1
		add("aelig", "&#230;", "\u00E6", "latin small letter ae = latin small ligature ae, U+00E6"); // ISOlat1
		add("ccedil", "&#231;", "\u00E7", "latin small letter c with cedilla, U+00E7"); // ISOlat1
		add("egrave", "&#232;", "\u00E8", "latin small letter e with grave, U+00E8"); // ISOlat1
		add("eacute", "&#233;", "\u00E9", "latin small letter e with acute, U+00E9"); // ISOlat1
		add("ecirc", "&#234;", "\u00EA", "latin small letter e with circumflex, U+00EA"); // ISOlat1
		add("euml", "&#235;", "\u00EB", "latin small letter e with diaeresis, U+00EB"); // ISOlat1
		add("igrave", "&#236;", "\u00EC", "latin small letter i with grave, U+00EC"); // ISOlat1
		add("iacute", "&#237;", "\u00ED", "latin small letter i with acute, U+00ED"); // ISOlat1
		add("icirc", "&#238;", "\u00EE", "latin small letter i with circumflex, U+00EE"); // ISOlat1
		add("iuml", "&#239;", "\u00EF", "latin small letter i with diaeresis, U+00EF"); // ISOlat1
		add("eth", "&#240;", "\u00F0", "latin small letter eth, U+00F0"); // ISOlat1
		add("ntilde", "&#241;", "\u00F1", "latin small letter n with tilde, U+00F1"); // ISOlat1
		add("ograve", "&#242;", "\u00F2", "latin small letter o with grave, U+00F2"); // ISOlat1
		add("oacute", "&#243;", "\u00F3", "latin small letter o with acute, U+00F3"); // ISOlat1
		add("ocirc", "&#244;", "\u00F4", "latin small letter o with circumflex, U+00F4"); // ISOlat1
		add("otilde", "&#245;", "\u00F5", "latin small letter o with tilde, U+00F5"); // ISOlat1
		add("ouml", "&#246;", "\u00F6", "latin small letter o with diaeresis, U+00F6"); // ISOlat1
		add("divide", "&#247;", "\u00F7", "division sign, U+00F7"); // ISOnum
		add("oslash", "&#248;", "\u00F8", "latin small letter o with stroke, = latin small letter o slash, U+00F8"); // ISOlat1
		add("ugrave", "&#249;", "\u00F9", "latin small letter u with grave, U+00F9"); // ISOlat1
		add("uacute", "&#250;", "\u00FA", "latin small letter u with acute, U+00FA"); // ISOlat1
		add("ucirc", "&#251;", "\u00FB", "latin small letter u with circumflex, U+00FB"); // ISOlat1
		add("uuml", "&#252;", "\u00FC", "latin small letter u with diaeresis, U+00FC"); // ISOlat1
		add("yacute", "&#253;", "\u00FD", "latin small letter y with acute, U+00FD"); // ISOlat1
		add("thorn", "&#254;", "\u00FE", "latin small letter thorn, U+00FE"); // ISOlat1
		add("yuml", "&#255;", "\u00FF", "latin small letter y with diaeresis, U+00FF"); // ISOlat1

		// <!-- Mathematical, Greek and Symbolic characters for HTML -->
		// <!-- Latin Extended-B -->
		add("fnof", "&#402;", "\u0192", "latin small f with hook = function = florin, U+0192"); // ISOtech

		// <!-- Greek -->
		add("Alpha", "&#913;", "\u0391", "greek capital letter alpha, U+0391");
		add("Beta", "&#914;", "\u0392", "greek capital letter beta, U+0392");
		add("Gamma", "&#915;", "\u0393", "greek capital letter gamma, U+0393"); // ISOgrk3
		add("Delta", "&#916;", "\u0394", "greek capital letter delta, U+0394"); // ISOgrk3
		add("Epsilon", "&#917;", "\u0395", "greek capital letter epsilon, U+0395");
		add("Zeta", "&#918;", "\u0396", "greek capital letter zeta, U+0396");
		add("Eta", "&#919;", "\u0397", "greek capital letter eta, U+0397");
		add("Theta", "&#920;", "\u0398", "greek capital letter theta, U+0398"); // ISOgrk3
		add("Iota", "&#921;", "\u0399", "greek capital letter iota, U+0399");
		add("Kappa", "&#922;", "\u039A", "greek capital letter kappa, U+039A");
		add("Lambda", "&#923;", "\u039B", "greek capital letter lambda, U+039B"); // ISOgrk3
		add("Mu", "&#924;", "\u039C", "greek capital letter mu, U+039C");
		add("Nu", "&#925;", "\u039D", "greek capital letter nu, U+039D");
		add("Xi", "&#926;", "\u039E", "greek capital letter xi, U+039E"); // ISOgrk3
		add("Omicron", "&#927;", "\u039F", "greek capital letter omicron, U+039F");
		add("Pi", "&#928;", "\u03A0", "greek capital letter pi, U+03A0"); // ISOgrk3
		add("Rho", "&#929;", "\u03A1", "greek capital letter rho, U+03A1");
		// <!-- there is no Sigmaf, and no U+03A2 character either -->
		add("Sigma", "&#931;", "\u03A3", "greek capital letter sigma, U+03A3"); // ISOgrk3
		add("Tau", "&#932;", "\u03A4", "greek capital letter tau, U+03A4");
		add("Upsilon", "&#933;", "\u03A5", "greek capital letter upsilon, U+03A5"); // ISOgrk3
		add("Phi", "&#934;", "\u03A6", "greek capital letter phi, U+03A6"); // ISOgrk3
		add("Chi", "&#935;", "\u03A7", "greek capital letter chi, U+03A7");
		add("Psi", "&#936;", "\u03A8", "greek capital letter psi, U+03A8"); // ISOgrk3
		add("Omega", "&#937;", "\u03A9", "greek capital letter omega, U+03A9"); // ISOgrk3

		add("alpha", "&#945;", "\u03B1", "greek small letter alpha, U+03B1"); // ISOgrk3
		add("beta", "&#946;", "\u03B2", "greek small letter beta, U+03B2"); // ISOgrk3
		add("gamma", "&#947;", "\u03B3", "greek small letter gamma, U+03B3"); // ISOgrk3
		add("delta", "&#948;", "\u03B4", "greek small letter delta, U+03B4"); // ISOgrk3
		add("epsilon", "&#949;", "\u03B5", "greek small letter epsilon, U+03B5"); // ISOgrk3
		add("zeta", "&#950;", "\u03B6", "greek small letter zeta, U+03B6"); // ISOgrk3
		add("eta", "&#951;", "\u03B7", "greek small letter eta, U+03B7"); // ISOgrk3
		add("theta", "&#952;", "\u03B8", "greek small letter theta, U+03B8"); // ISOgrk3
		add("iota", "&#953;", "\u03B9", "greek small letter iota, U+03B9"); // ISOgrk3
		add("kappa", "&#954;", "\u03BA", "greek small letter kappa, U+03BA"); // ISOgrk3
		add("lambda", "&#955;", "\u03BB", "/ greek small letter lambda, U+03BB"); // ISOgrk3
		add("mu", "&#956;", "\u03BC", "greek small letter mu, U+03BC"); // ISOgrk3
		add("nu", "&#957;", "\u03BD", "greek small letter nu, U+03BD"); // ISOgrk3
		add("xi", "&#958;", "\u03BE", "greek small letter xi, U+03BE"); // ISOgrk3
		add("omicron", "&#959;", "\u03BF", "greek small letter omicron, U+03BF"); // NEW
		add("pi", "&#960;", "\u03C0", "greek small letter pi, U+03C0"); // ISOgrk3
		add("rho", "&#961;", "\u03C1", "greek small letter rho, U+03C1"); // ISOgrk3
		add("sigmaf", "&#962;", "\u03C2", "greek small letter final sigma, U+03C2"); // ISOgrk3
		add("sigma", "&#963;", "\u03C3", "greek small letter sigma, U+03C3"); // ISOgrk3
		add("tau", "&#964;", "\u03C4", "greek small letter tau, U+03C4"); // ISOgrk3
		add("upsilon", "&#965;", "\u03C5", "greek small letter upsilon, U+03C5"); // ISOgrk3
		add("phi", "&#966;", "\u03C6", "greek small letter phi, U+03C6"); // ISOgrk3
		add("chi", "&#967;", "\u03C7", "greek small letter chi, U+03C7"); // ISOgrk3
		add("psi", "&#968;", "\u03C8", "greek small letter psi, U+03C8"); // ISOgrk3
		add("omega", "&#969;", "\u03C9", "greek small letter omega, U+03C9"); // ISOgrk3
		add("thetasym", "&#977;", "\u03D1", "greek small letter theta symbol, U+03D1"); // NEW
		add("upsih", "&#978;", "\u03D2", "greek upsilon with hook symbol, U+03D2"); // NEW
		add("piv", "&#982;", "\u03D6", "greek pi symbol, U+03D6"); // ISOgrk3

		// <!-- General Punctuation -->
		add("bull", "&#8226;", "\u2022", "bullet = black small circle, U+2022"); // ISOpub
		// <!-- bullet is NOT the same as bullet operator, U+2219 -->
		add("hellip", "&#8230;", "\u2026", "horizontal ellipsis = three dot leader, U+2026"); // ISOpub
		add("prime", "&#8242;", "\u2032", "prime = minutes = feet, U+2032"); // ISOtech
		add("Prime", "&#8243;", "\u2033", "double prime = seconds = inches, U+2033"); // ISOtech
		add("oline", "&#8254;", "\u203E", "overline = spacing overscore, U+203E"); // NEW
		add("frasl", "&#8260;", "\u2044", "fraction slash, U+2044"); // NEW

		// <!-- Letterlike Symbols -->
		add("weierp", "&#8472;", "\u2118", "script capital P = power set = Weierstrass p, U+2118"); // ISOamso
		add("image", "&#8465;", "\u2111", "blackletter capital I = imaginary part, U+2111"); // ISOamso
		add("real", "&#8476;", "\u211C", "blackletter capital R = real part symbol, U+211C"); // ISOamso
		add("trade", "&#8482;", "\u2122", "trade mark sign, U+2122"); // ISOnum
		add("alefsym", "&#8501;", "\u2135", "alef symbol = first transfinite cardinal, U+2135"); // NEW
		// <!-- alef symbol is NOT the same as hebrew letter alef,
		// U+05D0 although the same glyph could be used to depict both characters -->

		// <!-- Arrows -->
		add("larr", "&#8592;", "\u2190", "leftwards arrow, U+2190"); // ISOnum
		add("uarr", "&#8593;", "\u2191", "upwards arrow, U+2191"); // ISOnum
		add("rarr", "&#8594;", "\u2192", "rightwards arrow, U+2192"); // ISOnum
		add("darr", "&#8595;", "\u2193", "downwards arrow, U+2193"); // ISOnum
		add("harr", "&#8596;", "\u2194", "left right arrow, U+2194"); // ISOamsa
		add("crarr", "&#8629;", "\u21B5", "downwards arrow with corner leftwards = carriage return, U+21B5"); // NEW
		add("lArr", "&#8656;", "\u21D0", "leftwards double arrow, U+21D0"); // ISOtech
		//
		// <!-- ISO 10646 does not say that lArr is the same as the 'is implied by' arrow
		// but also does not have any other character for that function. So ? lArr can
		// be used for 'is implied by' as ISOtech suggests -->
		add("uArr", "&#8657;", "\u21D1", "upwards double arrow, U+21D1"); // ISOamsa
		add("rArr", "&#8658;", "\u21D2", "rightwards double arrow, U+21D2"); // ISOtech
		//
		// <!-- ISO 10646 does not say this is the 'implies' character but does not have
		// another character with this function so ?
		// rArr can be used for 'implies' as ISOtech suggests -->
		add("dArr", "&#8659;", "\u21D3", "downwards double arrow, U+21D3"); // ISOamsa
		add("hArr", "&#8660;", "\u21D4", "left right double arrow, U+21D4"); // ISOamsa

		// <!-- Mathematical Operators -->
		add("forall", "&#8704;", "\u2200", "for all, U+2200"); // ISOtech
		add("part", "&#8706;", "\u2202", "partial differential, U+2202"); // ISOtech
		add("exist", "&#8707;", "\u2203", "there exists, U+2203"); // ISOtech
		add("empty", "&#8709;", "\u2205", "empty set = null set = diameter, U+2205"); // ISOamso
		add("nabla", "&#8711;", "\u2207", "nabla = backward difference, U+2207"); // ISOtech
		add("isin", "&#8712;", "\u2208", "element of, U+2208"); // ISOtech
		add("notin", "&#8713;", "\u2209", "not an element of, U+2209"); // ISOtech
		add("ni", "&#8715;", "\u220B", "contains as member, U+220B"); // ISOtech
		// <!-- should there be a more memorable name than 'ni'? -->
		add("prod", "&#8719;", "\u220F", "n-ary product = product sign, U+220F"); // ISOamsb
		// <!-- prod is NOT the same character as U+03A0 'greek capital letter pi' though
		// the same glyph might be used for both -->
		add("sum", "&#8721;", "\u2211", "n-ary sumation, U+2211"); // ISOamsb
		// <!-- sum is NOT the same character as U+03A3 'greek capital letter sigma'
		// though the same glyph might be used for both -->
		add("minus", "&#8722;", "\u2212", "minus sign, U+2212"); // ISOtech
		add("lowast", "&#8727;", "\u2217", "asterisk operator, U+2217"); // ISOtech
		add("radic", "&#8730;", "\u221A", "square root = radical sign, U+221A"); // ISOtech
		add("prop", "&#8733;", "\u221D", "proportional to, U+221D"); // ISOtech
		add("infin", "&#8734;", "\u221E", "infinity, U+221E"); // ISOtech
		add("ang", "&#8736;", "\u2220", "angle, U+2220"); // ISOamso
		add("and", "&#8743;", "\u2227", "logical and = wedge, U+2227"); // ISOtech
		add("or", "&#8744;", "\u2228", "logical or = vee, U+2228"); // ISOtech
		add("cap", "&#8745;", "\u2229", "intersection = cap, U+2229"); // ISOtech
		add("cup", "&#8746;", "\u222A", "union = cup, U+222A"); // ISOtech
		add("int", "&#8747;", "\u222B", "integral, U+222B"); // ISOtech
		add("there4", "&#8756;", "\u2234", "therefore, U+2234"); // ISOtech
		add("sim", "&#8764;", "\u223C", "tilde operator = varies with = similar to, U+223C"); // ISOtech
		// <!-- tilde operator is NOT the same character as the tilde, U+007E,
		// although the same glyph might be used to represent both -->
		add("cong", "&#8773;", "\u2245", "approximately equal to, U+2245"); // ISOtech
		add("asymp", "&#8776;", "\u2248", "almost equal to = asymptotic to, U+2248"); // ISOamsr
		add("ne", "&#8800;", "\u2260", "not equal to, U+2260"); // ISOtech
		add("equiv", "&#8801;", "\u2261", "identical to, U+2261"); // ISOtech
		add("le", "&#8804;", "\u2264", "less-than or equal to, U+2264"); // ISOtech
		add("ge", "&#8805;", "\u2265", "greater-than or equal to, U+2265"); // ISOtech
		add("sub", "&#8834;", "\u2282", "subset of, U+2282"); // ISOtech
		add("sup", "&#8835;", "\u2283", "superset of, U+2283"); // ISOtech
		// <!-- note that nsup, 'not a superset of, U+2283' is not covered by the Symbol
		// font encoding and is not included. Should it be, for symmetry?
		// It is in ISOamsn -->
		add("nsub", "&#8836;", "\u2284", "not a subset of, U+2284"); // ISOamsn
		add("sube", "&#8838;", "\u2286", "subset of or equal to, U+2286"); // ISOtech
		add("supe", "&#8839;", "\u2287", "superset of or equal to, U+2287"); // ISOtech
		add("oplus", "&#8853;", "\u2295", "circled plus = direct sum, U+2295"); // ISOamsb
		add("otimes", "&#8855;", "\u2297", "circled times = vector product, U+2297"); // ISOamsb
		add("perp", "&#8869;", "\u22A5", "up tack = orthogonal to = perpendicular, U+22A5"); // ISOtech
		add("sdot", "&#8901;", "\u22C5", "dot operator, U+22C5"); // ISOamsb
		// <!-- dot operator is NOT the same character as U+00B7 middle dot -->

		// <!-- Miscellaneous Technical -->
		add("lceil", "&#8968;", "\u2308", "left ceiling = apl upstile, U+2308"); // ISOamsc
		add("rceil", "&#8969;", "\u2309", "right ceiling, U+2309"); // ISOamsc
		add("lfloor", "&#8970;", "\u230A", "left floor = apl downstile, U+230A"); // ISOamsc
		add("rfloor", "&#8971;", "\u230B", "right floor, U+230B"); // ISOamsc
		add("lang", "&#9001;", "\u2329", "left-pointing angle bracket = bra, U+2329"); // ISOtech
		// <!-- lang is NOT the same character as U+003C 'less than'
		// or U+2039 'single left-pointing angle quotation mark' -->
		add("rang", "&#9002;", "\u232A", "right-pointing angle bracket = ket, U+232A"); // ISOtech
		// <!-- rang is NOT the same character as U+003E 'greater than'
		// or U+203A 'single right-pointing angle quotation mark' -->

		// <!-- Geometric Shapes -->
		add("loz", "&#9674;", "\u25CA", "lozenge, U+25CA"); // ISOpub

		// <!-- Miscellaneous Symbols -->
		add("spades", "&#9824;", "\u2660", "black spade suit, U+2660"); // ISOpub
		// <!-- black here seems to mean filled as opposed to hollow
		add("clubs", "&#9827;", "\u2663", "black club suit = shamrock, U+2663"); // ISOpub
		add("hearts", "&#9829;", "\u2665", "black heart suit = valentine, U+2665"); // ISOpub
		add("diams", "&#9830;", "\u2666", "black diamond suit, U+2666"); // ISOpub
	}

	private static void add(String a, String b, String c, String d) {
		String[] va = new String[] {a, b, c};
		refMap.put(a, va);
		refMap.put(b, va);
		refMap.put(c, va);

		String[] ta = new String[] {c, d};
		tipMap.put(c, ta);
	}
}
