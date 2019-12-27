package net.certiv.fluent.dt.core.model;

import org.antlr.v4.runtime.tree.ParseTree;

import net.certiv.dsl.core.model.IStatement.BaseType;
import net.certiv.dsl.core.model.builder.ISpecType;
import net.certiv.dsl.core.model.builder.IStmtData;

public class SpecData implements IStmtData {

	// overlay type
	public static final int GRAPH = 1 << 0;
	public static final int DIGRAPH = 1 << 1;

	public int decoration;

	public BaseType baseType;		// basic model type
	public SpecType specType;		// specialized model type

	public ParseTree stmtNode;		// statement context
	public String ruleName;			// matched grammar rule name
	public String name;				// display name

	public ParseTree value;			// statement value context

	// -----------------------------------------------------------

	public int hdrLevel;			// header level
	public int dents;				// statement leading indents
	public boolean begList;			// list item begins new (sub) list
	public boolean endList;			// list item resumes last (sub) list
	public SpecType listType;		// list item type

	/** Represents a simple statement; name contains the display text. */
	public SpecData(BaseType baseType, SpecType specType, String ruleName, ParseTree stmtNode, String name) {
		this(baseType, specType, ruleName, stmtNode, name, null);
	}

	/** Represents some key/value pair-like statement. */
	public SpecData(BaseType baseType, SpecType specType, String ruleName, ParseTree stmtNode, String name,
			ParseTree value) {
		this.baseType = baseType;
		this.specType = specType;
		this.ruleName = ruleName;
		this.stmtNode = stmtNode;
		this.name = name;
		this.value = value;
	}

	/** Sets the display icon decoration type. */
	public void setDecoration(int decoration) {
		this.decoration = decoration & 0x7F;
	}

	@Override
	public ISpecType getSpecType() {
		return specType;
	}

	@Override
	public void setSpecType(ISpecType specType) {
		this.specType = (SpecType) specType;
	}

	/** Header level. */
	public void setHeaderLevel(int level) {
		this.hdrLevel = level;
	}

	/** List type containing this list item. */
	public void setListType(SpecType type) {
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
	public String toString() {
		return String.format("ModelData [key=%s]", name);
	}
}
