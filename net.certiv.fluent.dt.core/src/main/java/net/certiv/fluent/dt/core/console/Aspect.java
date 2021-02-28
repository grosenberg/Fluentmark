package net.certiv.fluent.dt.core.console;

import net.certiv.common.util.Strings;
import net.certiv.dsl.core.console.CS;
import net.certiv.dsl.core.console.IAspect;

public enum Aspect implements IAspect {

	GENERAL("General"),

	NO_METHOD("No such method"),
	NO_ACCESS("No access"),
	NO_ARG("Illegal argument(s)"),
	INSTANCE("Instantiation"),

	SECURITY("Security access"),
	INVOKE("Invocation target"),

	BUILDER("Builder"),
	LEXER("Lexer"),
	FACTORY("Token factory"),
	STRATEGY("Error strategy"),
	PARSER("Parser"),
	TREE("Tree"),

	;

	private String _desc;
	private String _infoColor;
	private String _errsColor;
	private int _infoFontStyle;
	private int _errsFontStyle;
	private String _encoding;

	Aspect(String desc) {
		this(desc, null, null, 0, 0, Strings.UTF_8);
	}

	Aspect(String desc, String info, String errs, int infoStyle, int errsStyle, String encoding) {
		_desc = desc;

		_infoColor = info != null ? info : IAspect.super.info();
		_errsColor = errs != null ? errs : IAspect.super.error();
		_infoFontStyle = infoStyle;
		_errsFontStyle = errsStyle;
		_encoding = encoding;
	}

	@Override
	public String info() {
		return _infoColor;
	}

	@Override
	public String error() {
		return _errsColor;
	}

	@Override
	public String getDesc() {
		return _desc;
	}

	@Override
	public int getFontStyle(CS kind) {
		return CS.ERROR == kind ? _errsFontStyle : _infoFontStyle;
	}

	@Override
	public String getEncoding() {
		return _encoding;
	}

	@Override
	public String toString() {
		return _desc;
	}
}
