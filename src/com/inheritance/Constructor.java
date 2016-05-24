package com.inheritance;

public class Constructor {
	final Derivedclass dc = new Derivedclass();
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Constructor ct = new Constructor();
		ct.dc.age = 5;
		//final修饰基本数据类型时，不能修改其初始值，final修饰引用类型时，不能更改其引用变量的值，即不能更改指向。
		//但可以修改引用指向的对象的属性值。
		new Derivedclass();
		new Derivedclass(3);
	}

}
class Baseclass{
	private String name = "abc";//子类不能使用
	final int ID = 3;//final声明（declare）字段时可以不初始化(blank final)，但必须在使用前初始化，例如在构造器里初始化，之后不能被修改
	Baseclass(){
		System.out.println("the constructor of base class with no args");
	}
	Baseclass(int num){
		System.out.println("arg="+num);
	}
	final void test(){
		//final声明的method子类不能重写，能重载，btw,final声明class时，该class不能被继承。
	}
}
class Derivedclass extends Baseclass{
	String user;
	int age;
	Derivedclass(){
		//super();
		System.out.println("the constructor of derived class with no args");
	}
	Derivedclass(int num){
		//super();derived class 的每个constructor都会隐式调用base class的无参constructor；
		//构造器不能被继承，如果父类没有无参构造器，则必须明确调用父类的有参数构造器。
		//通过super(num)调用父类构造器;通过super.field,super.methods调用父类的成员或者方法。
		System.out.println(num);
	}	
	void test(int num){
		
	}
}