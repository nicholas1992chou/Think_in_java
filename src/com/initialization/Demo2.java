package com.initialization;

public class Demo2 {

	private static Demo2 obj = new Demo2();//step1

	public static int counter1;//step4 counter1=1;

	public static int counter2 = 0;//step5 counter2 =0;

	private Demo2() {

		counter1++;//step2 counter1=1

		counter2++;//step3 counter2=1

	}

	public static Demo2 getInstance() {

		return obj;

	}

	public static void main(String[] args) {

		Demo2 obj = Demo2.getInstance();

		System.out.println("obj.counter1==" + obj.counter1);

		System.out.println("obj.counter2==" + obj.counter2);

	}
}
