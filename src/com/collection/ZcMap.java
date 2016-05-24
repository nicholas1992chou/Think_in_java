package com.collection;

import java.util.*;

public class ZcMap {
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		/*
		 * Map interface: HashTable, HashMap, TreeMap.
		 * HashTable:�ײ����ݽṹ���ǹ�ϣ���߳�ͬ������������null����nullֵ��
		 * HashMap:�ײ����ݽṹΪ��ϣ���̲߳�ͬ��������һ��null���Ͷ��nullֵ��
		 * TreeMap���ײ����ݽṹΪ���������̲߳�ͬ��������һ��null���Ͷ��nullֵ��
		 */
		Map hashtable = new Hashtable();
		Map hashmap = new HashMap();
		Map treemap = new TreeMap();

		for(String s : "my name is zc".split(" ")){
			treemap.put(s, s);
		}
		//����һ����map����ȡ������ֵ��
		Set<String> hashset = treemap.keySet();
		Iterator<String> it = hashset.iterator();
		while(it.hasNext()){
			String key = it.next();
			String value = (String)treemap.get(key);
			System.out.println(value);
		}
		//��������
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
