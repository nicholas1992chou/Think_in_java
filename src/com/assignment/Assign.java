package com.assignment;

public class Assign {

		public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		String str1 = "abc";//��ʱ�ڶ��ڴ��Ϸ���ռ������abc��������str�洢���Ƕ�����׵�ַ��
		String str2 = "abc";
		System.out.println("str1 == str2..." + (str1 == str2)); //output:  true.
		/*
		 * ==�ǱȽ����ã�reference����equals�ǱȽ�����ֵ��
		 * String��ʵ���˳����ؼ�����"abc"��������Ҳ�Ƕ��󡣵��ڴ�Ϊ�ó��������˿ռ���������û�ֱ������ʹ��
		 * ���str1��str2��ָ��һ����abc����
		 */
		String str3 = new String("abcd");
		String str4 = new String("abcd");
		System.out.println("str3 == str4..." + (str3 == str4));//output:    false
		System.out.println("str3.equals(str4)..." + str3.equals(str4));//output:    true
		/*
		 * ��String��ͨ���ؼ���new��������ʱ��ʵ�򴴽�����������һ���ǡ�abcd����new String();
		 * ��ʱstr3��str4�ֱ�ָ��������������Ȼ����������ֵ��ͬ�����׵�ַ�����ò�ͬ��
		 */
		String str5 = str4;//��str4��ֵ��str5����ʱ�ǽ����ô��ݸ���str5����str5��str4ͬʱָ��һ������
		/*
		 * �����ʱstr4ָ������һ�����󣬼�str4 = "ab".
		 * str5����ָ��֮ǰ�Ķ���"abcd"��
		 */
		int a = 333;
		int b = a;//��ʱ�ǽ�a��ֵ���ݸ���b����a�ı��ˣ�b����Ӱ�졣
		
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
		 * �����������ͳ���float��double�İ�װ�࣬������װ���String�඼ʵ���˳����ؼ�����
		 * ����ֵ��-128��127��һ���ֽڷ�Χ����ȣ�����ͬһ�����á�
		 * ��ͨ��new��������ʱ���Ͳ���ͬһ�����á�
		 */
		Assign assign = new Assign();
		User us = new User();
		us.name = "no";
		int num = 22;
		assign.change(us, num);
		System.out.println("us.name= "+ us.name + "...num = " + num);
		/*
		 * �������ݣ�����ǻ����������ͣ���ֵ������ı�ԭ���ݵ�ֵ��
		 * ����ǲ����Ƕ������Ǵ��ݲ��������ã����Ըı�ԭ����
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