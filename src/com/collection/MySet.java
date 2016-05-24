package com.collection;

import java.util.*;

public class MySet {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		/*
		 * Set interface: HashSet class and TreeSet class.
		 * HashSet 底层数据结构为Hash Table.元素存取无序，不可重复，线程不同步。
		 * 存入自定义对象时，必须重写该对象的hashCode() and equals(obj)方法。
		 * 先判断hashCode() method and then equals() method.
		 * 若存入重复元素，则之前元素被覆盖。允许存入一个null。
		 * 
		 * TreeSet 底层数据结构为二叉树，元素存取无序，但在集合内有一定顺序
		 * 存入自定义对象时，集合会强制将其排序，因此要么让该对象具有可比较性，要么让集合构造时具备比较功能。
		 * 1.对象实现comparable接口，实现其compareTo(obj)方法。
		 * 2.自定义比较器，实现comparator接口,实现其compare（obj1，obj2）方法。将其对象传入集合构造器。
		 */
		Set set = new HashSet();
		Set treeset = new TreeSet(new ZcComparator());
		Set treeset1 = new TreeSet();
		
		User user1 = new User("abc", 22);
		User user2 = new User("abcd", 24);
		User user3 = new User("abcdr", 25);
		User user4 = new User("abc", 28);
		
		Student stu1 = new Student("ab", 33);
		Student stu2 = new Student("abc", 35);
		Student stu3 = new Student("abcd", 34);
		Student stu4 = new Student("ab", 34);
		
		set.add(user4);
		set.add(user3);
		set.add(user2);
		set.add(user1);
		
		treeset.add(user4);
		treeset.add(user3);
		treeset.add(user2);
		treeset.add(user1);
		
		treeset1.add(stu4);
		treeset1.add(stu3);
		treeset1.add(stu2);
		treeset1.add(stu1);
		
		Iterator it = set.iterator();
		while(it.hasNext()){
			User user = (User)it.next();
			System.out.println(user.name + "..." + user.age);
		}
		System.out.println("........................");
	
		Iterator tree = treeset.iterator();
		while(tree.hasNext()){
			User user = (User)tree.next();
			System.out.println(user.name + "..." + user.age);
		}
		System.out.println("........................");
				
		Iterator tree1 = treeset1.iterator();
		while(tree1.hasNext()){
			Student user = (Student)tree1.next();
			System.out.println(user.name + "..." + user.age);
		}
	}

}
class User{
	String name;
	int age;
	
	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public int hashCode() {
		// TODO 自动生成的方法存根
		return name.hashCode() + 31 * age;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO 自动生成的方法存根
		if(!(obj instanceof User))
			return false;
		User user = (User)obj;
		return this.name.equals(user.name) && this.age == user.age;
	}
	
}
class ZcComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		// TODO 自动生成的方法存根
		User user1 = (User)o1;
		User user2 = (User)o2;
		int num = user1.name.compareTo(user2.name);
		if(num == 0){
			return (new Integer(user1.age)).compareTo(new Integer(user2.age));
		}
		return num;
	}
}
class Student implements Comparable{
	String name;
	int age;
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public int compareTo(Object o) {
		// TODO 自动生成的方法存根
		Student stu = (Student)o;
		int num = this.name.compareTo(stu.name);
		if (num == 0){
			return (new Integer(this.age)).compareTo(new Integer(stu.age));
		}
		return num;
	}
	
}