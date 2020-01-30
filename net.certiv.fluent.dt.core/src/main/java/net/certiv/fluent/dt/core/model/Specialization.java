package net.certiv.fluent.dt.core.model;

import org.antlr.v4.runtime.tree.ParseTree;

import net.certiv.dsl.core.model.ModelType;
import net.certiv.dsl.core.model.builder.ISpecializedType;
import net.certiv.dsl.core.model.builder.ISpecialization;

public class Specialization implements ISpecialization, Cloneable {

	// overlay type
	public static final int GRAPH = 1 << 0;
	public static final int DIGRAPH = 1 << 1;

	public int decoration;

	public ModelType modelType;		// basic model type
	public SpecializedType specializedType;		// specialized model type

	public ParseTree stmtNode;		// statement context
	public String ruleName;			// matched grammar rule name
	public String name;				// display name

	public ParseTree value;			// statement value context

	// -----------------------------------------------------------

	public int hdrLevel;			// header level
	public int dents;				// statement leading indents
	public boolean begList;			// list item begins new (sub) list
	public boolean endList;			// list item resumes last (sub) list
	public SpecializedType listType;		// list item type

	/** Represents a simple statement; name contains the display text. */
	public Specialization(ModelType modelType, SpecializedType specializedType, String ruleName, ParseTree stmtNode,
			String name) {
		this(modelType, specializedType, ruleName, stmtNode, name, null);
	}

	/** Represents some key/value pair-like statement. */
	public Specialization(ModelType modelType, SpecializedType specializedType, String ruleName, ParseTree stmtNode,
			String name, ParseTree value) {

		this.modelType = modelType;
		this.specializedType = specializedType;
		this.ruleName = ruleName;
		this.stmtNode = stmtNode;
		this.name = name;
		this.value = value;
	}

	@Override
	public ISpecializedType getSpecializedType() {
		return specializedType;
	}

	@Override
	public void setSpecializedType(ISpecializedType specializedType) {
		this.specializedType = (SpecializedType) specializedType;
	}

	/** Sets the display icon decoration type. */
	public void setDecoration(int decoration) {
		this.decoration = decoration & 0x7F;
	}

	/** Header level. */
	public void setHeaderLevel(int level) {
		this.hdrLevel = level;
	}

	/** List type containing this list item. */
	public void setListType(SpecializedType type) {
		this.listType = type;
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
			return (Specialization) this.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException("Shoud never occur", e);
		}
	}

	@Override
	public String toString() {
		return String.format("ModelData [key=%s]", name);
	}
}
