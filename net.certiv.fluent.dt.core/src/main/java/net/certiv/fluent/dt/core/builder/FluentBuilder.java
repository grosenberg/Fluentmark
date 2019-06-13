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
	public String getBuilderID() {
		return BUILDER_ID;
	}

	@Override
	public IStatus buildSourceModules(IProgressMonitor monitor, int ticks, List<ICodeUnit> srcModules)
			throws CoreException {

		// Log.info(this, String.format("Building %s", srcModules));
		return Status.OK_STATUS;
	}
}
