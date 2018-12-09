/*******************************************************************************
 * Copyright (c) 2009, 2011 David Green and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     David Green - initial API and implementation
 *******************************************************************************/

package net.certiv.fluentmark.ui.editor.text.css;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author David Green
 * @since 3.0
 */
public class SparseCharSequence implements CharSequence {

	private final CharSequence data;

	private final Segment[] segments;

	private final int length;

	public SparseCharSequence(CharSequence data, Pattern excludePattern) {
		this.data = data;
		List<Segment> segments = new ArrayList<>(5);
		Segment segment = new Segment(0, 0);
		Matcher matcher = excludePattern.matcher(data);
		while (matcher.find()) {
			segment.length = matcher.start() - segment.offset;
			segments.add(segment);
			int end = matcher.end();
			if (end == data.length()) {
				segment = null;
				break;
			} else {
				segment = new Segment(end, segment.zeroBase + segment.length);
			}
		}
		if (segment != null) {
			segment.length = data.length() - segment.offset;
			segments.add(segment);
		}
		// remove 0-length segments
		if (segments.size() > 1) {
			Iterator<Segment> it = segments.iterator();
			while (it.hasNext() && segments.size() > 1) {
				segment = it.next();
				if (segment.length == 0) {
					it.remove();
				}
			}
		}
		this.segments = segments.toArray(new Segment[segments.size()]);
		Segment lastSegment = this.segments[this.segments.length - 1];
		length = lastSegment.zeroBase + lastSegment.length;
	}

	public int originalOffsetOf(int index) {
		if (index < 0 || index >= length()) {
			throw new IndexOutOfBoundsException(String.format("%s is not within [0,%s)", index, length())); //$NON-NLS-1$
		}
		Segment segment = segmentOf(index);
		return segment.offset + (index - segment.zeroBase);
	}

	@Override
	public char charAt(int index) {
		if (index < 0 || index >= length()) {
			throw new IndexOutOfBoundsException(String.format("%s is not within [0,%s)", index, length())); //$NON-NLS-1$
		}
		Segment segment = segmentOf(index);
		return data.charAt(segment.offset + (index - segment.zeroBase));
	}

	private Segment segmentOf(int index) {
		if (index == 0) {
			return segments[0];
		}
		Segment candidate = segments[0];
		for (int x = 1; x < segments.length; ++x) {
			if (segments[x].zeroBase > index) {
				break;
			}
			candidate = segments[x];
		}
		return candidate;
	}

	@Override
	public int length() {
		return length;
	}

	@Override
	public CharSequence subSequence(int start, int end) {
		if (start < 0 || start >= length || end > length) {
			throw new IndexOutOfBoundsException(
					String.format("[%s,%s) is not within range [0,%s)", start, end, length)); //$NON-NLS-1$
		}
		int rangeLength = end - start;
		if (rangeLength == 0) {
			return ""; //$NON-NLS-1$
		}
		int remainingLength = rangeLength;
		String sequence = null;
		for (Segment segment = segmentOf(start); remainingLength > 0; segment = segmentOf(end - remainingLength)) {
			int segmentOffset = start - segment.zeroBase;
			int segmentEnd = Math.min(end - segment.zeroBase, segment.length);
			CharSequence part = data.subSequence(segment.offset + segmentOffset, segment.offset + segmentEnd);
			if (sequence == null) {
				sequence = part.toString();
			} else {
				sequence += part;
			}
			remainingLength -= part.length();
			start += part.length();
		}
		return sequence;
	}

	private static class Segment {
		public Segment(int offset, int zeroBase) {
			this.offset = offset;
			this.zeroBase = zeroBase;
		}

		int offset, length;

		int zeroBase;
	}

	@Override
	public String toString() {
		return subSequence(0, length).toString();
	}
}
