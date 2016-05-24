package com.collection;

import java.util.*;

public class ZcMap {
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		/*
		 * Map interface: HashTable, HashMap, TreeMap.
		 * HashTable:底层数据结构，是哈希表。线程同步，不允许有null键和null值。
		 * HashMap:底层数据结构为哈希表。线程不同步，允许一个null键和多个null值。
		 * TreeMap：底层数据结构为二叉树。线程不同步。允许一个null键和多个null值。
		 */
		Map hashtable = new Hashtable();
		Map hashmap = new HashMap();
		Map treemap = new TreeMap();

		for(String s : "my name is zc".split(" ")){
			treemap.put(s, s);
		}
		//方法一：从map里面取出键和值。
		Set<String> hashset = treemap.keySet();
		Iterator<String> it = hashset.iterator();
		while(it.hasNext()){
			String key = it.next();
			String value = (String)treemap.get(key);
			System.out.println(value);
		}
		//方法二：
		Set<Map.Entry<String, String>> set = treemap.entrySet();
		Iterator<Map.Entry<String, String>> iter = set.iterator();
		while(iter.hasNext()){
			Map.Entry<String, String> entry = iter.next();
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(value);
		}
	}

}
