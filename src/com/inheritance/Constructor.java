package com.inheritance;

public class Constructor {
	final Derivedclass dc = new Derivedclass();
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Constructor ct = new Constructor();
		ct.dc.age = 5;
		//final���λ�����������ʱ�������޸����ʼֵ��final������������ʱ�����ܸ��������ñ�����ֵ�������ܸ���ָ��
		//�������޸�����ָ��Ķ��������ֵ��
		new Derivedclass();
		new Derivedclass(3);
	}

}
class Baseclass{
	private String name = "abc";//���಻��ʹ��
	final int ID = 3;//final������declare���ֶ�ʱ���Բ���ʼ��(blank final)����������ʹ��ǰ��ʼ���������ڹ��������ʼ����֮���ܱ��޸�
	Baseclass(){
		System.out.println("the constructor of base class with no args");
	}
	Baseclass(int num){
		System.out.println("arg="+num);
	}
	final void test(){
		//final������method���಻����д�������أ�btw,final����classʱ����class���ܱ��̳С�
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
		//super();derived class ��ÿ��constructor������ʽ����base class���޲�constructor��
		//���������ܱ��̳У��������û���޲ι��������������ȷ���ø�����в�����������
		//ͨ��super(num)���ø��๹����;ͨ��super.field,super.methods���ø���ĳ�Ա���߷�����
		System.out.println(num);
	}	
	void test(int num){
		
	}
}