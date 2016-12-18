package net.certiv.fluentmark.model;

import org.eclipse.core.resources.IResource;

import net.certiv.fluentmark.editor.ISourceReference;

public interface IElement extends ISourceReference {

	IResource getResource();

	Kind getKind();

	int getLevel();

	void dispose();
}
