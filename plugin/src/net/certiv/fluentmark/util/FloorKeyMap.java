/*******************************************************************************
 * Copyright (c) 2016 Certiv Analytics and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package net.certiv.fluentmark.util;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class FloorKeyMap {

	// key=offset, value=line number
	private LinkedHashMap<Integer, Integer> map;

	public FloorKeyMap() {
		this(16);
	}

	public FloorKeyMap(int size) {
		map = new LinkedHashMap<>(size);
	}

	/**
	 * Returns the value of the largest (closest to positive infinity) key, currently existing in
	 * the map, that is less than or equal to the given key.
	 */
	public Integer get(int key) {
		if (key < 0) return null;
		int idx = key;
		Integer value = map.get(idx);
		while (value == null && idx > 0) {
			idx--;
			value = map.get(idx);
		}
		return value;
	}

	/**
	 * Returns the largest (closest to positive infinity) key, currently existing in the map, that
	 * is less than or equal to the given key.
	 */
	public Integer find(int key) {
		if (key < 0) return null;
		int idx = key;
		Integer value = map.get(idx);
		while (value == null && idx > 0) {
			idx--;
			value = map.get(idx);
		}
		return idx;
	}

	public Integer put(Integer key, Integer value) {
		return map.put(key, value);
	}

	/** For when used just as a floor key set */
	public void add(int key) {
		map.put(key, 0);
	}

	public boolean isEmpty() {
		return map.isEmpty();
	}

	public int size() {
		return map.size();
	}

	public void clear() {
		map.clear();
	}

	public boolean containsKey(Object key) {
		return map.containsKey(key);
	}

	public boolean containsValue(Object value) {
		return map.containsValue(value);
	}

	public Set<Entry<Integer, Integer>> entrySet() {
		return map.entrySet();
	}

	public Set<Integer> keySet() {
		return map.keySet();
	}

	public Collection<Integer> values() {
		return map.values();
	}

	public String toString() {
		return map.toString();
	}

}
