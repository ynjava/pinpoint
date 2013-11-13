package com.nhn.pinpoint.web.util;

import java.util.TreeMap;

/**
 * 
 * @author netspider
 * 
 * @param <K>
 * @param <V>
 */
public class MergeableTreeMap<K, V extends Mergeable<K, V>> extends TreeMap<K, V> implements MergeableMap<K, V> {

	private static final long serialVersionUID = 8751127723531630287L;

	public V putOrMerge(K key, V value) {
		final V find = get(key);
		if (find == null) {
			put(key, value);
		} else {
            find.mergeWith(value);
		}
		return find;
	}
}
