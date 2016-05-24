package com.algorithm;

import java.util.ArrayList;
import java.util.List;

/*
 * ÅÅÁÐ×éºÏ
 */
public class Arrange {

	public static void main(String[] args) {
		sort("", "adcb");
	}
	static void sort(String prefix, String src){
		if(src.length() == 1){
			System.out.print(prefix + src+' ');
		}
		for(int i = 0; i<src.length(); i++){
			sort(prefix + src.charAt(i), src.substring(0, i)+src.substring(i+1));
		}
	}
}
