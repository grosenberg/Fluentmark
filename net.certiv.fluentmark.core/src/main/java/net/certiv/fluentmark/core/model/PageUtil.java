package net.certiv.fluentmark.core.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;

import net.certiv.dsl.core.model.IDslElement;
import net.certiv.dsl.core.model.IStatement;
import net.certiv.dsl.core.model.builder.IDslElementVisitor;
import net.certiv.fluentmark.core.md.parser.ModelData;
import net.certiv.fluentmark.core.md.parser.ModelType;

public class PageUtil {

	public static ModelType getModelType(IStatement stmt) {
		if (stmt.hasData()) {
			ModelData data = (ModelData) stmt.getData();
			return data.mType;
		}
		return ModelType.Unknown;
	}

	/** Returns all children of the given statement that are of the given model type. */
	public static List<IStatement> getChildren(IStatement stmt, ModelType mType) {
		List<IStatement> children = new ArrayList<>();
		try {
			stmt.decend(new IDslElementVisitor() {

				@Override
				public boolean visit(IDslElement child) throws CoreException {
					if (getModelType((IStatement) child) == mType) children.add((IStatement) child);
					return true;
				}
			});
		} catch (CoreException e) {}
		return children;
	}
}
