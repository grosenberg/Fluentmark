package net.certiv.fluent.dt.core.lang.md.model;

import org.antlr.v4.runtime.tree.ParseTree;

import net.certiv.dsl.core.model.builder.ISpecSubType;
import net.certiv.dsl.core.model.builder.ISpecializedType;
import net.certiv.dsl.core.model.builder.ModelSpecialization;

public class Specialization extends ModelSpecialization {

	// overlay type
	public static final int GRAPH = 1 << 0;
	public static final int DIGRAPH = 1 << 1;

	private SpecializedType type;	// item type
	private SpecSubType subtype;		// sub type

	public int hdrLevel;			// header level
	public int dents;				// statement leading indents
	public boolean begList;			// list item begins new (sub) list
	public boolean endList;			// list item resumes last (sub) list

	/** Represents a simple statement; name contains the display text. */
	public Specialization(SpecializedType type, String ruleName, ParseTree stmtNode, String name) {
		this(type, ruleName, stmtNode, name, null);
	}

	/** Represents some key/value pair-like statement. */
	public Specialization(SpecializedType type, String ruleName, ParseTree stmtNode, String name,
			ParseTree value) {

		super(ruleName, stmtNode, name, value);
		this.type = type;
	}

	@Override
	public SpecializedType getSpecializedType() {
		return type;
	}

	@Override
	public void setSpecializedType(ISpecializedType type) {
		this.type = (SpecializedType) type;
	}

	@Override
	public SpecSubType getSpecSubType() {
		return subtype;
	}

	@Override
	public void setSpecSubType(ISpecSubType subtype) {
		this.subtype = (SpecSubType) subtype;
	}

	/** Header level. */
	public void setHeaderLevel(int level) {
		hdrLevel = level;
	}

	/** Indent level. */
	public void setDents(int dents) {
		this.dents = dents;
	}

	public void begList() {
		begList = true;
	}

	public void endList() {
		endList = true;
	}

	@Override
	public Specialization copy() {
		try {
			return (Specialization) clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException("Shoud never occur", e);
		}
	}
}
