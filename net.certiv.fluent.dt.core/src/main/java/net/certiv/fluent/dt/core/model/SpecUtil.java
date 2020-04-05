package net.certiv.fluent.dt.core.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;

import net.certiv.dsl.core.model.ICodeUnit;
import net.certiv.dsl.core.model.IStatement;
import net.certiv.dsl.core.model.IStatementVisitor;

public class SpecUtil {

	public static final String DOT = "dot";
	public static final String PLAIN = "nohighlight";
	public static final String UML = "uml";

	/** Returns all statement children of the given specialized type. */
	public static List<IStatement> getChildren(IStatement stmt, SpecializedType specializedType) {
		List<IStatement> children = new ArrayList<>();
		ICodeUnit unit = stmt.getCodeUnit();
		unit.lock();
		try {
			stmt.decend(new IStatementVisitor() {

				@Override
				public boolean onEntry(IStatement child) throws CoreException {
					if (getSpecializedType(child) == specializedType) children.add(child);
					return true;
				}
			});
		} catch (CoreException e) {} finally {
			unit.unlock();
		}
		return children;
	}

	public static SpecializedType getSpecializedType(IStatement stmt) {
		if (stmt.hasData()) {
			Specialization data = (Specialization) stmt.getData();
			return data.specializedType;
		}
		return SpecializedType.Unknown;
	}
}
