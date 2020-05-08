package net.certiv.fluent.dt.core.lang.md.model;

import org.antlr.v4.runtime.tree.ParseTree;

import net.certiv.dsl.core.model.builder.ISpecializedType;
import net.certiv.dsl.core.model.builder.ModelSpecialization;

public class Specialization extends ModelSpecialization {

	// overlay type
	public static final int GRAPH = 1 << 0;
	public static final int DIGRAPH = 1 << 1;

	public SpecializationType specializationType;

	public int hdrLevel;			// header level
	public int dents;				// statement leading indents
	public boolean begList;			// list item begins new (sub) list
	public boolean endList;			// list item resumes last (sub) list
	public SpecializationType listType;		// list item type

	/** Represents a simple statement; name contains the display text. */
	public Specialization(SpecializationType specializationType, String ruleName, ParseTree stmtNode, String name) {
		this(specializationType, ruleName, stmtNode, name, null);
	}

	/** Represents some key/value pair-like statement. */
	public Specialization(SpecializationType specializationType, String ruleName, ParseTree stmtNode, String name,
			ParseTree value) {

		super(ruleName, stmtNode, name, value);
		this.specializationType = specializationType;
	}

	@Override
	public ISpecializedType getSpecializedType() {
		return specializationType;
	}

	@Override
	public void setSpecializedType(ISpecializedType specializedType) {
		this.specializationType = (SpecializationType) specializedType;
	}

	/** Header level. */
	public void setHeaderLevel(int level) {
		hdrLevel = level;
	}

	/** List type containing this list item. */
	public void setListType(SpecializationType type) {
		listType = type;
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
