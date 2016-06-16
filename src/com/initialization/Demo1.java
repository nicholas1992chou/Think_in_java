package com.initialization;

public class Demo1 {
	/*
	 * 静态变量与静态块 在加载类的时候 首先初始化， 两者按先后顺序， 且只初始化一次。
	 * 接着是 成员变量 初始化 没有显示初始化 则jvm初始
	 * 然后执行 构造代码块
	 * 最后执行  构造函数
	 */
	public static int k=0;  //step1
	public static Demo1 t1=new Demo1("t1");  //step2 
	public static Demo1 t2=new Demo1("t2");  // step15
	public static int i=print("i");  //
	public static int n=99;  
	private int a=0;  //step3 t1.a=0; step14 t2.a=0;
	public int j=print("j");  //step 4  return 1, t1.j = 1; step15 repeat step2-step14;
	{  
		print("构造块");  //step9
	}  
	static   
	{  
		print("静态块");  
	}  
	 public Demo1(String str)  
	 {  
		 System.out.println((++k)+":"+str+"   i="+i+"    n="+n);  //step13 k = 3, i =2, n = 2;
		 ++i;++n; //step14 i = 3, n=3;
	 }  
	 public static int print(String str)  
	 {  
		 System.out.println((++k)+":"+str+"   i="+i+"    n="+n);  //step7 k=1, i=0, n=0; step10 k=2 i=1 n=1;
		 ++n;   //step8 n=1; step11 n=2;
	     return++i;   //step9 i=1;step12 i=2;
	 }  
	 public static void main(String args[])  
	 {  
		 Demo1 t=new Demo1("init");  
	 } 
}
