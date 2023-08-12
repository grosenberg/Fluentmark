package net.certiv.fluent.dt.core.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;

import net.certiv.dsl.core.model.ICodeUnit;
import net.certiv.dsl.core.model.IStatement;
import net.certiv.dsl.core.model.IStatementVisitor;
import net.certiv.dsl.core.model.ModelType;
import net.certiv.dsl.core.model.builder.ISpecSubType;
import net.certiv.dsl.core.model.builder.ISpecializedType;
import net.certiv.fluent.dt.core.lang.md.model.SpecializedType;

public class SpecUtil {

	public static final String DOT = "dot";
	public static final String PLAIN = "nohighlight";
	public static final String UML = "uml";

	/** Returns all statement children of the given specialized type. */
	public static List<IStatement> getChildren(IStatement stmt, SpecializedType type) {
		List<IStatement> children = new ArrayList<>();
		ICodeUnit unit = stmt.getCodeUnit();
		unit.lock();
		try {
			stmt.decend(new IStatementVisitor() {

				@Override
				public boolean onEntry(IStatement child) throws CoreException {
					if (getSpecializedType(child) == type) children.add(child);
					return true;
				}
			});
		} catch (CoreException e) {} finally {
			unit.unlock();
		}
		return children;
	}

	/**
	 * Returns the specialized type of the given statement, or
	 * {@link SpecializedType#Unknown} if the statement does not have specialization data.
	 *
	 * @param stmt a statement
	 * @return the specialized type
	 */
	public static SpecializedType getSpecializedType(IStatement stmt) {
		if (!stmt.hasData()) return SpecializedType.Unknown;
		return (SpecializedType) stmt.getSpecializedType();
	}

	/**
	 * Finds all unit statements of the given type and subtype. A {@code null} type and/or
	 * subtype is treated as a wildcard value.
	 *
	 * @param reference statement identifying the containing unit
	 * @param type      statement specialized type
	 * @param subtype   statement specilaized subtype
	 * @return the found statements
	 */
	public static List<IStatement> findStatements(IStatement reference, ISpecializedType type,
			ISpecSubType subtype) {

		ICodeUnit unit = reference.getCodeUnit();
		List<IStatement> stmts = unit.findStatements(ModelType.STATEMENT, null, type);
		if (subtype != null) {
			stmts = stmts.stream().filter(s -> s.getData().getSpecSubType().equals(subtype)).toList();
		}
		return stmts;
	}

	// /** Returns all unit related statements of the given specialized type. */
	// public static List<IStatement> findRelatedStatementsOfType(IStatement stmt,
	// ISpecializedType type) {
	// return findRelatedStatementsOfType(stmt, type, null);
	// }
	//
	// /** Returns all unit related statements of the given specialized type and subtype.
	// */
	// public static List<IStatement> findRelatedStatementsOfType(IStatement stmt,
	// ISpecializedType type,
	// ISpecSubType subtype) {
	//
	// List<IStatement> children = new LinkedList<>();
	// ICodeUnit unit = stmt.getCodeUnit();
	//
	// unit.findStatements(ModelType.STATEMENT, ModelType.VARIABLE);xxx
	//
	// unit.lock();
	// try {
	// unit.decend(new IElementVisitor() {
	//
	// @Override
	// public boolean onEntry(IDslElement element) throws CoreException {
	// // if (statementOfType(child, type, subtype)) children.add(child);
	// return IElementVisitor.super.onEntry(element);
	// }
	//
	// });
	// } catch (CoreException e) {
	// Log.error("Descent failed", e);
	// } finally {
	// unit.unlock();
	// }
	// return children;
	// }
	//
	// public static boolean statementOfType(IStatement stmt, ISpecializedType type) {
	// return statementOfType(stmt, type, null);
	// }
	//
	// public static boolean statementOfType(IStatement stmt, ISpecSubType subtype) {
	// return statementOfType(stmt, null, subtype);
	// }
	//
	// public static boolean statementOfType(IStatement stmt, ISpecializedType type,
	// ISpecSubType subtype) {
	// if (!stmt.hasData()) return false;
	//
	// if (stmt.getSpecializedType() == SpecializedType.Phrase) {
	// stmt = stmt.getParent();
	// }
	//
	// ISpecialization data = stmt.getData();
	//
	// int line = ((Statement) stmt).getStartLine();
	//
	// boolean m = (type == null || data.getSpecializedType() == type)
	// && (subtype == null || data.getSpecSubType() == subtype);
	//
	// Log.debug("Match[%s:%s] %s:%s %s:%s", line, m, type, subtype,
	// data.getSpecializedType(),
	// data.getSpecSubType());
	//
	// return (type == null || data.getSpecializedType() == type)
	// && (subtype == null || data.getSpecSubType() == subtype);
	// }
}
