package com.collection;
import java.util.*;
public class MyStack<E>{
	private LinkedList<E> link = new LinkedList<E>();
	public void push(E e){
		link.addFirst(e);
	}
	public E peek(){
		return link.getFirst();
	}
	public E pop(){
		return link.removeFirst();
	}
	public boolean isEmpty(){
		return link.isEmpty();
	}
	public String toString(){
		return link.toString();
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		MyStack<String> stack = new MyStack<String>();
		stack.push("adc");
		stack.push("dfdf");
		stack.push("dlfkjdflk");
		System.out.println(stack);
	}

}

