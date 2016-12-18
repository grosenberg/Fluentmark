package net.certiv.fluentmark.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.CoreException;

public abstract class Parent extends Element implements IParent {

	private IParent parent;
	private final List<IParent> children = new ArrayList<>();
	private boolean changed;

	public Parent(IParent parent, Kind kind, ISourceRange range) {
		super(kind, range);
		this.parent = parent;
	}

	public Parent() {
		super();
	}

	@Override
	public IParent getParent() {
		return parent;
	}

	/** Adds a child to the current element. */
	@Override
	public void addChild(IParent member) {
		children.add(member);
	}

	@Override
	public IParent getLastChild() {
		synchronized (children) {
			if (!children.isEmpty()) {
				return children.get(children.size() - 1);
			}
		}
		return null;
	}

	/** Removes a child to the current element. */
	public void removeChild(IParent member) throws CoreException {
		children.remove(member);
	}

	public void removeChildren() throws CoreException {
		children.clear();
	}

	/** Gets the children of this element. */
	@Override
	public IParent[] getChildren() throws CoreException {
		synchronized (children) {
			return children.toArray(new IParent[children.size()]);
		}
	}

	/** Gets the children of a certain type */
	@Override
	public List<IParent> getChildrenOfKind(Kind kind) throws CoreException {
		ArrayList<IParent> list = new ArrayList<>();
		for (IParent child : getChildren()) {
			if (child.getKind() == kind) {
				list.add(child);
			}
		}
		return list;
	}

	@Override
	public List<IParent> getChildList() throws CoreException {
		return new ArrayList<>(Arrays.asList(getChildren()));
	}

	@Override
	public boolean hasChildren() {
		synchronized (children) {
			return !children.isEmpty();
		}
	}

	protected void setChanged() {
		this.changed = true;
	}

	protected boolean hasChanged() {
		return changed;
	}

	@Override
	public void dispose() {
		for (IParent child : children) {
			child.dispose();
		}
		children.clear();
		super.dispose();
	}

	public void clear() {
		children.clear();
	}

	@Override
	public int hashCode() {
		return getContent().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (obj instanceof Parent) {
			return getContent().equals(((Parent) obj).getContent());
		}
		return false;
	}
}
