package com.initialization;

public class InitTest {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		//InitTwo one = new InitTwo(1);
		//one.init1();
		new InitThree(1);//创建一个对象，首先初始化静态变量，一经初始化后，新建对象不再初始化。
		//InitThree.six.str = "no"；调用一个类的静态方法或者字段，初始化程序也会去初始化该类的静态字段。
	}

}
class InitOne{
	String str = "ok";
	InitOne(int maker){
		System.out.println("instance "+ maker + " of InitOne");
	}
}
class InitTwo{
	/*
	 *the order of Initialization: static members constructors methods. 
	 */
	String str = new String("first char");//step 1 如果没有初始化，系统自动初始化，默认值：null。
	InitOne one = new InitOne(1);// step 2. 
	InitTwo(int maker){
		System.out.println("i am here");//step 5
		InitOne two = new InitOne(2);//step 6
		System.out.println(str);//step 7
		System.out.println("instance "+ maker + " of InitTwo");//step 8
	}
	InitOne three = new InitOne(3);//step 3
	InitOne four = new InitOne(4);//step 4
	void init1(){
		String str = null;//step 9局部变量必须初始化。
		System.out.println(str);
	}
}
class InitThree{
	InitOne five = new InitOne(5);
	InitThree(int maker){
		System.out.println("instance "+ maker + " of InitThree");
	}
	static InitOne six = new InitOne(6);
	static InitOne seven = new InitOne(7);
	
	static void hello(){
		System.out.println("hello");
	}
}