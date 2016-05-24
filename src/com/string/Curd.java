package com.string;

public class Curd {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		String str = "abcdefghijklmnopqrsjtuvwxyz";
		System.out.println(str.length());
		System.out.println(str.contains("s"));
		System.out.println(str.indexOf("j"));
		System.out.println(str.lastIndexOf("j"));
		
		
		System.out.println(str.toCharArray());
		System.out.println(str.getBytes());
		System.out.println(str.substring(0,2));
		char[] c = {'1','3','4'};
		System.out.println(new String(c));
		System.out.println(String.valueOf(c));
		
	}

}
