package com.initialization;

public class Demo1 {
	/*
	 * ��̬�����뾲̬�� �ڼ������ʱ�� ���ȳ�ʼ���� ���߰��Ⱥ�˳�� ��ֻ��ʼ��һ�Ρ�
	 * ������ ��Ա���� ��ʼ�� û����ʾ��ʼ�� ��Ĭ�ϳ�ʼ
	 * Ȼ�� �ǹ��캯�� ��ʼ��
	 * ������
	 */
	public static int k=0;  //step1
	public static Demo1 t1=new Demo1("t1");  //step2 
	public static Demo1 t2=new Demo1("t2");  // step15
	public static int i=print("i");  //
	public static int n=99;  
	private int a=0;  //step3 t1.a=0; step14 t2.a=0;
	public int j=print("j");  //step 4  return 1, t1.j = 1; step15 repeat step2-step14;
	{  
		print("�����");  //step9
	}  
	static   
	{  
		print("��̬��");  
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
