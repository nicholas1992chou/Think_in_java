package com.initialization;

public class InitializationDemo {

	int a;
	char b;
	short s;
	float f;
	long lo;
	double dou;
	byte e;
	boolean flag;
	Object obj; // default initialization step 2................

	public InitializationDemo() {// step 4.............
		System.out.println("initializationDemo ............");
	}

	Bb b1 = new Bb();// step 3.............
	static Aa a1 = new Aa();// static initialization step 1...........

	public void print() {
		System.out.println("int a=" + a + " char b=" + b + " short s=" + s + " float f=" + f + "  long lo=" + lo
				+ "  double dou=" + dou + " byte e=" + e + "boolean flag=" + flag + " Object obj=" + obj);
	}

	public static void main(String[] args) {

		InitializationDemo init = new InitializationDemo();
		init.print();

	}
}

class Aa {
	int i = 1;

	public Aa() {
		System.out.println("Aa initialization.....");
	}
}

class Bb {
	int i = 2;

	public Bb() {
		System.out.println("Bb initialization.....");
	}
}
