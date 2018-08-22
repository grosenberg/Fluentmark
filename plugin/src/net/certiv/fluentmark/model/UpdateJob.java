package net.certiv.fluentmark.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

public class UpdateJob extends Job {

	private static final long DELAY = 1000L;
	private final List<Task> queue = new ArrayList<>();

	public UpdateJob(String name) {
		super(name);
	}

	public void trigger(PageRoot root, IResource res, String text) {
		synchronized (queue) {
			queue.add(new Task(root, res, text));
			schedule(DELAY);
		}
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		Task task;
		synchronized (queue) {
			task = queue.get(queue.size() - 1);
			queue.clear();
		}

		task.root.updateModel(task.res, task.text);
		return Status.OK_STATUS;
	}

	private class Task {
		PageRoot root;
		IResource res;
		String text;

		Task(PageRoot root, IResource res, String text) {
			this.root = root;
			this.res = res;
			this.text = text;
		}
	}

}
