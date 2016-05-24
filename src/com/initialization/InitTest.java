package com.initialization;

public class InitTest {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		//InitTwo one = new InitTwo(1);
		//one.init1();
		new InitThree(1);//����һ���������ȳ�ʼ����̬������һ����ʼ�����½������ٳ�ʼ����
		//InitThree.six.str = "no"������һ����ľ�̬���������ֶΣ���ʼ������Ҳ��ȥ��ʼ������ľ�̬�ֶΡ�
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
	String str = new String("first char");//step 1 ���û�г�ʼ����ϵͳ�Զ���ʼ����Ĭ��ֵ��null��
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
		String str = null;//step 9�ֲ����������ʼ����
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