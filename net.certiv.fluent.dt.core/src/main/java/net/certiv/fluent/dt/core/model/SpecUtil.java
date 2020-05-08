package net.certiv.fluent.dt.core.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;

import net.certiv.dsl.core.model.ICodeUnit;
import net.certiv.dsl.core.model.IStatement;
import net.certiv.dsl.core.model.IStatementVisitor;
import net.certiv.fluent.dt.core.lang.md.model.Specialization;
import net.certiv.fluent.dt.core.lang.md.model.SpecializationType;

public class SpecUtil {

	public static final String DOT = "dot";
	public static final String PLAIN = "nohighlight";
	public static final String UML = "uml";

	/** Returns all statement children of the given specialized type. */
	public static List<IStatement> getChildren(IStatement stmt, SpecializationType specializationType) {
		List<IStatement> children = new ArrayList<>();
		ICodeUnit unit = stmt.getCodeUnit();
		unit.lock();
		try {
			stmt.decend(new IStatementVisitor() {

				@Override
				public boolean onEntry(IStatement child) throws CoreException {
					if (getSpecializedType(child) == specializationType) children.add(child);
					return true;
				}
			});
		} catch (CoreException e) {} finally {
			unit.unlock();
		}
		return children;
	}

	public static SpecializationType getSpecializedType(IStatement stmt) {
		if (!stmt.hasData()) return SpecializationType.Unknown;

		Specialization data = (Specialization) stmt.getData();
		return data.specializationType;
	}
}
