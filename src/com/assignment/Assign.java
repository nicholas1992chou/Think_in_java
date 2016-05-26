package com.assignment;

public class Assign {

		public static void main(String[] args) {
		// TODO 自动生成的方法存根
		String str1 = "abc";//此时在堆内存上分配空间给对象“abc”，引用str存储的是对象的首地址。
		String str2 = "abc";
		System.out.println("str1 == str2..." + (str1 == str2)); //output:  true.
		/*
		 * ==是比较引用（reference），equals是比较字面值。
		 * String类实现了常量池技术，"abc"即常量，也是对象。当内存为该常量开辟了空间后，其他引用会直接拿来使用
		 * 因此str1和str2都指向一个“abc”。
		 */
		String str3 = new String("abcd");
		String str4 = new String("abcd");
		System.out.println("str3 == str4..." + (str3 == str4));//output:    false
		System.out.println("str3.equals(str4)..." + str3.equals(str4));//output:    true
		/*
		 * 当String类通过关键字new创建对象时，实则创建了两个对象，一个是“abcd”和new String();
		 * 此时str3和str4分别指向了两个对象，虽然它俩的字面值相同，但首地址即引用不同。
		 */
		String str5 = str4;//将str4赋值给str5，这时是将引用传递给了str5，即str5和str4同时指向一个对象。
		/*
		 * 如果此时str4指向了另一个对象，即str4 = "ab".
		 * str5还是指向之前的对象"abcd"。
		 */
		int a = 333;
		int b = a;//此时是将a的值传递给了b，当a改变了，b不受影响。
		
		Integer c = 127;//-128---127
		Integer d = 127;
		System.out.println("c == d..."+ (c == d));//output: true
		
		Integer e = 128;
		Integer f = 128;
		System.out.println("e == f..."+ (e == f));//output: false
		
		Float aa = 1.0f;
		Float bb = 1.0f;
		System.out.println("aa == bb..." + (aa == bb));//output: false
		/*
		 * 基本数据类型除了float和double的包装类，其他包装类和String类都实现了常量池技术，
		 * 当赋值在-128至127即一个字节范围内相等，就是同一个引用。
		 * 当通过new创建对象时，就不是同一个引用。
		 */
		Assign assign = new Assign();
		User us = new User();
		us.name = "no";
		int num = 22;
		assign.change(us, num);
		System.out.println("us.name= "+ us.name + "...num = " + num);
		/*
		 * 函数传递，如果是基本数据类型，则传值，不会改变原数据的值，
		 * 如果是参数是对象，则是传递参数的引用，可以改变原数据
		 */
	}
	public void change(User user, int age){
		user.name = "ok";
		age = 4;
	}
}
class User{
	String name;
	int age;
}