package net.certiv.fluentmark.ui.preferences.blocks;

import net.certiv.fluentmark.core.preferences.Prefs;

public enum Cnv {
	PANDOC(1, "Pandoc", Prefs.KEY_PANDOC, "Pandoc converter", "Invalid Pandoc executable",
			"Full pathname of the Pandoc executable [pandoc|pandoc.exe]", "pandoc"),

	CMARK(2, "CMark-gfm", Prefs.KEY_CMARK, "CMark converter", "Invalid CMark executable",
			"Full pathname of the CMark executable [cmark|cmark.exe]", "cmark"),

	BLACKFRIDAY(3, "BlackFriday", Prefs.KEY_BLACKFRIDAY, "BlackFriday converter", "Invalid BlackFriday tool executable",
			"Full pathname of the BlackFriday tool executable [blackfriday-tool|blackfriday-tool.exe]",
			"blackfriday-tool"),

	TXTMARK(4, "TxtMark", Prefs.KEY_TXTMARK, "TxtMark converter", ""),

	EXTERNAL(5, "External", Prefs.KEY_EXTERNAL, "External converter", "Invalid executable",
			"Full pathname of the executable ", ""),

	DOT(6, "Dot Processor", Prefs.KEY_DOT, "Dot configuration", "Invalid Dot executable",
			"Full pathname of the Dot executable [dot|dot.exe]", "dot"),

	UML(7, "UML Processor", Prefs.KEY_UML, "UML configuration", ""),

	;

	private int _index;
	private String _title;
	private String _key;
	private String _desc;
	private String _errMsg;
	private String _label;
	private String _base;

	Cnv(int index, String title, String key, String desc, String errMsg) {
		this(index, title, key, desc, errMsg, null, null);
	}

	Cnv(int index, String title, String key, String desc, String errMsg, String label, String base) {
		_index = index;
		_title = title;
		_key = key;
		_desc = desc;
		_errMsg = errMsg;
		_label = label;
		_base = base;
	}

	public int idx() {
		return _index;
	}

	public String title() {
		return _title;
	}

	public String key() {
		return _key;
	}

	public String desc() {
		return _desc;
	}

	public String[] msg() {
		return new String[] { _errMsg, _label, _base };
	}

	public String errMsg() {
		return _errMsg;
	}

	public String label() {
		return _label;
	}

	public String base() {
		return _base;
	}
}
