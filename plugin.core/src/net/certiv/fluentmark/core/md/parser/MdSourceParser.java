package net.certiv.fluentmark.core.md.parser;

import org.eclipse.core.resources.IMarker;

import net.certiv.dsl.core.DslCore;
import net.certiv.dsl.core.model.DslModelException;
import net.certiv.dsl.core.model.builder.DslModelMaker;
import net.certiv.dsl.core.parser.DslProblem;
import net.certiv.dsl.core.parser.DslSourceParser;
import net.certiv.dsl.core.util.Strings;
import net.certiv.fluentmark.core.FluentCore;
import net.certiv.fluentmark.core.model.Headers;
import net.certiv.fluentmark.core.model.IPageElement;
import net.certiv.fluentmark.core.model.Item;
import net.certiv.fluentmark.core.model.Lines;
import net.certiv.fluentmark.core.model.Page;
import net.certiv.fluentmark.core.model.PagePart;
import net.certiv.fluentmark.core.model.Lines.Line;

public class MdSourceParser extends DslSourceParser {

	private Page page;

	public MdSourceParser() {
		super();
	}

	@Override
	public DslCore getDslCore() {
		return FluentCore.getDefault();
	}

	public Page getModel() {
		return page;
	}

	/** Return the page part of the line at the given line index */
	public PagePart getPagePart(int idx) {
		return page.lines().getPagePart(idx);
	}

	@Override
	public void parse() {
		String content = record.doc.get();
		if (content.trim().isEmpty()) return;

		page = new Page(content, Strings.EOL);

		IPageElement current;
		int end;
		int offset;
		int len;

		for (int idx = 0; idx < page.lines().length(); idx++) {
			Item item = page.lines().identifyKind(idx);
			switch (item) {

				case HEADER:
					page.lines().setKind(idx, item);
					addPageHeader(page.lines().getLine(idx));
					break;

				case SETEXT:
					page.lines().setKind(idx, item);		// original
					page.lines().setKind(idx, Item.HEADER);	// effective
					addToParent(idx);
					break;

				case MATH_BLOCK:
					end = page.lines().nextMatching(idx, item);
					offset = page.lines().getOffset(idx);
					len = page.lines().getOffset(end) + page.lines().getTextLength(end) - offset;
					current = page.headers().getCurrentParent();
					addPageElement(current, item, offset, len, idx, end);
					idx = end;
					break;

				case MATH_BLOCK_INLINE:
					end = idx;
					offset = page.lines().getOffset(idx);
					len = page.lines().getTextLength(idx);
					current = page.headers().getCurrentParent();
					page.lines().setKind(idx, item);				// original
					addPageElement(current, Item.MATH_BLOCK, offset, len, idx, end);
					idx = end;
					break;

				case CODE_BLOCK:
					end = page.lines().nextMatching(idx, item);
					offset = page.lines().getOffset(idx);
					len = page.lines().getOffset(end) + page.lines().getTextLength(end) - offset;
					current = page.headers().getCurrentParent();
					addPageElement(current, item, offset, len, idx, end);
					idx = end;
					break;

				case CODE_BLOCK_INDENTED:
					end = idx;
					offset = page.lines().getOffset(idx);
					len = page.lines().getTextLength(idx);
					current = page.headers().getCurrentParent();
					page.lines().setKind(idx, item);

					if (idx > 0) {
						// check prior & conditionally change item and add to parent
						switch (page.lines().getKind(idx - 1)) {
							case CODE_BLOCK:
								page.lines().setKind(idx, Item.CODE_BLOCK);
								addToParent(idx);
								break;
							case TEXT:
								page.lines().setKind(idx, Item.TEXT);
								addToParent(idx);
								break;
							case LIST:
								page.lines().setKind(idx, Item.LIST);
								addToParent(idx);
								break;
							case TABLE:
								page.lines().setKind(idx, Item.TABLE);
								addToParent(idx);
								break;
							case DEFINITION:
								page.lines().setKind(idx, Item.DEFINITION);
								addToParent(idx);
								break;
							default:
								page.lines().setKind(idx, Item.CODE_BLOCK);
								addPageElement(current, Item.CODE_BLOCK, offset, len, idx, end);
								break;
						}
					}
					break;

				case HTML_BLOCK:
					end = page.lines().nextMatching(idx, Item.BLANK);
					end = page.lines().identifyKind(end) == Item.BLANK ? end - 1 : end;
					offset = page.lines().getOffset(idx);
					len = page.lines().getOffset(end) + page.lines().getTextLength(end) - offset;
					current = page.headers().getCurrentParent();
					addPageElement(current, item, offset, len, idx, end);
					idx = end;
					break;

				case COMMENT:
					end = page.lines().nextMatching(idx, item, "--->");
					offset = page.lines().getOffset(idx);
					len = page.lines().getOffset(end) + page.lines().getTextLength(end) - offset;
					current = page.headers().getCurrentParent();
					addPageElement(current, item, offset, len, idx, end);
					idx = end;
					break;

				case FRONT_MATTER:
					end = page.lines().nextMatching(idx, "---");
					offset = page.lines().getOffset(idx);
					len = page.lines().getOffset(end) + page.lines().getTextLength(end) - offset;
					current = page.headers().getCurrentParent();
					addPageElement(current, item, offset, len, idx, end);
					idx = end;
					break;

				case HRULE:
					end = idx;
					offset = page.lines().getOffset(idx);
					len = page.lines().getTextLength(idx);
					current = page.headers().getCurrentParent();
					addPageElement(current, item, offset, len, idx, end);
					break;

				case BLANK:
				case LIST:
				case QUOTE:
				case REFERENCE:
					end = idx;
					offset = page.lines().getOffset(idx);
					len = page.lines().getTextLength(idx);
					current = page.headers().getCurrentParent();
					page.lines().setKind(idx, item);

					// add to parent if prior is same item
					PagePart part;
					if (idx > 0 && page.lines().getKind(idx - 1) == item) {
						part = addToParent(idx);
					} else {
						part = addPageElement(current, item, offset, len, idx, end);
					}

					switch (item) {
						case BLANK:
							setPriorPartSeparator(part);
							break;
						case LIST:
							part.addListMarkedLine(idx);
						case QUOTE:
							int level = Lines.computeLevel(page.lines().getText(idx));
							part.setLevel(level);
							break;
						default:
							break;
					}

					break;

				case TEXT:
					end = idx;
					offset = page.lines().getOffset(idx);
					len = page.lines().getTextLength(idx);
					current = page.headers().getCurrentParent();
					page.lines().setKind(idx, item);

					if (idx > 0) {
						// check prior & conditionally change item and add to parent
						switch (page.lines().getKind(idx - 1)) {
							case TEXT:
								addToParent(idx);
								break;
							case LIST:
								page.lines().setKind(idx, Item.LIST);
								addToParent(idx);
								break;
							case TABLE:
								page.lines().setKind(idx, Item.TABLE);
								addToParent(idx);
								break;
							case DEFINITION:
								page.lines().setKind(idx, Item.DEFINITION);
								addToParent(idx);
								break;
							default:
								addPageElement(current, item, offset, len, idx, end);
								break;
						}
					}
					break;

				case TABLE:
					end = idx;
					offset = page.lines().getOffset(idx);
					len = page.lines().getTextLength(idx);
					current = page.headers().getCurrentParent();
					page.lines().setKind(idx, item);

					if (idx > 0 && page.lines().getKind(idx - 1) == Item.TEXT) {
						getPagePart(idx - 1).setKind(item);
						page.lines().setKind(idx - 1, item);
						addToParent(idx);
					} else {
						addPageElement(current, item, offset, len, idx, end);
					}
					break;

				case DEFINITION:
					end = idx;
					offset = page.lines().getOffset(idx);
					len = page.lines().getTextLength(idx);
					current = page.headers().getCurrentParent();
					page.lines().setKind(idx, item);
					if (idx > 0 && page.lines().getKind(idx - 1) == Item.TEXT) {
						current = page.headers().getCurrentParent();
						PagePart lastPart = (PagePart) current.getLastChild();
						lastPart.addLine(page.lines().getLine(idx));
						lastPart.setKind(item);
					} else {
						addPageElement(current, item, offset, len, idx, end);
					}
					break;

				default:
					break;
			}
		}
	}

	private PagePart addPageHeader(Line line) {
		int level = Headers.computeLevel(line.text);
		IPageElement parent = page.headers().getEnclosingParent(level);
		PagePart part = addPageElement(parent, line);
		part.setLevel(level);
		page.headers().putHeader(part, line);
		return part;
	}

	// single line element
	private PagePart addPageElement(IPageElement parent, Line line) {
		return addPageElement(parent, line.item, line.offset, line.length, line.idx, line.idx);
	}

	// multiline element
	private PagePart addPageElement(IPageElement parent, Item item, int offset, int length, int begLine, int endLine) {
		PagePart part = new PagePart(page, parent, item, offset, length, begLine, endLine);
		try {
			parent.addChild(part);
			page.parts().add(part);
			StringBuilder sb = new StringBuilder();
			for (int idx = begLine; idx <= endLine; idx++) {
				page.lines().setKind(idx, item);
				page.lines().setPagePart(idx, part);
				sb.append(page.lines().getText(idx) + page.delim());
			}
			part.set(parent.getResource(), sb.toString());
		} catch (DslModelException e) {
			String cause = "Error constructing multiline element";
			DslProblem problem = createProblem(IMarker.SEVERITY_ERROR, cause, item, begLine, 1, e);
			record.collector.accept(problem);
		}
		return part;
	}

	// add line to parent, returning the parent part
	private PagePart addToParent(int idx) {
		Line line = page.lines().getLine(idx);
		if (line == null) return null;

		IPageElement header = page.headers().getCurrentParent();
		IPageElement prior = header.getLastChild();
		if (prior instanceof PagePart) {
			PagePart parent = (PagePart) prior;
			parent.addLine(line);
			return parent;
		}
		return addPageElement(header, line);
	}

	// set the length of the blank line separator
	private void setPriorPartSeparator(PagePart blank) {
		if (page.parts().size() > 1) {
			PagePart prior = page.parts().get(page.parts().size() - 2);
			prior.setSeparator(blank);
		}
	}

	@Override
	public void build() {}

	@Override
	public void analyzeStructure(DslModelMaker maker) {}

	@Override
	public boolean modelContributor() {
		return true;
	}
}
