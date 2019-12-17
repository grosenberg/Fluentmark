package net.certiv.fluent.dt.core.builder;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.core.builder.DslBuilder;
import net.certiv.dsl.core.model.ICodeUnit;
import net.certiv.fluent.dt.core.FluentCore;

public class FluentBuilder extends DslBuilder {

	public static final String BUILDER_ID = "net.certiv.fluent.dt.core.builder";

	@Override
	public DslCore getDslCore() {
		return FluentCore.getDefault();
	}

	@Override
	protected String taskId() {
		return BUILDER_ID;
	}

	@Override
	protected IStatus buildUnits(List<ICodeUnit> srcModules, IProgressMonitor monitor, int ticks) throws CoreException {
		return Status.OK_STATUS;
	}
}
