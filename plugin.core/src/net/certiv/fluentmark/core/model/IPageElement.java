package net.certiv.fluentmark.core.model;

import net.certiv.dsl.core.model.IDslElement;

public interface IPageElement extends IDslElement {

	String DOT = "dot";
	String PLAIN = "nohighlight";
	String UML = "uml";

	int getLevel();

	String getContent();

	String getContent(boolean noTerm);

	IPageElement getLastChild();

	void dispose();

	void clear();

	Item getItem();

}
