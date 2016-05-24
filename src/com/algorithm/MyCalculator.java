package com.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class MyCalculator {
	static Stack<Character> stack = new Stack<Character>();
	static List<String> list = new ArrayList<String>();
	
	public static void main(String[] args) {
		while(true){
		System.out.println("Enter your expression below:");
		String str = null;
		Scanner scan = new Scanner(System.in);
		str = scan.next();
		if(str.equals("exit"))
			break;
		System.out.println(cal(infixToSuffix(str)));
		}
		
	}
	private static List<String> infixToSuffix(String str){
		str+= "#";//�ӱ��ʽ������ʶ��
		//valid(str);
		stack.push('#');//���á�#�������ȼ���͡�ѹջ�ɱ���ջ�յĳ�����
		int i=0;
		while(i < str.length()){
			char ch= str.charAt(i);
			if('#' != ch){
				//����ǲ�����ֱ�Ӵ��뼯�ϡ�������Ϊһλ����һ���ַ�ʱ��
				if(Character.isDigit(ch)){
					String temp = "" + ch;
					StringBuffer sb = new StringBuffer(temp);
					while(i+1 < str.length()-1 && Character.isDigit(str.charAt(i+1))){//�������Ҳ��������������һ���Ҳ�Ϊ������ʶ��
						sb.append(str.charAt(i+1));
						i++;
					}
					list.add(sb.toString());
					
				}else if(ch != ')' && ch != ']'){
					//ȡ��ջ�������� �� ɨ��ĵ�ǰ�������Ƚ� ���ȼ���
					//��ջ��Ԫ�����ȼ��ߣ����ջ�����뼯��.������ǰ��������ջ��Ԫ�رȽ����ȼ�
					//ֱ����ǰ��������ջ��Ԫ�����ȼ��ߣ���ѹջ��
					while(stack.peek() !='(' && stack.peek() != '[' && (!priority(stack.peek(), ch))){//���ջ�����ȼ���
						list.add(String.valueOf(stack.pop()));
					}
					stack.push(ch);
					
				}else if(ch == ')' ){
					while(stack.peek() != '('){
						list.add(String.valueOf(stack.pop()));
					}
					stack.pop();
					
				}else if(ch == ']' ){
					while(stack.peek() != '['){
						list.add(String.valueOf(stack.pop()));
					}
					stack.pop();
				
				}
				
			}else{//���ɨ�赽������ʶ# ȫ����ջ
				do {
					list.add(String.valueOf(stack.pop()));
				} while (!stack.isEmpty());
			}
			i++;
		}
		return list;
	}
	private static boolean priority(char char1, char char2){//true ��ڶ������ȼ���
		if(char2 == '(' || char2 == '[' || char2 == '{')//����ڶ�����������( ��Ȼ���ȼ���ߣ�
			return true;
		if(char2 == '^' ){
			if(char1 != '(' && char1 != '[' && char1 != '{')
				return true;
		}
		if(char2 == '*' || char2 == '/'){//����ڶ���Ϊ�˳���ֻ�е�һ����
			if(char1 == '+' || char1 == '-' || char1 == '#')
				return true;
		}
		if((char2 == '+' || char2 == '-') && char1 == '#')
			return true;
		return false;
	}
	private static boolean isPerator(char c){
		switch(c){
		case '+':
		case '-':
		case '*':
		case '/':
		case '^':
		case '(':
		case ')':
		case '[':
		case ']':
		case '{':
		case '}':
			return true;
		default:
			return false;
		}
	}
	public static Integer cal(List<String> sufFix){
		Stack<Integer> stack = new Stack<Integer>();
		Integer left,right;
		for(String str:sufFix){
			switch (str) {
			case "+":
				right = stack.pop();
				left = stack.pop();
				stack.push(left + right);
				break;
			case "-":
				right = stack.pop();
				left = stack.pop();
				stack.push(left - right);
				break;
			case "*":
				right = stack.pop();
				left = stack.pop();
				stack.push(left * right);
				break;
			case "/":
				right = stack.pop();
				left = stack.pop();
				stack.push(left / right);
				break;
			case "^":
				right = stack.pop();
				left = stack.pop();
				stack.push((int)Math.pow(left, right));
				break;
			case "#":
				break;
			default:
				stack.push(Integer.parseInt(str));
				break;
			}
		}
		return stack.pop();
	}
	static void valid(String expression){
		Stack<Character> valid = new Stack<Character>();
		for(int i = 0; i<expression.length();i++){
			switch (expression.charAt(i)) {
			case '(':
			case '[':
			case '{':
				valid.push(expression.charAt(i));
				break;
			case ']':
				if(valid.isEmpty() || valid.pop() != '[')
					throw new RuntimeException();
				break;
			case ')':
				if(valid.isEmpty() || valid.pop() != '(')
					throw new RuntimeException();
				break;
			case '}':
				if(valid.isEmpty() ||valid.pop() != '{')
					throw new RuntimeException();
				break;
			default:
				
				break;
			}
		}
		if(!valid.isEmpty())
			throw new RuntimeException("invalid");
	}
}
