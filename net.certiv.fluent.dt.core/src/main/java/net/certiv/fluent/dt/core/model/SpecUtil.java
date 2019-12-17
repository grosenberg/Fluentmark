package net.certiv.fluent.dt.core.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;

import net.certiv.dsl.core.model.IDslElement;
import net.certiv.dsl.core.model.IStatement;
import net.certiv.dsl.core.model.builder.IDslElementVisitor;

public class SpecUtil {

	public static final String DOT = "dot";
	public static final String PLAIN = "nohighlight";
	public static final String UML = "uml";

	/** Returns all statement children of the given specialized type. */
	public static List<IStatement> getChildren(IStatement stmt, SpecType specType) {
		List<IStatement> children = new ArrayList<>();
		try {
			stmt.decend(new IDslElementVisitor() {

				@Override
				public boolean visit(IDslElement child) throws CoreException {
					if (getSpecType((IStatement) child) == specType) children.add((IStatement) child);
					return true;
				}
			});
		} catch (CoreException e) {}
		return children;
	}

	public static SpecType getSpecType(IStatement stmt) {
		if (stmt.hasData()) {
			SpecData data = (SpecData) stmt.getData();
			return data.specType;
		}
		return SpecType.Unknown;
	}
}
