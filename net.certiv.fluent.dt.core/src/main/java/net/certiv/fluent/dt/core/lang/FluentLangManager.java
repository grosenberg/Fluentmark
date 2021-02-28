package net.certiv.fluent.dt.core.lang;

import java.util.Arrays;
import java.util.List;

import net.certiv.common.util.Strings;
import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.core.lang.LanguageManager;
import net.certiv.dsl.core.lang.RootEntry;
import net.certiv.dsl.core.model.ICodeUnit;
import net.certiv.dsl.core.parser.DslSourceParser;
import net.certiv.fluent.dt.core.lang.dot.DotSourceParser;
import net.certiv.fluent.dt.core.lang.md.MdSourceParser;

public class FluentLangManager extends LanguageManager {

	public static final String DSL_NAME = "fluent";
	public static final List<String> EXTENSIONS = Arrays.asList("md", "dot", "mdown", "mkd");

	// unique parser language identifiers
	public static final String MD = "md";
	public static final String DOT = "dot";

	// source root paths - project relative
	private static final String SRC = Strings.SLASH;
	private static final String[] EXC = { "attic", "bin", "lib", "target" };

	public FluentLangManager(DslCore core) {
		super(core);
	}

	@Override
	public String getDslName() {
		return DSL_NAME;
	}

	@Override
	public String getDefaultLanguageId() {
		return MD;
	}

	@Override
	public List<String> getLanguageIds() {
		return Arrays.asList(MD, DOT);
	}

	@Override
	public DslSourceParser createSourceParser(ICodeUnit unit, String langId) {
		switch (langId) {
			case DOT:
				return new DotSourceParser(unit.getParseRecord(DOT));

			case MD:
				return new MdSourceParser(unit.getParseRecord(MD));

			default:
				return null;
		}
	}

	@Override
	public boolean persistProblemMarkers() {
		return false;
	}

	@Override
	public List<String> getDslFileExtensions() {
		return EXTENSIONS;
	}

	@Override
	public List<RootEntry> getLangSourceRoots() {
		return Arrays.asList(RootEntry.source(SRC).exclude(EXC));
	}

	@Override
	public boolean useNativeSourceRoots() {
		return false;
	}
}
