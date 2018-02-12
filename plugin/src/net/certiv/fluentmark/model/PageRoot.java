/*******************************************************************************
 * Copyright (c) 2016 - 2017 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.jface.text.DocumentEvent;

import net.certiv.fluentmark.Log;
import net.certiv.fluentmark.convert.DotGen;
import net.certiv.fluentmark.editor.FluentMkEditor;
import net.certiv.fluentmark.editor.IDocumentChangedListener;
import net.certiv.fluentmark.model.Lines.Line;
import net.certiv.fluentmark.util.FloorKeyMap;

public class PageRoot extends Parent implements IResourceChangeListener, IDocumentChangedListener {

	private static final int events = IResourceChangeEvent.POST_CHANGE;

	/** Maximum length for a task tag message */
	private static final int MSG_MAXLEN = 60;

	public static PageRoot MODEL;

	/** Collection of listeners for Dsl element deltas */
	protected List<IElementChangedListener> elementChangedListeners = Collections
			.synchronizedList(new ArrayList<IElementChangedListener>());

	private FluentMkEditor editor;
	private List<PagePart> parts;	// all page parts
	private Headers headers;		// all header page parts
	private Lines lines;			// all lines
	private FloorKeyMap lineMap;

	public PageRoot(FluentMkEditor editor) {
		super(editor.getLineDelimiter());
		MODEL = this;
		this.editor = editor;
		init();
	}

	private void init() {
		ResourcesPlugin.getWorkspace().addResourceChangeListener(this, events);
		editor.addDocChangeListener(this);
		headers = new Headers(MODEL);
	}

	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		if (event.getSource() instanceof IWorkspace) {
			switch (event.getType()) {
				case IResourceChangeEvent.POST_CHANGE:
					try {
						if (event.getDelta() != null && editor.isActiveOn(event.getResource())) {
							editor.getPageModel();
						}
					} catch (Exception e) {
						Log.error("Failed handing post_change of resource", e);
					}
					break;
			}
		}
	}

	@Override
	public void documentChanged(DocumentEvent event) {
		updateModel(getResource(), event.getDocument().get());
	}

	protected void fire() {
		IElementChangedListener[] listeners;
		synchronized (elementChangedListeners) {
			listeners = new IElementChangedListener[elementChangedListeners.size()];
			elementChangedListeners.toArray(listeners);
		}
		int offset = editor.getCursorOffset();
		IElement part = partAtOffset(offset);
		final ElementChangedEvent event = new ElementChangedEvent(this, part, ElementChangedEvent.POST_CHANGE);
		for (IElementChangedListener listener : listeners) {
			SafeRunner.run(new ISafeRunnable() {

				@Override
				public void run() throws Exception {
					listener.elementChanged(event);
				}

				@Override
				public void handleException(Throwable exception) {
					Log.error("Exception during change notification", exception);
				}
			});
		}
	}

	public void addElementChangedListener(IElementChangedListener listener) {
		synchronized (elementChangedListeners) {
			if (!elementChangedListeners.contains(listener)) {
				elementChangedListeners.add(listener);
			}
		}
	}

	public void removeElementChangedListener(IElementChangedListener listener) {
		synchronized (elementChangedListeners) {
			int idx = elementChangedListeners.indexOf(listener);
			if (idx != -1) elementChangedListeners.remove(idx);
		}
	}

	/**
	 * Entry point for invoking model updates
	 * 
	 * @param text
	 * @param resource
	 */
	public void updateModel(IResource resource, String text) {
		long begTime = System.nanoTime();
		clearModel();
		set(resource, text);
		parse();
		long elapsed = System.nanoTime() - begTime;
		String value = BigDecimal.valueOf(elapsed, 6).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
		if (value.indexOf('.') > 2) {
			Log.info("Model updated (ms): " + value);
		}
		fire();
	}

	public ISourceRange regionAtOffset(int offset) {
		return partAtOffset(offset).getSourceRange();
	}

	/** Return the part of the given doc offset */
	public PagePart partAtOffset(int offset) {
		int idx = lineAtOffset(offset);
		return lines.getPagePart(idx);
	}

	/** Return the index of the line at the given doc offset */
	public int lineAtOffset(int offset) {
		if (lineMap == null) return 0;
		Integer idx = lineMap.get(offset);
		if (idx == null) return 0;
		return idx;
	}

	/** Return the offset of the given line index */
	public int getOffset(int idx) {
		return lines.getOffset(idx);
	}

	/** Return the text of the given line index */
	public String getText(int idx) {
		return lines.getText(idx);
	}

	/** Return the length of the text of the given line index */
	public int getTextLength(int idx) {
		return lines.getTextLength(idx);
	}

	/** Return the kind of the line at the given line index */
	public Type getKind(int idx) {
		return lines.getKind(idx);
	}

	/** Returns the page parts in the order created */
	public List<PagePart> getPageParts() {
		return new ArrayList<>(parts);
	}

	/** Returns the page parts of the given kind */
	public List<PagePart> getPageParts(Type kind) {
		List<PagePart> kindParts = new ArrayList<>();
		for (PagePart part : parts) {
			if (part.getKind() == kind) {
				kindParts.add(part);
			}
		}
		return kindParts;
	}

	/** Return the page part of the line at the given line index */
	public PagePart getPagePart(int idx) {
		return lines.getPagePart(idx);
	}

	/** Returns the part that follows the given part, or null */
	public PagePart getNext(PagePart part) {
		int idx = parts.indexOf(part);
		if (idx == -1) return null;
		if (idx < parts.size() - 2) return parts.get(idx + 1);
		return null;
	}

	public boolean isDotCodeBlock(int offset) {
		PagePart part = partAtOffset(offset);
		if (part.getMeta().startsWith(DotGen.DOT)) return true;
		return false;
	}

	public void dispose() {
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
		editor.removeDocChangeListener(this);
		if (headers != null) headers.dispose();
		if (lines != null) lines.dispose();
		if (lineMap != null) lineMap.clear();
		super.dispose();
	}

	private void clearModel() {
		if (parts != null) parts.clear();
		if (headers != null) headers.clear();
		if (lines != null) lines.clear();
		clear(); // children
	}

	private void parse() {
		parts = new ArrayList<>();
		lines = new Lines(getContent(), getLineDelim());
		lineMap = lines.getOffsetMap();
		int end;
		int offset;
		int len;
		IParent current;

		if (getContent().trim().isEmpty()) return;

		for (int idx = 0; idx < lines.length(); idx++) {
			Type kind = lines.identifyKind(idx);
			switch (kind) {

				case HEADER:
					lines.setKind(idx, kind);
					addPageHeader(lines.getLine(idx));
					break;

				case SETEXT:
					lines.setKind(idx, kind);			// original
					lines.setKind(idx, Type.HEADER);	// effective
					addToParent(idx);
					break;

				case MATH_BLOCK:
					end = lines.nextMatching(idx, kind);
					offset = lines.getOffset(idx);
					len = lines.getOffset(end) + lines.getTextLength(end) - offset;
					current = headers.getCurrentParent();
					addPageElement(current, kind, offset, len, idx, end);
					idx = end;
					break;

				case MATH_BLOCK_INLINE:
					end = idx;
					offset = lines.getOffset(idx);
					len = lines.getTextLength(idx);
					current = headers.getCurrentParent();
					lines.setKind(idx, kind);				// original
					addPageElement(current, Type.MATH_BLOCK, offset, len, idx, end);
					idx = end;
					break;

				case CODE_BLOCK:
					end = lines.nextMatching(idx, kind);
					offset = lines.getOffset(idx);
					len = lines.getOffset(end) + lines.getTextLength(end) - offset;
					current = headers.getCurrentParent();
					addPageElement(current, kind, offset, len, idx, end);
					idx = end;
					break;

				case CODE_BLOCK_INDENTED:
					end = idx;
					offset = lines.getOffset(idx);
					len = lines.getTextLength(idx);
					current = headers.getCurrentParent();
					lines.setKind(idx, kind);

					if (idx > 0) {
						// check prior & conditionally change kind and add to parent
						switch (lines.getKind(idx - 1)) {
							case CODE_BLOCK:
								lines.setKind(idx, Type.CODE_BLOCK);
								addToParent(idx);
								break;
							case TEXT:
								lines.setKind(idx, Type.TEXT);
								addToParent(idx);
								break;
							case LIST:
								lines.setKind(idx, Type.LIST);
								addToParent(idx);
								break;
							case TABLE:
								lines.setKind(idx, Type.TABLE);
								addToParent(idx);
								break;
							case DEFINITION:
								lines.setKind(idx, Type.DEFINITION);
								addToParent(idx);
								break;
							default:
								lines.setKind(idx, Type.CODE_BLOCK);
								addPageElement(current, Type.CODE_BLOCK, offset, len, idx, end);
								break;
						}
					}
					break;

				case HTML_BLOCK:
					end = lines.nextMatching(idx, Type.BLANK);
					end = lines.identifyKind(end) == Type.BLANK ? end - 1 : end;
					offset = lines.getOffset(idx);
					len = lines.getOffset(end) + lines.getTextLength(end) - offset;
					current = headers.getCurrentParent();
					addPageElement(current, kind, offset, len, idx, end);
					idx = end;
					break;

				case COMMENT:
					end = lines.nextMatching(idx, kind, "--->");
					offset = lines.getOffset(idx);
					len = lines.getOffset(end) + lines.getTextLength(end) - offset;
					current = headers.getCurrentParent();
					addPageElement(current, kind, offset, len, idx, end);
					idx = end;
					break;

				case FRONT_MATTER:
					end = lines.nextMatching(idx, "---");
					offset = lines.getOffset(idx);
					len = lines.getOffset(end) + lines.getTextLength(end) - offset;
					current = headers.getCurrentParent();
					addPageElement(current, kind, offset, len, idx, end);
					idx = end;
					break;

				case HRULE:
					end = idx;
					offset = lines.getOffset(idx);
					len = lines.getTextLength(idx);
					current = headers.getCurrentParent();
					addPageElement(current, kind, offset, len, idx, end);
					break;

				case BLANK:
				case LIST:
				case QUOTE:
				case REFERENCE:
					end = idx;
					offset = lines.getOffset(idx);
					len = lines.getTextLength(idx);
					current = headers.getCurrentParent();
					lines.setKind(idx, kind);

					// add to parent if prior is same kind
					PagePart part;
					if (idx > 0 && lines.getKind(idx - 1) == kind) {
						part = addToParent(idx);
					} else {
						part = addPageElement(current, kind, offset, len, idx, end);
					}

					switch (kind) {
						case BLANK:
							setPriorPartSeparator(part);
							break;
						case LIST:
							part.addListMarkedLine(idx);
						case QUOTE:
							int level = Lines.computeLevel(lines.getText(idx));
							part.setLevel(level);
							break;
						default:
							break;
					}

					break;

				case TEXT:
					end = idx;
					offset = lines.getOffset(idx);
					len = lines.getTextLength(idx);
					current = headers.getCurrentParent();
					lines.setKind(idx, kind);

					if (idx > 0) {
						// check prior & conditionally change kind and add to parent
						switch (lines.getKind(idx - 1)) {
							case TEXT:
								addToParent(idx);
								break;
							case LIST:
								lines.setKind(idx, Type.LIST);
								addToParent(idx);
								break;
							case TABLE:
								lines.setKind(idx, Type.TABLE);
								addToParent(idx);
								break;
							case DEFINITION:
								lines.setKind(idx, Type.DEFINITION);
								addToParent(idx);
								break;
							default:
								addPageElement(current, kind, offset, len, idx, end);
								break;
						}
					}
					break;

				case TABLE:
					end = idx;
					offset = lines.getOffset(idx);
					len = lines.getTextLength(idx);
					current = headers.getCurrentParent();
					lines.setKind(idx, kind);

					if (idx > 0 && lines.getKind(idx - 1) == Type.TEXT) {
						getPagePart(idx - 1).setKind(kind);
						lines.setKind(idx - 1, kind);
						addToParent(idx);
					} else {
						addPageElement(current, kind, offset, len, idx, end);
					}
					break;

				case DEFINITION:
					end = idx;
					offset = lines.getOffset(idx);
					len = lines.getTextLength(idx);
					current = headers.getCurrentParent();
					lines.setKind(idx, kind);
					if (idx > 0 && lines.getKind(idx - 1) == Type.TEXT) {
						current = headers.getCurrentParent();
						PagePart lastPart = (PagePart) current.getLastChild();
						lastPart.addLine(lines.getLine(idx));
						lastPart.setKind(kind);
					} else {
						addPageElement(current, kind, offset, len, idx, end);
					}
					break;

				default:
					break;
			}
		}
	}

	private PagePart addPageHeader(Line line) {
		int level = Headers.computeLevel(line.text);
		IParent parent = headers.getEnclosingParent(level);
		PagePart part = addPageElement(parent, line);
		part.setLevel(level);
		headers.putHeader(part, line);
		return part;
	}

	// single line element
	private PagePart addPageElement(IParent parent, Line line) {
		return addPageElement(parent, line.kind, line.offset, line.length, line.idx, line.idx);
	}

	// multiline element
	private PagePart addPageElement(IParent parent, Type kind, int offset, int length, int begLine, int endLine) {
		PagePart part = new PagePart(this, parent, kind, offset, length, begLine, endLine);
		parts.add(part);
		parent.addChild(part);
		StringBuilder sb = new StringBuilder();
		for (int idx = begLine; idx <= endLine; idx++) {
			lines.setKind(idx, kind);
			lines.setPagePart(idx, part);
			sb.append(lines.getText(idx) + getLineDelim());
		}
		part.set(parent.getResource(), sb.toString());
		return part;
	}

	// add line to parent, returning the parent part
	private PagePart addToParent(int idx) {
		IParent header = headers.getCurrentParent();
		PagePart parent = (PagePart) header.getLastChild();
		Line line = lines.getLine(idx);
		if (parent == null || line == null) {
			System.out.println("help");
		}
		parent.addLine(line);
		return parent;
	}

	// set the length of the blank line separator
	private void setPriorPartSeparator(PagePart blank) {
		if (parts.size() > 1) {
			PagePart prior = parts.get(parts.size() - 2);
			prior.setSeparator(blank);
		}
	}

	public void markTaggedLines(IFile markFile, List<String> tags, List<IMarker> markers) {
		for (int idx = 0; idx < lines.length(); idx++) {
			String text = lines.getText(idx);
			int tagOffset = findTag(tags, text);
			if (tagOffset == -1) continue;

			String msg = text.substring(tagOffset);
			msg = text.substring(0, Math.min(msg.length(), MSG_MAXLEN)).trim();
			removeExistingTag(markFile, idx, msg, text, markers);

			try {
				IMarker marker = markFile.createMarker(IMarker.TASK);
				marker.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_NORMAL);
				marker.setAttribute(IMarker.LINE_NUMBER, idx);
				marker.setAttribute(IMarker.MESSAGE, msg);
			} catch (CoreException e) {}
		}

		// Remove remaining old markers
		for (IMarker mark : markers) {
			try {
				mark.delete();
			} catch (Exception e) {}
		}
	}

	private int findTag(List<String> tags, String text) {
		for (String tag : tags) {
			if (text.contains(tag)) {
				return text.indexOf(tag);
			}
		}
		return -1;
	}

	private void removeExistingTag(IFile markFile, int idx, String msg, String text, List<IMarker> markers) {
		for (IMarker marker : markers) {
			try {
				if (idx != (Integer) marker.getAttribute(IMarker.LINE_NUMBER)) continue;
				if (msg.equals(((String) marker.getAttribute(IMarker.MESSAGE)).trim())) {
					markers.remove(marker);
					marker.delete();
				}
			} catch (Exception ex) {}
		}
		return;
	}
}
