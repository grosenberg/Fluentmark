package net.certiv.fluentmark.util.legacy;

import java.util.regex.Matcher;

public interface IReplace {

	public abstract void appendReplacementTo(StringBuilder stringbuilder, Matcher matcher);
}
