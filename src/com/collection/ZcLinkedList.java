package com.collection;
public class ZcLinkedList<E> {
	private Entry<E> header;
	private int size;
	public ZcLinkedList(){
		header = new Entry<E>(null, null, null);
		header.previous = header; 
		header.next = header;
		size = 0;
	}
	public Object[] toArray(){
		Object[] result = new Object[size];
		Entry<E> entry = header.next;
		for(int i = 0; entry != header; entry = entry.next){
			result[i++] = entry.e;
		}
		return result;
	}
	public int add(E e){
		addBefore(e, header);
		return 1;
	}
	public int addFirst(E e){
		addBefore(e, header.next);
		return 1;
	}
	public E get(int index){
		return (E)this.toArray()[index];
	}
	public E removeFirst(E e){
		remove(header.next);
		return header.next.e;
	}
	public E remove(E e){
		remove(header.previous);
		return header.previous.e;
	}
	private static class Entry<E>{
		E e;
		Entry<E> next = null;
		Entry<E> previous = null;
		public Entry(E e, Entry<E> next, Entry<E> previous){
			this.e = e;
			this.next = next;
			this.previous = previous;
		}
	}
	private Entry<E> addBefore(E e, Entry<E> entry){
		Entry<E> zcentry = new Entry<E>(e, entry, entry.previous);
		zcentry.previous.next = zcentry;
		zcentry.next.previous = zcentry;
		size++;
		return zcentry;
	}
	private Entry<E> remove(Entry<E> entry){
		if(size == 0){
			return null;
		}
		entry.previous.next = entry.next;
		entry.next.previous = entry.previous;
		size--;
		return entry;
	}
	public static void main(String[] args) {
		ZcLinkedList<String> list = new ZcLinkedList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
	}
}
