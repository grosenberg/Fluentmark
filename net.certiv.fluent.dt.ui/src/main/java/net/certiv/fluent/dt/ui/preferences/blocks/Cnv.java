package net.certiv.fluent.dt.ui.preferences.blocks;

import java.util.HashMap;
import java.util.Map;

import net.certiv.fluent.dt.core.preferences.Prefs;

public enum Cnv {
	PANDOC(0, "Pandoc", Prefs.KEY_PANDOC, "Pandoc converter", "Invalid Pandoc executable",
			"Full pathname of the Pandoc executable [pandoc|pandoc.exe]", "pandoc"),

	FLEXMARK(1, "Flexmark", Prefs.KEY_FLEXMARK, "Flexmark converter", ""),

	BLACKFRIDAY(2, "BlackFriday", Prefs.KEY_BLACKFRIDAY, "BlackFriday converter", "Invalid BlackFriday tool executable",
			"Full pathname of the BlackFriday tool executable [blackfriday-tool|blackfriday-tool.exe]",
			"blackfriday-tool"),

	EXTERNAL(3, "External", Prefs.KEY_EXTERNAL, "External converter", "Invalid executable",
			"Full pathname of the executable ", ""),

	GRAPHS(4, "Graphs", Prefs.KEY_GRAPHS, "Dot configuration", "Invalid Dot executable",
			"Full pathname of the Dot executable [dot|dot.exe]", "dot"),

	;

	private static Map<String, Cnv> map;

	private int _index;
	private String _title;
	private String _key;
	private String _desc;
	private String _errMsg;
	private String _tip;
	private String _basename;

	Cnv(int index, String title, String key, String desc, String errMsg) {
		this(index, title, key, desc, errMsg, null, null);
	}

	Cnv(int index, String title, String key, String desc, String errMsg, String tip, String basename) {
		_index = index;
		_title = title;
		_key = key;
		_desc = desc;
		_errMsg = errMsg;
		_tip = tip;
		_basename = basename;
	}

	/** Find by {@code title} or {@code key}. */
	public static Cnv find(String value) {
		if (map == null) {
			map = new HashMap<>();
			for (Cnv cnv : Cnv.values()) {
				map.put(cnv._title, cnv);
				map.put(cnv._key, cnv);
			}
		}
		return map.get(value);
	}

	public int index() {
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
		return new String[] { _errMsg, _tip, _basename };
	}

	public String errMsg() {
		return _errMsg;
	}

	public String tooltip() {
		return _tip;
	}

	public String basename() {
		return _basename;
	}
}
