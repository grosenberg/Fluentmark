package net.certiv.fluent.dt.core.model;

import org.antlr.v4.runtime.tree.ParseTree;

import net.certiv.dsl.core.model.IStatement.Form;
import net.certiv.dsl.core.model.IStatement.Realm;
import net.certiv.dsl.core.model.IStatement.Type;
import net.certiv.dsl.core.model.builder.IDescriptionData;

public class ModelData implements IDescriptionData {

	// overlay type
	public static final int GRAPH = 1 << 0;
	public static final int DIGRAPH = 1 << 1;

	public int decoration = 0;
	public Type type = Type.LITERAL;
	public Form form = Form.DECLARATION;
	public Realm realm = Realm.LOCAL;

	public ModelType mType;
	public ParseTree rootNode;
	public ParseTree name;
	public String key;
	public ParseTree value;

	/** Represents a simple statement; model type provides the display text. */
	public ModelData(ModelType mType, ParseTree rootNode) {
		this.mType = mType;
		this.rootNode = rootNode;
		this.key = mType.toString();
	}

	/** Represents a simple statement; key contains the display text. */
	public ModelData(ModelType mType, ParseTree rootNode, String key) {
		this.mType = mType;
		this.rootNode = rootNode;
		this.key = key;
	}

	/** Represents a key/value pair statement; e.g., an action or option. */
	public ModelData(ModelType mType, ParseTree rootNode, String key, ParseTree value) {
		this.mType = mType;
		this.rootNode = rootNode;
		this.key = key;
		this.value = value;
	}

	/** Sets the display icon decoration type. */
	public void setDecoration(int decoration) {
		this.decoration = decoration;
	}

	public void setAspects(Type type, Form form, Realm realm) {
		this.type = type;
		this.form = form;
		this.realm = realm;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public void setForm(Form form) {
		this.form = form;
	}

	public void setScope(Realm realm) {
		this.realm = realm;
	}

	@Override
	public String toString() {
		return String.format("ModelData [key=%s]", key);
	}
}
